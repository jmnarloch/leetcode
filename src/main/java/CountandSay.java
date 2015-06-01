/**
 * Created by jakubnarloch on 20.03.15.
 */
public class CountandSay {

    public String countAndSay(int n) {

        if(n <= 0) {
            return "";
        }

        StringBuilder current = new StringBuilder("1");
        StringBuilder next;

        char num;
        int occurrences;

        for(int k = 1; k < n; k++) {
            next = new StringBuilder(2 * k);

            num = current.charAt(0);
            occurrences = 1;
            for(int ind = 1; ind < current.length(); ind++) {
                if(current.charAt(ind) == num) {
                    occurrences++;
                } else {
                    next.append(occurrences);
                    next.append(num);

                    num = current.charAt(ind);
                    occurrences = 1;
                }
            }
            next.append(occurrences);
            next.append(num);

            current = next;
        }
        return current.toString();
    }

    public String countAndSay2(int n) {

        if(n <= 0) {
            return "";
        }

        StringBuilder current = new StringBuilder("1");
        return countAndSay(current, n);
    }

    private String countAndSay(StringBuilder current, int n) {
        if(n <= 1) {
            return current.toString();
        }

        StringBuilder next = new StringBuilder();
        char num = current.charAt(0);
        int occurrences = 1;
        for(int ind = 1; ind < current.length(); ind++) {
            if(num == current.charAt(ind)) {
                occurrences++;
            } else {
                next.append(occurrences);
                next.append(num);

                num = current.charAt(ind);
                occurrences = 1;
            }
        }

        next.append(occurrences);
        next.append(num);

        return countAndSay(next, n - 1);
    }

    public static void main(String[] args) {

        CountandSay countandSay = new CountandSay();

        for(int i = 1; i <= 5; i++) {
            System.out.println(countandSay.countAndSay(i));
        }
    }
}
