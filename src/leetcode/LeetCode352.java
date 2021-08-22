package leetcode;

import java.util.*;

public class LeetCode352 {
    /**
     * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
     *
     * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
     *
     * [1, 1]
     * [1, 1], [3, 3]
     * [1, 1], [3, 3], [7, 7]
     * [1, 3], [7, 7]
     * [1, 3], [6, 7]
     *
     */
    static class SummaryRanges {
        // k: start v: end
        TreeMap<Integer, Integer> blocks;
        // k: end v: start
        TreeMap<Integer, Integer> reverseBlocks;
        /** Initialize your data structure here. */
        public SummaryRanges() {
            blocks = new TreeMap<>(Comparator.comparingInt(integer -> integer));
            reverseBlocks = new TreeMap<>(Comparator.comparingInt(integer -> integer));
        }

        public void addNum(int val) {
            // [1,8] 插入 5
            for (Map.Entry<Integer, Integer> entry : blocks.entrySet()) {
                int start =  entry.getKey();
                int end = entry.getValue();
                if (val >= start && val <= end){
                    return;
                }
            }

            //1： [1,1] [3,3] -> 插入2 & 2： [1,3], [5,6] 插入 433
            int start = val + 1;
            if (blocks.containsKey(start)){
                blocks.put(val, blocks.get(start));
                reverseBlocks.put(blocks.get(start), val);
                blocks.remove(start);
            }
            int end = val - 1;
            if (reverseBlocks.containsKey(end)){
                reverseBlocks.put(val, reverseBlocks.get(end));
                blocks.put(reverseBlocks.get(end), val);
                reverseBlocks.remove(end);
            }

            // 合并把
            if (blocks.containsKey(val) && reverseBlocks.containsKey(val)){
                int blockEnd = blocks.get(val);
                int blockStart = reverseBlocks.get(val);
                blocks.remove(val);
                reverseBlocks.remove(val);
                blocks.put(blockStart, blockEnd);
                reverseBlocks.put(blockEnd, blockStart);
                return;
            }

            reverseBlocks.put(val, val);
            blocks.put(val, val);
        }

        public int[][] getIntervals() {
            int[][] rets = new int[blocks.size()][];
            int cnt = 0;
            for (Map.Entry<Integer, Integer> entry : blocks.entrySet()) {
                int[] ret = new int[2];
                ret[0] = entry.getKey();
                ret[1] = entry.getValue();
                rets[cnt++] = ret;
            }
            return rets;
        }
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(6);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(6);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(0);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(4);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(8);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(7);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(6);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(4);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(7);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(5);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
    }
}
