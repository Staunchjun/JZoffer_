package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode633 {
    /**
     * 还是老老实实二分法把
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum1(int c) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i * i <= c; i++) {
            int b = c - i * i;
            if (binary_search(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b){
                return true;
            }
        }
        return false;
    }

    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }

    private boolean search(int s, int e, int b) {
        while (s < e){
            int mid = (s + e) >>> 1;
            int temp  = mid * mid;
             if (temp <= b){
                s = mid + 1;
            }else {
                e = mid;
            }
        }
        if (s*s == b){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode633 leetCode633 = new LeetCode633();
//        System.out.println(leetCode633.judgeSquareSum(1));
//        System.out.println(leetCode633.judgeSquareSum(0));
//        System.out.println(leetCode633.judgeSquareSum(5));
        System.out.println(leetCode633.judgeSquareSum(8));
    }
}
