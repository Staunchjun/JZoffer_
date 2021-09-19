package company.Pinduoduo;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/1.
 */
//Java 大数相乘
public class pinduoduo2 {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();


        int len1 = num1.length();
        int len2 = num2.length();

        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();

        // 对调
        for (int i = 0; i < len1 / 2; i++) {
            s1[i] += s1[len1 - 1 - i];
            s1[len1 - 1 - i] = (char) (s1[i] - s1[len1 - 1 - i]);
            s1[i] = (char) (s1[i] - s1[len1 - 1 - i]);
        }
        for (int i = 0; i < len2 / 2; i++) {
            s2[i] += s1[len2 - 1 - i];
            s2[len2 - 1 - i] = (char) (s2[i] - s2[len2 - 1 - i]);
            s2[i] = (char) (s2[i] - s2[len2 - 1 - i]);
        }
        multiply(s1,len1,s2,len2);
    }
    public static void multiply(char a[], int alen, char b[], int blen) {
        // 两数乘积位数不会超过乘数位数和+ 3位
        int csize = alen + blen + 3;
        // 开辟乘积数组
        int[] c = new int[csize];
        // 乘积数组填充0
        for (int ii = 0; ii < csize; ii++) {
            c[ii] = 0;
        }
        // 对齐逐位相乘
        for (int j = 0; j < blen; j++) {
            for (int i = 0; i < alen; i++) {
                c[i + j] +=  Integer.parseInt(String.valueOf(a[i]))* Integer.parseInt(String.valueOf(b[j]));
            }
        }
        int m = 0;
        // 进位处理
        for (m = 0; m < csize; m++) {
            int carry = c[m] / 10;
            c[m] = c[m] % 10;
            if (carry > 0)
                c[m + 1] += carry;
        }
        // 找到最高位
        for (m = csize - 1; m >= 0;) {
            if (c[m] > 0)
                break;
            m--;
        }
        // 由最高位开始打印乘积
        StringBuffer stringBuffer = new StringBuffer();
        for (int n = 0; n <= m; n++) {
            stringBuffer.append(c[m - n]);
        }
        System.out.print(stringBuffer.toString());
    }
}
