package leetcode;

public class LeetCode1290 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int getDecimalValue(ListNode head) {
        int count = 0;
        while (head!=null){
            count = (count*2 + head.val);
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
