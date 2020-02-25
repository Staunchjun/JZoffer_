package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1227 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] dirs = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
        };
        int[][] gridWithQueens = new int[8][8];
        for (int[] queen : queens) {
            gridWithQueens[queen[0]][queen[1]] = 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int[] dir : dirs) {
            int x = king[0];
            int y = king[1];
            while (inArea(x, y)) {
                if (gridWithQueens[x][y] == 1) {
                    res.add(Arrays.asList(x, y));
                    break;
                } else {
                    x += dir[0];
                    y += dir[1];
                }
            }
        }
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public static void main(String[] args) {
        int[][] queens = new int[][]
                {{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2},
                        {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2},
                        {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}};
        int[] king = new int[]{3, 4};
        System.out.println(Arrays.deepToString((new LeetCode1227()).queensAttacktheKing(queens, king).toArray()));
    }

}
