# Table of Contents

- [Table of Contents](#table-of-contents)
- [GitHub Pages](#github-pages)
  - [Add `gh-pages` package as dev dependency](#add-gh-pages-package-as-dev-dependency)
  - [Modify `package.json`](#modify-packagejson)
  - [Make changes and push as usual](#make-changes-and-push-as-usual)
  - [Deploy](#deploy)

# GitHub Pages

- Note that the repository needs to be PUBLIC (unless you have GitHub Premium)
- Check by going to "Settings" tab -> "Code and automation" tab -> "Pages"
- [Link 1](https://github.com/gitname/react-gh-pages)
- [Link 2](https://create-react-app.dev/docs/deployment/)

## Add `gh-pages` package as dev dependency

```
yarn add gh-pages -D
yarn add gh-pages --dev

npm install gh-pages --save-dev
```

## Modify `package.json`

```diff
{
  "name": "my-app",
  "version": "0.1.0",
+ "homepage": "https://s3same.github.io/repo-name",
  "private": true,
```

```diff
"scripts": {
+   "predeploy": "npm run build",
+   "deploy": "gh-pages -d build",
    "start": "react-scripts start",
    "build": "react-scripts build",
```

- Can also do
  - `"predeploy": "yarn run build",`
- If you wanted to deploy build to `master` branch instead of `gh-pages` branch
  - `"deploy": "gh-pages -b master -d build",`

## Make changes and push as usual

- `gaa && gcmsg 'done' && gp`

## Deploy

```
npm run deploy

yarn run deploy
```
