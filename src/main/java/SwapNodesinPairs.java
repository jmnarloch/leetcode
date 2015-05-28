/**
 * Created by jakubnarloch on 27.03.15.
 */
public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {

        // input: the head of the linked list
        // output: the head of the linked list will all pair elements being swapped
        // edge cases: head is null, list contains one element, list contains odd number of elements
        // assumptions: can rearenge the input data, can we allocate additional memory
        // approaches:
        // No.          Time complexity         Space usage
        // 1            O(N)                    O(N)
        // 2            O(N)                    O(1)

        if(head == null) {
            return null;
        }

        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            ListNode next = current.next;
            if(next == null) {
                break;
            }

            if(current == head) {
                current.next = next.next;
                next.next = current;
                head = next;
            } else {
                prev.next = next;
                current.next = next.next;
                next.next = current;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {

        // input: the head of the linked list
        // output: the head of the linked list will all pair elements being swapped
        // edge cases: head is null, list contains one element, list contains odd number of elements
        // assumptions: can rearenge the input data, can we allocate additional memory
        // approaches:
        // No.          Time complexity         Space usage
        // 1            O(N)                    O(N)
        // 2            O(N)                    O(1)

        if(head == null) {
            return null;
        }

        final int length = length(head);
        int[] values = new int[length];

        ListNode node = head;
        int ind = 0;
        while(node != null) {
            values[ind++] = node.val;
            node = node.next;
        }

        swapPairs(values);
        copy(head, values);

        return head;
    }

    private void copy(ListNode head, int[] values) {

        ListNode node = head;
        int ind = 0;
        while(node != null) {
            node.val = values[ind++];
            node = node.next;
        }
    }

    private void swapPairs(int[] values) {
        for(int ind = 1; ind < values.length; ind += 2) {
            swap(values, ind - 1, ind);
        }
    }

    private void swap(int[] values, int i, int j) {

        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    private int length(ListNode node) {
        int len = 0;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
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

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);

        SwapNodesinPairs swap = new SwapNodesinPairs();
        ListNode result = swap.swapPairs(node);
        System.out.println();
    }
}
