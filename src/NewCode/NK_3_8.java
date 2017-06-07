package NewCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/6.
 * 小牛牛是牛牛王国的将军,为了训练出精锐的部队,
 * 他会对新兵进行训练。
 * 部队进入了n个新兵,
 * 每个新兵有一个战斗力值和潜力值,
 * 当两个新兵进行决斗时,总是战斗力值高的获胜。
 * 获胜的新兵的战斗力值就会变成对手的潜力值 +
 * 自己的战斗力值 - 对手的战斗力值。败者将会被淘汰。
 * 若两者战斗力值一样,则会同归于尽,双双被淘汰(
 * 除了考察的那个新兵之外，其他新兵之间不会发生战斗) 。
 * 小牛牛想知道通过互相决斗之后新兵中战斗力值+
 * 潜力值最高的一个可能达到多少,你能帮助小牛牛将军求出来吗?
 输入描述:
 输入包括n+1行,第一行包括一个整数n(1 ≤ n ≤ 10^5);
 接下来的n行,每行两个整数x和y(1 ≤ x,y ≤ 10^9)
 输出描述:
 输出一个整数,表示新兵中战斗力值+潜力值最高的一个能达到多少。
 输入例子:
 2
 1 2
 2 1
 输出例子:
 4
 */
public class NK_3_8 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        List<long[]> persons = new ArrayList<long[]>();
        long add = 0;
        for (int i = 0; i < n; i++) {
            long[] person = new long[2];
            long fighting = scanner.nextInt();
            long potential= scanner.nextInt();
            person[0] = fighting;
            person[1] = potential;
            persons.add(person);
            if (potential - fighting >= 0)
            add += (potential - fighting);
        }
        long maxV = Integer.MIN_VALUE;
        for (long[] p :persons)
        {
            long temp;
            if (p[0]<p[1])
            {
              temp = add - (p[1]-p[0])+p[1]+p[0];
            }
            else {
                temp = add+p[1]+p[0];
            }
            if (temp > maxV )
            {
                maxV = temp;
            }
        }
        System.out.print(maxV);
    }
}
