package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] record = new int[26];
        /**
         * 记录所有字符的最大下标
         */
        for (int i = 0; i < S.length(); i++) {
            record[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int max = 0;
        for (int i = 0; i < S.length(); i++) {
            int maxIndex = record[S.charAt(i) - 'a'];
            if (maxIndex > max) {
                max = maxIndex;
            }
            if (i == max) {
                res.add(max - start + 1);
                start = max + 1;
            }
        }
        return res;
    }

    /**
     * 输入: S = "ababcbacadefegdehijhklij"
     * 输出: [9,7,8]
     * 解释:
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-labels
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode763 leetCode763 = new LeetCode763();
        String S = "ababcbacadefegdehijhklij";
        System.out.println(Arrays.deepToString(leetCode763.partitionLabels(S).toArray()));

    }
}
