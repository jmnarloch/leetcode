import java.util.Arrays;

/**
 * Created by jakubnarloch on 13.04.15.
 */
public class MaximumGap {

    public int maximumGap(int[] num) {

        // input: the unsorted array - num of integers i
        // output: the maximum gap between
        // edge cases: num is null, num is empty, num contains single element, num contains duplicates ex. [1 1]
        // test cases:
        // assumptions: reorder the input array, use extra memory
        // approaches: sort the array

        if(num == null || num.length <= 1) {
            return 0;
        }

        Arrays.sort(num);

        int max = 0;
        for(int ind = 1; ind < num.length; ind++) {
            max = Math.max(max, num[ind] - num[ind - 1]);
        }

        return max;
    }

    public static void main(String[] args) {

        MaximumGap maximumGap = new MaximumGap();
        System.out.println(maximumGap.maximumGap(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }
}
