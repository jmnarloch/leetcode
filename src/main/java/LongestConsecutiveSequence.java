import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jakubnarloch on 12.04.15.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {

        // input: the array of integers - num of size |N| - each integer within range MIN_INTEGER, MAX_INTEGER
        // output: the longest consecutive sequence
        // edge cases: num is null, num is empty, num contains single element, or num contains non consecutive elementsng
        // assumptions: use extra memory, rearrange the input
        // approaches: O(N lg N) time

        if (num == null || num.length == 0) {
            return 0;
        }

        final Set<Integer> set = new HashSet<Integer>();
        for(int val : num) {
            set.add(val);
        }

        int maxSequence = 1;
        int sequence = 0;
        for(int ind = 0; ind < num.length; ind++) {
            final int val = num[ind];

            int prev = val - 1;
            int next = val + 1;
            sequence = 1;

            while(set.contains(prev)) {
                set.remove(prev);
                sequence++;
                prev--;
            }

            while(set.contains(next)) {
                set.remove(next);
                sequence++;
                next++;
            }

            maxSequence = Math.max(maxSequence, sequence);
        }

        return maxSequence;
    }


    public int longestConsecutive2(int[] num) {

        // input: the array of integers - num of size |N| - each integer within range MIN_INTEGER, MAX_INTEGER
        // output: the longest consecutive sequence
        // edge cases: num is null, num is empty
        // assumptions: use extra memory, rearrange the input
        // approaches: O(N lg N) time

        if (num == null || num.length == 0) {
            return 0;
        }

        // sorts the array
        Arrays.sort(num);

        int ind = 1;
        int sequence = 0;
        int maxSequence = 1;
        while (ind < num.length) {
            if (num[ind] - num[ind - 1] == 1) {
                sequence = 2;
                ind++;
                while (ind < num.length && num[ind] - num[ind - 1] == 1) {
                    sequence++;
                    ind++;
                }
                maxSequence = Math.max(maxSequence, sequence);
            }
            ind++;
        }
        return maxSequence;
    }

    public static void main(String[] args) {

        LongestConsecutiveSequence longest = new LongestConsecutiveSequence();
        System.out.println(longest.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longest.longestConsecutive(new int[]{1}));
    }
}
