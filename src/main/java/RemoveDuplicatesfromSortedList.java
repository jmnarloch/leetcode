/**
 * Created by jakubnarloch on 06.03.15.
 */
public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        // input: the reference to the list
        // output: the reference of the list with all the duplicates being removed
        // assumptions: can we modify the input list, remove
        // edge cases: head is null, list consists only of duplicates,
        // or there is a lot of duplicates in the end of the list

        if(head == null) {
            return null;
        }

        ListNode node = head, next = head.next;
        while(next != null) {

            if(node.val != next.val) {
                node.next = next;
                node = node.next;
            }
            next = next.next;
        }
        // clears up any remaining elements
        node.next = null;
        return head;
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

        ListNode head = null, prev = null;
        for(int i = 0; i < 9; i++) {
            ListNode node = new ListNode(i);
            if(head == null) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        RemoveDuplicatesfromSortedList dedup = new RemoveDuplicatesfromSortedList();
        ListNode result = dedup.deleteDuplicates(head);
        System.out.println();
    }
}
