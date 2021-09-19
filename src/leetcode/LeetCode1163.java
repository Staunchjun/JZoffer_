package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode1163 {
    /**
     * 示例 1：
     * <p>
     * 输入："abab"
     * 输出："bab"
     * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
     * 示例 2：
     * <p>
     * 输入："leetcode"
     * 输出："tcode"
     */
    public String lastSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return null;
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(1, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return t1.compareTo(s);
            }
        });
        for (int i = 0; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                String temp = s.substring(i, j);
                if (temp.length() == 0) {
                    continue;
                }
                priorityQueue.add(temp);
            }
        }

        return priorityQueue.poll();
    }

    public String lastSubstring1(String s) {
        char[] array = s.toCharArray();
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            if (array[k] < array[i]) {
                k = i;
            } else if (array[k] == array[i] && array[i] != array[i - 1]) {
                for (int j = 0; i + j < s.length(); j++) {
                    if (array[k + j] < array[i + j]) {
                        k = i;
                        break;
                    } else if (array[k + j] > array[i + j]) {
                        break;
                    }
                }
            }
        }
        return s.substring(k);
    }

    public static void main(String[] args) {
        LeetCode1163 leetCode1163 = new LeetCode1163();
        System.out.println(leetCode1163.lastSubstring("abab"));
        System.out.println(leetCode1163.lastSubstring("leetcode"));
    }
}
