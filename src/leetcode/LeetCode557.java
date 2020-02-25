package leetcode;

public class LeetCode557 {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String t : ss) {
            stringBuilder.append((new StringBuilder(t)).reverse().toString());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        LeetCode557 leetCode557 = new LeetCode557();
        String test = "Let's take LeetCode contest";
        System.out.println(leetCode557.reverseWords(test));
    }
}
