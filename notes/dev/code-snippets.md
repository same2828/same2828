# Table of Contents

- [Table of Contents](#table-of-contents)
- [Browser](#browser)
  - [Change PDF Colors](#change-pdf-colors)
  - [Change GitHub Theme](#change-github-theme)
  - [Change Video Playback Speed](#change-video-playback-speed)
- [GitHub - Load All Diffs](#github---load-all-diffs)
  - [Webcms3 Forums - Expand All Comments](#webcms3-forums---expand-all-comments)
- [Linux](#linux)
  - [clone.sh](#clonesh)
  - [C++ Compile](#c-compile)
  - [Delete Every 2nd And 3rd Lines Of File](#delete-every-2nd-and-3rd-lines-of-file)
  - [Find Invalid Folder Names](#find-invalid-folder-names)
  - [Find All Java LeetCode Files](#find-all-java-leetcode-files)
  - [List All Completed LeetCode Questions](#list-all-completed-leetcode-questions)
  - [Move Files From Child Directory To Parent Directory And Delete Child Directory](#move-files-from-child-directory-to-parent-directory-and-delete-child-directory)
  - [Update \&\& Upgrade](#update--upgrade)
- [macOS](#macos)
  - [macOS Allow Unidentified Developers](#macos-allow-unidentified-developers)
- [WSL/Windows](#wslwindows)
  - [Update WSL](#update-wsl)
  - [Restart WSL](#restart-wsl)
  - [Update Git Windows](#update-git-windows)

# Browser

## Change PDF Colors

```js
viewer.style = 'filter: grayscale(100%) invert(100%) contrast(100%) brightness(100%)';
document.querySelector('embed').style.filter = 'invert()';
```

## Change GitHub Theme

```js
document.documentElement.setAttribute('data-color-mode', 'option-light');
```

## Change Video Playback Speed

```js
document.querySelector('video').playbackRate = 2.5;
```

# GitHub - Load All Diffs

```js
let buttons = document.getElementsByClassName('load-diff-button');

for (let i = 0; i < buttons.length; i++) {
  buttons[i].click();
}
```

# Photopea - Remove Empty Side Panel

```js
Object.defineProperty(window, 'innerWidth', {
  get() {
    return document.documentElement.offsetWidth + 320;
  },
});
```

# Webcms3 Forums - Expand All Comments

```js
function expandAllComments() {
  let refs = document.querySelectorAll('.fa-plus-square');
  refs.forEach((ref) => ref.click());
}
expandAllComments();
```

# Linux

## clone.sh

- Shell script that takes in a https repo as an argument and recursively clones each branch (except for master/main) into its own folder (named after the branch name)
- Usage:
  - `chmod +x test.sh`
  - `test.sh <https-repo-url>`

```sh
#!/bin/bash

# Check if at least one argument is provided
if [ $# -lt 1 ]; then
  echo "Usage: $0 <https-repo-url>"
  exit 1
fi

REPO_URL=$1
EXPORT_DIR=$(echo $REPO_URL | sed 's#.*/\([^/]*\)\.git#\1#')

# Remove + create export directory
rm -rf $EXPORT_DIR
mkdir -p "$EXPORT_DIR"

# Fetch all branches from the repository
BRANCHES=$(git ls-remote --heads $REPO_URL | grep -vE 'master$|main$' | sed 's?.*refs/heads/??')

# Loop through each branch and clone it into its own directory within the export folder
for BRANCH in $BRANCHES; do
  # Define the directory name based on the branch name
  DIR_NAME="$EXPORT_DIR/$BRANCH"
  # Clone the specific branch
  git clone --branch $BRANCH $REPO_URL $DIR_NAME
done

echo "All branches (except master/main) have been cloned into $EXPORT_DIR"
```

## C++ Compile

```sh
g++ source.cpp
./a.out

g++ source.cpp -o outputName
./outputName

g++ source.cpp -o test
./test < input.txt

alias g++='g++ -o test'
```

## Delete Every 2nd And 3rd Lines Of File

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

## Find All Java LeetCode Files

```sh
cd github/lc-topics
ls -R | grep -P '^[0-9]+.*\.java' | sort -n | uniq
```

## List All Completed LeetCode Questions

```sh
cd github/lc-topics
ls -R | grep -P '^\..*:$'
```

- `cat array.txt | sed 's/\.\/.*\///g' | sed 's/^\..*//g' | sort -n > array.txt`
- `cat rest.txt | sed 's/\.\/.*\///g' | sed 's/^\..*//g' | sort -n | uniq > rest.txt`

## Move Files From Child Directory To Parent Directory And Delete Child Directory

```sh
cd parent
mv child/* .
rm -rf child
```

## Update && Upgrade

```sh
sudo apt update
sudo apt update --fix-missing

sudo apt upgrade
sudo apt upgrade --fix-missing

sudo apt update && sudo apt upgrade
sudo apt update --fix-missing && sudo apt upgrade --fix-missing
```

# macOS

## macOS Allow Unidentified Developers

```sh
sudo spctl --master-disable
sudo spctl --master-enable
```

# WSL/Windows

## Update WSL

- Run Windows PowerShell as Admin

```sh
wsl --update
```

## Restart WSL

- Run Windows PowerShell as Admin

```sh
Get-Service LxssManager | Restart-Service
```

- or

```sh
wsl --shutdown
```

## Update Git Windows

- Run Windows PowerShell as Admin

```sh
git update-git-for-windows
```
