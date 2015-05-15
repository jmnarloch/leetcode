import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jakubnarloch on 04.03.15.
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
                break;
            } else {
                num.put(target - numbers[ind], ind);
            }
        }
        return result;
    }

    public int[] twoSum1(int[] numbers, int target) {

        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {

        int[] copy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(copy);
        int lo = 0, hi = copy.length - 1;
        while (lo < hi) {

            int sum = copy[lo] + copy[hi];
            if (sum == target) {
                break;
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }

        // the lo and hi point to values containing the solution
        int[] results = new int[2];
        int count = 0;
        for (int ind = 0; ind < numbers.length && count < 2; ind++) {
            if (numbers[ind] == copy[lo] || numbers[ind] == copy[hi]) {
                results[count++] = ind + 1;
            }
        }
        Arrays.sort(results);
        return results;
    }

    public static void main(String[] args) {

        TwoSum sum = new TwoSum();
        System.out.println(Arrays.toString(sum.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
