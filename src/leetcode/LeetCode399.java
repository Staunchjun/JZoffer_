package leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class LeetCode399 {
    class Node {
        String son;
        double nodeDiveSon;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        /**
         * create a map
         */
        int len1 = equations.size();
        int len2 = values.length;
        if (len1 != len2) {
            return null;
        }
        Set<String> visited = new HashSet<>();
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            Node aInfo = new Node();
            aInfo.son = b;
            aInfo.nodeDiveSon = values[i];
            List<Node> aInfos = graph.getOrDefault(a, new ArrayList<>());
            aInfos.add(aInfo);
            graph.put(a, aInfos);

            Node bInfo = new Node();
            bInfo.son = a;
            bInfo.nodeDiveSon = 1.0 / values[i];
            List<Node> bInfos = graph.getOrDefault(b, new ArrayList<>());
            bInfos.add(bInfo);
            graph.put(b, bInfos);
        }
        int len = queries.size();
        double[] res = new double[len];
        for (int i = 0; i < len; i++) {
            List<String> queried = queries.get(i);
            res[i] = dfs(graph, queried.get(0), queried.get(1), visited, 1.0);
            visited.clear();
        }

        return res;
    }

    private double dfs(Map<String, List<Node>> graph, String s, String end, Set<String> visited, double value) {
        visited.add(s);
        List<Node> nodes = graph.get(s);
        if (nodes == null) {
            return -1;
        }
        for (Node node : nodes) {
            double temp = node.nodeDiveSon * value;
            if (end.equals(node.son)) {
                return temp;
            }
            if (visited.contains(node.son)) {
                continue;
            }
            /**
             * 这里是关键，如果是走向不存在分支，染的res肯定是-1。
             * 这里的值通过temp去传递，一直找到目标
             */
            double res = dfs(graph, node.son, end, visited, temp);
            if (res > 0) {
                return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));
        double[] values = {3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x1", "x5"));
        queries.add(Arrays.asList("x5", "x2"));
        queries.add(Arrays.asList("x2", "x4"));
        queries.add(Arrays.asList("x2", "x2"));
        queries.add(Arrays.asList("x2", "x8"));
        LeetCode399 leetCode399 = new LeetCode399();
        for (double d : leetCode399.calcEquation(equations, values, queries)) {
            System.out.print(d + " ");
        }
    }
}