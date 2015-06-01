/**
 * Created by jakubnarloch on 23.04.15.
 */
public class HappyNumbers {

    public boolean isHappy(int n) {
        if(n <= 0) {
            return false;
        } else if(n == 1) {
            return true;
        }

        int number = sumOfSquare(n);
        while(number >= 10) {
            number = sumOfSquare(number);
        }

        return number == 1 || number == 7;
    }

    private int sumOfSquare(int n) {

        int digit;
        int sum = 0;

        while(n > 0) {
            digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }

        return sum;
    }

    public static void main(String[] args) {

        // 1, 10, 100, 1000, 10000, 100000

        // 2, 4, 16, 37, 58, 89, 145, 42, 20, 2
        // 3, 9, 81, 65, 61, 37, 58, 89, 145, 42, 20, 2
        // 4, 16,
        // 5, 25, 29, 85, 89, 145, 42, 20
        // 6,
        // 9,

        HappyNumbers happyNumbers = new HappyNumbers();
        System.out.println(happyNumbers.isHappy(5));
    }
}
