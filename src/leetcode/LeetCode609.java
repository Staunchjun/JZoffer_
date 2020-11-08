package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode609 {
    public static List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> record = new HashMap<>();
        for (String tempFolder : paths) {
            //注意：n>=1 且 m>=0。如果 m=0，则表示该目录是根目录。
            //您可以假设每个给定的目录信息代表一个唯一的目录。
            // 目录路径和文件信息用一个空格分隔。
            String[] segments = tempFolder.split(" ");
            String dir = segments[0];

            for (int i = 1; i < segments.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                String file = segments[i];
                stringBuilder.append(dir);
                stringBuilder.append('/');
                //这里有坑啊.txt分不开这个.
                //String[] fileSegments = file.split(".txt");
                String[] fileSegments = file.split("\\(");
                String fileName = fileSegments[0];
                String fileContent = fileSegments[1];

                stringBuilder.append(fileName);
//                stringBuilder.append(".txt");
                List<String> re = record.getOrDefault(fileContent, new ArrayList<>());
                re.add(stringBuilder.toString());
                record.put(fileContent, re);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : record.entrySet()) {
            //一组重复的文件至少包括二个具有完全相同内容的文件。
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};

        //您可以假设在同一目录中没有任何文件或目录共享相同的名称。
        String[] paths1 = {"root/a ", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        String[] paths2 = {"root/cflrodi/irrgfoyzwbj/q/rjytmebdlzcdakl/eozikpwsempmhuf/qaipsnreapdgye/n/kf/zq udosmfn.txt(lnmahafnssgsrgnkfosaasgyq) sditog.txt(tsuxooqqlmbrewwpysatghuowmmucqhzodpvrvhul) kwkmqvtxtnw.txt(oeqaxwnzbkowwhrwwmxfbzrqqeuxvdijtnwybyfsihb) gj.txt(oeqaxwnzbkowwhrwwmxfbzrqqeuxvdijtnwybyfsihb) khrct.txt(wrrajcclaeuzgiivqhjxjyt)"};
//        System.out.println(findDuplicate(paths));
//        System.out.println(findDuplicate(paths1));
        System.out.println(findDuplicate(paths2));
    }
}
