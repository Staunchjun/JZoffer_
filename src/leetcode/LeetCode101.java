package leetcode;

public class LeetCode101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return true;
        }
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right != null){
            return false;
        }
        if (left != null && right == null){
            return false;
        }
        if (left == null && right == null){
            return true;
        }
        if (left.val == right.val ){
            return  helper(left.left,right.right) && helper(left.right,right.left);
        }else {
            return false;
        }
    }
}
