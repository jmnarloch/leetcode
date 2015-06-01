import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jakubnarloch on 04.04.15.
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        // input: the root of the binary tree
        // output: the list containing only values visible from 'right view/side'
        // edge cases: the root is null
        // test cases: the tree has only left children, thee tree has only right children
        // assumptions: can we use extra memory
        // approaches to the problem: O(N) + O(N) with level order traversal

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new LinkedList<Integer>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        int count = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            count--;

            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }

            if (count == 0) {
                result.add(node.val);
                count = queue.size();
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

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        BinaryTreeRightSideView rightSideView = new BinaryTreeRightSideView();
        System.out.println(rightSideView.rightSideView(root));
    }
}
