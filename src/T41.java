import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/22.
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class T41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
       if (sum<3)return lists;
       int s = (int)Math.sqrt(2*sum);
       for (int i =s;i>=2;i--)
       {
           if (2*sum%i == 0)
           {
               int d = 2*sum/i;
               if (d%2==0&&i%2!=0||d%2!=0&&i%2==0)
               {
                   int al = (d-i+1)/2;
                   int an = (d+i-1)/2;
                   ArrayList<Integer> temp = new ArrayList<>();
                   for (int j= al;j<=an;j++)
                       temp.add(j);
                   lists.add(temp);
               }
           }
       }
       return lists;
    }
}
