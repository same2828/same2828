# Table of Contents

- [Table of Contents](#table-of-contents)
- [Remove repeated substring in word](#remove-repeated-substring-in-word)
- [Extract text in brackets](#extract-text-in-brackets)
- [Remove \text{adsf}](#remove-textadsf)
- [Remove O(n \* d)O(n⋅d)](#remove-on--dond)

# Remove repeated substring in word

- Find

  ```
  \b(([a-zA-Z0-9_"',:;\.\?\+\-\*\/\{\}\[\]\(\)])+)(\s*)\1
  ```

- Replace

  ```
  $1
  ```

# Extract text in brackets

- E.g. Extract 'max' from '\text{max}'
- Find
  ```
  (\\\w+\{)(\w+)(\})
  ```
- Replace
  ```
  $2
  ```

# Remove \text{adsf}

- Find
  ```
  \\text\{.*?\}
  ```
- Replace
  ```
  [LEAVE THIS EMPTY]
  ```

# Remove O(n \* d)O(n⋅d)

- Find

  ```
  \)(O\(.*?⋅.*?\))
  ```

- Replace
  ```
  )
  ```
