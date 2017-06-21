/**
 * Created by Administrator on 2017/6/20 0020.
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest
 * path from the root node down to the nearest leaf node.
 */
package leetcode_dp;
import java.util.LinkedList;
import java.util.Queue;
public class l1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int run(TreeNode root) {
        Queue<TreeNode> stack = new LinkedList<TreeNode>();
        int minDepth = 1;
        if (root == null) {
            return 0;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            int len = stack.size();
            for (int i = 0; i < len; i++) {
            root = stack.poll();
            if (root.right == null && root.left == null) {
                return minDepth;
            }
            if (root.left != null) {
                stack.add(root.left);
            }
            if (root.right != null) {
                stack.add(root.right);
            }
            }
            minDepth++;
        }
        return minDepth;
    }
}
