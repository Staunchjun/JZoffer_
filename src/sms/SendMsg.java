package sms;

import java.util.Map;

interface SendMsg {

    /**
     *
     * @param mobiles 手机号码 （必需）
     * @param customer_name 客户名字（必需）
     * @param sms_template_id 使用的模版编号（必需）
     * @param info 填入信息（必需）
     * @param apply_id  贷款申请编号（选输）
     * @param case_id 档案编号（选输）
     * @param func_name 功能模块（必需）
     * @param send_user 发送用户名称（必需）
     * @return code_status 状态码
     */

    int SendMsg(String mobiles, String customer_name, int sms_template_id, Map<String,String> info,String apply_id,String case_id,String func_name,String send_user);

    /**
     *
     * @param sms_template_id 使用的模版编号（必需）
     * @param info 填入信息（必需）
     * @return  isVaild 返回检验结果
     */
    boolean valid(int sms_template_id,Map<String,String> info);

}
