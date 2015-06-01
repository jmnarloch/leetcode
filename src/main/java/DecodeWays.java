/**
 * Created by jakubnarloch on 09.04.15.
 */
public class DecodeWays {

    public int numDecodings(String s) {

        // input: the string with number encodings
        // output: the unique number of ways to decode the string
        // edge cases: the string is null, the string is empty, the string contains 0
        // assumptions: use extra memory, the input can contain only digit

        if(s == null || s.length() == 0) {
            return 0;
        }

        if(s.charAt(0) == '0') {
            return 0;
        }

        final int N = s.length();
        final int[] ways = new int[N];
        ways[0] = 1;

        for(int ind = 1; ind < N; ind++) {
            if(s.charAt(ind) == '0') {
                if(s.charAt(ind - 1) == '1' || s.charAt(ind - 1) == '2') {
                    ways[ind] = ind >= 2 ? ways[ind - 2] : 1;
                } else {
                    return 0;
                }
            } else {
                if(isValid(s.charAt(ind - 1), s.charAt(ind))) {
                    ways[ind] = ind >= 2 ? ways[ind - 1] + ways[ind - 2] : 2;
                } else {
                    ways[ind] = ways[ind - 1];
                }
            }
        }
        return ways[N - 1];
    }

    private boolean isValid(char a, char b) {
        if(a == '1') {
            return true;
        } else if(a == '2' && b <= '6') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("101"));
    }
}
