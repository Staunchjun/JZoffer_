package sms;

import java.util.Map;

public class SmsService implements SmsModelDao,SmsStoreDao {
    @Override
    public Map<String, String> QuerySmsModel(int sms_template_id) {
        return null;
    }

    @Override
    public int recordSms(String temp_id, String mobile, String name, String content, String status, String repeat_time, String resp_code, String resp_msg, String repsp_msgid, String apply_id, String case_id, String fun_name, String send_user, String res_time, String sned_time) {
        return 0;
    }
}
