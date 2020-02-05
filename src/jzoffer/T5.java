package jzoffer; /**
 * Created by Administrator on 2017/3/19.
 */
import java.util.Stack;
public class T5 {

    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack1.isEmpty() && stack2.isEmpty())
            {
                throw new RuntimeException("Queue is empty!");
            }
            if (stack2.isEmpty())
            {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
