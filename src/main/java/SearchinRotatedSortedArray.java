/**
 * Created by jakubnarloch on 24.03.15.
 */
public class SearchinRotatedSortedArray {

    public int search(int[] A, int target) {

        // input: the array A of integers N, the search value
        // output: the index of the searched element or -1 if not found
        // assumptions: the array has been sorted and then rotated
        // edge cases: A is null, A is empty, A was not rotated, A contains duplicates
        // approaches: binary search

        if (A == null || A.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = A.length - 1;

        while(lo <= hi) {
            final int mid = lo + (hi - lo) / 2;
            if(A[mid] == target) {
                return mid;
            }

            if(A[lo] <= A[mid]) {
                // lower half is sorted
                if(A[lo] <= target && A[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if(A[hi] >= target && target > A[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        SearchinRotatedSortedArray search = new SearchinRotatedSortedArray();
        System.out.println(search.search(new int[]{3, 4, 5, 1, 2}, 1));
        System.out.println(search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(search.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }
}

