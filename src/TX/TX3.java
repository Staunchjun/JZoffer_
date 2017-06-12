package TX;


/**
 * Created by Administrator on 2017/4/25.
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？
 输入描述:
 输入包含多组测试数据。
 对于每组测试数据：
 N - 本组测试数据有n个数
 a1,a2...an - 需要计算的数据
 保证:
 1<=N<=100000,0<=ai<=INT_MAX.
 输出描述:
 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
 输入例子:
 6
 45 12 45 32 5 6
 输出例子:
 1 2
 */

import java.util.*;

public class TX3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();}
        Arrays.sort(nums);
        if (nums[0] == nums[N-1])
        {
            int tmp = (N*(N-1))/2;
            System.out.print(tmp+" "+tmp);
            return;
        }
        //map 统计
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        //计算最大值和最小值的个数，这里开始算差值最大
        List<Integer> keySet = new ArrayList<>(map.keySet());
        int val1 = map.get(keySet.get(0));
        int maxInd = keySet.size()-1;
        int val2 = map.get(keySet.get(maxInd));
        int MaxDifCount = val1*val2;
        //这里开始算差值最小必定相邻差值最小
        int MinDifCount = 0;
        if (map.size() == N) {
            int MinDifValue = Integer.MAX_VALUE;
            for (int i = 1; i < N ; i++) {
                if (MinDifValue > Math.abs(nums[i] - nums[i -1])) {
                    MinDifValue = Math.abs(nums[i] - nums[i -1]);
                    MinDifCount = 1;
                } else if (MinDifValue == Math.abs(nums[i] - nums[i -1])) {
                    MinDifCount++;
                }
            }
        }
        else
        {
            for (Integer key:map.keySet()) {
                int val = map.get(key);
                if (val > 1 )
                {
                    MinDifCount += (val*(val-1))/2;
                }
            }
        }
        System.out.print(MinDifCount+" "+MaxDifCount);
    }
}
