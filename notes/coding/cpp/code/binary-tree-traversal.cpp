#include <bits/stdc++.h>

/*
--------------------------------------------------------------------------------
                            DFS PRE-order (NLR)
--------------------------------------------------------------------------------
#           1           #           1
#          / \          #        /     \
#         2   5         #       2       5
#        / \            #      / \     / \
#       3   4           #     3   4   6   7

--------------------------------------------------------------------------------
                            DFS IN-order (LNR)
--------------------------------------------------------------------------------
#           4           #           4
#          / \          #        /     \
#         2   5         #       2       6
#        / \            #      / \     / \
#       1   3           #     1   3   5   7

--------------------------------------------------------------------------------
                            DFS POST-order (LRN)
--------------------------------------------------------------------------------
#           5           #           7
#          / \          #        /     \
#         3   4         #       3       4
#        / \            #      / \     / \
#       1   2           #     1   2   5   6

--------------------------------------------------------------------------------
                                BFS LEVEL-order
--------------------------------------------------------------------------------
#           1           #           1
#          / \          #        /     \
#         2   3         #       2       3
#        / \            #      / \     / \
#       4   5           #     4   5   6   7

--------------------------------------------------------------------------------
*/

// Definition for a binary tree node
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;

  TreeNode()
  : val(0)
  , left(nullptr)
  , right(nullptr) {}

  TreeNode(int x)
  : val(x)
  , left(nullptr)
  , right(nullptr) {}

  TreeNode(int x, TreeNode *left, TreeNode *right)
  : val(x)
  , left(left)
  , right(right) {}
};

//----------------------------------------------------------------------------
//                                  Pre-Order
//----------------------------------------------------------------------------
class preorder_traversal {
private:
  void preorderTraversal(TreeNode *root, std::vector<int> &result) {
    if (!root) {
      return;
    }
    result.push_back(root->val);            // Visit the root
    preorderTraversal(root->left, result);  // Traverse left subtree
    preorderTraversal(root->right, result); // Traverse right subtree
  }

public:
  std::vector<int> preorderTraversal(TreeNode *root) {
    std::vector<int> result;
    preorderTraversal(root, result);
    return result;
  }
};

class preorder_traversal_iterative {
public:
  std::vector<int> preorderTraversal(TreeNode *root) {
    std::vector<int> result;
    stack<TreeNode *> s;
    if (root) {
      s.push(root);
    }
    TreeNode *curr;
    while (!s.empty()) {
      curr = s.top();
      s.pop();
      result.push_back(curr->val); // Visit the root
      if (curr->right) {
        s.push(curr->right); // Push right child to stack if it is not null
      }
      if (curr->left) {
        s.push(curr->left); // Push left child to stack if it is not null
      }
    }
    return result;
  }
};

//----------------------------------------------------------------------------
//                                  In-Order
//----------------------------------------------------------------------------

class inorder_traversal {
private:
  void inorderTraversal(TreeNode *root, std::vector<int> &result) {
    if (!root) {
      return;
    }
    inorderTraversal(root->left, result);  // Traverse left subtree
    result.push_back(root->val);           // Visit the root
    inorderTraversal(root->right, result); // Traverse right subtree
  }

public:
  std::vector<int> inorderTraversal(TreeNode *root) {
    std::vector<int> result;
    inorderTraversal(root, result);
    return result;
  }
};

//----------------------------------------------------------------------------
//                                Post-Order
//----------------------------------------------------------------------------

class postorder_traversal {
private:
  void postorderTraversal(TreeNode *root, std::vector<int> &result) {
    if (!root) {
      return;
    }
    postorderTraversal(root->left, result);  // Traverse left subtree
    postorderTraversal(root->right, result); // Traverse right subtree
    result.push_back(root->val);             // Visit the root
  }

public:
  std::vector<int> postorderTraversal(TreeNode *root) {
    std::vector<int> result;
    postorderTraversal(root, result);
    return result;
  }
};

//----------------------------------------------------------------------------
//                                Level-Order
//----------------------------------------------------------------------------
class level_order {
public:
  std::vector<std::vector<int>> levelOrder(TreeNode *root) {
    std::vector<std::vector<int>> result;
    queue<TreeNode *> q;
    if (root) {
      q.push(root);
    }
    TreeNode *curr;
    while (!q.empty()) {
      int size = q.size();
      result.push_back(std::vector<int>());
      for (int i = 0; i < size; ++i) { // traverse nodes in the same level
        curr = q.front();
        q.pop();
        result.back().push_back(curr->val); // visit the root
        if (curr->left) {
          q.push(curr->left); // push left child to queue if it is not null
        }
        if (curr->right) {
          q.push(curr->right); // push right child to queue if it is not null
        }
      }
    }
    return result;
  }
};
