package leetcode;

public class LeetCode1866 {
    private int mod = 1000000007;

    public int rearrangeSticks(int n, int k) {
        int[][] memory = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memory[i][j] = -1;
            }
        }
        return dfs(n, k, memory);
    }

    private int dfs(int n, int k, int[][] memory) {
        // 如果k 小于0 则认为是 已经派发完了
        if (k < 0) {
            return 0;
        }
        // 如果 k > n ，即便 n 从小到大排列也不可能满足要求
        if (k > n) {
            return 0;
        }
        // 如果刚好等于 n 可 只有一种可能
        if (k == n) {
            return 1;
        }

        if (memory[n][k] == -1) {
            // 分割为左右两边计算不行，已经尝试过了。
            // 如果 k < n 则 可能性有点多，如下进行分割
            // 分割 : 一个一个排除，有两种情况
            // 情况1： 这一根 被用来派发
            // 情况2： 这一根 不用来派发，则这一根可以藏在n-1中 12345... 从头开始排除
            return memory[n][k] = (int) ((dfs(n - 1, k - 1, memory) + dfs(n - 1, k, memory) * (long) (n - 1)) % mod);
        } else {
            return memory[n][k];
        }
    }

    public static void main(String[] args) {
        LeetCode1866 leetCode1866 = new LeetCode1866();
        System.out.println(leetCode1866.rearrangeSticks(3, 2));
        System.out.println(leetCode1866.rearrangeSticks(5, 5));
        System.out.println(leetCode1866.rearrangeSticks(20, 11));
    }
}
