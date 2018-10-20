package Arithmetic.Set;
import java.util.*;

public class Main {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        ListNode a = new ListNode(0);
        ListNode b = a;
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode node: lists) {
            while (node != null){
                list.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(list);
        for (int x: list) {
            b.next = new ListNode(x);
            b = b.next;
        }
        return a.next;
    }

    static ListNode string2ListNode(String str) {
        StringTokenizer token = new StringTokenizer(str, ",");
        ListNode head, foot;
        head = foot = new ListNode(0);
        while(token.hasMoreTokens()) {
            int val = Integer.parseInt(token.nextToken());
            foot = foot.next = new ListNode(val);
        }
        return head.next;
    }

    static String listNode2String(ListNode listNode) {
        StringBuilder result = new StringBuilder();
        while (listNode != null) {
            result.append(listNode.val).append(",");
            listNode = listNode.next;
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<ListNode> list = new ArrayList<>();
        while (input.hasNext()) {
            list.add(string2ListNode(input.next()));
        }
        ListNode[] listNode = list.toArray(new ListNode[list.size()]);
        System.out.print(listNode2String(mergeKLists(listNode)));
    }

}