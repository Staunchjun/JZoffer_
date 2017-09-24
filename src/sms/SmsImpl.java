package sms;

import com.bcloud.msg.http.HttpSender;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsImpl implements SendMsg {
    private static final String URL = "http://121.40.16.43/msg/main.do"; // 应 地址
    private static final String ACCOUNT = "SendSMS_zydbcs"; // 账号
    private static final String PRODUCT = "247407973"; // 产品ID
    private static final String PWD = "zydbcs@2017"; // 密码
    private static final String EXTNO = "011"; // 扩展码
    private static Map<String, String> errors_map = new HashMap<>();//错误码表
    private static final String  SMS_UNSEND= "0";//0- 未发送
    private static final String  SMS_SEND_SUCCESS= "1";//1-已发送
    private static final String  SMS_SEND_FAIL= "2";//2-发送失败
    private static final String  MODEL_ENABLE= "1";//1-模版正常
    private static final String  MODEL_DISABLE= "2";//2-模板停用
    public SmsImpl() {
    }

    @Override
    public int SendMsg(String mobile, String customer_name, int sms_template_id, Map<String, String> info, String apply_id, String case_id, String func_name, String send_user) {
        int code_status = 1;//发送成功
        initErrorMap();
        try {
            SmsService smsService = new SmsService();
            Map<String, String> smsMoodel = smsService.QuerySmsModel(sms_template_id);
            String content = smsMoodel.get("content");
            String model_status = smsMoodel.get("status");
            String send_time = String.valueOf(System.currentTimeMillis());

            if (model_status.equals(MODEL_DISABLE)) {
                code_status = 2;//模板错误
                return code_status;
            } else {

                for (Map.Entry<String, String> e : info.entrySet()) {
                    content.replace(e.getKey(), e.getValue());
                }
                boolean isVaild = checkPhoneNumber(mobile);
                if (!isVaild) {
                    code_status = 3;//非法手机号码
                    return code_status;
                } else {
                    String res = HttpSender.send(URL, ACCOUNT, PWD, mobile, content, true, PRODUCT, EXTNO);
                    String[] ress = PraseRes(res);
                    String res_time = ress[0];
                    String resStatus = ress[1];
                    String msgId = ress[2];
                    int repeat_time = 0;
                    String smsStatus = SMS_SEND_SUCCESS;
                    String given_repeat_time = smsMoodel.get("repeat_time");
                    String resp_msg = "";
                    String template_id = sms_template_id + "";

                    while (msgId == "") {
                        if (repeat_time <= Integer.parseInt(given_repeat_time)) {
                            res = HttpSender.send(URL, ACCOUNT, PWD, mobile, content, true, PRODUCT, EXTNO);
                            ress = PraseRes(res);
                            res_time = ress[0];
                            resStatus = ress[1];
                            msgId = ress[2];
                            repeat_time++;
                        } else {
                            code_status = 0;
                            smsStatus = SMS_UNSEND;
                            resp_msg = "重发次数过多";
                        }
                    }
                    if (msgId != "" && Integer.parseInt(resStatus) != 0) {
                        smsStatus = SMS_SEND_FAIL;
                        code_status = Integer.parseInt(resStatus);
                        resp_msg = errors_map.get(resStatus);
                    }
                        String repeat_time_string = repeat_time + "";
                        RecordSms(template_id, mobile, customer_name, content, smsStatus, repeat_time_string, resStatus,
                                resp_msg, msgId, apply_id, case_id, func_name, send_user,res_time,send_time);
                        return code_status;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        code_status = 2;
        return code_status;
    }

    private void initErrorMap() {
        errors_map.put("101", "无此用户");
        errors_map.put("102", "密码错");
        errors_map.put("103", "提交过快");
        errors_map.put("104", "系统忙");
        errors_map.put("105", "敏感短信");
        errors_map.put("106", "消息长度错误");
        errors_map.put("107", "包含错误的手机号码");
        errors_map.put("108", "手机号码个数错误");
        errors_map.put("109", "无发送额度");
        errors_map.put("110", "不在发送时间内");
        errors_map.put("111", "超出该账户当月发送额度限制");
        errors_map.put("112", "无此产品，用户没有订购该产品");
        errors_map.put("113", "EXTNO格式错误");
        errors_map.put("115", "自动审核驳回");
        errors_map.put("116", "签名不合法");
        errors_map.put("117", "IP地址认证出错");
        errors_map.put("118", "用户没有相应的发送权限");
        errors_map.put("119", "用户已过期");
        errors_map.put("120", "内容不在白名单模板中");
        errors_map.put("121", "相同内容短信超限");
    }

    public void RecordSms(String temp_id, String mobile, String name, String content, String status, String repeat_time,
                          String resp_code, String resp_msg, String repsp_msgid, String apply_id, String case_id,
                          String fun_name, String send_user,String res_time,String sned_time) {

    }
    // 判断一个字符串是否都为数字
    public  boolean isDigit(String strNum) {
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher((CharSequence) strNum);
        return matcher.matches();
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 13) {
            return false;
        }
        if (!isDigit(phoneNumber)) {
            return false;
        }
        if (!phoneNumber.startsWith("86")) {
            return false;
        }
        return true;
    }

    private String[] PraseRes(String res) {
        String[] ress = res.split(",");
        return ress;
    }

    @Override
    public boolean valid(int sms_template_id, Map<String, String> info) {
        return false;
    }
}
