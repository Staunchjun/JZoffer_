package jibite;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/27.
 */
public class jibite2 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int cloum = scanner.nextInt();
        int[][] grid = new int[row][cloum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cloum; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[row][cloum];
        //可能之前一直为正，则只需1，可能之前的为负数最大，所以1-xxx
        dp[row-1][cloum-1] = Math.max(1,1-grid[row-1][cloum-1]);
        for (int i = row-2; i >=0 ; i--) {
            dp[i][cloum-1] = Math.max(1,dp[i+1][cloum-1]-grid[i][cloum-1]);
        }
        for (int i = cloum-2; i>=0 ; i--) {
            dp[row-1][i] = Math.max(1,dp[row-1][i+1] - grid[row-1][i]);
        }
        for (int i = row-2; i >=0 ; i--) {
            for (int j = cloum-2; j >=0 ; j--) {
                dp[i][j] = Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-grid[i][j]);

            }
        }

        System.out.println(dp[0][0]);
    }


}
