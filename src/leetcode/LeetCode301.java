package leetcode;

import java.util.*;

public class LeetCode301 {
    /**
     * 超时的解法
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses1(String s) {
        Set<String> res = new HashSet<>();
        /**
         * 可能性的题目使用dfs ， 极大极小 用 BFS
         * 穷举删除把 从删除1到删除自身的长度。 碰到 可以 成功删除的，就只保留当前循环圈里的成功个数
         */
        if (s == null || s.length() == 0) {
            res.add("");
            return new ArrayList<>(res);
        }
        if ((!s.contains("(") && !s.contains(")")) || checkVaild(s)) {
            res.add(s);
            return new ArrayList<>(res);
        }
        for (int count = 1; count <= s.toCharArray().length; count++) {
            if (deleteEle(count, s.toCharArray(), res)) {
                break;
            }
        }
        return new ArrayList<>(res);
    }

    private boolean deleteEle(int delCount, char[] ss, Set<String> res) {
        /**
         * 先选一个数字来删除
         */
        for (int j = 0; j < ss.length; j++) {
            /**
             * 剪纸
             */
            if ((j > 0 && ss[j] == ss[j - 1]) || (ss[j] != '(' && ss[j] != ')')) {
                continue;
            }
            char temp = ss[j];
            ss[j] = ' ';
            /**
             * 选着第二个数字删除 直至删除到 delCount
             */
            backtrack(ss, delCount, 1, res);
            ss[j] = temp;
        }
        return !res.isEmpty();
    }

    private void backtrack(char[] ss, int delCount, int count, Set<String> res) {
        if (delCount == count) {
            String re = String.valueOf(ss);
            re = re.replaceAll(" ", "");
            if (checkVaild(re)) {
                res.add(re);
            }
        }
        for (int j = 0; j < ss.length; j++) {
            /**
             * 剪纸
             */
            if ((j > 0 && ss[j] == ss[j - 1]) || (ss[j] != '(' && ss[j] != ')')) {
                continue;
            }
            char temp = ss[j];
            /**
             * 如果已经是空的，说明已经删除过了，跳过
             */
            if (temp == ' ') {
                continue;
            }
            ss[j] = ' ';
            backtrack(ss, delCount, count + 1, res);
            ss[j] = temp;
        }
    }


    private boolean checkVaild(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode301 leeCode301 = new LeetCode301();
        System.out.println(leeCode301.removeInvalidParentheses("()((())(()("));
        System.out.println(leeCode301.removeInvalidParentheses(")x(()())()("));
        System.out.println(leeCode301.removeInvalidParentheses(")(((((((("));
        System.out.println(leeCode301.removeInvalidParentheses("()())))))()"));
        System.out.println(leeCode301.removeInvalidParentheses("(a)())()"));
        System.out.println(leeCode301.removeInvalidParentheses(")("));
    }

    public List<String> removeInvalidParentheses(String s) {
        /**
         * 这道题是标准的dfs. 非常清晰
         * 1,记录要删的'{'数量和要删的'}'数量. 记住,一定要先判断'{'. this is a trick.
         * 2,然后dfs,用set记录.
         */
        HashSet<String> set = new HashSet<>();
        int index = 0;
        int leftToDelete = 0;
        int rightToDelete = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftToDelete++;
            } else if (c == ')') {
                if (leftToDelete > 0) {
                    leftToDelete--;
                } else {
                    rightToDelete++;
                }
            }
        }
        dfs(s, index, leftCount, leftToDelete, rightToDelete, set, new StringBuilder());

        ArrayList<String> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }

    private void dfs(String s, int index, int leftCount, int leftToDelete, int rightToDelete, HashSet<String> set, StringBuilder sb) {
        if (index == s.length()) {
            if (leftToDelete == 0 && rightToDelete == 0 && leftCount == 0) {
                set.add(sb.toString());

            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            // 如果是'{',那么要么删除,要么保留.
            // 如果删除
            if (leftToDelete > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, index + 1, leftCount, leftToDelete - 1, rightToDelete, set, tmp);
            }
            // 不删,或者没有可以删除的
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, index + 1, leftCount + 1, leftToDelete, rightToDelete, set, tmp);
        } else if (c == ')') {
            // 如果是'}', 要么删除,要么在前面有'{'的时候保留.否则只能删除
            if (rightToDelete > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, index + 1, leftCount, leftToDelete, rightToDelete - 1, set, tmp);
            }
            if (leftCount > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append(c);
                dfs(s, index + 1, leftCount - 1, leftToDelete, rightToDelete, set, tmp);
            } else {
                return;
            }
        } else {
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, index + 1, leftCount, leftToDelete, rightToDelete, set, tmp);
        }
    }
}
