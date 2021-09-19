//package leetcode;
//
//import java.util.Arrays;
//
//public class LeetCode1289 {
//    public int minFallingPathSum(int[][] arr) {
//        /*
//        [1,2,3]
//        [4,5,6]
//        [7,8,9]
//        dfs || dp
//        */
//        int[][] memo = new int[arr.length + 2][arr.length + 2];
//        for (int[] dp : memo) {
//            Arrays.fill(dp, -1);
//        }
//
//        return dfs(arr,0, -1, memo);
//    }
//
//    int minVal = 100000000;
//
//    private int dfs(int[][] arr,int curIndex, int lastIndex, int[][] memo) {
//        // 如果以前就已经有了就直接返回
//        if (lastIndex != -1){
//            if (memo[curIndex][lastIndex] != -1){
//                return memo[curIndex][lastIndex];
//            }
//        }
//
//        int ans = 0;
//        // for 循环里面选
//        for (int i = 0; i < arr[curIndex].length; i++) {
//            if (i == lastIndex) {
//                continue;
//            }
//            ans =  arr[curIndex][i] + dfs(arr, curIndex + 1, i, memo);
//            // 这里的return 是记录 curIndex 和lastIndex的时候 需要的值。
//            //如果 已经跑完了就直接返回结果, 也不累计了
//            if (curIndex >= arr.length){
//                minVal = Math.min(minVal, sum);
//                return 0;
//            }
//        }
//        if(lastIndex != -1){
//            return  memo[curIndex][lastIndex] = ans;
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        LeetCode1289 leetCode1289 = new LeetCode1289();
//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(leetCode1289.minFallingPathSum(arr));
//    }
//}
