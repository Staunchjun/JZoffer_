/**
 * Created by Staunchjun on 2017/7/23.
 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 输入描述:
 输入一个正浮点数值
 输出描述:
 输出该数值的近似整数值
 示例1
 输入
 5.5
 输出
 6
 */
package huawei;
import java.util.Scanner;
public class hw_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            double d = scan.nextDouble();
            int dint = (int)d;
            if((d-dint)>=0.5 && (d-dint)<1)
                dint++;
            System.out.println(dint);
        }
    }
}
