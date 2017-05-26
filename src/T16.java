/**
 * Created by Administrator on 2017/3/20.输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class T16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode merge2 = null;
        if (list1.val > list2.val) {
            merge2 = list2;
            merge2.next = Merge(list1, list2.next);
        } else {
            merge2 = list1;
            merge2.next = Merge(list1.next, list2);
        }
        return merge2;
    }
}

