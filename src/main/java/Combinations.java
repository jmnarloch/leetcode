import java.util.*;

/**
 * Created by jakubnarloch on 06.04.15.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        // input: the two integers n and k
        // output: the list of integers
        // edge cases: n or k is non-positive
        // assumptions: use of extra space O(n)

        if(n <= 0 || k <= 0) {
            return Collections.emptyList();
        }

        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        final Deque<Integer> stack = new LinkedList<Integer>();

        combine(1, n, k, stack, result);

        return result;
    }

    private void combine(final int number, final int n, final int length,
                         Deque<Integer> stack, List<List<Integer>> result) {
        if(length == 0) {
            // shallow copy
            result.add(new ArrayList<Integer>(stack));
            return;
        }

        if(number > n) {
            return;
        }

        stack.addLast(number);
        combine(number + 1, n, length - 1, stack, result);
        stack.removeLast();

        combine(number + 1, n, length, stack, result);
    }

    public List<List<Integer>> combine2(int n, int k) {

        // input: the two integers n and k
        // output: the list of integers
        // edge cases: n or k is non-positive
        // assumptions: use of extra space O(n)

        if(n <= 0 || k <= 0) {
            return Collections.emptyList();
        }

        final List<Integer> numbers = new ArrayList<Integer>(n);
        for(int num = 1; num <= n; num++) {
            numbers.add(num);
        }

        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        final LinkedList<Integer> stack = new LinkedList<Integer>();

        combine2(numbers, 0, k, stack, result);

        return result;
    }

    private void combine2(List<Integer> numbers, int index, int length, Deque<Integer> stack, List<List<Integer>> result) {
        if(length == 0) {
            // shallow copy
            result.add(new ArrayList<Integer>(stack));
            return;
        }

        if(index >= numbers.size()) {
            return;
        }

        stack.addLast(numbers.get(index));
        combine2(numbers, index + 1, length - 1, stack, result);
        stack.removeLast();

        combine2(numbers, index + 1, length, stack, result);
    }

    public static void main(String[] args) {

        Combinations combinations = new Combinations();
        List<List<Integer>> result = combinations.combine(4, 2);
        System.out.println(result);
    }
}
