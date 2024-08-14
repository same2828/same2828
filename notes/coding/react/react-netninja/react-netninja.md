# Table of Contents

- [Table of Contents](#table-of-contents)
- [Course Files](#course-files)
- [React Notes](#react-notes)
  - [React 18 Changes](#react-18-changes)
  - [Import/Export](#importexport)
    - [Default Export](#default-export)
    - [Named Export](#named-export)
    - [Default + Named Export](#default--named-export)
  - [Callback Functions](#callback-functions)
  - [Cleanup Functions](#cleanup-functions)
- [JavaScript Notes](#javascript-notes)
  - [Primitive Types](#primitive-types)
  - [Rules](#rules)
  - [Callback Functions](#callback-functions-1)
  - [Spread Syntax `...`](#spread-syntax-)
    - [Objects](#objects)
    - [Arrays](#arrays)
- [Frontend Dev Tips/Tricks](#frontend-dev-tipstricks)
  - [`console.log` Debugging](#consolelog-debugging)
- [HTML Notes](#html-notes)
- [CSS Notes](#css-notes)
  - [Info](#info)
  - [Main Axis](#main-axis)
  - [Cross Axis](#cross-axis)
  - [Flexbox](#flexbox)
    - [`justify-content`](#justify-content)
    - [`align-items`](#align-items)
    - [`align-content`](#align-content)

# Course Files

https://github.com/iamshaunjp/React-Firebase

# React Notes

## React 18 Changes

Note that also the file index.js needs to be changed a bit. For React 17 it looks like

```jsx
// React17
import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';

ReactDOM.render(<App />, document.getElementById('root')); /* <-- HERE */
```

```jsx
// React18
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

ReactDOM.createRoot(document.getElementById('root')).render(<App />); /* <-- HERE */
```

## Import/Export

### Default Export

> `import MyComponent from file.js`
>
> Note: For DEFAULT exports, this is INVALID `import { MyComponent } from fileName.jsx`
>
> Note: Can only have ONE default export per file

V1

```jsx
export default MyComponent() {
  return (
    //...
  );
}
```

V2

```jsx
const MyComponent = () => {
  return (
    //...
  );
};

export default MyComponent;
```

### Named Export

> `import {Component1, Component 2} from file.js`

V1

```jsx
export function Component1() {
  return (
    //...
  );
}


export const Component2 = () => {
  return (
    //...
  );
};
```

V2

```jsx
function Component1() {
  return (
    //...
  );
}


const Component2 = () => {
  return (
    //...
  );
};

export { Component1, Component2 };
```

### Default + Named Export

> `import DefaultComponent, { Component2 } from './file.js'`
> Note: When a component is 'default' exported (i.e. `export default MyComponent`), you import it as `import MyComponent from fileName.js` and do NOT use `import { MyComponent } from fileName.js`

Button.jsx

```jsx

// Default export
export default function DefaultComponent() {
  return (
    //...
  );
}

// Named export
export const Component2 = () => {
  return (
    //...
  );
};
```

App.jsx

```jsx
import DefaultComponent, { Component2 } from './Buttons.js';
export default function App() {
  return (
    <div>
      <DefaultComponent />
      <Component2 />
    </div>
  );
}
```

## Callback Functions

In React, a callback function is a function that is passed as a prop to a component and is executed inside the component at a later time.

Callback functions are often used in React to update the state of a parent component from a child component, or to trigger an action in the parent component based on some event that occurs in the child.

Here is an example of a callback function in a React component:

```jsx
import React, { useState } from 'react';

function ParentComponent() {
  const [count, setCount] = useState(0);

  const incrementCount = () => {
    setCount(count + 1);
  };

  return <ChildComponent onClickProp={incrementCount} />;
}

function ChildComponent({ onClickProp }) {
  return <button onClick={onClickProp}>Click me to increment the count!</button>;
}
```

- In this example, the `ParentComponent` has a state variable `count` that is initialized to 0
- It also has a function `incrementCount()` that increments the value of `count` by 1
- The `ParentComponent` renders a `ChildComponent` and passes the `incrementCount` function as a prop called `onClickProp`
- When the button in the `ChildComponent` is clicked, the `onClickProp` prop (which is the `incrementCount()` function) is called, and the value of `count` in the `ParentComponent` is incremented
- This allows the `ChildComponent` to update the state of the `ParentComponent` without directly modifying the state itself

Callback functions are often used to perform asynchronous operations, such as making a network request or reading from a file

- In these cases, the callback function is executed once the operation has completed, allowing the program to continue running while the operation is being performed in the background

## Cleanup Functions

The cleanup function is a function that is RETURNED by `useEffect` hook

The cleanup functions runs:

- When a component unmounts
- After each re-render
  - After every re-render with changed dependencies, React will first run the cleanup function with the old values/props

The `useEffect` Hook is built in a way that we can return a function inside it and this return function is where the cleanup happens

- Note: the `useEffect` cleanup function does not only run when our component wants to unmount, it also runs right before the next rerender

```jsx
import { useEffect } from 'react';

useEffect(() => {
  // Effect
  return () => {
    // Cleanup
  };
}, [dependencies]);
```

# JavaScript Notes

## Primitive Types

```ts
let var1: boolean = false;
let var2: number = 4096;
let var3: string = 'hello world';
let var4: null = null;
let var5: undefined = undefined;
let var6: bigint = BigInt(9007199254740991); // let var6: bigint = BigInt("9007199254740991"); // let var6: bigint = 9007199254740991n;
let var7: symbol = Symbol('var7');
let var8: any = 'string';
```

Note: Note: When calling `.map()`, remember you can always add `index` as parameter

```jsx
const fruits = ['apple', 'banana', 'orange', 'pear'];

fruits.map((fruit, index) => {
  console.log(`${index + 1}: ${fruit}`);
});

['1: apple', '2: banana', '3: orange', '4: pear'];

// const fruitsList = fruits.map((fruit, index) => {
//   return `${index + 1}: ${fruit}`;
// });
// console.log(fruitsList);
```

## Rules

Note: The `-` character is NOT allowed in Javascript dot notation format

```js
// INVALID
className={styles.login-form}
// Valid
className={styles['login-form']}
```

## Callback Functions

A callback function is a function passed into another function as an argument, which is then invoked inside the outer function

Example:

```ts
function greeting(name: string) {
  console.log(`Hello, ${name}!`);
}

function processUserInput(callbackFn: (name: string) => void) {
  const name = prompt('Please enter your name.');
  callbackFn(name);
}

processUserInput(greeting);
```

```js
function greeting(name) {
  console.log(`Hello, ${name}!`);
}

function processUserInput(callbackFn) {
  const name = prompt('Please enter your name.');
  callbackFn(name);
}

processUserInput(greeting);
```

## Spread Syntax `...`

### Objects

```js
oldObject = { brand: 'Porsche', model: '911', color: 'white' };
newObject = { ...oldObject, transmission: 'Automatic' };
```

### Arrays

```jsx
const sum = (a, b, c) => {
  return a + b + c;
};
let nums = [1, 2, 3];
console.log(sum(...nums));
```

```js
const greeting = (s1, s2, s3) => {
  console.log(s1 + " " + s2 + " " + s3);
}
let info = ["Hello", "Eric" "Cartman"];
greeting(...info);
```

# Frontend Dev Tips/Tricks

## `console.log` Debugging

> Always use `,` instead of `+` when using `console.log()`

Always tests object returned by a function call with `console.log()`

# HTML Notes

- `<button>` elements have `type="submit"` by DEFAULT
  - This means that when `<button>` elements are placed inside `<form></form>` and are clicked, the form will be submitted
  - Change `type="button"` to prevent this or use `e.preventDefault()` on the event
  - [Read more](https://html.spec.whatwg.org/multipage/form-elements.html#attr-button-type)

# CSS Notes

## Info

- `color` == Text Color
- `background` == Background Color
- Order items horizontally instead of vertically: `display: flex; flex-direction: row`
- `margin: top right bottom left`
- Put an element on the left: `margin-right: auto;`
- Do NOT need `htmlFor=""` if we surround <input/> in a <label></label>

## Main Axis

- Used for `justify-content`

![](https://developer.mozilla.org/en-US/docs/Glossary/Main_Axis/basics1.png)
![](https://developer.mozilla.org/en-US/docs/Glossary/Main_Axis/basics2.png)

## Cross Axis

- Used for `align-items`

![](https://developer.mozilla.org/en-US/docs/Glossary/Cross_Axis/basics3.png)
![](https://developer.mozilla.org/en-US/docs/Glossary/Cross_Axis/basics4.png)

## Flexbox

### `justify-content`

> The justify-content property sets the alignment of the flex items along the main axis of each flex line
>
> [MDN Docs](https://developer.mozilla.org/en-US/docs/Web/CSS/justify-content)

Grey == Blank Space

![](https://i.sstatic.net/7SGnT.png)

### `align-items`

> The align-items property sets the default alignment of the flex items along the cross axis of each flex line (perpendicular to the main-axis)
>
> align-items = the justify-content version for the cross-axis (perpendicular to the main-axis)

![](https://i.sstatic.net/WiA2e.png)

### `align-content`

> The align-content property only applies to multi-line flex containers, and aligns the flex lines within the flex container when there is extra space in the cross-axis.

![](https://i.sstatic.net/cbZom.png)
