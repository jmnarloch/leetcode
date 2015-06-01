/**
 * Created by jakubnarloch on 13.04.15.
 */
public class NQueensII {

    public int totalNQueens(int n) {

        if(n <= 0) {
            return 0;
        }

        final int[] queens = new int[n];
        for(int ind = 0; ind < queens.length; ind++) {
            queens[ind] = ind;
        }

        return queensPermutation(queens, 0, n);
    }

    private int queensPermutation(int[] queens, int index, int n) {
        if(index == n) {
            if(isValid(queens)) {
                return 1;
            }
            return 0;
        } else {
            int count = 0;
            for(int ind = index; ind < queens.length; ind++) {
                exch(queens, ind, index);
                count += queensPermutation(queens, index + 1, n);
                exch(queens, ind, index);
            }
            return count;
        }
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

        NQueensII queens = new NQueensII();
        System.out.println(queens.totalNQueens(4));
    }
}
