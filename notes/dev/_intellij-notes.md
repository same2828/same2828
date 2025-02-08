# Table of Contents

- [Table of Contents](#table-of-contents)
- [Format](#format)
- [Maven](#maven)
- [Application Configuration](#application-configuration)
- [Troubleshooting](#troubleshooting)
- [Debugging](#debugging)
- [Shortcuts](#shortcuts)

# Format

| Description      | Shortcut               |
| ---------------- | ---------------------- |
| Format Code      | `Command + Option + L` |
| Optimise Imports | `Control + Option + O` |

# Maven

```sh
mvn clean compile -U

mvn clean install -U

mvn clean install -Dmaven.test.skip=true -U
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

# Troubleshooting

- Project missing Java JDK: `File > Project Structure > Add JDK`

- `Shift + Shift > Actions > Reload from Disk`
- `Shift + Shift > Actions > Reload all Maven Projects`
- `Shift + Shift > Actions > Add Maven Projects`
- `Shift + Shift > Actions > Reload Configuration`
- `Shift + Shift > Actions > Invalid Caches... (Select All)` **(troubleshoot 4)**

- `File > Reload All from Disk (Command + Option + Y)`
- `File > Invalidate Caches... (Select All)`
- `File > Project Structure > Add JDK`

- `Right Click on Repo > Reload from Disk`

- `rm -rf .idea` **(troubleshoot 3)**
- `rm -rf .vscode` **(troubleshoot 2)**

- `VSCode > Ctrl + P > Java: Clean Java Language Server Workspace` in VSCode **(troubleshoot 1)**

# Debugging

- Place break point on line in code (red dot in sidebar)
  - Note: Sometimes may need to place multiple breakpoints (just add a few on the lines below of target)
- Choose to "Debug" instead of "Run" for the test case/file
- If breakpoint is hit BEFORE the Postman collection is ran, then press "Resume Program"
- Run Postman collection
- Wait for breakpoint to be hit and program to be paused
- Examine variables and their values
- "Step Over" is used more commonly then "Step Into"
  - Note: Variable values will sometimes only be shown once the line has passed, hence the reason we place multiple breakpoints on subsequent lines

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
