/**
 * Created by Administrator on 2017/3/20.输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class T17 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
            boolean result = false;
            if (root1 != null && root2 != null) {
                if (root1.val == root2.val) {
                    result = DoesTree1HaveTree2(root1, root2);
                }
                if (!result) {
                    result = HasSubtree(root1.left, root2);
                }
                if (!result) {
                    result = HasSubtree(root1.right, root2);
                }
            }
            return result;
        }

        private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
            if (root2 == null) {
                return true;
            }
            if (root1 == null) {
                return false;
            }
            if (root1.val != root2.val) {
                return false;
            }
            return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
        }
    }
}
