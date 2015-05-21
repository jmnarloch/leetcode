import java.util.List;

/**
 * Created by jakubnarloch on 05.03.15.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        final ListNode head = new ListNode(0);
        ListNode prev = head;
        while(l1 != null && l2 != null) {
            if(less(l2.val, l1.val)) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        if(l1 != null) {
            prev.next = l1;
        }
        if(l2 != null) {
            prev.next = l2;
        }
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        ListNode head = null, prev = null;
        while(l1 != null && l2 != null) {
            ListNode node;
            if(less(l2.val, l1.val)) {
                node = l2;
                l2 = l2.next;
            } else {
                node = l1;
                l1 = l1.next;
            }

            if(head == null) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }

        if(l1 != null) {
            prev.next = l1;
        }
        if(l2 != null) {
            prev.next = l2;
        }
        return head;
    }

    private boolean less(int v, int w) {
        return v < w;
    }


    public static void main(String[] args) {


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
