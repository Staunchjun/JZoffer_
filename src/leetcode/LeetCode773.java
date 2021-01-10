package leetcode;

import java.util.*;

public class LeetCode773 {

    /**
     * 题目的坑点在于不要对board进行实时的修改，会影响到其他只干的！！！！！一定要在temp上进行修改，而且即便你是用clone估计也是浅拷贝
     * @param board
     * @return
     */

    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        String targetBoard = "123450";
        String org = getString(board);
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(org);
        visited.add(org);
        int step = 0;
        while (!queue.isEmpty()) {
//            每次先把队列清空了先
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String curBoard = queue.poll();
                if (targetBoard.equals(curBoard)) {
                    return step;
                }
                int[][] tempBoard = getArray(curBoard, m, n);
//               开始找0
                int startX = 0;
                int startY = 0;
                for (int k = 0; k < m; k++) {
                    for (int j = 0; j < n; j++) {
                        if (tempBoard[k][j] == 0) {
                            startX = k;
                            startY = j;
                            break;
                        }
                    }
                }
//            开始上下左右地换
                for (int[] dir : dirs) {
                    int nextX = startX + dir[0];
                    int nextY = startY + dir[1];
                    if (nextX >= m || nextX < 0 || nextY >= n || nextY < 0) {
                        continue;
                    } else {
//                    准备和0交换位置把
                        int[][] newBoard = new int[m][n];
                        for (int k = 0; k < m; k++) {
                            for (int j = 0; j < n; j++) {
                                newBoard[k][j] = tempBoard[k][j];
                            }
                        }

                        int temp = newBoard[startX][startY];
                        newBoard[startX][startY] = newBoard[nextX][nextY];
                        newBoard[nextX][nextY] = temp;

//                   看一下换完位置的兄弟是不是去过的
                        if (!visited.contains(getString(newBoard))) {
                            queue.add(getString(newBoard));
                            visited.add(getString(newBoard));

                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String getString(int[][] board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                stringBuilder.append(board[i][j]);
            }
        }
        return stringBuilder.toString();
    }

    private int[][] getArray(String boardStr, int m, int  n) {
        int[][] board = new int[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(boardStr.charAt(i * n + j)));
            }
        }
        return board;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{4, 1, 2}, {5, 0, 3}};
        LeetCode773 leetCode773 = new LeetCode773();
        System.out.println(leetCode773.slidingPuzzle(board));
    }
}
