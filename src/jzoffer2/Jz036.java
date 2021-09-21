package jzoffer2;

import java.util.Stack;

public class Jz036 {
    public int evalRPN(String[] tokens) {
        Stack<String> nums = new Stack<>();
        for (String token : tokens) {
            int n1;
            int n2;
            int ret;
            switch (token) {
                case "+":
                    n1 = Integer.parseInt(nums.pop());
                    n2 = Integer.parseInt(nums.pop());
                    ret = n2 + n1;
                    nums.push(String.valueOf(ret));
                    break;
                case "-":
                    n1 = Integer.parseInt(nums.pop());
                    n2 = Integer.parseInt(nums.pop());
                    ret = n2 - n1;
                    nums.push(String.valueOf(ret));
                    break;
                case "*":
                    n1 = Integer.parseInt(nums.pop());
                    n2 = Integer.parseInt(nums.pop());
                    ret = n2 * n1;
                    nums.push(String.valueOf(ret));
                    break;
                case "/":
                    n1 = Integer.parseInt(nums.pop());
                    n2 = Integer.parseInt(nums.pop());
                    ret = n2 / n1;
                    nums.push(String.valueOf(ret));
                    break;
                default:
                    nums.push(token);
                    break;
            }
        }
        return Integer.parseInt(nums.pop());
    }

    public static void main(String[] args) {
        Jz036 jz036 = new Jz036();
        System.out.println(jz036.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(jz036.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(jz036.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
