package company.souhu;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/28.
 */
public class souhu01 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        int temp = 2;
        int flag = a[temp];
        for (int i = 3; i < m; ) {
            int num = a[temp];
            for (int j = 1; j <= num ; j++) {
                if (flag == 1);
            }
        }


    }
}
