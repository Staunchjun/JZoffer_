import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Administrator on 2017/5/16.
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class T39 {
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;}
     }
    public int TreeDepth(TreeNode root) {
        if (root == null)
        {return 0;}
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if ((left -right)>0)
        {
            left = left+1;
            return left;
        }
        else {
            right = right +1;
            return right;
        }
    }
}
