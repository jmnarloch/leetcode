/**
 * Created by jakubnarloch on 06.03.15.
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) {
            return null;
        }

        int lengthA = length(headA);
        int lengthB = length(headB);

        if(lengthA != lengthB) {
            int proceed = Math.abs(lengthA - lengthB);
            if (lengthA > lengthB) {
                headA = move(headA, proceed);
            } else {
                headB = move(headB, proceed);
            }
        }

        while(headA != null && headB != null) {
            if(headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private ListNode move(ListNode node, int proceed) {
        int ind = 0;
        while(node != null && ind < proceed) {
            ind++;
            node = node.next;
        }
        return node;
    }

    private int length(ListNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
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

        ListNode headA = new ListNode(3);
        ListNode headB = new ListNode(2);
        headB.next = headA;

        IntersectionofTwoLinkedLists inter = new IntersectionofTwoLinkedLists();
        ListNode result = inter.getIntersectionNode(headA, headB);
        System.out.println();
    }
}
