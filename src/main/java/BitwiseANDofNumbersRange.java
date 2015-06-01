/**
 * Created by jakubnarloch on 16.04.15.
 */
public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {

        // 1 0001
        // 2 0010
        // 3 0011
        // 4 0100
        // 5 0101
        // 6 0110
        // 7 0111
        // 8 1000

        // 7 & 5 - 101
        // 7 | 5 - 111
        // 7 - 5 - 010
        // 7 ^ 5 - 010
        // 7 + 5 -1100

        // 5 6 7
        // 0101 0110 0111

        final int result = m & n;
        int diff = n - m;

        int mask = 0;

        while(diff > 0) {
            mask = mask << 1 | 1;
            diff >>>= 1;
        }

        return result & ~mask;
    }

    public static void main(String[] args) {

        BitwiseANDofNumbersRange bit = new BitwiseANDofNumbersRange();
        System.out.println(bit.rangeBitwiseAnd(5, 7));
    }
}
