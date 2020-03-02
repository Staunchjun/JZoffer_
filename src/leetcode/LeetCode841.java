package leetcode;

import java.util.List;

public class LeetCode841 {
    private boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        for (int i = 0; i < rooms.size(); i++) {
            visited[i] = false;
        }
        dfs(rooms, 0);
        boolean isAll = true;
        for (int i = 0; i < rooms.size(); i++) {
            if (visited[i] == false) {
                isAll = false;
                break;
            }
        }
        return isAll;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        List<Integer> keys = rooms.get(i);
        for (int k : keys) {
            dfs(rooms, k);
        }
    }
}
