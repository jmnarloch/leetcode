import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 */
public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {

        if(rowIndex < 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<Integer>(rowIndex + 2);
        for(int i = 0; i < rowIndex + 2; i++) {
            result.add(0);
        }
        result.set(1, 1);

        for(int row = 0; row < rowIndex; row++) {
            for(int col = rowIndex + 1; col >= 1; col--) {
                result.set(col, result.get(col - 1) + result.get(col));
            }
        }

        result.remove(0);
        return result;
    }

    public List<Integer> getRow2(int rowIndex) {

        if(rowIndex < 0) {
            return Collections.emptyList();
        }
        int numRows = rowIndex + 1;
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
        return result.get(rowIndex);
    }

    private int value(List<List<Integer>> result, int row, int col) {

        List<Integer> rowElements = result.get(row);
        if(col > row) {
            return 0;
        }
        return rowElements.get(col);
    }

    public static void main(String[] args) {

        final int row = 4;

        PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
        List<Integer> result = pascalTriangle2.getRow(row);
        List<Integer> result2 = pascalTriangle2.getRow2(row);

        System.out.println();
    }
}
