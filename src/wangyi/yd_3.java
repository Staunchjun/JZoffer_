package wangyi;

import java.util.*;

/**
 * Created by Staunchjun on 2017/8/12.
 */
public class yd_3 {
    public static int CrazyLine(ArrayList<Integer> hight, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        Collections.sort(hight);
        ArrayList<Integer> temp = hight;
        int sum = 0;
        if (n == 1)
            return 0;
        else if (n == 2) {
            return Math.abs(hight.get(0) - hight.get(1));
        } else if (n == 3) {
            return Math.abs(hight.get(2) - hight.get(0) + hight.get(2) - hight.get(1));
        }
        int allHight_max = hight.get(n - 1);
        temp.remove(n - 1);
        int left1 = hight.get(0);
        int right1 = hight.get(1);
        int a1 = left1;
        int b1 = right1;
        int left2 = hight.get(temp.size() - 1);
        int right2 = hight.get(temp.size() - 2);
        int visit = 0;
        Do:
        while (temp.size() > 0) {
            if (temp.size() == 1) {
                sum = sum + Math.max(Math.abs(temp.get(0) - left2), Math.abs(temp.get(0) - right2));
                break Do;
            } else if (temp.size() == 2) {
                sum = sum + Math.max(Math.abs(temp.get(1) - left2), Math.abs(temp.get(1) - temp.get(0))) + Math.abs(temp.get(0) - right2);
                break Do;
            } else if (temp.size() == 3) {
                sum = sum + Math.abs(temp.get(0) - left2) + Math.abs(temp.get(1) - right2) + Math.abs(temp.get(0) - temp.get(2));
                break Do;
            }
            left1 = temp.get(0);
            temp.remove(0);
            if (visit == 1) {
                sum = sum + Math.abs(left1 - left2);
            }
            right1 = temp.get(0);
            temp.remove(0);
            if (visit == 1) {
                sum = sum + Math.abs(right1 - right2);
            }
            left2 = temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            right2 = temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            visit = 1;
            sum = sum + (left2 - left1 + right2 - right1);
        }
        sum = sum + Math.abs(allHight_max - a1 + allHight_max - b1);
        return sum;
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> hight = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hight.add(in.nextInt());
        }
        int res = CrazyLine(hight, n);
        System.out.println(res);
    }
}
