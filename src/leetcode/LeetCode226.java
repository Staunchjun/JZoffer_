package leetcode;

public class LeetCode226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return  null;
        }
        /**
         * 错误写法 如果你这个时候就对root.left进行赋值
         * 那么接下来你invertTree(root.left)的时候就是root.right的值
         */
//        root.left = invertTree(root.right);
//        root.right = invertTree(root.left);
        /**
         * 正确写法
         */
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
