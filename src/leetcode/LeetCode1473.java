package leetcode;

public class LeetCode1473 {
    int m, n;
    // 这里有个坑，不能用Integer.MAX_VALUE，
    // 如果使用了Integer.MAX_VALUE, 后面return后，进行相加则直接变为负数
    int MAX_VALUE = 10000001;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m;
        this.n = n;
        // 用lastColor代替houses[curIndex - 1]可以不用拷贝过多的临时houses出来，不然这里会爆内存
        // 这里最好添加记忆化，不然后面会超时。 state[curIndex][lastColor][target] = minCost, 默认全部为0
        int[][][] state = new int[m + 1][n + 1][target + 1];
        int res = backtrack(houses, cost, target, 0, -1, state);
        return res == MAX_VALUE ? -1 : res;
    }

    private int backtrack(int[] houses, int[][] cost, int target, int curIndex, int lastColor, int[][][] state) {
        if (lastColor != -1 && state[curIndex][lastColor][target] > 0) {
            return state[curIndex][lastColor][target];
        }
        // 判断 当前是否都已经走完
        if (curIndex >= m) {
            // 如果走完了，且target也刚好消费完则返回0
            if (target == 0) {
                return 0;
            }
            // 否则 返回无穷大的值
            // 如果使用了Integer.MAX_VALUE, 后面return后，进行相加则直接变为负数
            return MAX_VALUE;
        }
        // 如果target消耗完了后， index还有，则需要判断后面的是否都一样，如果都一样，则不需要搞了
        if (target == 0) {
            int res = 0;
            int tempIndex = curIndex;
            while (tempIndex < m) {
                if (houses[tempIndex] == 0) {
                    res += cost[tempIndex][lastColor - 1];
                } else if (houses[tempIndex] != lastColor) {
                    return MAX_VALUE;
                }
                tempIndex++;
            }
            return res;
        }
        int res = MAX_VALUE;
        if (houses[curIndex] != 0) {
            if (houses[curIndex] != lastColor) {
                res = Math.min(res, backtrack(houses, cost, target - 1, curIndex + 1, houses[curIndex], state));
            } else {
                res = Math.min(res, backtrack(houses, cost, target, curIndex + 1, lastColor, state));
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (i == lastColor) {
                    res = Math.min(res, cost[curIndex][i - 1] + backtrack(houses, cost, target, curIndex + 1, i, state));
                } else {
                    res = Math.min(res, cost[curIndex][i - 1] + backtrack(houses, cost, target - 1, curIndex + 1, i, state));
                }
            }
        }
        if (lastColor != -1) {
            state[curIndex][lastColor][target] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1473 leetCode1473 = new LeetCode1473();
        int[] houses = {0, 0, 0, 0, 0};
        int[][] cost = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        int m = 5;
        int n = 2;
        int target = 3;
        System.out.println(leetCode1473.minCost(houses, cost, m, n, target));

    }
}
