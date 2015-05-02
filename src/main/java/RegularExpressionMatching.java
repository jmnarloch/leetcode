/**
 * Created by jakubnarloch on 04.03.15.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        // input: text s the search text, p the pattern
        // output: flag indicating whether the text matcher the pattern
        // edge cases: s is null or p is null
        //             s is empty and p is empty
        // assumptions: we match the entire string, can we escape this characters
        // test cases: s or p is null, s or p is empty, s and p are equal, p contains only '.', p contains only .*,
        //             p starts with *
        // approaches: backtracking implementation O(2^N)

        if(s == null || p == null) {
            return false;
        }
        if(s.isEmpty() && p.isEmpty()) {
            return true;
        }

        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {

        if(i >= s.length() || j >= p.length()) {
            while(nextWildcard(p, j)) {
                j+=2;
            }
            return i == s.length() && j == p.length();
        }

        if(j == p.length() - 1 || (j < p.length() - 1 && p.charAt(j + 1) != '*')) {
            return matchesChar(s, i, p, j) && isMatch(s, i + 1, p, j + 1);
        }

        while(i < s.length() && (matchesChar(s, i, p, j))) {
            if(isMatch(s, i, p, j + 2)) {
                return true;
            }
            i++;
        }
        return isMatch(s, i, p, j + 2);
    }

    private boolean nextWildcard(String p, int j) {
        return j < p.length() - 1 && p.charAt(j + 1) == '*';
    }

    private boolean matchesChar(String s, int i, String p, int j) {
        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }

    public static void main(String[] args) {

        RegularExpressionMatching solution = new RegularExpressionMatching();
        System.out.println(solution.isMatch("aab", "c*a*b*"));
        System.out.println(solution.isMatch("a", ".*..a*"));
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("ab", ".*..c*"));
        System.out.println(solution.isMatch("aaa", "aa"));
        System.out.println(solution.isMatch("a", "ab*"));
        System.out.println(solution.isMatch("a", "*"));
    }
}
