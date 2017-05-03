
/**
 * Created by Administrator on 2017/5/3.\
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class T24 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        int SEQ_LENTH = sequence.length;
        if (SEQ_LENTH<= 0||sequence == null)
        {return false;}
        int root = sequence[SEQ_LENTH-1];
        int i = 0;
        for (; i <SEQ_LENTH-1; i++) {
            if (root < sequence[i])
            {
                break;
            }
        }
        int j = i;
        for (; j < SEQ_LENTH-1; j++) {
            if (sequence[j] < root)
            {
                return false;
            }
        }
        boolean left = true;
        if (i>0)
        {
            int[] NEW_SEQ = new int[i];
            for (int k = 0;k<i;k++)
            {
                NEW_SEQ[k] = sequence[k];
            }
            left = VerifySquenceOfBST(NEW_SEQ);
        }
        boolean right = true;
        int y = 0;
        if (i<SEQ_LENTH-1)
        {
            int[] NEW_SEQ = new int[SEQ_LENTH-i-1];
            for (int k = i;k<SEQ_LENTH-1;k++)
            {
                NEW_SEQ[y] = sequence[k];
                y++;
            }
            right = VerifySquenceOfBST(NEW_SEQ);
        }

    return left&right;
    }
}
