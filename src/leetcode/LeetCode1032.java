package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1032 {
    static class Node {
        boolean isEnd;

        Character val;

        Map<Character, Node> nextNodeMap;

        public Node(Character val, boolean isEnd) {
            this.isEnd = isEnd;
            this.val = val;
            this.nextNodeMap = new HashMap<>();
        }
    }

    List<Character> history = new ArrayList<>();
    Node treeRoot = new Node(null, false);

    public LeetCode1032(String[] words) {
        for (String word : words) {
            // 倒序插入
            Node root = treeRoot;
            for (int i = word.length() - 1; i >= 0; i--) {
                char digital = word.charAt(i);
                Node node;
                if (root.nextNodeMap.containsKey(digital)) {
                    node = root.nextNodeMap.get(digital);
                    // 此处需要注意 子串 也有可能 是 终结点，这里容易出错。
                    if (i == 0) {
                        node.isEnd = true;
                    }
                }else {
                    node = new Node(digital, false);
                    if (i == 0) {
                        node.isEnd = true;
                    }
                    root.nextNodeMap.put(digital, node);
                }
                root = node;
            }
        }
    }

    public boolean query(char letter) {
        // 无论是不是，先加入histoty先
        history.add(letter);

        Node root = treeRoot;
        // 如果不是终末 则继续 查看 子map
        for (int i = history.size() - 1; i >= 0; i--) {
            char digital = history.get(i);
            if (!root.nextNodeMap.containsKey(digital)) {
                return false;
            }
            root = root.nextNodeMap.get(digital);
            if (root.isEnd) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode1032 leetCode1032 = new LeetCode1032(new String[]{"abaa", "abaab", "aabbb", "bab", "ab"});
        System.out.println(leetCode1032.query('a'));
        System.out.println(leetCode1032.query('a'));
        System.out.println(leetCode1032.query('b'));
        System.out.println(leetCode1032.query('b'));
        System.out.println(leetCode1032.query('b'));
    }
}
