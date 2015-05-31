/**
 *
 */
public class ReverseNodesinKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        // input: the head of the list, and the group count - k range?
        // output: the reversed K group list head
        // edge cases: head is null, k is non positive, k is larger the list length
        // assumptions: we can modify the input list

        if(head == null || k <= 0) {
            return head;
        }

        ListNode reversedHead = null;
        ListNode node = head, prev = null;

        while(node != null) {

            ListNode end = move(node, k);

            if(end == null) {
                if(reversedHead == null) {
                    reversedHead = node;
                } else {
                    prev.next = node;
                }
                break;
            } else {
                final ListNode next = end.next;
                ListNode rev = reverse(node, end);
                if(reversedHead == null) {
                    reversedHead = rev;
                } else {
                    prev.next = rev;
                }

                prev = node;
                node = next;
            }
        }
        return reversedHead;
    }

    private ListNode reverse(ListNode start, ListNode end) {

        ListNode node = start, prev = null;
        while(node != end) {
            final ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        node.next = prev;
        return node;
    }

    private ListNode move(ListNode node, int k) {

        for(int ind = 1; node != null && ind < k; ind++) {
            node = node.next;
        }
        return node;
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

        ListNode head = new ListNode(0), prev = head;
        for(int num = 1; num <= 5; num++) {
            prev.next = new ListNode(num);
            prev = prev.next;
        }
        head = head.next;

        ReverseNodesinKGroup reverse = new ReverseNodesinKGroup();
//        ListNode result = reverse.reverseKGroup(head, 2);
        ListNode result = reverse.reverseKGroup(head, 3);
        System.out.println();
    }
}
