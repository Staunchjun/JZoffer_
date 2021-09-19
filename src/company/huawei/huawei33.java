package company.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class huawei33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] ss = line.split(" ");
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < ss.length; i++) {
                int num = Integer.parseInt(ss[i]);
                if (map.containsKey(num)) {
                    int count = map.get(num);
                    count++;
                    map.put(num, count);
                } else {
                    map.put(num, 1);
                }
            }
            int count = 0;
            int len = map.size();
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (count < len-1) {
                    stringBuffer.append(e.getKey() + " ");
                    stringBuffer.append(e.getValue() + " ");
                } else {
                    stringBuffer.append(e.getKey() + " ");
                    stringBuffer.append(e.getValue());
                }
                count++;
            }
            System.out.print(stringBuffer.toString());
        }
    }
}