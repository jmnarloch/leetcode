/**
 * Created by jakubnarloch on 28.03.15.
 */
public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {

        if(root == null) {
            return 0;
        }

        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int num) {
        if(node == null) {
            return 0;
        }

        final int val = num * 10 + node.val;
        if(node.left == null && node.right == null) {
            return val;
        }

        return sumNumbers(node.left, val)
                + sumNumbers(node.right, val);
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
        root.right = new TreeNode(3);

        SumRoottoLeafNumbers sum = new SumRoottoLeafNumbers();
        System.out.println(sum.sumNumbers(root));
    }
}
