package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode52 {
    private int count = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return count;
        }
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0);
        return count;
    }

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
            count++;
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
