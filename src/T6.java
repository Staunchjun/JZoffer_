/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class T6 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

            if (pre.length == 0  || in.length == 0)
            {return  null;}
            else
            {
               TreeNode rootNode = new TreeNode(pre[0]);
               int IndexIn = ScanValue(rootNode.val,in);
               if (IndexIn == -1)
               {
                   return null;
               }
               else
               {
                   int[] pre_LeftNums = new int[IndexIn];
                   int[] pre_RightNums = new int[in.length-IndexIn-1];
                   int[] In_LeftNums = new int[IndexIn];
                   int[] In_RightNums = new int[in.length-IndexIn-1];
                   for (int j=1,i=0;j<IndexIn+1;j++,i++)
                   {pre_LeftNums[i] = pre[j];}
                   for (int j=0,i=0;j<IndexIn;j++,i++)
                   {In_LeftNums[i] = in[j];}
                   for (int j=IndexIn+1,i=0;j<pre.length;j++,i++)
                   {pre_RightNums[i] = pre[j];}
                   for (int j=IndexIn+1,i=0;j<in.length;j++,i++)
                   {In_RightNums[i] = in[j];}
                   rootNode.left = reConstructBinaryTree(pre_LeftNums, In_LeftNums);
                   rootNode.right = reConstructBinaryTree(pre_RightNums,In_RightNums);
               }
                return rootNode;
            }
    }
    public static int ScanValue(int x, int[] in)
    {
        for (int i = 0;i<in.length;i++)
        {
            if (in[i] == x)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println("Hello World!");
        int[] pre = new int[]{1,2,4,3,5,6};
        int[] in = new int[]{4,2,1,5,3,6};
        TreeNode a = reConstructBinaryTree(pre,in);

    }
}