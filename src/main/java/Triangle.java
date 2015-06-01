import java.util.Arrays;
import java.util.List;

/**
 * Created by jakubnarloch on 28.03.15.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        // input: the list of lists of integers
        // output: the mininum path form the top to the bottom
        // edge cases: the triangle is null, the triangle is empty

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        final int length = triangle.size();
        final int[][] minPath = createTriangleMatrix(length);
        minPath[0][0] = triangle.get(0).get(0);
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < i + 1; j++) {

                minPath[i + 1][j] = Math.min(minPath[i + 1][j], triangle.get(i + 1).get(j) + minPath[i][j]);
                minPath[i + 1][j + 1] = Math.min(minPath[i + 1][j + 1],
                        triangle.get(i + 1).get(j + 1) + minPath[i][j]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int ind = 0; ind < length; ind++) {
            min = Math.min(min, minPath[length - 1][ind]);
        }
        return min;
    }

    private int[][] createTriangleMatrix(int length) {

        int[][] result = new int[length][];
        for (int ind = 1; ind <= length; ind++) {
            result[ind - 1] = new int[ind];
            Arrays.fill(result[ind - 1], Integer.MAX_VALUE);
        }
        return result;
    }

    public static void main(String[] args) {

//        List<List<Integer>> data = Arrays.asList(
//                Arrays.asList(2),
//                Arrays.asList(3, 4),
//                Arrays.asList(6, 5, 7),
//                Arrays.asList(4, 1, 8, 3));

        List<List<Integer>> data = Arrays.asList(
                Arrays.asList(-1),
                Arrays.asList(2, 3),
                Arrays.asList(1, -1, 1));

        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(data));
    }
}
