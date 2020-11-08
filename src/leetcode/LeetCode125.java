package leetcode;

import java.util.Locale;

public class LeetCode125 {
    public boolean isPalindrome1(String s) {
        if (s == null || s.length() == 1 || s.length() == 0) {
            return true;
        }
        /**
         * 忽略 大小写
         */
        s = s.toUpperCase(Locale.ENGLISH);
        /**
         * 只考虑 字母 和数字字符
         */
        int i = 0, k = s.length() - 1;
        while (i != k && i < s.length() && k > 0) {
            char left = 0;
            while (i < s.length()) {
                left = s.charAt(i);
                if (!chekVaild(left)) {
                    i++;
                } else {
                    break;
                }
            }
            if (i > s.length() - 1) {
                return true;
            }
            char right = 0;
            while (k >= 0) {
                right = s.charAt(k);
                if (!chekVaild(right)) {
                    k--;
                } else {
                    break;
                }
            }
            if (k < 0) {
                return true;
            }
            if (left != right) {
                return false;
            }
            if (i == k) {
                break;
            } else {
                i++;
                k--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1 || s.length() == 0) {
            return true;
        }
        /**
         * 忽略 大小写
         */
        s = s.toUpperCase(Locale.ENGLISH);
        /**
         * 只考虑 字母 和数字字符
         */
        int i = 0, k = s.length() - 1;
        while (i <= k) {
            if (!chekVaild(s.charAt(i))) {
                i++;
                continue;
            }
            if (!chekVaild(s.charAt(k))) {
                k--;
                continue;
            }
            if (s.charAt(i) != s.charAt(k)) {
                return false;
            }
            i++;
            k--;
        }
        return true;
    }

    boolean chekVaild(char left) {
        return (left <= 'Z' && left >= 'A') || (left <= '9' && left >= '0');
    }

    public static void main(String[] args) {
        LeetCode125 leetCode125 = new LeetCode125();
        System.out.println(leetCode125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(leetCode125.isPalindrome("race a car"));
//        System.out.println(leetCode125.isPalindrome("<,>"));
        System.out.println(leetCode125.isPalindrome("<,>2"));
        System.out.println(leetCode125.isPalindrome("2<,>"));
        System.out.println(leetCode125.isPalindrome("2<,2>"));
        System.out.println(leetCode125.isPalindrome("2<A,2>"));
        System.out.println(leetCode125.isPalindrome("2<AB,2>"));
    }
}
