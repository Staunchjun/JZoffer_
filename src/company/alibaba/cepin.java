package company.alibaba;

import java.util.*;
public class cepin {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int cut(int[] parts) {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Arrays.sort(parts);
        for (int p : parts)
        {
            queue.add(p);
        }
        int cost = 0;
        while (!queue.isEmpty()) {
            Integer min1 = queue.poll();
            Integer min2 = queue.poll();
            if (min1 != null && min2 !=null) {
                Integer sum = Integer.sum(min1, min2);
                cost += sum;
                if (queue.size() != 0)
                queue.add(sum);
            }
            else {
                cost += min1;
            }
        }
        return cost;

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        int[] parts = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(cut(parts));
    }
}