/**
 * Created by Administrator on 2017/4/23.
 */
public class T59 {
 public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
    boolean isSymmetrical(TreeNode pRoot)
    {
//        前序遍历和自定义的前序遍历同时进行 写对称版本的遍历Hhhhhhhh 遍历的同时也在比较
        TreeNode pRoot1 = pRoot;
        TreeNode pRoot2 = pRoot;
        return  MyisSymmertrical(pRoot1,pRoot2);
    }

    private boolean MyisSymmertrical(TreeNode pRoot1, TreeNode pRoot2) {
     if (pRoot1 == null && pRoot2 == null)
     {
         return true;
     }
     if (pRoot1 == null || pRoot2 == null)
     {
         return false;
     }
//     这里不能判断相等返回true,因为这里判断到最后的递归的终止条件是上面两个
     if (pRoot1.val != pRoot2.val)
     {
         return false;
     }
//     这里的&&不是同时进行的，是先左后右的 就是先找到最左边的点以及最左边点父节点的右子节点
     return MyisSymmertrical(pRoot1.left,pRoot2.right) && MyisSymmertrical(pRoot1.right,pRoot2.left);
    }
}
