/**
 * Created by jakubnarloch on 17.03.15.
 */
public class StrStr {

    public int strStr(String haystack, String needle) {

        /**
         * input: two strings: the text T and the substring S being search
         * output: the index of the first occurrence of the searched substring or -1 if the needle
         * assumptions: can we use additional memory?
         *
         * edge cases: haystack is null or needle is null -> -1
         * edge cases: haystack is empty and needle is empty -> 0
         *
         * test cases: T contains S - returns the index
         * test cases: T does not not contain S - returns the -1
         */

        if(haystack == null || needle == null) {
            return -1;
        }
        if(haystack.isEmpty() && needle.isEmpty()) {
            return 0;
        }

        final int N = haystack.length();
        final int M = needle.length();

        for(int i = 0; i <= N - M; i++) {

            int j;
            for(j = 0; j < M; j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == M) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("mississippi", "a"));
    }
}
