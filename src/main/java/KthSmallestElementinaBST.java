/**
 * Created by jakubnarloch on 02.07.15.
 */
public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {

        final int size = size(root.left) + 1;

        if(size == k) {
            return root.val;
        } else if(k < size) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - size);
        }
    }

    private int size(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
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

        final TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        final KthSmallestElementinaBST bst = new KthSmallestElementinaBST();
        System.out.println(bst.kthSmallest(root, 2));
    }
}
