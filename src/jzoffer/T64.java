package jzoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/4/27.
 */
public class T64 {
    public class Solution {
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        private int count = 0;
        public void Insert(Integer num) {
            if (count %2 == 0)
            {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }else {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());

            }
            count++;

        }

        public Double GetMedian() {
            if (count %2 ==0)
            {
                return (maxHeap.peek()+minHeap.peek())/(2.0);
            }
            else
            {
                return new Double(minHeap.peek());
            }
        }


    }
}
