/**
 * Created by jakubnarloch on 23.03.15.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] A) {

        // input: array A of integers N
        // output: the maximum slice of the array
        // edge cases: A is null, A is empty array, A contains only one element

        if(A == null || A.length == 0) {
            return 0;
        }

        int max = A[0];
        int maxSlice = A[0];
        for(int ind = 1; ind < A.length; ind++) {

            max = Math.max(A[ind], max + A[ind]);
            maxSlice = Math.max(maxSlice, max);
        }
        return maxSlice;
    }
}
