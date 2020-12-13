package leetcode;

import java.util.Stack;

public class LeetCode1106 {

    private boolean characterToBoolean(char character) {
        if (character == 't') {
            return true;
        } else if (character == 'f') {
            return false;
        } else {
            return false;
        }
    }

    private char booleanToCharacter(boolean isTrue) {
        if (isTrue) {
            return 't';
        } else {
            return 'f';
        }
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> signStack = new Stack<>();
        Stack<Character> expressStack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char temp = expression.charAt(i);
            if (temp == '&' || temp == '|' || temp == '!') {
                signStack.push(temp);
            } else if (temp == ',') {
                ;
            } else if (temp == ')') {
                if (!signStack.isEmpty()) {
                    boolean result = true;
                    char sign = signStack.pop();
                    if (sign == '&') {
                        char firstCharacter = expressStack.pop();
                        result = characterToBoolean(firstCharacter);
                        while (!expressStack.isEmpty() && expressStack.peek() != '(') {
                            char tempFlag = expressStack.pop();
                            result = result & characterToBoolean(tempFlag);
                        }
                    } else if (sign == '|') {
                        char firstCharacter = expressStack.pop();
                        result = characterToBoolean(firstCharacter);
                        while (!expressStack.isEmpty() && expressStack.peek() != '(') {
                            char tempFlag = expressStack.pop();
                            result = result ||  characterToBoolean(tempFlag);
                        }
                    } else if (sign == '!') {
                        char tempFlag = expressStack.pop();
                        result = !characterToBoolean(tempFlag);
                    }
                    // 'pop ('
                    expressStack.pop();
                    expressStack.push(booleanToCharacter(result));
                }
            } else {
                expressStack.add(temp);
            }
        }
        return characterToBoolean(expressStack.pop());
    }

    public static void main(String[] args) {
        LeetCode1106 leetCode1106 = new LeetCode1106();
        System.out.println(leetCode1106.parseBoolExpr("!(f)"));
        System.out.println(leetCode1106.parseBoolExpr("|(f,t)"));
        System.out.println(leetCode1106.parseBoolExpr("&(t,f)"));
        System.out.println(leetCode1106.parseBoolExpr("|(&(t,f,t),!(t))"));
    }
}
