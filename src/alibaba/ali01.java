package alibaba;

import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/25.
 */
public class ali01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int b_price = 2000;

        while (scanner.hasNext()) {
            int b_length = scanner.nextInt();
            int b_width = scanner.nextInt();
            int b_height = scanner.nextInt();

            int itemNum = scanner.nextInt();
           Model[] items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            System.out.println(process(items,b_length,b_width,b_height,b_price));
            int boxMinNum = Integer.MAX_VALUE;
        }

    }

    private static int process(Model[] items, int b_length, int b_width, int b_height, int b_price) {
        int itemNum = items.length;
        int sum = 0;
        for (int i = 0; i < itemNum; i++) {
            sum += items[i].price;
        }
        int[][] dp = new int[itemNum+1][sum+1];
        for (int i = 1; i <= itemNum; i++) {
            for (int j = sum; j >= items[i].price ; j--) {
                for (int k = b_length; k >= items[i].length  ; k--) {
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-items[i].price]);
                }
                for (int k = b_width ; k >= items[i].width  ; k--) {
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-items[i].price]);
                }
                for (int k = b_height ; k >= items[i].height  ; k--) {
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-items[i].price]);
                }
            }
        }
        return dp[itemNum+1][sum+1];
    }


    private static class Model {
        private int price;
        private int length;
        private int width;
        private int height;

    }
}
