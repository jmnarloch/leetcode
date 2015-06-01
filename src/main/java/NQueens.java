import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 12.04.15.
 */
public class NQueens {

    public List<String[]> solveNQueens(int n) {

        // input: the integers representing the size of the board
        // output: the possible not coliding solutions
        // edge cases: n is non-positive, for the given n there is no valid solutions

        if(n <= 0) {
            return Collections.emptyList();
        }

        final List<String[]> result = new ArrayList<>();

        final int[] queens = new int[n];
        for(int ind = 0; ind < queens.length; ind++) {
            queens[ind] = ind;
        }
        queensPermutation(queens, 0, n, result);
        return result;
    }

    private void queensPermutation(int[] queens, int index, final int length, List<String[]> result) {

        if(index == length) {
            if(isValid(queens)) {
                result.add(toString(queens));
            }
        } else {

            for(int ind = index; ind < length; ind++) {
                exch(queens, ind, index);
                queensPermutation(queens, index + 1, length, result);
                exch(queens, ind, index);
            }
        }
    }

    private String[] toString(int[] a) {

        String[] result = new String[a.length];
        for(int ind = 0; ind < a.length; ind++) {
            StringBuilder builder = new StringBuilder();
            for(int col = 0; col < a.length; col++) {
                if(a[ind] == col) {
                    builder.append('Q');
                } else {
                    builder.append('.');
                }
            }
            result[ind] = builder.toString();
        }
        return result;
    }

    private boolean isValid(int[] a) {

        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(i - j == a[i] - a[j] || j - i == a[i] - a[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        NQueens nQueens = new NQueens();
        List<String[]> result = nQueens.solveNQueens(4);

        for(String[] matrix : result) {
            print(matrix);
            System.out.println();
        }
    }

    private static void print(String[] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i]);
        }
    }
}
