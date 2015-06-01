import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubnarloch on 05.04.15.
 */
public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {

        // input: the root of the binary search tree
        // output: altered BST
        // edge cases: root is null, no elements has been altered
        // assumptions: use extra memory
        // approaches: O(N lg N) + O(N) memory

        if(root == null) {
            return;
        }

        final List<Integer> inorder = inorder(root);
        final int size = inorder.size();
        final int[] bst = new int[size];
        final int[] ordered = new int[size];

        int ind = 0;
        for(int val : inorder) {
            bst[ind] = val;
            ordered[ind] = val;
            ind++;
        }

        insertionSort(ordered);
        restore(root, bst, ordered, 0, size - 1);
    }

    private void restore(TreeNode node, int[] bst, int[] ordered, int lo, int hi) {

        if(node == null) {
            return;
        }
        final int val = node.val;
        final int mid = binarySearch(ordered, 0, ordered.length - 1, val);

        if(ordered[mid] != bst[mid]) {
            node.val = bst[mid];
        }
        restore(node.left, bst, ordered, lo, mid - 1);
        restore(node.right, bst, ordered, mid + 1, hi);
    }

    private int binarySearch(int[] a, int lo, int hi, int key) {

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(a[mid] < key) {
                lo = mid + 1;
            } else if(a[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private void insertionSort(int[] a) {

        for(int i = 1; i < a.length; i++) {
            for(int j = i; j >= 1 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    private List<Integer> inorder(TreeNode node) {
        List<Integer> values = new ArrayList<Integer>();
        inorder(node, values);
        return values;
    }

    private void inorder(TreeNode node, List<Integer> values) {
        if(node == null) {
            return;
        }
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);

        RecoverBinarySearchTree recover = new RecoverBinarySearchTree();
        recover.recoverTree(node);

        System.out.println();
    }
}
