package leetcode;

import java.util.Comparator;
import java.util.TreeSet;

public class LeetCode414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> priorityQueue = new TreeSet<>(new Comparator<Integer>() {
            /**
             * 从小到大排列，每次剔除最小
             * @param integer
             * @param t1
             * @return
             */
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer.compareTo(t1);
            }
        });
        for (int j : nums) {
            if (priorityQueue.size() < 3) {
                priorityQueue.add(j);
            } else {
                if (priorityQueue.contains(j)){
                    continue;
                }
                if (priorityQueue.first() < j) {
                    priorityQueue.pollFirst();
                    priorityQueue.add(j);
                }
            }
        }
        if (priorityQueue.size() < 3){
            return priorityQueue.pollLast();
        }else {
            return priorityQueue.pollFirst();
        }
    }

    public static void main(String[] args) {
        int[] num1 = {3,2,1};
        int[] num2 = {1,2};
        int[] num3 = {2,2,3,1};
        int[] num4 = {1,2,2};
        int[] num5 = {1,2,2,5,3,5};
        LeetCode414 leetCode414 = new LeetCode414();
//        System.out.println(leetCode414.thirdMax(num1));
//        System.out.println(leetCode414.thirdMax(num2));
//        System.out.println(leetCode414.thirdMax(num3));
        System.out.println(leetCode414.thirdMax(num5));
    }
}
