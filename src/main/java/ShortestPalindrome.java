import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class ShortestPalindrome {

    private static final int R = 26;

    public String shortestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        final int N = s.length();
        final int ch[][] = new int[N + 1][R];
        final Deque<Integer> candidates = new LinkedList<>();

        for(int ind = 1; ind <= N; ind++) {
            final int len = ind;
            int odds = 0;

            ch[ind][s.charAt(ind - 1) - 'a']++;
            for(int c = 0; c < ch[ind].length; c++) {
                ch[ind][c] += ch[ind - 1][c];
                if(ch[ind][c] % 2 == 1) {
                    odds++;
                }
            }

            if((len % 2 == 0 && odds == 0) || (len % 2 == 1 && odds == 1)) {
                candidates.push(ind - 1);
            }
        }

        if(candidates.size() != 0) {

            while(candidates.size() > 0) {
                final int end = candidates.pop() + 1;
                if(isPalindrome(s, 0, end - 1)) {
                    String rest = s.substring(end);
                    return new StringBuilder()
                            .append(rest)
                            .reverse()
                            .append(s.substring(0, end))
                            .append(rest)
                            .toString();
                }
            }
        }
        return new StringBuilder()
                .append(s.substring(1))
                .reverse()
                .append(s)
                .toString();
    }

    public String shortestPalindrome3(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        // find the longest palindrome starting from 0
        for (int ind = s.length() - 1; ind >= 0; ind--) {
            if (s.charAt(0) != s.charAt(ind)) {
                continue;
            } else if (isPalindrome(s, 0, ind)) {
                return new StringBuilder(s.substring(ind + 1))
                        .reverse()
                        .append(s)
                        .toString();
            }
        }
        return "";
    }

    public String shortestPalindrome4(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        final int N = s.length();
        final String reversed = reverse(s.substring(1));
        final String concat = reversed.concat(s);

        final int end = concat.length() - 1;
        int ind = N - 1;

        while (ind >= 0) {
            while (concat.charAt(ind) != concat.charAt(end)) {
                ind--;
            }

            if (isPalindrome(concat, ind, end)) {
                return concat.substring(ind);
            }
            ind--;
        }
        return "";
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {

        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        System.out.println(shortestPalindrome.shortestPalindrome("ba"));
        System.out.println(shortestPalindrome.shortestPalindrome("abbacd"));
        System.out.println(shortestPalindrome.shortestPalindrome("aabbaad"));
        System.out.println(shortestPalindrome.shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome.shortestPalindrome("adcba"));
        System.out.println(shortestPalindrome.shortestPalindrome("a"));
        System.out.println(shortestPalindrome.shortestPalindrome("abcd"));
    }
}
