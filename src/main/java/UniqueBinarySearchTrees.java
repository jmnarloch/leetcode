/**
 * Created by jakubnarloch on 10.04.15.
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {

        // input: the integer with number of unique elements of binary tree
        // output: the possible number of unique trees that can be created
        // edge cases: n is zero, n is negative, n eq 1, n eq 2

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int[] bt = new int[n + 1];
        bt[0] = 1;
        bt[1] = 1;
        bt[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                bt[i] += bt[j - 1] * bt[i - j];
            }

        }
        return bt[n];
    }

    public static void main(String[] args) {

        UniqueBinarySearchTrees bt = new UniqueBinarySearchTrees();
        System.out.println(bt.numTrees(3));
    }
}
