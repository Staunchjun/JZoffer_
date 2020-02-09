package leetcode;

import java.util.Arrays;

public class LeetCode654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
     * <p>
     * 二叉树的根是数组中的最大元素。
     * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
     * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
     * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        /**
         * 找最大
         */
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        /**
         * 找到最大后最右分开
         */
        int[] newLeft = Arrays.copyOfRange(nums,0,index);
        root.left = constructMaximumBinaryTree(newLeft);
        int[] newRight = Arrays.copyOfRange(nums,index + 1,len);
        root.right = constructMaximumBinaryTree(newRight);
        /**
        for (int i:newLeft) {
            System.out.print(i + " ");
        }
        System.out.print(System.lineSeparator());
        for (int i:newRight) {
            System.out.print(i + " ");
        }
         **/
        return root;
    }

    public static void main(String[] args) {
        LeetCode654 leetCode654 = new LeetCode654();
        int[] nums = new int[]{3,2,1,6,0,5};
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{3,1};
        leetCode654.constructMaximumBinaryTree(nums);
        leetCode654.constructMaximumBinaryTree(nums1);
        leetCode654.constructMaximumBinaryTree(nums2);
    }
}
