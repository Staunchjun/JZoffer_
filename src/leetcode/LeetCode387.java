package leetcode;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class LeetCode387 {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符
     * 并返回它的索引。如果不存在，则返回 -1。
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int[] al = new int[26];
        LinkedHashMap<Character, Integer> record = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            if (al[tempChar - 'a'] == 0){
                record.put(tempChar, i);
                al[tempChar - 'a'] = 1;
            }else {
                if (record.containsKey(tempChar)){
                    record.remove(tempChar);
                }
            }
        }
        if (record.isEmpty()){
            return -1;
        }else {
            return record.entrySet().iterator().next().getValue();
        }
    }

    public static void main(String[] args) {
      String s1 = "leetcode";
      String s2 = "loveleetcode";
      System.out.println(firstUniqChar(s1));
      System.out.println(firstUniqChar(s2));
    }
}
