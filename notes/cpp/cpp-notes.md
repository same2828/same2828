# Table of Contents

- [Table of Contents](#table-of-contents)
- [CMake](#cmake)
  - [Configuration](#configuration)
  - [Building](#building)
  - [Running](#running)
- [General Utilities Library](#general-utilities-library)
  - [std::pair](#stdpair)
    - [Member Objects](#member-objects)
    - [Member Functions](#member-functions)
    - [Non-Member Functions](#non-member-functions)
  - [std::tuple](#stdtuple)
    - [Member Functions](#member-functions-1)
    - [Non-Member Functions](#non-member-functions-1)

# CMake

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

# General Utilities Library

- `#include <utility>`

```cpp
#include <utility>
```

## std::pair

- `#include <utility>`
  ```cpp
  template<
    class T1,
    class T2
  > struct pair;
  ```
- The `std::pair<T1,T2>` template struct is a copyable, movable, swappable,
  (lexicographically) comparable struct that stores a pair of T1 and T2 values in its public
  first and second member variables
- A default-constructed pair zero-initialises its values,
  but initial values may be provided as well

  ```cpp
  // Constructor
  std::pair<int, std::string> p("Seth", 21);
  // Make pair variable
  auto p = std::make_pair("Seth", 21);
  // Decomposing pair back into its elements
  auto [name, age] = p;
  // Printing
  std::cout << p.first << ", " << p.second << "\n";
  ```

- [Read More](https://en.cppreference.com/w/cpp/utility/pair)

### Member Objects

| Member Object | Type |
| ------------- | ---- |
| `first`       | T1   |
| `second`      | T2   |

### Member Functions

| Member Function | Description          |
| --------------- | -------------------- |
| `(constructor)` | Constructs new pair  |
| `operator=`     | Assigns the contents |
| `std::swap`     | Swaps the contents   |

### Non-Member Functions

| Non-Member Function                                                                            | Description                                                          |
| ---------------------------------------------------------------------------------------------- | -------------------------------------------------------------------- |
| `std::make_pair`                                                                               | Creates a pair object of type, defined by the argument types         |
| `std::get(std::pair)`                                                                          | Accesses an element of a pair                                        |
| `std::swap(std::pair)`                                                                         | Specialises the std::swap algorithm                                  |
| `operator==`<br>`operator!=`<br>`operator<`<br>`operator<=`<br>`operator>`<br>`operator>=`<br> | Lexicographically compares the values in the pair (removed in C++20) |
| `operator<=>`                                                                                  | Lexicographically compares the values in the pair                    |

```cpp
#include <iostream>
#include <utility>

int main() {
  auto p = std::make_pair(1, 3.14);
  std::cout << '(' << p.first << ", " << p.second << ")\n";
  std::cout << '(' << std::get<0>(p) << ", " << std::get<1>(p) << ")\n";
  std::cout << '(' << std::get<int>(p) << ", " << std::get<double>(p) << ")\n";
}

// (1, 3.14)
// (1, 3.14)
// (1, 3.14)
```

## std::tuple

- `#include <tuple>`

  ```cpp
  template< class... Types >
  class tuple;
  ```

- `std::tuple` is a generalisation of pair that allows any number of values to be stored (i.e.
  zero or more, not just two): `std::tuple<Type...>`

  - It is mostly analogous to pair
  - The main difference is that the **individual values are NOT stored in public member variables**
    - Instead, you can access them using one of the get() template functions

  ```cpp
  // Constructor
  std::tuple t(1, 2, 0.3, std::string("4"));
  // Make tuple variable
  auto t = std::make_tuple(1, 2, 0.3, std::string("4"));
  // Decomposing tuple back into its elements
  auto [one, two, three, s] = t;
  // Printing
  std::cout << p.first << ", " << p.second << "\n";
  ```

- [Read more](https://en.cppreference.com/w/cpp/utility/tuple)

### Member Functions

| Member Function | Description                                  |
| --------------- | -------------------------------------------- |
| `(constructor)` | Constructs a new tuple                       |
| `operator=`     | Assigns the contents of one tuple to another |
| `std::swap`     | Swaps the contents of two tuples             |

### Non-Member Functions

| Non-Member Function                                                                            | Description                                                                     |
| ---------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `std::forward_as_tuple`                                                                        | Creates a tuple of forwarding references                                        |
| `std::make_tuple`                                                                              | Creates a tuple object of the type defined by the argument types                |
| `std::get(std::tuple)`                                                                         | Tuple accesses specified element                                                |
| `std::swap(std::tuple)`                                                                        | Specialises the std::swap algorithm                                             |
| `std::tie`                                                                                     | Creates a tuple of lvalue references or unpacks a tuple into individual objects |
| `std::tuple_cat`                                                                               | Creates a tuple by concatenating any number                                     |
| `operator==`<br>`operator!=`<br>`operator<`<br>`operator<=`<br>`operator>`<br>`operator>=`<br> | Lexicographically compares the values in the pair (removed in C++20)            |
| `operator<=>`                                                                                  | Lexicographically compares the values in the pair                               |

```cpp
#include <iostream>
#include <string>
#include <tuple>

int main() {
  auto t = std::make_tuple(1, "Foo", 3.14);
  // Index-based access
  std::cout << "(" << std::get<0>(t) << ", " << std::get<1>(t) << ", " << std::get<2>(t) << ")\n";
  // Type-based access
  std::cout << "(" << std::get<int>(t) << ", " << std::get<const char *>(t) << ", " << std::get<double>(t) << ")\n";

  // (1, Foo, 3.14)
  // (1, Foo, 3.14)
}
```
