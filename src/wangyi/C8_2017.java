package wangyi;
// Created by Administrator on 2017/6/1.
// 常规的表达式求值，我们都会根据计算的优先级来计算。比如*/的优先级就高于+-。
// 但是小易所生活的世界的表达式规则很简单，
// 从左往右依次计算即可，而且小易所在的世界没有除法，
// 意味着表达式中没有/，只有(+, - 和 *)。现在给出一个表达式，
// 需要你帮忙计算出小易所在的世界这个表达式的值为多少
import java.util.Scanner;
public class C8_2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            String str = sc.nextLine();
            int res = Compute(str);
            System.out.print(res) ;
        }
        sc.close();
    }

    private static int Compute(String str) {
        char[] strs = str.toCharArray();
        int res = 0;
        int cur = 0;
        char flag = '+';
        for (int i = 0; i < strs.length; i++) {
            if ((strs[i]>='0'&& strs[i]<='9')&& i != strs.length-1)
            {
                cur = strs[i] - '0';
            }
            else {
            if (i == strs.length-1)
            {
                cur = strs[i] - '0';
            }
            if (flag == '+')
            {
                res += cur;
            }
            if (flag == '-')
            {
                res -= cur;
            }
            if (flag == '*')
            {
                res *= cur;
            }
            flag = strs[i];
            }
        }
        return res;
    }
}
