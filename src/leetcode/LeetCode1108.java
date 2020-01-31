package leetcode;

public class LeetCode1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }
    public static void main(String[] args) {
        LeetCode1108 leetCode1108 = new LeetCode1108();
        String address = "1.1.1.1";
        String address2 = "255.100.50.0";
        System.out.print(leetCode1108.defangIPaddr(address)+System.lineSeparator());
        System.out.print(leetCode1108.defangIPaddr(address2)+System.lineSeparator());
    }
}
