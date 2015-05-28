import java.util.HashMap;
import java.util.Map;

/**
 * Created by jakubnarloch on 29.04.15.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        // input: two strings s and t
        // output: flag indicating whether the strings are isomorphic
        // edge cases: both strings are null, both are empty, they have different length
        // assumptions: use extra space
        // approaches:

        if(s == null || t == null) {
            return false;
        } else if(s.length() != t.length()) {
            return false;
        }

        final Map<Character, Character> chars = new HashMap<Character, Character>();
        final Map<Character, Character> reverse = new HashMap<Character, Character>();

        for(int ind = 0; ind < s.length(); ind++) {

            final char src = s.charAt(ind);
            final char des = t.charAt(ind);

            if(!chars.containsKey(src) && !reverse.containsKey(des)) {
                chars.put(src, des);
                reverse.put(des, src);
            } else {
                if((chars.containsKey(src) && chars.get(src) != des)
                        || (reverse.containsKey(des) && reverse.get(des) != src)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        IsomorphicStrings isomorphic = new IsomorphicStrings();
        System.out.println(isomorphic.isIsomorphic("egg", "add"));
        System.out.println(isomorphic.isIsomorphic("foo", "bar"));
        System.out.println(isomorphic.isIsomorphic("paper", "title"));
        System.out.println(isomorphic.isIsomorphic("ab", "aa"));
    }
}
