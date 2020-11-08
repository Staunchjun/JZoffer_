package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode698 {
    /**
     * 这道题的关键在于对回溯的剪枝，利用排序做回溯的剪枝
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        if (nums.length < k) {
            return false;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
        }
        if (ans % k != 0) {
            return false;
        }
        int tar = ans / k;
        boolean[] visited = new boolean[nums.length];
        int[] sumed = new int[k];
        Arrays.fill(sumed, tar);
        Arrays.sort(nums);
        /**
         * 暴力回溯 只要有一个是不能分组的，就返回false，只要能成功分组一次的就返回true
         */

        return backtrack1(visited, sumed, 0, nums, k);
    }

    private boolean backtrack1(boolean[] visited, int[] sumed, int index, int[] nums, int k) {
        if (index >= visited.length - 1){
            return true;
        }
        for (int j = 0; j < k; j++) {
            if (sumed[j] == nums[index] || sumed[j] - nums[index] >= nums[0]){
                sumed[j] -= nums[index];
                if(backtrack1(visited, sumed,index +1 , nums, k)){
                    return true;
                }
                sumed[j] += nums[index];
            }
        }

        /**
         * 没有搭配的就返回false呗
         */
        return false;
    }

    public static void main(String[] args) {
        LeetCode698 leetCode698 = new LeetCode698();
//        System.out.println(leetCode698.canPartitionKSubsets(new int[]{5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3}, 15));
//        System.out.println(leetCode698.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
//        System.out.println(leetCode698.canPartitionKSubsets(new int[]{10,10,10,7,7,7,7,7,7,6,6,6}, 3));
        System.out.println(leetCode698.canPartitionKSubsets(new int[]{4,5,3,2,5,5,5,1,5,5,5,5,5,5,5,5}, 14));
    }
}
