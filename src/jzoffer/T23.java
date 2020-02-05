package jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2017/5/3.
 */
public class T23 {
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
    public Queue queue = new  LinkedList();
    public ArrayList<Integer> solutions = new ArrayList<>();
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = (TreeNode) queue.poll();
            if (temp!= null) {
                solutions.add(temp.val);
                if (root.left != null)
                    queue.add(temp.left);
                if (root.right != null)
                    queue.add(temp.right);
            }
        }
        return solutions;
    }
}
