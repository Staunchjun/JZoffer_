package leetcode;

import java.util.*;

public class LeetCode451 {
    /**
     * 偷懒，使用map
     * 对value排序
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> characterIntegerEntry, Map.Entry<Character, Integer> t1) {
                return t1.getValue().compareTo(characterIntegerEntry.getValue());
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                stringBuilder.append(e.getKey());
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        LeetCode451 leetCode451 = new LeetCode451();
        System.out.println(leetCode451.frequencySort("tree"));
        System.out.println(leetCode451.frequencySort("cccaaa"));
        System.out.println(leetCode451.frequencySort("Aabb"));
    }
}
