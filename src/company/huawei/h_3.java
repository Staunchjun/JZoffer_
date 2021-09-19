package company.huawei;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/6.
 * 出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入）
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * 输出描述:
 * 输出该数值的十进制字符串。
 * 输入例子:
 * 0xA
 * 输出例子:
 * 10
 */
public class h_3 {
    //Method 2
    static class Main {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            while (sc.hasNext()) {

                StringBuffer sb = new StringBuffer();

                sb.append(sc.next());

                //String str=sc.next();

                String str = sb.reverse().substring(0, sb.length() - 2);

                char ch[] = str.toCharArray();

                int sum = 0;

                for (int i = 0; i < ch.length; i++) {

                    if (ch[i] >= 'A' && ch[i] <= 'F') {


                        sum += (Integer.valueOf(ch[i]) - 55) * Math.pow(16, i);

                    } else {


                        sum += (Integer.valueOf(ch[i]) - 48) * Math.pow(16, i);

                    }

                }

                System.out.println(sum);

                // System.out.println(Integer.valueOf('6'));

            }

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine().substring(2);
            System.out.println(Integer.parseInt(str, 16));
        }
    }

}
