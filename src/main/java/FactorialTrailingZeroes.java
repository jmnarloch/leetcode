/**
 * Created by jakubnarloch on 06.03.15.
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {

        if(n <= 0) {
            return 0;
        }

        return countDivPow(n, 5);
    }

    private int countDivPow(int n, int div) {

        int count = 0;
        for(long pow = 5; n / pow >= 1; pow *= div) {

            count += n / pow;
        }
        return count;
    }

    public static void main(String[] args) {

        FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        System.out.println(factorialTrailingZeroes.trailingZeroes(1808548329));
    }
}
