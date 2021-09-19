package company.wangyi;

import java.util.*;

/**
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
 输入描述:

 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
 第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高


 输出描述:

 输出一个整数,表示n个学生列队可以获得的最大的疯狂值。

 如样例所示:
 当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
 这是最大的疯狂值了。
 示例1
 输入

 5
 5 10 25 40 25
 输出

 100
 * Created by Staunchjun on 2017/8/12.
 */
public class yd_3 {
    public static int CrazyLine(ArrayList<Integer> hight, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        Collections.sort(hight);
        ArrayList<Integer> temp = hight;
        int sum = 0;
        if (n == 1)
            return 0;
        else if (n == 2) {
            return Math.abs(hight.get(0) - hight.get(1));
        } else if (n == 3) {
            return Math.abs(hight.get(2) - hight.get(0) + hight.get(2) - hight.get(1));
        }
        int allHight_max = hight.get(n - 1);
        temp.remove(n - 1);
        int left1 = hight.get(0);
        int right1 = hight.get(1);
        int a1 = left1;
        int b1 = right1;
        int left2 = hight.get(temp.size() - 1);
        int right2 = hight.get(temp.size() - 2);
        int visit = 0;
        Do:
        while (temp.size() > 0) {
            if (temp.size() == 1) {
                sum = sum + Math.max(Math.abs(temp.get(0) - left2), Math.abs(temp.get(0) - right2));
                break Do;
            } else if (temp.size() == 2) {
                sum = sum + Math.max(Math.abs(temp.get(1) - left2), Math.abs(temp.get(1) - temp.get(0))) + Math.abs(temp.get(0) - right2);
                break Do;
            } else if (temp.size() == 3) {
                sum = sum + Math.abs(temp.get(0) - left2) + Math.abs(temp.get(1) - right2) + Math.abs(temp.get(0) - temp.get(2));
                break Do;
            }
            left1 = temp.get(0);
            temp.remove(0);
            if (visit == 1) {
                sum = sum + Math.abs(left1 - left2);
            }
            right1 = temp.get(0);
            temp.remove(0);
            if (visit == 1) {
                sum = sum + Math.abs(right1 - right2);
            }
            left2 = temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            right2 = temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            visit = 1;
            sum = sum + (left2 - left1 + right2 - right1);
        }
        sum = sum + Math.abs(allHight_max - a1 + allHight_max - b1);
        return sum;
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> hight = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hight.add(in.nextInt());
        }
        int res = CrazyLine(hight, n);
        System.out.println(res);
    }
}
