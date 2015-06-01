import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jakubnarloch on 24.03.15.
 */
public class FlattenBinaryTreetoLinkedList {

    public void flatten2(TreeNode root) {

        TreeNode node = root;
        while (node != null) {
            TreeNode left = node.left;
            if (left != null) {
                while (left.right != null) {
                    left = left.right;
                }
                left.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

    public void flatten(TreeNode root) {

        // input: the root of the binary tree
        // output: the root will be modified in place
        // edge cases: the root is null

        if(root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        TreeNode node = root;
        while (node != null) {

            if(node.right != null) {
                stack.addFirst(node.right);
            }
            if(node.left != null) {
                stack.addFirst(node.left);
            }

            if(!stack.isEmpty()) {
                node.right = stack.pollFirst();
            } else {
                node.right = null;
            }
            node.left = null;
            node = node.right;
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

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        one.left = two;
        one.right = five;

        two.left = three;
        two.right = four;

        five.right = six;

        FlattenBinaryTreetoLinkedList flatten = new FlattenBinaryTreetoLinkedList();
        flatten.flatten(one);

        System.out.println();
    }
}
