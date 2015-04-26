import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by jakubnarloch on 08.04.15.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        // input: the string - s
        // output: the length of the longest not repeating substring
        // edge cases: s is null, s is empty
        // assumptions: use extra memory
        // approaches: O(N^3) + extra space O(N)

        if (s == null || s.length() == 0) {
            return 0;
        }

        final Set<Character> characters = new LinkedHashSet<Character>();
        int i = 0, j = 0;
        int max = 0;

        while (i < s.length()) {

            j = i;
            while (j < s.length()) {
                if (characters.contains(s.charAt(j))) {
                    break;
                }
                characters.add(s.charAt(j));
                j++;
            }
            max = Math.max(max, characters.size());
            if (j == s.length()) {
                break;
            }

            Iterator<Character> iterator = characters.iterator();
            while (iterator.hasNext() && iterator.next() != s.charAt(j)) {
                iterator.remove();
            }
            iterator.remove();
            characters.add(s.charAt(j));

            i = j + 1;
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {

        int maxLength = 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        char[] a = s.toCharArray();
        int start = 0;
        for (int i = 0; i < a.length; i++) {
            if (map[a[i]] >= start) {
                maxLength = Math.max(maxLength, (i - start));
                start = map[a[i]] + 1;
            }
            map[a[i]] = i;
        }
        return Math.max(maxLength, (a.length - start));
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters longest = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longest.lengthOfLongestSubstring("bbbbb"));
    }
}
