package leetcode;

import java.util.Arrays;

public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);
        int start = 0;
        int end = 0;
        boolean isFirst = true;
        for (int i = 0; i < nums.length; i++) {
            if (temp[i] != nums[i]){
                if (isFirst){
                    start = i;
                    isFirst = false;
                }
                end = i;
            }
        }
        if (end == start){
            return 0;
        }
        return end - start + 1;
    }
}
