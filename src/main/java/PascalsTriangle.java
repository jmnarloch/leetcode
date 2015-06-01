import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 06.03.15.
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        if(numRows <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int row = 0; row < numRows; row++) {

            ArrayList<Integer> rowElements = new ArrayList<Integer>(row + 1);
            for(int col = 0; col < row + 1; col++) {
                rowElements.add(1);
            }
            result.add(rowElements);
        }
        for(int row = 1; row < numRows - 1; row++) {
            for(int col = 0; col < row + 1; col++) {

                int val = value(result, row, col) + value(result, row, col + 1);
                result.get(row + 1).set(col + 1, val);
            }
        }
        return result;
    }

    private int value(List<List<Integer>> result, int row, int col) {

        List<Integer> rowElements = result.get(row);
        if(col > row) {
            return 0;
        }
        return rowElements.get(col);
    }

    public static void main(String[] args) {

        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> result = pascalsTriangle.generate(5);
        System.out.println();
    }
}
