package leetcode;

public class LeetCode374 {
    public static void main(String[] args) {
        LeetCode374.checkResult(6, LeetCode374.guessNumber(10));
    }

    private static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int res = guess(mid);
            if (res == 1) {
                right = mid;
            } else if (res == 0) {
                return left;
            } else if (res == -1) {
                left = mid + 1;
            }
        }
        return left;
    }

    private static void checkResult(int expect, int actual) {
        if (expect == actual) {
            System.out.println("Pass!");
        } else {
            System.out.println("Fail!");
        }
    }

    /**
     * 此接口应为父类实现，此处省略。
     *
     * @param num
     * @return
     */
    private static int guess(int num) {
        return 1;
    }
}
