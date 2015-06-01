/**
 * Created by jakubnarloch on 06.04.15.
 */
public class ReverseWordsinaStringII {

    public void reverseWords(char[] s) {

        // input: the character array
        // output: the altered input array
        // edge cases: s is null or s is empty
        // assumptions: can not use extra memory
        // approaches: O(N) + O(1) - go over

        if(s == null || s.length == 0) {
            return;
        }

        final int length = s.length;
        reverse(s, 0, length - 1);

        boolean isWord = false;
        int index = 0;
        while(index < s.length && Character.isWhitespace(s[index])) {
            index++;
        }

        int start = -1, end = -1;
        while(index < s.length) {

            if(!Character.isWhitespace(s[index]) && !isWord) {
                isWord = true;
                start = index;
            } else if(Character.isWhitespace(s[index])) {
                if(isWord) {
                    end = index - 1;
                    reverse(s, start, end);
                }
                isWord = false;
            }
            index++;
        }

        if(isWord) {
            end = index - 1;
            reverse(s, start, end);
        }
    }

    private void reverse(char[] s, int lo, int hi) {

        while(lo < hi) {

            exch(s, lo++, hi--);
        }
    }

    private void exch(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {

        String text = "the sky is blue";
        char[] chars = text.toCharArray();
        ReverseWordsinaStringII reverse = new ReverseWordsinaStringII();
        reverse.reverseWords(chars);
        System.out.println(chars);
    }
}
