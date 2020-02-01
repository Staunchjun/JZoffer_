package leetcode;

public class LeetCode79 {
    private boolean[][] marked;
    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int col;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        col = board[0].length;
        marked = new boolean[m][col];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        /**
         * 先写退出的条件吧
         * 当索引等于单词长度的时候，表示找完了所有的，可以返回
         * 这里到了最后一个需要判断下是否相等，既然都走到这里了
         * 最后一个相等就OK啦
         */
        if (start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }

        /**
         * 判断是否和word里的字母一样
         */
        if (board[i][j] == word.charAt(start)){
            /**
             * 标志一下，已经走过了
             */
            marked[i][j] = true;
            /**
             * 上下左右地走呗
             */
            for (int[] direction:directions) {
                int x = i+direction[0];
                int y = j+direction[1];
                /**
                 * 注意边界啊, 以及判断下有没有走过
                 */
                if (inArea(x,y) && !marked[x][y]){
                    /**
                     * 这里别用++start,如果用了++start会影响别的
                     *  好好用start+1不行吗，非要对start自增？
                     */
                    if (dfs( x,  y,   start+1 )){
                        return true;
                    }
                }
            }

            /**
             * 恢复下标志位，还记得回溯吗23333,就是排列组合
             * 第一种你试过了，总要恢复下标志位吧
             */
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int i,int j){
        return i < m && j < col && i >= 0 && j >= 0;
    }

    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "ABCCED";

//        char[][] board = {{'a', 'b'}};
//        String word = "ba";
        LeetCode79 solution = new LeetCode79();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }

}
