package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode239 {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //单调队列里永远是单调递减，第一个是最大的23333
        Deque<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < k; i++) {
            if (!deque.isEmpty()) {
                // 必须要用等于，保证每次滑动必须更新单调队列
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
            }
            //记录index ，即单调队列记录所有的num单调递减的index
            //记录index有一个好处就是可以直接知道pollFirst是否已经不在滑动窗口里
            deque.offerLast(i);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty()) {
                // 必须要用等于，保证每次滑动必须更新单调队列
                while (!deque.isEmpty() && nums[deque.peekLast()]  <= nums[i]) {
                    deque.pollLast();
                }
            }
            deque.offerLast(i);
            //记录index有一个好处就是可以直接知道pollFirst是否已经不在滑动窗口里
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            //记录这个窗口里的最大值
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        LeetCode239 leetCode239 = new LeetCode239();
        System.out.println(leetCode239.maxSlidingWindow(nums, k));
    }

}
