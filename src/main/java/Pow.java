/**
 * Created by jakubnarloch on 21.03.15.
 */
public class Pow {

    public double pow(final double x, int n) {

        if(n == 0) {
            return 1D;
        } else if(n == 1) {
            return x;
        } else if(n < 0) {
            double div = 1;
            if(n == Integer.MIN_VALUE) {
                div *= x;
                n++;
            }
            div *= pow(x, -n);

            return 1.0 / div;
        }
        if(n % 2 == 1) {
            return x * pow(x, n - 1);
        } else {
            double p = pow(x, n / 2);
            return p * p;
        }
    }

    public static void main(String[] args) {

        Pow pow = new Pow();
//        System.out.println(pow.pow(2, -1));
        System.out.println(pow.pow(1, Integer.MIN_VALUE));
    }
}
