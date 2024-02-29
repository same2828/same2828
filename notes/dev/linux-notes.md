# Table of Contents

- [Table of Contents](#table-of-contents)
- [Commands](#commands)
  - [apt](#apt)
- [Delete every 2nd and 3rd lines of file](#delete-every-2nd-and-3rd-lines-of-file)
- [Find invalid folder names](#find-invalid-folder-names)
- [Find all java leetcode files](#find-all-java-leetcode-files)
- [Move files from child directory to parent directory and delete child directory](#move-files-from-child-directory-to-parent-directory-and-delete-child-directory)
- [Pathname Globbing](#pathname-globbing)
- [Shell Script to Recursively Clone All Branches from GitHub Repository](#shell-script-to-recursively-clone-all-branches-from-github-repository)
- [Random](#random)

# Commands

## apt

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

# Delete every 2nd and 3rd lines of file

- Used to grab all leetcode questions done (copy paste from leetcode website)
- `awk '(NR-1)%3<1' fileName`
  - The command `(NR-1)%3<1` tells awk to print any line for which `(NR-1)%3<1` is `true`
  - In awk, `NR` is the line number with the first line counting as `1`
  - For every three lines in the file, that statement will be true for the first line
- [Read more](https://unix.stackexchange.com/questions/509553/how-to-delete-every-two-lines-after-3rd-lines-in-a-file-contains-very-large-numb)

# Find invalid folder names

```sh
cd ~/github/lc-all
ls | grep -E '^[0-9]+\-'

cd ~/github/lc-topics
ls -R | grep -E '^[0-9]+\-'
```

# Find all java leetcode files

```sh
cd github/lc-topics
ls -R | grep -P '^[0-9]+.*\.java' | sort -n | uniq
```

# Move files from child directory to parent directory and delete child directory

```sh
cd parent
mv child/* .
rm -rf child
```

# Pathname Globbing

`*`: Matches any number of characters (including none). For example, `*.txt` would match any file ending with .txt
`?`: Matches exactly one character. For example, `?.txt` would match a.txt but not ab.txt
`[]`: Matches any one character that is within the brackets. For example, `[ab].txt` would match a.txt and b.txt but not c.txt
`**` (globstar) : Matches all files and zero or more directories and subdirectories. If followed by a `/`, it matches only directories and subdirectories

# Shell Script to Recursively Clone All Branches from GitHub Repository

- Make sure to to `git clone` original repository FIRST

```sh
#!/usr/bin/env bash
previous_pwd="$HOME/files"

PROJECT="$HOME/files/netninja-react-original"
EXPORT_DIR="$HOME/files/download"

rm -rf $EXPORT_DIR
mkdir -p $EXPORT_DIR

cd $PROJECT

for branch in `git branch -a|sed 's/\*//g'`; do
  # echo "$branch"
  name=${branch/remotes\/origin\//}
  # echo $name
    git checkout origin/$name
    cp -R ./ $EXPORT_DIR/$name
done

cd ..

# back to where we were
cd $previous_pwd
```

# Random

- List all completed leetcode questions

```
cd github/lc-topics
ls -R | grep -P '^\..*:$'
```

- `cat array.txt | sed 's/\.\/.*\///g' | sed 's/^\..*//g' | sort -n > array.txt`
- `cat rest.txt | sed 's/\.\/.*\///g' | sed 's/^\..*//g' | sort -n | uniq > rest.txt`
