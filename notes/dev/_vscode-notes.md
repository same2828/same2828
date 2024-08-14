# Table of Contents

- [Table of Contents](#table-of-contents)
- [Config](#config)
- [Notes](#notes)
  - [Scroll](#scroll)
  - [Search](#search)
- [Customisation](#customisation)
  - [Clang Auto Format Options](#clang-auto-format-options)
  - [Flake8 Rules](#flake8-rules)
- [Extensions](#extensions)
  - [macOS](#macos)
- [Keyboard Shortcuts](#keyboard-shortcuts)
  - [Command Palette](#command-palette)
  - [Copy Line](#copy-line)
  - [Cycle Tabs](#cycle-tabs)
  - [Find Code in Files](#find-code-in-files)
  - [Find/Replace](#findreplace)
  - [Go to Specific Line](#go-to-specific-line)
  - [Move Editor Into Next Group](#move-editor-into-next-group)
  - [Multiple Cursors](#multiple-cursors)
  - [Open File in File Explorer](#open-file-in-file-explorer)
  - [Open Markdown Preview](#open-markdown-preview)
  - [Search for Files (in opened folder workspace)](#search-for-files-in-opened-folder-workspace)
  - [Settings](#settings)
  - [Show Visible Tabs](#show-visible-tabs)
  - [Split View](#split-view)
  - [Swap Lines](#swap-lines)
  - [Toggle Word Wrap](#toggle-word-wrap)
- [Tips/Tricks](#tipstricks)
- [Create Custom Theme](#create-custom-theme)

# Config

- Make sure to **DISABLE** `Format On Save` BEFORE performing `find and replace all` on files (bug with java formatter when opening multiple files with same name)
  - Change `editor.formatOnSave: true` to `editor.formatOnSave: false`

# Notes

## Scroll

- Hold `Alt` key to scroll FASTER vertically
- Hold `Shift` key to scroll HORIZONTALLY

## Search

Include

```
github/lc-all/**/*.java
github/lc-all/**/*.cpp

github/lc-all/**/*.{java,cpp}
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
  - `Outline` tab > 3 dots (more actions) > Turn ON `follow cursor`
  - Activity Bar > Right Click > Activity Bar Position > Top
  - Status Bar > Right Click > HIDE: GitLens Commit Graph, GitLens Launchpad
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

- ~~.NET Install Tool~~
- Apc Customize UI++ (drcika)
- Astro
- **Auto Rename Tag (Jun Han)**
- **autopep8 (Microsoft)**
- **Babel JavaScript (Michael McDermott)**
- **Better C++ Syntax (Jeff Hykin)**
- **Better Comments (Aaron Bond)**
- Better Dockerfile Syntax (Jeff Hykin)
- Better Go Syntax (Jeff Hykin)
- ~~Better Perl Syntax (DISABLED)~~
- **Better Shell Syntax (Jeff Hykin)**
- **Black Formatter (Microsoft)**
- **Bookmarks (Alessandro Fragnani)**
- **C/C++ (Microsoft)**
- ~~C# (DISABLED)~~
- **change-case (wmaurer)**
- Clang-Format (Xaver Hellauer) (DISABLED)
- clangd (LLVM) (DISABLED) (If want to use need to disable C/C++ extension from Microsoft in `settings.json`)
- Cloak (John Papa)
- ~~CMake (DISABLED)~~
- ~~CMakeTools (DISABLED)~~
- **Code Spell Checker (Street Side Software)**
- Codeium: AI (Codeium) (DISABLED) (Alternative to GitHub Copilot)
- CodeSnap (adpyke) (Code Screenshot)
- ~~CodeLLDB (DISABLED)~~
- **Color Highlight (Sergii N)**
- **Color Info (Matt Bierner)**
- **colorize (kamikillerto)**
- **Console Ninja (Wallby.js)**
- ~~CSS Peek (Pranay Prakash) (DISABLED)~~
- **CSS Navigation (pucelle)**
- **Dev Containers (Microsoft)**
- **Docker (Microsoft)**
- DotENV (mikestead)
- ~~Doxygen Documentation Generator (DISABLED)~~
- **Dracula Official (Dracula Theme)**
- **Draw.io Integration (Henning Dieterichs)**
- **Error Lens (Alexander)**
- **ES7+ React/Redux/GraphQL/React-Native snippets (dsznajder)**
- **ESLint (Microsoft)**
- **Even Better TOML (tamasfe)**
- **Excel Viewer (MESCIUS)**
- **Extension Pack for Java**
- **Fast Compare (David Kolar)**
- **File Utils (Steffen Leistner)**
- **Firebase (toba)**
- Flake8 (Microsoft)
- **Format All Files in Workspace (Alex Ross)**
- Frontend Essentials Extension Pack (FPack) (SeyyedKhandon)
- **Git Graph (mhutchie)**
- **Git History (Don Jayamanne)**
- GitHub Copilot (GitHub)
- GitHub Copilot Chat (GitHub)
- ~~GitHub Theme (DISABLED)~~
- **GitLens (GitKraken)**
- **HTML CSS Support (ecmel)**
- **Hungry Delete (jasonlhy)**
- Image Preview (Kiss Tamas)
- **indent-rainbow (oderwat)**
- **IntelliCode (Microsoft)**
- ~~IntelliCode API Usage Examples (Microsoft) (DISABLED)~~
- **IntelliCode Completions (Microsoft)**
- **isort (Microsoft)**
- **JavaScript (ES6) Code Snippets (charalampos karypidis)**
- **json2ts (Gregor Biswanger)**
- **JSON Crack (Aykut Sarac)**
- ~~Jupyter (Microsoft) (DISABLED)~~
- ~~Jupyter Cell Tags (Microsoft) (DISABLED)~~
- ~~Jupyter Keymap (Microsoft) (DISABLED)~~
- ~~Jupyter Notebook Renderers (Microsoft) (DISABLED)~~
- ~~Jupyter Slide Show (Microsoft) (DISABLED)~~
- LaTeX Workshop (James Yu) (DISABLED)
- Live Server (Ritwick Dey) (DISABLED)
- **Markdown All in One (Yu Zhang)**
- ~~Markdown Checkboxes (Matt Bierner) (DISABLED)~~
- ~~Markdown Lint (David Anson) (DISABLED)~~
- Markdown Preview Enhanced (Yiyi Wang) (DISABLED)
- **Material Icon Theme (Philipp Kief)**
- MDX (unified)
- Monorepo Workspace (Folke Lemaitre)
- **Multiple Cursor Case Preserve (Cardinal90)**
- Native Debug (WebFreak)
- npm Intellisense (Christian Kohler)
- Open All Files with Globs (xuld)
- **OpenAPI (Swagger) Editor (42Crunch)**
- Output Colorizer (IBM)
- **Partial Diff (Ryuichi Inagaki)**
- Paste JSON as Code (quicktype)
- **Path Intellisense (Christian Kohler)**
- **Permute Lines (earshinov)**
- pgFormatter (Brady Holt)
- **PostCSS Sorting (mrmlnc)** (Ctrl+Shift+P -> PostCSS Sorting: Run)
- **Prettier (Prettier)**
- **Pretty TypeScript Errors (yoavbls)**
- **Pylance (Microsoft)**
- **Pylint (Microsoft)**
- **Python (Microsoft)**
- Python Indent (Kevin Rose)
- **quick-lint-js (quick-lint)**
- Quokka.js (Wallaby.js)
- ~~Remote - SSH (DISABLED)~~
- **Random Everything (helixquar)** (Random Data Generator)
- **Remove Non ASCII Characters (Samuel Charpentier)**
- **Replace Curly Quotes (jinhyuk)**
- Ruff (Astral Software)
- **shell-format (foxundermoon)**
- **ShellCheck (Timon Wong)**
- Simple React Snippets (Burke Holland) (DISABLED)
- **Sort JSON objects (richie5um2)**
- **Spring Boot Dashboard (Microsoft)**
- **Spring Boot Tools (VMware)**
- **Spring Initializr Java Support (Microsoft)**
- **SQLTools (Matheus Teixeira)**
- SQLite Viewer (Florian Klampfer)
- **SSH FS (Kelvin Schoofs)**
- ~~Tabnine: AI Autocomplete (DISABLED)~~
- **Tailwind CSS IntelliSense (Tailwind Labs)**
- **Text Pastry (jkjustjoshing)**
- **Text Power Tools (Daniel Tar)**
- **REST Client (Huachao Mao)** (ThunderClient is now paywalled)
- Todo Highlight (Wayou Liu)
- Todo Tree (Gruntfuggly)
- **Toggle Quotes (BriteSnow)**
- **Turbo Console Log (Anas Chakroun)**
- VSCode Essentials Pack (jabacchetta)
- wireit (Google)
- Wrap Console Log Simple (WooodHead)
- **WSL (Microsoft)**
- **XML (Red Hat)**
- **YAML (Red Hat)**
- **yapf (EeyoreLee)**

## macOS

```
- Babel JavaScript
- Better C++ Syntax
- Better Comments
- C/C++
- change-case (wmaurer)
- Code Spell Checker
- Color Highlight
- Color Info
- CSS Navigation
- Dev Containers
- Docker
- Dracula
- ESLint
- Even Better TOML
- Fast Compare
- File Utils (Steffen Leistner)
- Format All Files in Workspace (Alex Ross)
- Git Graph
- GitHub Copilot
- GitHub Copilot Chat
- GitLens
- HTML CSS Support (ecmel)
- indent-rainbow (oderwat)
- Intellicode
- JavaScript (ES6) code snippets
- Java Extension Pack
- Markdown All in One (Yu Zhang)
- Material Icon Theme
- Multiple cursor case preserve (Cardinal90)
- Partial Diff
- Permute Lines (earshinov)
- PostCSS Sorting (mrmlnc)
- Prettier
- Pretty TypeScript Errors
- quick-lint-js
- Remove Non ASCII Chars (Samuel Charpentier)
- Sort JSON Objects
- Spring Boot Extension Pack
- SSH FS
- Tailwind
- Text Pastry (jkjustjoshing)
- Turbo Console Log
- XML
- YAML
```

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

## Move Editor Into Next Group

- `Ctrl + Alt + Right Arrow` (Windows)
- `Command + Ctrl + Right Arrow` (macOS)

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

## Show Visible Tabs

`Ctrl + Tab`

## Split View

- `Ctrl + \`

## Swap Lines

- `Alt + Up`
- `Alt + Down`

## Toggle Word Wrap

- `Alt + Z`

# Tips/Tricks

- `Ctrl + P` > `Search Editor: New Search Editor`
- `Ctrl + P` > `Workspaces: Duplicate As Workspace in New Window`
- Show all repositories in Source Control
  - `Ctrl + P` > `Source Control: Focus on Source Control Repositories view`
  - `Click` on the FIRST repository in the list
  - `Shift + Click` on the LAST repository in the list`
  - All repositories should be selected and now visible in the Source Control Repositories view
- Clear History
  - `Ctrl + P` > `File: Clear Recently Opened... `
  - `Ctrl + P` > `Chat: Clear Input History`
  - `Ctrl + P` > `Chat: Clear All Workspace Chats`

# Create Custom Theme

- https://code.visualstudio.com/api/get-started/your-first-extension
- https://code.visualstudio.com/api/extension-guides/color-theme#create-a-new-color-theme
- https://code.visualstudio.com/api/working-with-extensions/publishing-extension
- https://code.visualstudio.com/api/references/extension-manifest#marketplace-presentation-tips

To make extension compatible with VSCodium, bump DOWN the version number of `engine.vscode` inside `package.json` [source](https://github.com/VSCodium/vscodium/issues/1753#issuecomment-2064992100)

```sh
# If you do NOT want to install Yeoman globally:
npx --package yo --package generator-code -- yo code

# If you instead want to install Yeoman globally:
npm install --global yo generator-code
yo code

npm install -g @vscode/vsce
cd <myExtension>
# Note: Need to add "publisher" field to package.json before packaging
vsce package
# Ctrl + Shift + P > Extensions: Install from VSIX...
```
