import java.util.*;

// Definition for a Node
class Node {
  public int val;
  public Node left;
  public Node right;
  // public Node parent;

  public Node() {}

  public Node(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

  public Node(int val, Node left, Node right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
