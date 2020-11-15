package leetcode;

import java.util.*;

public class LeetCode1233 {

    public static void main(String[] args) {
        String[] t1 = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        String[] t2 = {"/a", "/a/b/c", "/a/b/d"};
        String[] t3 = {"/a/b/c", "/a/b/d", "/a/b/ca"};
        LeetCode1233 leetCode1233 = new LeetCode1233();
        System.out.println(Arrays.deepToString(leetCode1233.removeSubfolders(t1).toArray()));
        System.out.println(Arrays.deepToString(leetCode1233.removeSubfolders(t2).toArray()));
        System.out.println(Arrays.deepToString(leetCode1233.removeSubfolders(t3).toArray()));
    }

    private List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        TreeNode root = new TreeNode("/");
        Arrays.sort(folder, (a, b) -> {
            return a.length() - b.length();
        });
        for (int i = 0; i < folder.length; i++) {
            if (!isCover(folder[i], root)) {
                res.add(folder[i]);
            }
        }

        return res;
    }

    private boolean isCover(String s, TreeNode root) {
        boolean isCover = false;
        String[] segments = s.split("/");
        TreeNode tempRoot = root;
        for (int i = 1; i < segments.length; i++) {
            TreeNode child = tempRoot.children.get(segments[i]);
            if (Objects.isNull(child)) {
                child = new TreeNode(segments[i]);
            } else {
                if (child.isPath) {
                    isCover = true;
                }
            }
            if (i == segments.length - 1 && !isCover) {
                child.isPath = true;
            }
            tempRoot.children.put(segments[i], child);
            tempRoot = child;
        }
        return isCover;
    }

    private class TreeNode {
        String name;
        Map<String, TreeNode> children = new HashMap<>();
        boolean isPath = false;

        TreeNode(String name) {
            this.name = name;
        }
    }
}
