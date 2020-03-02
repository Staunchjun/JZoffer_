package leetcode;

import java.util.Arrays;

public class LeetCode561 {
    /**
     * 贪心就完事了
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
