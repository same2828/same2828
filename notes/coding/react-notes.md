# Table of Contents

- [Table of Contents](#table-of-contents)
- [Docs Links](#docs-links)
- [Dev Setup](#dev-setup)
  - [Global](#global)
  - [Project](#project)
    - [Initialisation/Creation](#initialisationcreation)
    - [NPM Packages](#npm-packages)
  - [Migration](#migration)
    - [NPM -\> Yarn](#npm---yarn)
    - [Create-React-App (CRA) -\> Vite](#create-react-app-cra---vite)
  - [Cloning Projects](#cloning-projects)
- [Notes](#notes)
  - [Conditional Rendering](#conditional-rendering)
  - [Conditional Class Names](#conditional-class-names)
  - [Importing/Exporting](#importingexporting)
    - [Default Export](#default-export)
      - [Version 1](#version-1)
      - [Version 2](#version-2)
      - [Version 3](#version-3)
    - [Named Export (Module)](#named-export-module)
      - [ES6 Single Module](#es6-single-module)
      - [ES6 Multiple Modules](#es6-multiple-modules)
        - [Version 1](#version-1-1)
        - [Version 2](#version-2-1)
    - [Default + Named Export](#default--named-export)
  - [`.map()`](#map)
  - [Functions](#functions)
    - [Version 1](#version-1-2)
    - [Version 2](#version-2-2)
    - [Callback Functions (for updating states that depend on previous states)](#callback-functions-for-updating-states-that-depend-on-previous-states)
  - [Props](#props)
    - [Version 1 (Using Destructuring)](#version-1-using-destructuring)
    - [Version 2 (Props Param)](#version-2-props-param)
  - [Timing](#timing)
  - [Troubleshooting](#troubleshooting)
  - [Truthy/Falsy Values](#truthyfalsy-values)
    - [Truthy](#truthy)
    - [Falsy](#falsy)
- [Hooks](#hooks)
  - [useState](#usestate)
    - [Anonymous Updater Function](#anonymous-updater-function)
    - [2 Way Binding](#2-way-binding)
    - [Single Event Handler For Multiple Fields](#single-event-handler-for-multiple-fields)
    - [Updating Nested Objects](#updating-nested-objects)
    - [Updating Arrays](#updating-arrays)
      - [Appending to Array](#appending-to-array)
      - [Inserting into Array (using `.slice()`)](#inserting-into-array-using-slice)
      - [Removing from Array (using `.filter()`)](#removing-from-array-using-filter)
      - [Updating Elements in Array Array (using `.map()`)](#updating-elements-in-array-array-using-map)
      - [Sorting an Array](#sorting-an-array)
      - [Updating Nested Objects in Array](#updating-nested-objects-in-array)
    - [Reacting to Input with State](#reacting-to-input-with-state)
    - [Sharing State Between Components](#sharing-state-between-components)
    - [Same Component at the Same Position Preserves State](#same-component-at-the-same-position-preserves-state)
    - [Different Components at the Same Position Resets State](#different-components-at-the-same-position-resets-state)
    - [Resetting State at the Same Position](#resetting-state-at-the-same-position)
      - [Version 1 - Render a Component in Different Position](#version-1---render-a-component-in-different-position)
      - [Version 2 - Resetting State with a Key](#version-2---resetting-state-with-a-key)
  - [useEffect](#useeffect)
    - [Cleanup Function](#cleanup-function)
    - [Anonymous Updater Function](#anonymous-updater-function-1)
    - [Handling useEffect Firing 2x in Development](#handling-useeffect-firing-2x-in-development)
    - [Subscribing to Events](#subscribing-to-events)
    - [Triggering Animations](#triggering-animations)
    - [Fetching Data](#fetching-data)
      - [Aborting Fetch](#aborting-fetch)
    - [Initialising Application (Auth)](#initialising-application-auth)
      - [Version 1](#version-1-3)
      - [Version 2](#version-2-3)
  - [useReducer](#usereducer)
    - [Dispatch Action](#dispatch-action)
    - [Reducer Function](#reducer-function)
    - [Using Reducer within Component](#using-reducer-within-component)
  - [useContext](#usecontext)
    - [Create the Context](#create-the-context)
    - [Provide and Use the Context](#provide-and-use-the-context)
    - [Using And Providing Context From The Same Component (prop-less method)](#using-and-providing-context-from-the-same-component-prop-less-method)
    - [useContext + useReducer (to scale up)](#usecontext--usereducer-to-scale-up)
  - [useRef](#useref)
    - [Stopwatch Example](#stopwatch-example)
    - [Refs vs State](#refs-vs-state)
    - [Manipulating DOM with Refs](#manipulating-dom-with-refs)
    - [Manage List of Refs using a Ref Callback](#manage-list-of-refs-using-a-ref-callback)

# Docs Links

- [Learn Docs](https://react.dev/learn)
- [Reference Docs](https://react.dev/reference/react)

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

```sh
pnpm add -D vitest
pnpm add react-router
# Tailwind
pnpm add -D tailwindcss postcss autoprefixer
pnpm tailwindcss init -p
```

## Migration

### NPM -> Yarn

- cd into folder that was initialised with `npx create-react-app`
- `yarn`
- Delete `package-lock.json`

### Create-React-App (CRA) -> Vite

- Method 1
  - Create new Vite app with `pnpm create vite`
  - Move `public` folder from your old CRA to this new project except `index.html`
  - Move any changes you made to CRA `public/index.html` to the new `index.html` in Vite project
  - Move `src` folder except `index.tsx`
- [Tool](https://github.com/bhbs/viject)

## Cloning Projects

cd into project directory

```sh
pnpm install
pnpm dev || pnpm run dev
```

```sh
yarn || yarn install
yarn dev || yarn run dev
```

# Notes

## Conditional Rendering

**Version 1**

```jsx
{
  emails.length < 10 && (
    <button
      className='btn btn-primary'
      id='add-more-btn'
      onClick={(event) => {
        const newEmails = [...emails];
        newEmails.push('');
        newEmails.push('');
        setEmails(newEmails);
      }}
    >
      Add More
    </button>
  );
}
```

**Version 2**

```jsx
{
  emails.length < 10 ? (
    <button
      className='btn btn-primary'
      id='add-more-btn'
      onClick={(event) => {
        const newEmails = [...emails];
        newEmails.push('');
        newEmails.push('');
        setEmails(newEmails);
      }}
    >
      Add More
    </button>
  ) : (
    <>No more adding</>
  );
}
```

## Conditional Class Names

Use ternary operators

```jsx
export const SingleCard = ({ card, handleChoice, flipped }) => {
  return (
    <div className='card'>
      <div className={flipped ? 'flipped' : ''}>
        <img className='front' src={card.src} alt='card front' />
        <img className='back' src='/img/cover.png' onClick={() => handleClick(card)} alt='cover' />
      </div>
    </div>
  );
};
```

## Importing/Exporting

### Default Export

Note can only have ONE default export

**Usage: `import MyComponent from file.js`**

#### Version 1

```jsx
export default function MyComponent() {
  return (
    //...
  );
}
```

#### Version 2

```jsx
function MyComponent() {
  return (
    //...
  );
}

export default MyComponent
```

#### Version 3

```jsx
const MyComponent = () => {
  return (
    //...
  );
};

export default MyComponent;
```

### Named Export (Module)

**Usage: `import { MyComponent } from file.jsx`**

#### ES6 Single Module

file.jsx

```jsx
export const MyComponent = () => {
  return (
    <div className="ctnr" style={someCss}>
    <div>
  );
};
```

#### ES6 Multiple Modules

**Usage: `import { MyComponent1, MyComponent2, MyComponent3 } from file.jsx`**

##### Version 1

```jsx
const func1 = () => console.log('Hello');
const func2 = () => console.log('Word');
const func3 = () => console.log('Universe');

export { func1, func2, func3 };
```

##### Version 2

```jsx
export const func1 = () => console.log('Hello');
export const func2 = () => console.log('Word');
export const func3 = () => console.log('Universe');
```

### Default + Named Export

When a component is 'default' exported (i.e. `export default functionName`), you import it as `import functionName from fileName.js` and do NOT use `import { functionName } from fileName.js`

**Usage: `import DefaultComponent, { MyComponent2 }` from './file.jsx'**

```jsx
// Default export
export default function DefaultComponent() {
  return (
    //...
  );
}

// Named export
export const MyComponent2 = () => {
  return (
    //...
  );
};
```

## `.map()`

- `parent.map((item, index) => {})`
- Must give `key` prop to each child

Example 1

```jsx
{
  emails.map((email, index) => {
    return <div key={index}>Email: {email}</div>;
  });
}
```

Example 2

```jsx
<div className='mb-3' id='email-inputs'>
  {emails.map((email, index) => {
    return (
      <div key={index} class='email-input'>
        <label class='form-label'>Email Address {index + 1}</label>
        <input
          type='email'
          class='form-control'
          placeholder='name@example.com'
          onKeyDown={(event) => {
            const newEmails = [...emails];
            newEmails[index] = event.target.value;
            setEmails(newEmails);
          }}
        />
      </div>
    );
  })}
</div>
```

## Functions

### Version 1

- Can only use this when there are NO parameters passed to the function

```jsx
const handleClick = () => console.log('clicked!');
<button onClick={handleClick}></button>;
```

### Version 2

- MUST use this when there ARE parameters passed to the function

```jsx
const handleClick = (id) => console.log('clicked!');
// Parameter from event
<button onClick={(e) => handleClick(e.id)}></button>;
// Parameter from props
<button onClick={() => handleClick(otherVar)}></button>;
```

### Callback Functions (for updating states that depend on previous states)

```jsx
import './App.css';
import { useState } from 'react';

function App() {
  const [events, setEvents] = useState([
    { title: "mario's birthday bash", id: 1 },
    { title: "bowser's live stream", id: 2 },
    { title: 'race on moo moo farm', id: 3 },
  ]);

  const handleClick = (id) => {
    setEvents((prevEvents) => {
      return prevEvents.filter((e) => id !== e.id);
    });
  };

  return (
    <div className='App'>
      {events.map((event, index) => (
        <div key={event.id}>
          <h2>
            {index} - {event.title}
          </h2>
          <button onClick={() => handleClick(event.id)}>Delete Event</button>
        </div>
      ))}
    </div>
  );
}

export default App;
```

## Props

- Example

  ```jsx
  const subtitle = 'All the latest events in Marioland';
  <Title title='Marioland Events' subtitle={subtitle} />;
  ```

### Version 1 (Using Destructuring)

```jsx
export default function Title({ title, subtitle }) {
  return (
    <div>
      <h1 className='title'>{title}</h1>
      <br />
      <h2 className='subtitle'>{subtitle}</h2>
    </div>
  );
}
```

### Version 2 (Props Param)

```jsx
export default function Title(props) {
  return (
    <div>
      <h1 className='title'>{props.title}</h1>
      <br />
      <h2 className='subtitle'>{props.subtitle}</h2>
    </div>
  );
}
```

## Timing

To figure out if an operation is time expensive

```jsx
console.time('filter array');
const visibleTodos = getFilteredTodos(todos, filter);
console.timeEnd('filter array');
```

Fix

```jsx
console.time('filter array');
// Skipped if todos and filter haven't changed
const visibleTodos = useMemo(() => {
  return getFilteredTodos(todos, filter);
}, [todos, filter]);
console.timeEnd('filter array');
```

## Troubleshooting

- `Uncaught ReferenceError: process is not defined`
  - https://stackoverflow.com/questions/70368760/react-uncaught-referenceerror-process-is-not-defined

## Truthy/Falsy Values

### Truthy

- Number 0 (Zero)
  - `0`
- Empty Strings
  - `''`
  - `""`

### Falsy

- `null`
- `undefined`
- `false`

# Hooks

**Hooks can only be called at the TOP-LEVEL of a component** (i.e. cannot call hooks within `.map()`)

## useState

```jsx
import { useState } from 'react';

const [state, setState] = useState(initialState);
```

- [Reference Docs](https://react.dev/reference/react/useState)

### Anonymous Updater Function

**Common Error**

```jsx
import { useState } from 'react';

const Example = () => {
  const [age, setAge] = useState(0);

  function handleClick() {
    setAge(age + 1); // setAge(42 + 1)
    setAge(age + 1); // setAge(42 + 1)
    setAge(age + 1); // setAge(42 + 1)
  }

  return (
    <div>
      <button onClick={handleClick}>Increase</button>
    </div>
  );
};
```

- After one click, `age` will only be 43 and NOT 45
- This is because calling the set function does NOT update the age `state` variable in the already running code (asynchronously updated)
- So each `setAge(age + 1)` call becomes `setAge(43)`

**Solution**

```jsx
import { useState } from 'react';

const Example = () => {
  const [age, setAge] = useState(0);

  function handleClick() {
    setAge((prevAge) => prevAge + 1); // setAge(42 => 43)
    setAge((prevAge) => prevAge + 1); // setAge(43 => 44)
    setAge((prevAge) => prevAge + 1); // setAge(44 => 45)
  }

  return (
    <div>
      <button onClick={handleClick}>Increase</button>
    </div>
  );
};
```

- Here, `(prevAge) => prevAge + 1` is your updater function
  - It takes the pending state and calculates the next state from it
- React puts your updater functions in a **queue**. Then, during the next render, it will call them in the same order:
  - `prevAge => prevAge + 1` will receive 42 as the pending state and return 43 as the next state
  - `prevAge => prevAge + 1` will receive 43 as the pending state and return 44 as the next state
  - `prevAge => prevAge + 1` will receive 44 as the pending state and return 45 as the next state

### 2 Way Binding

- Store state in `useState`
- Put `value={state}` in component
- That way if state is changed elsewhere then component is also updated

```jsx
import { useState } from 'react';

const myComponent = () => {
  const [title, setTitle] = useState('');
  return (
    <>
      <input type='text' onChange={(e) => setTitle(e.target.value)} value={title} required />
    </>
  );
};
```

### Single Event Handler For Multiple Fields

- Note: the spread operator `...` only does SHALLOW copies (one level deep)

```jsx
import { useState } from 'react';

export default function Form() {
  const [person, setPerson] = useState({
    firstName: 'Seth',
    lastName: 'Chen',
    email: 'sethchen@gmail.com',
  });

  function handleChange(e) {
    setPerson({
      ...person,
      [e.target.type]: e.target.value,
    });
  }

  return (
    <>
      <label>
        First name:
        <input type='firstName' value={person.firstName} onChange={handleChange} />
      </label>
      <label>
        Last name:
        <input type='lastName' value={person.lastName} onChange={handleChange} />
      </label>
      <label>
        Email:
        <input type='email' value={person.email} onChange={handleChange} />
      </label>
      <p>
        {person.firstName} {person.lastName} ({person.email})
      </p>
    </>
  );
}
```

### Updating Nested Objects

```jsx
import { useState } from 'react';

export default function Form() {
  const [person, setPerson] = useState({
    name: 'Leonardo da Vinci',
    artwork: {
      title: 'Mona Lisa',
      city: 'Paris',
      image: 'https://cdn.pariscityvision.com/library/image/5449.jpg',
    },
  });

  function handleNameChange(e) {
    setPerson({
      ...person,
      name: e.target.value,
    });
  }

  function handleNestedChange(e, type) {
    if (type === 'title') {
      setPerson({
        ...person,
        artwork: {
          ...person.artwork,
          title: e.target.value,
        },
      });
    } else if (type === 'city') {
      setPerson({
        ...person,
        artwork: {
          ...person.artwork,
          city: e.target.value,
        },
      });
    } else if (type == 'image') {
      setPerson({
        ...person,
        artwork: {
          ...person.artwork,
          image: e.target.value,
        },
      });
    }
  }

  return (
    <>
      <label>
        Name:
        <input value={person.name} onChange={handleNameChange} />
      </label>
      <label>
        Title:
        <input value={person.artwork.title} onChange={(e) => handleNestedChange(e, title)} />
      </label>
      <label>
        City:
        <input value={person.artwork.city} onChange={(e) => handleNestedChange(e, city)} />
      </label>
      <label>
        Image:
        <input value={person.artwork.image} onChange={(e) => handleNestedChange(e, image)} />
      </label>
      <p>
        <i>{person.artwork.title}</i>
        {` by  ${person.name}`}
        <br />
        {`(located in ${person.artwork.city})`}
      </p>
      <img src={person.artwork.image} alt={person.artwork.title} />
    </>
  );
}
```

### Updating Arrays

|           | AVOID (mutates original array)        | Prefer (returns new array)                             |
| --------- | ------------------------------------- | ------------------------------------------------------ |
| Adding    | `.push()`, `.unshift()`               | `.concat()`, `[...arr, newItem]` (spread syntax)       |
| Removing  | `.pop()`, `.shift()`, `.splice()`     | `.filter()`, `.slice()`                                |
| Replacing | `.splice()`, `arr[i] = ` (assignment) | `.map()`                                               |
| Sorting   | `.sort()`, `.reverse()`               | `const newArr = [...arr]` (create copy of array first) |

- Note:
  - `.slice()` lets you copy an array or part of it
  - `.splice()` MUTATES the array (to insert or delete items)

#### Appending to Array

```jsx
import { useState } from 'react';

let globalID = 0;

export default function List() {
  const [name, setName] = useState('');
  const [artists, setArtists] = useState([]);

  return (
    <>
      <h1>Artists:</h1>
      <input value={name} onChange={(e) => setName(e.target.value)} />
      <button onClick={() => setArtists([...artists, { id: globalID++, name: name }])}>Add</button>
      <ul>
        {artists.map((artist) => (
          <li key={artist.id}>{artist.name}</li>
        ))}
      </ul>
    </>
  );
}
```

#### Inserting into Array (using `.slice()`)

```jsx
import { useState } from 'react';

let globalID = 3;
const initialArtists = [
  { id: 0, name: 'Leonardo da Vinci' },
  { id: 1, name: 'Vincent van Gogh' },
  { id: 2, name: 'Pablo Picasso' },
  { id: 3, name: 'Claude Monet' },
];

export default function List() {
  const [newArtist, setNewArtist] = useState('');
  const [artists, setArtists] = useState(initialArtists);

  function handleClick() {
    const insertAt = 1; // Could be any index
    const nextArtists = [
      // Items before the insertion point:
      ...artists.slice(0, insertAt),
      // New item:
      { id: globalID++, name: newArtist },
      // Items after the insertion point:
      ...artists.slice(insertAt),
    ];
    setArtists(nextArtists);
    setNewArtist('');
  }

  return (
    <>
      <h1>Artists:</h1>
      <input value={newArtist} onChange={(e) => setNewArtist(e.target.value)} />
      <button onClick={handleClick}>Insert</button>
      <ul>
        {artists.map((artist) => (
          <li key={artist.id}>{artist.name}</li>
        ))}
      </ul>
    </>
  );
}
```

#### Removing from Array (using `.filter()`)

```jsx
import { useState } from 'react';

let initialArtists = [
  { id: 0, name: 'Leonardo da Vinci' },
  { id: 1, name: 'Vincent van Gogh' },
  { id: 2, name: 'Pablo Picasso' },
  { id: 3, name: 'Claude Monet' },
];

export default function List() {
  const [artists, setArtists] = useState(initialArtists);

  return (
    <>
      <h1>Artists:</h1>
      <ul>
        {artists.map((artist) => (
          <li key={artist.id}>
            {artist.name}{' '}
            <button
              onClick={() => {
                setArtists(artists.filter((a) => a.id !== artist.id));
              }}
            >
              Delete
            </button>
          </li>
        ))}
      </ul>
    </>
  );
}
```

#### Updating Elements in Array Array (using `.map()`)

```jsx
import { useState } from 'react';

let initialShapes = [
  { id: 0, type: 'circle', x: 50, y: 100 },
  { id: 1, type: 'square', x: 150, y: 100 },
  { id: 2, type: 'circle', x: 250, y: 100 },
];

export default function ShapeEditor() {
  const [shapes, setShapes] = useState(initialShapes);

  function handleClick() {
    const nextShapes = shapes.map((shape) => {
      // No change
      if (shape.type === 'square') {
        return shape;
      } else {
        // Return a new circle 50px below
        return {
          ...shape,
          y: shape.y + 50,
        };
      }
    });
    // Re-render with the new array
    setShapes(nextShapes);
  }

  return (
    <>
      <button onClick={handleClick}>Move Circles Down</button>
      {shapes.map((shape) => (
        <div
          key={shape.id}
          style={{
            background: 'purple',
            position: 'absolute',
            left: shape.x,
            top: shape.y,
            borderRadius: shape.type === 'circle' ? '50%' : '',
            width: 20,
            height: 20,
          }}
        />
      ))}
    </>
  );
}
```

```jsx
import { useState } from 'react';

let initialCounters = [0, 0, 0];

export default function CounterList() {
  const [counters, setCounters] = useState(initialCounters);

  function handleIncrementClick(index) {
    const nextCounters = counters.map((c, i) => (i === index ? c + 1 : c));
    // const nextCounters = counters.map((c, i) => {
    //   return i === index ? c + 1 : c;
    // });
    setCounters(nextCounters);
  }

  return (
    <ul>
      {counters.map((counter, index) => (
        <li key={index}>
          {counter}
          <button
            onClick={() => {
              handleIncrementClick(index);
            }}
          >
            +1
          </button>
        </li>
      ))}
    </ul>
  );
}
```

#### Sorting an Array

```jsx
import { useState } from 'react';

let globalID = 3;
const initialList = [
  { id: 0, title: 'Big Bellies' },
  { id: 1, title: 'Lunar Landscape' },
  { id: 2, title: 'Terracotta Army' },
];

export default function List() {
  const [list, setList] = useState(initialList);

  function handleClick() {
    const newList = [...list];
    newList.reverse();
    setList(newList);
  }

  return (
    <>
      <button onClick={handleClick}>Reverse</button>
      <ul>
        {list.map((artwork) => (
          <li key={artwork.id}>{artwork.title}</li>
        ))}
      </ul>
    </>
  );
}
```

#### Updating Nested Objects in Array

```jsx
import { useState } from 'react';

let globalID = 3;
const initialList = [
  { id: 0, title: 'Big Bellies', seen: false },
  { id: 1, title: 'Lunar Landscape', seen: false },
  { id: 2, title: 'Terracotta Army', seen: true },
];

export default function BucketList() {
  const [myList, setMyList] = useState(initialList);
  const [yourList, setYourList] = useState(initialList);

  function handleToggleMyList(artworkID, newSeenState) {
    setMyList(myList.map((artwork) => (artwork.id === artworkID ? { ...artwork, seen: newSeenState } : artwork)));
    // setMyList(myList.map(artwork => {
    //   return (artwork.id === artworkID) ? { ...artwork, seen: newSeenState } : artwork;
    // }));

    // Note: Incorrect because ITEMS are the same (other list's items will also get changed, point to SAME original list item)
    // const newMyList = [...myList];
    // const artwork = newMyList.find(a => a.id === artworkID);
    // artwork.seen = newSeenState;
    // setMyList(newMyList);
  }

  function handleToggleYourList(artworkID, newSeenState) {
    setMyList(yourList.map((artwork) => (artwork.id === artworkID ? { ...artwork, seen: newSeenState } : artwork)));
    // setMyList(yourList.map(artwork => {
    //   return (artwork.id === artworkID) ? { ...artwork, seen: newSeenState } : artwork;
    // }));

    // Note: Incorrect because ITEMS are the same (other list's items will also get changed, point to SAME original list item)
    // const newYourList = [...yourList];
    // const artwork = newYourList.find(a => a.id === artworkID);
    // artwork.seen = newSeenState;
    // setYourList(newYourList);
  }

  return (
    <>
      <h1>Art Bucket List</h1>
      <h2>My list of art to see:</h2>
      <ItemList artworks={myList} onToggle={handleToggleMyList} />
      <h2>Your list of art to see:</h2>
      <ItemList artworks={yourList} onToggle={handleToggleYourList} />
    </>
  );
}

function ItemList({ artworks, onToggle }) {
  return (
    <ul>
      {artworks.map((artwork) => (
        <li key={artwork.id}>
          <label>
            <input type='checkbox' checked={artwork.seen} onChange={(e) => onToggle(artwork.id, e.target.checked)} />
            {artwork.title}
          </label>
        </li>
      ))}
    </ul>
  );
}
```

### Reacting to Input with State

```jsx
import { useState } from 'react';

export default function Form() {
  const [answer, setAnswer] = useState('');
  const [error, setError] = useState(null);
  const [status, setStatus] = useState('typing');

  if (status === 'success') {
    return <h1>That's right!</h1>;
  }

  async function handleSubmit(e) {
    e.preventDefault();
    setStatus('submitting');
    try {
      await submitForm(answer);
      setStatus('success');
    } catch (err) {
      setStatus('typing');
      setError(err);
    }
  }

  return (
    <>
      <h2>City quiz</h2>
      <p>In which city is there a billboard that turns air into drinkable water?</p>
      <form onSubmit={handleSubmit}>
        <textarea value={answer} onChange={(e) => setAnswer(e.target.value)} disabled={status === 'submitting'} />
        <br />
        <button disabled={answer.length === 0 || status === 'submitting'}>Submit</button>
        {error !== null && <p className='Error'>{error.message}</p>}
      </form>
    </>
  );
}

function submitForm(answer) {
  // Pretend it's hitting the network.
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      let shouldError = answer.toLowerCase() !== 'lima';
      if (shouldError) {
        reject(new Error('Good guess but a wrong answer. Try again!'));
      } else {
        resolve();
      }
    }, 1500);
  });
}
```

### Sharing State Between Components

```jsx
import { useState } from 'react';

export default function Accordion() {
  const [activeIndex, setActiveIndex] = useState(0);
  return (
    <>
      <h2>Almaty, Kazakhstan</h2>
      <Panel title='About' isActive={activeIndex === 0} onShow={() => setActiveIndex(0)}>
        Info 1
      </Panel>
      <Panel title='Etymology' isActive={activeIndex === 1} onShow={() => setActiveIndex(1)}>
        Info 2
      </Panel>
    </>
  );
}

function Panel({ title, children, isActive, onShow }) {
  return (
    <section className='panel'>
      <h3>{title}</h3>
      {isActive ? <p>{children}</p> : <button onClick={onShow}>Show</button>}
    </section>
  );
}
```

### Same Component at the Same Position Preserves State

- The "score" remains the same when switching between "fancy" and "non-fancy" counters
- Note: same "position" means in the **same render logic line**

```jsx
import { useState } from 'react';

export default function App() {
  const [isFancy, setIsFancy] = useState(false);
  return (
    <div>
      {/* Conditional Render Logic is on the SAME ONE LINE (hence same "position") */}
      {isFancy ? <Counter isFancy={true} /> : <Counter isFancy={false} />}
      <label>
        <input type='checkbox' checked={isFancy} onChange={(e) => setIsFancy(e.target.checked)} />
        Use fancy styling
      </label>
    </div>
  );
}

function Counter({ isFancy }) {
  const [score, setScore] = useState(0);
  const [hover, setHover] = useState(false);

  let className = 'counter';
  if (hover) {
    className += ' hover';
  }
  if (isFancy) {
    className += ' fancy';
  }

  return (
    <div className={className} onPointerEnter={() => setHover(true)} onPointerLeave={() => setHover(false)}>
      <h1>{score}</h1>
      <button onClick={() => setScore(score + 1)}>Add one</button>
    </div>
  );
}
```

### Different Components at the Same Position Resets State

```jsx
import { useState } from 'react';

export default function App() {
  const [isPaused, setIsPaused] = useState(false);
  return (
    <div>
      {isPaused ? <p>Bye</p> : <Counter />}
      <label>
        <input type='checkbox' checked={isPaused} onChange={(e) => setIsPaused(e.target.checked)} />
        Take a break
      </label>
    </div>
  );
}

function Counter() {
  const [score, setScore] = useState(0);
  const [hover, setHover] = useState(false);

  let className = 'counter';
  if (hover) {
    className += ' hover';
  }

  return (
    <div className={className} onPointerEnter={() => setHover(true)} onPointerLeave={() => setHover(false)}>
      <h1>{score}</h1>
      <button onClick={() => setScore(score + 1)}>Add one</button>
    </div>
  );
}
```

### Resetting State at the Same Position

#### Version 1 - Render a Component in Different Position

- Split the logic into 2 DIFFERENT/SEPARATE conditional render lines

```jsx
import { useState } from 'react';

export default function Scoreboard() {
  const [isPlayerA, setIsPlayerA] = useState(true);
  return (
    <div>
      {/* Conditional Render Logic is on two DIFFERENT lines (hence different "position") */}
      {isPlayerA && <Counter person='Taylor' />}
      {!isPlayerA && <Counter person='Sarah' />}
      <button onClick={() => setIsPlayerA(!isPlayerA)}>Change Player</button>
    </div>
  );
}

function Counter({ person }) {
  const [score, setScore] = useState(0);
  const [hover, setHover] = useState(false);

  let className = 'counter';
  if (hover) {
    className += ' hover';
  }

  return (
    <div className={className} onPointerEnter={() => setHover(true)} onPointerLeave={() => setHover(false)}>
      <h1>
        {person}'s score: {score}
      </h1>
      <button onClick={() => setScore(score + 1)}>Add one</button>
    </div>
  );
}
```

#### Version 2 - Resetting State with a Key

Example 1

```jsx
import { useState } from 'react';

export default function Scoreboard() {
  const [isPlayerA, setIsPlayerA] = useState(true);
  return (
    <div>
      {/* Components are in the "same" position but are treated differently because of DIFFERENT KEYS */}
      {isPlayerA ? <Counter key='Taylor' person='Taylor' /> : <Counter key='Sarah' person='Sarah' />}
      <button onClick={() => setIsPlayerA(!isPlayerA)}>Change Player</button>
    </div>
  );
}

function Counter({ person }) {
  const [score, setScore] = useState(0);
  const [hover, setHover] = useState(false);

  let className = 'counter';
  if (hover) {
    className += ' hover';
  }

  return (
    <div className={className} onPointerEnter={() => setHover(true)} onPointerLeave={() => setHover(false)}>
      <h1>
        {person}'s score: {score}
      </h1>
      <button onClick={() => setScore(score + 1)}>Add one</button>
    </div>
  );
}
```

Example 2

```jsx
// Apps.jsx
import { useState } from 'react';
import Chat from './Chat.js';
import ContactList from './ContactList.js';

export default function Messenger() {
  const [to, setTo] = useState(contacts[0]);
  return (
    <div>
      <ContactList
        contacts={contacts}
        selectedContact={to}
        onSelect={contact => setTo(contact)}
      />
      { /* "key" prop is responsible for RESETTING input box each time contact is changed */ }
      <Chat key={to.id} contact={to} />
    </div>
  );
}

const contacts = [
  { id: 0, name: 'Taylor', email: 'taylor@mail.com' },
  { id: 1, name: 'Alice', email: 'alice@mail.com' },
  { id: 2, name: 'Bob', email: 'bob@mail.com' }
];

// ContactList.jsx
export default function ContactList({
  selectedContact,
  contacts,
  onSelect
}) {
  return (
    <section className="contact-list">
      <ul>
        {contacts.map(contact =>
          <li key={contact.id}>
            <button onClick={() => onSelect(contact)}>
              {contact.name}
            </button>
          </li>
        )}
      </ul>
    </section>
  );
}

// Chat.jsx
import { useState } from 'react';

export default function Chat({ contact }) {
  const [text, setText] = useState('');
  return (
    <section className="chat">
      <textarea
        value={text}
        placeholder={'Chat to ' + contact.name}
        onChange={e => setText(e.target.value)}
      />
      <br />
      <button>Send to {contact.email}</button>
    </section>
  );
}
```

## useEffect

```jsx
import { useEffect } from 'react';

useEffect(() => {
  // This runs after every render
});

useEffect(() => {
  // This runs only on mount (when the component appears) i.e. only runs ONCE
}, []);

useEffect(() => {
  // This runs on mount AND if either a or b have changed since the last render
}, [a, b]);
```

- [Reference Docs](https://react.dev/reference/react/useEffect)

Trick/Hack to prevent code from running in `useEffect` on first load is to check if dependency is "truthy" with `if (var)`

```jsx
import { useEffect } from 'react';

useEffect(() => {
  if (data) {
    console.log(`hello ${data}`);
  }
}, [data]);
```

### Cleanup Function

- Example Scenario:
  - Imagine the `ChatRoom` component is a part of a larger app with many different screens
  - The user starts their journey on the `ChatRoom` page
  - The component mounts and calls `connection.connect()`
  - Then imagine the user navigates to another screen such as the `Settings` page
  - The `ChatRoom` component unmounts
  - Finally, the user clicks "back" and `ChatRoom` mounts again
  - This would set up a second connection but the first connection was never destroyed!

```jsx
import { useEffect } from 'react';

useEffect(() => {
  const connection = createConnection();
  connection.connect();
  return () => {
    connection.disconnect();
  };
}, []);
```

### Anonymous Updater Function

**Common Error (Infinite Loop)**

```jsx
import { useEffect, useState } from 'react';

export const Example = () => {
  const [count, setCount] = useState(0);
  const [analyticsCount, setAnalyticsCount] = useState(0);

  useEffect(() => {
    setAnalyticsCount(analyticsCount + 1); // <-- HERE
  }, [analyticsCount]);

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Increase</button>
    </div>
  );
};
```

**Solution/Fix**

- Solution: Use anonymous function

```jsx
import { useEffect, useState } from 'react';

export const Example = () => {
  const [count, setCount] = useState(0);
  const [analyticsCount, setAnalyticsCount] = useState(0);

  useEffect(() => {
    setAnalyticsCount((currCount) => currCount + 1); // <-- HERE
  }, []);

  return (
    <div>
      <button onClick={() => setCount(count + 1)}>Increase</button>
    </div>
  );
};
```

### Handling useEffect Firing 2x in Development

- React purposely/intentionally remounts your components in development to find bugs

Some APIs can be called twice without a problem

```jsx
useEffect(() => {
  const map = mapRef.current;
  map.setZoomLevel(zoomLevel);
}, [zoomLevel]);
```

Some APIs may not allow you to call them twice in a row

```jsx
useEffect(() => {
  const dialog = dialogRef.current;
  dialog.showModal();
  return () => dialog.close();
}, []);
```

### Subscribing to Events

If your Effect subscribes to something, the cleanup function should unsubscribe:

```jsx
useEffect(() => {
  const handleScroll = (e) => {
    console.log(window.scrollX, window.scrollY);
  };
  window.addEventListener('scroll', handleScroll);
  return () => window.removeEventListener('scroll', handleScroll);
}, []);
```

### Triggering Animations

If your Effect animates something in, the cleanup function should reset the animation to the initial values

```jsx
useEffect(() => {
  const node = ref.current;
  // Trigger the animation
  node.style.opacity = 1;
  return () => {
    // Reset to the initial value
    node.style.opacity = 0;
  };
}, []);
```

### Fetching Data

- If your Effect fetches something, the cleanup function should either [abort the fetch](https://developer.mozilla.org/en-US/docs/Web/API/AbortController) or ignore its result:

```jsx
useEffect(() => {
  let ignore = false;

  async function startFetching() {
    const json = await fetchTodos(userId);
    if (!ignore) {
      setTodos(json);
    }
  }

  // const startFetching = async () => {
  //   const json = await fetchTodos(userId);
  //   if (!ignore) {
  //     setTodos(json);
  //   }
  // }

  startFetching();

  return () => {
    ignore = true;
  };
}, [userId]);
```

```jsx
function SearchResults({ query }) {
  const [results, setResults] = useState([]);
  const [page, setPage] = useState(1);
  useEffect(() => {
    let ignore = false;
    fetchResults(query, page).then((json) => {
      if (!ignore) {
        setResults(json);
      }
    });
    return () => {
      ignore = true;
    };
  }, [query, page]);

  function handleNextPageClick() {
    setPage(page + 1);
  }
  // ...
}
```

#### Aborting Fetch

```jsx
import { useState, useEffect } from 'react';

export const useFetch = (url) => {
  const [data, setData] = useState(null);
  const [isPending, setIsPending] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const controller = new AbortController(); /* <-- HERE */
    const makeFetch = async () => {
      setIsPending(true);
      try {
        const res = await fetch(url, { signal: controller.signal }); /* <-- HERE */
        if (!res.ok) {
          throw new Error(res.statusText);
        }
        const data = await res.json();
        setIsPending(false);
        setData(data);
        setError(null);
      } catch (error) {
        if (error.name === 'AbortError') {
          console.log('The fetch was aborted');
        } else {
          setIsPending(false);
          setError('Could not fetch the data');
        }
      }
    };
    makeFetch();
    return () => {
      controller.abort(); /* <-- HERE */
    };
  }, [url]);

  return { data, isPending, error };
};
```

### Initialising Application (Auth)

#### Version 1

```jsx
// App.jsx
let didInit = false;

function App() {
  useEffect(() => {
    if (!didInit) {
      didInit = true;
      // Only runs once per app load
      loadDataFromLocalStorage();
      checkAuthToken();
    }
  }, []);
  // ...
}
```

#### Version 2

```jsx
if (typeof window !== 'undefined') {
  // Check if we're running in the browser
  // Only runs once per app load
  checkAuthToken();
  loadDataFromLocalStorage();
}

function App() {
  // ...
}
```

## useReducer

```jsx
import { useReducer } from 'react';

const [state, dispatch] = useReducer(stateReducer, initialState);
```

- [Reference Docs](https://react.dev/reference/react/useReducer)

### Dispatch Action

```jsx
import { useReducer } from 'react';

let globalID = 3;

function handleAddTask(text) {
  dispatch({
    type: 'added',
    id: globalID++,
    text: text,
  });
}

function handleChangeTask(task) {
  dispatch({
    type: 'changed',
    task: task,
  });
}

function handleDeleteTask(taskId) {
  dispatch({
    type: 'deleted',
    id: taskId,
  });
}
```

### Reducer Function

- It takes 2 arguments:
  - 1. Current state
  - 2. Action object
- **The reducer function returns the next state**

1. Declare the current state (`tasks`) as the first argument
2. Declare the `action` object as the second argument
3. Return the **next** state from the reducer (which React will set the state to).

```jsx
import { useReducer } from 'react';

function tasksReducer(tasks, action) {
  switch (action.type) {
    case 'added': {
      return [
        ...tasks,
        {
          id: action.id,
          text: action.text,
          done: false,
        },
      ];
    }
    case 'changed': {
      return tasks.map((t) => return tasks.map((t) => (t.id === action.task.id) ? action.task : t));
    }
    case 'deleted': {
      return tasks.filter((t) => t.id !== action.id);
    }
    default: {
      throw Error('Unknown action: ' + action.type);
    }
  }
}
```

### Using Reducer within Component

App.jsx

```jsx
import { useReducer } from 'react';
import AddTask from './AddTask.js';
import TaskList from './TaskList.js';
import tasksReducer from './tasksReducer.js';

let globalID = 3;
const initialTasks = [
  { id: 0, text: 'Visit Kafka Museum', done: true },
  { id: 1, text: 'Watch a puppet show', done: false },
  { id: 2, text: 'Lennon Wall pic', done: false },
];

export default function TaskApp() {
  const [tasks, dispatch] = useReducer(tasksReducer, initialTasks);

  function handleAddTask(text) {
    dispatch({
      type: 'added',
      id: globalID++,
      text: text,
    });
  }

  function handleChangeTask(task) {
    dispatch({
      type: 'changed',
      task: task,
    });
  }

  function handleDeleteTask(taskId) {
    dispatch({
      type: 'deleted',
      id: taskId,
    });
  }

  return (
    <>
      <h1>Prague itinerary</h1>
      <AddTask onAddTask={handleAddTask} />
      <TaskList tasks={tasks} onChangeTask={handleChangeTask} onDeleteTask={handleDeleteTask} />
    </>
  );
}
```

tasksReducer.jsx

```jsx
export default function tasksReducer(tasks, action) {
  switch (action.type) {
    case 'added': {
      return [
        ...tasks,
        {
          id: action.id,
          text: action.text,
          done: false,
        },
      ];
    }
    case 'changed': {
      return tasks.map((t) => (t.id === action.task.id ? action.task : t));
      // return tasks.map((t) => {
      //   if (t.id === action.task.id) {
      //     return action.task;
      //   } else {
      //     return t;
      //   }
      // });
    }
    case 'deleted': {
      return tasks.filter((t) => t.id !== action.id);
    }
    default: {
      throw Error('Unknown action: ' + action.type);
    }
  }
}
```

## useContext

```jsx
import { createContext } from 'react';

export const MyContext1 = createContext(''); // Can be any default value
export const MyContext2 = createContext(null); // Can be any default value
```

- [Reference Docs](https://react.dev/reference/react/useContext)

Use Cases for useContext

- Theming
- Currently Logged in User
- Routing
- Managing State to Scale

### Create the Context

Typically in its OWN file

```jsx
// LevelContext.jsx
import { createContext } from 'react';

export const LevelContext = createContext(1);
```

### Provide and Use the Context

- PROVIDE Context: Wrap children in `<MyContext.Provider></MyContext.Provider>`
- USE Context: `const dataContext = useContext(MyContext)`

App.jsx

```js
import Heading from './Heading.js';
import Section from './Section.js';

export default function Page() {
  return (
    <Section level={1}>
      <Heading>Title</Heading>
      <Section level={2}>
        <Heading>Heading</Heading>
        <Heading>Heading</Heading>
        <Heading>Heading</Heading>
        <Section level={3}>
          <Heading>Sub-heading</Heading>
          <Heading>Sub-heading</Heading>
          <Heading>Sub-heading</Heading>
          <Section level={4}>
            <Heading>Sub-sub-heading</Heading>
            <Heading>Sub-sub-heading</Heading>
            <Heading>Sub-sub-heading</Heading>
          </Section>
        </Section>
      </Section>
    </Section>
  );
}
```

Section.jsx

```js
import { LevelContext } from './LevelContext.js';

export default function Section({ level, children }) {
  return (
    <section className='section'>
      <LevelContext.Provider value={level}>{children}</LevelContext.Provider>
    </section>
  );
}
```

Heading.jsx

```jsx
import { useContext } from 'react';
import { LevelContext } from './LevelContext.js';

export default function Heading({ children }) {
  const level = useContext(LevelContext);
  switch (level) {
    case 1:
      return <h1>{children}</h1>;
    case 2:
      return <h2>{children}</h2>;
    case 3:
      return <h3>{children}</h3>;
    case 4:
      return <h4>{children}</h4>;
    case 5:
      return <h5>{children}</h5>;
    case 6:
      return <h6>{children}</h6>;
    default:
      throw Error('Unknown level: ' + level);
  }
}
```

LevelContext.jsx

```jsx
import { createContext } from 'react';

export const LevelContext = createContext(1);
```

### Using And Providing Context From The Same Component (prop-less method)

- This is another method to use to prevent specifying each "context value" prop in each component
  - "prop-less" method
- We can do this because "context" allows you to read information from the component above

App.jsx

```js
import Heading from './Heading.js';
import Section from './Section.js';

export default function Page() {
  return (
    <Section>
      <Heading>Title</Heading>
      <Section>
        <Heading>Heading</Heading>
        <Heading>Heading</Heading>
        <Heading>Heading</Heading>
        <Section>
          <Heading>Sub-heading</Heading>
          <Heading>Sub-heading</Heading>
          <Heading>Sub-heading</Heading>
          <Section>
            <Heading>Sub-sub-heading</Heading>
            <Heading>Sub-sub-heading</Heading>
            <Heading>Sub-sub-heading</Heading>
          </Section>
        </Section>
      </Section>
    </Section>
  );
}
```

Section.jsx

```js
import { useContext } from 'react';
import { LevelContext } from './LevelContext.js';

export default function Section({ children }) {
  const level = useContext(LevelContext);
  return (
    <section className='section'>
      <LevelContext.Provider value={level + 1}>{children}</LevelContext.Provider>
    </section>
  );
}
```

Heading.jsx

```jsx
import { useContext } from 'react';
import { LevelContext } from './LevelContext.js';

export default function Heading({ children }) {
  const level = useContext(LevelContext);
  switch (level) {
    case 0:
      throw Error('Heading must be inside a Section!');
    case 1:
      return <h1>{children}</h1>;
    case 2:
      return <h2>{children}</h2>;
    case 3:
      return <h3>{children}</h3>;
    case 4:
      return <h4>{children}</h4>;
    case 5:
      return <h5>{children}</h5>;
    case 6:
      return <h6>{children}</h6>;
    default:
      throw Error('Unknown level: ' + level);
  }
}
```

LevelContext.jsx

```jsx
import { createContext } from 'react';

export const LevelContext = createContext(0);
```

### useContext + useReducer (to scale up)

- Essentially create 2 DIFFERENT contexts and each one has the "value" of the `state` and `dispatch` of the reducer
  - `import { TasksContext, TasksDispatchContext } from './TasksContext.js';`
  - `const [tasks, dispatch] = useReducer(tasksReducer, initialTasks);`
  - `<TasksContext.Provider value={tasks}>`
  - `<TasksDispatchContext.Provider value={dispatch}>`
- Grab each context separately
  - `AddTask.js` grabs `TasksDispatchContext`
    - `const dispatch = useContext(TasksDispatchContext);`
  - `TaskList.js` grabs `TasksContext`
    - `const tasks = useContext(TasksContext);`

TaskContext.jsx

```jsx
import { createContext } from 'react';

export const TasksContext = createContext(null);
export const TasksDispatchContext = createContext(null);
```

App.jsx

```jsx
import { useReducer } from 'react';
import AddTask from './AddTask.js';
import TaskList from './TaskList.js';
import { TasksContext, TasksDispatchContext } from './TasksContext.js';

const initialTasks = [
  { id: 0, text: 'Philosopher’s Path', done: true },
  { id: 1, text: 'Visit the temple', done: false },
  { id: 2, text: 'Drink matcha', done: false },
];

export default function TaskApp() {
  const [tasks, dispatch] = useReducer(tasksReducer, initialTasks); // <-- HERE

  return (
    { /* HERE */ }
    <TasksContext.Provider value={tasks}>
      { /* HERE */ }
      <TasksDispatchContext.Provider value={dispatch}>
        <h1>Day off in Kyoto</h1>
        <AddTask />
        <TaskList />
      </TasksDispatchContext.Provider>
    </TasksContext.Provider>
  );
}

function tasksReducer(tasks, action) {
  switch (action.type) {
    case 'added': {
      return [
        ...tasks,
        {
          id: action.id,
          text: action.text,
          done: false,
        },
      ];
    }
    case 'changed': {
      return tasks.map((t) => (t.id === action.task.id ? action.task : t));
    }
    case 'deleted': {
      return tasks.filter((t) => t.id !== action.id);
    }
    default: {
      throw Error('Unknown action: ' + action.type);
    }
  }
}
```

AddTask.jsx

```jsx
import { useState, useContext } from 'react';
import { TasksDispatchContext } from './TasksContext.js';

let globalID = 3;

export default function AddTask() {
  const [text, setText] = useState('');
  const dispatch = useContext(TasksDispatchContext); // <-- HERE
  return (
    <>
      <input placeholder='Add task' value={text} onChange={(e) => setText(e.target.value)} />
      <button
        onClick={() => {
          setText('');
          dispatch({
            type: 'added',
            id: globalID++,
            text: text,
          });
        }}
      >
        Add
      </button>
    </>
  );
}
```

TaskList.jsx

```jsx
import { useState, useContext } from 'react';
import { TasksContext, TasksDispatchContext } from './TasksContext.js';

export default function TaskList() {
  const tasks = useContext(TasksContext); // <-- HERE
  return (
    <ul>
      {tasks.map((task) => (
        <li key={task.id}>
          <Task task={task} />
        </li>
      ))}
    </ul>
  );
}

function Task({ task }) {
  const [isEditing, setIsEditing] = useState(false);
  const dispatch = useContext(TasksDispatchContext);
  let taskContent;
  if (isEditing) {
    taskContent = (
      <>
        <input
          value={task.text}
          onChange={(e) => {
            dispatch({
              type: 'changed',
              task: {
                ...task,
                text: e.target.value,
              },
            });
          }}
        />
        <button onClick={() => setIsEditing(false)}>Save</button>
      </>
    );
  } else {
    taskContent = (
      <>
        {task.text}
        <button onClick={() => setIsEditing(true)}>Edit</button>
      </>
    );
  }
  return (
    <label>
      <input
        type='checkbox'
        checked={task.done}
        onChange={(e) => {
          dispatch({
            type: 'changed',
            task: {
              ...task,
              done: e.target.checked,
            },
          });
        }}
      />
      {taskContent}
      <button
        onClick={() => {
          dispatch({
            type: 'deleted',
            id: task.id,
          });
        }}
      >
        Delete
      </button>
    </label>
  );
}
```

## useRef

```jsx
import { useRef } from 'react';

const ref = useRef(null);
// Access value with "ref.current"

// useRef returns the following object with the "value" set to the initial value passed to useRef
// ref = { current: null };
```

- [Reference Docs](https://react.dev/reference/react/useRef)
- When you want a component to "remember" some information, but you do NOT want that information to trigger new renders
  - Use sparingly and treat it as an "escape hatch"
- A `ref` is a plain JavaScript object with a single property called `current`, which you can read or set
- Like `state`, `refs` let you retain information between re-renders of a component
- Unlike `state`, setting the ref's `current` value does NOT trigger a re-render
- Do NOT read or write `ref.current` during rendering

Uses Cases:

- Refs are an escape hatch to hold onto values that are NOT used for rendering
- Typically, you will use a `ref` when your component needs to "step outside" React and communicate with external APIs
  - Storing timeout IDs
  - Storing and manipulating DOM elements
  - Storing other objects that are NOT necessary to calculate the JSX
  - Managing focus, scroll position
  - Calling browser APIs
- Most common use case for a `ref` is to access a DOM element (e.g. to focus an input programmatically)
  - When you pass a ref to a `ref` attribute in JSX, like `<div ref={myRef}>`, React will put the corresponding DOM element into `myRef.current`
  - Once the element is removed from the DOM, React will update `myRef.current` to be `null`

Access current value of ref through `ref.current` property

- This value is mutable (read + write)

Best Practices

- Treat `refs` as an escape hatch
  - Refs are useful when you work with external systems or browser APIs
  - If much of your application logic and data flow relies on refs, you might want to rethink your approach
- Do NOT read or write `ref.current` during rendering
  - If some information is needed during rendering, use `state` instead
  - Since React does NOT know when `ref.current` changes, even reading it while rendering makes your component's behavior difficult to predict
    - The only exception is code like `if (!ref.current) ref.current = new Thing()` which only sets the `ref` ONCE during the first render

Limitations of React state do NOT apply to refs

- For example, state acts like a snapshot for every render and does NOT update synchronously
- But when you mutate the `current` value of a `ref`, it changes immediately:
  - This is because the `ref` itself is a regular JavaScript object, and so it behaves like one

```jsx
ref.current = 5;
console.log(ref.current); // 5
```

### Stopwatch Example

```jsx
import { useState, useRef } from 'react';

export default function Stopwatch() {
  const [startTime, setStartTime] = useState(null);
  const [now, setNow] = useState(null);
  const intervalRef = useRef(null);

  function handleStart() {
    setStartTime(Date.now());
    setNow(Date.now());
    clearInterval(intervalRef.current);
    // intervalRef.current = setInterval(() => setNow(Date.now()), 10);
    intervalRef.current = setInterval(() => {
      setNow(Date.now());
    }, 10);
  }

  function handleStop() {
    clearInterval(intervalRef.current);
  }

  let secondsPassed = 0;
  if (startTime != null && now != null) {
    secondsPassed = (now - startTime) / 1000;
  }

  return (
    <>
      <h1>Time passed: {secondsPassed.toFixed(3)}</h1>
      <button onClick={handleStart}>Start</button>
      <button onClick={handleStop}>Stop</button>
    </>
  );
}
```

### Refs vs State

| refs                                                                               | state                                                                                                                  |
| ---------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| `useRef(initialValue)` returns object `{ current: initialValue }`                  | `useState(initialValue)` returns the current value of a state variable and a state setter function `[value, setValue]` |
| Does NOT trigger re-render when you change it                                      | Triggers re-render when you change it                                                                                  |
| MUTABLE - Can modify and update `current's` value outside of the rendering process | IMMUTABLE - Must use the state setting function to modify state variables to queue a re-render                         |
| Should NOT read (or write) the `current` value during rendering                    | You can read state at any time. However, each render has its own snapshot of state which does not change               |

### Manipulating DOM with Refs

- Sometimes you might need access to the DOM elements managed by React e.g. to focus a node, scroll to it, or measure its size and position
  - There is NO built-in way to do those things in React, so you will need a `ref` to the DOM node

```jsx
import { useRef } from 'react';

const myRef = useRef(null);

// Pass your ref as the ref attribute to the JSX tag for which you want to get the DOM node
<div ref={myRef}>

myRef.current.scrollIntoView();
```

Example: Focusing a Text Input

```jsx
import { useRef } from 'react';

export default function Form() {
  const inputRef = useRef(null);
  return (
    <>
      <input ref={inputRef} />
      <button onClick={() => inputRef.current.focus()}>Focus the input</button>
    </>
  );
}
```

Example: Scrolling to an Element

```jsx
import { useRef } from 'react';

export default function CatFriends() {
  const firstCatRef = useRef(null);
  const secondCatRef = useRef(null);
  const thirdCatRef = useRef(null);

  function handleScrollToFirstCat() {
    firstCatRef.current.scrollIntoView({
      behavior: 'smooth',
      block: 'nearest',
      inline: 'center',
    });
  }

  function handleScrollToSecondCat() {
    secondCatRef.current.scrollIntoView({
      behavior: 'smooth',
      block: 'nearest',
      inline: 'center',
    });
  }

  function handleScrollToThirdCat() {
    thirdCatRef.current.scrollIntoView({
      behavior: 'smooth',
      block: 'nearest',
      inline: 'center',
    });
  }

  return (
    <>
      <nav>
        <button onClick={handleScrollToFirstCat}>Tom</button>
        <button onClick={handleScrollToSecondCat}>Maru</button>
        <button onClick={handleScrollToThirdCat}>Jellylorum</button>
      </nav>
      <div>
        <ul>
          <li>
            <img src='https://placekitten.com/g/200/200' alt='Tom' ref={firstCatRef} />
          </li>
          <li>
            <img src='https://placekitten.com/g/300/200' alt='Maru' ref={secondCatRef} />
          </li>
          <li>
            <img src='https://placekitten.com/g/250/200' alt='Jellylorum' ref={thirdCatRef} />
          </li>
        </ul>
      </div>
    </>
  );
}
```

### Manage List of Refs using a Ref Callback

```jsx
import { useRef } from 'react';

const catList = [];
for (let i = 0; i < 10; i++) {
  catList.push({
    id: i,
    imageUrl: 'https://placekitten.com/250/200?image=' + i,
  });
}

export default function CatFriends() {
  const itemsRef = useRef(null);

  function scrollToId(itemId) {
    const map = getMap();
    const node = map.get(itemId);
    node.scrollIntoView({
      behavior: 'smooth',
      block: 'nearest',
      inline: 'center',
    });
  }

  function getMap() {
    // Initialize the Map on first usage
    if (!itemsRef.current) {
      itemsRef.current = new Map();
    }
    return itemsRef.current;
  }

  return (
    <>
      <nav>
        <button onClick={() => scrollToId(0)}>Tom</button>
        <button onClick={() => scrollToId(5)}>Maru</button>
        <button onClick={() => scrollToId(9)}>Jellylorum</button>
      </nav>
      <div>
        <ul>
          {catList.map((cat) => (
            <li
              key={cat.id}
              ref={(node) => {
                const map = getMap();
                if (node) {
                  map.set(cat.id, node);
                } else {
                  map.delete(cat.id);
                }
              }}
            >
              <img src={cat.imageUrl} alt={'Cat #' + cat.id} />
            </li>
          ))}
        </ul>
      </div>
    </>
  );
}
```
