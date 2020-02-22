package leetcode;

public class LeetCode1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += Math.max(Math.abs(points[i+1][0] - points[i][0]),Math.abs(points[i+1][1] - points[i][1]));
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode1266 leetCode1266 = new LeetCode1266();
        int[][] points = new int[][]{ {1,1},{3,4},{-1,0}};
        System.out.println(leetCode1266.minTimeToVisitAllPoints(points));

    }
}
