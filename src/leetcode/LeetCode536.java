package leetcode;

import java.util.Stack;

public class LeetCode536 {
    private int count = 0;

    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        backtrack(N, 1, visited);
        return count;
    }

    /**
     * @param n
     * @param pos     用pos来记录是否已经选够了n个
     * @param visited 用visited来记录哪些访问过了
     */
    private void backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            /**
             * 查看是否有选过
             */
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                /**
                 * 开始做选择
                 */
                visited[i] = true;
                backtrack(n, pos + 1, visited);
                /**
                 * 恢复选择
                 */
                visited[i] = false;
            }
        }
    }

    /**
     * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
     * <p>
     * 第 i 位的数字能被 i 整除
     * i 能被第 i 位上的数字整除
     * 现在给定一个整数 N，请问可以构造多少个优美的排列？
     * <p>
     * 示例1:
     * <p>
     * 输入: 2
     * 输出: 2
     * 解释:
     * <p>
     * 第 1 个优美的排列是 [1, 2]:
     * 第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
     * 第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
     * <p>
     * 第 2 个优美的排列是 [2, 1]:
     * 第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
     * 第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
     * 说明:
     * <p>
     * N 是一个正整数，并且不会超过15。
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode536 leetCode536 = new LeetCode536();
        System.out.println(leetCode536.countArrangement(2));
    }
}
