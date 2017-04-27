/**
 * Created by Administrator on 2017/3/19.
 */
public class T7 {
    public class Solution {
        public int Fibonacci(int n) {
            if (n < 2)
            {
                return n;
            }
            int  F0 = 0;
            int  F1 = 1;
            int  Fn = 0;
            for(int i = 2;i<=n;i++)
            {
                Fn = F0 +F1;
                F0 = F1;
                F1 = Fn;
            }
            return Fn;
        }
    }
}
