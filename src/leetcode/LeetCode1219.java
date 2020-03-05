package leetcode;

public class LeetCode1219 {
    private int row = 0;
    private int col = 0;
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 多个路口结果计算呗。
     * 回溯 + dfs 为什么用回溯，因为 省略多个grid的构造，每次走完恢复下就好了
     *
     * @param grid
     * @return
     */
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] > 0){
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (!checkValid(i, j) || grid[i][j] <= 0) {
            return 0;
        }
        /**
         * 用0标记已经走过了
         */
        int origin = grid[i][j];
        /**
         * 标记已经走过了
         */
        grid[i][j] = 0;
        int sum = 0;
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            /**
             * 错误写法是写在这里做判断
             */
//            if (checkValid(newX, newY) && grid[newX][newY] > 0) { 写在这里做判断会少加一次，最后一次加不上了，如果要加上，前面必须先返回值
//            记住，一定要先在递归开始处处写好结束条件，不然很容易漏掉
                sum = Math.max(sum, origin + dfs(grid, newX, newY));
//            }

        }
        /**
         * 恢复刚才做的标记
         */
        grid[i][j] = origin;
        return sum;
    }

    private boolean checkValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
       int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
       LeetCode1219 leetCode1219 = new LeetCode1219();
       System.out.println(leetCode1219.getMaximumGold(grid));
    }
}
