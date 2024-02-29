# Table of Contents

- [Table of Contents](#table-of-contents)
- [Resources](#resources)
- [Glob vs RegEx](#glob-vs-regex)
- [Glob Basics](#glob-basics)
- [Extended Globbing](#extended-globbing)
  - [Brace Expansion](#brace-expansion)
  - [extglobs](#extglobs)
  - [POSIX character classes](#posix-character-classes)
  - [Common Options](#common-options)

# Resources

- https://en.wikipedia.org/wiki/Glob_(programming)
- https://www.digitalocean.com/community/tools/glob
- https://stackoverflow.com/questions/74683013/regex-to-glob-and-vice-versa-conversion
- https://code.visualstudio.com/docs/editor/glob-patterns
- https://tldp.org/LDP/GNU-Linux-Tools-Summary/html/x11655.htm#WILDCARDS
- https://github.com/begin/globbing

# Glob vs RegEx

| Glob Wildcard | Regular Expression | Meaning                      |
| ------------- | ------------------ | ---------------------------- |
| `?`           | `.`                | Any single character         |
| `*`           | `.*`               | Zero or more characters      |
| `?*`          | `.+`               | One or more characters       |
| `[a-z]`       | `[a-z]`            | Any character from the range |
| `[!a-m]`      | `[^a-m]`           | A character not in the range |
| `[a,b,c]`     | `[abc]`            | One of the given characters  |

Glob: `{cat,dog,bat}`
Regex: `(cat|dog|bat)`

Glob: `{*.tar,*.gz}`
Regex: `(.*\.tar|.*\.gz)`

# Glob Basics

| Character | Description                                                                                                                    |
| --------- | ------------------------------------------------------------------------------------------------------------------------------ |
| `*`       | Matches any character zero or more times, except for `/`                                                                       |
| `**`      | Matches any character zero or more times, including `/`                                                                        |
| `?`       | Matches any character except for `/` one time                                                                                  |
| `[abc]`   | Matches any characters inside the brackets. For example, `[abc]` would match the characters `a`, `b` or `c`, and nothing else. |

Notes:

- `**/` = Recursive Subdirectory Search
- `*` typically does NOT match dotfiles (file names starting with a `.`) unless explicitly enabled by the user [via options](#common-options)
- `?` also typically does NOT match the leading dot
- More than two stars in a glob path segment are typically interpreted as _a single star_ (e.g. `/***/` is the same as `/*/`)

# Extended Globbing

## Brace Expansion

In simple cases, brace expansion appears to work the same way as the logical `OR` operator. For example, `(a|b)` will achieve the same result as `{a,b}`

Here are some powerful features unique to brace expansion (versus character classes):

- Range expansion: `a{1..3}b/*.js` expands to: `['a1b/*.js', 'a2b/*.js', 'a3b/*.js']`
- Nesting: `a{c,{d,e}}b/*.js` expands to: `['acb/*.js', 'adb/*.js', 'aeb/*.js']`

Visit the [braces](https://github.com/micromatch/braces) library for more examples and information about brace expansion

## extglobs

As described by the bash man page:

| **pattern** | **regex equivalent**  | **matches**                                    |
| ----------- | --------------------- | ---------------------------------------------- |
| `?(foo)`    | `(foo)?`              | zero or one occurrence of the given patterns   |
| `*(foo)`    | `(foo)*`              | zero or more occurrences of the given patterns |
| `+(foo)`    | `(foo)+`              | one or more occurrences of the given patterns  |
| `@(foo)`    | `(foo)`               | one of the given patterns                      |
| `!(foo)`    | `^(?:(?!(foo)$).*?)$` | anything except one of the given patterns      |

Note: `@` is NOT a RegEx character

## POSIX character classes

POSIX character classes, or "bracket expressions", provide a way of defining regular expressions using something closer to plain english

For example, the pattern `[[:alpha:][:digit:]]` would match `a1`, but not `aa`

| Character    | Description                                                                                  |
| ------------ | -------------------------------------------------------------------------------------------- |
| `[:upper:]`  | Uppercase letters                                                                            |
| `[:lower:]`  | Lowercase letters                                                                            |
| `[:alpha:]`  | Alphabetic (letters) meaning upper+lower (both uppercase and lowercase letters)              |
| `[:digit:]`  | Numbers in decimal, 0 to 9                                                                   |
| `[:alnum:]`  | Alphanumeric meaning alpha+digits (any uppercase or lowercase letters or any decimal digits) |
| `[:space:]`  | Whitespace meaning spaces, tabs, newlines and similar                                        |
| `[:graph:]`  | Graphically printable characters excluding space                                             |
| `[:print:]`  | Printable characters including space                                                         |
| `[:punct:]`  | Punctuation characters meaning graphical characters minus alpha and digits                   |
| `[:cntrl:]`  | Control characters meaning non-printable characters                                          |
| `[:xdigit:]` | characters that are hexadecimal digits.                                                      |

## Common Options

The following options are commonly available on various globbing implementations

| **Option name** | **Description**                                                                                                                                                                                                                                                                |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ----- |
| `extglob`       | Enable extended globs. In addition to the traditional globs (using wildcards: `*`, `*`, `?` and `[...]`), extended globs add (almost) the expressive power of regular expressions, allowing the use of patterns like `foo/!(a                                                  | b)\*` |
| `dotglob`       | Allows files beginning with `.` to be included in matches. This option is automatically enabled if the glob pattern begins with a dot. Aliases: `dot` (supported by: [minimatch](https://github.com/isaacs/minimatch), [micromatch](https://github.com/micromatch/micromatch)) |
| `failglob`      | report an error when no matches are found                                                                                                                                                                                                                                      |
| `globignore`    | allows you to specify patterns a glob should not match Aliases: `ignore` (supported by: [minimatch](https://github.com/isaacs/minimatch), [micromatch](https://github.com/micromatch/micromatch))                                                                              |
| `globstar`      | recursively match directory paths (enabled by default in [minimatch](https://github.com/isaacs/minimatch) and [micromatch](https://github.com/micromatch/micromatch), but not in [bash](https://github.com/felixge/node-bash))                                                 |
| `nocaseglob`    | perform case-insensitive pathname expansion                                                                                                                                                                                                                                    |
| `nocasematch`   | perform case-insensitive matching. Aliases: `nocase` (supported by: [minimatch](https://github.com/isaacs/minimatch), [micromatch](https://github.com/micromatch/micromatch))                                                                                                  |
| `nullglob`      | when enabled, the pattern itself will be returned when no matches are found. Aliases: `nonull` (supported by: [minimatch](https://github.com/isaacs/minimatch), [micromatch](https://github.com/micromatch/micromatch))                                                        |
