- [Table of Contents](#table-of-contents)
- [Resources](#resources)
- [Edge Cases](#edge-cases)
  - [Array/List](#arraylist)
  - [Integers](#integers)
  - [Graph](#graph)
  - [Heap Priority Queue](#heap-priority-queue)
  - [String](#string)
- [Backtracking](#backtracking)
- [Backtracking](#backtracking-1)
- [Binary Representation](#binary-representation)
  - [Negative Numbers (Two's Complement)](#negative-numbers-twos-complement)
  - [Converting Binary String to Integer](#converting-binary-string-to-integer)
- [Bitwise Operators](#bitwise-operators)
  - [Common Pitfalls/Mistakes (Sources of Errors)](#common-pitfallsmistakes-sources-of-errors)
  - [Check If Number Is A Power Of 2](#check-if-number-is-a-power-of-2)
  - [Bit Manipulation](#bit-manipulation)
    - [Multiply by 2](#multiply-by-2)
    - [Divide by 2](#divide-by-2)
  - [Bitmask](#bitmask)
    - [Bitmask With All N Bits Set To 1](#bitmask-with-all-n-bits-set-to-1)
    - [Check if the i'th bit is set (to 1) in the binary form of the given number](#check-if-the-ith-bit-is-set-to-1-in-the-binary-form-of-the-given-number)
    - [Count the Number of Bits Set to 1](#count-the-number-of-bits-set-to-1)
    - [Set i'th bit](#set-ith-bit)
    - [Unset i'th bit](#unset-ith-bit)
    - [Flip i'th bit](#flip-ith-bit)
    - [XOR (`^`)](#xor-)
- [Binary Search Tree (BST)](#binary-search-tree-bst)
  - [Info](#info)
  - [Code](#code)
  - [Lowest Common Ancestor (LCA) - Binary Lifting/Binary Jumping](#lowest-common-ancestor-lca---binary-liftingbinary-jumping)
    - [Algorithm](#algorithm)
    - [Algorithm 2](#algorithm-2)
      - [Pre-Processing](#pre-processing)
      - [Query Resolution](#query-resolution)
    - [Implementation](#implementation)
- [BFS](#bfs)
  - [Find Nodes in Cycle](#find-nodes-in-cycle)
  - [Giving Unique ID to Each Subtree (Finding Duplicate Subtrees)](#giving-unique-id-to-each-subtree-finding-duplicate-subtrees)
- [Common Errors/Pitfalls](#common-errorspitfalls)
- [Cumulative Sum (Line Sweep)](#cumulative-sum-line-sweep)
- [Data Types](#data-types)
  - [Floating Point Numbers](#floating-point-numbers)
    - [Double Precision/Floating Point Precision Loss](#double-precisionfloating-point-precision-loss)
- [Dynamic Programming](#dynamic-programming)
  - [Array Index Methods](#array-index-methods)
  - [1-Indexed Array](#1-indexed-array)
  - [Boolean to Integer Hack](#boolean-to-integer-hack)
  - [Digit DP](#digit-dp)
  - [Preventing Integer Overflow/Underflow](#preventing-integer-overflowunderflow)
  - [Common Causes of Errors](#common-causes-of-errors)
- [DFS](#dfs)
  - [DFS Cycle Find](#dfs-cycle-find)
  - [DFS Cycle Removal](#dfs-cycle-removal)
- [Formulas](#formulas)
  - [Convert 2D Matrix Cell Coordinate (i, j) to Index Number (Flatten 2D Matrix)](#convert-2d-matrix-cell-coordinate-i-j-to-index-number-flatten-2d-matrix)
  - [Binary Search on 2D Matrix Using Single Index 'mid'](#binary-search-on-2d-matrix-using-single-index-mid)
  - [Filter out numbers that end with digit `k`](#filter-out-numbers-that-end-with-digit-k)
  - [Flatten 2D Grid to Single Array + Shifting](#flatten-2d-grid-to-single-array--shifting)
- [Graph](#graph-1)
  - [Data Structure](#data-structure)
  - [Complete Graph](#complete-graph)
  - [Connected Graph](#connected-graph)
  - [Eulerian Path / Eulerian Circuit](#eulerian-path--eulerian-circuit)
  - [Hamiltonian Path](#hamiltonian-path)
  - [Minimum Spanning Tree](#minimum-spanning-tree)
    - [Kruskal's Algorithm](#kruskals-algorithm)
    - [Prim's Algorithm](#prims-algorithm)
  - [Single-Source Shortest Path](#single-source-shortest-path)
    - [Dijkstra's Algorithm](#dijkstras-algorithm)
    - [Bellman-Ford's Algorithm](#bellman-fords-algorithm)
  - [All-Pairs Shortest Path](#all-pairs-shortest-path)
    - [Floyd-Warshall's Algorithm](#floyd-warshalls-algorithm)
  - [Topological Sort](#topological-sort)
- [Hacks/Tricks](#hackstricks)
  - [Array Wrap Around](#array-wrap-around)
  - [Flatten 2D Matrix into Stateful String and Check Neighbours of currCell](#flatten-2d-matrix-into-stateful-string-and-check-neighbours-of-currcell)
  - [Index Shifting When Deleting an Element](#index-shifting-when-deleting-an-element)
  - [Uses of 3D array `int[][][]`](#uses-of-3d-array-int)
- [Heap Priority Queue](#heap-priority-queue-1)
  - [K'th Largest](#kth-largest)
  - [K'th Smallest](#kth-smallest)
  - [Index Heap/Index Priority Queue](#index-heapindex-priority-queue)
- [Infinity](#infinity)
- [Intervals](#intervals)
  - [Closed Intervals](#closed-intervals)
  - [Open Intervals](#open-intervals)
  - [Half-Closed/Half-Open Intervals](#half-closedhalf-open-intervals)
- [LeetCode Patterns](#leetcode-patterns)
- [`long` or `long long` Type](#long-or-long-long-type)
- [Math](#math)
  - [Branching](#branching)
  - [Brackets](#brackets)
  - [Combinatorics](#combinatorics)
    - [Permutation](#permutation)
      - [With Repetition](#with-repetition)
      - [Without Repetition](#without-repetition)
      - [Distinct Permutation](#distinct-permutation)
    - [Combination](#combination)
      - [Without Repetition](#without-repetition-1)
      - [With Repetition](#with-repetition-1)
      - [nCr == (n-1)C(r-1) + (n-1)Cr](#ncr--n-1cr-1--n-1cr)
      - [Finding Total Number of Combinations](#finding-total-number-of-combinations)
      - [Code](#code-1)
        - [Iterative Pascal's Triangle](#iterative-pascals-triangle)
        - [Recursive nCr()/nCk()](#recursive-ncrnck)
  - [Digits (Create Number Recursively)](#digits-create-number-recursively)
  - [Exponent](#exponent)
    - [Rules](#rules)
  - [Factor](#factor)
    - [Euclidean Algorithm](#euclidean-algorithm)
    - [Prime Factorisation Method](#prime-factorisation-method)
    - [Check if number is a prime number](#check-if-number-is-a-prime-number)
  - [Logarithm](#logarithm)
    - [Rules](#rules-1)
    - [Closest Power of 2](#closest-power-of-2)
  - [`Math.ceil(a/b)` / `std::ceil(a/b)`](#mathceilab--stdceilab)
  - [Modulus (%)](#modulus-)
  - [Get Digits of Number (Individually)](#get-digits-of-number-individually)
  - [Parity (Odd/Even)](#parity-oddeven)
    - [Check if number is ODD](#check-if-number-is-odd)
  - [Probability](#probability)
  - [Ranges](#ranges)
- [Optimisations](#optimisations)
  - [Caching](#caching)
- [UpperBound - LowerBound (`[0:high] - [0:low]`) to get `[low:high]`](#upperbound---lowerbound-0high---0low-to-get-lowhigh)
  - [Sequences](#sequences)
    - [Arithmetic Sequence](#arithmetic-sequence)
      - [Sum of AP (Arithmetic Progression)](#sum-of-ap-arithmetic-progression)
        - [Number of Subarrays](#number-of-subarrays)
    - [Geometric Sequence](#geometric-sequence)
      - [Sum of GP (Geometric Progression)](#sum-of-gp-geometric-progression)
    - [Greatest Common Divisor (GCD)](#greatest-common-divisor-gcd)
- [Number of Unique Combinations/Subsets Possible](#number-of-unique-combinationssubsets-possible)
- [Prefix Sum](#prefix-sum)
  - [Left Prefix Sum + Right Prefix Sum + Bottom Up DP](#left-prefix-sum--right-prefix-sum--bottom-up-dp)
    - [Version 1 - `dp[n+1]`](#version-1---dpn1)
    - [Version 2 - `dp[n+2]`](#version-2---dpn2)
- [Random Trivial Knowledge](#random-trivial-knowledge)
  - [Comparisons](#comparisons)
- [Sliding Window](#sliding-window)
- [String](#string-1)
  - [Characters](#characters)
  - [Java](#java)
  - [Substrings + Palindrome](#substrings--palindrome)
- [Sliding Window](#sliding-window-1)
  - [Array Indexing for Single Pass Forwards + Backwards](#array-indexing-for-single-pass-forwards--backwards)
  - [Longest Palindromic Substring / Longest Common Subsequence](#longest-palindromic-substring--longest-common-subsequence)
- [Time Complexity](#time-complexity)
  - [Dynamic Programming Time Complexity](#dynamic-programming-time-complexity)
- [TreeMap](#treemap)
- [TreeSet](#treeset)
- [Union Find](#union-find)
  - [Path Compression](#path-compression)
  - [Union by Rank](#union-by-rank)
  - [Formula to convert matrix cell coordinate (i, j) to index number](#formula-to-convert-matrix-cell-coordinate-i-j-to-index-number)
  - [Handling Strings](#handling-strings)
  - [Connected Components](#connected-components)

# Table of Contents

# Resources

- [USACO](https://usaco.guide/dashboard)
- [CP-Algorithms](https://cp-algorithms.com/)
- [TopCoder](https://www.topcoder.com/thrive/)

# Edge Cases

## Array/List

- Empty array/list
- An array/list of empty strings `''`

## Integers

- If we have negatives, then CANNOT use `Integer.MIN_VALUE`
  - Instead just initialise it to first value of values array given i.e. `int result = vals[0];`

## Graph

- Graph with NO edges (i.e. disconnected graph)
  - Then CANNOT use `int n = edges.length;`
- A node/vertex with NO neighbours
  - When looping over neighbours need to add default value `for (int nei : graph.getOrDefault(u, new ArrayList<>())`
  - Need to initialise `result[i]` to be `vals[i]` BEFORE calling `dfs()` if `dfs()` does NOT handle case where node has no neighbours
    ```java
    int[] result = new int[n];
    // Initialise BEFOREHAND
    for (int i = 0; i < n; i++) {
      result[i] = values[i];
    }
    for (int i = 0; i < n; i++) {
      result[i] = dfs(i);
    }
    ```

## Heap Priority Queue

- If `vals[]` contains NEGATIVE values, and we are trying to find MAX sum, then check if `vals[i] > 0` before inserting into pq
  ```java
  for (int nei : graph.getOrDefault(i, new ArrayList<>())) {
    if (vals[nei] > 0) {
      pq.offer(vals[nei]);
    }
  }
  ```

## String

- Empty String `''`
- Null `null`
- Note compare strings with **`.equals()`** and NOT `==`

# Backtracking

- In `dfs(i)` call
  ```java
  int dfs(i) {
    for (int num : nums) {
      memo[i] += nums[i];
      dfs(i + 1);
      memo[i] -= nums[i];
    }
  }
  ```

# Backtracking

- Backtracking is a method to generate all permutations/combinations/subsets in O(1) time
  - MODIFY state (i.e. swap elements) BEFORE the `dfs()` call in O(1) time and UN-MODIFY state (i.e. unswap elements) AFTER the `dfs()` call in O(1) time
- [Read more](https://dimosr.github.io/backtracking-vs-depth-first-search)
- Examples
  - 1947.maximum-compatibility-score-sum

# Binary Representation

- The base/radix is 2
- Digits are 0 and 1

|       |       |       |       |       |       |
| ----- | ----- | ----- | ----- | ----- | ----- |
| `32`  | `16`  | `8`   | `4`   | `2`   | `1`   |
| `2^5` | `2^4` | `2^3` | `2^2` | `2^1` | `2^0` |

- **`1 byte == 8 bits`**
- **`char = 1 byte = 8 bits`**
- **`int = 4 bytes = 32 bits`**
- **`long long = 8 bytes = 64 bits`**
- **`double = 8 bytes = 64 bits`**

- The most significant bit (**MSB**) (the bit furthest to the LEFT) (also known as highest bit) is used to represent the sign of a number, where 0 indicates a positive value and 1 indicates a negative value
- The least significant bit (**LSB**) (the bit furthest to the RIGHT)

## Negative Numbers (Two's Complement)

- To represent a negative number in binary, we utilise "Two's Complement"

  - Negative numbers are represented by taking the binary representation of the positive counterpart and then inverting all the bits (changing 0s to 1s and 1s to 0s) and adding 1 to the result
  - Example for `-1`
    - Step 1: Positive Counterpart = `1` = `0001`
    - Step 2: Invert all bits = `1110`
    - Step 3: Add 1 = `1111`

- For an `n-bit` binary number the presentation of `-x == 2^(n) - x`
  - `int` = `32 bit` number
    - **`-x == 2^(32) - x`**

## Converting Binary String to Integer

- You need to read string **BACKWARDS/REVERSE**
  - I.e. `String s = "1011"`, we need to read from index `s.length() - 1` to `0`

# Bitwise Operators

| Bitwise Operation  | Code         | Definition                                                                                                                                     |
| ------------------ | ------------ | ---------------------------------------------------------------------------------------------------------------------------------------------- | --- |
| AND                | **`x & y`**  | If both bits in the compared position of the bit patterns are 1, the bit in the resulting bit pattern is 1, otherwise 0                        |
| OR                 | **`x \| y`** | If both bits in the compared position of the bit patterns are 0, the bit in the resulting bit pattern is 0, otherwise 1                        |
| NOT/NEG            | **`~ x`**    | Flips the bits of the number i.e. if the ith bit is 0, it will change it to 1 and vice versa                                                   |
| Exclusive-Or (XOR) | **`x ^ y`**  | If BOTH bits in the compared position of the bit patterns are 0 or 1, the bit in the resulting bit pattern is 0, otherwise 1                   |
| Left Shift         | **`x << n`** | Multiples the number `x` by `2^n` <br> Moves/Shifts each bit `n` positions to the LEFT <br> Left-end bit vanishes; right-end bit replaced by 0 |
| Right Shift        | **`x >> n`** | Divides the number `x` by `2^n` <br> Moves/Shifts each bit `n` positions to the RIGHT <br> Right-end bit vanishes; left-end bit replaced by 0  |     |

| AND (`&`) | 0   | 1   |
| --------- | --- | --- |
| 0         | 0   | 0   |
| 1         | 0   | 1   |

| OR (`\|`) | 0   | 1   |
| --------- | --- | --- |
| 0         | 0   | 1   |
| 1         | 1   | 1   |

| NEG (`~`) | 0   | 1   |
| --------- | --- | --- |
| `~`       | 1   | 0   |

| XOR (`^`) | 0   | 1   |
| --------- | --- | --- |
| 0         | 0   | 1   |
| 1         | 1   | 0   |

- OR (`|`) == `+`
- XOR (`^`) == `-`

- **`(x << n)`** MULTIPLES the number `x` by `2^n`
- **`(x >> n)`** DIVIDES the number `x` by `2^n`
- **`x | (1 << n)`** SETS the `n'th` bit of the number `x` to `1`
- **`x & ~(1 << n)`** SETS the `n'th` bit of the number `x` to `0`
- **`x ^ (1 << n)`** FLIPS the `n'th` bit of the number `x` to `0`

## Common Pitfalls/Mistakes (Sources of Errors)

- Shifts involving negative values are NOT portable (implementation defined) [common source of errors/bugs]
- Always use unsigned values/variables when shifting to be safe/portable

Bitwise Operators (`&`, `|`, `~`, `^`) have **LOWER** precedence than boolean comparison operators (`!=`, `==`, `>`, `>=`, `<`, `<=`) so will always need to **wrap the bitwise/binary expression in NESTED brackets/parentheses BEFORE performing a boolean comparison** (common source of errors/bugs)

```java
// INCORRECT/INVALID
if (mask & (1 << i) != 0) { ... }
if (mask & (1 << i) > 0) { ... }


// Valid
if ((mask & (1 << i)) != 0) { ... }
if ((mask & (1 << i)) > 0) { ... }
```

Note: The 3 `if()` statements below are EQUIVALENT

```cpp
if ((mask & (1 << i)) != 0) { ... }

if ((mask & (1 << i)) > 0) { ... }

// Might NOT work in Java but valid in C++
if ((mask & (1 << i))) { ... }
```

```cpp
// Checks if i'th bit is set to 0 (i.e. "not set")
if (!(mask & (1 << i))) { ... }
```

If trying to bitshift a number by a large amount in **C++**, you may need to use a for loop to prevent "shift exponent num is too large for 64-bit type 'long 'long'" error

```cpp
// Does NOT work (invalid)
long long totalSubsets = ((long long) 1 << n) % mod; // Note: Using this 1 liner gives "shift exponent 97 is too large for 64-bit type 'long long'" error

// Works (valid)
long long totalSubsets = 1;
for (int i = 1; i <= n; i++) {
  totalSubsets = (totalSubsets * 2) % mod;
}
```

If trying to bitshift a number by a large amount in **Java**, you will need to cast to `long` FIRST

```java
// INCORRECT/INVALID
int dp(int i, int charMask, boolean canChange) {
  long key = (i << 27) | (charMask << 1) | (canChange ? 1 : 0);
}

// VALID
int dp(int i, int charMask, boolean canChange) {
  long key = ((long) i << 27) | ((long) charMask << 1) | (canChange ? 1 : 0);
}
```

## Check If Number Is A Power Of 2

- `(x & (x -1)) == 0`
- A power of two in binary form has only one '1' (MSB)
- A number one less than a power of 2 has all bits except for MSB set to 1
- Hence bitwise ANDing both should give zero (0)

```java
if (num & (num - 1) == 0) {
  System.out.println(num + " is a power of 2")
}
// 1000 == 8
// 0111 == 7
// ---- &
// 0000
```

## Bit Manipulation

- Examples
  - See 3007.maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k

### Multiply by 2

**`(num << 1)`**

```java
int a = 5;
int b = (a << 1); // b = 10
```

### Divide by 2

**`(num >> 1)`**

```java
int a = 10;
int b = (a >> 1); // b = 5
```

## Bitmask

- Note we can only use bitmask if there are `<=32` or `<=64` elements
  - `int == 32 bit`
  - `long == 64 bit`

### Bitmask With All N Bits Set To 1

- To get a bitmask where all `n` bits are set to `1` use:

```java
int finalBitmask = (1 << n) - 1;
```

- Example

```java
(1 << 5) = 32;
// 0010 0000
(1 << 5) - 1 = 31;
// 0001 1111
```

### Check if the i'th bit is set (to 1) in the binary form of the given number

```cpp
if (num & (1 << i)) {
  // ...
}
```

**Note: CANNOT do `if ((num & (1 << i)) == 1)`, since the result of the `AND &` operation may NOT be 1**

Do `if ((num & (1 << i)) != 0)` or `if ((num & (1 << i)) > 0)` instead

```java
if ((num & (1 << i)) != 0) {
  // ...
}
```

```java
if ((num & (1 << i)) > 0) {
  // ...
}
```

### Count the Number of Bits Set to 1

```java
int numBitsSet = Integer.bitCount(currMask);
```

```cpp
// int numBitsSet = std::popcount(currMask); // C++20
int numBitsSet = __builtin_popcount(currMask);
```

```java
int numBitsSet = 0;
while (currMask > 0) {
  numBitsSet += (currMask & 1) == 1 ? 1 : 0;
  currMask >> 1;
}
```

### Set i'th bit

- Note `int y = x | (1 << n)` sets the `n'th` bit of the number `x` to `1`

```java
// Modify "mask"
mask |= (1 << i);

// Create NEW mask to be passed as parameter
dp(mask | (1 << i));
```

### Unset i'th bit

```java
mask &= ~(1 << i);
```

### Flip i'th bit

```java
mask ^= (1 << i);
```

### XOR (`^`)

- If the XOR operation returns a non-zero value, it means `nums[i]` and `nums[j]` are different values

```java
if (nums[i] ^ nums[j]) == if (nums[i] != nums[j])
```

- Keeping track of Parity (Odd/Even)

  - 0 == "even" number of times a character has occurred
  - 1 == "odd" number of times a character has occurred
  - We switch between 0 and 1 with the XOR operation ((0 ^ 1) == 1 && (1 ^ 1) == 0)
  - See 2791.count-paths-that-can-form-a-palindrome-in-a-tree

- Unique Element Detection

  - Bitwise XOR is used to find the unique number in an array where all numbers except one are present twice
  - This is because the XOR of all elements gives us an odd occurring element. A property of XOR is that the XOR of a number with itself is 0, and the XOR of a number with 0 is the number itself
  - So, if we XOR all the elements, we'll end up with the element that appears an odd number of times.

- Flipping Bits

  - XOR with 1 is often used to flip bits in a bitmask
  - This is because `(1 ^ 1) = 0` (flips 1 to 0) and `(0 ^ 1) = 1` (flips 0 to 1)
  - For example, if you want to flip the ith bit in a number n, you can use the operation `n ^= (1 << i)`

- Swapping Numbers
  - XOR can be used to swap two numbers without the need for a temporary variable
  - The sequence of operations is
    ```java
    x ^= y;
    y ^= x;
    x ^= y;
    ```
  - After these operations, the original value of x is now in y and vice versa

```java
// i = 10010, j = 10, prevMask = 10000
int prevMask = mask - (1 << j);
int prevMask = mask ^ (1 << j);

int mask -= (1 << j);
int mask ^= (1 << j);
```

- The following code are EQUIVALENT

```java
int newMask = mask - (1 << i);
int newMask = mask ^ (1 << j);
```

# Binary Search Tree (BST)

## Info

- Height of "balanced" binary search tree (bst) with `N` nodes is `log(N)`
- Worst case height of bst tree is `N` (just a single linked-list)

Fact 1: Inorder traversal of BST is an array sorted in ascending order

- To compute inorder traversal follow the direction Left -> Node -> Right

```java
public LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr) {
  if (root == null) {
    return arr;
  }
  inorder(root.left, arr);
  arr.add(root.val);
  inorder(root.right, arr);
  return arr;
}
```

Fact 2: Successor = "after node", the next node in the inorder traversal, or the smallest node after currNode

- To find a successor, go to the right once and then as many times to the left as you could

```java
public TreeNode getSuccessor(TreeNode root) {
  root = root.right;
  while (root.left != null) {
    root = root.left;
  }
  return root;
}
```

Fact 3: Predecessor = "before node", i.e. the previous node in the inorder traversal, or the largest node before the currNode

- To find a predecessor, go to the left once and then as many times to the right as you could

```java
public TreeNode getPredecessor(TreeNode root) {
  root = root.left;
  while (root.right != null) {
    root = root.right;
  }
  return root;
}
```

## Code

**`int[] dfs(int currNode, int parentNode) {}`**

- Return info containing `{ result_including_currNode, result_from_max_child_excluding_currNode }`

```java
class Solution {
  // List<Integer>[] graph = new List[n];
  Map<Integer, List<Integer>> graph = new HashMap<>();
  int[] colors;

  int question(int[][] edges, int colors) {
    // for (int i = 0; i < n; i++) {
    //   graph[i] = new ArrayList<>();
    // }
    // for (int[] edge : edges) {
    //   graph[edge[0]].add(edge[1]);
    //   graph[edge[1]].add(edge[0]);
    // }
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], f -> new ArrayList<>()).add(edge[1]);
      graph.computeIfAbsent(edge[1], f -> new ArrayList<>()).add(edge[0]);
    }
    return dfs(0, -1)[1];
  }

  // int dfs(int currNode, int parentNode) {
  int[] dfs(int currNode, int prevNode) {
    // Initialise other state variables here
    int countFromCurrNode = 1; // Note: This INCLUDES currNode
    int countFromMaxChild = 0; // Note: This EXCLUDES currNode
    for (int nei : graph.getOrDefault(currNode, Collections.emptyList())) {
      if (nei == prevNode) {
        continue;
      }
      int[] tmp = dfs(nei, currNode);
      result += dfs(nei, currNode);
      // Check nei and currNode have same color
      if (colors[nei] == colors[currNode] && countFromCurrNode != -1) {
        countFromCurrNode += tmp[0];
      // If one of currNode's children/subtrees have different color then currNode does NOT satisfy rule of "every node in its subtree being the same color"
      } else {
        countFromCurrNode = -1;
      }
      countFromMaxChild = Math.max(countFromMaxChild, tmp[1]);
    }
    return new int[] { countFromCurrNode, Math.max(countFromCurrNode, countFromMaxChild) };
  }
}
```

## Lowest Common Ancestor (LCA) - Binary Lifting/Binary Jumping

Let `G` be a tree. For every query of the form `(u, v)` we want to find the lowest common ancestor of the nodes `u` and `v`, i.e. we want to find a node w that lies on the path from `u` to the root node, that lies on the path from `v` to the root node, and if there are multiple nodes we pick the one that is farthest away from the root node. In other words the desired node `w` is the lowest ancestor of `u` and `v` . In particular if `u` is an ancestor of `v`, then `u` is their lowest common ancestor.

The algorithm described in this article will need `O(Nlog_2(N))` for preprocessing the tree, and then `O(log_2(N))` for each LCA query.

### Algorithm

For each node we will precompute its ancestor above them, its ancestor two nodes above, its ancestor four above, etc. Let's store them in the array `up`, i.e. `up[i][j]` is the `2^j`-th ancestor above the node i with `i=1...N`, `j=0...ceil(log_2(N))`. This information allows us to jump from any node to any ancestor above it in `O(log_2(N))` time. We can compute this array using a DFS traversal of the tree.

For each node we will also remember the time of the first visit of this node (i.e. the time when the DFS discovers the node), and the time when we left it (i.e. after we visited all children and exit the DFS function). We can use this information to determine in constant time if a node is an ancestor of another node.

Suppose now we received a query `(u, v)` . We can immediately check whether one node is the ancestor of the other. In this case this node is already the LCA. If `u` is NOT the ancestor of `v`, and `v` NOT the ancestor of `u`, we climb the ancestors of `u` until we find the highest (i.e. closest to the root) node, which is not an ancestor of `v` (i.e. a node `x`, such that `x` is NOT an ancestor of `v`, but `up[x][0]` is). We can find this node `x` in `O(log_2(N))` time using the array `up`.

We will describe this process in more detail. Let `L = ceil(log_2(N))`. Suppose first that `i = L`. If `up[u][i]` is NOT an ancestor of `v`, then we can assign `u = up[u][i]` and decrement `i`. If `up[u][i]` is an ancestor, then we just decrement `i`. Clearly after doing this for all non-negative `i` the node `u` will be the desired node (i.e.` u` is still NOT an ancestor of `v`, but `up[u][0]` is).

Now, obviously, the answer to LCA will be `up[u][0]` (i.e. the smallest node among the ancestors of the node `u`, which is also an ancestor of `v`)

So answering a LCA query will iterate `i` from` ceil(log_2(N))` to `0` and checks in each iteration if one node is the ancestor of the other. Consequently each query can be answered in O(log_2(N)).

### Algorithm 2

Binary Lifting solves the problem of "finding the k'th ancestor of a node in log_2(N) time"

#### Pre-Processing

We will need to store `2^(x)'th` ancestor for each node. Let us store this information in a table `ancestor`. The dimensions of this table are `N * log_2(N)`. Here is what each entry in this table represents

```tex
ancestor[i][x] -> 2^(x)'th parent of node i
```

Note that since the first ancestor of any node is its OWN parent we can write `ancestor[i][0] = parent[i]` for each node `i`. Now to fill the remaining entries we can follow the following recursive relation

```tex
ancestor[n][x] = ancestor[ancestor[n][x-1]][x-1]
```

The idea behind is is `2^n == 2^(n - 1) + 2^(n - 1) == 2 * 2^(n - 1) == 2^(1 + (n - 1)) == 2^n`

To reach the `2^x'th` ancestor we can make 2 jumps of size `2^(x-1)`. Since `2^(x-1) + 2^(x-1) == 2 * 2^(x-1) == 2^(1 + x-1) == 2^(x)`, we will ultimately reach the required ancestor. Thus we have all the required knowledge for performing the pre-processing step.

```java
class Solution {
  int[][] ancestor;

  public int lca(int[] parent, int k) {
    int n = parent.length;
    int maxBitColumnLen = (int) Math.ceil(Math.log(k) / Math.log(2));
    this.ancestor = new int[n][maxBitColumnLen + 1];
    for (int i = 0; i < n; i++) {
      ancestor[i][0] = parent[i];
    }
    // We can NOT go up from root
    // for (int x = 1; x <= maxBitColumnLen; x++) {
    //   ancestor[root][x] = root;
    // }
    for (int x = 1; x <= maxBitColumnLen; x++) {
      for (int i = 0; i < n; i++) {
        // if (i == root) { continue; }
        // Make TWO jumps worth "x-1"
        ancestor[i][x] = ancestor[ancestor[i][x-1]][x-1];
      }
    }
  }
}
```

#### Query Resolution

The idea is to express/construct `k` as the sum of the powers of `2` (i.e. jumping to the powers of `2` to construct `k`).

We will then move up the tree following these powers of `2`.

```java
class Solution {
  int[][] ancestor;
  int maxBitColumnLen;

  public int lca(int[] parent, long k) {
    int n = parent.length;
    this.maxBitColumnLen = (int) Math.ceil(Math.log(k) / Math.log(2));
    this.ancestor = new int[n][maxBitColumnLen + 1];
    for (int i = 0; i < n; i++) {
      ancestor[i][0] = parent[i];
    }
    // We can NOT go up from root
    // for (int x = 1; x <= maxBitColumnLen; x++) {
    //   ancestor[root][x] = root;
    // }
    for (int x = 1; x <= maxBitColumnLen; x++) {
      for (int i = 0; i < n; i++) {
        // if (i == root) { continue; }
        // Make TWO jumps worth "x-1"
        ancestor[i][x] = ancestor[ancestor[i][x-1]][x-1];
      }
    }
  }

  int solveQuery(int node, long k) {
    // for (int x = 1; x <= maxBitColumnLen; x++) {
    for (int x = maxBitColumnLen; x >= 0; x--) {
      // Checking if 2^i is present in binary representation of k
      if ((k & (1L << x)) != 0) {
        // Move up to (2^x)th ancestor
        node = ancestor[node][x];
      }
    }
    return node;
  }
}
```

### Implementation

```cpp
#include <bits/stdc++.h>

class Solution {
public:
  std::vector<int> parent; // Assuming "parent" is given in question
  std::vector<std::vector<int>> ancestor;

  int main() {
    int n;
    std::cin >> n; // n is the number of nodes numbered 0 to n-1
    int maxBitColumnLen = std::log2(n);
    this->parent.assign(n, 0);
    this->ancestor.assign(n, std::vector<int>(maxBitColumnLen + 1, 0));
    // Assuming node 0 is the root of the tree
    parent[0] = 0;
    // Assuming next n lines contain edges in format: parent_node, child_node
    for (int i = 0; i < n; i++) {
      int par, child;
      std::cin >> par >> child;
      parent[child] = par;
    }
    for (int i = 0; i < n; i++) {
      ancestor[i][0] = parent[i];
    }
    for (int x = 1; x <= maxBitColumnLen + 1; x++) {
      for (int i = 0; i < n; i++) {
        ancestor[i][x] = ancestor[ancestor[i][x - 1]][x - 1];
      }
    }
    int numQueries;
    std::cin >> numQueries;
    while (numQueries-- > 0) {
      int currNode, k;
      std::cin >> currNode >> k;
      for (int i = maxBitColumnLen; i >= 0; i--) {
        if (k & (1 << i)) {
          currNode = ancestor[currNode][i];
        }
      }
      std::cout << currNode << "\n";
    }
  }
};
```

```cpp
#include <bits/stdc++.h>

class Solution {
public:
  int n;
  int l;
  std::vector<std::vector<int>> graph; // Assume graph is created beforehand
  int timer;
  std::vector<int> tin;
  std::vector<int> tout;
  std::vector<std::vector<int>> up; // up == ancestorDP

  void dfs(int v, int parent) {
    tin[v] = ++timer;
    up[v][0] = parent;
    for (int i = 1; i <= l; i++) {
      up[v][i] = up[up[v][i - 1]][i - 1];
    }
    for (int nei : graph[v]) {
      if (nei != parent) {
        dfs(nei, v);
      }
    }
    tout[v] = ++timer;
  }

  bool isAncestor(int u, int v) {
    return tin[u] <= tin[v] && tout[u] >= tout[v];
  }

  int getLCA(int u, int v) {
    if (isAncestor(u, v)) {
      return u;
    }
    if (isAncestor(v, u)) {
      return v;
    }
    for (int i = l; i >= 0; i--) {
      if (!isAncestor(up[u][i], v)) {
        u = up[u][i];
      }
    }
    return up[u][0];
  }

  void preprocess(int root, int n) {
    this->tin.resize(n);
    this->tout.resize(n);
    this->timer = 0;
    this->l = std::ceil(std::log2(n));
    // this->up.resize(n, std::vector<int>(l + 1));
    this->up.assign(n, std::vector<int>(l + 1));
    dfs(root, root); // Careful to NOT do dfs(root, -1);
  }
};
```

**Resources**

[Resource 1](https://cp-algorithms.com/graph/lca_binary_lifting.html)
[Resource 2](https://leetcode.com/discuss/study-guide/4299594/Binary-Lifting-Technique-A-Beginners-Guide/)
[Resource 3](https://medium.com/@the_infinity/binary-lifting-and-its-applications-b11729889c2f)

**Examples**

- 2846.minimum-edge-weight-equilibrium-queries-in-a-tree
  - Note: Also includes "weight"
- 2836.maximize-value-of-function-in-a-ball-passing-game
  - Note: Interesting implementation of "successors" INSTEAD OF "ancestors"

# BFS

- Use **`queue`**
- 2 Methods
  - Store numIterations in global variable
  - Store numIterations inside queue element

```java
// Set up "graph" + "visitedSet"
Queue<int[]> q = new LinkedList<>();
// Offer initial state onto queue { x, y, cost, numSteps }
q.offer(new int[0, 0, 0, 0]);
// BFS (expand all elements in queue)
int numSteps = 0;
while (!q.isEmpty()) {
  int[] curr = q.poll();
  int x = curr[0];
  int y = curr[1];
  int currCost = curr[2];
  int numSteps = curr[3];
  // Expand to neighbours
  for (int[] nei : graph.getOrDefault(curr[0], Collections.emptyList())) {
    if (!visited) {
      q.offer(new int[] { nei[0], nei[1], currCost + nei[2], numSteps++ });
    }
  }
}
```

```java
// Set up "graph" + "visitedSet"
Queue<int[]> q = new LinkedList<>();
// Offer initial state onto queue { x, y, cost }
q.offer(new int[0, 0, 0]);
// BFS (expand all elements in queue)
int numSteps = 0;
while (!q.isEmpty()) {
  int qSize = q.size();
  for (int i = 0; i < qSize; i++) {
    int[] curr = q.poll();
    // Expand to neighbours
    for (int[] nei : graph.getOrDefault(curr[0], Collections.emptyList())) {
      if (!visited) {
        q.offer(new int[] { nei[0], nei[1], numSteps });
      }
    }
  }
  numSteps++;
}
```

## Find Nodes in Cycle

- Continuously trim leaf nodes(nodes with indegree == 1) until you can't
  - Push leaf nodes (nodes with indegree == 1) onto queue
  - Poll from queue and decrease indegree of neighbours and offer onto queue if neighbour indegree == 1
  - Repeat above
- Questions
  - 2204

## Giving Unique ID to Each Subtree (Finding Duplicate Subtrees)

- Use `String` to create triplet of `dfs(left) + "," + currNode.val + dfs(right)` (returning `0` when `currNode == null`)
- Use 2 `HashMaps`
  - "tripletToID" which maps above string representation to a `tripletToID.size()` number (id). Note: The trick is to use the size of the hashmap as the ID (size of hashmap == id)
  - "cnt" which maps the **id** to an occurence count
- See 652.find-duplicate-subtrees

```java
class Solution {
  List<TreeNode> result;
  Map<Integer, Integer> cnt;
  Map<String, Integer> tripletToID;

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    this.result = new ArrayList<>();
    this.cnt = new HashMap<>();
    this.tripletToID = new HashMap<>();
    dfs(root);
    return result;
  }

  public int dfs(TreeNode currNode) {
    if (currNode == null) {
      return 0;
    }
    String triplet = dfs(currNode.left) + "," + currNode.val + "," + dfs(currNode.right);
    if (!tripletToID.containsKey(triplet)) {
      tripletToID.put(triplet, tripletToID.size() + 1);
    }
    int id = tripletToID.get(triplet);
    cnt.put(id, cnt.getOrDefault(id, 0) + 1);
    if (cnt.get(id) == 2) {
      result.add(currNode);
    }
    return id;
  }
}
```

# Common Errors/Pitfalls

- Always check that indexes/indices are valid BEFORE using them

```java
int dp(int i, int j) {
  // ORDER matters
  if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
    return -1;
  }
}
```

- Need to WRAP bitwise operations `&`, `|`, `^`, `~` in EXTRA set of BRACKETS

  - Bitwise Operators (`&`, `|`, `~`, `^`) have LOWER precedence than comparison operators (`!=`, `==`) so will always need to wrap the binary operators in nested brackets before doing the comparison

  ```java
  // Note the two if() statements below are equivalent
  if ((mask & (1 << i)) != 0) {
    //...
  }

  if (!(mask & (1<< i))) {
    //...
  }
  ```

# Cumulative Sum (Line Sweep)

```java
int[] nums = {1, 2, 3, 4, 5}
int n = nums.length;
int[] cumulativeSum = new int[n];
cumulativeSum[0] = nums[0];
for (int i = 1; i < n; i++) {
  cumulativeSum[i] = cumulativeSum[i - 1] + nums[i];
}
```

- Examples
  - 1109.corporate-flight-bookings (interesting application)

# Data Types

| Types        | `int`                     | `long long`               | `double`                                                          | `bool`                     | `char`                  |
| ------------ | ------------------------- | ------------------------- | ----------------------------------------------------------------- | -------------------------- | ----------------------- |
| Description  | 32-bit integer            | 64-bit integer            | Double-Precision Float                                            | `true/false` value`        | 8-bit character         |
| Size (bytes) | 4                         | 8                         | 8                                                                 | 1                          | 1                       |
| Range        | `-2^(31)` to `2^(31) - 1` | `-2^(63)` to` 2^(63) - 1` | `-1.7E+308` to `1.7E+308` (`-1.7 * 10^(308)` to `1.7 * 10^(308)`) | 0 or 1 (`true` or `false`) | `-2^(7)` to `2^(7) - 1` |

The normal/typical 32-bit integer data type (`int` in C++ and Java) supports values between `-2147483648` and `2147483647` (roughly `+- 2 * 10^(9)`)

## Floating Point Numbers

Floating point numbers are like the computer equivalent of scientific notation

Why floating point numbers can support/represent larger ranges than `long`:

- Floating point numbers trade precision for higher ranges
- The mass of the earth is `5.972e+27` grams
  - `5.972e+27` only takes up 9 characters, while `5972000000000000000000000000` takes up 28 characters

### Double Precision/Floating Point Precision Loss

- Always be careful when performing operations using floating point types such as `double` due to rounding errors
- If calling `Math.ceil()` on the result of floating point calculation, then we need to **subtract** an epsilon value **BEFORE** calling `Math.ceil()`
  - This is because if `1/3 + 2/3 == 1.000000000001`, then `Math.ceil()` will give `2` instead of `1`
- See 1883.minimum-skips-to-arrive-at-meeting-on-time

```java
double sum = 0.0;
for (int i = 0; i < 3000; i++) {
  sum += (10.0/3.0);
}
// Expected sum == 10000 however actual output == 10000.000000000031
System.out.println(sum);
```

# Dynamic Programming

- Easier to understand when looking at **Top Down** (DFS) version **FIRST** before looking at **Bottom Up** version
- Top Down is essentially dfs with memoisation
- The space complexity of a Bottom Up approach will typically be lower than a Top Down approach, since it does NOT need to store the full recursive call stack
- The time complexities of BOTH Bottom Up and Top Down approaches will be similar

## Array Index Methods

**FORWARDS**

- Start at index `1`
- End at either index `n` inclusive or exclusive

```java
// Forwards
int[] dp = new int[n + 1];
// Normally set dp[0] = 0 (or whatever base case)
for (int i = 1; i <= n; i++) {
  if (nums[i - 1] >= target) {
    dp[i] = dp[i - 1] + 1;
  } else {
    dp[i] = dp[i - 1];
  }
}
```

**BACKWARDS**

- Start at index `n - 2`
- End at index `0`

```java
// Backwards
int[] dp = new int[n + 1];
// Normally set dp[n - 1] = 0 (or whatever base case)
for (int i = n - 2; i >= 0; i--) {
  if (nums[i + 1] >= target) {
    dp[i] = dp[i + 1] + 1;
  } else {
    dp[i] = dp[i + 1];
  }
}
```

## 1-Indexed Array

- 1-Indexed Array means that `index 0 == 1st element == (i is 1)` in terms of counting
- Will need to use `i+1` when checking for boundaries instead of `i` because everything is shifted forward by 1
- See 2969.minimum-number-of-coins-for-fruits-ii

## Boolean to Integer Hack

- If we want to store a `boolean` value in `Integer[][][] dp` we can use `0` and `1` to represent `true` and `false`
- Toggle value of `0` and `1` wtih

```java
dp(x, y, (canReduce + 1) % 2);

dp(x, y, canReduce ^ 1); // 0 ^ 1 == 1 and 1 ^ 1 == 0
```

## Digit DP

Convert number to string using `std::to_string` or `String.valueOf()`

Reconstruct number STARTING from index 0 which corresponds to LEFT-MOST digit of num

Note: We start off by setting `isCurrDigitBound` to `True/1` because we do NOT want to exceed the given digit of num, we want to build UP TO the given digit

```
Digit: 2048
Index: 0123
```

```java
int num = 123;
String s = String.valueOf(num);
// s = "123"
dp(0, 1);
int dp(int i, int isCurrDigitBound) {
  //...
}
```

## Preventing Integer Overflow/Underflow

- Top Down DP Recursion Base Case: `if (i == nums1.length || j == nums2.length) { return Integer.MIN_VALUE; }`
- However we want use the returned value for addition/subtraction
- Problem: Integer overflow/underflow with `Integer.MIN_VALUE`
- Solution: Use `Math.max(dp(nextState), 0)`
- See 1458.max-dot-product-of-two-subsequences

```java
class Solution {
  int[][] memo;
  int[] nums1;
  int[] nums2;

  public int dp(int i, int j) {
    if (i == nums1.length || j == nums2.length) {
      return Integer.MIN_VALUE;
    }
    if (memo[i][j] != -1) {
      return memo[i][j];
    }
    int use = nums1[i] * nums2[j] + Math.max(dp(i + 1, j + 1), 0); // <-- HERE
    // return memo[i][j] = Math.max(use, Math.max(skipI, skipJ));
    return memo[i][j] = Math.max(use, Math.max(dp(i + 1, j), dp(i, j + 1)));
  }

  public int maxDotProduct(int[] nums1, int[] nums2) {
    this.memo = new int[nums1.length][nums2.length];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    this.nums1 = nums1;
    this.nums2 = nums2;
    return dp(0, 0);
  }
}
```

## Common Causes of Errors

**No Base Case for Recursion**

**Forgot to initialise `memo[][]` values to `-1` or `0`**

- In Java, you NEED to use `for (int[] row : memo) { Arrays.fill(row, -1); }`
- In C++, you are able to initialise in the declaration `std::vector<std::vector<int>> memo(m, std::vector<int>(n, -1))` or `this->memo.resize(m, std::vector<int>(n, -1))`

**Memoisation parameters are NOT sufficient/does NOT cover all possible cases (`memo[i][j]` TOO SIMPLISTIC )**

- E.g. For 1751.maximum-number-of-events-that-can-be-attended-ii we CANNOT use `memo[i][numEventsAttended]` and need to use the parameter `prevEventEnd` since we can reach the SAME index `i` with SAME `numEventsAttended` but with DIFFERENT `prevEventEnd`
- However we also cannot use `prevEventEnd` since its limit is `10^9` which would lead to MLE
- Solution: Either use `String` or use **binary search** to find optimal next index (instead of just incrementing index `i` blindly by one each time)

# DFS

- Use `recursion`
  - Make sure base case/ending case is clearly defined

## DFS Cycle Find

- Use WHITE (0), GREY (1), BLACK (2) coloring

## DFS Cycle Removal

- 1192 dfs() removes ALL edges that are in cycle
- 1579 dfs() removes SINGLE edge that causes cycle

# Formulas

## Convert 2D Matrix Cell Coordinate (i, j) to Index Number (Flatten 2D Matrix)

- This function converts a cell of a matrix/grid (of size `m * n`) to an index/number
- Note the indices start from `0` and go to `(m * n) - 1` (left to right, top to bottom)
- Note
  - `m = grid.length`
  - `n = grid[0].length`
  - We need to use **`n`** (i.e. number of columns) to ensure formula works with non-square matrix/grids (where `grid.length != grid[0].length`)
- Examples
  - See 3605.shift-2d-grid

```java
int cellToIndex(int i, int j) {
  return i * n + j;
}

int cellToIndex(int x, int y) {
  return x * n + y;
}
```

## Binary Search on 2D Matrix Using Single Index 'mid'

- See 74.search-a-2d-matrix
  - `m = matrix.length`
  - `n = matrix[0].length`
  - `mid = (left + right) / 2`
  - **`row = mid / n`** (floor division, Math.floor)
  - **`col = mid % n`**
- Flatten 2D matrix into 1D matrix through use of a single index, that can be used for binary search

```java
public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int left = 0;
    int right = m * n - 1;
    while (left <= right) {
      // int mid = (left + right) / 2;
      int mid = left + (right - left) / 2;
      if (matrix[mid / n][mid % n] == target) {
        return true;
      }
      if (matrix[mid / n][mid % n] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
```

## Filter out numbers that end with digit `k`

```java
public class Solution {
  public boolean getNumbersThatEndWithK(int upperBound, int k) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i <= upperBound; i++) {
      // Filter out numbers that end with digit 'k'
      if (i % 10 == k) {
        list.add(i);
      }
    }
    int[] nums = list.stream().mapToInt(i -> i).toArray();
    // int[] nums = new int[list.size()];
    // for (int i = 0; i < list.size(); i++) {
    //   nums[i] = list.get(i);
    // }
    return nums;
  }
}
```

## Flatten 2D Grid to Single Array + Shifting

- The element at `grid[i][j]` is moved to `grid[i][j + 1]`
- The element at `grid[i][n - 1]` moves to `grid[i + 1][0]`
- The element at `grid[m - 1][n - 1]` is moved to `grid[0][0]`

```java
class Solution {
  // @param k: Number of shifts
  public int[][] shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int[] flattenedGrid = new int[m * n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        flattenedGrid[(i * n) + j] = grid[i][j];
      }
    }
    k %= flattenedGrid.length;
    int[] shiftedGrid = new int[flattenedGrid.length];
    for (int i = 0; i < flattenedGrid.length; i++) {
      int newIndex = (i + k) % flattenedGrid.length;
      shiftedGrid[newIndex] = flattenedGrid[i];
    }
    int[][] resultGrid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        resultGrid[i][j] = shiftedGrid[(i * n) + j];
      }
    }
    return resultGrid;
  }
}

class Solution2 {
  // @param k: Number of shifts
  public int[][] shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    k = k % (m * n);
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // pos == index in flattened then shifted grid
        int pos = (i * n + j + k) % (m * n);
        int x = pos / n;
        int y = pos % n;
        result[x][y] = grid[i][j];
      }
    }
    return result;
  }
}
```

# Graph

## Data Structure

- `List<List<Integer>>` or `List<List<int[]>>`
- `Map<Integer, List<Integer>>` or `Map<Integer, List<int[]>>`
- `List<Integer>[]`

```java
List<List<Integer>> graph = new ArrayList<>();
int n = edges.length;
for (int i = 0; i < n; i++) {
  graph.add(new ArrayList<>());
}
for (int[] e : edges) {
  graph.get(e[0]).add(e[1]);
  graph.get(e[1]).add(e[0]);
}

// Iterating through graph
for (int neiNode : graph.get(currNode)) {
  //...
}
```

```java
Map<Integer, List<Integer>> graph = new HashMap<>();
for (int[] e : edges) {
  graph.computeIfAbsent(e[0], f -> new ArrayList<>()).add(e[1]);
  graph.computeIfAbsent(e[1], f -> new ArrayList<>()).add(e[0]);
}

// Iterating through graph
for (int neiNode : graph.getOrDefault(currNode, new ArrayList<>())) {
  //...
}
```

```java
List<Integer>[] graph = new List[n];
for (int i = 0; i < n; i++) {
  graph[i] = new ArrayList<>();
}
for (int[] e : edges) {
  graph[e[0]].add(e[1]);
  graph[e[1]].add(e[0]);
}
```

## Complete Graph

- Complete graphs are graphs that have an edge between every single vertex in the graph

## Connected Graph

- A connected graph is a graph in which it's possible to get from every vertex in the graph to every other vertex through a series of edges, called a path
- The minimum number of edges for undirected connected graph is `(n-1)` edges where `n` is the number of vertices

## Eulerian Path / Eulerian Circuit

- An Eulerian Path is a path in a graph that **visits every edge exactly once** (allowing for revisiting vertices)
- An Eulerian Circuit/Eulerian Cycle is an Eulerian path that **starts and ends at the same vertex** (cycle)
- For the existence of Eulerian paths it is necessary that 0 or 2 vertices have an odd degree
  - If there are **no vertices of odd degree**, all Eulerian paths are cycles
  - If there are **exactly two vertices of odd degree**, all Eulerian paths start at one of them and end at the other
- A graph has an Eulerian Path if and only if:
  - We have `outDegree[i] == inDegree[i]` for each node i
    - I.e. Cycle
  - We have `outDegree[i] == inDegree[i]` for all nodes i except exactly two nodes `x` and `y` that satisfy:
    - `outDegree[x] = inDegree[x] + 1` (x = start node)
    - `outDegree[y] = inDegree[y] - 1` (y = end node)
- Resources
  - [cp-algorithms](https://cp-algorithms.com/graph/euler_path.html)
- Questions
  - 332.reconstruct-itinerary
  - 2097.valid-arrangement-of-pairs

## Hamiltonian Path

- A Hamiltonian Path is a path in an undirected or directed graph that **visits each vertex exactly once**
- A Hamiltonian Cycle is a Hamiltonian path **starts and ends at the same vertex** (cycle)

## Minimum Spanning Tree

- A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight
- MST = A Spanning Tree whose sum of edge weights is as small as possible
  - A Spanning Tree ST of an undirected graph G is a subgraph that is a tree which includes all of the vertices of G
  - Note: A graph that is not connected will not contain a spanning tree
- Both **Kruskal's Algorithm** and **Prim's Algorithm** are used to construct a "minimum spanning tree (MST)" of a "weighted undirected graph"
- Note: A MST becomes complete as soon as it contains `(n-1)` edges because a tree with `n` nodes will always have `(n-1)` edges
  - Or alternatively a MST becomes complete as soon as it contains `n` nodes
- `while(!pq.isEmpty && edgesUsed < n - 1)`
- `while(!pq.isEmpty && visitedNodes.size() < n)`

### Kruskal's Algorithm

- Kruskal's Algorithm starts from the LOWEST WEIGHTED EDGE and traverses edges based on lowest weight to create MST
- Kruskal's Algorithm performs better in sparse graphs (graphs with lower number of edges)
- Use **Heap Priority Queue** or **List** data structure to sort edges in ascending order of weights initially
- Use **Union Find** or **Disjoint Set Union (DSU)** data structure to determine if vertices/nodes are connected already
- `while(!pq.isEmpty && edgesUsed < n - 1)`
- In Kruskal's Algorithm, you do not keep one connected component but a forest
  - At each stage, you look at the globally smallest edge that does not create a cycle in the current forest
  - Such an edge has to necessarily merge two trees in the current forest into one
  - Since you start with N single-vertex trees, in N-1 steps, they would all have merged into one if the graph was connected
- Complexity
  - Time Complexity: `O(E * log(E))`
    - Creating graph costs `O(E)`
    - Costs `O(E * log(E))` to push all edges onto pq initially (or to sorting all edges)
    - Iterate through all edges and perform union find
      - If using BOTH path compression AND union by rank then each find() and union() operation costs `O(alpha(V))` which is amortised constant time `O(1)`
      - If using only path compression OR union by rank then each find() and union() operation costs `O(log(V))` hence `O(E * log(V))`
  - Space Complexity: `O(V + E)`
    - Storing graph costs `O(V + E)`
    - PQ costs `O(E)`

### Prim's Algorithm

- Prim's Algorithm starts from the ROOT NODE/VERTEX and traverses from vertex to vertex adjacently to create MST
- Prim's Algorithm is significantly faster in dense graphs (graphs with many more edges than vertices)
- Use **Heap Priority Queue** data structure and push root node with weight of 0 onto pq initially
  - Then visit adjacent nodes and for each adjacent node push (neiNode, neiWeight) onto pq
- Use visited set and break when visited.size() == number of vertices/nodes
  - Can also use visited array and numNodesVisited variable counter
- `while(!pq.isEmpty && visitedNodes.size() < n)`
- In Prim's Algorithm, you always keep a connected component, starting with a single vertex
  - You look at all edges from the current component to other vertices and find the smallest among them
  - You then add the neighbouring vertex to the component, increasing its size by 1
  - In N-1 steps, every vertex would be merged to the current one if we have a connected graph
- Complexity
  - Time Complexity: `O(E * log(V))`
    - Creating graph costs `O(E)`
    - We visit all nodes in graph and push each node onto pq costing `O(log(V))`
      - For each node visited, we examine all its edges to find adjacent nodes hence `O(E * log(V))`
  - Space Complexity: `O(V + E)`
    - Storing graph costs `O(V + E)`
    - PQ costs `O(V)`

## Single-Source Shortest Path

### Dijkstra's Algorithm

- Dijkstra's Algorithm solves the "single-source shortest path" problem in a weighted directed graph with **non-negative** weight edges
- Use **Heap Priority Queue** and push starting node onto pq initially
  - Pop currNode from pq
  - Visited adjacent neighbours and push (neiNode, neiWeight) onto pq
  - Break if you pop endNode from pq
- Complexity
  - Time Complexity: `O(E + (V * log(V))`
    - Creating graph costs `O(E)`
    - We visit all nodes in graph and push each node onto pq costing `O(log(V))`, hence `O(V * log(V))`
  - Space Complexity: `O(V + E)`
    - Storing graph costs `O(V + E)`
    - PQ costs `O(V)`

```java
class Solution {
  public int minCost(int source, int target, int[][] edges) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] e : edges) {
      int u = e[0];
      int v = e[1];
      int dist = e[2];
      graph.computeIfAbsent(u, f -> new ArrayList<>()).add(new int[] { v, dist });
      graph.computeIfAbsent(v, f -> new ArrayList<>()).add(new int[] { u, dist });
    }
    // pq = { node, dist }
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
    // currNode, numSteps
    pq.offer(new int[] { source, 0 });
    int[] dist = new int[edges.length];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;
    // Dijkstra's Algorithm
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int currNode = curr[0];
      int numSteps = curr[1];
      // Reach last node (note cannot return dist[n - 1] because min dist does not always equal min dist to reach last node, see example2)
      if (currNode == target) {
        return numSteps;
      }
      for (int[] nei : graph.getOrDefault(currNode, new ArrayList<>())) {
        int neiNode = nei[0];
        int edgeWeight = nei[1];
        // If we can reach neiNode with lower distance
        if (numSteps + edgeWeight < dist[neiNode]) {
          dist[neiNode] = numSteps + edgeWeight;
          pq.offer(new int[] { neiNode, numSteps + edgeWeight });
        }
      }
    }
    return -1;
  }
}
```

### Bellman-Ford's Algorithm

- Bellman-Ford's Algorithm solves the "single-source shortest path" problem in a weighted directed graph with **negative** weight edges
- [Read more](https://cp-algorithms.com/graph/bellman_ford.html)

## All-Pairs Shortest Path

### Floyd-Warshall's Algorithm

```cpp
class Solution {
public:
  void floydWarshall(int n, std::vector<std::vector<int>> &edges) {
    std::vector<std::vector<int>> dist(n, std::vector<int>(n, INT_MAX));
    for (auto &e : edges) {
      // dist[e[0]][e[0]] = 1;
      // dist[e[1]][e[1]] = 1;
      dist[e[0]][e[1]] = 1;
      dist[e[1]][e[0]] = 1;
    }
    // Floyd-Warshall Algorithm
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          dist[i][j] = std::min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }
  }
}
```

```java
class Solution {
  void floydWarshall(int n, int[][] edges) {
    int[][] dist = new int[n][n];
    for (int[] row : dist) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    for (int[] e : edges) {
      // dist[e[0]][e[0]] = 1;
      // dist[e[1]][e[1]] = 1;
      dist[e[0]][e[1]] = 1;
      dist[e[1]][e[0]] = 1;
    }
    // Floyd-Warshall Algorithm
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        if (dist[i][k] != Integer.MAX_VALUE) { // Prevent Integer Overflow [can also do `if (dist[i][k] < Integer.MAX_VALUE)`]
          for (int j = 0; j < n; j++) {
            if (dist[k][j] != Integer.MAX_VALUE) { // Prevent Integer Overflow [can also do `if (dist[i][k] < Integer.MAX_VALUE)`]
              dist[i][j] = std::min(dist[i][j], dist[i][k] + dist[k][j]);
            }
          }
        }
      }
    }
  }
}
```

## Topological Sort

- Steps
  - Create `graph` and record `indegrees`
  - Push nodes with 0 indegree onto `queue`
  - Trim leaf nodes one by one (by popping nodes off queue) and decreasing the indegree count of their neighbours by one

```java
class Solution {
  int topologicalSort(int[][] edges) {
    int n = edges.length;
    int[] inDegrees = new int[n];
    boolean[] visited = new boolean[n];
    Queue<Integer> q = new LinkedList<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    // Topological sort to find cycles in directed graph
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], f -> new ArrayList<>()).add(edge[1]);
      inDegrees[edge[1]]++;
    }
    for (int i = 0; i < n; i++) {
      if (inDegrees[i] == 0) {
        q.offer(i);
      }
    }
    // Trim leaf nodes one by one
    while (!q.isEmpty()) {
      int currNode = q.poll();
      visited[currNode] = true;
      for (int nei : graph.getOrDefault(currNode, Collections.emptyList())) {
        if (--inDegrees[nei] == 0) {
          q.offer(nei);
        }
      }
    }
    // After above while loop finishes (i.e. when queue is EMPTY), the remaining nodes that have NOT been visited are part of a cycle
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        //...
      }
    }
  }
}
```

# Hacks/Tricks

## Array Wrap Around

- Utilise modulus (`%`)

```java
// 'i' == starting index
for (int i = 0; i < n; i++) {
  int prefixSum = 0;
  for (int j = 0; j < n; j++) {
    prefixSum += nums[(i + j + n) % n];
    //...
  }
}
```

- See 3542.non-negative-prefix-sum

## Flatten 2D Matrix into Stateful String and Check Neighbours of currCell

- See 1659.maximize-grid-happiness
- `M = matrix.length`
- `N = matrix[0].length`
- TOP neighbour = `currIndex - N`
- LEFT neighbour = `currIndex - 1`

```md
C = currCell
T = TOP neighbour
L = LEFT neighbour

|x|x|x|T|
|x|x|L|C|
```

## Index Shifting When Deleting an Element

- Store all the evenPrefixSum and oddPrefixSum (up to and including index i) for every index i of the array
- When you remove currIndex, even/odd index sum on its LEFT SIDE remain UNCHANGED
- But the indexes on its RIGHT side will get interchanged/swapped
  - Odd indices become even indices and even indices will become odd indices
  - Therefore, on its RIGHT side, the oddIndexSum becomes evenIndexSum and evenIndexSum becomes oddIndexSum
- Therefore `if (evenIndexSum == oddIndexSum)` becomes `if (evenSumBefore + oddSumAfter == oddSumBefore + evenSumAfter)`
- See 1664.ways-to-make-a-fair-array

## Uses of 3D array `int[][][]`

- If you want to have a `std::vector<std::vector<std::pair<int, int>>>` in Java, instead of using `List<List<Map.Entry<int, int>>>` you can instead of `int[][][]` with the size of the last array being `2`
  - `int[][][] dp = new int[m][n][2];`
  - `dp[i][j][0] = pair.first`
  - `dp[i][j][1] = pair.second`
  - `dp[i][j] = new int{ minNum, maxNum };`

# Heap Priority Queue

- `k'th` largest = `(n - k)'th` smallest
- `k'th` smallest = `(n - k)'th` largest
- See interview-questions/2023/atlassian/q4.java

## K'th Largest

- Use **MIN** heap of size `k` so that k'th largest element will be at the top of the heap
  - Min heap order goes `[k'th, (k-1)'th, (k-2)th, ..., 2nd, 1st]` largest
  - Elements that come after will be LARGER, so `k-1`th largest element comes next
    - I.e. if `k == 3`, then second largest element comes next, then largest element comes last
  - Largest element will be at bottom of the heap
- Insert elements into pq and restrict `pq.size()` to k

```java
class Solution {
  int getKthLargestElement(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    for (int num : nums) {
      pq.offer(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.poll();
  }
}
```

## K'th Smallest

- Use **MAX** heap of size `k` so that k'th smallest element will be at the top of the heap
  - Max heap order goes `[k'th, (k-1)'th, (k-2)th, ..., 2nd, 1st]` smallest
  - Elements that come after will be SMALLER, so `k-1`th smallest element comes next
    - I.e. if `k == 3`, then second smallest element comes next, then smallest element comes last
  - Smallest element will be at bottom of the heap
- Insert elements into pq and restrict `pq.size()` to k

```java
class Solution {
  int getKthSmallestElement(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    for (int num : nums) {
      pq.offer(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.poll();
  }
}
```

## Index Heap/Index Priority Queue

```cpp
class Solution {
public:
  int nthSuperUglyNumber(int n, std::vector<int> &primes) {
    std::vector<long long> uglyNums(n, 0);
    auto cmp = [&uglyNums, &primes](auto a, auto b) {
      return uglyNums[a.first] * primes[a.second] > uglyNums[b.first] * primes[b.second];
    };
    // pq = uglyNumsIndex, primesIndex
    std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, decltype(cmp)> pq(cmp);
    for (int i = 0; i < primes.size(); ++i) {
      pq.push({0, i});
    }
    uglyNums[0] = 1;
    int i = 1;
    while (i < n) {
      auto top = pq.top();
      pq.pop();
      int currPrime = primes[top.second];
      int uglyNumsIndex = top.first;
      long long currNum = uglyNums[uglyNumsIndex] * currPrime;
      // Skip duplicates and only store unique ugly numbers
      if (currNum != uglyNums[i - 1]) {
        uglyNums[i] = currNum;
        i++;
      }
      pq.push({uglyNumsIndex + 1, top.second});
    }
    return (int) uglyNums[n - 1];
  }
};
```

# Infinity

- If only using for comparisons then `Integer.MAX_VALUE` is suitable
- However if we are adding values returned by recursive calls, then `Integer.MAX_VALUE` is **NOT** suitable
  - `Integer.MAX_VALUE` will overflow to `Integer.MIN_VALUE` if you add to it
  - Set an appropriate limit such as a couple hundred million
    - `int INF = 200 * (1e6)`
- Reference
  - `Integer.MAX_VALUE` = `2_147_483_647` == `2^(31) - 1`
  - `Integer.MIN_VALUE` = `-2_147_483_648` == `-2^(31)`

# Intervals

## Closed Intervals

- In a closed interval, BOTH the lower and upper bounds are INCLUDED in the range
  - I.e. the interval is INCLUSIVE at both ends
- A closed interval is denoted using square brackets `[]` for both the lower and upper bounds

```tex
[a, b] = {x | a <= x <= b}
```

## Open Intervals

- In an open interval, neither the lower nor the upper bound is included in the range
  - I.e. the interval is EXCLUSIVE at both ends
- An open interval is denoted using parentheses `()` for both the lower and upper bounds

```tex
(a, b) = {x | a < x < b}
```

## Half-Closed/Half-Open Intervals

```tex
[a, b) = {x | a <= x < b}
(a, b] = {x | a < x <= b}
```

# LeetCode Patterns

- If input array is sorted:

  - Binary search
  - Two pointers

- If asked for all permutations/subsets:

  - Backtracking

- If given a tree:

  - DFS
  - BFS

- If given a graph:

  - DFS
  - BFS

- If given a linked list:

  - Two pointers

- If recursion is banned:

  - Stack

- If must solve in-place:

  - Swap corresponding values
  - Store one or more different values in the same pointer

- If asked for maximum/minimum subarray/subset/options:

  - Dynamic programming

- If asked for top/least K items:

  - Heap Priority Queue
  - QuickSelect

- If asked for common strings:

  - Map
  - Trie

- Random
  - Map/Set for O(1) time and O(n) space
  - Sort input for O(Nlog(N)) time and O(1) space

# `long` or `long long` Type

- `long` type for Java

  - Operations on `int` are NOT promoted to `long` even if target variable is of type `long`
  - Need to add `1L` into operation

  ```cpp
  int a = 1000000;
  int b = 1000000;

  // long c = a * b; // INVALID
  long c = 1L * a * b;

  // long d = 1 << 40; // INVALID
  long d = 1L << 40;
  ```

- `long long` type for C++

  - Operations on `int` are NOT promoted to `long long` even if target variable is of type `long long`
  - Need to add `1LL` into operation

  ```cpp
  int main() {
    int a = 1000000;
    int b = 1000000;

    // long long c = a * b; // INVALID
    long long c = 1LL * a * b;

    // long long d = 1 << 40; // INVALID
    long long d = 1LL << 40;
  }
  ```

# Math

## Branching

- To find total number of combinations where sections are INDEPENDENT of each other then we just multiply the number of combinations for each section together
  - Think of tree example, if a there are 3 leaves and each leaf branches off into 2 children, then total combinations is `3\*2`
- No permutation/combination formula is needed
- Examples
  - See 2147.number-of-ways-to-divide-a-long-corridor

## Brackets

- Sometimes there is shitty code written like `n - i - 1`
- Conver it to `n - (i + 1)` for better readability

## Combinatorics

**Permutation = ARRANGEMENT** of n (distinct or non-distinct) objects

**Combination = SELECTION** of n (distinct or non-distinct) objects

### Permutation

Definition:

- A permutation/arrangement is an **ordered** subset formed by selecting some or all of the elements of a set
- A permutation/ordered set is an **arrangement of objects** chosen from a certain set
  - The symbol `nPr` is used to denote the number of permutations of r objects chosen without repetition from a set of n distinct objects

Properties:

- **`nPn = n!`**
  - `nPn == n!/(n-n)! == n!/0! = n!/1 = n!`

#### With Repetition

Formula: **`n^r`**

- `n` = total number of objects in the set
- `r` = number of objects chosen from the set

#### Without Repetition

Formula: **`nPr = n!/(n-r)!`**

- `n` = total number of objects in the set
- `r` = number of objects chosen from the set

Note: `nPr == nCr * rPr`

#### Distinct Permutation

Formula: **`n!/(r1! * r2! * ... rk!)`**

- If there are any items repeated:
  - One/first item is repeated `r1` times
  - Another/second item is repeated `r2` times
  - ...
  - K'th item is repeated `rk` times

Example:

- There are 12 stickers and 4 of the those stickers are identical stars and 3 are identical moons
- Number of distinct permutations = `12!/(4! * 3!)`

### Combination

Definition:

- A combination is a selection of objects from a set, in such a way that the order of the objects does NOT matter
- A combination is an **unordered** selection of r subsets from a set of n objects
  - The symbol `nCr` is used to denote the number of selections of r objects chosen without repetition from a set of n distinct objects

Properties:

- **`nC0 = 1`**
- **`nCn = 1`**
- **`nC1 = n`**
- **`nC(n-1) = n`**
  - Choose everybody except 1 / exclude 1 person
- **`nCr = nC(n-r)`**
- **`nCr = (n-1)Cr + (n-1)C(r-1)`**
  - C(n,r) == C(n-1, r) + C(n-1, r-1)
- **`(n+1)Cr = nCr + nC(r-1)`**

Example:

- Choose 2 pairs from n objects
  - `nC2 == n!/(2! * (n-2)!) == (n * (n-1))/2 == n*(n-1)/2`

#### Without Repetition

Formula: **`nCr = n!/((n-r)! * r!)`**

- `n` = total number of objects in the set
- `r` = number of objects chosen from the set

Note: `nCr == nPr/r! == n!/((n-r)! * r!)`

#### With Repetition

Formula: **`(n+r-1)Cr = (n+r-1)!/(r! * (n-1)!)`**

- `n` = total number of objects in the set
- `r` = number of objects chosen from the set

#### nCr == (n-1)C(r-1) + (n-1)Cr

`nCr == (n-1)C(r-1) + (n-1)C(r)`

`nCk == (n-1)C(k-1) + (n-1)C(k)`

- Suppose you want to select a group of `k` students out of `N` students, which can be done in `{N}C{k}` ways
- Then for each student there are 2 possibilities:
  1. Student is included/selected from group
  2. Student is excluded/rejected from group
- Let out of these `N` students there exists a student `X` which will either be included/excluded in the group of those `k` students
- If you **include** student `X` in the group then you have total `N-1` students left and you have to select the remaining `k-1` students, which can be done in `{N-1}C{k-1}` ways
- If you **exclude** student `X` then you have total `N-1` students left and you still have to select `k` students which can be done in `{N-1}C{k}` ways
- So the total number of ways of selecting `k` students out of `N` students is equal to `{N-1}C{k} + {N-1}C{k-1}`

#### Finding Total Number of Combinations

- Multiply (`*`) the number of combinations of each unique subset together to find result

#### Code

##### Iterative Pascal's Triangle

```cpp
// long long mod = 1e9 + 7;
long long mod = 1'000'000'007;
std::vector<std::vector<long long>> pascal;

void createPascalsTriangle(int n) {
  // Pascal triangle
  this->pascal.resize(n + 1);
  for (int i = 0; i < n + 1; i++) {
    // Make column length 1 more than row number (i.e. row 0 == 1 column, row 1 == 2 column)
    pascal[i] = std::vector<long long>(i + 1, 1);
    // Outside edge numbers are always 1
    // nCk == (n-1)C(k-1) + (n-1)C(k)
    // nCr == (n-1)C(r-1) + (n-1)C(r)
    for (int j = 1; j < i; j++) {
      pascal[i][j] = (pascal[i - 1][j - 1] + pascal[i - 1][j]) % mod;
    }
  }
}
```

```java
long mod = 1_000_000_007;
long[][] pascal;

void createPascalsTriangle(int n) {
  // Pascal triangle
  this.pascal = new long[n + 1][];
  for (int i = 0; i < n + 1; i++) {
    // Make column length 1 more than row number (i.e. row 0 == 1 column, row 1 == 2 column)
    pascal[i] = new long[i + 1];
    Arrays.fill(pascal[i], 1);
    // Outside edge numbers are always 1
    // nCk == (n-1)C(k-1) + (n-1)C(k)
    // nCr == (n-1)C(r-1) + (n-1)C(r)
    for (int j = 1; j < i; j++) {
      pascal[i][j] = (pascal[i - 1][j - 1] + pascal[i - 1][j]) % mod;
    }
  }
}
```

##### Recursive nCr()/nCk()

```cpp
std::map<std::pair<int, int>, int> nCrMemo;
// nCr function with memoization
int nCr(int n, int k) {
  if (nCrMemo.find({n, k}) != nCrMemo.end()) {
    return nCrMemo[{n, k}];
  }
  if (k > n) {
    return nCrMemo[{n, k}] = 0;
  }
  if (k == 0 || k == n) {
    return nCrMemo[{n, k}] = 1;
  }
  // nCr = (n-1)C(r-1) + (n-1)C(r)
  return nCrMemo[{n, k}] = (nCr(n - 1, k - 1) % mod + nCr(n - 1, k) % mod) % mod;
}
```

```cpp
std::unordered_map<std::string, int> nCrMemo;
// nCr function with memoization
int nCr(int n, int k) {
  std::string key = std::to_string(n) + '_' + std::to_string(k);
  if (nCrMemo.find(key) != nCrMemo.end()) {
    return nCrMemo[key];
  }
  if (k > n) {
    return nCrMemo[key] = 0;
  }
  if (k == 0 || k == n) {
    return nCrMemo[key] = 1;
  }
  // nCr = (n-1)C(r-1) + (n-1)C(r)
  return nCrMemo[key] = (nCr(n - 1, k - 1) % mod + nCr(n - 1, k) % mod) % mod;
}
```

```java
Map<List<Integer>, Integer> memo;

int nCr(int n, int k) {
  if (nCrMemo.containsKey(new ArrayList<>(Arrays.asList(n, k)))) {
    return nCrMemo.get(new ArrayList<>(Arrays.asList(n, k)));
  }
  if (k > n) {
    nCrMemo.put(new ArrayList<>(Arrays.asList(n, k)), 0);
    return 0;
  }
  if (k == 0 || k == n) {
    nCrMemo.put(new ArrayList<>(Arrays.asList(n, k)), 1);
    return 1;
  }
  // nCr = (n-1)C(r-1) + (n-1)C(r)
  int result = (nCr(n - 1, k - 1) % mod + nCr(n - 1, k) % mod) % mod;
  nCrMemo.put(new ArrayList<>(Arrays.asList(n, k)), result);
  return result;
}
```

## Digits (Create Number Recursively)

- To build a number recursively (from right to left)
  - Make sure to first convert `num` to a `String` first to be able to bind/bound digits
- See
  - 2801.count-stepping-numbers-in-range
  - 2827.number-of-beautiful-integers-in-the-range

```java
for (int digit = 0; digit < 9; digit++) {
  dfs(currNum * 10 + digit);
}
```

- Start with `currSum = 0`
- For each `dfs()` call:
  - Multiply currSum by 10 and add currValue `currSum = (currSum * 10) + currVal`
- Essentially we shift digits 1 place to the left and add next digit
- Example: 129.sum-root-to-leaf-numbers

```java
class Solution {
  public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
  }

  private int dfs(TreeNode currNode, int currSum) {
    if (currNode == null) {
      return 0;
    }
    // When we go to each child node we shift digits over to the left
    currSum = currSum * 10 + currNode.val;
    if (currNode.left == null && currNode.right == null) {
      return currSum;
    }
    int leftSum = dfs(currNode.left, currSum);
    int rightSum = dfs(currNode.right, currSum);
    return leftSum + rightSum;
  }
}
```

## Exponent

### Rules

```tex
2^n == 2^(n - 1) + 2^(n - 1) == 2 * 2^(n - 1) == 2^(1 + (n - 1)) == 2^n

2^n == 2^(n-1) + 2^(n-1) == 2 * 2^(n-1) == 2^(1 + (n-1)) == 2^n
```

## Factor

- Factors of a number divides the original number evenly
- Example
  - 5 is a factor of 15
  - 8 is a factor of 64

### Euclidean Algorithm

- Euclid's Division Lemma

  - **`a = bq + r (where 0 <= r < b)`**
  - Recursively apply lemma to `b` and `r` until `r = 0` (at which case `b` is gcd of original `a` and `b`)

- Example 1

  - gcd(105, 252)
  - gcd(252, 105)
  - gcd(105, 42)
  - gcd(42, 21)
  - gcd(21, 21)
  - gcd(21, 0)

- Example 2
  - gcd(24, 16) = gcd(16, 24 % 16)
  - gcd(16, 8) = gcd(8, 16 % 8)
  - gcd(8, 0)

Note: Can use `__gcd()` in CPP/C++

```java
class Solution {
  public int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    // % == remainder after division
    return gcd(b, a % b);
  }
}
```

```java
class Solution {
  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
```

### Prime Factorisation Method

- Every composite number (number with more than one factor) can be written as a product of prime numbers

```java
class Solution {
  public static List<Integer> primeFactors(int num) {
    List<Integer> primeFactors = new ArrayList<>();
    int factor = 2;
    while (num > 1) {
      if (num % factor == 0) {
        primeFactors.add(factor);
        num /= factor;
      } else {
        factor++;
      }
    }
    return primeFactors;
  }
}
```

```java
class Solution {
  public Set<Integer> getPrimeFactors(int num) {
    Set<Integer> primeFactors = new HashSet<>();
    int factor = 2;
    while (factor * factor <= num) {
      if (num % factor == 0) {
        primeFactors.add(factor);
        num /= factor;
      } else {
        factor += 1;
      }
    }
    // num is a prime number itself now (i.e. num == 5 in getPrimeFactors(10) == [2, 5])
    primeFactors.add(num);
    return primeFactors;
  }
}
```

### Check if number is a prime number

```java
boolean checkIsPrime(int num) {
  if (num <= 1) {
    return false;
  }
  for (int factor = 2; factor <= Math.sqrt(num); factor++) {
    if (num % factor == 0) {
      return false;
    }
  }
  return true;
}
```

## Logarithm

### Rules

```tex
y = log_a(x) == x = a^(y)
log_b(a) == ln(a)/ln(b) == log_10(a)/log_10(b)
% log_2(x) == ln(x)/ln(2) == log_10(a)/log_10(2)

ln(e) = 1
ln(1) = 0

ln(xy) = ln(x) + ln(y)
ln(x/y) = ln(x) - ln(y)
ln(x^y) = y * ln(x)
ln(e^x) = x
e^(ln(x)) = x
a^(log_a(x)) = x
```

### Closest Power of 2

```java
// log_2(x) == ln(x)/ln(2) == log_10(a)/log_10(2)
int n = 11;

// Method 1
int prevPower = Math.pow(2, Math.floor(Math.log(n)/Math.log(2))); // Closest power of 2 SMALLER than x (<=)
int nextPower = Math.pow(2, Math.ceil(Math.log(n)/Math.log(2))); // Closest power of 2 GREATER than x (>)

// Method 2
int x = (int) (Math.log(n)/Math.log(2));
int prevPower = (int) Math.pow(2, x);
int nextPower = (int) Math.pow(2, x + 1);
```

## `Math.ceil(a/b)` / `std::ceil(a/b)`

- Using `Math.ceil()` or `std::ceil()` on the result of a division does **NOT** work
  - E.g. `(int) Math.ceil(2/3) == 0` due to division between 2 integers always being floored/rounded down
- Solution/Fix:
  - `int ceil = (a / b) + ((a % b == 0) ? 0 : 1);`
  - `int ceil = (a + b - 1) / b;`
  - `int ceil = (a - 1) / (b + 1);`
- Resources
  - [Read more](https://stackoverflow.com/questions/7139382/java-rounding-up-to-an-int-using-math-ceil)

**Invalid/Incorrect**

- The following is invalid/incorrect because we are dividing two integers with each other, which always result in a rounded down integer
- Therefore the `(int) Math.ceil(a / b)` is NOT doing anything

```java
// This does NOT work (INVALID/INCORRECT)
int ceil = Math.ceil(a / b);
```

**Valid**

```java
// Method 1 (discouraged due to loss of precision when using floating point types)
int ceil = (int) Math.ceil((double) a / b);

// Method 2
int ceil = a / b + ((a % b == 0) ? 0 : 1);

// Method 3 (-1 because in case 'b' is an integer multiple of 'a') [use a = 4, b = 2 example. result should be 2 and NOT 3]
int ceil = (a + b - 1) / b; // Note: Does NOT work for b <= 0 (i.e. condition == b > 0)

// Method 4
int ceil = (a - 1) / (b + 1);
```

## Modulus (%)

**Properties**

1. `(a + b) % mod = ((a % mod) + (b % mod)) % mod == ((a % mod) + (b % mod) + mod) % mod`
2. `(a * b) % mod = ((a % mod) * (b % mod)) % mod`
3. `(a — b) % mod = ((a % mod) — (b % mod) + mod) % mod`
   - Note we `+ mod` in case `(a - b)` || `((a % mod) — (b % mod))` is negative (since in some programming languages taking the modulus of a negative number `x` gives a DIFFERENT result to taking modulus of positive number `x`)
     - I.e. In Java `(-10 % 3) == -1` BUT `(10 % 3) == 1`
4. `(a / b) % mod = ((a % mod) * (b^(-1) % mod)) % mod`

- Note that `Math.max(sum1 % mod, sum2 % mod) % mod;` is **NOT** the same as `Math.max(sum1, sum2) % mod;`

  - Correct version is `return (int) Math.max(sum1, sum2) % mod;`
  - Make sure `sum1` and `sum2` are declared as `long` in Java or `long long` in C++ first
  - Example
    - `Math.max(10 % 15, 20 % 15) % 15 == Math.max(10, 5) % 15 == 10 % 15 == 10`
    - `Math.max(10, 20) % 15 == 20 % 15 == 5`

- [Read more](https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/)
- See
  - 2327.number-of-people-aware-of-a-secret
  - 2998.minimum-number-of-operations-to-make-x-and-y-equal
- LeetCode modulus `10^9 + 7`
  - `int mod = 1_000_000_007` (Java)
  - `int mod = 1'000'000'007` (CPP/C++)
  - `int mod = (int) 1e9 + 7`
  - `int mod = (int) Math.pow(10, 9) + 7;` (Java)
  - `int mod = 1000000007`

## Get Digits of Number (Individually)

Gets digits of a number from left to right

```java
class Solution {
  int getDigits(int num) {
    while (num > 0) {
      int digit = num % 10;
      System.out.println(digit);
      num /= 10;
    }
  }
}
```

## Parity (Odd/Even)

### Check if number is ODD

```cpp
// Check if number is odd
int num = 5;

if (num % 2) { // CPP/C++ feature only
  result = 1;
}

if (num % 2 == 1) {
  result = 1;
}

if ((num & 1)) { // CPP/C++ feature only
  result = 1;
}

if ((num & 1) == 1) {

}

int result = (num % 2) ? 1 : 0; // CPP/C++
int result = (num & 1) ? 1 : 0; // CPP/C++

int result = (num % 2 == 1) ? 1 : 0; // Java
int result = (num & 1 == 1) ? 1 : 0; // Java
```

## Probability

- Probability of `a` **AND** `b` == `probability(a) * probability(b)`
- Probability of `a` **OR** `b` == `probability(a) + probability(b)`

## Ranges

# Optimisations

CPP/C++ specific: ALWAYS use REFERENCES `&` in for() loops

## Caching

Look at where you are doing repeated calculations (especially in recursive calls) and see if you can STORE them into an array/hashmap

- E.g. Storing the primeMask for each number beforehand in numsPrimeMask[] (to prevent repeated calculations) in 2572.count-the-number-of-square-free-subsets

# UpperBound - LowerBound (`[0:high] - [0:low]`) to get `[low:high]`

- If finding range of `low = [0:low]` and `high = [0:high]` and then doing `int result = high - low`
  - There is edge case where `low` is valid and NOT counted in `[0:high] - [0:low]`
  - To account for this we either need to redo calculation for `low` or make the `lowerBound = [0:low-1]`
- See
  - 2801.count-stepping-numbers-in-range
  - 2827.number-of-beautiful-integers-in-the-range

## Sequences

### Arithmetic Sequence

#### Sum of AP (Arithmetic Progression)

Formula:

- **`n/2 * (2a + (n-1)d)`**
- **`n/2 * (a + l)`**
  - `a` = First term in the sequence
  - `n` = Number of elements
  - `d` = Common difference between terms
  - `l` = Last term of sequence

Example:

```
First Term = a = 1
Difference = d = 1

Formula
= n/2 * (2*1 + (n-1) * 1)
= n/2 * (2 + n-1)
= n/2 * (n + 1)
= n * (n+1) / 2
```

##### Number of Subarrays

- The formula `N * (N+1) / 2` is used to calculate the number of subarrays that can be formed from an array of length N

- To understand how this formula works, let's first define what a subarray is
  - A subarray is a contiguous sequence of elements from an array
  - For example, if we have an array `[1, 2, 3, 4]`, some of its subarrays are `[1], [1, 2], [2, 3], [1, 2, 3, 4]`, etc
- Now, to calculate the number of subarrays, we can start with a single element from the array and then keep adding one element at a time until we reach the end of the array
  - For example, let's take an array `[1, 2, 3, 4]`
  - If we start with the first element, we can form a subarray `[1]`
    - Then we can add the next element to it and form another subarray `[1, 2]`
    - We can keep adding elements this way and form subarrays `[1, 2, 3]`, `[1, 2, 3, 4]`
  - Now, if we start with the second element, we can form subarrays `[2]`, `[2, 3]`, `[2, 3, 4]`
  - Similarly, if we start with the third element, we can form subarrays `[3]`, `[3, 4]`
  - Finally, if we start with the fourth element, we can form a single subarray `[4]`
  - So, the total number of subarrays that can be formed from an array of length N is the sum of the number of subarrays that start at each element of the array
- If we start with the first element, we can form N subarrays (since we can keep adding one element at a time until we reach the end)

  - If we start with the second element, we can form N-1 subarrays (since we can add elements until the end of the array)
  - Similarly, if we start with the third element, we can form N-2 subarrays, and so on

- Therefore, the total number of subarrays is: `N + (N-1) + (N-2) + ... + 1`

  - This is an arithmetic sequence with N terms and a common difference of -1
  - Or an arithmetic sequence with N terms and a common difference of 1 (if you reverse it)
  - We can use the formula for the sum of an arithmetic sequence to simplify this expression:
    - `sum = (N/2) * (2*N + (N-1)* -1)`
    - `    = (N/2) * (2N - N + 1)`
    - `    = (N/2) * (N+1)`

### Geometric Sequence

#### Sum of GP (Geometric Progression)

Formula:

- **`(a(1 - r^n))/(1 - r)`** (if r < 1)
- **`(a(r^n - 1))/(r - 1)`** (if r > 1)

### Greatest Common Divisor (GCD)

- The greatest common divisor (GCD) of two or more numbers is the greatest common factor number that divides them, exactly
  - Also known as highest common factor (HCF)
- Example
  - gcd(10, 15) = 5
  - gcd(4, 8, 16) = 4
- Resources
  - [Link 1](https://byjus.com/maths/greatest-common-divisor/)

# Number of Unique Combinations/Subsets Possible

- To combine the number of unique combinations/subsets

```cpp
// n == number of elements in subset
long findNumCombinationsInSubset(int n) {
  long[] dp = new long[n + 1];
  dp[0] = 0; // dp[0] = 1 (IFF the empty subset counts as a valid combination)
  dp[1] = 1; // dp[1] = 2 (IFF the empty subset counts as a valid combination)
  for (int i = 2; i <= n; i++) {
    // Include/Exclude currNum with prev combination
    dp[i] = dp[i - 1] + dp[i - 2];
  }
  return dp[n];
}
```

# Prefix Sum

- Note that `prefixSum[i]` == sum of indices BEFORE index i

| index     | 0   | 1   | 2   | 3   | 4   | 5   |
| --------- | --- | --- | --- | --- | --- | --- |
| nums      | 1   | 2   | 3   | 4   | 5   |     |
| prefixSum | 0   | 1   | 3   | 6   | 10  | 15  |

- Version 1

```java
for (int i = 0; i < n; i++) {
  prefixSum[i + 1] = prefixSum[i] + nums[i];
}
```

- Version 2

```java
for (int i = 1; i <= n; i++) {
  prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
}
```

- Get Sum Between Indices i...j (inclusive)

```java
int sum = prefixSum[j + 1] - prefixSum[i];
```

- For C++ can use `std::partial_sum` algorithm

```cpp
int n = nums.size()
std::vector<int> prefixSum(n + 1, 0);
std::partial_sum(std::begin(nums), std::end(nums), std::begin(prefixSum) + 1);
```

## Left Prefix Sum + Right Prefix Sum + Bottom Up DP

- There are two main variations when comparing from **left** and **right**

### Version 1 - `dp[n+1]`

- Store minimum cost to reach index `i` from **LEFT**
  - From `[0 -> n-1]` inclusive
- Store minimum cost to reach index `i` from **RIGHT**
  - From `[n-1 -> 0]` inclusive
- Examine minimum cost to reach index `i` from **BOTH** **LEFT** and **RIGHT**
- In the `leftDP` and `rightDP` we should match the columns vertically
  - Each `leftDP[i]` matches with `rightDP[i]`
  ```
  string  = "1101001"
  leftDP  = 0 1 2 2 4 4 4
  rightDP = 7 5 3 3 1 1 1
  ```
- Finding final result
  ```java
  for (int i = 0; i < n; i++) {
    result = Math.min(result, leftDP[i] + rightDP[i]);
  }
  ```

### Version 2 - `dp[n+2]`

- Store minimum cost to reach index `i` from LEFT
  - From `[1 -> n]` inclusive
- Store minimum cost to reach index `i` from RIGHT
  - From `[n -> 1]` inclusive
- In the `leftDP` and `rightDP` we should match the columns diagonally (like **`\`** and NOT `/`)
  - Each `leftDP[i]` matches with `rightDP[i + 1]`
  ```
  string  = "1101001"
  leftDP  = 0 1 2 2 4 4 4 6 0
  rightDP = 0 7 5 3 3 1 1 1 0
  ```
- Finding final result

  ```java
  for (int i = 1; i <= n; i++) {
    result = Math.min(result, leftDP[i] + rightDP[i + 1]);
  }
  ```

- Examples
  - 2167.minimum-time-to-remove-all-cars-containing-illegal-goods

# Random Trivial Knowledge

## Comparisons

- If there are `n` comparisons, then there will be `n+1` elements involved (see 978.longest-turbulent-subarray)

# Sliding Window

- Use
  - Two pointers (`left`, `right`)
  - `deque`

# String

## Characters

- Convert characters to integer/int index with `int index = str.charAt(0) - 'a';`

## Java

- Compare strings with **`.equals()`** and NOT `==`
- Convert `String` to `char[]` with `.toCharArray()`
- Convert `String` to `String[]` with `.split()`

## Substrings + Palindrome

- To split a string into k substrings (sub_1, sub_2, ..., sub_k) that are palindromic the following formula is used
  - `sub_i == sub_k - i + 1`
    - Note: There are NO brackets here, it is `k - 1 + 1` as is
    - Note: This is mainly just fancy notation and it was purposely decided that substrings should start at index 1
- Read more:
  - 1147.longest-chunked-palindrome-decomposition

# Sliding Window

- If using a sliding window on a string of length `n` to find substrings of length `substrLength`
  - I.e. Finding substrings of length 2 from string `|h|e|l|l|o|w|o|r|l|d||`
- Formula for for loop:
  - `for (int i = 0; i <= n - substrLength)`
  - `for (int i = 0; i < n - substrLength + 1)`

```java
for (int i = 0; i < n - substrLength + 1; i++) {
  String tmp = s.substring(i, i + substrLength);
  //...
}
```

## Array Indexing for Single Pass Forwards + Backwards

- Use `n - i - 1` for right to left/backwards/reverse

```java
for (int i = 1; i < n; i++) {
  // Prefix
  if (s[i] != s[i - 1]) {
    prefix[i] = i + prefix[i - 1];
  } else {
    prefix[i] = prefix[i - 1];
  }
  // Suffix
  if (s[n - i - 1] != s[n - i]) {
    suffix[n - i - 1] = i + suffix[n - i];
  } else {
    suffix[n - i - 1] = suffix[n - i];
  }
}
```

## Longest Palindromic Substring / Longest Common Subsequence

- Bottom Up DP
  - Method 1
    - Don't ask why formula is like this (switching `i` to start at 0 does NOT work)
    - `for (int i = s.length() - 1; i >= 0; i--)`
      - `for(int j = i; j < n; j++)`
  - Method 2
    - Reverse string `s` and compare `s` with reversed string

```java
// Method 1
public int longestPalindromicSubseq(String s) {
  int n = s.length();
  int[][] dp = new int[n][n];

  for (int i = n - 1; i >= 0; i--) {
    dp[i][i] = 1;
    for (int j = i + 1; j < n; j++) {
      // s[i] == s[j] so result = 2 + longest palindrome from characters in-between characters i and j
      if (s.charAt(i) == s.charAt(j)) {
        dp[i][j] = dp[i + 1][j - 1] + 2;
      // s.charAt(i) != s.charAt(j) so find longest palindrome excluding i or excluding j
      } else {
        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
      }
    }
  }

  return dp[0][n - 1];
}
```

```java
// Method 2
public int longestPalindromicSubseq(String s) {
  String r = new StringBuilder(s).reverse().toString();
  int n = s.length();
  int[][] dp = new int[n + 1][n + 1];
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      dp[i][j] = s.charAt(i - 1) == r.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
    }
  }
  return dp[n][n];
}
```

```java
// Build longestPalindromicSubseq DP for all ranges of indices of string "s"
public int[][] getLongestPalindromicSubseqDP(String s) {
  int n = s.length();
  int[][] dp = new int[n][n];
  for (int i = n - 1; i >= 0; i--) {
    for (int j = i; j < n; j++) {
      int len = j - i + 1;
      if (len == 1) {
        dp[i][j] = true;
      } else if (len == 2) {
        dp[i][j] = (s.charAt(i) == s.charAt(j));
      } else {
        dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1]);
      }
    }
  }
  return dp;
}
```

# Time Complexity

- Trick
  - Look at the dimensions/size of `memo` and multiply them together (i.e. `int[][] memo = new int[m][n] == O(M * N)`)
  - Have a look `for()` loops in each recursive `dp()` call/function
- Memoisation
  - Example
    - `auto dp = [](int i, char left, char right) { ... }`
    - If there are 2 choices at each index in a `dp()` call, time complexity would be `O(2^N)` WITHOUT memoisation
    - WITH memoisation the time complexity is reduced to `O(N * 26 * 26);`
- `O(N^2)`
  - Fill up `memo[N][N]`
  - Double `for()` loop
- `O(2^N)`
  - For each of the `N` elements in `nums[]` we have 2 choices (which is typically skip or include `nums[i]`)
- String
  - In a given string `S` of length `N`, there are `N` possible substrings of length 1, `N-1` possible substrings of length 2, `N-2` possible substrings of length 3, and so on, down to 1 possible substring of length `N`
  - Therefore, the total number of possible substrings of a string `S` is: `N + (N-1) + (N-2) + ... + 1 = N * (N+1)/2 = O(N^2)`

## Dynamic Programming Time Complexity

- Can figure out time complexity by looking at size of `memo` (because we need to fill `memo` up)
- **HOWEVER** need to analyse time complexity of **EACH** dp state/recursive `dp()` call
  - **EDGE/EXCEPTION CASE**
    - Say for example `memo[][]` is of size `N * K`
      - N = nums.length
      - K = numPartitionsAllowed
    - In each recursive `dp(i, k)` call / each dp state, if we need to iterate over ALL of nums which costs `O(N)`
      - `for(int j = i; j < nums.length; j++)`
    - Then time complexity is actually `O(N * K * N)` = `O(N^2 * K)`
    - See 1959.minimum-total-space-wasted-with-k-resizing-operations

# TreeMap

- `treeMap.firstEntry()`
- `treeMap.lastEntry()`

- `>=` and `<=`
  - `treeMap.ceilingEntry(key)`
  - `treeMap.floorEntry(key)`
- `>` and `<`

  - `treeMap.higherEntry(key)`
  - `treeMap.lowerEntry(key)`

- See 2008.maximum-earnings-from-taxi

# TreeSet

- `import java.util.TreeSet;`
- Use TreeSet to get an **ordered/sorted set** to iterate over
  ```java
  TreeSet<Integer> treeSet = new TreeSet<>((a, b) -> Integer.compare(a, b));
  treeSet.add(5);
  treeSet.add(10);
  treeSet.add(4);
  treeSet.add(2);
  treeSet.add(6);
  for (int num : treeSet) {
    //...
  }
  ```

# Union Find

## Path Compression

- Flattens the structure of the nodes in the hierarchy and links each node directly to the final root
- Only in the first run of find will you traverse the whole structure
- The next time you'll get a direct hit since you set the node's parent to its ultimate root
- Do NOT use Path Compression if you want to analyse the parent chain of each child to ensure that a certain condition is met
  - See 1724.checking-existence-of-edge-length-limited-paths-ii

## Union by Rank

- Makes sure that the node with more children becomes the root of the node with less children
- Therefore, less nodes need to be reassigned a new parent, hence less work

## Formula to convert matrix cell coordinate (i, j) to index number

- This function converts a cell of a matrix/grid (of size `m * n`) to an index/number
- Note the indices start from `0` and go to `(m * n) - 1` (left to right, top to bottom)
- Note
  - `m = grid.length`
  - `n = grid[0].length`
  - We need to use **`n`** (i.e. number of columns) to ensure formula works with non-square matrix/grids (where `grid.length != grid[0].length`)

```java
int cellToIndex(int i, int j) {
  return i * n + j;
}

int cellToIndex(int x, int y) {
  return x * n + y;
}
```

## Handling Strings

- Use a counter variable `index` and `HashMap` to associate each string (key) to an index (value)
- Union the mapped indices of strings
- Examples
  - 721.accounts-merge
  - 737.sentence-similarity

## Connected Components

- Use `boolean union()` version and check boolean result of calling `uf.union(i, j)`
- Example
  - 947.most-stones-removed-with-same-row-or-column
    - Interesting case of `return stones.length - numSeparateComponents`
    - Note how we can remove all nodes of a connected component except for the LAST stone of each separate connected component (since it does not share any coordinates with other stones)
