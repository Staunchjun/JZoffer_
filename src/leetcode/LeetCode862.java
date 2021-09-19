package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode862 {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // 这里注意，可能超大，需要long
        // 前缀和
        // 任意子序列和 用 i-j 的和 为 preSum[j] - preSum[i]
        long[] preSum = new long[n+1];
        for (int i = 0; i < n; ++i){
            preSum[i+1] = preSum[i] + (long) nums[i];
        }
        // 求最小长度，那就滑窗呗，可变滑窗，从小到大，有一个符合就ok
        // 优化-> 动态可变滑窗 也需要提前终止
        // 1. 若 preSum[r] - preSum[l] >= K，
        // 则 当 preSum[r + 1] - preSum[l] >= K 时 ， r + 1 -l > r - i 不符合要求是最短
        // 所以 l++ 就可以了。
        // 2. 若 preSum[r] - preSum[x1] >= K，-> preSum[r] - K >= preSum[x1]，
        // 当  preSum[x2] <= preSum[x1], 且 x2 > x1 则
        // 由于 preSum[r] - K >= preSum[x1] >= preSum[x2]
        // 表示 不可能 用 x2.
        // 要实现一个可变的滑窗，那就用 双端队列吧。队列长度就是结果。
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        int ans = Integer.MAX_VALUE;
        for (int r = 1; r < preSum.length; r++) {
            // r = largest x with P[x] <= P[y] - K;
            while (!deque.isEmpty() && (preSum[r] <= preSum[deque.peekLast()])){
                long x =  preSum[r];
                long y = preSum[deque.peekLast()];
                deque.removeLast();
            }
            while (!deque.isEmpty() && (preSum[r] - preSum[deque.peekFirst()]) >= k){
                // 符合要求
                ans = Math.min(ans, r - deque.peekFirst());
                deque.pollFirst();
            }
            // 入队
            deque.addLast(r);
        }

        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static void main(String[] args) {
        LeetCode862 leetCode862 = new LeetCode862();
        int[] A = {2, -1, 2};
        int K = 3;
        System.out.println(leetCode862.shortestSubarray(A, K));
    }
}
