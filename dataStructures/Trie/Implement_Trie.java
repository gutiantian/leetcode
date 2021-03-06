/* Implement Trie
Implement a trie with insert, search, and startsWith methods.

Example
insert("lintcode")
search("code")
>>> false
startsWith("lint")
>>> true
startsWith("linterror")
>>> false
insert("linterror")
search("lintcode)
>>> true
startsWith("linterror")
>>> true
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public boolean hasWord;
    public char c;
    public String word;
    public HashMap<Character, TrieNode> children;
    public TrieNode() {
        this.hasWord = false;
        children = new HashMap<Character, TrieNode>();
    }
    public TrieNode(char c) {
        this.hasWord = false;
        children = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
            TrieNode curNode = root;
            char[] wordArray = word.toCharArray();
            for(int i = 0; i < wordArray.length; i++) {
                char c = wordArray[i];
                if(!curNode.children.containsKey(c)) {
                    curNode.children.put(c, new TrieNode(c));
                }
                
                curNode = curNode.children.get(c);
            }
            
            curNode.word = word;
            curNode.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
            TrieNode curNode = root;
            char[] wordArray = word.toCharArray();
            for(int i = 0; i < wordArray.length; i++) {
                char c = wordArray[i];
                if(!curNode.children.containsKey(c)) {
                    return false;
                }
                curNode = curNode.children.get(c);
            }
            
            return curNode.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] wordArray = prefix.toCharArray();
        TrieNode curNode = root;
        HashMap<Character, TrieNode> children = root.children;
         for(int i = 0; i < wordArray.length; i++) {
            char curWord = wordArray[i];
            if(!children.containsKey(curWord)) {
                return false;
            }else {
                curNode = children.get(curWord);
                children = curNode.children;
            }
         }
         
         return true;
    }
}