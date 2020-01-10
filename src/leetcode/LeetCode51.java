package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode51 {
    List<List<String>> res;

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0);
        return res;
    }

    /**
     * 剪枝
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        // check is valid in col
        for (char[] chars : board) if (chars[col] == 'Q') return false;
        // check is valide upright
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // check is valide upleft
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private void backtrack(char[][] board, int row) {
        /**
         * 结束条件
         */
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }
        /**
         * 开始做选择放皇后
         */
        int length = board[row].length;
        for (int i = 0; i < length; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            /**
             * 做选择
             */
            board[row][i] = 'Q';
            /**
             * 下一个决策
             */
            backtrack(board, row + 1);
            /**
             * 撤销选择
             */
            board[row][i] = '.';
        }
    }
}
