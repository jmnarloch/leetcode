import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 22.03.15.
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null) {
            return Collections.emptyList();
        }

        List<Integer> values = new ArrayList<Integer>();
        inorderTraversal(root, values);
        return values;
    }

    private void inorderTraversal(TreeNode node, List<Integer> values) {
        if(node == null) {
            return;
        }

        inorderTraversal(node.left, values);
        values.add(node.val);
        inorderTraversal(node.right, values);
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
