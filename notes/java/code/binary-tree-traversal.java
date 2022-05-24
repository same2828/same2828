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
      // Visit the root
      result.add(root.val);
      // Traverse left subtree
      preorderTraversal(root.left, result);
      // Traverse right subtree
      preorderTraversal(root.right, result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      preorderTraversal(root, result);
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
      // Traverse left subtree
      inorderTraversal(root.left, result);
      // Visit the root
      result.add(root.val);
      // Traverse right subtree
      inorderTraversal(root.right, result);
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
      // Traverse left subtree
      postorderTraversal(root.left, result);
      // Traverse right subtree
      postorderTraversal(root.right, result);
      // Visit the root
      result.add(root.val);
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
      Queue<TreeNode> q = new LinkedList<>();
      if (root != null) {
        q.offer(root);
      }
      TreeNode currNode;
      while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> subAns = new LinkedList<Integer>();
        // Traverse nodes in the same level
        for (int i = 0; i < size; ++i) {
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
