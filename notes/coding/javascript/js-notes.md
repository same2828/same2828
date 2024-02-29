# Table of Contents

- [Table of Contents](#table-of-contents)
  - [Convert `number` to `string`](#convert-number-to-string)
  - [Convert `string` to `number`](#convert-string-to-number)
- [Debugging (`console.log()`)](#debugging-consolelog)
- [Deep Copy](#deep-copy)
- [Expressions + Operators](#expressions--operators)
  - [Destructuring](#destructuring)
  - [Logical AND Operator (`&&`)](#logical-and-operator-)
  - [Optional chaining (`?.`)](#optional-chaining-)
  - [Nullish Coalescing Operator (`??`)](#nullish-coalescing-operator-)
- [For Loops](#for-loops)
- [Function](#function)
  - [Version 1](#version-1)
  - [Version 2](#version-2)
  - [Function within Function](#function-within-function)
- [JSON](#json)
- [`Math.random()`](#mathrandom)
- [Numeric Separator](#numeric-separator)
- [Shuffle Array](#shuffle-array)
  - [Durstenfeld Shuffle](#durstenfeld-shuffle)
  - [Quick \& Easy](#quick--easy)
- [Strings](#strings)
- [Truthy/Falsy Values](#truthyfalsy-values)
  - [Truthy](#truthy)
  - [Falsy](#falsy)
- [Vanilla JS + DOM](#vanilla-js--dom)
  - [Adding/Removing Classes and Setting Style](#addingremoving-classes-and-setting-style)
  - [document](#document)
    - [document.getElementsByClassName() / document.getElementsByTagName()](#documentgetelementsbyclassname--documentgetelementsbytagname)
    - [document.getElementById() and cloning](#documentgetelementbyid-and-cloning)
    - [document.querySelector()](#documentqueryselector)

## Convert `number` to `string`

```js
let num = 123;
let str = num.toString();
```

## Convert `string` to `number`

```js
let str = '123';
let num = parseInt(str);
```

# Debugging (`console.log()`)

Do NOT concatenate variables/values using `+`

Use `,` instead

```js
let var1 = 'hello world';
let var2 = [
  { name: 'mario', id: 11 },
  { name: 'peach', id: 25 },
  { name: 'yoshi', id: 99 },
];

console.log(var1 + var2);
// hello world[object Object],[object Object],[object Object]
console.log(var1, var2);
// hello world [ { name: 'mario', id: 11 }, { name: 'peach', id: 25 }, { name: 'yoshi', id: 99 } ]
```

# Deep Copy

**INVALID** (only shallow copies)

- Nested objects are NOT copied but reference original object's nested object

```js
const p1 = { firstName: 'Eric', lastName: 'Cartman', address: { city: 'Colarado', country: 'USA' } };
const p2 = { ...p1, firstName: 'Stan', lastName: 'Marsh' };
```

**VALID**

```js
const p1 = { firstName: 'Eric', lastName: 'Cartman', address: { city: 'Colarado', country: 'USA' } };
const p2 = JSON.parse(JSON.stringify(p1));
p2.firstName = 'Stan';
p2.lastName = 'Marsh';
```

# Expressions + Operators

## Destructuring

The destructuring assignment syntax is a JavaScript expression that makes it possible to unpack values from arrays, or properties from objects, into distinct variables.

[Mozilla Docs](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment)

```js
const [a, b] = array;
const [a, , b] = array;
const [a = aDefault, b] = array;
const [a, b, ...rest] = array;
const [a, , b, ...rest] = array;
const [a, b, ...{ pop, push }] = array;
const [a, b, ...[c, d]] = array;

const { a, b } = obj;
const { a: a1, b: b1 } = obj;
const { a: a1 = aDefault, b = bDefault } = obj;
const { a, b, ...rest } = obj;
const { a: a1, b: b1, ...rest } = obj;
const { [key]: a } = obj;
```

## Logical AND Operator (`&&`)

The Logical AND Operator (`&&`) returns the value of the **first falsy** operand encountered when evaluating from left to right, or the value of the **last** operand if they are all **truthy**

[Mozilla Docs](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Logical_AND)

If the FIRST operand is **truthy**, the logical AND operator (`&&`) **returns the SECOND operand**:

```js
let var1 = true && 'dog';
// var1 = "dog"

let var2 = [] && 999;
// var2 = 999
```

If the FIRST operand is **falsy**, the logical AND operator (`&&`) **returns the FIRST operand**:

```js
let var1 = false && 'dog';
// var1 = false

let var2 = 0 && 'dog';
// var2 = 0
```

- Note: All values are **"truthy** except for:
  - `false`
  - `0`
  - `-0`
  - `0n`
  - `""`
  - `null`
  - `undefined`
  - `NaN`
  - `document.all`
- Note: This means EMPTY arrays/objects, `"false"`, `"0"` are considered **truthy**

## Optional chaining (`?.`)

The optional chaining (`?.`) operator accesses an object's property or calls a function.
If the object accessed or function called using this operator is `undefined` or `null`,
the expression short circuits and evaluates to `undefined` instead of throwing an error.

[Mozilla Docs](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining)

## Nullish Coalescing Operator (`??`)

The nullish coalescing (`??`) operator is a logical operator that returns its RIGHT-hand side operand when its LEFT-hand side operand is `null` or `undefined`, and otherwise returns its LEFT-hand side operand.

[Mozilla Docs](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Nullish_coalescing)

```js
const var1 = null ?? 'hello world';
console.log(var1);
// 'hello world'

const var2 = 0 ?? 123;
console.log(var2);
// 0

const var3 = undefined ?? { name: 'mario', id: 99 };
console.log(var3);
// { name: "mario", id: 99 }
```

# For Loops

- `for...in` iterates over all enumerable property **keys** of an object
- `for...of` iterates over the **values** of an iterable object.
  - Examples of iterable objects are arrays, strings, and NodeLists.

```js
let list = [4, 5, 6];

// Index
for (let i in list) {
  console.log(i); // "0", "1", "2",
}

// Element
for (let i of list) {
  console.log(i); // "4", "5", "6"
}
```

# Function

## Version 1

```js
function myFunc(num1, num2) {
  //...
}
```

## Version 2

```js
const myFunc = (num1, num2) => {
  //...
};
```

## Function within Function

```js
const minCameraCover = (root) => {
  let result = 0;
  // 0 = NOT_MONITORED
  // 1 = MONITORED_NOCAM
  // 2 = MONITORED_WITHCAM

  const dfs = (currNode) => {
    if (!currNode) {
      return 1;
    }

    let l = dfs(currNode.left);
    let r = dfs(currNode.right);

    if (l === 1 && r === 1) {
      return 0;
    } else if (l === 0 || r === 0) {
      result++;
      return 2;
    } else {
      // l === 2 || r === 2
      return 1;
    }
  };

  return dfs(root) === 0 ? result + 1 : result;
};
```

# JSON

- `JSON.stringify()` = JavaScript Object -> JSON String
- `JSON.parse()` = JSON String -> JavaScript Object
- `response.json()` = Response (JSON) -> JavaScript Object

# `Math.random()`

Returns random number **`>= 0 && < 1`**

Note: Use `Math.floor()` to turn generated random number into integer after applying numeric operations (multiplication, addition)

```js
// Generate number in range [0, 900_000_000) and add 100_000_000 to ENSURE final value is in range [100_000_000, 999_999_999]
// Note: Largest number generated is 899_999_999.999999 (and adding 100_000_000 gives 999_999_999.999999)
const id = Math.floor(Math.random() * 900_000_000 + 100_000_000);
```

# Numeric Separator

Use `_`

```js
let mod = 1_000_000_007;
```

# Shuffle Array

- [Fisher-Yates Shuffle Wikipedia](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle)
- [Durstenfeld Shuffle Wikipedia](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm)

## Durstenfeld Shuffle

- Multiply this by `(i + 1)` to scale the range of possible results to `[0, i+1)` (which is required range specified by algorithm)

```js
const shuffle = (a) => {
  for (let i = a.length - 1; i > 0; i--) {
    let j = Math.floor(Math.random() * (i + 1)); // 0 <= j <= i
    [a[i], a[j]] = [a[j], a[i]];
    // let temp = a[i];
    // a[i] = a[j];
    // a[j] = temp;
  }
  return a;
};
```

- Multiply this by `(a.length - i)` to scale the range of possible results to `[0, a.length - i)`

```js
const shuffle = (a) => {
  for (let i = 0; i < a.length - 1; i++) {
    const j = i + Math.floor(Math.random() * (a.length - i)); // i <= j < n
    [a[i], a[j]] = [a[j], a[i]];
    // let temp = a[i];
    // a[i] = a[j];
    // a[j] = temp;
  }
  return a;
};
```

## Quick & Easy

```js
const shuffle = (a) => {
  // Math.random() returns num >= 0 && < 1;
  a.sort(() => Math.random() - 0.5);
  return a;
};
```

# Strings

Backticks (\`) allow for template literals which allow javascript expressions to be embedded into the string by wrapping it in `${}` and also for strings to span multiple lines

```js
// Version 1
let single = 'single-quoted';
// Version 2
let double = 'double-quoted';
// Version 3
let backticks = `backticks`;

let name = 'peach';
let age = 18;
let varStr = `${name} is ${age} years old`;
console.log(varStr);
```

# Truthy/Falsy Values

## Truthy

All values are **"truthy"** except for

- `false`
- `null`
- `undefined`
- `""`
- `0`
- `-0`
- `0n`
- `NaN`
- `document.all`

Note: This means EMPTY arrays/objects, the strings `"false"` and `"0"` are considered **truthy**

## Falsy

| Value          | Type      | Description                                                                                                      |
| -------------- | --------- | ---------------------------------------------------------------------------------------------------------------- |
| `null`         | Null      | null = The absence of any value                                                                                  |
| `undefined`    | Undefined | undefined = The primitive/unassigned value                                                                       |
| `false`        | Boolean   | The keyword false                                                                                                |
| `NaN`          | Number    | NaN — not a number                                                                                               |
| `0`            | Number    | The Number zero, also including 0.0, 0x0, etc                                                                    |
| `-0`           | Number    | The Number negative zero, also including -0.0, -0x0, etc                                                         |
| `0n`           | BigInt    | The BigInt zero, also including 0x0n, etc. Note that there is no BigInt negative zero — the negation of 0n is 0n |
| `""`           | String    | Empty string value, also including '' and ``                                                                     |
| `document.all` | Object    | The only falsy object in JavaScript is the built-in document.all                                                 |

# Vanilla JS + DOM

## Adding/Removing Classes and Setting Style

Use `.innerText` instead of `.innerHTML`

```javascript
const element = document.querySelector('#elementID');
const subElement = element.querySelector('.subElement');

element.innerText = 'Hello';
// If element is a form elements like <input>, <textarea>, <select>
element.value = 'Hello';

element.setAttribute('id', 'btn-login');
element.removeAttribute('id');

element.classList.add('class1');
element.classList.remove('class2');
element.classList.toggle('valid');
element.classList.replace('oldClass', 'newClass');

element.style.display = 'flex';
element.style.display = 'none';
element.style.backgroundColor = '#FFFFFF';
```

## document

### document.getElementsByClassName() / document.getElementsByTagName()

```javascript
document.getElementById('id');

document.getElementsByClassName('class1');
// class1 AND class2
document.getElementsByClassName('class1 class2');
element.getElementsByClassName('class1 class2');

document.getElementsByTagName('p');
element.getElementsByTagName('div');
```

### document.getElementById() and cloning

```javascript
const newError = document.getElementById('template-errorAlert').cloneNode(true);

const ctnr = document.getElementById('container-main');
ctnr.appendChild(newError);
```

### document.querySelector()

```javascript
document.querySelector('#id');
// First instance
document.querySelector('.class1');
// All instances
const allMatches = document.querySelectorAll('.class1');
for (let match of allMatches) {
  // ...
}
const firstMatch = document.querySelectorAll('.class1')[0];
// class1 AND class2
document.querySelector('.class1.class2');
document.querySelectorAll('.class1.class2');
// class1 OR class2
document.querySelector('.class1, .class2');
document.querySelectorAll('.class1, .class2');

document.querySelector('input[type='checkbox']');
document.querySelectorAll('input[type='checkbox']');
```
