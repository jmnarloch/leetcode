/**
 *
 */
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        // input: the head of the list
        // output: the head of the deduplicated list
        // edge cases: head is null, head contains only duplicated values,
        //             head points to duplicated values fallow by non duplicate list
        // test cases:
        // assumptions:

        if(head == null) {
            return null;
        }

        ListNode result = null, prev = null, node;

        node = head;
        while(node != null) {
            if(duplicated(node)) {
                node = next(node);
            } else {
                if(result == null) {
                    result = node;
                } else {
                    prev.next = node;
                }
                prev = node;
                node = node.next;
            }
        }
        if(prev != null) {
            prev.next = null;
        }

        return result;
    }

    private ListNode next(ListNode node) {
        ListNode next = node.next;
        while(next != null && next.val == node.val) {
            next = next.next;
        }
        return next;
    }

    private boolean duplicated(ListNode node) {

        final ListNode next = node.next;
        return next != null && next.val == node.val;
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

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);

        RemoveDuplicatesfromSortedListII remove = new RemoveDuplicatesfromSortedListII();
        ListNode result = remove.deleteDuplicates(head);

        System.out.println();
    }
}
