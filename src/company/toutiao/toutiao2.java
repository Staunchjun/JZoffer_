package company.toutiao;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/22.
 */
public class toutiao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long max = 0;
        for (int qujian = 1; qujian <= n+1; qujian++) {
            for (int i = 0; i < n; i++) {
                int minValue = Integer.MAX_VALUE;
                int sum = 0;
                if (i+qujian-1>=n)
                    continue;
                for (int j = 0; j < qujian; j++) {
                    sum += a[i + j];
                    if (minValue > a[i + j]) {
                        minValue = a[i + j];
                    }
                }
                int res = sum * minValue;
                if (res > max) {
                    max = res;
                }
            }

        }
        System.out.println(max);
    }
}
