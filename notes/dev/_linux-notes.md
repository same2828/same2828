# Table of Contents

- [Table of Contents](#table-of-contents)
- [Commands](#commands)
  - [`apt`](#apt)
  - [`awk`](#awk)
  - [`cat`](#cat)
  - [`cp` - Copy](#cp---copy)
  - [`cut` - Vertical Slice](#cut---vertical-slice)
  - [`date` - Timestamp](#date---timestamp)
  - [`find` - Search for files](#find---search-for-files)
  - [`grep` - Globally search with Regular Expressions and Print](#grep---globally-search-with-regular-expressions-and-print)
  - [`head`/`tail` (Select `first`/`last` lines)](#headtail-select-firstlast-lines)
  - [`join` - Join Files](#join---join-files)
  - [`kill` - Kill ProcessId](#kill---kill-processid)
  - [`ls`](#ls)
  - [`less` - View File Contents using Pager](#less---view-file-contents-using-pager)
  - [`more` - View File Contents using Pager](#more---view-file-contents-using-pager)
  - [`paste` - Combine Files](#paste---combine-files)
  - [`pkill` - Kill Process by Name](#pkill---kill-process-by-name)
  - [`ps`](#ps)
  - [`sed` - Stream Editor](#sed---stream-editor)
    - [Change a file with sed](#change-a-file-with-sed)
  - [`sort` - Sort Lines](#sort---sort-lines)
  - [`tee` - Send Copy of Pipeline to File](#tee---send-copy-of-pipeline-to-file)
  - [`tr` - Transliterate Characters](#tr---transliterate-characters)
  - [`uniq` - Remove or Count Duplicates](#uniq---remove-or-count-duplicates)
  - [`wc` - Word Counter](#wc---word-counter)
  - [`where`](#where)
  - [`xargs` - Run Commands With Arguments From stdin (Standard Input)](#xargs---run-commands-with-arguments-from-stdin-standard-input)
  - [SSH](#ssh)
    - [Change User to Root](#change-user-to-root)
    - [Copy Local File into Remote SSH Instance](#copy-local-file-into-remote-ssh-instance)
    - [Copy File from Remote SSH Instance into Local Directory](#copy-file-from-remote-ssh-instance-into-local-directory)
- [Filters](#filters)
- [Process Substitution (Named Pipes)](#process-substitution-named-pipes)
- [Scripts](#scripts)
  - [Template](#template)
- [Workflow](#workflow)
  - [Delete every 2nd and 3rd lines of file](#delete-every-2nd-and-3rd-lines-of-file)
  - [Find Invalid Folder Names](#find-invalid-folder-names)
  - [Find All Java Leetcode Files](#find-all-java-leetcode-files)
  - [Move Files From Child Directory To Parent Directory And Delete Child Directory](#move-files-from-child-directory-to-parent-directory-and-delete-child-directory)
  - [Find All Files In Folder With Partial Match](#find-all-files-in-folder-with-partial-match)
  - [List All Completed Leetcode Questions](#list-all-completed-leetcode-questions)
  - [Delete All Files and Folders](#delete-all-files-and-folders)
- [Links](#links)
  - [Hard Links](#hard-links)
  - [Symbolic Links (Symlinks)](#symbolic-links-symlinks)
  - [Zsh](#zsh)
    - [`{}` - Grouping Commands](#---grouping-commands)
    - [`()` - Subshell Execution](#---subshell-execution)

# Commands

## `apt`

```sh
sudo apt update
sudo apt update --fix-missing

sudo apt upgrade
sudo apt upgrade --fix-missing

sudo apt update && sudo apt upgrade
sudo apt update --fix-missing && sudo apt upgrade --fix-missing

sudo apt autoclean
sudo apt clean
sudo apt autoremove
sudo apt autoclean && sudo apt clean && sudo apt autoremove

# Remove pkg
sudo apt remove <pkg>
# Remove pkg + configuration files
sudo apt purge <pkg>
sudo apt remove --purge <pkg>
```

## `awk`

> `awk 'pattern { action }' filename(s)`

- `awk` reads input (file or stdin) line by line. For each line, it checks if it matches the pattern. If it does, it executes the action.
- `awk` automatically splits each line into fields based on whitespace (by default).
  - Access fields using `$1`, `$2`, `$3`, etc
  - `$0` = the entire line
- Patterns:
  - `/regex/`: Matches lines containing the regular expression.
  - `expression`: Matches lines where the expression is true (e.g., `$1 == "error"`, `NR > 5`).
  - `BEGIN`: Special pattern; its action runs before any input lines are read (useful for initialization)
  - `END`: Special pattern; its action runs after all input lines are read (useful for summaries)
  - If `pattern` is omitted, the action applies to every line.
- Actions:
  - Code block `{ ... }` containing `awk` commands.
  - Common action: `print $1, $3` (prints the first and third fields/columns)
  - Can perform calculations, manipulate strings, use variables, etc.
  - If action is omitted, the default action is print $0 (print the whole matching line)
- Field Separator
  - Change the input field separator using `-F`: `awk -F',' '{ print $1 }' data.csv` (uses comma as separator)
  - Change output separator with `OFS` variable: `awk 'BEGIN { OFS="," } { print $1, $2 }' file`
- Built-in Variables:
  - `NR` = Current line/record number
  - `NF` = Number of fields/columns in the current line
  - `FS` = Input field separator (tells `awk` how fields are delimited in the INPUT data)
    - Represents the input field separator
    - It holds the character or regex used to split input lines into fields
    - You can set `FS` within an `awk` script, typically in a `BEGIN` block, to achieve the same effect as `-F`
    - If both `-F` and `FS` in `BEGIN` are used, `-F` takes precedence over `FS`
  - `OFS` = Output field separator (tells `awk` how to delimit fields in the OUTPUT data)
    - Represents the output field separator
    - It defines the string that awk prints between fields when you use the comma (,) in a print statement
    - The default value for OFS is a single space.
    - Example: Process the CSV and output fields separated by a tab.

| `awk` Flag   | Example                                      | Description Example                                                                                                                  |
| ------------ | -------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| `-F fs`      | `awk -F',' '{print $1}' data.csv`            | Sets the input field separator (FS) to fs. fs can be a single character or a regular expression                                      |
| `-v var=val` | `awk -v name="Alice" '$1 == name' users.txt` | Assigns the value val to the variable var before the script begins execution. Useful for passing shell variables into the awk script |
| `-f file`    | `awk -f script.awk input.txt`                | Specifies that the awk script should be read from file instead of the command line                                                   |
| `-W lint`    | `awk -W lint '{print $1}' file.txt`          | Provides warnings about potential issues or non-portable constructs in the awk script                                                |
| `-W posix`   | `awk -W posix '/pattern/ {print}' file.txt`  | Enforces strict POSIX compatibility for the awk script                                                                               |

| `awk` Variable | Description                                                               |
| -------------- | ------------------------------------------------------------------------- |
| `$0`           | The entire current input record                                           |
| `$1, $2, ...`  | The fields of the current input record                                    |
| `ARGC`         | The number of command-line arguments                                      |
| `ARGV`         | An array containing the command-line arguments                            |
| `ENVIRON`      | An associative array containing the environment variables                 |
| `FILENAME`     | The name of the current input file                                        |
| `FNR`          | The record number within the current input file                           |
| `FS`           | The input field separator (default: space/tab)                            |
| `IGNORECASE`   | (gawk extension) If non-zero, case is ignored in string/regexp operations |
| `NF`           | The number of fields in the current input record                          |
| `NR`           | The total number of input records read so far                             |
| `OFS`          | The output field separator (default: space)                               |
| `ORS`          | The output record separator (default: newline)                            |
| `RLENGTH`      | The length of the string matched by match()                               |
| `RS`           | The input record separator (default: newline)                             |
| `RSTART`       | The starting position of the string matched by match()                    |
| `SUBSEP`       | The subscript separator for multidimensional arrays (default: "\034")     |

| `awk` Builtin Function | Description                                                                              |
| ---------------------- | ---------------------------------------------------------------------------------------- |
| `atan2(y, x)`          | Returns the arctangent of `y/x `in radians                                               |
| `close(expr)`          | Closes the file or pipe specified by `expr`                                              |
| `cos(x)`               | Returns the cosine of `x` (in radians)                                                   |
| `exp(x)`               | Returns the exponential of `x` (`e^x`)                                                   |
| `gsub(r, s, t)`        | Substitutes `s` for all occurrences of regexp `r` in string `t`. Returns # substitutions |
| `index(s, t)`          | Returns the position in string `s` where string `t` first occurs, or `0`                 |
| `int(x)`               | Returns the integer part of `x`                                                          |
| `length(s)`            | Returns the length of string `s`                                                         |
| `log(x)`               | Returns the natural logarithm of `x`                                                     |
| `match(s, r)`          | Returns the position in `s` where regexp `r` occurs, or `0`. Sets `RSTART`, `RLENGTH`    |
| `mktime(ts)`           | Converts date specification ts (`"YYYY MM DD HH MM SS [DST]"`) to timestamp              |
| `rand()`               | Returns a random floating-point number between 0 and 1                                   |
| `sin(x)`               | Returns the sine of `x` (in radians)                                                     |
| `split(s, a, r)`       | Splits string `s` into array `a` on regexp `r`. Returns # fields                         |
| `sprintf(fmt, ...)`    | Returns a string formatted according to printf format fmt                                |
| `sqrt(x)`              | Returns the square root of `x`                                                           |
| `srand(x)`             | Seeds the random number generator with `x` (uses time if `x` omitted)                    |
| `strftime(fmt, ts)`    | Formats timestamp `ts` according to fmt. Uses current time if `ts` omitted               |
| `sub(r, s, t)`         | Substitutes `s` for the first occurrence of regexp `r` in string `t`. Returns `1` or `0` |
| `substr(s, i, n)`      | Returns substring of `s` starting at index `i` with length `n`                           |
| `system(cmd)`          | Executes command `cmd` and returns its exit status                                       |
| `systime()`            | Returns the current time as seconds since the epoch                                      |
| `tolower(s)`           | Returns string `s` converted to lowercase                                                |
| `toupper(s)`           | Returns string `s` converted to uppercase                                                |

```sh
# Print the first and third columns of file.txt, separated by a tab
awk '{ print $1 "\t" $3 }' file.txt
# Print lines from log.txt where the first field/column is "ERROR"
awk '$1 == "ERROR" { print $0 }' log.txt
awk '$1 == "ERROR"' log.txt
# Calculate the sum of the second column in data.txt
awk '{ sum += $2 } END { print sum }' data.txt
# Print lines longer than 80 characters (use the length() function and omits the action, defaulting to print $0)
awk 'length($0) > 80' filename.log
# Print the last field/column of each line (use the built-in variable NF which holds the number of fields/columns)
awk '{ print $NF }' data.txt
# Print lines 10 through 20 (use the built-in variable NR which holds the number of records/rows)
awk 'NR >= 10 && NR <= 20' input.txt
# Print lines from a CSV file where the 2nd column is "pending" (uses -F',' to set the field separator to a comma)
awk -F',' '$2 == "pending" { print $0 }' status.csv
# Count lines containing the word "warning" (use a regex pattern /warning/, increments a counter, and prints the total in the END block)
awk '/warning/ { count++ } END { print count }' system.log
# Print the first field of lines containing "error", converting it to uppercase (uses the toupper() string function)
awk '/error/ { print toupper($1) }' app.log
# Calculate the average of the values in the 3rd column (sums values and counts lines, then calculates the average in the END block, checking for division by zero)
awk '{ total += $3; count++ } END { if (count > 0) print total / count }' numbers.txt
# Add line numbers to a file (prints the line number NR, a colon, and the original line $0)
awk '{ print NR ": " $0 }' file.txt
# Print fields 2 and 3, separated by a hyphen (sets the Output Field Separator OFS in the BEGIN block)
awk 'BEGIN { OFS="-" } { print $2, $3 }' data.txt
# Print lines where the number of fields/columns is exactly 5
awk 'NF == 5' structured_data.txt
```

```sh
cat data.csv
# name,age,city
# Alice,30,New York
# Bob,25,London

awk -F',' '{print $1, $3}' data.csv
awk 'BEGIN { FS = "," } {print $1, $3}' data.csv # Gives same output
# name city
# Alice New York
# Bob London

awk -F',' 'BEGIN { OFS = "_" } {print $1, $2}' data.csv
# name_age
# Alice_30
# Bob_25
```

```sh
local latest_remote_node_version=$(command fnm ls-remote | grep "$major_node_version" | tail -n 1 | awk '{print $1}')
```

## `cat`

| `cat` Flag | Description                                                                  |
| ---------- | ---------------------------------------------------------------------------- |
| `-n`       | Number output lines (starting from 1)                                        |
| `-A`       | Display non-printing characters - handy for debugging (not available on mac) |
| `-s`       | Squeeze consecutive blank lines into single blank line                       |

- Note: the `tac` command reverses the order of lines
- Note: the `rev` command reverses the order of characters in lines

## `cp` - Copy

```sh
# Copy file to current working directory
cd /path/to/targetDirectory
cp /path/to/srcFile ./
```

## `cut` - Vertical Slice

> The `cut` command prints selected parts of input lines
> cut can select columns, column separator defaults to tab

- `cut` CANNOT refer to "last column" without counting the columns
- `cut` CANNOT reorder columns
- Lists are specified as ranges (e.g. 1-5) or comma-separated (e.g. 2,4,5)

| `cut` Flag                            | Description                                                |
| ------------------------------------- | ---------------------------------------------------------- |
| `-flist-of-cols` (`-fx-y`, `-fx,y,z`) | Print only the specified columns (tab-separated) on output |
| `-clist-of-pos` (`-cx-y`, `-cx,y,z`)  | Print only chars in the specified positions                |
| `-d'char'`                            | Use character `char` as the field separator                |

```sh
# Print the first column
cut -f1 data.txt
# Print the first three columns
cut -f1-3 data.txt
# Print the first and fourth columns
cut -f1,4 data.txt
# Print all columns after the third
cut -f4- data.txt
# Print the first three columns, if '|'-separated
cut -d'|' -f-3 data.txt
# Print the first five chars on each line
cut -c1-5 data.txt
```

```sh
local latest_remote_node_version=$(command fnm ls-remote | grep "$major_node_version" | tail -n 1 | cut -d' ' -f1)
```

## `date` - Timestamp

```sh
# ISO 8601 standard format with ' ' separator
date +"%Y-%m-%d %H:%M:%S"
# ISO 8601 standard format with 'T' separator
date +"%Y-%m-%dT%H:%M:%S"
date +"%Y-%m-%dT%H-%M-%S"
# ISO 8601 standard format with '_' separator
date +"%Y-%m-%d_%H-%M-%S"
# No separator (compact)
date +"%Y%m%d%H%M%S"
# Unix Timestamp (seconds since January 1, 1970)
date +%s
```

## `find` - Search for files

> The find commands allows you to search for files based on specified properties

- Entire directory trees, testing each file for the required property.
- Takes actions for all matching files - default action is print the filename
- Very useful as first stage of pipeline, but can specify operation as well

> Invocation: `find directories fileProperties actions`

- `fileProperties` = Examine file properties like name, type, modification date
- `actions` = Actions can be simply to print the name or execute an arbitrary command on the matched file

```sh
# Find all the HTML files below /home/z5234567/public_html
find /home/z5234567/public_html -name '*.html'
# Find all your files/dirs changed in the last 2 days
find ~ -mtime -2
# Show info on files changed in the last 2 days
find ~ -mtime -2 -type f -exec ls -l {} \;
# Show info on directories changed in the last week
find ~ -mtime -7 -type d -exec ls -ld {} \;
# Find directories either new or '07' in their name
find ~ -type d \( -name '*07*' -o -mtime -1 \)
# Find all new HTML files below ~/public_html
find ~/public_html -name '*.html' -mtime -1
# Find background colours in my HTML files
find ~/public_html -name '*.html' -exec grep -H 'bgcolor' {} \;
# Above could also be accomplished via ...
grep -r 'bgcolor' ~/public_html
# Make sure that all HTML files are accessible
find ~/public_html -name '*.html' -exec chmod 644 {} \;
# Remove any really old files
find /home/same -type f -mtime +364 -exec rm {} \;
find /home/same -type f -mtime +364 -ok rm {} \;
```

## `grep` - Globally search with Regular Expressions and Print

Note: `grep` with regex flags (`-E`, `-P`, `-e`) are case-SENSITIVE by default

```sh
# GNU Grep
grep --color=always -iP 'quoted-regex'
# BSD/macOS Grep
grep --color=always -ie 'quoted-regex'
```

| `grep` Flag | Description                                                    |
| ----------- | -------------------------------------------------------------- |
| `-E`        | Use extended regular expression syntax                         |
| `-P`        | Use POSIX regular expressions + Perl extensions (PCRE library) |
| `-i`        | Ignore upper/lower-case difference in matching                 |
| `-v`        | Only display lines that do NOT match the pattern               |
| `-c`        | Print a count of matching lines                                |
| `-w`        | Only match pattern if it makes a complete word                 |
| `-x`        | Only match pattern if it makes a complete line                 |

## `head`/`tail` (Select `first`/`last` lines)

- `head` prints the first `n` (default 10) lines of input
- `tail` prints the last `n` lines of input
- The `-n` option changes number of lines head/tail prints.
  - E.g. `tail -n 30 file` prints last 30 lines of file.
- Combine head and tail to select a range of lines.
  - `head -n 100 | tail -n 20` copies lines `81...100` to output

## `join` - Join Files

> `join` merges two files using the values in a column in each file as a common key.

- The key column can be in a different position in each file, but the files must be ordered on that column
- The default key column is 1

| `join` Flag | Description                                              |
| ----------- | -------------------------------------------------------- |
| `-1 k`      | Key column in first file is `k`                          |
| `-2 k`      | Key column in second file is `k`                         |
| `-a N`      | Print a line for each unpairable line in file N (1 or 2) |
| `-i`        | Ignore case                                              |
| `-t 'char'` | Tab character is char                                    |

```sh
cat data1.txt
# Bugs Bunny 1953
# Daffy Duck 1948
# Donald Duck 1939
# Goofy 1952
# Mickey Mouse 1937
# Nemo 2003
# Road Runner 1949

cat data2.txt
# Warners Bugs Bunny
# Warners Daffy Duck
# Disney Goofy
# Disney Mickey Mouse
# Pixar Nemo

join -t' ' -2 2 -a 1 data1.txt data2.txt
# Bugs Bunny 1953 Warners
# Daffy Duck 1948 Warners
# Donald Duck 1939
# Goofy 1952 Disney
# Mickey Mouse 1937 Disney
# Nemo 2003 Pixar
# Road Runner 1949
```

## `kill` - Kill ProcessId

```sh
kill -9 <processId>
```

## `ls`

```sh
# OLDEST files at BOTTOM
ls -lt
# NEWEST files at BOTTOM
ls -ltr

# OLDEST files at BOTTOM
ls -AoFt
# NEWEST files at BOTTOM
ls -AoFtr
```

## `less` - View File Contents using Pager

> The `less` command is a pager utility similar to `more`, but it allows both backward and forward movement through a file and doesn't have to read the entire file before starting
>
> `less` is generally considered more powerful and flexible than `more`

| `less` Keyboard Command | Description                                         |
| ----------------------- | --------------------------------------------------- |
| `Spacebar or Page Down` | Move forward one screenful                          |
| `b or Page Up`          | Move backward one screenful                         |
| `Down Arrow`            | Move forward one line                               |
| `Up Arrow`              | Move backward one line                              |
| `/pattern`              | Search forward for the pattern                      |
| `?pattern`              | Search backward for the pattern                     |
| `n`                     | Repeat the previous search                          |
| `N`                     | Repeat the previous search in the reverse direction |
| `g`                     | Go to the beginning of the file                     |
| `G`                     | Go to the end of the file                           |
| `q`                     | Quit less                                           |

```sh
less /Users/same/dev/github/notes/dev/_linux-notes.md
```

## `more` - View File Contents using Pager

> The `more` command is a pager utility in Linux used to view the contents of a text file one screenful at a time
>
> Less powerful than `less`

| `more` Keyboard Command | Description                      |
| ----------------------- | -------------------------------- |
| `Spacebar`              | Display the next screenful       |
| `Enter`                 | Display the next line            |
| `/pattern`              | Search for the specified pattern |
| `q`                     | Quit more                        |

```sh
more /Users/same/dev/github/notes/dev/_linux-notes.md
```

## `paste` - Combine Files

> The paste command displays several text files "in parallel" on output.

- If the inputs are files `a`, `b`, `c`
  - The first line of output is composed of the first lines of `a`, `b`, `c`
  - The second line of output is composed of the second lines of `a`, `b`, `c`
- Lines from each file are separated by a tab character or specified delimiter(s).
- If files are different lengths, output has all lines from longest file, with empty strings for missing lines.
- Interleaves lines instead with -s (serial) option

```sh
# Example: Using paste to rebuild a file broken up by cut
# Assume "data.txt" is a file with 3 tab-separated columns
cut -f1 data > data1
cut -f2 data > data2
cut -f3 data > data3
paste data1 data2 data3 > newData
# "newData" should look the same as "data"
```

## `pkill` - Kill Process by Name

```sh
pkill -9 -f "processName"
```

## `ps`

```sh
ps aux | grep -ie "<process-name-to-find-using-regex>"
```

## `sed` - Stream Editor

> `sed` is an editor for streams (pipelines)
>
> `sed` can also be used to change files

- How sed works:
  - Read each line of input
  - Check if it matches any patterns or line-ranges
  - Apply related editing commands to the line
  - Write the transformed line to output
- In addition, sed can:
  - Partition lines based on patterns rather than columns
  - Extract ranges of lines based on patterns or line numbers

| `sort` Flag                     | Description                                                                                                                      |
| ------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| `-E`, `-r`, `--regexp-extended` | Extended regular expressions                                                                                                     |
| `-n`                            | Do NOT print lines by default - applies all editing commands as normal but displays no output, unless p appended to edit command |

| `sort` Editing flag   | Description                                                            |
| --------------------- | ---------------------------------------------------------------------- |
| `p`                   | Print the current line                                                 |
| `d`                   | Delete (don't print) the current line                                  |
| `s/regex/replace/`    | Substitute first occurrence of string matching regex by replace string |
| `s/regex/replace/g`   | Substitute all occurrences of string matching regex by replace string  |
| `s/regex/replace/gim` | Global + Ignore Case + Multiline                                       |
| `q`                   | Terminate execution of sed                                             |

All editing commands can be qualified by line addresses or line selector patterns to limit lines where command is applied

|                                     | Description                                                    |
| ----------------------------------- | -------------------------------------------------------------- |
| `line_number`                       | Selects the specified line                                     |
| `start_line_number,end_line_number` | Selects all lines between specified line numbers               |
| `/regex/`                           | Selects all lines that match `regex`                           |
| `/regex1/,/regex2/`                 | Selects all lines between lines matching `regex1` and `regex2` |

```sh
# Print all lines
sed -n 'p' < file
# Print the first 10 lines
sed '10q' < file
sed -n '1,10p' < file
# Print lines 81 to 100
sed -n '81,100p' < file
# Print the last 10 lines of the file?
sed -n '$-10,$p' < file # INVALID
sed -n "$((`wc -l < file` - 9)),\$p" file # VALID (count total lines, subtracts 9 from the total line count to use as starting line, create sed range)
# Print only lines containing 'xyz'
sed -n '/xyz/p' < file
# Print only lines NOT containing 'xyz'
sed '/xyz/d' < file
# Show the passwd file, displaying only the lines from "root" up to "nobody" (i.e. system accounts)
sed -n '/^root/,/^nobody/p' /etc/passwd
# Remove first column from ':'-separated file
sed 's/[^:]*://' datafile
# Reverse the order of the first two columns
sed -E 's/([^:]*):([^:]*):(.*)$/\2:\1:\3/
```

### Change a file with sed

```sh
# Use a temporary file
sed 's/[aeiou]//g' story.txt > story2.txt
mv story.txt.new story.txt
# Use `in-place` flag -i
sed -i 's/[aeiou]//g' story.tx
```

## `sort` - Sort Lines

> The sort command copies input to output but ensures that the output is arranged in some particular order of lines

- By default, sorting is based on the first characters in the line.
- Other features of sort:
  - Can sort columns other than the first (which is the default)
  - Can ignore punctuation or case differences
  - Can sort files "in place" as well as behaving like a filter

| `sort` Flag | Description                                                                  |
| ----------- | ---------------------------------------------------------------------------- |
|             | Sort in ASCENDING order (lexicographically)                                  |
| `-r`        | Sort in DESCENDING/reverse order (lexicographically)                         |
| `-n`        | Sort NUMERICALLY rather than lexicographically                               |
| `-d`        | Dictionary order: ignore non-letters and non-digits                          |
| `-t'char'`  | Use character c to separate columns (default: non-blank to blank transition) |
| `-kn`       | Sort on column n                                                             |

```sh
# Sort numbers in 3rd column in descending order
sort -nr -k3 data.txt
# Sort the password file based on user name
sort -t':' -k5 /etc/passwd
```

## `tee` - Send Copy of Pipeline to File

> A useful debugging trick is `tee /dev/tty` to divert a copy of a pipeline to the terminal

```sh
echo Hello World | tee copy.txt
# Hello World
cat copy.txt
# Hello World
```

## `tr` - Transliterate Characters

> `tr` reads chars and writes characters, mapping (replacing) some chars with others
>
> The mapping is specified as 2 arguments: `tr sourceChars destChars`

- `tr` does NOT accept file names on the command line (ONLY uses `stdin`)
- Chars that are NOT in `sourceChars` are copied unchanged to output
- If there is NO corresponding char (i.e. `destChars` is shorter than `sourceChars`), then the last char in `destChars` is used
- Shorthands are available for specifying char lists: `'a-z'` is equivalent to `'abcdefghijklmnopqrstuvwxyz'`
- Note: newlines can be modified if the mapping specification requires it.

| `tr` Flag | Description                                                    |
| --------- | -------------------------------------------------------------- |
| `-c`      | Map all bytes not occurring in `sourceChars` (complement)      |
| `-s`      | Squeeze adjacent repeated characters out (only copy the first) |
| `-d`      | Delete all characters in `sourceChars` (no `destChars`)        |

```sh
tr 'abc' '123' < text.txt
# a -> 1, b -> 2, c -> 3
```

```sh
# Map all upper-case letters to lower-case equivalents
tr 'A-Z' 'a-z' < text
# Naive encryption (a->b, b->c, ... z->a)
tr 'a-zA-Z' 'b-zaB-ZA' < text
# Remove all digits from input
tr -d '0-9' < text
# Break text file into individual words, one per line
tr -cs 'a-zA-Z0-9' '\n' < text
```

## `uniq` - Remove or Count Duplicates

> `uniq` removes all but one copy of adjacent identical lines

- `uniq` is often preceded by cut
- `uniq` is often preceded by sort (to ensure identical lines are adjacent)

| `uniq` Flag | Description                                        |
| ----------- | -------------------------------------------------- |
| `-c`        | Also print number of times each line is duplicated |
| `-d`        | Only print (one copy of) duplicated lines          |
| `-u`        | Only print lines that occur uniquely (once only)   |

```sh
# extract first field, sort, and tally
cut -f1 data.txt | sort | uniq -c
```

## `wc` - Word Counter

> `wc` summarizes its input as a single line
>
> By default `wc` prints the number of lines, words, characters in its input (`numLines`, `numWords`, `numChars`)

- `wc` is often useful as last command in pipeline

| `wc` Flag | Description                                      |
| --------- | ------------------------------------------------ |
| `-c`      | Print the number of characters                   |
| `-w`      | Print the number of words (non-white space) only |
| `-l`      | Print the number of lines only                   |

```sh
wc /etc/passwd
#   73  586 5585 test2.txt
#   numLines, numWords, numCharacters
```

## `where`

```sh
where jmeter
```

## `xargs` - Run Commands With Arguments From stdin (Standard Input)

| `xargs` Flag    | Description                                                                                  |
| --------------- | -------------------------------------------------------------------------------------------- |
| `nmax-args`     | Use at most max-args arguments per command line                                              |
| `-Pmax-procs`   | Run up to max-procs processes at a time                                                      |
| `-Ireplace-str` | Replace occurrences of `replace-str` in the initial arguments with the input read from stdin |

```sh
# Remove home directories of users named Seth:
grep Seth /etc/passwd | cut -d: -f6 | xargs rm -r
# Run make in every sub-directory below /usr/src/ with a Makefile, run up to 8 make's in parallel
# - The -i@ flag (or -I@ in newer versions) tells xargs to use @ as a placeholder. For each line of input xargs receives, xargs will replace every occurrence of @ in the command that follows with that input line
# - For a path like /usr/src/linux-headers-XYZ/, the -i@ tells xargs to substitute in this path wherever it sees @
find /usr/src -name Makefile | sed 's/Makefile//' | xargs -P8 -i@ make -C @
```

## SSH

```sh
ssh <ip_address>
ssh <ip_address> -l <user_name>
```

### Change User to Root

```sh
sudo su
sudo su - root
# sudo su - userToChangeTo
sudo -s
```

### Copy Local File into Remote SSH Instance

```sh
scp /path/to/local/file user@remote-host-ip:/path/to/remote/directory
# scp /path/to/local/file user@192.168.1.100:/path/to/remote/directory
# scp /path/to/local/file user@example.com:/path/to/remote/directory
```

### Copy File from Remote SSH Instance into Local Directory

```sh
scp user@remote-ip-host:/path/to/remote/file /path/to/local/directory
# scp user@192.168.1.100:/path/to/remote/directory /path/to/local/directory
# scp user@example.com:/path/to/remote/directory /path/to/local/directory
```

# Filters

- Horizontal slicing - Select Subset Of Lines: `cat`, `head`, `tail`, `grep`, `sed`, `uniq`
- Vertical slicing - Select Subset Of Columns: `cut` , `sed`
- Substitution: `tr`, `sed`
- Aggregation, simple statistics: `wc`, `uniq`
- Assembly - Combining Data Sources: `paste`, `join`
- Reordering: `sort`
- Viewing (always end of pipeline): more, less
- File system search: find
- Programmable filters: sed (also awk, python, perl, …)

# Process Substitution (Named Pipes)

- Bash provides process substitution
  - Does not work with other shells
  - Uses temporary named pipes
- `<(command)`
  - Example: `diff <(sort file1) <(sort file2)`
  - Runs `sort file1` and `sort file2` then passes fake/temporary filenames to `diff` as arguments
- `>(command)`
  - Example: `tar cf - somedir | tee >(shasum > dir.tgz.shasum) >(md5sum > dir.tgz.md5sum) > dir.tar`
  - Runs `shasum`, `md5sum`, and creates `dir.tar` all with the output of `tar`
- Useful for commands which don't provide any way of reading from stdin or writing to stdout
  - Note: Check if `-` as filename works
  - Note: `/dev/stdin`, `/dev/stdout` may be available
- Useful to combine two pipelines

# Scripts

## Template

> The shebang line should always be `#!/usr/bin/env bash`

- `bash` and `sh` are two different shells
  - `bash` is `sh`, with more features and better syntax
  - `bash != sh && bash >> sh`
- `env` uses the `$PATH` to find `bash` (this is useful if `bash` is NOT in `/bin`)

```sh
#!/usr/bin/env bash
```

# Workflow

## Delete every 2nd and 3rd lines of file

- Used to grab all leetcode questions done (copy paste from leetcode website)
- `awk '(NR-1)%3<1' fileName`
  - The command `(NR-1)%3<1` tells awk to print any line for which `(NR-1)%3<1` is `true`
  - In awk, `NR` is the line number with the first line counting as `1`
  - For every three lines in the file, that statement will be true for the first line
- [Read more](https://unix.stackexchange.com/questions/509553/how-to-delete-every-two-lines-after-3rd-lines-in-a-file-contains-very-large-numb)

## Find Invalid Folder Names

```sh
cd ~/github/lc-all
ls | grep -E '^[0-9]+\-'

cd ~/github/lc-topics
ls -R | grep -E '^[0-9]+\-'
```

## Find All Java Leetcode Files

```sh
cd github/lc-topics
ls -R | grep -P '^[0-9]+.*\.java' | sort -n | uniq
```

## Move Files From Child Directory To Parent Directory And Delete Child Directory

```sh
cd parent
mv child/* .
rm -rf child
```

## Find All Files In Folder With Partial Match

Example: Finding all files that have

```sh
find . -type f -name '*notes*'

find . -type f -regex '.*notes.*'
```

```sh
find -E . -regex '.*/notes.*'

find . -regextype posix-extended -regex '.*/notes.*'

find . -regextype posix-egrep -regex '.*/notes.*'
```

## List All Completed Leetcode Questions

```sh
cd github/lc-topics
ls -R | grep -P '^\..*:$'
```

```sh
cat array.txt | sed 's/\.\/.*\///g' | sed 's/^\..*//g' | sort -n > array.txt
cat rest.txt | sed 's/\.\/.*\///g' | sed 's/^\..*//g' | sort -n | uniq > rest.txt
```

## Delete All Files and Folders

```sh
rm -rf * .*
```

# Links

![](https://i.sstatic.net/ka2ab.jpg)
![](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*uZxU0JkUd_af0a2fLiPSFg.png)

## Hard Links

> A hard link is a direct reference to a file via its inode.
> You can only hardlink files and NOT directories.
> By using a hardlink, you can change the original file's contents or location and
> the hardlink will still point to the original file because its inode is still pointing to that file.
> There is no referencing to the original file. In addition, hardlinks can only refer to
> files within the same volume otherwise symbolic links will be needed
>
> A hard link always points a filename to data on a storage device.
>
> Hard Link = Physical Copy of a File
>
> `ln ~/source_file_path ~/hard_link_path`
>
> `ln ~/target_file_path ~/hard_link_path`

Inode:

- Both the original file and the hard link share the same inode number
- This means they point to the same data blocks on the disk

Characteristics:

- Deleting either the original file or the hard link does not delete the actual data on the disk until all hard links to that data are deleted.
- Hard links cannot span across different filesystems
- Hard links cannot be created for directories (to avoid cyclic structures).

## Symbolic Links (Symlinks)

> Symbolic links are essentially shortcuts that reference to a file instead of its inode value.
> This method can be applied to directories and can reference across different hard disks/volumes.
> Since the symbolic link is referring to the original file and not its inode value,
> then replacing the original file into a different folder will break the symbolic link, or create a dangling link
>
> A soft link always points a filename to another filename, which then points to information on a storage device.
>
> Symbolic Link = Symlink = Pointer to a File
>
> Note: The symlinked file/folder will be created for you automatically
>
> `ln -s ~/source_file_path ~/sym_linked_file_path`
>
> `ln -s ~/path/to/original/folder ~/path/to/symlinked/folder`

Note:

- ALWAYS use FULL paths when creating BOTH hard links and symbolic links/symlinks
- Editing the symlinked files / files within symlinked folders will modify the original files

Inode:

- The symbolic link has its own inode and the data within it is the path to the target file or directory.

Characteristics:

- If you delete the original file, the symbolic link becomes a dangling link (broken link) pointing to a non-existent file.
- Symbolic links can span across different filesystems.
- Symbolic links can reference directories as well as files.

## Zsh

### `{}` - Grouping Commands

The curly braces {} group commands together but execute them in the current shell context:

- Commands inside {} run in the same shell process
- Variables set inside {} affect the current shell
- More efficient (no subprocess creation)
- Requires spaces around braces and semicolon before closing brace

```sh
is-not-git-repo() {
  ! { [ -d ".git" ] || { [ -f ".git" ] && [ -f ".gitignore" ]; } } && return 0 || return 1 # The curly braces {} group commands together but execute them in the current shell context (more efficient) (requires spaces around braces and semicolon before closing brace)
}
```

### `()` - Subshell Execution

The parentheses () create a subshell to execute the commands:

- Commands inside () run in a separate subprocess
- Variables set inside () don't affect the parent shell
- Slightly less efficient due to subshell creation
- Does NOT require special spacing or semicolons

```sh
is-not-git-repo() {
  ! ( [ -d ".git" ] || ([ -f ".git" ] && [ -f ".gitignore" ]) ) && return 0 || return 1 # The parentheses () create a subshell to execute the commands (less efficient) (does not require special spacing or semicolons)
}
```
