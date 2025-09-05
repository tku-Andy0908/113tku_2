package finalexam;

// 題目 12
import java.io.*;
import java.util.*;

public class LC23_MergeKLists_Hospitals {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) if (node != null) pq.offer(node);
        ListNode dummy = new ListNode(0), tail = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int k = (line == null || line.trim().isEmpty()) ? 0 : Integer.parseInt(line.trim());

        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            line = br.readLine();
            if (line == null) { lists[i] = null; continue; }
            StringTokenizer st = new StringTokenizer(line);
            ListNode dummy = new ListNode(0), cur = dummy;
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                cur.next = new ListNode(v);
                cur = cur.next;
            }
            lists[i] = dummy.next;
        }

        ListNode head = mergeKLists(lists);
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}

