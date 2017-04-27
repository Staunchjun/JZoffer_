import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/20.输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class T16 {

    public  static int A = 1;
    public static int B = 2;

    public static boolean A_w = false;
    public static boolean B_w = false;

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        while (scanner.hasNext())
        {
             int n = scanner.nextInt();
             if (n > 100)
             {
                 return;
             }
             else {
                 for (int k = 1;k < n;k++)
                 {
                 takeStone(n,k,0,1);
                 }
             }
        }


    }
    public static void takeStone(int n, int t, int lastT, int who)
    {


        if(n == 0)
        {
            if (who == A)
            {A_w= true;return;}
            else
            {B_w = true;return;}
        }
        if (t > n)
        {
            return;
        }
        else if (lastT < t)
        {
            if (lastT != 0)
            {
            return;
            }
        }
        int nRest = n - t;
        lastT = t;
        for (int k = 1;k < nRest && k < lastT ;k++)
        {
            if (who == A)
            {takeStone(nRest,k,lastT,B);}
            else
            {takeStone(nRest,k,lastT,A);}
        }
    }
}
