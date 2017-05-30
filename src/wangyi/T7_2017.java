package wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/27.
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 输入描述:
 输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果


 输出描述:
 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1

 输入例子:
 20

 输出例子:
 3

 和找丑数其实是同样道理，看剑指offer丑数，从一开始生成所有符合要求的数字
 */
public class T7_2017 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int[] step = new int[input+8];
        for (int i = 0; i < input+8; i++) {
            step[i] = Integer.MAX_VALUE;
        }
        step[6] = 1;
        step[8] = 1;
        for (int i = 6;i<input;i++)
        {
            if (step[i] == Integer.MAX_VALUE)continue;
            else {
                if (i+6<=input)
                {
                    step[i+6] = min(step[i]+1,step[i+6]);
                }
                if (i+8<=input)
                {
                    step[i+8] = min(step[i]+1,step[i+8]);
                }

            }
        }
        step[input] = (step[input] == Integer.MAX_VALUE ? -1:step[input]);
        System.out.print(step[input]) ;
        }

    private static int min(int i, int i1) {
        return i>i1?i1:i;
    }

}

