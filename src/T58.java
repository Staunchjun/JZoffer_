/**
 * Created by Administrator on 2017/4/23.
 */
public class T58 {
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
        {
            return null;
        }
        if (pNode.right != null)
        {
//           右树存在,直接输出最左边的节点
            pNode = pNode.right;
            while (pNode.left != null)
            {
                pNode = pNode.left;
            }
            return pNode;
        }
        else if (pNode.next != null&& pNode.next.left == pNode)
        {
//            若没有右树但有父节点,若pNode位于右子树则一直往上，找到最尽的父节点，若pNode在左子树则追溯回一个父节点就可以了
            return pNode.next;
        }else if (pNode.next != null&& pNode.next.right == pNode)
        {
            while (pNode.next != null && pNode.next.right == pNode) {
                pNode = pNode.next;
            }
            pNode = pNode.next;
            return pNode;
        }
        return pNode.next;
    }
}
