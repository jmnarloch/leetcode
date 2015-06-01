/**
 * Created by jakubnarloch on 29.03.15.
 */
public class FindPeakElement {

    public int findPeakElement(int[] num) {

        // input: the array of integers
        // output: the index of the peak element
        // edge cases: the num is null, num is empty, num length is < 3, num does not contain peak

        if(num == null || num.length == 0) {
            return -1;
        }

        if(num.length == 1) {
            return 0;
        }

        for(int ind = 1; ind < num.length - 1; ind++) {

            if((ind == 0 && num[ind] > num[ind +1]) || (ind == num.length - 1 && num[ind] > num[ind - 1])
                    || (ind > 0 && ind < num.length - 1 && num[ind] > num[ind - 1] && num[ind] > num[ind + 1])) {
                return ind;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        FindPeakElement peak = new FindPeakElement();
        System.out.println(peak.findPeakElement(new int[] {1, 2, 3, 1}));
    }
}
