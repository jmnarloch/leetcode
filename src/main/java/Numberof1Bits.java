/**
 * Created by jakubnarloch on 13.03.15.
 */
public class Numberof1Bits {

    public int hammingWeight(int n) {

        int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                count++;
            }

            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {

        Numberof1Bits nb = new Numberof1Bits();
        System.out.println(nb.hammingWeight(11));
    }
}
