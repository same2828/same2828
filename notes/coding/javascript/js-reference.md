# Table of Contents

- [Table of Contents](#table-of-contents)
- [`null` vs `undefined`](#null-vs-undefined)
- [Array](#array)
  - [Array Methods and Properties](#array-methods-and-properties)
  - [Mutating vs Non-Mutating Array Methods](#mutating-vs-non-mutating-array-methods)
    - [Add](#add)
    - [Remove](#remove)
    - [Replace](#replace)
- [Boolean](#boolean)
  - [Boolean Methods and Properties](#boolean-methods-and-properties)
- [Class](#class)
  - [Class Methods](#class-methods)
  - [Class Keywords](#class-keywords)
- [Date](#date)
  - [Date Methods and Properties](#date-methods-and-properties)
- [Error](#error)
  - [Error Object Properties](#error-object-properties)
  - [Error Names](#error-names)
- [Expressions + Operators](#expressions--operators)
  - [Destructuring](#destructuring)
  - [Logical AND Operator (`&&`)](#logical-and-operator-)
  - [Optional chaining (`?.`)](#optional-chaining-)
  - [Nullish Coalescing Operator (`??`)](#nullish-coalescing-operator-)
- [Function](#function)
  - [Version 1](#version-1)
  - [Version 2](#version-2)
  - [Function within Function](#function-within-function)
- [Global](#global)
  - [Global Methods](#global-methods)
  - [Global Properties](#global-properties)
- [JSON](#json)
  - [JSON Methods](#json-methods)
  - [Valid Data Types](#valid-data-types)
- [Math](#math)
  - [`Math` Object Methods and Properties](#math-object-methods-and-properties)
  - [`Math.random()`](#mathrandom)
- [Number](#number)
  - [Number Methods](#number-methods)
  - [Number Properties](#number-properties)
  - [Numeric Separator](#numeric-separator)
- [Operators](#operators)
  - [Arithmetic Operators](#arithmetic-operators)
  - [Assignment Operators](#assignment-operators)
  - [String Operators](#string-operators)
  - [Comparison Operators](#comparison-operators)
  - [Conditional (Ternary) Operator](#conditional-ternary-operator)
  - [Logical Operators](#logical-operators)
  - [Bitwise Operators](#bitwise-operators)
  - [`delete` Operator](#delete-operator)
  - [`in` Operator](#in-operator)
  - [`instanceof` Operator](#instanceof-operator)
  - [`typeof` Operator](#typeof-operator)
  - [`void` Operator](#void-operator)
- [Regex](#regex)
- [Statements](#statements)
  - [Statement Identifiers](#statement-identifiers)
- [String](#string)
  - [String Methods](#string-methods)
  - [String Properties](#string-properties)
- [Truthy/Falsy Values](#truthyfalsy-values)
  - [Truthy Values](#truthy-values)
  - [Falsy Values](#falsy-values)
- [Vanilla JS + DOM](#vanilla-js--dom)
  - [Adding/Removing Classes and Setting Style](#addingremoving-classes-and-setting-style)
  - [document](#document)
    - [document.getElementsByClassName() / document.getElementsByTagName()](#documentgetelementsbyclassname--documentgetelementsbytagname)
    - [document.getElementById() and cloning](#documentgetelementbyid-and-cloning)
    - [document.querySelector()](#documentqueryselector)
- [Miscellaneous](#miscellaneous)
  - [.forEach(), .map() indexing](#foreach-map-indexing)
  - [Convert `number` to `string`](#convert-number-to-string)
  - [Convert `string` to `number`](#convert-string-to-number)
  - [Debugging (`console.log()`)](#debugging-consolelog)
  - [Deep Copy](#deep-copy)
  - [Shuffle Array](#shuffle-array)
    - [Durstenfeld Shuffle](#durstenfeld-shuffle)
    - [Quick \& Easy](#quick--easy)

# `null` vs `undefined`

`null` == Absence of any value
`undefined` == Unassigned value

![](images/null-vs-undefined.png)

# Array

```js
let brands = ['Porsche', 'Toyota', 'Lexus'];
// const brands = ['Porsche', 'Toyota', 'Lexus'];
```

[Read more](https://www.w3schools.com/jsref/jsref_obj_array.asp)

## Array Methods and Properties

| Method              | Description                                                                      |
| ------------------- | -------------------------------------------------------------------------------- |
| `.concat()`         | Joins arrays and returns an array with the joined arrays                         |
| `.constructor`      | Returns the function that created the Array object's prototype                   |
| `.copyWithin()`     | Copies array elements within the array, to and from specified positions          |
| `.entries()`        | Returns a key/value pair Array Iteration Object                                  |
| `.every()`          | Checks if every element in an array pass a test                                  |
| `.fill()`           | Fill the elements in an array with a static value                                |
| `.filter()`         | Creates a new array with every element in an array that pass a test              |
| `.find()`           | Returns the value of the first element in an array that pass a test              |
| `.findIndex()`      | Returns the index of the first element in an array that pass a test              |
| `.forEach()`        | Calls a function for each array element                                          |
| `.from()`           | Creates an array from an object                                                  |
| `.includes()`       | Check if an array contains the specified element                                 |
| `.indexOf()`        | Search the array for an element and returns its position                         |
| `.isArray()`        | Checks whether an object is an array                                             |
| `.join()`           | Joins all elements of an array into a string                                     |
| `.keys()`           | Returns a Array Iteration Object, containing the keys of the original array      |
| `.lastIndexOf()`    | Search the array for an element, starting at the end, and returns its position   |
| `.length Sets`      | or returns the number of elements in an array                                    |
| `.map()`            | Creates a new array with the result of calling a function for each array element |
| `.pop()`            | Removes the last element of an array, and returns that element                   |
| `.prototype Allows` | you to add properties and methods to an Array object                             |
| `.push()`           | Adds new elements to the end of an array, and returns the new length             |
| `.reduce()`         | Reduce the values of an array to a single value (going left-to-right)            |
| `.reduceRight()`    | Reduce the values of an array to a single value (going right-to-left)            |
| `.reverse()`        | Reverses the order of the elements in an array                                   |
| `.shift()`          | Removes the first element of an array, and returns that element                  |
| `.slice()`          | Selects a part of an array, and returns the new array                            |
| `.some()`           | Checks if any of the elements in an array pass a test                            |
| `.sort()`           | Sorts the elements of an array                                                   |
| `.splice()`         | Adds/Removes elements from an array                                              |
| `.toString()`       | Converts an array to a string, and returns the result                            |
| `.unshift()`        | Adds new elements to the beginning of an array, and returns the new length       |
| `.valueOf()`        | Returns the primitive value of an array                                          |

## Mutating vs Non-Mutating Array Methods

**Mutating**

- `Array.splice()` DOES mutate the original array
- `Array.forEach()` executes a provided function once per array element

**NON-Mutating**

- `Array.slice()` does NOT mutate the original array and returns NOTHING
- `Array.map()` creates and returns a new array with the results of calling a provided function on every element in the array

[Read more](http://web.archive.org/web/20211101150139/https://lorenstewart.me/2017/01/22/javascript-array-methods-mutating-vs-non-mutating/)

### Add

```js
// Mutating
let a = ['a', 'b', 'c', 'd', 'e'];

a.push('f'); // ['a', 'b', 'c', 'd', 'e', 'f']
a.unshift('z'); // ['z', 'a', 'b', 'c', 'd', 'e', 'f']

// Non-Mutating
const a = ['a', 'b', 'c', 'd', 'e'];
const b = a.concat('f'); // ['a', 'b', 'c', 'd', 'e', 'f']
console.log(a); // ['a', 'b', 'c', 'd', 'e']

const c = [...b, 'f']; // ['a', 'b', 'c', 'd', 'e', 'f']
const d = ['z', ...arr1]; // ['z', 'a', 'b', 'c', 'd', 'e']
```

### Remove

```js
// Mutating
let a = ['a', 'b', 'c', 'd', 'e'];
a.pop(); // ['a', 'b', 'c', 'd']
a.shift(); // ['b', 'c', 'd']

let b = ['a', 'b', 'c', 'd', 'e'];
const poppedElement = b.pop();
console.log(b); // ['a', 'b', 'c', 'd']
console.log(poppedElement); // 'e'
const shiftedElement = b.shift();
console.log(b); // ['b', 'c', 'd']
console.log(shiftedElement); // 'a'

let c = ['a', 'b', 'c', 'd', 'e'];
// .splice(startIndex, numItemsToRemove)
const removedItems = c.splice(0, 2);
console.log(c); // ['c', 'd', 'e']
console.log(removedItems); // ['a', 'b']

// Non-Mutating
const a = ['a', 'b', 'c', 'd', 'e'];

const b = a.filter((val) => val !== 'e'); // ['a', 'b', 'c', 'd']
// OR
const c = a.filter((val) => {
  return val !== 'e';
}); // ['a', 'b', 'c', 'd']

// .slice(startIndexInclusive, endIndexExclusive)
// .slice(startIndex) -> goes to endIndex automatically
const d = a.slice(1, 5); // ['b', 'c', 'd', 'e']
const e = a.slice(2); // ['c', 'd', 'e']
```

### Replace

```js
// Mutating
// .splice(startIndex, numItemsToRemove, itemsToAdd...)
let a = ['a', 'b', 'c', 'd', 'e'];
a.splice(2, 1, 30); // ['a', 'b', 30, 'd', 'e']
// OR
a.splice(2, 1, 30, 31); // ['a', 'b', 30, 31, 'd', 'e']

// Non-Mutating
const a = ['a', 'b', 'c', 'd', 'e'];
const b = a.map((item) => {
  if (item === 'c') {
    item = 'CAT';
  }
  return item;
}); // ['a', 'b', 'CAT', 'd', 'e']

const c = a.map((val) => val + 'Hi!'); // ['aHi!', 'bHi!', 'cHi!', 'dHi!', 'eHi!']
// OR
const d = a.map((n) => {
  return n + 'Hi!';
}); // ['aHi!', 'bHi!', 'cHi!', 'dHi!', 'eHi!']

console.log(a); // ['a', 'b', 'c', 'd', 'e']; // original array is intact
```

# Boolean

- `true`
- `false`

- Can use the `Boolean()` function to find out if an expression is true:

```js
// v1
console.log(Boolean(10 > 9));
// v2
console.log(10 > 9);
```

- [Read more](https://www.w3schools.com/jsref/jsref_obj_boolean.asp)

## Boolean Methods and Properties

| Method         | Description                                                       |
| -------------- | ----------------------------------------------------------------- |
| `.constructor` | Returns the function that created JavaScript's Boolean prototype  |
| `.prototype`   | Allows you to add properties and methods to the Boolean prototype |
| `.toString()`  | Converts a boolean value to a string, and returns the result      |
| `.valueOf()`   | Returns the primitive value of a boolean                          |

# Class

- A `class` is a type of function, but instead of using the keyword `function` to initiate it, we use the keyword `class`, and the properties are assigned inside a `constructor()` method
- [Read more](https://www.w3schools.com/jsref/jsref_classes.asp)

```js
class Car {
  // Create a class
  constructor(brand) {
    // Class constructor
    this.carName = brand; // Class body/properties
  }
}

// Create an object of Car class
myCar = new Car('Porsche');
```

## Class Methods

| Method           | Description                                                                   |
| ---------------- | ----------------------------------------------------------------------------- |
| `.constructor()` | A special method for creating and initializing objects created within a class |

## Class Keywords

| Keyword   | Description                         |
| --------- | ----------------------------------- |
| `extends` | Extends a class (inherit)           |
| `static`  | Defines a static method for a class |
| `super`   | Refers to the parent class          |

# Date

- The `Date` object works with dates and times
- Date objects are created with `new Date()`
- There are four ways of instantiating (creating) a date:
  - `new Date();`
  - `new Date(milliseconds);`
  - `new Date(dateString);`
  - `new Date(year, month, day, hours, minutes, seconds, milliseconds);`
- [Read more](https://www.w3schools.com/jsref/jsref_obj_date.asp)

## Date Methods and Properties

| Method                  | Description                                                                                           |
| ----------------------- | ----------------------------------------------------------------------------------------------------- |
| `.constructor`          | Returns the function that created the Date object's prototype                                         |
| `.getDate()`            | Returns the day of the month (from 1-31)                                                              |
| `.getDay()`             | Returns the day of the week (from 0-6)                                                                |
| `.getFullYear()`        | Returns the year                                                                                      |
| `.getHours()`           | Returns the hour (from 0-23)                                                                          |
| `.getMilliseconds()`    | Returns the milliseconds (from 0-999)                                                                 |
| `.getMinutes()`         | Returns the minutes (from 0-59)                                                                       |
| `.getMonth()`           | Returns the month (from 0-11)                                                                         |
| `.getSeconds()`         | Returns the seconds (from 0-59)                                                                       |
| `.getTime()`            | Returns the number of milliseconds since midnight Jan 1 1970, and a specified date                    |
| `.getTimezoneOffset()`  | Returns the time difference between UTC time and local time, in minutes                               |
| `.getUTCDate()`         | Returns the day of the month, according to universal time (from 1-31)                                 |
| `.getUTCDay()`          | Returns the day of the week, according to universal time (from 0-6)                                   |
| `.getUTCFullYear()`     | Returns the year, according to universal time                                                         |
| `.getUTCHours()`        | Returns the hour, according to universal time (from 0-23)                                             |
| `.getUTCMilliseconds()` | Returns the milliseconds, according to universal time (from 0-999)                                    |
| `.getUTCMinutes()`      | Returns the minutes, according to universal time (from 0-59)                                          |
| `.getUTCMonth()`        | Returns the month, according to universal time (from 0-11)                                            |
| `.getUTCSeconds()`      | Returns the seconds, according to universal time (from 0-59)                                          |
| `.getYear()`            | Deprecated. Use the getFullYear() method instead                                                      |
| `.now()`                | Returns the number of milliseconds since midnight Jan 1, 1970                                         |
| `.parse()`              | Parses a date string and returns the number of milliseconds since January 1, 1970                     |
| `.prototype`            | Allows you to add properties and methods to an object                                                 |
| `.setDate()`            | Sets the day of the month of a date object                                                            |
| `.setFullYear()`        | Sets the year of a date object                                                                        |
| `.setHours()`           | Sets the hour of a date object                                                                        |
| `.setMilliseconds()`    | Sets the milliseconds of a date object                                                                |
| `.setMinutes()`         | Set the minutes of a date object                                                                      |
| `.setMonth()`           | Sets the month of a date object                                                                       |
| `.setSeconds()`         | Sets the seconds of a date object                                                                     |
| `.setTime()`            | Sets a date to a specified number of milliseconds after/before January 1, 1970                        |
| `.setUTCDate()`         | Sets the day of the month of a date object, according to universal time                               |
| `.setUTCFullYear()`     | Sets the year of a date object, according to universal time                                           |
| `.setUTCHours()`        | Sets the hour of a date object, according to universal time                                           |
| `.setUTCMilliseconds()` | Sets the milliseconds of a date object, according to universal time                                   |
| `.setUTCMinutes()`      | Set the minutes of a date object, according to universal time                                         |
| `.setUTCMonth()`        | Sets the month of a date object, according to universal time                                          |
| `.setUTCSeconds()`      | Set the seconds of a date object, according to universal time                                         |
| `.setYear()`            | Deprecated. Use the setFullYear() method instead                                                      |
| `.toDateString()`       | Converts the date portion of a Date object into a readable string                                     |
| `.toGMTString()`        | Deprecated. Use the toUTCString() method instead                                                      |
| `.toISOString()`        | Returns the date as a string, using the ISO standard                                                  |
| `.toJSON()`             | Returns the date as a string, formatted as a JSON date                                                |
| `.toLocaleDateString()` | Returns the date portion of a Date object as a string, using locale conventions                       |
| `.toLocaleTimeString()` | Returns the time portion of a Date object as a string, using locale conventions                       |
| `.toLocaleString()`     | Converts a Date object to a string, using locale conventions                                          |
| `.toString()`           | Converts a Date object to a string                                                                    |
| `.toTimeString()`       | Converts the time portion of a Date object to a string                                                |
| `.toUTCString()`        | Converts a Date object to a string, according to universal time                                       |
| `.UTC()`                | Returns the number of milliseconds in a date since midnight of January 1, 1970, according to UTC time |
| `.valueOf()`            | Returns the primitive value of a Date object                                                          |

# Error

- The Error object provides error information when an error occurs

```js
try {
  adddlert('Welcome');
} catch (error) {
  document.getElementById('demo').innerHTML = error.name + '<br>' + error.message;
}
```

- [Read more](https://www.w3schools.com/jsref/jsref_obj_error.asp)

## Error Object Properties

| Property   | Description                                 |
| ---------- | ------------------------------------------- |
| `.name`    | Sets or returns an error name               |
| `.message` | Sets or returns an error message (a string) |

## Error Names

| Error Name       | Description                          |
| ---------------- | ------------------------------------ |
| `RangeError`     | A number "out of range" has occurred |
| `ReferenceError` | An illegal reference has occurred    |
| `SyntaxError`    | A syntax error has occurred          |
| `TypeError`      | A type error has occurred            |
| `URIError`       | An error in encodeURI() has occurred |

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
- Note: This means EMPTY arrays/objects, the strings `"false"` and `"0"` are considered **truthy**

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

# Global

- The JavaScript global properties and methods can be used with all JavaScript objects
- Note
  - Since these methods are global, and global the object is the browser window, these methods are actually window methods:
    - `isNaN()` is the same as `window.isNaN()`
- [Read more](https://www.w3schools.com/jsref/jsref_obj_global.asp)

## Global Methods

| Method                 | Description                                                 |
| ---------------------- | ----------------------------------------------------------- |
| `decodeURI()`          | Decodes a URI                                               |
| `decodeURIComponent()` | Decodes a URI component                                     |
| `encodeURI()`          | Encodes a URI                                               |
| `encodeURIComponent()` | Encodes a URI component                                     |
| `eval()`               | Evaluates a string and executes it as if it was script code |
| `isFinite()`           | Determines whether a value is a finite, legal number        |
| `isNaN()`              | Determines whether a value is an illegal number             |
| `Number()`             | Converts an object's value to a number                      |
| `parseFloat()`         | Parses a string and returns a floating point number         |
| `parseInt()`           | Parses a string and returns an integer                      |
| `String()`             | Converts an object's value to a string                      |

## Global Properties

| Property    | Description                                                |
| ----------- | ---------------------------------------------------------- |
| `Infinity`  | A numeric value that represents positive/negative infinity |
| `NaN`       | "Not-a-Number" value                                       |
| `undefined` | Indicates that a variable has not been assigned a value    |

# JSON

**`JSON.stringify()` = JavaScript Object -> JSON String**
**`JSON.parse()` = JSON String -> JavaScript Object**
**`response.json()` = Response (JSON) -> JavaScript Object**

JSON == JavaScript Object Notation

JSON is a format for storing and transporting data

JavaScript Objects can be converted into JSON, and JSON can be converted back into JavaScript Objects

```js
// A JavaScript object
let myObj = { name: 'John', age: 31, city: 'New York' };
// Converted into JSON:
let myJSON = JSON.stringify(myObj);
// Send JSON
window.location = 'demo_json.php?x=' + myJSON;
```

**Receiving JSON**

```js
// myJSON is text received in JSON format
// Convert JSON into a JavaScript object:
let myObj = JSON.parse(myJSON);
document.getElementById('demo').innerHTML = myObj.name;
```

**Storing data as JSON, using localStorage**

```js
// Storing data:
let myObj = { name: 'John', age: 31, city: 'New York' };
let myJSON = JSON.stringify(myObj);
localStorage.setItem('testJSON', myJSON);

// Retrieving data:
let text = localStorage.getItem('testJSON');
let obj = JSON.parse(text);
document.getElementById('demo').innerHTML = obj.name;
```

- [Read more](https://www.w3schools.com/jsref/jsref_obj_json.asp)

## JSON Methods

| Method             | Description                                          |
| ------------------ | ---------------------------------------------------- |
| `JSON.parse()`     | Parses a JSON string and returns a JavaScript object |
| `JSON.stringify()` | Convert a JavaScript object to a JSON string         |

## Valid Data Types

- In JSON, values must be one of the following data types:
  - A string
  - A number
  - An object (containing valid JSON values)
  - An array
  - A boolean
  - `null`
- JSON values can NOT be one of the following data types:
  - A function
  - A date
  - `undefined`

# Math

- Math is not a constructor
- All properties/methods of Math can be called by using Math as an object, without creating it

```js
let x = Math.PI;
let y = Math.sqrt(16);
```

- [Read more](https://www.w3schools.com/jsref/jsref_obj_math.asp)

## `Math` Object Methods and Properties

| Method               | Description                                                                    |
| -------------------- | ------------------------------------------------------------------------------ |
| `Math.abs(x)`        | Returns the absolute value of x                                                |
| `Math.acos(x)`       | Returns the arccosine of x, in radians                                         |
| `Math.acosh(x)`      | Returns the hyperbolic arccosine of x                                          |
| `Math.asin(x)`       | Returns the arcsine of x, in radians                                           |
| `Math.asinh(x)`      | Returns the hyperbolic arcsine of x                                            |
| `Math.atan(x)`       | Returns the arctangent of x as a numeric value between -PI/2 and PI/2 radians  |
| `Math.atan2(y, x)`   | Returns the arctangent of the quotient of its arguments                        |
| `Math.atanh(x)`      | Returns the hyperbolic arctangent of x                                         |
| `Math.cbrt(x)`       | Returns the cubic root of x                                                    |
| `Math.ceil(x)`       | Returns x, rounded upwards to the nearest integer                              |
| `Math.clz32(x)`      | Returns the number of leading zeros in a 32-bit binary representation of x     |
| `Math.cos(x)`        | Returns the cosine of x (x is in radians)                                      |
| `Math.cosh(x)`       | Returns the hyperbolic cosine of x                                             |
| `Math.E`             | Returns Euler's number (approx. 2.718)                                         |
| `Math.exp(x)`        | Returns the value of Ex                                                        |
| `Math.expm1(x)`      | Returns the value of Ex minus 1                                                |
| `Math.floor(x)`      | Returns x, rounded downwards to the nearest integer                            |
| `Math.fround(x)`     | Returns the nearest (32-bit single precision) float representation of a number |
| `Math.LN2`           | Returns the natural logarithm of 2 (approx. 0.693)                             |
| `Math.LN10`          | Returns the natural logarithm of 10 (approx. 2.302)                            |
| `Math.log(x)`        | Returns the natural logarithmof x                                              |
| `Math.log10(x)`      | Returns the base-10 logarithm of x                                             |
| `Math.LOG10E`        | Returns the base-10 logarithm of E (approx. 0.434)                             |
| `Math.log1p(x)`      | Returns the natural logarithm of 1 + x                                         |
| `Math.log2(x)`       | Returns the base-2 logarithm of x                                              |
| `Math.LOG2E`         | Returns the base-2 logarithm of E (approx. 1.442)                              |
| `Math.max(x1,x2,..)` | Returns the number with the highest value                                      |
| `Math.min(x1,x2,..)` | Returns the number with the lowest value                                       |
| `Math.PI`            | Returns PI (approx. 3.14)                                                      |
| `Math.pow(x, y)`     | Returns the value of x to the power of y                                       |
| `Math.random()`      | Returns a random number between 0 and 1                                        |
| `Math.round(x)`      | Rounds x to the nearest integer                                                |
| `Math.sign(x)`       | Returns the sign of a number (checks whether it is positive, negative or zero) |
| `Math.sin(x)`        | Returns the sine of x (x is in radians)                                        |
| `Math.sinh(x)`       | Returns the hyperbolic sine of x                                               |
| `Math.sqrt(x)`       | Returns the square root of x                                                   |
| `Math.SQRT1_2`       | Returns the square root of 1/2 (approx. 0.707)                                 |
| `Math.SQRT2`         | Returns the square root of 2 (approx. 1.414)                                   |
| `Math.tan(x)`        | Returns the tangent of an angle                                                |
| `Math.tanh(x)`       | Returns the hyperbolic tangent of a number                                     |
| `Math.trunc(x)`      | Returns the integer part of a number (x)                                       |

## `Math.random()`

`Math.random()` returns random number **`>= 0 && < 1`**

Note: Use `Math.floor()` to turn generated random number into integer after applying numeric operations (multiplication, addition)

```js
// Generate number in range [0, 900_000_000) and add 100_000_000 to ENSURE final value is in range [100_000_000, 999_999_999]
// Note: Largest number generated is 899_999_999.999999 (and adding 100_000_000 gives 999_999_999.999999)
const id = Math.floor(Math.random() * 900_000_000 + 100_000_000);
```

# Number

- JavaScript has only one type of number
- Numbers can be written with, or without, decimals

```js
// A number with decimals
let x = 3.14;
// A number without decimals
let y = 34;
```

- Extra large or extra small numbers can be written with scientific (exponent) notation:

```js
// 12300000
let x = 123e5;
// 0.00123
let y = 123e-5;
```

- [Read more](https://www.w3schools.com/jsref/jsref_obj_number.asp)

## Number Methods

- **All number methods return a new value (they do NOT change the original variable)**

| Method              | Description                                                       |
| ------------------- | ----------------------------------------------------------------- |
| `.isFinite()`       | Checks whether a value is a finite number                         |
| `.isInteger()`      | Checks whether a value is an integer                              |
| `.isNaN()`          | Checks whether a value is Number.NaN                              |
| `.isSafeInteger()`  | Checks whether a value is a safe integer                          |
| `.toExponential(x)` | Converts a number into an exponential notation                    |
| `.toFixed(x)`       | Formats a number with x numbers of digits after the decimal point |
| `.toLocaleString()` | Converts a number into a string, based on the locale settings     |
| `.toPrecision(x)`   | Formats a number to x length                                      |
| `.toString()`       | Converts a number to a string                                     |
| `.valueOf()`        | Returns the primitive value of a number                           |

## Number Properties

| Property                   | Description                                                     |
| -------------------------- | --------------------------------------------------------------- |
| `Number.constructor`       | Returns the function that created JavaScript's Number prototype |
| `Number.MAX_VALUE`         | Returns the largest number possible in JavaScript               |
| `Number.MIN_VALUE`         | Returns the smallest number possible in JavaScript              |
| `Number.NEGATIVE_INFINITY` | Represents negative infinity (returned on overflow)             |
| `Number.NaN`               | Represents a "Not-a-Number" value                               |
| `Number.POSITIVE_INFINITY` | Represents infinity (returned on overflow)                      |
| `Number.prototype`         | Allows you to add properties and methods to an object           |

## Numeric Separator

Use `_`

```js
let mod = 1_000_000_007;
```

# Operators

- [Read more](https://www.w3schools.com/jsref/jsref_operators.asp)

## Arithmetic Operators

- Given that `y = 5`

| Operator | Description                        | Example      | Result in y | Result in x |
| -------- | ---------------------------------- | ------------ | ----------- | ----------- |
| `+`      | Addition                           | `x = y + 2`  | y = 5       | x = 7       |
| `-`      | Subtraction                        | `x = y - 2`  | y = 5       | x = 3       |
| `*`      | Multiplication                     | `x = y * 2`  | y = 5       | x = 10      |
| `**`     | Exponentiation                     | `x = y ** 2` | y = 5       | x = 25      |
| `/`      | Division                           | `x = y / 2`  | y = 5       | x = 2.5     |
| `%`      | Modulus (remainder after division) | `x = y % 2`  | y = 5       | x = 1       |
| `++`     | Increment                          | `x = ++y`    | y = 6       | x = 6       |
| <br>     | <br>                               | `x = y++`    | y = 6       | x = 5       |
| `--`     | Decrement                          | `x = --y`    | y = 4       | x = 4       |
| <br>     | <br>                               | `x = y--`    | y = 4       | x = 5       |

## Assignment Operators

- Given that `x = 10` and `y = 5`

| Operator | Example  | Same As     | Result in x |
| -------- | -------- | ----------- | ----------- |
| `=`      | `x = y`  | `x = y`     | x = 5       |
| `+=`     | `x += y` | `x = x + y` | x = 15      |
| `-=`     | `x -= y` | `x = x - y` | x = 5       |
| `*=`     | `x *= y` | `x = x * y` | x = 50      |
| `/=`     | `x /= y` | `x = x / y` | x = 2       |
| `%=`     | `x %= y` | `x = x % y` | x = 0       |

## String Operators

- The `+` operator, and the `+=` operator can also be used to concatenate (add) strings
- Given that `text1 = "Good "`, `text2 = "Morning"`, and `text3 = ""`

| Operator | Example                 | text1          | text2     | text3          |
| -------- | ----------------------- | -------------- | --------- | -------------- |
| `+`      | `text3 = text1 + text2` | "Good "        | "Morning" | "Good Morning" |
| `+=`     | `text1 += text2`        | "Good Morning" | "Morning" | ""             |

## Comparison Operators

- Comparison operators are used in logical statements to determine equality or difference between variables or values
- Given that `x = 5`

| Operator | Description                       | Comparing   | Returns |
| -------- | --------------------------------- | ----------- | ------- |
| `==`     | Equal to                          | `x == 8`    | `false` |
| <br>     | <br>                              | `x == 5`    | `true`  |
| `===`    | Equal value and equal type        | `x === "5"` | `false` |
| <br>     | <br>                              | `x === 5`   | `true`  |
| `!=`     | Not equal                         | `x != 8`    | `true`  |
| `!==`    | Not equal value or not equal type | `x !== "5"` | `true`  |
| <br>     | <br>                              | `x !== 5`   | `false` |
| `>`      | Greater than                      | `x > 8`     | `false` |
| `<`      | Less than                         | `x < 8`     | `true`  |
| `>=`     | Greater than or equal to          | `x >= 8`    | `false` |
| `<=`     | Less than or equal to             | `x <= 8`    | `true`  |

## Conditional (Ternary) Operator

| Syntax                                       | Example                                             |
| -------------------------------------------- | --------------------------------------------------- |
| `variablename = (condition) ? value1:value2` | `voteable = (age < 18) ? "Too young":"Old enough";` |

## Logical Operators

- Logical operators are used to determine the logic between variables or values
- Given that `x = 6` and `y = 3`

| Operator | Description | Example                             |
| -------- | ----------- | ----------------------------------- |
| `&&`     | and         | `(x < 10 && y > 1)` is `true`       |
| `\|\|`   | or          | `(x === 5 \|\| y === 5)` is `false` |
| `!`      | not         | `!(x === y)` is `true`              |

## Bitwise Operators

- Bit operators work on 32 bits numbers
- Any numeric operand in the operation is converted into a 32 bit number
- The result is converted back to a JavaScript number
- The examples above uses 4 bits unsigned examples
  - But JavaScript uses 32-bit signed numbers
  - Because of this, in JavaScript, `~5` will not return `10`
  - It will return `-6`
  - `~00000000000000000000000000000101` will return `11111111111111111111111111111010`

| Operator | Description | Example      | Same as        | Result | Decimal |
| -------- | ----------- | ------------ | -------------- | ------ | ------- |
| `&`      | AND         | `x = 5 & 1`  | `0101 & 0001`  | 1      | 1       |
| `\|`     | OR          | `x = 5 \| 1` | `0101 \| 0001` | 101    | 5       |
| `~`      | NOT         | `x = ~ 5`    | `~0101`        | 1010   | 10      |
| `^`      | XOR         | `x = 5 ^ 1`  | `0101 ^ 0001`  | 100    | 4       |
| `<<`     | Left shift  | `x = 5 << 1` | `0101 << 1`    | 1010   | 10      |
| `>>`     | Right shift | `x = 5 >> 1` | `0101 >> 1`    | 10     | 2       |

## `delete` Operator

- The `delete` operator deletes a property from an object
- The delete operator deletes both the value of the property and the property itself
- After deletion, the property cannot be used before it is added back again
- The delete operator is designed to be used on object properties
  - It has no effect on variables or functions
- Note: The delete operator should not be used on predefined JavaScript object properties
  - It can crash your application

```js
const person = {
  firstName: 'Seth',
  lastName: 'Chen',
  age: 21,
  eyeColor: 'blue',
};
// Equivalent
delete person.age;
delete person['age'];
```

## `in` Operator

- The `in` operator returns true if the specified property is in the specified object, otherwise false

```js
// Arrays
const cars = ['Saab', 'Volvo', 'BMW'];
'Saab' in cars; // Returns false (specify the index number instead of value)
0 in cars; // Returns true
1 in cars; // Returns true
4 in cars; // Returns false (does not exist)
'length' in cars; // Returns true  (length is an Array property)

// Objects
const person = { firstName: 'John', lastName: 'Doe', age: 50 };
'firstName' in person; // Returns true
'age' in person; // Returns true

// Predefined objects
'PI' in Math; // Returns true
'NaN' in Number; // Returns true
'length' in String; // Returns true
```

## `instanceof` Operator

- The `instanceof` operator returns `true` if the specified object is an instance of the specified object

```js
const cars = ['Porsche', 'Toyota', 'Lexus'];

// Returns true
let bool = cars instanceof Array;
// Returns true
let bool = cars instanceof Object;
// Returns false
let bool = cars instanceof String;
// Returns false
let bool = cars instanceof Number;
```

## `typeof` Operator

- The `typeof` operator returns the type of a variable, object, function or expression
- Note:
  - The data type of NaN is number
  - The data type of an array is object
  - The data type of a date is object
  - The data type of null is object
  - The data type of an undefined variable is undefined
- **You can NOT use `typeof` to define if a JavaScript object is an array (or a date)**

```js
// Returns string
typeof 'John';
// Returns number
typeof 3.14;
// Returns number
typeof NaN;
// Returns boolean
typeof false;
// Returns object
typeof [1, 2, 3, 4];
// Returns object
typeof { name: 'John', age: 34 };
// Returns object
typeof new Date();
// Returns function
typeof function () {};
// Returns undefined (if myCar is not declared)
typeof myCar;
// Returns object
typeof null;
```

## `void` Operator

- The `void` operator evaluates an expression and returns `undefined`
- This operator is often used to obtain the undefined primitive value, using `void(0)` (useful when evaluating an expression without using the return value)

```js
<a href="javascript:void(0);">
  Useless link
</a>

<a href="javascript:void(document.body.style.backgroundColor='red');">
  Click me to change the background color of body to red
</a>
```

# Regex

- [Read more](https://www.w3schools.com/jsref/jsref_obj_regexp.asp)

# Statements

- [Read more](https://www.w3schools.com/jsref/jsref_statements.asp)

## Statement Identifiers

- JavaScript statements often start with a "statement identifier" to identify the JavaScript action to be performed
- Statement identifiers are reserved words and cannot be used as variable names (or any other things)

| Statement Identifier        | Description                                                                                                           |
| --------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| `break`                     | Exits a switch or a loop                                                                                              |
| `class`                     | Declares a class                                                                                                      |
| `const`                     | Declares a variable with a constant value                                                                             |
| `continue`                  | Breaks one iteration (in the loop) if a specified condition occurs, and continues with the next iteration in the loop |
| `debugger`                  | Stops the execution of JavaScript, and calls (if available) the debugging function                                    |
| `do ... while`              | Executes a block of statements and repeats the block while a condition is true                                        |
| `for`                       | Loops through a block of code a number of times                                                                       |
| `for ... in `               | Loops through the properties of an object                                                                             |
| `for ... of`                | Loops through the values of an iterable object                                                                        |
| `function`                  | Declares a function                                                                                                   |
| `if ... else ... else if`   | Marks a block of statements to be executed depending on a condition                                                   |
| `let`                       | Declares a variable                                                                                                   |
| `return`                    | Stops the execution of a function and returns a value from that function                                              |
| `switch`                    | Marks a block of statements to be executed depending on different cases                                               |
| `throw`                     | Throws (generates) an error                                                                                           |
| `try ... catch ... finally` | Marks the block of statements to be executed when an error occurs in a try block, and implements error handling       |
| `var`                       | Declares a variable                                                                                                   |
| `while`                     | Marks a block of statements to be executed while a condition is true                                                  |

# String

A string can be any text inside double `""` or single quotes `''`

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

## String Methods

- With JavaScript, methods and properties are also available to strings, because JavaScript treats strings as objects when executing methods and properties
- Note:
  - All string methods return a new value
  - They do not change the original variable

| Method                 | Description                                                                                                |
| ---------------------- | ---------------------------------------------------------------------------------------------------------- |
| `.charAt()`            | Returns the character at a specified index (position)                                                      |
| `.charCodeAt()`        | Returns the Unicode of the character at a specified index                                                  |
| `.concat()`            | Returns two or more joined strings                                                                         |
| `.endsWith()`          | Returns if a string ends with a specified value                                                            |
| `.fromCharCode()`      | Returns Unicode values as characters                                                                       |
| `.includes()`          | Returns if a string contains a specified value                                                             |
| `.indexOf()`           | Returns the index (position) of the first occurrence of a value in a string                                |
| `.lastIndexOf()`       | Returns the index (position) of the last occurrence of a value in a string                                 |
| `.localeCompare()`     | Compares two strings in the current locale                                                                 |
| `.match()`             | Searches a string for a value, or a regular expression, and returns the matches                            |
| `.repeat()`            | Returns a new string with a number of copies of a string                                                   |
| `.replace()`           | Searches a string for a value, or a regular expression, and returns a string where the values are replaced |
| `.search()`            | Searches a string for a value, or regular expression, and returns the index (position) of the match        |
| `.slice()`             | Extracts a part of a string and returns a new string                                                       |
| `.split()`             | Splits a string into an array of substrings                                                                |
| `.startsWith()`        | Checks whether a string begins with specified characters                                                   |
| `.substr()`            | Extracts a number of characters from a string, from a start index (position)                               |
| `.substring()`         | Extracts characters from a string, between two specified indices (positions)                               |
| `.toLocaleLowerCase()` | Returns a string converted to lowercase letters, using the host's locale                                   |
| `.toLocaleUpperCase()` | Returns a string converted to uppercase letters, using the host's locale                                   |
| `.toLowerCase()`       | Returns a string converted to lowercase letters                                                            |
| `.toString()`          | Returns a string or a string object as a string                                                            |
| `.toUpperCase()`       | Returns a string converted to uppercase letters                                                            |
| `.trim()`              | Returns a string with removed whitespaces                                                                  |
| `.valueOf()`           | Returns the primitive value of a string or a string object                                                 |

## String Properties

| Property       | Description                                           |
| -------------- | ----------------------------------------------------- |
| `.constructor` | Returns the string's constructor function             |
| `.length`      | Returns the length of a string                        |
| `.prototype`   | Allows you to add properties and methods to an object |

# Truthy/Falsy Values

## Truthy Values

All values are **truthy** except for:

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

Examples of Truthy Values

| Value                | Type        | Definition                           |
| -------------------- | ----------- | ------------------------------------ |
| `true`               | Boolean     |                                      |
| `'0'`, `"0"`         | String      | A string containing a single zero    |
| `'false'`, `"false"` | String      | A string containing the text "false" |
| `[]`                 |             | An empty array                       |
| `{}`                 |             | An empty object                      |
| `function(){}`       |             | An "empty" function                  |
| `314`                | Number      |                                      |
| `-314`               | Number      |                                      |
| `3.14`               | Number      |                                      |
| `-3.14`              | Number      |                                      |
| `314n`               | BigInt      |                                      |
| `new Date()`         | Date Object |                                      |
| `Infinity`           | Number      |                                      |
| `-Infinity`          | Number      |                                      |

## Falsy Values

| Value              | Type      | Description                                                                                                      |
| ------------------ | --------- | ---------------------------------------------------------------------------------------------------------------- |
| `false`            | Boolean   | The keyword `false`                                                                                              |
| `null`             | Null      | The keyword `null` = The absence of any value                                                                    |
| `undefined`        | Undefined | The keyword `undefined` = The unassigned/primitive value                                                         |
| `NaN`              | Number    | NaN = "Not A Number"                                                                                             |
| `""`, `''`, ` `` ` | String    | Empty string value                                                                                               |
| `0`                | Number    | The Number zero, also including 0.0, 0x0, etc                                                                    |
| `-0`               | Number    | The Number negative zero, also including -0.0, -0x0, etc                                                         |
| `0.0`              | Number    | The Number negative zero, also including -0.0, -0x0, etc                                                         |
| `-0.0`             | Number    | The Number negative zero, also including -0.0, -0x0, etc                                                         |
| `0n`               | BigInt    | The BigInt zero, also including 0x0n, etc. Note that there is no BigInt negative zero — the negation of 0n is 0n |
| `document.all`     | Object    | The only falsy object in JavaScript is the built-in document.all                                                 |

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

# Miscellaneous

## .forEach(), .map() indexing

- Remember that `array.forEach()` and `array.map()` can take an additional parameter which is the `index`
-

```js
// Arrow function
.forEach((element) => { /* … */ })
.forEach((element, index) => { /* … */ })
.forEach((element, index, array) => { /* … */ })

// Callback function
.forEach(callbackFn)
.forEach(callbackFn, thisArg)

// Inline callback function
.forEach(function(element) { /* … */ })
.forEach(function(element, index) { /* … */ })
.forEach(function(element, index, array){ /* … */ })
.forEach(function(element, index, array) { /* … */ }, thisArg)
```

```js
// Arrow function
.map((element) => { /* … */ })
.map((element, index) => { /* … */ })
.map((element, index, array) => { /* … */ })

// Callback function
.map(callbackFn)
.map(callbackFn, thisArg)

// Inline callback function
.map(function(element) { /* … */ })
.map(function(element, index) { /* … */ })
.map(function(element, index, array){ /* … */ })
.map(function(element, index, array) { /* … */ }, thisArg)
```

- [.map()](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map)
- [.forEach()][https://developer.mozilla.org/en-us/docs/web/javascript/reference/global_objects/array/foreach]

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

## Debugging (`console.log()`)

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

## Deep Copy

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

## Shuffle Array

- [Fisher-Yates Shuffle Wikipedia](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle)
- [Durstenfeld Shuffle Wikipedia](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm)

### Durstenfeld Shuffle

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

### Quick & Easy

```js
const shuffle = (a) => {
  // Math.random() returns num >= 0 && < 1;
  a.sort(() => Math.random() - 0.5);
  return a;
};
```
