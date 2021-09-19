package company.wangyi;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/12.
 */
public class yd_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        //如果是偶数次   0+1 在顺序右边 0+2 在顺序左边
        if (a.length % 2 == 0) {
            for (int i = a.length - 1; i >= 1; i = i - 2) {
                System.out.print(a[i] + " ");
            }
            for (int i = 0; i <= a.length - 1; i = i + 2) {
                if (i == a.length - 2)
                    System.out.print(a[i]);
                else
                    System.out.print(a[i] + " ");
            }

        }
        //如果是奇数次   0+1 在顺序左边 0+2 在顺序右边
        else {
            for (int i = a.length - 1; i >= 0; i = i - 2) {
                System.out.print(a[i] + " ");
            }
            for (int i = 1; i <= a.length - 1; i = i + 2) {
                if (i == a.length - 2)
                    System.out.print(a[i]);
                else
                    System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }
}