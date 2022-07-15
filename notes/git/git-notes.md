# Table of Contents

- [Table of Contents](#table-of-contents)
- [SSH Keys for Multiple GitHub Accounts](#ssh-keys-for-multiple-github-accounts)
- [Git Setup Machine First Time](#git-setup-machine-first-time)
  - [Update Git Config with name + email](#update-git-config-with-name--email)
  - [To check](#to-check)
- [SSH Key for CSE Not Saving](#ssh-key-for-cse-not-saving)
- [Authorized Keys](#authorized-keys)

# SSH Keys for Multiple GitHub Accounts

- [Read more](https://gist.github.com/oanhnn/80a89405ab9023894df7)
- Make sure to clone using NEW@HANDLE
  - git@**`github-same2828`** instead of git@**`github.com`**

```
git clone git@github-same2828:same2828/text-analytics.git
```

INSTEAD OF

```
git clone git@github.com:same2828/text-analytics.git
```

- Make sure to CHANGE username and email for cloned project

```
cd newRepo
git config user.email "newEmail"
git config user.name "newName"
```

# Git Setup Machine First Time

## Update Git Config with name + email

```
git config --global user.name "samsolichin"
git config --global user.email "samsolichin01@gmail.com"
```

## To check

```
git config --global --list
git config --global push.default simple
git config --global pull.rebase true
```

# SSH Key for CSE Not Saving

```shell
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/gitlab-cse
```

# Authorized Keys

```
cat ~/.ssh/gitlab-cse.pub >> ~/.ssh/authorized_keys
chmod 600 ~/.ssh/authorized_keys
```
