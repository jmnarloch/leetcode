/**
 * Created by jakubnarloch on 05.04.15.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // input: two arrays of integers
        // output: the root of the binary search tree
        // edge cases: the arrays are null, arrays have different length

        if (inorder == null || postorder == null) {
            return null;
        }
        if (inorder.length != postorder.length) {
            return null;
        }

        return buildTree(inorder, postorder, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int index, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        final TreeNode node = new TreeNode(postorder[index]);
        if (lo != hi) {
            final int mid = find(inorder, lo, hi, postorder[index]);

            node.left = buildTree(inorder, postorder, index + mid - hi - 1, lo, mid - 1);
            node.right = buildTree(inorder, postorder, index - 1, mid + 1, hi);
        }
        return node;
    }

    private int find(int[] a, int lo, int hi, int key) {
        for (int ind = lo; ind <= hi; ind++) {
            if (a[ind] == key) {
                return ind;
            }
        }
        return -1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        final int[] inorder = new int[]{1, 3, 2, 5, 6, 4, 7};
        final int[] postorder = new int[]{1, 2, 3, 6, 7, 4, 5};

        ConstructBinaryTreefromInorderandPostorderTraversal construct =
                new ConstructBinaryTreefromInorderandPostorderTraversal();
        TreeNode result = construct.buildTree(inorder, postorder);

        System.out.println();
    }
}
