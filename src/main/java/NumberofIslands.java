/**
 * Created by jakubnarloch on 08.04.15.
 */
public class NumberofIslands {

    public int numIslands(char[][] grid) {

        // input: the two dimensional matrix of characters
        // output: the number of islands
        // edge cases: the grid is null, the grid is empty
        // assumptions: use extra memory, assuming that the input will consists of only 0 and 1
        // approaches: O(M N) + O(M N), connectivity problem, connected components in undirected graphs

        if(grid == null || grid.length == 0) {
            return 0;
        }

        final int N = grid.length;
        final int M = grid[0].length;
        final boolean visited[][] = new boolean[N][M];
        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {

                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        } else if(visited[i][j] || grid[i][j] != '1') {
            return;
        }

        visited[i][j] = true;
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }

    public static void main(String[] args) {

        char[][] island1 = new char[][] {
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()
        };

        char[][] island2 = new char[][] {
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        };

        NumberofIslands islands = new NumberofIslands();
        System.out.println(islands.numIslands(island1));
        System.out.println(islands.numIslands(island2));
    }
}
