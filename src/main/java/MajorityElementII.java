import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MajorityElement
 */
public class MajorityElementII {

    private static final int CANDIDATES = 2;

    public List<Integer> majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        final int[] candidates = new int[CANDIDATES];
        final int[] occurrences = new int[CANDIDATES];
        final int[] counts = new int[CANDIDATES];
        final List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (occurrences[0] <= 0) {
                candidates[0] = num;
                occurrences[0] = 0;
            }
            if (occurrences[1] <= 0 && candidates[0] != num) {
                candidates[1] = num;
                occurrences[1] = 0;
            }

            boolean match = false;
            for (int c = 0; c < candidates.length; c++) {
                if (candidates[c] == num) {
                    occurrences[c]++;
                    match = true;
                    break;
                }
            }
            if (!match) {
                for (int c = 0; c < candidates.length; c++) {
                    occurrences[c]--;
                }
            }
        }

        for (int num : nums) {
            for (int c = 0; c < candidates.length; c++) {
                if (candidates[c] == num) {
                    counts[c]++;
                }
            }
        }

        if (counts[0] > nums.length / 3) {
            result.add(candidates[0]);
        }
        if (counts[1] > nums.length / 3 && candidates[1] != candidates[0]) {
            result.add(candidates[1]);
        }
        return result;
    }

    public static void main(String[] args) {

        final MajorityElementII majorityElement = new MajorityElementII();
        System.out.println(majorityElement.majorityElement(new int[]{1, 2}));
        System.out.println(majorityElement.majorityElement(new int[]{8, 8, 7, 7, 7}));
    }
}
