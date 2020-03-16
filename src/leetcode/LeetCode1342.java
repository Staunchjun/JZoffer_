package leetcode;

public class LeetCode1342 {
    public int numberOfSteps (int num) {
        /**
         * -2 --> oxfffffffe
         */
        int count = 0;
        while (num != 0){
            count++;
            /**
             * 判断奇数还是偶数，看最后一位是不是为1，是1为奇数，非为偶数
             */
            num  = (num & 1) == 1 ? num & -2 : num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1342 leetCode1342 = new LeetCode1342();
        System.out.println(leetCode1342.numberOfSteps(14));
        System.out.println(leetCode1342.numberOfSteps(8));
    }
}
