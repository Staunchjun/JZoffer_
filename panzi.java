import java.util.*;

public class Main {
    /**
     * 指向与被指向，用TreeMao存储，Key排序，Boolean记录是否已经访问过边
     */
    static class Point
    {
        Map<Integer,Boolean> in;
        Map<Integer,Boolean> out;
        Point()
        {
            in = new TreeMap<>();
            out = new TreeMap<>();
        }
    }

    /**
     * 用于提交的时候屏蔽log
     * @param  s
     */
    private static void Logln(String s)
    {
        System.out.println(s);
    }
    /**
     * 用于提交的时候屏蔽log
     * @param  s
     */
    private static void Log(String s)
    {
        System.out.print(s);
    }

    private static int n;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
         n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int[] panZi = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            panZi[i] = x + i;
        }
        
        List<int[]> rawRules = new ArrayList<int[]>();
        
        for (int i = 0; i < m; i++)
        {
            int[] rule = new int[2];
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            /*
             * 自环直接返回-1
             */
            if (a == b)
            {
                System.out.println("-1");
                return;
            }
            else
            {
                rule[0] = a;
                rule[1] = b;
                rawRules.add(rule);
            }
        }
        
        List<Integer> hiddenRule =  ShowHiddenRule(rawRules);
        List<Integer> finalRule = ComposeRule(rawRules,hiddenRule);
        if (finalRule == null)
        {
            return;
        }
        Logln("根据规则排序后的下标：");
        for (Integer i : finalRule)
        {
            Log(i + "->");

        }
        Logln("");
        for (Integer i : finalRule)
        {

            System.out.print(panZi[i] + " ");

        }
    }

    /**
     * 根据规则排序
     * @param rules
     * @param hiddenRule
     * @return List<Integer>
     */
    private static List<Integer> ComposeRule(List<int[]> rules,List<Integer> hiddenRule)
    {
        Map<Integer, Point> graph = setAdjacencyInfo(rules);

        List<Integer> startRule = findGraphEntrance(graph);
        if (startRule == null)
        {
            return null;
        }

        List<Integer> normalList = new ArrayList<>();
        int[] checkLoop = new int[n];
        for (int i = 0; i < n; i++)
        {
            checkLoop[i] = 0;
        }
        while (startRule.size() != 0  || hiddenRule.size() != 0  )
        {
            /*
             * 从小到大排序，每次从最小的图开始
             */
            Collections.sort(startRule);
            if (startRule.size() == 0 )
            {
                normalList.add(hiddenRule.get(0));
                hiddenRule.remove(0);
            }
            else if(hiddenRule.size() == 0)
            {
                normalList.add(startRule.get(0));
                Set<Map.Entry<Integer, Boolean>> out = graph.get(startRule.get(0)).out.entrySet();;

                for(Map.Entry<Integer, Boolean> entry:out)
                {
                    graph.get(entry.getKey()).in.put(startRule.get(0),true);
                    graph.get(startRule.get(0)).out.put(entry.getKey(),true);
                }
                Integer integer = startRule.remove(0);
                for (Map.Entry<Integer, Boolean> entry:out)
                {
                    boolean canPut = true;
                    for (Map.Entry<Integer, Boolean> entry1:graph.get(entry.getKey()).in.entrySet()) {
                        if (!entry1.getValue())
                        {
                            canPut = false;
                            break;
                        }
                    }
                    if (canPut)
                    startRule.add(entry.getKey());
                }
            }else if (startRule.get(0) < hiddenRule.get(0)  )
            {
                normalList.add(startRule.get(0));
                Set<Map.Entry<Integer, Boolean>> out = graph.get(startRule.get(0)).out.entrySet();;


                for(Map.Entry<Integer, Boolean> entry:out)
                {
                    graph.get(entry.getKey()).in.put(startRule.get(0),true);
                    graph.get(startRule.get(0)).out.put(entry.getKey(),true);
                }
                startRule.remove(0);

                for (Map.Entry<Integer, Boolean> entry:out)
                {
                    boolean canPut = true;
                    for (Map.Entry<Integer, Boolean> entry1 : graph.get(entry.getKey()).in.entrySet())
                    {
                        if (!entry1.getValue())
                        {
                            canPut = false;
                            break;
                        }
                    }
                    if (canPut)
                        startRule.add(entry.getKey());
                }
            }
            else
            {
                normalList.add(hiddenRule.get(0));
                hiddenRule.remove(0);
            }
        }

        return normalList;
    }

    /**
     * 找到图的个数，图的入口点分别有哪些。只要搜寻有out没有in的就行了。
     */
    private static List<Integer> findGraphEntrance(Map<Integer, Point> graph) {

        List<Integer> startRule = new ArrayList<>();
        for (Map.Entry<Integer, Point> entry : graph.entrySet())
        {
            /*
             * in/out 都为空的 为隐藏规则的点，直接忽略
             */
            if (entry.getValue().in.size() == 0 && entry.getValue().out.size() == 0 )
            {
                continue;
            }
            if (entry.getValue().in.size() == 0)
            {
                startRule.add(entry.getKey());
            }
        }
        Logln("图入口有以下：");
        for (Integer i:startRule)
        {
            Logln(i+" ");
        }
        /*
         *判断是否有环
         */
        for (Integer i:startRule)
        {
            Map<Integer, Point> tempgraph = graph;
            checkoutLoop(tempgraph,i);
        }
        if(!flag)
        {
            System.out.println("-1");
            return null;
        }
        return startRule;
    }
    private static boolean flag = true;
    private static void checkoutLoop(Map<Integer, Point> tempgraph,int i)
    {
        Set<Map.Entry<Integer, Boolean>> out = tempgraph.get(i).out.entrySet();;
        for(Map.Entry<Integer, Boolean> entry:out)
        {
            if (!tempgraph.get(entry.getKey()).in.get(i))
            {
                tempgraph.get(entry.getKey()).in.put(i,true);
                tempgraph.get(i).out.put(entry.getKey(),true);
                checkoutLoop(tempgraph,entry.getKey());
            }
            else
            {
                flag = false;
            }
        }

    }
    /**
     * 构图 用一个 map 记录所有顶点的邻接信息就行了 隐藏规则的点，可以不用设置....用不上.....隐藏规则的点可以视为单独的连通图，只需要对非隐藏规则的点建图就行
     */
    private static Map<Integer, Point> setAdjacencyInfo(List<int[]> rules)
    {
        Map<Integer, Point> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            Point point = new Point();
            graph.put(i,point);
        }

        for (int[] e : rules)
        {
            int estart = e[0];
            int eend = e[1];

            graph.get(estart).out.put(eend, false);
            graph.get(eend).in.put(estart, false);
        }

        for (Map.Entry<Integer, Point> entry : graph.entrySet())
        {
            Logln("key = " + entry.getKey() + ", value = " + entry.getValue());
            Logln("in = " );
            for (Integer i :entry.getValue().in.keySet())
            {
                Log(i+" " );
            }
            Logln("");
            Logln("out = " );
            for (Integer i :entry.getValue().out.keySet())
            {
                Log(i+" " );
            }
            Logln("");
        }
        return graph;
    }


    /**
     * 把所有下标置为1，已经出现在规则的，置为0，剩下的所有0,组成新的隐藏规则 （编号越小的人体重越小）
     */
    private static List<Integer> ShowHiddenRule(List<int[]> rawRules)
    {
        int[] num = new int[n];
        for (int i = 0; i < n; i++)
        {
            num[i] = 1;
        }

        for (int[] rule : rawRules)
        {
            num[rule[0]] = 0;
            num[rule[1]] = 0;
        }

        List<Integer> rule = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            if (num[i] == 1)
            {
                rule.add(i);
            }
        }
        for (Integer i : rule)
        {
            Log(i + "->");

        }
        Logln("");
        return rule;
    }



}
