package leetcode;

import java.util.Stack;

public class LeetCode394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        return null;
    }

    public static void main(String[] args) {
        LeetCode394 leetCode394 = new LeetCode394();
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        System.out.println(leetCode394.decodeString(s1));
        System.out.println(leetCode394.decodeString(s2));
        System.out.println(leetCode394.decodeString(s3));
    }
}
