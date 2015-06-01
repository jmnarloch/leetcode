import java.util.*;

/**
 * Created by jakubnarloch on 05.03.15.
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root == null) {
            return Collections.emptyList();
        }

        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        int count = 0;
        int nodes = queue.size();
        List<Integer> levelNodes = new LinkedList<Integer>();

        while(!queue.isEmpty()) {

            TreeNode node = queue.pollFirst();
            levelNodes.add(node.val);
            count++;

            // adds the subtrees
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }

            if(count == nodes) {
                count = 0;
                nodes = queue.size();
                result.addFirst(levelNodes);
                levelNodes = new LinkedList<Integer>();
            }
        }
        return result;
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

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);

        BinaryTreeLevelOrderTraversal2 bt = new BinaryTreeLevelOrderTraversal2();
        List<List<Integer>> result = bt.levelOrderBottom(node);
        System.out.println();
    }
}
