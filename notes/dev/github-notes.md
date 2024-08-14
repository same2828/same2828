# Table of Contents

- [Table of Contents](#table-of-contents)
- [Copilot](#copilot)
  - [See Suggestions (inline)](#see-suggestions-inline)
  - [See Suggestions (new tab)](#see-suggestions-new-tab)
  - [Copilot Chat](#copilot-chat)
- [Load all diffs](#load-all-diffs)
- [Change Username](#change-username)

# Copilot

## See Suggestions (inline)

| OS            | See next suggestion | See previous suggestion |
| ------------- | ------------------- | ----------------------- |
| macOS         | `Option + ]`        | `Option + [`            |
| Windows/Linux | `Alt + ]`           | `Alt + [`               |

## See Suggestions (new tab)

- `Ctrl + Enter`

## Copilot Chat

- Inline Chat (Editor): `Ctrl + I`
  - Then use `/` to get list of prompts
- Inline Chat (Command Palette): `Ctrl + Shift + I`

```
// q: What does SOLID stand for in OOP

/fix the problems in my code

/tests add unit tests for my code

/explain how the selected code works
```

# Load all diffs

```
let buttons = document.getElementsByClassName('load-diff-button');

for(let i = 0; i < buttons.length; i++) {
  buttons[i].click();
}
```

# Change Username

After changing github username -> need to change remote repository url for each repo

- Note: Also GitHub links/uses the email address in the commit header to link the commit to a GitHub user (i.e. author/username on the commit == git config's `user.email`)

```sh
cd ~/github/notes && git remote set-url origin git@github.com:s3same/notes.git
```

- [Read more](https://docs.github.com/en/get-started/getting-started-with-git/managing-remote-repositories)
