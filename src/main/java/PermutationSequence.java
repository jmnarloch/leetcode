/**
 * Created by jakubnarloch on 09.04.15.
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {

        // input: the number of input size - n:  and the k-th permutation number k <1, N!>
        // output: the k-th permutation string

        if(n < 1 || k < 1) {
            return "";
        }

        char[] perm = new char[n];
        for(int num = 1; num <= n; num++) {
            perm[num - 1] = (char)('0' + num);
        }

        for(int ind = 1; ind < k; ind++) {
            nextPermutation(perm);
        }
        return new String(perm);
    }

    private void nextPermutation(char[] perm) {

        int incInd = -1;

        for(int ind = 1; ind < perm.length; ind++) {
            if(perm[ind - 1] < perm[ind]) {
                incInd = ind - 1;
            }
        }

        if(incInd == -1) {
            reverse(perm, 0, perm.length - 1);
        } else {
            reverse(perm, incInd + 1, perm.length - 1);
            for(int ind = incInd + 1; ind < perm.length; ind++) {
                if(perm[ind] > perm[incInd]) {

                    exch(perm, ind, incInd);
                    break;
                }
            }
        }
    }

    private void reverse(char[] a, int lo, int hi) {
        while(lo < hi) {
            exch(a, lo++, hi--);
        }
    }

    private void exch(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(3, 4));
    }
}
