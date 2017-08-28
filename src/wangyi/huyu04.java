package wangyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Staunchjun on 2017/8/26.
 */
public class huyu04 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length() == 0) System.out.println();
        int len = s.length();
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Character> kuohao = new Stack<Character>();
        StringBuffer a = unzip(s, len, stringBuffer,kuohao);
        System.out.println(a.toString());
    }

    private static StringBuffer unzip(String s, int len, StringBuffer stringBuffer,Stack<Character> kuohao) {

        for (int i = 0; i < len; i++) {
                kuohao.push(s.charAt(i));
                if (s.charAt(i) == '}')
                {
                    StringBuffer temp = new StringBuffer();
                    while (kuohao.peek() != '{')
                    {
                        if (kuohao.pop() == '}')
                            continue;
                        temp.append(kuohao.pop());
                    }
                    temp.reverse();
                    String repeatS = temp.toString();
                    kuohao.pop();//把｛弹出
                    Character num = kuohao.pop();
                    int Repeatnum = Integer.parseInt(String.valueOf(num));
                    for (int j = 0; j < Repeatnum-1; j++) {
                        temp.append(repeatS);
                    }
                    String finalString = temp.toString();
                    for (int j = 0; j < finalString.length(); j++) {
                        kuohao.push(finalString.charAt(j));
                    }
                }
        }
        StringBuffer stringBuffer1 = new StringBuffer();
        while (!kuohao.isEmpty())
        {
            stringBuffer1.append(kuohao.pop());
        }
        return stringBuffer1.reverse();
//
//        for (int i = 0; i < len;) {
//            if (s.charAt(i) <= '9'&& s.charAt(i) >= '0')
//            {
//                int repeatNum = Integer.parseInt(String.valueOf(s.charAt(i)));
//                int count = 0;
//                while (s.charAt(i+2+count) != '}')
//                {
//                    count++;
//
//                }
//                String temp = s.substring(i+2,i+2+count);
//                unzip(temp,count,stringBuffer);
//                for (int j = 0; j < repeatNum; j++) {
//                    stringBuffer.append(temp);
//                }
//                i = i+2+count+1;
//            }
//            else {
//
//                stringBuffer.append(s.charAt(i));
//                i++;
//            }
//        }
//        return stringBuffer;
    }

}
