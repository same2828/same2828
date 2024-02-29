# Table of Contents

- [Table of Contents](#table-of-contents)
- [URL](#url)
  - [Path Parameters](#path-parameters)
  - [Query Parameters](#query-parameters)
  - [Spaces](#spaces)
    - [Adding Spaces in URL Paths:](#adding-spaces-in-url-paths)
    - [Adding Spaces in URL Query Parameters:](#adding-spaces-in-url-query-parameters)

# URL

## Path Parameters

Path parameters are used to identify a specific resource or resources
Referenced using placeholders preceded by `:`
Example

```
/cars/view/:id
```

## Query Parameters

Query parameters are used to sort/filter resources identified by path parameters
`key=value` pairs separated by `&` that come AFTER the `?`
Example

```
/cars/view/?brand=toyota&type=sedan
```

## Spaces

- Spaces need to be encoded using specific characters to avoid ambiguity and conform to URL encoding standards
- When handling query parameters, it's important to encode the keys and values as well if they contain special characters, using URL encoding.
- Common special characters that need encoding include ampersand (&), equals (=), and question mark (?).

### Adding Spaces in URL Paths:

- Use URL encoding of `%20` to represent space character in paths
- Replace each space with `%20` in the path to encode it correctly
- Do NOT use the plus sign `+` to represent spaces in the path
- Note that if your path includes other special characters, such as slashes (/) or question marks (?), they may need to be encoded as well using the appropriate URL encoding

Example:

```
https://www.example.com/my%20path/
```

### Adding Spaces in URL Query Parameters:

- Query parameters are the key-value pairs that come after the question mark `?` in a URL (used to pass additional data to the server)
- Use URL encoding of `%20` or `+` to represent space character in query parameters

Example:

```
https://www.example.com/path?key=my%20value
https://www.example.com/path?key=my+value
```
