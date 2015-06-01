import java.util.*;

/**
 * Created by jakubnarloch on 06.04.15.
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] num) {

        // input: the array of integers with duplicates
        // output: the list of unique permutations
        // edge cases: the num is null, the num is empty, num contains only duplicates
        // test cases: the num contains duplicates, the num contains only unique values, num contains only single element

        if(num == null || num.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(num[0]));

        Set<Integer> duplicates = new HashSet<Integer>();

        for(int ind = 1; ind < num.length; ind++) {
            List<List<Integer>> tmp = new ArrayList<>();

            for(int perm = 0; perm < result.size(); perm++) {
                List<Integer> permutation = result.get(perm);
                for(int pos = 0; pos <= permutation.size(); pos++) {
                    List<Integer> copy = new LinkedList<>(permutation);
                    copy.add(pos, num[ind]);

                    int hash = copy.hashCode();
                    if(!duplicates.contains(hash)) {
                        tmp.add(copy);
                        duplicates.add(hash);
                    }
                }
            }
            result = tmp;
        }

        return result;
    }

    public List<List<Integer>> permuteUnique2(int[] num) {

        // input: the array of integers with duplicates
        // output: the list of unique permutations
        // edge cases: the num is null, the num is empty, num contains only duplicates
        // test cases: the num contains duplicates, the num contains only unique values, num contains only single element

        if(num == null || num.length == 0) {
            return Collections.emptyList();
        }

        Set<List<Integer>> result = new LinkedHashSet<>();
        result.add(Collections.singletonList(num[0]));

        for(int ind = 1; ind < num.length; ind++) {
            Set<List<Integer>> tmp = new HashSet<>();

            for(List<Integer> permutation : result) {
                for(int pos = 0; pos <= permutation.size(); pos++) {
                    List<Integer> copy = new LinkedList<>(permutation);
                    copy.add(pos, num[ind]);
                    tmp.add(copy);
                }
            }
            result = tmp;
        }

        return new ArrayList<>(result);
    }

    public List<List<Integer>> permuteUnique3(int[] num) {

        // input: the array of integers
        // output: the list of list
        // edge cases: the num is null, the num is empty

        if(num == null || num.length == 0) {
            return Collections.emptyList();
        }

        final Set<List<Integer>> result = new HashSet<List<Integer>>();
        final Deque<Integer> stack = new LinkedList<Integer>();

        permuteUnique(num, 0, stack, result);

        return new ArrayList<List<Integer>>(result);
    }

    private void permuteUnique(int[] num, int index, Deque<Integer> stack, Set<List<Integer>> result) {

        if(stack.size() == num.length) {
            result.add(new ArrayList<Integer>(stack));
            return;
        }

        if(index >= num.length) {
            return;
        }

        for(int ind = index; ind < num.length; ind++) {
            stack.addLast(num[ind]);
            exch(num, ind, index);
            permuteUnique(num, index + 1, stack, result);
            exch(num, ind, index);
            stack.removeLast();
        }
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        PermutationsII permutation = new PermutationsII();
//        System.out.println(permutation.permuteUnique(new int[] {3,3,0,0,2,3,2}));
        System.out.println(permutation.permuteUnique(new int[] {1, 1, 1}));
    }
}
