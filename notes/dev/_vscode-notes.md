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
  - [Remove Unused Imports](#remove-unused-imports)
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

- Apc Customize UI++ (drcika)
- Astro (Astro)
- Auto Rename Tag (Jun Han)
- **autopep8 (Microsoft)**
- **Babel JavaScript (Michael McDermott)**
- **base64-image-preview (NateScarlet)**
- **Better C++ Syntax (Jeff Hykin)**
- **Better Comments (Aaron Bond)**
- Better Dockerfile Syntax (Jeff Hykin) (note: NOT updated since 2020)
- Better Go Syntax (Jeff Hykin) (note: NOT updated since 2020)
- Better Perl Syntax (Jeff Hykin)
- **Better Shell Syntax (Jeff Hykin)**
- **Black Formatter (Microsoft)**
- Binocular (jpcrs) (note: requires other dependencies)
- **Bookmarks (Alessandro Fragnani)**
- **C/C++ (Microsoft)**
- **change-case (wmaurer)**
- ~~Clang-Format (Xaver Hellauer) (DISABLED)~~
- ~~clangd (LLVM) (DISABLED) (If want to use need to disable C/C++ extension from Microsoft in `settings.json`)~~
- Cloak (John Papa)
- ~~CMake (DISABLED)~~
- ~~CMakeTools (DISABLED)~~
- **Code Spell Checker (Street Side Software)**
- Codeium: AI (Codeium) (DISABLED) (note: Alternative to GitHub Copilot)
- CodeSnap (adpyke) (note: Code Screenshot)
- ~~CodeLLDB (DISABLED)~~
- **Color Highlight (Sergii N)**
- **Color Info (Matt Bierner)**
- **colorize (kamikillerto)**
- **Comment Anchors (Starlane Studios)**
- **Console Ninja (Wallaby.js)**
- **Conventional Commits (vivaxy)**
- **copy-json-path (nidu)**
- **Copy Word in Cursor (Alessandro Fragnani)**
- ~~CSS Peek (Pranay Prakash) (DISABLED)~~
- **CSS Navigation (pucelle)**
- **Debugger for Firefox (Firefox DevTools)**
- **Dev Containers (Microsoft)**
- **Docker (Microsoft)**
- **DotENV (mikestead)**
- **Dracula (s3same)**
- **Draw.io Integration (Henning Dieterichs)**
- Duplicate Action (mrmlnc) (note: File Utils does same thing)
- **Error Lens (Alexander)**
- ES7+ React/Redux/GraphQL/React-Native snippets (dsznajder) (note: NOT updated since 2022)
- **ESLint (Microsoft)**
- **Even Better TOML (tamasfe)**
- **Excel Viewer (MESCIUS)**
- **Extension Pack for Java**
- **Fast Compare (David Kolar)**
- **Fetch Client (Ganesan Chandran)**
- **File Utils (Steffen Leistner)**
- **Firebase (toba)**
- Flake8 (Microsoft)
- **Format All Files in Workspace (Alex Ross)**
- **Format In Context Menus (lacroixdavid1)**
- **Formatting Toggle (tombonnike)**
- Frontend Essentials Extension Pack (FPack) (SeyyedKhandon)
- **Git Graph (mhutchie)**
- **Git History (Don Jayamanne)**
- GitHub Copilot (GitHub)
- GitHub Copilot Chat (GitHub)
- **GitLess (maattdd)**
- **Gremlins Tracker (Nicolas Hoizey)**
- **Go (Go Team at Google)**
- **HTML CSS Support (ecmel)**
- **HTML End Tag Labels (Ante Primorac)**
- HTTP Client (Marcel J. Kloubert)
- **Hungry Delete (jasonlhy)**
- **Image Preview (Kiss Tamas)**
- Image To Base64 (FEZIRO)
- **indent-rainbow (oderwat)**
- **IntelliCode (Microsoft)**
- ~~IntelliCode API Usage Examples (Microsoft) (DISABLED)~~
- **IntelliCode Completions (Microsoft)**
- **isort (Microsoft)**
- **JavaScript (ES6) Code Snippets (charalampos karypidis)**
- json2ts (Gregor Biswanger)
- **JSON Crack (Aykut Sarac)**
- **JSON Escaper (Joshua Poehls)**
- **JSON Formatter (Clemens Peters)**
- **JSON Path Status Bar (richie5um2)**
- **JSON to TS (MariusAlchimavicius)** (Newer version of json2ts)
- **Jumpy2 (David L. Goldberg)**
- **Just Blame (Artem Sapegin)**
- **Kubernetes (Microsoft)**
- LaTeX Workshop (James Yu) (DISABLED)
- Live Server (Ritwick Dey) (DISABLED)
- **Markdown All in One (Yu Zhang)**
- ~~Markdown Checkboxes (Matt Bierner) (DISABLED)~~
- ~~Markdown Lint (David Anson) (DISABLED)~~
- Markdown Preview Enhanced (Yiyi Wang) (DISABLED)
- **Material Icon Theme (Philipp Kief)**
- **MetaGo (metaseed)** (alternative to Jumpy2)
- Microsoft Edge Tools for VS Code (Microsoft)
- Monorepo Workspace (Folke Lemaitre)
- **Multiple Cursor Case Preserve (Cardinal90)**
- Native Debug (WebFreak)
- Notes (Dion Munk)
- npm Intellisense (Christian Kohler)
- Open All Files with Globs (xuld)
- **OpenAPI (Swagger) Editor (42Crunch)**
- **Open Folder Context Menus (Chris Dias)**
- **Output Colorizer (IBM)**
- **Partial Diff (Ryuichi Inagaki)**
- **Paste Image Anywhere (dzylikecode)**
- **Paste JSON as Code (quicktype)**
- **Path Intellisense (Christian Kohler)**
- **Periscorpe (Josh Mu)**
- Permute Lines (earshinov)
- pgFormatter (Brady Holt)
- **PostCSS Sorting (mrmlnc)** (usage: `Ctrl+Shift+P` -> `PostCSS Sorting: Run`)
- **Prettier (Prettier)**
- **Pretty TypeScript Errors (yoavbls)**
- **Print Divider (XuangeAha)**
- **Project Manager (Alessandro Fragnani)**
- **Pylance (Microsoft)**
- **Pylint (Microsoft)**
- **Python (Microsoft)**
- Python Indent (Kevin Rose)
- px to rem & rpx & vw (cssrem) (cipchk)
- **quick-lint-js (quick-lint)**
- **Quick Opener (mogelbrod)**
- **Quokka.js (Wallaby.js)**
- **Rainbow CSV (mechatroner)**
- Random Everything (helixquar) (Random Data Generator) (note: OLD, use `vscode-faker` instead)
- **Remove Non ASCII Characters (Samuel Charpentier)**
- **Replace Curly Quotes (jinhyuk)**
- **REST Client (Huachao Mao)** (ntoe: `ThunderClient` is now paywalled)
- **Rewrap (stkb)**
- Ruff (Astral Software)
- **shell-format (foxundermoon)**
- **ShellCheck (Timon Wong)**
- Simple React Snippets (Burke Holland) (DISABLED)
- **Sort JSON objects (richie5um2)**
- **Sort Lines (Daniel Imms)**
- **Sorting HTML and Jade attributes (mrmlnc)**
- **Spring Boot Dashboard (Microsoft)**
- **Spring Boot Tools (VMware)**
- **Spring Initializr Java Support (Microsoft)**
- **SQLTools (Matheus Teixeira)**
- **SQLite Viewer (Florian Klampfer)**
- **SSH FS (Kelvin Schoofs)**
- **Tailwind CSS IntelliSense (Tailwind Labs)**
- **Text Pastry (jkjustjoshing)**
- **Text Power Tools (Daniel Tar)**
- Todo Highlight (Wayou Liu)
- **Todo Tree (Gruntfuggly)**
- **Toggle Quotes (BriteSnow)**
- Turbo Console Log (Anas Chakroun)
- **vscode-faker (Budi Irawan)** (note: newer version of `Random Everything`)
- VSCode Essentials (jabacchetta)
- VSCode Essentials (Andres Gutierrez)
- wireit (Google)
- **Wrap Log Simple (mrpineapples)**
- Wrap Console Log Simple (WooodHead)
- **WSL (Microsoft)**
- **XML (Red Hat)**
- **YAML (Red Hat)**
- **YAML Sort (Pascal Reitermann)**
- **YAML to JSON (ahebrank)**
- **yapf (EeyoreLee)**

## macOS

- autopep8 (Microsoft)
- Babel JavaScript (Michael McDermott)
- Better C++ Syntax (Jeff Hykin)
- Better Shell Syntax (Jeff Hykin)
- Better Comments (Aaron Bond)
- Bookmarks (Alessandro Fragnani)
- C/C++ (Microsoft)
- Code Spell Checker (Street Side Software)
- Color Highlight (Sergii N)
- Color Info (Matt Bierner)
- copy-json-path (nidu)
- Copy Word in Cursor (Alessandro Fragnani)
- CSS Navigation (pucelle)
- Debugger for Firefox (Firefox DevTools)
- Dev Containers (Microsoft)
- Docker (Microsoft)
- DotENV (mikestead)
- Dracula (s3same)
- Draw.io Integration (Henning Dieterichs)
- Error Lens (Alexander)
- ESLint (Microsoft)
- Even Better TOML (tamasfe)
- Excel Viewer (MESCIUS)
- Fast Compare (David Kolar)
- Fetch Client (Ganesan Chandran)
- File Utils (Steffen Leistner)
- Format All Files in Workspace (Alex Ross)
- Formatting Toggle (tombonnike)
- Git Graph (mhutchie)
- GitHub Copilot (GitHub)
- GitHub Copilot Chat (GitHub)
- GitLess (maattdd)
- HTML CSS Support (ecmel)
- Hungry Delete (jasonlhy)
- indent-rainbow (oderwat)
- Intellicode (Microsoft)
- Java Extension Pack (Red Hat)
- JavaScript (ES6) Code Snippets (charalampos karypidis)
- JSON Crack (Aykut Sarac)
- JSON Formatter (Clemens Peters)
- JSON Path Status Bar (richie5um2)
- JSON to TS (MariusAlchimavicius) (Newer version of json2ts)
- Jumpy2 (David L. Goldberg)
- Just Blame (Artem Sapegin)
- Markdown All in One (Yu Zhang)
- Material Icon Theme (Philipp Kief)
- Microsoft Edge Tools for VS Code (Microsoft)
- Multiple Cursor Case Preserve (Cardinal90)
- Open Folder Context Menus (Chris Dias)
- OpenAPI (Swagger) Editor (42Crunch)
- Partial Diff (Ryuichi Inagaki)
- Path Intellisense (Christian Kohler)
- PostCSS Sorting (mrmlnc)
- Prettier (Prettier)
- Pretty TypeScript Errors (yoavbls)
- Project Manager (Alessandro Fragnani)
- Pylance (Microsoft)
- Pylint (Microsoft)
- Python (Microsoft)
- quick-lint-js (quick-lint)
- Rainbow CSV (mechatroner)
- Remove Non ASCII Characters (Samuel Charpentier)
- Replace Curly Quotes (jinhyuk)
- REST Client (Huachao Mao)
- shell-format (foxundermoon)
- ShellCheck (Timon Wong)
- Sort JSON Objects (richie5um2)
- Sort Lines (Daniel Imms)
- Sorting HTML and Jade attributes (mrmlnc)
- Spring Boot Extension Pack (VMware)
- SSH FS (Kelvin Schoofs)
- Tailwind CSS IntelliSense (Tailwind Labs)
- Text Pastry (jkjustjoshing)
- Text Power Tools (Daniel Tar)
- Todo Tree (Gruntfuggly)
- vscode-faker (Budi Irawan) (note: newer version of `Random Everything`)
- Wrap Log Simple (mrpineapples)
- XML (Red Hat)
- YAML (Red Hat)

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

## Remove Unused Imports

- `Alt + Shift + O`
- `Option + Shift + O`

# Tips/Tricks

- `Ctrl + P` > `Search Editor: New Search Editor`
- `Ctrl + P` > `Workspaces: Duplicate As Workspace in New Window`
- Show All Repositories in Source Control
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
