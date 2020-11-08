package leetcode;

import java.util.Iterator;
import java.util.Stack;

public class LeetCode155 {
    class MinStack {
        private Stack<Integer> stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
           Iterator<Integer> iterator = stack.iterator();
           int min = Integer.MAX_VALUE;
           while (iterator.hasNext()){
               Integer val = iterator.next();
               if (val < min){
                   min = val;
               }
           }
           return min;
        }
    }
}
