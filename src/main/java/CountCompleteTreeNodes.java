/**
 *
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        // O(lg N) solution
        if (root == null) {
            return 0;
        }

        final int min = min(root);
        final int max = max(root);

        final int total = pow2(max) - 1;
        if (max == min) {
            return total;
        }

        final int lastLevel = pow2(max - 1);
        final int prev = lastLevel - 1;

        int lo = prev + 1;
        int hi = prev + lastLevel;
        int mid = lo;
        int odd = 0;

        while(lo <= hi) {
            mid = lo + (hi - lo) / 2;
            final TreeNode midNode = getNode(root, mid);

            if(midNode.left == null) {
                hi = mid - 1;
            } else if(midNode.right != null) {
                lo = mid + 1;
            } else {
                odd = 1;
                break;
            }
        }
        return total + 2 * (lo - prev - 1) + odd;
    }

    private TreeNode getNode(TreeNode node, int index) {
        if(index == 1) {
            return node;
        }

        int mask = 1;
        int nav = index;
        while((nav >> 1) > 1) {
            nav >>= 1;
            mask <<= 1;
        }

        while(mask > 0) {
            if((index & mask) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            mask >>= 1;
        }
        return node;
    }

    private int pow2(int n) {
        return 1 << n;
    }

    private int min(TreeNode node) {

        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    private int max(TreeNode node) {

        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }

    public int countNodes2(TreeNode root) {

        // O(N) solution
        if (root == null) {
            return 0;
        }

        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {

        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(9);
//        root.left.right = new TreeNode(5);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        CountCompleteTreeNodes completeTreeNodes = new CountCompleteTreeNodes();
        System.out.println(completeTreeNodes.countNodes2(root));
        System.out.println(completeTreeNodes.countNodes(root));
    }
}
