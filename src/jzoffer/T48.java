package jzoffer;

/**
 * Created by Administrator on 2017/5/25.
 */
public class T48 {
    public static int StrToInt(String str) {
        if (str.equals("")||str.length()==0)return 0;
        char[] strs = str.toCharArray();
        int sign = 0;
        if (strs[0]=='-')
        {
            sign = 1;
        }
        int temp=0;
        for (int i = sign; i < strs.length; i++) {
                if (strs[i] == '+')
                {
                    continue;
                }
            if (strs[i] > '9'||strs[i] < '0')
            {
                return 0;
            }
            temp = temp*10+(strs[i] - '0');
        }
        return sign == 0?temp:temp*-1;

    }
    public static void main(String[] args)
    {
        System.out.println(StrToInt("123"));
    }
}
