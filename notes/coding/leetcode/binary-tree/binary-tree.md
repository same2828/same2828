# Table of Contents

- [Table of Contents](#table-of-contents)
- [Binary Tree](#binary-tree)
- [Summary](#summary)

# Binary Tree

- A tree is a frequently-used data structure to simulate a hierarchical tree structure.

- Each node of the tree will have a root value and a list of references to other nodes which are called child nodes.

  - From graph view, a tree can also be defined as a directed acyclic graph which has N nodes and N-1 edges.

- A Binary Tree is one of the most typical tree structure.
  - As the name suggests, a binary tree is a tree data structure in which each node has at most two children, which are referred to as the left child and the right child

# Summary

```
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
```
