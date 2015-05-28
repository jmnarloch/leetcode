import java.util.*;

/**
 *
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {

        // input: two dimensional matrix of characters, array of words
        // output: list of matching words
        // edge cases: board is null or empty, word is null or empty
        // assumptions:

        if(board == null || words == null
                || board.length == 0 || board[0].length == 0 || words.length == 0) {
            return Collections.emptyList();
        }

        final int N = board.length;
        final int M = board[0].length;

        final Trie trie = new Trie(words);
        final List<String> result = new ArrayList<>();

        final boolean visited[][] = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visit(trie, trie.root, i, j, board, visited, result);
            }
        }

        return result;
    }

    private void visit(Trie trie, TrieNode node, int i, int j, char[][] board, boolean[][] visited, List<String> result) {

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || trie.size == 0) {
            return;
        }

        if(!visited[i][j]) {

            final char c = board[i][j];
            if(!node.next.containsKey(c)) {
                return;
            }

            visited[i][j] = true;
            final TrieNode next = node.next.get(c);
            if(next.word != null) {
                result.add(next.word);
                trie.delete(next.word);
            }

            visit(trie, next, i - 1, j, board, visited, result);
            visit(trie, next, i + 1, j, board, visited, result);
            visit(trie, next, i, j - 1, board, visited, result);
            visit(trie, next, i, j + 1, board, visited, result);

            visited[i][j] = false;
        }
    }

    private static class Trie {

        private final TrieNode root = new TrieNode();
        private int size;

        public Trie(final String[] words) {
            size = words.length;
            for(String word : words) {
                insert(root, word);
            }
        }

        private void insert(TrieNode root, String word) {

            TrieNode node = root;
            for(int ind = 0; ind < word.length(); ind++) {
                final char c = word.charAt(ind);
                if(!node.next.containsKey(c)) {
                    node.next.put(c, new TrieNode());
                }
                node = node.next.get(c);
            }
            node.word = word;
        }

        public void delete(String word) {

            size--;
            delete(root, word, 0);
        }

        private boolean delete(TrieNode node, String word, int len) {

            if (node == null) {
                return true;
            }
            if (len == word.length()) {
                node.word = null;
            } else {
                final char c = word.charAt(len);
                if (delete(node.next.get(c), word, len + 1)) {
                    node.next.remove(c);
                }
            }
            return node.word == null && node.next.size() == 0;
        }
    }

    private static class TrieNode {

        private final Map<Character, TrieNode> next = new HashMap<>();
        private String word;
    }

    public static void main(String[] args) {

        final WordSearchII wordSearch = new WordSearchII();
        String[] data = new String[] {"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};
        String[] words = new String[] {"baabab","abaaaa","abaaab","ababba","aabbab","aabbba","aabaab"};

        String[] data1 = new String[] {"ab"};
        String[] word1 = new String[] {"ba"};

        System.out.println(wordSearch.findWords(toBoard(data), words));
    }

    private static char[][] toBoard(String[] data) {
        final int N = data.length;

        final char[][] result = new char[N][];
        int ind = 0;
        for(String row : data) {
            result[ind] = row.toCharArray();
            ind++;
        }
        return result;
    }
}

