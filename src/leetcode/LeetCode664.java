package leetcode;

public class LeetCode664 {
    int[][] d;
    public int strangePrinter(String s) {
        d = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                d[i][j] = -1;
            }
        }
        return dfs(s, 0, s.length() - 1);
    }

    private int dfs(String s, int start, int end) {
        //终止条件
        if (start == end){
            return 1;
        }else if(start > end){
            return 0;
        }else if(end - start == 1){
            if (s.charAt(end) == s.charAt(start)){
                return 1;
            }else {
                return 2;
            }
        }

        int ans = d[start][end];
        if(ans >= 0){
            return ans;
        }

        ans = Integer.MAX_VALUE;
        for (int j = start; j <= end; j++) {
            int res;
            // a aabb
            if (j == start){
                res = 1 + dfs(s,start + 1,end);
            }else {
                if (s.charAt(j)  == s.charAt(start)){
                    // aa abbb
                    res = dfs(s, start, j - 1) + dfs(s, j + 1, end);
                }else {
                    // aaab bb
                    res = dfs(s, start, j) + dfs(s, j + 1, end);
                }
            }
            ans = Math.min(ans, res);
            d[start][end] = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode664 leetCode664 = new LeetCode664();
        System.out.println(leetCode664.strangePrinter("aaabbb"));
    }
}
