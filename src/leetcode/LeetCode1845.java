package leetcode;

import java.util.PriorityQueue;

public class LeetCode1845 {
    PriorityQueue<Integer> spare = new PriorityQueue<>();

    public LeetCode1845(int n) {
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                continue;
            }
            spare.add(i);
        }
    }

    public int reserve() {
        int orderId = spare.poll();
        return orderId;
    }

    public void unreserve(int seatNumber) {
        spare.add(seatNumber);
    }
}
