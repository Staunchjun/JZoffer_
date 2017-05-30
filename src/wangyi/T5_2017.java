package wangyi;


/**
 * Created by Administrator on 2017/5/30.
 * 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
 如果 X = 123，则rev(X) = 321;
 如果 X = 100，则rev(X) = 1.
 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
 */
import java.util.Scanner;
public class T5_2017 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input1 = scanner.nextInt();
            int input2 = scanner.nextInt();
            System.out.print(rev(rev(input1)+rev(input2)));
        }
    }
    private static int rev(int input)
    {
        int newInput = 0;
        while (input>0)
        {
           int mod = input % 10;
           newInput = newInput *10 +mod;
           input = input/10;
        }
        return newInput;
    }
}
