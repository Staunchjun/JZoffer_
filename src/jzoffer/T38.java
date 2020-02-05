package jzoffer;

/**
 * Created by Administrator on 2017/5/16.
 * 统计一个数字在排序数组中出现的次数
 * 注意:這個數組是排序的
 */
public class T38 {
    public static int GetNumberOfK(int[] array, int k) {
        int number = 0;
        if (array.length <= 0 || array == null) {
          return 0;
        }
        int first = GetFirstK(array, array.length, k, 0, array.length - 1);
        int end = GetLastK(array, array.length, k, 0, array.length - 1);
        if (first > -1 && end > -1) {
            number = end - first + 1;
        }
        return number;
    }
    private static int GetFirstK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        //注意：mid是start+end，你要求的是start和end兩個index之間的mid值，所以不是用end-start
        int mid = (start+end) / 2;
        if (array[mid] > k) {
            end = mid - 1;
        } else if (array[mid] < k) {
            start = mid + 1;
        } else {
            if (mid > 0 && array[mid - 1] != k || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        }
        return GetFirstK(array, length, k, start, end);

    }

    private static int GetLastK(int[] array, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start+end) / 2;
        if (array[mid] > k) {
            end = mid - 1;

        } else if (array[mid] < k) {
            start = mid + 1;
        } else {
            if (mid <length-1 && array[mid + 1] != k || mid == length-1) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return GetLastK(array,length, k, start, end);
    }
    public static void main(String[] args)
    {
        int[] array = new int[]{1,2,3,3,3,3};
      System.out.print( GetNumberOfK(array,3));
    }
}
