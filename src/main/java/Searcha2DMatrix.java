/**
 * Created by jakubnarloch on 22.03.15.
 */
public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        // input: the two dimensional matrix of integers and the searched integer
        // output: flag indicating whether the matrix contains the given searched number
        // edge cases: matrix is null, matrix is empty
        // assumptions: each row is sorted, and the lowest value in next row is gratter then the max of the previous

        if(matrix == null || matrix.length == 0) {
            return false;
        }

        final int N = matrix.length;
        final int M = matrix[0].length;

        int lo = 0;
        int hi = N * M - 1;

        while(lo <= hi) {
            final int mid = lo + (hi - lo) / 2;
            final int i = mid / M;
            final int j = mid % M;

            if(matrix[i][j] < target) {
                lo = mid + 1;
            } else if(matrix[i][j] > target) {
                hi = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
