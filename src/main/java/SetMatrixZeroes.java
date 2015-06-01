/**
 * Created by jakubnarloch on 29.03.15.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        // input: the two dimensional matrix of size m x n
        // output: -
        // edge cases: matrix is null, matrix is empty

        if(matrix == null || matrix.length == 0) {
            return;
        }

        final int N = matrix.length;
        final int M = matrix[0].length;

        final boolean[] rows = new boolean[N];
        final boolean[] columns = new boolean[M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
