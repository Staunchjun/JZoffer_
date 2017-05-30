package wangyi;


/**
 * Created by Administrator on 2017/5/30.
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。
 * 小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，
 * 小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 例如：半径的平方如果为25
 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
 */
import java.util.Scanner;
public class T2_2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int RR = scanner.nextInt();
            double R =  Math.sqrt(RR);
            //在第一象限上
            int count = 0;
            for (int i = 0; i<R;i++)
            {
                double j = Math.sqrt(RR - i*i);
                if (Math.abs(j)-Math.round(j) == 0)
                {
                    count++;
                }
            }
            System.out.print(count*4);
        }
    }
}
