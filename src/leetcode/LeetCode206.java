package leetcode;

import java.util.List;

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            /**
             * 输入: 1->2->3->4->5->NULL
             * 输出: 5->4->3->2->1->NULL
             *
             * 1->2->3->4->5->NULL
             * 1 2->3->4->5->NULL
             * null<-1 2->3->4->5->NULL
             * null<-1<-2 3->4->5->NULL
             */
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

