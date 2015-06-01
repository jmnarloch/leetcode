import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 22.03.15.
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) {
            return Collections.emptyList();
        }

        List<Integer> values = new ArrayList<Integer>();
        preorderTraversal(root, values);
        return values;
    }

    private void preorderTraversal(TreeNode node, List<Integer> values) {
        if(node == null) {
            return;
        }

        values.add(node.val);
        preorderTraversal(node.left, values);
        preorderTraversal(node.right, values);
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}
