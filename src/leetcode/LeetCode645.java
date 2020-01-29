package leetcode;

public class LeetCode645 {
    public static void main(String[] args) {
        LeetCode645 leetCode645 = new LeetCode645();
        /**
         * 集合 S 包含从1到 n 的整数
         * 看题目啊！！！！！是1到n，即1，2，3，4，5... 不会有 3，4，5这样的
         * 读题目啊啊啊啊啊！！！
         *
         * 输出也是有要求的啊啊啊啊！！！要读题目啊啊啊啊
         * 你的任务是首先寻找到重复出现的整数，再找到丢失的整数
         */
//        int[] res = new int[]{1, 2, 2, 4, 5};
        int[] res = new int[]{1, 2};
        int[] result = leetCode645.findErrorNums(res);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] nu = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nu[nums[i] - 1]++;
        }
        for (int i = 0; i < nu.length; i++) {
            if (nu[i] == 0) {
                res[1] = i + 1;
            } else if (nu[i] == 2) {
                res[0] = i + 1;
            }
        }
        return res;
    }
}
