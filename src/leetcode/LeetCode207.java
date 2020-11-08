package leetcode;

import java.util.*;

public class LeetCode207 {
    class Node {
        int in;
        int out;
        int visited;
        int val;
        List<Integer> inAdjs;
        List<Integer> outAdjs;

        public Node(Integer val) {
            this.val = val;
            visited = 0;
            in = 0;
            out = 0;
            inAdjs = new ArrayList<>();
            outAdjs = new ArrayList<>();
        }

        public void setIn(int i) {
            in++;
            inAdjs.add(i);
        }

        public void setOut(int i) {
            out++;
            outAdjs.add(i);
        }
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return false;
        }
        Map<Integer, Node> maps = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int inNode = prerequisite[0];
            int outNode = prerequisite[1];

            Node in = maps.getOrDefault(inNode, new Node(inNode));
            in.setIn(outNode);
            maps.put(inNode, in);

            Node out = maps.getOrDefault(outNode, new Node(outNode));
            out.setOut(inNode);
            maps.put(outNode, out);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node t1, Node t2) {
                return t1.in - t2.in;
            }
        });
        /**
         * 把所有入度为0的放进来
         */
        for (Map.Entry<Integer, Node> entry : maps.entrySet()) {
            if (entry.getValue().in == 0) {
                priorityQueue.add(maps.get(entry.getKey()));
            }
        }
        /**
         * 如果没有入度为0的，则说明有环了
         */
        if (priorityQueue.isEmpty()) {
            return false;
        }

        while (!priorityQueue.isEmpty() && priorityQueue.peek().in == 0) {
            /**
             * 先把入度为0的弹出来
             */
            Node node = priorityQueue.poll();
            for (int i = 0; i < node.outAdjs.size(); i++) {
                Node nextNode = maps.get(node.outAdjs.get(i));
                nextNode.in--;
                nextNode.inAdjs.remove(new Integer(node.val));
                maps.put(node.outAdjs.get(i), nextNode);
                priorityQueue.add(nextNode);
            }
            maps.remove(node.val);
        }
        int i = 0;
        return maps.isEmpty() && priorityQueue.isEmpty();
    }

    /**
     * 还是用邻接矩阵把....
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0){
            return true;
        }
        int[] indegree = new  int[numCourses];
        /**
         * 出度图把 ，方便查询
         */
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
        {
            indegree[i] = 0;
            graph.put(i,new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            List<Integer> out = graph.getOrDefault(prerequisites[i][1],new ArrayList<>());
            out.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1],out);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0){
                priorityQueue.add(i);
            }
        }
        int cnt = 0;
        while (!priorityQueue.isEmpty()){
            int top = priorityQueue.poll();
            cnt++;
            for (int i = 0; i < graph.get(top).size(); i++) {
                indegree[graph.get(top).get(i)]--;
                if (indegree[graph.get(top).get(i)] == 0){
                    priorityQueue.add(graph.get(top).get(i));
                }
            }
        }
        return cnt == numCourses;
    }
    /**
     * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     * <p>
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     *
     * @param args
     */
    public static void main(String[] args) {
        LeetCode207 leetCode207 = new LeetCode207();
        int[][] nums1 = new int[][]{{1, 0}};
        int[][] nums2 = new int[][]{{1, 0}, {0, 1}};
        int[][] nums3 = new int[][]{{1, 0}, {2, 6}, {1, 7}, {5, 1}, {6, 4}, {7, 0}, {0, 5}};
        int[][] nums4 = new int[][]{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}};
        System.out.println(leetCode207.canFinish(2, nums1));
        System.out.println(leetCode207.canFinish(2, nums2));
        System.out.println(leetCode207.canFinish(8, nums3));
        System.out.println(leetCode207.canFinish(7, nums4));
    }
}
