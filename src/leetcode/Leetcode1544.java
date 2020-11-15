package leetcode;

import java.util.Collections;
import java.util.Stack;

public class Leetcode1544 {
    /**
     * 需要实时修改前后数据的，还是用栈比较方便
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode1544 leetcode1544 = new Leetcode1544();
        System.out.println(leetcode1544.makeGood("leEeetcode"));
        System.out.println(leetcode1544.makeGood("abBAcC"));
        System.out.println(leetcode1544.makeGood("s"));
    }

    private String makeGood(String s) {
        int diff = Math.abs('a' - 'A');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            //若栈为空，则直接压栈即可
            if (stack.isEmpty()) {
                stack.push(c1);
                continue;
            }
            char c2 = stack.peek();
            if (Math.abs(c2 - c1) == diff) {
                stack.pop();
            } else {
                stack.push(c1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        Collections.reverse(stack);
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    private String makeGood1(String s) {
        int diff = Math.abs('a' - 'A');
        int start = 0;
        while (start < s.length() - 1) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(start + 1);
            if (Math.abs(c2 - c1) == diff) {
                String s1 = s.substring(0, start);
                String s2 = s.substring(start + 2);
                s = s1.concat(s2);
                if (start != 0) {
                    start--;
                }
                continue;
            }
            start++;
        }
        return s;
    }
}
