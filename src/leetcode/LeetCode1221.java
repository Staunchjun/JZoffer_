package leetcode;

public class LeetCode1221 {
    public int balancedStringSplit(String s) {
        int len = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c == 'L'){
                len++;
            }else if(c == 'R'){
                len--;
            }
            if (len == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode1221 leetCode1221 = new LeetCode1221();
        String s1 = "RLRRLLRLRL";
        String s2 = "RLLLLRRRLR";
        String s3 = "LLLLRRRR";
        System.out.println(leetCode1221.balancedStringSplit(s1));
        System.out.println(leetCode1221.balancedStringSplit(s2));
        System.out.println(leetCode1221.balancedStringSplit(s3));
    }
}
