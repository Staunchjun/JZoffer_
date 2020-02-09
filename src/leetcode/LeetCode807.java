package leetcode;

import java.util.Arrays;

public class LeetCode807 {
    /**
     * 例子：
     * 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
     * 输出： 35
     * 解释：
     * The grid is:
     * [ [3, 0, 8, 4],
     * [2, 4, 5, 7],
     * [9, 2, 6, 3],
     * [0, 3, 1, 0] ]
     * <p>
     * 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7] colMax
     * 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3] rowMax
     * 判断colMax rowMax 中的最小值，即极大值中的极小值
     * for (int k = 0; k < row; k++) {
     * for (int j = 0; j < col; j++) {
     * int val = grid[k][j];
     * sum += (Math.min(colMax[j],rowMax[k]) - val);
     * }
     * }
     * 在不影响天际线的情况下对建筑物进行增高后，新数组如下：
     * <p>
     * gridNew = [ [8, 4, 8, 7],
     * [7, 4, 7, 7],
     * [9, 4, 8, 7],
     * [3, 3, 3, 3] ]
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        /**
         * 找到row、col天线
         */
        Integer[] rowMax = new Integer[row];
        Integer[] colMax = new Integer[col];
        for (int k = 0; k < row; k++) {
            int[] i = grid[k];
            int val = Integer.MIN_VALUE;
            for (int j = 0; j < col; j++) {
                if (i[j] > val) {
                    val = i[j];
                }
            }
            rowMax[k] = val;
        }
        for (int k = 0; k < col; k++) {
            int val = Integer.MIN_VALUE;
            for (int j = 0; j < row; j++) {
                if (grid[j][k] > val) {
                    val = grid[j][k];
                }
            }
            colMax[k] = val;
        }
        /**
         System.out.println(Arrays.deepToString(rowMax));
         System.out.println(Arrays.deepToString(colMax));
         **/
        int sum = 0;
        /**
         * 开始拔高啦
         */
        for (int k = 0; k < row; k++) {
            for (int j = 0; j < col; j++) {
                int val = grid[k][j];
                sum += (Math.min(colMax[j], rowMax[k]) - val);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode807 leetCode807 = new LeetCode807();
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(leetCode807.maxIncreaseKeepingSkyline(grid));
    }
}
