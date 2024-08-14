# Table of Contents

- [Table of Contents](#table-of-contents)
- [Two Pointers](#two-pointers)
  - [One Input, Opposite Ends](#one-input-opposite-ends)
  - [Two Inputs, Exhaust Both](#two-inputs-exhaust-both)
- [Sliding Window](#sliding-window)
- [Prefix Sum (Construction/Build)](#prefix-sum-constructionbuild)
- [Char to String (Construction/Build)](#char-to-string-constructionbuild)
- [Linked List](#linked-list)
  - [Fast and Slow Pointer](#fast-and-slow-pointer)
  - [Reversing Linked List](#reversing-linked-list)
- [Find Number Of Subarrays That Fit Criteria](#find-number-of-subarrays-that-fit-criteria)
- [Monotonic Increasing Stack](#monotonic-increasing-stack)
- [Binary Search Tree (BST)](#binary-search-tree-bst)
  - [DFS (Recursive)](#dfs-recursive)
  - [DFS (Iterative)](#dfs-iterative)
  - [BFS](#bfs)
- [Graph](#graph)
  - [DFS (Recursive)](#dfs-recursive-1)
  - [DFS (Iterative)](#dfs-iterative-1)
  - [BFS](#bfs-1)
- [Heap/Priority Queue](#heappriority-queue)
  - [Find Top K Elements](#find-top-k-elements)
- [Binary Search](#binary-search)
  - [Non-Duplicate Elements](#non-duplicate-elements)
  - [Duplicate Elements (Left-Most Insertion Point)](#duplicate-elements-left-most-insertion-point)
  - [Duplicate Elements (Right-Most Insertion Point)](#duplicate-elements-right-most-insertion-point)
  - [Greedy Problems](#greedy-problems)
    - [Find LOWER Bound / Minimum](#find-lower-bound--minimum)
    - [Find UPPER Bound / Maximum](#find-upper-bound--maximum)
- [Backtracking](#backtracking)
- [Dynamic Programming](#dynamic-programming)
  - [Top-Down Memoisation](#top-down-memoisation)
- [Trie (Construction/Build)](#trie-constructionbuild)
- [Dijkstra's Algorithm](#dijkstras-algorithm)

# Two Pointers

## One Input, Opposite Ends

```cpp
int twoPointer(std::vector<int> &arr) {
  int left = 0;
  int right = int(arr.size()) - 1;
  int result = 0;

  while (left < right) {
    // do some logic here with left and right
    if (CONDITION) {
      left++;
    } else {
      right--;
    }
  }

  return result;
}
```

```java
public int twoPointer(int[] arr) {
  int left = 0;
  int right = arr.length - 1;
  int result = 0;

  while (left < right) {
    // do some logic here with left and right
    if (CONDITION) {
      left++;
    } else {
      right--;
    }
  }

  return result;
}
```

```js
let twoPointer = (arr) => {
  let left = 0,
    result = 0,
    right = arr.length - 1;

  while (left < right) {
    // do some logic here with left and right
    if (CONDITION) {
      left++;
    } else {
      right--;
    }
  }

  return result;
};
```

```py
def twoPointer(arr):
  left = result = 0
  right = len(arr) - 1

  while left < right:
    # do some logic here with left and right
    if CONDITION:
      left += 1
    else:
      right -= 1

  return result
```

## Two Inputs, Exhaust Both

```cpp
int twoPointer(std::vector<int> &arr1, std::vector<int> &arr2) {
  int i = 0, j = 0, result = 0;

  while (i < arr1.size() && j < arr2.size()) {
    // do some logic here
    if (CONDITION) {
      i++;
    } else {
      j++;
    }
  }

  while (i < arr1.size()) {
    // do logic
    i++;
  }

  while (j < arr2.size()) {
    // do logic
    j++;
  }

  return result;
}
```

```java
public int twoPointer(int[] arr1, int[] arr2) {
  int i = 0, j = 0, result = 0;

  while (i < arr1.length && j < arr2.length) {
    // do some logic here
    if (CONDITION) {
      i++;
    } else {
      j++;
    }
  }

  while (i < arr1.length) {
    // do logic
    i++;
  }

  while (j < arr2.length) {
    // do logic
    j++;
  }

  return result;
}
```

```js
let twoPointer = (arr1, arr2) => {
  let i = 0,
    j = 0,
    result = 0;

  while (i < arr1.length && j < arr2.length) {
    // do some logic here
    if (CONDITION) {
      i++;
    } else {
      j++;
    }
  }

  while (i < arr1.length) {
    // do logic
    i++;
  }

  while (j < arr2.length) {
    // do logic
    j++;
  }

  return result;
};
```

```py
def twoPointer(arr1, arr2):
  i = j = result = 0

  while i < len(arr1) and j < len(arr2):
    # do some logic here
    if CONDITION:
      i += 1
    else:
      j += 1

  while i < len(arr1):
    # do logic
    i += 1

  while j < len(arr2):
    # do logic
    j += 1

  return result
```

# Sliding Window

```cpp
int slidingWindow(std::vector<int> &arr) {
  int left = 0, result = 0, curr = 0;

  for (int right = 0; right < arr.size(); right++) {
    // do logic here to add arr[right] to curr

    while (WINDOW_CONDITION_BROKEN) {
      // remove arr[left] from curr
      left++;
    }

    // update result
  }

  return result;
}
```

```java
public int slidingWindow(int[] arr) {
  int left = 0, result = 0, curr = 0;

  for (int right = 0; right < arr.length; right++) {
    // do logic here to add arr[right] to curr

    while (WINDOW_CONDITION_BROKEN) {
      // remove arr[left] from curr
      left++;
    }

    // update result
  }

  return result;
}
```

```js
let slidingWindow = (arr) => {
  let left = 0;
  let result = 0;
  let curr = 0;

  for (let right = 0; right < arr.length; right++) {
    // do logic here to add arr[right] to curr

    while (WINDOW_CONDITION_BROKEN) {
      // remove arr[left] from curr
      left++;
    }

    // update result
  }

  return result;
};
```

```py
def slidingWindow(arr):
  left = result = curr = 0

  for right in range(len(arr)):
    # do logic here to add arr[right] to curr

    while WINDOW_CONDITION_BROKEN:
      # remove arr[left] from curr
      left += 1

    # update result

  return result
```

# Prefix Sum (Construction/Build)

```cpp
std::vector<int> buildPrefixSum(std::vector<int> &arr) {
  std::vector<int> prefix(arr.size());
  prefix[0] = arr[0];

  for (int i = 1; i < arr.size(); i++) {
    prefix[i] = prefix[i - 1] + arr[i];
  }

  return prefix;
}
```

```java
public int[] buildPrefixSum(int[] arr) {
  int[] prefix = new int[arr.length];
  prefix[0] = arr[0];

  for (int i = 1; i < arr.length; i++) {
    prefix[i] = prefix[i - 1] + arr[i];
  }

  return prefix;
}
```

```js
let buildPrefixSum = (arr) => {
  let prefix = [arr[0]];
  for (let i = 1; i < arr.length; i++) {
    prefix.push(prefix[prefix.length - 1] + arr[i]);
  }

  return prefix;
};
```

```py
def buildPrefixSum(arr):
  prefix = [arr[0]]
  for i in range(1, len(arr)):
    prefix.append(prefix[-1] + arr[i])

  return prefix
```

# Char to String (Construction/Build)

```cpp
std::string charToString(std::vector<char> &arr) {
  return std::string(arr.begin(), arr.end())
}
```

```java
public String charToString(char[] arr) {
  StringBuilder sb = new StringBuilder();
  for (char c : arr) {
    sb.append(c);
  }

  return sb.toString();
}
```

```js
// arr is a list of characters
let charToString = (arr) => {
  let result = [];
  for (const c of arr) {
    result.push(c);
  }

  return result.join('');
};

// Benchmarking shows that concatenation with += is faster than using .join().
let charToString = (arr) => {
  let result = '';
  for (const c of arr) {
    result += c;
  }

  return result;
};
```

```py
# arr is a list of characters
def charToString(arr):
  result = []
  for c in arr:
    result.append(c)

  return "".join(result)
```

# Linked List

## Fast and Slow Pointer

```cpp
int llFastSlowPointer(ListNode *head) {
  ListNode *slow = head;
  ListNode *fast = head;
  int result = 0;

  while (fast != nullptr && fast->next != nullptr) {
    // do logic
    slow = slow->next;
    fast = fast->next->next;
  }

  return result;
}
```

```java
public int llFastSlowPointer(ListNode head) {
  ListNode slow = head;
  ListNode fast = head;
  int result = 0;

  while (fast != null && fast.next != null) {
    // do logic
    slow = slow.next;
    fast = fast.next.next;
  }

  return result;
}
```

```js
let llFastSlowPointer = (head) => {
  let slow = head;
  let fast = head;
  let result = 0;

  while (fast && fast.next) {
    // do logic
    slow = slow.next;
    fast = fast.next.next;
  }

  return result;
};
```

```py
def llFastSlowPointer(head):
  slow = head
  fast = head
  result = 0

  while fast and fast.next:
    # do logic
    slow = slow.next
    fast = fast.next.next

  return result
```

## Reversing Linked List

```cpp
ListNode *reverseLL(ListNode *head) {
  ListNode *curr = head;
  ListNode *prev = nullptr;
  while (curr != nullptr) {
    ListNode *nextNode = curr->next;
    curr->next = prev;
    prev = curr;
    curr = nextNode;
  }

  return prev;
}
```

```java
public ListNode reverseLL(ListNode head) {
  ListNode curr = head;
  ListNode prev = null;
  while (curr != null) {
    ListNode nextNode = curr.next;
    curr.next = prev;
    prev = curr;
    curr = nextNode;
  }

  return prev;
}
```

```js
let reverseLL = (head) => {
  let curr = head;
  let prev = null;
  while (curr) {
    let nextNode = curr.next;
    curr.next = prev;
    prev = curr;
    curr = nextNode;
  }

  return prev;
};
```

```py
def reverseLL(head):
  curr = head
  prev = None
  while curr:
    next_node = curr.next
    curr.next = prev
    prev = curr
    curr = next_node

  return prev
```

# Find Number Of Subarrays That Fit Criteria

```cpp
int numSubArrays(std::vector<int> &arr, int k) {
  std::unordered_map<int, int> countMap;
  countMap[0] = 1;
  int result = 0, curr = 0;

  for (int num : arr) {
    // do logic to change curr
    result += countMap[curr - k];
    countMap[curr]++;
  }

  return result;
}
```

```java
public int numSubArrays(int[] arr, int k) {
  Map<Integer, Integer> countMap = new HashMap<>();
  countMap.put(0, 1);
  int result = 0, curr = 0;

  for (int num : arr) {
    // do logic to change curr
    result += countMap.getOrDefault(curr - k, 0);
    countMap.put(curr, countMap.getOrDefault(curr, 0) + 1);
  }

  return result;
}
```

```js
let numSubArrays = (arr, k) => {
  let countMap = new Map();
  countMap.set(0, 1);
  let result = 0,
    curr = 0;

  for (const num of arr) {
    // do logic to change curr
    result += countMap.get(curr - k) || 0;
    countMap.set(curr, (countMap.get(curr) || 0) + 1);
  }

  return result;
};
```

```py
from collections import defaultdict

def numSubArrays(arr, k):
  countMap = defaultdict(int)
  countMap[0] = 1
  result = curr = 0

  for num in arr:
    # do logic to change curr
    result += countMap[curr - k]
    countMap[curr] += 1

  return result
```

# Monotonic Increasing Stack

```cpp
int monotonicStack(std::vector<int> &arr) {
  stack<integer> stack;
  int result = 0;

  for (int num : arr) {
    // for monotonic decreasing, just flip the > to <
    while (!stack.empty() && stack.top() > num) {
      // do logic
      stack.pop();
    }

    stack.push(num);
  }
}
```

```java
public int monotonicStack(int[] arr) {
  Stack<Integer> stack = new Stack<>();
  int result = 0;

  for (int num : arr) {
    // for monotonic decreasing, just flip the > to <
    while (!stack.empty() && stack.peek() > num) {
      // do logic
      stack.pop();
    }

    stack.push(num);
  }

  return result;
}
```

```js
let monotonicStack = (arr) => {
  let stack = [];
  let result = 0;

  for (const num of arr) {
    // for monotonic decreasing, just flip the > to <
    while (stack.length && stack[stack.length - 1] > num) {
      // do logic
      stack.pop();
    }

    stack.push(num);
  }

  return result;
};
```

```py
def monotonicStack(arr):
  stack = []
  result = 0

  for num in arr:
    # for monotonic decreasing, just flip the > to <
    while stack and stack[-1] > num:
      # do logic
      stack.pop()
    stack.append(num)

  return result
```

# Binary Search Tree (BST)

## DFS (Recursive)

```cpp
int dfs(TreeNode *root) {
  if (root == nullptr) {
    return 0;
  }

  int result = 0;
  // do logic
  dfs(root.left);
  dfs(root.right);
  return result;
}
```

```java
public int dfs(TreeNode root) {
  if (root == null) {
    return 0;
  }

  int result = 0;
  // do logic
  dfs(root.left);
  dfs(root.right);
  return result;
}
```

```js
let dfs = (root) => {
  if (!root) {
    return;
  }

  let result = 0;

  // do logic
  dfs(root.left);
  dfs(root.right);
  return result;
};
```

```py
def dfs(root):
  if not root:
    return

  result = 0

  # do logic
  dfs(root.left)
  dfs(root.right)
  return result
```

## DFS (Iterative)

```cpp
int dfs(TreeNode *root) {
  stack<TreeNode *> stack;
  stack.push(root);
  int result = 0;

  while (!stack.empty()) {
    TreeNode *node = stack.top();
    stack.pop();
    // do logic
    if (node->left != nullptr) {
      stack.push(node->left);
    }
    if (node->right != nullptr) {
      stack.push(node->right);
    }
  }

  return result;
}
```

```java
public int dfs(TreeNode root) {
  Stack<TreeNode> stack = new Stack<>();
  stack.push(root);
  int result = 0;

  while (!stack.empty()) {
    TreeNode node = stack.pop();
    // do logic
    if (node.left != null) {
      stack.push(node.left);
    }
    if (node.right != null) {
      stack.push(node.right);
    }
  }

  return result;
}
```

```js
let dfs = (root) => {
  let stack = [root];
  let result = 0;

  while (stack.length) {
    let node = stack.pop();
    // do logic
    if (node.left) {
      stack.push(node.left);
    }
    if (node.right) {
      stack.push(node.right);
    }
  }

  return result;
};
```

```py
def dfs(root):
  stack = [root]
  result = 0

  while stack:
    node = stack.pop()
    # do logic
    if node.left:
      stack.append(node.left)
    if node.right:
      stack.append(node.right)

  return result
```

## BFS

```cpp
int bfs(TreeNode *root) {
  queue<TreeNode *> queue;
  queue.push(root);
  int result = 0;

  while (!queue.empty()) {
    int currentLength = queue.size();
    // do logic for current level

    for (int i = 0; i < currentLength; i++) {
      TreeNode *node = queue.front();
      queue.pop();
      // do logic
      if (node->left != nullptr) {
        queue.push(node->left);
      }
      if (node->right != nullptr) {
        queue.push(node->right);
      }
    }
  }

  return result;
}
```

```java
public int bfs(TreeNode root) {
  Queue<TreeNode> queue = new LinkedList<>();
  queue.add(root);
  int result = 0;

  while (!queue.isEmpty()) {
    int currentLength = queue.size();
    // do logic for current level

    for (int i = 0; i < currentLength; i++) {
      TreeNode node = queue.remove();
      // do logic
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
  }

  return result;
}
```

```js
let bfs = (root) => {
  let queue = [root];
  let result = 0;

  while (queue.length) {
    let currentLength = queue.length;
    // do logic for current level

    let nextQueue = [];

    for (let i = 0; i < currentLength; i++) {
      let node = queue[i];
      // do logic
      if (node.left) {
        nextQueue.push(node.left);
      }
      if (node.right) {
        nextQueue.push(node.right);
      }
    }

    queue = nextQueue;
  }

  return result;
};
```

```py
from collections import deque

def bfs(root):
  queue = deque([root])
  result = 0

  while queue:
    current_length = len(queue)
    # do logic for current level

    for _ in range(current_length):
      node = queue.popleft()
      # do logic
      if node.left:
        queue.append(node.left)
      if node.right:
        queue.append(node.right)

  return result
```

# Graph

- For the graph templates, assume the nodes are numbered from `0` to` n - 1` and the graph is given as an adjacency list
- Depending on the problem, you may need to convert the input into an equivalent adjacency list before using the templates

## DFS (Recursive)

```cpp
class Solution {
public:
  unordered_set<int> seen;

  int graphDFSOuter(std::vector<std::vector<int>> &graph) {
    seen.insert(START_NODE);
    return dfs(START_NODE, graph);
  }

  int dfs(int node, std::vector<std::vector<int>> &graph) {
    int result = 0;
    // do some logic
    for (int neighbor : graph[node]) {
      if (seen.find(neighbor) == seen.end()) {
        seen.insert(neighbor);
        result += dfs(neighbor, graph);
      }
    }

    return result;
  }
}
```

```java
class Solution {
  Set<Integer> seen = new HashSet<>();

  public int graphDFSOuter(int[][] graph) {
    seen.add(START_NODE);
    return dfs(START_NODE, graph);
  }

  public int dfs(int node, int[][] graph) {
    int result = 0;
    // do some logic
    for (int neighbor : graph[node]) {
      if (!seen.contains(neighbor)) {
        seen.add(neighbor);
        result += dfs(neighbor, graph);
      }
    }

    return result;
  }
}
```

```js
let graphDFSOuter = (graph) => {
  let dfs = (node) => {
    let result = 0;
    // do some logic
    for (const neighbor of graph[node]) {
      if (!seen.has(neighbor)) {
        seen.add(neighbor);
        result += dfs(neighbor);
      }
    }

    return result;
  };

  let seen = new Set([START_NODE]);
  return dfs(START_NODE);
};
```

```py
def graphDFSOuter(graph):
  def dfs(node):
    result = 0
    # do some logic
    for neighbor in graph[node]:
      if neighbor not in seen:
        seen.add(neighbor)
        result += dfs(neighbor)

    return result

  seen = {START_NODE}
  return dfs(START_NODE)
```

## DFS (Iterative)

```cpp
class Solution {
public:
  int dfsIterative(std::vector<std::vector<int>> &graph) {
    stack<int> stack;
    unordered_set<int> seen;
    stack.push(START_NODE);
    seen.insert(START_NODE);
    int result = 0;

    while (!stack.empty()) {
      int node = stack.top();
      stack.pop();
      // do some logic
      for (int neighbor : graph[node]) {
        if (seen.find(neighbor) == seen.end()) {
          seen.insert(neighbor);
          stack.push(neighbor);
        }
      }
    }
  }
}
```

```java
class Solution {
  public int dfsIterative(int[][] graph) {
    Stack<Integer> stack = new Stack<>();
    Set<Integer> seen = new HashSet<>();
    stack.push(START_NODE);
    seen.add(START_NODE);
    int result = 0;

    while (!stack.empty()) {
      int node = stack.pop();
      // do some logic
      for (int neighbor : graph[node]) {
        if (!seen.contains(neighbor)) {
          seen.add(neighbor);
          stack.push(neighbor);
        }
      }
    }

    return result;
  }
}
```

```js
let dfsIterative = (graph) => {
  let stack = [START_NODE];
  let seen = new Set([START_NODE]);
  let result = 0;

  while (stack.length) {
    let node = stack.pop();
    // do some logic
    for (const neighbor of graph[node]) {
      if (!seen.has(neighbor)) {
        seen.add(neighbor);
        stack.push(neighbor);
      }
    }
  }

  return result;
};
```

```py
def dfsIterative(graph):
  stack = [START_NODE]
  seen = {START_NODE}
  result = 0

  while stack:
    node = stack.pop()
    # do some logic
    for neighbor in graph[node]:
      if neighbor not in seen:
        seen.add(neighbor)
        stack.append(neighbor)

  return result
```

## BFS

```cpp
class Solution {
public:
  int bfs(std::vector<std::vector<int>> &graph) {
    queue<int> queue;
    unordered_set<int> seen;
    queue.add(START_NODE);
    seen.insert(START_NODE);
    int result = 0;

    while (!queue.empty()) {
      int node = queue.front();
      queue.pop();
      // do some logic
      for (int neighbor : graph[node]) {
        if (seen.find(neighbor) == seen.end()) {
          seen.insert(neighbor);
          queue.push(neighbor);
        }
      }
    }
  }
}
```

```java
class Solution {
  public int bfs(int[][] graph) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> seen = new HashSet<>();
    queue.add(START_NODE);
    seen.add(START_NODE);
    int result = 0;

    while (!queue.isEmpty()) {
      int node = queue.remove();
      // do some logic
      for (int neighbor : graph[node]) {
        if (!seen.contains(neighbor)) {
          seen.add(neighbor);
          queue.add(neighbor);
        }
      }
    }

    return result;
  }
}
```

```js
let bfs = (graph) => {
  let queue = [START_NODE];
  let seen = new Set([START_NODE]);
  let result = 0;

  while (queue.length) {
    let currentLength = 0;
    let nextQueue = [];

    for (let i = 0; i < currentLength; i++) {
      let node = queue[i];
      // do some logic
      for (const neighbor of graph[node]) {
        if (!seen.has(neighbor)) {
          seen.add(neighbor);
          nextQueue.push(neighbor);
        }
      }
    }

    queue = nextQueue;
  }

  return result;
};
```

```py
from collections import deque

def bfs(graph):
  queue = deque([START_NODE])
  seen = {START_NODE}
  result = 0

  while queue:
    node = queue.popleft()
    # do some logic
    for neighbor in graph[node]:
      if neighbor not in seen:
        seen.add(neighbor)
        queue.append(neighbor)

  return result
```

# Heap/Priority Queue

## Find Top K Elements

```cpp
std::vector<int> findTopKElements(std::vector<int> &arr, int k) {
  std::priority_queue<int, CUSTOM_COMPARATOR> heap;
  for (int num : arr) {
    heap.push(num);
    if (heap.size() > k) {
      heap.pop();
    }
  }

  std::vector<int> result;
  while (heap.size() > 0) {
    result.push_back(heap.top());
    heap.pop();
  }

  return result;
}
```

```java
public int[] findTopKElements(int[] arr, int k) {
  PriorityQueue<Integer> heap = new PriorityQueue<>(CUSTOM_COMPARATOR);
  for (int num : arr) {
    heap.add(num);
    if (heap.size() > k) {
      heap.remove();
    }
  }

  int[] result = new int[k];
  for (int i = 0; i < k; i++) {
    result[i] = heap.remove();
  }

  return result;
}
```

```js
/*
JavaScript does not have any built in support - it is recommended
that you have another language ready in case you need to use a heap
*/
```

```py
import heapq

def findTopKElements(arr, k):
  heap = []
  for num in arr:
    # do some logic to push onto heap according to problem's criteria
    heapq.heappush(heap, (CUSTOM_COMPARATOR, num))
    if len(heap) > k:
      heapq.heappop(heap)

  return [num for num in heap]
```

# Binary Search

## Non-Duplicate Elements

```cpp
int binarySearch(std::vector<int> &arr, int target) {
  int left = 0;
  int right = int(arr.size()) - 1;
  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) {
      // do something;
      return mid;
    }
    if (arr[mid] > target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  // left is the insertion point
  return left;
}
```

```java
public int binarySearch(int[] arr, int target) {
  int left = 0;
  int right = arr.length - 1;
  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) {
      // do something
      return mid;
    }
    if (arr[mid] > target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  // left is the insertion point
  return left;
}
```

```js
let binarySearch = (arr, target) => {
  let left = 0;
  let right = arr.length - 1;
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] == target) {
      // do something
      return;
    }
    if (arr[mid] > target) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  // left is the insertion point
  return left;
};
```

```py
def binarySearch(arr, target):
  left = 0
  right = len(arr) - 1
  while left <= right:
    mid = (left + right) // 2
    if arr[mid] == target:
      # do something
      return
    if arr[mid] > target:
      right = mid - 1
    else:
      left = mid + 1

  # left is the insertion point
  return left
```

## Duplicate Elements (Left-Most Insertion Point)

```cpp
int binarySearch(std::vector<int> &arr, int target) {
  int left = 0;
  int right = arr.size();
  while (left < right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] >= target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
}
```

```java
public int binarySearch(int[] arr, int target) {
  int left = 0;
  int right = arr.length;
  while (left < right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] >= target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
}
```

```js
let binarySearch = (arr, target) => {
  let left = 0;
  let right = arr.length;
  while (left < right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] >= target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
};
```

```py
def binarySearch(arr, target):
  left = 0
  right = len(arr)
  while left < right:
    mid = (left + right) // 2
    if arr[mid] >= target:
      right = mid
    else:
      left = mid + 1

  return left
```

## Duplicate Elements (Right-Most Insertion Point)

```cpp
int binarySearch(std::vector<int> &arr, int target) {
  int left = 0;
  int right = arr.size();
  while (left < right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] > target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
}
```

```java
public int binarySearch(int[] arr, int target) {
  int left = 0;
  int right = arr.length;
  while (left < right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] > target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
}
```

```js
let binarySearch = (arr, target) => {
  let left = 0;
  let right = arr.length;
  while (left < right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] > target) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
};
```

```py
def binarySearch(arr, target):
  left = 0
  right = len(arr)
  while left < right:
    mid = (left + right) // 2
    if arr[mid] > target:
      right = mid
    else:
      left = mid + 1

  return left
```

## Greedy Problems

### Find LOWER Bound / Minimum

```cpp
int binarySearchForMin(std::vector<int> &arr) {
  int left = MINIMUM_POSSIBLE_VALUE;
  int right = MAXIMUM_POSSIBLE_VALUE;
  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (check(mid)) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return left;
}

bool check(int x) {
  // this function is implemented depending on the problem
  return BOOLEAN;
}
```

```java
public int binarySearchForMin(int[] arr) {
  int left = MINIMUM_POSSIBLE_VALUE;
  int right = MAXIMUM_POSSIBLE_VALUE;
  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (check(mid)) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return left;
}

public boolean check(int x) {
  // this function is implemented depending on the problem
  return BOOLEAN;
}
```

```js
let binarySearchForMin = (arr) => {
  let check = (x) => {
    // this function is implemented depending on the problem
    return BOOLEAN;
  };

  let left = MINIMUM_POSSIBLE_VALUE;
  let right = MAXMIMUM_POSSIBLE_ANSWER;
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (check(mid)) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  return left;
};
```

```py
def binarySearchForMin(arr):
  def check(x):
    # this function is implemented depending on the problem
    return BOOLEAN

  left = MINIMUM_POSSIBLE_VALUE
  right = MAXIMUM_POSSIBLE_VALUE
  while left <= right:
    mid = (left + right) // 2
    if check(mid):
      right = mid - 1
    else:
      left = mid + 1

  return left
```

### Find UPPER Bound / Maximum

```cpp
int binarySearchForMax(std::vector<int> &arr) {
  int left = MINIMUM_POSSIBLE_VALUE;
  int right = MAXIMUM_POSSIBLE_VALUE;
  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (check(mid)) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return right;
}

bool check(int x) {
  // this function is implemented depending on the problem
  return BOOLEAN;
}
```

```java
public int binarySearchForMax(int[] arr) {
  int left = MINIMUM_POSSIBLE_VALUE;
  int right = MAXIMUM_POSSIBLE_VALUE;
  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (check(mid)) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return right;
}

public boolean check(int x) {
  // this function is implemented depending on the problem
  return BOOLEAN;
}
```

```js
let binarySearchForMax = (arr) => {
  let check = (x) => {
    // this function is implemented depending on the problem
    return BOOLEAN;
  };

  let left = MINIMUM_POSSIBLE_VALUE;
  let right = MAXMIMUM_POSSIBLE_ANSWER;
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (check(mid)) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return right;
};
```

```py
def binarySearchForMax(arr):
  def check(x):
    # this function is implemented depending on the problem
    return BOOLEAN

  left = MINIMUM_POSSIBLE_VALUE
  right = MAXIMUM_POSSIBLE_VALUE
  while left <= right:
    mid = (left + right) // 2
    if check(mid):
      left = mid + 1
    else:
      right = mid - 1

  return right
```

# Backtracking

```cpp
int backtrack(STATE curr, OTHER_ARGUMENTS...) {
  if (BASE_CASE) {
    // modify the answer
    return 0;
  }

  int result = 0;
  for (ITERATE_OVER_INPUT) {
    // modify the current state
    result += backtrack(curr, OTHER_ARGUMENTS...)
    // undo the modification of the current state
  }

  return result;
}
```

```java
public int backtrack(STATE curr, OTHER_ARGUMENTS...) {
  if (BASE_CASE) {
    // modify the answer
    return 0;
  }

  int result = 0;
  for (ITERATE_OVER_INPUT) {
    // modify the current state
    result += backtrack(curr, OTHER_ARGUMENTS...)
    // undo the modification of the current state
  }
}
```

```js
let backtrack = (curr, OTHER_ARGUMENTS...) => {
  if (BASE_CASE) {
    // modify the answer
    return;
  }

  let result = 0;
  for (ITERATE_OVER_INPUT) {
    // modify the current state
    result += backtrack(curr, OTHER_ARGUMENTS...);
    // undo the modification of the current state
  }

  return result;
}
```

```py
def backtrack(curr, OTHER_ARGUMENTS...):
  if (BASE_CASE):
    # modify the answer
    return

  result = 0
  for (ITERATE_OVER_INPUT):
    # modify the current state
    result += backtrack(curr, OTHER_ARGUMENTS...)
    # undo the modification of the current state

  return result
```

# Dynamic Programming

## Top-Down Memoisation

```cpp
class Solution {
public:
  std::unordered_map<STATE, int> memo;

  int topDownDP(std::vector<int> &arr) {
    return dp(STATE_FOR_WHOLE_INPUT, arr);
  }

  int dp(STATE, std::vector<int> &arr) {
    if (BASE_CASE) {
      return 0;
    }

    if (memo.find(STATE) != memo.end()) {
      return memo[STATE];
    }

    int result = RECURRENCE_RELATION(STATE);
    memo[STATE] = result;
    return result;
  }
};
```

```java
class Solution {
  Map<STATE, Integer> memo;
  // int[][] memo;

  public int topDownDP(int[] arr) {
    this.memo = new HashMap<>();
    // this.memo = new int[n][n];
    return dp(STATE_FOR_WHOLE_INPUT, arr);
  }

  public int dp(STATE, int[] arr) {
    if (BASE_CASE) {
      return 0;
    }

    if (memo.contains(STATE)) {
      return memo.get(STATE);
    }

    int result = RECURRENCE_RELATION(STATE);
    memo.put(STATE, result);
    return result;
  }
}
```

```js
let topDownDP = (arr) => {
  let dp = (STATE) => {
    if (BASE_CASE) {
      return 0;
    }

    if (memo[STATE] != -1) {
      return memo[STATE];
    }

    let result = RECURRENCE_RELATION(STATE);
    memo[STATE] = result;
    return result;
  };

  let memo = ARRAY_SIZED_ACCORDING_TO_STATE;
  return dp(STATE_FOR_WHOLE_INPUT);
};
```

```py
def topDownDP(arr):
  def dp(STATE):
    if BASE_CASE:
      return 0

    if STATE in memo:
      return memo[STATE]

    result = RECURRENCE_RELATION(STATE)
    memo[STATE] = result
    return result

  memo = {}
  return dp(STATE_FOR_WHOLE_INPUT)
```

# Trie (Construction/Build)

```cpp
// note: using a class is only necessary if you want to store data at each node.
// otherwise, you can implement a trie using only hash maps.
struct TrieNode {
  int data;
  std::unordered_map<char, TrieNode *> children;

  TrieNode()
  : data(0)
  , children(std::unordered_map<char, TrieNode *>()) {}
};

TrieNode *buildTrie(std::vector<std::string> words) {
  TrieNode *root = new TrieNode();
  // for (std::string word : words) {
  for (auto word : words) {
    TrieNode *curr = root;
    for (char c : word) {
      if (curr->children.find(c) == curr->children.end()) {
        curr->children[c] = new TrieNode();
      }
      curr = curr->children[c];
      // At this point, you have a full word at curr
      // You can perform more logic here to give curr an attribute if you want
    }
  }

  return root;
}
```

```java
class Solution {
  // note: using a class is only necessary if you want to store data at each node.
  // otherwise, you can implement a trie using only hash maps.
  class TrieNode {
    // you can store data at nodes if you wish
    int data;
    Map<Character, TrieNode> children;

    TrieNode() {
      this.children = new HashMap<>();
    }
  }

  public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode curr = root;
      for (char c : word.toCharArray()) {
        if (!curr.children.containsKey(c)) {
          curr.children.put(c, new TrieNode());
        }

        curr = curr.children.get(c);
      }
      // At this point, you have a full word at curr
      // You can perform more logic here to give curr an attribute if you want
    }

    return root;
  }
}
```

```js
// note: using a class is only necessary if you want to store data at each node.
// otherwise, you can implement a trie using only hash maps.
class TrieNode {
  constructor() {
    // you can store data at nodes if you wish
    this.data = null;
    this.children = new Map();
  }
}

let buildTrie = (words) => {
  let root = new TrieNode();
  for (const word of words) {
    let curr = root;
    for (const c of word) {
      if (!curr.children.has(c)) {
        curr.children.set(c, new TrieNode());
      }
      curr = curr.children.get(c);
    }

    // at this point, you have a full word at curr
    // you can perform more logic here to give curr an attribute if you want
  }

  return root;
};
```

```py
# note: using a class is only necessary if you want to store data at each node.
# otherwise, you can implement a trie using only hash maps.
class TrieNode:
  def __init__(self):
    # you can store data at nodes if you wish
    self.data = None
    self.children = {}

def buildTrie(words):
  root = TrieNode()
  for word in words:
    curr = root
    for c in word:
      if c not in curr.children:
        curr.children[c] = TrieNode()
      curr = curr.children[c]
    # at this point, you have a full word at curr
    # you can perform more logic here to give curr an attribute if you want

  return root
```

# Dijkstra's Algorithm

```cpp
class Solution {
  void dijkstra(int source, std::vector<std::vector<int>> edges, int n) {
    std::vector<int> distances(n, INT_MAX);
    distances[source] = 0;
    std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> pq;
    pq.push({0, source});
    while (!pq.empty()) {
      int currDist = pq.top().first;
      int node = pq.top().second;
      pq.pop();
      if (currDist > distances[node]) {
        continue;
      }
      for (std::pair<int, int> edge : graph[node]) {
        int nei = edge.first;
        int weight = edge.second;
        int dist = currDist + weight;
        if (dist < distances[nei]) {
          distances[nei] = dist;
          pq.push({dist, nei});
        }
      }
    }
  }
};
```

```java
class Solution {
  void dijkstra(int source, int[][] edges, int n) {
    int[] distances = new int[n];
    Arrays.fill(distances, Integer.MAX_VALUE);
    distances[source] = 0;
    // Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    pq.offer(new Pair(source, 0));
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int currNode = curr[0];
      int currDist = curr[1];
      if (currDist > distances[currNode]) {
        continue;
      }
      for (int[] edge : graph.get(currNode)) {
        int nei = edge[0];
        int weight = edge[1];
        int dist = currDist + weight;
        if (dist < distances[nei]) {
          distances[nei] = dist;
          pq.offer(new int[] { nei, dist });
        }
      }
    }
  }
}
```

```py
from heapq import *
from math import inf

distances = [inf] * n
distances[source] = 0
heap = [(0, source)]

while heap:
  curr_dist, node = heappop(heap)
  if curr_dist > distances[node]:
    continue

  for nei, weight in graph[node]:
    dist = curr_dist + weight
    if dist < distances[nei]:
      distances[nei] = dist
      heappush(heap, (dist, nei))
```
