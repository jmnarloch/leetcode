/**
 * Created by jakubnarloch on 04.05.15.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode node, ListNode prev) {

        if(node == null) {
            return prev;
        }

        final ListNode next = node.next;
        node.next = prev;
        return reverseList(next, node);
    }

    public ListNode reverseList2(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode node = head,
                prev = null,
                reversed = null;

        while (node != null) {
            final ListNode next = node.next;

            if (node.next == null) {
                reversed = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }

        return reversed;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        ReverseLinkedList reverse = new ReverseLinkedList();
        ListNode result = reverse.reverseList(head);
        System.out.println();
    }
}
