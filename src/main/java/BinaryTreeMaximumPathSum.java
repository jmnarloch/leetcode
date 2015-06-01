/**
 * Created by jakubnarloch on 09.04.15.
 */
public class BinaryTreeMaximumPathSum {

    private int max;

    public int maxPathSum(TreeNode root) {

        max = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return max;
    }

    private int findMaxPathSum(TreeNode node) {
        if(node == null) {
            return 0;
        }

        final int left = findMaxPathSum(node.left);
        final int right = findMaxPathSum(node.right);
        max = Math.max(max, node.val + left + right);
        int result = Math.max(left, right) + node.val;
        return result > 0 ? result : 0;
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
