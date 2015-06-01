import java.util.*;

/**
 * Created by jakubnarloch on 11.04.15.
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        // input: the string containing - s -
        // output: the list of list
        // edge cases: s is empty, s is null, s contains single character
        // test cases: s does not contain an palidrom, s contains single char
        // assumptions: use extra space
        // approaches: O()

        if(s == null || s.length() == 0) {
            return Collections.emptyList();
        }

        final List<List<String>> result = new ArrayList<>();

        Deque<String> partitions = new LinkedList<>();
        addPartition(s, 0, partitions, result);
        return result;
    }

    private void addPartition(String s, int index, Deque<String> partitions, List<List<String>> result) {
        if(index >= s.length()) {
            result.add(new ArrayList<>(partitions));
            return;
        }

        for(int ind = index + 1; ind <= s.length(); ind++) {
            String sub = s.substring(index, ind);
            if(isPalindrome(sub)) {
                partitions.addLast(sub);
                addPartition(s, ind, partitions, result);
                partitions.removeLast();
            }
        }
    }

    private boolean isPalindrome(String sub) {

        int lo = 0;
        int hi = sub.length() - 1;

        while(lo < hi) {
            if(sub.charAt(lo) != sub.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {

        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));
    }
}
