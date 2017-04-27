/**
 * Created by Administrator on 2017/4/23.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T60 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int toBePrinted = 1;
        int nextLevel = 0;
        if (pRoot == null)
        {
            return arrayLists;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while ( !queue.isEmpty())
        {
             TreeNode node =  queue.remove();
             arrayList.add(node.val);

             if (node.left != null)
             {
                 queue.add(node.left);
                 nextLevel++;
             }
             if (node.right != null)
             {
                 nextLevel++;
                 queue.add(node.right);
             }
             toBePrinted--;
             if (toBePrinted == 0)
             {
                 arrayLists.add(arrayList);
                 toBePrinted = nextLevel;
                 nextLevel = 0;
                arrayList  = new ArrayList<Integer>();
             }

        }
        return arrayLists;
    }
}
