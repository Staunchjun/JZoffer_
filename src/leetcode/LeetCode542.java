package leetcode;

import java.util.*;

public class LeetCode542 {
    private final int[][] dirs = new int[][]{
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {

        int len = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[len][col];
        int[][] tempMatrix = new int[len][col];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    continue;
                }
                CopyMatrix(matrix, len, col, tempMatrix);
                SetMatrix(res, tempMatrix, i, j);
            }
        }
        return res;
    }

    private void SetMatrix(int[][] res, int[][] tempMatrix, int i, int j) {
        Queue<Node> temp = new LinkedList<>();
        temp.add(new Node(i, j, 0));
        while (!temp.isEmpty()) {
            Node node = temp.poll();
            int x = node.x;
            int y = node.y;
            int count = node.count;
            if (tempMatrix[x][y] != 0) {
                count += 1;
                tempMatrix[x][y] = -1;
                for (int[] dir : dirs) {
                    int newX = dir[0] + x;
                    int newY = dir[1] + y;
                    if (isValid(tempMatrix, newX, newY)) {
                        temp.add(new Node(newX, newY, count));
                    }
                }
            } else {
                res[i][j] = count;
                break;
            }

        }
    }

    private boolean isValid(int[][] tempMatrix, int newX, int newY) {
        return newX < tempMatrix.length && newX >= 0 && newY >= 0 && newY < tempMatrix[0].length && tempMatrix[newX][newY] != -1;
    }

    private void CopyMatrix(int[][] matrix, int len, int col, int[][] tempMatrix) {
        for (int k = 0; k < len; k++) {
            if (col >= 0) System.arraycopy(matrix[k], 0, tempMatrix[k], 0, col);
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] matrix2 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        LeetCode542 leetCode542 = new LeetCode542();
//        System.out.println(Arrays.deepToString(leetCode542.updateMatrix(matrix1)));
        System.out.println(Arrays.deepToString(leetCode542.updateMatrix(matrix2)));
    }
}
