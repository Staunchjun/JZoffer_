package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;

public class LeetCode1402 {
    int[][] mem;
    int n ;
    public int maxSatisfaction(int[] satisfaction) {
        n = satisfaction.length;
        mem = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                mem[i][j] = -1;
            }
        }
        Arrays.sort(satisfaction);
        System.out.println(Arrays.toString(satisfaction));
        return backtrack(satisfaction, 0, 1, 0);
    }

    private int backtrack(int[] satisfaction, int start, int time, int dec) {
        if (start >= n){
            return 0;
        }
        // 如果这个已经搜索过了，直接返回结果。 mem[start][time]
        if (mem[start][time] != -1){
            return mem[start][time];
        }
        // 从下往上计算
        int maxnum = 0;
        // 遍历左树，选取最大 pick one
        maxnum = Math.max(maxnum, backtrack(satisfaction, start + 1, time + 1, dec + 1) + satisfaction[start] * time);
        for (int i = 0; i < dec; i++) {
            System.out.print(" ");
        }
        System.out.println("pick" + maxnum + " start:" + start + " time:" + time);
        // 遍历右树，选取最大 non-pick one time不变
        maxnum = Math.max(maxnum, backtrack(satisfaction, start + 1, time, dec + 1));
        for (int i = 0; i < dec; i++) {
            System.out.print(" ");
        }
        System.out.println("non-pick" + maxnum + " start:" + start + " time:" + time);
        return mem[start][time] = maxnum;
    }

    public static void main(String[] args) {
       int[] satisfaction = {-1,-8,0,5,-7};
       LeetCode1402 leetCode1402 = new LeetCode1402();
       System.out.println(leetCode1402.maxSatisfaction(satisfaction));
    }
}
