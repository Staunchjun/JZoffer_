package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994 {
    /**
     * 多源BFS
     *
     * @param grid
     * @return
     */
    private int row = 0;
    private int col = 0;

    public int orangesRotting(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<OldOrange> stack = new LinkedList<>();
        int min = 0;
        /**
         * 找到所有2的地方，并且在2的地方开始
         */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    stack.add(new OldOrange(i, j, 0));
                }
            }
        }
        while (!stack.isEmpty()) {
            OldOrange oldOrange = stack.poll();
            min = oldOrange.min;
            for (int[] dir : dirs) {
                int newX = oldOrange.x + dir[0];
                int newY = oldOrange.y + dir[1];
                if (checkValid(newX, newY) && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    stack.add(new OldOrange(newX, newY, oldOrange.min + 1));
                }
            }
        }
        /*
        如果存在1就直接返回-1
         */
        for (int[] row : grid) {
            for (int i : row)
                if (i == 1) {
                    return -1;
                }
        }
        return min;
    }

    private boolean checkValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    class OldOrange {
        int x;
        int y;
        /**
         * 记录当前这个是在什么时候腐烂的
         */
        int min;

        OldOrange(int x, int y, int min) {
            this.x = x;
            this.y = y;
            this.min = min;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        LeetCode994 leetCode994 = new LeetCode994();
        System.out.println(leetCode994.orangesRotting(grid));
    }
}
