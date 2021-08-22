package leetcode;

public class LeetCode1028 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        char[] str = S.toCharArray();
        return dfs(str ,0);
    }

    int curIndex = 0;
    private TreeNode dfs(char[] str, int curDepth) {
        int val = 0;
        while(curIndex < str.length &&  str[curIndex] != '-' ){
            val = val * 10 + (str[curIndex] - '0');
            curIndex++;
        }
        TreeNode root = new TreeNode(val);
        // get - num
        int num = 0;
        while(curIndex < str.length &&  str[curIndex] == '-'){
            num++;
            curIndex++;
        }
        if (num > curDepth)
            root.left = dfs(str, curDepth + 1);
        if (num > curDepth)
            root.right = dfs(str, curDepth + 1);

        return root;
    }
}
