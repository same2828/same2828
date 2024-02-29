# Table of Contents

- [Table of Contents](#table-of-contents)
- [Commands](#commands)
- [Python](#python)
  - [Pylint](#pylint)
- [Starship](#starship)

# Commands

```
brew update && brew upgrade && brew cleanup

brew link --force node@18
brew link --overwrite node@18
```

```

**Update**

```

brew update

```

**Upgrade**

```

brew upgrade

```

**Cleanup**

```

brew cleanup

```

**Issues**

```

brew doctor

````

# Node@18

- Installation

```sh
brew install node@18
brew postinstall node@18
brew link --overwrite node@18
brew link --force node@18
````

```sh
If you need to have node@18 first in your PATH, run:
  echo 'export PATH="/home/linuxbrew/.linuxbrew/opt/node@18/bin:$PATH"' >> ~/.zshrc

For compilers to find node@18 you may need to set:
  export LDFLAGS="-L/home/linuxbrew/.linuxbrew/opt/node@18/lib"
  export CPPFLAGS="-I/home/linuxbrew/.linuxbrew/opt/node@18/include"
```

- Check

```sh
node -v
npm -v
```

# Python

```shell
==> python@3.10
Python has been installed as
  /home/linuxbrew/.linuxbrew/opt/python@3.10/bin/python3

Unversioned symlinks `python`, `python-config`, `pip` etc. pointing to
`python3`, `python3-config`, `pip3` etc., respectively, have been installed into
  /home/linuxbrew/.linuxbrew/opt/python@3.10/libexec/bin

You can install Python packages with
  /home/linuxbrew/.linuxbrew/opt/python@3.10/bin/pip3 install <package>
They will install into the site-package directory
  /home/linuxbrew/.linuxbrew/lib/python3.10/site-packages

tkinter is no longer included with this formula, but it is available separately:
  brew install python-tk@3.10

See: https://docs.brew.sh/Homebrew-and-Python

python@3.10 is keg-only, which means it was not symlinked into /home/linuxbrew/.linuxbrew,
because this is an alternate version of another formula.

If you need to have python@3.10 first in your PATH, run:
  echo 'export PATH="/home/linuxbrew/.linuxbrew/opt/python@3.10/bin:$PATH"' >> ~/.zshrc

For compilers to find python@3.10 you may need to set:
  export LDFLAGS="-L/home/linuxbrew/.linuxbrew/opt/python@3.10/lib"
  export CPPFLAGS="-I/home/linuxbrew/.linuxbrew/opt/python@3.10/include"
```

## Pylint

- `pylint --generate-rcfile > $HOME/.pylintrc`

# Starship

- zsh completions have been installed to:
  - /home/linuxbrew/.linuxbrew/share/zsh/site-functions
