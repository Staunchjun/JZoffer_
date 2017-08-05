package Pinduoduo;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/1.
 */
/*
*背包问题
j巧克力重量为w[j]
每个小朋友i拿到的巧克力大小为h[i]才会上台
* */
public class pinduoduo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] H = new int[n];
        for (int i = 0; i < n; i++) {
            H[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] W = new int[m];
        for (int i = 0; i < m; i++) {
            W[i] = sc.nextInt();
        }

        Arrays.sort(H);
        Arrays.sort(W);

        int sum = 0;

        for (int i = 0, j = 0; i < n && j < m; ) {
            if (W[j] >= H[i]) {
                sum++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        System.out.print(sum);
    }
}
