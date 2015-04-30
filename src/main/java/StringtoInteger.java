/**
 * Created by jakubnarloch on 04.03.15.
 */
public class StringtoInteger {

    public int atoi(String str) {

        if(str == null || str.length() == 0) {
            return 0;
        }

        double result = 0;
        int index = 0;
        char sign = '+';
        // strip the whitespaces
        while(index < str.length()
                && Character.isWhitespace(str.charAt(index))) {
            index++;
        }

        if(index < str.length()) {
            if(str.charAt(index) == '-') {
                sign = str.charAt(index);
                index++;
            } else if(str.charAt(index) == '+') {
                sign = str.charAt(index);
                index++;
            }
        }

        while(index < str.length()) {
            if(str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            result = 10 * result + (str.charAt(index) - '0');
            index++;
        }

        if(sign == '-') {
            result = -result;
        }

        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)result;
    }

    public static void main(String[] args) {

        StringtoInteger stringtoInteger = new StringtoInteger();
        System.out.println(stringtoInteger.atoi("9223372036854775809"));
    }
}
