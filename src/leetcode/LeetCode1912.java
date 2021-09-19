package leetcode;

import java.util.*;

public class LeetCode1912 {
    // map<movieId, int{shopId,price}>
    Map<Integer, PriorityQueue<int[]>> unrent = new HashMap<>();
    // int{movieId,shopId,price}
    PriorityQueue<int[]> rent = new PriorityQueue<>((t1, t2) -> {
        if (t1[2] != t2[2]) {
            return t1[2] - t2[2];
        } else if (t1[1] != t2[1]) {
            return t1[1] - t2[1];
        } else {
            return t1[0] - t2[0];
        }
    });

    public LeetCode1912(int n, int[][] entries) {
        for (int[] entry : entries) {
            int shopId = entry[0];
            int movieId = entry[1];
            int priceId = entry[2];
            PriorityQueue<int[]> shopMap = unrent.getOrDefault(movieId, new PriorityQueue<int[]>((t1, t2) -> {
                if (t1[1] == t2[1]) {
                    return t1[0] - t2[0];
                } else {
                    return t1[1] - t2[1];
                }
            }));
            shopMap.add(new int[]{shopId, priceId});
            unrent.put(movieId, shopMap);
        }
    }

    public List<Integer> search(int movie) {
        PriorityQueue<int[]> shopMap = unrent.get(movie);
        List<Integer> res = new ArrayList<>();
        if (Objects.isNull(shopMap)) {
            return res;
        }
        Stack<int[]> tempPq = new Stack<>();
        while (!shopMap.isEmpty() && res.size() < 5) {
            int[] temp = shopMap.poll();
            res.add(temp[0]);
            tempPq.add(temp);
        }
        while (!tempPq.isEmpty()) {
            shopMap.add(tempPq.pop());
        }
        return res;
    }

    public void rent(int shop, int movie) {
        PriorityQueue<int[]> shopMap = unrent.get(movie);
        if (Objects.isNull(shopMap)) {
            return;
        }
        for (int[] temp : shopMap) {
            if (temp[0] == shop) {
                shopMap.remove(temp);
                rent.add(new int[]{movie, shop, temp[1]});
                return;
            }
        }
    }

    public void drop(int shop, int movie) {
        if (Objects.isNull(rent)) {
            return;
        }
        for (int[] temp : rent) {
            if (temp[0] == movie && temp[1] == shop) {
                rent.remove(temp);
                PriorityQueue<int[]> shopMap = unrent.get(movie);
                shopMap.add(new int[]{shop, temp[2]});
                return;
            }
        }
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        if (Objects.isNull(rent)) {
            return res;
        }
        Stack<int[]> tempPq = new Stack<>();
        while (!rent.isEmpty() && res.size() < 5) {
            int[] data = rent.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(data[1]);
            temp.add(data[0]);
            res.add(temp);
            tempPq.add(data);
        }
        // 一定一定要注意优先队列不能用迭代器，因为使用迭代器是无序的，只有poll的时候才是有序的。坑爹。
        while (!tempPq.isEmpty()) {
            rent.add(tempPq.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1912 leetCode1912 = new LeetCode1912(3, new int[][]{{60, 1625, 2383}, {54, 6691, 9511}, {39, 1625, 7944}});
        leetCode1912.rent(60, 1625);
        leetCode1912.rent(54, 6691);
        leetCode1912.rent(39, 1625);
        System.out.println(Arrays.toString(leetCode1912.report().toArray()));
    }
}
