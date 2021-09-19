package leetcode;

import java.util.*;

public class LeetCode491 {
    Set<List<Integer>> rets = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        backtrack(nums, 0, Integer.MIN_VALUE, new Stack<Integer>());

        return new ArrayList<>(rets);
    }

    private void backtrack(int[] nums, int curIndex, int lastValue, Stack<Integer> ret) {
        if (ret.size() >= 2) {
            rets.add(new ArrayList<>(ret));
        }
        // 回溯把
        for (int i = curIndex; i < nums.length; i++) {
            if (lastValue > nums[i]) {
                continue;
            }
            // 任意选择一个
            ret.push(nums[i]);
            // 进行回溯
            backtrack(nums, i + 1, nums[i], ret);
            // 撤销之前的选择
            ret.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
//        int[] nums = {4,4,3,2,1};
        LeetCode491 leetCode491 = new LeetCode491();
        System.out.println(Arrays.toString(leetCode491.findSubsequences(nums).toArray()));
    }
}
