package baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/14 0014.
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 输入描述:

 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）


 输出描述:

 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1

 输入例子:

 10
 10 10 10 10 20 20 30 30 40 40

 输出例子:

 30
 */
public class B_1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n>50||n<0)
        {
            return;
        }
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
            if (prices[i]>1000||prices[i]<0)
                return;
        }
        Arrays.sort(prices);
        int lecel = 0;
        for (int i = 0; i < n-1; i++) {
            if (prices[i]<prices[i+1])
                lecel++;
            if (lecel == 2) {
                System.out.print(prices[i + 1]);
                break;
            }
        }
        if(lecel < 2) {
            System.out.print(-1);

        }
    }
}
