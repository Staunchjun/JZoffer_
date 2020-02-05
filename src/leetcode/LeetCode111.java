package leetcode;

public class LeetCode111 {
    class TreeNode {
        private final int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 1;
        dfs(root, level);
        return min;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (level < min) {
                min = level;
            }
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
