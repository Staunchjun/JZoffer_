package leetcode;

public class LeetCode1304 {
    /**
     * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int h = 0, t = 0, l = n - 1;
        for (int i = 0; i < n / 2; i++) {
            res[i] = h + 1;
            res[l] = t - 1;
            t--;
            h++;
            l--;
        }
        return res;
    }

}
