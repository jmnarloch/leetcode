/**
 * Created by jakubnarloch on 29.03.15.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        // input: the two dimensional matrix of characters, and the searched word
        // output: whether the given word can be found in the
        // edge cases: board is null, board is empty, word is null, word is empty
        // assumptions: all rows will have the same number of 'columns'

        if(board == null || board.length == 0
                || word == null || word.length() == 0) {
            return false;
        }

        final int n = board.length;
        final int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(exist(board, n, m, i, j, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, final int n, final int m, int i, int j, String word, boolean[][] visited) {
        if(word.length() == 0) {
            return true;
        }

        boolean result = false;
        if(i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        if(!visited[i][j] && board[i][j] == word.charAt(0)) {
            visited[i][j] = true;
            String rest = word.substring(1);

            result = exist(board, n, m, i + 1, j, rest, visited)
                    || exist(board, n, m, i - 1, j, rest, visited)
                    || exist(board, n, m, i, j + 1, rest, visited)
                    || exist(board, n, m, i, j - 1, rest, visited);

            if(!result) {
                visited[i][j] = false;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        //
//        char[][] board = new char[][] {
//                "ABCE".toCharArray(),
//                "SFCS".toCharArray(),
//                "ADEE".toCharArray()
//        };

        char[][] board = new char[][] {
                "aaaa".toCharArray(),
                "aaaa".toCharArray(),
                "aaaa".toCharArray()
        };

        WordSearch wordSearch = new WordSearch();
//        System.out.println(wordSearch.exist(board, "ABCCED"));
//        System.out.println(wordSearch.exist(board, "SEE"));
//        System.out.println(wordSearch.exist(board, "ABCB"));
        System.out.println(wordSearch.exist(board, "aaaaaaaaaaaaa"));
    }
}
