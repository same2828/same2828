struct TrieNode {
  bool flag;
  std::map<char, TrieNode *> next;
};

class Trie {
private:
  TrieNode *root;

public:
  // Initialize your data structure here
  Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie
  void insert(std::string word) {
    TrieNode *curr = root;
    for (int i = 0; i < word.length(); ++i) {
      if ((curr->next).count(word[i]) <= 0) {
        // insert a new node if the path does not exist
        (curr->next).insert(std::make_pair(word[i], new TrieNode()));
      }
      curr = (curr->next)[word[i]];
    }
    curr->flag = true;
  }

  // Returns true if the word is in the trie
  bool search(std::string word) {
    TrieNode *curr = root;
    for (int i = 0; i < word.length(); ++i) {
      if ((curr->next).count(word[i]) <= 0) {
        return false;
      }
      curr = (curr->next)[word[i]];
    }
    return curr->flag;
  }

  // Returns true if there is any word in the trie that starts with the given prefix
  bool startsWith(std::string prefix) {
    TrieNode *curr = root;
    for (int i = 0; i < prefix.length(); ++i) {
      if ((curr->next).count(prefix[i]) <= 0) {
        return false;
      }
      curr = (curr->next)[prefix[i]];
    }
    return true;
  }
};

// Your Trie object will be instantiated and called as such:
// Trie obj = new Trie();
// obj.insert(word);
// bool param_2 = obj.search(word);
// bool param_3 = obj.startsWith(prefix);
