package NewCode;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/6.
 * 牛牛想对一个数做若干次变换，直到这个数只剩下一位数字。
 变换的规则是：将这个数变成 所有位数上的数字的乘积。比如285经过一次变换后转化成2*8*5=80.
 问题是，要做多少次变换，使得这个数变成个位数。
 输入描述:
 输入一个整数。小于等于2,000,000,000。
 输出描述:
 输出一个整数，表示变换次数。
 输入例子:
 285
 输出例子:
 2
 */
public class NK_3_1 {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
        String num = scanner.nextLine();
        char[] nums =num.toCharArray();
        int count = 0;
        while ( nums.length != 1) {
            long newNum = 1;
            for (int i = 0; i < nums.length; i++) {
                if ('0' == nums[i]) {
                    newNum = 0;
                    break;
                } else {
                    newNum = newNum * (nums[i]-'0');
                }
            }
            String newNumStr = String.valueOf(newNum);
            nums = newNumStr.toCharArray();
            count++;
        }
        System.out.print(count);
        }
    }
}
