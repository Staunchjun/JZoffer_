package leetcode;

public class LeetCode914 {
    public boolean hasGroupsSizeX(int[] deck) {
        /**
         * 1 <= deck.length <= 10000
         * 0 <= deck[i] < 10000
         */
        int len = deck.length;
        int[] decks = new int[10000];
        for (int value : deck) {
            decks[value]++;
        }
        target: for (int X = 2; X <= len; X++) {
            if (len % X == 0){
                for (int deccc:decks) {
                    if (deccc > 0 && deccc % X != 0){
                        continue target;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一副牌，每张牌上都写着一个整数。
     *
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     *
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * @param args
     */
    public static void main(String[] args) {
        LeetCode914 leetCode914 = new LeetCode914();
        int[] num1 = {1,2,3,4,4,3,2,1};//可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
        int[] num2 = {1,1,1,2,2,2,3,3};//没有满足要求的分组。
        int[] num3 = {1};//没有满足要求的分组。
        int[] num4 = {1,1};//可行的分组是 [1,1]
        int[] num5 = {1,1,2,2,2,2};//可行的分组是 [1,1]，[2,2]，[2,2]
        System.out.println(leetCode914.hasGroupsSizeX(num1));
        System.out.println(leetCode914.hasGroupsSizeX(num2));
        System.out.println(leetCode914.hasGroupsSizeX(num3));
        System.out.println(leetCode914.hasGroupsSizeX(num4));
        System.out.println(leetCode914.hasGroupsSizeX(num5));
    }
}
