package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode46 {
    private static int length = 0;
    private final List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        LeetCode46 leetCode46 = new LeetCode46();
        for (List<Integer> list : leetCode46.permute(nums)) {
            System.out.println("Print:");
            for (Integer i : list) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

    private List<List<Integer>> permute(int[] nums) {
        length = nums.length;
        if (length <= 0) {
            return res;
        }
        /**
         * 这里选择栈的好处在于push pop就完事了
         */
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
