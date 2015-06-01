/**
 * Created by jakubnarloch on 05.04.15.
 */
public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {

        // input: the head of the sorted linked list
        // output: the root of the balanced BST
        // edge cases: the head is null
        // assumptions: use extra space
        // approaches: O(N) + O(N) space - O(N ^ 2) - O(1)

        if(head == null) {
            return null;
        }

        final int length = length(head);
        final int[] aux = new int[length];

        ListNode node = head;
        for(int ind = 0; ind < length; ind++) {
            aux[ind] = node.val;
            node = node.next;
        }

        return sortedListToBST(aux, 0, length - 1);
    }

    private TreeNode sortedListToBST(int[] aux, int lo, int hi) {
        if(lo > hi) {
            return null;
        }
        final int mid = lo + (hi - lo) / 2;
        final TreeNode node = new TreeNode(aux[mid]);
        node.left = sortedListToBST(aux, lo, mid - 1);
        node.right = sortedListToBST(aux, mid + 1, hi);
        return node;
    }

    private int length(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }


    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; next = null; }
         } }
