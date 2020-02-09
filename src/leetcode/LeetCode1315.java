package leetcode;

public class LeetCode1315 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return sum;
        }
        if (root.left != null) {
            /**
             * TreeNode grandparent, TreeNode parent, TreeNode root
             *          非空                  非空              空/非空
             */
            dfs(root, root.left, root.left.left);
            dfs(root, root.left, root.left.right);
        }
        if (root.right != null) {
            dfs(root, root.right, root.right.left);
            dfs(root, root.right, root.right.right);
        }
        return sum;
    }

    private void dfs(TreeNode grandparent, TreeNode parent, TreeNode node) {

        /**
         * 直接看有木有孙子节点
         * 这里要测，必须有孙子节点存在，故必有父节点和祖父节点
         * 没有孙子节点则直接退出，不再遍历
         */
        if (node == null) {
            return;
        }
        if (grandparent.val % 2 == 0) {
            sum += node.val;
        }
        dfs(parent, node, node.left);
        dfs(parent, node, node.right);
    }
}
