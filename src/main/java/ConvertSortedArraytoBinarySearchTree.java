/**
 * Created by jakubnarloch on 22.03.15.
 */
public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] num) {

        // input: sorted array
        // output: the root of tree build out of the array
        // edge cases: num is null, num is empty
        if (num == null || num.length == 0) {
            return null;
        }

        return sortedArrayToBST(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num, int lo, int hi) {
        if (lo > hi) {
            return null;
        } else if (lo == hi) {
            return new TreeNode(num[lo]);
        }

        final int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, lo, mid - 1);
        node.right = sortedArrayToBST(num, mid + 1, hi);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
