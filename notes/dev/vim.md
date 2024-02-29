# Table of Contents

- [Table of Contents](#table-of-contents)
- [Note](#note)
- [Normal Mode](#normal-mode)
  - [Enter Normal Mode](#enter-normal-mode)
  - [Copy/Yank (y)](#copyyank-y)
  - [Cut (d)](#cut-d)
  - [Paste (p)](#paste-p)
  - [Select All (Ctrl + A)](#select-all-ctrl--a)
  - [Undo](#undo)
  - [Redo](#redo)
- [Insert Mode](#insert-mode)
  - [Enter Insert Mode](#enter-insert-mode)
  - [Paste (Ctrl + V)](#paste-ctrl--v)
- [Command-Line Mode](#command-line-mode)
  - [Undo (Ctrl + Z)](#undo-ctrl--z)
  - [Save](#save)
  - [Show line numbers](#show-line-numbers)
  - [Quit](#quit)
  - [Quit Without Saving Changes](#quit-without-saving-changes)
- [Vim Grammar](#vim-grammar)
  - [Rule](#rule)
  - [Nouns (Motions)](#nouns-motions)
    - [Text Objects](#text-objects)
  - [Verbs (Operators)](#verbs-operators)

# Note

- All commands that start with **`:`** require pressing **`Esc`** first

# Normal Mode

## Enter Normal Mode

- **`Esc`**

## Copy/Yank (y)

| Command   | Explanation                                                                                                                      |
| --------- | -------------------------------------------------------------------------------------------------------------------------------- |
| **`yy`**  | Copy the current line                                                                                                            |
| **`4yy`** | Copy multiple lines <br> Type in the number of lines followed by **`yy`** <br> **`4yy`** will copy 4 lines starting from cursors |
| **`y$`**  | Copy everything from the cursor to the end of the line                                                                           |
| **`y^`**  | Copy everything from the start of the line to the cursor                                                                         |
| **`yiw`** | Copy the current word                                                                                                            |

## Cut (d)

| Command   | Explanation                                                                                                                   |
| --------- | ----------------------------------------------------------------------------------------------------------------------------- |
| **`dd`**  | Cut the current line                                                                                                          |
| **`4dd`** | Cut multiple lines <br> Type in the number of lines followed by **`dd`** <br> **`4dd`** will cut 4 lines starting from cursor |
| **`d$`**  | Cut everything from the cursor to the end of the lines                                                                        |

## Paste (p)

| Command | Explanation         |
| ------- | ------------------- |
| **`P`** | Paste BEFORE cursor |
| **`p`** | Paste AFTER cursor  |

## Select All (Ctrl + A)

- **`ggVG`**
  - `ggVG` selects all content
  - `gg` moves to the first line
  - `V` starts visual mode
  - `G` jumps to last line thereby selecting from first to last line

## Undo

- Undo Last Change
  - **`u`**
- Undo Multiple Changes
  - **`4u`** (undo's last 4 changes)

## Redo

- Redo Last Change
  - **`Ctrl + r`**
- Redo Multiple Changes
  - **`4Ctrl + r`** (redo's last 4 changes)

# Insert Mode

## Enter Insert Mode

- **`Esc -> i`**

## Paste (Ctrl + V)

- **`Ctrl + Shift + V || middle mouse button`**

# Command-Line Mode

## Undo (Ctrl + Z)

- **`:u`**

## Save

- **`:wq`**

## Show line numbers

- **`:set number`**

## Quit

- **`:q`**

## Quit Without Saving Changes

- **`:q!`**

# Vim Grammar

- [Read more](https://learnvim.irian.to/basics/vim_grammar)

## Rule

- `verb + noun`

## Nouns (Motions)

| Noun/Motion                  | Explanation                                     |
| ---------------------------- | ----------------------------------------------- |
| **`h`**                      | Move cursor LEFT                                |
| **`j`**                      | Move cursor DOWN                                |
| **`k`**                      | Move cursor UP                                  |
| **`l`**                      | Move cursor RIGHT                               |
| **`Ctrl + u`**               | Scroll UP                                       |
| **`Ctrl + d`**               | Scroll DOWN                                     |
| **`Ctrl + e`**               | Scroll DOWN one line                            |
| **`Ctrl + y`**               | Scroll UP one line                              |
| **`w`**                      | Move forward to the beginning of the next word  |
| **`b`**                      | Move backward one word                          |
| **`e`**                      | Move forward to the END of a word               |
| **`}`**                      | Jump to the next paragraph                      |
| **`^`**                      | Go to START of line (first NON-BLANK character) |
| **`0`**                      | Go to START of line (first character)           |
| **`$`**                      | Go to END of the line                           |
| **`gg`**                     | Jumps to the FIRST line of file                 |
| **`G`**                      | Jumps to the LAST line of file                  |
| **`:44 \|\| 44gg \|\| 44G`** | Jump to line 44                                 |
| **`H`**                      | Jump to the TOP of the window (moves cursor)    |
| **`M`**                      | Jump to the MIDDLE of the window (moves cursor) |
| **`L`**                      | Jump to the BOTTOM of the window (moves cursor) |

### Text Objects

| Verb/Operator    | Explanation       |
| ---------------- | ----------------- |
| **`i + object`** | Inner text object |
| **`a + object`** | Outer text object |

- Inner text object selects the object inside EXCLUDING the white space or the surrounding objects
- Outer text object selects the object inside INCLUDING the white space or the surrounding objects
- Example 1
  - `(hello world)`
  - To delete the text inside the parentheses ONLY: `di(`
  - To delete the parentheses AND the text inside: `da(`
- Example 2
  ```js
  const hello = function () {
    console.log('Hello Vim');
    return true;
  };
  ```
  - To delete the entire "Hello Vim": `di(`
  - To delete the "Hello" string: `diw`
  - To delete the content of function (surrounded by `{}`): `di{`
- Example 3

```html
<div>
  <h1>Header1</h1>
  <p>Paragraph1</p>
  <p>Paragraph2</p>
</div>
```

- If your cursor is on "Header1" text:
  - To delete "Header1": `dit`
  - To delete `<h1>Header1</h1>`: `dat`
- If your cursor is on "div":
  - To delete h1 and both p lines: `dit`
  - To delete everything: `dat`
  - To delete "div": `di<`

| Vim        | Text Object            |
| ---------- | ---------------------- |
| `w`        | A word                 |
| `p`        | A paragraph            |
| `s`        | A sentence             |
| `(` or `)` | A pair of `( )`        |
| `{` or `}` | A pair of `{ }`        |
| `[` or `]` | A pair of `[ ]`        |
| `<` or `>` | A pair of `< >`        |
| `t`        | XML tags (i.e.`<div>`) |
| `"`        | A pair of `" "`        |
| `'`        | A Pair of `' '`        |
| \`         | A pair of \`\`         |

## Verbs (Operators)

- `:h operator`

| Verb/Operator | Explanation                                |
| ------------- | ------------------------------------------ |
| **`y`**       | Copy text                                  |
| **`d`**       | Cut text                                   |
| **`c`**       | Cut text + Enter Insert mode               |
| **`P`**       | Paste BEFORE cursor                        |
| **`p`**       | Paste AFTER cursor                         |
| **`>`**       | Indent                                     |
| **`<`**       | Dedent                                     |
| **`=`**       | Reformat (reindent, break long lines, etc) |
| **`yy`**      | Copy line                                  |
| **`dd`**      | Cut text                                   |
| **`cc`**      | Cut text + Enter Insert mode               |
| **`>>`**      | Indent line                                |
| **`<<`**      | Dedent line                                |
| **`==`**      | Reformat line                              |
