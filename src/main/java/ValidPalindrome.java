/**
 * Created by jakubnarloch on 12.03.15.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        if(s == null) {
            return false;
        }

        int lo = 0;
        int hi = s.length() - 1;

        while(true) {

            while(lo < hi && !Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
            }
            while(lo < hi && !Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
            }

            if(hi <= lo) {
                break;
            }

            if(Character.toLowerCase(s.charAt(lo)) == Character.toLowerCase(s.charAt(hi))) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        ValidPalindrome palindrome = new ValidPalindrome();

        System.out.println(palindrome.isPalindrome("1a2"));
    }
}
