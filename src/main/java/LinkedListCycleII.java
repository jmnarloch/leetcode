/**
 * Created by jakubnarloch on 05.04.15.
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        // input: the head of the linked list
        // output: the node pointing to the start of the list cycle, or null if there is no cycle
        // edge cases: the head is null, the list does not contain the cycle
        // approaches: O(N)

        if (head == null) {
            return null;
        }

        // find if there is a cycle
        ListNode node = findCycle(head);
        if (node == null) {
            return null;
        }

        // count the number of nodes in cycle
        int cycle = 1;
        ListNode inCycle = node.next;
        while (inCycle != node) {
            cycle++;
            inCycle = inCycle.next;
        }

        // move the node ahead from the head to find the beginning
        ListNode first = head, last = head;
        for (int ind = 0; ind < cycle; ind++) {
            last = last.next;
        }

        while (first != last) {
            first = first.next;
            last = last.next;
        }
        return first;
    }

    private ListNode findCycle(ListNode head) {

        ListNode slow = head, fast = slow.next;

        while (fast != null) {
            if (slow == fast) {
                return fast;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
