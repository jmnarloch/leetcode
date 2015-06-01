/**
 * Created by jakubnarloch on 04.04.15.
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        int lo = 0;
        int hi = numbers.length - 1;

        while(lo < hi) {
            int sum = numbers[lo] + numbers[hi] - target;
            if(sum > 0) {
                hi--;
            } else if(sum < 0) {
                lo++;
            } else {
                break;
            }
        }
        return new int[] {lo + 1, hi + 1};
    }
}
