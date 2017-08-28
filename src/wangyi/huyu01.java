package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/26.
 * 66.7%
 */
public class huyu01 {
    public static void main(String[] ags)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] eLong = new int[n];
        int[] yShi = new int[m];
        for (int i = 0; i < n; i++) {
            eLong[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            yShi[i] = scanner.nextInt();
        }
        Arrays.sort(eLong);
        Arrays.sort(yShi);
        int sum = -1;
        for (int i = 0,j = 0; i <n || j<m ;) {
            if (yShi[j] >= eLong[i])
            {
                sum += yShi[j];
                i++;
            }else
            {
                j++;
            }
            if (i == n)
            {
                break;
            }
        }
        if (sum == 0)
            sum = -1;
        System.out.println(sum);
    }
}
