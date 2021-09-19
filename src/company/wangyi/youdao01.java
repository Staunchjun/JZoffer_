package company.wangyi;

import java.util.Scanner;

public class youdao01 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int i = t; i > 0 ; i--) {
                int n = scanner.nextInt();
                int[] count = {0,0,0,0};
                for (int j = 0; j < n; j++) {
                    int a = scanner.nextInt();
                    int re = a%4;
                    count[re]++;
                }
                int sum = count[0]+count[1]+count[3];
                if (count[2]!= 0)
                {
                    sum++;
                }
                if (sum/2 > count[0])
                {
                    System.out.println("No\n");
                }
                else {
                    System.out.println("Yes\n");
                }
            }

        }
}
