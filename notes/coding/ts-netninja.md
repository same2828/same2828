# Table of Contents

- [Table of Contents](#table-of-contents)
- [TypeScript Basics](#typescript-basics)
  - [Installation](#installation)
  - [Compilation](#compilation)
  - [tsconfig](#tsconfig)
  - [Truthy/Falsy Values](#truthyfalsy-values)
    - [Truthy](#truthy)
    - [Falsy](#falsy)
  - [TypeScript Primitives](#typescript-primitives)
  - [Type Annotations](#type-annotations)
    - [Non-null Assertion Operator (Postfix `!`)](#non-null-assertion-operator-postfix-)
  - [Arrays](#arrays)
  - [Objects](#objects)
    - [Optional Properties](#optional-properties)
  - [Functions](#functions)
  - [`any` Type](#any-type)
  - [Tuples](#tuples)
  - [Sets](#sets)
  - [Enums](#enums)
  - [Interfaces](#interfaces)
  - [Type Aliases](#type-aliases)
  - [Union Types](#union-types)
  - [Type Guards](#type-guards)
  - [Reusable Interfaces](#reusable-interfaces)
  - [Function Signatures](#function-signatures)
    - [Function Signatures inside Interfaces](#function-signatures-inside-interfaces)
      - [Version 1](#version-1)
      - [Version 2](#version-2)
  - [Extending Interfaces](#extending-interfaces)
  - [Extending Type Aliases](#extending-type-aliases)
- [Classes](#classes)
  - [Methods inside Classes](#methods-inside-classes)
    - [Version 1](#version-1-1)
    - [Version 2](#version-2-1)
  - [Access Modifiers](#access-modifiers)
    - [Shortcut for Constructors](#shortcut-for-constructors)
  - [Classes as Types](#classes-as-types)
  - [Getters + Setters](#getters--setters)
  - [Inheritance](#inheritance)
  - [Classes with Interfaces](#classes-with-interfaces)
  - [Abstract Classes](#abstract-classes)
  - [CSV Writer Project](#csv-writer-project)
- [Generics](#generics)
  - [Generic Functions](#generic-functions)
  - [Generic Functions + Intersection Types (Extended Type Aliases)](#generic-functions--intersection-types-extended-type-aliases)
  - [Generic Interfaces](#generic-interfaces)
  - [Generic Classes](#generic-classes)
  - [Generic Constraints](#generic-constraints)
  - [CSV Writer Project using Generics](#csv-writer-project-using-generics)
- [TypeScript for the Web](#typescript-for-the-web)
  - [Using Parcel](#using-parcel)
  - [Data Resource Class](#data-resource-class)
  - [Making a Pizza Model](#making-a-pizza-model)
  - [Fetching Data](#fetching-data)
  - [Finishing Data Resource Class](#finishing-data-resource-class)
  - [Querying the DOM](#querying-the-dom)
  - [Type Assertion](#type-assertion)
  - [Form Data](#form-data)
- [TypeScript + NextJS](#typescript--nextjs)
  - [Project Setup](#project-setup)
  - [Component + Props](#component--props)
  - [Fetching Data](#fetching-data-1)
  - [Type Definition Files](#type-definition-files)
  - [Typed Links](#typed-links)

https://netninja.dev

# TypeScript Basics

## Installation

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

## tsconfig

Run in root dir

```sh
tsc --init
```

Look for

```json
"rootDir": "./src" /* Specify the root folder within your source files. */,
"outDir": "./dist" /* Specify an output folder for all emitted files. */,
```

Run in root dir to compile

```sh
tsc
```

Run in root dir to compile automatically

```sh
tsc --watch
```

Run in root dir to run automatically

```sh
node --watch dist/index.js
```

## Truthy/Falsy Values

### Truthy

All values are **truthy** except for

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

### Falsy

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

## TypeScript Primitives

```ts
let var1: boolean = false;
let var2: number = 4096;
let var3: string = 'hello world';
let var4: null = null;
let var5: undefined = undefined;
let var6: bigint = BigInt(9007199254740991); // let var6: bigint = BigInt("9007199254740991"); // let var6: bigint = 9007199254740991n;
let var7: symbol = Symbol('var7');
```

## Type Annotations

**`let var: type; var = value;`**
**`let var: type = value;`**

Note: If a variable is NOT type annotated, then TypeScript defaults the type to `any`

```ts
// Basic Type Annotations
let age: number = 30;
let firstName: string = 'Mario';
let isFictional: boolean;
age = 31;
firstName = 'Luigi';
isFictional = false;

// Type Inference
let planet = 'Earth';
let moons = 1;
let isLarge = false;
planet = 'Saturn';
moons = 145;
isLarge = true;

// null + undefined
let something: null;
let anotherThing: undefined;
something = null;
anotherThing = undefined;
```

### Non-null Assertion Operator (Postfix `!`)

Appending `!` to a variable/expression is a way to tell the compiler "this expression cannot be null or undefined here, so don't complain about the possibility of it being null or undefined"

The operation `x!` produces a value of the type of `x` with `null` and `undefined` EXCLUDED

```ts
function duplicate(text: string | null) {
  if (text === null || text === undefined) {
    text = '';
  }
  return text.concat(text);
}
```

## Arrays

**`let arr: type[]; arr = [value1, value2, value3];`**

**`let arr: type[] = [value1, value2, value3];`**

```ts
// Arrays
let names: string[] = ['mario', 'luigi', 'peach'];
let ages: number[] = [25, 28, 24];
names.push('bowser');
ages.push(30);

// Type Inference with Arrays
let fruits = ['apples', 'pears', 'bananas', 'mangos'];
fruits.push('peaches');
const f = fruits[3];

// Union Type
let things: (string | number | boolean)[] = [1, true, 'hello'];
const t = things[0];
```

## Objects

**`let obj: { property1: type; property2: type; };`**

**`let obj: { property1: type; property2: type; } = { property1: value, property2: value };`**

**`let { var1, var2 }: { property1: type; property2: type; } = obj;`**

```ts
// Object Literals
let user: { firstName: string; age: number; id: number } = {
  firstName: 'mario',
  age: 30,
  id: 1,
};
user.firstName = 'peach';
user.id = 2;

// Destructuring from Objects
const { age, id }: { age: number; id: number } = user;

// Type Inference with Object Literals
let person = {
  name: 'luigi',
  score: 35,
};
person.name = 'bowser';
const score = person.score;
```

### Optional Properties

**Add a `?` AFTER property name**

```ts
function printName(obj: { first: string; last?: string }) {
  // console.log(obj.last.toUpperCase()); // <-- INVALID (might crash if 'obj.last' is NOT provided)
  if (obj.last !== undefined) {
    console.log(obj.last.toUpperCase());
  }
  // Version/Method 2 using Optional Chaining (?.) > https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
  console.log(obj.last?.toUpperCase());
}

printName({ first: 'Mario' });
printName({ first: 'Luigi', last: 'Fratelli' });
```

## Functions

**`function func(param1: type, param2: type): returnType {};`**

**`const func = (param1: type, param2: type): returnType => {};`**

```ts
// Functions
function addTwoNumbers(a: number, b: number): number {
  return a + b;
}

const subtractTwoNumbers = (a: number, b: number): number => {
  return a - b;
};

addTwoNumbers(3, 9);
subtractTwoNumbers(10, 7);

function addAllNumbers(items: number[]): void {
  const total = items.reduce((a, c) => a + c, 0);
  console.log(total);
}

addAllNumbers([5, 7, 9, 11, 3, 2, 1]);

// Return Type Inference
// Note: We get inference on return types, but not on argument types
// Note: Type inference on return values does NOT enforce a return type
function formatGreeting(name: string, greeting: string) {
  return `${greeting}, ${name}`;
}

const formattedGreeting = formatGreeting('Seth', 'Good Morning');
```

## `any` Type

Useful when migrating from js to ts because using "any" won't cause errors initially

```ts
// `any` type
let age: any;
let title;

age = 30;
age = false;

title = 25;
title = {
  hello: 'world',
};

// `any` type in Arrays
let things: any[] = ['hello', true, 30, null];
things.push({ id: 123 });

// `any` type in Functions
function addTogether(value: any): any {
  return value + value;
}

const resultOne = addTogether('hello'); // "hellohello"
const resultTwo = addTogether(3); // 6
```

## Tuples

A "tuple" is a **typed array** with a **predefined order/length** and **predefined type** for **EACH index**

**`let tuple: [type1, type2, type3]; tuple = [value1, value2, value3];`**

**`let tuple: [type1, type2, type3] = [value1, value2, value3];`**

```ts
// Tuples
let person: [string, number, boolean] = ['mario', 30, true];

// person[0] = 1; // <-- INVALID
// person[0] = false; // <-- INVALID
person[0] = 'luigi';

// Hue Saturation Luminance AlphaChannel (opacity)
let hsla: [number, string, string, number];
hsla = [200, '100%', '50%', 1];

let xy: [number, number];
xy = [94.7, 20.1];

function useCoords(): [number, number] {
  const lat = 100;
  const long = 50;
  return [lat, long];
}

const [lat, long] = useCoords();

// Named Tuples
let user: [name: string, age: number];
user = ['peach', 25];
console.log(user[0]);
```

## Sets

```ts
// Sets
const nameSet = new Set<string>();
nameSet.add('mario');
nameSet.add('luigi');
nameSet.add('peach');
nameSet.add('mario'); // <-- Duplicate (will NOT be added)
console.log(nameSet);

// Sets with Custom Types
interface User {
  email: string;
  score: number;
}

const user1: User = { email: 'mario@netninja.dev', score: 10 };
const user2: User = { email: 'peach@netninja.dev', score: 15 };
const userSet = new Set<User>();
userSet.add(user1);
userSet.add(user2);
userSet.add(user1); // <-- Duplicate (will NOT be added)
console.log(userSet);

// Sets as Function Arguments
function printUserEmails(userSet: Set<User>): void {
  userSet.forEach((user) => console.log(user.email));
}

printUserEmails(userSet);
```

## Enums

```ts
// Enums
enum Priority {
  Lowest = 0,
  Low = 1,
  Medium = 2,
  High = 3,
  Urgent = 4,
}

// function addTicket(details: string, priority: number) {
//   if (priority === 0) {}
//   if (priority === 1) {}
//   if (priority === 2) {}
//   if (priority === 3) {}
//   if (priority === 4) {}
// }

// addTicket('Reinstall Windows', 4)

function addTicket(details: string, priority: Priority) {
  if (priority === 0) {
  }
  if (priority === 1) {
  }
  if (priority === 2) {
  }
  if (priority === 3) {
  }
  if (priority === 4) {
  }
}

addTicket('Reinstall Windows', Priority.Urgent);
```

## Interfaces

Define certain structure that other data structures (classes, object literals, other interfaces) can adhere to

Note: Objects created have to match the interface properties EXACTLY (CANNOT have extra properties)

**Note: There is NO SEMICOLON (;) at the end of the interface declaration**

**`interface InterfaceName {}`**

**`interface InterfaceName { property1: type, property2: type }`**

```ts
// Interfaces
interface Author {
  name: string;
  avatar: string;
}

const authorOne: Author = { name: 'mario', avatar: '/img/mario.png' };

interface Post {
  title: string;
  body: string;
  tags: string[];
  created_at: Date;
  author: Author;
}

const newPost = {
  title: 'my first post',
  body: 'something interesting',
  tags: ['gaming', 'tech'],
  created_at: new Date(),
  author: authorOne,
};

// Interfaces as Function Argument Types
function createPost(post: Post): void {
  console.log(`created post ${post.title} by ${post.author.name}`);
}

createPost(newPost);

// Interfaces with Arrays
let posts: Post[] = [];
posts.push(newPost);
```

## Type Aliases

**`type MyType = ...`**

- Where `...` could be anything
  - Array: `type MyType = type[];`
  - Tuple: `type MyType = [type1, type2, type3];`
  - Object: `type MyType = { property1: type; property2: type; };`

```ts
// Type Aliases

// Example 1: Tuple
type Rgb = [number, number, number];

function getRandomColor(): Rgb {
  const r = Math.floor(Math.random() * 255);
  const g = Math.floor(Math.random() * 255);
  const b = Math.floor(Math.random() * 255);
  return [r, g, b];
}

const colorOne = getRandomColor();
const colorTwo = getRandomColor();
console.log(colorOne, colorTwo);

// Example 2: Object Literal
type User = {
  name: string;
  score: number;
};

const userOne: User = { name: 'mario', score: 75 };

function formatUser(user: User): void {
  console.log(`${user.name} has a score of ${user.score}.`);
}

formatUser(userOne);
formatUser({ name: 'yoshi', score: 100 });
```

## Union Types

**`let var: type1 | type2 | type3;`**

Warning: A common cause of errors/pitfalls with using "union types" for functions parameters is that you can ONLY use props/methods/functions that are COMMON to ALL of the types in the type union

```ts
// Union Types
let someId: number | string;
someId = 123;
someId = '456';

let email: string | null = null;
email = 'mario@netninja.dev';
email = null;

type Id = number | string;
let anotherId: Id;

// anotherId = undefined <-- INVALID
anotherId = '1';
anotherId = 2;

// Union Type Pitfall (warning)
function swapIdType(id: Id): Id {
  // Can only use props/methods/functions common to both number and string types
  // parseInt(id) <-- Not Allowed
  return id;
}
```

## Type Guards

Use `typeof` on `types`

Embed a `type` property for `interfaces` (which is string representing type) and use `if (obj.type === 'typeStr')`

Note: CANNOT use `typeof` for `interfaces`

```ts
// Type Guards

// Example 1
type Id = number | string;

function swapIdType(id: Id): Id {
  if (typeof id === 'string') {
    // Can use string methods and properties
    return parseInt(id);
  } else {
    // Can use number methods and properties
    return id.toString();
  }
  // return typeof id === 'string' ? parseInt(id) : id.toString();
}

const idOne = swapIdType(123);
const idTwo = swapIdType('456');
console.log(idOne, idTwo);

// Tagged Union Types
// Note: CANNOT use `typeof` for `interface`
interface User {
  type: 'user';
  username: string;
  email: string;
  id: Id;
}

interface Person {
  type: 'person';
  firstname: string;
  age: number;
  id: Id;
}

function printDetails(value: User | Person): void {
  if (value.type === 'user') {
    console.log(value.email, value.username);
  }
  if (value.type === 'person') {
    console.log(value.firstname, value.age);
  }
}
```

## Reusable Interfaces

When passing variable `interfaces` as arguments to a function

- CAN pass variables that have been created and assigned BEFOREHAND (which have extra properties)
- CANNOT pass inline variables (created INLINE) which have extra properties (can only contain exact properties of interface and none extra)

```ts
// Reusable Interfaces
interface hasQuantity {
  quantity: number;
}

// INVALID (not allowed, has to match exact structure; no extra properties allowed)
// const something: hasQuantity = { title: 'hello', quantity: 50 }

// Valid (allowed)
const something: hasQuantity = { quantity: 50 };

function printQuantity(item: hasQuantity): void {
  // Can only access known properties "quantity"
  console.log(`the quantity of this item is ${item.quantity}`);
}

const fruit = {
  name: 'mango',
  quantity: 50,
};

const vehicle = {
  type: 'car',
  quantity: 3,
};

const person = {
  name: 'mario',
  age: 30,
};

// Edge Cases
printQuantity(fruit); // Valid (even though variable contain extra properties)
printQuantity(vehicle); // Valid (even though variables contain extra properties)
// printQuantity(person) <-- INVALID (not allowed)

// Passing object literals directly have to include only known interface properties
printQuantity({ quantity: 50 }); // Valid (can only contain exact properties of interface)
// printQuantity({ quantity: 50, title: 'something' }); <-- INVALID (not allowed)
```

## Function Signatures

**`type fnSig = (param1: type, param2: type) => returnType;`**

Function Signature details the type of the function "arguments" and its "return type"

Note: In order for a function to adhere/comply to a function signature, it does NOT have to have any or all of the arguments of the function signature **as long as its return type matches the function signature**

- As long as the function's arguments match the function signature's type, the function can have `<=` arguments

```ts
// Function Signatures
type Calculator = (numOne: number, numTwo: number) => number;

function addTwoNumbers(a: number, b: number) {
  return a + b;
}
function multiplyTwoNumbers(first: number, second: number) {
  return first * second;
}
function squareNumber(num: number) {
  return num * num;
}
function joinTwoNumbers(numOne: number, numTwo: number) {
  return `${numOne}${numTwo}`;
}

let calcFns: Calculator[] = [];

calcFns.push(addTwoNumbers);
calcFns.push(multiplyTwoNumbers);
calcFns.push(squareNumber); // Valid
// calcFns.push(joinTwoNumbers) <-- INVALID (not allowed) since returns a string

// Function Signatures On Interfaces
interface HasArea {
  name: string;
  calcArea: (a: number) => number; // Version 1
  // calcArea(a: number): number; // Version 2
}

const shapeOne: HasArea = {
  name: 'square',
  calcArea(length: number) {
    return length * length;
  },
};

const shapeTwo: HasArea = {
  name: 'circle',
  calcArea(radius: number) {
    return Math.PI * (radius ^ 2);
  },
};

shapeOne.calcArea(5);
shapeTwo.calcArea(10);
```

### Function Signatures inside Interfaces

#### Version 1

```ts
interface MyInter {
  myFunc: (x: number) => number; // Version 1
}
```

#### Version 2

```ts
interface MyInter {
  myFunc(x: number): number; // Version 2
}
```

## Extending Interfaces

**Note: There is NO SEMICOLON (;) at the end of the interface declaration**

**`interface extInter extends baseInter {}`**

Note: Function signatures are implicitly inherited (must be included when instantiating objects that comply to the extended interface)

```ts
// Extending Interfaces
interface hasFormatter {
  // format: () => string;
  format(): string;
}

// The `format(): string;` function signature is implicitly inherited
interface Bill extends hasFormatter {
  id: string | number;
  amount: number;
  server: string;
}

const user = {
  id: 1,
  format(): string {
    return `This user has an id of ${this.id}`;
  },
};

const bill = {
  id: 2,
  amount: 50,
  server: 'mario',
  format(): string {
    return `Bill with id ${this.id} has £${this.amount} to pay`;
  },
};

function printFormatted(val: hasFormatter): void {
  console.log(val.format());
}

function printBill(bill: Bill): void {
  console.log('server:', bill.server);
  console.log(bill.format());
}

// Testing the functions
printFormatted(user);
printFormatted(bill);
// printBill(user) <-- INVALID (not allowed)
printBill(bill);
```

## Extending Type Aliases

**`type extType = baseType & ...`**

- Where `...` could be anything
  - Array: `type extType = baseType & type[];`
  - Tuple: `type extType = baseType & [type1, type2, type3];`
  - Object: `type extType = baseType & { property1: type; property2: type; };`

```ts
// Extending Type Aliases
type Person = {
  id: string | number;
  firstName: string;
};

// `id: string | number` AND `firstName: string` properties are implicitly inherited
type User = Person & {
  email: string;
};

const personOne = {
  id: 1,
  firstName: 'mario',
};

// const personTwo = {
const personTwo: User = {
  id: '2',
  firstName: 'yoshi',
  email: 'yoshi@netninja.dev',
};

const personThree = {
  email: 'peach@netninja.dev',
};

function printUser(user: User): void {
  console.log(user.id, user.email, user.firstName);
}

// printUser(personOne) <-- INVALID (not allowed)
printUser(personTwo);
// printUser(personThree) <-- INVALID (not allowed)
```

# Classes

**`class MyClass {}`**

Instantiate class with the keyword **`new`**

- Interface = Way to enforce structure within values
- Class = Way to create objects with a certain structure

```ts
// Classes
type Base = 'classic' | 'thick' | 'thin' | 'garlic';

class Pizza {
  title: string;
  price: number;
  base: Base = 'classic';
  toppings: string[] = [];

  constructor(title: string, price: number) {
    this.title = title;
    this.price = price;
  }

  addTopping(topping: string): void {
    this.toppings.push(topping);
  }
  // addTopping = (topping: string): void => {
  //   this.toppings.push(topping);
  // };

  removeTopping(topping: string): void {
    this.toppings = this.toppings.filter((t) => t !== topping);
  }
  // removeTopping = (topping: string): void => {
  //   this.toppings = this.toppings.filter((t) => t !== topping);
  // };

  selectBase(b: Base): void {
    this.base = b;
  }
  // selectBase = (b: Base): void => {
  //   this.base = b;
  // };
}

const pizza = new Pizza('mario special', 15);
pizza.selectBase('garlic');
pizza.addTopping('mushrooms');
pizza.addTopping('olives');
console.log(pizza);
```

## Methods inside Classes

### Version 1

```ts
class Pizza {
  title: string;
  price: number;
  base: string = 'classic';
  toppings: string[] = [];

  constructor(title: string, price: number) {
    this.title = title;
    this.price = price;
  }

  addTopping(topping: string): void {
    this.toppings.push(topping);
  }
}
```

### Version 2

Arrow Function

```ts
class Pizza {
  title: string;
  price: number;
  base: string = 'classic';
  toppings: string[] = [];

  constructor(title: string, price: number) {
    this.title = title;
    this.price = price;
  }

  addTopping = (topping: string): void => {
    this.toppings.push(topping);
  };
}
```

## Access Modifiers

**`public`** (default): Class members (properties/fields, methods/functions) are accessible from ANYWHERE

**`private`**: Class members (properties/fields, methods/functions) are only accessible WITHIN the class itself

**`protected`**: Class members (properties/fields, methods/functions) are only accessible WITHIN the class and its subclasses

Recent convention is to use **prefix** of:

- `#` for `private` members
- `_` for `protected` members

Note: If you use `#` then you CANNOT use `private`. They are equivalent AND mutually exclusive

- See ECMAScript Private Fields

```js
class MyClass {
  #privateField: string;
  _protectedField: string;

  #privateMethod(): string {
    console.log(this.#privateField);
  }

  _protectedMethod(): string {
    console.log(this._protectedField);
  }
}
```

### Shortcut for Constructors

Shortcut: Placing access modifiers IN-FRONT of arguments in the `constructor()` function will CREATE AND SET the properties on the class instance (note: CANNOT omit `public` to get default access modifier)

```ts
// Access Modifiers
type Base = 'classic' | 'thick' | 'thin' | 'garlic';

class Pizza {
  private base: Base = 'classic';
  private toppings: string[] = [];

  // Shortcut
  constructor(private title: string, private price: number) {}

  // private title: string;
  // private price: number;
  // constructor(title: string, price: number) {
  //   this.title = title;
  //   this.price = price;
  // }

  addTopping(topping: string): void {
    this.toppings.push(topping);
  }
  removeTopping(topping: string): void {
    this.toppings = this.toppings.filter((t) => t !== topping);
  }
  selectBase(b: Base): void {
    this.base = b;
  }
}

const pizza = new Pizza('mario special', 15);
pizza.selectBase('garlic');
pizza.addTopping('mushrooms');
pizza.addTopping('olives');
// pizza.base = 'thick'; <-- INVALID (not allowed)
console.log(pizza);
```

## Classes as Types

**`class MyClass = { ... }`**
**`let var : myClass = new MyClass();`**

```ts
type Base = 'classic' | 'thick' | 'thin' | 'garlic';

class Pizza {
  private base: Base = 'classic';
  private toppings: string[] = [];

  // Shortcut
  constructor(private title: string, private price: number) {}

  // private title: string;
  // private price: number;
  // constructor(title: string, price: number) {
  //   this.title = title;
  //   this.price = price;
  // }

  addTopping(topping: string): void {
    this.toppings.push(topping);
  }
  removeTopping(topping: string): void {
    this.toppings = this.toppings.filter((t) => t !== topping);
  }
  selectBase(b: Base): void {
    this.base = b;
  }
}

// Explicit
const pizzaOne: Pizza = new Pizza('mario special', 15);
// Implicit (Inferred Type Inference)
const pizzaTwo = new Pizza('luigi special', 10);

function addMushroomsToPizzas(pizzas: Pizza[]): void {
  for (const p of pizzas) {
    p.addTopping('mushrooms');
  }
}

addMushroomsToPizzas([pizzaOne, pizzaTwo]);
console.log(pizzaOne, pizzaTwo);
```

## Getters + Setters

**`get fn(): returnType {}`**
**`set fn(): void {}`**

Getters allow functions to be invoked as properties

Pitfall: Common cause of errors is to have the NAME of properties/fields be the SAME as the NAME of the getters/setters for those properties/fields (which is NOT allowed)

Fix: Add prefix of `_` to the properties/fields

```ts
class Person {
  // #name: string; // Using ECMAScript Private Fields
  private _name: string;

  constructor(name: string) {
    this._name = name;
  }

  get name(): string {
    return this._name;
  }

  set name(newName: string) {
    this._name = newName;
  }
}

let person = new Person('mario');
console.log(person.name);
person.name = 'peach';
```

## Inheritance

Keyword = **`extends`**

**`class newClass extends BaseClass {}`**

```ts
type Base = 'classic' | 'thick' | 'thin' | 'garlic';

class MenuItem {
  // Shortcut
  constructor(private title: string, private price: number) {}
  // private title: string;
  // private price: number;
  // constructor(title: string, price: number) {
  //   this.title = title;
  //   this.price = price;
  // }

  // Getter
  get details(): string {
    return `${this.title} - £${this.price}`;
  }
}

class Pizza extends MenuItem {
  private base: Base = 'classic';
  private toppings: string[] = [];

  constructor(title: string, price: number) {
    super(title, price);
  }

  addTopping(topping: string): void {
    this.toppings.push(topping);
  }
  removeTopping(topping: string): void {
    this.toppings = this.toppings.filter((t) => t !== topping);
  }
  selectBase(b: Base): void {
    this.base = b;
  }
}

const pizza = new Pizza('mario special', 15);
console.log(pizza.details);

function printMenuItem(item: MenuItem): void {
  console.log(item.details);
}

printMenuItem(pizza);
```

## Classes with Interfaces

Keyword = **`implements`**

**`class MyClass implements MyInterface {}`**

```ts
type Base = 'classic' | 'thick' | 'thin' | 'garlic';

interface hasFormatter {
  format(): string;
}

class MenuItem implements hasFormatter {
  // Shortcut
  constructor(private title: string, private price: number) {}
  // private title: string;
  // private price: number;
  // constructor(title: string, price: number) {
  //   this.title = title;
  //   this.price = price;
  // }

  get details(): string {
    return `${this.title} - £${this.price}`;
  }

  format() {
    return `This menu item is called '${this.title}' and is £${this.price}`;
  }
}

class Pizza extends MenuItem {
  private base: Base = 'classic';
  private toppings: string[] = [];

  constructor(title: string, price: number) {
    super(title, price);
  }

  addTopping(topping: string): void {
    this.toppings.push(topping);
  }
  removeTopping(topping: string): void {
    this.toppings = this.toppings.filter((t) => t !== topping);
  }
  selectBase(b: Base): void {
    this.base = b;
  }
}

const pizza = new Pizza('mario special', 15);
pizza.selectBase('garlic');
pizza.addTopping('mushrooms');
pizza.addTopping('peppers');
pizza.addTopping('olives');

function printFormatted(val: hasFormatter): void {
  console.log(val.format());
}

printFormatted(pizza);
```

## Abstract Classes

Keyword = **`abstract`**

**`abstract Class {}`**
**`abstract Class { abstract method(): returnType; }`**

Abstract Class = Class that has properties & methods (including abstract methods) and can be extended/inherited from by other classes but CANNOT be instantiated itself (cannot be used to make a new instance of that class itself)

```ts
type Base = 'classic' | 'thick' | 'thin' | 'garlic';

interface hasFormatter {
  format(): string;
}

abstract class MenuItem implements hasFormatter {
  // Shortcut
  constructor(private _title: string, private _price: number) {}
  // private _title: string;
  // private _price: number;
  // constructor(title: string, price: number) {
  //   this._title = title;
  //   this._price = price;
  // }

  get details(): string {
    return `'${this._title}' - £${this._price}`;
  }
  get title(): string {
    return this._title;
  }
  get price(): number {
    return this._price;
  }

  // Abstract Method
  abstract format(): string;
}

class Pizza extends MenuItem {
  private base: Base = 'classic';
  private toppings: string[] = [];

  constructor(title: string, price: number) {
    super(title, price);
  }

  addTopping(topping: string): void {
    this.toppings.push(topping);
  }
  removeTopping(topping: string): void {
    this.toppings = this.toppings.filter((t) => t !== topping);
  }
  selectBase(b: Base): void {
    this.base = b;
  }
  format(): string {
    let formatted = this.details + '\n';
    // Base
    formatted += `'${this.title}' is a pizza on a ${this.base} base `;
    // Toppings
    if (this.toppings.length < 1) {
      formatted += 'with no toppings.';
    }
    if (this.toppings.length > 0) {
      formatted += `with: ${this.toppings.join(', ')}`;
    }
    return formatted;
  }
}

const pizza = new Pizza('mario special', 15);
pizza.selectBase('garlic');
pizza.addTopping('mushrooms');
pizza.addTopping('peppers');
pizza.addTopping('olives');

function printFormatted(val: hasFormatter): void {
  console.log(val.format());
}

printFormatted(pizza);
```

## CSV Writer Project

`fs` module = File System Module

- Might get error because we are using a JavaScript module (and NOT a TypeScript module) in a TypeScript file
- Need to install a "type definition" file for that package (to tell TypeScript about the types within the package)
- `npm init -Y`
- `npm install -D @types/node`

```ts
// CSV Writer Project
import { appendFileSync } from 'fs';

interface Payment {
  id: number;
  amount: number;
  to: string;
  notes: string;
}

type PaymentColumns = ('id' | 'amount' | 'to' | 'notes')[];

class CSVWriter {
  private csvStr: string;

  constructor(private columns: PaymentColumns) {
    this.csvStr = this.columns.join(',') + '\n';
  }

  save(filename: string): void {
    appendFileSync(filename, this.csvStr);
    // Reset csvStr (since we just want to append to the created file after first call)
    this.csvStr = '\n';
    console.log('file saved to', filename);
  }

  addRows(values: Payment[]): void {
    let rows = values.map((v) => this.formatRow(v));
    this.csvStr += rows.join('\n');
    console.log(this.csvStr);
  }

  private formatRow(p: Payment): string {
    return this.columns.map((col) => p[col]).join(',');
  }
}

const writer = new CSVWriter(['id', 'amount', 'to', 'notes']);

writer.addRows([
  { id: 1, amount: 50, to: 'yoshi', notes: 'for design work' },
  { id: 2, amount: 75, to: 'mario', notes: 'for web dev work' },
]);

writer.save('./data/payments.csvStr');
```

# Generics

## Generic Functions

**`function myFunc<T>(arg: T): T { return arg; }`**

**`function myFunc<Type>(arg: Type): Type { return arg; }`**

```ts
// Example 1
function printAndReturnString(val: string): string {
  console.log(val);
  return val;
}
function printAndReturnNumber(val: number): number {
  console.log(val);
  return val;
}
function printAndReturnBoolean(val: boolean): boolean {
  console.log(val);
  return val;
}
// function printAndReturnAny(val: any): any {
//   console.log(val);
//   return val;
// }
function printAndReturnValue<T>(val: T): T {
  console.log(val);
  return val;
}

// This is implicitly inferred
// const resultOne: string = printAndReturnValue<string>('mario');
// const resultTwo: number = printAndReturnValue<number>(25);
const resultOne = printAndReturnValue<string>('mario');
const resultTwo = printAndReturnValue<number>(25);

// Example 2
function getRandomArrayValue<T>(values: T[]): T {
  const i = Math.floor(Math.random() * values.length);
  return values[i];
}

interface User {
  name: string;
  score: number;
}

const users: User[] = [
  { name: 'mario', score: 100 },
  { name: 'peach', score: 88 },
  { name: 'wario', score: 75 },
  { name: 'yoshi', score: 90 },
];

const randomUser = getRandomArrayValue<User>(users);
console.log(randomUser.name);
```

## Generic Functions + Intersection Types (Extended Type Aliases)

**`function myFunc<T>(arg: T): T & ... { return arg; }`**

- Where `...` could be:
  - A `type`
  - An `interface`

```ts
// Intersection Type (Extended Type Aliases) Recap
type Person = {
  firstName: string;
  id: number;
};

type User = Person & {
  email: string;
};
```

```ts
// Intersection Type (Extended Type Aliases) + Generic Function
interface HasID {
  id: number;
}

function addIdToValue<T>(val: T): T & HasID {
  // Generate number in range [0, 900_000_000) and add 100_000_000 to ENSURE final value is in range [100_000_000, 999_999_999]
  // Note: Largest number generated is 899_999_999.999999 (and adding 100_000_000 gives 999_999_999.999999)
  const id = Math.floor(Math.random() * 900_000_000 + 100_000_000);
  return { ...val, id };
}

interface Post {
  title: string;
  thumbsUp: number;
}

const post = addIdToValue<Post>({ title: 'Vegemite Recipes', thumbsUp: 250 });
console.log(post.id, post.title, post.thumbsUp);
```

## Generic Interfaces

**Note: There is NO SEMICOLON (;) at the end of the interface declaration**

**`interface InterfaceName<T> {}`**

**`interface InterfaceName<T> { property1: T, property2: T[] }`**

```ts
// Generic Interface
interface Collection<T> {
  data: T[];
  name: string;
}

const collectionOne: Collection<string> = {
  data: ['mario', 'luigi', 'peach', 'yoshi'],
  name: 'super mario characters',
};

const collectionTwo: Collection<number> = {
  data: [10, 15, 27, 3, 9, 34],
  name: 'winning lottery numbers',
};

function getRandomCollectionItem<T>(c: Collection<T>): T {
  const i = Math.floor(Math.random() * c.data.length);
  return c.data[i];
}

const resultOne = getRandomCollectionItem<string>(collectionOne);
// const resultTwo = randomCollectionItem(collectionTwo); // <-- Also valid
const resultTwo = getRandomCollectionItem<number>(collectionTwo);

console.log(resultOne, resultTwo);
```

## Generic Classes

**`class MyClass<T> {}`**

Instantiate class with the keyword **`new`**

```ts
// Generic Classes
class DataCollection<T> {
  constructor(private data: T[]) {}

  loadOne(): T {
    const i = Math.floor(Math.random() * this.data.length);
    return this.data[i];
  }
  loadAll(): T[] {
    return this.data;
  }
  add(val: T): T[] {
    this.data.push(val);
    return this.data;
  }
}

interface User {
  name: string;
  score: number;
}

const userDC = new DataCollection<User>([
  { name: 'mario', score: 100 },
  { name: 'peach', score: 78 },
  { name: 'yoshi', score: 85 },
]);

userDC.add({ name: 'luigi', score: 50 });

const user = userDC.loadOne();
const users = userDC.loadAll();

console.log('load one - ', userDC.loadOne());
console.log('load all - ', userDC.loadAll());
```

## Generic Constraints

Generic Constraint = Method to limit the types of data that can be passed into a generic function/interface/type alias/class

Note: You can only `extend` "interfaces" and "classes"

```ts
// Generic Constraints
interface HasId {
  id: number;
}

class DataCollection<T extends HasId> {
  constructor(private data: T[]) {}

  loadOne(): T {
    const i = Math.floor(Math.random() * this.data.length);
    return this.data[i];
  }
  loadAll(): T[] {
    return this.data;
  }
  add(val: T): T[] {
    this.data.push(val);
    return this.data;
  }
  deleteById(id: number): void {
    this.data = this.data.filter((item) => item.id !== id);
  }
}

interface User {
  name: string;
  score: number;
  id: number;
}

const users = new DataCollection<User>([
  { name: 'mario', score: 100, id: 3 },
  { name: 'peach', score: 78, id: 2 },
  { name: 'yoshi', score: 67, id: 1 },
]);

users.add({ name: 'luigi', score: 50, id: 4 });
users.deleteById(2);
console.log('load all - ', users.loadAll());
// load all -  [{ name: 'mario', score: 100, id: 3 }, { name: 'yoshi', score: 67, id: 1 }, { name: 'luigi', score: 50, id: 4 }]
```

```ts
type Animal = {
  name: string;
  age: number;
};

type Dog = Animal & {
  breed: string;
};

// Somehow generics can extend types...
function printName<T extends Animal>(animal: T) {
  console.log(animal.name);
}

const myDog: Dog = {
  name: 'Buddy',
  age: 5,
  breed: 'Golden Retriever',
};

printName(myDog);
// Buddy
```

## CSV Writer Project using Generics

`node --watch dist/PaymentsWriter.js`
`node --watch dist/EmployeeWriter.js`

```ts
// index.ts
import { appendFileSync } from 'fs';

export class CSVWriter<T> {
  constructor(private columns: (keyof T)[]) {
    this.csv = this.columns.join(',') + '\n';
  }

  private csv: string;

  save(filename: string): void {
    appendFileSync(filename, this.csv);
    this.csv = '\n';
    console.log('file saved to', filename);
  }

  addRows(values: T[]): void {
    let rows = values.map((v) => this.formatRow(v));
    this.csv += rows.join('\n');
  }

  private formatRow(values: T): string {
    return this.columns.map((col) => values[col]).join(',');
  }
}
```

```ts
// PaymentWriter.ts
import { CSVWriter } from './index';

interface Payment {
  id: number;
  amount: number;
  to: string;
  notes: string;
}

const paymentsWriter = new CSVWriter<Payment>(['amount', 'notes', 'id', 'to']);

// Add initial rows
paymentsWriter.addRows([
  { id: 1, amount: 30, notes: 'payment for plumbing work', to: 'yoshi' },
  { id: 2, amount: 50, to: 'peach', notes: 'payment for design work' },
  { id: 3, amount: 25, to: 'yoshi', notes: 'clearing a debt' },
]);

// Save the file
// paymentsWriter.save('data/payments.csv');
paymentsWriter.save('./data/payments.csv');
```

```ts
// EmployeeWriter.ts
import { CSVWriter } from './index';

export interface Employee {
  id: number;
  name: string;
  role: string;
  salary: number;
}

// Employee write
const employeeWriter = new CSVWriter<Employee>(['id', 'name', 'role', 'salary']);

employeeWriter.addRows([
  { id: 1, name: 'mario', role: 'web developer', salary: 50000 },
  { id: 2, name: 'peach', role: 'digital manager', salary: 50000 },
  { id: 3, name: 'yoshi', role: 'director', salary: 100000 },
]);

// employeeWriter.save('data/employees.csv');
employeeWriter.save('./data/employees.csv');
```

# TypeScript for the Web

## Using Parcel

[ParcelJS](https://parceljs.org/docs/)

```sh
pnpm init
# pnpm create vite my-ts-app --template vanilla-ts
pnpm add -D parcel
pnpm dlx parcel src/*.html
```

Project Folder Structure

```
root
- src/
  - styles/
    - index.css
  - ts/
    - models/
      - Pizza.ts
    - services/
      - DataResource.ts
    - create.js
    - index.ts
  - create.html
  - index.html
- .gitignore
- package.json
- package-lock.json
- tsconfig.json
- db.json
```

Add following to `index.html` and `create.html` files in the `<body></body>` tags

```html
<!-- src/index.html -->
<script src="./ts/index.ts" type="module"></script>
<!-- src/create.html -->
<script src="./ts/create.ts" type="module"></script>
```

## Data Resource Class

```ts
// src/ts/services/DataResource.ts
export class DataResource<T> {
  constructor(private endpoint: string) {}

  async loadAll() {}
  async loadOne(id: number) {}
  async delete(id: number) {}
  async save(data: T) {}
}
```

## Making a Pizza Model

```sh
# npm install -g json-server
pnpm add json-server
# Create db.json file in root folder > touch db.json
json-server --watch db.json
```

Note: `json-server` will automatically generate `id` properties for all values

```ts
// src/ts/models/Pizza.ts
import { DataResource } from '../services/DataResource';

export interface PizzaProps {
  // PizzaProps = PizzaProperties
  title: string;
  description: string;
  toppings: string[];
  price: number;
}

export const PizzaDR = new DataResource<PizzaProps>('http://localhost:3000/pizzas');

// PizzaDR.save({
//   title: 'Hawaiian',
//   description: 'Hawaiian pizza is a pizza originating in Canada, traditionally topped with pineapple, tomato sauce, cheese, and either ham or bacon',
//   toppings: ['mozzarella', 'pineapple', 'bacon'],
//   price: 10,
// });
```

## Fetching Data

```ts
// src/ts/services/DataResource.ts
export class DataResource<T> {
  constructor(private endpoint: string) {}

  async loadAll(): Promise<T[]> {
    const res = await fetch(this.endpoint);
    return res.json();
  }
  async loadOne(id: number) {}
  async delete(id: number) {}
  async save(data: T) {}
}
```

```ts
// src/ts/index.ts
import { Pizza } from './models/Pizza';
// import { PizzaDR } from './models/Pizza';

document.addEventListener('DOMContentLoaded', async () => {
  // Load the pizzas data
  const pizzas = await Pizza.loadAll();
  console.log(pizzas);
});
```

## Finishing Data Resource Class

```ts
// src/ts/services/DataResource.ts
export class DataResource<T> {
  constructor(private endpoint: string) {}

  async loadAll(): Promise<T[]> {
    const res = await fetch(this.endpoint);
    return res.json();
  }
  async loadOne(id: number): Promise<T> {
    const res = await fetch(`${this.endpoint}/${id}`);
    return res.json();
  }
  async delete(id: number): Promise<Response> {
    const res = await fetch(`${this.endpoint}/${id}`, {
      method: 'DELETE',
    });
    return res;
  }
  async save(data: T): Promise<Response> {
    const res = await fetch(this.endpoint, {
      method: 'POST',
      body: JSON.stringify(data),
      headers: { 'Content-Type': 'application/json' },
    });
    return res;
  }
}
```

## Querying the DOM

`Element` type = Any type of DOM element

`HTMLElement` type = Any type of HTML DOM element

An `HTMLElement` is an `Element`, as defined in the HTML extension to the DOM Level 2 Core specification:

```ts
interface HTMLElement extends Element {
  id: string;
  title: string;
  lang: string;
  dir: string;
  className: string;
}
```

```ts
// src/ts/index.ts
import { Pizza, PizzaProps } from './models/Pizza';

const rootElement = document.querySelector('.root')!; // <-- `!` tells TypeScript that rootElement will NEVER be null

function createPizzaTemplate(pizza: PizzaProps): string {
  return `
    <div class="pizza">
      <h2>${pizza.title}...</h2>
      <p class="toppings">${pizza.toppings.join(', ')}</p>
      <p>${pizza.description}</p>
      <span>£${pizza.price}</span>
    </div>
  `;
}

function renderTemplates(templates: string[], parent: Element): void {
  const templateElement = document.createElement('template');
  for (const t of templates) {
    templateElement.innerHTML += t;
  }
  parent.append(templateElement.content);
}

document.addEventListener('DOMContentLoaded', async () => {
  // Load the pizza data
  const pizzas = await Pizza.loadAll();
  // Create template string for each pizza
  // const pizzaTemplates = pizzas.map(createPizzaTemplate);
  const pizzaTemplates = pizzas.map((p) => createPizzaTemplate(p));
  // Render pizza templates to DOM
  renderTemplates(pizzaTemplates, rootElement);
});
```

## Type Assertion

**`var as type`**

```ts
// src/ts/create.ts
const titleInput = document.querySelector('input[name="title"]') as HTMLInputElement;
const descriptionInput = document.querySelector('textarea') as HTMLTextAreaElement;
const form = document.querySelector('.create') as HTMLFormElement; // 'form.create' is also valid

form.addEventListener('submit', async (e) => {
  e.preventDefault();
});
```

## Form Data

Note: Need to add `name` attribute to html elements

Note: Extracted value of `input` fields are always of type string

```ts
import { Pizza, PizzaProps } from './models/Pizza';

const form = document.querySelector('.create') as HTMLFormElement;

form.addEventListener('submit', async (e) => {
  e.preventDefault();
  const data = new FormData(form);
  // Note: Need to add 'name' attribute to html elements
  // Note: Extracted value of 'input' fields are always of type string
  const newPizza: PizzaProps = {
    title: data.get('title') as string,
    description: data.get('description') as string,
    toppings: data.getAll('toppings') as string[],
    price: parseInt(data.get('price') as string),
  };
  const res = await Pizza.save(newPizza);
  if (!res.ok) {
    console.log('not able to save the pizza');
  }
  if (res.ok) {
    window.location.href = '/';
  }
});
```

# TypeScript + NextJS

## Project Setup

```sh
pnpm dlx create-next-app@latest my-app
pnpm run dev
```

Create routes by creating a folder name which matches the route (then create `page.tsx` file inside that folder for that route)

Note: Use `.tsx` file extension instead of `.jsx` file extension

## Component + Props

```tsx
// src/app/page.tsx
import PostCard from '@/components/PostCard';

export default function Home() {
  return (
    <main>
      <h2>Home</h2>
      <PostCard title='some title' author='mario' />
    </main>
  );
}
```

```tsx
// src/components/PostCard.tsx

// export default function PostCard(props: { title: string; author: string }) {
//   return (
//     <div className='card'>
//       <h2>{props.title}</h2>
//       <p>written by {props.author}</p>
//     </div>
//   );
// }

export default function PostCard({ title, author }: { title: string; author: string }) {
  return (
    <div className='card'>
      <h2>{title}</h2>
      <p>written by {author}</p>
    </div>
  );
}

interface PostCardProps {
  title: string;
  author: string;
}

export default function PostCard({ title, author }: PostCardProps) {
  return (
    <div className='card'>
      <h2>{title}</h2>
      <p>written by {author}</p>
    </div>
  );
}
```

## Fetching Data

[JSONPlaceholder](https://jsonplaceholder.typicode.com/guide/)

```tsx
// src/app/page.tsx
import PostCard from '@/components/PostCard';

interface Post {
  id: number;
  title: string;
  body: string;
}

const fetchPosts = async (): Promise<Post[]> => {
  const res = await fetch('https://jsonplaceholder.typicode.com/users/1/posts');
  if (!res.ok) {
    console.log('could not fetch the posts');
  }
  return res.json();
};

export default async function Home() {
  const posts = await fetchPosts();

  return (
    <main>
      <h2>Home</h2>
      {posts.map((post) => (
        <PostCard key={post.id} post={post} />
      ))}
    </main>
  );
}
```

```tsx
// src/components/PostCard.tsx
interface Post {
  id: number;
  title: string;
  body: string;
}

interface PostCardProps {
  post: Post;
}

export default function PostCard({ post }: PostCardProps) {
  return (
    <div className='card'>
      <h2>{post.title}</h2>
      <p>{post.body}</p>
    </div>
  );
}
```

## Type Definition Files

**`touch types.d.ts`** in ROOT folder of project

Makes a type available GLOBALLY (without needing to import)

Alternative is to `export` the type from a file and `import` when needed

```ts
// types.d.ts
interface Post {
  id: number;
  title: string;
  body: string;
}
```

```tsx
// src/app/page.tsx
import PostCard from '@/components/PostCard';

const fetchPosts = async (): Promise<Post[]> => {
  const res = await fetch('https://jsonplaceholder.typicode.com/users/1/posts');
  if (!res.ok) {
    console.log('could not fetch the posts');
  }
  return res.json();
};

export default async function Home() {
  const posts = await fetchPosts();

  return (
    <main>
      <h2>Home</h2>
      {posts.map((post) => (
        <PostCard key={post.id} post={post} />
      ))}
    </main>
  );
}
```

```tsx
// src/components/PostCard.tsx
interface PostCardProps {
  post: Post;
}

export default function PostCard({ post }: PostCardProps) {
  return (
    <div className='card'>
      <h2>{post.title}</h2>
      <p>{post.body}</p>
    </div>
  );
}
```

## Typed Links

Typed Links prevents making links to pages that do NOT exist

Make sure dev server is running `pnpm run dev`

```js
// next.config.js
/** @type {import('next').NextConfig} */
const nextConfig = {
  experimental: {
    typedRoutes: true, // <-- HERE
  },
};

module.exports = nextConfig;
```

```tsx
// src/app/layout.tsx
import './globals.css';
import type { Metadata } from 'next';
import { Inter } from 'next/font/google';
import Link from 'next/link';

const inter = Inter({ subsets: ['latin'] });

export const metadata: Metadata = {
  title: 'Create Next App',
  description: 'Generated by create next app',
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang='en'>
      <body className={inter.className}>
        <nav>
          <Link href='/'>Home</Link>
          <Link href='/about'>About</Link>
          <Link href='/contact'>Contact</Link> {/* <-- LINT ERROR */}
        </nav>
        {children}
      </body>
    </html>
  );
}
```
