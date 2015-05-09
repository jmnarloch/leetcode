/**
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {

        root = insert(root, word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

        return search(root, word, 0);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {

        return startsWith(root, prefix, 0);
    }

    private TrieNode insert(TrieNode node, String word, int len) {

        if (node == null) {
            node = new TrieNode();
        }
        if (len == word.length()) {
            node.end = true;
            return node;
        }
        final int c = getChar(word, len);
        node.next[c] = insert(node.next[c], word, len + 1);
        return node;
    }

    private boolean search(TrieNode node, String word, int len) {

        if (node == null) {
            return false;
        }
        if (len == word.length()) {
            return node.end;
        }
        final int c = getChar(word, len);
        return search(node.next[c], word, len + 1);
    }

    private boolean startsWith(TrieNode node, String prefix, int len) {

        if (node == null) {
            return false;
        }
        if (len == prefix.length()) {
            return true;
        }
        final int c = getChar(prefix, len);
        return startsWith(node.next[c], prefix, len + 1);
    }

    private int getChar(String word, int len) {
        final char c = word.charAt(len);
        return c - 'a';
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("ab");

        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
}

class TrieNode {

    private static final int R = 26;

    public TrieNode[] next;
    public boolean end;

    // Initialize your data structure here.
    public TrieNode() {
        next = new TrieNode[R];
    }
}
