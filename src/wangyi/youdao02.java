package wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class youdao02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        ArrayList<long []> arrayList = new ArrayList();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextLong();
            }
            arrayList.add(a);
        }
        for (long[] a:arrayList)
        {
         boolean flag = getAllOrder(0,a.length-1,a,false,0);
         if (flag)
         {
             System.out.println("Yes");
         }
         else
         {
             System.out.println("No");

         }
        }
    }
    public static boolean check(long[] array) {
        // 排列拿到了，可以进行你的判断了。
        int len = array.length;
        boolean sumFlag = true;
        for (int i = 0; i < len - 1; i++) {
            long res = array[i]*array[i+1];
            if (res%4 != 0)
            {
               sumFlag = false;
               break;
            }
        }
        return sumFlag;
    }
    public static boolean getAllOrder(int begin, int end,long[]array,boolean flag,int count) {
        if (count>= 10000)
        {
            return false;
        }
        if (flag == true)
        {
            return true;
        }
        count++;
        if (begin == end) {
          flag = check(array);
        } else {
            for (int i = begin; i <= end; i++) {
                // 交换数据
                swap(begin, i,array);
                flag = getAllOrder(begin + 1, end,array,flag,count);
                swap(i, begin,array);
            }
        }

        return flag;
    }
    public static void swap(int from, int to,long[] array) {
        // 这里应该加上各种防止无效交换的情况
        // 比如位置相同，或者2个位置的数据相同
        if (from == to) {
            return;
        }
        long tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }
}
