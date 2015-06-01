import java.util.TreeSet;

/**
 *
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        // input: array of integers, k disstance between index and t distance betwean values
        // output: flag indicating whether there exists two indexes i, j i <= j j - i <= k and abs(nums[j] - nums[i]) <= t
        // edge cases: nums is null, nums is empty, k is non positive
        // assumptions: use extra memory, duplicates?
        // approaches:
        // test cases:

        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        final ContainsDuplicateIII duplicate = new ContainsDuplicateIII();
        System.out.println(duplicate.containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 1, 1));
    }
}
