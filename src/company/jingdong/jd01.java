package company.jingdong;

import java.util.*;

public class jd01 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int len = s.length();
        int tol = 0;
        long ans =1;
        for (int i = len-1; i >= 0 ; i--) {
            if (s.charAt(i) == ')')
                tol++;
            else if (s.charAt(i) == '(') {
                    ans = ans * tol;
                    tol--;
                }
        }
        System.out.println(ans);
    }

}
