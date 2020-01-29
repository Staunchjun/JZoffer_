package leetcode;

import java.util.PriorityQueue;

public class LeetCode703 {
    private PriorityQueue<Integer> priorityQueue = null;
    private int k;

    public static void main(String[] args) {
        LeetCode703 leetCode703 = new LeetCode703();
        int[] nums = new int[]{4, 5, 8, 2};
        leetCode703.KthLargest(3, nums);
        System.out.println(leetCode703.add(3));
        System.out.println(leetCode703.add(5));
        System.out.println(leetCode703.add(10));
        System.out.println(leetCode703.add(9));
        System.out.println(leetCode703.add(4));

    }

    private void KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }

    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
