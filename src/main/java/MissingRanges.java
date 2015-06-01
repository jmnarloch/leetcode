import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 08.04.15.
 */
public class MissingRanges {

    public List<String> findMissingRanges(int[] A, int lower, int upper) {

        // input: the array of integers, and two integers representing the lower and upper bounds
        // output: the list of ranges
        // edge cases: the a is null, a is empty

        if(A == null) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<String>();
        int prev = lower - 1;
        for(int i = 0; i <= A.length; i++) {

            int next = i == A.length ? upper + 1 : A[i];
            if(next - prev >= 2) {
                result.add(toRange(prev + 1, next - 1));
            }
            prev = next;
        }
        return result;
    }

    private String toRange(int prev, int next) {
        return prev == next ? String.valueOf(next) : (prev + "->" + next);
    }

    public static void main(String[] args) {

        MissingRanges missingRanges = new MissingRanges();
//        System.out.println(missingRanges.findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
        System.out.println(missingRanges.findMissingRanges(new int[] {}, 1, 1));
    }
}
