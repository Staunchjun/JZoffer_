package company.huawei;
/**
 * Created by Staunchjun on 2017/7/23.
 题目描述
 写出一个程序，接受一个有字母和数字以及空格组成的字符串，
 和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 输入描述:
 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 输出描述:
 输出输入字符串中含有该字符的个数。
 示例1
 输入
 ABCDEF
 A
 输出
 1
 */
import java.util.*;
public class hw_8 {
        public static void main(String[] args){
            int count=0;
            Scanner in = new Scanner(System.in);
            String str = in.nextLine().toUpperCase();
            char target  = in.nextLine().toUpperCase().toCharArray()[0];
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == target){
                    count++;
                }
            }
            System.out.println(count);
   }
}
