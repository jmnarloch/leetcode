/**
 * Created by jakubnarloch on 10.04.15.
 */
public class JumpGameII {

    public int jump(int[] A) {

        // input: the array of integers
        // output: the minimum number of jumps to reach the last element
        // edge cases: A is null, A is empty, A has only one element, last element can be reached,
        //             last element can not be reached

        if (A == null || A.length <= 1) {
            return 0;
        }

        int[] max = new int[A.length];
        max[0] = A[0];
        for (int ind = 1; ind < A.length; ind++) {
            max[ind] = Math.max(max[ind - 1], A[ind] + ind);
        }

        int index = max[0];
        int jumps = 1;
        while (index < A.length - 1) {
            final int prev = index;

            index = max[index];
            jumps++;

            // we didn't make any progress
            if (prev == index) {
                return 0;
            }
            if(index >= A.length - 1) {
                break;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {

        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(jumpGameII.jump(new int[]{2, 1}));
//        System.out.println(jumpGameII.jump(new int[]{1}));
//        System.out.println(jumpGameII.jump(new int[]{1, 2, 3}));
    }
}
