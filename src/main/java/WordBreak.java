import java.util.HashSet;
import java.util.Set;

/**
 * Created by jakubnarloch on 29.03.15.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {

        // input: string - s, set of words - dict
        // output: whether the string can be brake down into district words contained by the set

        if(s == null || dict == null) {
            return false;
        }
        if(s.length() == 0 || dict.isEmpty()) {
            return false;
        }

        boolean[] match = new boolean[s.length() + 1];
        match[0] = true;

        for(int ind = 0; ind < s.length(); ind++) {
            if(!match[ind]) {
                continue;
            }

            for(String word : dict) {
                final int len = word.length();
                final int end = ind + len;
                if(end > s.length() || match[end]) {
                    continue;
                }

                if(word.equals(s.substring(ind, end))) {
                    match[end] = true;
                }
            }
        }

        return match[s.length()];
    }

    public boolean wordBreak2(String s, Set<String> dict) {

        // input: string - s, set of words - dict
        // output: whether the string can be brake down into district words contained by the set

        if(s == null || dict == null) {
            return false;
        }
        if(s.length() == 0 || dict.isEmpty()) {
            return false;
        }

        return match(s, dict);
    }

    private boolean match(String s, Set<String> dict) {
        if(s.length() == 0) {
            return true;
        }

        for(int ind = 1; ind <= s.length(); ind++) {
            if(dict.contains(s.substring(0, ind))) {
                if(match(s.substring(ind), dict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Set<String> dict = new HashSet<String>();
//        dict.add("leet");
//        dict.add("code");
        dict.add("aaaa");
        dict.add("aaa");
//        dict.add("a");

        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("aaaaaaa", dict));
    }
}
