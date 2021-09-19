package company.didi;

import java.util.*;

/**
 * Created by Staunchjun on 2017/8/26.
 */
public class didi01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(" ");

        int[] a = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            a[i] = Integer.parseInt(ss[i]);
        }
        int k = scanner.nextInt();
        System.out.println(GetLeastNumbers_Solution(a, k));
    }

    private static int partition(int[] num, int low, int high) {
        int tmp = num[low];
        while (low < high) {
            while ((low < high) && tmp >= num[high])//（1）
                high--;
            num[low] = num[high];
            while ((low < high) && tmp <= num[low])//（2）
                low++;
            num[high] = num[low];
        }
        num[low] = tmp;
        return low;
    }

    private static int quickSort(int[] num, int low, int high, int k) {
        if (low <= high) {
            int pos = partition(num, low, high);
            if (pos == k - 1)
                return num[pos];
            else if (pos > k - 1)
                return quickSort(num, low, pos - 1, k);
            else
                return quickSort(num, pos + 1, high, k);
        } else
            return -1;
    }

    private static int GetLeastNumbers_Solution(int[] a, int k) {

        return quickSort(a, 0, a.length-1, k);
    }


}
