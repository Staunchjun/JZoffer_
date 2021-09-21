package jzoffer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Jz114 {
    /**
     * words[i] 仅由小写英文字母组成
     * 有问题，这里使用数据结构node，不容易更新，
     * 如果使用入度和出度矩阵作为全局数据实现动态修改
     */
    private int[] inDegree = new int[26];
    private boolean[] exist = new boolean[26];
    // 1 维记录 起始边， 二维记录 有哪些边， 存在则为 1
    private boolean[][] edges = new boolean[26][26];

    public String alienOrder(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                exist[c - 'a'] = true;
            }
        }
        // 这里的两两比较是由顺序的，需要注意下
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                // 从左至右判断
                if (!getInfo(words[i], words[j])) {
                    return "";
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        // 开始拓扑排序，即从入度为0的开始清理
        for (int i = 0; i < 26; i++) {
            if (exist[i]) {
                count++;
            }
            if (exist[i] && inDegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Character> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int i = queue.poll();
            order.add((char) (i + 'a'));
            for (int j = 0; j < 26; j++) {
                // 找到 当前这个点 的下一个点有哪些
                // 对下一个点的入度 进行 自减
                if (edges[i][j]) {
                    edges[i][j] = false;
                    inDegree[j] -= 1;
                    if (inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : order) {
            stringBuilder.append(c);
        }
        return order.size() == count ? stringBuilder.toString() : "";
    }

    /**
     * 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么s 的字典顺序小于 t 。
     * 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。
     *
     * @param word1
     * @param word2
     */
    private boolean getInfo(String word1, String word2) {
        int minLen = Math.min(word1.length(), word2.length());
        // 如果前面 min(s.length, t.length) 字母都相同
        // 那么 s.length < t.length 时，s 的字典顺序也小于 t 。
        for (int i = 0; i < minLen; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            // 由于 word1 在 word2 左边，所以，如果不同，则认为 c1 < c2 , c1 -> c2
            // 组建edge
            // 如果edge 已经组建过了则跳过组建
            if (edges[c1 - 'a'][c2 - 'a']) {
                return true;
            }
            edges[c1 - 'a'][c2 - 'a'] = true;
            inDegree[c2 - 'a'] += 1;
            return true;
        }
        if (word1.length() > word2.length()) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Jz114 jz114 = new Jz114();
        System.out.println(jz114.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }
}
