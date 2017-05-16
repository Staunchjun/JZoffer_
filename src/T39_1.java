/**
 * Created by Administrator on 2017/5/16.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class T39_1 {
    public boolean IsBalanced_Solution(T39.TreeNode root) {
        return f(root,new Holder());
    }
    private class Holder{int n;}
    boolean f(T39.TreeNode root,Holder h)
    {
        if (root == null)
        {
            h.n = 0;
            return true;
        }
        Holder l = new Holder(),r = new Holder();
        if (f(root.left,l)&&f(root.right,r)){
            if (l.n - r.n >1 || r.n - l.n >1)
            {
                return false;
            }
            h.n += (l.n > r.n ? l.n:r.n)+1;
            return true;
        }
        return false;
    }
}
