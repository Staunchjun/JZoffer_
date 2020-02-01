package leetcode;

public class LeetCode461 {
    /**
     * 异或运算：相同的为0，不同的为1
     * 将两个数做异或运算，然后计算1的个数即是答案。
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        LeetCode461 hammingDistance = new LeetCode461();
        System.out.println(hammingDistance.hammingDistance(1,4));

    }
}
