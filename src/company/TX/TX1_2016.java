package company.TX;

/**
 * Created by Administrator on 2017/6/11 0011.
 * [编程题] 生成格雷码
 * 时间限制：3秒
 * 空间限制：32768K
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，
 * 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 * 测试样例：
 * 1
 * 返回：["0","1"]
 */
public class TX1_2016 {
    public static void main(String[] args) {
        int n = 3;
        String[] resStrs = getGray(n);
        for (String s:resStrs) {
            System.out.println(s);
        }
    }
    private static String[] getGray(int n) {
        String[] resStrs = null;
        if (n == 1)resStrs = new String[]{"0","1"};
        else {
            String[] strs = getGray(n - 1);
            resStrs = new String[2*strs.length];
            for (int i = 0; i < strs.length; i++) {
                resStrs[i] = "0"+strs[i];
                //重点在这里。0-1的转换，这里的结尾相当于1的开始。010-110  10前加0/1
                resStrs[resStrs.length-1-i] = "1"+strs[i];
            }
        }
        return resStrs;
    }
}
