package leetcode_dp;

/**
 * Created by Administrator on 2017/6/27 0027.
 Follow up for "Unique Paths":
 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as1and0respectively in the grid.
 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is2.
 Note: m and n will be at most 100.
 */
public class l11 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++)
        {
            if (obstacleGrid[i][0] == 1){break;}
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++)
        {
            if (obstacleGrid[0][i] == 1){break;}
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1)dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
