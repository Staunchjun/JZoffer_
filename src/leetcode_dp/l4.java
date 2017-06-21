package leetcode_dp;

/**
 * Created by Administrator on 2017/6/21 0021.
 *
 Given a string s, partition s such that every substring of the partition is a palindrome.
 Return the minimum cuts needed for a palindrome partitioning of s.
 For example, given s ="aab",
 Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 */
public class l4 {
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] ss = s.toCharArray();
        boolean[][] isPal = new boolean[ss.length][ss.length];
        for (int i = 0; i < ss.length; i++)
            for (int j = i; j >=0 ; j--)
                if (ss[i] == ss[j] && (i-j<=2||isPal[j+1][i-1]))
                    isPal[j][i] = true;
        int[] dp = new int[ss.length+1];
        dp[0] = -1;
        for (int i = 1; i <=ss.length ; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i-1; j >= 0 ; j--) {
                if (isPal[j][i-1] && dp[j] +1 < min)
                     min  = dp[j] +1;
            }
        dp[i] = min;
        }
        return dp[ss.length];
    }
}
