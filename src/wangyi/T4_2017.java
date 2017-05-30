package wangyi;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/30.
 * 一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，
 * 那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
 BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
 AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
 你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
 */
public class T4_2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input1 = scanner.nextInt();
            System.out.print(findBlcakString(input1));

        }
    }

    private static long findBlcakString(int input1) {
        long[] num = new long[input1 +1];
        num[1] = 3;
        num[2] = 9;
        for (int i = 3; i <= input1; i++) {
            num[i] = 2*num[i-1] +num[i-2];
        }

        return num[input1];
    }
}
