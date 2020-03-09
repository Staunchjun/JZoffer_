package leetcode;

import java.util.*;

public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /**
         * 这里不建议使用set去区分不同的数组，会有问题
         */
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, res, new Stack<Integer>());
        return new ArrayList<>(res);
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res, Stack<Integer> re) {
        /**
         * 无论啥结果都记录下来 ,注意，结果是可以有空集的
         */
//        if (re.size() != 0) {
            res.add(new ArrayList<>(re));
//        }
        for (int i = start; i < nums.length; i++) {
            /*和上个数字相等就跳过
             * i>start 即已经做了第一个选择，正在选择start+1个
             * 如果start+1 和 start重复了，就选择 start+1+1，如此类推
             * 防止选择一样的数字，所以核心就在于前面必须要排序
            **/
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            /**
             * 记录一个
             */
            re.push(nums[i]);
            /**
             * 继续走
             */
            backtrack(nums, i + 1, res, re);
            /**
             * 撤销做过的选择
             */
            re.pop();
        }
    }

    /**
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * <p>
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,2]
     * 输出:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        LeetCode90 leetCode90 = new LeetCode90();
        System.out.println(Arrays.deepToString(leetCode90.subsetsWithDup(nums).toArray()));
    }
}
