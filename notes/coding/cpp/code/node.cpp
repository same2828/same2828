#include <bits/stdc++.h>

// Definition for a Node
class Node {
public:
  int val;
  Node *left;
  Node *right;
  // Node *parent;

  Node() {}

  Node(int val) {
    this->val = val;
    this->left = nullptr;
    this->right = nullptr;
  }

  Node(int val, Node *left, Node *right) {
    this->val = val;
    this->left = left;
    this->right = right;
  }
};
