import java.util.*;

/**
 * Created by jakubnarloch on 12.04.15.
 */
public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String S, String[] L) {

        // input: string S representing a sentence of length |M|, the array/dictionary of words of size |N|
        // output: the indexes of substrings matching exactly each word from the dictionary
        // edge cases: S is null, S is empty, L is null, L is empty, there are no matching substrings
        // test cases:
        // assumptions: characters - digits, will word be unique
        // approaches: #1 variation of the dictionary word: O(N!) + O(N!)
        // approaches: #2 generate substrings O(M ^ 2 * N) + O(1)
        // approaches: #3 try to match each word O(M N) + O(M)

        if(S == null || L == null || S.length() == 0 || L.length == 0) {
            return Collections.emptyList();
        }

        final int N = L.length;
        final int M = L[0].length();

        final List<Integer> indexes = new ArrayList<>();
        final Map<String, Integer> words = new HashMap<>(N);

        for(int ind = 0; ind < L.length; ind++) {
            final String w = L[ind];
            if(!words.containsKey(w)) {
                words.put(w, 1);
            } else {
                words.put(w, words.get(w) + 1);
            }
        }

        for(int i = 0; i < S.length() && i <= S.length() - M * N; i++) {
            Map<String, Integer> tmp = new HashMap<>(words);

            for(int j = 0; j < N; j++) {
                final String word = S.substring(i + j * M, i + (j + 1) * M);
                if(!tmp.containsKey(word)) {
                    break;
                }
                int count = tmp.get(word);
                if(count - 1 == 0) {
                    tmp.remove(word);
                } else {
                    tmp.put(word, tmp.get(word) - 1);
                }
            }

            if(tmp.size() == 0) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    public static void main(String[] args) {

        SubstringwithConcatenationofAllWords allWords = new SubstringwithConcatenationofAllWords();

        System.out.println(allWords.findSubstring("a", new String[] {"a"}));
//        System.out.println(allWords.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
    }
}
