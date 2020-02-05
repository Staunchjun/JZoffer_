package jzoffer;

/**
 * Created by Administrator on 2017/5/23.
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后
 * 来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class T42_1 {
    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        int end = chars.length-1;
        int start = 0;
        chars = Reverse(chars,start,end);
        start = end = 0;
        int length = chars.length-1;
        while (start <= length)
        {
            if (chars[start] == ' ')
            {
                start++;
                end++;
            }
//            把这里的位置换一下 先判断 end>length 若为true则后面不判断
            else if (end>length||chars[end] == ' '){
                chars = Reverse(chars,start,--end);
                start = ++end;

            }else
            {
                end++;
            }
        }
        return new String(chars);
    }

    private static char[] Reverse(char[] chars, int start, int end) {
        while (start<end)
        {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return chars;
    }
    public  static void main(String[] args)
    {
        System.out.print(ReverseSentence("Wonderful"));
    }
}
