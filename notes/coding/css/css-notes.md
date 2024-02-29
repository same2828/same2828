# Table of Contents

- [Table of Contents](#table-of-contents)
- [CSS Reset](#css-reset)
- [Background](#background)
- [Include the padding and border in an element's total width and height](#include-the-padding-and-border-in-an-elements-total-width-and-height)
- [Make content take up full viewport](#make-content-take-up-full-viewport)

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

# Background

```css
background-size: cover;
```

# Include the padding and border in an element's total width and height

```css
.container {
  box-sizing: border-box;
}
```

# Make content take up full viewport

```css
html,
body {
  margin: 0;
  height: 100%;
  width: 100%;
  font-family: Arial, Helvetica, sans-serif;
}
```
