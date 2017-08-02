package Pinduoduo;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/1.
 */
/*
*背包问题
j巧克力重量为w[j]
每个小朋友i拿到的巧克力大小为h[i]才会上台
* */
public class pinduoduo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] H = new int[n+1];
        H[0] = 0;
        for (int i = 1; i <= n; i++) {
            H[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] W = new int[m+1];
        W[0]=0;
        for (int i = 1; i <= m; i++) {
            W[i] = sc.nextInt();
        }
        //这里有n个小孩子 m块巧克力
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        //有巧克力没有学生
        for (int i = 0; i < m; i++) {
            dp[0][i] = 0;
        }
        //有学生没有巧克力
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (W[j] >= H[i]) {
                    //如果只有一个学生有m个巧克力则最多也只能有一个学生上去
                    //如果只有两个学生有m个巧克力则最多可能有两个上去或者一个，即是只有一个符合要求
                    //注意dp[i-1][j-1]+1意味着下一个j就符合要求了，多一个学生上去
                    //dp[i-1][j]意味着
                    dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i-1][j]);

                }
            }
        }
        System.out.println(dp[n][m]);

    }
}
