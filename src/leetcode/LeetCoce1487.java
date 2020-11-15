package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LeetCoce1487 {
    public static void main(String[] args) {
        LeetCoce1487 leetCoce148 = new LeetCoce1487();
        String[] t1 = {"pes", "fifa", "gta", "pes(2019)"};
        String[] t2 = {"gta", "gta(1)", "gta", "avalon"};
        String[] t3 = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)"};
        String[] t4 = {"wano", "wano", "wano", "wano"};
        String[] t5 = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
//        System.out.println(Arrays.deepToString(leetCoce148.getFolderNames(t1)));
//        System.out.println(Arrays.deepToString(leetCoce148.getFolderNames(t2)));
//        System.out.println(Arrays.deepToString(leetCoce148.getFolderNames(t3)));
//        System.out.println(Arrays.deepToString(leetCoce148.getFolderNames(t4)));
        System.out.println(Arrays.deepToString(leetCoce148.getFolderNames(t5)));
    }

    private String[] getFolderNames(String[] names) {
        final String suffix = "(%d)";
        HashMap<String, Integer> set = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (set.containsKey(name)) {
                int count = set.get(name);
                while (set.containsKey(name.concat(String.format(suffix, count)))) {
                    count++;
                }
                set.put(name.concat(String.format(suffix, count)), 1);
                set.put(name, set.get(name) + 1);
                names[i] = name.concat(String.format(suffix, count));
            } else {
                set.put(name, 1);
            }
        }
        return names;
    }

    /**
     * 超时了
     * 想想优化的方法吧
     * 这里面的do while其实是可以优化的，能不能不do while
     * 或者do while的次数少一点
     *
     * @param names
     * @return
     */
    private String[] getFolderNames1(String[] names) {
        final String suffix = "(%d)";
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (set.contains(name)) {
                int count = 1;
                String uniqueName;
                do {
                    uniqueName = name.concat(String.format(suffix, count));
                    count++;
                } while (set.contains(uniqueName));
                set.add(uniqueName);
                names[i] = uniqueName;
            } else {
                set.add(name);
            }
        }
        return names;
    }
}
