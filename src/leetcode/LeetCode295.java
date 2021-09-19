package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode295 {
    // 从小到大 head为最小
    PriorityQueue<Integer> minToMax = new PriorityQueue<>(Comparator.comparingInt(integer -> integer));
    // 从大到小 head 为最大
    PriorityQueue<Integer> maxToMin = new PriorityQueue<>((integer, t1) -> -(integer - t1));

    /** initialize your data structure here. */
    public LeetCode295() {
    }

    // 如何动态调整是关键, 要始终保持差值为1
    // eg 大至小: 12 13 小至大: 2 40 41 这种场景显然是不允许的
    // 我们期待 变为 1 : 2 12 2: 13 40 41
    // 即  大至小: 12 13 小至大: 40 41 插入2的时候，应该变为  大至小 : 2 12 小至大: 13 40 41
    public void addNum(int num) {
        if (minToMax.size() >= maxToMin.size()){
            // 如果想要往 maxToMin 里面放，则 需要先放进 minToMax
            // minToMax 弹出 最小值，这个最小值 放入 到 maxToMin
            minToMax.add(num);
            maxToMin.add(minToMax.poll());
        }else {
            maxToMin.add(num);
            minToMax.add(maxToMin.poll());
        }
    }

    public double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (minToMax.size() < maxToMin.size()) {
            return maxToMin.peek();
        } else if (minToMax.size() > maxToMin.size()) {
            return minToMax.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (minToMax.peek() + maxToMin.peek()) / 2.0;
    }

    public static void main(String[] args) {
        LeetCode295 leetCode295 = new LeetCode295();
        leetCode295.addNum(40);
        leetCode295.addNum(12);
        leetCode295.addNum(16);
        System.out.println(leetCode295.findMedian());
    }
}
