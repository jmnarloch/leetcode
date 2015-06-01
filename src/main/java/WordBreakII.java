import java.util.*;

/**
 * Created by jakubnarloch on 08.04.15.
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> dict) {

        // input: the string - s and dictionary of words - dict
        // output: the list of matching words
        // edge cases: s is null, s is empty, dict is null or dict is empty
        if(s == null || dict == null || s.length() == 0 || dict.size() == 0) {
            return Collections.emptyList();
        }

        boolean[] match = new boolean[s.length() + 1];
        List<String>[] words = (List<String>[])new ArrayList[s.length() + 1];
        List<Integer>[] pathTo = (List<Integer>[])new List[s.length() + 1];
        match[0] = true;

        for(int ind = 0; ind < s.length(); ind++) {

            if(!match[ind]) {
                continue;
            }

            for(String word : dict) {
                final int len = word.length();
                final int end = ind + len;
                if(end > s.length()) {
                    continue;
                }

                if(word.equals(s.substring(ind, end))) {
                    match[end] = true;
                    if(pathTo[end] == null) {
                        pathTo[end] = new ArrayList<Integer>();
                    }
                    pathTo[end].add(ind);

                    if(words[end] == null) {
                        words[end] = new ArrayList<String>();
                    }
                    words[end].add(word);
                }
            }
        }

        if(!match[s.length()]) {
            return Collections.emptyList();
        }
        final List<String> result = new ArrayList<String>();
        final Deque<String> stack = new LinkedList<String>();
        permutation(s.length(), pathTo, words, stack, result);
        return result;
    }

    private void permutation(int index, List<Integer>[] pathTo, List<String>[] words, Deque<String> stack, List<String> result) {

        if(index <= 0) {

            result.add(toString(stack));
            return;
        } else if(pathTo[index] == null || words[index] == null) {
            return;
        }

        for(int ind = 0; ind < Math.min(pathTo[index].size(), words[index].size()); ind++) {
            stack.addFirst(words[index].get(ind));

            permutation(pathTo[index].get(ind), pathTo, words, stack, result);

            stack.removeFirst();
        }
    }

    private String toString(Deque<String> stack) {
        StringBuilder builder = new StringBuilder();
        int ind = 0;
        for(String word : stack) {
            if(ind != 0) {
                builder.append(' ');
            }
            builder.append(word);
            ind++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        final String s = "catsanddog";
        final Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        WordBreakII wordBreakII = new WordBreakII();
        System.out.println(wordBreakII.wordBreak(s, dict));
    }
}
