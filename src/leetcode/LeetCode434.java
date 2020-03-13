package leetcode;

public class LeetCode434 {
    public int countSegments(String s) {
       String[] ss = s.split(" ");
       int count = 0;
        /**
         * 这里有一个坑，就是”“会分割出空的字符串，我们需要对空字符串进行判空
         */
       for (String s1:ss){
           if (!s1.equals("")){
               count++;
           }
       }
       return count;
    }

    public static void main(String[] args) {
        String s= ", , , ,        a, eaefa";
        String s1= "";
        LeetCode434 leetCode434 = new LeetCode434();
        System.out.println(leetCode434.countSegments(s));
        System.out.println(leetCode434.countSegments(s1));
    }
}
