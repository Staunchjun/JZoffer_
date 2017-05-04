import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/5/4.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class T25 {
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;
     }
}
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        Stack<Integer> stack = new Stack();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null)
        {return null;}
        FindSpecificPath(root,target,stack,lists);
        return lists;
    }

    private void FindSpecificPath(TreeNode root, int target, Stack<Integer> stack, ArrayList<ArrayList<Integer>> lists) {
         if (root == null)
         {
             return;
         }
         if (root.left == null && root.right == null)
         {
             if (root.val == target)
             {
                 ArrayList<Integer> list = new ArrayList<>();
                 for (int i:stack)
                 {
                     list.add(new Integer(i));
                 }
                 list.add(root.val);
                 lists.add(list);
             }
         }
    else
         {
             stack.push(new Integer(root.val));
             FindSpecificPath(root.left,target-root.val,stack,lists);
             FindSpecificPath(root.right,target-root.val,stack,lists);
             stack.pop();
         }

    }
}
