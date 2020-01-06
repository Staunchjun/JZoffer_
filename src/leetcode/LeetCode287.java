package leetcode;

public class LeetCode287 {
        int left = 1;
        int right = nums.length;
         while (left < right) {
            int mid = (left + right) >>> 1;
            int count = 0;
            for(int num : nums){
                if(num <= mid){
                    count += 1;
                }
            }
            if(count > mid){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
}
