/**
 * Created by jakubnarloch on 06.03.15.
 */
public class ValidSudoku {

    private static final int SIZE = 9;

    public boolean isValidSudoku(char[][] board) {

        if (board == null) {
            return false;
        } else if (board.length == 0 || (board.length != SIZE && board[0].length != SIZE)) {
            return false;
        }

        int[] vertical = new int[SIZE + 1];
        int[] horizontal = new int[SIZE + 1];
        for (int row = 0; row < SIZE; row++) {
            clear(vertical);
            clear(horizontal);
            for (int col = 0; col < SIZE; col++) {
                int horVal;
                int verticalVal;

                if(board[row][col] != '.') {
                    horVal = board[row][col] - '0';
                    horizontal[horVal]++;
                    if(horizontal[horVal] > 1) {
                        return false;
                    }
                }

                if(board[col][row] != '.') {
                    verticalVal = board[col][row] - '0';
                    vertical[verticalVal]++;
                    if (vertical[verticalVal] > 1) {
                        return false;
                    }
                }
            }
        }

        for (int row = 0; row < SIZE; row += 3) {
            for (int col = 0; col < SIZE; col += 3) {
                clear(vertical);
                for(int i = row; i < row + 3; i++) {
                    for(int j = col; j < col + 3; j++) {
                        if(board[i][j] != '.') {
                            int val = board[i][j] - '0';
                            vertical[val]++;

                            if(vertical[val] > 1) {
                                return false;
                            }
                        }
                    }
                }

            }
        }
        return true;
    }

    private void clear(int[] a) {
        for (int ind = 0; ind < a.length; ind++) {
            a[ind] = 0;
        }
    }

    public static void main(String[] args) {

        ValidSudoku vs = new ValidSudoku();
        char[][] board = toCharArray(new String[] {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"});

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(j != 0) {
                    System.out.print(" ");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println(vs.isValidSudoku(board));
    }

    private static char[][] toCharArray(String[] strings) {
        final int len = strings.length;
        char[][] result = new char[len][len];
        for(int ind = 0; ind < len; ind++) {
            result[ind] = strings[ind].toCharArray();
        }
        return result;
    }
}
