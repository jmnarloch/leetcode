import java.util.Arrays;

/**
 * Created by jakubnarloch on 05.03.15.
 */
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] A) {

        if(A == null || A.length == 0) {
            return 0;
        }

        int out = 0;
        for(int ind = 1; ind < A.length; ind++) {
            if(A[ind] != A[out]) {
                out++;
                exch(A, ind, out);
            }
        }
        return out + 1;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        RemoveDuplicatesfromSortedArray remove = new RemoveDuplicatesfromSortedArray();
        int[] a = {1, 1, 2};
        int len = remove.removeDuplicates(a);
        System.out.println(Arrays.toString(a));
        System.out.println(len);
    }
}
