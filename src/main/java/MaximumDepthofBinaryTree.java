/**
 * Created by jakubnarloch on 05.03.15.
 */
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        // TODO implement
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
