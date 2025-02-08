# Table of Contents

- [Table of Contents](#table-of-contents)
- [Update My Repositories](#update-my-repositories)
- [Git Commands](#git-commands)
  - [`git add`](#git-add)
  - [`git cherry-pick`](#git-cherry-pick)
  - [`git commit`](#git-commit)
    - [Fixing Commits using `git commit --fixup <commitHash>` + `git rebase -i --autosquash`](#fixing-commits-using-git-commit---fixup-commithash--git-rebase--i---autosquash)
  - [Git Branches](#git-branches)
  - [`git rebase`](#git-rebase)
    - [Rebasing `feature` branch on `master`](#rebasing-feature-branch-on-master)
    - [Deleting Commits](#deleting-commits)
    - [Editing Commits](#editing-commits)
    - [Splitting Commits](#splitting-commits)
    - [Squashing Commits](#squashing-commits)
  - [`git remote`](#git-remote)
  - [`git reset`](#git-reset)
  - [`git rm`](#git-rm)
- [Git Workflow](#git-workflow)
  - [Remove Most Recent Commit + Unstage \& Leave Changes in Working Directory](#remove-most-recent-commit--unstage--leave-changes-in-working-directory)
  - [Reset Repository](#reset-repository)
  - [Adding Files to Previous Commit](#adding-files-to-previous-commit)
  - [Change Most Recent Git Commit Message](#change-most-recent-git-commit-message)
  - [Git Ignore Check](#git-ignore-check)
  - [Git Worktree](#git-worktree)
- [Setup](#setup)
  - [Git Config](#git-config)
- [SSH Keys](#ssh-keys)
  - [Authorized Keys](#authorized-keys)
  - [SSH Keys Not Saving](#ssh-keys-not-saving)
  - [SSH Keys for Multiple GitHub Accounts](#ssh-keys-for-multiple-github-accounts)
- [Miscellaneous](#miscellaneous)
  - [Force Git to Pickup Change in Case](#force-git-to-pickup-change-in-case)
  - [Fix `git fetch` would Clobber Existing Tags](#fix-git-fetch-would-clobber-existing-tags)
- [OhMyZsh Git Shortcuts](#ohmyzsh-git-shortcuts)

# Update My Repositories

```sh
cd ~/github/lc-topics && gl && cd ../lc-all && gl && cd ../notes && gl && cd ../config && gl && cd ../fake && gl && cd ../lnt-topics && gl && cd ../lnt-all && gl && cd ../oa && gl && cd ../fe && gl && cd
```

# Git Commands

## `git add`

```sh
# Add all files
gaa
git add --all

# Add all files in subdirectory
ga github/notes/dev/*
git add github/notes/dev/*

# Add java files only
ga **/*.java
```

## `git cherry-pick`

Scenario

- I have made `commit-a` on `master`
- I have branched off `master` to create `branch2` and made commits `commit-b`, `commit-c` on `branch2`
- We found errors with `commit-a` on `master` and have reverted/deleted `commit-a` and made new commits `fix1` and `fix2` on `master`
- After fixing `master`, I have created a new branch `branch3` from `master`
- How do I get commits `commit-b` and `commit-c` from `branch2` into `branch3`?

Solution

- To get commits `commit-b` and `commit-c` from `branch2` into `branch3`, use `git cherry-pick`

```sh
# Check out branch3
git checkout branch3
# Cherry-pick the commits from branch2
# git cherry-pick <commit-b-hash>
# git cherry-pick <commit-c-hash>
git cherry-pick <commit-b-hash> <commit-c-hash>
```

## `git commit`

### Fixing Commits using `git commit --fixup <commitHash>` + `git rebase -i --autosquash`

- Resources
  - https://jordanelver.co.uk/blog/2020/06/04/fixing-commits-with-git-commit-fixup-and-git-rebase-autosquash/
  - https://fle.github.io/git-tip-keep-your-branch-clean-with-fixup-and-autosquash.html
  - https://www.30secondsofcode.org/git/s/create-fixup-commit/

`git commit --fixup <commitHash>` automatically marks your commit as a fix of a previous commit
`git rebase -i --autosquash` automatically organize merging of these fixup commits and associated normal commits

Note: `git rebase -i <hashOfLastCommitToRetainAsIs>` must be launched with the commitHash of the LAST commit you want to retain as-is (NOT the first commit you want to change)

**Example**

We have made 3 commits and make/raise a PR

```sh
git add featureA.java && git commit -m "Feature A is done"
# [fb2f677] Feature A is done
git add featureB.java && git commit -m "Feature B is done"
# [733e2ff] Feature B is done
git add featureC.java && git commit -m "Feature C is done"
# [a13xd9g] Feature C is done
```

We make improvements to FeatureA.java based on comments in PR

```sh
git add featureA.java
git commit --fixup fb2f677
# [c5069d5] fixup! Feature A is done
```

```sh
git log --oneline
# c5069d5 fixup! Feature A is done
# a13xd9g Feature C is done
# 733e2ff Feature B is done
# fb2f677 Feature A is done
# ac5db87 Project Structure Initialisation
```

We want to clean/fix our commit history before merging it into `master`

Note: `git rebase -i <hashOfLastCommitToRetainAsIs>` must be launched with the commitHash of the LAST commit you want to retain as-is (NOT the first commit you want to change)

```sh
git rebase -i --autosquash ac5db87
# pick fb2f677 Feature A is done
# fixup c5069d5 fixup! Feature A is done
# pick 733e2ff Feature B is done
# pick a13xd9g Feature C is done
```

```sh
git log --oneline
# a13xd9g Feature C is done
# ff4de2a Feature B is done
# 5478cee Feature A is done
# ac5db87 Project Structure Initialisation
```

## Git Branches

```sh
# Delete LOCAL Branch
git branch -D localBranch
gbD localBranch

# Delete REMOTE Branch
git push origin --delete remoteBranch
git push origin -d remoteBranch
git push origin :remoteBranch

# View LOCAL Branches
git branch
gb

# View REMOTE Branches
git branch -r
gbr

# View LOCAL && REMOTE Branches
git branch -a
gba

# Rename Branch
# -------------
# Step 1: Rename Local Branch
# If you are ON the TARGET branch to rename
git checkout oldName
git branch -m newName
git branch --move newName
# If you are on a DIFFERENT branch (i.e. NOT on the target branch)
git branch -m oldName newName
git branch --move oldName newName
# Step 2: Delete Old Remote Branch
git push origin :oldName
git push origin -d oldName
git push origin --delete remoteBranch
# Alternatively you can RENAME the Remote Branch (your local branch still points to the now deleted oldName on the remote; you will need to point your local branch to newName on the remote via `git push origin -u newName`)
git push origin :oldName newName
# Step 3: Reset the Upstream Branch for the New Local Branch (and/or create a new remote branch)
git push origin -u newName
git push origin --set-upstream newName
# Combining Steps 2 + 3 (delete old remote branch and create new remote branch and update upstream branch for local branch)
git push -u origin :oldName newName
git push --set-upstream origin :oldName newName
# Step 4: Update Local List of Remote Branches
git fetch --prune
# git remote update --prune
# TLDR
git branch -m oldName newName
git push -u origin :oldName newName
git fetch --prune

# Update Local List Of Remote Branches
# ------------------------------------
# Note: git remote prune == git fetch --prune (except that git fetch will fetch changes first)
git fetch --prune
# git remote update --prune
```

## `git rebase`

- Can either do
  - `git rebase HEAD~n` (where `n` is number of commits GO BACK FROM `HEAD`, so if fixing the previous `3` commits then `n` should be `3` [i.e. we jump back 3 commits from `HEAD` back to the `4th` commit in desc order (inclusive)]) (where `n` is number of commits to go back from HEAD to reach the commit to go back to)
  - `git rebase <commitHash>` (where `commitHash` is the commit hash of the commit BEFORE the problems start (i.e. ancestor commit), so if fixing the last `3` commits then `commitHash` should be the commit hash of the `4th` commit)
- Can reorder/delete the commit lines
- Can change the command `pick`/`p` with any of the other commands below such as
  - `edit`/`e`
  - `reword`/`r`
  - `squash`/`s`
- Note: The commits are displayed in ASCENDING order (opposite to git log) [i.e. oldest commit at the TOP/FIRST]

```
f6g8h0j 12/07/24 12/07/24 11:30pm s3same Deploy to PROD (HEAD -> master, origin/master, origin/HEAD)  # <-- HEAD
o2p4q7s 12/07/24 12/07/24 10:00pm s3same Optimize application for performance
i3j5l8n 12/07/24 12/07/24 08:30pm s3same Implement client-side routing and state with Redux
d7e9g0h 12/07/24 12/07/24 05:00pm s3same Add functionality to create, and delete posts                # Commit to jump BACK TO
y1z6a4c 12/07/24 12/07/24 04:30pm s3same Design and implement the homepage + components
u7v0w3x 12/07/24 12/07/24 03:00pm s3same Connect backend to frontend for user authentication
q2r5s8t 12/07/24 12/07/24 11:30am s3same Develop RESTful API endpoints for user operations
k8m6n4p 12/07/24 12/07/24 10:00am s3same Create database schema for users and posts
0f9h1j2 12/07/24 12/07/24 08:30am s3same Implement user authentication
b3a5d79 12/07/24 12/07/24 07:00am s3same Initialize project structure
```

### Rebasing `feature` branch on `master`

```sh
git fetch -all --prune
gfa

git checkout master
gco master

git clean -dfx
gclean

git pull
gl

git checkout feature-a
gco feature-a

git rebase -i origin/master
grb -i origin/master
grbi origin/master

git push --force
gpf!
```

```sh
git fetch --all --prune && git checkout master && git reset --hard origin/master && git clean -dfx && git pull
gfa && gco master && groh && gclean && gl
gfa && gco master && gcleano && gl

git checkout <myBranch>
gco <myBranch>

git rebase -i origin/master
grb -i origin/master
grbi origin/master

# Resolve rebase conflicts
git add <resolvedFiles>
ga <resolvedFiles>
gaa

git rebase --continue
grbc

# CTRL+X (nano) || :wq (vim) || CTRL+S > CTRL+W (vscode)
git push --force
gpf!
```

```sh
# Abort Git Rebase
git rebase --abort
grba
```

### Deleting Commits

- [Git Docs](https://git-scm.com/book/en/v2/Git-Tools-Rewriting-History)

Example: We created a branch off feature/a branch and it turns out that the last commit of feature/a branch needs to be removed/rolled back

```sh
gco feature/a
echo "hello" > test.txt
gaa && gcmsg 'commit1' && gp

gcb feature/b
# Made 2 commits && pushed
echo "world" >> test.txt
gaa && gcmsg 'commit2' && gp
echo "hello world" > test.txt
gaa && gcmsg 'commit3' && gp

# Realised last commit from feature/a branch needs to be DELETED
git rebase -i hashOfCommit1 # V1/Method1
git rebase -i HEAD~3        # V2/Method2
grb -i HEAD~3

# DELETE the first line (remember that commits are displayed in ASCENDING order [opposite to git log])
pick 3245801 commit1        # <-- HERE
pick 2348129 commit2
pick 5892304 commit3

pick 2348129 commit2        # <-- HERE
pick 5892304 commit3

# CTRL+X (nano) || :wq (vim) || CTRL+S > CTRL+W (vscode)
git push --force
gpf!
```

### Editing Commits

Example: Remove typos in initial README.md commit

```sh
# Example: Remove typos in initial README.md
git rebase -i HEAD~4

# pick 3245801 Added README.md              # <-- HERE (change from PICK to EDIT)
# pick 2348129 Added login endpoint
# pick a4623d3 Added login endpoint tests
# pick 2bd3kxz Added logout endpoint

# edit 3245801 Added README.md              # <-- HERE
# pick 2348129 Added login endpoint
# pick a4623d3 Added login endpoint tests
# pick 2bd3kxz Added logout endpoint

# Remove typos in initial README.md
git add --all
gaa

git rebase --continue
grbc
# Git Rebase will prompt you to change commit message (can just close window)
# CTRL+X (nano) || :wq (vim) || CTRL+S > CTRL+W (vscode)
gpf!
```

### Splitting Commits

Example: Split commit of "Added README.md and login endpoint" into 2 separate commits

```sh
# Example: Remove typos in initial README.md
git rebase -i HEAD~3

pick 3245801 Added README.md and login endpoint   # <-- HERE (change from PICK to EDIT)
pick 1239593 Added login endpoint tests
pick 6729395 Added logout endpoint

edit 3245801 Added README.md and login endpoint   # <-- HERE (change from PICK to EDIT)
pick 1239593 Added login endpoint tests
pick 6729395 Added logout endpoint

# CTRL+X (nano) || :wq (vim) || CTRL+S > CTRL+W (vscode)

# Remove the last commit from history but leave the changes for it in the working copy
git reset HEAD~1
ga 'README.md' && gcmsg 'Added README.md'
ga 'index.js' && gcmsg 'Added login endpoint'

git rebase --continue
grbc
# Git Rebase will prompt you to change commit message (can just close window)
# CTRL+X (nano) || :wq (vim) || CTRL+S > CTRL+W (vscode)
gpf!
```

### Squashing Commits

Example: Remove "cleanup" commit

```sh
git rebase -i HEAD~5

pick 3245801 Added README.md
pick 2348129 Added login endpoint
pick 5892304 Added logout endpoint
pick 8129190 Cleanup logout endpoint
pick 7392932 Add authentication middleware

# Note: If you mark one or more lines as "squash", they will be combined into the line/commit ABOVE
pick 3245801 Added README.md
pick 2348129 Added login endpoint
pick 5892304 Added logout endpoint
squash 8129190 Cleanup logout endpoint
pick 7392932 Add authentication middleware

# CTRL+X (nano) || :wq (vim) || CTRL+S > CTRL+W (vscode)
gpf!
```

Example: Squash last 3 commits into 1

```sh
git rebase -i HEAD~3

pick 3245801 added tests
pick 2348129 fixed tests
pick 5892304 improved syntax

# Note: If you mark one or more lines as "squash", they will be combined into the line/commit ABOVE
pick 3245801 added tests
s 2348129 fixed tests
s 5892304 improved syntax

# CTRL+X (nano) || :wq (vim) || CTRL+S > CTRL+W (vscode)
gpf!
```

**Change This**

```sh
# This is a combination of 3 commits.
# This is the 1st commit message:

added tests

# This is the commit message #2:      # <-- DELETE
                                      # <-- DELETE
fixed tests                           # <-- DELETE
                                      # <-- DELETE
# This is the commit message #3:      # <-- DELETE
                                      # <-- DELETE
improved syntax                       # <-- DELETE

# Please enter the commit message for your changes. Lines starting
# with '#' will be ignored, and an empty message aborts the commit.
#
# Date:      Tue Apr 23 15:42:42 2024 +1000
#
# interactive rebase in progress; onto 040643d
# Last commands done (3 commands done):
#    squash e978b1f fixed tests
#    squash a34820b improved syntax
# No commands remaining.
# You are currently rebasing branch 'master' on '040643d'.
#
# Changes to be committed:
# modified:   .gitignore
#
```

**To This**

- Note:
  - DELETE all lines below `# This is the 1st commit message:` until `# Please enter the commit message for your changes. Lines starting` and add your custom git commit message for the squash
  - Can change commit message to something entirely different or leave as is

```sh
# This is a combination of 3 commits.
# This is the 1st commit message:

added tests and improved syntax

# Please enter the commit message for your changes. Lines starting
# with '#' will be ignored, and an empty message aborts the commit.
#
# Date:      Tue Apr 23 15:42:42 2024 +1000
#
# interactive rebase in progress; onto 040643d
# Last commands done (3 commands done):
#    squash e978b1f fixed tests
#    squash a34820b improved syntax
# No commands remaining.
# You are currently rebasing branch 'master' on '040643d'.
#
# Changes to be committed:
# modified:   .gitignore
#
```

## `git remote`

```sh
git remote -v

git remote set-url origin <insert-git-ssh-url-here>

git remote show origin
```

## `git reset`

```sh
# Undo the `git commit`
# Changes still exist in the working tree (the project folder) + the index (--cached)
git reset HEAD^ --soft
git reset HEAD~1 --soft
# Restore changes that have been staged (i.e. undo the git add)
git restore --staged .

# Undo the `git commit` && the `git add`
# Changes still exist in the working tree
git reset HEAD^ --mixed
git reset HEAD~1 --mixed

# Like you never made these changes to the codebase
# Changes are removed from the working tree
git reset HEAD^ --hard
git reset HEAD~1 --hard
```

## `git rm`

```sh
git rm --cached .DS_Store
git commit -m 'Stop tracking .DS_Store files'
git push

git rm --cached .DS_Store
gcmsg 'Stop tracking .DS_Store files'
gp
```

# Git Workflow

## Remove Most Recent Commit + Unstage & Leave Changes in Working Directory

```sh
git reset --soft HEAD~1
git restore --staged .
```

```sh
git reset --mixed HEAD~1
```

## Reset Repository

```sh
git reset --hard && git clean -dfx
git pull

gclean
gl
```

```sh
git remote update origin --prune
git fetch --all --prune
git fetch --all --prune && git reset --hard origin/master && git clean -dfx
```

## Adding Files to Previous Commit

```sh
git add test1.java
git commit -m 'added tests'

# Realised that you forgot to add test.java
git add test2.java

git commit --amend --no-edit
gcn!
```

## Change Most Recent Git Commit Message

```sh
git commit --amend -m 'updated commit message'
gcmsg! 'updated commit message'
```

## Git Ignore Check

Example: Check why `scripts/clone.sh` is being ignored by git in the `notes` folder

```sh
cd notes
git check-ignore -v notes/scripts/clone.sh
```

## Git Worktree

> Rule: Keep EACH Worktree in a SEPARATE PARENT directory (i.e. do NOT nest them inside the `master` directory)

```sh
cd myProject
git worktree add ../targetBranchDir targetBranch
gwta ../targetBranchDir targetBranch
```

```sh
cd targetBrachDir
git worktree remove .
gwtr .
# OR
cd myProject
git worktree remove ../targetBranchDir
gwtr ../targetBranchDir
```

# Setup

## Git Config

```ini
# ~/.gitconfig
# https://git-scm.com/docs/git-config#Documentation/git-config.txt
[alias]
  # Print the name of the current branch (useful for scripting)
  currbranch = "!git branch --contains HEAD | grep '*' | tr -s ' ' | cut -d ' ' -f2"
  # Associates a new commit with an existing commit hash (usage: git fix <prevCommitHashToAssociate>)
  fix = commit --fixup
  # fixup = "commit --fixup=HEAD"
  # Edit last commit message (usage: git reword "new commit msg")
  reword = commit --amend -m
  # Undo last commit but keep changed files in staged area (usage: git uncommit)
  uncommit = reset --soft HEAD~1
[branch]
  sort = -committerdate
[core]
  autocrlf = false
  editor = code --wait
  pager = less -F -X
[diff]
  # Use descriptive initials (c = commit, i = index, w = working tree) instead of a/b
  mnemonicPrefix = true
  # Show renames/moves
  renames = true
  # Use vscode as the default difftool
  tool = vscode
  # When using --word-diff, assume --word-diff-regex=.
  wordRegex = .
[difftool "vscode"]
  cmd = code --wait --diff $LOCAL $REMOTE
[fetch]
  prune = true
  prunetags = true
[grep]
  break = true
  heading = true
  lineNumber = true
  extendedRegexp = true
[init]
  defaultBranch = master
[log]
  date = local
[merge]
  conflictstyle = zdiff3
  tool = vscode
[mergetool "vscode"]
  cmd = code --wait $MERGED
[pull]
  rebase = true
[push]
  autoSetupRemote = true
  default = simple
[rebase]
  autosquash = true
  autostash = true
[remote "origin"]
  prune = true
[user]
  name = s3same
  email = s3samedev@gmail.com
```

**Git Config Commands**

```sh
git config --global user.name "s3same"
git config --global user.email "s3samedev@gmail.com"
git config --global push.default simple
git config --global pull.rebase true
git config --global branch.sort -committerdate
git config --global remote.origin.prune true
# git config --global column.ui auto

# Show configured global options
git config --global --list
```

# SSH Keys

## Authorized Keys

```shell
cat ~/.ssh/gitlab-cse.pub >> ~/.ssh/authorized_keys
chmod 600 ~/.ssh/authorized_keys
```

## SSH Keys Not Saving

- Need to add `AddKeysToAgent` line

```shell
# https://manpages.ubuntu.com/manpages/focal/en/man5/ssh_config.5.html

# s3same
Host github.com
  HostName github.com
  IdentityFile ~/.ssh/github-s3same
  AddKeysToAgent yes
  IdentitiesOnly yes

# s3samedev
Host githubs3.com
  HostName github.com
  IdentityFile ~/.ssh/github-s3samedev
  AddKeysToAgent yes
  IdentitiesOnly yes

# same2828
Host github28.com
  HostName github.com
  IdentityFile ~/.ssh/github-same2828
  AddKeysToAgent yes
  IdentitiesOnly yes

# CSE
# Host gitlab.cse.unsw.edu.au
#   HostName gitlab.cse.unsw.edu.au
#   IdentityFile ~/.ssh/gitlab-cse
#   AddKeysToAgent yes
#   IdentitiesOnly yes
```

## SSH Keys for Multiple GitHub Accounts

- Resources
  - https://gist.github.com/oanhnn/80a89405ab9023894df7
  - https://gist.github.com/jexchan/2351996?permalink_comment_id=4535652#gistcomment-4535652
  - https://gist.github.com/yinzara/bbedc35798df0495a4fdd27857bca2c1
- Make sure to clone using **NEW@HANDLE**
  - `git@github2` instead of `git@github.com`

```sh
git clone git@github2.com:same2828/text-analytics.git
```

INSTEAD OF

```sh
git clone git@github.com:same2828/text-analytics.git
```

- Make sure to CHANGE username and email for cloned project

```sh
cd newRepo
git config user.email "newEmail"
git config user.name "newName"
```

# Miscellaneous

- Note:
  - `HEAD^` == `HEAD~1`
  - `HEAD^^` == `HEAD~2`
  - `HEAD^^^` == `HEAD~3`

## Force Git to Pickup Change in Case

```sh
git mv oldFileName newFileName
```

```conf
git config core.ignorecase false
```

## Fix `git fetch` would Clobber Existing Tags

```sh
git fetch --tags --force
git fetch --all --tags --force
```

# OhMyZsh Git Shortcuts

| Shortcut  | Git Command                                                                                                                             |
| --------- | --------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `ga`      | `git add`                                                                                                                               |                                                                                                                                                                 |
| `gaa`     | `git add --all`                                                                                                                         |                                                                                                                                                                 |
| `gb`      | `git branch`                                                                                                                            |                                                                                                                                                                 |
| `gba`     | `git branch -a`                                                                                                                         |                                                                                                                                                                 |
| `gbd`     | `git branch -d`                                                                                                                         |                                                                                                                                                                 |
| `gbD`     | `git branch -D`                                                                                                                         |                                                                                                                                                                 |
| `gbd!`    | `git branch -D`                                                                                                                         |                                                                                                                                                                 |
| `gc!`     | `git commit --verbose --amend`                                                                                                          |                                                                                                                                                                 |
| `gcam`    | `git commit -a -m`                                                                                                                      |                                                                                                                                                                 |
| `gcb`     | `git checkout -b`                                                                                                                       |                                                                                                                                                                 |
| `gclean`  | `git reset --hard && git clean -dfx`                                                                                                    |                                                                                                                                                                 |
| `gclean`  | `git reset --hard && git clean -dfx`                                                                                                    |                                                                                                                                                                 |
| `gcleano` | `git fetch --all --prune --tags --force && git reset --hard origin/$(git_current_branch) && git clean -dfx`                             |                                                                                                                                                                 |
| `gcmsg`   | `git commit -m`                                                                                                                         |                                                                                                                                                                 |
| `gcmsg!`  | `git commit --amend -m`                                                                                                                 |                                                                                                                                                                 |
| `gco`     | `git checkout`                                                                                                                          |                                                                                                                                                                 |
| `gf`      | `git fetch --all --prune`                                                                                                               |                                                                                                                                                                 |
| `gf!`     | `git fetch --all --prune --tags --force`                                                                                                |                                                                                                                                                                 |
| `gfa`     | `git fetch --all --prune`                                                                                                               |                                                                                                                                                                 |
| `ggu`     | `git pull --rebase origin $(current_branch)`                                                                                            |                                                                                                                                                                 |
| `gl`      | `git pull --rebase --autostash`                                                                                                         |                                                                                                                                                                 |
| `glo`     | `git log --pretty='%C(yellow)%h %C(cyan)%cd %C(red)%aN%Cgreen%d %Creset%s' --date=format:'%d/%m/%y %I:%M%P'` (`%p` for macOS)           |                                                                                                                                                                 |
| `glo2`    | `git log --graph --oneline --decorate --pretty=%C(yellow)%h %C(cyan)%cd %C(red)%aN %Creset%s%C(green)%d --date=format:%d/%m/%y %I:%M%p` |                                                                                                                                                                 |
| `glo3`    | `git log --pretty=%C(yellow)%h %C(cyan)%cd %C(magenta)%aN %Creset%s%C(green)%d --date=format:%d/%m/%y %I:%M:%S%p`                       |                                                                                                                                                                 |
| `gp`      | `git push`                                                                                                                              |                                                                                                                                                                 |
| `gpf!`    | `git push --force-with-lease --force-if-includes`                                                                                       |                                                                                                                                                                 |
| `gpf!!`   | `git push --force`                                                                                                                      |                                                                                                                                                                 |
| `gpf`     | `git push --force-with-lease --force-if-includes`                                                                                       |                                                                                                                                                                 |
| `gpff`    | `git push --force`                                                                                                                      |                                                                                                                                                                 |
| `gpsup`   | `git push --set-upstream origin $(git_current_branch)`                                                                                  |                                                                                                                                                                 |
| `grb`     | `git rebase`                                                                                                                            |                                                                                                                                                                 |
| `grba`    | `git rebase --abort`                                                                                                                    |                                                                                                                                                                 |
| `grbc`    | `git rebase --continue`                                                                                                                 |                                                                                                                                                                 |
| `grbi`    | `git rebase -i`                                                                                                                         |                                                                                                                                                                 |
| `grh`     | `git reset`                                                                                                                             |                                                                                                                                                                 |
| `grhh`    | `git reset --hard`                                                                                                                      |                                                                                                                                                                 |
| `groh`    | `git reset origin/$(git_current_branch) --hard`                                                                                         |                                                                                                                                                                 |
| `gst`     | `git status`                                                                                                                            |                                                                                                                                                                 |
| `gstash`  | `git stash --include-untracked`                                                                                                         |                                                                                                                                                                 |
| `gstashp` | `git stash pop`                                                                                                                         |                                                                                                                                                                 |
| `gsth`    | `git stash --include-untracked`                                                                                                         |                                                                                                                                                                 |
| `gstp`    | `git stash pop`                                                                                                                         |                                                                                                                                                                 |
| `gstsh`   | `git stash --include-untracked`                                                                                                         |                                                                                                                                                                 |
| `gstshp`  | `git stash pop`                                                                                                                         |                                                                                                                                                                 |
| `gundo`   | `git reset --mixed HEAD~1`                                                                                                              |                                                                                                                                                                 |
| `gundo1`  | `git reset --mixed HEAD~1`                                                                                                              |                                                                                                                                                                 |
| `gundo!`  | `git reset --hard ORIG_HEAD`                                                                                                            | # Undos the gundo (note: ORIG_HEAD is a reference that points to the previous state of HEAD before disruptive operations like git reset, git rebase, git merge) |
| `gwta`    | `git worktree add`                                                                                                                      | `cd myRepo && gwta ../targetBranchDir targetBranch`                                                                                                             |
| `gwtl`    | `git worktree list`                                                                                                                     | `(cd myRepo or cd targetBranchDir) && gwtl`                                                                                                                     |
| `gwtr`    | `git worktree remove`                                                                                                                   | `(cd myRepo && gwtr ../targetBranchDir) or (cd targetBranchDir && gwtr .)`                                                                                      |

| Shortcut               | Git Command                                                                                                                                  |
| ---------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| `g`                    | `git`                                                                                                                                        |
| `ga`                   | `git add`                                                                                                                                    |
| `gaa`                  | `git add --all`                                                                                                                              |
| `gam`                  | `git am`                                                                                                                                     |
| `gama`                 | `git am --abort`                                                                                                                             |
| `gamc`                 | `git am --continue`                                                                                                                          |
| `gams`                 | `git am --skip`                                                                                                                              |
| `gamscp`               | `git am --show-current-patch`                                                                                                                |
| `gap`                  | `git apply`                                                                                                                                  |
| `gapa`                 | `git add --patch`                                                                                                                            |
| `gapt`                 | `git apply --3way`                                                                                                                           |
| `gau`                  | `git add --update`                                                                                                                           |
| `gav`                  | `git add --verbose`                                                                                                                          |
| `gb`                   | `git branch`                                                                                                                                 |
| `gba`                  | `git branch -a`                                                                                                                              |
| `gbd`                  | `git branch -d`                                                                                                                              |
| `gbD`                  | `git branch -D`                                                                                                                              |
| `gbda`                 | `git branch --no-color --merged \| grep -vE "^([+]\|\s($(git_main_branch)\|$(git*develop_branch))\s\*$)" \| xargs git branch -d 2>/dev/null` |
| `gbl`                  | `git blame -b -w`                                                                                                                            |
| `gbnm`                 | `git branch --no-merged`                                                                                                                     |
| `gbr`                  | `git branch --remote`                                                                                                                        |
| `gbs`                  | `git bisect`                                                                                                                                 |
| `gbsb`                 | `git bisect bad`                                                                                                                             |
| `gbsg`                 | `git bisect good`                                                                                                                            |
| `gbsr`                 | `git bisect reset`                                                                                                                           |
| `gbss`                 | `git bisect start`                                                                                                                           |
| `gc`                   | `git commit -v`                                                                                                                              |
| `gc!`                  | `git commit -v --amend`                                                                                                                      |
| `gca`                  | `git commit -v -a`                                                                                                                           |
| `gca!`                 | `git commit -v -a --amend`                                                                                                                   |
| `gcam`                 | `git commit -a -m`                                                                                                                           |
| `gcan!`                | `git commit -v -a --no-edit --amend`                                                                                                         |
| `gcans!`               | `git commit -v -a -s --no-edit --amend`                                                                                                      |
| `gcas`                 | `git commit -a -s`                                                                                                                           |
| `gcasm`                | `git commit -a -s -m`                                                                                                                        |
| `gcb`                  | `git checkout -b`                                                                                                                            |
| `gccd`                 | `git clone --recurse-submodules "$@" && cd "$(basename $* .git)"`                                                                            |
| `gcd`                  | `git checkout $(git_develop_branch)`                                                                                                         |
| `gcf`                  | `git config --list`                                                                                                                          |
| `gcl`                  | `git clone --recurse-submodules`                                                                                                             |
| `gclean`               | `git clean -id`                                                                                                                              |
| `gcleano`              | `git fetch --all --prune && git reset --hard origin/master && git clean -dfx`                                                                |
| `gcm`                  | `git checkout $(git_main_branch)`                                                                                                            |
| `gcmsg`                | `git commit -m`                                                                                                                              |
| `gcmsg!`               | `git commit --amend -m`                                                                                                                      |
| `gcn!`                 | `git commit -v --no-edit --amend`                                                                                                            |
| `gco`                  | `git checkout`                                                                                                                               |
| `gcor`                 | `git checkout --recurse-submodules`                                                                                                          |
| `gcount`               | `git shortlog -sn`                                                                                                                           |
| `gcp`                  | `git cherry-pick`                                                                                                                            |
| `gcpa`                 | `git cherry-pick --abort`                                                                                                                    |
| `gcpc`                 | `git cherry-pick --continue`                                                                                                                 |
| `gcs`                  | `git commit -S`                                                                                                                              |
| `gcsm`                 | `git commit -s -m`                                                                                                                           |
| `gd`                   | `git diff`                                                                                                                                   |
| `gdca`                 | `git diff --cached`                                                                                                                          |
| `gdct`                 | `git describe --tags $(git rev-list --tags --max-count=1)`                                                                                   |
| `gdcw`                 | `git diff --cached --word-diff`                                                                                                              |
| `gdnolock`             | `git diff $@ ":(exclude)package-lock.json" ":(exclude)*.lock"`                                                                               |
| `gds`                  | `git diff --staged`                                                                                                                          |
| `gdt`                  | `git diff-tree --no-commit-id --name-only -r`                                                                                                |
| `gdup`                 | `git diff @{upstream}`                                                                                                                       |
| `gdv`                  | `git diff -w $@ \| view -`                                                                                                                   |
| `gdw`                  | `git diff --word-diff`                                                                                                                       |
| `gf`                   | `git fetch`                                                                                                                                  |
| `gfa`                  | `git fetch --all --prune`                                                                                                                    |
| `gfg`                  | `git ls-files \| grep`                                                                                                                       |
| `gfo`                  | `git fetch origin`                                                                                                                           |
| `gg`                   | `git gui citool`                                                                                                                             |
| `gga`                  | `git gui citool --amend`                                                                                                                     |
| `ggf`                  | `git push --force origin $(current_branch)`                                                                                                  |
| `ggfl`                 | `git push --force-with-lease origin $(current_branch)`                                                                                       |
| `ggl`                  | `git pull origin $(current_branch)`                                                                                                          |
| `ggp`                  | `git push origin $(current_branch)`                                                                                                          |
| `ggpnp`                | `ggl && ggp`                                                                                                                                 |
| `ggpull`               | `git pull origin "$(git_current_branch)"`                                                                                                    |
| `ggpur`                | `ggu`                                                                                                                                        |
| `ggpush`               | `git push origin "$(git_current_branch)"`                                                                                                    |
| `ggsup`                | `git branch --set-upstream-to=origin/$(git_current_branch)`                                                                                  |
| `ggu`                  | `git pull --rebase origin $(current_branch)`                                                                                                 |
| `ghh`                  | `git help`                                                                                                                                   |
| `gignore`              | `git update-index --assume-unchanged`                                                                                                        |
| `gignored`             | `git ls-files -v \| grep "^[[:lower:]]"`                                                                                                     |
| `git-svn-dcommit-push` | `git svn dcommit && git push github $(git_main_branch):svntrunk`                                                                             |
| `gk`                   | `gitk --all --branches &!`                                                                                                                   |
| `gke`                  | `gitk --all $(git log -g --pretty=%h) &!`                                                                                                    |
| `gl`                   | `git pull`                                                                                                                                   |
| `glg`                  | `git log --stat`                                                                                                                             |
| `glgg`                 | `git log --graph`                                                                                                                            |
| `glgga`                | `git log --graph --decorate --all`                                                                                                           |
| `glgm`                 | `git log --graph --max-count=10`                                                                                                             |
| `glgp`                 | `git log --stat -p`                                                                                                                          |
| `glo`                  | `git log --oneline --decorate`                                                                                                               |
| `glo`                  | `git log --pretty='%C(yellow)%h %C(cyan)%cd %C(red)%aN%Cgreen%d %Creset%s' --date=format:'%d/%m/%y %I:%M%P'` (`%p` for macOS)                |
| `glod`                 | `git log --graph --pretty='%Cred%h%Creset -%C(auto)%d%Creset %s %Cgreen(%ad) %C(bold blue)<%an>%Creset'`                                     |
| `glods`                | `git log --graph --pretty='%Cred%h%Creset -%C(auto)%d%Creset %s %Cgreen(%ad) %C(bold blue)<%an>%Creset' --date=short`                        |
| `glog`                 | `git log --oneline --decorate --graph`                                                                                                       |
| `gloga`                | `git log --oneline --decorate --graph --all`                                                                                                 |
| `glol`                 | `git log --graph --pretty='%Cred%h%Creset -%C(auto)%d%Creset %s %Cgreen(%ar) %C(bold blue)<%an>%Creset'`                                     |
| `glola`                | `git log --graph --pretty='%Cred%h%Creset -%C(auto)%d%Creset %s %Cgreen(%ar) %C(bold blue)<%an>%Creset' --all`                               |
| `glols`                | `git log --graph --pretty='%Cred%h%Creset -%C(auto)%d%Creset %s %Cgreen(%ar) %C(bold blue)<%an>%Creset' --stat`                              |
| `glp`                  | `git log --pretty=<format>`                                                                                                                  |
| `gluc`                 | `git pull upstream $(git_current_branch)`                                                                                                    |
| `glum`                 | `git pull upstream $(git_main_branch)`                                                                                                       |
| `gm`                   | `git merge`                                                                                                                                  |
| `gma`                  | `git merge --abort`                                                                                                                          |
| `gmom`                 | `git merge origin/$(git_main_branch)`                                                                                                        |
| `gmtl`                 | `git mergetool --no-prompt`                                                                                                                  |
| `gmtlvim`              | `git mergetool --no-prompt --tool=vimdiff`                                                                                                   |
| `gmum`                 | `git merge upstream/$(git_main_branch)`                                                                                                      |
| `gp`                   | `git push`                                                                                                                                   |
| `gpd`                  | `git push --dry-run`                                                                                                                         |
| `gpf`                  | `git push --force-with-lease`                                                                                                                |
| `gpf!`                 | `git push --force`                                                                                                                           |
| `gpoat`                | `git push origin --all && git push origin --tags`                                                                                            |
| `gpr`                  | `git pull --rebase`                                                                                                                          |
| `gpristine`            | `git reset --hard && git clean -dffx`                                                                                                        |
| `gpsup`                | `git push --set-upstream origin $(git_current_branch)`                                                                                       |
| `gpu`                  | `git push upstream`                                                                                                                          |
| `gpv`                  | `git push -v`                                                                                                                                |
| `gr`                   | `git remote`                                                                                                                                 |
| `gra`                  | `git remote add`                                                                                                                             |
| `grb`                  | `git rebase`                                                                                                                                 |
| `grba`                 | `git rebase --abort`                                                                                                                         |
| `grbc`                 | `git rebase --continue`                                                                                                                      |
| `grbd`                 | `git rebase $(git_develop_branch)`                                                                                                           |
| `grbi`                 | `git rebase -i`                                                                                                                              |
| `grbm`                 | `git rebase $(git_main_branch)`                                                                                                              |
| `grbo`                 | `git rebase --onto`                                                                                                                          |
| `grbom`                | `git rebase origin/$(git_main_branch)`                                                                                                       |
| `grbs`                 | `git rebase --skip`                                                                                                                          |
| `grev`                 | `git revert`                                                                                                                                 |
| `grh`                  | `git reset`                                                                                                                                  |
| `grhh`                 | `git reset --hard`                                                                                                                           |
| `grm`                  | `git rm`                                                                                                                                     |
| `grmc`                 | `git rm --cached`                                                                                                                            |
| `grmv`                 | `git remote rename`                                                                                                                          |
| `groh`                 | `git reset origin/$(git_current_branch) --hard`                                                                                              |
| `grrm`                 | `git remote remove`                                                                                                                          |
| `grs`                  | `git restore`                                                                                                                                |
| `grset`                | `git remote set-url`                                                                                                                         |
| `grss`                 | `git restore --source`                                                                                                                       |
| `grst`                 | `git restore --staged`                                                                                                                       |
| `grt`                  | `cd "$(git rev-parse --show-toplevel \|\| echo .)"`                                                                                          |
| `gru`                  | `git reset --`                                                                                                                               |
| `grup`                 | `git remote update`                                                                                                                          |
| `grv`                  | `git remote -v`                                                                                                                              |
| `gsb`                  | `git status -sb`                                                                                                                             |
| `gsd`                  | `git svn dcommit`                                                                                                                            |
| `gsh`                  | `git show`                                                                                                                                   |
| `gsi`                  | `git submodule init`                                                                                                                         |
| `gsps`                 | `git show --pretty=short --show-signature`                                                                                                   |
| `gsr`                  | `git svn rebase`                                                                                                                             |
| `gss`                  | `git status -s`                                                                                                                              |
| `gst`                  | `git status`                                                                                                                                 |
| `gsta`                 | `git stash push`                                                                                                                             |
| `gsta`                 | `git stash save`                                                                                                                             |
| `gstaa`                | `git stash apply`                                                                                                                            |
| `gstall`               | `git stash --all`                                                                                                                            |
| `gstash`               | `git stash --all`                                                                                                                            |
| `gstashp`              | `git stash pop`                                                                                                                              |
| `gstc`                 | `git stash clear`                                                                                                                            |
| `gstd`                 | `git stash drop`                                                                                                                             |
| `gstl`                 | `git stash list`                                                                                                                             |
| `gstp`                 | `git stash pop`                                                                                                                              |
| `gsts`                 | `git stash show --text`                                                                                                                      |
| `gstu`                 | `git stash --include-untracked`                                                                                                              |
| `gsu`                  | `git submodule update`                                                                                                                       |
| `gsw`                  | `git switch`                                                                                                                                 |
| `gswc`                 | `git switch -c`                                                                                                                              |
| `gswd`                 | `git switch $(git_develop_branch)`                                                                                                           |
| `gswm`                 | `git switch $(git_main_branch)`                                                                                                              |
| `gtl`                  | `gtl(){ git tag --sort=-v:refname -n -l ${1}\* }; noglob gtl`                                                                                |
| `gts`                  | `git tag -s`                                                                                                                                 |
| `gtv`                  | `git tag \| sort -V`                                                                                                                         |
| `gundo`                | `git reset --mixed HEAD~1`                                                                                                                   |
| `gunignore`            | `git update-index --no-assume-unchanged`                                                                                                     |
| `gunwip`               | `git log -n 1 \| grep -q -c "--wip--" && git reset HEAD~1`                                                                                   |
| `gup`                  | `git pull --rebase`                                                                                                                          |
| `gupa`                 | `git pull --rebase --autostash`                                                                                                              |
| `gupav`                | `git pull --rebase --autostash -v`                                                                                                           |
| `gupom`                | `git pull --rebase origin $(git_main_branch)`                                                                                                |
| `gupomi`               | `git pull --rebase=interactive origin $(git_main_branch)`                                                                                    |
| `gupv`                 | `git pull --rebase -v`                                                                                                                       |
| `gwch`                 | `git whatchanged -p --abbrev-commit --pretty=medium`                                                                                         |
| `gwip`                 | `git add -A; git rm $(git ls-files --deleted) 2> /dev/null; git commit --no-verify --no-gpg-sign -m "--wip-- [skip ci]"`                     |
