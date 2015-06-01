import java.util.Arrays;

/**
 * Created by jakubnarloch on 01.04.15.
 */
public class SearchforaRange {

    public int[] searchRange(int[] A, int target) {

        final int[] result = new int[] {-1, -1};
        if(A == null || A.length == 0) {
            return result;
        }

        result[0] = start(A, target);
        result[1] = end(A, target);
        return result;
    }

    private int start(int[] a, int target) {

        int lo = 0;
        int hi = a.length - 1;

        while(lo <= hi) {
            final int middle = lo + (hi - lo) / 2;
            if(a[middle] == target) {
                if((middle > 0 && a[middle - 1] != target) || middle == 0) {
                    return middle;
                }

                hi = middle - 1;
            } else if(a[middle] > target) {
                hi = middle - 1;
            } else {
                lo = middle + 1;
            }
        }

        return -1;
    }

    private int end(int[] a, int target) {

        int lo = 0;
        int hi = a.length - 1;

        while(lo <= hi) {
            final int middle = lo + (hi - lo) / 2;
            if(a[middle] == target) {
                if((middle < a.length - 1 && a[middle + 1] != target)
                        || middle == a.length - 1) {
                    return middle;
                }

                lo = middle + 1;
            } else if(a[middle] > target) {
                hi = middle - 1;
            } else {
                lo = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int target = 8;
        int[] data = new int[] {5, 7, 7, 8, 8, 10};
        SearchforaRange search = new SearchforaRange();
//        System.out.println(Arrays.toString(search.searchRange(data, target)));
        System.out.println(Arrays.toString(search.searchRange(new int[] {2, 2}, 2)));
    }
}
