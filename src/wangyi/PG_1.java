package wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/4.
 * 给定一个字符串，请你将字符串重新编码，
 * 将连续的字符替换成“连续出现的个数+字符”。
 * 比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。
 输入描述:
 每个测试输入包含1个测试用例
 每个测试用例输入只有一行字符串，字符串只包括大写英文字母，长度不超过10000。
 输出描述:
 输出编码后的字符串
 输入例子:
 AAAABCCDAA
 输出例子:
 4A1B2C1D2A
 */
public class PG_1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            String str =  scanner.nextLine();
            char[] strs = str.toCharArray();
            if (strs.length == 1)
            {
                System.out.print("1"+strs[0]);
                return;
            }
            if (strs.length == 0)
            {
                return;
            }
            int second = 1;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < strs.length; i++) {
                while (second <=str.length()-1 && strs[i] ==strs[second]  )
                {
                    second++;
                }
                int num = second - i;
                stringBuffer.append(num);
                stringBuffer.append(strs[i]);
                i = second-1;
                second = second+1;
            }
            System.out.print(stringBuffer.toString());

        }
    }
}
