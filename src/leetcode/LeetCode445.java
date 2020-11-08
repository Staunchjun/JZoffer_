package leetcode;

import java.util.Stack;

public class LeetCode445 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = getIntegers(l1);
        Stack<Integer> s2 = getIntegers(l2);

        Stack<Integer> s3 = new Stack();
        int flag = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int v1 = s1.pop();
            int v2 = s2.pop();
            int sum = v1 + v2;
            flag = getFlag(s3, flag, sum);
        }
        flag = getFlag(s1, s3, flag);
        flag = getFlag(s2, s3, flag);
        ListNode res = null;
        if (flag > 0) {
            res = new ListNode(flag);
        } else if (!s3.isEmpty()) {
            res = new ListNode(s3.pop());
        }
        ListNode temp = res;
        while (!s3.isEmpty()) {
            temp.next = new ListNode(s3.pop());
            temp = temp.next;
        }
        return res;
    }

    private int getFlag(Stack<Integer> s1, Stack<Integer> s3, int flag) {
        while (!s1.isEmpty()) {
            int temp = s1.pop();
            flag = getFlag(s3, flag, temp);
        }
        return flag;
    }

    private Stack<Integer> getIntegers(ListNode l1) {
        Stack<Integer> s1 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        return s1;
    }

    private int getFlag(Stack<Integer> s3, int flag, int sum) {
        sum += flag;
        flag = 0;
        if (sum >= 10) {
            flag = sum / 10;
            sum = sum % 10;
        }
        s3.push(sum);
        return flag;
    }

}
