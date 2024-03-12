# Table of Contents

- [Table of Contents](#table-of-contents)
- [OhMyZsh Git Shortcuts](#ohmyzsh-git-shortcuts)
- [Git Commands](#git-commands)
  - [Branches](#branches)
  - [Reset](#reset)
- [Workflow](#workflow)
  - [Rebase](#rebase)
- [Setup](#setup)
  - [Git Config](#git-config)
- [SSH Keys](#ssh-keys)
  - [Authorized Keys](#authorized-keys)
  - [SSH Keys Not Saving](#ssh-keys-not-saving)
  - [SSH Keys for Multiple GitHub Accounts](#ssh-keys-for-multiple-github-accounts)
- [Miscellaneous](#miscellaneous)

# OhMyZsh Git Shortcuts

| Shortcut  | Git Command                                                                                                  |
| --------- | ------------------------------------------------------------------------------------------------------------ |
| `ga`      | `git add`                                                                                                    |
| `gaa`     | `git add --all`                                                                                              |
| `gb`      | `git branch`                                                                                                 |
| `gba`     | `git branch -a`                                                                                              |
| `gbd`     | `git branch -d`                                                                                              |
| `gbD`     | `git branch -D`                                                                                              |
| `gcam`    | `git commit -a -m`                                                                                           |
| `gcb`     | `git checkout -b`                                                                                            |
| `gclean`  | `git reset --hard && git clean -dfx`                                                                         |
| `gcleano` | `git fetch --all --prune && git reset --hard origin/master && git clean -dfx`                                |
| `gcmsg`   | `git commit -m`                                                                                              |
| `gcmsg!`  | `git commit --amend -m`                                                                                      |
| `gco`     | `git checkout`                                                                                               |
| `gf`      | `git fetch`                                                                                                  |
| `gfa`     | `git fetch --all --prune`                                                                                    |
| `ggu`     | `git pull --rebase origin $(current_branch)`                                                                 |
| `gl`      | `git pull`                                                                                                   |
| `glo`     | `git log --pretty='%C(yellow)%h %C(cyan)%cd %C(red)%aN%Cgreen%d %Creset%s' --date=format:'%d/%m/%y %I:%M%P'` |
| `gp`      | `git push`                                                                                                   |
| `gpf`     | `git push --force`                                                                                           |
| `gpf`     | `git push --force-with-lease`                                                                                |
| `gpsup`   | `git push --set-upstream origin $(git_current_branch)`                                                       |
| `grb`     | `git rebase`                                                                                                 |
| `grba`    | `git rebase --abort`                                                                                         |
| `grbc`    | `git rebase --continue`                                                                                      |
| `grbi`    | `git rebase -i`                                                                                              |
| `grhh`    | `git reset --hard`                                                                                           |
| `groh`    | `git reset origin/$(git_current_branch) --hard`                                                              |
| `gst`     | `git stash`                                                                                                  |
| `gstall`  | `git stash --all`                                                                                            |
| `gstash`  | `git stash --all`                                                                                            |
| `gstp`    | `git stash pop`                                                                                              |
| `gundo`   | `git reset HEAD~1 --mixed`                                                                                   |

# Git Commands

## Branches

```sh
# Delete LOCAL Branch
git branch -D localBranchToDelete
gbD localBranchToDelete

# Delete REMOTE Branch
git push origin --delete remoteBranchToDelete

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
git checkout oldName
git branch -m newName
# git branch -m oldName newName # If you are on master branch

# Update Local List Of Remote Branches
git remote update origin --prune
```

## Reset

```sh
# Undo the `git commit`
# Changes still exist in the working tree (the project folder) + the index (--cached)
git reset HEAD^ --soft
git reset HEAD~1 --soft

# Undo the `git commit` && the `git add`
# Changes still exist in the working tree
git reset HEAD^ --mixed
git reset HEAD~1 --mixed

# Like you never made these changes to the codebase
# Changes are removed from the working tree
git reset HEAD^ --hard
git reset HEAD~1 --hard
```

# Workflow

```sh
git commit --amend -m "new commit message"
gcmsg! 'new commit message'
```

```sh
git remote update origin --prune
git fetch --all --prune
git fetch --all --prune && git reset --hard origin/master && git clean -dfx
```

```sh
git reset --hard && git clean -dfx
git pull
```

```sh
cd ~/github/lc-topics && gl && cd ../lc-all && gl && cd ../notes && gl && cd ../config && gl && cd ../lnt-topics && gl && cd ../lnt-all && gl && cd ../oa && gl && cd ../fe && gl && cd
```

## Rebase

```sh
git rebase --abort
# grba
```

```sh
git fetch --all --prune && git checkout master && git reset --hard origin/master && git clean -dfx
git checkout <myBranch>
git rebase -i origin/master
# Resolve rebase conflicts
git add <resolvedFiles>
git rebase --continue
# CTRL + X (nano) || :wq (vim)
git push --force
```

```sh
gfa && gco master && groh && gclean
gco <myBranch>
grbi origin/master
# Resolve rebase conflicts
ga <resoledFiles>
grbc
# CTRL + X (nano) || :wq (vim)
gpf
```

# Setup

## Git Config

```ini
# ~/.gitconfig
[branch]
	sort = -committerdate
[core]
	autocrlf = false
	editor = code --wait
	pager = less -F -X
[init]
  defaultBranch = master
[log]
	date = local
[pull]
	rebase = true
[push]
	default = simple
[remote "origin"]
	prune = true
[user]
	name = samsolichin
	email = samsolichin01@gmail.com
```

**Git Config Commands**

```sh
git config --global user.name "samsolichin"
git config --global user.email "samsolichin01@gmail.com"
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

# samsolichin
Host github.com
  HostName github.com
  IdentityFile ~/.ssh/github-samsolichin
  AddKeysToAgent yes
  IdentitiesOnly yes

# s3same
Host github2.com
  HostName github.com
  IdentityFile ~/.ssh/github-s3same
  AddKeysToAgent yes
  IdentitiesOnly yes

# same2828
Host github3.com
  HostName github.com
  IdentityFile ~/.ssh/github-same2828
  AddKeysToAgent yes
  IdentitiesOnly yes

# CSE
Host gitlab.cse.unsw.edu.au
  HostName gitlab.cse.unsw.edu.au
  IdentityFile ~/.ssh/gitlab-cse
  AddKeysToAgent yes
  IdentitiesOnly yes
```

## SSH Keys for Multiple GitHub Accounts

- [Read more](https://gist.github.com/oanhnn/80a89405ab9023894df7)
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
  - `^` == `HEAD~1`
  - `^^` == `HEAD~2`
  - `^^^` == `HEAD~3`
