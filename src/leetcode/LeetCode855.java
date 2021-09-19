package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LeetCode855 {

    TreeSet<Integer> treeSet = new TreeSet<>();
    int max = Integer.MIN_VALUE;

    public LeetCode855(int n) {
        this.max = n - 1;
    }

    public static void main(String[] args) {
        LeetCode855 leetCode855 = new LeetCode855(10);
        System.out.println(leetCode855.seat());
        System.out.println(leetCode855.seat());
        System.out.println(leetCode855.seat());
        System.out.println(leetCode855.seat());
        leetCode855.leave(4);
        System.out.println(leetCode855.seat());
    }

    public int seat() {
        // 没有人在考场里，那么学生坐在 0 号座位上
        if (treeSet.isEmpty()) {
            treeSet.add(0);
            return 0;
        }

        // 这里有两个坑点
        // 最左的数字和 0 比较。
        // 最右的数字和 max 比较。
        int num = 0;
        int left = treeSet.first();
        int right = treeSet.last();
        int pre = -1;
        for (int cur : treeSet) {
            // 如果是第一个 则先设置pre
            if (pre == -1) {
                pre = cur;
                continue;
            }

            int diff = (cur - pre) / 2;
            if (diff > left){
                left = diff;
                num = pre + diff;
            }

            pre = cur;
        }

        if (max - right > left){
            num = max;
        }
        treeSet.add(num);
        return num;

    }

    public void leave(int p) {
        treeSet.remove(p);
    }
}
