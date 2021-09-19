package company.wangyi;
/**
 * Created by Administrator on 2017/5/31.
 * 现在有n位工程师和6项工作(编号为0至5)，
 * 现在给出每个人能够胜任的工作序号表(用一个字符串表示，
 * 比如：045，表示某位工程师能够胜任0号，4号，5号工作)。
 * 现在需要进行工作安排，每位工程师只能被安排到自己能够胜任的工作当中去，
 * 两位工程师不能安排到同一项工作当中去。
 * 如果两种工作安排中有一个人被安排在的工作序号不一样就被视为不同的工作安排，
 * 现在需要计算出有多少种不同工作安排计划。
 */
import java.util.HashSet;
import java.util.Scanner;
public class C6_2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ables = new String[n];
        for (int i = 0; i < n; i++) {
            ables[i] =sc.next();
        }
        backTracking(ables,0,new HashSet<Integer>());
        System.out.print(cases);
        sc.close();
    }
    private static int cases = 0;
    private static void backTracking(String[] ables, int inedx, HashSet<Integer> integers) {
        //当考察完最后一个人的时候，直接递归出去
        if (inedx >= ables.length)
        { cases++;return;}
        String able = ables[inedx];
        for (int i = 0; i <able.length() ; i++) {
            int able_work = able.charAt(i) - '0';
            if (!integers.contains(able_work))
            {
                integers.add(able_work);
                backTracking(ables,inedx+1,integers);
                //计算完了一轮移除able_work
                integers.remove(able_work);
            }
        }
    }
}
