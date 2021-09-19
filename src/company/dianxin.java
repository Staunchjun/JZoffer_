package company;

import java.util.Scanner;
public class dianxin {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            int len = s.length();
            char[] sc = s.toCharArray();
            StringBuffer stringbuffer = new StringBuffer();

            for(int i=0; i<26; i++){
                char c = (char)(i+'A');
                for(int j=0; j<len; j++){
                    if(sc[j] == c || sc[j] == (char)(c+32)){
                        stringbuffer.append(sc[j]);
                    }
                }
            }

            for(int i=0; i<len; i++){
                if(!(sc[i] >= 'A' && sc[i] <= 'Z' || sc[i] >= 'a' && sc[i] <= 'z')){
                    stringbuffer.insert(i, sc[i]);
                }
            }
            System.out.println(stringbuffer.toString());
        }

    }
}