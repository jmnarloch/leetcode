/**
 * Created by jakubnarloch on 06.04.15.
 */
public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] num) {

        // input: the sorted shifted array of integers
        // output: the minimum
        // edge cases: num is null or empty
        // test cases: the array is rotated, the array is sorted asc
        // assumptions: there are no duplicates

        if(num == null || num.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = num.length - 1;

        int mid = 0;
        while(num[lo] > num[hi]) {
            if(lo + 1 == hi
                    && num[lo] > num[hi]) {
                mid = hi;
                break;
            }

            mid = lo + (hi - lo) / 2;
            if(num[mid] >= num[lo]) {
                lo = mid;
            } else /*if(num[mid] > num[lo])*/ {
                hi = mid;
            }

        }
        return num[mid];
    }

    public static void main(String[] args) {

        final int[] num = new int[] {4, 5, 6, 7, 0, 1, 2};

        FindMinimuminRotatedSortedArray sortedArray = new FindMinimuminRotatedSortedArray();
        System.out.println(sortedArray.findMin(num));
        System.out.println(sortedArray.findMin(new int[] {1}));
    }
}
