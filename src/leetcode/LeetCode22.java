package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode22 {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        backtrack(n, n, new StringBuilder());
        return res;
    }

    private void backtrack(int leftCount, int rightCount, StringBuilder stringBuilder) {
        /**
         * 肯定是先是左括号，然后是右边括号，回溯呗 先任意抽左括号，再抽右括号补上
         */
        if (leftCount == 0 && rightCount == 0){
            res.add(stringBuilder.toString());
            return;
        }

        /**
         *  做选择要有个前提，就是生成的时候，左括号 一定少于右括号，不然会有））））((这样的场景出来
         */
        if (leftCount > rightCount){
            return;
        }
        /**
         * 先是左括号, 这里可以一直左括号，也可以用右括号结束  做选择
         */
        if (leftCount > 0){
            backtrack(leftCount -  1, rightCount, stringBuilder.append("("));
            /**
             * 恢复原状啦
             */
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if (rightCount > 0){
            backtrack(leftCount, rightCount -  1, stringBuilder.append(")"));
            /**
             * 恢复原状啦
             */
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * 例如，给出 n = 3，生成结果为：
     * <p>
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        System.out.println(Arrays.deepToString(leetCode22.generateParenthesis(3).toArray()));
    }
}
