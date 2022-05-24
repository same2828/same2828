# Table of Contents

- [Table of Contents](#table-of-contents)
- [Remove blank lines](#remove-blank-lines)
- [Regexr Cheatsheet](#regexr-cheatsheet)
  - [Character classes](#character-classes)
  - [Anchors](#anchors)
  - [Escaped characters](#escaped-characters)
  - [Groups & Lookaround](#groups--lookaround)
  - [Quantifiers & Alternation](#quantifiers--alternation)

# Remove blank lines

- Find

  ```
  ^(?:[\t ]*(?:\r?\n|\r))+
  ```

- Replace

  ```
  [LEAVE THIS EMPTY]
  ```

# Regexr Cheatsheet

## Character classes

| Regex    | Explanation                  |
| -------- | ---------------------------- |
| `.`      | Any character except newline |
| `\w\d\s` | Word, digit, whitespace      |
| `\W\D\S` | Not word, digit, whitespace  |
| `[abc]`  | Any of a, b, or c            |
| `[^abc]` | Not a, b, or c               |
| `[a-g]`  | Character between a & g      |

## Anchors

| Regex   | Explanation               |
| ------- | ------------------------- |
| `^abc$` | Start / end of the string |
| `\b\B`  | Word, not-word boundary   |

## Escaped characters

| Regex    | Explanation                    |
| -------- | ------------------------------ |
| `\.\*\\` | Escaped special characters     |
| `\t\n\r` | Tab, linefeed, carriage return |

## Groups & Lookaround

| Regex     | Explanation               |
| --------- | ------------------------- |
| `(abc)`   | Capture group             |
| `\1`      | Backreference to group #1 |
| `(?:abc)` | Non-capturing group       |
| `(?=abc)` | Positive lookahead        |
| `(?!abc)` | Negative lookahead        |

## Quantifiers & Alternation

| Regex       | Explanation                  |
| ----------- | ---------------------------- |
| `a\*a+a?`   | 0 or more, 1 or more, 0 or 1 |
| `a{5}a{2,}` | Exactly five, two or more    |
| `a{1,3}`    | Between one & three          |
| `a+?a{2,}?` | Match as few as possible     |

- `ab|cd` Match ab or cd
