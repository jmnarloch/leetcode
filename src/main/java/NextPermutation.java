import java.util.Arrays;

/**
 * Created by jakubnarloch on 08.04.15.
 */
public class NextPermutation {

    public void nextPermutation(int[] num) {

        // input: the permutation of sequence
        // output: - | the next permutation performed in place
        // edge cases: num is null || num is empty
        // assumptions:

        if(num == null || num.length == 0) {
            return;
        }

        int last = -1;
        for(int ind = 1; ind < num.length; ind++) {
            if(num[ind - 1] < num[ind]) {
                last = ind - 1;
            }
        }
        if(last == -1) {
            // reverse the order of element
            reverse(num, 0, num.length - 1);
            // we are done
            return;
        }
        reverse(num, last + 1, num.length - 1);
        for(int ind = last + 1; ind < num.length; ind++) {
            if(num[ind] > num[last]) {
                exch(num, ind, last);
                break;
            }
        }
    }

    private void reverse(int[] a, int lo, int hi) {

        while(lo < hi) {
            int tmp = a[lo];
            a[lo] = a[hi];
            a[hi] = tmp;
            lo++;
            hi--;
        }
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        int[] set1 = {1, 2, 3};
        int[] set2 = {3, 2, 1};
        int[] set3 = {1, 1, 5};
        int[] set4 = {1, 3, 2};

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(set1);
//        nextPermutation.nextPermutation(set2);
//        nextPermutation.nextPermutation(set3);
        nextPermutation.nextPermutation(set4);

        System.out.println(Arrays.toString(set1));
//        System.out.println(Arrays.toString(set2));
//        System.out.println(Arrays.toString(set3));
        System.out.println(Arrays.toString(set4));
    }
}
