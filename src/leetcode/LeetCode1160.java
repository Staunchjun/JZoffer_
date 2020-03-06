package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1160 {
    /**
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     * <p>
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     * <p>
     * 注意：每次拼写时，chars 中的每个字母都只能用一次。
     * <p>
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char temp = chars.charAt(i);
            charsMap.put(temp, charsMap.getOrDefault(temp, 0) + 1);
        }
        /**
         * 注意：每次拼写时，chars 中的每个字母都只能用一次。
         * 是每一次拼写！而不是总的拼写
         */
        int count = 0;
        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>(charsMap);
            boolean isContain = true;
            for (int i = 0; i < word.length(); i++) {
                char temp = word.charAt(i);
                if (tempMap.containsKey(temp) && tempMap.get(temp) != 0) {
                    tempMap.put(temp, tempMap.get(temp) - 1);
                } else {
                    isContain = false;
                    break;
                }
            }
            if (isContain) {
                count += word.length();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1160 leetCode1160 = new LeetCode1160();
        TestCase1(leetCode1160);
        TestCase2(leetCode1160);
    }

    private static void TestCase2(LeetCode1160 leetCode1160) {
        String[] words = new String[]{"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(leetCode1160.countCharacters(words, chars));
    }

    private static void TestCase1(LeetCode1160 leetCode1160) {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(leetCode1160.countCharacters(words, chars));
    }
}
