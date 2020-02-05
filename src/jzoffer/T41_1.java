package jzoffer;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/22.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class T41_1 {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> lists = new ArrayList<>();
        if (array.length<=0||array.length<2)
        {
            return lists;
        }
        int small = 0;
        int big = array.length - 1;
        while (small<big)
        {
            int temp = array[small] + array[big];
            if (temp == sum)
            {
                lists.add(array[small]);
                lists.add( array[big]);
                return lists;
            }
            else if (temp < sum)
            {
                small++;
            }
            else
            {
                big--;
            }
        }

        return lists;
    }
 public static void main(String[] args)
 {
    ArrayList<Integer> lists =  FindNumbersWithSum(new int[]{1,2,4,7,11,15},15);
    for (Integer a :lists)
    {
        System.out.println(a);
    }
 }
}
