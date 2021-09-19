package company.Pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/1.
 */
//company.alibaba.cepin  无序数组 包含 正数 负数 0 求出 3 个数的最大乘积
public class pinduoduo1 {
    public static  void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] A = new long[num];
        if (num < 3)
            return;
        for (int i = 0; i < num; i++) {
            A[i] = sc.nextInt();
        }

        //主要代码   注意这里包含负数，两个最小负数+一个最大正数可以为最大   三个最大正数可以为最大
        Arrays.sort(A);

        long max1 = A[num-1];
        long max2 = A[num-2];
        long max3 = A[num-3];

        long min1 = A[0];
        long min2 = A[1];

        //1：先考虑全部为正数 或者全部为负数
        long max = Integer.MIN_VALUE;
        if (max <  max1*max2*max3)
            max =  max1*max2*max3;
        //2:考虑一个最大为正数，两个为负数
        if (max < max1*min1*min2)
            max = max1*min1*min2;

        System.out.print(max);
        sc.close();

    }
}
