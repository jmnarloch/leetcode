import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jakubnarloch on 05.04.15.
 */
public class SurroundedRegions {

    private static final char OPEN = 'O';
    private static final char CLOSE = 'X';
    private static final char TRANSITIVE = '#';

    public void solve(char[][] board) {

        // input: the two dimensional array/matrix of characters
        // output: the altered matrix
        // edge cases: the board is null, the board is empty
        // tests cases:
        // assumptions: the entries will contains only 'X' and 'O'
        // approaches: O(N M)

        if (board == null
                || board.length == 0
                || board[0].length == 0) {
            return;
        }

        final int N = board.length;
        final int M = board[0].length;

        for (int ind = 0; ind < N; ind++) {

            if (board[ind][0] == OPEN) {
                dfs(board, ind, 0);
            }
            if (board[ind][M - 1] == OPEN) {
                dfs(board, ind, M - 1);
            }
        }

        for (int ind = 0; ind < M; ind++) {
            if (board[0][ind] == OPEN) {
                dfs(board, 0, ind);
            }
            if (board[N - 1][ind] == OPEN) {
                dfs(board, N - 1, ind);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == OPEN) {
                    board[i][j] = CLOSE;
                } else if (board[i][j] == TRANSITIVE) {
                    board[i][j] = OPEN;
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {

        Deque<Pair<Integer>> indexes = new LinkedList<Pair<Integer>>();
        indexes.push(new Pair<Integer>(i, j));

        while(!indexes.isEmpty()) {

            final Pair<Integer> ind = indexes.pop();
            final int x = ind.first;
            final int y = ind.second;

            if (x < 0 || x >= board.length
                    || y < 0 || y >= board[0].length) {
                continue;
            }
            if (board[x][y] != OPEN) {
                continue;
            }
            board[x][y] = TRANSITIVE;

            indexes.push(new Pair<>(x - 1, y));
            indexes.push(new Pair<>(x + 1, y));
            indexes.push(new Pair<>(x, y - 1));
            indexes.push(new Pair<>(x, y + 1));
        }
    }

    private class Pair<T> {
        final T first;
        final T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', OPEN, OPEN, 'X'},
                {'X', 'X', OPEN, 'X'},
                {'X', OPEN, 'X', 'X'}
        };

        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
