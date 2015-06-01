/**
 * Created by jakubnarloch on 05.03.15.
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {

        if (s == null || nRows == 0) {
            return null;
        }

        StringBuilder result = new StringBuilder(s.length());
        for (int row = 0; row < nRows; row++) {
            if (result.length() == s.length()) {
                break;
            }

            int next = row;
            if(row % 2 == 0) {
                while(next < s.length()) {

                    result.append(s.charAt(next));
                    next += nRows + nRows / 2;
                }
            } else {
                int col = 0;
                while(next < s.length()) {
                    result.append(s.charAt(next));
                    if(col % 2 == 0) {
                        next += nRows / 2 + 1;
                    } else {
                        next += nRows - row;
                    }
                    col++;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        ZigZagConversion zigZag = new ZigZagConversion();
        System.out.println(zigZag.convert("ABC", 2));
    }
}
