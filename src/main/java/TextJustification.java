import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 13.04.15.
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int L) {

        // input: the array of String - words, the length of line
        // output: the list of justificated lines
        // edge cases: the words is null, the words is empty, words has single element, words contains null elements,
        //             L matches the word lengths
        // test cases: L is negative, L is zero, L is lower the minimum word length
        // assumptions: use extra memory

        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<>();

        int word = 0;
        while (word < words.length) {

            int j = word + 1;
            int len = words[word].length();
            int wordsLen = words[word].length();
            while (j < words.length && wordsLen + words[j].length() + 1 <= L) {
                len += words[j].length();
                wordsLen += 1 + words[j].length();
                j++;
            }

            final int diff = L - len;
            result.add(join(words, word, j - 1, diff, j == words.length));

            word = j;
        }
        return result;
    }

    private String join(String[] words, int lo, int hi, int diff, boolean last) {

        final StringBuilder builder = new StringBuilder();

        if (hi - lo == 0 || last) {
            for(int k = lo; k <= hi; k++) {
                if(k != lo) {
                    builder.append(' ');
                }
                builder.append(words[k]);
            }
            times(builder, ' ', diff - (hi - lo));
        } else {
            final int gaps = hi - lo;
            final int space = diff / gaps;
            int rem = (diff % gaps);

            for (int k = lo; k <= hi; k++) {
                if (k != lo) {
                    int w = space;
                    if(rem > 0) {
                        w++;
                        rem--;
                    }
                    times(builder, ' ', w);
                }
                builder.append(words[k]);
            }
        }

        return builder.toString();
    }

    private void times(StringBuilder builder, char c, int times) {
        for (int ind = 0; ind < times; ind++) {
            builder.append(c);
        }
    }

    public static void main(String[] args) {

        TextJustification textJustification = new TextJustification();
//        List<String> result = textJustification.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
//        System.out.println(result);
//        List<String> result2 = textJustification.fullJustify(new String[]{"What","must","be","shall","be."}, 12);
//        System.out.println(result2);
//        List<String> result3 = textJustification.fullJustify(new String[]{"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."}, 30);
//        System.out.println(result3);
        List<String> result4 = textJustification.fullJustify(new String[]{"a","b","c","d","e"}, 3);
        System.out.println(result4);
    }
}
