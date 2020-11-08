package leetcode;

public class Leetcode42 {

    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int sum = 0;
        int dataSum = 0;
        int high = 1;
        for (int i = 0; i <= end; i++) {
            dataSum += height[i];
        }
        while (start <= end){
            while (start <= end && height[start] < high){
                start++;
            }
            while (start <= end && height[end] < high){
                end--;
            }
            high++;
            sum += end - start + 1;
        }

        return sum - dataSum;
    }
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Leetcode42 leetcode42 = new Leetcode42();
        System.out.println(leetcode42.trap(height));
    }
}
