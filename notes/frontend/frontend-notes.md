# Table of Contents

- [Table of Contents](#table-of-contents)
- [CSS = Styling](#css--styling)
- [HTML = Structuring](#html--structuring)
- [JavaScript](#javascript)
- [ReactJS](#reactjs)

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

# JavaScript

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
- Map over shit
- `&&` == `return`
- Can push html templates into useState variable
- Can push data/json into useState variable
- Can add eventListeners()
