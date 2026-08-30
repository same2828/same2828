# Table of Contents

- [Table of Contents](#table-of-contents)
- [Config](#config)
  - [Appearance \& Behaviour](#appearance--behaviour)
  - [Editor](#editor)
  - [Keymap](#keymap)
    - [Remove](#remove)
  - [Sidebars/Toolbars](#sidebarstoolbars)
  - [Extensions/Plugins](#extensionsplugins)
  - [Advanced Settings](#advanced-settings)
- [Shortcuts](#shortcuts)
- [Troubleshooting](#troubleshooting)
  - [Miscellaneous](#miscellaneous)
- [Maven](#maven)
- [Application Configuration](#application-configuration)
- [Debugging](#debugging)
- [Extensions/Plugins](#extensionsplugins-1)
  - [Karate Test Automation](#karate-test-automation)
- [Shortcuts](#shortcuts-1)

# Config

## Appearance & Behaviour

`Appearance & Behaviour > Appearance > Accessibility` > Turn ON `Use contrast scrollbars`
`Appearance & Behaviour > Appearance > UI Options` > Turn ON `Always show full path in window header`

`Appearance & Behaviour > Menus and Toolbars > Main Toolbar > Left > Add... > Main Menu > Navigate` > Back && Forward

## Editor

`Editor > General.OnSave` > Turn OFF `Keep trailing spaces on caret line`
`Editor > General.OnSave` > Turn ON `Remove trailing spaces on: All lines`

`Editor > General > Appearance` > Turn ON `Show whitespaces`
`Editor > General > Appearance` > Turn OFF `Show code lens on scrollbar hover`

`Editor > General > Breadcrumbs ` > `Placement: Top` && Select ALL languages

`Editor > General > Code Folding` > `Show code folding arrows: Always`
`Editor > General > Code Folding` > Fold by Default > Turn OFF everything

`Editor > General > Editor Tabs > Appearance` > Turn ON `Mark modified`
`Editor > General > Editor Tabs > Tab Order` > Turn ON `Sort tabs alphabetically` and `Open new tabs at the end`

`Editor > General > Sticky Lines` > Turn ON only for `JSON`, `YAML`
`Editor > General > Sticky Lines` > `Maximum number of lines: 10`

`Editor > Font > JetBrains Mono`
`Editor > Font > Size > 16`
`Editor > Font > Line height > 1.2`

`Editor > Color Scheme > General > Code > Identifier under caret row (write)` > #573D62
`Editor > Color Scheme > General > Code > Line number` > #B3B3B3 (default: #A3A5BA)
`Editor > Color Scheme > General > Code > Line number on caret row` > ##FF79C6
`Editor > Color Scheme > General > Code > TODO defaults` > #FF8C00 (default: #E998FF)

`Editor > Color Scheme > General > Editor > Breadcrumbs` > #FFFFFF
`Editor > Color Scheme > General > Editor > Caret` > #EEEEEE (default: #CCCCCC)

`Editor > Color Scheme > General > Editor > Guides > Hard wrap guide` > #5A5A5A (default: #A8B0E2)
`Editor > Color Scheme > General > Editor > Guides > Indent guide` > #43434F (default: #3E404B)
`Editor > Color Scheme > General > Editor > Guides > Indent guide selected` > #5A5A5A (default: #A8B0E2)
`Editor > Color Scheme > General > Editor > Guides > Visual guides` > #5A5A5A (default: #6B7090)

`Editor > Color Scheme > General > Editor > Vertical Scrollbar > Thumb` > #6B6B6B (default: #3A3D4C)
`Editor > Color Scheme > General > Editor > Vertical Scrollbar > Thumb while scrolling` > #969696 (default: #3A3D4C)

`Editor > Color Scheme > General > Errors and Warnings > Unused Code` > #BBBBBB (default: #72737A)

`Editor > Color Scheme > General > Text > Folded Text` > #B7C4FF (default: #787E9F)

`Editor > Color Scheme > Language Defaults > Comments > Block Comment` > #B7C4FF
`Editor > Color Scheme > Language Defaults > Comments > Doc Comment > Text` > #B7C4FF
`Editor > Color Scheme > Language Defaults > Comments > Line Comment` > #B7C4FF
`Editor > Color Scheme > Language Defaults > Identifiers > Label` > #B7C4FF

`Editor > Code Style > General` > Ajit turned OFF `Enable EditorConfig support`

`Editor > Code Style > Java > Tabs and Indents > Tab size`: 2
`Editor > Code Style > Java > Tabs and Indents > Indent`: 2
`Editor > Code Style > Java > Tabs and Indents > Continuation Indent`: 2

`Editor > Code Style > Java > Wrapping and Braces > Keep when reformatting` > Turn OFF everything

`Editor > Code Style > Java > Blank Lines > Keep maximum blank lines` > Change all to 1

`Editor > Code Style > Java > Imports > Delete unused module imports`
`Editor > Code Style > Java > Imports > Class count to use import with '*'`: 999
`Editor > Code Style > Java > Imports > Names count to use import with '*'`: 999

`Editor > Code Style > Java > Code Generation > Comment Code` > Turn OFF `Line comment at first column`
`Editor > Code Style > Java > Code Generation > Comment Code` > Turn ON `Add a space at line comment start`
`Editor > Code Style > Java > Code Generation > Comment Code` > Turn ON `Enforce on reformat`
`Editor > Code Style > Java > Code Generation > Comment Code` > Turn OFF `Block comment at first column`
`Editor > Code Style > Java > Code Generation > Comment Code` > Turn ON `Add spaces around block comments`

- [Disable Italics](https://stackoverflow.com/a/76388214)
- [Fix comment shortcut behaviour](https://stackoverflow.com/a/69490719)
- [Comment out several lines of code](https://stackoverflow.com/questions/61827270/keyboard-shortcut-to-comment-several-lines-of-code-in-intellij)

## Keymap

Download `VSCode Keymap` plugin

`Settings > Keymap > VSCode (macOS)`

| Shortcut                                                             | Keymap                       | Default (IntelliJ) |
| -------------------------------------------------------------------- | ---------------------------- | ------------------ |
| `Code > Code Formatting Actions > Optimize Imports`                  | `Option+O`, `Option+Shift+O` | `Ctrl+Option+O`    |
| `Code > Code Formatting Actions > Reformat Code`                     | `Option+S`                   | `Cmd+Option+L`     |
| `Edit > Find > Find in Files`                                        | `Option+Shift+F`             |                    |
| `Edit > Find Usages > Find Usages`                                   | `Cmd+Shift+F`                |                    |
| `Edit > Redo`                                                        | `Cmd+Y`                      |                    |
| `Navigate > Back`                                                    | `Ctrl+[`, `Ctrl+-`           |                    |
| `Navigate > Forward`                                                 | `Ctrl+`, `Ctrl+=`            |                    |
| `Navigate > Goto by Reference Actions > Go To Declaration or Usages` | `Ctrl+B`,`Option+B`          | `Cmd+B`            |
| `Navigate > Goto by Reference Actions > Go To Implementation`        | `Ctrl+I`,`Option+I`          | `Cmd+Option+B`     |
| `Navigate > Goto by Reference Actions > Go To SuperMethod`           | `Ctrl+U`,`Option+U`          | `Cmd+U`            |
| `Other > Show Context Actions`                                       | `Option+Enter`               |                    |
| `Other > Show Quick-Fixes`                                           | `Option+Enter`               |                    |

### Remove

Window > Editor Tabs > Split with Chooser Navigation > Use Left Split or Switch Left inherited from Left > Remove `Ctrl + B`

## Sidebars/Toolbars

Right sidebar = View > Tool Windows

## Extensions/Plugins

- `MavenHelper (Vojtech Krasa)`
- `VSCode Keymap (JetBrains)`
- Disable
  - `AI-Powered` >`MCP Server`
  - `IDE Localisation` > `All`
  - `IDE Settings` > `Backup and Sync`
  - `Local AI/ML Tools` > `All` (except for `Full Line Code Completion`)
  - `Remote Development` > `Code With Me`, `Station`

## Advanced Settings

`Advanced Settings > Editor` > Turn OFF `Move caret down after Comment with Line Comment action`

`Advanced Settings > User Interface` > Turn OFF `Merge main menu with window title`

# Shortcuts

- [IntelliJ Shortcuts Pdf](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)

| Description                       | Shortcut                           | Other                                                                                           |
| --------------------------------- | ---------------------------------- | ----------------------------------------------------------------------------------------------- |
| Format Code                       | `Command + Option + L`             |                                                                                                 |
| Optimise Imports                  | `Control + Option + O`             |                                                                                                 |
| Go to implementation(s)           | `Command + Option + B`             |                                                                                                 |
| Go to Declaration                 | `Command + B` or `Command + Click` |                                                                                                 |
| Navigate Back                     | `Command + Option + Left Arrow`    |                                                                                                 |
| Navigate Forward                  | `Command + Option + Right Arrow`   |                                                                                                 |
| Go to super-method / super-class  | `Command + U`                      |                                                                                                 |
| Go to previous method             | `Control + Up Arrow`               |                                                                                                 |
| Go to next method                 | `Control + Down Arrow`             |                                                                                                 |
| Move to code block start          | `Command + Option + ]`             |                                                                                                 |
| Move to code block end            | `Command + Option + [`             |                                                                                                 |
| Find usages / Find usages in file | `Option + F7` or `Command + F7`    | Maven: `Download Sources and Documentation` && Change Usages `Scope` to `Project and Libraries` |
| Highlight usages in file          | `Command + Shift +  F7`            |                                                                                                 |
| Show usages                       | `Command + Option + F7`            |                                                                                                 |

# Troubleshooting

**Cannot have the SAME project open in BOTH VSCode and IntelliJ**

1. `VSCode > Ctrl + P > Java: Clean Java Language Server Workspace`
2. Close VSCode window of project
3. `Shift + Shift > Actions > Invalid Caches... > Select All > Invalid and Restart`
4. `Shift + Shift > Actions > Sync All Maven Projects`
5. `Shift + Shift > Actions > Reload All Maven Projects`
6. In IntelliJ Maven:
   - Toggle the `Skip Tests` mode
   - Run `clean install` Maven Goal

## Miscellaneous

- Project missing Java JDK: `File > Project Structure > Add JDK`

- `Shift + Shift > Actions > Reload from Disk`
- `Shift + Shift > Actions > Reload all Maven Projects`
- `Shift + Shift > Actions > Add Maven Projects`
- `Shift + Shift > Actions > Reload Configuration`
- `Shift + Shift > Actions > Invalid Caches... > Select All > Invalid and Restart` **(troubleshoot 4)**

- `File > Reload All from Disk (Command + Option + Y)`
- `File > Invalidate Caches... (Select All)`
- `File > Project Structure > Add JDK`

- `Right Click on Repo > Reload from Disk`

- `rm -rf .idea` **(troubleshoot 3)**
- `rm -rf .vscode` **(troubleshoot 2)**

- `VSCode > Ctrl + P > Java: Clean Java Language Server Workspace` in VSCode **(troubleshoot 1)**

# Maven

```sh
# Compile
mvn clean compile
# Compile + Run Tests
mvn clean install
# Troubleshooting: Forces a check for missing releases and updated snapshots on remote repositories
mvn clean compile -U
mvn clean install -U
# Skip compilation && execution of tests
mvn clean install -U -Dmaven.test.skip=true
# Skip execution of tests
mvn clean install -U -DskipTests
mvn spring-boot:run
mvn spring-boot:run -Dspring-boot.run.arguments=--debug
mvn spring-boot:run -Dspring-boot.run.profiles=local
mvn spring-boot:run -Dspring-boot.run.arguments=--debug -Dspring-boot.run.profiles=local
mvn dependency:tree | grep pkgOfInterest
mvn dependency:tree > maven-dependencies.txt
```

- `Shift + Shift > Reload All Maven Projects`
- After changing `pom.xml` > Open Maven tab on RHS > Click the "circle" icon (to reload)

# Application Configuration

```sh
# Compile
mvn clean compile
# Compile + Run Tests
mvn clean install
# Troubleshooting: Forces a check for missing releases and updated snapshots on remote repositories
mvn clean compile -U
mvn clean install -U
mvn clean install -U -Dmaven.test.skip=true
mvn spring-boot:run
mvn spring-boot:run -Dspring-boot.run.arguments=--debug
mvn spring-boot:run -Dspring-boot.run.profiles=local
mvn spring-boot:run -Dspring-boot.run.arguments=--debug -Dspring-boot.run.profiles=local
mvn dependency:tree | grep pkgOfInterest
mvn dependency:tree > maven-dependencies.txt
```

```sh
# Main Application
com.example.demo.framework.main.MainApplication

# Program Arguments
-Dbypass.header=true -Dspring.profiles.active=local # Assuming application-local.yml
-Dbypass.header=true --spring.config.location=/Users/same/dev/${USE_REPO_NAME_HERE}/src/main/resources/application-local.yml

# Environment Variables
ENV1=VALUE1;ENV2=VALUE2;ENV3=VALUE3
```

# Debugging

- Place break point on line in code (red dot in sidebar)
  - Note: Sometimes may need to place multiple breakpoints (just add a few on the lines below of target)
- Choose to `Debug` instead of `Run` for the test case/file
- If breakpoint is hit BEFORE the Postman collection is ran, then press "Resume Program"
- Run Postman collection
- Wait for breakpoint to be hit and program to be paused
- Examine variables and their values
- "Step Over" is used more commonly then "Step Into"
  - Note: Variable values will sometimes only be shown once the line has passed, hence the reason we place multiple breakpoints on subsequent lines

# Extensions/Plugins

## Karate Test Automation

Use `Cucumber for Java` and `Gherkin` > `Karate`

# Shortcuts

- `Command + -` = Collapse Code Fragment
- `Command + =` = Expand Code Fragment
- `Command + 3` = Open The "Find" View
- `Command + 7` = Show File Structure As Tool Window
- `Command + B (2x)` = See All Usages Of Method
- `Command + B` = Jump To Declaration Of Method
- `Command + Control + G` = Select All Occurrences In File
- `Command + D` = Duplicate Line
- `Command + E` = View Recently Opened Files
- `Command + F1` = Expand Warning Description
- `Command + F12` = Open File Structure
- `Command + F2` = Finish/Stop Debugging
- `Command + F8` = Set Breakpoint
- `Command + F9` = Build Project (Apply Hot Swap)
- `Command + G` = Jump To Next Occurrence
- `Command + O` = Search For Class
- `Command + Option + /` = Create Block Comment `/* ... */`
- `Command + Option + B` = Find Implementations
- `Command + Option + C` = Refactor With Constant
- `Command + Option + F8` = Invoke Quick Evaluate Expression For Selected Argument
- `Command + Option + L` = Reformat Selected Code Fragment
- `Command + Option + N` = Refactor With Inline Variable
- `Command + Option + O` = Search For Method/Global Variable
- `Command + Option + R` = Resume Program Execution (Debugging)
- `Command + Option + Shift + L` = Show Reformat Settings
- `Command + Option + T` = Surround Selected Code Fragment With Template Code
- `Command + Option + V` = Extract Local Variable
- `Command + Otpion + M` = Extract Selected Code Block Into A Method
- `Command + P` = Show Method's Signatures/Parameters
- `Command + Shift + -` = Collapse All Regions In File
- `Command + Shift + =` = Expand All Regions In File
- `Command + Shift + A` = Find Action
- `Command + Shift + Delete` = Unwrap Action (Return To Previous State)
- `Command + Shift + E` = View Code In Recently Visited Files
- `Command + Shift + Enter` = Complete Statement
- `Command + Shift + F` = Open "Find In Files..." Window
- `Command + Shift + F7` = Highlight All Usages Of Symbol At Cursor (Within The File)
- `Command + Shift + G` = Jump To Previous Occurrence
- `Command + Shift + H` = View Whole Hierarchy For Method
- `Command + Shift + O` = Search For File
- `Command + Shift + R` = Open "Replace In Files..." Window
- `Command + U` = Navigate To A Super Method From Derived
- `Control + D` = Start Debugging
- `Control + G (2x)` = Select Next Occurrence Of Symbol (Create Cursor Another Cursor At Next Occurrence Of Symbol)
- `Control + G` = Select Symbol At Cursor (Create Cursor)
- `Control + H` = View Class Hierarchy
- `Control + Shift + G` = Deselect Last Occurrence (Delete Last Created Cursor)
- `Control + Shift + R` = Run Item
- `Control + Shift + Space` = Smart Type Completion
- `Control + Space (2x)` = Show Suggestions For Static Constants/Methods
- `Control + Space` = Show Suggestions
- `Control + T` = List All Refactorings Available
- `F1` = See Documentation For Symbol At Cursor
- `F2` = Go To Next Highlighted Error In File
- `F7` = Step Into Selected Call (Debugging)
- `Hold Shift` While Clicking On "Run" = Edit Run Configurations Or Add New Ones
- `Option + D` = Narrow Replacement To Current Directory
- `Option + Enter` = Preview Warnings + Suggested Fixes
- `Option + F7` = More Detailed View Of Usages (Can Invoke On Declaration + Usage)
- `Option + F9` = Execute Program Up To Line Where Cursor Is
- `Option + Shift + Down Arrow` = Pull Down Current Line
- `Option + Shift + Enter` = Replace Argument With Empty Array
- `Option + Shift + Up Arrow` = Pull Up Current Line
- `Option + Space` = See Definition Of Symbol At Cursor
- `Option + Up Arrow (2x)` = Select Whole String At Cursor
- `Option + Up Arrow (3x)` = Include Quotes In The Selection
- `Option + Up Arrow (Nx)` = Expand The Selection At Each Press
- `Option + Up Arrow` = Select Word At Cursor (Expand Selection)
- `Option + Up Arrow` = Shrink Selection
- `Option + W` = Narrow Search To A Whole Word
- `Shift + Esc` = Hide The View
- `Shift + F6` = Show Rename Options
- `Shift + Shift || (Shift 2x)` = Search Everywhere
