# Table of Contents

- [Table of Contents](#table-of-contents)
- [Set Up](#set-up)
- [OA Prep Notes](#oa-prep-notes)
  - [Data Structures](#data-structures)
  - [Pitfalls](#pitfalls)
- [LeetCode Patterns](#leetcode-patterns)

# Set Up

- On your laptop have
  - **Google Chrome** open with:
    - [ChatGPT](https://chat.openai.com/)
    - [lc-notes.md](https://github.com/samsolichin/notes/blob/master/coding/leetcode/lc-notes.md)
    - [cpp-vs-java.md](https://github.com/samsolichin/notes/blob/master/coding/cpp-vs-java.md)
    - [java-reference.md](https://github.com/samsolichin/notes/blob/master/coding/java/java-reference.md)
    - [LeetCode](https://leetcode.com/problemset/all/)
  - **VSCode** open with:
    - "github" folder set as workspace folder
      - `cd github && code .`
- On PC
  - Turn off ALL chrome extensions
  - Eject USB
  - Quit Discord
  - Have VSCode open with blank workspace (use new tabs to save progress for each question)

# OA Prep Notes

- Review "LeetCode Patterns"
- Make sure to **READ** question properly and slowly **BEFORE** you start coding (will save you a lot of time if you write up the wrong code and need to rewrite)
- Watch out for **TRICK** questions that appear more complicated than it actually is **Keep It Simple Stupid (KISS)**
- If given "inequality" as rule/condition (i.e. `<`, `<=`, `>=`, `>`) try to **REARRANGE** the inequalities to see if can find easier comparison (i.e. move values across to one side)
- If given "list"/"array" try to **SORT** in ascending/descending order if possible
- If asked to find "maximum"/"minimum" try to **FLIP** the question and find the opposite instead
  - E.g. 2925.maximum-score-after-applying-operations-on-a-tree
- Make sure to handle edge cases
  - Empty list
  - Empty string `''`
  - Integer overflow/underflow (use `long` instead)
  - Negative values
  - `null` values
- Have you properly initialised default values of your data structure
- `HashMap` + `Set` will be enough for MOST cases

## Data Structures

See Collections diagram in `java-reference.md`

- **Map**
  - HashMap
  - TreeMap
- **List**
  - ArrayList
  - LinkedList
  - Stack
- **Queue**
  - PriorityQueue
  - Deque
- **Set**
  - HashSet
  - TreeSet

## Pitfalls

- Make sure to use `long` when performing addition/multiplication on large numbers and to cast to given numbers to long e.g. `if ((long) (currSum * nums[i]) <= (long) k) `
- Watch out for Integer overflow
- Are you able to **sort** the given array/list?

# LeetCode Patterns

- If input array/list is NOT sorted:

  - Check if you can SORT it

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
