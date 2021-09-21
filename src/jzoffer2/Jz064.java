package jzoffer2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Jz064 {
    class Node {
        Map<Character, Node> next = new HashMap<>();
        boolean isEnd = false;
    }

    private Node root = new Node();

    /**
     * Initialize your data structure here.
     */
    public Jz064() {
    }

    public void buildDict(String[] dictionary) {
        // 构造字典树
        for (String word : dictionary) {
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                Map<Character, Node> next = temp.next;
                // 这里的构图有问题， 如果遇到 cat catt 这样的情况，先构造处的从catt，那么后来的cat则无法被视作为单词。
                // 这里的 is End 需要判断一下。
                Node nextNode;
                if (!next.containsKey(character)) {
                    nextNode = new Node();
                } else {
                    nextNode = next.get(character);
                }
                // 构造树的时候，还是要注意下最后一个字母的判断，要放在最后，防止出现 cat catt的情况
                if (i == word.length() - 1) {
                    nextNode.isEnd = true;
                }
                next.put(character, nextNode);
                temp = nextNode;
            }
        }
    }

    public boolean search(String searchWord) {
        Node temp = root;
        // 只能用dfs遍历所有可能性了
        return dfs(temp, searchWord, 0, 0);
    }

    private boolean dfs(Node temp, String searchWord, int isChange, int index) {
        if (index == searchWord.length()  && temp.isEnd && isChange == 1){
            return true;
        }
        if (index > searchWord.length() || isChange > 1){
            return false;
        }
        boolean res = false;
        for (Character character : temp.next.keySet()) {
            if (res){
                return true;
            }

            if (index > searchWord.length() - 1){
                return false;
            }

            if (searchWord.charAt(index) == character){
                res = res | dfs(temp.next.get(character), searchWord, isChange, index + 1 );
            }else {
                res = res | dfs(temp.next.get(character), searchWord, isChange + 1, index + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Jz064 jz064 = new Jz064();
        jz064.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(jz064.search("hello"));
        System.out.println(jz064.search("hhllo"));
        System.out.println(jz064.search("hell"));
        System.out.println(jz064.search("leetcoded"));
    }
}
