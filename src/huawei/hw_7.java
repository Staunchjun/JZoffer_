package huawei;
/**
 * Created by Staunchjun on 2017/7/23.
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 * 输出描述:
 * 整数N，最后一个单词的长度。
 * 示例1
 * 输入
 * hello world
 * 输出
 * 5
 */
import java.util.*;
public class hw_7 {
    public static int lengthOfLast(String str) {
        String[] s = str.split(" ");
        return s[s.length - 1].length();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(lengthOfLast(str));
        }
    }
}

