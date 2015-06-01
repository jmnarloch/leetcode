import java.util.*;

/**
 * Created by jakubnarloch on 21.03.15.
 */
public class Anagrams {

    public List<String> anagrams(String[] strs) {

        if(strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        final Map<String, Integer> anagrams = new HashMap<>();
        final Map<String, String> anagramsWord = new HashMap<>();
        final List<String> result = new LinkedList<>();

        for(String word : strs) {
            final String anagram = toAnagram(word);

            if(!anagrams.containsKey(anagram)) {
                anagrams.put(anagram, 1);
                anagramsWord.put(anagram, word);
            } else {
                if(anagrams.get(anagram) == 1) {
                    anagrams.put(anagram, -1);
                    result.add(anagramsWord.get(anagram));
                }

                result.add(word);
            }
        }

        return result;
    }

    public List<String> anagrams2(String[] strs) {

        if(strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        final Map<String, List<String>> anagrams = new HashMap<>();
        final List<String> result = new ArrayList<>();

        for(String word : strs) {
            final String anagram = toAnagram(word);

            if(!anagrams.containsKey(anagram)) {
                final List<String> words = new ArrayList<>();
                words.add(word);
                anagrams.put(anagram, words);
            } else {
                if(anagrams.get(anagram).size() == 1) {
                    result.add(anagrams.get(anagram).get(0));
                }

                anagrams.get(anagram).add(word);
                result.add(word);
            }
        }

        return result;
    }

    public List<String> anagrams3(String[] strs) {

        if(strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        final Map<String, List<String>> anagrams = new HashMap<>();

        for(String word : strs) {
            final String anagram = toAnagram(word);

            if(!anagrams.containsKey(anagram)) {
                final List<String> words = new ArrayList<>();
                words.add(word);
                anagrams.put(anagram, words);
            } else {
                anagrams.get(anagram).add(word);
            }
        }

        final List<String> result = new ArrayList<>();
        for(List<String> words : anagrams.values()) {
            if(words.size() > 1) {
                result.addAll(words);
            }
        }
        return result;
    }

    private String toAnagram(String word) {

        final char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<String> anagrams4(String[] strs) {

        // input: array of strings
        // output: the list of string being the anagrams
        // edge cases: strs is null, strs is empty, strs contains one element,
        //             strs conatins null elements, strs contains empty string
        // test cases:
        // approaches:
        // No.          Name        Time complexity         Space usage
        // 1            Sort        O(NM lg N lg M)         O(NM)

        if(strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        final List<String> result = new ArrayList<String>();

        Anagram[] anagrams = new Anagram[strs.length];
        for(int ind = 0; ind < strs.length; ind++) {
            anagrams[ind] = new Anagram(strs[ind]);
        }

        Arrays.sort(anagrams);
        int compInd = 0;
        int ind = 1;
        while(ind < strs.length) {
            if(anagrams[ind].compareTo(anagrams[ind - 1]) == 0) {
                int j = ind + 1;
                result.add(anagrams[ind - 1].text);
                result.add(anagrams[ind].text);
                while(j < strs.length && anagrams[j].compareTo(anagrams[j - 1]) == 0) {
                    result.add(anagrams[j].text);
                    j++;
                }
                ind = j - 1;
            }
            ind++;
        }

        return result;
    }

    private static class Anagram implements Comparable<Anagram> {

        private final String text;
        private final String anagram;

        public Anagram(String text) {
            this.text = text;
            this.anagram = alphabetize(text);
        }

        private static String alphabetize(String text) {
            char[] chars = text.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        @Override
        public int compareTo(Anagram o) {
            return anagram.compareTo(o.anagram);
        }
    }
}
