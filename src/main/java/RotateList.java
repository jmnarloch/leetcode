/**
 * Created by jakubnarloch on 29.03.15.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        // input: the head of list, the integer of how many numbers rotate >= 0
        // output: the head of rotated list
        // edge case: head is null, k is negative, k is zero, k is grater than length of list

        if (head == null || k == 0) {
            return head;
        }

        final int length = length(head);
        k = k % length;
        if (k == 0) {
            return head;
        }

        ListNode end = head;
        ListNode rotate = head;
        for (int ind = 0; ind < k && end != null; ind++) {
            end = end.next;
        }

        while (end.next != null) {

            rotate = rotate.next;
            end = end.next;
        }

        ListNode result = rotate.next;
        rotate.next = null;
        end.next = head;
        return result;
    }

    private int length(ListNode node) {
        int len = 0;
        while (node != null) {
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

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        RotateList rotateList = new RotateList();
        ListNode result = rotateList.rotateRight(head, 1);
        System.out.println();
    }
}
