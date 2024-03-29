package company.wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/4.
 * 在一条无限长的跑道上，有N匹马在不同的位置上出发开始赛马。
 * 当开始赛马比赛后，所有的马开始以自己的速度一直匀速前进。
 * 每匹马的速度都不一样，且全部是同样的均匀随机分布。
 * 在比赛中当某匹马追上了前面的某匹马时，
 * 被追上的马就出局。
 * 请问按以上的规则比赛无限长的时间后，赛道上剩余的马匹数量的数学期望是多少
 输入描述:
 每个测试输入包含1个测试用例
 输入只有一行，一个正整数N
 1 <= N <= 1000
 输出描述:
 输出一个浮点数，精确到小数点后四位数字，表示剩余马匹数量的数学期望
 输入例子:
 1
 2
 输出例子:
 1.0000
 1.5000
 */
public class PG_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double sum = 0;
            int n = scanner.nextInt();
            for (double i = 0; i < n; i++) {
                sum = sum + 1.0/(i+1);
            }
            System.out.println(String.format("%.4f", sum));
        }
    }
}
