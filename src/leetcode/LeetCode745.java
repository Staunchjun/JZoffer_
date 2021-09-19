package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode745 {
    static class Node {

        Character val;

        Map<Character, Node> nextNodeMap;

        public Node(Character val) {
            this.val = val;
            this.nextNodeMap = new HashMap<>();
        }
    }
    public LeetCode745(String[] words) {

    }

    public int f(String prefix, String suffix) {
        return -1;
    }

    public static void main(String[] args) {

    }
}
