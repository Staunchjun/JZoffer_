package leetcode_dp;

/**
 * Created by Administrator on 2017/6/27 0027.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class l13 {
    public int climbStairs(int n) {
        int ppre = 0;
        int pre = 1;
        int cur = 0;
        while (n-- > 0) {
            cur = ppre + pre;
            ppre = pre;
            pre = cur;
        }
        return cur;
    }
}
