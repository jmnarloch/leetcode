import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jakubnarloch on 05.04.15.
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        // input: the array of strings
        // output: the result of operations
        // edge cases: tokens is null, or empty

        if(tokens == null || tokens.length == 0) {
            return 0;
        }

        Deque<Long> values = new LinkedList<Long>();
        long result = 0l;

        for(String token : tokens) {

            if("+".equals(token)) {
                long op2 = values.pop();
                long op1 = values.pop();

                result = op1 + op2;
                values.push(result);
            } else if("-".equals(token)) {
                long op2 = values.pop();
                long op1 = values.pop();

                result = op1 - op2;
                values.push(result);
            } else if("*".equals(token)) {
                long op2 = values.pop();
                long op1 = values.pop();

                result = op1 * op2;
                values.push(result);
            } else if("/".equals(token)) {
                long op2 = values.pop();
                long op1 = values.pop();

                result = op1 / op2;
                values.push(result);
            } else {
                values.push(Long.parseLong(token));
            }
        }

        if(values.peek() > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int)((long)values.peek());
    }

    public static void main(String[] args) {

        EvaluateReversePolishNotation evaluate = new EvaluateReversePolishNotation();
        System.out.println(evaluate.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(evaluate.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
    }
}
