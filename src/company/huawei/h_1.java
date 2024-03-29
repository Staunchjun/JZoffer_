package company.huawei;


/**
 * Created by Administrator on 2017/6/6.
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
 * 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
 * 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
 * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * 输入描述:
 * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），
 * 表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
 * 输出描述:
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 * 输入例子:
 * 3
 * 10
 * 81
 * 0
 * 输出例子:
 * 1
 * 5
 * 40
 */

import java.util.Scanner;

public class h_1 {
    private static int blank;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            blank = scan.nextInt();
            int drink = 0;
            int remain;
            if (blank > 0 && blank <= 100) {
                if (blank == 1) {
                    drink = 0;
                } else if (blank == 2) {
                    drink = 1;
                }
                while (blank > 2) { //10,4,5
                    drink += blank / 3; //3 drink,4 drink
                    remain = blank % 3; //1 remain,1 remain
                    blank = blank / 3 + remain; //4 blank,2 blank
                    if (blank == 2) {
                        drink++;
                    }
                }
            }
            System.out.println(drink + "");
        }
    }
}

