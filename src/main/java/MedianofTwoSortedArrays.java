/**
 * Created by jakubnarloch on 11.04.15.
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {

        // input: two sorted arrays: A, B
        // output: the median of the arrays
        // edge cases: the A or B is null, the A or B is empty
        //             |A B| is odd , or |A B| is even avg
        // approaches: O(M N) + O(M N)
        // approaches: O(lg M * lg N) + O(1)

        if(A == null || B == null) {
            return 0D;
        }
        if(A.length == 0 || B.length == 0) {
            return 0D;
        }



        return 0D;
    }
}
