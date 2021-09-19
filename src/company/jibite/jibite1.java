package company.jibite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Staunchjun on 2017/8/27.
 */
public class jibite1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s =  scanner.nextLine();
//        StringBuffer stringBuffer_num = new StringBuffer();
//        StringBuffer stringBuffer_char = new StringBuffer();
        ArrayList<Character> list_num = new ArrayList<Character>();
        ArrayList<Character> list_char = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
             if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
            {
                list_num.add(s.charAt(i));
            }
            else if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a')
             {
                 list_char.add(s.charAt(i));
             }

        }
        Collections.sort(list_char);
        Collections.sort(list_num);

        for (int i = 0; i < list_char.size(); i++) {
            System.out.print(list_char.get(i));
        }
        for (int i = 0; i < list_num.size(); i++) {
            System.out.print(list_num.get(i));
        }
    }
}
