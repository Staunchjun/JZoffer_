import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/27.
 */
public class T65 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i<num.length;i++)
        {
            begin = i -size+1;
            if (q.isEmpty())q.add(i);
            else if (begin>q.peekFirst())q.pollFirst();
            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])q.pollLast();
            q.add(i);
            if (begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
