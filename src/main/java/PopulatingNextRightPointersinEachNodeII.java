import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jakubnarloch on 06.04.15.
 */
public class PopulatingNextRightPointersinEachNodeII {

    public void connect(TreeLinkNode root) {

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

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

}
