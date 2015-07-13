/**
 *
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        final int N = matrix.length;
        final int M = matrix[0].length;
        final int[] heights = new int[M];

        int max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }

            max = Math.max(max, maxRow(heights));
        }

        return max;
    }

    private int maxRow(int[] heights) {
        int max = 0;

        for(int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for(int j = i; j < heights.length; j++) {
                if(heights[j] == 0) {
                    break;
                }

                minHeight = Math.min(minHeight, heights[j]);
                final int len = Math.min(minHeight, j - i + 1);
                max = Math.max(max, len * len);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        final char[][] matrix = new char[][] {
                {'1'},
        };

        final MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));
    }
}
