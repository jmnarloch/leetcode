import java.util.*;

/**
 * Created by jakubnarloch on 06.04.15.
 */
public class Permutations {

    public List<List<Integer>> permute2(int[] num) {

        if(num == null || num.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(num[0]));

        for(int len = 1; len < num.length; len++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(int ind = 0; ind < result.size(); ind++) {
                List<Integer> perm = result.get(ind);
                for(int size = 0; size <= perm.size(); size++) {
                    List<Integer> copy = new LinkedList<>(perm);
                    copy.add(size, num[len]);
                    tmp.add(copy);
                }
            }
            result = tmp;
        }
        return result;
    }

    public List<List<Integer>> permute(int[] num) {

        // input: the array of integers
        // output: the result list
        // edge cases: the num is null, the num is empty
        // assumptions: use extra space
        // approaches:

        if (num == null || num.length == 0) {
            return Collections.emptyList();
        }

        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        final Deque<Integer> stack = new LinkedList<Integer>();
        permute(num, 0, stack, result);
        return result;
    }

    private void permute(int[] num, int index, Deque<Integer> stack, List<List<Integer>> result) {

        if (stack.size() == num.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        if (index >= num.length) {
            return;
        }

        for (int ind = index; ind < num.length; ind++) {
            stack.addLast(num[ind]);
            exch(num, index, ind);
            permute(num, index + 1, stack, result);
            exch(num, index, ind);
            stack.removeLast();
        }
    }

    private void exch(int[] a, int i, int j) {

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
        System.out.println(permutations.permute2(new int[]{1, 2, 3}));
    }
}
