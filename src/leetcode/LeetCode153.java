package leetcode;

/**
 * 参考：https://www.cxyxiaowu.com/310.html
 */
public class LeetCode153 {
    public static int findMin(int[] nums) {
        if (nums.length == 0){
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
            if (  nums[right] < nums[mid]) {
               left = mid + 1;
            } else {
                right = mid;
            }
        }
        /**
         * 3. 最后的值清理
         */
        return nums[left];
    }

    public static void main(String[] args) {
        int[] arrs0 = new int[]{4,5,6,7,2,3};
        int[] arrs = new int[]{4,5,6,7,0,1,2};
        int[] arrs1 = new int[]{3,4,5,1,2};
        int[] arrs2 = new int[]{3};
        int[] arrs3 = new int[]{};
        int[] arrs4 = new int[]{0,1,2,4,5,6,7};
        System.out.println(findMin(arrs0));
        System.out.println(findMin(arrs));
        System.out.println(findMin(arrs1));
        System.out.println(findMin(arrs2));
        System.out.println(findMin(arrs3));
        System.out.println(findMin(arrs4));
    }
}
