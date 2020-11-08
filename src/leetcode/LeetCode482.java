package leetcode;

public class LeetCode482 {

    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        S = S.replaceAll("-", "");
        if (S.length() < K){
            return S;
        }
        int num = S.length() / K;
        int first = S.length() % K;
        StringBuilder stringBuilder = new StringBuilder(S);
        int i = K;
        if (first != 0) {
            stringBuilder.insert(first, "-");
            i++;
            i = i + first;
        }
        for (; i < S.length() + num - 1; i = i + K) {
            stringBuilder.insert(i, "-");
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     * 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，
     * 重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，
     * 第一个分组至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，
     * 并且将所有的小写字母转换为大写字母。
     * <p>
     * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode482 leetCode482 = new LeetCode482();
//        System.out.println(leetCode482.licenseKeyFormatting("5F3Z-2e-9-w-i-i-i-i", 4));
//        System.out.println(leetCode482.licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(leetCode482.licenseKeyFormatting("2", 2));
    }
}
