package company.souhu;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/28.
 */
public class souhu02 {
    public static void main(String[] args)
    {
        //122112211221...
        //1 22 11 2 1 22 11 2 1 22 11 2
        //122112211221
        //保持不变
        //22 33 222 333 22 33 22 333 222 333 22 33...
        //22332223332
        //22331
        //221
        //21

        //2 1 3 1
        //22 11 3 1 222 1 33 11 22 1 333 111 2 1 33 11.
        //2211312221331122
        //221131222
        //22113
        //221
        //21

        //12 2 1 3 1
        //211
        //2213
        //22113111
        //221131222131
        //221131222131
        int[] all = new int[Integer.MAX_VALUE];
        all[1] = 1;
        all[2] = 2;
        all[3] = 2;
        int biao =3;
        int t = 3;
        int temp;
        for (int i = 4; i <=Integer.MAX_VALUE ; i++) {
            temp = all[t++];
            if (temp == 2) {
                if (all[i - 1] == 1) {
                    all[i] = 2;
                    all[i + 1] = 2;
                    i++;
                }else
                {
                    all[i] = 1;
                    all[i+1] =1;
                    i++;
                }
            }else
            {
                if (all[i-1] == 1)
                {
                    all[i] = 2;
                }else
                {
                    all[i] =1;
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
//        int temp = 2;
//        int flag = a[temp];
//        for (int i = 3; i < m; ) {
//            int num = a[temp];
//            for (int j = 1; j <= num ; j++) {
//                if (flag == 1);
//            }
//        }


    }}
