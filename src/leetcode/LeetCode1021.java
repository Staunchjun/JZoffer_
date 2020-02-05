package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode1021 {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack();
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        boolean flag = false;
        /**
         * 先原语分解
         */
        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if (temp == '(') {
                if (!flag) {
                    start = i;
                    flag = true;
                }
                stack.push(temp);
            } else if (temp == ')') {
                stack.pop();
            }
            /**
             * 找到一个原语了，记录i的位置
             *
             * (()())(())
             * 0    56  9
             *
             * (()())(())(()(()))
             * 0    56  910     17
             */
            if (stack.size() == 0) {
                flag = false;
                stringBuilder.append(S.substring(start + 1,i));
            }
        }

        return stringBuilder.toString();
    }
    /**
     * 输入："(()())(())"
     * 输出："()()()"
     * 解释：
     * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
     *
     * 提示：
     *
     * S.length <= 10000
     * S[i] 为 "(" 或 ")"
     * S 是一个有效括号字符串
     */
    public static void main(String[] args) {
        LeetCode1021 leetCode1021 = new LeetCode1021();
        System.out.println(leetCode1021.removeOuterParentheses("(()())(())"));
        System.out.println(leetCode1021.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(leetCode1021.removeOuterParentheses("()()"));
    }
}
