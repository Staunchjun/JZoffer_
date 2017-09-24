package sms;

import java.util.Map;

public interface SmsModelDao {

   Map<String,String> QuerySmsModel(int sms_template_id);

}
