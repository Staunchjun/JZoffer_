package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode401 {
    private static int[] hour;
    private static int[] minute;

    public static List<String> readBinaryWatch(int num) {
        hour = new int[]{1, 2, 4, 8};
        minute = new int[]{1, 2, 4, 8, 16, 32};
        int[] combination = new int[2];
        List<String> res = new ArrayList<>();
        backtrack(num, res, combination, 0);
        return res;
    }

    public static void main(String[] args) {
        List<String> res = readBinaryWatch(3);
        for (String s:res) {
            System.out.println(s);
        }
    }
    private static void backtrack(int row, List<String> res, int[] combination, int start) {
        /**
         * 结束条件
         */
        if (row == 0) {
            if (combination[1] < 10) {
                res.add(combination[0] + ":0" + combination[1]);
            } else {
                res.add(combination[0] + ":" + combination[1]);
            }
            return;
        }
        /**
         * 开始做选择哪一个
         */
        for (int i = start; i < hour.length + minute.length; i++) {
            /**
             * 做选择 , 先从小时开始
             */
            if (i < hour.length) {
                combination[0] += hour[i];
                /**
                 * 如果num次数的范围内，不到12，继续加 做下一个决策,
                 * 要多加一个参数，记录i跑到哪里了，有木有超过小时的，i超过小时的直接进入选分钟的
                 */
                if (combination[0] < 12) {
                    backtrack(row - 1, res, combination, i + 1);
                }
                /**
                 * 决策数分支的决策做完了，撤销之前的操作
                 */
                combination[0] -= hour[i];
            } else {
                /**
                 * 小时的选完了选 分钟的
                 */
                combination[1] += minute[i - hour.length];
                /**
                 * 如果num次数的范围内，不到60，继续加  做下一个决策
                 */
                if (combination[1] < 60) {
                    backtrack(row - 1, res, combination, i + 1);
                }
                /**
                 * 决策数分支的决策做完了，撤销之前的操作
                 */
                combination[1] -= minute[i - hour.length];
            }
        }
    }
}
