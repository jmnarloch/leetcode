/**
 * Created by jakubnarloch on 11.04.15.
 */
public class TrappingRainWater {

    public int trap(int[] A) {

        // input: the array of heights non-negative
        // output: the maximum amount of rain
        // edge cases: A is null, A is empty

        if (A == null || A.length == 0) {
            return 0;
        }

        final int N = A.length;
        int left = A[0];

        final int[] rigth = new int[N];
        rigth[N - 1] = A[N - 1];
        for (int ind = A.length - 2; ind >= 0; ind--) {
            rigth[ind] = Math.max(A[ind], rigth[ind + 1]);
        }

        int trap = 0;
        for (int ind = 0; ind < A.length; ind++) {
            left = Math.max(left, A[ind]);
            trap += Math.max(0, Math.min(left, rigth[ind]) - A[ind]);
        }
        return trap;
    }

    public int trap2(int[] A) {

        // input: the array of heights non-negative
        // output: the maximum amount of rain
        // edge cases: A is null, A is empty

        if (A == null || A.length == 0) {
            return 0;
        }

        final int N = A.length;
        final int[] left = new int[N];
        final int[] rigth = new int[N];

        left[0] = A[0];
        rigth[N - 1] = A[N - 1];
        for (int ind = 1; ind < A.length; ind++) {
            left[ind] = Math.max(A[ind], left[ind - 1]);
        }
        for (int ind = A.length - 2; ind >= 0; ind--) {
            rigth[ind] = Math.max(A[ind], rigth[ind + 1]);
        }

        int trap = 0;
        for (int ind = 0; ind < A.length; ind++) {
            trap += Math.max(0, Math.min(left[ind], rigth[ind]) - A[ind]);
        }
        return trap;
    }

    public static void main(String[] args) {

        TrappingRainWater water = new TrappingRainWater();
        System.out.println(water.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
