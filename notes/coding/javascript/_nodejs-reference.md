# Table of Contents

- [Table of Contents](#table-of-contents)
- [NodeJS Built-in Modules](#nodejs-built-in-modules)
- [File System (fs)](#file-system-fs)
  - [Callback API](#callback-api)

# NodeJS Built-in Modules

| Module           | Description                                                |
| ---------------- | ---------------------------------------------------------- |
| `assert`         | Provides a set of assertion tests                          |
| `buffer`         | To handle binary data                                      |
| `child_process`  | To run a child process                                     |
| `cluster`        | To split a single Node process into multiple processes     |
| `crypto`         | To handle OpenSSL cryptographic functions                  |
| `dgram`          | Provides implementation of UDP datagram sockets            |
| `dns`            | To do DNS lookups and name resolution functions            |
| `domain`         | Deprecated. To handle unhandled errors                     |
| `events`         | To handle events                                           |
| `fs`             | To handle the file system                                  |
| `http`           | To make Node.js act as an HTTP server                      |
| `https`          | To make Node.js act as an HTTPS server.                    |
| `net`            | To create servers and clients                              |
| `os`             | Provides information about the operation system            |
| `path`           | To handle file paths                                       |
| `punycode`       | Deprecated. A character encoding scheme                    |
| `querystring`    | To handle URL query strings                                |
| `readline`       | To handle readable streams one line at the time            |
| `stream`         | To handle streaming data                                   |
| `string_decoder` | To decode buffer objects into strings                      |
| `timers`         | To execute a function after a given number of milliseconds |
| `tls`            | To implement TLS and SSL protocols                         |
| `tty`            | Provides classes used by a text terminal                   |
| `url`            | To parse URL strings                                       |
| `util`           | To access utility functions                                |
| `v8`             | To access information about V8 (the JavaScript engine)     |
| `vm`             | To compile JavaScript code in a virtual machine            |
| `zlib`           | To compress or decompress files                            |

# File System (fs)

- `const fs = require('fs')`
- NO need to install `fs` module (built into NodeJS)
- All the methods are asynchronous by default, but they can also work synchronously by appending `Sync`
  - E.g.
    - `fs.rename()` -> `fs.renameSync()`
    - `fs.write()` -> `fs.writeSync()`
- Resources
  - https://github.com/nodejs/nodejs.dev/blob/aa4239e87a5adc992fdb709c20aebb5f6da77f86/content/learn/node-js-modules/node-module-fs.en.md
  - https://nodejs.org/api/fs.html#fs_fs_promises_api

## Callback API

| Method                   | Description                                                                                              |
| ------------------------ | -------------------------------------------------------------------------------------------------------- |
| `fs.access()`            | Check if the file exists and Node.js can access it with its permissions                                  |
| `fs.appendFile()`        | Append data to a file. If the file does not exist, it's created                                          |
| `fs.chmod()`             | Change the permissions of a file specified by the filename passed. Related: fs.lchmod(), fs.fchmod()     |
| `fs.chown()`             | Change the owner and group of a file specified by the filename passed. Related: fs.fchown(), fs.lchown() |
| `fs.close()`             | Close a file descriptor                                                                                  |
| `fs.copyFile()`          | Copies a file                                                                                            |
| `fs.createReadStream()`  | Create a readable file stream                                                                            |
| `fs.createWriteStream()` | Create a writable file stream                                                                            |
| `fs.link()`              | Create a new hard link to a file                                                                         |
| `fs.mkdir()`             | Create a new folder                                                                                      |
| `fs.mkdtemp()`           | Create a temporary directory                                                                             |
| `fs.open()`              | Opens the file and returns a file descriptor to allow file manipulation                                  |
| `fs.readdir()`           | Read the contents of a directory                                                                         |
| `fs.readFile()`          | Read the content of a file. Related: fs.read()                                                           |
| `fs.readlink()`          | Read the value of a symbolic link                                                                        |
| `fs.realpath()`          | Resolve relative file path pointers (., ..) to the full path                                             |
| `fs.rename()`            | Rename a file or folder                                                                                  |
| `fs.rmdir()`             | Remove a folder                                                                                          |
| `fs.stat()`              | Returns the status of the file identified by the filename passed. Related: fs.fstat(), fs.lstat()        |
| `fs.symlink()`           | Create a new symbolic link to a file                                                                     |
| `fs.truncate()`          | Truncate to the specified length the file identified by the filename passed. Related: fs.ftruncate()     |
| `fs.unlink()`            | Remove a file or a symbolic link                                                                         |
| `fs.unwatchFile()`       | Stop watching for changes on a file                                                                      |
| `fs.utimes()`            | Change the timestamp of the file identified by the filename passed. Related: fs.futimes()                |
| `fs.watchFile()`         | Start watching for changes on a file. Related: fs.watch()                                                |
| `fs.writeFile()`         | Write data to a file. Related: fs.write()                                                                |
