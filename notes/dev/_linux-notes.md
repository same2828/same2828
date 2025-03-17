# Table of Contents

- [Table of Contents](#table-of-contents)
- [Commands](#commands)
  - [`apt`](#apt)
  - [`cp` - Copy](#cp---copy)
  - [`date` - Timestamp](#date---timestamp)
  - [`kill` - Kill ProcessId](#kill---kill-processid)
  - [`ls`](#ls)
  - [`pkill` - Kill Process by Name](#pkill---kill-process-by-name)
  - [`ps`](#ps)
  - [`where`](#where)
  - [SSH](#ssh)
    - [Change User](#change-user)
    - [Copy Local File into Remote SSH Instance](#copy-local-file-into-remote-ssh-instance)
    - [Copy File from Remote SSH Instance into Local Directory](#copy-file-from-remote-ssh-instance-into-local-directory)
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

## `cp` - Copy

```sh
# Copy file to current working directory
cd /path/to/targetDirectory
cp /path/to/srcFile ./
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

## `pkill` - Kill Process by Name

```sh
pkill -9 -f "processName"
```

## `ps`

```sh
ps aux | grep -e "<process-name-to-find-using-regex>"
ps aux | grep -i <process-name-to-find-ignore-case>"
```

## `where`

```sh
where jmeter
```

## SSH

```sh
ssh <ip_address>
ssh <ip_address> -l <user_name>
```

### Change User

```sh
sudo su
sudo su - root
sudo su - userToChangeTo
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
