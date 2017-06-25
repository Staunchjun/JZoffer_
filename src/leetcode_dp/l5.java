package leetcode_dp;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/25 0025.
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 For example, given the following triangle
 [[2],
 [3,4],
 [6,5,7],
 [4,1,8,3]]
 The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class l5 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        //DP from bottom to up;
        ArrayList<Integer> lastRow  = triangle.get(triangle.size()-1);
        int[][] minSumPaths = new int[triangle.size()][lastRow.size()];
        for (int i = 0; i < lastRow.size(); i++) {
            minSumPaths[triangle.size()-1][i] = lastRow.get(i);
        }
        for (int i = triangle.size()-2; i >= 0; i--) {
        ArrayList<Integer> lastRow2  = triangle.get(i);
            for (int j = 0; j < lastRow2.size(); j++) {
                minSumPaths[i][j] = Math.min(minSumPaths[i+1][j],minSumPaths[i+1][j+1])+lastRow2.get(j);
            }
        }
        return minSumPaths[0][0];
    }
}
