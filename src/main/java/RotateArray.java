import java.util.Arrays;

/**
 * Created by jakubnarloch on 06.03.15.
 */
public class RotateArray {

    // 1,2,3,4,5,6,7

    public void rotate(int[] nums, int k) {

        if(nums == null
                || nums.length <= 1
                || k % nums.length == 0) {
            return;
        }

        final int len = nums.length;
        k = mod(k, len);

        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    private int mod(int a, int n) {
        return (((a % n) + n) % n);
    }

    private void reverse(int[] nums, int lo, int hi) {

        while(lo < hi) {
            exch(nums, lo++, hi--);
        }
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        // TODO implement

        RotateArray rotateArray = new RotateArray();
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(array, 2);
        System.out.println(Arrays.toString(array));
    }
}
