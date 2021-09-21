package jzoffer2;

import java.util.*;
import java.util.stream.Collectors;

public class Jz108 {
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // 存在疑问，会不会存在 wordlist 中有和beginword 不等长的，这时候怎么转换？
        HashSet<String> visited = new HashSet<>();
        HashSet<String> wordListSet = new HashSet<>(wordList);
        if (!wordListSet.contains(endWord)) {
            return 0;
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curLen = queue.size();
            // 选择把当前层的全部扩散
            for (int k = 0; k < curLen; k++) {
                String curWord = queue.poll();
                if (curWord.equals(endWord)) {
                    return count + 1;
                }
                char[] curWordArray = curWord.toCharArray();
                for (int i = 0; i < curWordArray.length; i++) {
                    char[] tempCurWordArray = Arrays.copyOf(curWordArray, curWordArray.length);
                    // 26 个字母都换一遍
                    for (int j = 0; j < 26; j++) {
                        tempCurWordArray[i] = (char) ('a' + j);
                        String nextWortd = new String(tempCurWordArray);
                        if (!visited.contains(nextWortd) && wordListSet.contains(nextWortd)) {
                            visited.add(new String(curWordArray));
                            queue.add(nextWortd);
                        }
                    }
                }
            }
            count += 1;
        }
        // 如果跑完了都不能得到結果則爲0
        return 0;
    }

    /**
     在提交里看到的最优解，看懂了，解读一下分享出来：
     需要掌握的知识递进：
     1.BFS。
     2.双端BFS。
     3.临近点查找方式：
     首先将所有的字符存到结构为HashSet的dic字典里去，然后将字符串的每一位挨个从a变到z,
     在变化的时候实时去字典里查，因为是hashset，所以复杂度是O(1)，非常快。
     如果查到了，则就是找到了临近点。
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        //hashset的好处：去重也完成了
        //开始端
        HashSet<String> start = new HashSet<>();
        //结束端
        HashSet<String> end = new HashSet<>();
        //所有字符串的字典
        HashSet<String> dic = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        if (!dic.contains(endWord)) return 0;
        //经历过上面的一系列判定，到这里的时候，若是有路径，则最小是2，所以以2开始
        return bfs(start, end, dic, 2);
    }

    public int bfs(HashSet<String> st, HashSet<String> ed, HashSet<String> dic, int l) {
        //双端查找的时候，若是有任意一段出现了“断裂”，也就是说明不存在能够连上的路径，则直接返回0
        if (st.size() == 0) return 0;
        if (st.size() > ed.size()) {//双端查找，为了优化时间，永远用少的去找多的，比如开始的时候塞进了1000个，而结尾只有3个，则肯定是从少的那一端开始走比较好
            return bfs(ed, st, dic, l);
        }
        //BFS的标记行为，即使用过的不重复使用
        dic.removeAll(st);
        //收集下一层临近点
        HashSet<String> next = new HashSet<>();
        for (String s : st) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                //变化
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c) continue;
                    arr[i] = c;
                    String nstr = new String(arr);
                    if (dic.contains(nstr)) {
                        if (ed.contains(nstr)) return l;
                        else next.add(nstr);
                    }
                }
                //复原
                arr[i] = tmp;
            }
        }
        return bfs(next, ed, dic, l + 1);
    }
    public static void main(String[] args) {
        Jz108 jz108 = new Jz108();
        System.out.print(jz108.ladderLength2("hit", "cog", Arrays.stream(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}).collect(Collectors.toList())));
    }
}
