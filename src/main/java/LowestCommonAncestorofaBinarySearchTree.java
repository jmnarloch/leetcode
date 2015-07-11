/**
 * LowestCommonAncestorofaBinarySearchTree
 */
public class LowestCommonAncestorofaBinarySearchTree {

    private TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p == null || q == null) {
            return null;
        }

        dfs(root, p, q);
        return lca;
    }

    private int dfs(TreeNode node, TreeNode p, TreeNode q) {

        if(node == null) {
            return 0;
        }
        int curr = 0;
        if(node == p || node == q) {
            curr = 1;
        }

        final int left = dfs(node.left, p, q);
        final int right = dfs(node.right, p, q);

        if(curr + left + right == 2 && lca == null) {
            lca = node;
        }
        return curr + left + right;
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

