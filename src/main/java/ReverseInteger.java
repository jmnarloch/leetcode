/**
 * Created by jakubnarloch on 04.03.15.
 */
public class ReverseInteger {

    public int reverse(int x) {

        return sgn(x) * reverseAbs(x);
    }

    private int reverseAbs(int x) {
        int abs = Math.abs(x);
        int reverse = 0;
        while(abs > 0) {

            if(Integer.MAX_VALUE / 10 < reverse) {
                return 0;
            }

            reverse = reverse * 10 + abs % 10;
            abs /= 10;
        }
        return reverse;
    }

    private int sgn(int x) {
        if(x == 0) {
            return 0;
        } else if(x > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));
    }
}
