import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jakubnarloch on 28.03.15.
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        // input: head of the list
        // output: the reordered list
        // edge case: head is null
        // assumptions: the length of the list is in <0, Integer.MAX_VALUE>

        if(head == null) {
            return;
        }

        Deque<ListNode> nodes = new LinkedList<ListNode>();
        ListNode node = head;
        while(node != null) {
            nodes.addFirst(node);

            node = node.next;
        }

        node = head;
        while(node != nodes.peekFirst()) {
            ListNode next = node.next;

            node.next = nodes.pollFirst();
            if(next == node.next) {
                node = node.next;
                break;
            }
            if(node.next != null) {
                node.next.next = next;
            }

            node = next;
        }

        if(node != null) {
            node.next = null;
        }
    }

    public void reorderList2(ListNode head) {

        // input: head of the list
        // output: the reordered list
        // edge case: head is null
        // assumptions: the length of the list is in <0, Integer.MAX_VALUE>

        if(head == null) {
            return;
        }

        final int length = length(head);
        ListNode[] nodes = new ListNode[length];

        ListNode node = head;
        int ind = 0;
        while(node != null) {
            nodes[ind] = node;
            node = node.next;
            ind++;
        }

        node = head;
        int lo = 1;
        int hi = length - 1;

        for(int k = 1; k < length; k++) {
            if(k % 2 == 1) {
                node.next = nodes[hi];
                hi--;
            } else {
                node.next = nodes[lo];
                lo++;
            }
            node = node.next;
        }
        node.next = null;
    }

    private int length(ListNode node) {
        int len = 0;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        ListNode head = null;
        ListNode prev = null;
        for(int num = 1; num <= 2; num++) {
            ListNode node = new ListNode(num);
            if(head == null) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }

        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head);
        System.out.println();
    }
}
