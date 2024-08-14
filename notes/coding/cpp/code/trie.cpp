#include <bits/stdc++.h>

//------------------------------------------------------------------------------
//                              std::unordered_map
//------------------------------------------------------------------------------
// Using `struct TrieNode`
class Trie {
private:
  struct TrieNode {
    bool isEnd;
    std::unordered_map<char, TrieNode *> children;

    TrieNode() {
      this->isEnd = false;
    }

    // TrieNode()
    // : isEnd(false) {}
  };

  TrieNode *root;

public:
  Trie() {
    this->root = new TrieNode();
  }

  // Inserts a word into the trie
  void insert(std::string word) {
    TrieNode *currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word[i];
      if ((currNode->children).count(ch) <= 0) {
        // insert a new node if the path does not exist
        (currNode->children)[ch] = new TrieNode();
      }
      currNode = (currNode->children)[ch];
    }
    currNode->isEnd = true;
  }

  // Returns true if the word is in the trie
  bool search(std::string word) {
    TrieNode *currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word[i];
      if ((currNode->children).count(ch) <= 0) {
        return false;
      }
      currNode = (currNode->children)[ch];
    }
    return currNode->isEnd;
  }

  // Returns true if there is any word in the trie that starts with the given prefix
  bool startsWith(std::string prefix) {
    TrieNode *currNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix[i];
      if ((currNode->children).count(ch) <= 0) {
        return false;
      }
      currNode = (currNode->children)[ch];
    }
    return true;
  }
};

// Using `class TrieNode`
class Trie {
private:
  class TrieNode {
    bool isEnd;
    std::unordered_map<char, TrieNode *> children;

    TrieNode() {
      this->isEnd = false;
    }

    // TrieNode()
    // : isEnd(false) {}
  };

  TrieNode *root;

public:
  Trie() {
    this->root = new TrieNode();
  }

  // Inserts a word into the trie
  void insert(std::string word) {
    TrieNode *currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word[i];
      if ((currNode->children).count(ch) <= 0) {
        // insert a new node if the path does not exist
        (currNode->children)[ch] = new TrieNode();
      }
      currNode = (currNode->children)[ch];
    }
    currNode->isEnd = true;
  }

  // Returns true if the word is in the trie
  bool search(std::string word) {
    TrieNode *currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word[i];
      if ((currNode->children).count(ch) <= 0) {
        return false;
      }
      currNode = (currNode->children)[ch];
    }
    return currNode->isEnd;
  }

  // Returns true if there is any word in the trie that starts with the given prefix
  bool startsWith(std::string prefix) {
    TrieNode *currNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix[i];
      if ((currNode->children).count(ch) <= 0) {
        return false;
      }
      currNode = (currNode->children)[ch];
    }
    return true;
  }
};

//------------------------------------------------------------------------------
//                                std::vector
//------------------------------------------------------------------------------
class Trie {
private:
  class TrieNode {
  public:
    bool isEnd;
    std::vector<TrieNode *> children;

    TrieNode() {
      this->children = std::vector<TrieNode *>(26, nullptr);
      this->isEnd = false;
    }

    // TrieNode()
    // : children(26, nullptr)
    // , isEnd(false) {}
  };

  TrieNode *root;

public:
  Trie() {
    this->root = new TrieNode();
  }

  // Inserts a word into the trie
  void insert(std::string word) {
    TrieNode *currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word[i];
      if (currNode->children[ch] == nullptr) {
        currNode->children[ch] = new TrieNode();
      }
      currNode = currNode->children[ch];
    }
    currNode->isEnd = true;
  }

  // Returns true if the word is in the trie
  bool search(std::string word) {
    TrieNode *currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word[i];
      if (currNode->children[ch] == nullptr) {
        return false;
      }
      currNode = currNode->children[ch];
    }
    return currNode->isEnd;
  }

  // Returns true if there is any word in the trie that starts with the given prefix
  bool startsWith(std::string prefix) {
    TrieNode *currNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix[i];
      if (currNode->children[ch] == nullptr) {
        return false;
      }
      currNode = currNode->children[ch];
    }
    return true;
  }
};

//------------------------------------------------------------------------------
//                                  int[]
//------------------------------------------------------------------------------
class Trie {
private:
  class TrieNode {
  public:
    bool isEnd;
    TrieNode *children[26];

    TrieNode() {
      std::fill_n(children, 26, nullptr);
      this->isEnd = false;
    }

    // TrieNode()
    // : isEnd(false) {
    //   std::fill_n(children, 26, nullptr);
    // }
  };

  TrieNode *root;

public:
  Trie() {
    this->root = new TrieNode();
  }

  // Inserts a word into the trie
  void insert(std::string word) {
    TrieNode *currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word[i];
      if (currNode->children[ch] == nullptr) {
        currNode->children[ch] = new TrieNode();
      }
      currNode = currNode->children[ch];
    }
    currNode->isEnd = true;
  }

  // Returns true if the word is in the trie
  bool search(std::string word) {
    TrieNode *currNode = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word[i];
      if (currNode->children[ch] == nullptr) {
        return false;
      }
      currNode = currNode->children[ch];
    }
    return currNode->isEnd;
  }

  // Returns true if there is any word in the trie that starts with the given prefix
  bool startsWith(std::string prefix) {
    TrieNode *currNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix[i];
      if (currNode->children[ch] == nullptr) {
        return false;
      }
      currNode = currNode->children[ch];
    }
    return true;
  }
};
