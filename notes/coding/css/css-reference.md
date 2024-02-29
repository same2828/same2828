- [Table of Contents](#table-of-contents)
- [CSS Reset](#css-reset)
- [Resources](#resources)
- [Add to HTML `<head>`](#add-to-html-head)
- [Classes and IDs](#classes-and-ids)
- [CSS Animatable Properties](#css-animatable-properties)
- [CSS Combinator Selectors](#css-combinator-selectors)
- [CSS Default Values](#css-default-values)
- [CSS Functions](#css-functions)
- [CSS Properties](#css-properties)
  - [3D / 2D Transform](#3d--2d-transform)
  - [Animations](#animations)
  - [Backgrounds](#backgrounds)
  - [Border](#border)
  - [Box Model](#box-model)
  - [Colors](#colors)
  - [Column](#column)
  - [Font](#font)
  - [Generated Content](#generated-content)
  - [Hyperlink](#hyperlink)
  - [Line Box](#line-box)
  - [List \& Markers](#list--markers)
  - [Outline](#outline)
  - [Paged Media](#paged-media)
  - [Positioning](#positioning)
  - [Ruby](#ruby)
  - [Speech](#speech)
  - [Table](#table)
  - [Text](#text)
  - [Transitions](#transitions)
  - [UI](#ui)
- [CSS Selectors](#css-selectors)
- [CSS Units](#css-units)
  - [Absolute Measurement/Lengths](#absolute-measurementlengths)
  - [Relative Measurement/Lengths](#relative-measurementlengths)
- [Angles](#angles)
- [Colors](#colors-1)
- [Frequency](#frequency)
- [Pseudo-Class](#pseudo-class)
- [Pseudo-Element](#pseudo-element)
- [Selector Types](#selector-types)

# Table of Contents

# CSS Reset

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

# Resources

- [Flexbox](https://css-tricks.com/snippets/css/a-guide-to-flexbox/)
- [Grid](https://css-tricks.com/snippets/css/complete-guide-grid/)
- [CSS Cheatsheet](https://websitesetup.org/wp-content/uploads/2019/11/wsu-css-cheat-sheet-gdocs.pdf)
- [TailwindCSS](https://tailwindcss.com/docs/guides/vite)

# Add to HTML `<head>`

```html
<link rel="stylesheet" href="css/style.css" />
```

# Classes and IDs

```css
.class {
}

#id {
}
```

# CSS Animatable Properties

| Property                     |
| ---------------------------- |
| `background`                 |
| `background-color`           |
| `background-position`        |
| `background-size`            |
| `border`                     |
| `border-bottom`              |
| `border-bottom-color`        |
| `border-bottom-left-radius`  |
| `border-bottom-right-radius` |
| `border-bottom-width`        |
| `border-color`               |
| `border-left`                |
| `border-left-color`          |
| `border-left-width`          |
| `border-right`               |
| `border-right-color`         |
| `border-right-width`         |
| `border-spacing`             |
| `border-top`                 |
| `border-top-color`           |
| `border-top-left-radius`     |
| `border-top-right-radius`    |
| `border-top-width`           |
| `bottom`                     |
| `box-shadow`                 |
| `clip`                       |
| `color`                      |
| `column-count`               |
| `column-gap`                 |
| `column-rule`                |
| `column-rule-color`          |
| `column-rule-width`          |
| `column-width`               |
| `columns`                    |
| `filter`                     |
| `flex`                       |
| `flex-basis`                 |
| `flex-grow`                  |
| `flex-shrink`                |
| `font`                       |
| `font-size`                  |
| `font-size-adjust`           |
| `font-stretch`               |
| `font-weight`                |
| `grid`                       |
| `grid-area`                  |
| `grid-auto-columns`          |
| `grid-auto-flow`             |
| `grid-auto-rows`             |
| `grid-column`                |
| `grid-column-end`            |
| `grid-column-gap`            |
| `grid-column-start`          |
| `grid-gap`                   |
| `grid-row`                   |
| `grid-row-end`               |
| `grid-row-gap`               |
| `grid-row-start`             |
| `grid-template`              |
| `grid-template-areas`        |
| `grid-template-columns`      |
| `grid-template-rows`         |
| `height`                     |
| `left`                       |
| `letter-spacing`             |
| `line-height`                |
| `margin`                     |
| `margin-bottom`              |
| `margin-left`                |
| `margin-right`               |
| `margin-top`                 |
| `max-height`                 |
| `max-width`                  |
| `min-height`                 |
| `min-width`                  |
| `object-position`            |
| `opacity`                    |
| `order`                      |
| `outline`                    |
| `outline-color`              |
| `outline-offset`             |
| `outline-width`              |
| `padding`                    |
| `padding-bottom`             |
| `padding-left`               |
| `padding-right`              |
| `padding-top`                |
| `perspective`                |
| `perspective-origin`         |
| `right`                      |
| `text-decoration-color`      |
| `text-indent`                |
| `text-shadow`                |
| `top`                        |
| `transform`                  |
| `transform-origin`           |
| `vertical-align`             |
| `visibility`                 |
| `width`                      |
| `word-spacing`               |
| `z-index`                    |

# CSS Combinator Selectors

| Name               | Selector             | Info                                                                                                      | Example      | Example description                                                                |
| ------------------ | -------------------- | --------------------------------------------------------------------------------------------------------- | ------------ | ---------------------------------------------------------------------------------- |
| General Descendent | `element element`    | An element that is below (in the document tree) another element - no matter how many levels below         | `div p`      | Selects all `<p>` elements inside `<div>` elements                                 |
| Direct Child       | `element>element`    | An element that is directly below (in the document tree) another element                                  | `div > p`    | Selects all `<p>` elements where the parent is a `<div>` element                   |
| Adjacent Sibling   | `element+element`    | All elements that share the same parent and elements are in the same immediate sequence                   | `div + p`    | Selects the first `<p>` element that are placed immediately after `<div>` elements |
| General Sibling    | `element1~element2`  | All elements that share the same parent and elements are in the same sequence (not necessarily immediate) | `p ~ ul`     | Selects every `<ul>` element that are preceded by a `<p>` element                  |
| Grouping           | `element1, element2` | Multiple elements of different types                                                                      | `h1, h2, h3` | Selects all `h1`, `h2`, `h3` elements                                              |

# CSS Default Values

| Element            | Default CSS Value                                                                                                                                                                                                         |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `a:link:active`    | `color: (internal value);`                                                                                                                                                                                                |
| `a:link`           | `color: (internal value);`<br>`text-decoration: underline;`<br>`cursor: auto;`                                                                                                                                            |
| `a:visited:active` | `color: (internal value);`                                                                                                                                                                                                |
| `a:visited`        | `color: (internal value);`<br> `text-decoration: underline;`<br> `cursor: auto;`                                                                                                                                          |
| `abbr`             | `None`                                                                                                                                                                                                                    |
| `address`          | `display: block;`<br>`font-style: italic;`                                                                                                                                                                                |
| `area`             | `display: none;`                                                                                                                                                                                                          |
| `article`          | `display: block;`                                                                                                                                                                                                         |
| `aside`            | `display: block;`                                                                                                                                                                                                         |
| `audio`            | `None`                                                                                                                                                                                                                    |
| `b`                | `font-weight: bold;`                                                                                                                                                                                                      |
| `base`             | `None`                                                                                                                                                                                                                    |
| `bdi`              | `None`                                                                                                                                                                                                                    |
| `bdo`              | `unicode-bidi: bidi-override;`                                                                                                                                                                                            |
| `blockquote`       | `display: block;`<br>`margin-top: 1em;`<br>`margin-bottom: 1em;`<br>`margin-left: 40px;`<br>`margin-right: 40px;`                                                                                                         |
| `body:focus`       | `outline: none;`                                                                                                                                                                                                          |
| `body`             | `display: block;`<br>`margin: 8px;`                                                                                                                                                                                       |
| `br`               | `None`                                                                                                                                                                                                                    |
| `button`           | `None`                                                                                                                                                                                                                    |
| `canvas`           | `None`                                                                                                                                                                                                                    |
| `caption`          | `display: table-caption;`<br>`text-align: center;`                                                                                                                                                                        |
| `cite`             | `font-style: italic;`                                                                                                                                                                                                     |
| `code`             | `font-family: monospace;`                                                                                                                                                                                                 |
| `col`              | `display: table-column;`                                                                                                                                                                                                  |
| `colgroup`         | `display: table-column-group`                                                                                                                                                                                             |
| `datalist`         | `display: none;`                                                                                                                                                                                                          |
| `dd`               | `display: block;`<br>`margin-left: 40px;`                                                                                                                                                                                 |
| `del`              | `text-decoration: line-through;`                                                                                                                                                                                          |
| `details`          | `display: block;`                                                                                                                                                                                                         |
| `dfn`              | `font-style: italic;`                                                                                                                                                                                                     |
| `dialog`           | `None`                                                                                                                                                                                                                    |
| `div`              | `display: block;`                                                                                                                                                                                                         |
| `dl`               | `display: block;`<br>`margin-top: 1em;`<br>`margin-bottom: 1em;`<br>`margin-left: 0;`<br>`margin-right: 0;`                                                                                                               |
| `dt`               | `display: block;`                                                                                                                                                                                                         |
| `em`               | `font-style: italic;`                                                                                                                                                                                                     |
| `embed:focus`      | `outline: none;`                                                                                                                                                                                                          |
| `fieldset`         | `display: block;`<br>`margin-left: 2px;`<br>`margin-right: 2px;`<br>`padding-top: 0.35em;`<br>`padding-bottom: 0.625em;`<br>`padding-left: 0.75em;`<br>`padding-right: 0.75em;`<br>`border: 2px groove (internal value);` |
| `figcaption`       | `display: block;`                                                                                                                                                                                                         |
| `figure`           | `display: block;`<br>`margin-top: 1em;`<br>`margin-bottom: 1em`;<br>`margin-left: 40px;`<br>`margin-right: 40px`;                                                                                                         |
| `footer`           | `display: block;`                                                                                                                                                                                                         |
| `form`             | `display: block;`<br>`margin-top: 0em;`                                                                                                                                                                                   |
| `h1`               | `display: block;`<br>`font-size: 2em;`<br>`margin-top: 0.67em`;<br>`margin-bottom: 0.67em;`<br>`margin-left: 0;`<br>`margin-right: 0;`<br>`font-weight: bold;`                                                            |
| `h2`               | `display: block;`<br>`font-size: 1.5em;`<br>`margin-top: 0.83em`;<br>`margin-bottom: 0.83em;`<br>`margin-left: 0;`<br>`margin-right: 0;`<br>`font-weight: bold;`                                                          |
| `h3`               | `display: block;`<br>`font-size: 1.17em;`<br>`margin-top: 1em;`<br>`margin-bottom: 1em`;<br>`margin-left: 0;`<br>`margin-right: 0;`<br>`font-weight: bold;`                                                               |
| `h4`               | `display: block;`<br>`margin-top: 1.33em`;<br>`margin-bottom: 1.33em;`<br>`margin-left: 0;`<br>`margin-right: 0;`<br>`font-weight: bold;`                                                                                 |
| `h5`               | `display: block;`<br>`font-size: .83em;`<br>`margin-top: 1.67em;`<br>`margin-bottom: 1.67em;`<br>`margin-left: 0;`<br>`margin-right: 0;`<br>`font-weight: bold;`                                                          |
| `h6`               | `display: block;`<br>`font-size: .67em;`<br>`margin-top: 2.33em;`<br>`margin-bottom: 2.33em;`<br>`margin-left: 0;`<br>`margin-right: 0;`<br>`font-weight: bold;`                                                          |
| `head`             | `display: none;`                                                                                                                                                                                                          |
| `header`           | `display: block;`                                                                                                                                                                                                         |
| `hr`               | `display: block;`<br>`margin-top: 0.5em;`<br>`margin-bottom: 0.5em;`<br>`margin-left: auto;`<br>`margin-right: auto;`<br>`border-style: inset;`<br>`border-width: 1px;`                                                   |
| `html:focus`       | `outline: none;`                                                                                                                                                                                                          |
| `html`             | `display: block;`                                                                                                                                                                                                         |
| `i`                | `font-style: italic;`                                                                                                                                                                                                     |
| `iframe:focus`     | `outline: none;`                                                                                                                                                                                                          |
| `iframe[seamless]` | `display: block;`                                                                                                                                                                                                         |
| `img`              | `display: inline-block;`                                                                                                                                                                                                  |
| `input`            | `None`                                                                                                                                                                                                                    |
| `ins`              | `text-decoration: underline;`                                                                                                                                                                                             |
| `kbd`              | `font-family: monospace;`                                                                                                                                                                                                 |
| `label`            | `cursor: default;`                                                                                                                                                                                                        |
| `legend`           | `display: block;`<br>`padding-left: 2px;`<br>`padding-right: 2px;`<br>`border: none;`                                                                                                                                     |
| `li`               | `display: list-item;`                                                                                                                                                                                                     |
| `link`             | `display: none;`                                                                                                                                                                                                          |
| `main`             | `None`                                                                                                                                                                                                                    |
| `map`              | `display: inline;`                                                                                                                                                                                                        |
| `mark`             | `background-color: yellow;`<br>`color: black;`                                                                                                                                                                            |
| `menu`             | `display: block;`<br>`list-style-type: disc;`<br>`margin-top: 1em;`<br>`margin-bottom: 1em;`<br>`margin-left: 0;`<br>`margin-right: 0;`<br>`padding-left: 40px;`                                                          |
| `menuitem`         | `None`                                                                                                                                                                                                                    |
| `meta`             | `None`                                                                                                                                                                                                                    |
| `meter`            | `None`                                                                                                                                                                                                                    |
| `nav`              | `display: block;`                                                                                                                                                                                                         |
| `noscript`         | `None`                                                                                                                                                                                                                    |
| `object:focus`     | `outline: none;`                                                                                                                                                                                                          |
| `ol`               | `display: block;`<br>`list-style-type: decimal;`<br>`margin-top: 1em;`<br>`margin-bottom: 1em;`<br>`margin-left: 0;`<br>`margin-right: 0;`<br>`padding-left: 40px;`                                                       |
| `optgroup`         | `None`                                                                                                                                                                                                                    |
| `option`           | `None`                                                                                                                                                                                                                    |
| `output`           | `display: inline;`                                                                                                                                                                                                        |
| `p`                | `display: block;`<br>`margin-top: 1em;`<br>`margin-bottom: 1em;`<br>`margin-left: 0;`<br>`margin-right: 0;`                                                                                                               |
| `param`            | `display: none;`                                                                                                                                                                                                          |
| `picture`          | `None`                                                                                                                                                                                                                    |
| `pre`              | `display: block;`<br>`font-family: monospace;`<br>`white-space: pre;`<br>`margin: 1em 0;`                                                                                                                                 |
| `progress`         | `None`                                                                                                                                                                                                                    |
| `q::after`         | `content: close-quote;`                                                                                                                                                                                                   |
| `q::before`        | `content: open-quote;`                                                                                                                                                                                                    |
| `q`                | `display: inline;`                                                                                                                                                                                                        |
| `rp`               | `None`                                                                                                                                                                                                                    |
| `rt`               | `line-height: normal;`                                                                                                                                                                                                    |
| `ruby`             | `None`                                                                                                                                                                                                                    |
| `s`                | `text-decoration: line-through;`                                                                                                                                                                                          |
| `samp`             | `font-family: monospace;`                                                                                                                                                                                                 |
| `script`           | `display: none;`                                                                                                                                                                                                          |
| `section`          | `display: block;`                                                                                                                                                                                                         |
| `select`           | `None`                                                                                                                                                                                                                    |
| `small`            | `font-size: smaller;`                                                                                                                                                                                                     |
| `source`           | `None`                                                                                                                                                                                                                    |
| `span`             | `None`                                                                                                                                                                                                                    |
| `strike`           | `text-decoration: line-through;`                                                                                                                                                                                          |
| `strong`           | `font-weight: bold;`                                                                                                                                                                                                      |
| `style`            | `display: none;`                                                                                                                                                                                                          |
| `sub`              | `vertical-align: sub;`<br>`font-size: smaller;`                                                                                                                                                                           |
| `summary`          | `display: block;`                                                                                                                                                                                                         |
| `sup`              | `vertical-align: super;`<br>`font-size: smaller;`                                                                                                                                                                         |
| `table`            | `display: table;`<br>`border-collapse: separate;`<br>`border-spacing: 2px;`<br>`border-color: gray;`                                                                                                                      |
| `tbody`            | `display: table-row-group;`<br>`vertical-align: middle;`<br>`border-color: inherit;`                                                                                                                                      |
| `td`               | `display: table-cell;`<br>`vertical-align: inherit;`                                                                                                                                                                      |
| `template`         | `None`                                                                                                                                                                                                                    |
| `textarea`         | `None`                                                                                                                                                                                                                    |
| `tfoot`            | `display: table-footer-group;`<br>`vertical-align: middle;`<br>`border-color: inherit;`                                                                                                                                   |
| `th`               | `display: table-cell;`<br>`vertical-align: inherit;`<br>`font-weight: bold;`<br>`text-align: center;`                                                                                                                     |
| `thead`            | `display: table-header-group;`<br>`vertical-align: middle;`<br>`border-color: inherit;`                                                                                                                                   |
| `time`             | `None`                                                                                                                                                                                                                    |
| `title`            | `display: none;`                                                                                                                                                                                                          |
| `tr`               | `display: table-row;`<br>`vertical-align: inherit;`<br>`border-color: inherit;`                                                                                                                                           |
| `track`            | `None`                                                                                                                                                                                                                    |
| `u`                | `text-decoration: underline;`                                                                                                                                                                                             |
| `ul`               | `display: block;`<br>`list-style-type: disc;`<br>`margin-top: 1em;`<br>`margin-bottom: 1 em;`<br>`margin-left: 0;`<br>`margin-right: 0;`<br>`padding-left: 40px;`                                                         |
| `var`              | `font-style: italic;`                                                                                                                                                                                                     |
| `video`            | `None`                                                                                                                                                                                                                    |
| `wbr`              | `None`                                                                                                                                                                                                                    |

# CSS Functions

| Function                      | Description                                                                           |
| ----------------------------- | ------------------------------------------------------------------------------------- |
| `attr()`                      | Returns the value of an attribute of the selected element                             |
| `calc()`                      | Allows you to perform calculations to determine CSS property values                   |
| `conic-gradient()`            | Creates a conic gradient                                                              |
| `counter()`                   | Returns the current value of the named counter                                        |
| `cubic-bezier()`              | Defines a Cubic Bezier curve                                                          |
| `hsl()`                       | Defines colors using the Hue-Saturation-Lightness model (HSL)                         |
| `hsla()`                      | Defines colors using the Hue-Saturation-Lightness-Alpha model (HSLA)                  |
| `linear-gradient()`           | Creates a linear gradient                                                             |
| `max()`                       | Uses the largest value, from a comma-separated list of values, as the property value  |
| `min()`                       | Uses the smallest value, from a comma-separated list of values, as the property value |
| `radial-gradient()`           | Creates a radial gradient                                                             |
| `repeating-conic-gradient()`  | Repeats a conic gradient                                                              |
| `repeating-linear-gradient()` | Repeats a linear gradient                                                             |
| `repeating-radial-gradient()` | Repeats a radial gradient                                                             |
| `rgb()`                       | Defines colors using the Red-Green-Blue model (RGB)                                   |
| `rgba()`                      | Defines colors using the Red-Green-Blue-Alpha model (RGBA)                            |
| `var()`                       | Inserts the value of a custom property                                                |

# CSS Properties

## 3D / 2D Transform

| Element               | Values                                                                                                                                                                                                                                 |
| --------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `backface-visibility` | `visible \| hidden`                                                                                                                                                                                                                    |
| `perspective`         | `none \| number`                                                                                                                                                                                                                       |
| `perspective-origin`  | `[ [ percentage> \| <length> \| left \| center \| right ] [ <percentage> \| <length> \| top \| center \| bottom ]? ] <length> ] \| [ [ [ left \| center \| right ] \|\| [ top \| center \| bottom ] ] <length> ]`                      |
| `transform`           | `none \| matrix \| matrix3d \| translate3d \| tranlateX \| translateY \| translateZ \| scale \| scale3d \| scaleX \| scaleY \| scaleZ \| rotate \| rotate3d \| rotateX \| rotateY \| rotateZ \| skewX \| skewY \| skew \| perspective` |
| `transform-origin`    | `[ [ [ <percentage> \| <length> \| left \| center \| right ] [ <percentage> \| <length> \| top \| center \| bottom ]? ] <length> ] \| [ [ [ left \| center \| right ] \|\| [ top \| center \| bottom ] ] <length> ]`                   |
| `transform-style`     | `flat \| preserve-3d`                                                                                                                                                                                                                  |

## Animations

| Element                     | Values                                                                                                                                     |
| --------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| `animation-delay`           | `time`                                                                                                                                     |
| `animation-direction`       | `normal \| alternate`                                                                                                                      |
| `animation-duration`        | `time`                                                                                                                                     |
| `animation-iteration-count` | `inherit \| number`                                                                                                                        |
| `animation-name`            | `none \| IDENT`                                                                                                                            |
| `animation-play-state`      | `running \| paused`                                                                                                                        |
| `animation-timing-function` | `ease \| linear \| ease-in \| easeout \| ease-in-out \| cubic-Bezier \| (number, number, number, number)`                                  |
| `animations`                | `animation-name \| animation-duration \| animation-timing-function \| animation-delay \| animation-iteration-count \| animation-direction` |
| `rotation`                  | `angle \| rotation-point \| position (paired value off-set)`                                                                               |

## Backgrounds

| Property                | Values                                                                                                                                                          |
| ----------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `background`            | `bg-attachment bg-clip bg-color bg-image bg-origin bg-position bg-repeat bg-size`                                                                               |
| `background-attachment` | `scroll \| fixed \| local`                                                                                                                                      |
| `background-clip`       | `border-box \| padding-box \| content-box`                                                                                                                      |
| `background-color`      | `color \| transparent`                                                                                                                                          |
| `background-image`      | `url \| gradients \| none`                                                                                                                                      |
| `background-origin`     | `border-box \| padding-box \| content-box`                                                                                                                      |
| `background-position`   | `top left \| top center \| top right \| center left \| center center \| center right \| bottom left \| bottom center \| bottom right \| x-% y-% \| x-pos y-pos` |
| `background-repeat`     | `repeat \| repeat-x \| repeat-y \| no-repeat`                                                                                                                   |
| `background-size`       | `length \| % \| auto \| cover \| contain`                                                                                                                       |

## Border

| Property                     | Values                                                                                                                          |
| ---------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| `border-bottom`              | `border-bottom-width \| border-style \| border-color`                                                                           |
| `border-bottom-color`        | `border-color`                                                                                                                  |
| `border-bottom-left-radius`  | `length`                                                                                                                        |
| `border-bottom-right-radius` | `length`                                                                                                                        |
| `border-bottom-style`        | `border-style`                                                                                                                  |
| `border-break`               | `border-width\| border-style\| color\| close`                                                                                   |
| `border-collapse`            | `collapse \| separate`                                                                                                          |
| `border-color`               | `color`                                                                                                                         |
| `border-image`               | `image \| [ number / % border-width stretch \| repeat \| round ] \| none`                                                       |
| `border-left`                | `border-left-width\|border-style\|border-color`                                                                                 |
| `border-left-color`          | `border-color`                                                                                                                  |
| `border-left-style`          | `border-style`                                                                                                                  |
| `border-left-width`          | `thin \| medium \| thick length`                                                                                                |
| `border-right`               | `border-right-width\|border-style\|border-color`                                                                                |
| `border-radius`              | `border-radius \| border-top-right-radius \| border-bottom-right-radius \| border-bottom-left-radius \| border-top-left-radius` |
| `border-right-color`         | `border-color`                                                                                                                  |
| `border-right-style`         | `border-style`                                                                                                                  |
| `border-right-width`         | `thin \| medium \| thick \| length`                                                                                             |
| `border-style`               | `none \| hidden \| dotted \| dashed \| solid \| double \| groove \| ridge \| inset \| outset`                                   |
| `border-top`                 | `border-top-width \| border-style \| border-color`                                                                              |
| `border-top-color`           | `border-color`                                                                                                                  |
| `border-top-right-radius`    | `length`                                                                                                                        |
| `border-top-style`           | `border-style`                                                                                                                  |
| `border-top-width`           | `thin \| medium \| thick \| length`                                                                                             |
| `border-width`               | `thin \| medium \| thick \| length`                                                                                             |
| `border`                     | `width style color`                                                                                                             |
| `box-shadow`                 | `inset \| [ length, length, length, length \| <color> ] \| none`                                                                |

## Box Model

| Property         | Values                                                                                                                                                                                                                                                                                                                                                                                 |
| ---------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `clear`          | `left \| right \| both \| none`                                                                                                                                                                                                                                                                                                                                                        |
| `display`        | `none \| inline \| block \| inline-block \| flex \| inline-flex \| grid \| inline-grid \| contents \| list-item \|run-in \| compact \| table \| inline-table \| table-row-group \| table-header-group \| table-footer-group \| table-row \| table-column-group \| table-column \| table-cell \| table-caption \| ruby \| ruby-base \| ruby-text \| ruby-base-group \| ruby-text-group` |
| `float`          | `left \| right \| none`                                                                                                                                                                                                                                                                                                                                                                |
| `height`         | `auto \| length \| %`                                                                                                                                                                                                                                                                                                                                                                  |
| `margin`         | `margin-top \| margin-right \| margin-bottom \| margin-left`                                                                                                                                                                                                                                                                                                                           |
| `margin-bottom`  | `auto \| length \| %`                                                                                                                                                                                                                                                                                                                                                                  |
| `margin-left`    | `auto \| height \| %`                                                                                                                                                                                                                                                                                                                                                                  |
| `margin-right`   | `auto \| height \| %`                                                                                                                                                                                                                                                                                                                                                                  |
| `margin-top`     | `auto \| length \| %`                                                                                                                                                                                                                                                                                                                                                                  |
| `max-height`     | `none \| length \| %`                                                                                                                                                                                                                                                                                                                                                                  |
| `max-width`      | `none \| length \| %`                                                                                                                                                                                                                                                                                                                                                                  |
| `min-height`     | `none \| length \| %`                                                                                                                                                                                                                                                                                                                                                                  |
| `overflow-style` | `auto \| marquee-line \| marqueeblock \|`                                                                                                                                                                                                                                                                                                                                              |
| `overflow-x`     | `visible \| hidden \| scroll \| auto \| no-display \| no-content`                                                                                                                                                                                                                                                                                                                      |
| `overflow-y`     | `visible \| hidden \| scroll \| auto \| no-display \| no-content`                                                                                                                                                                                                                                                                                                                      |
| `overflow`       | `visible \| hidden \| scroll \| auto \| no-display \| no-content \| overflow-x \| overflow-y`                                                                                                                                                                                                                                                                                          |
| `padding`        | `padding-top \| padding-right \| padding-bottom \| padding-left`                                                                                                                                                                                                                                                                                                                       |
| `padding-bottom` | `length \| %`                                                                                                                                                                                                                                                                                                                                                                          |
| `padding-left`   | `length \| %`                                                                                                                                                                                                                                                                                                                                                                          |
| `padding-right`  | `length \| %`                                                                                                                                                                                                                                                                                                                                                                          |
| `padding-top`    | `length \| %`                                                                                                                                                                                                                                                                                                                                                                          |
| `visibility`     | `visible \| hidden \| collapse`                                                                                                                                                                                                                                                                                                                                                        |
| `width`          | `auto \| % \| length`                                                                                                                                                                                                                                                                                                                                                                  |

## Colors

| Element   | Values              |
| --------- | ------------------- |
| `color`   | `inherit \| color`  |
| `opacity` | `inherit \| number` |

## Column

| Element             | Values                                                                                             |
| ------------------- | -------------------------------------------------------------------------------------------------- |
| `columns`           | `column-width \| column-count`                                                                     |
| `column-count`      | `auto \| number`                                                                                   |
| `column-fill`       | `auto \| balance`                                                                                  |
| `column-gap`        | `normal \| length`                                                                                 |
| `column-rule-width` | `thin \| medium \| thick \| length`                                                                |
| `column-rule`       | `column-rule-width \| column-rule-style \| column-rule-color \| column-rule-style \| border-style` |
| `column-span`       | `1 \| all`                                                                                         |
| `column-width`      | `auto \| length`                                                                                   |

## Font

| Property           | Values                                                                                                                                                      |
| ------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `font`             | `font-style \| font-variant \| font-weight \| font-size/line-height \| font-family \| caption \| icon \| menu \| messagebox \| small-caption \| status-bar` |
| `font-family`      | `serif \| sans-serif \| Font Name`                                                                                                                          |
| `font-size-adjust` | `none \| inherit \| number`                                                                                                                                 |
| `font-size`        | `xx-small \| x-small \| small \| medium \| large \| x-large \| xxlarge \| smaller \| larger \| inherit \| length \| %`                                      |
| `font-style`       | `normal \| italic \| oblique \| inherit`                                                                                                                    |
| `font-variant`     | `normal \| small-caps \| inherit`                                                                                                                           |
| `font-weight`      | `normal \| bold \| bolder \| lighter \| 100 \| 200 \| 300 \| 400 \| 500 \| 600 \| 700 \| 800 \| 900 \| inherit`                                             |

## Generated Content

| Element               | Values                                |
| --------------------- | ------------------------------------- |
| `bookmark-label`      | `content \| attr \| string`           |
| `bookmark-level`      | `none \| integer`                     |
| `bookmark-target`     | `self \| url \| attr`                 |
| `border-length`       | `self \| url \| attr`                 |
| `content`             | `normal \| none \| inhibit \| url`    |
| `counter-increment`   | `none \| identifier number`           |
| `counter-reset`       | `none \| identifier number`           |
| `crop`                | `auto \| shape`                       |
| `display`             | `normal \| none \| list-item`         |
| `float-offset`        | `length length`                       |
| `hyphenate-after`     | `auto \| integer`                     |
| `hyphenate-before`    | `auto \| integer`                     |
| `hyphenate-character` | `auto \| string`                      |
| `hyphenate-lines`     | `no-limit \| integer`                 |
| `hyphenate-resource`  | `none \| url`                         |
| `hyphens`             | `none \| manual \| auto`              |
| `image-resolution`    | `normal \| auto \| dpi`               |
| `marks`               | `[crop \|\| cross ] \| none`          |
| `move-to`             | `normal \| here \| identifier`        |
| `page-policy`         | `start \| first \| last`              |
| `quotes`              | `none \| string string string string` |
| `string-set`          | `identifier \| content-list`          |
| `text-replace`        | `none \| [<string> <string>]+`        |

## Hyperlink

| Element           | Values                                                |
| ----------------- | ----------------------------------------------------- |
| `target`          | `target-name \| target-new \| target-position`        |
| `target-name`     | `current \| root \| parent \| new \| modal \| string` |
| `target-new`      | `window \| tab \| none`                               |
| `target-position` | `above \| behind \| front \| back`                    |

## Line Box

| Element                      | Values                                                                                                                                                                            |
| ---------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `alignment-adjust`           | `auto \| baseline \| before-edge \| text-before-edge \| middle \| central \| after-edge \| textafter-edge \| ideographic \| alphabetic \| hanging \| mathematical \| length \| %` |
| `alignment-baseline`         | `baseline \| ise-script \| beforeedge \| text-before-edge \| afteredge \| text-after-edge \| central \| middle \| ideographic \| alphabetic \| hanging \| mathematical`           |
| `baseline-shift`             | `baseline \| sub \| super \| length \| %`                                                                                                                                         |
| `dominant-baseline`          | `auto \| use-script \| no-change \| reset-size \| alphabetic \| hanging \| ideographic \| mathematical \| central \| middle \| text-after-edge \| text-beforeedge`                |
| `drop-initial-after-align`   | `alignment-baseline`                                                                                                                                                              |
| `drop-initial-after-align`   | `central \| middle \| after-edge \| text-after-edge \| ideographic \| alphabetic \| mathematical \| %`                                                                            |
| `drop-initial-before-adjust` | `before-edge \| text-before-edge \| central \| middle \| hanging \| mathematical \| length \| %`                                                                                  |
| `drop-initial-before-align`  | `caps-height \| alignment-baseline`                                                                                                                                               |
| `drop-initial-size`          | `auto \| integer \| % \| line`                                                                                                                                                    |
| `drop-initial-value`         | `initial \| integer`                                                                                                                                                              |
| `inline-box-align`           | `initial \| last \| integer`                                                                                                                                                      |
| `line-height`                | `normal \| number \| length \| %`                                                                                                                                                 |
| `line-stacking-ruby`         | `exclude-ruby \| include-ruby`                                                                                                                                                    |
| `line-stacking-shift`        | `consider-shifts \| disregardshifts`                                                                                                                                              |
| `line-stacking-strategy`     | `inline-line-height \| block-lineheight \| max-height \| gridheight`                                                                                                              |
| `line-stacking`              | `line-stacking-strategy \| line-stacking-ruby \| line-stacking-shift`                                                                                                             |
| `text-height`                | `auto \| font-size \| text-size \| max-size`                                                                                                                                      |
| `vertical-align`             | `Baseline \| sub \| super \| top \| text-top \| middle \| bottom \| text-bottom \| length \| %`                                                                                   |

## List & Markers

| Element            | Values                                                                                                                                                                                                                                                                                                                                                        |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `list-style`       | `list-style-type \| list-style-position \| list-style-image`                                                                                                                                                                                                                                                                                                  |
| `list-style-image` | `none \| url`                                                                                                                                                                                                                                                                                                                                                 |
| `list-style-type`  | `none \| asterisks \| box \| check \| circle \| diamond \| disc \| hyphen \| square \| decimal \| decimalleading-zero \| lower-roman \| upper-roman \| lower-alpha \| upper-alpha \| lower-greek \| lower-latin \| upper-latin \| hebrew \| armenian \| georgian \| cjk-ideographic \| hiragana \| katakana \| hiragana-iroha \| katakana-iroha \| footnotes` |
| `marker-offset`    | `auto \| length`                                                                                                                                                                                                                                                                                                                                              |

## Outline

| Element          | Values                                                                              |
| ---------------- | ----------------------------------------------------------------------------------- |
| `outline`        | `outline-color \| outline-style \| outline-width`                                   |
| `outline-offset` | `inherit \| length`                                                                 |
| `outline-style`  | `none \| dotted \| dashed \| solid \| double \| groove \| ridge \| inset \| outset` |
| `outline-width`  | `thin \| medium \| thick \| length`                                                 |

## Paged Media

| Element             | Values                                                                    |
| ------------------- | ------------------------------------------------------------------------- |
| `fit`               | `fill \| hidden \| meet \| slice`                                         |
| `fit-position`      | `[top \| center \| bottom] \|\| [left \| center \| right] \| length \| %` |
| `image-orientation` | `auto \| angle`                                                           |
| `orphans`           | `integer`                                                                 |
| `page-break-after`  | `auto \| always \| avoid \| left \| right`                                |
| `page-break-before` | `auto \| always \| avoid \| left \| right`                                |
| `page-break-inside` | `auto \| avoid`                                                           |
| `page`              | `auto \| identifier`                                                      |
| `size`              | `auto \| landscape \| portrait \| length`                                 |
| `windows`           | `integer`                                                                 |

## Positioning

| Element    | Values                                    |
| ---------- | ----------------------------------------- |
| `bottom`   | `auto \| % \| length`                     |
| `clip`     | `shape \| auto`                           |
| `left`     | `auto \| % \| length`                     |
| `position` | `static \| relative \| absolute \| fixed` |
| `right `   | `auto \| % \| length`                     |
| `top`      | `auto \| % \| length`                     |
| `z-index`  | `auto \| Number`                          |

## Ruby

| Element         | Values                                                                                                  |
| --------------- | ------------------------------------------------------------------------------------------------------- |
| `ruby-align`    | `auto \| start \| left \| center \| end \| right \| distribute-letter \| distribute-space \| line-edge` |
| `ruby-overhang` | `auto \| start \| end \| none`                                                                          |
| `ruby-position` | `before \| after \| right \| inline`                                                                    |
| `ruby-span`     | `attr(x) \| none`                                                                                       |

## Speech

| Element             | Values                                                                                             |
| ------------------- | -------------------------------------------------------------------------------------------------- |
| `caption-side`      | `top \| bottom \| left \| right`                                                                   |
| `cue`               | `cue-before \| cue-after`                                                                          |
| `cue-after`         | `url [ silent \| x-soft \| soft \| medium \| loud \| x-loud \| none \| inherit ] \| number \| %`   |
| `cue-before`        | `url [ silent \| x-soft \| soft \| medium \| loud \| x-loud \| none \| inherit ] \| number \| %`   |
| `mark`              | `mark-before \| mark-after`                                                                        |
| `mark-after`        | `string`                                                                                           |
| `mark-before`       | `string`                                                                                           |
| `pause`             | `pause-before \| pause-after`                                                                      |
| `pause-before`      | `none \| x-weak \| weak \| medium \| strong \| x-strong \| inherit \| time`                        |
| `phonemes`          | `string`                                                                                           |
| `rest`              | `rest-before \| rest-after`                                                                        |
| `rest-after`        | `none \| x-weak \| weak \| medium \| strong \| x-strong \| inherit \| time`                        |
| `rest-before`       | `none \| x-weak \| weak \| medium \| strong \| x-strong \| inherit \| time`                        |
| `speak`             | `none \| normal \| spell-out \| digits \| literal-punctuation \| no-punctuation \| inherit-number` |
| `voice-duration`    | `time`                                                                                             |
| `voice-family`      | `inherit \| [ <specific-voice, age, generic-voice, number> ]`                                      |
| `voice-pitch-range` | `x-low \| low \| medium \| high \| xhigh \| inherit \| number`                                     |
| `voice-pitch`       | `x-low \| low \| medium \| high \| xhigh \| inherit \| number \| %`                                |
| `voice-rate`        | `x-slow \| slow \| medium \| fast \| x-fast \| inherit \| %`                                       |
| `voice-stress`      | `strong \| moderate \| none \| reduced \| inherit`                                                 |
| `voice-volume`      | `silent \| x-soft \| soft \| medium \| loud \| x-loud \| inherit \| number \| %`                   |

## Table

| Element           | Values                           |
| ----------------- | -------------------------------- |
| `border-collapse` | `collapse \| separate`           |
| `border-spacing`  | `length length`                  |
| `caption-side`    | `top \| bottom \| left \| right` |
| `empty-cells`     | `show \| hide`                   |
| `table-layout`    | `auto \| fixed`                  |

## Text

| Element                | Values                                                                                      |
| ---------------------- | ------------------------------------------------------------------------------------------- |
| `direction`            | `ltr \| rtl \| inherit`                                                                     |
| `hanging-punctuation`  | `none \| [ start \| end \| endedge ]`                                                       |
| `letter-spacing`       | `normal \| length \| %`                                                                     |
| `punctuation-trim`     | `none \| [ start \| end \| adjacent ]`                                                      |
| `text-align`           | `start \| end \| left \| right \| center \| justify`                                        |
| `text-align-last`      | `start \| end \| left \| right \| center \| justify`                                        |
| `text-decoration`      | `none \| underline \| overline \| line-thorugh \| blink`                                    |
| `text-emphasis`        | `none \| [ [ accent \| dot \| circle \| disc \| [ before \| after ]?]`                      |
| `text-indent`          | `length \| %`                                                                               |
| `text-justify`         | `auto \| inter-word \| interideograph \| inter-cluster \| distribute \| kashida \| tibetan` |
| `text-outline`         | `none \| color \| length`                                                                   |
| `text-shadow`          | `none \| color \| length`                                                                   |
| `text-transform`       | `none \| capitalize \| uppercase \| lowercase`                                              |
| `text-wrap`            | `normal \| unresrricted \| none \| suppress`                                                |
| `unicode-bidi`         | `normal \| embed \| bidi-override`                                                          |
| `white-space`          | `normal \| pre \| nowrap \| pre-wrap \| pre-line`                                           |
| `white-space-collapse` | `perserve \| collapse \| pre-servebreaks \| discard`                                        |
| `word-break`           | `normal \| keep-all \| loose \| break-strict \| break-all`                                  |
| `word-spacing`         | `normal \| length \| %`                                                                     |
| `word-wrap`            | `normal \| nowrap`                                                                          |

## Transitions

| Element                      | Values                                                                                                |
| ---------------------------- | ----------------------------------------------------------------------------------------------------- |
| `transitions`                | `transitions-property \| transitions-duration \| transitions-timing-function \| transitions-delay`    |
| `transition-timing-function` | `ease \| linear \| ease-in \| ease-out \| ease-in-out \| cubicBezier(number, number, number, number)` |
| `transitions-delay`          | `time`                                                                                                |
| `transitions-duration`       | `time`                                                                                                |
| `transitions-property`       | `none \| all`                                                                                         |

## UI

| Element      | Values                                                                                                                                                                                                                                                                                                                                                              |
| ------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `appearance` | `normal \| inherit \| [ icon \| window \| desktop \| work-space \| document \| tooltip \| dialog \| button \| push-button \| hyperlink \| radio-button \| checkbox \| menu-item \| tab \| menu \| menubar \| pull-down-menu \| pop-up-menu \| list-menu \| radio-group \| checkbox-group \| outline-tree \| range \| field \| combo-box \| signature \| password ]` |
| `cursor`     | `auto \| crosshair \| default \| pointer \| move \| e-resize \| neresize \| nw-resize \| n-resize \| se-resize \| sw-resize \| swresize \| s-resize \| w-resize \| text \| wait \| help \| url`                                                                                                                                                                     |
| `icon`       | `auto \| inherit \| url`                                                                                                                                                                                                                                                                                                                                            |
| `nav-down`   | `auto \| inherit <id> [current \| root \| <target-name>`                                                                                                                                                                                                                                                                                                            |
| `nav-index`  | `auto \| inherit \| number`                                                                                                                                                                                                                                                                                                                                         |
| `nav-left`   | `auto \| inherit <id> [current \| root \| <target-name>`                                                                                                                                                                                                                                                                                                            |
| `nav-right`  | `auto \| inherit <id> [current \| root \| <target-name>`                                                                                                                                                                                                                                                                                                            |
| `nav-up`     | `auto \| inherit <id> [current \| root \| <target-name>`                                                                                                                                                                                                                                                                                                            |
| `resize`     | `none \| both \| horizontal \| vertical \| inherit`                                                                                                                                                                                                                                                                                                                 |

# CSS Selectors

- [MDN Reference](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Selectors)

| Selector                | Example                 | Example Description                                                                                      |
| ----------------------- | ----------------------- | -------------------------------------------------------------------------------------------------------- |
| `.class`                | `.intro`                | Selects all elements with class="intro"                                                                  |
| `.class1.class2`        | `.name1.name2`          | Selects all elements with both name1 and name2 set within its class attribute                            |
| `.class1 .class2`       | `.name1 .name2`         | Selects all elements with name2 that is a descendant of an element with name1                            |
| `#id`                   | `#firstname`            | Selects the element with id="firstname"                                                                  |
| `*`                     | `*`                     | Selects all elements                                                                                     |
| `element`               | `p`                     | Selects all `<p>` elements                                                                               |
| `element.class`         | `p.intro`               | Selects all `<p>` elements with class="intro"                                                            |
| `element,element`       | `div, p`                | Selects all `<div>` elements and all `<p>` elements                                                      |
| `element element`       | `div p`                 | Selects all `<p>` elements inside `<div>` elements                                                       |
| `element>element`       | `div > p`               | Selects all `<p>` elements where the parent is a `<div>` element                                         |
| `element+element`       | `div + p`               | Selects the first `<p>` element that is placed immediately after `<div>` elements                        |
| `element1~element2`     | `p ~ ul`                | Selects every `<ul>` element that is preceded by a `<p>` element                                         |
| `[attribute]`           | `[target]`              | Selects all elements with a target attribute                                                             |
| `[attribute=value]`     | `[target=_blank]`       | Selects all elements with `target="\_blank"`                                                             |
| `[attribute~=value]`    | `[title~=flower]`       | Selects all elements with a title attribute containing the word "flower"                                 |
| `[attribute \| =value]` | `[lang \| =en]`         | Selects all elements with a lang attribute value equal to "en" or starting with "en-"                    |
| `[attribute^=value]`    | `a[href^="https"]`      | Selects every `<a>` element whose href attribute value begins with "https"                               |
| `[attribute$=value]`    | `a[href$=".pdf"]`       | Selects every `<a>` element whose href attribute value ends with ".pdf"                                  |
| `[attribute*=value]`    | `a[href*="w3schools"]`  | Selects every `<a>` element whose href attribute value contains the substring "w3schools"                |
| `:active`               | `a:active`              | Selects the active link                                                                                  |
| `::after`               | `p::after`              | Insert something after the content of each `<p>` element                                                 |
| `::before`              | `p::before`             | Insert something before the content of each `<p>` element                                                |
| `:checked`              | `input:checked`         | Selects every checked `<input>` element                                                                  |
| `:default`              | `input:default`         | Selects the default `<input>` element                                                                    |
| `:disabled`             | `input:disabled`        | Selects every disabled `<input>` element                                                                 |
| `:empty`                | `p:empty`               | Selects every `<p>` element that has no children (including text nodes)                                  |
| `:enabled`              | `input:enabled`         | Selects every enabled `<input>` element                                                                  |
| `:first-child`          | `p:first-child`         | Selects every `<p>` element that is the first child of its parent                                        |
| `::first-letter`        | `p::first-letter`       | Selects the first letter of every `<p>` element                                                          |
| `::first-line`          | `p::first-line`         | Selects the first line of every `<p>` element                                                            |
| `:first-of-type`        | `p:first-of-type`       | Selects every `<p>` element that is the first `<p>` element of its parent                                |
| `:focus`                | `input:focus`           | Selects the input element which has focus                                                                |
| `:fullscreen`           | `:fullscreen`           | Selects the element that is in full-screen mode                                                          |
| `:hover`                | `a:hover`               | Selects links on mouse over                                                                              |
| `:in-range`             | `input:in-range`        | Selects input elements with a value within a specified range                                             |
| `:indeterminate`        | `input:indeterminate`   | Selects input elements that are in an indeterminate state                                                |
| `:invalid`              | `input:invalid`         | Selects all input elements with an invalid value                                                         |
| `:lang(language)`       | `p:lang(it)`            | Selects every `<p>` element with a lang attribute equal to "it" (Italian)                                |
| `:last-child`           | `p:last-child`          | Selects every `<p>` element that is the last child of its parent                                         |
| `:last-of-type`         | `p:last-of-type`        | Selects every `<p>` element that is the last `<p>` element of its parent                                 |
| `:link`                 | `a:link`                | Selects all unvisited links                                                                              |
| `::marker`              | `::marker`              | Selects the markers of list items                                                                        |
| `:not(selector)`        | `:not(p)`               | Selects every element that is not a `<p>` element                                                        |
| `:nth-child(n)`         | `p:nth-child(2)`        | Selects every `<p>` element that is the second child of its parent                                       |
| `:nth-last-child(n)`    | `p:nth-last-child(2)`   | Selects every `<p>` element that is the second child of its parent, counting from the last child         |
| `:nth-last-of-type(n)`  | `p:nth-last-of-type(2)` | Selects every `<p>` element that is the second `<p>` element of its parent, counting from the last child |
| `:nth-of-type(n)`       | `p:nth-of-type(2)`      | Selects every `<p>` element that is the second `<p>` element of its parent                               |
| `:only-of-type`         | `p:only-of-type`        | Selects every `<p>` element that is the only `<p>` element of its parent                                 |
| `:only-child`           | `p:only-child`          | Selects every `<p>` element that is the only child of its parent                                         |
| `:optional`             | `input:optional`        | Selects input elements with no "required" attribute                                                      |
| `:out-of-range`         | `input:out-of-range`    | Selects input elements with a value outside a specified range                                            |
| `::placeholder`         | `input::placeholder`    | Selects input elements with the "placeholder" attribute specified                                        |
| `:read-only`            | `input:read-only`       | Selects input elements with the "readonly" attribute specified                                           |
| `:read-write`           | `input:read-write`      | Selects input elements with the "readonly" attribute NOT specified                                       |
| `:required`             | `input:required`        | Selects input elements with the "required" attribute specified                                           |
| `:root`                 | `:root`                 | Selects the document's root element                                                                      |
| `::selection`           | `::selection`           | Selects the portion of an element that is selected by a user                                             |
| `:target`               | `#news:target`          | Selects the current active #news element (clicked on a URL containing that anchor name)                  |
| `:valid`                | `input:valid`           | Selects all input elements with a valid value                                                            |
| `:visited`              | `a:visited`             | Selects all visited links                                                                                |

# CSS Units

- A whitespace cannot appear between the number and the unit
  - However, if the value is 0, the unit can be omitted
- For some CSS properties, negative lengths are allowed

## Absolute Measurement/Lengths

- The absolute length units are fixed and a length expressed in any of these will appear as exactly that size
- Absolute length units are not recommended for use on screen, because screen sizes vary so much
- However, they can be used if the output medium is known, such as for print layout
- Pixels (px) are relative to the viewing device
  - For low-dpi devices, 1px is one device pixel (dot) of the display
  - For printers and high resolution screens 1px implies multiple device pixels

| Absolute Unit | Description                  |
| ------------- | ---------------------------- |
| `cm`          | Centimeters                  |
| `in`          | Inches (1in = 96px = 2.54cm) |
| `mm`          | Millimeters                  |
| `pc`          | Picas (1pc = 12 pt)          |
| `pt`          | Points (1pt = 1/72 inch)     |
| `px`          | Pixels (1px = 1/96th inch)   |

## Relative Measurement/Lengths

- Relative length units specify a length relative to another length property
- Relative length units scale better between different rendering medium
- The em and rem units are practical in creating perfectly scalable layout
- Viewport = The browser window size
  - If the viewport is 50cm wide
    - 1vw = 0.5cm
    - 100vw = 50cm

| Relative Unit | Description                                                                                                                           |
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------- |
| `%`           | Relative to the parent element                                                                                                        |
| `ch`          | Relative to the width of the "0" (zero)                                                                                               |
| `em`          | Relative to the font-size of the element (1em = current font size of current element, 2em means 2 times the size of the current font) |
| `ex`          | Relative to the x-height of the current font (rarely used)                                                                            |
| `rem`         | Relative to font-size of the root element                                                                                             |
| `vh`          | Relative to 1% of the height of the viewport                                                                                          |
| `vmax`        | Relative to 1% of viewport's larger dimension                                                                                         |
| `vmin`        | Relative to 1% of viewport's smaller dimension                                                                                        |
| `vw`          | Relative to 1% of the width of the viewport                                                                                           |

# Angles

| Angle  | Description |
| ------ | ----------- |
| `deg`  | Degrees     |
| `grad` | Grads       |
| `rad`  | Radians     |
| `turn` | Turns       |

# Colors

| Color                            | Description                                                                                             |
| -------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `Color Name`                     | `red, blue, green, dark green`                                                                          |
| `hsl(hue, saturation,lightness)` | red = `hsl(0, 100%, 50%)`                                                                               |
| `#rrggbb`                        | red = `#ff0000 (or shorthand #f00)`                                                                     |
| `rgb(x,y,z) `                    | red = `rgb(255,0,0)`                                                                                    |
| `rgb(x%,y%,z%)`                  | red = `rgb(100%,0,0)`                                                                                   |
| `rgba(x,y,z,alpha)`              | red = `rgba(255,0,0,0)`                                                                                 |
| `Flavor`                         | An accent color (typically chosen by the user) to customize the user interface of the user agent itself |
| `currentColor`                   | Computer value of the ‘currentColor' keyword is the computed value of the 'color' property              |

# Frequency

| Frequency | Description |
| --------- | ----------- |
| `Hz`      | Hertz       |
| `kHz`     | Kilo-hertz  |

# Pseudo-Class

| Pseudo-Class           | Description                                                                    |
| ---------------------- | ------------------------------------------------------------------------------ |
| `:active`              | An activated element                                                           |
| `:checked`             | An element that is checked                                                     |
| `:disabled`            | An element while the element is disabled                                       |
| `:empty`               | An element that has no children                                                |
| `:enabled`             | An element while the element is enabled                                        |
| `:first-child`         | An element that is the first sibling                                           |
| `:first-of-type`       | An element that is the first sibling of its type                               |
| `:focus`               | An element while the element has focus                                         |
| `:hover`               | An element when you mouse over it                                              |
| `:lang`                | Allows the author to specify a language to use in a specified element          |
| `:last-child`          | An element that is the last sibling                                            |
| `:last-of-type`        | An element that is the last sibling of its type                                |
| `:link`                | An unvisited link                                                              |
| `:not(x)`              | An element not represented by the argument 'x'                                 |
| `:nth-child(n)`        | An element that is the n-th sibling                                            |
| `:nth-last-child(n)`   | An element that is the n-th sibling counting from the last sibling             |
| `:nth-last-of-type(n)` | An element that is the n-th sibling of its type counting from the last sibling |
| `:nth-of-type(n)`      | An element that is the n-th sibling of its type                                |
| `:only-child`          | An element that is the only child                                              |
| `:only-of-type`        | An element that is the only child of its type                                  |
| `:root`                | Root element within the document                                               |
| `:selection`           | An element that is currently selected or highlighted by the user               |
| `:target`              | A target element as specified by a target in a UR                              |

# Pseudo-Element

| Pseudo-Element   | Description                                           |
| ---------------- | ----------------------------------------------------- |
| `::after`        | Inserts some content after the content of an element  |
| `::before`       | Inserts some content before the content of an element |
| `::first-letter` | Adds special style to the first letter of a text      |
| `::first-line`   | Adds special style to the first line of a text        |

# Selector Types

| Name             | Info                                                                                                      | Example                                                                                                                                                                                                                                                                                                                                        |
| ---------------- | --------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Adjacent Sibling | All elements that share the same parent and elements are in the same immediate sequence                   | `h1 + p { font-style: italic; }`                                                                                                                                                                                                                                                                                                               |
| Attribute        | An element that matches the attribute listed                                                              | `E[selected]` = Att whatever the value <br>`E[att="val"]` = Att with a specific value <br>`E[rel~="next"]` = Att with a value is a whitespace separated list <br>`*[lang\|="en"]` = Att value either being exactly "val" or beginning with "val" immediately followed by "-" <br>`E[att^="val"]` = Att value that begins with the prefix "val" |
| Child            | An element that is directly below (in the document tree) another element                                  | `#title > p { font-weight: bold; }`                                                                                                                                                                                                                                                                                                            |
| Class            | Multiple elements of different types when you don't want to affect all instances of that type             | `.sampleClass { text-decoration:underline; }`                                                                                                                                                                                                                                                                                                  |
| Descendant       | An element that is below (in the document tree) another element - no matter how many levels below         | `#gallery h1 { text-decoration: underline; }`                                                                                                                                                                                                                                                                                                  |
| General Sibling  | All elements that share the same parent and elements are in the same sequence (not necessarily immediate) | `h1 ~ p { font-style: italic; }`                                                                                                                                                                                                                                                                                                               |
| Grouping         | Multiple elements of different types                                                                      | `h1, h2, h3 { font-family:Verdana; }`                                                                                                                                                                                                                                                                                                          |
| Id               | A single element type when you don't want to affect all instances of that type                            | `#sampleID { text-decoration: underline; }`                                                                                                                                                                                                                                                                                                    |
| Type             | Any element of that type                                                                                  | `h1 { text-decoration:underline; }`                                                                                                                                                                                                                                                                                                            |
| Universal        | Any element                                                                                               | `* { font: 10px Arial; }`                                                                                                                                                                                                                                                                                                                      |
