import java.util.Arrays;

/**
 * Created by jakubnarloch on 14.04.15.
 */
public class ScrambleString {

    public boolean isScramble(String s1, String s2) {

        // input: two strings s1, s2
        // output: flag indicating whether the two strings are scrambled
        // edge cases: the s1 or s2 is null, s1 or s2 is empty, does not contain same characters, s1 = s2, |s1| != |s2|
        // test cases: a scrambled string rgtae grate, ab cd

        if(s1 == null || s2 == null) {
            return false;
        } else if(s1.length() == 0 || s2.length() == 0) {
            return true;
        } else if(s1.length() != s2.length()) {
            return false;
        } else if(s1.equals(s2)) {
            return true;
        } else if(!sameChars(s1, s2)) {
            return false;
        }

        for(int len = 1; len < s1.length(); len++) {

            if(isScramble(s1.substring(0, len), s2.substring(0, len)) && isScramble(s1.substring(len), s2.substring(len))
                    || isScramble(s1.substring(0, len),  s2.substring(s2.length() - len)) && isScramble(s1.substring(len), s2.substring(0, s2.length() - len))) {
                return true;
            }
        }

        return false;
    }

    private boolean sameChars(String s1, String s2) {

        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);

        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);

        return new String(a1).equals(new String(a2));
    }

    public static void main(String[] args) {

        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("rgeat", "great"));
        System.out.println(scrambleString.isScramble("great", "rgeat"));
        System.out.println(scrambleString.isScramble("rgtae", "great"));
    }
}
