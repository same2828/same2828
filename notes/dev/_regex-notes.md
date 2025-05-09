# Table of Contents

- [Table of Contents](#table-of-contents)
- [Lookarounds](#lookarounds)
- [Examples](#examples)
  - [Exclude Word/String](#exclude-wordstring)
  - [Find Duplicate Lines](#find-duplicate-lines)
  - [Find Unquoted Strings in yaml/yml](#find-unquoted-strings-in-yamlyml)
  - [Find Words Without the Prefix `.`](#find-words-without-the-prefix-)
  - [Find Words Containing `ized` but without an `@`](#find-words-containing-ized-but-without-an-)
  - [Remove Blank Lines](#remove-blank-lines)
  - [Remove Comments That End With Period (`.`)](#remove-comments-that-end-with-period-)
  - [Remove Lines That End With Period (`.`)](#remove-lines-that-end-with-period-)
- [Regexr Cheatsheet](#regexr-cheatsheet)
  - [Character classes](#character-classes)
  - [Anchors](#anchors)
  - [Escaped characters](#escaped-characters)
  - [Groups \& Lookaround](#groups--lookaround)
  - [Quantifiers \& Alternation](#quantifiers--alternation)

# Lookarounds

> Note: Any `patterns` declared INSIDE the lookaround are NOT matched
> Note: Non-capturing groups `(?:pattern)` CANNOT be used with/inside lookarounds

| Regex                | Description using `foobarbarfoo`                                    |
| -------------------- | ------------------------------------------------------------------- |
| `bar(?=bar)`         | Finds the 1st `bar` ("bar" which has "bar" after it)                |
| `bar(?!bar)`         | Finds the 2nd `bar` ("bar" which does not have "bar" after it)      |
| `(?<=foo)bar`        | Finds the 1st `bar` ("bar" which has "foo" before it)               |
| `(?<!foo)bar`        | Finds the 2nd `bar` ("bar" which does not have "foo" before it)     |
| `(?<=foo)bar(?=bar)` | Finds the 1st `bar` ("bar" with "foo" before it and "bar" after it) |

| Regex   | Lookaround          | Pattern       | Description                                      |
| ------- | ------------------- | ------------- | ------------------------------------------------ |
| `(?=)`  | Positive Lookahead  | `foo(?=bar)`  | Finds/matches `foo` where `bar` MUST follow      |
| `(?!)`  | Negative Lookahead  | `foo(?!bar)`  | Finds/matches `foo` where `bar` does NOT follow  |
| `(?<=)` | Positive Lookbehind | `(?<=bar)foo` | Finds/matches `foo` where `bar` MUST precede     |
| `(?<!)` | Negative Lookbehind | `(?<!bar)foo` | Finds/matches `foo` where `bar` does NOT precede |

# Examples

## Exclude Word/String

```re
(?!ignore1|ignore2|ignoreN)
```

## Find Duplicate Lines

```re
^(.*)(\r?\n\1)+$
^(.*)(?:(\r?\n|\n|$)\1)+$
^(.*)(?:(\s|$)\1)+$
^(.*[\n]*)(?:(\r?\n|\n|$)\1*)+
```

## Find Unquoted Strings in yaml/yml

```re
<!-- Missing PREFIX quote | Missing SUFFIX Quote -->

// Regex V1
^([^'\r\n]+)(?<!')[^'\r\n]+['](?!')(\r\n?|\n|$)
^([^'\r\n]+)(?<!')['][^'\r\n]+(?!')(\r\n?|\n|$)
^(['])[^'\r\n]+(?!')(\r\n?|\n|$)
// Regex V1 Combined
^([^'\r\n]+)(?<!')([^'\r\n]+[']|['][^'\r\n]+)(?!')(\r\n?|\n|$)|^(['])[^'\r\n]+(?!')(\r\n?|\n|$)

// Regex V2
^(?:[^'\r\n]+)(?<!')(?:[^'\r\n]+['])(?!')(?:\r\n?|\n|$)
^(?:[^'\r\n]+)(?<!')(?:['][^'\r\n]+)(?!')(?:\r\n?|\n|$)
^(?:['])(?:[^'\r\n]+)(?!')(?:\r\n?|\n|$)
// Regex V2 Combined
(?:^(?:[^'\r\n]+)(?<!')(?:[^'\r\n]+[']|['][^'\r\n]+)(?!')(?:\r\n?|\n|$))|(?:^(?:['])(?:[^'\r\n]+)(?!')(?:\r\n?|\n|$))
```

## Find Words Without the Prefix `.`

```re
(?<!\.)\b\w+\b
```

## Find Words Containing `ized` but without an `@`

```re
\b(?<!@)\w*ized\w*\b
```

- `\b` asserts a word boundary, ensuring we match whole words
- `(?<!@)` is a negative lookbehind that asserts what directly precedes the current position in the string is not an `@` character
- `\w*` matches any word character (equivalent to `[a-zA-Z0-9_]`) zero or more times, both before and after `ized`
- `ized` matches the literal string `ized`
- `\b` asserts another word boundary at the end

## Remove Blank Lines

Find

```re
^(?:[\s]*(?:\r\n?|\n))+
^(?:[\s]*(?:\r\n?|\n|$))+
```

Replace

```re
[LEAVE THIS EMPTY]
```

## Remove Comments That End With Period (`.`)

Find

```re
(^[ ]+\/\/.+)(\.[ ]{0,})$
```

Replace

```re
$1
```

## Remove Lines That End With Period (`.`)

Find

```re
([^.])\.\n
```

Replace

```re
$1\n
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
