import java.util.Arrays;

/**
 * Created by jakubnarloch on 05.04.15.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {

        // input: the array of integers, and the search value 'target'
        // output: the sum of element that is closes to the value
        // edge cases: num is null, num is empty
        // test cases: the num contains exactly the target, the num contains the sum that != target, the num length < 3
        // assumptions: values will distinct, reorder | modify the input
        // approaches: O(N^3), O(N^2)

        if (num == null || num.length == 0 || num.length < 3) {
            return 0;
        }

        // sorts the array
        Arrays.sort(num);
        int min = target - (num[0] + num[1] + num[2]);
        for (int ind = 0; ind < num.length; ind++) {

            int minDiff = search(num, ind, target);
            if (Math.abs(minDiff) < Math.abs(min)) {
                min = minDiff;
            }
        }
        return target - min;
    }

    private int search(int[] num, int ind, int target) {

        int lo = 0;
        int hi = num.length - 1;

        int minDiff = target - (num[lo] + num[hi] + num[ind]);
        while (lo < hi) {
            if(lo == ind) {
                lo++;
                continue;
            }
            if(hi == ind) {
                hi--;
                continue;
            }

            final int sum = target - (num[lo] + num[hi] + num[ind]);
            if (sum == 0) {
                return 0;
            } else if (sum < 0) {
                hi--;
            } else {
                lo++;
            }

            if(Math.abs(sum) < Math.abs(minDiff)) {
                minDiff = sum;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {

        ThreeSumClosest threeSum = new ThreeSumClosest();
//        System.out.println(threeSum.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSum.threeSumClosest(new int[]{0, 1, 2}, 0));
    }
}
