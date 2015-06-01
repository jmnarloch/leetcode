/**
 * Created by jakubnarloch on 08.04.15.
 */
public class DivideTwoIntegers2 {

    public int divide(int dividend, int divisor) {

        // input: two integers
        // output: the
        // edge cases: divisor is zero, dividiend or divisor is negative
        // assumptions: can not use any oritmetic or multiplication operations (+, -, /, *)

        if(divisor == 0) {
            return 0;
        }

        long num1 = dividend;
        long num2 = divisor;

        boolean negative = false;
        if((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0)) {
            negative = true;
        }

        if(num1 < 0) {
            num1 = negate(num1);
        }
        if(num2 < 0) {
            num2 = negate(num2);
        }

        long result = 0;
        for(long i = 0; i < 32; i = inc(i)) {
            result <<= 1;
            if((num1 >> (31 - i)) >= num2) {
                num1 = substract(num1, (num2 << (31 - i)));
                result = add(result, 1);
            }
        }

        if(result > Integer.MAX_VALUE) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if(negative) {
            result = negate(result);
        }

        return (int)result;
    }

    private long add(long num1, long num2) {

        long sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while(num2 != 0);
        return num1;
    }

    private long substract(long num1, long num2) {
        num2 = add(~num2, 1);
        return add(num1, num2);
    }

    private long inc(long num) {
        return add(num, 1);
    }

    private long negate(long num) {

        return add(~num, 1);
    }

    public static void main(String[] args) {

        DivideTwoIntegers2 div = new DivideTwoIntegers2();
        System.out.println(div.divide(10, 5));
        System.out.println(div.divide(100, 20));
        System.out.println(div.divide(100, 5));
        System.out.println(div.divide(-2147483648, -1));
        System.out.println(div.divide(-2147483648, 2));
    }
}
