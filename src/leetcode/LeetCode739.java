package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode739 {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            for (int j = i; j < length; j++) {
                if (temperature < T[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; ++i) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

        LeetCode739 leetCode739 = new LeetCode739();
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = leetCode739.dailyTemperatures2(T);
        for (int i : res) {
            System.out.print(" " + i);
        }
    }
}
