/**
 * Created by jakubnarloch on 05.04.15.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        // input: the head of the list and the search element
        // output: the head of the partitioned list
        // edge cases: the head is null, the x does not exists in list
        // assumptions: use extra space
        // approaches: O(N) + O(N) space

        if (head == null) {
            return null;
        }

        ListNode first = null;
        ListNode rest = null;

        ListNode prevFirst = null;
        ListNode prevRest = null;

        ListNode node = head;
        while (node != null) {

            if (less(node.val, x)) {

                if (first == null) {
                    first = node;
                } else {
                    prevFirst.next = node;
                }
                prevFirst = node;
            } else {

                if (rest == null) {
                    rest = node;
                } else {
                    prevRest.next = node;
                }
                prevRest = node;
            }
            node = node.next;
        }

        if (prevFirst != null) {

            prevFirst.next = rest;
            if (prevRest != null) {
                prevRest.next = null;
            }
            return first;
        } else {

            if (prevRest != null) {
                prevRest.next = null;
            }
            return rest;
        }
    }

    private boolean less(int v, int w) {
        return v < w;
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

//        final int[] values = new int[]{1, 4, 3, 2, 5, 2};
        final int[] values = new int[]{2, 1};
        ListNode head = null, prev = null;
        for (int val : values) {
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }

        PartitionList partition = new PartitionList();
//        ListNode result = partition.partition(head, 3);
        ListNode result = partition.partition(head, 2);

        System.out.println();
    }
}
