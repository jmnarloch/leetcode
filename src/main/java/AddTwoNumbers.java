/**
 * Created by jakubnarloch on 04.03.15.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null, node, prev = null;
        int sum, carry = 0, value;

        while (l1 != null || l2 != null) {

            sum = value(l1) + value(l2) + carry;
            value = sum % 10;
            carry = sum / 10;

            node = new ListNode(value);
            if(head == null) {
                head = node;
            } else {
                prev.next = node;
            }

            l1 = next(l1);
            l2 = next(l2);
            prev = node;
        }

        if(carry > 0) {
            prev.next = new ListNode(carry);
        }

        return head;
    }

    private ListNode next(ListNode node) {
        if(node != null) {
            return node.next;
        }
        return null;
    }

    private int value(ListNode node) {
        if(node != null) {
            return node.val;
        }

        return 0;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {


        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(null, null);
    }
}
