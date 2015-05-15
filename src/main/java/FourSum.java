import java.util.*;

/**
 * Created by jakubnarloch on 05.04.15.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] num, int target) {

        // input: the array of integer, the search integer
        // output: the list of sorted indexes that match the value
        // edge cases: num is null, num is empty
        // assumptions: num has distinct values
        // test cases: there is no sum matching the search value
        // approaches: O(N ^ 4), O(N ^ 3)

        if(num == null || num.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(num);

        final Set<List<Integer>> result = new HashSet<List<Integer>>();
        for(int i = 0; i < num.length; i++) {
            for(int j = i + 1; j < num.length; j++) {
                partition(num, i, j, target, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void partition(int[] num, int i, int j, int target, Set<List<Integer>> result) {

        int lo = 0;
        int hi = num.length - 1;

        while(lo < hi) {
            if(lo == i || lo == j) {
                lo++;
                continue;
            }
            if(hi == i || hi == j) {
                hi--;
                continue;
            }

            final int sum = num[i] + num[j] + num[lo] + num[hi] - target;
            if(sum == 0) {
                final Integer[] indexes = new Integer[] {num[lo], num[hi], num[i], num[j]};
                Arrays.sort(indexes);
                result.add(Arrays.asList(indexes));
                lo++;
                hi--;
            } else if(sum < 0) {
                lo++;
            } else {
                hi--;
            }
        }
    }

    public static void main(String[] args) {

        FourSum sum = new FourSum();
        System.out.println(sum.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
    }
}
