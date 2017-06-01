/**
 * Created by Administrator on 2017/6/1.
 * 小易最近在数学课上学习到了集合的概念,集合有三个特征：1.确定性 2.互异性 3.无序性.
 小易的老师给了小易这样一个集合：
 S = { p/q | w ≤ p ≤ x, y ≤ q ≤ z }
 需要根据给定的w，x，y，z,求出集合中一共有多少个元素。小易才学习了集合还解决不了这个复杂的问题,需要你来帮助他。
 */
package wangyi;
import java.util.*;
public class C7_2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ables[] = new int[4];
        for (int i = 0; i < 4; i++) {
            ables[i] =sc.nextInt();
        }
        double p = 0;
        Set myset = new HashSet();
        for (double i = ables[0]; i <= ables[1]; i++) {
            for (double j = ables[2];j<=ables[3];j++)
            {
                p = i/j;
                myset.add(Double.toString(p));
            }
        }
        System.out.print(myset.size());

    }
}
