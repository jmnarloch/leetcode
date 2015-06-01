import java.util.Arrays;

/**
 *
 */
public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] A) {

        // input: the sorted array A of integers N
        // output: the length of deduplicated array
        // edge cases: A is null, A is empty
        // test cases: A contains one element, A contains three duplicated element, A does not contain any duplicates
        // assumptions: use additional memory
        // approaches: O(N) time + O(N) space, O(N) time + O(1) space

        if(A == null || A.length == 0) {
            return 0;
        }

        int i = 1;
        int j = 0;

        while(i < A.length) {
            if(A[i] == A[j]) {
                if(j == 0 || A[j] != A[j - 1]) {
                    exch(A, i, ++j);
                }
            } else {
                exch(A, i, ++j);
            }
            i++;
        }

        return j + 1;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        int[] A = new int[] {1,1,1,2,2,3};
        RemoveDuplicatesfromSortedArrayII remove = new RemoveDuplicatesfromSortedArrayII();
        System.out.println(remove.removeDuplicates(A));
        System.out.println(Arrays.toString(A));
    }
}
