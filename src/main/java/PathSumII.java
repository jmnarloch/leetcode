import java.util.*;

/**
 * Created by jakubnarloch on 31.03.15.
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        // input: the root of the binary tree, and searched integer N : N >= 0
        // output: the list of list of node values that create the path
        // edge cases: the root is null
        // assumptions: can use extra memory

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<Integer> stack = new LinkedList<Integer>();

        pathSum(root, 0, sum, stack, result);
        return result;
    }

    private void pathSum(TreeNode node, int sum, int expected, Deque<Integer> stack, List<List<Integer>> result) {
        if(node == null) {
            return;
        }

        int val = sum + node.val;
        stack.addLast(node.val);

        if(val == expected && node.left == null && node.right == null) {
            result.add(new ArrayList<Integer>(stack));
        }

        pathSum(node.left, val, expected, stack, result);
        pathSum(node.right, val, expected, stack, result);
        stack.removeLast();
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}
