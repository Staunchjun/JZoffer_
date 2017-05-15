import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017/5/13.
 *在一个字符串(1<=字符串长度<=10000，
 * 全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class T35 {
        public int FirstNotRepeatingChar(String str) {
            LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char w = str.charAt(i);
                if (map.containsKey(w))
                {
                    int count = map.get(w);
                    map.put(w,++count);
                }else {
                    map.put(w,1);
                }
            }
            int pos = -1;
            for (int i = 0; i <str.length() ; i++) {
                char w = str.charAt(i);
                if (map.get(w) == 1)
                {
                    return i;
                }

            }

            return pos;
        }
}
