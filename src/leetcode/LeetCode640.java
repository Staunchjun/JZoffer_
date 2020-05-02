package leetcode;

public class LeetCode640 {
    public static void main(String[] args) {
        LeetCode640 leetCode640 = new LeetCode640();
        System.out.println(leetCode640.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(leetCode640.solveEquation("x=x"));
        System.out.println(leetCode640.solveEquation("2x=x"));
        System.out.println(leetCode640.solveEquation("2x+3x-6x=x+2"));
        System.out.println(leetCode640.solveEquation("x=x+2"));
        System.out.println(leetCode640.solveEquation("3x=33+22+11"));
    }

    /**
     * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
     * 如果方程没有解，请返回“No solution”。
     * 如果方程有无限解，则返回“Infinite solutions”。
     * 如果方程中只有一个解，要保证返回值 x 是一个整数。
     * 示例 1：
     * 输入: "x+5-3+x=6+x-2"
     * 输出: "x=2"
     * 示例 2:
     * 输入: "x=x"
     * 输出: "Infinite solutions"
     * 示例 3:
     * 输入: "2x=x"
     * 输出: "x=0"
     * 示例 4:
     * 输入: "2x+3x-6x=x+2"
     * 输出: "x=-1"
     * 示例 5:
     * 输入: "x=x+2"
     * 输出: "No solution"
     *
     * @param equation
     * @return
     */
    private String solveEquation(String equation) {
        final String noSolution = "No solution";
        final String infiniteSolutions = "Infinite solutions";
        /**
         * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。
         * 该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
         */
        String[] parts = equation.split("=");
        /**
         *         "x+5-3+x=6+x-2"
         *         1 x+5-3+x -> +x+5-3+x
         *         2 6+x-2   -> +6+x-2
         *         2个一组进行处理。带有x的放到x里
         *         把x都整合都左边，常数整合到右边
         */
        String left = parts[0];
        String right = parts[1];
        Res leftRes = new Res(0, 0);
        Res rightRes = new Res(0, 0);
        CalcPart(leftRes, left);
        CalcPart(rightRes, right);
        //把x都整合都左边，常数整合到右边
        int xNum = leftRes.xNum - rightRes.xNum;
        int normalNum = rightRes.normalNum - leftRes.normalNum;
        if (normalNum == 0 && xNum == 0) {
            return infiniteSolutions;
        }
        if (xNum == 0) {
            return noSolution;
        }
        int res = normalNum / xNum;
        return "x=" + res;
    }

    private void CalcPart(Res res, String string) {
        StringBuilder temp = new StringBuilder(string);
        temp = AddPlusSign(temp);
        for (int i = 0; i < temp.length(); ) {
            //+x+5-3+2x
            char sign = temp.charAt(i);
            // parse 2
            i++;
            char num = temp.charAt(i);
            if (num == 'x') {
                ProcessSingleX(res, sign);
            } else {
                i = ProcessNum(res, temp, i, sign);
            }
            //next
            i++;
        }
    }

    private void ProcessSingleX(Res res, char sign) {
        //+x
        if (sign == '-') {
            res.xNum--;
        } else {
            res.xNum++;
        }
    }

    private int ProcessNum(Res res, StringBuilder temp, int i, char sign) {
        //33334x
        int start = i;
        int len = temp.length();
        while ('0' <= temp.charAt(i) && temp.charAt(i) <= '9') {
            i++;
            if (i == len) {
                break;
            }
        }
        int end = i;

        int tempNum = Integer.parseInt(temp.substring(start, end));
        if (sign == '-') {
            tempNum = -tempNum;
        }

        // 查看的时候要看一下是不是最后一个
        if (i >= temp.length() || temp.charAt(i) != 'x') {
            i--;
            // 整合常数
            res.normalNum += tempNum;
        } else {
            // 整合x的系数\
            res.xNum += tempNum;
        }
        return i;
    }

    private StringBuilder AddPlusSign(StringBuilder temp) {
        // 先看第一个数字前面有没有-号，没有就加上+号
        if (temp.charAt(0) != '-') {
            temp = new StringBuilder("+").append(temp);
        }
        return temp;
    }

    class Res {
        int xNum;
        int normalNum;

        Res(int xNum, int normalNum) {
            this.xNum = xNum;
            this.normalNum = normalNum;
        }
    }
}
