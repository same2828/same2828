class Trie {
  class TrieNode {
    public boolean isWord;
    public Map<Character, TrieNode> childrenMap = new HashMap<>();
  }

  private TrieNode root;

  // Initialize your data structure here
  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie
  public void insert(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (curr.childrenMap.get(c) == null) {
        // insert a new node if the path does not exist
        curr.childrenMap.put(c, new TrieNode());
      }
      curr = curr.childrenMap.get(c);
    }
    curr.isWord = true;
  }

  // Returns true if the word is in the trie
  public boolean search(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (curr.childrenMap.get(c) == null) {
        return false;
      }
      curr = curr.childrenMap.get(c);
    }
    return curr.isWord;
  }

  // Returns true if there is any word in the trie that starts with the given prefix
  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (curr.childrenMap.get(c) == null) {
        return false;
      }
      curr = curr.childrenMap.get(c);
    }
    return true;
  }
}
