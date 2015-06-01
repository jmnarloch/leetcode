import java.util.Arrays;

/**
 *
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

        // input: the two dimensional array of size NxN
        // output: the matrix will be rotated
        // assumptions: we can modify the input matrix
        // edge cases: matrix is null, matrix is empty, matrix is not quadratic

        if(matrix == null
                || matrix.length == 0
                || matrix.length != matrix[0].length) {
            // nothing to do
            return;
        }

        final int N = matrix.length;
        int[][] aux = new int[N][N];

        for(int i = 0; i < aux.length; i++) {
            for(int j = 0; j < aux.length; j++) {
                aux[j][N - i - 1] = matrix[i][j];
            }
        }
        // copy the data back to the original matrix
        System.arraycopy(aux, 0, matrix, 0, N);
    }

    public static void main(String[] args) {

        //
        // 1, 2
        // 3, 4
        //
        // 3, 1
        // 4, 2


        int[][] matrix = new int[][] {{1, 2}, {3, 4}};
        RotateImage rotate = new RotateImage();
        rotate.rotate(matrix);
        System.out.println(Arrays.toString(matrix));
    }
}
