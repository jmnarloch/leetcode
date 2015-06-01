/**
 * Created by jakubnarloch on 22.03.15.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        if (word1 == null || word2 == null) {
            return 0;
        }
        if (word1.isEmpty() || word2.isEmpty()) {
            return word1.length() > 0 ? word1.length() : word2.length();
        }

        final int N = word1.length();
        final int M = word2.length();
        final int[][] distance = new int[N + 1][M + 1];

        for (int ind = 0; ind <= N; ind++) {
            distance[ind][0] = ind;
        }
        for (int ind = 0; ind <= M; ind++) {
            distance[0][ind] = ind;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = min(distance[i - 1][j], distance[i][j - 1], distance[i - 1][j - 1]) + 1;
                }
            }
        }

        return distance[N][M];
    }

    private int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static void main(String[] args) {

        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("ab", "bc"));
    }
}
