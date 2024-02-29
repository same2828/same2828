# Table of Contents

- [Table of Contents](#table-of-contents)
- [TLDR](#tldr)
  - [Primitive Arrays](#primitive-arrays)
  - [Size Methods](#size-methods)
  - [Data Types](#data-types)
- [Classes](#classes)
- [Declaration + Initialisation](#declaration--initialisation)
- [Data Structures](#data-structures)
  - [Array](#array)
  - [Graph](#graph)
  - [HashMap](#hashmap)
    - [Iterating over Values](#iterating-over-values)
  - [List](#list)
  - [Set](#set)
  - [TreeMap](#treemap)
- [Equality Comparison (`==`)](#equality-comparison-)
- [for() Loops](#for-loops)
- [Imports](#imports)
- [Initialisation](#initialisation)
  - [Initialisation of Inner/Nested Containers](#initialisation-of-innernested-containers)
- [Iterators](#iterators)
  - [Iterators for Data Structures](#iterators-for-data-structures)
- [LeetCode](#leetcode)
  - [Data Structures](#data-structures-1)
  - [Other](#other)
- [Math.max() / Math.min()](#mathmax--mathmin)
- [Return Types](#return-types)
- [Sorting](#sorting)
- [Streams](#streams)
- [String](#string)
  - [Character `char`](#character-char)
- [Ternary Operators (`booleanExp ? trueExp : falseExp`)](#ternary-operators-booleanexp--trueexp--falseexp)
- [Miscellaneous](#miscellaneous)
  - [Count the Number of Bits Set to 1](#count-the-number-of-bits-set-to-1)

# TLDR

**Java**

- `import java.util.*;`
- Classes do NOT require a `;` at the end of closing `}`
- Class members (variables + methods):
  - Have a default access level/modifier of `package-private`
  - Are prefixed with class scopes `private`, `protected`, `public`
- CANNOT use `==` to compare everything
  - With primitive data types always use `==`
  - With objects you should NEVER use `==` always use the `.equals()` method (otherwise you are just comparing if the objects are equivalent instead of the actual values in the objects)
- CANNOT use `[]` to index into everything (including hashmap)
- CANNOT use `.size()` to get size/length of everything
- Strings are IMMUTABLE and have special methods (`s.charAt(), s.length()`)
  - Use StringBuilder for mutable strings
- Primitive arrays can be declared `int[][] memo` and initialised later `this.memo = new int[m][n];`
  - Note you NEED to do `for (int[] row : memo) { Arrays.fill(row, -1) };` otherwise it defaults to `0`
- Declaration + Initialisation == `Interface<Type> dataStructure = new ImplementingClass<>();`
- Collections Containers are **UNORDERED by default**
  - For need to use `TreeMap`, `TreeSet` to get ORDERED version of container
- Inner/Nested containers are **UNINITIALISED**
  - Need to manually initialise inner containers
- Java arguments (args) are **passed by value**
  - Non-Primitives (objects/strings) are accessed by "object references" which are "values" that represent "the object's location in memory" (so essentially Java non-primitive arguments (args) are **"passed by reference"**)
- `boolean` values `true` and `false` are NOT mapped to integers

**CPP/C++**

- `#include <bits/stdc++.h>`
- Classes require a `;` at the end of closing `}` (i.e. `};`)
- Class members (variables + methods):
  - Have a default access level/modifier of `private`
  - Are grouped in SEPARATE `private`, `protected`, `public` blocks (i.e. are NOT prefixed with class scopes `private`, `protected`, `public`)
- Can use `==` to compare everything
- Can use `[]` to index into everything (including hashmap)
- Can use `.size()` to get size/length of everything
- Strings are MUTABLE
- Primitive arrays must be declared and initialised SIMULTANEOUSLY with CONSTANTS (not variables like `m` or `n`) `int memo[100][100]` (sizes must be supplied upon declaration and initialisation)
  - Cannot declare then initialise later
  - Use `std::vector` instead if we want to initialise with variable numbers
- `std::vector` containers can be initialised with custom numbers UPON declaration
  - `std:vector<std::vector<int>> memo(m, std::vector<int>(n, -1));`
  - `std:vector<std::vector<int>> memo = std::vector<std::vector<int>>(m, std::vector<int>(n, -1));`
- Does NOT have `new` when declaring/initialising containers
  - Initialisation of `std::map`, `std::unordered_map`, `std::set`, `std::unordered_set`, `std::stack`, `std::queue`, `std::priority_queue` are EMPTY
  - I.e. `std::map<int, std::vector<int>> map;`
- STL Containers are **ORDERED by default**
  - For need to use `std::unordered_map`, `std::unordered_set` to get UNORDERED version of container
- Inner/Nested containers are **INITIALISED** initialised and empty
- CPP arguments (args) are **passed by value** (copy constructed) by default
  - CPP arguments (args) can be "passed by reference" if `&` is prepended to arguments (args)
- `bool` values `true` and `false` are mapped to `int` values `1` and `0` respectively

  - `true == 1`
  - `false == 0`
  - Note this means that ternary boolean checks such as `if (5 % 2)` implicitly mean `if (5 % 2 == 1)`

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

## Primitive Arrays

```java
class Solution {
  int[][] memo;
  int[][] pairs;

  int myFunc(int[][] costs, int[] nums1, int[] nums2) {
    this.memo = new int[costs.length][costs[0].length];
    this.pairs = new int[costs.length][2];
    //...
  }
}
```

```cpp
class Solution {
  public:
  // Note we initialise "memo" to the constraints given/supplied in question (and CANNOT do int memo[costs.size()][costs[0.size()])
  int memo[1001][1001];
  std::vector<std::pair<int, int>> pairs;
  std::vector<std::array<int, 2>> pairs;

  int myFunc(std::vector<std::vector<int>> &costs, std::vector<int> &nums1, std::vector<int> &nums2) {
    memset(memo, -1, sizeof(memo));
    for (int i = 0; i < nums1.size(); i++) {
      pairs.push_back({nums1[i], nums2[i]});
    }
    //...
  }
};
```

## Size Methods

- Java's `.length`, `.length()`, `.size()` always returns an `int`/`Integer`
- CPP/C++'s `.size()` returns a `size_type` which is **NOT** an `int` which is a common cause of errors
  - Fix is to cast to an `int`

| Type                                                     | CPP/C++   | Java        |
| -------------------------------------------------------- | --------- | ----------- |
| Primitive Array <br> `int[]`                             | `.size()` | `.length`   |
| String                                                   | `.size()` | `.length()` |
| List/Vector <br> `List<Integer>` <br> `std::vector<int>` | `.size()` | `.size()`   |

## Data Types

| C++           | Java      |
| ------------- | --------- |
| `bool`        | `boolean` |
| `std::string` | `String`  |
| `long long`   | `long`    |
| `nullptr`     | `null`    |
| `true`        | `true`    |
| `false`       | `false`   |

**Java**

- Use classes if you want values to be able to be `null`
- I.e. `Integer` can be `null` but `int` CANNOT
- In Java `boolean` values CANNOT be treated as `int` values
  - Use `0` or `-1` to represent `false`

**CPP/C++**

- In C++ `bool` values CAN be treated as `int` values (i.e. `int` values can be truthy/falsy)
  - `bool` == `int`
  - `true == 1`
  - `false == 0`
  - Can use `bool` values to return `int` values and vice versa

```cpp
int val1 = 0;
int val2 = 1;

int zero == !val1 ? 0 : 1; // zero == 0
int one == val2 ? 1 : 0; // one == 1
```

```cpp
int myFunc(bool num) {
  return num;
}

int zero = myFunc(false); // zero == 0
int one = myFunc(true); // one == 1
```

# Classes

**Java**

```java
class Solution {
  public int publicFunc() {
    //...
  }

  private int privateFunc() {
    //...
  }
}
```

**CPP/C++**

```java
class Solution {
public:

  int publicFunc() {
    //...
  }

private:

  int privateFunc() {
    //...
  }
}; // <-- NOTE THE SEMICOLON (;) HERE
```

# Declaration + Initialisation

**Java**

- Always have `new ImplementingClass<>()` on RHS
  - Declaration + Initialisation == `Interface<Type> dataStructure = new ImplementingClass<>();`

```java
int[][] memo = new int[m][n];
for (int[] row : memo) {
  Arrays.fill(row, -1);
}

Map<Integer, List<Integer>> map = new HashMap<>();
Map<Integer, List<int[]>> graph = new HashMap<>();
```

**C++/CPP**

- Does NOT have anything on RHS (handled by respective constructors)
  - Especially initialisation of `std::map`, `std::unordered_map`, `std::set`, `std::unordered_set`, `std::stack`, `std::queue`, `std::priority_queue` are EMPTY
  - I.e. `std::map<int, std::vector<int>> map;`

```cpp
std::vector<std::vector> memo(m, std::vector<int>(n, -1));
// std::vector<std::vector> memo;
// this->memo.resize(m, std::vector<int>(n, -1));

std::unordered_map<int, std::vector<int>> map;
std::unordered_map<int, std::vector<std::pair<int, int>>> graph;
```

# Data Structures

| C++                  | Java            |
| -------------------- | --------------- |
| `std::vector<int>`   | `int[]`         |
| `std::vector<int>`   | `List<Integer>` |
| `std::map`           | `TreeMap`       |
| `std::set`           | `TreeSet`       |
| `std::unordered_map` | `Map`           |
| `std::unordered_set` | `Set`           |

Note: Use `List<Integer> list = new ArrayList<>()` instead of `List<Integer> list = new LinkedList<>()`

For nested data structures that need to store additional info about graphs such as (nei, weight)

| C++                                                        | Java                       |
| ---------------------------------------------------------- | -------------------------- |
| `std::pair<int, int>`                                      | `int[]`                    |
| `std::unordered_map<int, std::vector<std::pair<int, int>>` | `Map<Integer, List<int[]>` |

## Array

**Java**

- Array index is an integer in Java, hence max array size is `Integer.MAX_VALUE`
  - I.e. CANNOT use `long i` to index into array

```java
int[][] arr = new int[n][n];
for (int[] row : arr) {
  Arrays.fill(row, -1);
}
```

**CPP/C++**

- Note arrays MUST have initial size when being declared (CANNOT declare as `int[][]` and initialise based on input later like Java)
- `std::vector<int>` is used as replacement for BOTH `int[]` and `List<Integer>`
  - This is because we can initialise `std::vector`:
    - To certain dimensions (which can be extended later on)
    - To be empty and manually add elements ourselves

```cpp
// Size MUST be given when declaring/initialising
int arr[5][5];

std::vector<std::vector<int>> vec(n, std::vector<int>(n, -1));
// std::vector<std::vector<int>> vec;
// vec.resize(n, std::vector<int>(n, -1));
```

## Graph

**Java**

```java
// Note: Can also use Set<Integer> as well
Map<Integer, List<Integer>> graph = new HashMap<>();
for (int[] e : edges) {
  graph.computeIfAbsent(e[0], f -> new ArrayList<>()).add(e[1]);
  graph.computeIfAbsent(e[1], f -> new ArrayList<>()).add(e[0]);
}
```

```java
// Note: Can also use Set<int[]>> as well
Map<Integer, List<int[]>> graph = new HashMap<>();
for (int[] e : edges) {
  graph.computeIfAbsent(e[0], f -> new ArrayList<>()).add(new int[] {e[1], e[2]});
  graph.computeIfAbsent(e[1], f -> new ArrayList<>()).add(new int[] {e[0], e[2]});
}
```

```java
List<List<Integer>> graph = new ArrayList<>();
// Arrays.setAll(graph, f -> new ArrayList<>());
for (int i = 0; i < n; i++) {
  graph.add(new ArrayList<>());
}
for (int[] e : edges) {
  graph.get(e[0]).add(e[1]);
  graph.get(e[1]).add(e[0]);
}
```

```java
List<List<int[]>> graph = new ArrayList<>();
// Arrays.setAll(graph, f -> new ArrayList<>());
for (int i = 0; i < n; i++) {
  graph.add(new ArrayList<>());
}
for (int[] e : edges) {
  graph.get(e[0]).add(new int[] {e[1], e[2]});
  graph.get(e[1]).add(new int[] {e[0], e[2]});
}
```

```java
List<Integer>[] graph = new List[n];
// Arrays.setAll(graph, f -> new ArrayList<>());
for (int i = 0; i < n; i++) {
  graph[i] = new ArrayList<>();
}
for (int[] e : edges) {
  graph[e[0]].add(e[1]);
  graph[e[1]].add(e[0]);
}
```

```java
List<int[]>[] graph = new List[n];
// Arrays.setAll(graph, f -> new ArrayList<>());
for (int i = 0; i < n; i++) {
  graph[i] = new ArrayList<>();
}
for (int[] e : edges) {
  graph[e[0]].add(new int[] {e[1], e[2]});
  graph[e[1]].add(new int[] {e[0], e[2]});
}

for (int[] neiInfo : graph[curr]) {
  //...
}
```

**CPP/C++**

```cpp
std::unordered_map<int, std::vector<int>> graph;
for (auto &e : edges) {
  graph[e[0]].emplace_back(e[1]);
  graph[e[1]].emplace_back(e[0]);
}
```

```cpp
std::unordered_map<int, std::vector<std::pair<int, int>>> graph;
for (auto &e : edges) {
  graph[e[0]].emplace_back(std::make_pair(e[1], e[2]));
  graph[e[1]].emplace_back(std::make_pair(e[0], e[2]));
}
```

```cpp
// Create 2d vector with 'n' EMPTY rows
std::vector<std::vector<int>> graph(n);
for (auto &e : edges) {
  graph[e[0]].emplace_back(e[1]);
  graph[e[1]].emplace_back(e[0]);
}
```

```cpp
// Create 2d vector with 'n' EMPTY rows
std::vector<std::vector<std::pair<int, int>>> graph(n);
for (auto &e : edges) {
  // graph[e[0]].push_back({e[1], e[2]});
  // graph[e[1]].push_back({e[0], e[2]});
  graph[e[0]].emplace_back(std::make_pair(e[1], e[2]));
  graph[e[1]].emplace_back(std::make_pair(e[0], e[2]));
}

for (auto [nei, weight] : graph[curr]) {
  //...
}
```

```cpp
int mainProblem(std::vector<std::vector<int>> &edges) {
  int n = edges.length;
  std::vector<int> graph[n];
  for (auto &e : edges) {
    graph[e[0]].emplace_back(e[1]);
    graph[e[1]].emplace_back(e[0]);
  }
  return dp(0, graph);
}

int dp(int currNode, std::vector<int> (&graph)[]) {
  //...
}
```

```cpp
int mainProblem(std::vector<std::vector<int>> &edges) {
  int n = edges.length;
  std::vector<std::pair<int, int>> graph[n];
  for (auto &e : edges) {
    graph[e[0]].emplace_back(std::make_pair(e[1], e[2]));
    graph[e[1]].emplace_back(std::make_pair(e[0], e[2]));
  }
  return dp(0, graph);
}

int dp(int currNode, std::vector<std::pair<int, int>> (&graph)[]) {
  //...
}
```

- See 2247.maximum-cost-of-trip-with-k-highways
- For interesting `Set<Integer>[][]` or `std::vector<std::vector<std::unordered_set<int>>>` see 2019.the-score-of-students-solving-math-expression

## HashMap

**Java**

- Get Value:
  - `map.get(key)`
    - `map.getOrDefault(key, defaultValue)`
- Assign Value:
  - `map.put(key, value)`
  - `Map<Integer, List<Integer>>`: `map.get(key).add(value)`

**CPP/C++**

- `std::unordered_map` is FASTER than `std::map`
  - `std::unordered_map` requires keys to be hashable (hence cannot use `std::vector`, `std::pair`, `std::tuple` as key without first defining custom hash function)
  - `std::map` does NOT have this requirement
- Get Value:
  - `map[key]`
- Assign Value:

  - `map[key] = value`
  - `std::map<int, std::vector<int>>`: `map[key].emplace_back(value)`

### Iterating over Values

**Java**

- Need to add `.getOrDefault(key, defaultValue)`
  - `defaultValue` is normally `Collections.emptyList()` or `new ArrayList<>()`

```java
for (int[] value : map.getOrDefault(key, new ArrayList<>())) {
  //...
}
```

**CPP/C++**

- NO need to add anything

```cpp
for (auto &value : map[key]) {
  //...
}
```

```cpp
for (auto &kvp : map) {
  auto key = kvp.first;
  auto value = kvp.second;
}
```

```cpp
for (auto it : map.begin(); it != map.end(); it++) {
  auto &key = it->first;
  auto &value = it->second;
}
```

```cpp
std::map<int, std::vector<std::pair<int, int>>> map;
for (int i = 0; i < m; ++i) {
  for (int j = 0; j < n; ++j) {
    map[grid[i][j]].emplace_back(std::make_pair(i, j));
  }
}
for (auto &[k, v] : map) {
  for (auto &[i, j] : v) {
    dp[i][j] = 1 + std::max(rowMax[i], colMax[j]);
  }
}
```

## List

**Java**

- `List<>` interface

```java
List<List<Integer>> list = new ArrayList<>();
for (int i = 0; i < dim1; i++) {
  list.add(new ArrayList<>());
  for (int j = 0; j < dim2; j++) {
    list.get(i).add(-1);
  }
}
```

**CPP/C++**

- `std::vector` is used as replacement for BOTH `int[]` and `List<>`
  - This is because we can initialise `std::vector`:
    - To certain dimensions (which can be extended later on)
    - To be empty and manually add elements ourselves

```cpp
std::vector<std::vector<int>> vec1(dim1, std::vector<int>(dim2, -1));

std::vector<std::vector<int>> vec2;
vec2 = std::vector<std::vector<int>>(dim1, std::vector<int>(dim2, -1));

std::vector<std::vector<int>> vec3;
vec3.emplace_back(std::vector<int>{});
```

## Set

**Java**

- Checking the boolean result of `if(set.add())` does **NOT** work
  - See 996.number-of-squareful-arrays
- Use `if (!set.contains())` instead

**CPP/C++**

- Checking bool result of `if(s.insert().second)` DOES work

## TreeMap

| C++              | Java              |
| ---------------- | ----------------- |
| `std::map`       | `TreeMap`         |
| `.upper_bound()` | `.ceilingEntry()` |
| `.upper_bound()` | `.floorEntry()`   |

- Note: **The LESS entries in the TreeMap the FASTER it will perform**
  - Hence when deciding whether to remove entries always use `>=` rather than `>`

**Java**

- `TreeMap<>`
  - Collections Containers are UNORDERED by default
- `.ceilingEntry()` returns a `Map.Entry` to first entry `>= givenKey`
- `.floorEntry()` returns a `Map.Entry` to first entry `<= givenKey`

**CPP/C++**

- `std::map`
  - STL Containers are ORDERED by default
- `.upper_bound()` returns an `Iterator` to first entry `> givenKey`
- `.lower_bound()` returns an `Iterator` to first entry `>= givenKey`
- **DO NOT USE .lower_bound()** to find `floorEntry()` (`<=`) or to go backwards (only use it to go forwards)

- We use `.upper_bound()` for BOTH `.floorEntry()` and `.ceilingEntry()` functionalities
  - The reason is because `.lower_bound()` returns an iterator to an element that is GREATER THAN OR EQUAL TO `>=` the given key
    - Hence there are 3 iterator return possibilities:
      1. Returns an iterator to element EQUIVALENT (`==`) to the given key
      2. Returns an iterator to first element GREATER THAN `>` the given key if there is NOT an equivalent key
         - Note: Returned iterator could point to `std::end(map) == map.end()` if given key is GREATER THAN `>` largest key in the `std::map` (i.e. if no such element in `std::map` is `>=` to the given key)
      3. Returns an iterator to `std::begin(map) == map.begin()` (pointer to FIRST ELEMENT in the `std::map`) if the given key is LESS THAN OR EQUAL TO `<=` the smallest key in the `std::map` (i.e. all elements in `std::map` are GREATER THAN OR EQUAL TO `>=` the given key)
    - This causes a lot of ambiguity on how to find first element `<=` given key
      - Do we decrement the iterator or not since `it` may point to equivalent key, or first key greater than given key (such as `std::end(map) == map.end()`)
  - `.upper_bound()` returns an iterator to an element that is GREATER THAN `>` the given key
    - Hence there are only 2 iterator return possibilities:
      1. Returns an iterator to first element GREATER THAN `>` the given key
         - Note: Returned iterator could point to `std::end(map) == map.end()` if given key is GREATER THAN `>` largest key in the `std::map` (i.e. if no such element in `std::map` is GREATER THAN `>`the given key)
      2. Returns an iterator to `std::begin(map) == map.begin()` (pointer to FIRST ELEMENT in the `std::map`) if the given key is LESS THAN `<` the smallest key in the `std::map` (i.e. all elements in `std::map` are GREATER THAN `>` the given key)
    - This **STRICTLY GREATER THAN `>`** condition by `.upper_bound()` solves ALL our problems because we can find BOTH the first element LESS THAN OR EQUAL TO `<=` and the first element GREATER THAN OR EQUAL TO `>=` given key by decrementing the iterator `it--` AFTER FIRST checking it does NOT equal to `std::begin(map) == map.begin()`
      - `auto it = treeMap.lower_bound(key); if (it == map.begin()) { it--; }`
        - `it` now points to first element >= given key
      - `auto it = treeMap.upper_bound(key); if (it == map.begin()) { it--; }`
        - `it` now points to first element <= given key
  - Note:
    - If given key is LESS THAN `<` smallest key in the map, `.upper_bound()` will return `std::begin(map) == map.begin()` which points to the FIRST element in the `std::map`
    - This means we CANNOT decrement the iterator `it` anymore
  - Examples
    - 2926.maximum-balanced-subsequence-sum
    - 975.odd-even-jump

```cpp
std::map<int, int> treeMap;

// It is preferable to add this so that after decrementing "it" (it--) it->second will always give a valid value
// treeMap[INT_MIN] = 0;

//------------------------------------------------------------------------------
// .floorEntry() (<=)
//------------------------------------------------------------------------------
auto it = treeMap.upper_bound(nums[i]);
if (it != treeMap.begin()) {
  it--;
}
// "it" now points to first element >= given key
auto key = it->first;
auto val = it->second;
//------------------------------------------------------------------------------
// .ceilingEntry() (>=)
//------------------------------------------------------------------------------
auto it = treeMap.upper_bound(nums[i]);
if (it != treeMap.begin()) {
  it--;
}
// "it" now points to first element <= given key
auto key = it->first;
auto val = it->second;
```

When using `.upper_bound()` always need to check `if (it != map.begin())` since we always decrement `it--` before using `it` to have equivalent functionality of Java's `<=`

```cpp
std::map<int, int> treeMap;
treeMap[arr[n - 1]] = n - 1;
// Loop from the second last element toward the left
for (int i = n - 2; i >= 0; i--) {
  auto nextSmallerKV = treeMap.upper_bound(arr[i]);
  if (nextSmallerKV != treeMap.begin()) {
  nextSmallerKV--;
  //...
  }
}
```

# Equality Comparison (`==`)

**Java**

- With "primitive data" types always use `==`
- With "objects" you should NEVER use `==` always use the `.equals()` method instead
- Otherwise you are just comparing if the objects are equivalent instead of the actual values in the objects
- `==` is lazy
  - It just checks whatever the value in the variables you are comparing are the same or not
  - So if you are comparing primitive data types, the value is stored in the variable, and the `==` will work no problem
  - However, if you have objects, the reference to the memory location is stored, so `==` will only return `true` if you have the same object
  - So you must not be lazy with objects, use the .equals() method, which will go to the memory location, grab the actual value, and then compare the values of the object instead of the address
- The `Integer.intValue()` is used to get the primitive int value of Integer
  - The other test cases pass for you because the int values are low and the auto-unboxing feature of java does the value comparison for you
  - But for this one test case the int values are pretty large and hence it leads to object comparison instead of the value comparison which is not what we want
  - You can get more details from here:
  - https://stackoverflow.com/questions/3130311/weird-integer-boxing-in-java
  - https://stackoverflow.com/questions/3131136/integers-caching-in-java?noredirect=1&lq=1
- **Solution: Use `Integer.intValue()`**
- Examples
  - 79.minimum-window-substring

**CPP**

`==` can be used to compare everything and can be "overridden" to have custom functionality

# for() Loops

**Java**

- Always need to write TYPE of element that you iterate over

```java
int[][] edges;
for (int[] edge : edges) {
  //...
}


Map<Integer, Integer> map = new HashMap<>();
for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
  int src = entry.getKey();
  // List<int[]> neiInfoList = entry.getValue();
  for (int[] neiInfo : entry.getValue()) {
    int nei = neiInfo[0];
    int weight = neiInfo[1];
  }
}
```

**CPP/C++**

- Just spam `auto` and make sure to add `&` (ampersand) to make it a reference (speeds things up)
  - Can also add `const` as well

```cpp
std::vector<std::vector<int>> edges;
for (auto &edge : edges) {
  //...
}

std::unordered_map<int, std::vector<std::pair<int, int>>> map;
for (auto &kvp : map) {
  auto key = kvp.first;
  // auto value = kvp.second;
  for (auto &[nei, weight] : kvp.second) {
    //...
  }
}
```

# Imports

**Java**

```java
import java.util.*;
```

**CPP/C++**

```cpp
#include <bits/stdc++.h>
```

# Initialisation

**Java**

- Always need to add **`new`** to RHS
- `Interface<Type> var = new ImplementingClass<>();`

**CPP/C++**

- For the following containers, their usage normally starts off as empty (we insert elements into them); therefore we do **NOT** need to initialise (in function body) after declaring it at the top of a class for the following containers

  - `std::list`/`std::forward_list`
  - `std::deque`
  - `std::map`/`std::unordered_map`
  - `std::set`/`std::unordered_set`
  - `std::stack`
  - `std::queue`
  - `std::priority_queue`

    ```cpp
    class Solution {
    public:
      std::unordered_map<int, std::vector<int>>> graph;

      void myFunction(int a, int b) {
        graph[a].push_back(b);
      }
    }
    ```

- For `std::vector`, their usage normally does **NOT** stat off as empty (we expect the values to be initialised to `0` or `-1`, and do not want to call `.push_back()` or `.emplace_back()`); therefore we **DO** need to initialise (in function body) after declaration

  - `std::vector`

    ```cpp
    class Solution {
    public:
      std::vector<std::vector<int>> list;

      void myFunction(int a, int b) {
        list = std::vector<std::vector<int>>(5, std::vector<int>(5, -1));
        // if (list[a][b] == -1) {
        //   list[a][b] = 5;
        // }
      }
    };

    // int main() {
    //   Solution s;
    //   s.myFunction(1, 2);
    //   std::cout << s.list[1][2];
    // }

    // Output: 5
    ```

## Initialisation of Inner/Nested Containers

**Java**

- Inner/nested containers are **UNINITIALISED**
- Need to **manually** initialise inner containers

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
```

```java
Map<Integer, List<Integer>> graph = new HashMap<>();
for (int[] e : edges) {
  graph.computeIfAbsent(e[0], f -> new ArrayList<>()).add(e[1]);
  graph.computeIfAbsent(e[1], f -> new ArrayList<>()).add(e[0]);
}
```

**CPP/C++**

- Inner/nested containers are **automatically** initialised and empty

```cpp
std::vector<std::vector<int>> graph(n, std::vector<int>{})
for (auto &e : edges) {
  graph[e[0]].push_back(e[1]);
  graph[e[1]].push_back(e[0]);
}
```

```cpp
std::unordered_map<int, std::vector<int>> graph;
for (auto &e : edges) {
  graph[e[0]].push_back(e[1]);
  graph[e[1]].push_back(e[0]);
}
```

# Iterators

**Java**

- `.iterator()` returns an iterator that does NOT point to anything yet
  - Can think of pointing to 1 index BEFORE first element (similar yet opposite behaviour to std::end() in C++)
  - Need to call `.next()` on the iterator to advance it
- `.next()` does 2 things
  1. Returns next element
  2. Advances the iterator

```java
TreeSet<Integer> t = new TreeSet<>();
t.add(3);
t.add(2);
t.add(1);
Iterator<Integer> it = t.iterator();
// Need to call .next() to get "it" to point to FIRST element
int first = it.next();
while (it.hasNext()) {
  int next = it.next();
  //...
}
```

**CPP/C++**

```cpp
std::set<int> s;
s.insert(3);
s.insert(2);
s.insert(1);
auto it = s.begin();
int first = *it;
while (++it != s.end()) {
  int next = *it;
}
```

## Iterators for Data Structures

**Java**

- If you want to remove all elements in a `Map` or `Set` and return the final value, you will need to manually keep track of the "final" element yourself (usually done in `for()` loop and with `break` statement)

**CPP/C++**

- Can just call `std::begin()` on the data structure
  - I.e. `std::begin(std::map->first)`, `std::begin(std::map->second)` depending on whether you want to return the key or the value of the `std::map`

# LeetCode

## Data Structures

**Java**

- Somehow `ArrayList` is MUCH FASTER than `LinkedList`
- `ArrayList > LinkedList` for BOTH implementation and interface (i.e. `List > LinkedList`)

**CPP/C++**

- Always use `std::vector` over an normal array `int arr[]` since you have to provide size upon declaring an array

## Other

Note that similar to Java, we only need to use `this->` if there is ambiguity between local (argument) variables and member variables

```java
class Solution {
  int[] nums;
  int[][] memo;

  public int function(int[] a) {
    this.nums = a;
    this.memo = new int[a.length+1];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    subFunction();
  }

  public int subFunction() {
    for (int num : nums) {
      System.out.println(num);
    }
  }
}
```

In C++, you **CANNOT** have a member variable that is a reference and is assigned later
A reference must be initialized when it is declared (declared and initialized at SAME time), so you CANNOT have a class member that is a reference and assign it in a member function later

```cpp
class Solution {
public:
  std::vector<int> nums;
  std::vector<std::vector<int>> memo;

  // Note: We do NOT include access modifier infront of function name
  int function(std::vector<int>& a) {
    this->nums = a; // Our global variable "arr" is COPY-CONSTRUCTED
    memo.resize(a.size() + 1, std::vector<int>(a.size() + 1, -1));
    subFunction();
  }

  int subFunction() {
    for (auto &num : nums) {
      std::cout << num << '\n';
    }
  }
}; // <-- NOTE THE ';' character here
```

Need to **PASS BY REFERENCE** if we do NOT want to copy construct containers

- CPP arguments (args) are **passed by value** (copy constructed) by default
  - CPP arguments (args) can be "passed by reference" if `&` is prepended to arguments (args)
- Java Non-Primitives (objects/strings) are accessed by "object references" which are "values" that represent "the object's location in memory" (so essentially Java non-primitive arguments (args) are **"passed by reference"**)
- This is a common cause of errors when translating C++ code to Java code and vice versa

```cpp
class Solution {
public:
  std::vector<std::vector<int>> memo;

  // Note: We do NOT include access modifier infront of function name
  int function(std::vector<int>& a) {
    memo.resize(a.size() + 1, std::vector<int>(a.size() + 1, -1));
    subFunction(a);
  }

  int subFunction(std::vector<int>& nums) { // Note: Make sure to use PASS BY REFERENCE (&) otherwise we will have to copy construct the container each time we call the subFunction
    for (auto &num : nums) {
      std::cout << num << '\n';
    }
  }
}; // <-- Note: The ';' character here
```

Can also use **pointers** if we do NOT want to copy construct containers

```cpp
class Solution {
public:
  std::vector<int> *arr;

  int myFunc(std::vector<int> &nums) {
    this->arr = &nums;
    for (auto &num : *myVec) {
      //...
    }
  }
};
```

# Math.max() / Math.min()

**CPP/C++**

- All elements MUST be casted to same type
- E.g.

```cpp
std::vector<long long> subTreeCosts = {cost[currNode]};
// Add to subTreeCosts...
result[currNode] = std::max(0LL, (long long) subTreeCosts[0] * subTreeCosts[1], (long long) subTreeCosts[n - 2] * subTreeCosts[n - 1])
```

# Return Types

**Java**

- Can only do `return memo[i][j] = result;` for PRIMTIVE arrays

**Java**

- Can do `return memo[i][j] = result;` for PRIMTIVE arrays/vectors AND hashmaps

```cpp
std::unordered_map<std::string, long> memo;
return memo[key] = result;
```

# Sorting

**Java**

- Use `Arrays.sort()` for arrays of primitives such as `int[]`
  - Cannot pass lambda's into `Arrays.sort()`
  - `Arrays.sort()` can **only sort in ascending order (a < b)**
- Use `Collections.sort()` for containers such as `List<Integer>`
  - Can pass lambda's into `Collections.sort()`
- Preferably use `return Integer.compare(a, b)` and `return Long.compare(a, b)` instead of `return a - b` to handle Integer overflows
  - Use `return Integer.compare(b, a)` for descending order

```java
class Solution {
  public int myFunc(std::vector<std::vector<int>> &arr) {
    for (int[] row : arr) {
      Arrays.sort(row);
    }
    // Sort arr in ascending order of dim1, dim2 then dim3
    Arrays.sort(arr, (a, b) -> {
      if (a[0] != b[0]) {
        return Integer.compare(a[0], b[0]);
      }
      if (a[1] != b[1]) {
        return Integer.compare(a[1], b[1]);
      }
      return Integer.compare(a[2], b[2]);
    });
  }
};
```

**CPP/C++**

- Use `std::sort` for everything
- Use `return a < b`
- Note for `std::priority_queue` the operators are reversed `a < b` actually means `a > b`

```cpp
class Solution {
public:
  int myFunc(std::vector<std::vector<int>> &arr) {
    // Implicit/Default behaviour
    // for (auto &row : arr) {
    //   std::sort(std::begin(row), std::end(row));
    // }
    // std::sort(std::begin(arr), std::end(arr));

    // Explicit
    for (auto &row : arr) {
      std::sort(std::begin(row), std::end(row), [](int a, int b) { return a < b; });
    }
    std::sort(std::begin(arr), std::end(arr), [](std::vector<int> &a, std::vector<int> &b) {
      if (a[0] != b[0]) {
        return a[0] < b[0];
      }
      if (a[1] != b[1]) {
        return a[1] < b[1];
      }
      return a[2] < b[2];
    });
  }
};
```

# Streams

```cpp
std::vector<int> nums = { 1, 2, 3, 4, 5 }; // Pretend there are many more numbers...
long sum = std::accumulate(nums.begin(), nums.end(), 0LL);
```

```java
int[] nums = { 1, 2, 3, 4, 5 }; // Pretend there are many more numbers...
long sum = Arrays.stream(nums).mapToLong(val -> (long) val).sum();
```

# String

**Java**

- `s.charAt(index)`;
- `s1.equals(s2)`
- Strings are **IMMUTABLE**, need to use `StringBuilder sb = new StringBuilder()`

```java
int i = 1;
int j = 2;
String s = i + "_" + j; // Somehow using '_' gives error since Java treats '_' as an INTEGER (int)
```

**CPP/C++**

- `s[index]`;
- `s1 == s2`
- Strings are **MUTABLE**

```cpp
int i = 1;
int j = 2;
std::string s = std::to_string(i) + '_' + std::to_string(j);
```

## Character `char`

- Behaviour is the SAME
- Preferably use single quotes for single characters

```java
char a = 'a';
char b = 'b';
return a == b;
```

# Ternary Operators (`booleanExp ? trueExp : falseExp`)

**CPP/C++**

- In C++ braces initializer list CANNOT be used on the right hand side of operator ':'
- E.g. 2973.find-number-of-coins-to-place-in-tree-nodes

```cpp
// return (n <= 5) ? subTreeCosts : {subTreeCosts[0], subTreeCosts[1], subTreeCosts[n - 3], subTreeCosts[n - 2], subTreeCosts[n - 1]};
return (n <= 5) ? subTreeCosts : std::vector<long long>({subTreeCosts[0], subTreeCosts[1], subTreeCosts[n - 3], subTreeCosts[n - 2], subTreeCosts[n - 1]});
```

# Miscellaneous

## Count the Number of Bits Set to 1

**Java**

```java
int numBitsSet = Integer.bitCount(currMask);
```

**CPP/C++**

```cpp
// int numBitsSet = std::popcount(currMask); // C++20
int numBitsSet = __builtin_popcount(currMask); // Requires GCC
```

**Manual**

```java
int numBitsSet = 0;
while (currMask > 0) {
  numBitsSet += (currMask & 1) == 1 ? 1 : 0;
  currMask >> 1;
}
```
