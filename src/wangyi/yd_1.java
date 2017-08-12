package wangyi;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/12.
 */
public class yd_1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int length = s.length();
        if (length>50 || length<=0)
        {
            return;
        }
        int[] dp = new int[length];
        if (s.charAt(0) == '0' || s.charAt(0) == '1')
        dp[0] = 1;
        for (int i = 1; i <length; i++) {
            if (s.charAt(i-1) != s.charAt(i) && (s.charAt(i) == '0' || s.charAt(i) == '1'))
            {
                dp[i] = dp[i-1]+1;
            }
            else
            {
                dp[i] = 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max)
            {
                max = dp[i];
            }
        }

        System.out.println(max);
    }

}
