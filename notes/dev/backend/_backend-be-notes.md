# Table of Contents

- [Table of Contents](#table-of-contents)
- [Basic Authentication](#basic-authentication)
- [CLI Commands](#cli-commands)
  - [`cp`](#cp)
  - [`ls`](#ls)
  - [`where`](#where)
- [SSH](#ssh)
  - [Change User](#change-user)
  - [Copy Local File into Remote SSH Instance](#copy-local-file-into-remote-ssh-instance)
  - [Copy File from Remote SSH Instance into Local Directory](#copy-file-from-remote-ssh-instance-into-local-directory)

# Basic Authentication

Use the following VSCode Extension: `Encode/Decode (Mitch Denny)`

```sh
# String to Base64
Authorization: Basic username:password
Authorization: Basic postgres:pwd

# Base64 to String
Authorization: Basic cG9zdGdyZXM6cHdk
```

# CLI Commands

## `cp`

```sh
# Copy file to current working directory
cd targetSrcDirectory
cp /path/to/srcFile ./
```

## `ls`

```sh
# Oldest files appear at TOP
ls -ltr
# Newest files appear at TOP
ls -lt
```

## `where`

```sh
where jmeter
```

# SSH

```sh
ssh <ip_address>
ssh <ip_address> -l <user_name>
```

## Change User

```sh
sudo su - root
sudo su - userToChangeTo
```

## Copy Local File into Remote SSH Instance

```sh
scp /path/to/local/file user@remote-host-ip:/path/to/remote/directory
# scp /path/to/local/file user@192.168.1.100:/path/to/remote/directory
# scp /path/to/local/file user@example.com:/path/to/remote/directory
```

## Copy File from Remote SSH Instance into Local Directory

```sh
scp user@remote-ip-host:/path/to/remote/file /path/to/local/directory
# scp user@192.168.1.100:/path/to/remote/directory /path/to/local/directory
# scp user@example.com:/path/to/remote/directory /path/to/local/directory
```
