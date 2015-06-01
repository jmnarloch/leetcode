/**
 * Created by jakubnarloch on 11.04.15.
 */
public class SudokuSolver {

    private static final int BOARD_SIZE = 9;

    public void solveSudoku(char[][] board) {

        // input: the two dimensional matrix of characters each 9x9
        // output: the solve sudoku board (in place)
        // edge cases: if board is null, if board is empty or the other dimension is empty
        // assumptions: the characters are in range '0' - '9'

        if (board == null
                || board.length == 0
                || board[0].length == 0) {
            return;
        }

        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int i, int j) {
        if (i >= 9) {
            return true;
        }

        final int nextRow = j == 8 ? i + 1 : i;
        final int nextCol = j == 8 ? 0 : j + 1;

        if (board[i][j] != '.') {
            return solveSudoku(board, nextRow, nextCol);
        }

        for (char c = '1'; c <= '9'; c++) {

            if (isValid(board, c, i, j)) {
                board[i][j] = c;
                if (solveSudoku(board, nextRow, nextCol)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, final char c, final int row, final int col) {

        for (int ind = 0; ind < BOARD_SIZE; ind++) {

            if (board[ind][col] == c) {
                return false;
            }
            if (board[row][ind] == c) {
                return false;
            }
        }

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = new char[][]{
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray(),
        };

        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(j != 0) {
                    System.out.print(" ");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
