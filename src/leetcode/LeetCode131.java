package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s, 0, s.length(),new Stack<>());
        return res;
    }

    private void backtrack(List<List<String>> res, String s,int start , int len, Stack<String> stack) {
        if (start == len) {
            res.add(new ArrayList(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            String subStr = s.substring(start, i + 1);
            /**
             * take a choice
             */
            if (isLoop(subStr)) {
                stack.push(subStr);
                backtrack(res, s, i + 1,len , stack);
                stack.pop();
            }
        }
    }

    private boolean isLoop(String s) {
        if (s.length() == 0) {
            return true;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String test = "aab";
//        String subStr = test.substring(0, 1);
//        String subStr1 = test.substring(1);
//        System.out.println(subStr);
//        System.out.println(subStr1);
        System.out.println(Arrays.deepToString((new LeetCode131()).partition(test).toArray()));
    }
}
