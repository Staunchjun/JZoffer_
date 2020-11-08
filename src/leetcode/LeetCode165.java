package leetcode;

public class LeetCode165 {
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        /**
         * 不够 0 的补 0，用Integer.valueof可以消除001为1
         */
        int maxLen = Math.max(a1.length, a2.length);
        for (int i = 0; i < maxLen; i++) {
            int left = 0;
            int right = 0;
            if (i < a1.length) {
                left = Integer.valueOf(a1[i]);
            }
            if (i < a2.length) {
                right = Integer.valueOf(a2[i]);
            }
            if (left > right) {
                return 1;
            } else if (left < right) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode165 leetCode165 = new LeetCode165();
        System.out.println(leetCode165.compareVersion("0.1", "1.1"));
        System.out.println(leetCode165.compareVersion("1.0.1", "1"));
        System.out.println(leetCode165.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(leetCode165.compareVersion("1.01", "1.001"));
        System.out.println(leetCode165.compareVersion("1.0", "1.0.0"));
    }
}
