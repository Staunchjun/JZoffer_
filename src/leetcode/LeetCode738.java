package leetcode;

public class LeetCode738 {
    public static void main(String[] args) {

    }

    /**
     * 贪心 + 剪枝
     * <p>
     * 112200345 -> p=3  补0操作 -> 112000000 再减1 -> 111999999
     * 10 -> p=1 补0 -> 10 -1 -> 9
     * 234850 -> p=4 补0 -> 234800 - 1 -> 234799
     * 23520 -> p=3 补0 -> 23500 - 1 -> 23499
     * 23320 -> p=2 补0 -> 23000 - 1 -> 22999
     * 核心，找到第一个相同大于前面数字的数 重点：第一个！！！
     *
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        char[] res = String.valueOf(N).toCharArray();
        int p = 0;
        for (int i = 1; i < res.length; i++) {
            if (res[i] > res[i - 1]) {
                p = i;
            } else if (res[i] < res[i - 1]) {
                break;
            }
        }
        if (p + 1 == res.length) {
            return Integer.valueOf(new String(res));
        }
        while (++p != res.length) {
            res[p] = '0';
        }
        return Integer.valueOf(new String(res)) - 1;
    }
}
