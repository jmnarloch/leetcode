/**
 *
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {

        // input: the search number, the array of integers
        // output: the smallest subarray
        // edge cases: nums is null, nums is empty

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = 0;
        int sum = 0;

        int min = Integer.MAX_VALUE;

        while (hi < nums.length) {

            sum += nums[hi];
            if (sum >= s) {
                while (lo <= hi && sum - nums[lo] >= s) {
                    sum -= nums[lo];
                    lo++;
                }
                min = Math.min(min, hi - lo + 1);
            }
            hi++;
        }

        return min != Integer.MAX_VALUE ? min : 0;
    }

    public static void main(String[] args) {

        final int s = 7;
        final int[] nums = new int[]{2, 3, 1, 2, 4, 3};

        final MinimumSizeSubarraySum min = new MinimumSizeSubarraySum();
        System.out.println(min.minSubArrayLen(s, nums));
    }
}
