package NewCode;
/**
 * Created by Administrator on 2017/6/6.
 * 牛牛现在有一个n个数组成的数列,
 * 牛牛现在想取一个连续的子序列,并且这个子序列还必须得满足:
 * 最多只改变一个数,就可以使得这个连续的子序列是一个严格上升的子序列,
 * 牛牛想知道这个连续子序列最长的长度是多少。
 输入描述:
 输入包括两行,第一行包括一个整数n(1 ≤ n ≤ 10^5),即数列的长度;
 第二行n个整数a_i, 表示数列中的每个数(1 ≤ a_i ≤ 10^9),以空格分割。
 输出描述:
 输出一个整数,表示最长的长度。
 输入例子:
 6
 7 2 3 1 5 6
 输出例子:
 5
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NK_3_7 {
    public static void main(String[] args)
    {   Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
        }
    }
}
