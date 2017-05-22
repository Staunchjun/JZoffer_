/**
 * Created by Administrator on 2017/5/16.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次
 * 请写程序找出这两个只出现一次的数字。
 */
public class T40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
       if(array == null || array.length<2)
       {
        return;
       }
       int temp = 0;
       for (int i=0;i<array.length;i++)
       {
           temp ^=array[i];
       }
       int indexOf1 = findFirstBits(temp);
       for (int i = 0;i<array.length;i++)
       {
           if (isBit(array[i],indexOf1))
               num1[0]^=array[i];
           else
               num2[0]^=array[i];
       }
    }

    private boolean isBit(int i, int indexOf1) {
        i = i>>indexOf1;
        return (i&1)==1;
    }

    private int findFirstBits(int temp) {
        int indexBit = 0;
        while ((temp & 1)==0 && (indexBit)<8*4)
        {temp = temp>>1;++indexBit;}
        return indexBit;
    }
}

