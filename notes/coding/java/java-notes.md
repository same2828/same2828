# Table of Contents

- [Table of Contents](#table-of-contents)
- [Java Frameworks](#java-frameworks)
- [Array](#array)
- [Boolean](#boolean)
- [Character Type (char)](#character-type-char)
- [Default Function Parameter Values](#default-function-parameter-values)
- [Digit Grouping/Separator](#digit-groupingseparator)
- [Initialisation](#initialisation)
  - [Default Type Initialisation](#default-type-initialisation)
  - [Initialisation](#initialisation-1)
    - [`int[]`](#int)
    - [`int[][]`](#int-1)
    - [`List<List<Integer>>`](#listlistinteger)
    - [`List<Integer>[]`](#listinteger)
- [Interface Types](#interface-types)
- [List Type](#list-type)
  - [Long Type](#long-type)
- [Null Type](#null-type)
- [PriorityQueue](#priorityqueue)
  - [Custom Comparator](#custom-comparator)
- [String Type](#string-type)
  - [Double Quotes `""` vs Single Quotes `''`](#double-quotes--vs-single-quotes-)
  - [String Comparison](#string-comparison)
  - [String Regex](#string-regex)
- [Truthy/Falsy Values](#truthyfalsy-values)

# Java Frameworks

![](images/collections-framework-hierarchy.png)
![](images/map-framework-hierarchy.png)

# Array

- Only use `.length` for primitive arrays and `.size()` for everything else
  - `array.length`

# Boolean

```java
boolean b1 = true;
boolean b2 = false;
boolean myFunc() { System.out.println("hello") };
Map<Integer, Boolean>;
```

# Character Type (char)

- Compare character types with **`==`**

# Default Function Parameter Values

- Java does **NOT** support default function parameter values such as the following in C++

```cpp
void dfs(int currNode, int parentNode = -1) {
  //...
}
```

# Digit Grouping/Separator

```java
int mod = (int) 1e9 + 7;
int mod = 1_000_000_007;
```

# Initialisation

- Always need to have the keyword **`new`** on **RHS**
- Note how we do NOT need to specify capacity for NON-PRIMITIVES

```
Interface<Type> variable1 = new ImplementingClass<>();
ImplementingClass<Type> variable2 = new ImplementingClass<>();
```

```java
List<Integer> v1 = new ArrayList<>();
PriorityQueue<int[]> v2 = new PriorityQueue<>();
int[] v3 = new int{ 1, 2, 3 }
int[] v4 = new int[5]; // Initialised to 0
int[][] v5 = new int{{1, 2, 3}, {4, 5, 6}}
int[][] v6 = new int[5][5]; // Initialised to 0
```

## Default Type Initialisation

- `char[]` has default values initialised to `'\0'`
- `int[]` has default values initiailsed to `0`
- `boolean[]` has default values initialised to `false`
- All other types (including custom classes) are initialised to `null`
  - `Integer[]` has default values initialised to `null`
  - `String[]` has default values initialised to `null`
- [Read more](https://docs.oracle.com/javase/specs/jls/se17/html/jls-4.html#jls-4.12.5)

## Initialisation

### `int[]`

```java
// Initialise to 0
int[] arr = new int[10];
```

```java
// Initialise to -1
int[] arr = new int[10];
Arrays.fill(arr, -1);
```

### `int[][]`

```java
// Initialise to 0
int[] arr = new int[10][10];
```

```java
// Initialise to -1
int[] arr = new int[10][10];
for (int[] row : arr) {
  Arrays.fill(row, -1);
}
```

### `List<List<Integer>>`

```java
List<List<Integer>> list = new ArrayList<>();
int n = 5;
for (int i = 0; i < n; i++) {
  list.add(new ArrayList<>());
}
// Note at this point each sublist is EMPTY
list.get(0).add(123);
```

### `List<Integer>[]`

- Creates an **array of** `List<Integer>` which allows for indexing
  - Note for EACH index you need to initialise an underlying class implementation such as `new ArrayList<>()` or `new LinkedList<>()`
- Note this is NOT recommended
  - Prefer to use `List<List<Integer>>` instead

```java
// Initialise to null
List<Integer>[] arrayList = List[10];
// if (arrayList[0] != null) {
//   arrayList[0] = new ArrayList<>();
// }
// arrayList[0].add(123);
// System.out.println(arrayList[0].get(0));
for (int i = 0; i < 10; i++) {
  arrayList[i] = new ArrayList<>();
}
```

# Interface Types

- Remember when declaring types inside the diamond operators `<>` for collection/container interfaces such as `List<>`, `Map<>`, `Set<>`, `Queue<>`, `PriorityQueue<>` etc, we need to use the **NON-PRIMITIVE** class types
  - Use `Integer` instead of `int`
  - Use `Long` instead of `long`
  - Use `Double` instead of `double`
  - Use `Character` instead of `char`
  - Use `Boolean` instead of `boolean`

# List Type

- `list.size()`

## `long` Type

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

# Null Type

- `null`

# PriorityQueue

## Custom Comparator

```java
import java.util.*;

public class MyClass {
  static class Person {
    String name;
    int age;

    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  public static void main(String args[]) {
    PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> a.name.compareTo(b.name)); // Ascending order
    // PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> b.name.compareTo(a.name)); // Descending order
    // PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.age, b.age)); // Ascending order
    // PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.age, a.age)); // Descending order
    pq.offer(new Person("Bob", 5));
    pq.offer(new Person("Alice", 1));
    pq.offer(new Person("Daphne", 4));
    pq.offer(new Person("Charlie", 3));

    while (!pq.isEmpty()) {
      Person p = pq.poll();
      System.out.println(p.name + " " + p.age);
    }
  }
}
```

# String Type

- Size
  - `str.size()`
- **CANNOT** index into a string such as `s[i]`, you must use **`s.charAt(i)`**
- Compare strings with **`.equals()`** and **NOT** `==`
- A `String` object is **IMMUTABLE**

## Double Quotes `""` vs Single Quotes `''`

- Use **SINGLE** quotes for literal **chars**
- Use **DOUBLE** quotes for literal **Strings**

## String Comparison

- Compare strings with **`.equals()`** and NOT `==`

| Return  | Method                                    | Description                                                          |
| ------- | ----------------------------------------- | -------------------------------------------------------------------- |
| int     | `.compareTo(String anotherString)`        | Compares two strings lexicographically                               |
| int     | `.compareToIgnoreCase(String str)`        | Compares two strings lexicographically, ignoring case differences    |
| boolean | `.equals(Object anObject)`                | Compares this string to the specified object                         |
| boolean | `.equalsIgnoreCase(String anotherString)` | Compares this String to another String, ignoring case considerations |

```java
String s1 = "hello";
String s2 = "HELLO";
// .compareTo()
// 0 if a == b
// +ve if a > b (alphabetically)
// -ve if a < b (alphabetically)
return s1.compareTo(s2);
```

## String Regex

- **IMPORTANT IMPORT** `import java.util.regex.*`
  - Packages are organized in a tree, but import is NOT recursive
  - Importing `java.util.*` only imports classes in `java.util`, but not classes from sub-packages
  - That is why `java.util.regex.Matcher` and `java.util.regex.Pattern` are NOT imported with the line `import java.util.*`

| Return   | Method                                            | Description                                                                                                      |
| -------- | ------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- |
| boolean  | `.matches(String regex)`                          | Tells whether or not this string matches the given regular expression                                            |
| String   | `.replaceAll(String regex, String replacement)`   | Replaces each substring of this string that matches the given regular expression with the given replacement      |
| String   | `.replaceFirst(String regex, String replacement)` | Replaces the first substring of this string that matches the given regular expression with the given replacement |
| String[] | `.split(String regex)`                            | Splits this string around matches of the given regular expression                                                |
| String[] | `.split(String regex, int limit)`                 | Splits this string around matches of the given regular expression                                                |

# Truthy/Falsy Values

- The following values are considered "truthy", meaning they evaluate to `true` in a `boolean` context:

  - Non-Zero integers (int, long, double, float, etc.)
  - Non-Null object references
  - Non-Empty arrays
  - Boolean `true` (`true` keyword)

- The following values are considered "falsy" or "untruthy" meaning they evaluate to `false` in a `boolean` context:
  - Zero integers (0, 0L, 0.0, 0.0f, etc.)
  - Null object references
  - Empty arrays
  - Boolean `false` (`false` keyword)

```java
public class TruthyFalsyDemo {
  public static void main(String[] args) {
    // Truthy Values
    int num = 4096;
    Object obj = new Object();
    int[] array = { 1, 2, 3 };
    boolean flag = true;

    if (num != 0) {
      System.out.println("num is truthy");
    }
    if (obj != null) {
      System.out.println("obj is truthy");
    }
    if (array.length > 0) {
      System.out.println("array is truthy");
    }
    if (flag) {
      System.out.println("flag is truthy");
    }

    // Falsy Values
    int zeroNum = 0;
    Object nullObj = null;
    int[] emptyArray = {};
    boolean flag2 = false;

    if (zeroNum == 0) {
      System.out.println("zero is untruthy");
    }
    if (nullObj == null) {
      System.out.println("nullObj is untruthy");
    }
    if (emptyArray.length == 0) {
      System.out.println("emptyArray is untruthy");
    }
    if (!flag2) {
      System.out.println("falseFlag is untruthy");
    }
  }
}
```
