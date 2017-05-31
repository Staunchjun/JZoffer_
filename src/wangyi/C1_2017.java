package wangyi;

import java.util.Scanner;

/**
 * 01 背包問題的轉化
 * Created by Administrator on 2017/5/30.
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，
 * 假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
 * n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 */
public class C1_2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] item = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                item[i] = scanner.nextInt() >> 10;
                sum+=item[i];
            }
            // dp[j]表示在容量为j的情况下可存放的重量
            // 如果不放arr[i]重量为dp[j],如果放arr[i]重量为dp[j-arr[i]]+arr[i];
            int[] dp = new int[sum/2+1];
            for (int i = 0; i < n; i++) {
                for (int j = sum/2; j >= item[i] ; j--) {
                    dp[j] = Math.max(dp[j],dp[j-item[i]]+item[i]);
                }
            }
            System.out.print(Math.max(dp[sum/2],sum-dp[sum/2])<<10);
        }
    }
}
