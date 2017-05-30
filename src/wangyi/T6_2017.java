package wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/30.
 * 小易是一个数论爱好者，并且对于一个数的奇数约数十分感兴趣。
 * 一天小易遇到这样一个问题： 定义函数f(x)为x最大的奇数约数，x为正整数。
 * 例如:f(44) = 11.
 现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
 例如： N = 7
 f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
 小易计算这个问题遇到了困难，需要你来设计一个算法帮助他。

 对于偶数的一直除2得到的奇数就是了。对于奇数的就是自己。
 */
public class T6_2017 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input>1000000000||input<1)
            {
                return;
            }
            long sum = 0;
            for (long i=input;i>0;i=i/2)
            {
                long temp = (i+1)/2;
                sum +=temp*temp;
            }
            System.out.print(sum);
        }
//只能通过60%。。。。。。。。。。。。
        private static long count(int i) {
            long sum = 0;
            for (int j = 1; j <= i; j++) {
                {
                    sum = sum + f(j);
                }
            }
            return sum;
        }
        private static long f(int i)
        {
            if ((i+1)%2 == 0)
            {
                return i;
            }
            else {
                int a = 0;
                do {
                    a = i/2;
                    i = a;
                }while (a%2 == 0 );
                return i;
            }
        }
    }


