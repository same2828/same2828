import java.util.*;

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
https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/328601/all-dfs-traversals-preorder-postorder-inorder-in-java-in-5-lines
--------------------------------------------------------------------------------
*/

public class binary_tree_traversal {
  // Definition for a binary tree node
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }
  }

  //----------------------------------------------------------------------------
  //                                  Pre-Order
  //----------------------------------------------------------------------------
  class preorder_traversal {
    private void preorderTraversal(TreeNode root, List<Integer> result) {
      if (root == null) {
        return;
      }
      result.add(root.val); // Visit the root
      preorderTraversal(root.left, result); // Traverse left subtree
      preorderTraversal(root.right, result); // Traverse right subtree
    }

    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      preorderTraversal(root, result);
      return result;
    }
  }

  class preorder_traversal_iterative {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Deque<TreeNode> stack = new ArrayDeque<>();
      if (root != null) {
        stack.push(root);
      }
      TreeNode curr;
      while (!stack.empty()) {
        curr = stack.pop();
        result.add(curr.val); // Visit the root
        if (curr.right != null) {
          stack.push(curr.right); // Push right child to stack if it is not null
        }
        if (curr.left != null) {
          stack.push(curr.left); // Push left child to stack if it is not null
        }
      }
      return result;
    }
  }

  //----------------------------------------------------------------------------
  //                                  In-Order
  //----------------------------------------------------------------------------
  class inorder_traversal {
    private void inorderTraversal(TreeNode root, List<Integer> result) {
      if (root == null) {
        return;
      }
      inorderTraversal(root.left, result); // Traverse left subtree
      result.add(root.val); // Visit the root
      inorderTraversal(root.right, result); // Traverse right subtree
    }

    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      inorderTraversal(root, result);
      return result;
    }
  }

  //----------------------------------------------------------------------------
  //                                Post-Order
  //----------------------------------------------------------------------------
  class postorder_traversal {
    private void postorderTraversal(TreeNode root, List<Integer> result) {
      if (root == null) {
        return;
      }
      postorderTraversal(root.left, result); // Traverse left subtree
      postorderTraversal(root.right, result); // Traverse right subtree
      result.add(root.val); // Visit the root
    }

    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      postorderTraversal(root, result);
      return result;
    }
  }

  //----------------------------------------------------------------------------
  //                                Level-Order
  //----------------------------------------------------------------------------
  class level_order {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      Queue<TreeNode> q = new ArrayDeque<>();
      if (root != null) {
        q.offer(root);
      }
      TreeNode currNode;
      while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> subAns = new ArrayList<>();
        // Traverse nodes in the same level
        for (int i = 0; i < size; i++) {
          currNode = q.poll();
          // Visit the root
          subAns.add(currNode.val);
          if (currNode.left != null) {
            // Push left child to queue if it is not null
            q.offer(currNode.left);
          }
          if (currNode.right != null) {
            // Push right child to queue if it is not null
            q.offer(currNode.right);
          }
        }
        result.add(subAns);
      }
      return result;
    }
  }
}
