package leetcode;

public class LeetCode614 {
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // memo[i] 表示考虑抢劫 nums[i...n-1] 所能获得最大收益（不是说一定从 i 开始抢劫）
        int[] memo = new int[n];
        // 先考虑最简单的情况
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // memo[i] 的取值在考虑抢劫 i 号房子和不考虑抢劫之间取最大值
            memo[i] = Math.max(nums[i] + (i + 2 >= n ? 0 : memo[i + 2]), nums[i + 1] + (i + 3 >= n ? 0 : memo[i + 3]));
        }
        return memo[0];
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        /**
         * [1,2,3,1] dp[0,1,2,4,4]
         *  0 1 2 3
         *  dp[0] = 0;为空
         *  dp[1] = nums[0] = 1;只有一个
         *  dp[2] = max(dp[1],dp[0]+nums[1]) = 2;
         *  dp[1]表示到了第一个数字的最大获取金币数
         *  dp[0]+nums[1]表示，不拿第一个数，拿前一个最大加上当前的数字是否最大。
         *  即不选1，选择2。
         *  dp[3] = max(dp[2],dp[1]+nums[2]) = 4;
         *  这里dp[3]表示到了第三个数字的时候能够获取的最大金币数
         *  dp[1]表示到了第一个数字的最大获取金币数
         *  dp[1]+nums[2]则表示不拿数字2，拿前一个最大加上当前的数字看是否最大。
         *  即1，2，3，忽略数字2，取1，3，则结果为4->dp[1]+nums[2]
         *  dp[4] = max(dp[3],dp[2]+nums[3]) = 4;
         *  dp[2]+nums[3] 比 dp[3]小，则表明选择当前的数字加上前一个最大并不是最优的(不能选择相邻的，故是机上dp[2])
         *  最优的是不选择当前的数字，即保持dp[3]不变,
         *  注意：题目说的是你不能够选择相邻的数字，即表示，你要么空一个，要么空两个，反正不能同时选
         */
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[length];
    }
}
