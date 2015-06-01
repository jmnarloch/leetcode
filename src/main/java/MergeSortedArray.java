import java.util.Arrays;

/**
 *
 */
public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {

        // sort the elements from end to beginning
        int i = m - 1;
        int j = n - 1;

        for(int k = m + n - 1; k >= 0; k--) {

            if(i < 0) {
                A[k] = B[j--];
            } else if(j < 0) {
                A[k] = A[i--];
            } else if(grater(A[i], B[j])) {
                A[k] = A[i--];
            } else {
                A[k] = B[j--];
            }
        }
    }

    private boolean grater(int v, int w) {
        return v > w;
    }

    public static void main(String[] args) {

        // TODO implement
        int[] A = new int[1];
        int[] B = new int[] {1};

        MergeSortedArray merge = new MergeSortedArray();
        merge.merge(A, 0, B, 1);
        System.out.println(Arrays.toString(A));
    }
}
