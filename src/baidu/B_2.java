package baidu;
/**
 * Created by Administrator on 2017/6/14 0014.
 * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
 * 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？
 * 输入描述:
 * <p>
 * 输入一个正整数N, N <= 50。
 * <p>
 * 接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
 * <p>
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数表示度度熊最少需要走的距离。
 * <p>
 * 输入例子:
 * <p>
 * 4
 * 1 4 -1 3
 * <p>
 * 输出例子:
 * <p>
 * 4
 */

import java.util.Scanner;

public class B_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n > 50 || n < 0) {
            return;
        }
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
            if (Math.abs(prices[i]) > 100)
                return;
        }
        int sum1 = 0, sum2 = 0, max = 0, space1 = 0, space2 = 0;
        for (int i = 0; i < n - 3; i++) {
            int begin = prices[i];
            int mid = prices[i + 1];
            int end = prices[i + 2];
            int distance = Math.abs(mid - begin) + Math.abs(end - mid);
            space2 = Math.abs(end - mid);
            sum2 += space2;
            sum1 += distance;
            if (distance > max) {
                max = distance;
                space1 = Math.abs(mid - begin);
            }
        }
        System.out.print(sum1 - max + space1 - sum2 + space2);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N > 50 || N < 0) {
            return;
        }
        int[] PRICES = new int[N];
        for (int i = 0; i < N; i++) {
            PRICES[i] = sc.nextInt();
            if (Math.abs(PRICES[i]) > 100)
                return;
        }
        int SUM_DISTANCE = 0;
        for (int i = 0; i < N - 1; i++) {
            SUM_DISTANCE += Math.abs(PRICES[i + 1] - PRICES[i]);
        }
        int MAX_ABLE_DEL_DISTANCE = Integer.MIN_VALUE;
        for (int i = 1; i <= N - 2; i++) {
            int ABLE_DEL_DISTANCE = Math.abs(Math.abs(PRICES[i] - PRICES[i - 1]) + Math.abs(PRICES[i + 1] - PRICES[i]) - Math.abs(PRICES[i + 1] - PRICES[i - 1]));
            if (ABLE_DEL_DISTANCE > MAX_ABLE_DEL_DISTANCE)
                MAX_ABLE_DEL_DISTANCE = ABLE_DEL_DISTANCE;
        }
        System.out.print(SUM_DISTANCE - MAX_ABLE_DEL_DISTANCE);
    }
}