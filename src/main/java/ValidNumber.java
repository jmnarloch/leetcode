/**
 * Created by jakubnarloch on 07.04.15.
 */
public class ValidNumber {

    public boolean isNumber(String s) {

        // input: the string representation of real number +|-12.12E|e+-12 .01
        // output: whether the string is valid number
        // edge cases: number contains the whitespaces, number contains other characters then digits, s is null, s is empty
        // test cases: positive, negative integer, positive negative real number

        if(s == null || s.length() == 0) {
            return false;
        }

        int index = 0;
        while(index < s.length() && Character.isWhitespace(s.charAt(index))) {
            index++;
        }
        return matchNumber(s, index);
    }

    private boolean matchNumber(String s, int index) {

        if(index >= s.length()) {
            return false;
        }
        if(s.charAt(index) == '-' || s.charAt(index) == '+') {
            index++;
        }
        if(index == s.length()) {
            return false;
        }

        int prev = index;
        int count = 0;
        index = matchDigits(s, index);
        count += index - prev;

        if(index < s.length() && s.charAt(index) == '.') {
            prev = index + 1;
            index = matchDigits(s, index + 1);
            count += index - prev;
        }
        if(count > 0 && index < s.length() && (s.charAt(index) == 'E' || s.charAt(index) == 'e')) {
            index++;
            if(index >= s.length()) {
                return false;
            }
            if(s.charAt(index) == '-' || s.charAt(index) == '+') {
                index++;
            }
            prev = index;
            index = matchDigits(s, index);
            if(index == prev) {
                return false;
            }
        }
        while(index < s.length() && Character.isWhitespace(s.charAt(index))) {
            index++;
        }
        return count > 0 && index == s.length();
    }

    private int matchDigits(String s, int index) {
        while(index < s.length() && Character.isDigit(s.charAt(index))) {

            index++;
        }
        return index;
    }

    public static void main(String[] args) {

        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber(" 005047e+6"));
        System.out.println(validNumber.isNumber("."));
        System.out.println(validNumber.isNumber("      1"));
        System.out.println(validNumber.isNumber("1      "));
        System.out.println(validNumber.isNumber("1"));
        System.out.println(validNumber.isNumber("0"));
        System.out.println(validNumber.isNumber("+1"));
        System.out.println(validNumber.isNumber("-1"));
        System.out.println(validNumber.isNumber("1.01"));
        System.out.println(validNumber.isNumber("1.01e10"));
        System.out.println(validNumber.isNumber("1.01e"));
        System.out.println(validNumber.isNumber("1 "));
        System.out.println(validNumber.isNumber("1a"));
        System.out.println(validNumber.isNumber("1e-125e-125"));
    }
}
