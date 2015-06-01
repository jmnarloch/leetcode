/**
 * Created by jakubnarloch on 05.03.15.
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode root, int expected, int sum) {
        if(root == null) {
            return false;
        }

        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == expected;
        }

        return hasPathSum(root.left, expected, sum)
                || hasPathSum(root.right, expected, sum);
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
