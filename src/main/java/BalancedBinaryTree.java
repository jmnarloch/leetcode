/**
 * Created by jakubnarloch on 05.03.15.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int L = maxDepth(root.left);
        if (L == -1) return -1;
        int R = maxDepth(root.right);
        if (R == -1) return -1;
        return (Math.abs(L - R) <= 1) ? (Math.max(L, R) + 1) : -1;
    }

    public boolean isBalanced2(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (Math.abs(maxHeight(root.left) - maxHeight(root.right)) > 1) {
            return false;
        }

        return isBalanced2(root.left) && isBalanced2(root.right);
    }

    private int maxHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        return Math.max(left, right) + 1;
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

        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(3);

        BalancedBinaryTree bt = new BalancedBinaryTree();
        System.out.println(bt.isBalanced(root));
    }
}
