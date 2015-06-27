import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SummaryRanges
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        // input: the sorted array of integers
        // output: the list of ranges
        // edge cases: nums is null, nums is empty, nums does not contain consecutive values, nums contains only consecutive values :<0, N - 1>
        // constraints: the input does not contain duplicates
        // assumptions:
        // approaches: O(N)

        if(nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<>();
        int ind = 0;
        while(ind < nums.length) {
            int j = ind + 1;
            while(j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            }

            result.add(addRange(nums, ind, j - 1));
            ind = j;
        }
        return result;
    }

    private String addRange(int[] nums, int i, int j) {
        if(i == j) {
            return String.valueOf(nums[i]);
        } else {
            return String.format("%d->%d", nums[i], nums[j]);
        }
    }

    public static void main(String[] args) {

        final int[] nums = {0, 1, 2, 4, 5, 7};
        final SummaryRanges ranges = new SummaryRanges();
        System.out.println(ranges.summaryRanges(nums));
    }
}
