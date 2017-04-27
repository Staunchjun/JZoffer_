import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/4/25.
 */
public class T61 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int toBePrinted = 1;
        int nextLevel = 0;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(pRoot);
        boolean isEven = false;
        if (pRoot == null) {
            return arrayLists;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            TreeNode node = null;
            if (!isEven) {
                node = stack1.pop();
                if (node.left != null) {
                    stack2.push(node.left);
                    nextLevel++;
                }
                if (node.right != null) {
                    stack2.push(node.right);
                    nextLevel++;
                }
            } else {
                node = stack2.pop();

                if (node.right != null) {
                    stack1.push(node.right);
                    nextLevel++;
                }
                if (node.left != null) {
                    stack1.push(node.left);
                    nextLevel++;
                }
            }
            arrayList.add(node.val);
            toBePrinted--;
            if (toBePrinted == 0) {
                arrayLists.add(arrayList);
                toBePrinted = nextLevel;
                nextLevel = 0;
                isEven = !isEven;
               arrayList = new ArrayList<Integer>();
            }

        }
        return arrayLists;
    }
}


