package huawei;

import java.util.*;

public class hw11 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] ss = line.split(" ");
        String num = ss[0];
        String beitihuan = ss[1];
        String tihuan = ss[2];

        char[] chars = num.toCharArray();
        ArrayList<Integer> inedxes = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]-'0' == Integer.parseInt(beitihuan))
            {
                inedxes.add(i);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer s:inedxes) {
            stringBuffer.append(s);
        }
        List<List<Character>> s = new ArrayList<>();
        ArrayList<Character> allIndex=new ArrayList();
        char[] chs = stringBuffer.toString().toCharArray();
        combiantion(chs,allIndex,s);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(num));
        for (int i = 0; i < s.size(); i++) {
            List<Character> index = s.get(i);
            char[] temp = chars.clone();
            for (int k = 0; k < index.size(); k++) {
                char zifu = index.get(k);
                int index_temp = zifu-'0';
                temp[index_temp] = tihuan.toCharArray()[0];
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            for (char a:temp) {
                stringBuffer2.append(a);
            }
            String sssss =  stringBuffer2.toString();

            list.add(Integer.parseInt(sssss));
    }
        Collections.sort(list);
        Collections.reverse(list);
        int countt = 0;
        for (Integer o:list) {
            if (countt == list.size()-1)
            {
                System.out.print(o);
            }
            else {
                System.out.print(o + ",");
            }
            countt++;


        }
    }

    public static void combiantion(char chs[],List<Character> list,List s){
        if(chs==null||chs.length==0){
            return ;
        }

        for(int i=1;i<=chs.length;i++){
            combine(chs,0,i,list,s);
        }
    }

    //从字符数组中第begin个字符开始挑选number个字符加入list中
    public static void combine(char []cs,int begin,int number,List<Character> list,List s){
        if(number==0){
            s.add(list);
            System.out.println(list.toString());
            return ;
        }
        if(begin==cs.length){
            return;
        }
        list.add(cs[begin]);
        combine(cs,begin+1,number-1,list,s);
        list.remove((Character)cs[begin]);
        combine(cs,begin+1,number,list,s);
    }

}
