package leetcode;

import java.util.Arrays;

public class LeetCode1696 {
    int[] memory;

    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k && i - j >= 0 ; j++) {
                dp[i] = Math.max(dp[i], dp[i - j]);
            }
            dp[i] += nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int constrainedSubsetSum1(int[] nums, int k) {
        memory = new int[nums.length];
        Arrays.fill(memory, Integer.MIN_VALUE);
        // 这里要注意的是 第一个也可以选/不选, 这里选择一个数字进行开始
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(dfs(nums, k , i) , max);
        }
        return max;
    }

    private int dfs(int[] nums, int k, int curIndex) {
        if (curIndex > nums.length - 1){
            // 超出长度了，返回为0
            return 0;
        }
        if (memory[curIndex] != Integer.MIN_VALUE){
            return memory[curIndex];
        }

        int max = Integer.MIN_VALUE;
        // 说白了就是一直在找 固定线段上的最大值，区域间的最大值。
        // 在K的范围内进行选择 一直延申
        for (int i = 1; i <= k; i++) {
            int nextIndex = curIndex + i ;
            max = Math.max(nums[curIndex] + dfs(nums, k , nextIndex), max);
        }
        // 或者 选择 只要自己， 不要后面的
        max = Math.max(nums[curIndex], max);
        return memory[curIndex] = max;
    }

    public static void main(String[] args) {
//        int[] nums = {10, 2, -10, 5, 20};
//        int k = 2;
//        int[] nums = {-1,-2,-3};
//        int k = 1;
        int[] nums = {10,-2,-10,-5,20};
        int k = 2;
        LeetCode1696 leetCode1696 = new LeetCode1696();
        System.out.println(leetCode1696.constrainedSubsetSum(nums, k));
    }
}
