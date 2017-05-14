package NewCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/14.
 */
public class T6
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<String> set = new HashSet<String>();
        while(n!=0)
        {
            char[] array = scanner.next().toCharArray();
            Arrays.sort(array);
            set.add(String.valueOf(array));
            n--;
        }
        scanner.close();
        System.out.println(set.size());
    }
}
