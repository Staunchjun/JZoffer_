package jzoffer;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/9.
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class T30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(k>input.length){return al;}
        for(int i = 0;i<k;i++)
        {
            for(int j = 0;j<input.length-i-1;j++)
            {
                if(input[j]<input[j+1])
                {
                int temp = input[j];
                input[j]=input[j+1];
                input[j+1]=temp;
                }
            }
            al.add(input[input.length-i-1]);
        }
        return al;
    }
}
