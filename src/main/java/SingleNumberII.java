import java.util.HashMap;
import java.util.Map;

/**
 * Created by jakubnarloch on 27.03.15.
 */
public class SingleNumberII {

    public int singleNumber(int[] A) {

        // input: the array of integers
        // output: the value that occurs only once within the array
        // edge case: the A is null, A is empty, A contains single element
        // assumptions:

        if (A == null || A.length == 0) {
            return -1;
        }

        int[] result = new int[32];
        for (int ind = 0; ind < A.length; ind++) {

            int val = A[ind];
            int pos = 0;
            while (val != 0) {

                if ((val & 1) == 1) {
                    result[pos] = (result[pos] + 1) % 3;
                }

                val >>>= 1;
                pos++;
            }
        }

        return binaryToInt(result);
    }

    private int binaryToInt(int[] result) {

        int num = 0;
        for (int ind = result.length - 1; ind >= 0; ind--) {

            num = num << 1 | result[ind];
        }
        return num;
    }

    public int singleNumber2(int[] A) {

        // input: the array of integers
        // output: the value that occurs only once within the array
        // edge case: the A is null, A is empty, A contains single element
        // assumptions:

        if (A == null || A.length == 0) {
            return -1;
        }

        Map<Integer, Integer> occurences = new HashMap<Integer, Integer>();
        for (int ind = 0; ind < A.length; ind++) {

            if (occurences.containsKey(A[ind])) {
                int occ = occurences.get(A[ind]);
                occurences.put(A[ind], occ + 1);
            } else {
                occurences.put(A[ind], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] data = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 10};
        SingleNumberII singleNumber = new SingleNumberII();

        System.out.println(singleNumber.singleNumber(data));
    }
}
