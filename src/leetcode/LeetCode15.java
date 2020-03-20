package leetcode;

import java.util.*;

public class LeetCode15 {
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> ress = new HashSet<>();
        if (nums.length == 0) {
            return new ArrayList<>(ress);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            Stack<Integer> res = new Stack<>();
            int sum = 0;
            sum += nums[i];
            res.add(nums[i]);
            map.put(nums[i], map.get(nums[i]) - 1);
            for (int j = i + 1; j < nums.length; j++) {
                res.add(nums[j]);
                map.put(nums[j], map.get(nums[j]) - 1);
                sum += nums[j];
                int target = -sum;
                if (map.getOrDefault(target, 0) != 0) {
                    res.add(target);
                    List<Integer> integers = new ArrayList<>(res);
                    Collections.sort(integers);
                    ress.add(integers);
                    res.pop();
                }
                res.pop();
                sum -= nums[j];
                map.put(nums[j], map.get(nums[j]) + 1);
            }
            res.pop();
            sum -= nums[i];
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        return new ArrayList<>(ress);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        /**
         * 排序 找到左边为负数的，右边为正数的，left全部为负数，right 全部为正数
         */
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            /**
             * 如果当前数字大于0，则三数之和一定大于0，所以结束循环
             */
            if (nums[i] > 0) {
                break;
            }
            /**
             * 碰到重复的直接跳过即可
             */
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            /**
             * right的为正数、left的为负数，极端情况下，right为负数，那就不用玩了
             */
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]){
                        /**
                         * 左边碰到一样的，一直跳过
                         */
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]){
                        /**
                         * 右边碰到一样的，一直跳过
                         */
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0){
                    L++;
                }
                else R--;
            }
        }
        return ans;
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例：
     * <p>
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        LeetCode15 leetCode15 = new LeetCode15();
        System.out.println(Arrays.deepToString(leetCode15.threeSum(nums).toArray()));
    }
}
