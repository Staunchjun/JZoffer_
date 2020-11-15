package leetcode;

import java.util.*;

public class LeetCode1417 {
    public static String reformat(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Character> chars = new LinkedList<>();
        Queue<Character> numbers = new LinkedList<>();
        recordChars(s, chars, numbers);
        if (chars.size() != numbers.size() && chars.size() - 1 != numbers.size() && numbers.size() - 1 != chars.size()) {
            return stringBuilder.toString();
        }

        if (numbers.size() > chars.size()) {
            while (!chars.isEmpty() || !numbers.isEmpty()) {
                appNumber(stringBuilder, numbers);
                appNumber(stringBuilder, chars);
            }
        } else {
            while (!chars.isEmpty() || !numbers.isEmpty()) {
                appNumber(stringBuilder, chars);
                appNumber(stringBuilder, numbers);
            }
        }
        return stringBuilder.toString();
    }

    private static void recordChars(String s, Queue<Character> chars, Queue<Character> numbers) {
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            if (tempChar <= 'z' && tempChar >= 'a') {
                chars.add(tempChar);
            } else {
                numbers.add(tempChar);
            }
        }
    }

    private static void appNumber(StringBuilder stringBuilder, Queue<Character> numbers) {
        if (!numbers.isEmpty()) {
            stringBuilder.append(numbers.poll());
        }
    }

    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
        System.out.println(reformat("ab1c2"));
        System.out.println(reformat("a01c2"));
        System.out.println(reformat("leetcode"));
        System.out.println(reformat("1229857369"));
        System.out.println(reformat("covid2019"));
    }
}
