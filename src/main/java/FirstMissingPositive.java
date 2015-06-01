/**
 * Created by jakubnarloch on 23.03.15.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {

        if(A == null || A.length == 0) {
            return 1;
        }

        int ind = 0;
        while(ind < A.length) {
            if(A[ind] != ind + 1 && A[ind] > 0 && A[ind] <= A.length && A[A[ind] - 1] != A[ind]) {
                exch(A, A[ind] - 1, ind);
            } else {
                ind++;
            }
        }

        for(ind = 0; ind < A.length; ind++) {
            if(A[ind] != ind + 1) {
                return ind + 1;
            }
        }
        return A.length + 1;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int firstMissingPositive2(int[] A) {

        // input: the array A of integers N
        // output: the first positive integer that is not present in the array
        // edge cases: A is null, A is empty, A contains all values from <1, Integer.MAX_VALUE>

        if(A == null || A.length == 0) {
            return 1;
        }

        // partition the input, by values > 0 and <= 0
        final int j = partition(A, 0, A.length - 1);
        if(j >= A.length) {
            return 1;
        }
        final int maxValue = A.length - j;
        final int expectedSum = maxValue * (maxValue + 1) / 2;
        int sum = 0;
        for(int ind = j; ind < A.length; ind++) {
            if(A[ind] <= maxValue) {
                sum += A[ind];
            }
        }
        if(expectedSum - sum <= 0) {
            return maxValue + 1;
        }
        return expectedSum - sum;
    }

    private int partition(int[] A, final int lo, final int hi) {

        int i = lo;
        int j = hi;

        while(true) {
            while(i <= hi && A[i] <= 0) {
                i++;
            }
            while(j >= lo && A[j] > 0) {
                j--;
            }
            if(i >= j) {
                break;
            }

            exch(A, i, j);
        }
        return i;
    }

    public static void main(String[] args) {

        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
//        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {1,2,0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {3,4,-1,1}));
//        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {1, 1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {0}));
    }
}
