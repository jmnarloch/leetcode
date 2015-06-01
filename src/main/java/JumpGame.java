/**
 * Created by jakubnarloch on 07.03.15.
 */
public class JumpGame {

    public boolean canJump(int[] A) {

        if (A == null || A.length == 0) {
            return false;
        }

        int ind = 0;
        int max = A[0] + ind;
        while(ind < A.length && ind <= max) {
            if(max >= A.length - 1) {
                break;
            }
            max = Math.max(max, A[ind] + ind);
            ind++;
        }

        return max >= A.length - 1;
    }

    public boolean canJump2(int[] A) {

        if (A == null || A.length == 0) {
            return false;
        }
        final int length = A.length;

        int[] jump = new int[length];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i] + i);
            jump[i] = max;
        }

        int ind = 0;
        for (int k = 0; k < length - 1; k++) {
            int prev = ind;
            if (jump[ind] >= length - 1) {
                return true;
            }
            ind = jump[ind];
            if (ind == prev) {
                return false;
            }
        }

        return ind == length - 1;
    }

    public static void main(String[] args) {

        final int[] a = new int[]{2, 3, 1, 1, 4};
        final int[] b = new int[]{3, 2, 1, 0, 4};
        final int[] c = new int[]{2, 5, 0, 0};
        final int[] d = new int[]{1, 2, 3};
        final int[] e = new int[]{0, 1};

        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(e));
    }
}
