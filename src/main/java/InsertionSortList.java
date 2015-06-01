/**
 * Created by jakubnarloch on 17.03.15.
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        // input: the reference to the beginning of the list to be sorted in ascending order
        // output: the head of the sorted list
        // assumptions: can we use additional space?, can we modify the input?
        // edge cases: head is null, head contains one element
        // test cases: list is sorted in reverse order, list is already sorted, list contains random ordered number,
        //             list contains only single duplicated value

        // Example:
        // 9 - 2 - 7 - 4 - 5 - 6 - 3 - 8 - 1
        // |   |
        // last next

        if (head == null) {
            return null;
        }

        ListNode lastSorted = head;
        ListNode next = head.next;

        while(next != null) {

            if(next.val < head.val) {
                lastSorted.next = next.next;
                next.next = head;
                head = next;
            } else {
                ListNode node = head;
                while(node != lastSorted && node.next.val < next.val) {
                    node = node.next;
                }

                if(node != lastSorted) {

                    lastSorted.next = next.next;
                    next.next = node.next;
                    node.next = next;
                } else {
                    lastSorted = lastSorted.next;
                }
            }
            next = lastSorted.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
