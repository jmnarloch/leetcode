import java.util.*;

/**
 * Created by jakubnarloch on 05.03.15.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<PathTreeNode> queue = new LinkedList<PathTreeNode>();
        queue.addLast(new PathTreeNode(root, 0));

        while(!queue.isEmpty()) {

            PathTreeNode node = queue.pollFirst();

            if(node.depth >= result.size()) {
                result.add(new LinkedList<Integer>());
            }
            result.get(node.depth).add(node.node.val);

            // adds the subtries
            if(node.node.left != null) {
                queue.add(new PathTreeNode(node.node.left, node.depth + 1));
            }
            if(node.node.right != null) {
                queue.add(new PathTreeNode(node.node.right, node.depth + 1));
            }
        }
        return result;
    }

    public class PathTreeNode {
        TreeNode node;
        int depth;

        public PathTreeNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
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

        TreeNode node = new TreeNode(1);

        BinaryTreeLevelOrderTraversal bt = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = bt.levelOrder(node);
        System.out.println();
    }
}
