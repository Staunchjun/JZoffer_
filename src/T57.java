/**
 * Created by Administrator on 2017/4/21.
 */

public class T57 {
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

    public class Solution {
        public ListNode deleteDuplication(ListNode pHead)
        {
            ListNode lNode,cNode,rNode;
            cNode = pHead;
            lNode= null;
            rNode= null;
            while (cNode != null)
            {
                boolean flag = false;
                rNode = cNode.next;
                while (rNode != null && rNode.val == cNode.val)
                {
                    flag = true;
                    rNode = rNode.next;
                }
                if (flag)
                {
                        if (lNode != null)
                        {
                         lNode.next = rNode;
                        }
                        else {
//                            如果是头节点是连续值，直接把头节点删除
                         pHead = null;
//                         pHead = rNode
                        }
                }
                else {

                    if (lNode == null)
                    {
                    pHead = cNode;
                    }
                    lNode =cNode;
                }
                     cNode = rNode;
            }
            return pHead;
        }
    }
}
