# Table of Contents

- [Table of Contents](#table-of-contents)
- [Dev Setup](#dev-setup)
  - [Global](#global)
  - [Project](#project)
    - [Initialisation/Creation](#initialisationcreation)
    - [NPM Packages](#npm-packages)
    - [tsconfig.json](#tsconfigjson)
    - [.eslintrc.cjs](#eslintrccjs)
    - [CSS Reset](#css-reset)
- [Dev Tools](#dev-tools)
  - [pnpm](#pnpm)
  - [Vite](#vite)
  - [TailwindCSS](#tailwindcss)
- [CSS = Styling](#css--styling)
- [HTML = Structuring](#html--structuring)
- [JavaScript = Interactivity](#javascript--interactivity)
- [ReactJS](#reactjs)

# Dev Setup

## Global

```sh
# Old
# sudo apt install npm
# sudo npm i -g npx
# yarn global add npm

# Install NodeJS
brew install node@20
# brew postinstall node@20
brew link node@20 --overwrite
# brew unlink node@20 && brew link --force node@20

# Note: Corepack comes preinstalled with NodeJS and you should use the corresponding corepack version that comes with the node version that you choose to brew install
# brew install corepack

# Enable Corepack
corepack enable

# Install & Update pnpm
corepack prepare pnpm@latest --activate

# Install & Update Yarn
corepack prepare yarn@stable --activate

# NPM Global
npm list -g
npm outdated -g
npm update -g

npm install -g vite@latest
npm install -g typescript@latest
npm install -g fkill-cli@latest
```

## Project

### Initialisation/Creation

**yarn**

```sh
# Create New Project
yarn init -2
yarn set version stable
yarn install
yarn run dev
```

**yarn + vite**

```sh
# To create in specific folder
yarn create vite folderName
# To create in current directory folder
yarn create vite .
# Choose either "TypeScript + SWC" or "JavaScript + SWC"

yarn install
yarn run dev
```

**pnpm + vite**

```sh
# To create in specific folder
pnpm create vite folderName
# To create in current directory folder
pnpm create vite .
# Choose either "TypeScript + SWC" or "JavaScript + SWC"

pnpm install
pnpm run dev
```

### NPM Packages

[NPM](https://www.npmjs.com/)

```sh
pnpm add -D @types/react
pnpm add -D vitest
pnpm add react-router
# Tailwind
pnpm add -D tailwindcss postcss autoprefixer
pnpm dlx tailwindcss init -p
```

### tsconfig.json

https://www.totaltypescript.com/tsconfig-cheat-sheet

```json
{
  "compilerOptions": {
    // Base Options
    "esModuleInterop": true,
    "skipLibCheck": true,
    "target": "es2022",
    "allowJs": true,
    "resolveJsonModule": true,
    "moduleDetection": "force",
    "isolatedModules": true,
    // If transpiling with TypeScript
    "moduleResolution": "NodeNext",
    "module": "NodeNext",
    "outDir": "dist",
    "sourceMap": true,
    // If your code runs in the DOM
    "lib": ["es2022", "dom", "dom.iterable"],
    // Vite.js
    "useDefineForClassFields": true,
    "allowImportingTsExtensions": true,
    "noEmit": true,
    "jsx": "react-jsx",
    /* Linting */
    "strict": true,
    "noUncheckedIndexedAccess": true,
    "noUnusedLocals": true,
    "noUnusedParameters": true,
    "noFallthroughCasesInSwitch": true
  },
  "include": ["src"],
  "references": [
    {
      "path": "./tsconfig.node.json"
    }
  ]
}
```

### .eslintrc.cjs

Add `node: true` to `modules.exports.env`

```cjs
module.exports = {
  //...
  env: { browser: true, es2020: true, node: true },
};
```

### CSS Reset

- https://www.joshwcomeau.com/css/custom-css-reset/
- https://andy-bell.co.uk/a-modern-css-reset/
- https://piccalil.li/blog/a-more-modern-css-reset/

```css
/* https://www.joshwcomeau.com/tutorials/css/ */
/* 1. Use a more-intuitive box-sizing model */
*,
*::before,
*::after {
  box-sizing: border-box;
}

/* 2. Remove default margin */
* {
  margin: 0;
}

/*
Typographic tweaks: 3. Add accessible line-height, 4. Improve text rendering
*/
body {
  line-height: 1.5;
  -webkit-font-smoothing: antialiased;
}

/* 5. Improve media defaults */
img,
picture,
video,
canvas,
svg {
  display: block;
  max-width: 100%;
}

/* 6. Remove built-in form typography styles */
input,
button,
textarea,
select {
  font: inherit;
}

/* 7. Avoid text overflows */
p,
h1,
h2,
h3,
h4,
h5,
h6 {
  overflow-wrap: break-word;
}

/* 8. Create a root stacking context */
#root,
#__next {
  isolation: isolate;
}
```

# Dev Tools

## pnpm

```sh
pnpm add <pkg>
pnpm add -D <pkg>

pnpm remove <pkg>

pnpm update

# If you HAVE RAN `pnpm add <pkg>`
pnpm exec cmd
# If you HAVE NOT RAN `pnpm add <pkg>`
pnpm dlx cmd
```

The are 2 key uses of `npx`

- (1) Running executables inside your downloaded packages/dependencies (runs package already in `node_modules/bin`)
  - E.g. `npx jest == pnpm exec jest`
- (2) Running executable commands in packages you want to download transiently (when you want to run a one-off script or command from a package WITHOUT needing to install the package itself)
  - E.g. `npx create-react-app my-app == pnpm dlx create-react-app my-app`

[pnpm Docs](https://pnpm.io/pnpm-cli)

## Vite

```sh
# To create in specific folder
pnpm create vite folderName
# To create in current directory folder
pnpm create vite .

pnpm create vite my-react-ts-app --template react-ts
pnpm create vite my-react-ts-app --template react-swc-ts
```

[Vite Docs](https://vitejs.dev/guide/)

## TailwindCSS

[TailwindCSS Docs](https://tailwindcss.com/docs/guides/vite)

Install TailwindCSS and peer dependencies from NPM

```sh
cd my-project
pnpm add -D tailwindcss postcss autoprefixer
pnpm dlx tailwindcss init -p
```

Add the paths to all of your template files in your `tailwind.config.js` file

```js
/** @type {import('tailwindcss').Config} */
export default {
  content: ['./index.html', './src/**/*.{js,ts,jsx,tsx}'], // <-- HERE
  theme: {
    extend: {},
  },
  plugins: [],
};
```

Add the `@tailwind` directives for each of Tailwind’s layers to your `./src/index.css` file

```css
@tailwind base;
@tailwind components;
@tailwind utilities;
```

Start build process

```sh
pnpm run dev
```

Start using TailwindCSS

```jsx
export default function App() {
  return <h1 className='text-3xl font-bold underline'>Hello world!</h1>;
}
```

# CSS = Styling

- align-items (center, stretch, flex-start, flex-end) (y axis alignment)
- border
- color
- column-gap
- display (flex, block, grid, inline-grid, ...)
- flex (flex-grow, flex-shrink, flex-basis)
- flex-direction
- flex-wrap
- font-family
- gap
- grid-template-areas
- grid-template-columns
- grid-template-rows
- height (%, em, rem, vh, px)
- justify-content (center, space-between, flex-start, flex-end) (x axis alignment)
- margin
- padding
- position (relative, absolute, static, fixed, ...)
- row-gap
- text-alignment
- width (%, em, rem, vw, px)
- top
- left
- transform

```css
.className {
  position: relative;
}

#idName {
  position: absolute;
}
```

# HTML = Structuring

- `class='cntr, darkMode'`
- `id='cntr-links'`

```html
<h1>Heading 1</h1>
<div class="cntr" id="template-message-cntr">Block Container</div>
<span> Inline Block Container </span>
<p>Paragraph</p>
<input />
<label> Label for Input </label>

<ul>
  <li>Unordered List Item 1</li>
  <li>Unordered List Item 2</li>
</ul>
```

- Can include raw CSS in HTML file (or include/import it from external folder)
- Can include raw JavaScript in HTML file (or include/import it from external folder)

# JavaScript = Interactivity

- Manipulate HTML via DOM
  - Use
    - `document.getElementById()`,
    - `document.getElementsByClassName()`,
    - `document.querySelector()`
  - Add eventListeners() to HTML items
  - Clone/Create HTML items (via HTML templates)
  - Hide and Show HTML items (modify HTML item's classes)
  - Set HTML item's class and id attributes
  - Create reusable components (via predefined templates in HTML file)

# ReactJS

- CANNOT use `document.getElementById()`, `document.getElementsByClassName()`, `document.querySelector()`
- Create Reusable Components (via different files and importing them)
- Write HTML in `return()` statement
  - Write JavaScript functions above `return()` statement
- Hooks
  - UI Rendering
    - `useEffect()`
  - State Management
    - `useState()`
- Break into JavaScript using `{}`
- Map over data and return templated components
- `&&` == `return`
- Can push html templates into useState variable
- Can push data/json into useState variable
- Can add eventListeners()
