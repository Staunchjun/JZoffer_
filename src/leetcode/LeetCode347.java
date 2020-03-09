package leetcode;

import java.util.*;

public class LeetCode347 {
    /**
     * 用大顶堆就完事了，这里用优先队列代替
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        /**
         * 大顶堆的排列顺序由小到大，每次剔除最小的
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return count.get(integer).compareTo(count.get(t1));
            }
        });

        /**
         * Hashmap 走一遍 n
         */
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        /**
         * 用小顶堆走一遍优于O(n log n)
         */
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(e.getKey());
            } else {
                if (count.get(priorityQueue.peek()) < e.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(e.getKey());
                }
            }
        }
        return new ArrayList<>(priorityQueue);
    }

    /**
     * /**
     * * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     * *
     * * 示例 1:
     * *
     * * 输入: nums = [1,1,1,2,2,3], k = 2
     * * 输出: [1,2]
     * * 示例 2:
     * *
     * * 输入: nums = [1], k = 1
     * * 输出: [1]
     * * 说明：
     * *
     * * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     */
    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {3,0,1,0};
//        int k = 2;
        int k = 1;
        System.out.println(Arrays.deepToString((new LeetCode347()).topKFrequent(nums, k).toArray()));
    }
}
