# Table of Contents

- [Table of Contents](#table-of-contents)
- [TypeScript Basics](#typescript-basics)
- [Installation](#installation)
  - [Compilation](#compilation)
  - [Setup](#setup)

# TypeScript Basics

# Installation

```sh
npm install -g typescript
```

## Compilation

TypeScript is ONLY for coding

TypeScript needs to be compiled into JavaScript into order to be run/ran

```sh
# This will compile fileName.ts into fileName.js
tsc fileName.ts

# Run with
node fileName.js
```

## Setup

```sh
npm install --save-dev lite-server
```

Change package.json

```json
{
  "name": "understanding-ts",
  "version": "1.0.0",
  "description": "",
  "main": "app.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "start": "lite-server" // <-- HER
  },
  "author": "s3same",
  "license": "ISC",
  "devDependencies": {
    "lite-server": "^2.5.4"
  }
}
```
