import java.util.*;

/**
 * Created by jakubnarloch on 06.04.15.
 */
public class SubsetsII {

    public List<List<Integer>> subsets(int[] S) {

        // input: the array of integers
        // output: the list of result
        // edge cases: the S is null, the S is empty
        // assumptions: use extra memory
        // approaches:

        if (S == null || S.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(S);
        final Set<List<Integer>> result = new LinkedHashSet<List<Integer>>();
        final Deque<Integer> stack = new LinkedList<Integer>();
        result.add(Collections.<Integer>emptyList());
        for (int len = 1; len <= S.length; len++) {
            combinations(S, 0, len, stack, result);
        }
        return new ArrayList<List<Integer>>(result);
    }

    private void combinations(int[] s, int index, int len, Deque<Integer> stack, Set<List<Integer>> result) {

        if (len == 0) {
            result.add(new ArrayList<Integer>(stack));
            return;
        }

        if (index >= s.length) {
            return;
        }

        stack.addLast(s[index]);
        combinations(s, index + 1, len - 1, stack, result);
        stack.removeLast();
        combinations(s, index + 1, len, stack, result);
    }

    public static void main(String[] args) {

        SubsetsII subsets = new SubsetsII();
        System.out.println(subsets.subsets(new int[]{1, 2, 2}));
    }
}
