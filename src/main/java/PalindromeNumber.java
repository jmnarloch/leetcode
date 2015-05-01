/**
 *
 */
public class PalindromeNumber {

    /**
     *
     */
    public boolean isPalindrome(int x) {

        return x == reverse(x);
    }

    private int reverse(int x) {

        int rev = 0;
        while(x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {

        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(12321));
    }
}
