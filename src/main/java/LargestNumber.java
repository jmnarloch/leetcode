import java.util.*;

/**
 * Created by jakubnarloch on 22.03.15.
 */
public class LargestNumber {

    public String largestNumber(int[] num) {

        if(num == null || num.length == 0) {
            return null;
        }

        // convert the data into string
        String[] numbers = toStringArray(num);

        Arrays.sort(numbers, new NumberComparator());

        return join(numbers);
    }

    private String[] toStringArray(int[] num) {
        String[] result = new String[num.length];
        for(int ind = 0; ind < result.length; ind++) {
            result[ind] = Integer.toString(num[ind]);
        }
        return result;
    }

    private String join(String[] numbers) {
        StringBuilder builder = new StringBuilder();

        boolean onlyZeros = true;

        for(String num : numbers) {
            if(!num.equals("0")) {
                onlyZeros = false;
            }

            builder.append(num);
        }

        if(onlyZeros) {
            return "0";
        }

        return builder.toString();
    }

    private class NumberComparator implements Comparator<String> {
        @Override
        public int compare(String num1, String num2) {

            String s1 = num1 + num2;
            String s2 = num2 + num1;

            return -s1.compareTo(s2);
        }
    }

    public static void main(String[] args) {

        LargestNumber largest = new LargestNumber();
        System.out.println(largest.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
