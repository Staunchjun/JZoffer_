package company.wangyi;

import java.util.*;

/**
 * Created by Administrator on 2017/5/31.
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，
 * 但是小易想是对于每种元素保留最后出现的那个。
 * 小易遇到了困难,希望你来帮助他。
 */
public class C4_2017 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
        int n = scanner.nextInt();
        int[] arrs = new int[n];
        for (int i = 0; i < n; i++) {
            arrs[i] = scanner.nextInt();
        }
        ArrayList list = new ArrayList();
        for (int i = n-1; i >= 0; i--) {
            if (!list.contains(arrs[i]))
                list.add(arrs[i]);
        }
        for (int i = list.size()-1; i >=0; i--) {
            System.out.print(list.get(i));
            if (i != 0)
            {
            System.out.print(" ");
            }
        }
    }
}
}
