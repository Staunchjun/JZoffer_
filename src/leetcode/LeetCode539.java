package leetcode;

import java.net.CookieHandler;
import java.util.*;

public class LeetCode539 {
    /**
     * 两个问题，
     * 1，相同的时间怎么解决。
     * 2.24周期，60周期，这个算应该怎么算。
     *
     * @param timePoints
     * @return
     */
    public static int findMinDifference(List<String> timePoints) {
        HashSet<Integer> lists = new HashSet<>();
        for (String tempTime1 : timePoints) {
            String[] t1Segments = tempTime1.split(":");
            int hour1 = Integer.parseInt(t1Segments[0]);
            int min1 = Integer.parseInt(t1Segments[1]);
            int total1 = hour1 * 60 + min1;
            if (lists.contains(total1)){
                return 0;
            }else {
                lists.add(total1);
            }
        }
        List<Integer> res =  new ArrayList<>(lists);
        Collections.sort(res);
        int min = Integer.MAX_VALUE;
        //排序过后，找出两两差值，形成一个环
        for (int i = 1; i < res.size() ; i++) {
            int res1 = res.get(i-1);
            int res2 = res.get(i);
            int diff = res2 - res1;
            if (min > diff){
                min = diff;
            }
        }
        //计算最小和最大之间的差值
        int diff1 = (res.get(0) + 60*24 - res.get(res.size() - 1) );
        if (diff1 < min){
            min = diff1;
        }
        return min;
    }

    public static void main(String[] args) {
        String[] t1 = {"23:59", "00:00"};
        String[] t2 = {"00:00", "23:59", "00:00"};
        System.out.println(findMinDifference(Arrays.asList(t1)));
        System.out.println(findMinDifference(Arrays.asList(t2)));
    }
}
