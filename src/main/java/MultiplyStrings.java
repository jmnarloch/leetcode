import java.math.BigInteger;

/**
 * Created by jakubnarloch on 22.03.15.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }
}
