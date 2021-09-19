package company.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class huawei22 {
    public  static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        String[]  l1s =line1.split("-");
        String[]  l2s =line2.split("-");
        HashMap<String,Integer> map = new HashMap();
        for (int i = 0; i < l1s.length; i++) {
            String s = l1s[i];
            map.put(s,1);
        }
        String first = null;
        int count = 0;
        for (int i = 0; i < l2s.length; i++) {
            if (map.containsKey(l2s[i]))
            {
                if (count == 0)
                {
                    System.out.print(l2s[i]+" ");
                }
                count++;
            }
        }
        System.out.print(count);
        }
    }

