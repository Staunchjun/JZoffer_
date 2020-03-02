package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] maps = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                builder.append(maps[c - 'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        LeetCode804 leetCode804 = new LeetCode804();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(leetCode804.uniqueMorseRepresentations(words));
    }
}
