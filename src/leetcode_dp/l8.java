package leetcode_dp;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/27 0027.
 Given a string s and a dictionary of words dict, determine
 if s can be segmented into a space-separated sequence of one or more dictionary words.
 For example, given
 s ="leetcode",
 dict =["leet", "code"].
 Return true because"leetcode"can be segmented as"leet code".
 */
public class l8 {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 1; i <len+1 ; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]&&dict.contains(s.substring(j,i)))
                { dp[i] = true;
                break;}
            }
        }
        return dp[len];
   }
}
