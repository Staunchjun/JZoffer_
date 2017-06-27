package leetcode_dp;
/**Created by Administrator on 2017/6/25 0025.
 Given a string S and a string T, count the number of distinct subsequences of T in S.
 A subsequence of a string is a new string which is formed from the original string
 by deleting some (can be none) of the characters without disturbing the relative
 positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
 Here is an example:
 S ="rabbbit", T ="rabbit"
 Return3.
 */
public class l6 {
    public int numDistinct(String S, String T) {
        int row = S.length();
        int col = T.length();
        int[][] dp = new int[row+1][col+1];
        for (int i = 0; i < col+1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < row+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < row+1; i++) {
            for (int j = 1; j < col+1; j++) {
                if (S.charAt(i-1) == T.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[row][col];
    }
}
