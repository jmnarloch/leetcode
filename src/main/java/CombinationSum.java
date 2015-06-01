import java.util.*;

/**
 * Created by jakubnarloch on 06.04.15.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // input: the array of candidates and the searched value
        // output: the result list
        // edge cases: the array is null, the array is empty
        // assumptions use extra memory
        // assumptions:

        if(candidates == null || candidates.length == 0) {
            return null;
        }

        Arrays.sort(candidates);

        final int min = min(candidates);
        final Set<List<Integer>> results = new LinkedHashSet<List<Integer>>();
        final Deque<Integer> stack = new LinkedList<Integer>();
        for(int length = 1; length <= Math.max(candidates.length, target / min + 1); length++) {
            combination(candidates, 0, length, 0, target, stack, results);
        }
        return new ArrayList<List<Integer>>(results);
    }

    private int min(int[] candidates) {
        int min = candidates[0];
        for(int ind = 0; ind < candidates.length; ind++) {
               min = Math.min(candidates[ind], min);
        }
        return min;
    }

    private void combination(int[] candidates, int index, int length, int sum, int target,
                             Deque<Integer> stack, Set<List<Integer>> results) {

        if(length == 0) {
            if(sum == target) {
                results.add(new ArrayList<Integer>(stack));
            }
            return;
        }

        if(index >= candidates.length || sum > target) {
            return;
        }

        for(int ind = index; ind < candidates.length; ind++) {
            final int val = candidates[ind];
            stack.addLast(val);
            combination(candidates, ind, length - 1, sum + val, target, stack, results);
            stack.removeLast();
        }
    }

    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();
//        System.out.println(combinationSum.combinationSum(new int[] {2, 3, 6, 7}, 7));
//        System.out.println(combinationSum.combinationSum(new int[] {1}, 2));
        System.out.println(combinationSum.combinationSum(new int[] {1, 2}, 4));
    }
}
