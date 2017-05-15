/**
 * Created by Administrator on 2017/5/15.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 输入描述:
 题目保证输入的数组中没有的相同的数字
 数据范围：
 对于%50的数据,size<=10^4
 对于%75的数据,size<=10^5
 对于%100的数据,size<=2*10^5
 输入例子:
 1,2,3,4,5,6,7,0
 输出例子:
 7
 */
public class T36 {
    public int InversePairs(int [] array) {
        if (array == null || array.length <= 0)
            return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            copy[i] = array[i];
        }
        int count = CombineAndCompare(array,copy,0,array.length-1);
        return count;
    }

    private int CombineAndCompare(int[] array, int[] copy, int start, int end) {
        if (start == end)
        {
            return 0;
        }
        int mid = (end + start)/2;
        int left = CombineAndCompare(array,copy,start,mid)%1000000007;
        int right = CombineAndCompare(array,copy,mid+1,end)%1000000007;
        int i = mid;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i>=start && j > mid)
        {
            if (array[i]>array[j])
            {
                copy[indexCopy--] = array[i--];
                count += j-mid;
                if(count>=1000000007)
                {
                    count = count%1000000007;
                }
            }else {
                copy[indexCopy--] = array[j--];
            }
        }
        for (;i>=start;i--)
        {
            copy[indexCopy--] = array[i];
        }
        for (;j>mid;j--)
        {
            copy[indexCopy--] = array[j];
        }
        for (int k = start; k <= end; k++) {
            array[k] = copy[k];
        }
        return (count+left+right)%1000000007;
    }
}
