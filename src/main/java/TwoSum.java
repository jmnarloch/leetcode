import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class TwoSum {

    public int[] twoSum(final int[] numbers, final int target) {

        // input: an array of integers in the random order
        //        and searched sum of the two elements
        // output: the indexes of any(?) elements that sum is equal to target
        // assumptions: extra space usage ?, modify reorder the elements ?
        // edge cases: numbers is null, numbers is empty, numbers has only one element, numbers is negative
        //             there is no element matching the criteria

        // Solutions:
        // No       Time Complexity     Memory Usage
        // #1       O(N^2)              O(1)
        // #2       O(N*logN)           O(N)
        // #3       O(N)                O(N)

        final Map<Integer, Integer> num = new HashMap<Integer, Integer>();
        final int[] result = new int[2];
        for (int ind = 0; ind < numbers.length; ind++) {
            if(num.containsKey(numbers[ind])) {
                int index = num.get(numbers[ind]);
                result[0] = index + 1;
                result[1] = ind + 1;
            } else {
                num.put(target - numbers[ind], ind);
            }
        }
        return result;
    }
}
