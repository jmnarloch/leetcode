/**
 * Created by jakubnarloch on 04.04.15.
 */
public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {

        // input: two strings: s, t
        // output: flag indicating whether they are one edit distance apart
        // edge cases: s is null or t is null, s or t is empty

        if(s == null || t == null) {
            return false;
        }
        if(s.isEmpty() && t.isEmpty()) {
            return false;
        }

        final int distance = Math.abs(s.length() - t.length());
        if(distance > 1) {
            return false;
        }

        if(s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        int index = 0;
        while(index < s.length() && s.charAt(index) == t.charAt(index)) {
            index++;
        }
        if(index == s.length()) {
            return distance > 0;
        }
        if(distance == 0) {
            index++;
        }
        while(index < s.length() && s.charAt(index) == t.charAt(index + distance)) {
            index++;
        }
        return index == s.length();
    }

    public static void main(String[] args) {

        String s = "ab";
        String t = "cab";

        OneEditDistance distance = new OneEditDistance();
        System.out.println(distance.isOneEditDistance(s, t));
    }
}
