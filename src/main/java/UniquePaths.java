/**
 * Created by jakubnarloch on 29.03.15.
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] board = new int[m][n];

        for(int ind = 0; ind < m; ind++) {
            board[ind][0] = 1;
        }
        for(int ind = 0; ind < n; ind++) {
            board[0][ind] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {

                board[i][j] = board[i - 1][j] + board[i][j - 1];
            }
        }

        return board[m - 1][n - 1];
    }
}
