/**
 * Created by jakubnarloch on 08.04.15.
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        // input: two integers
        // output: the
        // edge cases: divisor is zero, dividiend or divisor is negative
        // assumptions: can not use any oritmetic or multiplication operations (+, -, /, *)

        if(divisor == 0) {
            return 0;
        }

        boolean negative = false;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            negative = true;
        }

        if(dividend < 0) {
            dividend = negate(dividend);
        }
        if(divisor < 0) {
            divisor = negate(divisor);
        }

        int result = 0;
        for(int i = 0; i < 32; i = inc(i)) {
            result <<= 1;
            if((dividend >> (31 - i)) >= divisor) {
                dividend = substract(dividend, (divisor << (31 - i)));
                result = add(result, 1);
            }
        }

        if(negative) {
            result = negate(result);
        }

        return result;
    }

    private int add(int num1, int num2) {

        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while(num2 != 0);
        return num1;
    }

    private int substract(int num1, int num2) {
        num2 = add(~num2, 1);
        return add(num1, num2);
    }

    private int inc(int num) {
        return add(num, 1);
    }

    private int negate(int num) {
        if(num == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        } else if(num == Integer.MAX_VALUE) {
            return Integer.MIN_VALUE;
        }

        return add(~num, 1);
    }

    public static void main(String[] args) {

        DivideTwoIntegers div = new DivideTwoIntegers();
//        System.out.println(div.divide(10, 5));
//        System.out.println(div.divide(100, 20));
//        System.out.println(div.divide(100, 5));
        System.out.println(div.divide(-2147483648, -1));
    }
}
