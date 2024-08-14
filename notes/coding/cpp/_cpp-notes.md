# Table of Content

- [Table of Content](#table-of-content)
- [Compiling C++](#compiling-c)
  - [Clang (LLVM)](#clang-llvm)
  - [GCC (G++)](#gcc-g)
- [Compiler Extensions](#compiler-extensions)
  - [Clangd](#clangd)
  - [CMake](#cmake)
  - [Configuration](#configuration)
  - [Building](#building)
  - [Running](#running)
- [`.` dot operator vs `->` arrow operator](#-dot-operator-vs---arrow-operator)
  - [Dot (`.`) Operator](#dot--operator)
  - [Dot (`.`) Operator + Pointers](#dot--operator--pointers)
  - [Arrow (`->`) Operator](#arrow---operator)
- [`()` brackets vs `{}` brackets](#-brackets-vs--brackets)
  - [Initialisations](#initialisations)
  - [Implicit type conversions](#implicit-type-conversions)
  - [Narrowing conversions](#narrowing-conversions)
  - [Aggregate initialisation](#aggregate-initialisation)
  - [Empty initialiser](#empty-initialiser)
    - [Zero (0) initialisation for fundamental types](#zero-0-initialisation-for-fundamental-types)
    - [Default construction for user-defined types](#default-construction-for-user-defined-types)
    - [Value Initialisation for aggregates](#value-initialisation-for-aggregates)
  - [Overload resolution](#overload-resolution)
  - [Object Constructor](#object-constructor)
  - [Parentheses `()` with No Parameters](#parentheses--with-no-parameters)
  - [Curly Braces `{}` with No Parameters](#curly-braces--with-no-parameters)
  - [Parentheses `()` with a Single Parameter](#parentheses--with-a-single-parameter)
  - [Curly Braces `{}` with a Single Parameter](#curly-braces--with-a-single-parameter)
  - [Stateless Function Objects Instantiation](#stateless-function-objects-instantiation)
- [`auto` keyword](#auto-keyword)
- [`bool` (Boolean) Type](#bool-boolean-type)
- [Default Function Parameter Values](#default-function-parameter-values)
- [Digit Grouping/Separator](#digit-groupingseparator)
- [East `const` vs `const` West](#east-const-vs-const-west)
  - [Class Member Functions](#class-member-functions)
  - [Constrained `auto` (C++20)](#constrained-auto-c20)
- [For Loops](#for-loops)
- [Initialisation](#initialisation)
  - [`int[]` array](#int-array)
  - [`int[][]` array](#int-array-1)
  - [`std::vector`](#stdvector)
  - [1D Vector](#1d-vector)
    - [`std::vector<int>`](#stdvectorint)
    - [`std::vector<std::pair<int, std::string>>`](#stdvectorstdpairint-stdstring)
  - [2D Vector](#2d-vector)
    - [`std::vector<std::vector<int>>`](#stdvectorstdvectorint)
    - [Initialise Single ROW of 2D Vector](#initialise-single-row-of-2d-vector)
    - [Initialise Single COLUMN of 2D Vector](#initialise-single-column-of-2d-vector)
    - [`std::vector<std::vector<std::pair<int, std::string>>>`](#stdvectorstdvectorstdpairint-stdstring)
  - [3D Vector](#3d-vector)
    - [`std::vector<std::vector<std::vector<int>>>`](#stdvectorstdvectorstdvectorint)
  - [`std::list`](#stdlist)
  - [`std::deque`](#stddeque)
  - [`std::set` + `std::unordered_set`](#stdset--stdunordered_set)
  - [`std::map` + `std::unordered_map`](#stdmap--stdunordered_map)
  - [`std::unordered_map.reserve()`](#stdunordered_mapreserve)
  - [`std::stack`](#stdstack)
  - [`std::queue`](#stdqueue)
  - [`std::priority_queue`](#stdpriority_queue)
  - [`std::pair`](#stdpair)
- [Iterators](#iterators)
  - [`.` dot operator vs `->` arrow operator](#-dot-operator-vs---arrow-operator-1)
  - [Invalidation](#invalidation)
- [Lambda Expressions](#lambda-expressions)
  - [Syntax / Parts of a Lambda Expression](#syntax--parts-of-a-lambda-expression)
  - [Capture List](#capture-list)
    - [Capture "all by value/by copy"](#capture-all-by-valueby-copy)
    - [Capture "all by reference"](#capture-all-by-reference)
    - [Capture "by specific variable by value/by copy"](#capture-by-specific-variable-by-valueby-copy)
    - [Capture "by specific variable by reference"](#capture-by-specific-variable-by-reference)
    - [Make capture "by value/by copy" mutable](#make-capture-by-valueby-copy-mutable)
    - [Equivalent Captures](#equivalent-captures)
  - [Parameters](#parameters)
  - [Return Type](#return-type)
  - [Function Body](#function-body)
  - [Examples](#examples)
  - [Usage with `std::accumulate()`](#usage-with-stdaccumulate)
  - [Usage with `std::sort()`](#usage-with-stdsort)
- [LeetCode / Competitive Programming](#leetcode--competitive-programming)
  - [`char` Type](#char-type)
  - [Global Variables](#global-variables)
  - [Header Files (import)](#header-files-import)
  - [Iterators](#iterators-1)
  - [Java Equivalent](#java-equivalent)
  - [`long long` Type](#long-long-type)
  - [Pass by Reference `&`](#pass-by-reference-)
  - [TLE](#tle)
- [Null Type](#null-type)
- [Placement of Identifiers/Operators](#placement-of-identifiersoperators)
  - [NO difference](#no-difference)
  - [Difference](#difference)
- [Reference vs Pointer](#reference-vs-pointer)
  - [Syntax](#syntax)
  - [Initialisation](#initialisation-1)
  - [Nullability](#nullability)
  - [Dereferencing](#dereferencing)
  - [Memory Management](#memory-management)
  - [Function Parameters](#function-parameters)
  - [Objects](#objects)
- [`std::algorithm` Examples](#stdalgorithm-examples)
  - [`std::fill`](#stdfill)
  - [`std::accumulate`](#stdaccumulate)
  - [Get index of smallest element in `std::vector`](#get-index-of-smallest-element-in-stdvector)
- [`std::map` vs `std::unordered_map`](#stdmap-vs-stdunordered_map)
- [`this` keyword](#this-keyword)
- [Truthy/Falsy Values](#truthyfalsy-values)
  - [Truthy Values](#truthy-values)
  - [Falsy Values](#falsy-values)
- [Types](#types)
  - [Number](#number)
  - [Signed vs Unsigned](#signed-vs-unsigned)

# Compiling C++

## Clang (LLVM)

- `clang`
- `clang-16`
- `clang++`
- `clang++-16`

```sh
clang++ -std=c++20 test.cpp -o test
clang++ -std=c++20 -Wall test.cpp -o test
clang++ -std=c++20 -Wall -Wextra test.cpp -o test
clang++ -std=c++20 -Wall -Wextra -Werror test.cpp -o test
clang++ -std=c++20 -Wall -Wextra -pedantic -Werror test.cpp -o test

# Optimisation
clang++ -std=c++20 -O -Wall -Wextra test.cpp -o test # -O == -O1
clang++ -std=c++20 -O2 -Wall -Wextra test.cpp -o test # Used by LeetCode
clang++ -std=c++20 -O3 -Wall -Wextra test.cpp -o test

# Debugging
clang++ -std=c++20 -g -Wall -Wextra test.cpp -o test # Default = Level 2
clang++ -std=c++20 -g3 -Wall -Wextra test.cpp -o test # Highest

# Address Sanitizer
clang++ -std=c++20 -fsanitize=address -Wall -Wextra test.cpp -o test # LeetCode Compiler Flags
clang++ -std=c++20 -fsanitize=address -fno-omit-frame-pointer -Wall -Wextra test.cpp -o test
```

## GCC (G++)

- `g++`
- `g++-12`

```sh
g++-12 -std=c++20 test.cpp -o test
g++-12 -std=c++20 -Wall test.cpp -o test
g++-12 -std=c++20 -Wall -Wextra test.cpp -o test
g++-12 -std=c++20 -Wall -Wextra -Werror test.cpp -o test
g++-12 -std=c++20 -Wall -Wextra -pedantic -Werror test.cpp -o test

# Optimisation
g++-12 -std=c++20 -O -Wall -Wextra test.cpp -o test # -O == -O1
g++-12 -std=c++20 -O2 -Wall -Wextra test.cpp -o test # Used by LeetCode
g++-12 -std=c++20 -O3 -Wall -Wextra test.cpp -o test

# Debugging
g++-12 -std=c++20 -g -Wall -Wextra test.cpp -o test # Default = Level 2
g++-12 -std=c++20 -g3 -Wall -Wextra test.cpp -o test # Highest

# Address Sanitizer
g++-12 -std=c++20 -fsanitize=address -Wall -Wextra test.cpp -o test # LeetCode Compiler Flags
g++-12 -std=c++20 -fsanitize=address -fno-omit-frame-pointer -Wall -Wextra test.cpp -o test
```

By default if NO output file name is given (`-o` is NOT specified), g++ will name the output file `a.out`

```sh
g++ source.cpp
./a.out
```

```sh
g++ source.cpp -o outputName
./outputName
```

```sh
g++ source.cpp -o test
./test < input.txt
```

# Compiler Extensions

## Clangd

- Need to create a clang-format file and paste it somewhere
- Note that this extension sets `"C_Cpp.intelliSenseEngine": "disabled"` in settings.json
  - Need to set this back to "default" when not using `clangd` extension

## CMake

## Configuration

- `CMake: Select a Kit`
  - Select `Comp6671`
- `CMake: Configure`

## Building

- `CMake: Build Target`
  - Select file you want to build
- `CMake: Clean`
- `CMake: Clean Rebuild`

## Running

- `CMake: Set Debug Target`
  - Select file you want to build
- `CMake: Run Without Debugging`

# `.` dot operator vs `->` arrow operator

- In C++, the `.` (dot) and `->` (arrow) operators are used to access members of a class or struct
  - They are used to reference member variables and member functions of objects or pointers to objects
  - However, they are used in different contexts and with different types of variables

## Dot (`.`) Operator

- The dot (`.`) operator is used to access members of an object when the object is **NOT a pointer**
  - It is used with **objects** and **references to objects**
  - When accessing members with the dot operator, the object itself is used to directly access the members

```cpp
class MyClass {
public:
  int num;
  void func() {
    //...
  }
};

MyClass obj;
obj.num = 123;  // Accessing member variable using dot operator
obj.func();   // Accessing member function using dot operator

MyClass refObj = &obj;
refObj.num = 456;
```

## Dot (`.`) Operator + Pointers

- When using the pointers with the dot (`.`) operator, we need to first **dereference** the pointer using the `*` operator, which gives us the object `obj`, and then we can use the dot (`.`) operator to access its members
- Need to explictly dereference pointer in brackets because the dot (`.`) operator has higher precendence than the pointer dereference operator (`*`) , and without explicit dereferencing, the dot (`.`) operator would be applied to the pointer itself, resulting in a syntax error

```cpp
class MyClass {
public:
  int num;
  void func() {
    // function body
  }
};

MyClass obj;        // Create an object of MyClass
MyClass* ptr = &obj; // Create a pointer to MyClass and initialise it with the address of obj
// Accessing members of obj directly using dot (.) operator
obj.num = 42;
obj.func();
// Accessing members of obj through ptr using dot (.) operator with dereferencing
(*ptr).num = 42;
(*ptr).func();
```

## Arrow (`->`) Operator

- The arrow (`->`) operator is used to access members of an object **when the object is a pointer**
  - It is used with pointers to objects
  - When accessing members with the arrow operator, the pointer to the object is used to indirectly access the members

```cpp
class MyClass {
public:
  int num;
  void myFunc() {
    // function body
  }
};

MyClass* ptrObj = new MyClass(); // Create a pointer to an object of MyClass
pObj->num = 123;  // Accessing member variable using arrow operator
pObj->func();   // Accessing member function using arrow operator
```

# `()` brackets vs `{}` brackets

## Initialisations

## Implicit type conversions

- When using parentheses for initialisation, C++ allows for implicit conversions from one type to another
  - For example, if you have a constructor that takes an integer argument, you can pass a floating-point value as an argument and it will be implicitly converted to an integer
- However, when using braces for initialisation, implicit conversions are not allowed
- This means that brace initialisation is more restrictive in terms of type conversions and can potentially prevent unintended conversions

```cpp
int a(5.5);  // Implicit narrowing conversion from double to int
int b{5.5};  // Error: narrowing conversion from double to int
```

## Narrowing conversions

- Parentheses allow for narrowing conversions, which means that values may be truncated or lost during the initialisation process
- For example, if you initialise an integer with a floating-point value using parentheses, the fractional part will be truncated
- Braces do NOT allow narrowing conversions, and if a narrowing conversion is attempted, the compiler will produce a warning or an error

## Aggregate initialisation

- Braces are used for aggregate initialisation, which allows you to initialise arrays, structures, and classes with a sequence of values enclosed in braces
- This feature is NOT available with parentheses
- With braces, you can also use designated initialisers to specify which members of a structure or class are initialised

## Empty initialiser

- With braces, you can use an empty initialiser (`{}`) to zero-initialise an object, whereas with parentheses, an empty initialiser is treated as a function declaration
  - For example, `int x{}`; will zero-initialise x to 0, whereas `int x();` declares a function named x that takes no arguments and returns an int

### Zero (0) initialisation for fundamental types

- When using parentheses for initialisation, C++ performs zero initialisation for fundamental types, such as int, float, double, etc
- This means that the variable will be initialised to zero or a zero-equivalent value
- In example below, the variable x is not actually initialised to zero, but instead, it is declared as a function that takes no arguments and returns an int
  - This is known as a function declaration, NOT an initialisation
  ```cpp
  int x();  // x is NOT initialised to zero!
  ```
- On the other hand, when using braces for initialisation, C++ performs zero initialisation for fundamental types as well as user-defined types
  - For example:
  ```cpp
  int y{};  // y is initialised to zero
  ```

### Default construction for user-defined types

- When using parentheses for initialisation, C++ performs default construction for user-defined types, such as classes with constructors
- This means that the default constructor of the class will be called, which may or may not initialise the object to a specific value
- In the example below, the variable obj is not actually initialised by the default constructor of MyClass, but instead, it is declared as a function that takes no arguments and returns a MyClass object
  - This is a function declaration, not an initialisation

```cpp
class MyClass {
public:
  MyClass() {
    // Custom constructor implementation
  }
};

MyClass obj();  // obj is NOT initialised by default constructor!
```

- On the other hand, when using braces for initialisation, C++ performs default construction for user-defined types as well
  - In example below, the variable obj is default-constructed using braces, which calls the default constructor of MyClass and initialises the object to its default state

```cpp
class MyClass {
public:
  MyClass() {
    // Custom constructor implementation
  }
};

MyClass obj{};  // obj is default-constructed
```

### Value Initialisation for aggregates

- When using braces for initialisation, C++ performs value initialisation for aggregates, which includes arrays, structs, and classes without user-defined constructors
- This means that each element or member of the aggregate will be initialised to zero or a zero-equivalent value
- For example
- Using braces `{}` for initialisation initialises the array elements and struct members to zero using value initialisation
- Using parentheses `()` for empty initialisation, however, does NOT perform value initialisation for aggregates
  - Instead, it may result in uninitialised variables or objects with undefined values

```cpp
int arr[3]{};  // Array elements are initialised to zero

struct Point {
  int x;
  int y;
};

Point p{};  // Struct members are initialised to zero
```

## Overload resolution

- When using parentheses for initialisation, C++ performs overload resolution based on the number and types of arguments passed
- However, when using braces for initialisation, C++ prefers to use constructors that take an initialiser list as an argument, if available
  - This can result in different behavior when resolving overloaded constructors

## Object Constructor

- `()` with no parameters is a function declaration, not an object creation, and is not recommended for object construction
- `{}` with no parameters creates objects with default initialisation
- `()` with a single parameter allows for type conversions when calling the constructor
- `{}` with a single parameter requires an exact match of types between the argument and the constructor's parameter, with no type conversions allowed

## Parentheses `()` with No Parameters

- This syntax declares a function named obj that takes no parameters and returns an object of type Type. It does not create an object of type Type
- This is known as a function declaration, not an object creation, and it may not behave as expected if you intend to create an object of Type
- Therefore, using `()` with no parameters for object constructors is NOT recommended, as it can lead to unexpected behavior

```cpp
Type obj();  // Parentheses used with no parameters
```

## Curly Braces `{}` with No Parameters

- This syntax creates an object of type Type with default construction
- If Type is a class type, the default constructor of Type will be called to initialise the object
- If Type is a built-in type, such as int or float, the object will be value-initialised, which initialises it with the default value for that type (e.g., 0 for int and 0.0 for float)
- Therefore, using `{}` with no parameters for object constructors is preferred for creating objects with default initialisation

```cpp
Type obj{};  // Curly braces used with no parameters
```

## Parentheses `()` with a Single Parameter

- This syntax calls the constructor of Type that takes a single argument of type compatible with arg and creates an object of type Type
- The argument `arg` is passed to the constructor and used to initialise the object
- If there is no constructor that takes a single argument of compatible type, a compilation error will occur
- Type conversions may be applied to the argument arg to match the constructor's parameter type
- Therefore, using `()` with a single parameter for object constructors is used for creating objects with explicit initialisation using a specific constructor

```cpp
Type obj(arg);  // Parentheses used with a single parameter
```

## Curly Braces `{}` with a Single Parameter

- This syntax calls the constructor of Type that takes a single argument of type compatible with arg and creates an object of type Type
- The argument `arg` is passed to the constructor and used to initialise the object
- If there is no constructor that takes a single argument of compatible type, a compilation error will occur
- Unlike with `()`, NO type conversions are allowed with `{}` for single-parameter constructors, which means that the argument arg must be of exactly the same type as the constructor's parameter
  - Unlike with parentheses `()`, the use of curly braces does NOT allow for implicit type conversions
  - The constructor must exactly match the type of arg, otherwise a compilation error will occur
- Therefore, using `{}` with a single parameter for object constructors is used for creating objects with explicit initialisation with strict type checking

```cpp
Type obj{arg};  // Curly braces used with a single parameter
```

## Stateless Function Objects Instantiation

- Stateless function objects, such as `std::hash` or `std::less`, are function objects that do NOT have any internal state or member variables
  - These function objects are typically used as generic function objects for algorithms or containers in the C++ Standard Library
- Stateless function objects can be instantiated using both parentheses (`()`) and curly braces (`{}`), but there are some differences:

  - Parentheses (`()`) invoke the default constructor of the function object directly
    - If the function object does NOT have a default constructor, a compilation error will occur
    - For example, if `std::hash` had a deleted or private default constructor, both `std::hash<std::string> hashFunc1;` and `std::hash<std::string> hashFunc2();` would result in a compilation error
  - Curly braces (`{}`) also invoke the default constructor of the function object, but they allow for more flexibility
    - If the function object does NOT have a default constructor, the curly braces (`{}`) will try to aggregate initialise the function object with an empty initialiser list, which may still work if the function object has other constructors that can take an empty initialiser list or if the function object is an aggregate type
    - For example, `std::hash` is an aggregate type, so `std::hash<std::string> hashFunc3{};` would still work even if std::hash did not have a default constructor

```cpp
// Stateless function object instantiation using parentheses
std::hash<std::string> hashFunc1;  // Default constructor
std::hash<std::string> hashFunc2();

// Stateless function object instantiation using curly braces
std::hash<std::string> hashFunc3{};  // Default constructor
```

- Equivalent usage
  - `std::hash<std::string>{}(s)` creates a temporary `std::hash` function object for the `std::string` type using the curly braces `{}`, and then calls the function object with the string `s` argument using parentheses `()`, which correctly generates the hash code for the string `s`

```cpp
std::string s = "Hello World";

std::hash<std::string> hashFunc1;
int hashCode = hashFunc1(string);

std::hash<std::string> hashFunc2();
int hashCode2 = hashFunc2(string);

int hashCode3 = std::hash<std::string>{}(s);
```

# `auto` keyword

- Automatic type inference
- The `auto` keyword is a type specifier that is used to let the compiler automatically deduce the data type of a variable from its initialiser
  - Type inference which allows the compiler to determine the appropriate type of a variable based on its usage and assignment

```cpp
auto x = 123;   // x is deduced as int
auto y = 3.14; // y is deduced as double
auto z = "hello"; // z is deduced as const char*

auto& ref = x; // ref is deduced as int& (reference to x)
auto const& cref = y; // cref is deduced as const double& (const reference to y)
auto* ptr = &z; // ptr is deduced as const char* (pointer to z)
```

Can use `auto` to automatically infer the type of the variable

```cpp
// for (int &num : nums) {
for (auto &num : nums) {
  //...
}
```

# `bool` (Boolean) Type

```cpp
bool b1 = true;
bool b2 = false;
```

# Default Function Parameter Values

- C++ supports default function parameter values

```cpp
void dfs(int currNode, int parentNode = -1) {
  //...
}
```

# Digit Grouping/Separator

```cpp
int mod = 1e9 + 7;
int mod = 1'000'000'007;
int mod = std::pow(10, 9) + 7;
```

# East `const` vs `const` West

- [Read more](https://hackingcpp.com/cpp/design/east_vs_west_const.html)

**SAME**

- `int i = 1;`
- `int &r = i;`
- `int *p = &i;`

| East `const`                                                     | `const` West                                                     |
| ---------------------------------------------------------------- | ---------------------------------------------------------------- |
| **What is LEFT of `const` is constant**                          | No consistency                                                   |
| `int const c = 1;`                                               | `const int c = 1;`                                               |
| `int const& cr = i;`                                             | `const int& cr = i;`                                             |
| (pointer) to (const int) <br> `int const *pc = &i;`              | (pointer) to (const int) <br> `const int *pc = &i;`              |
| (const pointer) to (int) <br> `int *const cp = &i;`              | (const pointer) to (int) <br> `int *const cp = &i;`              |
| (const pointer) to (const int) <br> `int const *const cpc = &i;` | (const pointer) to (const int) <br> `const int *const cpc = &i;` |

## Class Member Functions

**NO difference between east and west const, but consistent with east const**

```cpp
// Only callable on const values
void MyClass::foo() const;
// Only callable on const lvalues C++11
void MyClass::bar() const&;
```

## Constrained `auto` (C++20)

```cpp
#include <concepts>
using std::regular;
// type of 'a' must be "regular"
regular auto   a = f();
regular auto&  b = f();
regular auto&& c = f();
```

| East `const`                            | `const` West                         |
| --------------------------------------- | ------------------------------------ |
| **What is LEFT of `const` is constant** | No consistency                       |
| `regular auto const  v = f();`          | `const regular auto  v = f();`       |
| `regular auto const& w = f();`          | `const regular auto& w = f();`       |
| `regular auto const* x = f();`          | `const regular auto* x = f();`       |
| `regular auto *const y = f();`          | `regular auto *const y = f();`       |
| `regular auto const*const z = f();`     | `const regular auto *const z = f();` |

# For Loops

- Tips:
  - Use `auto`
  - Use references `&` to avoid expensive value initialisation (value copying) of variables

```cpp
// for (int &num : nums) {
for (auto &num : nums) {
  //...
}
```

# Initialisation

Usage of following containers normally starts off as **empty** (we insert elements into them); therefore we do **NOT** need to initialise (in function body) after declaring it at the top of a class for the following containers

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

Usage of `std::vector` normally does **NOT** stat off as empty (we expect all values to be initialised to `0` or `-1`, and do not want to call `.push_back()` or `.emplace_back()`); therefore we **DO** need to initialise (in function body) after declaration

- However the opposite is true (i.e. usage of `std::vector` as empty) when `std::vector` is used as an inner container for `std::unordered_map<int, std::vector<int>` or `std::pair<int, std::vector<int>`

  - In this opposite case, we do NOT need to initialise the `std::vector` as it will be automatically initialised to be empty and can straight away call `.push_back()` or `.emplace_back()` on it

- `std::vector`

```cpp
class Solution {
public:
  std::vector<std::vector<int>> list;

  void myFunction(int a, int b) {
    list = std::vector<std::vector<int>>(5, std::vector<int>(5, -1));
    if (list[a][b] == -1) {
      list[a][b] = 5;
    }
  }
};

int main() {
  Solution s;
  s.myFunction(1, 2);
  std::cout << s.list[1][2];
}
// 5
```

## `int[]` array

- Note there is **NO** way to initialise an `int[]` array in C++ without knowing initial size (unless you use pointers)
  - **NO** equivalent of Java's `int[] array;`

```cpp
int arr[5] = {1, 2 ,3, 4, 5};
```

```cpp
// Initialise to 0
int arr[5] = {};
```

- `int arr[5] = {0};`
  - Is INCORRECT since it initialises first value to 0 and rest is default value initialised and 0 happens to be the default value

```cpp
// Initialise to -1
int arr[5];
std::fill(std::begin(arr), std::end(arr), -1);
```

```cpp
// Initialise to -1
int arr[5];
memset(arr, -1, sizeof(arr));
```

```cpp
// Only supported by clang compiler (not gcc or g++)
int arr[10] = {[0] = 0, [1 ... 9] = -1}
```

```cpp
// Initialises FIRST element to -1 and the REST to 0
int arr1[5]{-1};
int arr2[5] = {-1};
```

## `int[][]` array

- Note there is **NO** way to initialise an `int[][]` array in C++ without knowing initial size (unless you use pointers)
  - **NO** equivalent of Java's `int[][] array;`

```cpp
int arr[5][2] = {{1, 2} {3, 4}, {5, 6}, {7, 8}, {9, 10}};
```

```cpp
// Initialise to 0
int arr[5][5] = {};
```

```cpp
// Initialise to -1
int arr[5][5];
memset(arr, -1, sizeof(arr));
```

```cpp
// Initialise to -1
int arr[5][5];
for (auto& row : arr) {
  std::fill(row.begin(), row.end(), -1);
}
```

```cpp
// Initialise to -1
int arr[5][5];
std::for_each(std::begin(arr), std::end(arr), [](auto &row) {
  std::fill(std::begin(row), std::end(row), -1);
});
```

```cpp
// Initialise to -1
std::for_each(arr.begin(), arr.end(), [](auto& row) {
  std::for_each(row.begin(), row.end(), [](int& val) {
    val = -1;
  });
});
```

## `std::vector`

## 1D Vector

- `vec.push_back()` **constructs** an object of the vector's value type and **copies** it into the vector
  - `.push_back()` constructs a new object by copying the provided argument, and then moves that object into the vector
- `vec.emplace_back()` **constructs** a new object **in place** at the end of the vector
  - `.emplace_back()` avoids creating a temporary object and copying it into the vector
- The difference between the two methods is most noticeable when working with objects that are expensive to copy or move
  - E.g. if you have a vector of strings, using `.push_back()` to add a new string to the end of the vector involves creating a new string object and copying the contents of the argument into it
    - This can be expensive, especially if the string is large
    - Using `.emplace_back()`, on the other hand, constructs the new string object directly within the vector using the arguments provided, which can be faster

### `std::vector<int>`

```cpp
// Initialise with a default-constructed vector of a given size:
std::vector<int> vec(n); // Creates a vector of size n with all elements initialized to 0
```

```cpp
// Initialise with a given size and default value:
std::vector<int> vec(n, -1); // Creates a vector of size n with all elements initialized to -1
```

```cpp
// Initialise with a default-constructed vector of a given size:
std::vector<int> vec;
vec = std::vector<int>(n, -1); // Creates a vector of size n with all elements initialized to -1
```

```cpp
std::vector<int> vec;
vec.resize(n); // Initialised to 0
```

```cpp
std::vector<int> vec;
vec.resize(n, -1); // Initialised to 0
```

```cpp
std::vector<int> vec(n);
std::fill(vec.begin(), vec.end(), -1);
```

```cpp
// Initialise with a list of values:
std::vector<int> vec1 {1, 2, 3, 4, 5};
std::vector<int> vec2 = {1, 2, 3, 4, 5};
```

```cpp
// Default constructor (no initialisation)
std::vector<int> vec;
// vec.push_back(1);
// vec.push_back(2);
// vec.push_back(3);
vec.emplace_back(1);
vec.emplace_back(2);
vec.emplace_back(3);
// vec now contains {1, 2, 3}
```

```cpp
// Uniform initialisation / Value initialisation constructor
std::vector<int> vec{};
// vec.push_back(1);
// vec.push_back(2);
// vec.push_back(3);
vec.emplace_back(1);
vec.emplace_back(2);
vec.emplace_back(3);
// vec now contains {1, 2, 3}
```

```cpp
// Initialise with a range of values using iterators:
int arr[] = {1, 2, 3, 4, 5};
std::vector<int> vec(arr, arr + 5); // Creates a vector with elements from arr[0] to arr[4]
```

```cpp
// Initialise with another vector:
std::vector<int> vec1 = {1, 2, 3};
std::vector<int> vec2(vec1); // Creates a copy of vec1
```

```cpp
// Initialise with a lambda expression
std::vector<int> vec(n);
std::iota(vec.begin(), vec.end(), 1); // Creates a vector with values 1 to 5
```

```cpp
// Initialise with a range of values using std::copy
int arr[] = {1, 2, 3, 4, 5};
std::vector<int> vec;
std::copy(arr, arr + 5, std::back_inserter(vec)); // creates a vector with elements from arr[0] to arr[4]
```

```cpp
// Initialize with a range of values using std::transform
std::vector<int> vec = {1, 2, 3, 4, 5};
std::transform(vec.begin(), vec.end(), vec.begin(), [](int x) { return x * 2; }); // multiplies each element by 2
```

```cpp
// Initialise with a range of values using std::generate
std::vector<int> vec(n);
int value = 1;
std::generate(vec.begin(), vec.end(), [&value]() { return value++; }); // creates a vector with values 1 to 5
```

### `std::vector<std::pair<int, std::string>>`

```cpp
std::vector<std::pair<int, std::string>> vec;
// vec.push_back(std::make_pair(1, "one"));
// vec.push_back(std::make_pair(2, "two"));
vec.emplace_back(std::make_pair(1, "one"));
vec.emplace_back(std::make_pair(2, "two"));
```

```cpp
std::vector<std::pair<int, std::string>> vec = {{1, "one"}, {2, "two"}};
```

```cpp
std::vector<std::pair<int, std::string>> vec{{1, "one"}, {2, "two"}};
```

```cpp
std::vector<std::pair<int, std::string>> vec(n);
vec[0] = {1, "one"};
vec[1] = {2, "two"};
```

```cpp
std::vector<std::pair<int, std::string>> vec;
vec.resize(n);
vec[0] = {1, "one"};
vec[1] = {2, "two"};
```

## 2D Vector

### `std::vector<std::vector<int>>`

```cpp
std::vector<std::vector<int>> vec(dim1, std::vector<int>(dim2, -1));
```

```cpp
std::vector<std::vector<int>> vec;
vec = std::vector<std::vector<int>>(dim1, std::vector<int>(dim2, -1));
```

```cpp
std::vector<std::vector<int>> vec;
vec.resize(dim1, std::vector<int>(dim2, -1));
```

```cpp
std::vector<std::vector<int>> vec1 {{1, 2}, {3, 4}, {5, 6}};
std::vector<std::vector<int>> vec2 = {{1, 2}, {3, 4}, {5, 6}};

```

```cpp
std::vector<std::vector<int>> vec;
// vec.push_back(std::vector<int>{1, 2, 3});
// vec.push_back(std::vector<int>{4, 5, 6});
vec.emplace_back(std::vector<int>{1, 2, 3});
vec.emplace_back(std::vector<int>{4, 5, 6});
```

```cpp
std::vector<std::vector<int>> vec;
vec.resize(dim1, std::vector<int>(dim2));
for (auto& row : vec) {
  std::fill(std::begin(row), std::end(row), -1);
}
```

```cpp
std::vector<std::vector<int>> vec;
vec.resize(dim1, std::vector<int>(dim2));
std::for_each(std::begin(vec), std::end(vec), [&](std::vector<int>& row) {
  std::fill(std::begin(row), std::end(row), -1);
});
```

```cpp
// Creates a 2d std::vector<std::vector<int>> with 'n' EMPTY rows
std::vector<std::vector<int>> vec(n);
// for (int i = 0; i < n; i++) {
//   for (int j = 0; j < n; j++) {
//     vec[i].emplace_back(1);
//   }
// }
// 1 1 1
// 1 1 1
// 1 1 1
```

### Initialise Single ROW of 2D Vector

```cpp
// 2d vector of size m * n
int m = 10;
int n = 10;
std::vector<std::vector<int>> dp(m, std::vector<int>(n, 0));
// Fill ROW 0
std::fill(dp[0].begin(), dp[0].end(), 1);
```

### Initialise Single COLUMN of 2D Vector

```cpp
// 2d vector of size m * n
int m = 10;
int n = 10;
std::vector<std::vector<int>> dp(m, std::vector<int>(n, 0));
// Fill COLUMN 0
int targetCol = 0;
std::for_each(matrix.begin(), matrix.end(), [&targetCol](std::vector<int>& row) { // Can either capture `targetCol` by reference or by value/by copy
  row[targetCol] = 1;
});
```

### `std::vector<std::vector<std::pair<int, std::string>>>`

```cpp
std::vector<std::vector<std::pair<int, std::string>>> vec(n);
// vec[0].push_back(std::make_pair(1, "one"));
// vec[1].push_back(std::make_pair(2, "two"));
vec[0].emplace_back(std::make_pair(1, "one"));
vec[1].emplace_back(std::make_pair(2, "two"));
```

```cpp
std::vector<std::vector<std::pair<int, std::string>>> vec = {
  {{1, "one"}, {2, "two"}},
  {{3, "three"}, {4, "four"}}
  {{5, "five"}, {6, "six"}}
};
```

```cpp
std::vector<std::vector<std::pair<int, std::string>>> vec;
// Create inner list of 'n' std::vector containers
for (int i = 0; i < n; i++) {
  vec.emplace_back();
}
// vec[0].push_back(std::make_pair(1, "one"));
// vec[1].push_back(std::make_pair(2, "two"));
vec[0].emplace_back(std::make_pair(1, "one"));
vec[1].emplace_back(std::make_pair(2, "two"));
// std::cout << vec[0][0].second;
// std::cout << vec[1][0].second;
```

```cpp
std::vector<std::vector<std::pair<int, std::string>>> vec;
vec.resize(dim1, std::vector<std::pair<int, std::string>>(dim2, {-1, "default"}));
vec[0][0] = {1, "one"};
vec[1][1] = {2, "two"};
```

```cpp
std::vector<std::vector<std::pair<int, std::string>>> vec(dim1, std::vector<std::pair<int, std::string>>(dim2));
vec[0][0] = {1, "one"};
vec[1][1] = {2, "two"};
```

## 3D Vector

### `std::vector<std::vector<std::vector<int>>>`

```cpp
std::vector<std::vector<std::vector<int>>> vec(dim1, std::vector<std::vector<int>>(dim2, std::vector<int>(dim3, -1)));
```

```cpp
std::vector<std::vector<std::vector<int>>> vec;
vec = std::vector<std::vector<std::vector<int>>>(dim1, std::vector<std::vector<int>>(dim2, std::vector<int>(dim3, -1)));
```

```cpp
std::vector<std::vector<std::vector<int>>> vec;
vec.resize(dim1, std::vector<std::vector<int>>(dim2, std::vector<int>(dim3, -1)));
```

```cpp
std::vector<std::vector<std::vector<int>>> vec = {
  {{1, 2}, {3, 4}},
  {{5, 6}, {7, 8}}
  {{9, 10}, {11, 12}}
};
```

## `std::list`

- **`std::list<std::pair<int, std::string>>`**

```cpp
std::list<std::pair<int, std::string>> list;
// list.push_back(std::make_pair(1, "one"));
list.emplace_back(std::make_pair(1, "one"));
// list.push_back(std::make_pair(2, "two"));
list.emplace_back(std::make_pair(2, "two"));
// list.push_back(std::make_pair(3, "three"));
list.emplace_back(std::make_pair(3, "three"));
```

```cpp
std::list<std::pair<int, std::string>> list = {
  {1, "one"},
  {2, "two"},
  {3, "three"}
};
```

## `std::deque`

```cpp
std::deque<std::vector<int>> deque;
// deque.push_back({1, 2});
// deque.push_back({3, 4});
deque.emplace_back({1, 2});
deque.emplace_back({3, 4});
```

```cpp
std::deque<std::vector<int>> deque = { {1, 2}, {3, 4}, {5, 6} };
```

```cpp
// Create deque of size 'n', where each element is an empty std::vector
std::deque<std::vector<int>> deque(n);
```

```cpp
// Create deque of size 'm'
// All 'm' indices each contain a std::vector of size 'n' initialised to -1
std::deque<std::vector<int>> deque(m, std::vector<int>(n, -1))
```

## `std::set` + `std::unordered_set`

```cpp
// Default constructor
std::unordered_set<int> set;
set.insert(1);
set.insert(2);
set.emplace(3);
set.emplace(4);
```

```cpp
// Initialiser List
std::unordered_set<int> set = {1, 2, 3, 4, 5};
```

```cpp
// Range Constructor
std::vector<int> vec = {1, 2, 3, 4, 5};
std::unordered_set<int> set(vec.begin(), vec.end());
```

```cpp
// Copy Constructor
std::unordered_set<int> set1 = {1, 2, 3, 4, 5};
std::unordered_set<int> set2(set1);
```

## `std::map` + `std::unordered_map`

```cpp
std::map<int, std::vector<int>> map;
```

```cpp
std::map<int, std::vector<int>> map = {
  std::make_pair(1, std::vector<int>{11, 111}),
  std::make_pair(2, std::vector<int>{22, 222}),
  std::make_pair(3, std::vector<int>{33, 333})
};
```

```cpp
std::map<int, std::vector<int>> map = {
  {1, {11, 111}},
  {2, {22, 222}},
  {3, {33, 333}}
};
```

```cpp
// Create an empty map
std::unordered_map<int, int> map1;
std::unordered_map<int, std::string> map2;
std::unordered_map<int, std::vector<int>> map3;
map3[1].push_back(2);
```

```cpp
// Initialiser List
std::unordered_map<int, std::string> map = {{1, "one"}, {2, "two"}, {3, "three"}, {4, "four"}, {5, "five"}};
```

```cpp
// Copy Initialisation
std::unordered_map<int, std::string> map1 = {{1, "one"}, {2, "two"}, {3, "three"}, {4, "four"}, {5, "five"}};
std::unordered_map<int, std::string> map2 = map1;
```

```cpp
// Range Initialisation
std::vector<std::pair<int, std::string>> vec = {{1, "one"}, {2, "two"}, {3, "three"}, {4, "four"}, {5, "five"}};
std::unordered_map<int, std::string> map(vec.begin(), vec.end());
```

## `std::unordered_map.reserve()`

- Reserves space for at least the specified number of elements and regenerates the hash table
- Trick/Hack if you do **NOT** want rehashing to occur which would invalidate all existing iterators

```cpp
std::unordered_map<int, std::vector<int>> dp;
dp.reserve(1 << n); // Reserve space in advance to avoid hash collisions (which will invalidate all existing iterators)
```

## `std::stack`

```cpp
std::stack<int> stack;
```

```cpp
std::stack<int> stack({1, 2, 3, 4, 5});
// std::stack<int> stack{1, 2, 3, 4, 5}; // Only available in C++20 onwards
```

## `std::queue`

```cpp
std::queue<int, std::deque<int>> queue;
```

```cpp
std::queue<int> q({1, 2, 3, 4, 5});
// std::queue<int> q{1, 2, 3, 4, 5}; // Only available in C++20 onwards
```

## `std::priority_queue`

- Note `std::priority_queue<int[]>` is **NOT** supported use `std::vector<int>` instead

```cpp
std::priority_queue<std::vector<int>> pq;
```

```cpp
auto cmp = [](const std::vector<int>& a, const std::vector<int>& b) {
  return a[0] == b[0] ? a[1] < b[1] : a[0] < b[0];
};
std::priority_queue<std::vector<int>, std::vector<std::vector<int>>, decltype(cmp)> pq(cmp);
```

```cpp
struct MyComparator {
  auto operator()(const std::vector<int>& a, const std::vector<int>& b) const {
    return a[0] == b[0] ? a[1] < b[1] : a[0] < b[0];
  }
};
std::priority_queue<std::vector<int>, std::vector<std::vector<int>>, MyComparator> pq;
```

```cpp
// Only available in C++20 onwards
std::priority_queue<std::vector<int>, std::vector<std::vector<int>>, [](const std::vector<int>& a, const std::vector<int>& b) {
    return a[0] == b[0] ? a[1] < b[1] : a[0] < b[0];
}> pq;
```

## `std::pair`

```cpp
std::pair<int, std::string> pair(1, "hello");
// std::cout << pair.first << ', ' << pair.second;
```

```cpp
std::pair<int, std::string> pair{2, "world"};
// std::cout << pair.first << ', ' << pair.second;
```

```cpp
std::pair <std::string,double> pair;
pair = std::make_pair(1, "hello");
// std::cout << pair.first << ', ' << pair.second;
```

```cpp
std::pair<int, std::string> pair = std::make_pair(3, "universe");
// std::cout << pair.first << ', ' << pair.second;
```

# Iterators

- Analogy = **Generalised Pointer**
- Access members with either `iter->member` or `(*iter).member`

## `.` dot operator vs `->` arrow operator

- In C++, iterators are objects that provide a way to access the elements of a container such as an array, a vector, or a list
  - The dot operator (`.`) is used to access the members of an object, but it cannot be used with iterators returned by the `.begin()` function because iterators are NOT objects, they are pointers or objects that behave like pointers
- When an iterator is dereferenced using the `*` operator, it returns a reference to the element that the iterator is pointing to
  - For example, if we have a vector `vec` and an iterator `it` that points to the first element of the vector, we can access that element using the expression `*it`
- However, if we try to use the dot operator (`.`) to access the members of the element, such as `it.size()`, we will get a compilation error
  - This is because the dot operator is used to access the members of an object, and the element that the iterator is pointing to is NOT an object, but a value
- To access the members of the element, we need to dereference the iterator first and then use the dot operator (`.`) on the result
  - For example, if `vec` is a vector of objects that have a member function `.size()`, we can access the size of the first element using the expression `(*it).size()` or alternatively, we can use the arrow operator `it->size()`

```cpp
std::vector<std::vector<int>> vec = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
// std::vector<std::vector<int>>::iter = vec.begin();
auto iter2 = vec.begin();
for (; iter != vec.end(); iter++) {
  std::cout << iter->size();
  // std::vector<int>& inner_vec = *iter;
  // for (int elem : inner_vec) {
  //   std::cout << elem << ' ';
  // }
}
```

## Invalidation

- `std::map<int,vector<int>>` CANNOT be replaced by `std::unordered_map<int, vector<int>>` because in the code below, if rehashing occurs due to the insertion, **all iterators are INVALIDATED**
- [Read more](https://leetcode.com/problems/smallest-sufficient-team/discuss/334832/c%2B%2B-dp-bitmask-solution-with-algorithm)

```cpp
if (dp.find(comb) == dp.end() || dp[comb].size() > 1 + dp[it->first].size()) {
  dp[comb]=it->second;
  dp[comb].push_back(i);
}
```

# Lambda Expressions

- Lambda expressions are a feature introduced in C++11 that allows you to create small, anonymous functions (also known as "closures") directly in your code
  - Lambda expressions provide a concise way to define function objects, which are objects that behave like functions
  - They are useful in situations where you need to pass a function as an argument to another function, or when you want to create a short, throwaway function for a specific purpose

## Syntax / Parts of a Lambda Expression

- Brackets go from ordered to messy `[](){}`

```cpp
[captureList] (parameters) -> returnType {
  // Function Body
}
```

## Capture List

- The **capture list** is used to capture variables from the surrounding scope, making them available for use in the lambda expression
- You specify the capture list using square brackets `[]`
- Note capture list can be empty `[]`

### Capture "all by value/by copy"

- **By value**: `[=]` captures all variables from the surrounding scope by value
- Any changes made to the captured variables inside the lambda expression do NOT affect the original variables in the surrounding scope

```cpp
int x = 1;
int y = 2;

auto lambda = [=]() {
  std::cout << "Captured all values by value/by copy: " << "x = " << x << ", y = " << y << std::endl;
  std::cout << "Captured x: " << x << std::endl;
  std::cout << "Captured y: " << y << std::endl;
  // x = 3; // NOT allowed
  // y = 4; // NOT allowed
};

lambda();
```

### Capture "all by reference"

- **By reference**: `[&]` captures all variables from the surrounding scope by reference
- Any changes made to the captured variables inside the lambda expression will affect the original variables in the surrounding scope

```cpp
int x = 1;
int y = 2;

auto lambda = [&]() {
  std::cout << "Captured all values by reference: " << "x = " << x << ", y = " << y << std::endl;
  std::cout << "Captured x: " << x << std::endl;
  std::cout << "Captured y: " << y << std::endl;
  x = 3; // Modifying x
  y = 4; // Modifying y
};

lambda(); // Captured x: 1, Captured y: 2
std::cout << "Updated x: " << x << std::endl; // Updated x: 3
std::cout << "Updated y: " << y << std::endl; // Updated y: 4
```

### Capture "by specific variable by value/by copy"

- **By specific variable**: `[var1, var2, ...]` captures specific variables from the surrounding scope by value
- Any changes made to the captured variables inside the lambda do not affect the original variables outside the lambda

```cpp
int x = 1;
int y = 2;
auto lambda = [x, y]() {
  std::cout << "Captured x by value/by copy: " << x << std::endl;
  std::cout << "Captured y by value/by copy: " << y << std::endl;
  // x = 3; // NOT allowed
  // y = 4; // NOT allowed
};

lambda();
```

### Capture "by specific variable by reference"

- **By specific variable by reference**: `[&var1, &var2, ...]` captures specific variables from the surrounding scope by reference
- Any changes made to the captured variables inside the lambda directly affect the original variables outside the lambda

```cpp
int x = 1;
int y = 2;
auto lambda = [&x, &y]() {
  std::cout << "Captured x by reference: " << x << std::endl;
  std::cout << "Captured y by reference: " << y << std::endl;
  x = 3;
  y = 4;
};

lambda();
std::cout << "Updated x: " << x << std::endl; // Updated x: 3
std::cout << "Updated y: " << y << std::endl; // Updated y: 4
```

### Make capture "by value/by copy" mutable

- Can use the **`mutable`** keyword with a lambda to allow modifying captured variables even when capturing by value
- Without the `mutable` keyword, the lambda would NOT be able to modify the captured variable

```cpp
int x = 123;

auto lambda = [=]() mutable {
  x = 456; // Modifying x, even when capturing by value
};

lambda();
std::cout << "Updated x: " << x << std::endl; // Updated x: 456
```

### Equivalent Captures

- Example, if apple lambda body accesses the external variable `apple` by reference and the external variable `banana` by value, then the following capture clauses are equivalent:

```cpp
// Equivalent
[&apple, banana](){};
[banana, &apple](){};
[&, banana](){};
[=, &apple](){};
```

## Parameters

- The parameters are a comma-separated list of parameters that the lambda expression takes
  - The parameters are similar to function parameters, and you can specify their types explicitly or let the compiler deduce the types

## Return Type

- The return type specifies the return type of the lambda expression
  - If the lambda expression does NOT return a value, you can use void or omit the return type
  - If the lambda expression has a single return statement and the return type can be deduced from that statement, you can also omit the return type
  - The return type can be omitted or `auto`

## Function Body

- The function body contains the code that makes up the body of the lambda expression
  - It can include any valid C++ code, including expressions, statements, and even other lambda expressions
- Note the keyword `return` can be omitted in the function body if and only if the return type can be deduced by the compiler

```cpp
auto add = [](int x, int y) -> int {
  return x + y;
};

int result = add(123, 456); // Call the lambda expression like a regular function
std::cout << "Result: " << result << std::endl; // Result: 579
```

```cpp
auto lambda1 = [](int a, int b) { return a + b; };
auto lambda2 = [](int a, int b) { a + b; };
```

## Examples

```cpp
class Solution {
public:
  int main() {
    std::vector<int> nums = {10, 3, 5, 8, 11, 1, 7};

    // Sort the vector in descending order using a lambda expression
    // std::sort(nums.rbegin(), nums.rend()); // Hacky way
    std::sort(nums.begin(), nums.end(), [](int a, int b) {
      return a > b;
      // return b < a // can also do
    });
  }
};
```

```cpp
auto myConcatenate = [](const std::string& str1, const std::string& str2) -> auto {
  return str1 + str2;
};

std::string result = myConcatenate("Hello, ", "World!"); // Call the lambda expression like a regular function
std::cout << "Result: " << result << std::endl; // Result: Hello, World!
```

## Usage with `std::accumulate()`

```cpp
#include <iostream>
#include <bits/stdc++.h>

int main() {
  // Create a vector of integers
  std::vector<int> nums = {1, 2, 3, 4, 5};
  // Use std::accumulate with a lambda expression
  // acc = Accumulated sum
  // val = Current value from the range
  int sum = std::accumulate(nums.begin(), nums.end(), 0, [](int acc, int val) {
    // Return the updated sum
    return acc + val;
  });
  std::cout << "Sum: " << sum << std::endl;
  return 0;
}
```

## Usage with `std::sort()`

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

# LeetCode / Competitive Programming

## `char` Type

- Sometimes `char` (-127 to 128) types are used instead/in-place of `int` types because we only need small range of (-127 to 128)
- This behaviour should be **avoided**, use `int` instead
- Follow the `Character` interface usage behaviour of Java where `Character` is only used for characters such as `'a'` and not for ints

## Global Variables

```cpp
class Solution {
public:
  std::vector<std::string> words;
  std::vector<int> score;

  int dfs(int i, std::vector<int> &count) {
    if (i >= words.size()) {
      return 0;
    }
    int skipCurrWord = dfs(i + 1, count);
    int wordScore = 0;
    bool isValid = true;
    std::vector<int> newCount(std::begin(count), std::end(count));
    for (auto ch : words[i]) {
      newCount[ch - 'a']--;
      if (newCount[ch - 'a'] < 0) {
        isValid = false;
      }
      wordScore += score[ch - 'a'];
    }
    return std::max(skipCurrWord, isValid ? (wordScore + dfs(i + 1, newCount)) : 0);
  }

  int maxScoreWords(std::vector<std::string> &words, std::vector<char> &letters, std::vector<int> &score) {
     this->words = words;
    this->score = score;
    std::vector<int> count(26);
    for (auto ch : letters) {
      count[ch - 'a']++;
    }
    return dfs(0, count);
  }
};
```

## Header Files (import)

```cpp
#include <bits/stdc++.h>
// using namespace std;
```

- Example Format
  - See 2581.count-number-of-possible-root-nodes

## Iterators

- `std::map<int,vector<int>>` cannot be replaced by `std::unordered_map<int, vector<int>>` because in the code below, if rehashing occurs due to the insertion, **all iterators are INVALIDATED**
- [Read more](https://leetcode.com/problems/smallest-sufficient-team/discuss/334832/c%2B%2B-dp-bitmask-solution-with-algorithm)

```cpp
if (dp.find(comb) == dp.end() || dp[comb].size() > 1 + dp[it->first].size()) {
  dp[comb]=it->second;
  dp[comb].push_back(i);
}
```

## Java Equivalent

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

If `nums` was `int[]` instead of `std::vector<int>`

```cpp
class Solution {
public:
  int* arr;

  int myFunc(int[] nums) {
    this->arr = nums;
    for (auto i = 0; i < nums.size(); i++) {
      // std::cout << nums[i];
    }
  }
};
```

## `long long` Type

- `long long == long long int` (the `int` is optional)
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

## Pass by Reference `&`

- Remember to always **pass by reference** `&` and **NOT** pass by value, **when passing variables to functions** (such as containers) **to avoid TLE** (if you choose to NOT have global variables)
- Also remember to **loop over** keys/values of container **by reference**
  - `for (auto &value : container)`

```cpp
class Solution {
public:
  int dfs(int i, std::vector<int> &count, std::vector<std::string> &words, std::vector<int> &score) {
    if (i >= words.size()) {
      return 0;
    }
    int skipCurrWord = dfs(i+1, count, words, score);
    int wordScore = 0;
    bool isValid = true;
    std::vector<int> newCount(std::begin(count), std::end(count));
    for (auto ch : words[i]) {
      newCount[ch - 'a']--;
      if (newCount[ch - 'a'] < 0) {
        isValid = false;
      }
      wordScore += score[ch - 'a'];
    }
    return std::max(skipCurrWord, isValid ? (wordScore + dfs(i+1, newCount, words, score)) : 0);
  }

  int maxScoreWords(std::vector<std::string> &words, std::vector<char> &letters, std::vector<int> &score) {
    std::vector<int> count(26);
    for (auto ch : letters) {
      count[ch - 'a']++;
    }
    return dfs(0, count, words, score);
  }
};
```

## TLE

- Interestingly **passing containers by reference** is **faster** then **creating global containers** and can help avoid TLE
  - **This is because glboal containers need to be copy constructed**
- These two code snippets are both implementations of the same class and functionality in C++
  - The first version of the code uses local variables and function parameters while the second uses class member variables
- The first version (Code 1) might be faster due to reduced memory overhead compared to the second version (Code 2)
  - The difference in speed is due to the use of class member variables in Code 2, which introduces additional memory overhead
- Here are some specifics:

  1. Memory allocation and deallocation: In Code 2, `requiredQuantity` and `counts` are class member variables
     - They live as long as the object of the class `Solution` lives
     - This means that memory for these variables is allocated when the object is created and deallocated when the object is destroyed
     - On the other hand, in Code 1, `requiredQuantity` and `counts` are local variables, so the memory for these variables is allocated at the start of the function and deallocated at the end of the function
     - This could make Code 1 faster if the function is called multiple times, as it avoids the overhead of memory allocation and deallocation
  2. Passing arguments to functions: In Code 1, the counts and `requiredQuantity` vectors are passed by reference to the `canAssign` function
     - This is faster than accessing them as member variables in Code 2 because passing by reference avoids the overhead of looking up the member variables.

- **FASTER**

```cpp
#include <bits/stdc++.h>

class Solution {
public:

  bool canDistribute(std::vector<int> &nums, std::vector<int> &requiredQuantity) {
    std::unordered_map<int, int> numToOccurence;
    for (auto &num : nums) {
      numToOccurence[num] += 1;
    }
    std::vector<int> counts;
    for (auto &kv : numToOccurence) {
      counts.push_back(kv.second);
    }
    std::sort(requiredQuantity.begin(), requiredQuantity.end(), [](int a, int b) { return a > b; });
    std::sort(counts.begin(), counts.end(), [](int a, int b) { return a > b; });
    return canAssign(0, counts, requiredQuantity);
  }

  bool canAssign(int i, std::vector<int> &counts, std::vector<int> &requiredQuantity) {
    if (i == requiredQuantity.size()) {
      return true;
    }

    for (int j = 0; j < counts.size(); j++) {
      if (counts[j] >= requiredQuantity[i]) {
        counts[j] -= requiredQuantity[i];
        if (canAssign(i + 1, counts, requiredQuantity)) {
          return true;
        }
        counts[j] += requiredQuantity[i];
      }
    }
    return false;
  }
};
```

- **SLOWER**

```cpp
#include <bits/stdc++.h>

class Solution {
public:
  std::vector<int> requiredQuantity;
  std::vector<int> counts;

  bool canDistribute(std::vector<int> &nums, std::vector<int> &requiredQuantity) {
    this->requiredQuantity = requiredQuantity;
    std::unordered_map<int, int> numToOccurence;
    for (auto &num : nums) {
      numToOccurence[num] += 1;
    }
    for (auto &kv : numToOccurence) {
      counts.push_back(kv.second);
    }
    // std::sort(requiredQuantity.rbegin(), requiredQuantity.rend());
    std::sort(this->requiredQuantity.begin(), this->requiredQuantity.end(), [](int a, int b) { return a > b; });
    std::sort(counts.begin(), counts.end(), [](int a, int b) { return a > b; });
    return canAssign(0);
  }

  bool canAssign(int i) {
    if (i == requiredQuantity.size()) {
      return true;
    }

    for (int j = 0; j < counts.size(); j++) {
      if (counts[j] >= requiredQuantity[i]) {
        counts[j] -= requiredQuantity[i];
        if (canAssign(i + 1)) {
          return true;
        }
        counts[j] += requiredQuantity[i];
      }
    }
    return false;
  }
};
```

# Null Type

- In C++, there is **NO** "`null` type" and instead has a special value called **`nullptr`** that represents a null pointer
  - The `nullptr` keyword was introduced in C++11 to provide a better alternative to the C-style NULL macro, which is a preprocessor macro that evaluates to an integer zero

# Placement of Identifiers/Operators

## NO difference

```cpp
int num = 4
int& ref1 = num;
int &ref2 = num;
ref1++; // increments num to 5
ref2++; // increments num to 6
std::cout << num << std::endl;
// Output: 6
```

## Difference

```cpp
// Declares `a` as an `int&` and `b` as an `int`
int& a, b; // == `int &a, b` == `int &a; int b`;
```

```cpp
int const* a; // pointer to const int
int* const a; // const pointer to int
```

- **Trick is to read from RIGHT to LEFT**
  - **`*`** = pointer
  - **`const`** = const
- **`int const* a;`** declares a pointer variable `a` that can point to an integer, but the integer it points to is `const` and CANNOT be modified through `a`

  - I.e. `a` is a non-const pointer to a const integer
  - Example

    ```cpp
    int a = 1;
    int b = 2;
    int const* c = &a; // `c` points to const int `a`
    *c = 3; // COMPILE ERROR: CANNOT modify const int `a`
    c = &b; // Valid: `c` can be made to point to a different const int (point to a different address)
    ```

- **`int* const a;`** declares a pointer variable `a` that is itself `const`, meaning it cannot be modified to point to a different address

  - However, the integer it points to is NOT const and can be modified through a
  - I.e. `a` is a const pointer to a non-const integer
  - Example

    ```cpp
    int a = 1;
    int b = 2;
    int* const c = &a; // `c` is a const pointer to non-const int `a`
    *c = 3; // Valid: `a` can be modified through `c`
    c = &b; // COMPILE ERROR: const pointer CANNOT be modified to point to a different address
    ```

# Reference vs Pointer

- References are non-null, require initialisation at declaration, cannot be reassigned, and do not require manual memory management
- Pointers can be null, require manual memory management, support pointer arithmetic, can be reassigned

## Syntax

- References are declared using the ampersand (`&`) symbol
- Pointers are declared using the asterisk (`*`) symbol

```cpp
int x = 123;
int& ref = x; // reference to x
int* ptr = &x; // pointer to x
```

## Initialisation

- References MUST be initialised upon declaration and CANNOT be re-assigned to refer to a different object after initialisation
- Pointers can be declared WITHOUT initialisation and can be re-assigned to point to different objects at any time

```cpp
int x = 123;
int y = 456;

// Valid
int& ref = x;
ref = y; // Equivalent of doing `x = y` (ref is still a reference to x; we are reassigning the value of variable x to be y and NOT rebinding the reference ref)
std::cout << "ref: " << ref << std::endl; // prints "ref: 456"
std::cout << "x: " << x << std::endl; // prints "x: 456"

// Valid
int* ptr;
ptr = &x; // ptr points to x (assignment)
```

## Nullability

- References cannot be null, meaning they must always refer to a valid object
- Pointers can be assigned a null value ()`nullptr`) to indicate that they do not currently point to any valid object
  - This makes pointers more flexible for scenarios where an object may not always exist or may need to be dynamically allocated

```cpp
int* ptr = nullptr; // pointer initialised to null
```

## Dereferencing

- References are automatically dereferenced, meaning that when accessing the reference, the actual object it refers to is accessed directly
- Pointers, on the other hand, need to be explicitly dereferenced using the asterisk (`*`) operator to access the object they point to

```cpp
int x = 123;
int& ref = x;
int* ptr = &x;

// Value of x is directly accessed through ref
int a = ref; // a = 123
// Value of x is accessed through dereferencing ptr
int b = *ptr; // b = 123
```

## Memory Management

- References do not require memory management, as they are simply aliases to existing objects and do not have their own memory address
- Pointers can be used to dynamically allocate memory using the `new` operator, and it is the programmer's responsibility to properly deallocate the memory using the `delete` operator to avoid memory leaks

```cpp
int* ptr = new int; // dynamic memory allocation
*ptr = 123; // value assigned to dynamically allocated memory
delete ptr; // dynamic memory deallocation
```

## Function Parameters

- References are often used in function parameters to pass arguments by reference, allowing the function to directly modify the original objects
- Pointers require explicit dereferencing and may be null, whereas references cannot be null

```cpp
void modifyByReference(int& ref) {
  ref = 456; // directly modifies the original object
  // ref++;
}

void modifyByPointer(int* ptr) {
  *ptr = 789; // dereferences and modifies the object pointed to by ptr
  // (*ptr)++;
}

int x = 123;
modifyByReference(x); // x is directly modified
modifyByPointer(&x); // address of x is passed as a pointer
```

## Objects

```cpp
// Reference
class MyClass {
public:
  int myVar;
  void myMethod() {
    //...
  }
};

MyClass obj;
obj.myVar = 123; // Access member variable using object
obj.myMethod(); // Access member function using object

MyClass &ref = obj; // Create a reference to the object
ref.myVar = 456;     // Access member variable using reference
ref.myMethod();     // Access member function using reference
```

```cpp
// Pointer
class MyClass {
public:
  int myVar;
  void myMethod() {
    //...
  }
};

MyClass obj;
obj.myVar = 123; // Access member variable using object
obj.myMethod(); // Access member function using object

MyClass *ptr = &obj; // Create a pointer to the object
ptr->myVar = 456;     // Access member variable using pointer and arrow (->) operator
ptr->myMethod();     // Access member function using pointer and arrow (->) operator
```

# `std::algorithm` Examples

## `std::fill`

```cpp
class Solution {
public:
  int myFunc(int n) {
    int arr[n] = {};
    std::fill(std::begin(arr), std::end(arr), -1);

    std::vector<std::vector<int>> vec(n, std::vector<int>(n, -1));
    std::fill(vec[0].begin(), vec[0].end(), 0);
  }
};
```

## `std::accumulate`

```cpp
class Solution {
public:
  int distinctSubseqII(std::string s) {
    long dp[26] = {0};
    long mod = 1e9 + 7;
    for (char &c : s) {
      dp[c - 'a'] = std::accumulate(std::begin(dp), std::end(dp), 1L) % mod;
    }
    return std::accumulate(std::begin(dp), std::end(dp), 0L) % mod;
  }
};
```

```cpp
class Solution {
public:
  int knightDialer(int n) {
    int mod = 1'000'000'007;
    std::vector<std::vector<int>> graph = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
    std::vector<std::vector<long long>> dp(n + 1, std::vector<long long>(10, 0));
    // Base case for phone numbers of length 1
    std::fill(dp[1].begin(), dp[1].end(), 1);
    for (int i = 2; i < n + 1; i++) {
      for (int j = 0; j < 10; j++) {
        for (int nei : graph[j]) {
          dp[i][j] += dp[i - 1][nei];
        }
        dp[i][j] %= mod;
      }
    }
    int result = std::accumulate(dp[n].begin(), dp[n].end(), 0, [mod](int a, int b) {
      return (a + b) % mod;
    });
    return result;
  }
};
```

## Get index of smallest element in `std::vector`

```cpp
int main() {
  std::vector<int> vec = {5, 2, 7, 1, 9, 3};
  auto minNum = std::min_element(vec.begin(), vec.end());
  auto minNumIndex = std::distance(vec.begin(), minNum);
  std::cout << "The smallest element is " << *minNum << " at index " << minNumIndex << std::endl;
  return 0;
}
```

# `std::map` vs `std::unordered_map`

**`std::map`**

- Implemented using Red Black Tree (balanced binary search tree)
  - It is NOT a hash table, so it **does NOT require that the key is hashable**
  - However, it requires that the key support `<`, `>`, or `==` operations
- Therefore **cannot** use `std::vector<int>` as key
  - Need to implement own custom hash function for `std::vector<int>`
- Is ordered

**`std::unordered_map`**

- Implemented using associative containers (buckets) that determines placement of elements (key-value pairs) by the **hash of its key**
  - **Requires key is hashable** (requires availability of hash function for the key)
    - Such function does NOT exist for `std::vector` in standard implementation
- Therefore can use `std::vector<int>` as key
- Is unordered
  - Requires use of `.reserve()` to prevent resizing from invalidating all existing iterators

# `this` keyword

```cpp
class Solution {
public:
  std::vector<int> nums;
  void myFunc(std::vector<int> &nums) {
    //...
  }
}
```

- In C++, the dot operator `.` is used to access members of an object, while the arrow operator `->` is used to access members of an object through a pointer
- In the provided code `this.nums = nums`, `this` is a pointer to the current object of the Solution class, and `nums` is a member variable of the class
  - To access nums through the pointer `this`, you need to use the arrow operator, like this: `this->nums`
- Using the dot operator instead, as in `this.nums`, is a syntax error and will result in a compilation error

# Truthy/Falsy Values

## Truthy Values

- The following values are considered truthy, meaning they evaluate to `true` in a boolean context:

  - Non-Zero integers (integers > 0)
  - Non-Null pointers
  - Non-Empty C-style strings (arrays of characters)
  - Non-Empty `std::string` objects
  - Boolean `true` (`true` keyword)

## Falsy Values

- The following values are considered falsy or "untruthy," meaning they evaluate to false in a boolean context:
  - Zero integers (0, 0L, 0LL, 0.0, 0.0f, etc.)
  - Null pointers `nullptr`
  - Empty C-style strings (arrays of characters)
  - Empty std::string objects
  - Boolean `false` (`false` keyword)

```cpp
#include <iostream>
#include <bits/stdc++.h>

int main() {
  // Truthy Values
  int num = 4096;
  int* ptr = &num;
  char chars[] = "Hello";
  std::string str = "World";
  bool flag = true;

  if (num) {
    std::cout << "num is truthy\n";
  }
  if (ptr) {
    std::cout << "ptr is truthy\n";
  }
  if (chars[0]) {
    std::cout << "chars is truthy\n";
  }
  if (!str.empty()) {
    std::cout << "str is truthy\n";
  }
  if (flag) {
    std::cout << "flag is truthy\n";
  }

  // Falsy Values
  int zero = 0;
  int* nullPtr = nullptr;
  char emptyStr[] = "";
  std::string emptyStr = "";
  bool flag2 = false;

  if (zero == 0) {
    std::cout << "zero is untruthy\n";
  }
  if (!nullPtr) {
    std::cout << "nullPtr is untruthy\n";
  }
  if (emptyStr[0] == '\0') {
    std::cout << "emptyStr is untruthy\n";
  }
  if (emptyStr.empty()) {
    std::cout << "emptyStr is untruthy\n";
  }
  if (!flag2) {
    std::cout << "flag2 is untruthy\n";
  }

  return 0;
}
```

# Types

## Number

- `1 byte == 8 bits`

| Integer Type    | Definition        |
| --------------- | ----------------- |
| **`char`**      | 1 byte = 8 bits   |
| **`int`**       | 4 bytes = 32 bits |
| **`long long`** | 8 bytes = 64 bits |

| Decimal Type | Definition        |
| ------------ | ----------------- |
| **`float`**  | 4 bytes = 32 bits |
| **`double`** | 8 bytes = 64 bits |

## Signed vs Unsigned

- Signed Integer = Postive + 0 + Negative
- Unsigned Integer = Postive + 0

- **Signed Integers**:

  - Signed integers represent both positive and negative values, including zero
  - They use the most significant bit (MSB) (the bit furthest to the left) to represent the sign, where 0 indicates a positive value and 1 indicates a negative value
  - The remaining bits are used to represent the magnitude of the value
  - For example, a signed 8-bit integer (signed char) can represent values from -128 to 127
    - The binary representation of -128 is 1000 0000, where the MSB is 1 indicating a negative value, and the magnitude is represented by the remaining 7 bits
    - Similarly, the binary representation of 127 is 0111 1111, where the MSB is 0 indicating a positive value, and the magnitude is represented by the remaining 7 bits

- **Unsigned Integer**:

  - Unsigned integers represent only non-negative values, including zero
  - They do NOT use any bit to represent the sign, and all bits are used to represent the magnitude of the value
  - As a result, unsigned integers can represent a larger range of positive values compared to signed integers of the same size
  - For example, an unsigned 8-bit integer (unsigned char) can represent values from 0 to 255. The binary representation of 0 is 0000 0000, and the binary representation of 255 is 1111 1111. Since there is no sign bit, all 8 bits are used to represent the magnitude of the value

- [IBM Resource](https://www.ibm.com/docs/en/aix/7.2?topic=types-single-precision-floating-point)
