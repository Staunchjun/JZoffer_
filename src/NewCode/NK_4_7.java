package NewCode;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/28 0028.
 *
 * 有一条无限长的纸带,分割成一系列的格子,最开始所有格子初始是白色。现在在一个格子上放上一个萌萌的机器人(
 * 放上的这个格子也会被染红),
 * 机器人一旦走到某个格子上,就会把这个格子涂成红色。现在给出一个整数n,机器人现在会在纸带上走n步。
 * 每一步,机器人都会向左或者向右走一个格子,两种情况概率相等。机器人做出的所有随机选择都是独立的。现在需要计算出最后纸带上红色格子的期望值。
 */
public class NK_4_7 {
    private static final int MOD = 1_000_000_007;
    public void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] dp = new int[k+1][n];
        dp[0][0] = dp[1][0] = 1;
        int[] temp =new int[n];
    }
}
