# Table of Contents

- [Table of Contents](#table-of-contents)
- [IO Redirection](#io-redirection)
  - [File Descriptors](#file-descriptors)
  - [Output Redirection Types](#output-redirection-types)
    - [1. Standard Output (stdout)](#1-standard-output-stdout)
    - [2. Standard Error (stderr)](#2-standard-error-stderr)
    - [3. Redirecting Both stdout and stderr](#3-redirecting-both-stdout-and-stderr)
    - [4. Redirecting Streams to Built-in Descriptors](#4-redirecting-streams-to-built-in-descriptors)
    - [5. Discarding Output](#5-discarding-output)
  - [Input Redirection](#input-redirection)
    - [1. Standard Input (stdin)](#1-standard-input-stdin)
    - [2. Here Documents (\<\<)](#2-here-documents-)
    - [3. Here Strings (\<\<\<)](#3-here-strings-)
  - [Advanced Redirection](#advanced-redirection)
    - [1. Process Substitution (`<()`, `>()`)](#1-process-substitution--)
    - [2. Zsh Specifics (MULTIOS)](#2-zsh-specifics-multios)
- [Short-Circuit Evaluation](#short-circuit-evaluation)
- [parentheses () vs curly braces {}](#parentheses--vs-curly-braces-)
  - [Parentheses (): Subshell Execution](#parentheses--subshell-execution)
  - [Curly Braces {}: Current Shell Execution (Command Grouping)](#curly-braces--current-shell-execution-command-grouping)

# IO Redirection

## File Descriptors

- `0`: Standard Input (`stdin`)
- `1`: Standard Output (`stdout`)
- `2`: Standard Error (`stderr`)

## Output Redirection Types

### 1. Standard Output (stdout)

`>`: Redirects stdout to a file. Overwrites the file if it exists.

```sh
echo "Hello" > file.txt
```

`>>`: Appends stdout to a file.

```sh
echo "World" >> file.txt
```

### 2. Standard Error (stderr)

`2>`: Redirects stderr to a file. Overwrites.

```sh
ls /nonexistent 2> error.log
```

`2>>`: Appends stderr to a file.

```sh
ls /nonexistent 2>> error.log
```

### 3. Redirecting Both stdout and stderr

`&>` or `>&`: Redirects both stdout and stderr to the same file (Bash 4+ and Zsh). Overwrites.

```sh
command &> output.log
```

`&>>`: Appends both stdout and stderr to the same file.

```sh
command &>> output.log
```

Older/POSIX compliant method to redirect both:

```sh
command > output.log 2>&1
```

### 4. Redirecting Streams to Built-in Descriptors

- `>&2` or `1>&2`: Redirects stdout to stderr. Useful for error logging.
- `2>&1`: Redirects stderr to stdout. Useful if you want to pipe errors to another command (e.g., `command 2>&1 | grep error`).

### 5. Discarding Output

To safely ignore output, redirect it to `/dev/null` (the "black hole" of Unix).

- Discard stdout: `command > /dev/null`
- Discard stderr: `command 2> /dev/null`
- Discard both: `command &> /dev/null`

## Input Redirection

### 1. Standard Input (stdin)

`<`: Reads input from a file instead of the keyboard.

```sh
sort < file.txt
```

### 2. Here Documents (<<)

Feeds a multi-line string block to a command until a delimiter is reached.

```sh
cat << EOF
Line 1
Line 2
EOF
```

### 3. Here Strings (<<<)

Feeds a single string directly to a command (supported in Bash and Zsh).

```sh
grep "foo" <<< "foo bar baz"
```

## Advanced Redirection

### 1. Process Substitution (`<()`, `>()`)

Treats the output of a command as a temporary file. Useful for commands that expect file names, not standard input.

`<()`: Read from a process.

```sh
diff <(ls dir1) <(ls dir2)
```

`>()`: Write to a process.

```sh
tar -cf >(gzip -9 > archive.tar.gz) /source
```

### 2. Zsh Specifics (MULTIOS)

By default, Zsh enables the `MULTIOS` option. This allows you to redirect output to multiple destinations natively without using `tee`.

```zsh
# Writes to both file1.txt and file2.txt simultaneously
echo "Data" > file1.txt > file2.txt

# Pipes to grep AND writes to a file
command > file.txt | grep "error"
```

_(Note: To disable this behavior in Zsh and act strictly like Bash, use `unsetopt MULTIOS`)_

# Short-Circuit Evaluation

```sh
[ -d "$dir" ] || continue
```

This is a concise way of writing an if statement in Bash using short-circuit evaluation:

- `[ -d "$dir" ]`: This test checks if the path stored in the variable `$dir` exists and is a directory.
- `|| (Logical OR)`: If the command on the left fails (**returns a non-zero exit status**, meaning it's not a directory), the command on the right is executed.
- `continue`: This command skips the rest of the current loop iteration and moves to the next item.

Overall meaning: "Check if `$dir` is a directory. If it is not, skip to the next iteration of the loop."

# parentheses () vs curly braces {}

In bash and zsh, both parentheses () and curly braces {} are used to group commands, but they execute those commands in fundamentally different environments.

Here is the detailed difference:

## Parentheses (): Subshell Execution

When you wrap commands in parentheses, the shell spawns a new child process (subshell) to execute them.

State Isolation: Any changes to variables, environment, or the current working directory (e.g., using cd) inside the parentheses will not affect the parent shell. Once the subshell exits, those changes are lost.
Syntax: They do not require spaces on the inside or a terminating semicolon.
Example: `(command1; command2)` is perfectly valid.
Performance: There is a slight performance penalty because the operating system has to fork a new process.

## Curly Braces {}: Current Shell Execution (Command Grouping)

When you wrap commands in curly braces, the commands are executed within the current shell context.

Shared State: Any variable assignments or directory changes (e.g., cd) made inside the braces will persist in your current shell script after the block finishes.
Syntax Strictness: Curly braces are reserved words in bash. Therefore:
You must have a space after the opening brace and before the closing brace.
The final command inside the braces must be terminated with a semicolon ; or a newline.
Example: `{ command1; command2; }`
Performance: Because it does not fork a new process, it is slightly faster and more efficient than using a subshell.

Example

```sh
{ [ -f ".git" ] && [ -f ".gitignore" ]; }
# vs
([ -f ".git" ] && [ -f ".gitignore" ])
```

Because you are only performing file existence checks (`[ -f ... ]`) and not changing directories or modifying variables, the logical outcome is exactly the same.
Both simply group the `&&` condition to evaluate together before applying the preceding `||` operator.

However, using `{}` is the better practice here because it avoids the unnecessary overhead of spawning a subshell just to evaluate a boolean expression.
Note the strict syntax in your V1/V2 examples where `{}` correctly includes the inner spaces and the trailing semicolon.
