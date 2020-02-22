package leetcode;

public class LeetCode959 {
    /**
     * 输入：
     * [
     * " /",
     * "/ "
     * ]
     * 输出：2
     * 2x2行不通，是因为信息简化中数据丢失了，
     * 可以加大图像尺寸 3*3及以上都是可以的。
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] graph = new boolean[n * 3][n * 3];
        /**
         * 构造graph出来
         */
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                /**
                 将 / 转为
                 001
                 010
                 100.
                 */
                if (grid[i].charAt(j) == '/') {
                    graph[i * 3][j * 3 + 2] = true;
                    graph[i * 3 + 1][j * 3 + 1] = true;
                    graph[i * 3 + 2][j * 3] = true;
                    /**
                     \转为
                     100
                     010
                     001。
                     */
                } else if (grid[i].charAt(j) == '\\') {
                    graph[i * 3][j * 3] = true;
                    graph[i * 3 + 1][j * 3 + 1] = true;
                    graph[i * 3 + 2][j * 3 + 2] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n * 3; ++i) {
            for (int j = 0; j < n * 3; ++j) {
                if (!graph[i][j]) {
                    dfs(graph, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] graph, int i, int j) {
        int len = graph.length;
        if (0 <= i && i < len && 0 <= j && j < len && !graph[i][j]) {
            /**
             * 走过这里啦,把这里封锁掉
             */
            graph[i][j] = true;
            dfs(graph, i, j - 1);
            dfs(graph, i, j + 1);
            dfs(graph, i - 1, j);
            dfs(graph, i + 1, j);
        }
    }

    public static void main(String[] args) {

    }
}
