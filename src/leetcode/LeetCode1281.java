package leetcode;

public class LeetCode1281 {
    public int subtractProductAndSum(int n) {
        String num = String.valueOf(n);
        int bigger = 1;
        int smaller = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int temp = Integer.parseInt(String.valueOf(c));
            bigger *= temp;
            smaller += temp;
        }
        return bigger - smaller;
    }
    public static void main(String[] args) {
        LeetCode1281 leetCode1281 = new LeetCode1281();
        System.out.println(leetCode1281.subtractProductAndSum(234));
        System.out.println(leetCode1281.subtractProductAndSum(4421));
    }
}
