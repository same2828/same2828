# Table of Contents

- [Table of Contents](#table-of-contents)
- [Boilerplate](#boilerplate)
- [CSS within HTML file](#css-within-html-file)
- [JavaScript within HTML file](#javascript-within-html-file)
- [HTML Elements](#html-elements)
  - [Main Root](#main-root)
  - [Document Metadata](#document-metadata)
  - [Sectioning Root](#sectioning-root)
  - [Content Sectioning](#content-sectioning)
  - [Text Content](#text-content)
  - [Inline Text Semantics](#inline-text-semantics)
  - [Image and Multimedia](#image-and-multimedia)
  - [Embedded Content](#embedded-content)
  - [SVG and MathML](#svg-and-mathml)
  - [Scripting](#scripting)
  - [Demarcating Edits](#demarcating-edits)
  - [Table Content](#table-content)
  - [Forms](#forms)
  - [Interactive Elements](#interactive-elements)
  - [Web Components](#web-components)
  - [Obsolete and Deprecated elements](#obsolete-and-deprecated-elements)
- [HTML Attributes](#html-attributes)
- [HTML Global Attributes](#html-global-attributes)
- [HTML Event Attributes](#html-event-attributes)
  - [Clipboard Events](#clipboard-events)
  - [Drag Events](#drag-events)
  - [Form Events](#form-events)
  - [Keyboard Events](#keyboard-events)
  - [Media Events](#media-events)
  - [Misc Events](#misc-events)
  - [Mouse Events](#mouse-events)
  - [Window Event Attributes](#window-event-attributes)
- [HTML Colors](#html-colors)
- [HTML DOM](#html-dom)
  - [HTML DOM Documents](#html-dom-documents)
    - [Document Object Properties and Methods](#document-object-properties-and-methods)
  - [HTML DOM Elements](#html-dom-elements)
    - [classList](#classlist)
      - [classList Properties and Methods](#classlist-properties-and-methods)
  - [HTML DOM Event Objects](#html-dom-event-objects)
    - [Animation Event](#animation-event)
    - [Clipboard Event](#clipboard-event)
    - [Drag Event](#drag-event)
    - [Focus Event](#focus-event)
    - [HashChange Event](#hashchange-event)
    - [Input Event](#input-event)
    - [Keyboard Event](#keyboard-event)
    - [Mouse Event](#mouse-event)
    - [PageTransition Event](#pagetransition-event)
    - [PopState Event](#popstate-event)
    - [Progress Event](#progress-event)
    - [Storage Event](#storage-event)
    - [Touch Event](#touch-event)
    - [Transition Event](#transition-event)
    - [UI Event](#ui-event)
    - [Wheel Event](#wheel-event)
- [Miscellaneous](#miscellaneous)

# Boilerplate

```html
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="style.css" />
  </head>

  <body>
    <div class="container">Hello World!</div>

    <!-- Scripts -->
    <script type="module" src="main.js"></script>
  </body>
</html>
```

```html
<div class="class1" id="page-login">
  <div style="width: 100%; height: 1200px; border: 1px solid #333;"></div>
</div>
```

# CSS within HTML file

```css
<style type='text/css'>
  body {
    font-family: Arial;
  }

  #box-blue-container {
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
    margin: 10px;
    /* min-width: 320px; */
  }
</style>
```

# JavaScript within HTML file

```javascript
<script type='text/javascript'>
  const submitBtn = document.getElementById('submit-btn');
  submitBtn.addEventListener('click', () => {
    document.getElementById('submit-popup').style.display = 'block';
  });

  document.getElementById('cancel-popup').addEventListener('click', () => {
    document.getElementById('submit-popup').style.display = 'none';
  })

</script>
```

# HTML Elements

## Main Root

| Element | Description                                                                                                                                                                                  |
| ------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `html`  | The `<html>` HTML element represents the root (top-level element) of an HTML document, so it is also referred to as the root element. All other elements must be descendants of this element |

## Document Metadata

- Metadata contains information about the page
- This includes information about styles, scripts and data to help software (search engines, browsers, etc.) use and render the page
- Metadata for styles and scripts may be defined in the page or link to another file that has the information

| Element   | Description                                                                                                                                                                                                                                                                                                  |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `<base>`  | The `<base>` HTML element specifies the base URL to use for all relative URLs in a document. There can be only one `<base>` element in a document                                                                                                                                                            |
| `<head>`  | The `<head>` HTML element contains machine-readable information (metadata) about the document, like its title, scripts, and style sheets                                                                                                                                                                     |
| `<link>`  | The `<link>` HTML element specifies relationships between the current document and an external resource. This element is most commonly used to link to CSS, but is also used to establish site icons (both "favicon" style icons and icons for the home screen and apps on mobile devices) among other thing |
| `<meta>`  | The `<meta>` HTML element represents Metadata that cannot be represented by other HTML meta-related elements, like base, link, script, style or title                                                                                                                                                        |
| `<style>` | The `<style>` HTML element contains style information for a document, or part of a document. It contains CSS, which is applied to the contents of the document containing the `<style>` element                                                                                                              |
| `<title>` | The `<title>` HTML element defines the document's title that is shown in a Browser's title bar or a page's tab. It only contains text; tags within the element are ignored                                                                                                                                   |

## Sectioning Root

| Element  | Description                                                                                                                |
| -------- | -------------------------------------------------------------------------------------------------------------------------- |
| `<body>` | The `<body>` HTML element represents the content of an HTML document. There can be only one `<body>` element in a document |

## Content Sectioning

- Content sectioning elements allow you to organize the document content into logical pieces
- Use the sectioning elements to create a broad outline for your page content, including header and footer navigation, and heading elements to identify sections of content

| Element                              | Description                                                                                                                                                                                                                                                                                                                                                                                                   |
| ------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<address>`                          | The `<address>` HTML element indicates that the enclosed HTML provides contact information for a person or people, or for an organization                                                                                                                                                                                                                                                                     |
| `<article>`                          | The `<article>` HTML element represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable (e.g., in syndication). Examples include: a forum post, a magazine or newspaper article, or a blog entry, a product card, a user-submitted comment, an interactive widget or gadget, or any other independent item of content |
| `<aside>`                            | The `<aside>` HTML element represents a portion of a document whose content is only indirectly related to the document's main content. Asides are frequently presented as sidebars or call-out boxes                                                                                                                                                                                                          |
| `<footer>`                           | The `<footer>` HTML element represents a footer for its nearest ancestor sectioning content or sectioning root element. A `<footer>` typically contains information about the author of the section, copyright data or links to related documents                                                                                                                                                             |
| `<header>`                           | The `<header>` HTML element represents introductory content, typically a group of introductory or navigational aids. It may contain some heading elements but also a logo, a search form, an author name, and other elements                                                                                                                                                                                  |
| `<h1>, <h2>, <h3>, <h4>, <h5>, <h6>` | The `<h1>` to `<h6>` HTML elements represent six levels of section headings. `<h1>` is the highest section level and `<h6>` is the lowest                                                                                                                                                                                                                                                                     |
| `<main>`                             | The `<main>` HTML element represents the dominant content of the body of a document. The main content area consists of content that is directly related to or expands upon the central topic of a document, or the central functionality of an application                                                                                                                                                    |
| `<nav>`                              | The `<nav>` HTML element represents a section of a page whose purpose is to provide navigation links, either within the current document or to other documents. Common examples of navigation sections are menus, tables of contents, and indexes                                                                                                                                                             |
| `<section>`                          | The `<section>` HTML element represents a generic standalone section of a document, which doesn't have a more specific semantic element to represent it. Sections should always have a heading, with very few exceptions                                                                                                                                                                                      |

## Text Content

- Use HTML text content elements to organize blocks or sections of content placed between the opening `<body>` and closing `</body>` tags.
- Important for accessibility and Search Engine Optimization (SEO), these elements identify the purpose or structure of that content.

| Element        | Description                                                                                                                                                                                                                                                                                                                                                                  |
| -------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<blockquote>` | The `<blockquote>` HTML element indicates that the enclosed text is an extended quotation. Usually, this is rendered visually by indentation (see Notes for how to change it). A URL for the source of the quotation may be given using the cite attribute, while a text representation of the source can be given using the cite element                                    |
| `<dd>`         | The `<dd>` HTML element provides the description, definition, or value for the preceding term (dt) in a description list (dl)                                                                                                                                                                                                                                                |
| `<div>`        | The `<div>` HTML element is the generic container for flow content. It has no effect on the content or layout until styled in some way using CSS (e.g. styling is directly applied to it, or some kind of layout model like Flexbox is applied to its parent element)                                                                                                        |
| `<dl>`         | The `<dl>` HTML element represents a description list. The element encloses a list of groups of terms (specified using the dt element) and descriptions (provided by dd elements). Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs)                                                                               |
| `<dt>`         | The `<dt>` HTML element specifies a term in a description or definition list, and as such must be used inside a dl element. It is usually followed by a dd element; however, multiple `<dt>` elements in a row indicate several terms that are all defined by the immediate next dd element                                                                                  |
| `<figcaption>` | The `<figcaption>` HTML element represents a caption or legend describing the rest of the contents of its parent figure element                                                                                                                                                                                                                                              |
| `<figure>`     | The `<figure>` HTML element represents self-contained content, potentially with an optional caption, which is specified using the figcaption element. The figure, its caption, and its contents are referenced as a single unit                                                                                                                                              |
| `<hr>`         | The `<hr>` HTML element represents a thematic break between paragraph-level elements: for example, a change of scene in a story, or a shift of topic within a section                                                                                                                                                                                                        |
| `<li>`         | The `<li>` HTML element is used to represent an item in a list. It must be contained in a parent element: an ordered list (ol), an unordered list (ul), or a menu (menu). In menus and unordered lists, list items are usually displayed using bullet points. In ordered lists, they are usually displayed with an ascending counter on the left, such as a number or letter |
| `<menu>`       | The `<menu>` HTML element is a semantic alternative to ul. It represents an unordered list of items (represented by li elements), each of which represents a link or other command that the user can activate                                                                                                                                                                |
| `<ol>`         | The `<ol>` HTML element represents an ordered list of items — typically rendered as a numbered list                                                                                                                                                                                                                                                                          |
| `<p>`          | The `<p>` HTML element represents a paragraph. Paragraphs are usually represented in visual media as blocks of text separated from adjacent blocks by blank lines and/or first-line indentation, but HTML paragraphs can be any structural grouping of related content, such as images or form fields                                                                        |
| `<pre>`        | The `<pre>` HTML element represents preformatted text which is to be presented exactly as written in the HTML file. The text is typically rendered using a non-proportional, or monospaced, font. Whitespace inside this element is displayed as written                                                                                                                     |
| `<ul>`         | The `<ul>` HTML element represents an unordered list of items, typically rendered as a bulleted list                                                                                                                                                                                                                                                                         |

## Inline Text Semantics

- Use the HTML inline text semantic to define the meaning, structure, or style of a word, line, or any arbitrary piece of text

| Element    | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| ---------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<a>`      | The `<a> `HTML element (or anchor element), with its href attribute, creates a hyperlink to web pages, files, email addresses, locations in the same page, or anything else a URL can address                                                                                                                                                                                                                                                                        |
| `<abbr>`   | The `<abbr>` HTML element represents an abbreviation or acronym; the optional title attribute can provide an expansion or description for the abbreviation. If present, title must contain this full description and nothing else                                                                                                                                                                                                                                    |
| `<b>`      | The `<b> `HTML element is used to draw the reader's attention to the element's contents, which are not otherwise granted special importance. This was formerly known as the Boldface element, and most browsers still draw the text in boldface. However, you should not use `<b>` for styling text; instead, you should use the CSS font-weight property to create boldface text, or the strong element to indicate that text is of special importance              |
| `<bdi>`    | The `<bdi>` HTML element tells the browser's bidirectional algorithm to treat the text it contains in isolation from its surrounding text. It's particularly useful when a website dynamically inserts some text and doesn't know the directionality of the text being inserted                                                                                                                                                                                      |
| `<bdo>`    | The `<bdo>` HTML element overrides the current directionality of text, so that the text within is rendered in a different direction                                                                                                                                                                                                                                                                                                                                  |
| `<br>`     | The `<br>` HTML element produces a line break in text (carriage-return). It is useful for writing a poem or an address, where the division of lines is significant                                                                                                                                                                                                                                                                                                   |
| `<cite>`   | The `<cite>` HTML element is used to describe a reference to a cited creative work, and must include the title of that work. The reference may be in an abbreviated form according to context-appropriate conventions related to citation metadata                                                                                                                                                                                                                   |
| `<code>`   | The `<code>` HTML element displays its contents styled in a fashion intended to indicate that the text is a short fragment of computer code. By default, the content text is displayed using the user agent default monospace font                                                                                                                                                                                                                                   |
| `<data>`   | The `<data>` HTML element links a given piece of content with a machine-readable translation. If the content is time- or date-related, the time element must be used                                                                                                                                                                                                                                                                                                 |
| `<dfn>`    | The `<dfn>` HTML element is used to indicate the term being defined within the context of a definition phrase or sentence. The p element, the dt/dd pairing, or the section element which is the nearest ancestor of the `<dfn>` is considered to be the definition of the term                                                                                                                                                                                      |
| `<em>`     | The `<em>` HTML element marks text that has stress emphasis. The `<em>` element can be nested, with each level of nesting indicating a greater degree of emphasis                                                                                                                                                                                                                                                                                                    |
| `<i>`      | The `<i> `HTML element represents a range of text that is set off from the normal text for some reason, such as idiomatic text, technical terms, taxonomical designations, among others. Historically, these have been presented using italicized type, which is the original source of the `<i>` naming of this element                                                                                                                                             |
| `<kbd>`    | The `<kbd>` HTML element represents a span of inline text denoting textual user input from a keyboard, voice input, or any other text entry device. By convention, the user agent defaults to rendering the contents of a `<kbd>` element using its default monospace font, although this is not mandated by the HTML standard                                                                                                                                       |
| `<mark>`   | The `<mark>` HTML element represents text which is marked or highlighted for reference or notation purposes, due to the marked passage's relevance or importance in the enclosing context                                                                                                                                                                                                                                                                            |
| `<q>`      | The `<q> `HTML element indicates that the enclosed text is a short inline quotation. Most modern browsers implement this by surrounding the text in quotation marks. This element is intended for short quotations that don't require paragraph breaks; for long quotations use the blockquote element                                                                                                                                                               |
| `<rp>`     | The `<rp>` HTML element is used to provide fall-back parentheses for browsers that do not support display of ruby annotations using the ruby element. One `<rp>` element should enclose each of the opening and closing parentheses that wrap the rt element that contains the annotation's text                                                                                                                                                                     |
| `<rt>`     | The `<rt>` HTML element specifies the ruby text component of a ruby annotation, which is used to provide pronunciation, translation, or transliteration information for East Asian typography. The `<rt>` element must always be contained within a ruby element                                                                                                                                                                                                     |
| `<ruby>`   | The `<ruby>` HTML element represents small annotations that are rendered above, below, or next to base text, usually used for showing the pronunciation of East Asian characters. It can also be used for annotating other kinds of text, but this usage is less common                                                                                                                                                                                              |
| `<s>`      | The `<s> `HTML element renders text with a strikethrough, or a line through it. Use the `<s>` element to represent things that are no longer relevant or no longer accurate. However, `<s>` is not appropriate when indicating document edits; for that, use the del and ins elements, as appropriate                                                                                                                                                                |
| `<samp>`   | The `<samp>` HTML element is used to enclose inline text which represents sample (or quoted) output from a computer program. Its contents are typically rendered using the browser's default monospaced font (such as Courier or Lucida Console)                                                                                                                                                                                                                     |
| `<small>`  | The `<small>` HTML element represents side-comments and small print, like copyright and legal text, independent of its styled presentation. By default, it renders text within it one font-size smaller, such as from small to x-small                                                                                                                                                                                                                               |
| `<span>`   | The `<span>` HTML element is a generic inline container for phrasing content, which does not inherently represent anything. It can be used to group elements for styling purposes (using the class or id attributes), or because they share attribute values, such as lang. It should be used only when no other semantic element is appropriate. `<span>` is very much like a div element, but div is a block-level element whereas a `<span>` is an inline element |
| `<strong>` | The `<strong>` HTML element indicates that its contents have strong importance, seriousness, or urgency. Browsers typically render the contents in bold type                                                                                                                                                                                                                                                                                                         |
| `<sub>`    | The `<sub>` HTML element specifies inline text which should be displayed as subscript for solely typographical reasons. Subscripts are typically rendered with a lowered baseline using smaller text                                                                                                                                                                                                                                                                 |
| `<sup>`    | The `<sup>` HTML element specifies inline text which is to be displayed as superscript for solely typographical reasons. Superscripts are usually rendered with a raised baseline using smaller text                                                                                                                                                                                                                                                                 |
| `<time>`   | The `<time>` HTML element represents a specific period in time. It may include the datetime attribute to translate dates into machine-readable format, allowing for better search engine results or custom features such as reminders                                                                                                                                                                                                                                |
| `<u>`      | The `<u> `HTML element represents a span of inline text which should be rendered in a way that indicates that it has a non-textual annotation. This is rendered by default as a simple solid underline, but may be altered using CSS                                                                                                                                                                                                                                 |
| `<var>`    | The `<var>` HTML element represents the name of a variable in a mathematical expression or a programming context. It's typically presented using an italicized version of the current typeface, although that behavior is browser-dependent                                                                                                                                                                                                                          |
| `<wbr>`    | The `<wbr>` HTML element represents a word break opportunity—a position within text where the browser may optionally break a line, though its line-breaking rules would not otherwise create a break at that location                                                                                                                                                                                                                                                |

## Image and Multimedia

- HTML supports various multimedia resources such as images, audio, and video

| Element   | Description                                                                                                                                                                                                                                                                                        |
| --------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<area>`  | The `<area>` HTML element defines an area inside an image map that has predefined clickable areas. An image map allows geometric areas on an image to be associated with Hyperlink                                                                                                                 |
| `<audio>` | The `<audio>` HTML element is used to embed sound content in documents. It may contain one or more audio sources, represented using the src attribute or the source element: the browser will choose the most suitable one. It can also be the destination for streamed media, using a MediaStream |
| `<img>`   | The `<img>` HTML element embeds an image into the document                                                                                                                                                                                                                                         |
| `<map>`   | The `<map>` HTML element is used with area elements to define an image map (a clickable link area)                                                                                                                                                                                                 |
| `<track>` | The `<track>` HTML element is used as a child of the media elements, audio and video. It lets you specify timed text tracks (or time-based data), for example to automatically handle subtitles. The tracks are formatted in WebVTT format (.vtt files) — Web Video Text Tracks                    |
| `<video>` | The `<video>` HTML element embeds a media player which supports video playback into the document. You can use `<video>` for audio content as well, but the audio element may provide a more appropriate user experience                                                                            |

## Embedded Content

- In addition to regular multimedia content, HTML can include a variety of other content, even if it's not always easy to interact with

| Element     | Description                                                                                                                                                                                                                                                                                                                                                                                                                                |
| ----------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `<embed>`   | The `<embed>` HTML element embeds external content at the specified point in the document. This content is provided by an external application or other source of interactive content such as a browser plug-in                                                                                                                                                                                                                            |
| `<iframe>`  | The `<iframe>` HTML element represents a nested browsing context, embedding another HTML page into the current one                                                                                                                                                                                                                                                                                                                         |
| `<object>`  | The `<object>` HTML element represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin                                                                                                                                                                                                                                                                          |
| `<picture>` | The `<picture>` HTML element contains zero or more source elements and one img element to offer alternative versions of an image for different display/device scenarios                                                                                                                                                                                                                                                                    |
| `<portal>`  | The `<portal>` HTML element enables the embedding of another HTML page into the current one for the purposes of allowing smoother navigation into new pages                                                                                                                                                                                                                                                                                |
| `<source>`  | The `<source>` HTML element specifies multiple media resources for the picture, the audio element, or the video element. It is an empty element, meaning that it has no content and does not have a closing tag. It is commonly used to offer the same media content in multiple file formats in order to provide compatibility with a broad range of browsers given their differing support for image file formats and media file formats |

## SVG and MathML

You can embed SVG and MathML content directly into HTML documents, using the `<svg>` and `<math>` elements

| Element  | Description                                                                                                                                                                                                                                       |
| -------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<svg>`  | The svg element is a container that defines a new coordinate system and viewport. It is used as the outermost element of SVG documents, but it can also be used to embed an SVG fragment inside an SVG or HTML document                           |
| `<math>` | The top-level element in MathML is `<math>`. Every valid MathML instance must be wrapped in `<math>` tags. In addition you must not nest a second `<math>` element in another, but you can have an arbitrary number of other child elements in it |

## Scripting

- In order to create dynamic content and Web applications, HTML supports the use of scripting languages, most prominently JavaScript
- Certain elements support this capability

| Element      | Description                                                                                                                                                                                                                                                |
| ------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<canvas>`   | Use the HTML `<canvas>` element with either the canvas scripting API or the WebGL API to draw graphics and animations                                                                                                                                      |
| `<noscript>` | The `<noscript>` HTML element defines a section of HTML to be inserted if a script type on the page is unsupported or if scripting is currently turned off in the browser                                                                                  |
| `<script>`   | The `<script>` HTML element is used to embed executable code or data; this is typically used to embed or refer to JavaScript code. The `<script>` element can also be used with other languages, such as WebGL's GLSL shader programming language and JSON |

## Demarcating Edits

- These elements let you provide indications that specific parts of the text have been altered

| Element | Description                                                                                                                                                                                                                                                                                         |
| ------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<del>` | The `<del>` HTML element represents a range of text that has been deleted from a document. This can be used when rendering "track changes" or source code diff information, for example. The ins element can be used for the opposite purpose: to indicate text that has been added to the document |
| `<ins>` | The `<ins>` HTML element represents a range of text that has been added to a document. You can use the del element to similarly represent a range of text that has been deleted from the document                                                                                                   |

## Table Content

- The elements here are used to create and handle tabular data

| Element      | Description                                                                                                                                                             |
| ------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<caption>`  | The `<caption>` HTML element specifies the caption (or title) of a table                                                                                                |
| `<col>`      | The `<col>` HTML element defines a column within a table and is used for defining common semantics on all common cells. It is generally found within a colgroup element |
| `<colgroup>` | The `<colgroup>` HTML element defines a group of columns within a table                                                                                                 |
| `<table>`    | The `<table>` HTML element represents tabular data — that is, information presented in a two-dimensional table comprised of rows and columns of cells containing data   |
| `<tbody>`    | The `<tbody>` HTML element encapsulates a set of table rows (tr elements), indicating that they comprise the body of the table (table)                                  |
| `<td>`       | The `<td>` HTML element defines a cell of a table that contains data. It participates in the table model                                                                |
| `<tfoot>`    | The `<tfoot>` HTML element defines a set of rows summarizing the columns of the table                                                                                   |
| `<th>`       | The `<th>` HTML element defines a cell as header of a group of table cells. The exact nature of this group is defined by the scope and headers attributes               |
| `<thead>`    | The `<thead>` HTML element defines a set of rows defining the head of the columns of the table                                                                          |
| `<tr>`       | The `<tr>` HTML element defines a row of cells in a table. The row's cells can then be established using a mix of td (data cell) and th (header cell) elements          |

## Forms

- HTML provides a number of elements which can be used together to create forms which the user can fill out and submit to the Web site or application
- There's a great deal of further information about this available in the [HTML forms guide](https://developer.mozilla.org/en-US/docs/Learn/Forms)

| Element      | Description                                                                                                                                                                                                                                                                                                                                                                                      |
| ------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `<button>`   | The `<button>` HTML element is an interactive element activated by a user with a mouse, keyboard, finger, voice command, or other assistive technology. Once activated, it then performs a programmable action, such as submitting a form or opening a dialog                                                                                                                                    |
| `<datalist>` | The `<datalist>` HTML element contains a set of option elements that represent the permissible or recommended options available to choose from within other controls                                                                                                                                                                                                                             |
| `<fieldset>` | The `<fieldset>` HTML element is used to group several controls as well as labels (label) within a web form                                                                                                                                                                                                                                                                                      |
| `<form>`     | The `<form>` HTML element represents a document section containing interactive controls for submitting information                                                                                                                                                                                                                                                                               |
| `<input>`    | The `<input>` HTML element is used to create interactive controls for web-based forms in order to accept data from the user; a wide variety of types of input data and control widgets are available, depending on the device and user agent. The `<input>` element is one of the most powerful and complex in all of HTML due to the sheer number of combinations of input types and attributes |
| `<label>`    | The `<label>` HTML element represents a caption for an item in a user interface                                                                                                                                                                                                                                                                                                                  |
| `<legend>`   | The `<legend>` HTML element represents a caption for the content of its parent fieldset                                                                                                                                                                                                                                                                                                          |
| `<meter>`    | The `<meter>` HTML element represents either a scalar value within a known range or a fractional value                                                                                                                                                                                                                                                                                           |
| `<optgroup>` | The `<optgroup>` HTML element creates a grouping of options within a select element                                                                                                                                                                                                                                                                                                              |
| `<option>`   | The `<option>` HTML element is used to define an item contained in a select, an optgroup, or a datalist element. As such, `<option>` can represent menu items in popups and other lists of items in an HTML document                                                                                                                                                                             |
| `<output>`   | The `<output>` HTML element is a container element into which a site or app can inject the results of a calculation or the outcome of a user action                                                                                                                                                                                                                                              |
| `<progress>` | The `<progress>` HTML element displays an indicator showing the completion progress of a task, typically displayed as a progress bar                                                                                                                                                                                                                                                             |
| `<select>`   | The `<select>` HTML element represents a control that provides a menu of options                                                                                                                                                                                                                                                                                                                 |
| `<textarea>` | The `<textarea>` HTML element represents a multi-line plain-text editing control, useful when you want to allow users to enter a sizeable amount of free-form text, for example a comment on a review or feedback form                                                                                                                                                                           |

## Interactive Elements

- HTML offers a selection of elements which help to create interactive user interface objects

| Element     | Description                                                                                                                                                                                                       |
| ----------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<details>` | The `<details>` HTML element creates a disclosure widget in which information is visible only when the widget is toggled into an "open" state. A summary or label must be provided using the summary element      |
| `<dialog>`  | The `<dialog>` HTML element represents a dialog box or other interactive component, such as a dismissible alert, inspector, or subwindow                                                                          |
| `<summary>` | The `<summary>` HTML element specifies a summary, caption, or legend for a details element's disclosure box. Clicking the `<summary>` element toggles the state of the parent `<details>` element open and closed |

## Web Components

- Web Components is an HTML-related technology which makes it possible to, essentially, create and use custom elements as if it were regular HTML
- In addition, you can create custom versions of standard HTML elements

| Element      | Description                                                                                                                                                                                                              |
| ------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `<slot>`     | The `<slot>` HTML element—part of the Web Components technology suite—is a placeholder inside a web component that you can fill with your own markup, which lets you create separate DOM trees and present them together |
| `<template>` | The `<template>` HTML element is a mechanism for holding HTML that is not to be rendered immediately when a page is loaded but may be instantiated subsequently during runtime using JavaScript                          |

## Obsolete and Deprecated elements

- Warning: These are old HTML elements which are deprecated and should not be used
- You should never use them in new projects, and you should replace them in old projects as soon as you can

| Element       | Description                                                                                                                                                                                                                                                                                                                                                                                                                               |
| ------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `<acronym>`   | The `<acronym>` HTML element allows authors to clearly indicate a sequence of characters that compose an acronym or abbreviation for a word                                                                                                                                                                                                                                                                                               |
| `<applet>`    | The obsolete HTML Applet Element (`<applet>`) embeds a Java applet into the document; this element has been deprecated in favor of object                                                                                                                                                                                                                                                                                                 |
| `<basefont>`  | The `<basefont>` HTML element is deprecated. It sets a default font face, size, and color for the other elements which are descended from its parent element. With this set, the font's size can then be varied relative to the base size using the font element                                                                                                                                                                          |
| `<bgsound>`   | The `<bgsound>` HTML element is deprecated. It sets up a sound file to play in the background while the page is used; use audio instead                                                                                                                                                                                                                                                                                                   |
| `<big>`       | The `<big>` HTML deprecated element renders the enclosed text at a font size one level larger than the surrounding text (medium becomes large, for example). The size is capped at the browser's maximum permitted font size                                                                                                                                                                                                              |
| `<blink>`     | The `<blink>` HTML element is a non-standard element which causes the enclosed text to flash slowly                                                                                                                                                                                                                                                                                                                                       |
| `<center>`    | The `<center>` HTML element is a block-level element that displays its block-level or inline contents centered horizontally within its containing element. The container is usually, but isn't required to be, body                                                                                                                                                                                                                       |
| `<content>`   | The `<content>` HTML element—an obsolete part of the Web Components suite of technologies—was used inside of Shadow DOM as an insertion point, and wasn't meant to be used in ordinary HTML. It has now been replaced by the slot element, which creates a point in the DOM at which a shadow DOM can be inserted                                                                                                                         |
| `<dir>`       | The `<dir>` HTML element is used as a container for a directory of files and/or folders, potentially with styles and icons applied by the user agent. Do not use this obsolete element; instead, you should use the ul element for lists, including lists of files                                                                                                                                                                        |
| `<font>`      | The `<font>` HTML element defines the font size, color and face for its content                                                                                                                                                                                                                                                                                                                                                           |
| `<frame>`     | The `<frame>` HTML element defines a particular area in which another HTML document can be displayed. A frame should be used within a frameset                                                                                                                                                                                                                                                                                            |
| `<frameset>`  | The `<frameset>` HTML element is used to contain frame elements                                                                                                                                                                                                                                                                                                                                                                           |
| `<hgroup>`    | The `<hgroup>` HTML element represents a multi-level heading for a section of a document. It groups a set of `<h1>`-`<h6>` elements                                                                                                                                                                                                                                                                                                       |
| `<image>`     | The `<image>` HTML element is an ancient and poorly supported precursor to the img element. It should not be used                                                                                                                                                                                                                                                                                                                         |
| `<keygen>`    | The `<keygen>` HTML element exists to facilitate generation of key material, and submission of the public key as part of an HTML form. This mechanism is designed for use with Web-based certificate management systems. It is expected that the `<keygen>` element will be used in an HTML form along with other information needed to construct a certificate request, and that the result of the process will be a signed certificate  |
| `<marquee>`   | The `<marquee>` HTML element is used to insert a scrolling area of text. You can control what happens when the text reaches the edges of its content area using its attributes                                                                                                                                                                                                                                                            |
| `<menuitem>`  | The `<menuitem>` HTML element represents a command that a user is able to invoke through a popup menu. This includes context menus, as well as menus that might be attached to a menu button                                                                                                                                                                                                                                              |
| `<nobr>`      | The `<nobr>` HTML element prevents the text it contains from automatically wrapping across multiple lines, potentially resulting in the user having to scroll horizontally to see the entire width of the text                                                                                                                                                                                                                            |
| `<noembed>`   | The `<noembed>` HTML element is an obsolete, non-standard way to provide alternative, or "fallback", content for browsers that do not support the embed element or do not support the type of embedded content an author wishes to use. This element was deprecated in HTML 4.01 and above in favor of placing fallback content between the opening and closing tags of an object element                                                 |
| `<noframes>`  | The `<noframes>` HTML element provides content to be presented in browsers that don't support (or have disabled support for) the frame element. Although most commonly-used browsers support frames, there are exceptions, including certain special-use browsers including some mobile browsers, as well as text-mode browsers                                                                                                           |
| `<param>`     | The `<param>` HTML element defines parameters for an object element                                                                                                                                                                                                                                                                                                                                                                       |
| `<plaintext>` | The `<plaintext>` HTML element renders everything following the start tag as raw text, ignoring any following HTML. There is no closing tag, since everything after it is considered raw text                                                                                                                                                                                                                                             |
| `<rb>`        | The `<rb>` HTML element is used to delimit the base text component of a ruby annotation, i.e. the text that is being annotated. One `<rb>` element should wrap each separate atomic segment of the base text                                                                                                                                                                                                                              |
| `<rtc>`       | The `<rtc>` HTML element embraces semantic annotations of characters presented in a ruby of rb elements used inside of ruby element. rb elements can have both pronunciation (rt) and semantic (rtc) annotations                                                                                                                                                                                                                          |
| `<shadow>`    | The `<shadow>` HTML element—an obsolete part of the Web Components technology suite—was intended to be used as a shadow DOM insertion point. You might have used it if you have created multiple shadow roots under a shadow host. It is not useful in ordinary HTML                                                                                                                                                                      |
| `<spacer>`    | The `<spacer>` HTML element is an obsolete HTML element which allowed insertion of empty spaces on pages. It was devised by Netscape to accomplish the same effect as a single-pixel layout image, which was something web designers used to use to add white spaces to web pages without actually using an image. However, `<spacer>` no longer supported by any major browser and the same effects can now be achieved using simple CSS |
| `<strike>`    | The `<strike>` HTML element places a strikethrough (horizontal line) over text                                                                                                                                                                                                                                                                                                                                                            |
| `<tt>`        | The `<tt>` HTML element creates inline text which is presented using the user agent default monospace font face. This element was created for the purpose of rendering text as it would be displayed on a fixed-width display such as a teletype, text-only screen, or line printer                                                                                                                                                       |
| `<xmp>`       | The `<xmp>` HTML element renders text between the start and end tags without interpreting the HTML in between and using a monospaced font. The HTML2 specification recommended that it should be rendered wide enough to allow 80 characters per line                                                                                                                                                                                     |

# HTML Attributes

- The table below lists all HTML attributes and what elements they can be used within
- [Read more](https://www.w3schools.com/tags/ref_attributes.asp)

| Attribute          | Belongs to                                                                                                          | Description                                                                                                                      |
| ------------------ | ------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| `accept`           | `<input>`                                                                                                           | Specifies the types of files that the server accepts (only for type="file")                                                      |
| `accept-charset`   | `<form>`                                                                                                            | Specifies the character encodings that are to be used for the form submission                                                    |
| `accesskey`        | Global Attributes                                                                                                   | Specifies a shortcut key to activate/focus an element                                                                            |
| `action`           | `<form>`                                                                                                            | Specifies where to send the form-data when a form is submitted                                                                   |
| `alt`              | `<area>, <img>, <input>`                                                                                            | Specifies an alternate text when the original element fails to display                                                           |
| `async`            | `<script>`                                                                                                          | Specifies that the script is executed asynchronously (only for external scripts)                                                 |
| `autocomplete`     | `<form>, <input>`                                                                                                   | Specifies whether the `<form>` or the `<input>` element should have autocomplete enabled                                         |
| `autofocus`        | `<button>, <input>, <select>, <textarea>`                                                                           | Specifies that the element should automatically get focus when the page loads                                                    |
| `autoplay`         | `<audio>, <video>`                                                                                                  | Specifies that the audio/video will start playing as soon as it is ready                                                         |
| `charset`          | `<meta>, <script>`                                                                                                  | Specifies the character encoding                                                                                                 |
| `checked`          | `<input>`                                                                                                           | Specifies that an `<input>` element should be pre-selected when the page loads (for type="checkbox" or type="radio")             |
| `cite`             | `<blockquote>, <del>, <ins>, <q>`                                                                                   | Specifies a URL which explains the quote/deleted/inserted text                                                                   |
| `class`            | Global Attributes                                                                                                   | Specifies one or more classnames for an element (refers to a class in a style sheet)                                             |
| `cols`             | `<textarea>`                                                                                                        | Specifies the visible width of a text area                                                                                       |
| `colspan`          | `<td>, <th>`                                                                                                        | Specifies the number of columns a table cell should span                                                                         |
| `content`          | `<meta>`                                                                                                            | Gives the value associated with the http-equiv or name attribute                                                                 |
| `contenteditable`  | Global Attributes                                                                                                   | Specifies whether the content of an element is editable or not                                                                   |
| `controls`         | `<audio>, <video>`                                                                                                  | Specifies that audio/video controls should be displayed (such as a play/pause button etc)                                        |
| `coords`           | `<area>`                                                                                                            | Specifies the coordinates of the area                                                                                            |
| `data`             | `<object>`                                                                                                          | Specifies the URL of the resource to be used by the object                                                                       |
| `data-*`           | Global Attributes                                                                                                   | Used to store custom data private to the page or application                                                                     |
| `datetime`         | `<del>, <ins>, <time>`                                                                                              | Specifies the date and time                                                                                                      |
| `default`          | `<track>`                                                                                                           | Specifies that the track is to be enabled if the user's preferences do not indicate that another track would be more appropriate |
| `defer`            | `<script>`                                                                                                          | Specifies that the script is executed when the page has finished parsing (only for external scripts)                             |
| `dir`              | Global Attributes                                                                                                   | Specifies the text direction for the content in an element                                                                       |
| `dirname`          | `<input>, <textarea>`                                                                                               | Specifies that the text direction will be submitted                                                                              |
| `disabled`         | `<button>, <fieldset>, <input>, <optgroup>, <option>, <select>, <textarea>`                                         | Specifies that the specified element/group of elements should be disabled                                                        |
| `download`         | `<a>, <area>`                                                                                                       | Specifies that the target will be downloaded when a user clicks on the hyperlink                                                 |
| `draggable`        | Global Attributes                                                                                                   | Specifies whether an element is draggable or not                                                                                 |
| `enctype`          | `<form>`                                                                                                            | Specifies how the form-data should be encoded when submitting it to the server (only for method="post")                          |
| `for`              | `<label>, <output>`                                                                                                 | Specifies which form element(s) a label/calculation is bound to                                                                  |
| `form`             | `<button>, <fieldset>, <input>, <label>, <meter>, <object>, <output>, <select>, <textarea>`                         | Specifies the name of the form the element belongs to                                                                            |
| `formaction`       | `<button>, <input>`                                                                                                 | Specifies where to send the form-data when a form is submitted. Only for type="submit"                                           |
| `headers`          | `<td>, <th>`                                                                                                        | Specifies one or more headers cells a cell is related to                                                                         |
| `height`           | `<canvas>, <embed>, <iframe>, <img>, <input>, <object>, <video>`                                                    | Specifies the height of the element                                                                                              |
| `hidden`           | Global Attributes                                                                                                   | Specifies that an element is not yet, or is no longer, relevant                                                                  |
| `high`             | `<meter>`                                                                                                           | Specifies the range that is considered to be a high value                                                                        |
| `href`             | `<a>, <area>, <base>, <link>`                                                                                       | Specifies the URL of the page the link goes to                                                                                   |
| `hreflang`         | `<a>, <area>, <link>`                                                                                               | Specifies the language of the linked document                                                                                    |
| `http-equiv`       | `<meta>`                                                                                                            | Provides an HTTP header for the information/value of the content attribute                                                       |
| `id`               | Global Attributes                                                                                                   | Specifies a unique id for an element                                                                                             |
| `ismap`            | `<img>`                                                                                                             | Specifies an image as a server-side image map                                                                                    |
| `kind`             | `<track>`                                                                                                           | Specifies the kind of text track                                                                                                 |
| `label`            | `<track>, <option>, <optgroup>`                                                                                     | Specifies the title of the text track                                                                                            |
| `lang`             | Global Attributes                                                                                                   | Specifies the language of the element's content                                                                                  |
| `list`             | `<input>`                                                                                                           | Refers to a `<datalist>` element that contains pre-defined options for an `<input>` element                                      |
| `loop`             | `<audio>, <video>`                                                                                                  | Specifies that the audio/video will start over again, every time it is finished                                                  |
| `low`              | `<meter>`                                                                                                           | Specifies the range that is considered to be a low value                                                                         |
| `max`              | `<input>, <meter>, <progress>`                                                                                      | Specifies the maximum value                                                                                                      |
| `maxlength`        | `<input>, <textarea>`                                                                                               | Specifies the maximum number of characters allowed in an element                                                                 |
| `media`            | `<a>, <area>, <link>, <source>, <style>`                                                                            | Specifies what media/device the linked document is optimized for                                                                 |
| `method`           | `<form>`                                                                                                            | Specifies the HTTP method to use when sending form-data                                                                          |
| `min`              | `<input>, <meter>`                                                                                                  | Specifies a minimum value                                                                                                        |
| `multiple`         | `<input>, <select>`                                                                                                 | Specifies that a user can enter more than one value                                                                              |
| `muted`            | `<video>, <audio>`                                                                                                  | Specifies that the audio output of the video should be muted                                                                     |
| `name`             | `<button>, <fieldset>, <form>, <iframe>, <input>, <map>, <meta>, <object>, <output>, <param>, <select>, <textarea>` | Specifies the name of the element                                                                                                |
| `novalidate`       | `<form>`                                                                                                            | Specifies that the form should not be validated when submitted                                                                   |
| `onabort`          | `<audio>, <embed>, <img>, <object>, <video>`                                                                        | Script to be run on abort                                                                                                        |
| `onafterprint`     | `<body>`                                                                                                            | Script to be run after the document is printed                                                                                   |
| `onbeforeprint`    | `<body>`                                                                                                            | Script to be run before the document is printed                                                                                  |
| `onbeforeunload`   | `<body>`                                                                                                            | Script to be run when the document is about to be unloaded                                                                       |
| `onblur`           | All visible elements                                                                                                | Script to be run when the element loses focus                                                                                    |
| `oncanplay`        | `<audio>, <embed>, <object>, <video>`                                                                               | Script to be run when a file is ready to start playing (when it has buffered enough to begin)                                    |
| `oncanplaythrough` | `<audio>, <video>`                                                                                                  | Script to be run when a file can be played all the way to the end without pausing for buffering                                  |
| `onchange`         | All visible elements                                                                                                | Script to be run when the value of the element is changed                                                                        |
| `onclick`          | All visible elements                                                                                                | Script to be run when the element is being clicked                                                                               |
| `oncontextmenu`    | All visible elements                                                                                                | Script to be run when a context menu is triggered                                                                                |
| `oncopy`           | All visible elements                                                                                                | Script to be run when the content of the element is being copied                                                                 |
| `oncuechange`      | `<track>`                                                                                                           | Script to be run when the cue changes in a `<track>` element                                                                     |
| `oncut`            | All visible elements                                                                                                | Script to be run when the content of the element is being cut                                                                    |
| `ondblclick`       | All visible elements                                                                                                | Script to be run when the element is being double-clicked                                                                        |
| `ondrag`           | All visible elements                                                                                                | Script to be run when the element is being dragged                                                                               |
| `ondragend`        | All visible elements                                                                                                | Script to be run at the end of a drag operation                                                                                  |
| `ondragenter`      | All visible elements                                                                                                | Script to be run when an element has been dragged to a valid drop target                                                         |
| `ondragleave`      | All visible elements                                                                                                | Script to be run when an element leaves a valid drop target                                                                      |
| `ondragover`       | All visible elements                                                                                                | Script to be run when an element is being dragged over a valid drop target                                                       |
| `ondragstart`      | All visible elements                                                                                                | Script to be run at the start of a drag operation                                                                                |
| `ondrop`           | All visible elements                                                                                                | Script to be run when dragged element is being dropped                                                                           |
| `ondurationchange` | `<audio>, <video>`                                                                                                  | Script to be run when the length of the media changes                                                                            |
| `onemptied`        | `<audio>, <video>`                                                                                                  | Script to be run when something bad happens and the file is suddenly unavailable (like unexpectedly disconnects)                 |
| `onended`          | `<audio>, <video>`                                                                                                  | Script to be run when the media has reach the end (a useful event for messages like "thanks for listening")                      |
| `onerror`          | `<audio>, <body>, <embed>, <img>, <object>, <script>, <style>, <video>`                                             | Script to be run when an error occurs                                                                                            |
| `onfocus`          | All visible elements                                                                                                | Script to be run when the element gets focus                                                                                     |
| `onhashchange`     | `<body>`                                                                                                            | Script to be run when there has been changes to the anchor part of the a URL                                                     |
| `oninput`          | All visible elements                                                                                                | Script to be run when the element gets user input                                                                                |
| `oninvalid`        | All visible elements                                                                                                | Script to be run when the element is invalid                                                                                     |
| `onkeydown`        | All visible elements                                                                                                | Script to be run when a user is pressing a key                                                                                   |
| `onkeypress`       | All visible elements                                                                                                | Script to be run when a user presses a key                                                                                       |
| `onkeyup`          | All visible elements                                                                                                | Script to be run when a user releases a key                                                                                      |
| `onload`           | `<body>, <iframe>, <img>, <input>, <link>, <script>, <style>`                                                       | Script to be run when the element is finished loading                                                                            |
| `onloadeddata`     | `<audio>, <video>`                                                                                                  | Script to be run when media data is loaded                                                                                       |
| `onloadedmetadata` | `<audio>, <video>`                                                                                                  | Script to be run when meta data (like dimensions and duration) are loaded                                                        |
| `onloadstart`      | `<audio>, <video>`                                                                                                  | Script to be run just as the file begins to load before anything is actually loaded                                              |
| `onmousedown`      | All visible elements                                                                                                | Script to be run when a mouse button is pressed down on an element                                                               |
| `onmousemove`      | All visible elements                                                                                                | Script to be run as long as the mouse pointer is moving over an element                                                          |
| `onmouseout`       | All visible elements                                                                                                | Script to be run when a mouse pointer moves out of an element                                                                    |
| `onmouseover`      | All visible elements                                                                                                | Script to be run when a mouse pointer moves over an element                                                                      |
| `onmouseup`        | All visible elements                                                                                                | Script to be run when a mouse button is released over an element                                                                 |
| `onmousewheel`     | All visible elements                                                                                                | Script to be run when a mouse wheel is being scrolled over an element                                                            |
| `onoffline`        | `<body>`                                                                                                            | Script to be run when the browser starts to work offline                                                                         |
| `ononline`         | `<body>`                                                                                                            | Script to be run when the browser starts to work online                                                                          |
| `onpagehide`       | `<body>`                                                                                                            | Script to be run when a user navigates away from a page                                                                          |
| `onpageshow`       | `<body>`                                                                                                            | Script to be run when a user navigates to a page                                                                                 |
| `onpaste`          | All visible elements                                                                                                | Script to be run when the user pastes some content in an element                                                                 |
| `onpause`          | `<audio>, <video>`                                                                                                  | Script to be run when the media is paused either by the user or programmatically                                                 |
| `onplay`           | `<audio>, <video>`                                                                                                  | Script to be run when the media has started playing                                                                              |
| `onplaying`        | `<audio>, <video>`                                                                                                  | Script to be run when the media has started playing                                                                              |
| `onpopstate`       | `<body>`                                                                                                            | Script to be run when the window's history changes.                                                                              |
| `onprogress`       | `<audio>, <video>`                                                                                                  | Script to be run when the browser is in the process of getting the media data                                                    |
| `onratechange`     | `<audio>, <video>`                                                                                                  | Script to be run each time the playback rate changes (like when a user switches to a slow motion or fast forward mode).          |
| `onreset`          | `<form>`                                                                                                            | Script to be run when a reset button in a form is clicked.                                                                       |
| `onresize`         | `<body>`                                                                                                            | Script to be run when the browser window is being resized.                                                                       |
| `onscroll`         | All visible elements                                                                                                | Script to be run when an element's scrollbar is being scrolled                                                                   |
| `onsearch`         | `<input>`                                                                                                           | Script to be run when the user writes something in a search field (for `<input="search">`)                                       |
| `onseeked`         | `<audio>, <video>`                                                                                                  | Script to be run when the seeking attribute is set to false indicating that seeking has ended                                    |
| `onseeking`        | `<audio>, <video>`                                                                                                  | Script to be run when the seeking attribute is set to true indicating that seeking is active                                     |
| `onselect`         | All visible elements                                                                                                | Script to be run when the element gets selected                                                                                  |
| `onstalled`        | `<audio>, <video>`                                                                                                  | Script to be run when the browser is unable to fetch the media data for whatever reason                                          |
| `onstorage`        | `<body>`                                                                                                            | Script to be run when a Web Storage area is updated                                                                              |
| `onsubmit`         | `<form>`                                                                                                            | Script to be run when a form is submitted                                                                                        |
| `onsuspend`        | `<audio>, <video>`                                                                                                  | Script to be run when fetching the media data is stopped before it is completely loaded for whatever reason                      |
| `ontimeupdate`     | `<audio>, <video>`                                                                                                  | Script to be run when the playing position has changed (like when the user fast forwards to a different point in the media)      |
| `ontoggle`         | `<details>`                                                                                                         | Script to be run when the user opens or closes the `<details>` element                                                           |
| `onunload`         | `<body>`                                                                                                            | Script to be run when a page has unloaded (or the browser window has been closed)                                                |
| `onvolumechange`   | `<audio>, <video>`                                                                                                  | Script to be run each time the volume of a video/audio has been changed                                                          |
| `onwaiting`        | `<audio>, <video>`                                                                                                  | Script to be run when the media has paused but is expected to resume (like when the media pauses to buffer more data)            |
| `onwheel`          | All visible elements                                                                                                | Script to be run when the mouse wheel rolls up or down over an element                                                           |
| `open`             | `<details>`                                                                                                         | Specifies that the details should be visible (open) to the user                                                                  |
| `optimum`          | `<meter>`                                                                                                           | Specifies what value is the optimal value for the gauge                                                                          |
| `pattern`          | `<input>`                                                                                                           | Specifies a regular expression that an `<input>` element's value is checked against                                              |
| `placeholder`      | `<input>, <textarea>`                                                                                               | Specifies a short hint that describes the expected value of the element                                                          |
| `poster`           | `<video>`                                                                                                           | Specifies an image to be shown while the video is downloading, or until the user hits the play button                            |
| `preload`          | `<audio>, <video>`                                                                                                  | Specifies if and how the author thinks the audio/video should be loaded when the page loads                                      |
| `readonly`         | `<input>, <textarea>`                                                                                               | Specifies that the element is read-only                                                                                          |
| `rel`              | `<a>, <area>, <form>, <link>`                                                                                       | Specifies the relationship between the current document and the linked document                                                  |
| `required`         | `<input>, <select>, <textarea>`                                                                                     | Specifies that the element must be filled out before submitting the form                                                         |
| `reversed`         | `<ol>`                                                                                                              | Specifies that the list order should be descending (9,8,7...)                                                                    |
| `rows`             | `<textarea>`                                                                                                        | Specifies the visible number of lines in a text area                                                                             |
| `rowspan`          | `<td>, <th>`                                                                                                        | Specifies the number of rows a table cell should span                                                                            |
| `sandbox`          | `<iframe>`                                                                                                          | Enables an extra set of restrictions for the content in an `<iframe>`                                                            |
| `scope`            | `<th>`                                                                                                              | Specifies whether a header cell is a header for a column, row, or group of columns or rows                                       |
| `selected`         | `<option>`                                                                                                          | Specifies that an option should be pre-selected when the page loads                                                              |
| `shape`            | `<area>`                                                                                                            | Specifies the shape of the area                                                                                                  |
| `size`             | `<input>, <select>`                                                                                                 | Specifies the width, in characters (for `<input>`) or specifies the number of visible options (for `<select>`)                   |
| `sizes`            | `<img>, <link>, <source>`                                                                                           | Specifies the size of the linked resource                                                                                        |
| `span`             | `<col>, <colgroup>`                                                                                                 | Specifies the number of columns to span                                                                                          |
| `spellcheck`       | Global Attributes                                                                                                   | Specifies whether the element is to have its spelling and grammar checked or not                                                 |
| `src`              | `<audio>, <embed>, <iframe>, <img>, <input>, <script>, <source>, <track>, <video>`                                  | Specifies the URL of the media file                                                                                              |
| `srcdoc`           | `<iframe>`                                                                                                          | Specifies the HTML content of the page to show in the `<iframe>`                                                                 |
| `srclang`          | `<track>`                                                                                                           | Specifies the language of the track text data (required if kind="subtitles")                                                     |
| `srcset`           | `<img>, <source>`                                                                                                   | Specifies the URL of the image to use in different situations                                                                    |
| `start`            | `<ol>`                                                                                                              | Specifies the start value of an ordered list                                                                                     |
| `step`             | `<input>`                                                                                                           | Specifies the legal number intervals for an input field                                                                          |
| `style`            | Global Attributes                                                                                                   | Specifies an inline CSS style for an element                                                                                     |
| `tabindex`         | Global Attributes                                                                                                   | Specifies the tabbing order of an element                                                                                        |
| `target`           | `<a>, <area>, <base>, <form>`                                                                                       | Specifies the target for where to open the linked document or where to submit the form                                           |
| `title`            | Global Attributes                                                                                                   | Specifies extra information about an element                                                                                     |
| `translate`        | Global Attributes                                                                                                   | Specifies whether the content of an element should be translated or not                                                          |
| `type`             | `<a>, <button>, <embed>, <input>, <link>, <menu>, <object>, <script>, <source>, <style>`                            | Specifies the type of element                                                                                                    |
| `usemap`           | `<img>, <object>`                                                                                                   | Specifies an image as a client-side image map                                                                                    |
| `value`            | `<button>, <input>, <li>, <option>, <meter>, <progress>, <param>`                                                   | Specifies the value of the element                                                                                               |
| `width`            | `<canvas>, <embed>, <iframe>, <img>, <input>, <object>, <video>`                                                    | Specifies the width of the element                                                                                               |
| `wrap`             | `<textarea>`                                                                                                        | Specifies how the text in a text area is to be wrapped when submitted in a form                                                  |

# HTML Global Attributes

- The global attributes are attributes that can be used with all HTML elements
- [Read more](https://www.w3schools.com/tags/ref_standardattributes.asp)

| Attribute         | Description                                                                          |
| ----------------- | ------------------------------------------------------------------------------------ |
| `accesskey`       | Specifies a shortcut key to activate/focus an element                                |
| `class`           | Specifies one or more classnames for an element (refers to a class in a style sheet) |
| `contenteditable` | Specifies whether the content of an element is editable or not                       |
| `data-*`          | Used to store custom data private to the page or application                         |
| `dir`             | Specifies the text direction for the content in an element                           |
| `draggable`       | Specifies whether an element is draggable or not                                     |
| `hidden`          | Specifies that an element is not yet, or is no longer, relevant                      |
| `id`              | Specifies a unique id for an element                                                 |
| `lang`            | Specifies the language of the element's content                                      |
| `spellcheck`      | Specifies whether the element is to have its spelling and grammar checked or not     |
| `style`           | Specifies an inline CSS style for an element                                         |
| `tabindex`        | Specifies the tabbing order of an element                                            |
| `title`           | Specifies extra information about an element                                         |
| `translate`       | Specifies whether the content of an element should be translated or not              |

# HTML Event Attributes

- HTML has the ability to let events trigger actions in a browser, like starting a JavaScript 'script' when a user clicks on an element
- Below are the global event attributes that can be added to HTML elements to define event actions
- Note this is different to `HTML DOM Events`
- [Read more](https://www.w3schools.com/tags/ref_eventattributes.asp)

## Clipboard Events

| Attribute | Value  | Description                                           |
| --------- | ------ | ----------------------------------------------------- |
| `oncopy`  | script | Fires when the user copies the content of an element  |
| `oncut`   | script | Fires when the user cuts the content of an element    |
| `onpaste` | script | Fires when the user pastes some content in an element |

## Drag Events

| Attribute     | Value  | Description                                                                |
| ------------- | ------ | -------------------------------------------------------------------------- |
| `ondrag`      | script | Script to be run when an element is dragged                                |
| `ondragend`   | script | Script to be run at the end of a drag operation                            |
| `ondragenter` | script | Script to be run when an element has been dragged to a valid drop target   |
| `ondragleave` | script | Script to be run when an element leaves a valid drop target                |
| `ondragover`  | script | Script to be run when an element is being dragged over a valid drop target |
| `ondragstart` | script | Script to be run at the start of a drag operation                          |
| `ondrop`      | script | Script to be run when dragged element is being dropped                     |
| `onscroll`    | script | Script to be run when an element's scrollbar is being scrolled             |

## Form Events

- Events triggered by actions inside a HTML form (applies to almost all HTML elements, but is most used in form elements)

| Attribute       | Value  | Description                                                                     |
| --------------- | ------ | ------------------------------------------------------------------------------- |
| `onblur`        | script | Fires the moment that the element loses focus                                   |
| `onchange`      | script | Fires the moment when the value of the element is changed                       |
| `oncontextmenu` | script | Script to be run when a context menu is triggered                               |
| `onfocus`       | script | Fires the moment when the element gets focus                                    |
| `oninput`       | script | Script to be run when an element gets user input                                |
| `oninvalid`     | script | Script to be run when an element is invalid                                     |
| `onreset`       | script | Fires when the Reset button in a form is clicked                                |
| `onsearch`      | script | Fires when the user writes something in a search field (for `<input="search">`) |
| `onselect`      | script | Fires after some text has been selected in an element                           |
| `onsubmit`      | script | Fires when a form is submitted                                                  |

## Keyboard Events

| Attribute    | Value  | Description                         |
| ------------ | ------ | ----------------------------------- |
| `onkeydown`  | script | Fires when a user is pressing a key |
| `onkeypress` | script | Fires when a user presses a key     |
| `onkeyup`    | script | Fires when a user releases a key    |

## Media Events

- Events triggered by medias like videos, images and audio (applies to all HTML elements, but is most common in media elements, like `<audio>`, `<embed>`, `<img>`, `<object>`, and `<video>`)

| Attribute          | Value  | Description                                                                                                                 |
| ------------------ | ------ | --------------------------------------------------------------------------------------------------------------------------- |
| `onabort`          | script | Script to be run on abort                                                                                                   |
| `oncanplay`        | script | Script to be run when a file is ready to start playing (when it has buffered enough to begin)                               |
| `oncanplaythrough` | script | Script to be run when a file can be played all the way to the end without pausing for buffering                             |
| `oncuechange`      | script | Script to be run when the cue changes in a `<track>` element                                                                |
| `ondurationchange` | script | Script to be run when the length of the media changes                                                                       |
| `onemptied`        | script | Script to be run when something bad happens and the file is suddenly unavailable (like unexpectedly disconnects)            |
| `onended`          | script | Script to be run when the media has reach the end (a useful event for messages like "thanks for listening")                 |
| `onerror`          | script | Script to be run when an error occurs when the file is being loaded                                                         |
| `onloadeddata`     | script | Script to be run when media data is loaded                                                                                  |
| `onloadedmetadata` | script | Script to be run when meta data (like dimensions and duration) are loaded                                                   |
| `onloadstart`      | script | Script to be run just as the file begins to load before anything is actually loaded                                         |
| `onpause`          | script | Script to be run when the media is paused either by the user or programmatically                                            |
| `onplay`           | script | Script to be run when the media is ready to start playing                                                                   |
| `onplaying`        | script | Script to be run when the media actually has started playing                                                                |
| `onprogress`       | script | Script to be run when the browser is in the process of getting the media data                                               |
| `onratechange`     | script | Script to be run each time the playback rate changes (like when a user switches to a slow motion or fast forward mode)      |
| `onseeked`         | script | Script to be run when the seeking attribute is set to false indicating that seeking has ended                               |
| `onseeking`        | script | Script to be run when the seeking attribute is set to true indicating that seeking is active                                |
| `onstalled`        | script | Script to be run when the browser is unable to fetch the media data for whatever reason                                     |
| `onsuspend`        | script | Script to be run when fetching the media data is stopped before it is completely loaded for whatever reason                 |
| `ontimeupdate`     | script | Script to be run when the playing position has changed (like when the user fast forwards to a different point in the media) |
| `onvolumechange`   | script | Script to be run each time the volume is changed which (includes setting the volume to "mute")                              |
| `onwaiting`        | script | Script to be run when the media has paused but is expected to resume (like when the media pauses to buffer more data)       |

## Misc Events

| Attribute  | Value  | Description                                                 |
| ---------- | ------ | ----------------------------------------------------------- |
| `ontoggle` | script | Fires when the user opens or closes the `<details>` element |

## Mouse Events

| Attribute      | Value  | Description                                                        |
| -------------- | ------ | ------------------------------------------------------------------ |
| `onclick`      | script | Fires on a mouse click on the element                              |
| `ondblclick`   | script | Fires on a mouse double-click on the element                       |
| `onmousedown`  | script | Fires when a mouse button is pressed down on an element            |
| `onmousemove`  | script | Fires when the mouse pointer is moving while it is over an element |
| `onmouseout`   | script | Fires when the mouse pointer moves out of an element               |
| `onmouseover`  | script | Fires when the mouse pointer moves over an element                 |
| `onmouseup`    | script | Fires when a mouse button is released over an element              |
| `onmousewheel` | script | Deprecated. Use the onwheel attribute instead                      |
| `onwheel`      | script | Fires when the mouse wheel rolls up or down over an element        |

## Window Event Attributes

- Events triggered for the window object (applies to the `<body>` tag)

| Attribute        | Value  | Description                                                                  |
| ---------------- | ------ | ---------------------------------------------------------------------------- |
| `onafterprint`   | script | Script to be run after the document is printed                               |
| `onbeforeprint`  | script | Script to be run before the document is printed                              |
| `onbeforeunload` | script | Script to be run when the document is about to be unloaded                   |
| `onerror`        | script | Script to be run when an error occurs                                        |
| `onhashchange`   | script | Script to be run when there has been changes to the anchor part of the a URL |
| `onload`         | script | Fires after the page is finished loading                                     |
| `onmessage`      | script | Script to be run when the message is triggered                               |
| `onoffline`      | script | Script to be run when the browser starts to work offline                     |
| `ononline`       | script | Script to be run when the browser starts to work online                      |
| `onpagehide`     | script | Script to be run when a user navigates away from a page                      |
| `onpageshow`     | script | Script to be run when a user navigates to a page                             |
| `onpopstate`     | script | Script to be run when the window's history changes                           |
| `onresize`       | script | Fires when the browser window is resized                                     |
| `onstorage`      | script | Script to be run when a Web Storage area is updated                          |
| `onunload`       | script | Fires once a page has unloaded (or the browser window has been closed)       |

# HTML Colors

- [Read more](https://www.w3schools.com/tags/ref_colornames.asp)
- [Read more](https://www.htmlcsscolor.com/html-color-names)

| ColorName            | Hex Code |
| -------------------- | -------- |
| AliceBlue            | #F0F8FF  |
| AntiqueWhite         | #FAEBD7  |
| Aqua                 | #00FFFF  |
| Aquamarine           | #7FFFD4  |
| Azure                | #F0FFFF  |
| Beige                | #F5F5DC  |
| Bisque               | #FFE4C4  |
| Black                | #000000  |
| BlanchedAlmond       | #FFEBCD  |
| Blue                 | #0000FF  |
| BlueViolet           | #8A2BE2  |
| Brown                | #A52A2A  |
| BurlyWood            | #DEB887  |
| CadetBlue            | #5F9EA0  |
| Chartreuse           | #7FFF00  |
| Chocolate            | #D2691E  |
| Coral                | #FF7F50  |
| CornflowerBlue       | #6495ED  |
| Cornsilk             | #FFF8DC  |
| Crimson              | #DC143C  |
| Cyan                 | #00FFFF  |
| DarkBlue             | #00008B  |
| DarkCyan             | #008B8B  |
| DarkGoldenRod        | #B8860B  |
| DarkGray             | #A9A9A9  |
| DarkGrey             | #A9A9A9  |
| DarkGreen            | #006400  |
| DarkKhaki            | #BDB76B  |
| DarkMagenta          | #8B008B  |
| DarkOliveGreen       | #556B2F  |
| DarkOrange           | #FF8C00  |
| DarkOrchid           | #9932CC  |
| DarkRed              | #8B0000  |
| DarkSalmon           | #E9967A  |
| DarkSeaGreen         | #8FBC8F  |
| DarkSlateBlue        | #483D8B  |
| DarkSlateGray        | #2F4F4F  |
| DarkSlateGrey        | #2F4F4F  |
| DarkTurquoise        | #00CED1  |
| DarkViolet           | #9400D3  |
| DeepPink             | #FF1493  |
| DeepSkyBlue          | #00BFFF  |
| DimGray              | #696969  |
| DimGrey              | #696969  |
| DodgerBlue           | #1E90FF  |
| FireBrick            | #B22222  |
| FloralWhite          | #FFFAF0  |
| ForestGreen          | #228B22  |
| Fuchsia              | #FF00FF  |
| Gainsboro            | #DCDCDC  |
| GhostWhite           | #F8F8FF  |
| Gold                 | #FFD700  |
| GoldenRod            | #DAA520  |
| Gray                 | #808080  |
| Grey                 | #808080  |
| Green                | #008000  |
| GreenYellow          | #ADFF2F  |
| HoneyDew             | #F0FFF0  |
| HotPink              | #FF69B4  |
| IndianRed            | #CD5C5C  |
| Indigo               | #4B0082  |
| Ivory                | #FFFFF0  |
| Khaki                | #F0E68C  |
| Lavender             | #E6E6FA  |
| LavenderBlush        | #FFF0F5  |
| LawnGreen            | #7CFC00  |
| LemonChiffon         | #FFFACD  |
| LightBlue            | #ADD8E6  |
| LightCoral           | #F08080  |
| LightCyan            | #E0FFFF  |
| LightGoldenRodYellow | #FAFAD2  |
| LightGray            | #D3D3D3  |
| LightGrey            | #D3D3D3  |
| LightGreen           | #90EE90  |
| LightPink            | #FFB6C1  |
| LightSalmon          | #FFA07A  |
| LightSeaGreen        | #20B2AA  |
| LightSkyBlue         | #87CEFA  |
| LightSlateGray       | #778899  |
| LightSlateGrey       | #778899  |
| LightSteelBlue       | #B0C4DE  |
| LightYellow          | #FFFFE0  |
| Lime                 | #00FF00  |
| LimeGreen            | #32CD32  |
| Linen                | #FAF0E6  |
| Magenta              | #FF00FF  |
| Maroon               | #800000  |
| MediumAquaMarine     | #66CDAA  |
| MediumBlue           | #0000CD  |
| MediumOrchid         | #BA55D3  |
| MediumPurple         | #9370DB  |
| MediumSeaGreen       | #3CB371  |
| MediumSlateBlue      | #7B68EE  |
| MediumSpringGreen    | #00FA9A  |
| MediumTurquoise      | #48D1CC  |
| MediumVioletRed      | #C71585  |
| MidnightBlue         | #191970  |
| MintCream            | #F5FFFA  |
| MistyRose            | #FFE4E1  |
| Moccasin             | #FFE4B5  |
| NavajoWhite          | #FFDEAD  |
| Navy                 | #000080  |
| OldLace              | #FDF5E6  |
| Olive                | #808000  |
| OliveDrab            | #6B8E23  |
| Orange               | #FFA500  |
| OrangeRed            | #FF4500  |
| Orchid               | #DA70D6  |
| PaleGoldenRod        | #EEE8AA  |
| PaleGreen            | #98FB98  |
| PaleTurquoise        | #AFEEEE  |
| PaleVioletRed        | #DB7093  |
| PapayaWhip           | #FFEFD5  |
| PeachPuff            | #FFDAB9  |
| Peru                 | #CD853F  |
| Pink                 | #FFC0CB  |
| Plum                 | #DDA0DD  |
| PowderBlue           | #B0E0E6  |
| Purple               | #800080  |
| RebeccaPurple        | #663399  |
| Red                  | #FF0000  |
| RosyBrown            | #BC8F8F  |
| RoyalBlue            | #4169E1  |
| SaddleBrown          | #8B4513  |
| Salmon               | #FA8072  |
| SandyBrown           | #F4A460  |
| SeaGreen             | #2E8B57  |
| SeaShell             | #FFF5EE  |
| Sienna               | #A0522D  |
| Silver               | #C0C0C0  |
| SkyBlue              | #87CEEB  |
| SlateBlue            | #6A5ACD  |
| SlateGray            | #708090  |
| SlateGrey            | #708090  |
| Snow                 | #FFFAFA  |
| SpringGreen          | #00FF7F  |
| SteelBlue            | #4682B4  |
| Tan                  | #D2B48C  |
| Teal                 | #008080  |
| Thistle              | #D8BFD8  |
| Tomato               | #FF6347  |
| Turquoise            | #40E0D0  |
| Violet               | #EE82EE  |
| Wheat                | #F5DEB3  |
| White                | #FFFFFF  |
| WhiteSmoke           | #F5F5F5  |
| Yellow               | #FFFF00  |
| YellowGreen          | #9ACD32  |

# HTML DOM

## HTML DOM Documents

- The Document Object
  - When an HTML document is loaded into a web browser, it becomes a **document object**
  - The **document object** is the root node of the HTML document
  - The **document object** is a property of the **window object**
  - The **document object** is accessed with:
  - `window.document` or just `document`
  ```js
  // Example
  let url = window.document.URL;
  let url = document.URL;
  ```
- [Read more](https://www.w3schools.com/jsref/dom_obj_document.asp)

### Document Object Properties and Methods

- The following properties and methods can be used on HTML documents

| Property / Method          | Description                                                                                                |
| -------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `activeElement`            | Returns the currently focused element in the document                                                      |
| `addEventListener()`       | Attaches an event handler to the document                                                                  |
| `adoptNode()`              | Adopts a node from another document                                                                        |
| `anchors`                  | Deprecated                                                                                                 |
| `applets`                  | Deprecated                                                                                                 |
| `baseURI`                  | Returns the absolute base URI of a document                                                                |
| `body`                     | Sets or returns the document's body (the `<body>` element)                                                 |
| `charset`                  | Deprecated                                                                                                 |
| `characterSet`             | Returns the character encoding for the document                                                            |
| `close()`                  | Closes the output stream previously opened with document.open()                                            |
| `cookie`                   | Returns all name/value pairs of cookies in the document                                                    |
| `createAttribute()`        | Creates an attribute node                                                                                  |
| `createComment()`          | Creates a Comment node with the specified text                                                             |
| `createDocumentFragment()` | Creates an empty DocumentFragment node                                                                     |
| `createElement()`          | Creates an Element node                                                                                    |
| `createEvent()`            | Creates a new event                                                                                        |
| `createTextNode()`         | Creates a Text node                                                                                        |
| `defaultView`              | Returns the window object associated with a document, or null if none is available.                        |
| `designMode`               | Controls whether the entire document should be editable or not.                                            |
| `doctype`                  | Returns the Document Type Declaration associated with the document                                         |
| `documentElement`          | Returns the Document Element of the document (the `<html>` element)                                        |
| `documentMode`             | Deprecated                                                                                                 |
| `documentURI`              | Sets or returns the location of the document                                                               |
| `domain`                   | Returns the domain name of the server that loaded the document                                             |
| `domConfig`                | Deprecated                                                                                                 |
| `embeds`                   | Returns a collection of all `<embed>` elements the document                                                |
| `execCommand()`            | Deprecated                                                                                                 |
| `forms`                    | Returns a collection of all `<form>` elements in the document                                              |
| `getElementById()`         | Returns the element that has the ID attribute with the specified value                                     |
| `getElementsByClassName()` | Returns an HTMLCollection containing all elements with the specified class name                            |
| `getElementsByName()`      | Returns an live NodeList containing all elements with the specified name                                   |
| `getElementsByTagName()`   | Returns an HTMLCollection containing all elements with the specified tag name                              |
| `hasFocus()`               | Returns a Boolean value indicating whether the document has focus                                          |
| `head`                     | Returns the `<head>` element of the document                                                               |
| `images`                   | Returns a collection of all `<img>` elements in the document                                               |
| `implementation`           | Returns the DOMImplementation object that handles this document                                            |
| `importNode()`             | Imports a node from another document                                                                       |
| `inputEncoding`            | Deprecated                                                                                                 |
| `lastModified`             | Returns the date and time the document was last modified                                                   |
| `links`                    | Returns a collection of all `<a>` and `<area>` elements in the document that have a href attribute         |
| `normalize()`              | Removes empty Text nodes, and joins adjacent nodes                                                         |
| `normalizeDocument()`      | Deprecated                                                                                                 |
| `open()`                   | Opens an HTML output stream to collect output from document.write()                                        |
| `querySelector()`          | Returns the first element that matches a specified CSS selector(s) in the document                         |
| `querySelectorAll()`       | Returns a static NodeList containing all elements that matches a specified CSS selector(s) in the document |
| `readyState`               | Returns the (loading) status of the document                                                               |
| `referrer`                 | Returns the URL of the document that loaded the current document                                           |
| `removeEventListener()`    | Removes an event handler from the document (that has been attached with the addEventListener() method)     |
| `renameNode()`             | Deprecated                                                                                                 |
| `scripts`                  | Returns a collection of `<script>` elements in the document                                                |
| `strictErrorChecking`      | Deprecated                                                                                                 |
| `title`                    | Sets or returns the title of the document                                                                  |
| `URL`                      | Returns the full URL of the HTML document                                                                  |
| `write()`                  | Writes HTML expressions or JavaScript code to a document                                                   |
| `writeln()`                | Same as write(), but adds a newline character after each statement                                         |

## HTML DOM Elements

- The Element Object
  - In the HTML DOM, the Element object represents an HTML element, like p, div, a, table, or any other HTML element
- Properties and Methods
  - The following properties and methods can be used on all HTML elements
- [Read more](https://www.w3schools.com/jsref/dom_obj_all.asp)

| Property / Method           | Description                                                                         |
| --------------------------- | ----------------------------------------------------------------------------------- |
| `accessKey`                 | Sets or returns the accesskey attribute of an element                               |
| `addEventListener()`        | Attaches an event handler to an element                                             |
| `appendChild()`             | Adds (appends) a new child node to an element                                       |
| `attributes`                | Returns a NamedNodeMap of an element's attributes                                   |
| `blur()`                    | Removes focus from an element                                                       |
| `childElementCount`         | Returns an elements's number of child elements                                      |
| `childNodes`                | Returns a NodeList of an element's child nodes                                      |
| `children`                  | Returns an HTMLCollection of an element's child elements                            |
| `classList`                 | Returns the class name(s) of an element                                             |
| `className`                 | Sets or returns the value of the class attribute of an element                      |
| `click()`                   | Simulates a mouse-click on an element                                               |
| `clientHeight`              | Returns the height of an element, including padding                                 |
| `clientLeft`                | Returns the width of the left border of an element                                  |
| `clientTop`                 | Returns the width of the top border of an element                                   |
| `clientWidth`               | Returns the width of an element, including padding                                  |
| `cloneNode()`               | Clones an element                                                                   |
| `closest()`                 | Searches the DOM tree for the closest element that matches a CSS selector           |
| `compareDocumentPosition()` | Compares the document position of two elements                                      |
| `contains()`                | Returns true if a node is a descendant of a node                                    |
| `contentEditable`           | Sets or returns whether the content of an element is editable or not                |
| `dir`                       | Sets or returns the value of the dir attribute of an element                        |
| `firstChild`                | Returns the first child node of an element                                          |
| `firstElementChild`         | Returns the first child element of an element                                       |
| `focus()`                   | Gives focus to an element                                                           |
| `getAttribute()`            | Returns the value of an element's attribute                                         |
| `getAttributeNode()`        | Returns an attribute node                                                           |
| `getBoundingClientRect()`   | Returns the size of an element and its position relative to the viewport            |
| `getElementsByClassName()`  | Returns a collection of child elements with a given class name                      |
| `getElementsByTagName()`    | Returns a collection of child elements with a given tag name                        |
| `hasAttribute()`            | Returns true if an element has a given attribute                                    |
| `hasAttributes()`           | Returns true if an element has any attributes                                       |
| `hasChildNodes()`           | Returns true if an element has any child nodes                                      |
| `id`                        | Sets or returns the value of the id attribute of an element                         |
| `innerHTML`                 | Sets or returns the content of an element                                           |
| `innerText`                 | Sets or returns the text content of a node and its descendants                      |
| `insertAdjacentElement()`   | Inserts a new HTML element at a position relative to an element                     |
| `insertAdjacentHTML()`      | Inserts an HTML formatted text at a position relative to an element                 |
| `insertAdjacentText()`      | Inserts text into a position relative to an element                                 |
| `insertBefore()`            | Inserts a new child node before an existing child node                              |
| `isContentEditable`         | Returns true if an element's content is editable                                    |
| `isDefaultNamespace()`      | Returns true if a given namespaceURI is the default                                 |
| `isEqualNode()`             | Checks if two elements are equal                                                    |
| `isSameNode()`              | Checks if two elements are the same node                                            |
| `isSupported()`             | Deprecated                                                                          |
| `lang`                      | Sets or returns the value of the lang attribute of an element                       |
| `lastChild`                 | Returns the last child node of an element                                           |
| `lastElementChild`          | Returns the last child element of an element                                        |
| `matches()`                 | Returns true if an element is matched by a given CSS selector                       |
| `namespaceURI`              | Returns the namespace URI of an element                                             |
| `nextSibling`               | Returns the next node at the same node tree level                                   |
| `nextElementSibling`        | Returns the next element at the same node tree level                                |
| `nodeName`                  | Returns the name of a node                                                          |
| `nodeType`                  | Returns the node type of a node                                                     |
| `nodeValue`                 | Sets or returns the value of a node                                                 |
| `normalize()`               | Joins adjacent text nodes and removes empty text nodes in an element                |
| `offsetHeight`              | Returns the height of an element, including padding, border and scrollbar           |
| `offsetWidth`               | Returns the width of an element, including padding, border and scrollbar            |
| `offsetLeft`                | Returns the horizontal offset position of an element                                |
| `offsetParent`              | Returns the offset container of an element                                          |
| `offsetTop`                 | Returns the vertical offset position of an element                                  |
| `outerHTML`                 | Sets or returns the content of an element (including the start tag and the end tag) |
| `outerText`                 | Sets or returns the outer text content of a node and its descendants                |
| `ownerDocument`             | Returns the root element (document object) for an element                           |
| `parentNode`                | Returns the parent node of an element                                               |
| `parentElement`             | Returns the parent element node of an element                                       |
| `previousSibling`           | Returns the previous node at the same node tree level                               |
| `previousElementSibling`    | Returns the previous element at the same node tree level                            |
| `querySelector()`           | Returns the first child element that matches a CSS selector(s)                      |
| `querySelectorAll()`        | Returns all child elements that matches a CSS selector(s)                           |
| `remove()`                  | Removes an element from the DOM                                                     |
| `removeAttribute()`         | Removes an attribute from an element                                                |
| `removeAttributeNode()`     | Removes an attribute node, and returns the removed node                             |
| `removeChild()`             | Removes a child node from an element                                                |
| `removeEventListener()`     | Removes an event handler that has been attached with the addEventListener() method  |
| `replaceChild()`            | Replaces a child node in an element                                                 |
| `scrollHeight`              | Returns the entire height of an element, including padding                          |
| `scrollIntoView()`          | Scrolls the an element into the visible area of the browser window                  |
| `scrollLeft`                | Sets or returns the number of pixels an element's content is scrolled horizontally  |
| `scrollTop`                 | Sets or returns the number of pixels an element's content is scrolled vertically    |
| `scrollWidth`               | Returns the entire width of an element, including padding                           |
| `setAttribute()`            | Sets or changes an attribute's value                                                |
| `setAttributeNode()`        | Sets or changes an attribute node                                                   |
| `style`                     | Sets or returns the value of the style attribute of an element                      |
| `tabIndex`                  | Sets or returns the value of the tabindex attribute of an element                   |
| `tagName`                   | Returns the tag name of an element                                                  |
| `textContent`               | Sets or returns the textual content of a node and its descendants                   |
| `title`                     | Sets or returns the value of the title attribute of an element                      |
| `toString()`                | Converts an element to a string                                                     |

### classList

- The classList property returns the CSS classnames of an element
- The classList property returns a DOMTokenList

#### classList Properties and Methods

| Name         | Description                                                       |
| ------------ | ----------------------------------------------------------------- |
| `add()`      | Adds one or more tokens to the list                               |
| `contains()` | Returns true if the list contains a class                         |
| `entries()`  | Returns an Iterator with key/value pairs from the list            |
| `forEach()`  | Executes a callback function for each token in the list           |
| `item()`     | Returns the token at a specified index                            |
| `keys()`     | Returns an Iterator with the keys in the list                     |
| `length R`   | turns the number of tokens in the list                            |
| `remove()`   | Removes one or more tokens from the list                          |
| `replace()`  | Replaces a token in the list                                      |
| `supports()` | Returns true if a token is one of an attribute's supported tokens |
| `toggle()`   | Toggles between tokens in the list                                |
| `value`      | Returns the token list as a string                                |
| `values()`   | Returns an Iterator with the values in the list                   |

- Examples

```js
// Add a "myStyle" class to an element:
const list = element.classList;
list.add('myStyle');

// Remove the "myStyle" class from an element:
const list = element.classList;
list.remove('myStyle');

// Toggle "myStyle" on and off:
const list = element.classList;
list.toggle('myStyle');

// Add multiple classes to the an element:
element.classList.add('myStyle', 'anotherClass', 'thirdClass');

// Remove multiple classes from an element:
element.classList.remove('myStyle', 'anotherClass', 'thirdClass');
// How many class names the element have:
let numb = element.classList.length;

// Get the class names of the "myDIV" element:
<div id='myDIV' class='myStyle anotherClass thirdClass'>
  <p>I am myDIV.</p>
</div>;

const list = document.getElementById('myDIV').classList;

// Get the first class of an element:
let className = element.classList.item(0);

// Does an an element has a "myStyle" class?
let x = element.classList.contains('myStyle');

// Remove "anotherClass" if an element has a "myStyle" class.
if (element.classList.contains('mystyle')) {
  element.classList.remove('anotherClass');
}

// Toggle between classes to create a dropdown button:
document.getElementById('myBtn').onclick = function () {
  myFunction();
};

function myFunction() {
  document.getElementById('myDropdown').classList.toggle('show');
}

//------------------------Create a sticky navigation bar------------------------

// Get the navbar
const navbar = document.getElementById('navbar');

// Get the offset position of the navbar
const sticky = navbar.offsetTop;

// Add the sticky class to the navbar when you reach its scroll position
// Remove it when you leave the scroll position
function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add('sticky');
  } else {
    navbar.classList.remove('sticky');
  }
}
```

## HTML DOM Event Objects

- When an event occurs in HTML, the event belongs to a certain event object, like a mouse click event belongs to the MouseEvent object
- [Read more](https://www.w3schools.com/jsref/obj_events.asp)

### Animation Event

- For CSS animations

| Property/Method | Description                                                 |
| --------------- | ----------------------------------------------------------- |
| `animationName` | Returns the name of the animation                           |
| `elapsedTime`   | Returns the number of seconds an animation has been running |
| `pseudoElement` | Returns the name of the pseudo-element of the animation     |

| Event Type           | Description                                         |
| -------------------- | --------------------------------------------------- |
| `animationend`       | The event occurs when a CSS animation has completed |
| `animationiteration` | The event occurs when a CSS animation is repeated   |
| `animationstart`     | The event occurs when a CSS animation has started   |

### Clipboard Event

- For modification of the clipboard

| Property/Method | Description                                                               |
| --------------- | ------------------------------------------------------------------------- |
| `clipboardData` | Returns an object containing the data affected by the clipboard operation |

| Event Type | Description                                                      |
| ---------- | ---------------------------------------------------------------- |
| `oncopy`   | The event occurs when the user copies the content of an element  |
| `oncut`    | The event occurs when the user cuts the content of an element    |
| `onpaste`  | The event occurs when the user pastes some content in an element |

### Drag Event

- For drag and drop interaction

| Property/Method | Description                              |
| --------------- | ---------------------------------------- |
| `dataTransfer`  | Returns the data that is dragged/dropped |

| Event Type    | Description                                                             |
| ------------- | ----------------------------------------------------------------------- |
| `ondrag`      | The event occurs when an element is being dragged                       |
| `ondragend`   | The event occurs when the user has finished dragging an element         |
| `ondragenter` | The event occurs when the dragged element enters the drop target        |
| `ondragleave` | The event occurs when the dragged element leaves the drop target        |
| `ondragover`  | The event occurs when the dragged element is over the drop target       |
| `ondragstart` | The event occurs when the user starts to drag an element                |
| `ondrop`      | The event occurs when the dragged element is dropped on the drop target |

### Focus Event

| Property/Method | Description                                                         |
| --------------- | ------------------------------------------------------------------- |
| `relatedTarget` | Returns the element related to the element that triggered the event |

| Event Type   | Description                                             |
| ------------ | ------------------------------------------------------- |
| `onblur`     | The event occurs when an element loses focus            |
| `onfocus`    | The event occurs when an element gets focus             |
| `onfocusin`  | The event occurs when an element is about to get focus  |
| `onfocusout` | The event occurs when an element is about to lose focus |

### HashChange Event

| Property/Method | Description                                                      |
| --------------- | ---------------------------------------------------------------- |
| `newURL`        | Returns the URL of the document, after the hash has been changed |
| `oldURL`        | Returns the URL of the document, before the hash was changed     |

| Event Type     | Description                                                              |
| -------------- | ------------------------------------------------------------------------ |
| `onhashchange` | The event occurs when there has been changes to the anchor part of a URL |

### Input Event

| Property/Method     | Description                                                                               |
| ------------------- | ----------------------------------------------------------------------------------------- |
| `data`              | Returns the inserted characters                                                           |
| `dataTransfer`      | Returns an object containing information about the inserted/deleted data                  |
| `getTargetRanges()` | Returns an array containing target ranges that will be affected by the insertion/deletion |
| `inputType`         | Returns the type of the change (i.e "inserting" or "deleting")                            |
| `isComposing`       | Returns whether the state of the event is composing or not                                |

| Event Type | Description                                      |
| ---------- | ------------------------------------------------ |
| `oninput`  | The event occurs when an element gets user input |

### Keyboard Event

| Property/Method      | Description                                                                                                                                                         |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `altKey`             | Returns whether the "ALT" key was pressed when the key event was triggered                                                                                          |
| `charCode`           | Returns the Unicode character code of the key that triggered the event                                                                                              |
| `code`               | Returns the code of the key that triggered the event                                                                                                                |
| `ctrlKey`            | Returns whether the "CTRL" key was pressed when the key event was triggered                                                                                         |
| `getModifierState()` | Returns true if the specified key is activated                                                                                                                      |
| `isComposing`        | Returns whether the state of the event is composing or not                                                                                                          |
| `key`                | Returns the key value of the key represented by the event                                                                                                           |
| `location`           | Returns the location of a key on the keyboard or device                                                                                                             |
| `metaKey`            | Returns whether the "meta" key was pressed when the key event was triggered                                                                                         |
| `repeat`             | Returns whether a key is being hold down repeatedly, or not                                                                                                         |
| `shiftKey`           | Returns whether the "SHIFT" key was pressed when the key event was triggered                                                                                        |
| `which`              | Returns the Unicode character code of the key that triggered the onkeypress event, or the Unicode key code of the key that triggered the onkeydown or onkeyup event |

| Event Type   | Description                                      |
| ------------ | ------------------------------------------------ |
| `onkeydown`  | The event occurs when the user is pressing a key |
| `onkeypress` | The event occurs when the user presses a key     |
| `onkeyup`    | The event occurs when the user releases a key    |

### Mouse Event

| Property/Method      | Description                                                                                                                |
| -------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| `altKey`             | Returns whether the "ALT" key was pressed when the mouse event was triggered                                               |
| `button`             | Returns which mouse button was pressed when the mouse event was triggered                                                  |
| `buttons`            | Returns which mouse buttons were pressed when the mouse event was triggered                                                |
| `clientX`            | Returns the horizontal coordinate of the mouse pointer, relative to the current window, when the mouse event was triggered |
| `clientY`            | Returns the vertical coordinate of the mouse pointer, relative to the current window, when the mouse event was triggered   |
| `ctrlKey`            | Returns whether the "CTRL" key was pressed when the mouse event was triggered                                              |
| `getModifierState()` | Returns true if the specified key is activated                                                                             |
| `metaKey`            | Returns whether the "META" key was pressed when an event was triggered                                                     |
| `movementX`          | Returns the horizontal coordinate of the mouse pointer relative to the position of the last mousemove event                |
| `movementY`          | Returns the vertical coordinate of the mouse pointer relative to the position of the last mousemove event                  |
| `offsetX`            | Returns the horizontal coordinate of the mouse pointer relative to the position of the edge of the target element          |
| `offsetY`            | Returns the vertical coordinate of the mouse pointer relative to the position of the edge of the target element            |
| `pageX`              | Returns the horizontal coordinate of the mouse pointer, relative to the document, when the mouse event was triggered       |
| `pageY`              | Returns the vertical coordinate of the mouse pointer, relative to the document, when the mouse event was triggered         |
| `region`             |                                                                                                                            |
| `relatedTarget`      | Returns the element related to the element that triggered the mouse event                                                  |
| `screenX`            | Returns the horizontal coordinate of the mouse pointer, relative to the screen, when an event was triggered                |
| `screenY`            | Returns the vertical coordinate of the mouse pointer, relative to the screen, when an event was triggered                  |
| `shiftKey`           | Returns whether the "SHIFT" key was pressed when an event was triggered                                                    |
| `which`              | Returns which mouse button was pressed when the mouse event was triggered                                                  |

| Event Type      | Description                                                                                           |
| --------------- | ----------------------------------------------------------------------------------------------------- |
| `onclick`       | The event occurs when the user clicks on an element                                                   |
| `oncontextmenu` | The event occurs when the user right-clicks on an element to open a context menu                      |
| `ondblclick`    | The event occurs when the user double-clicks on an element                                            |
| `onmousedown`   | The event occurs when the user presses a mouse button over an element                                 |
| `onmouseenter`  | The event occurs when the pointer is moved onto an element                                            |
| `onmouseleave`  | The event occurs when the pointer is moved out of an element                                          |
| `onmousemove`   | The event occurs when the pointer is moving while it is over an element                               |
| `onmouseout`    | The event occurs when a user moves the mouse pointer out of an element, or out of one of its children |
| `onmouseover`   | The event occurs when the pointer is moved onto an element, or onto one of its children               |
| `onmouseup`     | The event occurs when a user releases a mouse button over an element                                  |

### PageTransition Event

| Property/Method | Description                                           |
| --------------- | ----------------------------------------------------- |
| `persisted`     | Returns whether the webpage was cached by the browser |

| Event Type | Description                                                  |
| ---------- | ------------------------------------------------------------ |
| `pagehide` | The event occurs when the user navigates away from a webpage |
| `pageshow` | The event occurs when the user navigates to a webpage        |

### PopState Event

| Property/Method | Description                                                |
| --------------- | ---------------------------------------------------------- |
| `state`         | Returns an object containing a copy of the history entries |

| Event Type | Description                                        |
| ---------- | -------------------------------------------------- |
| `popstate` | The event occurs when the window's history changes |

### Progress Event

| Property/Method    | Description                                                         |
| ------------------ | ------------------------------------------------------------------- |
| `lengthComputable` | Returns whether the length of the progress can be computable or not |
| `loaded`           | Returns how much work has been loaded                               |
| `total`            | Returns the total amount of work that will be loaded                |

| Event Type    | Description                                                              |
| ------------- | ------------------------------------------------------------------------ |
| `onerror`     | The event occurs when an error occurs while loading an external file     |
| `onloadstart` | The event occurs when the browser starts looking for the specified media |

### Storage Event

| Property/Method | Description                                                |
| --------------- | ---------------------------------------------------------- |
| `key`           | Returns the key of the changed storage item                |
| `newValue`      | Returns the new value of the changed storage item          |
| `oldValue`      | Returns the old value of the changed storage item          |
| `storageArea`   | Returns an object representing the affected storage object |
| `url`           | Returns the URL of the changed item's document             |

| Event Type | Description                                         |
| ---------- | --------------------------------------------------- |
| `storage`  | The event occurs when a Web Storage area is updated |

### Touch Event

| Property/Method  | Description                                                                                                                                                                  |
| ---------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `altKey`         | Returns whether the "ALT" key was pressed when the touch event was triggered                                                                                                 |
| `changedTouches` | Returns a list of all the touch objects whose state changed between the previous touch and this touch                                                                        |
| `ctrlKey`        | Returns whether the "CTRL" key was pressed when the touch event was triggered                                                                                                |
| `metaKey`        | Returns whether the "meta" key was pressed when the touch event was triggered                                                                                                |
| `shiftKey`       | Returns whether the "SHIFT" key was pressed when the touch event was triggered                                                                                               |
| `targetTouches`  | Returns a list of all the touch objects that are in contact with the surface and where the touchstart event occured on the same target element as the current target element |
| `touches`        | Returns a list of all the touch objects that are currently in contact with the surface                                                                                       |

| Event Type      | Description                                                   |
| --------------- | ------------------------------------------------------------- |
| `ontouchcancel` | The event occurs when the touch is interrupted                |
| `ontouchend`    | The event occurs when a finger is removed from a touch screen |
| `ontouchmove`   | The event occurs when a finger is dragged across the screen   |
| `ontouchstart`  | The event occurs when a finger is placed on a touch screen    |

### Transition Event

| Property/Method | Description                                                 |
| --------------- | ----------------------------------------------------------- |
| `propertyName`  | Returns the name of the transition                          |
| `elapsedTime`   | Returns the number of seconds a transition has been running |
| `pseudoElement` | Returns the name of the pseudo-element of the transition    |

| Event Type      | Description                                          |
| --------------- | ---------------------------------------------------- |
| `transitionend` | The event occurs when a CSS transition has completed |

### UI Event

| Property/Method | Description                                                       |
| --------------- | ----------------------------------------------------------------- |
| `detail`        | Returns a number with details about the event                     |
| `view`          | Returns a reference to the Window object where the event occurred |

| Event Type       | Description                                                                        |
| ---------------- | ---------------------------------------------------------------------------------- |
| `onabort`        | The event occurs when the loading of a media is aborted                            |
| `onbeforeunload` | The event occurs before the document is about to be unloaded                       |
| `onerror`        | The event occurs when an error occurred during the loading of a media file         |
| `onload`         | The event occurs when an object has loaded                                         |
| `onresize`       | The event occurs when the document view is resized                                 |
| `onscroll`       | The event occurs when an element's scrollbar is being scrolled                     |
| `onselect`       | The event occurs after the user selects some text (for `<input>` and `<textarea>`) |
| `onunload`       | The event occurs once a page has unloaded (for `<body>`)                           |

### Wheel Event

| Property/Method | Description                                                                                         |
| --------------- | --------------------------------------------------------------------------------------------------- |
| `deltaX`        | Returns the horizontal scroll amount of a mouse wheel (x-axis)                                      |
| `deltaY`        | Returns the vertical scroll amount of a mouse wheel (y-axis)                                        |
| `deltaZ`        | Returns the scroll amount of a mouse wheel for the z-axis                                           |
| `deltaMode`     | Returns a number that represents the unit of measurements for delta values (pixels, lines or pages) |

| Event Type | Description                                                            |
| ---------- | ---------------------------------------------------------------------- |
| `onwheel`  | The event occurs when the mouse wheel rolls up or down over an element |

# Miscellaneous

- `<button>` elements have `type="submit"` by DEFAULT
  - This means that when `<button>` elements are placed inside `<form></form>` and are clicked, the form will be submitted
  - Change `type="button"` to prevent this
  - [Read more](https://html.spec.whatwg.org/multipage/form-elements.html#attr-button-type)
