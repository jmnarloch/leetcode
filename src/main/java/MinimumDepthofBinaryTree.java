/**
 * Created by jakubnarloch on 05.03.15.
 */
public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        if(root.left != null && root.right != null) {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return Math.min(left, right) + 1;
        } else if(root.left != null) {
            return minDepth(root.left) + 1;
        } else if(root.right != null) {
            return minDepth(root.right) + 1;
        } else {
            return 1;
        }
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

        TreeNode root = new TreeNode(0);
        // root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        MinimumDepthofBinaryTree bt = new MinimumDepthofBinaryTree();
        System.out.println(bt.minDepth(root));
    }
}
