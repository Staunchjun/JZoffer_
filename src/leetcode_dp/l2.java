package leetcode_dp;


/**
 * Created by Administrator on 2017/6/20 0020.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 值的比较还是equal是最靠谱的
// */
import java.util.Stack;
public class l2 {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            if (tokens[i].equals("*")|| tokens[i].equals("+")|| tokens[i].equals("-")|| tokens[i].equals("/")) {
                String b = stack.pop();
                String a = stack.pop();
                int aNum = Integer.parseInt(a);
                int bNum = Integer.parseInt(b);
                if (tokens[i].equals("+")) {
                    int sum = aNum + bNum;
                    stack.push(String.valueOf( sum));
                } else if (tokens[i].equals("-")) {
                    int sum = aNum - bNum;
                    stack.push(String.valueOf( sum));
                } else if (tokens[i].equals( "/") ){
                    int sum = aNum/bNum;
                    stack.push(String.valueOf( sum));
                } else if (tokens[i].equals("*")) {
                    int sum = aNum * bNum;
                    stack.push(String.valueOf( sum));
                }
            }else { stack.push(tokens[i]);}
        }
        String result = stack.pop();
        return Integer.parseInt(result);
    }
    public static void main(String[] args)
    {
        evalRPN(new String[]{"0","3","/"});
    }
}
