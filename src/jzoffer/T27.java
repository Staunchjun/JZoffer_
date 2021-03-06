package jzoffer;

/**
 * Created by Administrator on 2017/5/7.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class T27 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    protected TreeNode leftLast = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            leftLast = pRootOfTree;
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        if (left != null) {
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
        leftLast = pRootOfTree;
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }
}
