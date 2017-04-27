/**
 * Created by Administrator on 2017/4/27.
 */
public class T63 {
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }

}
    int k ;
    TreeNode KthNode(TreeNode pRoot, int k)
    {

        this.k = k;
        return  KthNodeCore(pRoot);

    }
    private  TreeNode KthNodeCore(TreeNode pRoot)
    {
        TreeNode target = null;
        if (pRoot!=null )
        {
            if ((target = KthNodeCore(pRoot.left)) != null){return target;}
            if (--k==0) {return pRoot;}
            if ((target = KthNodeCore(pRoot.right)) != null){return target;}
        }
        return null;
    }
}
