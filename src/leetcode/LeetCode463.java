package leetcode;

public class LeetCode463 {
    /**
     * 输入:
     * [[0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,0],
     * [1,1,0,0]]
     * <p>
     * 输出: 16
     * <p>
     * 解释: 它的周长是下面图片中的 16 个黄色的边：
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/island-perimeter
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                /**
                 * 1个1代表=周长为4，如果两个相接，则周长为4+4-2=6
                 * 即各自少一个边。
                 */
                if (grid[i][j] == 1) {
                    count += 4;
                    /**
                     * 右边看有没有
                     */
                    if (i < row - 1 && grid[i + 1][j] == 1) {
                        count -= 2;
                    }
                    /**
                     * 下边看有没有
                     */
                    if (j < col - 1 && grid[i][j + 1] == 1) {
                        count -= 2;
                    }
                }
            }
        }

        return count;
    }
}
