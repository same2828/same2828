import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

// Definition for a binary tree node
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
    this.val = 0;
    this.left = null;
    this.right = null;
  }

  TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
