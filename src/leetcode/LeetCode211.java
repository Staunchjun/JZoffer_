package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode211 {
    class Node {
        boolean isEnd = false;

        Map<Character, Node> next = new HashMap<>();
    }

    Node root;

    /**
     * Initialize your data structure here.
     */
    public LeetCode211() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                Node tempNode = new Node();
                if (i == word.length() - 1) {
                    tempNode.isEnd = true;
                }
                cur.next.put(c, tempNode);
            }
            cur = cur.next.get(c);
        }
    }

    public boolean search(String word) {
        Node cur = root;
        return dfs(cur, 0, word);

    }

    private boolean dfs(Node cur, int index, String word) {
        if (index == word.length()){
            return cur.isEnd;
        }

        char c = word.charAt(index);
        if (!cur.next.containsKey(c)) {
            if (c == '.') {
                boolean isTrue = false;
                for (Map.Entry<Character, Node> entry : cur.next.entrySet()) {
                    isTrue = isTrue || dfs(entry.getValue(), index + 1, word);
                }
                return isTrue;
            }else {
                return false;
            }
        }else {
            cur = cur.next.get(c);
            return dfs(cur,  index + 1,  word);
        }
    }

    public static void main(String[] args) {
        LeetCode211 leetCode211 = new LeetCode211();
        leetCode211.addWord("bad");
        leetCode211.addWord("dad");
        leetCode211.addWord("mad");
//        leetCode211.addWord("a");
//        leetCode211.addWord("a");
        System.out.println(leetCode211.search("pad"));
        System.out.println(leetCode211.search("bad"));
        System.out.println(leetCode211.search(".ad"));
        System.out.println(leetCode211.search("b.."));
//        System.out.println(leetCode211.search("."));
//        System.out.println(leetCode211.search("a"));
//        System.out.println(leetCode211.search("aa"));
//        System.out.println(leetCode211.search("a"));
//        System.out.println(leetCode211.search(".a"));
//        System.out.println(leetCode211.search("a."));
    }
}
