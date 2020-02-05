package jzoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/8.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class T28 {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0 )
        {
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }

    private static void PermutationHelper(char[] chars, int i, ArrayList<String> res) {

        if (i == chars.length-1)
        {
            res.add(String.valueOf(chars));
        }
        else{
            Set<Character> characters  = new HashSet<>();
            for (int j = i; j <chars.length ; j++) {
                if (j == i || !characters.contains(chars[j])) {
                    characters.add(chars[j]);
                    //进行交换
                    swap(chars, i, j);
                    //交换过后的全排列，即是去掉第一个的全排列
                    PermutationHelper(chars, i + 1, res);
                    //换回来 准备和其他还没和交换的进行交换
                    swap(chars, i, j);
                }
            }
        }



    }
    private  static void swap(char[] cs ,int i ,int j)
    {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
    public static void main (String[] args)
    {
        String str ="abb";
        Permutation(str);
    }
}

