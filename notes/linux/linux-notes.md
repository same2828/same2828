# Table of Contents

- [Table of Contents](#table-of-contents)
- [Update](#update)
- [Upgrade](#upgrade)
- [Find invalid folder names](#find-invalid-folder-names)

# Update

```
sudo apt update --fix-missing
```

# Upgrade

```
sudo apt upgrade --fix-missing
```

# Find invalid folder names

- `cd github/lc-all`

```
ls | grep -E '^[0-9]+\-'
ls -R | grep -E '^[0-9]+\-'
```
