package wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/4.
 * 在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值
 * 输入描述:
 * 每个测试输入包含1个测试用例，第一行包括两个整数 N 和 D :
 * 3 <= N <= 100
 * 1 <= D <= N
 * 接下来有N行，每行N个数字d:
 * 0 <= d <= 100
 * 输出描述:
 * 输出一个整数，表示找到的和的最大值
 * 输入例子:
 * 4 2
 * 87 98 79 61
 * 10 27 95 70
 * 20 64 73 29
 * 71 65 15 0
 * 输出例子:
 * 193
 */
public class PG_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            int[][] nums = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            int max = 0;
            //确定各方向的第一个值的索引
            for (int k = 0; k < N; k++) {
                //确定各方向连续D个值的开始索引
                for (int begin = 0; begin <= N - D; begin++) {
                    //横
                    int hsum = 0;
                    //竖
                    int ssum = 0;
                    //左上到右下1
                    int lsum1 = 0;
                    //左上到右下2
                    int lsum2 = 0;
                    //右上到左下1
                    int rsum1 = 0;
                    //右上到左下2
                    int rsum2 = 0;
                    //开始求各方向连续D个数的和
                    for (int m = 0; m < D; m++) {
                        hsum += nums[k][begin + m];
                        ssum += nums[begin + m][k];
                        if ((k + D + begin) <= N) {
                            lsum1 += nums[k + begin + m][begin + m];
                            //避免1和2重复求k=0时的和
                            if (k != 0) {
                                lsum2 += nums[begin + m][k + begin + m];
                                rsum2 += nums[k + begin + m][N - 1 - begin - m];
                            }
                        }
                        if ((N - k - begin - D) >= 0) {
                            rsum1 += nums[m + begin][N - 1 - k - begin - m];
                        }
                    }
                    if (hsum > max)
                        max = hsum;
                    if (ssum > max)
                        max = ssum;
                    if (lsum1 > max)
                        max = lsum1;
                    if (lsum2 > max)
                        max = lsum2;
                    if (rsum1 > max)
                        max = rsum1;
                    if (rsum2 > max)
                        max = rsum2;
                }
            }
            System.out.println(max);
        }
    }
}
