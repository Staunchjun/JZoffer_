package company.huawei;
/**
 * Created by Staunchjun on 2017/7/23.
 */
import java.util.*;
public class hw_3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        System.out.println(sb.toString());
    }
}
