/**
 * Created by jakubnarloch on 05.03.15.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public static void main(String[] args) {

        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(null, null));
    }
}
