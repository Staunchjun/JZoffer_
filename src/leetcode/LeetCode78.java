package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode78 {
    private List<List<Integer>> ress = new ArrayList<>();
    private int len = 0;
    public List<List<Integer>> subsets(int[] nums) {
        len = nums.length;
        if (len == 0){
            return ress;
        }
        backtrack(nums,0, new Stack<>());
        return ress;
    }

    private void backtrack(int[] nums, int i, Stack<Integer> res) {
        /**
         * 任何结果都要记录, 当index 超出长度的时候就不用再做分支选择啦～
        **/
        ress.add(new ArrayList<>(res));
        if (i >= len){
            return;
        }
        /**
         * 开始做选择 这里的选择继承上一次选择的i
         */
        for (int j = i; j < len; j++) {
            /**
             * 随便选一个呗
             */
            res.push(nums[j]);
            backtrack(nums,j+1,res);
            /**
             * 恢复刚刚的选择
             */
            res.pop();
        }
    }

    public static void main(String[] args) {
       int[] nums = new int[]{1,2,3};
       LeetCode78 leetCode78 = new LeetCode78();
       System.out.print(Arrays.deepToString(leetCode78.subsets(nums).toArray()));
    }
}
