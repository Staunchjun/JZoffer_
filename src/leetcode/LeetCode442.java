package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode442 {
    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     * 找到所有出现两次的元素。
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     * 示例：
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [2,3]
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        /**
         * 用index作为hash值
         * 重点：有些元素出现两次而其他元素出现一次。
         * 因为里面的的值正常的是只出现一次，所以就用它的值去做Hash就行啦~，
         * 因为没有0，所以数字 1 对应的index 就是0，数字i对应的index 就是 i-1
         * 找到所有出现两次的元素。
         */
        for (int i = 0; i < nums.length; i++) {
            int absVal = Math.abs(nums[i]);
            int targetVal = nums[absVal - 1];
            if ( targetVal < 0){
                res.add(absVal);
            }else {
                nums[absVal - 1] = -targetVal;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode442 leetCode442 = new LeetCode442();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(Arrays.deepToString(leetCode442.findDuplicates(nums).toArray()));
    }
}
