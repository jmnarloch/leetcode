import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jakubnarloch on 28.03.15.
 */
public class MergekSortedLists {

    public ListNode mergeKLists(List<ListNode> lists) {

        // input: the list of sorted 'lists'
        // output the head of the merged sorted in ascending order list
        // edge cases: lists is null, lists is empty

        if(lists == null || lists.isEmpty()) {
            return null;
        }

        Deque<ListNode> mergedLists = new LinkedList<ListNode>(lists);

        while(mergedLists.size() > 1) {

            ListNode l1 = mergedLists.pollFirst();
            ListNode l2 = mergedLists.pollFirst();

            mergedLists.addLast(merge(l1, l2));
        }
        return mergedLists.pollFirst();
    }

    private ListNode merge(ListNode l1, ListNode l2) {
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        List<ListNode> lists = Arrays.asList(l1, l2);

        MergekSortedLists merge = new MergekSortedLists();
        merge.mergeKLists(lists);
        System.out.println();
    }
}
