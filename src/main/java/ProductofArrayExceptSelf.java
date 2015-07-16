/**
 * ProductofArrayExceptSelf
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        final int N = nums.length;

        final int[] result = new int[N];
        result[N - 1] = nums[N - 1];
        for(int ind = N - 2; ind >= 0; ind--) {
            result[ind] = result[ind + 1] * nums[ind];
        }

        int left = 1;
        for(int ind = 0; ind < N; ind++) {
            result[ind] = left * (ind < N - 1 ? result[ind + 1] : 1);
            left *= nums[ind];
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        final int N = nums.length;
        final int[] lefts = new int[N];
        final int[] rights = new int[N];

        for(int ind = 0; ind < N; ind++) {
            if(ind > 0) {
                lefts[ind] = lefts[ind - 1];
                rights[N - 1 - ind] = rights[N - ind];
            } else {
                lefts[ind] = 1;
                rights[N - 1 - ind] = 1;
            }
            lefts[ind] *= nums[ind];
            rights[N - 1 - ind] *= nums[N - 1 -ind];
        }

        final int[] result = new int[N];
        for(int ind = 0; ind < N; ind++) {
            final int left = ind > 0 ? lefts[ind - 1] : 1;
            final int right = ind < N - 1 ? rights[ind + 1] : 1;

            result[ind] = left * right;
        }
        return result;
    }
}
