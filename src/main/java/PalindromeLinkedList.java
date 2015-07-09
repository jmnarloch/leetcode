/**
 * Created by jakubnarloch on 10.07.15.
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode node = head;
        ListNode reversed = reverse(head);
        while(node != null) {
            if(node.val != reversed.val) {
                return false;
            }
            reversed = reversed.next;
            node = node.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode node = head, prev = null;
        while(node != null) {
            ListNode copy = new ListNode(node.val);
            copy.next = prev;
            prev = copy;
            node = node.next;
        }
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        final PalindromeLinkedList palindrome = new PalindromeLinkedList();
        System.out.println(palindrome.isPalindrome(head));
    }
}
