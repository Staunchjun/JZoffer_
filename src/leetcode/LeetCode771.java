package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if (jewels.contains(temp)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode771 leetCode771 = new LeetCode771();
        String J = "aA";
        String S = "aAAbbbb";
        String J2 = "z";
        String S2 = "ZZ";
        System.out.println(leetCode771.numJewelsInStones(J,S));
        System.out.println(leetCode771.numJewelsInStones(J2,S2));
    }
}
