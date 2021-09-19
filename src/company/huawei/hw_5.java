package company.huawei;
/**
 * Created by Staunchjun on 2017/7/23.
 */
import java.util.*;
public class hw_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();//next()是遇到空格；nextLine()是遇到回车
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse().toString());
        }
    }
}
