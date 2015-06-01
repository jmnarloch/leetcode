/**
 * Created by jakubnarloch on 28.03.15.
 */
public class ReverseWordsinaString {

    public String reverseWords(String s) {

        // input: the string
        // output: the string with reversed word order
        // edge cases: s is null, s is empty, s contains only whitespaces
        // assumptions: can use additional memory
        // approaches: time complexity: O(N), space usage: O(N)

        if(s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder reversed = new StringBuilder();

        // skips all trailing whitespaces
        boolean lastWhitespace = false;
        int ind = s.length() - 1;
        while(ind >= 0 && Character.isWhitespace(s.charAt(ind))) {
            lastWhitespace = true;
            ind--;
        }

        int end = ind;
        boolean hasPrev = false;
        for(; ind >= 0; ind--) {
            if(Character.isWhitespace(s.charAt(ind))) {
                if(!lastWhitespace) {
                    if(hasPrev) {
                        reversed.append(' ');
                    }
                    reverse(s, reversed, ind + 1, end);
                    hasPrev = true;
                }
                lastWhitespace = true;
            } else if(!Character.isWhitespace(s.charAt(ind)) && lastWhitespace) {
                end = ind;
                lastWhitespace = false;
            }
        }

        if(!lastWhitespace) {
            if(hasPrev) {
                reversed.append(' ');
            }

            reverse(s, reversed, 0, end);
        }
        return reversed.toString();
    }

    private void reverse(String s, StringBuilder reversed, int start, int end) {

        for(int ind = start; ind <= end; ind++) {
            reversed.append(s.charAt(ind));
        }
    }

    public static void main(String[] args) {

        ReverseWordsinaString reverse = new ReverseWordsinaString();
        System.out.println(reverse.reverseWords("the sky is blue"));
//        System.out.println(reverse.reverseWords(" "));
//        System.out.println(reverse.reverseWords("   a   b "));
//        System.out.println(reverse.reverseWords(" 1") + '|');
    }
}
