package leetcode;

public class LeetCode1568 {
    //上下左右
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //0 1 2 如果是全连通则为 1/2. 如果 非全联通 则为 0/
        // 岛屿数量不为 1，陆地已经分离
        if (count(grid, n, m) != 1) {
            return 0;
        }
        //接下来是搞去1个就能可以
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                // 把陆地变为0
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (count(grid, n, m) != 1) {
                        // 更改一个陆地单元为水单元后陆地分离
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        //剩下的至少要搞2次才行
        return 2;
    }

    private int count(int[][] grid, int n,  int m) {
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                //为2为0都不管
                if (grid[i][j] == 1) {
                    cnt++;
                    //深搜 遍历所有和1相连的
                    dfs(i, j, grid, n, m);
                }
            }
        }
        // 还原
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }
        return cnt;
    }

    private void dfs(int x, int y, int[][] grid, int n, int m) {
        //设置为2表示已经走过了
        grid[x][y] = 2;
        for (int i = 0; i < 4; ++i) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] != 1) {
                continue;
            }
            dfs(tx, ty, grid, n, m);
        }
    }

    public static void main(String[] args) {

    }
}
