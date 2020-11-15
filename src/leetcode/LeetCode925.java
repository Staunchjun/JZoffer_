package leetcode;

public class LeetCode925 {
    /**
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     * <p>
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/long-pressed-name
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param name
     * @param typed
     * @return
     */
    public static boolean isLongPressedName(String name, String typed) {
        int nameLen = name.length();
        int typedLen = typed.length();

        //肯定是少输入了
        if (typedLen < nameLen) {
            return false;
        }

        int indexName = 0, indexTyped = 0;
        while (indexName < nameLen && indexTyped < typedLen) {
            char tempName = name.charAt(indexName);
            char tempTyped = typed.charAt(indexTyped);

            if (tempName == tempTyped) {
                indexTyped++;
                indexName++;
            } else if (indexTyped > 0 && tempTyped == typed.charAt(indexTyped - 1)) {
                indexTyped++;
            } else {
                return false;
            }
        }
        if (indexTyped < typedLen) {
            char c = name.charAt(nameLen - 1);
            while (indexTyped < typedLen) {
                if (c == typed.charAt(indexTyped))
                    indexTyped++;
                else
                    return false;
            }
        }
        return indexName == nameLen;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("saeed", "ssaaeedd"));
        System.out.println(isLongPressedName("saeed", "ssaaeeedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));
    }
}
