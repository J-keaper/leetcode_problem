package cn.keaper.p208;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    private TrieNode root;

    static class TrieNode {
        TrieNode[] chileNodes;
        boolean isEnd;

        public TrieNode() {
            this.chileNodes = new TrieNode[26];
        }
    }


    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.chileNodes[index] == null){
                node.chileNodes[index] = new TrieNode();
            }
            node = node.chileNodes[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.chileNodes[index] == null){
                return false;
            }
            node = node.chileNodes[index];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(node.chileNodes[index] == null){
                return false;
            }
            node = node.chileNodes[index];
        }
        return true;
    }

}
