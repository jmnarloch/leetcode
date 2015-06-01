/**
 * Created by jakubnarloch on 24.03.15.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {

        if(A == null || A.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = A.length - 1;

        while(lo <= hi) {

            int mid = lo + (hi - lo) / 2;
            if(target < A[mid]) {
                hi = mid - 1;
            } else if (target > A[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {

        SearchInsertPosition search = new SearchInsertPosition();

        System.out.println(search.searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(search.searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(search.searchInsert(new int[] {1,3,5,6}, 7));
        System.out.println(search.searchInsert(new int[] {1,3,5,6}, 0));
    }
}
