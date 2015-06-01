import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jakubnarloch on 13.04.15.
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        // input: the string containing the parentheses
        // output: the longest valid sequence
        // edge cases: s is null, s is empty, there is no valid paratheneses
        // test cases: valid examples ((), )(()))
        // assumptions: use extra memory
        // approaches:

        if(s == null || s.length() == 0) {
            return 0;
        }

        final Deque<Integer> stack = new LinkedList<>();
        int longestSequence = 0;
        int start = 0;
        for(int ind = 0; ind < s.length(); ind++) {

            if(s.charAt(ind) == '(') {
                stack.push(ind);
            } else {
                if(stack.isEmpty()) {
                    start = ind + 1;
                } else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        longestSequence = Math.max(longestSequence, ind - start + 1);
                    } else {
                        longestSequence = Math.max(longestSequence, ind - stack.peek());
                    }
                }
            }
        }
        return longestSequence;
    }

    public static void main(String[] args) {

        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
//        System.out.println(longestValidParentheses.longestValidParentheses("(()"));
//        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses.longestValidParentheses(")()())()()("));
    }
}
