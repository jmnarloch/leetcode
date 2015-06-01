import java.util.Arrays;

/**
 * Created by jakubnarloch on 05.03.15.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int carry = 1;
        for(int ind = digits.length - 1; ind >= 0 && carry > 0; ind--) {

            if(digits[ind] < 8) {
                digits[ind] += carry;
                carry = 0;
                break;
            } else {
                int sum = digits[ind] + carry;
                int value = sum % 10;
                carry = sum / 10;
                digits[ind] = value;
            }
        }

        if(carry == 0) {
            return digits;
        }

        // allocates new memory for the additional carry value
        int[] tmp = new int[digits.length + 1];
        tmp[0] = carry;
        System.arraycopy(digits, 0, tmp, 1, digits.length);
        return tmp;
    }

    public static void main(String[] args) {

        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9, 9, 8})));
    }
}
