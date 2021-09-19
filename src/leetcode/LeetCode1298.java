package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int len = status.length;
        // 记录盒子是否被拆开
        boolean[] visited = new boolean[len];
        //记录我们拥有的所有盒子
        Set<Integer> haveBox = new HashSet<>();
        // 记录我们拥有的所有钥匙
        Set<Integer> havekey = new HashSet<>();
        // 放所有可以打开的盒子
        Queue<Integer> q = new LinkedList<>();
        // 初始化
        for (int boxIndex : initialBoxes) {
            haveBox.add(boxIndex);
            // 如果盒子可以打开则加入队列
            if (status[boxIndex] == 1) {
                q.offer(boxIndex);
                visited[boxIndex] = true;
            }
        }

        int sum = 0;
        while (!q.isEmpty()) {
            int boxIndex = q.poll();
            sum += candies[boxIndex];
            int[] nextKeys = keys[boxIndex];
            for (int nextKeyIndex : nextKeys) {
                havekey.add(nextKeyIndex);
            }
            int[] nextBoxes = containedBoxes[boxIndex];
            for (int nextBoxIndex : nextBoxes) {
                // 如果没有放进去过，且已经是开了的就直接放进去
                if (!visited[nextBoxIndex] && status[nextBoxIndex] == 1){
                    q.offer(nextBoxIndex);
                    visited[nextBoxIndex] = true;
                }
                haveBox.add(nextBoxIndex);
            }

            // 取交集
            Set<Integer> result = new HashSet<>(haveBox);
            result.retainAll(havekey);
            // 各自去除 交集
            haveBox.removeAll(result);
            havekey.removeAll(result);
            // 有钥匙，又有盒子，就不用管他是什么状态了。
            for (Integer index : result) {
                // 如果没有放进去过，有钥匙且是关闭的，就放进去。有钥匙但是打开的，前面已经放进去了
                if (!visited[index] && status[index] == 0){
                    q.offer(index);
                    visited[index] = true;
                }
            }

        }
        return sum;
    }
}
