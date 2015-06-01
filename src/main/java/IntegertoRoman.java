/**
 * Created by jakubnarloch on 21.03.15.
 */
public class IntegertoRoman {

    // 1: I
    // 5: V
    // 10: X
    // 50: L
    // 100: C
    // 500: D
    // 1000: M

    private static final short[] NUMBERS = new short[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {

        // input: the integer number
        // output: the string representation of the roman numeral
        // edge cases: the num is negative, num is zero

        if (num <= 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        int number = 0;
        while (num > 0) {

            if (num >= NUMBERS[number]) {
                builder.append(ROMANS[number]);
                num -= NUMBERS[number];
            } else {
                number++;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        IntegertoRoman intToRoman = new IntegertoRoman();
        System.out.println(intToRoman.intToRoman(1));
        System.out.println(intToRoman.intToRoman(3));
        System.out.println(intToRoman.intToRoman(4));
        System.out.println(intToRoman.intToRoman(5));
        System.out.println(intToRoman.intToRoman(6));
        System.out.println(intToRoman.intToRoman(9));
        System.out.println(intToRoman.intToRoman(10));
        System.out.println(intToRoman.intToRoman(49));
        System.out.println(intToRoman.intToRoman(50));
        System.out.println(intToRoman.intToRoman(100));
        System.out.println(intToRoman.intToRoman(500));
        System.out.println(intToRoman.intToRoman(1000));
        System.out.println(intToRoman.intToRoman(41));
    }
}
