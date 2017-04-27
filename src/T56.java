import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */

public class T56 {
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
    if (pHead == null)
    {

        return pHead;
    }
         ListNode pNode = pHead;
        HashSet<ListNode> pSet = new HashSet<ListNode>();
        while (pNode !=null)
        {
            if (pSet.contains(pNode))
            {
                return pNode;
            }
            else {
                pNode = pNode.next;
            }

        }
        return null;

    }
 }
