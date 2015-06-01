/**
 * Created by jakubnarloch on 29.03.15.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        // input: the two dimensional matrix  of integers
        // output: the minimum path from top left to bottom right
        // edge cases: grid is null, grid is empty

        if(grid == null || grid.length == 0) {
            return 0;
        }

        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] paths = new int[n][m];

        paths[0][0] = grid[0][0];
        for(int ind = 1; ind < n; ind++) {
            paths[ind][0] = paths[ind - 1][0] + grid[ind][0];
        }

        for(int ind = 1; ind < m; ind++) {
            paths[0][ind] = paths[0][ind - 1] + grid[0][ind];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                paths[i][j] = Math.min(paths[i - 1][j] + grid[i][j],
                        paths[i][j - 1] + grid[i][j]);

            }
        }

        return paths[n - 1][m - 1];
    }

    public static void main(String[] args) {

        int[][] data = new int[][] {
                {1, 2},
                {5, 6},
                {1, 1}
        };

        double neg = -0D;
        double pos = 0D;

        MinimumPathSum min = new MinimumPathSum();
        System.out.println(min.minPathSum(data));
    }
}
