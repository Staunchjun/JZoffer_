package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1128 {
    public static void main(String[] args) {
        LeetCode1128 leetCode1128 = new LeetCode1128();
        int[][] dominoes = new int[][]{{1, 2}, {1, 2}, {1, 2}, {3, 4}, {5, 6}};
//        for (int[] i : dominoes) {
//            System.out.println(Arrays.toString(i));
//        }

        System.out.println(leetCode1128.numEquivDominoPairs(dominoes));
    }

    private int numEquivDominoPairs(int[][] dominoes) {
        /**
         * 使用hashcode
         */
        int code = 10;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] i : dominoes) {
            Arrays.sort(i);
            int a = i[0];
            int b = i[1];
            int sum = a * code + b;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        /**
         * 全排列
         */
        int count = 0;
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            count += en.getValue() * (en.getValue() - 1) / 2;
        }

        return count;
    }
}
