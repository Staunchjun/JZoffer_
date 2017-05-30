package wangyi;
/**
 * Created by Administrator on 2017/5/30.
 * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，
 小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。
 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
 例如：
 N = 4，M = 24：
 4->6->8->12->18->24
 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
 */
import java.util.ArrayList;
import java.util.Scanner;
public class T3_2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int K = scanner.nextInt();
            int M = scanner.nextInt();
            if (K==M)
            {
                System.out.print(0);
                return;
            }
            int steps = M - K+1;
            int[] dp = new int[steps];
            for (int i = 0; i <steps; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[0] = 0;
            for (int i = 0; i <steps ; i++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    dp[i] = 0;
                    continue;
                }
                ArrayList<Integer> list = getAppNums(i + K);
                for (int j = 0; j < list.size(); j++)
                {
                    int x = list.get(j);
                    if (i+K+x <= M){dp[i+x] = Math.min(dp[i+x],dp[i]+1);}
                }
            }
            if (dp[steps - 1] == 0){System.out.print(-1);}
            else {System.out.print(dp[steps - 1]);}

        }
    }
    private static ArrayList<Integer> getAppNums(int n)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if (n%i == 0)
            {
                list.add(i);
                if ((n/i)!=i)
                {
                    list.add(n/i);
                }
            }

        }
        return list;
    }
}
