package leetcode_dp;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/21 0021.
 * There are N children standing in a line. Each child is
 * assigned a rating value.
 * You are giving candies to these children subjected to the following
 * requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their
 * neighbors.
 * <p>
 * What is the minimum candies you must give?
 */
public class l3 {
    public int candy(int[] ratings) {
        if (ratings.length <= 0) return 0;

        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);
        //dp[i] = dp[i-1]+1 i比i-1的rating高
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) dp[i] = dp[i - 1] + 1;
        }
        //从右到左
        for (int i = ratings.length - 2; i >= 0; i--) {
            //已经比拿的糖比较多的就不给了
            if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int num : dp
                ) {
            sum += num;
        }
        return sum;
    }
}
