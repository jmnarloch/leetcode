/**
 * Created by jakubnarloch on 09.04.15.
 */
public class BinaryTreeUpsideDown {

    public TreeNode UpsideDownBinaryTree(TreeNode root) {

        if(root == null) {
            return null;
        }

        return UpsideDownBinaryTree(root, null);
    }

    private TreeNode UpsideDownBinaryTree(TreeNode node, TreeNode parent) {
        if(node == null) {
            return parent;
        }

        TreeNode root = UpsideDownBinaryTree(node.left, node);
        node.left = parent != null ? parent.right : null;
        node.right = parent;
        return root;
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
