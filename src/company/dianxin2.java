package company;

import java.util.ArrayList;
import java.util.Scanner;

public class dianxin2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<Integer> list = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        int sum = 0;
        boolean contain = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)<'0' || s.charAt(i)>'9')
            {
                if (contain)
                {
                    list.add(sum);
                }
                sum = 0;
                contain = false;
                continue;
            }
            else{
                contain = true;
                sum = sum*10+s.charAt(i)-'0';
                if (i == s.length()-1)
                {
                    list.add(sum);
                    break;
                }
            }

        }
        if (list.size() >= 1)
        {
            System.out.print(list.get(0));
        }
        for (int i = 1; i < list.size(); i++) {
            System.out.print(" "+list.get(i));
        }

    }
}
