/**
 * Created by jakubnarloch on 08.04.15.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        // input: the string
        // output: the longest substring containing at most two distinct characters
        // edge cases: s is null, s is empty
        // assumptions: the alphabet ()

        if(s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int j = -1;

        int max = 0;
        for (int ind = 1; ind < s.length(); ind++) {

            if(s.charAt(ind) == s.charAt(ind - 1)) {
                continue;
            }
            if(j >= 0 && s.charAt(ind) != s.charAt(j)) {
                max = Math.max(max, ind - i);
                i = j + 1;
            }

            j = ind - 1;
        }
        return Math.max(max, s.length() - i);
    }

    public static void main(String[] args) {

        LongestSubstringwithAtMostTwoDistinctCharacters longest = new LongestSubstringwithAtMostTwoDistinctCharacters();
        System.out.println(longest.lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
