package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /**
         * Method 1
         */
        int size = arr.length;

        int left = 0;
        int right = size - 1;

        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
        /**
         * Method 2
         */
    }
}
