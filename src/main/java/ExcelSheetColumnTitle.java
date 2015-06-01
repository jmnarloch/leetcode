/**
 * Created by jakubnarloch on 06.03.15.
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {

        StringBuilder title = new StringBuilder();
        if(n < 1) {
            return title.toString();
        }

        while(n > 0) {
            char c = (char)(( (n - 1)  % 26) + 'A');
            title.append(c);

            n = (n - 1) / 26;
        }
        return title.reverse().toString();
    }

    public static void main(String[] args) {

        ExcelSheetColumnTitle excel = new ExcelSheetColumnTitle();
        System.out.println(excel.convertToTitle(26));
    }
}
