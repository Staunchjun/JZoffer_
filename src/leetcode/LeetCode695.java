package leetcode;

public class LeetCode695 {
    /**
     * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
     * <p>
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
     * <p>
     * 示例 1:
     * <p>
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,1,1,0,1,0,0,0,0,0,0,0,0],
     * [0,1,0,0,1,1,0,0,1,0,1,0,0],
     * [0,1,0,0,1,1,0,0,1,1,1,0,0],
     * [0,0,0,0,0,0,0,0,0,0,1,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
     * <p>
     * 示例 2:
     * <p>
     * [[0,0,0,0,0,0,0,0]]
     * 对于上面这个给定的矩阵, 返回 0。
     * <p>
     * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j, grid);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    private int count;

    private void dfs(int i, int j, int[][] grid) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) {
            return;
        }
        count++;
        grid[i][j] = 0;
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }

    public static void main(String[] args) {
        LeetCode695 leetCode695 = new LeetCode695();
        int[][] grids = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(leetCode695.maxAreaOfIsland(grids));

    }
}
