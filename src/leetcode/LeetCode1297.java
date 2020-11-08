package leetcode;

import java.util.*;

public class LeetCode1297 {
    /**
     * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
     *
     * 子串中不同字母的数目必须小于等于 maxLetters 。
     * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
     *
     * @param s
     * @param maxLetters
     * @param minSize
     * @param maxSize
     * @return
     */
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> res = new HashMap<>();
        int size = minSize;
//        for (int size = minSize; size <= maxSize; size++) {
            for (int j = 0; j + size <= s.length() ; j++) {
                //滑动窗口
                // 记录有多少不重复的字符
                HashSet<Character> record = new HashSet<>();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < size; i++) {
                       char tempChar =  s.charAt(i + j);
                       if (!record.contains(tempChar)){
                           record.add(tempChar);
                       }
                    stringBuilder.append(tempChar);
                }
                //如果不重复的字符少于maxLetters 则加入res中
                if (record.size() <= maxLetters) {
                    res.put(stringBuilder.toString(), res.getOrDefault(stringBuilder.toString(), 0 ) + 1 );
                }
            }
//        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(res.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> stringIntegerEntry, Map.Entry<String, Integer> t1) {
                return t1.getValue() - stringIntegerEntry.getValue() ;
            }
        });
        if (entryList.isEmpty()){
            return 0;
        }
        return entryList.get(0).getValue();
    }

    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab",2,3,4));
        System.out.println(maxFreq("aaaa",1,3,3));
        System.out.println(maxFreq("aabcabcab",2,2,3));
        System.out.println(maxFreq("abcde",2,3,3));
    }
}
