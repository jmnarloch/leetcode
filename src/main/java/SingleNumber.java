/**
 * Created by jakubnarloch on 27.03.15.
 */
public class SingleNumber {

    public int singleNumber(int[] A) {

        // input: array of integers
        // output: the value that appeared once
        // edge cases: A is null, A is empty, A contains exactly one element

        if(A == null || A.length == 0) {
            return -1;
        }

        int val = A[0];
        for(int ind = 1; ind < A.length; ind++) {
            val ^= A[ind];
        }
        return val;
    }
}
