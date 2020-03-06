package leetcode;

import java.util.*;

public class LeetCode791 {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            char temp = T.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char sTemp = S.charAt(i);
            if (map.containsKey(sTemp)) {
//                finalStr.append(String.valueOf(sTemp).repeat(Math.max(0, map.get(sTemp))));
                map.remove(sTemp);
            }
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
//            finalStr.append(String.valueOf(e.getKey()).repeat(Math.max(0, e.getValue())));
        }
        return finalStr.toString();
    }

    public static void main(String[] args) {
        System.out.println((new LeetCode791()).customSortString("cba", "abcd"));
    }
}
