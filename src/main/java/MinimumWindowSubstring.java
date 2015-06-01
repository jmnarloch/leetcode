import java.util.HashMap;
import java.util.Map;

/**
 * Created by jakubnarloch on 13.04.15.
 */
public class MinimumWindowSubstring {

    private static final String EMPTY = "";

    public String minWindow(String S, String T) {

        // input: two strings S, T
        // output: the min window String
        // edge cases: S is null, T is null, S is empty, T is empty
        // assumptions: will T contain unique characters?, use of extra memory

        if(S == null || T == null || S.length() == 0 || T.length() == 0) {
            return EMPTY;
        }

        final int N = S.length();
        final int M = T.length();

        Map<Character, Integer> searched = new HashMap<>();
        Map<Character, Integer> found = new HashMap<>();

        for(char c : T.toCharArray()) {
            inc(searched, c);
        }

        int max = Integer.MAX_VALUE;
        int ind = 0;
        int count = 0;
        for(int start = 0, end = 0; end < N; end++) {

            if(!searched.containsKey(S.charAt(end))) {
                continue;
            }

            inc(found, S.charAt(end));
            if(found.get(S.charAt(end)) <= searched.get(S.charAt(end))) {
                count++;
            }

            if(count == M) {
                while(!searched.containsKey(S.charAt(start))
                        || found.get(S.charAt(start)) > searched.get(S.charAt(start))) {
                    if(searched.containsKey(S.charAt(start)) && found.get(S.charAt(start)) > searched.get(S.charAt(start))) {
                        dec(found, S.charAt(start));
                    }
                    start++;
                }

                final int length = end - start + 1;
                if(length < max) {
                    max = length;
                    ind = start;
                }
            }
        }

        if(max == Integer.MAX_VALUE) {
            return "";
        } else {
            return S.substring(ind, ind + max);
        }
    }

    private void inc(Map<Character, Integer> map, char c) {
        int count = map.containsKey(c) ? map.get(c) : 0;
        map.put(c, count + 1);
    }

    private void dec(Map<Character, Integer> map, char c) {
        int count = map.containsKey(c) ? map.get(c) : 0;
        map.put(c, count - 1);
    }

    public static void main(String[] args) {

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }
}
