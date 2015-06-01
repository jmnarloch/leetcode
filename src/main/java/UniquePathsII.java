/**
 * Created by jakubnarloch on 31.03.15.
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // input: a two dimensional matrix A of size (M x N) of integers O: (0, 1)
        // output: the number of possible path from top left to right bottom
        // edge case: the matrix is null, the matrix is empty, the matrix columns has variable length,
        //            the matrix contains value not from range O and 1
        // assumptions: use additional memory O(MN)

        if(obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0) {
            return 0;
        }

        final int N = obstacleGrid.length;
        final int M = obstacleGrid[0].length;
        final int[][] paths = new int[N][M];

        for(int ind = 0; ind < N; ind++) {
            if(obstacleGrid[ind][0] == 1) {
                break;
            }
            paths[ind][0] = 1;
        }
        for(int ind = 0; ind < M; ind++) {
            if(obstacleGrid[0][ind] == 1) {
                break;
            }
            paths[0][ind] = 1;
        }
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < M; j++) {
                if(obstacleGrid[i][j] == 1) {
                    continue;
                }

                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[N - 1][M - 1];
    }
}
