package baidu;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/14 0014.
 * 三维空间中有N个点，每个点可能是三种颜色的其中之一，三种颜色分别是红绿蓝，分别用'R', 'G', 'B'表示。
 * 现在要找出三个点，并组成一个三角形，使得这个三角形的面积最大。
 * 但是三角形必须满足：三个点的颜色要么全部相同，要么全部不同。
 * 输入描述:
 * <p>
 * 首先输入一个正整数N三维坐标系内的点的个数.(N <= 50)
 * <p>
 * 接下来N行，每一行输入 c x y z，c为'R', 'G', 'B' 的其中一个。x，y，z是该点的坐标。(坐标均是0到999之间的整数)
 * <p>
 * <p>
 * 输出描述:
 * <p>
 * 输出一个数表示最大的三角形面积，保留5位小数。
 * <p>
 * 输入例子:
 * <p>
 * 5
 * R 0 0 0
 * R 0 4 0
 * R 0 0 3
 * G 92 14 7
 * G 12 16 8
 * <p>
 * 输出例子:
 * <p>
 * 6.00000
 */
public class B_3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] position = new int[n][4];

        for (int i = 0; i < n; i++) {

            int j = 0;

            String color = in.next();

            if (color.equals("R"))

                position[i][j++] = 0;

            else if (color.equals("B"))

                position[i][j++] = 1;

            else if (color.equals("G"))

                position[i][j++] = 2;

            else

                return;


            position[i][j++] = in.nextInt();

            position[i][j++] = in.nextInt();

            position[i][j++] = in.nextInt();

        }


        System.out.printf("%.5f", maxArea(n, position));

    }


    public static double maxArea(int n, int[][] position) {

        double max = 0;

        for (int i = 0; i < n - 2; i++)

            for (int j = i + 1; j < n - 1; j++)

                for (int k = j + 1; k < n; k++) {

                    double currentArea = area(position[i], position[j], position[k]);

                    if (currentArea > max)

                        max = currentArea;

                }

        return max;

    }


    public static double area(int[] firstVertex, int[] secondVertex, int[] thirdVertex) {

        if ((firstVertex[0] == secondVertex[0] && firstVertex[0] == thirdVertex[0])

                || ((firstVertex[0] != secondVertex[0]) && (firstVertex[0] != thirdVertex[0]) && (secondVertex[0] != thirdVertex[0]))) {

            int[] verctor1 = {secondVertex[1] - firstVertex[1], secondVertex[2] - firstVertex[2], secondVertex[3] - firstVertex[3]};

            int[] verctor2 = {thirdVertex[1] - firstVertex[1], thirdVertex[2] - firstVertex[2], thirdVertex[3] - firstVertex[3]};

            long x = verctor1[1] * verctor2[2] - verctor1[2] * verctor2[1];

            long y = verctor1[2] * verctor2[0] - verctor1[0] * verctor2[2];

            long z = verctor1[0] * verctor2[1] - verctor1[1] * verctor2[0];

            return Math.sqrt(x * x + y * y + z * z) / 2;

        }

        return 0;

    }
}
