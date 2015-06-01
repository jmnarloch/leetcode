/**
 * Created by jakubnarloch on 31.03.15.
 */
public class HouseRobber {

    public int rob(int[] num) {

        if(num == null || num.length == 0) {
            return 0;
        }

        final int len = num.length;
        int prevN = 0;
        int prevY = 0;

        for(int ind = 1; ind <= len; ind++) {

            int tmp = prevN;
            prevN = Math.max(prevN, prevY);
            prevY = num[ind - 1] + tmp;
        }
        return Math.max(prevN, prevY);
    }

    public int rob2(int[] num) {

        if(num == null || num.length == 0) {
            return 0;
        }

        final int len = num.length;
        final int[][] solutions = new int[len + 1][2];

        for(int ind = 1; ind <= len; ind++) {

            solutions[ind][0] = Math.max(solutions[ind - 1][0], solutions[ind - 1][1]);
            solutions[ind][1] = num[ind - 1] + solutions[ind - 1][0];
        }
        return Math.max(solutions[len][0], solutions[len][1]);
    }

    public int rob3(int[] num) {

        if(num == null || num.length == 0) {
            return 0;
        }

        Integer[] solutions = new Integer[num.length];
        return rob3(num, 0, solutions);
    }

    private int rob3(int[] num, int index, Integer[] solutions) {

        if(index >= num.length) {
            return 0;
        } else if(index == num.length - 1) {
            return num[index];
        } else if(solutions[index] != null) {
            return solutions[index];
        }

        int sum1 = num[index] + rob3(num, index + 2, solutions);
        int sum2 = num[index + 1] + rob3(num, index + 3, solutions);
        solutions[index] = Math.max(sum1, sum2);
        return solutions[index];
    }

    public int rob4(int[] num) {

        // input: the array A of non negative integers N: N >= 0
        // output: the maximum robbery value from the non adjacent houses
        // edge cases: num is null, num is empty, num contains single house
        // assumptions: use of additional memory
        // approaches: recursive (exponential O(2^N) - slow), dynamic programming (linear) O(N)

        if(num == null || num.length == 0) {
            return 0;
        }

        return rob4(num, 0);
    }

    private int rob4(int[] num, int index) {
        if(index >= num.length) {
            return 0;
        } else if(index == num.length - 1) {
            return num[index];
        }

        int sum1 = num[index] + rob4(num, index + 2);
        int sum2 = num[index + 1] + rob4(num, index + 3);

        return Math.max(sum1, sum2);
    }
}
