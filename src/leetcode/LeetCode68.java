package leetcode;

import java.util.*;

public class LeetCode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        //分组
        List<String> res = new ArrayList<>();
        Queue<String> temp = new LinkedList<>();
        int width = maxWidth;
        int curMaxSize = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= width) {
                width -= words[i].length();
                curMaxSize += words[i].length();
                //空格
                width--;
                temp.add(words[i]);
            } else {
                width = maxWidth;
                i--;
                //这一行已经满了 temp 清空
                int restSpaceNum = maxWidth - curMaxSize;
                int wordsNum = temp.size();
                int blankNum = restSpaceNum / wordsNum;
                int leftNum = restSpaceNum % wordsNum;
                //补齐空格把 少年
                StringBuilder stringBuilder = new StringBuilder();
                boolean isFirst = true;
                while (!temp.isEmpty()) {
                    String tempString = temp.poll();
                    if (isFirst) {
                        stringBuilder.append(tempString);
                        for (int j = 0; j < blankNum; j++) {
                            stringBuilder.append("*");
                        }
//                        if (leftNum > 0) {
//                            leftNum--;
//                            stringBuilder.append("*");
//                        }
                    } else if (temp.isEmpty()) {
                        if (leftNum > 0) {
                            leftNum--;
                            stringBuilder.append("*");
                        }
                        for (int j = 0; j < blankNum; j++) {
                            stringBuilder.append("*");
                        }
                        stringBuilder.append(tempString);
                    } else {
                        int leftRightNum = 0;
                        int left = 0;
                        if (leftNum > 0) {
                            leftNum--;
                            leftRightNum = (blankNum + 1) / 2;
                            left = (blankNum + 1) % 2;
                        } else {
                            leftRightNum = (blankNum) / 2;
                            left = blankNum % 2;
                        }

                        for (int j = 0; j < leftRightNum + left; j++) {
                            stringBuilder.append("*");
                        }
                        stringBuilder.append(tempString);
                        for (int j = 0; j < leftRightNum; j++) {
                            stringBuilder.append("*");
                        }
                    }
                    isFirst = false;
                }
                curMaxSize = 0;
                res.add(stringBuilder.toString());
            }
        }

        //最后一行
        int restSpaceNum = maxWidth - curMaxSize;
        //补齐空格把 少年

        StringBuilder stringBuilder = new StringBuilder();
        while (!temp.isEmpty()) {
            String tempString = temp.poll();
            stringBuilder.append(tempString);
            restSpaceNum--;
            stringBuilder.append("*");
        }
        for (int j = 0; j < restSpaceNum; j++) {
            stringBuilder.append("*");
        }
        res.add(stringBuilder.toString());
        return res;
    }

    //特殊情况1， 如果是最后一行， 单词之间只占一个空格
//特殊情况2， 如果一行只有一个单词， 补齐右边的空格
//普通情况 左侧放置的空格数要多于右侧的空格数
    public static void main(String[] args) {
        String[] t1 = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] t2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] t3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        LeetCode68 leetCode68 = new LeetCode68();
        for (String temp : leetCode68.fullJustify(t1, 16)) {
            System.out.println(temp);
        }
        for (String temp : leetCode68.fullJustify(t2, 16)) {
            System.out.println(temp);
        }
        for (String temp : leetCode68.fullJustify(t3, 20)) {
            System.out.println(temp);
        }
    }
}
