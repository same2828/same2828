# Table of Contents

- [Table of Contents](#table-of-contents)
- [Exclude Word/String](#exclude-wordstring)
- [Find Duplicate Lines](#find-duplicate-lines)
- [Remove Blank Lines](#remove-blank-lines)
- [Remove Comments That End With Period (`.`)](#remove-comments-that-end-with-period-)
- [Remove Lines That End With Period (`.`)](#remove-lines-that-end-with-period-)
- [Find words that contain `ized` but cannot have an `@`](#find-words-that-contain-ized-but-cannot-have-an-)
- [Regexr Cheatsheet](#regexr-cheatsheet)
  - [Character classes](#character-classes)
  - [Anchors](#anchors)
  - [Escaped characters](#escaped-characters)
  - [Groups \& Lookaround](#groups--lookaround)
  - [Quantifiers \& Alternation](#quantifiers--alternation)

# Exclude Word/String

```re
(?!ignore1|ignore2|ignoreN)
```

# Find Duplicate Lines

```re
^(.*)(\r?\n\1)+$
```

# Remove Blank Lines

Find

```re
^(?:[\t ]*(?:\r?\n|\r))+
```

Replace

```re
[LEAVE THIS EMPTY]
```

# Remove Comments That End With Period (`.`)

Find

```re
(^[ ]+\/\/.+)(\.[ ]{0,})$
```

Replace

```re
$1
```

# Remove Lines That End With Period (`.`)

Find

```re
([^.])\.\n
```

Replace

```re
$1\n
```

# Find words that contain `ized` but cannot have an `@`

```re
\b(?<!@)\w*ized\w*\b
```

- `\b` asserts a word boundary, ensuring we match whole words
- `(?<!@)` is a negative lookbehind that asserts what directly precedes the current position in the string is not an `@` character
- `\w*` matches any word character (equivalent to `[a-zA-Z0-9_]`) zero or more times, both before and after `ized`
- `ized` matches the literal string `ized`
- `\b` asserts another word boundary at the end

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
