package jzoffer;

import java.util.Stack;

/**
 * Created by Administrator on 2017/5/15.
 */
public class T37 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        if (temp1 == null||temp2 == null)
        {
            return null;
        }
        while (temp1!=null)
        {stack1.push(temp1);temp1 = temp1.next;}
        while (temp2!=null)
        {stack2.push(temp2);temp2 = temp2.next;}
        ListNode firstSameNode = null;
        while (!stack1.isEmpty() &&!stack2.isEmpty() && stack1.peek() == stack2.peek())
        {
            firstSameNode = (ListNode) stack1.pop();
        }
        return firstSameNode;
    }
}
