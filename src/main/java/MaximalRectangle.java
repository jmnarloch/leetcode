import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jakubnarloch on 11.04.15.
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        // input: the two dimensional matrix of size N x M
        // output: the size of the maximum rectangle
        // edge cases: the matrix is null, the matrix is empty, the matrix contains single element
        // assumptions: the matrix will contains only '1' and '0' characters
        // test cases: [0], [1]
        // approaches: O((M N) ^ 2)

        if(matrix == null
                || matrix.length == 0
                || matrix[0].length == 0) {
            return 0;
        }

        final int N = matrix.length;
        final int M = matrix[0].length;

        int max = 0;
        int[] heights = new int[M + 1];
        heights[0] = 0;

        for(int i = 0; i < N; i++) {
            Deque<Integer> stack = new LinkedList<>();

            for(int j = 0; j <= M; j++) {
                if(j < M) {
                    if(matrix[i][j] == '1') {
                        heights[j] += 1;
                    } else {
                        heights[j] = 0;
                    }
                }

                if(stack.isEmpty() || heights[stack.peek()] <= heights[j]) {
                    stack.push(j);
                } else {
                    while(!stack.isEmpty() && heights[j] < heights[stack.peek()]) {
                        int top = stack.pop();
                        int area = heights[top] * (stack.isEmpty() ? j : (j - stack.peek() - 1));
                        max = Math.max(max, area);
                    }
                    stack.push(j);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        char[][] matrix = new char[][] {{'1'}};

        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(matrix));
    }
}
