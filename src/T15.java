/**
 * Created by Administrator on 2017/3/20.输入一个链表，反转链表后，输出链表的所有元素。
 */
public class T15 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public class Solution {
            public ListNode ReverseList(ListNode head) {
                if(head == null)
                {
                    return null;
                }
                ListNode reHead = null;
                while(head.next != null)
                {
                    reHead = head.next;
                    head = head.next;

                }
                return null;
            }
        }
    }
}