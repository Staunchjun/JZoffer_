package leetcode;

public class LeetCode980 {
    //上下左右
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    int cnt = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 找到起始的地方
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, m, n);
                    break;
                }
            }
        }
        return cnt;
    }

    private void dfs(int x, int y, int[][] grid, int m, int n) {
        if (grid[x][y] == 2){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0){
                        return;
                    }
                }
            }
            cnt++;
            return;
        }
        //设置为3表示已经走过了
        if (grid[x][y] == 1){
            grid[x][y] = 4;
        }else {
            grid[x][y] = 3;
        }

        //做出选择
        for (int i = 0; i < 4; ++i) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || tx >= m || ty < 0 || ty >= n || grid[tx][ty] == -1 || grid[tx][ty] == 3 || grid[tx][ty] == 4) {
                continue;
            }
            dfs(tx, ty, grid, m, n);
        }
        //复原走过的地方
        if (grid[x][y] == 4){
            grid[x][y] = 1;
        }else {
            grid[x][y] = 0;
        }
    }

    public static void main(String[] args) {
        LeetCode980 leetCode980 = new LeetCode980();
        int[][] grid = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(leetCode980.uniquePathsIII(grid));
    }
}
