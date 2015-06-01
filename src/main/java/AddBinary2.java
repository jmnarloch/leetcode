/**
 * Created by jakubnarloch on 17.03.15.
 */
public class AddBinary2 {
    public String addBinary(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return num1 != null ? num1 : num2;
        }

        if(num1.isEmpty()) {
            return num2;
        }
        if(num2.isEmpty()) {
            return num1;
        }

        final StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        while(i >= 0 || j >= 0) {

            int b1 = value(num1, i--);
            int b2 = value(num2, j--);

            int sum = b1 + b2 + carry;
            int value = sum % 2;
            carry = sum / 2;

            result.append(value);
        }

        if(carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    private static int value(String text, int ind) {
        if(ind < 0) {
            return 0;
        }

        return text.charAt(ind) - '0';
    }

    public static void main(String[] args) {
        AddBinary2 add = new AddBinary2();
        System.out.println(add.addBinary("0", "0"));
    }
}
