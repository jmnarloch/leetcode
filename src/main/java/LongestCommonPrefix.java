import java.util.Arrays;

/**
 * Created by jakubnarloch on 05.03.15.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        // input: array of strings s
        // output: the longest common prefix of all the strings
        // assumptions: modify the input data, rearange
        // edge cases: null array, empty array, array with single element, no common prefix an empty string

        if(strs == null || strs.length == 0) {
            return "";
        } else if(strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs);
        String prefix = strs[0];
        for(int ind = 1; ind < strs.length; ind++) {

            int len;
            for(len = 0; len < Math.min(strs[ind].length(), prefix.length()); len++) {
                if(strs[ind].charAt(len) != prefix.charAt(len)) {
                    break;
                }
            }
            prefix = strs[ind].substring(0, len);
            if(prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {
                "a",
                "a",
                "ac"
        }));
    }
}
