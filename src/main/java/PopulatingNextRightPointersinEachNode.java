import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jakubnarloch on 05.04.15.
 */
public class PopulatingNextRightPointersinEachNode {

    public void connect(TreeLinkNode root) {

        // input: the root of the binary tree
        // output: N/A
        // edge cases: root is null
        // assumptions: use extra space O(N)
        // approaches: O(N) time to extra space O(N) - level order traversal

        if (root == null) {
            return;
        }

        Deque<TreeLinkNode> nodes = new LinkedList<TreeLinkNode>();
        nodes.addLast(root);
        int count = nodes.size();
        TreeLinkNode prev = null;
        while (!nodes.isEmpty()) {
            TreeLinkNode node = nodes.removeFirst();
            count--;

            if (node.left != null) {
                nodes.addLast(node.left);
            }
            if (node.right != null) {
                nodes.addLast(node.right);
            }

            if (prev != null) {
                prev.next = node;
            }

            if (count == 0) {
                count = nodes.size();
                prev = null;
            } else {
                prev = node;
            }
        }
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);

        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);

        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        PopulatingNextRightPointersinEachNode populate = new PopulatingNextRightPointersinEachNode();
        populate.connect(root);

        System.out.println();
    }
}
