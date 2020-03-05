package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int absVal = Math.abs(nums[i]);
            nums[absVal - 1] = -Math.abs(nums[absVal - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            /**
             * 因为下标对应的数字的都已经通过上面变成负数了，说明这个index是存在数字的
             * 那么还是为正数的index就是没有一个index可以使他变成负数
             * 因为存在两个index指向同一个地方，导致它变为正数
             * 细品细品再细品
             */
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode448 leetCode448 = new LeetCode448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(Arrays.deepToString(leetCode448.findDisappearedNumbers(nums).toArray()));
    }
}
