package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode208 {
    class TrieNode {
        boolean isEnd;
        /**
         * 这里的map用来记录不同character的下一个TrieNode
         */
        Map<Character, TrieNode> next = new HashMap<>();

        public TrieNode() {
            isEnd = false;
        }
    }

    class Trie {
        /**
         * 首先要有一个root
         */
        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode trieNode = root;
            trieNode = searchPrefix(word, trieNode);
            if (trieNode != null) {
                return trieNode.isEnd;
            } else {
                return false;
            }
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode trieNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                /**
                 * 看首字母有木有存在，不存在就插入，存在就接着找，直接完全插入
                 */
                if (!trieNode.next.containsKey(c)) {
                    trieNode.next.put(c, new TrieNode());
                }
                trieNode = trieNode.next.get(c);
            }
            trieNode.isEnd = true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode trieNode = root;
            return searchPrefix(prefix, trieNode) != null;
        }

        private TrieNode searchPrefix(String prefix, TrieNode trieNode) {
            if (prefix.length() == 0) {
                return null;
            }
            for (char c : prefix.toCharArray()) {
                /**
                 * 从首字母开始一直往下查
                 */
                if (!trieNode.next.containsKey(c)) {
                    return null;
                }
                trieNode = trieNode.next.get(c);
            }
            return trieNode;
        }
    }
}
