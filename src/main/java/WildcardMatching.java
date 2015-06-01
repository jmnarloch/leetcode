/**
 * Created by jakubnarloch on 21.03.15.
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {

        if(s == null || p == null) {
            return false;
        }
        if(s.isEmpty() && p.isEmpty()) {
            return true;
        }
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int i, String p, int j) {

        int starInd = -1;
        int prev = 0;
        while(i < s.length()) {

            if(j < p.length() && match(s, i, p, j)) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {

                starInd = j;
                prev = i;
                j++;
            } else if(starInd != -1) {

                j = starInd + 1;
                i = ++prev;
            } else {
                return false;
            }
        }

        while(j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }

    private boolean match(String s, int i, String p, int j) {

        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '?';
    }

    public boolean isMatch2(String s, String p) {

        // input: s - the text to search and p - pattern to be exactly match
        //        pattern contains two special characters '?' and '*' that matches 0, 1, or multiple chars
        // output: flag indicating whether the pattern matches exactly the given string
        // assumptions: '*' matches 0, 1, or many characters
        // edge cases: s or p are null, s is empty or p is empty
        // approaches to the problem:
        // #1 backtracking
        // #2 nfa

        if(s == null || p == null) {
            return false;
        }
        if(s.isEmpty() && p.isEmpty()) {
            return true;
        }

        return isMatch3(s, 0, p, 0);
    }

    private boolean isMatch3(String s, int i, String p, int j) {

        while(i < s.length() && j < p.length()) {

            if(p.charAt(j) == '*') {
                while(j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    j++;
                }

                return isMatch3(s, i + 1, p, j + 1)
                        || isMatch3(s, i + 1, p, j)
                        || isMatch3(s, i, p, j + 1);
            } else if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }

        while(j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return i == s.length() && j == p.length();
    }

    public static void main(String[] args) {

        WildcardMatching wm = new WildcardMatching();
//        System.out.println(wm.isMatch("bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
        System.out.println(wm.isMatch("aa", "*"));
    }
}
