package jzoffer;

/**
 * Created by Administrator on 2017/3/20.操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class T18 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class Solution {
        public void Mirror(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                return;
            }
            TreeNode pTemp = root.left;
            root.left = root.right;
            root.right = pTemp;

            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
