/**
 * Created by jakubnarloch on 05.03.15.
 */
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {

        // input: a string S with upper/lowercase and whitespaces
        // ouput: a length of last word
        // assumptions: the input string won't have any other characters
        // edge cases: s is null, s is empty, s contains only whitespaces, text does not end with whitespace,
        // text ends with witespace
        if(s == null || s.length() == 0) {
            return 0;
        }

        int start, end;
        start = end = -1;

        int ind = 0;
        boolean prevWhitespace = false;
        while(ind < s.length() && Character.isWhitespace(s.charAt(ind))) {
            prevWhitespace = true;
            ind++;
        }

        for(; ind < s.length(); ind++) {
            if(!Character.isWhitespace(s.charAt(ind)) && prevWhitespace) {
                start = ind;
                prevWhitespace = false;
            } else if(Character.isWhitespace(s.charAt(ind)) && !prevWhitespace) {
                end = ind;
                prevWhitespace = true;
            }
        }
        if(!prevWhitespace) {
            end = ind;
        }

        return end - start;
    }

    public static void main(String[] args) {

        LengthofLastWord lengthofLastWord = new LengthofLastWord();
        System.out.println(lengthofLastWord.lengthOfLastWord("Hello World"));
    }
}
