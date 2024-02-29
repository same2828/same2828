- [Table of Contents](#table-of-contents)
- [Edge Cases](#edge-cases)
- [Random Number Generator](#random-number-generator)

# Table of Contents

# Edge Cases

- Input
  - Empty string `""`
  - Null `null`
- Strings
  - Use ASCII Code for valid ranges instead of storing list of characters to remove
    - `'A'-'Z'` goes from `65-90`
    - `'a'-'z'` goes from `97-122`
  - Ask if punctuation characters will be present in input and if need to be removed

# Random Number Generator

- Generate `k` numbers in the range `x` to `y` inclusive
- You are given a random number generator function (`generateRandomNumber(x,y)`) that generates a random number in between the range `x` and `y`
- To add an upper bound
  - Create an array and fill it with numbers in the range `x` to `y` inclusive
  - Use the number given from the random number generator as an index into this array (`generateRandomNumber(x,arraySize)`)
  - Each time we extract an element from the array
    - Replace that element last element (`array[-1]`) in the array
    - Decrease the array size counter `arraySize -= 1`
    - Continue process of calling `generateRandomNumber(x,arraySize)` until you have `k` elements
