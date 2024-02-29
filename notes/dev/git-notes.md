# Table of Contents

- [Table of Contents](#table-of-contents)
- [Workflow](#workflow)
  - [Rebase](#rebase)
- [Setup](#setup)
  - [Git Config](#git-config)
- [SSH Keys](#ssh-keys)
  - [Authorized Keys](#authorized-keys)
  - [SSH Keys Not Saving](#ssh-keys-not-saving)
  - [SSH Keys for Multiple GitHub Accounts](#ssh-keys-for-multiple-github-accounts)

# Workflow

```sh
git commit --amend -m "new commit message"
```

```sh
git reset --soft origin/master
```

```sh
git reset --hard origin/master
```

```sh
cd github/lc-topics && gl && cd ../lc-all && gl && cd ../notes && gl && cd ../config && gl && cd ../interview-questions && gl && cd ../fe && gl && cd
```

```sh
cd github/lc-topics
sudo rm -rf .git
git init
# git add --all && git commit 'reinit'
gaa && gcmsg reinit
git remote add origin git@github.com:samsolichin/leetcode-topics.git
git push -u origin master
```

## Rebase

```sh
git fetch
git checkout <myBranch>
git rebase -i origin/master
# Resolve rebase conflicts
git add <resolvedFiles>
git rebase --continue
# CTRL + X (nano) || :wq (vim)
git push --force
```

# Setup

## Git Config

**.gitconfig File**

```ini
# .gitconfig
[user]
	name = samsolichin
	email = samsolichin01@gmail.com
[push]
	default = simple
[pull]
	rebase = true
[core]
	autocrlf = false
	editor = code --wait
	pager = less -F -X
[log]
	date = local
```

**Git Config Commands**

```sh
git config --global user.name "samsolichin"
git config --global user.email "samsolichin01@gmail.com"
git config --global --list
git config --global push.default simple
git config --global pull.rebase true
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
