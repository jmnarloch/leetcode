/**
 * Created by jakubnarloch on 09.04.15.
 */
public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] num) {

        // input: a rotated sorted array of integers
        // output: minimum value in the array
        // edge cases: the num is null, the num is empty, the num contains only one element
        // assumptions: the array is rotated, the array may contain duplicate values

        if(num == null || num.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;

        while(num[lo] >= num[hi]) {
            if(hi - lo == 1) {
                mid = hi;
                break;
            }

            mid = lo + (hi - lo) / 2;
            if(num[lo] == num[mid] && num[mid] == num[hi]) {
                mid = find(num, lo, hi);
                break;
            }

            if(num[mid] >= num[lo]) {
                lo = mid;
            } else /* if(num[mid] <= num[hi]) */ {
                hi = mid;
            }
        }
        return num[mid];
    }

    private int find(int[] num, int lo, int hi) {
        int min = lo;
        for(int ind = lo; ind <= hi; ind++) {
            if(num[ind] < num[min]) {
                min = ind;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        FindMinimuminRotatedSortedArrayII minimum = new FindMinimuminRotatedSortedArrayII();
        System.out.println(minimum.findMin(new int[] {4, 5, 1, 2, 3}));
        System.out.println(minimum.findMin(new int[] {2, 2, 2, 1, 2, 2}));
    }
}
