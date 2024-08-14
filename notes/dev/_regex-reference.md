# Table of Contents

- [Table of Contents](#table-of-contents)
- [regex101](#regex101)
  - [Common Tokens](#common-tokens)
  - [Anchors](#anchors)
  - [Quantifiers](#quantifiers)
  - [Group Constructs](#group-constructs)
  - [Lookarounds](#lookarounds)
    - [Use Case for Negative LookBEHIND](#use-case-for-negative-lookbehind)
  - [Flags/Modifiers](#flagsmodifiers)
    - [Multiple Lines Flag `/m` Explanation](#multiple-lines-flag-m-explanation)
- [RexEgg](#rexegg)
  - [Quick Reference](#quick-reference)
    - [Characters](#characters)
    - [Character Classes/Ranges](#character-classesranges)
    - [Quantifiers](#quantifiers-1)
      - [Greedy + Lazy Modifying Quantifiers](#greedy--lazy-modifying-quantifiers)
    - [Logic](#logic)
    - [Anchors and Boundaries](#anchors-and-boundaries)
      - [`^` - Start of String or Start of Line](#---start-of-string-or-start-of-line)
    - [Lookarounds](#lookarounds-1)
  - [Anchors](#anchors-1)
    - [`\G` - Beginning of String or End of Previous Match](#g---beginning-of-string-or-end-of-previous-match)
      - [`\K` - Rest Match](#k---rest-match)
      - [`\G` - "Beginning of String" Match: Using or Bridling `\G`](#g---beginning-of-string-match-using-or-bridling-g)

# regex101

## Common Tokens

| Common Tokens                                              | Regex      |
| ---------------------------------------------------------- | ---------- |
| Match any character EXCEPT linebreaks `[^\n\r]`            | `.`        |
| Match any character INCLUDING linebreaks                   | `[\s\S]`   |
| Character set                                              | `[abc]`    |
| Negated character set                                      | `[^abc]`   |
| Character range                                            | `[a-z]`    |
| Negated character range                                    | `[^a-z]`   |
| Multiple character range                                   | `[a-zA-Z]` |
| Alternate/Alternation (match either `a` or `b`)            | `a\|b`     |
| Alternate/Alternation (match either `ab` or `cd`)          | `ab\|cd`   |
| 0 or more of `a`                                           | `a*`       |
| 1 or more of `a`                                           | `a+`       |
| 0 or 1 of `a`                                              | `a?`       |
| Quantifier: Exactly 3 of `a`                               | `a{3}`     |
| Quantifier: 3 or more of `a`                               | `a{3,}`    |
| Quantifier: Between 3 and 6 of `a` (range `[3,6]`)         | `a{3,6}`   |
| Start of string                                            | `^`        |
| End of string                                              | `$`        |
| Any whitespace character (`[ \t\n\r\v]` or `[\h\t\n\r\v]`) | `\s`       |
| Any non-whitespace character                               | `\S`       |
| Any digit `[0-9]`                                          | `\d`       |
| Any non-digit                                              | `\D`       |
| Any word character `[A-Za-z0-9_]`                          | `\w`       |
| Any non-word character                                     | `\W`       |
| A word boundary                                            | `\b`       |
| Non-word boundary                                          | `\B`       |
| Newline                                                    | `\n`       |
| Match anything but a newline                               | `\N`       |
| Carriage return                                            | `\r`       |
| Tab                                                        | `\t`       |
| Vertical whitespace character                              | `\v`       |
| Negation of `\v`                                           | `\V`       |
| Horizontal whitespace character                            | `\h`       |
| Negation of `\h`                                           | `\H`       |
| Null character                                             | `\0`       |
| Match everything enclosed                                  | `(?:...)`  |
| Capture everything enclosed                                | `(...)`    |

## Anchors

| Anchors                | Regex |
| ---------------------- | ----- |
| Start of match         | `\G`  |
| Start of string        | `^ `  |
| Start of string        | `\A`  |
| End of string          | `$`   |
| End of string          | `\Z`  |
| Absolute end of string | `\z`  |
| A word boundary        | `\b`  |
| Non-word boundary      | `\B`  |

## Quantifiers

| Quantifiers                            | Regex    |
| -------------------------------------- | -------- |
| 0 or more of `a`                       | `*`      |
| 1 or more of `a`                       | `a+`     |
| 0 or 1 of `a`                          | `a?`     |
| Exactly 3 of `a`                       | `a{3}`   |
| 3 or more of `a`                       | `a{3,}`  |
| Between 3 and 6 of `a` (range `[3,6]`) | `a{3,6}` |
| Greedy quantifier                      | `a*`     |
| Non-Greedy/Lazy quantifier             | `*?`     |
| Possessive quantifier                  | `a*+`    |

## Group Constructs

Note: Capturing Groups "GROUP MULTIPLE TOKENS TOGETHER"
Note: Use "Named Capturing Groups" to refer to them by "name" instead of "id/number"
Note: Backreferences/Numeric References `\1` REFERS TO the RESULT/MATCH OF the referenced capturing group and NOT the regex of referenced capturing group (i.e. the regex `(\bChunLi\b)(.*)\1` means the `\1` == `ChunLi` and NOT `\bChunLi\b`)

```re
# Example 1.1
# -----------
# Note: \1 == "Ada" == refers to the RESULT/MATCH OF the first capturing group (\bAda\b) and NOT the regex (\bAda\b)

Regex: (\bAda\b)(.*)\1
String: "Ada AdaWong WongAdaWong"
Match: "(Ada AdaWong WongAda)Wong"
Explanation: Since we do NOT enforce a \b after \1, this regex will match "(Ada AdaWong WongAda)Wong" in the brackets

# Example 1.2
# -----------
Regex: (\bAda\b)(.*)\b\1\b

String1: "Ada AdaWong WongAdaWong"
Match1: None/Null

String2: "Ada AdaWong WongAdaWong WongAda Ada"
Match2: "(Ada AdaWong WongAdaWong WongAda Ada)"
Explanation: Since we ENFORCE a \b before and after \1, this will NOT match the string "Ada AdaWong WongAdaWong" but WILL match entire string "(Ada AdaWong WongAdaWong WongAda Ada)"

# Example 2
# ---------
Regex: (\b[A-Za-z]+\b)(.*)\b\1\b
String: "abc Miffy MiffyIsSaved SaveMeMiffy def Miffy xyz"
Match: "ABC (Miffy MiffyIsSaved SaveMeMiffy DEF Miffy) XYZ"
```

| Capturing Groups                                      | Regex           | Example                                                                          |
| ----------------------------------------------------- | --------------- | -------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------- |
| Capturing Group (capture everything enclosed)         | `(...)`         |                                                                                  | Groups multiple tokens together and creates a capture group for extracting a substring or using a backreference                                |
| Non-Capturing Group (match everything enclosed)       | `(?:...)`       |                                                                                  | Groups multiple tokens together without creating a capture group (i.e do NOT assign an ID)                                                     |
| Named Capturing Group (PCRE)                          | `(?'name'...)`  | `(?'myName'Sesame)` matches `SameSamsung(Sesame)StreetOpenSeas`                  |
| Named Capturing Group (ECMAScript/Java)               | `(?<name>...)`  | `(?<myName>Sesame)` matches `SameSamsung(Sesame)StreetOpenSeas`                  |
| Named Capturing Group (Golang)                        | `(?P<name>...)` | `(?P<myName>Sesame)` matches `SameSamsung(Sesame)StreetOpenSeas`                 |
| Use/Reference Capturing Group via Backreference       | `\1` or `$1`    | `(\bCityWok\b)(.*)\b\1\b` matches `(CityWok City Wok CityWork) CitySushi`        | Note: Capturing Group IDs/numberings STARTS FROM 1 <br> Note: Use `$1` when doing REPLACE                                                      |
| Use/Reference Named Capturing Group (ECMAScript/Java) | `\k<name>`      | `(?<underscores>[_]+)hello world(\k<underscores>)` matches `(___hello world___)` |
| Use/Reference Named Capturing Group (Java)            | `\k{name}`      | `(?<underscores>[_]+)hello world(\k<underscores>)` matches `(___hello world___)` |
| Atomic group (non-capturing)                          | `(?>...)`       |                                                                                  | Matches the longest possible substring in the group and doesn't allow later backtracking to reevaluate the group. It is NOT a capturing group. |
| Comment group (PCRE)                                  | `(?#...)`       | Note: Any text appearing in this group is ignored in the regex                   |

## Lookarounds

Note: Tokens inside lookarounds are NOT matched
Note: You MUST still specify what to look for (treat the lookaround as an "ignore" block)

| Lookarounds         | Regex      | Example                                                                                                           | Description                                                                                               |
| ------------------- | ---------- | ----------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| Positive LookAHEAD  | `(?=...)`  | `foo(?=bar)` matches `(foo)bar foobaz` <br> `\d(?=px)` matches `1em (2)px 3rem (4)px`                             | Matches a group after the main expression WITHOUT including it in the result                              |
| Negative LookAHEAD  | `(?!...)`  | `foo(?!bar)` matches `foobar (foo)baz` <br> `\d(?!px)` matches `(1)em 2px (3)rem 4px`                             | Specifies a group that must NOT match after the main expression (if it matches, the result is discarded). |
| Positive LookBEHIND | `(?<=...)` | `(?<=foo)bar` matches `foo(bar) fuubar` <br> `(?<=em )\d` matches `1em (2)px 3rem (4)px`                          |
| Negative LookBEHIND | `(?<!...)` | `(?<!foo)bar` matches `foobar fuu(bar)` <br> `(?<!\$)\d+` matches `age: (23), net_worth: $100, post_code: (2020)` |

Multiple values for lookarounds: `(?!success|valid|ok)`

### Use Case for Negative LookBEHIND

- When examining log output, find matches of `error` on lines that do NOT begin with `INFO`
  - Regex: `(?<!^INFO\s).*error`

## Flags/Modifiers

| Flags                             | Pattern modifier | Description                                                                                                                                                                                                   |
| --------------------------------- | ---------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Global match                      | `g`              |                                                                                                                                                                                                               |
| Multiple lines                    | `m`              | When the multiline flag is enabled, beginning and end anchors (`^` and `$`) will match at the start and end of EACH line in the input string, instead of the ONLY at start and end of the ENTIRE INPUT STRING |
| Case-insensitive (ignore case)    | `i`              |                                                                                                                                                                                                               |
| Ignore whitespace allows comments | `x`              |                                                                                                                                                                                                               |

### Multiple Lines Flag `/m` Explanation

```re
# Example 1
# ---------
Regex: /^Bar/g

String:
"Foo Bar
Bar Foo
Foo Bar"

Match: None/Null
Explanation: Match is none/null because in the "bar" is NOT at the beginning of the ENTIRE INPUT STRING

# Example 2
# ---------
Regex: /^Bar/gm

String:
"Foo Bar
Bar Foo
Foo Bar"

Match:
"Foo Bar
(Bar) Foo
Foo Bar"
```

# RexEgg

## Quick Reference

- [Quick Reference](https://www.rexegg.com/regex-quickstart.php)

### Characters

| Character | Description                                                                                                     |
| --------- | --------------------------------------------------------------------------------------------------------------- |
| `\s`      | Any whitespace character (`[ \t\n\r\v]` or `[\h\t\n\r\v]`) (space, tab, newline, carriage return, vertical tab) |
| `\S`      | Any non-whitespace character                                                                                    |
| `\d`      | Any digit `[0-9]`                                                                                               |
| `\D`      | Any non-digit                                                                                                   |
| `\w`      | Any word character `[A-Za-z0-9_]`                                                                               |
| `\W`      | Any non-word character                                                                                          |
| `\b`      | A word boundary                                                                                                 |
| `\B`      | Non-word boundary                                                                                               |
| `\n`      | Newline                                                                                                         |
| `\N`      | Match anything but a newline                                                                                    |
| `\r`      | Carriage return                                                                                                 |
| `\t`      | Tab                                                                                                             |
| `\v`      | Vertical whitespace character                                                                                   |
| `\V`      | Negation of `\v`                                                                                                |
| `\h`      | Horizontal whitespace character                                                                                 |
| `\H`      | Negation of `\h`                                                                                                |
| `\0`      | Null character                                                                                                  |

| Character | Description                              | Example Regex       | Sample Match |
| --------- | ---------------------------------------- | ------------------- | ------------ |
| `.`       | Any character except line break          | `a.c`               | `anc`        |
| `\.`      | A period (needs to be escaped by a `\`)  | `a\.c`              | `a.c`        |
| `\`       | Escapes a special character `[.*+?$^\/]` | `\.\*\+\? \$\^\/\\` | `.\*+? $^/\` |
| `\`       | Escapes a special character `[[](){}]`   | `\[\{\(\)\}\]`      | `[{()}]`     |

### Character Classes/Ranges

| Character | Description                                                                 | Example Regex    | Sample Match                                                              |
| --------- | --------------------------------------------------------------------------- | ---------------- | ------------------------------------------------------------------------- |
| `[ ... ]` | One of the characters in the brackets                                       | `[AEIOU]`        | One uppercase vowel                                                       |
| `[ ... ]` | One of the characters in the brackets                                       | `T[ao]p`         | Tap or Top                                                                |
| `...`     | Range indicator                                                             | `[a-z]`          | One lowercase letter                                                      |
| `[x-y]`   | One of the characters in the range from `x` to `y`                          | `[A-Z]+`         | DEBUG                                                                     |
| `[ ... ]` | One of the characters in the brackets                                       | `[AB1-5w-z]`     | One of either: `A,B,1,2,3,4,5,w,x,y,z`                                    |
| `[x-y]`   | One of the characters in the range from `x` to `y`                          | `[ -~]+`         | Characters in the printable section of the ASCII table                    |
| `[^x]`    | One character that is NOT `x`                                               | `[^a-z]{3}`      | A1!                                                                       |
| `[^x-y]`  | One of the characters NOT in the range from `x` to `y`                      | `[^ -~]+`        | Characters that are NOT in the printable section of the ASCII table       |
| `[\d\D]`  | One character that is a digit or a non-digit                                | `[\d\D]+`        | Any characters, including new lines, which the regular dot does NOT match |
| `[\x41]`  | Matches the character at hexadecimal position 41 in the ASCII table, i.e. A | `[\x41-\x45]{3}` | ABE                                                                       |

### Quantifiers

Note: Quantifiers apply to the preceding token only (hence the `?` in `plurals?` means `0` or `1` of ONLY the `s` character)

| Quantifier | Description                       | Example Regex    | Sample Match     |
| ---------- | --------------------------------- | ---------------- | ---------------- |
| `+`        | 1 or more                         | `Version \w-\w+` | `Version A-b1_1` |
| `* `       | 0 or more                         | `A*B*C*`         | `AAACC`          |
| `? `       | 0 or 1                            | `plurals?`       | `plural`         |
| `{3}`      | Exactly three times               | `\D{3}`          | `ABC`            |
| `{2,4}`    | Two to four times (range `[2,4]`) | `\d{2,4}`        | `156`            |
| `{3,}`     | Three or more times               | `\w{3,}`         | `regex_tutorial` |

#### Greedy + Lazy Modifying Quantifiers

| Quantifier | Description                               | Example Regex | Sample Match                           |
| ---------- | ----------------------------------------- | ------------- | -------------------------------------- |
| `+`        | The `+` (1 or more) is "GREEDY"           | `\d+`         | `(12345)`                              |
| `?`        | The `?` (0 or 1) makes quantifiers "LAZY" | `\d+?`        | `(1)2345`                              |
| `*`        | The `*` (0 or more) is "GREEDY"           | `A*`          | `(AAA)`                                |
| `?`        | Makes quantifiers "LAZY"                  | `A*?`         | No matches for `AAA` (none/null/empty) |
| `{2,4}`    | Two to four times, "GREEDY"               | `\w{2,4}`     | `(abcd)`                               |
| `?`        | Makes quantifiers "LAZY"                  | `\w{2,4}?`    | `(ab)cd`                               |

### Logic

| Logic     | Description              | Example Regex           | Sample Match              |
| --------- | ------------------------ | ----------------------- | ------------------------- |
| `\|`      | Alternation / OR operand | `22\|33`                | 33                        |
| `(...)`   | Capturing group          | `A(nt\|pple)`           | `Apple` (captures "pple") |
| `\1`      | Contents of Group 1      | `r(\w)g\1x`             | `regex`                   |
| `\2`      | Contents of Group 2      | `(\d\d)\+(\d\d)=\2\+\1` | `12+65=65+12`             |
| `(?:...)` | Non-capturing group      | `A(?:nt\|pple)`         | `Apple`                   |

### Anchors and Boundaries

| Anchor | Legend                                                                                                       | Example Regex      | Sample Match                 |
| ------ | ------------------------------------------------------------------------------------------------------------ | ------------------ | ---------------------------- |
| `^`    | Start of string or start of line depending on multiline mode. (But when [^inside brackets], it means "NOT")  | `^abc.*`           | `abc...`                     |
| `$`    | End of string or end of line depending on multiline mode                                                     | `.*? the end$`     | `this is the end`            |
| `\A`   | Beginning of string (all major engines except ECMAScript)                                                    | `\Aabc[\d\D]*`     | `abc...`                     |
| `\z`   | Very end of the string (note: string must NOT contain newline) (not available in Python and ECMAScript)      | `the end\z`        | `this is...\n...(the end)`   |
| `\Z`   | End of string or (except Python) before final line break Not available in ECMAScript                         | `the end\Z`        | `this is...\n...(the end)\n` |
| `\G`   | Beginning of String or End of Previous Match (PCRE, Java)                                                    |                    |                              |
| `\b`   | Word boundary position where one side only is a Unicode letter, digit or underscore `[\w]` or `[A-Za-z0-9_]` | `Bob.*\b\cheese\b` | `Bob ate the cheese`         |
| `\B`   | Not a word boundary                                                                                          | `c.*\Bcat\B.\*`    | `copycats`                   |

#### `^` - Start of String or Start of Line

When `multimode /m` is DISABLED, `^a` ONLY matches the `a` in `apple` (start of input string):
When `multimode /m` is ENABLED, `^a` matches the `a` on BOTH lines:

```
apple
apricot
```

### Lookarounds

| Lookaround | Description         | Example Regex       | Sample Match   |
| ---------- | ------------------- | ------------------- | -------------- |
| `(?=...)`  | Positive lookAHEAD  | `(?=\d{10})\d{5}`   | `(01234)56789` |
| `(?!...)`  | Negative lookAHEAD  | `(?!theatre)the\w+` | `theme`        |
| `(?<=...)` | Positive lookBEHIND | `(?<=\d)cat`        | `1(cat)`       |
| `(?<!...)` | Negative lookBEHIND | `\w{3}(?<!mon)ster` | `Munster`      |

## Anchors

- [Anchors](https://www.rexegg.com/regex-anchors.php)

### `\G` - Beginning of String or End of Previous Match

The `\G` anchor can match at one of two positions:

1. The beginning of the string,
2. The position that immediately follows the end of the previous match.

`\G` can be used in tokenized strings when you want to match tokens in certain areas of the string but not in others

Consider for instance this string showing Jane and Tarzan's times on three separate swim tests:

`Tarzan A:29 B:27 C:28 Jane A:35 B:33 C:31`

If we are only interested in matching Jane's scores, we can use:

`(?:Jane|\G) \w+:(\d+)`

- When the engine tries to match at the beginning of the string, the first token `(?:Jane|\G)` succeeds because \G matches at the beginning of the string
- However, the next token (a space character `[ ]`) fails against Tarzan's `T`
- The next chance for the pattern to match is at the position preceding Jane.
- The engine matches `Jane A:35`, capturing the `35` to Group 1
- At the starting position of the next match attempt, `\G` matches, and the engine matches `B:33`
- Finally, `\G` matches again, and the engine matches `C:31`

#### `\K` - Rest Match

In PCRE, we do NOT need to retrieve the times from Capture Group 1, we can match them directly by adding `\K` where `\K` tells the regex engine to drop what it matched so far from the match to be returned

I.e. `\K` sets the given position in the regex as the new start of the match. **Nothing preceding `\K` will be returned as part of the full match**

`(?:Jane|\G) \w+:\K\d+`

#### `\G` - "Beginning of String" Match: Using or Bridling `\G`

Consider this string, which might represent two potential positions for placing a submarine in certain coordinates in the game Battleship:

`A1B1C1vsD2E2F2`

Each position (on either side of `vs`) has three tokens composed of one letter and one digit.

We can match the first three tokens `A1, B1, C1` with this regex:

`\G[A-Z]\d`

- The `\G` matches at the beginning of the string, allowing us to match `A1`
- Then `\G` matches before the next token, so we match it, as well as the following token.
- `\G` succeeds again before the `vs`, but `[A-Z]` CANNOT match the `v`, so the match fails
- There is no more position for \G to match, and we therefore avoid the tokens to the right of `vs` as we wanted.

Now suppose we want to match the second position's tokens, `D1, E2, F2`

- Remembering the Tarzan and Jane example, we could try `(?:vs|\G)([A-Z]\d)` but the strings in these two examples are not built the same way, and this regex would match all the tokens!
  - After the `\G` matches at the beginning of the string, `[A-Z]\d` is able to match the first token
  - Then \G matches again, so we match the second token, and the third.
  - Then, when we hit `vs`, `\G` still matches, but `[A-Z]` fails against `vs`
  - The engine backtracks and tries the other side of the alternation, `vs`, which matches. `[A-Z]\d` matches the fourth token, then `\G` helps us with tokens 5 and 6
- This time `\G`'s behaviour of matching at the beginning of the string causes issues
  - To solve this, we can "bridle `\G`" by placing the negative lookahead `(?!\A)` right next to it
    - This asserts that what immediately follows the current position is NOT the beginning of the string, so `\G` can no longer match there
    - The regex becomes: `(?:vs|\G(?!\A))([A-Z]\d)`
    - Note: replacing negative lookahead `(?!\A)` with negative lookbehind `(?<!\A)` also works
      - `(?:vs|\G(?<!\A))([A-Z]\d)`
