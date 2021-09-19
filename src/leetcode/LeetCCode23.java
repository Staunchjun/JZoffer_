package leetcode;

import java.util.*;

public class LeetCCode23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode list : lists) {
            System.out.println("ListNode:" + list);
            ListNode cur = list;
            while (Objects.nonNull(cur)) {
                System.out.println(cur.val);
                priorityQueue.offer(cur);
                cur = cur.next;
            }
        }
        ListNode root = null;
        if (!priorityQueue.isEmpty()) {
            root = priorityQueue.poll();
        }
        ListNode cur = root;
        while (!priorityQueue.isEmpty()) {
            ListNode next = priorityQueue.poll();
            cur.next = next;
            cur = next;
        }
        if (Objects.nonNull(cur)) {
            cur.next = null;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode3 = new ListNode(21, new ListNode(6, null));
        List<ListNode> lists = new ArrayList<>();
        lists.add(listNode1);
        lists.add(listNode2);
        lists.add(listNode3);
        LeetCCode23 leetCCode23 = new LeetCCode23();
        leetCCode23.mergeKLists(lists.toArray(ListNode[]::new));
    }
}
