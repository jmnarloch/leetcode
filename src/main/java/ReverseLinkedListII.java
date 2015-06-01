/**
 * Created by jakubnarloch on 27.03.15.
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // input: the head of the linked list, the M the beginning index of the rotation, N the ending index
        // output: the head of the linked list
        // edge cases: head is null, m exceeds lenght of list, m points to head, n exceeds length of list, n is lower or equal to m

        if(head == null || m >= n) {
            return head;
        }

        // moves the m times
        ListNode start = head;
        ListNode prev = null;
        for(int ind = 1; ind < m && start != null; ind++) {
            prev = start;
            start = start.next;
        }
        if(start == null) {
            return head;
        }

        ListNode end = start;
        for(int ind = m; ind < n && end != null; ind++) {
            end = end.next;
        }
        if(end == null) {
            return head;
        }
        ListNode rest = end.next;
        reverse(start, end);

        if(prev == null) {
            head = end;
            start.next = rest;
        } else {
            prev.next = end;
            start.next = rest;
        }

        return head;
    }

    private void reverse(ListNode start, ListNode end) {

        ListNode node = start;
        ListNode prev = null;
        while(node != end) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        end.next = prev;
    }

    public static class ListNode {
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

        for(int ind = 1; ind <= 5; ind++) {
            ListNode node = new ListNode(ind);
            if(head == null) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }

        ReverseLinkedListII reverse = new ReverseLinkedListII();
        reverse.reverseBetween(head, 2, 4);
        System.out.println();
    }
}
