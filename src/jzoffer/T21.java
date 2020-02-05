package jzoffer;

import java.util.Stack;

/**
 * Created by Administrator on 2017/4/30.
 */
public class T21 {
    Stack<Integer> ass_stack = new Stack();
    Stack<Integer> main_stack = new Stack();
    public void push(int node) {
        main_stack.push(node);
        if (ass_stack.size() == 0 || ass_stack.peek() > node)
            ass_stack.push(node);
        else{
            ass_stack.push(ass_stack.peek());
        }
    }

    public void pop() {
        if (main_stack.size() > 0 && ass_stack.size() > 0 )
        {main_stack.pop();
        ass_stack.pop();}
    }

    public int top() {
          return main_stack.peek();

    }

    public int min() {
        return ass_stack.peek();
    }
}
