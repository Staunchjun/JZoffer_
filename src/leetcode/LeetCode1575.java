package leetcode;

import java.util.Arrays;

public class LeetCode1575 {

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] memo = new int[locations.length + 1][fuel + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        int ret =  dfs(locations, start, finish, fuel, memo);
        ret %= 1000000007;
        return ret;
    }

    private int dfs(int[] locations, int start, int finish, int fuel, int[][] memo) {
        // 如果油已经没有了，则return, 这里fuel不能等于0
        if (fuel < 0) {
            return 0;
        }
        // 如果已经走过了 则不需要再遍历了
        if (memo[start][fuel] != -1) {
            return memo[start][fuel];
        }
        int ans = 0;
        // 如果 现在已经是到达目标，则结果+1，有可能还有油可以来回横跳，所以不退出
        if (start == finish) {
            ans++;
        }
        // 经过任意城市超过一次
        for (int i = 0; i < locations.length; i++) {
            // 任意一个城市 j ，满足  j != i 且 0 <= j < locations.length
            if (i == start) {
                continue;
            } else {
                // 任意选择城市出发啦
                ans += dfs(locations, i, finish, fuel - Math.abs(locations[i] - locations[start]), memo);
            }
        }
        return memo[start][fuel] = ans;
    }

    public static void main(String[] args) {
        int[] locations = {2, 3, 6, 8, 4};
        int start = 1, finish = 3, fuel = 5;
        LeetCode1575 leetCode1575 = new LeetCode1575();
        System.out.println(leetCode1575.countRoutes(locations, start, finish, fuel));
    }
}
