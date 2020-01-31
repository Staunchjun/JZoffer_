package leetcode;

public class LeetCode1295 {
    public int findNumbers(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            int length = String.valueOf(num).length();
            if (length % 2 == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1295 leetCode1295 = new LeetCode1295();
        int[] numbs = new int[]{12,345,2,6,7896};
        System.out.print(leetCode1295.findNumbers(numbs));
    }
}
