package leetcode_dp;


/**
 * Created by Administrator on 2017/6/27 0027.
 * <p>
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 */

import java.util.ArrayList;
import java.util.Set;

public class l9 {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        if (dict == null || dict.size() == 0 || s == null || s.length() == 0)
            return result;

    // 将字符串从分割点i处切割为两部分左边s1和右边s2，
    // 如果s1包含在字典中，则递归计算s2切割生成的字符串
    // 用flag[i]==true表示从i位置往后分割不出满足条件的串
    // flag[i]==true的情况就不需要递归计算了，从而降低运算时间
        boolean[] flag = new boolean[s.length()];
        help(result, s, dict, "", 0, flag);
        return result;
    }

    public void help(ArrayList<String> result, String s, Set<String> dict,
                     String string, int begin, boolean[] flag) {
        for (int i = begin + 1; i <= s.length(); i++) {
            String tmp = string;
            if (dict.contains(s.substring(begin, i))) {
                // 分割点到了最后，直接加入到result中
                if (i == s.length()) {
                    tmp += s.substring(begin, i);
                    result.add(tmp);
                } else {
                    // 只有当flag[begin]为false时才进行后面的分割
                    if (!flag[begin]) {
                        int size = result.size();
                        tmp += s.substring(begin, i) + " ";
                        help(result, s, dict, tmp, i, flag);
                        // 当递归前后result的size没有变化，说明i后不可分割
                        if (size == result.size())
                            flag[i] = true;
                    }
                }
            }
        }
    }
}