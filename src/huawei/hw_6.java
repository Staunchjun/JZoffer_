package huawei;
/**
 * Created by Staunchjun on 2017/7/23.
 * 题目描述
 * 请实现如下接口
 * public   static   int  findNumberOf1( int num)
 * {请实现
 * return  0;
 * } 譬如：输入5 ，5的二进制为101，输出2
 * 涉及知识点：
 * 输入描述:
 * 输入一个整数
 * 输出描述:
 * 计算整数二进制中1的个数
 * 示例1
 * 输入
 * 5
 * 输出
 * 2
 */
import java.util.Scanner;
public class hw_6 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int count = 0;
            String str = Integer.toBinaryString(n);
            char[] cha = str.toCharArray();
            for (char c : cha) {
                if (c == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
