import java.util.HashMap;
import java.util.Map;

/**
 * Created by jakubnarloch on 04.04.15.
 */
public class FractiontoRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        // input: two integers numerator and denominator
        // output: the string representation of the division result
        // edge cases: numerator is negative, denominator is zero, denominator is negative

        if (denominator == 0) {
            return "";
        }
        if(numerator == 0) {
            return "0";
        }

        boolean negative = false;
        if ((numerator < 0) ^ (denominator < 0)) {
            negative = true;
        }
        long num = Math.abs((long) numerator);
        long div = Math.abs((long) denominator);

        final StringBuilder result = new StringBuilder();
        final Map<Long, Integer> remainders = new HashMap<Long, Integer>();

        if (negative) {
            result.append('-');
        }
        result.append(num / div);

        long remainder = (num % div) * 10;
        if (remainder == 0) {
            return result.toString();
        }

        result.append('.');
        while (remainder != 0) {

            if(remainders.containsKey(remainder)) {

                final int ind = remainders.get(remainder);
                result.append(')');
                shiftRight(result, ind);
                result.setCharAt(ind, '(');
                break;
            }

            remainders.put(remainder, result.length());
            result.append(remainder / div);
            remainder = (remainder % div) * 10;
        }

        return result.toString();
    }

    private void shiftRight(StringBuilder result, int ind) {

        for (int i = result.length() - 1; i >= ind; i--) {
            char c = result.charAt(i);

            if (i == result.length() - 1) {
                result.append(c);
            } else {
                result.setCharAt(i + 1, c);
            }
        }
    }

    public static void main(String[] args) {

        FractiontoRecurringDecimal fractiontoRecurringDecimal = new FractiontoRecurringDecimal();
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(1, 1000));
//        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(1, 5));
//        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(1, 6));
//        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(10, 3));
//        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(2, 3));
//        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(-50, 8));
//        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(-2147483648, -1999));
    }
}
