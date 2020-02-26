package leetcode;

public class LeetCode318 {
    /**
     * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
     * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
     * 输出: 16
     * 解释: 这两个单词为 "abcw", "xtfn"。
     * 示例 2:
     * <p>
     * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
     * 输出: 4
     * 解释: 这两个单词为 "ab", "cd"。
     * 示例 3:
     * <p>
     * 输入: ["a","aa","aaa","aaaa"]
     * 输出: 0
     * 解释: 不存在这样的两个单词。
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        /**
         * 提前把单词的mask和长度存起来
         * 灵活使用位运算可以提高比较效率
         */
        int[] masks = new int[n];
        int[] lens = new int[n];
        for (int i = 0; i < n; i++) {
            String string = words[i];
            int mask = 0;
            for (int j = 0; j < string.length(); j++) {
                mask |= 1 << (string.charAt(j) - 'a');
            }
            masks[i] = mask;
            lens[i] = string.length();
        }
        /**
         * 暴力解决
         */
        int re = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    re = Math.max(re, lens[i] * lens[j]);
                }
            }
        }
        return re;
    }

//    private boolean getNum(String word, String word1) {
//        int num1 = 0;
//        int num2 = 0;
//        /**
//         * 这里只包含小写字母
//         */
//        for (int i = 0; i < word.length(); i++) {
//            int nu = word.charAt(i) - 'a';
//            num1 |= 1 << nu;
//        }
//        for (int i = 0; i < word1.length(); i++) {
//            int nu = word1.charAt(i) - 'a';
//            num2 |= 1 << nu;
//        }
//        /**
//         * 不含有公共字母，即相与肯定为0，判断是否等于0即可
//         */
//        return (num1 & num2) == 0;
//    }

    public static void main(String[] args) {
        String[] s1 = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        String[] s2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        String[] s3 = {"a", "aa", "aaa", "aaaa"};
        LeetCode318 leetCode318 = new LeetCode318();
        System.out.println(leetCode318.maxProduct(s1));
        System.out.println(leetCode318.maxProduct(s2));
        System.out.println(leetCode318.maxProduct(s3));
    }
}
