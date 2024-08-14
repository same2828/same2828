# Table of Contents

- [Table of Contents](#table-of-contents)
- [Resources](#resources)
- [Installation](#installation)
- [Compiling TypeScript](#compiling-typescript)
- [Type Annotations](#type-annotations)
  - [TypeScript Primitives](#typescript-primitives)
  - [Non-Null Assertion Operator (Postfix `!`)](#non-null-assertion-operator-postfix-)
  - [Truthy/Falsy Values](#truthyfalsy-values)
    - [Truthy](#truthy)
    - [Falsy](#falsy)
- [Functions](#functions)
- [Objects](#objects)
  - [Type Aliases `type`](#type-aliases-type)
  - [Nested Objects](#nested-objects)
  - [Optional Properties `?`](#optional-properties-)
  - [`readonly` Modifer](#readonly-modifer)
  - [Intersection Types `&`](#intersection-types-)
- [Arrays `[]`](#arrays-)
- [Union Types `|`](#union-types-)
- [Tuples `[Type1, Type2]`](#tuples-type1-type2)
- [Enums `enum`](#enums-enum)
  - [Enums Behind the Scenes](#enums-behind-the-scenes)
- [Interfaces `interface`](#interfaces-interface)
  - [`readonly` + Optional `?` Interface Properties](#readonly--optional--interface-properties)
  - [Interface Methods](#interface-methods)

# Resources

- [TypeScript Playground](https://www.typescriptlang.org/play/)

# Installation

```sh
npm install -g typescript
```

# Compiling TypeScript

```sh
tsc fileName.ts
```

# Type Annotations

> **`let var: type; var = value;`**
>
> **`let var: type = value;`**

```ts
// String Variable With Explicit Annotation
let movieTitle: string = 'Amadeus';
movieTitle = 'Arrival';
movieTitle = 9; //This results in an error!
movieTitle.toUpperCase();

// Number Variable with explicit annotation
let numCatLives: number = 9;
numCatLives += 1;
numCatLives = 'zero'; //Error!

// Explicitly typed boolean variable
let gameOver: boolean = false;
gameOver = true;
gameOver = 'true'; //error!!

// Type Inference
let tvShow = 'Olive Kitteridge';
tvShow = 'The Other Two';
tvShow = false;

let isFunny = false;
isFunny = true;
isFunny = 'asd';

// the any type
let thing: any = 'hello'; //This is not a great idea!
thing = 1;
thing = false;
thing();
thing.toUpperCase();

const movies = ['Arrival', 'The Thing', 'Aliens', 'Amadeus'];
let foundMovie: string;

for (let movie of movies) {
  if (movie === 'Amadeus') {
    foundMovie = 'Amadeus';
  }
}
```

## TypeScript Primitives

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

## Non-Null Assertion Operator (Postfix `!`)

> `variable!`

Appending `!` to a variable/expression is a way to tell the compiler "this expression cannot be null or undefined here, so don't complain about the possibility of it being null or undefined"

The operation `x!` produces a value of the type of `x` with `null` and `undefined` EXCLUDED

```ts
function duplicate(text: string | null) {
  if (text === null || text === undefined) {
    text = '';
  }
  // return text.concat(text);
  return text!.concat(text!); // Note: Needed when `strict mode` is turned ON
}
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

# Functions

> `function myFunction1(param1: type1, param2: type2): returnType { ... }`
>
> `const myFunction2 = (param1: type1, param2: type2): returnType => { ... }`

```ts
// Function parameter type annotations
const printSomething = (person: string, age: number, isFunny: boolean): void => {
  console.log(`${person} is ${isFunny === true ? '' : 'not '}funny`);
};

// Return type annotation
function greet(person: string = 'stranger'): string {
  return `Hi there, ${person}!`;
}

function square(num: number): number {
  return num * num;
}

square(3);
greet('Tonya Harding');
doSomething('ChickenFace', 78, true);

// Arrow function
const add = (x: number, y: number): number => {
  return x + y;
};

// Contextual Type Clues
const colors = ['red', 'orange', 'yellow'];
colors.map((color) => {
  return color.toUpperCase();
});

// `void` type
function printTwice(msg: string): void {
  console.log(msg);
  console.log(msg);
}

// `never` type
function makeError(msg: string): never {
  throw new Error(msg);
}

function gameLoop(): never {
  while (true) {
    console.log('GAME LOOP RUNNING!');
  }
}
```

```ts
/*
// Write a function called "twoFer" that accepts a person's name
// It should return a string in the format "one for <name>, one for me"
// If no name is provided, it should default to "you"
// twoFer() => "One for you, one for me"
// twoFer("Elton") => "One for Elton, one for me"
*/
function twoFer(person: string = 'you'): string {
  return `One for ${person}, one for me.`;
}

console.log(twoFer());
console.log(twoFer('Elvis'));
```

```ts
/*
Write a isLeapyear() function that accepts a year and returns true/false depending on if the year is a leap year
isLeapYear(2012) => true
isLeapYear(2013) => false
A year is a leapyear if the (year is a multiple of 4 and not a multiple of 100) or the year is a multiple of 400
*/
const isLeapYear = (year: number): boolean => {
  if (year % 4 === 0 && year % 100 !== 0) {
    return true;
  } else if (year % 400 === 0) {
    return true;
  }
  return false;
};

const isLeapYear2 = (year: number): boolean => {
  return (year % 4 === 0 && year % 100 !== 0) || year % 400 === 0;
};

console.log(isLeapYear(2012));
console.log(isLeapYear(2013));
```

# Objects

```ts
// Objects as parameters
function printName(person: { first: string; last: string }): void {
  console.log(`${person.first} ${person.last}`);
}

printName({ first: 'Thomas', last: 'Jenkins' });

const singer = { first: 'Mick', last: 'Jagger', age: 473, isAlive: true };
printName(singer);
```

## Type Aliases `type`

> `type MyType = {};`

```ts
// let coordinate: { x: number; y: number } = { x: 34, y: 2 };

// function randomCoordinate(): { x: number; y: number } {
//   return { x: Math.random(), y: Math.random() };
// }

// function doublePoint(point: { x: number; y: number }): { x: number; y: number } {
//   return { x: point.x * 2, y: point.y * 2 };
// }

type Point = {
  x: number;
  y: number;
};

let coordinate: Point = { x: 34, y: 2 };

function randomCoordinate(): Point {
  return { x: Math.random(), y: Math.random() };
}

function doublePoint(point: Point): Point {
  return { x: point.x * 2, y: point.y * 2 };
}
```

## Nested Objects

```ts
type Song = {
  title: string;
  artist: string;
  numStreams: number;
  credits: { producer: string; writer: string };
};

function calculatePayout(song: Song): number {
  return song.numStreams * 0.0033;
}

function printSong(song: Song): void {
  console.log(`${song.title} - ${song.artist}`);
}

const mySong: Song = {
  title: 'Unchained Melody',
  artist: 'Righteous Brothers',
  numStreams: 12873321,
  credits: {
    producer: 'Phil Spector',
    writer: 'Alex North',
  },
};

const earnings = calculatePayout(mySong);
console.log(earnings);
printSong(mySong);
```

## Optional Properties `?`

> `property?: type;`

```ts
type Point = {
  x: number;
  y: number;
  z?: number;
};

const myPoint: Point = { x: 1, y: 3 };
```

## `readonly` Modifer

> `readonly property: type;`

```ts
type User = {
  readonly id: number;
  username: string;
};

const user: User = {
  id: 12837,
  username: 'mario',
};

console.log(user.id);
user.id = 5; // INVAILD/ERROR
```

## Intersection Types `&`

> `type Type3 = Type1 & Type2;`

```ts
type Circle = {
  radius: number;
};

type Colorful = {
  color: string;
};

type ColorfulCircle = Circle & Colorful;

const happyFace: ColorfulCircle = {
  radius: 4,
  color: 'yellow',
};
```

```ts
type Cat = {
  numLives: number;
};

type Dog = {
  breed: string;
};

type CatDog = Cat & Dog & { age: number };

const christy: CatDog = {
  numLives: 7,
  breed: 'Husky',
  age: 9,
};
```

```ts
/*
Write the Movie type alias to make the following two variables properly typed
Make sure that "originalTitle" is optional and "title" is readonly
*/
type Movie = {
  readonly title: string;
  originalTitle?: string;
  director: string;
  releaseYear: number;
  boxOffice: {
    budget: number;
    grossUS: number;
    grossWorldwide: number;
  };
};

const dune: Movie = {
  title: 'Dune',
  originalTitle: 'Dune Part One',
  director: 'Denis Villeneuve',
  releaseYear: 2021,
  boxOffice: {
    budget: 165000000,
    grossUS: 108327830,
    grossWorldwide: 400671789,
  },
};

const cats: Movie = {
  title: 'Cats',
  director: 'Tom Hooper',
  releaseYear: 2019,
  boxOffice: {
    budget: 95000000,
    grossUS: 27166770,
    grossWorldwide: 73833348,
  },
};
```

```ts
/*
Write a function called getProfit that accepts a single Movie object
It should return the movie's worldwide gross minus its budget
E.g. getProfit(cats) => -21166652
*/
function getProfit1(movie: Movie): number {
  return movie.boxOffice.grossWorldwide - movie.boxOffice.budget;
}

function getProfit2(movie: Movie): number {
  const { grossWorldwide, budget } = movie.boxOffice;
  return grossWorldwide - budget;
}

function getProfit3({ boxOffice: { grossWorldwide, budget } }: Movie): number {
  return grossWorldwide - budget;
}

console.log(getProfit1(dune));
console.log(getProfit1(cats));
```

# Arrays `[]`

> `arr: type[] = [];`
>
> `arr: Array<type> = [];`

```ts
// INVALID/ERROR
// const arr: [] = [];

// String array
const activeUsers: string[] = [];
activeUsers.push('Tony');

// Number array
const ageList: number[] = [45, 56, 13];
ageList[0] = 99;

// Alternate Syntax: Array<type>
const bools1: Array<boolean> = [];
const bools2: boolean[] = [];

// Array of Custom Types
type Point = {
  x: number;
  y: number;
};

const coords: Point[] = [];
coords.push({ x: 23, y: 8 });

// Multi-dimensional string array
const board: string[][] = [
  ['X', 'O', 'X'],
  ['X', 'O', 'X'],
  ['X', 'O', 'X'],
];
```

```ts
// Create an empty array of numbers called "ages"
const ages: number[] = [];

// Create an array variable called gameBoard that starts as an empty array.
// It should be typed to hold a 2 dimensional array of strings
const gameBoard: string[][] = [];

// Create a Product type that contains a name and a price.
// An example product could be
// {name: "coffee mug", price: 11.50}
type Product = {
  name: string;
  price: number;
};

// Write a function called getTotal that accepts an array of Product types
// It should return the sum of all the products' prices
function getTotal(products: Product[]): number {
  let total = 0;
  for (let product of products) {
    total += product.price;
  }
  return total;
}
```

# Union Types `|`

> `variable: Type1 | Type2`

```ts
// Basic Union Type
let age: number | string = 21;
age = 23;
age = '24';

type Point = {
  x: number;
  y: number;
};

type Coords = {
  lat: number;
  long: number;
};

// Union type with type aliases
let coordinates: Point | Coords = { x: 1, y: 34 };
coordinates = { lat: 321.213, long: 23.334 };

// Function parameter union type
function printAge(age: number | string): void {
  console.log(`You are ${age} years old`);
}

function calculateTax(price: number | string, tax: number): number {
  if (typeof price === 'string') {
    price = parseFloat(price.replace('$', ''));
  }
  return price * tax;
}

// const nums: number[] = [1,2,3,4]
// const anyArr: any[] = [1,2,3,4, true, "asdas", {}]
const unionArr1: (number | string)[] = [1, 2, 3, 'hello'];

// Note: This means EITHER number[] OR string[] ONLY (NOT BOTH)
const arr1: number[] | string[] = ['hello', 'world'];
const arr2: number[] | string[] = [1, 2];

// Union Type With Arrays
const coords: (Point | Coords)[] = [];
coords.push({ lat: 321.213, long: 23.334 });
coords.push({ x: 213, y: 43 });

// Literal Types
let zero: 0 = 0;
let mood: 'Happy' | 'Sad' = 'Happy';
mood = 'Sad';

type DayOfWeek = 'Monday' | 'Tuesday' | 'Wednesday' | 'Thursday' | 'Friday' | 'Saturday' | 'Sunday';

let today: DayOfWeek = 'Sunday';
```

```ts
/*
Create a variable called highScore that can be a number OR a boolean
*/
let highScore: number | boolean;
highScore = 1;
highScore = false;

/*
Create an array called numStrArr
It can be an array of numbers OR an array of strings
It cannot be an array of numbers and strings (mixed together)
*/
const numStrArr: number[] | string[] = [];

/*
Create a literal type called SkillLevel
There are 4 allowed values: "Beginner", "Intermediate", "Advanced", and "Expert"
*/
type SkillLevel = 'Beginner' | 'Intermediate' | 'Advanced' | 'Expert';

/*
Create a type called SkiSchoolStudent
name must be a string
age must be a number
sport must be "ski" or "snowboard"
level must be a value from the SkillLevel type (from above)
*/
type SkiSchoolStudent = {
  name: string;
  age: number;
  sport: 'ski' | 'snowboard';
  level: SkillLevel;
};
```

```ts
/*
Define a type to represent an RGB color
r should be a number
g should be a number
b should be a number
*/
type RGB = {
  r: number;
  g: number;
  b: number;
};

/*
Define a type to represent an HSL color
h should be a number
s should be a number
l should be a number
*/
type HSL = {
  h: number;
  s: number;
  l: number;
};

/*
Create an array called colors that can hold a mixture of RGB and HSL color types
*/
const colors: (RGB | HSL)[] = [];
```

```ts
/*
Write a function called greet that accepts a single string OR an array of strings
It should print "Hello, <name>" for that single person OR greet each person in the array with the same format
*/
const greet = (person: string | string[]): void => {
  if (typeof person === 'string') {
    console.log(`Hello, ${person}`);
  } else {
    for (let p of person) {
      console.log(`Hello, ${p}`);
    }
  }
};
```

# Tuples `[Type1, Type2]`

> `variable: [Type1, Type2] = [var1, var2]`

- **Tuples are arrays of FIXED LENGTH and FIXED TYPE**
- NOte: TypeScript only enforces/verifies Tuples upon creation/instantiation
- Note: After a tuple has been created, TypeScript does NOT prevent you from adding/removing to the tuple via `.push()`/`.pop()` (this is a limitation of TypeScript)

```ts
// Note: These are NOT tuples
// const stuff: (string | number)[] = [1,'asd', 'asdasd', 'asdasd', 2]
// const color: number[] = [23,45,234,234]

const color: [number, number, number] = [255, 0, 45];

type HTTPResponse = [number, string];

const okRes: HTTPResponse = [200, 'OK'];
// okRes.push(404); // <-- Note: This is valid in TypeScript

// An array of tuple
const responses: HTTPResponse[] = [
  [404, 'Not Found'],
  [200, 'OK'],
];
```

# Enums `enum`

> `enum MyNum { VAL1, VAL2 }`

```ts
// Enum Example
enum OrderStatus {
  PENDING,
  SHIPPED,
  DELIVERED,
  RETURNED,
}

// Default Enum Values if none are specified
enum OrderStatus2 {
  PENDING = 0
  SHIPPED = 1
  DELIVERED = 2
  RETURNED = 3
}

const myStatus = OrderStatus.DELIVERED;

function isDelivered(status: OrderStatus) {
  return status === OrderStatus.DELIVERED;
}

isDelivered(OrderStatus.RETURNED);
isDelivered(0);

// Default Enum Values if one is specified
enum OrderStatus3 {
  PENDING = 11,
  SHIPPED; // = 12
  DELIVERED; // = 13
  RETURNED; // = 14
}

enum OrderStatus4 {
  PENDING; // = 0
  SHIPPED = 5;
  DELIVERED; // = 6
  RETURNED; // = 7
}

// String Enum
enum ArrowKeys {
  UP = 'up',
  DOWN = 'down',
  LEFT = 'left',
  RIGHT = 'right',
}

// Mixed Enum
enum ArrowKeys {
  UP = 'up',
  DOWN = 'down',
  LEFT = 'left',
  RIGHT = 'right',
  ERROR = 404
}
```

## Enums Behind the Scenes

```ts
enum OrderStatus {
  PENDING,
  COMPLETED,
  CANCELLED,
}

interface Order {
  orderNumber: number;
  status: OrderStatus;
}

const order: Order = {
  orderNumber: 10,
  status: OrderStatus.PENDING,
};
```

compiles to

```js
'use strict';
var OrderStatus;
(function (OrderStatus) {
  OrderStatus[(OrderStatus['PENDING'] = 0)] = 'PENDING';
  OrderStatus[(OrderStatus['COMPLETED'] = 1)] = 'COMPLETED';
  OrderStatus[(OrderStatus['CANCELLED'] = 2)] = 'CANCELLED';
})(OrderStatus || (OrderStatus = {}));

const order = {
  orderNumber: 10,
  status: OrderStatus.PENDING,
};
```

One optimisation is to use `const enum` to get compiler to replace every enum value with its underlying type/value

```js
'use strict';
var OrderStatus;
(function (OrderStatus) {
  OrderStatus[(OrderStatus['PENDING'] = 0)] = 'PENDING';
  OrderStatus[(OrderStatus['COMPLETED'] = 1)] = 'COMPLETED';
  OrderStatus[(OrderStatus['CANCELLED'] = 2)] = 'CANCELLED';
})(OrderStatus || (OrderStatus = {}));

const order = {
  orderNumber: 99,
  status: 0,
};
```

# Interfaces `interface`

> `interface MyInterface { val1: type1; val2: type2; }`
>
> Note: Interfaces ONLY work for OBJECTS

```ts
// Point as a TYPE ALIAS
// type Point = {
//   x: number;
//   y: number;
// };
// const point: Point = {x: 213, y:12}

// Point using an INTERFACE
interface Point {
  x: number;
  y: number;
}

const point: Point = { x: 123, y: 1234 };
```

## `readonly` + Optional `?` Interface Properties

```ts
interface Person {
  readonly id: number;
  first: string;
  last: string;
  nickname?: string;
}

const thomas: Person = {
  first: 'Thomas',
  last: 'Hardy',
  nickname: 'Tom',
  id: 21837,
};

thomas.first = 'Seth';
// INVALID due to `readonly`
// thomas.id = 238974;
```

## Interface Methods

> `interface MyInterface1 { method: () => returnType }`
>
> `interface MyInterface2 { method(): returnType }`

```ts
interface Person {
  readonly id: number;
  first: string;
  last: string;
  nickname?: string;
  // sayHi: () => string; // V1
  sayHi(): string; // V2
}

const thomas: Person = {
  first: 'Thomas',
  last: 'Hardy',
  nickname: 'Tom',
  id: 21837,
  sayHi: () => {
    return 'Hello!';
  },
};
```

```ts
interface Product {
  name: string;
  price: number;
  applyDiscount(discount: number): number;
}

const shoes: Product = {
  name: 'Blue Suede Shoes',
  price: 100,
  applyDiscount(amount: number) {
    const newPrice = this.price * (1 - amount);
    this.price = newPrice;
    return this.price;
  },
};

console.log(shoes.applyDiscount(0.4));

// Re-opening an interface
interface Dog {
  name: string;
  age: number;
}

interface Dog {
  breed: string;
  bark(): string;
}

const elton: Dog = {
  name: 'Elton',
  age: 0.5,
  breed: 'Australian Shepherd',
  bark() {
    return 'WOOF WOOF!';
  },
};

// Extending an interface
interface ServiceDog extends Dog {
  job: 'drug sniffer' | 'bomb' | 'guide dog';
}

const chewy: ServiceDog = {
  name: 'Chewy',
  age: 4.5,
  breed: 'Lab',
  bark() {
    return 'Bark!';
  },
  job: 'guide dog',
};

interface Human {
  name: string;
}

interface Employee {
  readonly id: number;
  email: string;
}

// Extending multiple interfaces
interface Engineer extends Human, Employee {
  level: string;
  languages: string[];
}

const pierre: Engineer = {
  name: 'Pierre',
  id: 123897,
  email: 'pierre@gmail.com',
  level: 'senior',
  languages: ['JS', 'Python'],
};
```
