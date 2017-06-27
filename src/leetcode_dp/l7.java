package leetcode_dp;

/**
 * Created by Administrator on 2017/6/27 0027.
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * 可以选择归并和快排 ，归并可以保证稳定而且无论什么时候 都为O(n log n)
 */
public class l7 {
      class ListNode {
          int val;
         ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
         }
     }
    public ListNode sortList(ListNode head) {
                qucikSort(head,null);
                return head;
    }

    private void qucikSort(ListNode head, ListNode end) {
          if (head != end)
          {
              ListNode p = partition(head,end);
              qucikSort(head,p);
              qucikSort(p.next,end);
          }

    }

    private ListNode partition(ListNode head, ListNode end) {
        int x = head.val;
        ListNode i = head;
        //i 指针用来找到比 x 大的第一个数
        //j 指针用来找到比x小的第一个数，交换两边位置。最终左边为小，右边为大。
        ListNode j = head.next;
        while ( j != end) {
            if (j.val < x) {
                i = i.next;
                int tmp = i.val;
                i.val = j.val;
                j.val = tmp;
            }
            j = j .next;
        }
        int tmp = i.val;
        i.val = head.val;
        head.val = tmp;
        return i;
    }
}
