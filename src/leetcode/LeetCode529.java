package leetcode;

public class LeetCode529 {
    /**
     * 让我们一起来玩扫雷游戏！
     * <p>
     * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
     * <p>
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
     * <p>
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
     * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入:
     * <p>
     * [['E', 'E', 'E', 'E', 'E'],
     * ['E', 'E', 'M', 'E', 'E'],
     * ['E', 'E', 'E', 'E', 'E'],
     * ['E', 'E', 'E', 'E', 'E']]
     * <p>
     * Click : [3,0]
     * <p>
     * 输出:
     * <p>
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'M', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        row = board.length;
        col = board[0].length;

        int clickX = click[0];
        int clickY = click[1];

        if (board[clickX][clickY] == 'M') {
            board[clickX][clickY] = 'X';
            return board;
        } else {
            dfs(board, clickX, clickY);
        }

        return board;
    }

    private int row = 0;
    private int col = 0;

    private void dfs(char[][] board, int clickX, int clickY) {
        /**
         * 先看一下自己是不是没有走过的
         */
        if (inArea(clickX, clickY) && board[clickX][clickY] == 'E') {
            /**
             * 没有走过的
             */
            board[clickX][clickY] = 'B';
            /**
             * 看一下自己四周有没有炸弹
             */
            int count = 0;
            for (int[] dir : dirs) {
                int dirX = dir[0];
                int dirY = dir[1];
                if (inArea(clickX + dirX, clickY + dirY) && board[clickX + dirX][clickY + dirY] == 'M') {
                    count++;
                }
            }
            /**
             *如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
             *即当这个方块被计数后不再进行递归，此处应该return
             **/
            if (count != 0) {
                board[clickX][clickY] = (char) ('0' + count);
                return;
            }
            for (int[] dir : dirs) {
                int dirX = dir[0];
                int dirY = dir[1];
                dfs(board, clickX + dirX, clickY + dirY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x < row && x >= 0 && y >= 0 && y < col;
    }

    private int[][] dirs = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {-1, 1}, {1, -1}, {1, 1}, {-1, -1},
    };

    public static void main(String[] args) {
        char[][] board =
                {{'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'M', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};

        LeetCode529 leetCode529 = new LeetCode529();
        for (char[] re : leetCode529.updateBoard(board, click)) {
            for (char r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }

    }
}
