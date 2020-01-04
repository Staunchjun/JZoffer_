package leetcode;

public class LeetCode154 {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        /**
         * 搜索范围
         */
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        /**
         * 二分法模板
         */
        while (left < right) {
            /**
             * 1. 使用左中位数
             */
            int mid = (left + right) >>> 1;
            /**
             * 2. 条件2分 a、b debug 用
             */
            int a = nums[right];
            int b = nums[mid];
            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else if (nums[right] > nums[mid]) {
                right = mid;
            } else {
                right--;
            }
        }
        /**
         * 3. 最后的值清理
         */
        return nums[left];
    }
}
