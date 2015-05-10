import java.util.*;

/**
 * Created by jakubnarloch on 07.04.15.
 */
public class LetterCombinationsofaPhoneNumber {

    private static final String[] NUMBERS = new String[] {
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        // input: the string with digits representation
        // output: the combination of all possibilities
        // edge cases: the digits is null, the digits is empty
        // test cases: the string does not contain digit
        // assumptions: use of extra space
        // approaches:

        if(digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        final List<String> input = new ArrayList<String>();
        for(char c : digits.toCharArray()) {
            input.add(NUMBERS[c - '2']);
        }

        final List<String> results = new ArrayList<String>();
        final Deque<Character> stack = new LinkedList<Character>();
        combinations(input, 0, stack, results);
        return results;
    }

    private void combinations(List<String> input, int index, Deque<Character> stack, List<String> results) {

        if(stack.size() == input.size()) {
            String result = toString(stack);
            results.add(result);
            return;
        }

        if(index >= input.size()) {
            return;
        }

        for(char c : input.get(index).toCharArray()) {
            stack.addLast(c);

            combinations(input, index + 1, stack, results);

            stack.removeLast();
        }
    }

    private String toString(Deque<Character> stack) {
        StringBuilder builder = new StringBuilder(stack.size());
        for(char c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        LetterCombinationsofaPhoneNumber combinations = new LetterCombinationsofaPhoneNumber();
        System.out.println(combinations.letterCombinations("23"));
    }
}
