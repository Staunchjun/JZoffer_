package leetcode;

public class LeetCode1254 {
    /**
     * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
     * <p>
     * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
     * <p>
     * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
     * <p>
     * 请返回封闭岛屿的数目。
     *
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        /**
         * 边界着色
         */
        for (int i = 0; i < row; i++) {
            /**
             * 第一列 最后一列
             */
            dfs(grid, i, 0);
            dfs(grid, i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            /**
             * 第一行 最后一行
             */
            dfs(grid, 0, i);
            dfs(grid, row - 1, i);
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (inArea(i, j) && grid[i][j] == 0) {
            grid[i][j] = 1;
            for (int[] dir : dirs) {
                dfs(grid, i + dir[0], j + dir[1]);
            }
        }
    }

    private int row = 0;
    private int col = 0;

    private boolean inArea(int x, int y) {
        return x < row && x >= 0 && y >= 0 && y < col;
    }

    private int[][] dirs = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public static void main(String[] args) {
        int[][] board =
                {{1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1}};

        LeetCode1254 leetCode529 = new LeetCode1254();
        System.out.println(leetCode529.closedIsland(board));
    }
}

