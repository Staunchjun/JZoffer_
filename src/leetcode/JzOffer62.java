package leetcode;

import java.util.ArrayList;
import java.util.List;

public class JzOffer62 {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int c = (m - 1) % n;
        while (list.size() != 1) {
            list.remove(c);
            c = (c + m - 1) % list.size();
        }
        return list.get(0);
    }

    public int lastRemaining1(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i);
        while (list.size() > 1) {
            for (int j = 0; j < m; j++) {
                if (j != m - 1)
                    list.add(list.get(0));
                list.remove(0);
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        JzOffer62 jzOffer62 = new JzOffer62();
        System.out.println(jzOffer62.lastRemaining1(5, 3));
        System.out.println(jzOffer62.lastRemaining1(10, 17));
    }
}
