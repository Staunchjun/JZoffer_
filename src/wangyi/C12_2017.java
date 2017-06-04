package wangyi;
import java.util.Scanner;
/**
 * Created by Administrator on 2017/6/4.
 易老师购买了一盒饼干，盒子中一共有k块饼干，但是数字k有些数位变得模糊了，看不清楚数字具体是多少了。
 易老师需要你帮忙把这k块饼干平分给n个小朋友，易老师保证这盒饼干能平分给n个小朋友。现在你需要计算出k有多少种可能的数值
 输入描述:
 输入包括两行：
 第一行为盒子上的数值k，模糊的数位用X表示，长度小于18(可能有多个模糊的数位)
 第二行为小朋友的人数n
 输出描述:
 输出k可能的数值种数，保证至少为1
 输入例子:
 9999999999999X
 3
 输出例子:
 4
 */
public class C12_2017 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        //注意long的使用。
        long[][] dp = new long[str.length()+1][];
        for (int i = 0; i <= str.length(); i++) {
            dp[i] = new long[n];
        }
        dp[0][0] = 1;
        for (int i = 1; i <= str.length(); i++) {
            char c = str.charAt(i-1);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 10; k++) {
                    if (c == 'X'||c == '0'+k)
                        dp[i][(j*10+k)%n] += dp[i-1][j];
                }
            }
        }
        System.out.print(dp[str.length()][0]);
    }
}
