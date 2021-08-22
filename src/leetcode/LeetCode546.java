//package leetcode;
//
//public class LeetCode546 {
//    int[][] d;
//    public int removeBoxes(int[] boxes) {
//        d = new int[boxes.length][boxes.length];
//        for (int i = 0; i < boxes.length; i++) {
//            for (int j = 0; j < boxes.length; j++) {
//                d[i][j] = -1;
//            }
//        }
//        return dfs(boxes, 0, boxes.length - 1);
//    }
//
//    private int dfs(int[] boxes, int start, int end) {
//
//        int res;
//        int ans = Integer.MAX_VALUE;
//        for (int j = start + 1; j <= end; j++) {
//            if (boxes.charAt(j)  == s.charAt(start)){
//                // j 和 start 一样，则可以忽略 即为 aaaaa样式
//                res = dfs(s, start, j - 1) + dfs(s, j + 1, end);
//            }else {
//                // j 和 start 不一样， 则需要继续计算 即为 axxb样式
//                res = dfs(s, start, j) + dfs(s, j + 1, end);
//            }
//            ans = Math.min(ans, res);
//            d[start][end] = ans;
//        }
//        return ans;
//    }
//}
