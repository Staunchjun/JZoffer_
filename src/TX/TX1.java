package TX;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/25.
 */
//public class Main{}

//给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
/*输出需要删除的字符个数。

输入描述:

输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.

输出描述:
对于每组数据，输出一个整数，代表最少需要删除的字符个数。
输入例子:
abcda
google

输出例子:
2
2
*/
import java.util.Scanner;

public class TX1     {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            System.out.println(str.length()-getResult(str));
        }
    }

    private static int getResult(String str) {
        StringBuilder sb=new StringBuilder(str);
        String newstr=sb.reverse().toString();
        char[] c1=str.toCharArray();
        char[] c2=newstr.toCharArray();
        int len=newstr.length();
        int dp[][]=new int[len+1][len+1];
        for(int i=1;i<len+1;i++){
            for(int j=1;j<len+1;j++){
                if(c1[i-1]==c2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[len][len];
    }
}