# Table of Contents

- [Table of Contents](#table-of-contents)
- [Setup](#setup)
- [Notes](#notes)
  - [Scroll](#scroll)
  - [Search](#search)
- [Customisation](#customisation)
  - [Clang Auto Format Options](#clang-auto-format-options)
  - [Flake8 Rules](#flake8-rules)
- [Extensions](#extensions)
- [Keyboard Shortcuts](#keyboard-shortcuts)
  - [Command Palette](#command-palette)
  - [Copy Line](#copy-line)
  - [Cycle Tabs](#cycle-tabs)
  - [Find Code in Files](#find-code-in-files)
  - [Find/Replace](#findreplace)
  - [Go to Specific Line](#go-to-specific-line)
  - [Multiple Cursors](#multiple-cursors)
  - [Open File in File Explorer](#open-file-in-file-explorer)
  - [Open Markdown Preview](#open-markdown-preview)
  - [Search for Files (in opened folder workspace)](#search-for-files-in-opened-folder-workspace)
  - [Settings](#settings)
  - [Split View](#split-view)
  - [Swap Lines](#swap-lines)
  - [Toggle Word Wrap](#toggle-word-wrap)

# Setup

- `Ctrl + Shift + P`
- `> Preferences: Open Settings (UI)`
- Search for "unchost" (may need to change to Remote tab)
- Add `wsl.localhost` to it

```json
"security.allowedUNCHosts" : [ "wsl.localhost" ]
```

# Notes

## Scroll

- Hold `Alt` key to scroll FASTER vertically
- Hold `Shift` key to scroll HORIZONTALLY

## Search

Include

```
github/lc-all/**/*.java
github/lc-all/**/*.cpp
```

Exclude

```
*.svg, *.c, *.py
```

# Customisation

- [Theme Color API](https://code.visualstudio.com/api/references/theme-color)
- VSCode Settings
  - Preferences: Open Settings (UI) > Terminal > Integrated: GPU Acceleration > Turn OFF
  - Preferences: Open Settings (UI) > Terminal > Integrated: Scrollback > 2000
- GitLens Settings
  - GitLens: Open Settings > Current Line > TURN OFF
  - GitLens: Open Settings > Interactive Rebase Editor > TURN OFF

## Clang Auto Format Options

https://clang.llvm.org/docs/ClangFormatStyleOptions.html

## Flake8 Rules

https://www.flake8rules.com/

# Extensions

Notes:

- Make sure to go into "Tabnine Hub" and TURN OFF "Analytics"
- Make sure to DISABLE ".NET Install Tool" extension

Extension List:

- .NET Install Tool
- Astro
- **autopep8**
- **Babel JavaScript**
- **Better C++ Syntax**
- **Better Comments**
- Better Dockerfile Syntax
- Better Go Syntax
- Better Perl Syntax (DISABLED)
- **Better Shell Syntax**
- **Black Formatter**
- **C/C++**
- C/C++ Extension Pack (DISABLED)
- C# (DISABLED)
- Clang-Format (DISABLED)
- clangd (DISABLED) (If want to use need to disable C/C++ extension from Microsoft in `settings.json`)
- Cloak (John Papa)
- CMake (DISABLED)
- CMakeTools (DISABLED)
- **Code Spell Checker**
- Codeium (AI) (DISABLED)
- CodeLLDB (DISABLED)
- Cody (AI) (DISABLED)
- **Color Highlight**
- **Color Info (Matt Bierner)**
- CSS Peek (DISABLED)
- **CSS Navigation (pucelle)**
- **Dev Containers (Microsoft)**
- **Docker**
- DotENV
- Doxygen Documentation Generator (DISABLED)
- **Dracula Official**
- **ES7+ React/Redux/GraphQL/React-Native snippets**
- **ESLint**
- **Even Better TOML**
- **Extension Pack for Java**
- **Fast Compare (David Kolar)**
- **Firebase (toba)**
- Flake8
- **Format All Files in Workspace (Alex Ross)**
- Frontend Essentials Extension Pack (FPack) (SeyyedKhandon)
- GitHub Theme (DISABLED)
- **GitLens**
- **HTML CSS Support (ecmel)**
- **indent-rainbow**
- **IntelliCode**
- IntelliCode API Usage Examples (DISABLED)
- **IntelliCode Completions**
- **isort**
- **JavaScript (ES6) Code Snippets**
- **json2ts (Gregor Biswanger)**
- Jupyter (DISABLED)
- Jupyter Cell Tags (DISABLED)
- Jupyter Keymap (DISABLED)
- Jupyter Notebook Renderers (DISABLED)
- Jupyter Slide Show (DISABLED)
- LaTeX Workshop (DISABLED)
- Live Server (DISABLED)
- **Markdown All in One (Yu Zhang)**
- Markdown Checkboxes (DISABLED)
- Markdown Lint (David Anson) (DISABLED)
- Markdown Preview Enhanced (DISABLED)
- **Material Icon Theme**
- MDX (unified)
- Monorepo Workspace (Folke Lemaitre)
- Native Debug (WebFreak)
- npm Intellisense (Christian Kohler)
- **Partial Diff (Ryuichi Inagaki)**
- **Path Intellisense (Christian Kohler)**
- pgFormatter (Brady Holt)
- **PostCSS Sorting (mrmlnc)** (Ctrl+Shift+P -> PostCSS Sorting: Run)
- **Prettier**
- **Pretty TypeScript Errors**
- **Pylance**
- **Pylint**
- **Python**
- Python Indent
- **quick-lint-js (quick-lint)**
- Quokka.js
- Remote - SSH (DISABLED)
- **Remove Non ASCII Characters (Samuel Charpentier)**
- **ShellCheck**
- Simple React Snippets (DISABLED)
- **Spring Boot Dashboard**
- **Spring Boot Tools**
- **Spring Initializr Java Support**
- **SQLTools**
- **SSH FS**
- **Tabnine: AI Autocomplete**
- **Tailwind CSS IntelliSense**
- **Thunder Client**
- **Turbo Console Log**
- **WSL (Microsoft)**
- **XML (Red Hat)**
- **yapf**

# Keyboard Shortcuts

## Command Palette

- `Ctrl + Shift + P`
  - Change Language Mode
  - Compare Active File With...
  - Convert Indentation to Spaces
  - Convert Indentation to Tabs
  - Delete Duplicate Lines
  - Developer: Reload Window
  - Format Document
  - Format Document With...
  - Preferences: Open Default Settings (JSON)
  - Preferences: Open Settings (JSON)
  - Preferences: Open Settings (UI)
  - Reindent Lines
  - Sort Lines Ascending
  - Sort Lines Descending
  - Transform to Lowercase
  - Transform to Snake Case
  - Transform to Title Case
  - Transform to Uppercase
  - View: Toggle Word Wrap

## Copy Line

- Copy Line Down
  - `Shift + Alt + (down arrow)`
- Copy Line Up
  - `Shift + Alt + (up arrow)`
- Note this also works with current selection (whatever you have highlighted)

## Cycle Tabs

- `Ctrl + PageDown`
- `Ctrl + PageUp`

## Find Code in Files

- `Ctrl + Shift + F`

  ```
  github/lc-all/**/*.py
  github/lc-all/**/*.java, *.py
  ```

## Find/Replace

- Find
  - `Ctrl + F`
- Find + Replace
  - `Ctrl + H`
- When you have pressed one of the above combinations and are currently in the search editor
  - Toggle Case-Sensitive
    - `Alt + C`
  - Toggle Whole Word
    - `Alt + W`
  - Toggle Regex
    - `Alt + R`

## Go to Specific Line

- `Ctrl + G`

## Multiple Cursors

- Method 1 (Insert cursor manually with mouse click)
  - Hold `Alt` and `left click` with mouse to add cursor
  - Unselect using `Alt + U`
- Method 2 (Insert cursor above / below)
  - Hold `Ctrl + Alt`, use arrows keys `up` and `down` to insert cursors above / below
- Select Current Line
  - `Ctrl + L`
- Select All Occurrences Of Current Selection
  - `Ctrl + Shift + L`
- Select All Occurrences Of Current Word
  - `Ctrl + F2`
- Expand Selection
  - `Shift + Alt + (right arrow)`
- Shrink Selection
  - `Shift + Alt + (left arrow)`
- Column Box Selection (Mouse)
  - `Shift + Alt + (drag mouse)`
- Column Box Selection (Keyboard)
  - `Ctrl + Shift + Alt + (arrow key)`

## Open File in File Explorer

- `Alt + Shift + R`
  - Note file has to be open in code editor

## Open Markdown Preview

- `Ctrl + K` then `V`

## Search for Files (in opened folder workspace)

- `Ctrl+P`
  - [Read more](https://code.visualstudio.com/docs/editor/codebasics#_advanced-search-options)

## Settings

- `Ctrl + ,`

## Split View

- `Ctrl + \`

## Swap Lines

- `Alt + Up`
- `Alt + Down`

## Toggle Word Wrap

- `Alt + Z`
