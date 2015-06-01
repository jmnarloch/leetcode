/**
 * Created by jakubnarloch on 24.03.15.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] A) {

        if(A == null || A.length == 0) {
            return 0;
        }

        int max = A[0];
        int min = A[0];
        int maxProduct = A[0];
        for(int ind = 1; ind < A.length; ind++) {

            int mx = max, mn = min;

            min = Math.min(Math.min(A[ind], A[ind] * mn), A[ind] * mx);
            max = Math.max(Math.max(A[ind], A[ind] * mn), A[ind] * mx);

            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }

    public static void main(String[] args) {

        MaximumProductSubarray max = new MaximumProductSubarray();
        System.out.println(max.maxProduct(new int[] {2, 3, -2, 4}));
    }
}
