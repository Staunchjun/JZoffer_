//package sms;
//
//import sms.SendMsg;
//
//import java.util.Map;
//
//public class test {
//    static class SendMsgImp implements SendMsg {
//
//
//        @Override
//        public int SendMsg(String mobiles, String customer_name, int sms_template_id, Map<String, String> info) {
//
//            return 0;
//        }
//
//        @Override
//        public boolean valid(int sms_template_id, Map<String, String> info) {
//            return false;
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        SendMsg a = new SendMsgImp();
//        a.SendMsg(null,null,1,null);
//        a.valid(1,null);
//    }
//}
