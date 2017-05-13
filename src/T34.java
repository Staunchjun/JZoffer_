/**
 * Created by Administrator on 2017/5/13.
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class T34 {
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        //确保有序的产生
        for (int i = 1; i < index; i++) {
            res[i] = GetMin(res[t2] * 2, res[t3] * 3, res[t5] * 5);
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[index - 1];
    }

    public static int GetMin(int t2, int t3, int t5) {
        int min = 0;
        if (t2 < t3) {
            min = t2;
        } else {
            min = t3;
        }
        if (min < t5) {
            return min;
        } else {
            return t5;
        }
    }

    public static void main(String[] args) {
        System.out.print(GetUglyNumber_Solution(3));
    }

}
