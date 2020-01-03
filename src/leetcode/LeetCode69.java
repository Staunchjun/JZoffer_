package leetcode;

/**
 * 参考：https://www.cxyxiaowu.com/310.html
 */
public class LeetCode69 {
    private static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        /**
         * 搜索范围 右边界肯定小于1/2
         */
        long left = 1;
        long right = x / 2;
        /**
         * 二分法模板
         */
        while (left < right) {
            /**
             * 1. 使用右中位数
             */
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            /**
             * 2. 条件2分，注意使用的是右中位数，使用左中位数会死循环
             * 注意：这里也可以使用square < x 的判断。
             * 但是需要考虑，怎么拿到上一个值的问题，使解答变得负责
             */
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        /**
         * 3. 最后的值清理
         */
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
