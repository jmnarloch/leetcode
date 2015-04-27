/**
 * Created by jakubnarloch on 01.04.15.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        // input: the input text
        // output: the longest palindroming sub string
        // edge cases: the text is null, the text is empty
        // assumptions: can use additional memory
        // approaches: O(N ^ 2)
        // O(N)

        if(s == null || s.length() == 0) {
            return "";
        }

        final int N = s.length();
        String longest = s.substring(0, 1);
        String candidate;

        for(int ind = 0; ind < N - 1; ind++) {
            candidate = expandPalindrome(s, ind, ind);
            if(candidate.length() > longest.length()) {
                longest = candidate;
            }

            candidate = expandPalindrome(s, ind, ind + 1);
            if(candidate.length() > longest.length()) {
                longest = candidate;
            }
        }
        return longest;
    }

    private String expandPalindrome(String s, int lo, int hi) {

        while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        return s.substring(lo + 1, hi);
    }

    public String longestPalindrome2(String s) {

        // input: the input text
        // output: the longest palindroming sub string
        // edge cases: the text is null, the text is empty
        // assumptions: can use additional memory
        // approaches: O(N ^ 2)
        // O(N)

        if(s == null || s.length() == 0) {
            return "";
        }

        final int N = s.length();
        boolean[][] palindromes = new boolean[N][N];

        int begin = 0;
        int maxLen = 1;

        for(int ind = 0; ind < N; ind++) {
            palindromes[ind][ind] = true;
        }

        for(int ind = 0; ind < N - 1; ind++) {
            if(s.charAt(ind) == s.charAt(ind - 1)) {
                palindromes[ind][ind + 1] = true;
                begin = ind;
                maxLen = 2;
            }
        }

        for(int len = 3; len <= N; len++) {
            for(int i = 0; i < N - len + 1; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && palindromes[i + 1][j - 1]) {
                    palindromes[i][j] = true;
                    begin = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome3(String s) {

        // input: the input text
        // output: the longest palindroming sub string
        // edge cases: the text is null, the text is empty
        // assumptions: can use additional memory
        // approaches: O(N ^ 2)
        // O(N)

        if(s == null || s.length() == 0) {
            return "";
        }

        int length = 0;
        int index = -1;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length(); j++) {

                if(isPalindrome(s, i, j)) {
                    index = i;
                    length = Math.max(length, j - i + 1);
                }
            }
        }

        if(index == -1) {
            return "";
        }
        return s.substring(index, index + length);
    }

    private boolean isPalindrome(String s, int lo, int hi) {

        while(lo < hi) {

            if(s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return false;
    }

    public static void main(String[] args) {

        LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
        System.out.println(substring.longestPalindrome("abb"));
    }
}
