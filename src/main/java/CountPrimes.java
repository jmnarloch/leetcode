import java.util.BitSet;

/**
 *
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if(n <= 1) {
            return 0;
        }

        final BitSet sieve = new BitSet(n);
        sieve.set(0, true);
        sieve.set(1, true);
        int complex = 2;

        int num = 2;
        int sq = num * num;
        while(sq < n) {
            if(!sieve.get(num)) {

                for(int mul = sq; mul < n; mul += num) {
                    if(!sieve.get(mul)) {
                        sieve.set(mul, true);
                        complex++;
                    }
                }
            }

            sq += 2 * num + 1;
            num++;
        }

        return n - complex;
    }
}
