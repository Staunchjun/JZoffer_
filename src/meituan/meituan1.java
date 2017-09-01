package meituan;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/31.
 */
public class meituan1 {
    public  static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
         a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int max = 0;
        for (int i = n-1; i >= 0; i--) {
                int sum = 0;
            for (int j = 0; j <=i ; j++) {
                sum += a[j];
            }
            if (sum % 5 == 0)
            {
                max = i;
            }
        }
        System.out.println(max);

    }
}
