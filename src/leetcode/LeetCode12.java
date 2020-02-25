package leetcode;

public class LeetCode12 {
    public String intToRoman(int num) {
        /**
         * Special + Normal
         */
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] nums = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]){
                num -= values[i];
                stringBuilder.append(nums[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode12 leetCode12 = new LeetCode12();
        System.out.println(leetCode12.intToRoman(3));
        System.out.println(leetCode12.intToRoman(4));
        System.out.println(leetCode12.intToRoman(9));
        System.out.println(leetCode12.intToRoman(58));
        System.out.println(leetCode12.intToRoman(1994));
        System.out.println(leetCode12.intToRoman(3999));
    }
}
