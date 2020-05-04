package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode212 {
    private final int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    private final List<String> res = new ArrayList<>();
    private char[][] _board = null;

    public static void main(String[] args) {
        LeetCode212 leetCode212 = new LeetCode212();
        leetCode212.findWords(null, null);
    }

    private List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode tempNode = root;
            for (char aChar : word.toCharArray()) {
                if (tempNode.children.containsKey(aChar)) {
                    tempNode = tempNode.children.get(aChar);
                } else {
                    TrieNode newTrieNode = new TrieNode();
                    tempNode.children.put(aChar, newTrieNode);
                    tempNode = newTrieNode;
                }
            }
            tempNode.word = word;
        }

        _board = board;

        TrieNode rootNode = root;
        for (int i = 0; i < _board.length; i++) {
            for (int j = 0; j < _board[i].length; j++) {
                if (rootNode.children.containsKey(board[i][j])) {
                    backtrack(rootNode, i, j);
                }
            }
        }

        return res;
    }

    private void backtrack(TrieNode rootNode, int i, int j) {
        Character letter = _board[i][j];
        TrieNode curNode = rootNode.children.get(letter);
        /**
         * 结果
         */
        if (curNode.word != null) {
            res.add(curNode.word);
            // set null ,because it was found
            curNode.word = null;
        }
        /**
         * 开始做选择
         */
        //'#' used to marked as visited
        _board[i][j] = '#';
        /**
         * 下一步
         */
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= _board.length || newI < 0 || newJ >= _board[0].length || newJ < 0) {
                continue;
            }
            // jian zhi
            if (curNode.children.containsKey(_board[newI][newJ])) {
                backtrack(curNode, newI, newJ);
            }
        }
        /**
         * 恢复所选
         */
        _board[i][j] = letter;
        // Optimization: incrementally remove the leaf nodes
        if (curNode.children.isEmpty()) {
            rootNode.children.remove(letter);
        }
    }

    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;

        TrieNode() {
        }
    }
}
