import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

//------------------------------------------------------------------------------
//                                  HashMap
//------------------------------------------------------------------------------
class Trie {
  class TrieNode {
    public boolean isWord;
    public Map<Character, TrieNode> childrenMap;

    TrieNode() {
      this.isWord = false;
      this.childrenMap = new HashMap<>();
    }
  }

  private TrieNode root;

  // Initialize your data structure here
  public Trie() {
    this.root = new TrieNode();
  }

  // Inserts a word into the trie
  public void insert(String word) {
    TrieNode currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (currNode.childrenMap.get(ch) == null) {
        // insert a new node if the path does not exist
        currNode.childrenMap.put(ch, new TrieNode());
      }
      currNode = currNode.childrenMap.get(ch);
    }
    currNode.isWord = true;
  }

  // Returns true if the word is in the trie
  public boolean findWord(String word) {
    TrieNode currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (currNode.childrenMap.get(ch) == null) {
        return false;
      }
      currNode = currNode.childrenMap.get(ch);
    }
    return currNode.isWord;
  }

  // Returns true if there is any word in the trie that starts with the given prefix
  public boolean findPrefix(String prefix) {
    // public boolean startsWith(String prefix) {
    TrieNode currNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      if (currNode.childrenMap.get(ch) == null) {
        return false;
      }
      currNode = currNode.childrenMap.get(ch);
    }
    return true;
  }
}

//------------------------------------------------------------------------------
//                                Array as HashMap
//------------------------------------------------------------------------------
class Trie {
  class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    TrieNode() {
      this.isEnd = false;
      this.children = new TrieNode[26];
    }
  }

  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  // Inserts a word into the trie
  public void insert(String word) {
    TrieNode currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (currNode.children[ch] == null) {
        // insert a new node if the path does not exist
        currNode.children[ch] = new TrieNode();
      }
      currNode = currNode.children[ch];
    }
    currNode.isEnd = true;
  }

  // Returns true if the word is in the trie
  public boolean findWord(String word) {
    TrieNode currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (currNode.children[ch] == null) {
        return false;
      }
      currNode = currNode.children[ch];
    }
    return currNode.isEnd;
  }

  // Returns true if there is any word in the trie that starts with the given prefix
  public boolean findPrefix(String prefix) {
    // public boolean startsWith(String prefix) {
    TrieNode currNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      if (currNode.children[ch] == null) {
        return false;
      }
      currNode = currNode.children[ch];
    }
    return true;
  }
}
