import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 *
 */
public class BasicCalculator {

    private static final Map<Character, Integer> PRECEDENCE = new HashMap<Character, Integer>() {{
        put('(', 1);
        put('+', 2);
        put('-', 2);
    }};

    private static final Map<Character, BinaryOperator<Integer>> OPERATORS = new HashMap<Character, BinaryOperator<Integer>>() {{
        put('+', (arg1, arg2) -> arg1 + arg2);
        put('-', (arg1, arg2) -> arg1 - arg2);
    }};

    public int calculate(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        final String postfix = toPostfix(s);

        return evaluate(postfix);
    }

    private int evaluate(String postfix) {

        final Deque<Integer> arguments = new LinkedList<>();

        for (int ind = 0; ind < postfix.length(); ind++) {
            final char c = postfix.charAt(ind);

            if (Character.isWhitespace(c)) {
                continue;
            } else if (OPERATORS.containsKey(c)) {
                final int arg2 = arguments.pop();
                final int arg1 = arguments.pop();
                arguments.push(OPERATORS.get(c).apply(arg1, arg2));
            } else {
                int end = ind + 1;
                while (end < postfix.length() && Character.isDigit(postfix.charAt(end))) {
                    end++;
                }
                arguments.push(Integer.parseInt(postfix.substring(ind, end)));
                ind = end - 1;
            }
        }

        return arguments.pop();
    }

    private String toPostfix(String s) {

        final StringBuilder postfix = new StringBuilder();
        final Deque<Character> ops = new LinkedList<>();
        for (int ind = 0; ind < s.length(); ind++) {
            final char c = s.charAt(ind);
            if (Character.isDigit(c) || Character.isWhitespace(c)) {
                postfix.append(c);
                continue;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    postfix.append(ops.pop());
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && PRECEDENCE.get(ops.peek()) >= PRECEDENCE.get(c)) {
                    postfix.append(ops.pop());
                }
                ops.push(c);
            }
            postfix.append(' ');
        }
        while (!ops.isEmpty()) {
            postfix.append(ops.pop());
        }
        return postfix.toString();
    }
}
