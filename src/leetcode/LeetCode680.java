package leetcode;

public class LeetCode680 {
    public boolean validPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return true;
        }
        int left = 0;
        int right = len - 1;
        int count = 0;
        return check(left, right, count, s);

    }

    private boolean check(int left, int right, int count, String s) {
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar == rightChar) {
                left++;
                right--;
            } else {
                count++;
                if (count >= 2) {
                    return false;
                } else {
                    return check(left + 1, right, count, s) || check(left, right - 1, count, s);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode680 leetCode680 = new LeetCode680();
        System.out.println(leetCode680.validPalindrome("aba"));
        System.out.println(leetCode680.validPalindrome("abca"));
        System.out.println(leetCode680.validPalindrome("cbbcc"));
    }
}
