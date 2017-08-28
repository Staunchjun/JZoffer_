package didi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/26.
 */
public class didi02 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max+array[i],array[i]);
            res = Math.max(max,res);
        }
        return res;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (scanner.hasNext())
        {
            list.add(scanner.nextInt());
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        System.out.println(FindGreatestSumOfSubArray(a));
    }
}
