/**
 *
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        int b1, b2;
        int carry = 0;
        int maxLen = Math.max(a.length(), b.length());
        StringBuilder builder = new StringBuilder(maxLen + 1);

        for(int ind = 0; ind < maxLen; ind++) {
            b1 = value(a, ind);
            b2 = value(b, ind);

            int sum = b1 + b2 + carry;
            int val = sum % 2;
            carry = sum / 2;
            builder.append(val);
        }

        if(carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    private int value(String s, int ind) {
        if(ind >= s.length()) {
            return 0;
        }
        return s.charAt(s.length() - ind - 1) - '0';
    }

    public static void main(String[] args) {

        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
