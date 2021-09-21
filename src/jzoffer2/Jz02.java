package jzoffer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jz02 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> data = new HashMap<>();
        for (String str : strs) {
            char[] tempMap = new char[26];

            for (int i = 0; i < str.length(); i++) {
                char character = str.charAt(i);
                tempMap[character - 'a'] += 1;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < tempMap.length; i++) {
                int num = tempMap[i];
                keyBuilder.append((char) ('a' + i));
                keyBuilder.append(num);
            }

            List<String> ret = data.getOrDefault(keyBuilder.toString(), new ArrayList<>());
            ret.add(str);
            data.put(keyBuilder.toString(), ret);
        }
        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        Jz02 jz02 = new Jz02();
        System.out.println(jz02.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(jz02.groupAnagrams(new String[]{""}));
        System.out.println(jz02.groupAnagrams(new String[]{"a"}));
    }
}
