/**
 * Created by jakubnarloch on 23.03.15.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        if(root == null) {
            return true;
        }

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minValue, long maxValue) {
        if(node == null) {
            return true;
        }

        if(node.val < minValue || node.val > maxValue) {
            return false;
        }

        return isValidBST(node.left, minValue, node.val)
                && isValidBST(node.right, node.val, maxValue);
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}
