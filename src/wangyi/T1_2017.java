package wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/30.
 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 * {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 * {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 * 现在给出一个数字序列，允许使用一种转换操作：
 * 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 * 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 */
public class T1_2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] item = new int[n];
            for (int i = 0; i < n; i++) {
                item[i] = scanner.nextInt();
            }
            System.out.print(leastTime(n, item));
        }
    }

    //比较第一个和最后一个数，如果第一个大，则前两个相加替换原来位置。
    //如果最后一个数大，则最后两个相加替换原来位置。
    //如果首尾元素相等，则删除首尾元素。
    private static int leastTime(int n, int[] item) {
        int leastT = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(item[i]);
        }

        while (list.size() > 1) {
            if (list.get(0) < list.get(list.size() - 1)) {
                int a = list.get(0);
                int b = list.get(1);
                list.set(0, a + b);
                list.remove(1);
                leastT++;
            } else if (list.get(0) > list.get(list.size() - 1)) {
                int a = list.get(list.size() - 1);
                int b = list.get(list.size() - 2);
                list.set(list.size() - 2, a + b);
                list.remove(list.size() - 1);
                leastT++;
            } else {
                list.remove(0);
                list.remove(list.size() - 1);
            }
        }
        return leastT;

    }
}
