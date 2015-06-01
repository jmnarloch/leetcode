import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 22.03.15.
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        if(root == null) {
            return Collections.emptyList();
        }

        List<Integer> values = new ArrayList<Integer>();
        postorderTraversal(root, values);
        return values;
    }

    private void postorderTraversal(TreeNode node, List<Integer> values) {
        if(node == null) {
            return;
        }

        postorderTraversal(node.left, values);
        postorderTraversal(node.right, values);
        values.add(node.val);
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}
