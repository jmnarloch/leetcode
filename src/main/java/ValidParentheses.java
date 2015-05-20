import java.util.*;

/**
 * Created by jakubnarloch on 05.03.15.
 */
public class ValidParentheses {

    private static final List<Character> OPENING_PARATHENESS = Arrays.asList('(', '{', '[');
    private static final Map<Character, Character> PARENTHESES = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    public boolean isValid(String s) {

        if(s == null || s.isEmpty()) {
            return true;
        }

        Deque<Character> stack = new LinkedList<Character>();
        for(int ind = 0; ind < s.length(); ind++) {
            char c = s.charAt(ind);
            if(PARENTHESES.containsKey(c)) {
                stack.push(c);
            } else if(stack.isEmpty() || PARENTHESES.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public boolean isValid2(String s) {

        // input an string containing the paratheness
        // output: flag indicating whether they are properly enclosed
        // assumptions:
        // edge cases: s == null, s is empty, s contains characters out of this

        if(s == null || s.isEmpty()) {
            return true;
        }

        Deque<Character> paratheness = new LinkedList<Character>();
        for(int ind = 0; ind < s.length(); ind++) {
            char c = s.charAt(ind);
            if(isOpening(c)) {

                paratheness.addFirst(c);
            } else {

                // removes the closing parentheses and checks whether it matches the input
                if(paratheness.isEmpty() || !matches(c, paratheness.pollFirst())) {
                    return false;
                }
            }
        }

        return paratheness.isEmpty();
    }

    private boolean matches(char closing, char opening) {

        return (opening == '(' && closing == ')')
                || (opening == '{' && closing == '}')
                || (opening == '[' && closing == ']');
    }

    private boolean isOpening(char c) {
        return OPENING_PARATHENESS.contains(c);
    }

    public static void main(String[] args) {

        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()[]{}"));
    }
}
