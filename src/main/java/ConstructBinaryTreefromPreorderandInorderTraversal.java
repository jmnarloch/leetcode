/**
 * Created by jakubnarloch on 05.04.15.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // input: two array storing the result of preorder and inorder traversals
        // output: the root of the binary tree
        // the edge cases: the arrays are null, the arrays have different length, the arrays are empty
        // assumptions: the arrays contain the distinct values

        if(preorder == null || inorder == null) {
            return null;
        }
        if(preorder.length != inorder.length) {
            return null;
        }

        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int index, int lo, int hi) {

        if(lo > hi) {
            return null;
        }

        final TreeNode node = new TreeNode(preorder[index]);
        if(lo != hi) {
            final int mid = find(inorder, lo, hi, preorder[index]);

            node.left = buildTree(preorder, inorder, index + 1, lo, mid - 1);
            node.right = buildTree(preorder, inorder, index + mid - lo + 1, mid + 1, hi);
        }
        return node;
    }

    private int find(int[] a, int lo, int hi, int key) {
        for(int ind = lo; lo <= hi; ind++) {
            if(a[ind] == key) {
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
}
