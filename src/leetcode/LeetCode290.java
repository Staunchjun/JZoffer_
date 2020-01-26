package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290 {
    public static void main(String[] args) {
        LeetCode290 leetCode290 = new LeetCode290();
        String pattern1 = "abba";
        String pattern2 = "aaaa";
        String str1 = "dog cat cat dog";
        String str2 = "dog cat cat fish";
        String str3 = "dog cat cat dog";
        String str4 = "dog dog dog dog";
        LeetCode290.checkResult(LeetCode290.wordPattern(pattern1, str1), true);
        LeetCode290.checkResult(LeetCode290.wordPattern(pattern1, str2), false);
        LeetCode290.checkResult(LeetCode290.wordPattern(pattern2, str3), false);
        LeetCode290.checkResult(LeetCode290.wordPattern(pattern1, str4), false);
    }

    private static void checkResult(boolean expect, boolean actual) {
        if (expect == actual) {
            System.out.println("Pass!");
        } else {
            System.out.println("Fail!");
        }
    }

    private static boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        char[] charArray = pattern.toCharArray();
        Map<Character, String> maps = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            char character = charArray[i];
            String string = strs[i];
            if (maps.containsKey(character)) {
                if (!maps.get(character).equals(string)) {
                    return false;
                }
            } else {
                if (maps.containsValue(string)) {
                    return false;
                } else {
                    maps.put(character, string);
                }
            }
        }
        return true;
    }
}
