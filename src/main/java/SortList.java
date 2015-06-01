/**
 * Created by jakubnarloch on 06.04.15.
 */
public class SortList {

    public ListNode sortList(ListNode head) {

        // input: the head of list
        // output: the head of sorted list
        // edge: cases head is null
        // test cases: list is sorted asc, list is sorted desc (in reverse order), list is random
        // assumptions: can we use extra memory?
        // approaches: use array O(N lg N) + O(N) space, list O(N lg N) + O(1)

        if (head == null) {
            return null;
        }

        final int length = length(head);
        return sortList(head, 0, length - 1);
    }

    private ListNode sortList(ListNode node, int lo, int hi) {
        if (lo > hi) {
            return null;
        } else if (lo == hi) {
            return node;
        }

        final int mid = lo + (hi - lo) / 2;

        ListNode next = node, first = null;
        ListNode rest = null;

        for (int ind = lo; ind <= mid && next != null; ind++) {
            first = next;
            next = next.next;
        }
        if (first != null) {
            rest = first.next;
            first.next = null;
        }

        ListNode end = rest, prev = null;
        for (int ind = mid + 1; ind <= hi && end != null; ind++) {
            prev = end;
            end = end.next;
        }
        if (prev != null) {
            prev.next = null;
        }

        return merge(sortList(node, lo, mid), sortList(rest, mid + 1, hi));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        ListNode result = null, prev = null;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (less(l1, l2)) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }

            if (result == null) {
                result = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }

        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return result;
    }

    private boolean less(ListNode l1, ListNode l2) {
        return l1.val < l2.val;
    }

    private int length(ListNode node) {
        int len = 0;
        while (node != null) {
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

        ListNode head = null, prev = null;
        for(int ind = 9; ind >= 1; ind--) {
            final ListNode node = new ListNode(ind);
            if(head == null) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }

        SortList sort = new SortList();
        ListNode result = sort.sortList(head);

        System.out.println();
    }
}
