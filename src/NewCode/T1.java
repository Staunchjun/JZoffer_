package NewCode;

import java.util.ArrayList;
import java.util.Scanner;

/*牛牛有两个字符串（可能包含空格）,牛牛想找出其中最长的公共连续子串,希望你能帮助他,并输出其长度。
输入描述:
输入为两行字符串（可能包含空格），长度均小于等于50.


输出描述:
输出为一个整数，表示最长公共连续子串的长度。

输入例子:
abcde
abgde

输出例子:
2
*/
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<char[]> cs = new ArrayList<>();
        int lineNum = 0;
        while (lineNum<2) {
            String str = sc.nextLine();
            char[] c = str.toCharArray();
            cs.add(c);
            lineNum++;
        }
        char[] c1 = cs.get(0);
        char[] c2 = cs.get(1);
        int c1Length = c1.length;
        int c2Length = c2.length;
        int c[][] = new int[c1Length+1][c2Length+1];
        int result = 0;
        for (int i = 0; i <= c1Length; i++) {
            for (int j = 0; j <=c2Length ; j++) {
                if (i == 0 || j == 0)
                {c[i][j] = 0;}
                else if (c1[i] == c2[j])
                {
                    c[i][j] = c[i-1][j-1]+1;
                    if (result < c[i][j])
                    {
                        result = c[i][j];
                    }
                }else {
                    c[i][j] = 0;
                }
            }
        }
        System.out.println(result);
    }
}
