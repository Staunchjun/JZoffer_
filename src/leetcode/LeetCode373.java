package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //枚举 塞优先队列 取前 K 个
        // 一直维持K 个
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                int sum1 = ints[0] + ints[1];
                int sum2 = t1[0] + t1[1];
                // 队列由大到小 排列， 每次 poll 最大的出去，保证里面的K个最小
                return -(sum1 - sum2);
            }
        });
        // 两个优化点 一个是内存 一个是时间
        // 先枚举把 ， 注意，这两个都是升序了，空间优化可以维持K个，时间优化待定
        for (int value : nums1) {
            int cnt = 0;
            for (int i : nums2) {
                // 判断下最小堆的最大值是否 小于目标，如果是，则没必要放进去了
                int sum = value + i;
                if (priorityQueue.size() < k) {
                    priorityQueue.add(new int[]{value, i});
                }else {
                    assert priorityQueue.peek() != null;
                    if (priorityQueue.peek()[0] + priorityQueue.peek()[1] > sum){
                        priorityQueue.poll();
                        priorityQueue.add(new int[]{value, i});
                    }else{
                        // 由于是升序的，后面的肯定比这个都大，那就没有比较的必要了，直接退出
                        break;
                    }
                }
            }
        }
        List<List<Integer>> rets = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            int[] data = priorityQueue.poll();
            List<Integer> ret = new ArrayList<>();
            ret.add(data[0]);
            ret.add(data[1]);
            rets.add(ret);
        }
        return rets;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        LeetCode373 leetCode373 = new LeetCode373();
        System.out.println(leetCode373.kSmallestPairs(nums1, nums2, k));
    }
}
