package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode1169 {
    public static void main(String[] args) {
        LeetCode1169 leetCode1169 = new LeetCode1169();
        String[] t1 = {"alice,20,800,mtv", "alice,50,100,beijing"};
        String[] t2 = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        String[] t3 = {"alice,20,800,mtv", "bob,50,1200,mtv"};
        System.out.println(Arrays.deepToString(leetCode1169.invalidTransactions(t1).toArray()));
        System.out.println(Arrays.deepToString(leetCode1169.invalidTransactions(t2).toArray()));
        System.out.println(Arrays.deepToString(leetCode1169.invalidTransactions(t3).toArray()));
    }

    /**
     * 如果出现下述两种情况，交易 可能无效：
     * <p>
     * 交易金额超过 ¥1000
     * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
     * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，
     * 这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
     * <p>
     * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
     *
     * @param transactions
     * @return
     */
    private List<String> invalidTransactions(String[] transactions) {
        List<Transaction> collections = new ArrayList<>();
        for (String transactionString : transactions) {
            String[] segments = transactionString.split(",");
            Transaction transaction = new Transaction(segments[0], Integer.parseInt(segments[1]), Integer.parseInt(segments[2]), segments[3]);
            collections.add(transaction);
        }
        HashSet<Transaction> res = new HashSet<>();
        for (int i = 0; i < collections.size(); i++) {
            Transaction transaction1 = collections.get(i);
            if (transaction1.money > 1000) {
                res.add(transaction1);
            } else {
                isValid(collections, res, i, transaction1);
            }
        }
        List<String> ress = new ArrayList<>();
        for (Transaction transaction : res) {
            ress.add(transaction.toString());
        }
        return ress;
    }

    private void isValid(List<Transaction> collections, HashSet<Transaction> res, int i, Transaction transaction1) {
        for (int j = 0; j < collections.size(); j++) {
            Transaction transaction2 = collections.get(j);
            if (j != i
                    && transaction1.name.equals(transaction2.name)
                    && !transaction1.city.equals(transaction2.city)
                    && Math.abs(transaction1.time - transaction2.time) <= 60) {
                res.add(transaction1);
                res.add(transaction2);
            }
        }
    }

    private class Transaction {
        String name;
        int time;
        int money;
        String city;

        Transaction(String name, int time, int monty, String city) {
            this.name = name;
            this.time = time;
            money = monty;
            this.city = city;
        }

        @Override
        public String toString() {
            return name + "," + time + "," + money + "," + city;
        }
    }
}
