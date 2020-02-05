package leetcode;
public class LeetCode1095 {
    interface MountainArray {
        public int get(int index);

        public int length();
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = findPeakIndex(mountainArr);

        int leftResult = findInLeft(target, mountainArr,peak);
        if (leftResult != -1){
            return leftResult;
        }
        int rightResult = findInRight(target, mountainArr,peak);
        if (rightResult != -1){
            return rightResult;
        }
        return -1;
    }

    private int findPeakIndex(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (mountainArr.get(mid + 1) > mountainArr.get(mid)){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    private int findInLeft(int target, MountainArray mountainArr, int peak) {
        int left = 0;
        int right = peak;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (mountainArr.get(mid) < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if (mountainArr.get(left) != target) {
            return -1;
        }
        return left;
    }

    private int findInRight(int target, MountainArray mountainArr, int peak) {
        int left = peak;
        int right = mountainArr.length() - 1;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (mountainArr.get(mid) > target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if (mountainArr.get(left) != target) {
            return -1;
        }
        return left;
    }
}
