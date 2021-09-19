package company.TX;

/**
 * Created by Administrator on 2017/4/25.
 */
/*小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
你能帮帮小Q吗？
输入描述:
输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
输出描述:
对于每组数据，输出移位后的字符串。
输入例子:
AkleBiCeilD
输出例子:
kleieilABCD
*/
//其实用冒泡的方法就可以了
import java.util.Scanner;
public class TX2 {
    public static void main(String [] args){
        Scanner  sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char [] c =str.toCharArray();
            int n=c.length-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n-i;j++){
                    if(c[j]>='A'&&c[j]<='Z'&&c[j+1]<='z'&&c[j+1]>='a'){
                        char tmp=c[j];
                        c[j]=c[j+1];
                        c[j+1]=tmp;
                    }
                }
            }
            System.out.println(new String(c));
        }
    }
}
