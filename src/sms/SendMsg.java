package sms;

import java.util.Map;

interface SendMsg {

    int SendMsg(String mobiles, String customer_name, int sms_template_id, Map<String,String> info);
    boolean valid(int sms_template_id,Map<String,String> info);

}
