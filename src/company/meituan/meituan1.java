package company.meituan;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

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
        HashMap hashMap = new HashMap();
        int k = scanner.nextInt();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
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
