import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 10.04.15.
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {

        return constructTree(1, n);
    }

    private List<TreeNode> constructTree(int lo, int hi) {
        if(lo > hi) {
            return Collections.singletonList(null);
        } else if(lo == hi) {
            return Collections.singletonList(new TreeNode(lo));
        }

        final List<TreeNode> result = new ArrayList<TreeNode>();
        for(int i = lo; i <= hi; i++) {
            final List<TreeNode> leftNodes = constructTree(lo, i - 1);
            final List<TreeNode> rightNodes = constructTree(i + 1, hi);

            for(int l = 0; l < Math.max(1, leftNodes.size()); l++) {
                for(int r = 0; r < Math.max(1, rightNodes.size()); r++) {

                    TreeNode root = new TreeNode(i);
                    result.add(root);

                    if(l < leftNodes.size()) {
                        root.left = leftNodes.get(l);
                    }
                    if(r < rightNodes.size()) {
                        root.right = rightNodes.get(r);
                    }
                }
            }
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
