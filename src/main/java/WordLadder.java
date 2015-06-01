import java.util.*;

/**
 * Created by jakubnarloch on 01.04.15.
 */
public class WordLadder {

    public int ladderLength(String start, String end, Set<String> dict) {

        if (start == null || end == null || dict == null) {
            return 0;
        }
        if (start.length() == 0 || end.length() == 0 || dict.size() == 0) {
            return 0;
        }

        dict.add(end);

        Deque<String> words = new LinkedList<String>();
        Deque<Integer> distances = new LinkedList<Integer>();

        words.add(start);
        distances.add(1);

        int result = Integer.MAX_VALUE;

        while (!words.isEmpty()) {
            String word = words.pop();
            int dist = distances.pop();

            if(end.equals(word)) {
                result = Math.min(result, dist);
            }

            for(int ind = 0; ind < word.length(); ind++) {
                char[] arr = word.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    arr[ind] = c;
                    String tmp = new String(arr);
                    if(dict.contains(tmp)) {
                        words.add(tmp);
                        distances.add(dist + 1);
                        dict.remove(tmp);
                    }
                }
            }
        }

        if(result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    public int ladderLength2(String start, String end, Set<String> dict) {

        // input: the starting word, the ending word, the dictionary of words
        // output: the length of minimum path
        // edge cases: start or end or dict is null, start or end is empty string

        if (start == null || end == null || dict == null) {
            return 0;
        }
        if (start.length() == 0 || end.length() == 0 || dict.size() == 0) {
            return 0;
        }

        Set<String> extendedDict = new HashSet<String>(dict);
        extendedDict.add(start);
        extendedDict.add(end);
        Map<String, Set<String>> oneDistanceWords = new HashMap<String, Set<String>>();

        for (String word : extendedDict) {
            for (String other : extendedDict) {
                if (distance(word, other) == 1) {
                    if (!oneDistanceWords.containsKey(word)) {
                        oneDistanceWords.put(word, new HashSet<String>());
                    }
                    if (!oneDistanceWords.containsKey(other)) {
                        oneDistanceWords.put(other, new HashSet<String>());
                    }

                    oneDistanceWords.get(word).add(other);
                    oneDistanceWords.get(other).add(word);
                }
            }
        }

        Map<String, Integer> distance = new HashMap<String, Integer>();
        Deque<String> words = new LinkedList<String>();
        words.addLast(start);
        distance.put(start, 0);

        while (!words.isEmpty()) {

            final String s = words.removeFirst();
            final int dist = distance.get(s);
            if (end.equals(s)) {
                return dist;
            }

            if (oneDistanceWords.get(s) != null) {
                for (String e : oneDistanceWords.get(s)) {
                    words.addLast(e);
                    distance.put(e, dist + 1);
                }
            }
        }
        return 0;
    }

    private int distance(String word, String other) {
        int dist = 0;
        for (int ind = 0; ind < Math.min(word.length(), other.length()); ind++) {

            if (word.charAt(ind) != other.charAt(ind)) {
                dist++;
            }
        }
        return dist;
    }

    public static void main(String[] args) {

        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        WordLadder ladder = new WordLadder();
        System.out.println(ladder.ladderLength("hit", "cog", dict));
    }
}
