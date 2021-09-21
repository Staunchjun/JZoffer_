package jzoffer2;

public class Jz017 {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int[] targetMap = new int[58];
        for (int i = 0; i < t.length(); i++) {
            targetMap[t.charAt(i) - 'A'] += 1;
        }
        int[] temptMap = new int[58];
        int min = Integer.MAX_VALUE;
        int targetLeft = -1;
        int targetRight = -1;
        while (left <= right && right <= s.length()) {
            if (isContain(temptMap, targetMap)) {
                if ((right - left) < min) {
                    min = (right - left);
                    targetLeft = left;
                    targetRight = right;
                }
                // 去除left上的字母
                temptMap[s.charAt(left) - 'A'] -= 1;
                left++;
            }
            // 这里有一个坑点，就是temptmap记录了后，需要在下轮循环中进行判断的，不能因为right超了而不判断/
            if (right == s.length() || left == s.length()){
                break;
            }
            temptMap[s.charAt(right) - 'A'] += 1;
            right++;
        }
        if (targetLeft == -1) {
            return "";
        }
        return s.substring(targetLeft, targetRight);
    }

    private boolean isContain(int[] temptMap, int[] targetMap) {
        for (int i = 0; i < temptMap.length; i++) {
            int diff = targetMap[i] - temptMap[i];
            // 如果diff > 0 则表示 不包含
            if (diff > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Jz017 jz017 = new Jz017();
        System.out.println(jz017.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(jz017.minWindow("a", "a"));
        System.out.println(jz017.minWindow("a", "aa"));
    }
}
