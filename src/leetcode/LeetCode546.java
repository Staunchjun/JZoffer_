package leetcode;

public class LeetCode546 {
    public int removeBoxes(int[] boxes) {
        return dfs(boxes, 0, boxes.length - 1, 0);
    }

    private int dfs(int[] boxes, int start, int end, int sameNum) {
        if (end < start) {
            return 0;
        }

        while (end > start && boxes[end] == boxes[end - 1]) {
            end--;
            sameNum++;
        }

        int ret = 0;
        int sum = dfs(boxes, start, end - 1, 0) + (sameNum + 1) * (sameNum + 1);
        // 任选中间节点k
        for (int k = start; k < end; k++) {

            // 如果当前数字 和 start的数字为相同的，则可以算为同一个
            if (boxes[k] == boxes[end]) {
                int temp = dfs(boxes, start, k, sameNum + 1) + dfs(boxes, k + 1, end - 1, 0);
                ret = Math.max(temp, sum);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode546 leetCode546 = new LeetCode546();
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println(leetCode546.removeBoxes(boxes));
    }
}
