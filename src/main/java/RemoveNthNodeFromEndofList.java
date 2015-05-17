/**
 * Created by jakubnarloch on 05.03.15.
 */
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // input: and single linked list L and a index N >= 1 of the element to be removed from the end of the list
        // output: a reference to list with removed element
        // assumptions:
        // edge case: head is null, n is bigger the number of elements is list, n points to head, n points to last element

        if(head == null) {
            return null;
        }
        ListNode front = head, remove = head;
        int ind = 0;
        while(ind < n && front != null) {
            front = front.next;
            ind++;
        }

        if(front == null) {
            if(ind == n) {
                return head.next;
            } else {
                return head;
            }
        }

        // proceed with the index until reached the element in from of the removed one
        while(front.next != null) {
            front = front.next;
            remove = remove.next;
        }
        remove.next = remove.next.next;
        return head;
    }

    public static void main(String[] args) {

        ListNode head = null;
        ListNode prev = null;
        for(int ind = 2; ind >= 1; ind--) {
            ListNode node = new ListNode(ind);
            if(head == null) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }

        RemoveNthNodeFromEndofList remove = new RemoveNthNodeFromEndofList();
        ListNode result = remove.removeNthFromEnd(head, 1);
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
