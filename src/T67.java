/**
 * Created by Administrator on 2017/4/27.
 */
public class T67 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public int index = -1;

        String Serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            if (root == null) {
                sb.append("#,");
                return sb.toString();
            }
            sb.append(root.val + ",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
            return sb.toString();
        }

        TreeNode Deserialize(String str) {
            index++;
            int len = str.length();
            if (index >= len) {
                return null;
            }
            String[] chars = str.split(",");
            TreeNode node = null;
            if (!chars[index].equals("$")) {
                node = new TreeNode(Integer.valueOf(chars[index]));
                node.left = Deserialize(str);
                node.right = Deserialize(str);
            }
            return node;
        }
    }
}
