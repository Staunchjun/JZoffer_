package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode593 {
    public void main(String[] args) {
        LeetCode593 leetCode593 = new LeetCode593();
        boolean res = leetCode593.validSquare(new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2});
    }

    private int getInstance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    private boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        /**
         * 解题思路，6条边，两个分类。
         * 1。4边相等
         * 2。2边相等（对角线相等）
         *
         * 3。注意四边不能为0
         */
        Map<Integer, Integer> map = new HashMap<>();
        int p12 = getInstance(p1, p2);
        int p13 = getInstance(p1, p3);
        int p14 = getInstance(p1, p4);
        int p23 = getInstance(p2, p3);
        int p24 = getInstance(p2, p4);
        int p34 = getInstance(p3, p4);

        if (map.containsKey(p12)) {
            int val = map.get(p12);
            map.put(p12, ++val);
        } else {
            map.put(p12, 1);
        }

        if (map.containsKey(p13)) {
            int val = map.get(p13);
            map.put(p13, ++val);
        } else {
            map.put(p13, 1);
        }

        if (map.containsKey(p14)) {
            int val = map.get(p14);
            map.put(p14, ++val);
        } else {
            map.put(p14, 1);
        }

        if (map.containsKey(p23)) {
            int val = map.get(p23);
            map.put(p23, ++val);
        } else {
            map.put(p23, 1);
        }

        if (map.containsKey(p24)) {
            int val = map.get(p24);
            map.put(p24, ++val);
        } else {
            map.put(p24, 1);
        }

        if (map.containsKey(p34)) {
            int val = map.get(p34);
            map.put(p34, ++val);
        } else {
            map.put(p34, 1);
        }

        return map.size() == 2
                && p12 != 0
                && p13 != 0
                && p14 != 0
                && p23 != 0
                && p24 != 0
                && p34 != 0;
    }
}
