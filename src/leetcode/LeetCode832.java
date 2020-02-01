package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] pre = A;
        for (int i = 0; i < pre.length; i++) {
            int[] temp = new int[pre[i].length];
            for (int j = pre[i].length - 1,index = 0; j >=0 ; j--,index++) {
                temp[index] = pre[i][j] == 0?1:0;
            }
            pre[i] = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        LeetCode832 leetCode832 = new LeetCode832();
        int[][] image1 = new int[][]{
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        int[][] image2 = new int[][]{
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        };
        System.out.println( Arrays.deepToString(leetCode832.flipAndInvertImage(image1)) );
        System.out.println( Arrays.deepToString(leetCode832.flipAndInvertImage(image2)) );
    }
}
