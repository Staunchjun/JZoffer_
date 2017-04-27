
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017/4/20.
 */
public class T55 {
    LinkedHashMap<Character, Integer> map=new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {

        if(map.containsKey(ch)) {
            map.remove(ch);
        }
        else
        {
            map.put(ch,1);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char c = '#';
        Iterator<Character> it = map.keySet().iterator();
        if (it.hasNext())
        {
            Character iterator = it.next();
            return iterator;

        }
        else
        {
            return c;
        }
    }
}
