/**
 * Created by Administrator on 2017/3/19.
 */
//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
public class T11 {
    public class Solution {
        public int NumberOf1(int n) {
                int count = 0;
                int flag =1;
                while(flag != 0)
                {
                    int k = flag & n;
                    if (k != 0) {
                        count++;
                    }
                    flag = flag << 1;
                }

            return count;
        }
    }
}
