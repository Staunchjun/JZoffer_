package leetcode;

import java.util.*;

public class LeetCode621 {
    /**
     * 给定一个用字符数组表示的 CPU 需要执行的任务列表。
     * 其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
     * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
     * CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
     * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，
     * 因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
     * 你需要计算完成所有任务所需要的最短时间。
     * <p>
     * 示例 ：
     * 输入：tasks = ["A","A","A","B","B","B"], n = 2
     * 输出：8
     * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
     * 在本示例中，
     * 两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，
     * 而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
     */
    public static void main(String[] args) {
        LeetCode621 leetCode621 = new LeetCode621();
        char[] nums = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leetCode621.leastInterval(nums, 2));
        System.out.println(leetCode621.leastInterval2(nums, 2));
    }

    private int leastInterval(char[] tasks, int n) {
        final int digitalNuns = 26;
        int[] map = new int[digitalNuns];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[digitalNuns - 1] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[digitalNuns - 1] == 0) {
                    break;
                }
                if (i < digitalNuns && map[digitalNuns - 1 - i] > 0) {
                    map[digitalNuns - 1 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }

    private int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        Queue<CharacterPair> queue = new PriorityQueue<>((o1, o2) -> -(o1.count - o2.count));
        /**
         * 统计个数
         */
        for (char task : tasks) {
            characterIntegerMap.put(task, characterIntegerMap.getOrDefault(task, 0) + 1);
        }
        /**
         * 从高到低排序
         */
        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            queue.add(new CharacterPair(entry.getKey(), entry.getValue()));
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int count = 0;
            List<CharacterPair> temp = new ArrayList<>();
            /**
             * 不够n个则需要等待 所以一直time++
             */
            while (count <= n) {
                if (!queue.isEmpty()) {
                    CharacterPair maxPair = queue.poll();
                    maxPair.count -= 1;
                    if (maxPair.count != 0) {
                        temp.add(maxPair);
                    }
                } else if (temp.isEmpty()) {
                    /**
                     * 如果队列为空，且temp也为空，说明没有啥好加的
                     */
                    break;
                }
                time++;
                count++;
            }
            for (CharacterPair pair : temp) {
                queue.add(pair);
            }
        }
        return time;
    }

    class CharacterPair {
        char digital;
        int count;

        CharacterPair(char digital, int count) {
            this.digital = digital;
            this.count = count;
        }
    }
}
