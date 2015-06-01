import java.util.Arrays;

/**
 * Created by jakubnarloch on 09.04.15.
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(final int n) {

        // input: the integer - n the size of the matrix
        // output: the two dimensional matrix with values arranged in the spiaral order | starting from 1 to N^2
        // edge cases: n <= 0

        if(n <= 0) {
            return new int[0][0];
        }

        final int[][] matrix = new int[n][n];

        int w = n;
        int h = n;

        int row = 0;
        int col = -1;

        int value = 1;

        while(true) {

            for(int i = 0; i < w; i++) {
                matrix[row][++col] = value++;
            }
            if(--h == 0) {
                break;
            }

            for(int i = 0; i < h; i++) {
                matrix[++row][col] = value++;
            }
            if(--w == 0) {
                break;
            }

            for(int i = 0; i < w; i++) {
                matrix[row][--col] = value++;
            }
            if(--h == 0) {
                break;
            }

            for(int i = 0; i < h; i++) {
                matrix[--row][col] = value++;
            }

            if(--w == 0) {
                break;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();

        int[][] matrix = spiralMatrixII.generateMatrix(3);

        for(int i=0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(j != 0) {
                    System.out.print(" ");
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
