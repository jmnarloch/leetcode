/**
 * Created by jakubnarloch on 12.03.15.
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        int number = 0;
        for(int ind = 0; ind < s.length(); ind++) {

            int dig = s.charAt(ind) - 'A' + 1;
            number = number * 26 + dig;
        }
        return number;
    }

    public static void main(String[] args) {

        ExcelSheetColumnNumber excel = new ExcelSheetColumnNumber();

        System.out.println(excel.titleToNumber("Z"));
    }
}
