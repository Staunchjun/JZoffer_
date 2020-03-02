package leetcode;

public class LeetCode1351 {
    public int countNegatives(int[][] grid) {
        /**
         * 二分法有坑
         */
        int col = grid[0].length;
        int num = 0;
        for (int[] ints : grid) {
            int l = 0;
            int r = col - 1;
            int pos = -1;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (ints[mid] < 0) {
                    pos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (pos >= 0)
                num += (col - pos);
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
//        int[][] grid = {{4, 3}, {3, 2}};
        LeetCode1351 leetCode1351 = new LeetCode1351();
        System.out.println(leetCode1351.countNegatives(grid));
    }
}
