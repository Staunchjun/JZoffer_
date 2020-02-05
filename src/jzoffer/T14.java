package jzoffer;

/**
 * Created by Administrator on 2017/3/20.
 */
//题目描述
//输入一个链表，输出该链表中倒数第k个结点。
public class T14 {
        public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
        }
    public class Solution {
        public ListNode FindKthToTail(ListNode head,int k) {
            if ((k == 0)||head == null)
            {
                return null;
            }
            ListNode tail = head;
            for(int i=0;i<k;i++)
            {
                if(tail.next != null)
                tail = tail.next;
                else
                    return null;
            }

            ListNode k_node = head;
            while(tail.next != null)
            {
                tail = tail.next;
                k_node = k_node.next;
            }
            return k_node;
        }
    }
}
