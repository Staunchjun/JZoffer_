package NewCode;
/**
 * Created by Administrator on 2017/6/6.
 * 给出一个区间[a, b]，计算区间内“神奇数”的个数。
 * 神奇数的定义：存在不同位置的两个数位，组成一个两位数（且不含前导0），
 * 且这个两位数为质数。
 * 比如：153，可以使用数字3和数字1组成13，13是质数，
 * 满足神奇数。同样153可以找到31和53也为质数，只要找到一个质数即满足神奇数。
 * 输入描述:
 * 输入为两个整数a和b，代表[a, b]区间 (1 ≤ a ≤ b ≤ 10000)。
 * 输出描述:
 * 输出为一个整数，表示区间内满足条件的整数个数
 * 输入例子:
 * 11 20
 * 输出例子:
 * 6
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NK_3_2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 11; i < 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) list.add(i);
        }
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            String s = String.valueOf(i);
            for (Integer e : list) {
                String s1 = String.valueOf(e / 10);
                String s2 = String.valueOf(e % 10);
                if (!s1.equals(s2)) {
                    if (s.indexOf(s1) != -1 && s.indexOf(s2) != -1) {
                        cnt++;
                        break;
                    }
                } else {
                    int index = s.indexOf(s1);
                    int d = s.indexOf(s2, index+1);
                    if (index != -1 && d  != -1) {
                        cnt++;
                        break;
                    }
                }
            }

        }
        System.out.println(cnt);
    }
}
