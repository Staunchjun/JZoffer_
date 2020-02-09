package leetcode;

public class LeetCode1320 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxDepth = Integer.MIN_VALUE;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        /**
         * 如果发现这个深度等于最大的深度
         * 则相加结果，这里会有很多重复计算
         */
        if (depth == maxDepth) {
            sum += root.val;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            /**
             * 发现更加深的深度。
             * 其他分支的计算先重置
             */
            sum = root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
