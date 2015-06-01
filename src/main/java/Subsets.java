import java.util.*;

/**
 * Created by jakubnarloch on 06.04.15.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] S) {

        if(S == null || S.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(S);

        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        // adds empty set
        result.add(new ArrayList<Integer>());

        for(int ind = 0; ind < S.length; ind++) {
            final int len = result.size();
            for(int j = 0; j < len; j++) {
                List<Integer> copy = new ArrayList<Integer>(result.get(j));
                copy.add(S[ind]);
                result.add(copy);
            }
        }
        return result;
    }


    public List<List<Integer>> subsets2(int[] S) {

        // input: the array of integers
        // output: the list of result
        // edge cases: the S is null, the S is empty
        // assumptions: use extra memory
        // approaches:

        if (S == null || S.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(S);
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        final Deque<Integer> stack = new LinkedList<Integer>();
        result.add(Collections.<Integer>emptyList());
        for (int len = 1; len <= S.length; len++) {
            combinations(S, 0, len, stack, result);
        }
        return result;
    }

    private void combinations(int[] s, int index, int len, Deque<Integer> stack, List<List<Integer>> result) {

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

        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets2(new int[]{1, 2, 3}));
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }
}
