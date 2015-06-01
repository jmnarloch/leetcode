import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 09.04.15.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        // input: the two dimensional matrix of integers
        // output: the elements of the matrix in spiral order
        // edge cases: the matrix is null, the matrix is empty
        // assumptions: use memory for the result

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = -1;

        final List<Integer> result = new ArrayList<Integer>();

        while (true) {

            // top
            for (int i = 0; i < m; i++) {
                result.add(matrix[row][++col]);
            }
            if (--n == 0) {
                break;
            }

            // right
            for (int i = 0; i < n; i++) {
                result.add(matrix[++row][col]);
            }
            if (--m == 0) {
                break;
            }

            // bottom
            for (int i = 0; i < m; i++) {
                result.add(matrix[row][--col]);
            }
            if (--n == 0) {
                break;
            }

            // left
            for (int i = 0; i < n; i++) {
                result.add(matrix[--row][col]);
            }
            if (--m == 0) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }
}
