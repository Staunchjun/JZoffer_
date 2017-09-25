import java.util.*;

public class dianxin3 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] nums_sorted = nums.clone();
        Arrays.sort(nums_sorted);
        Map<Integer,Integer> maps = new HashMap<>();
        int count = 1;
        maps.put(nums_sorted[0],1);
        for (int i = 1; i < n; i++) {
            if (nums_sorted[i] != nums_sorted[i-1])
            {
                count++;
            }
            maps.put(nums_sorted[i],count);
        }
        ArrayList list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(maps.get(nums[i]));
        }
        if (list.size()>=1)
            System.out.print(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            System.out.print(" "+ list.get(i));
        }
    }
}
