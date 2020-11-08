package leetcode;

public class LeetCode583 {
    /**
     * 给定两个单词 word1 和 word2，找到使得 word1 和 word2
     * 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
     * @param word1
     * @param word2
     * @return
     */
    public static  int minDistance(String word1, String word2) {
        //找到相同的长度的序列有多少
        int len1 = word1.length();
        int len2 = word1.length();
        //表示 len1、len2的公共长度为多长
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
               if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                   dp[i][j] = dp[i - 1][j - 1] + 1;
               }else {
                   dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j] );
               }
            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }
}
