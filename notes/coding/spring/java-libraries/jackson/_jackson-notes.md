# Table of Contents

- [Table of Contents](#table-of-contents)
- [Official Docs](#official-docs)
  - [Jackson](#jackson)
- [`@JsonNaming`](#jsonnaming)

# Official Docs

## Jackson

- [`jackson-core` - JavaDocs](http://fasterxml.github.io/jackson-core/javadoc/2.5/)
- [`jackson-core` - javadoc.io](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-core)
- [`jackson-annotations` - JavaDocs](http://fasterxml.github.io/jackson-databind/javadoc/2.5/)
- [`jackson-annotations` - javadoc.io](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-annotations)
- [`jackson-databind` - JavaDocs](http://fasterxml.github.io/jackson-annotations/javadoc/2.5/)
- [`jackson-databind` - javadoc.io](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind)

# `@JsonNaming`

```java
package com.example.demo.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder(toBuilder = true)
@Getter
@Setter
public class User {
  private Long userId;
  private String firstName;
  private String lastName;
  private String emailAddress;
}
```

```java
package com.example.demo.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@Builder(toBuilder = true)
@Getter
@Setter
public class User {
  private Long userId;
  private String firstName;
  private String lastName;
  private String emailAddress;
}
```
