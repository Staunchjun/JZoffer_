package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode47 {
    private static int length = 0;
    private final List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 2};
        int[] nums = new int[]{3, 3, 0, 3};
        LeetCode47 leetCode47 = new LeetCode47();
        for (List<Integer> list : leetCode47.permuteUnique(nums)) {
            System.out.println("Print:");
            for (Integer i : list) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

    private List<List<Integer>> permuteUnique(int[] nums) {
        length = nums.length;
        if (length <= 0) {
            return res;
        }
        /**
         * 这里选择栈的好处在于push pop就完事了
         * 这里必须要排序，不然下面无法判断重复
         * 重复的原因是选择了相同的元素
         */
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        backtrack(nums, new Stack<>(), visited);
        return res;
    }

    private void backtrack(int[] candidates, Stack<Integer> preRes, int[] visited) {
        /**
         * 结束条件判断
         * 要 new 一个ArrayList，不然一直用的都是一个
         */
        if (preRes.size() == length) {
            res.add(new ArrayList<>(preRes));
            return;
        }
        /**
         * 开始做选择拉，排列组合.....
         */
        for (int i = 0; i < length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && (visited[i - 1]) == 1) {
                continue;
            }
            if (visited[i] == 1) {
                continue;
            }
            int chooseVal = candidates[i];
            /**
             * 选择操作
             */
            visited[i] = 1;
            preRes.push(chooseVal);
            /**
             * 下一轮选择
             */
            backtrack(candidates, preRes, visited);
            /**
             * 撤销选择操作， 你懂的
             */
            visited[i] = 0;
            preRes.pop();
        }
    }
}
