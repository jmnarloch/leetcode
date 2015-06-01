import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by jakubnarloch on 22.03.15.
 */
public class BSTIterator {

    private final Deque<TreeNode> nodeStack;

    public BSTIterator(TreeNode root) {

        nodeStack = new LinkedList<TreeNode>();

        while (root != null) {
            nodeStack.addFirst(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {

        return !nodeStack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {

        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        TreeNode next = nodeStack.pollFirst();
        TreeNode right = next.right;
        while(right != null) {
            nodeStack.addFirst(right);
            right = right.left;
        }

        return next.val;
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

        three.left = one;
        three.right = four;
        one.right = two;

        TreeNode root = three;

        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
