package company.wangyi;
import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/26.
 */
public class huyu03 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String m = scanner.nextLine();
        int n1 = Integer.parseInt(n);
        int m1 = Integer.parseInt(m);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int[][] dp = new int[n1+1][m1+1];
        for (int i = 0; i <= n1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <=n1; i++) {
            for (int j = 1; j <=m1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[n1][m1]);

    }


}
