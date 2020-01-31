package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1313 {
    public int[] decompressRLElist(int[] nums) {
        if (nums.length % 2 != 0){
            /**
             * 题目没有说错误的，就先别管把
             */
            return new int[1];
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i=i+2) {
            int num = nums[i];
            int digital = nums[i+1];
            for (int j = 0; j < num; j++) {
                result.add(digital);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode1313 leetCode1313 = new LeetCode1313();
        int[] nums = new int[]{1,2,3,4};
        for (int i:leetCode1313.decompressRLElist(nums)) {
            System.out.print(i+System.lineSeparator());
        }
    }
}
