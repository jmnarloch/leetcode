/**
 * Created by jakubnarloch on 31.03.15.
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {

        // input: the two dimension matrix of size N x M with integer values
        // output: the minimum health needed to
        // edge cases: the matrix is null, the matrix is empty
        // assumptions: can use extra memory O(M N) ~ 2 M N

        if (dungeon == null
                || dungeon.length == 0
                || dungeon[0].length == 0) {
            return 0;
        }

        final int N = dungeon.length;
        final int M = dungeon[0].length;

        final int[][] hp = new int[N][M];
        hp[N - 1][M - 1] = Math.max(1, 1 - dungeon[N - 1][M - 1]);

        for(int ind = N - 2; ind >= 0; ind--) {
            hp[ind][M - 1] = max(1, 1 - dungeon[ind][M - 1], hp[ind + 1][M - 1] - dungeon[ind][M - 1]);
        }
        for(int ind = M - 2; ind >= 0; ind--) {
            hp[N - 1][ind] = max(1, 1 - dungeon[N - 1][ind], hp[N - 1][ind + 1] - dungeon[N - 1][ind]);
        }

        for(int i = N - 2; i >= 0; i--) {
            for(int j = M - 2; j >= 0; j--) {

                hp[i][j] = max(1, 1 - dungeon[i][j],
                        Math.min(hp[i + 1][j] - dungeon[i][j], hp[i][j + 1] - dungeon[i][j]));
            }
        }

        return hp[0][0];
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        int[][] dungeon1 = new int[][]{
                {0, 5},
                {-2, -3}
        };

        int[][] dungeon2 = new int[][]{
                {1, -2, 3},
                {2, -2, -2}
        };

        int[][] dungeon3 = new int[][]{
                {1, -3, 3},
                {0, -2, 0},
                {-3, -3, -3}
        };

        int[][] dungeon4 = new int[][]{
                {1, 2, 1},
                {-2, -3, -3},
                {3, 2, -2}
        };

        int[][] dungeon5 = new int[][]{
                {3, -20, 30},
                {-3, 4, 0}
        };

        int[][] dungeon6 = new int[][]{
                {0, 0, 0},
                {-1, 0, 0},
                {2, 0, -2}
        };

        int[][] dungeon7 = new int[][]{
                {-61,-52,10,-82},
                {-77,-22,-83,48},
                {-59,-61,-42,-34},
                {231,47,-6,19},
        };

        int[][] dungeon8 = new int[][]{
                {2, 1}
        };

        DungeonGame dungeonGame = new DungeonGame();
        System.out.println(dungeonGame.calculateMinimumHP(dungeon1));
        System.out.println(dungeonGame.calculateMinimumHP(dungeon2));
        System.out.println(dungeonGame.calculateMinimumHP(dungeon3));
        System.out.println(dungeonGame.calculateMinimumHP(dungeon4));
        System.out.println(dungeonGame.calculateMinimumHP(dungeon5));
        System.out.println(dungeonGame.calculateMinimumHP(dungeon6));
        System.out.println(dungeonGame.calculateMinimumHP(dungeon7));
        System.out.println(dungeonGame.calculateMinimumHP(dungeon8));
    }
}
