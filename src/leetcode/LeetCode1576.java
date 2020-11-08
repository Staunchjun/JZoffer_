package leetcode;

import java.util.*;

public class LeetCode1576 {
    public static String modifyString(String s) {
        /**
         * 仅包含小写英文字母和 '?' 字符的字符串 s
         *
         * 将所有的 '?' 转换为若干小写字母，
         * 使最终的字符串不包含任何 连续重复 的字符。
         */
        Queue<Integer> indexes = new LinkedList<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            char temp = s.charAt(i);
            if (temp == '?') {
                //注意，这里是有要求，有要求是要同时满足，同时满足这样分上下就不对了额
                char replaceChar = 'a';
                //看左是否连续重复, 如果左边不存在则用默认。看右是否连续重复, 如果右边不存在则用默认。
                if (i > 0 && i < ss.length - 1){
                    //存在则判断当前的replaceChar是否和左边的一致,一致则+1
                    int leftIndex = i - 1;
                    int rightIndex = i + 1;
                    char rightChar = ss[rightIndex];
                    char leftChar = ss[leftIndex];
                    //同时满足这样
                    while (replaceChar == rightChar || replaceChar == leftChar){
                        replaceChar++;
                    }
                }
                //最左边 不等于右边即可
                if (i == 0 && i + 1 <= ss.length - 1){
                    int rightIndex = i + 1;
                    char rightChar = ss[rightIndex];
                    if (rightChar == replaceChar){
                        replaceChar++;
                    }
                }
                //最右边 不等于左边即可
                if (i == ss.length - 1 && i - 1 >= 0 ){
                    int leftIndex = i - 1;
                    char leftChar = ss[leftIndex];
                    if (leftChar == replaceChar){
                        replaceChar++;
                    }
                }
                ss[i] = replaceChar;
            }
        }
        return String.valueOf(ss);
    }

    public static void main(String[] args) {
//        String test1 = "?zs";
//        String test2 = "ubv?w";
//        String test3 = "j?qg??b";
//        String test4 = "??yw?ipkj?";
//        String test5= "?";
        String test6= "??";

//        System.out.println(modifyString(test1));
//        System.out.println(modifyString(test2));
//        System.out.println(modifyString(test3));
//        System.out.println(modifyString(test4));
//        System.out.println(modifyString(test5));
        System.out.println(modifyString(test6));
    }
}
