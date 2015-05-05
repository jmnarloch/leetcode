import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jakubnarloch on 05.03.15.
 */
public class RomantoInteger {

    private static final Map<Character, Integer> romanInteger = Collections.unmodifiableMap(new LinkedHashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }});

    public int romanToInt(String s) {
        int result = 0;
        for(int ind = 0; ind < s.length(); ind++) {
            if(ind < s.length() - 1 && gratter(s, ind + 1, ind)) {
                result -= romanNumeralToInt(s.charAt(ind));
            } else {
                result += romanNumeralToInt(s.charAt(ind));
            }
        }
        return result;
    }

    private boolean gratter(String s, int i, int j) {

        return romanInteger.get(s.charAt(i)) > romanInteger.get(s.charAt(j));
    }

    private int romanNumeralToInt(char c) {

        return romanInteger.get(c);
    }

    public static void main(String[] args) {

        RomantoInteger romantoInteger = new RomantoInteger();
        System.out.println(romantoInteger.romanToInt("LIX"));
    }
}
