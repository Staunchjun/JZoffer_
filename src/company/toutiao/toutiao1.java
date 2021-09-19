package company.toutiao;

import java.util.*;

/**
 * Created by Staunchjun on 2017/8/22.
 */
public class toutiao1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        List lists = new ArrayList();
        for (int i = 0; i < n; i++) {
            List list = new ArrayList();
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            list.add(x);
            list.add(y);
            lists.add(list);
        }
        List<List> prlong = new ArrayList<List>();
        //即是点的右上方没有点，即是x,y都要比原点大的不存在
        for (int i = 0; i < n; i++) {
            List wait2compare = (List) lists.get(i);
            boolean isMax = true;
            for (int j = 0; j < n; j++) {

                List temp = (List) lists.get(j);
                long wait2compare_x = (long) wait2compare.get(0);
                long wait2compare_y = (long) wait2compare.get(1);
                long temp_x = (long) temp.get(0);
                long temp_y = (long) temp.get(1);
                if (temp_x > wait2compare_x && temp_y > wait2compare_y) {
                    isMax = false;
                    break;
                }
            }
            if (isMax) {
                prlong.add(wait2compare);
            }
        }
        Collections.sort(prlong, new Comparator<List>() {
            @Override
            public int compare(List o1, List o2) {
                if ((long)o1.get(0) > (long)o2.get(0))
                    return 1;
                else
                    return -1;
            }
        });
        for (List a:prlong) {
            System.out.print(a.get(0)+" ");
            System.out.print(a.get(1));
            System.out.println();
        }

    }
}
