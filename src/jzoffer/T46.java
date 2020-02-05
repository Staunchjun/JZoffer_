package jzoffer;

/**
 * Created by Administrator on 2017/5/25.
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句
 * （A?B:C）。
 */
public class T46 {
    public int Sum_Solution(int n) {
        int sum = n;
        //他们有短路特性，前面的条件判真（或者假）了，就不会再执行后面的条件了
        //这时就能联想到--n,直到等于0就能返回值。
        boolean flag = (sum>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
