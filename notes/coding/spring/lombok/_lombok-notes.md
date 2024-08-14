# Table of Contents

- [Table of Contents](#table-of-contents)
- [Lombok - Giuseppe](#lombok---giuseppe)
- [Project Lombok - Devtiro](#project-lombok---devtiro)
  - [Code Checkout (No Lombok)](#code-checkout-no-lombok)
  - [Installing Lombok Dependency](#installing-lombok-dependency)
  - [Installing Lombok Plugin in IntelliJ](#installing-lombok-plugin-in-intellij)
  - [Getters + Setters using `@Getter` + `@Setter`](#getters--setters-using-getter--setter)
    - [Method 1](#method-1)
    - [Method 2](#method-2)
    - [Code Example](#code-example)
    - [Refactoring with IntelliJ](#refactoring-with-intellij)
  - [Constructors](#constructors)
    - [Code Example](#code-example-1)
  - [`.toString()` using `@ToString`](#tostring-using-tostring)
    - [Code Example](#code-example-2)
  - [`.equals()` + `.hashCode()` using `@EqualsAndHashCode`](#equals--hashcode-using-equalsandhashcode)
    - [Code Example](#code-example-3)
  - [Data Classes using `@Data`](#data-classes-using-data)
    - [Code Example](#code-example-4)
  - [Loggers using `@Log`](#loggers-using-log)
    - [Code Example](#code-example-5)
  - [Builders (Builder Pattern)](#builders-builder-pattern)
    - [Code Example](#code-example-6)

# Lombok - Giuseppe

- [YouTube Playlist](https://www.youtube.com/playlist?list=PL6oD2syjfW7CchnxJKhJ8IiY61efkyL8h)

# Project Lombok - Devtiro

- Links
  - [Youtube Link](https://www.youtube.com/watch?v=p5Chs-AXFbg)
  - [GitHub Repo](https://github.com/devtiro/course-lombok)
  - [Project Lombok Docs](https://projectlombok.org/)

## Code Checkout (No Lombok)

```
./mvnw test
```

```java
// src/main/java/com/devtiro/lombok/App.java
package com.devtiro.lombok;

import com.devtiro.lombok.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class App {
  /**
   * This "App" simply prints out the books and authors found in a JSON file
   * in resources.
   *
   * @param args Main args.
   * @throws IOException when cannot read books-authors.json file.
   */
  public static void main(String[] args) throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();

    final URL booksAuthorsFile = App.class.getClassLoader().getResource("books-authors.json");
    final Book[] books = objectMapper.readValue(booksAuthorsFile, Book[].class);
    Arrays.stream(books).forEach(book -> System.out.println(book.toString()));
  }
}
```

- App.java
  - `ObjectMapper` converts string JSON data into Java Objects (POJOs)

## Installing Lombok Dependency

- Add the following to `~/pom.xml`
  - `<scope>provided</scope>` means that to use Lombok at compile time but do NOT include Lombok during final build artifact
  - `<scope>compile</scope>` means that to use Lombok at compile time and include Lombok in final build artifact

```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.28</version>
  <scope>provided</scope>
</dependency>
```

- Update all maven dependencies to latest version

```sh
mvn versions:use-latest-versions
```

## Installing Lombok Plugin in IntelliJ

- IntelliJ > Settings > Plugins > Lombok

## Getters + Setters using `@Getter` + `@Setter`

### Method 1

- Add `@Getter`, `@Setter` on top of EACH instance variable in the class

```java
import lombok.Getter;
import lombok.Setter;

class Person {
  @Getter
  @Setter
  String firstName;

  @Getter
  @Setter
  String lastName;

  @Getter
  @Setter
  Integer age;
}
```

### Method 2

- Add `@Getter`, `@Setter` on top of CLASS to cover ALL instance variables in class

```java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Person {
  String firstName;
  String lastName;
  Integer age;
}
```

### Code Example

**Method 1**

```java
// src/main/java/com/devtiro/lombok/domain/Author.java
package com.devtiro.lombok.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Author {

  @Getter
  @Setter
  private String givenName;

  @Getter
  @Setter
  private String familyName;

  @Getter
  @Setter
  private Integer age;

  public Author() {}

  public Author(final String givenName, final String familyName, final Integer age) {
    this.givenName = givenName;
    this.familyName = familyName;
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Author author = (Author) o;
    return Objects.equals(givenName, author.givenName) && Objects.equals(familyName, author.familyName) && Objects.equals(age, author.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(givenName, familyName, age);
  }

  @Override
  public String toString() {
    return "Author(" + "givenName=" + givenName + ", familyName=" + familyName + ", age=" + age + ')';
  }
}
```

**Method 2**

```java
// src/main/java/com/devtiro/lombok/domain/Book.java
package com.devtiro.lombok.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Book {
  private String title;
  private Integer yearPublished;
  private Author author;

  public Book() {}

  public Book(final String title, final Integer yearPublished, final Author author) {
    this.title = title;
    this.yearPublished = yearPublished;
    this.author = author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(title, book.title) && Objects.equals(yearPublished, book.yearPublished) && Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, yearPublished, author);
  }

  @Override
  public String toString() {
    return "Book(" + "title=" + title + ", yearPublished=" + yearPublished + ", author=" + author + ')';
  }
}
```

### Refactoring with IntelliJ

- In IntelliJ > Right Click > Lombok > `Default @Getter` + `Default @Setter`
- In IntelliJ > Right Click > Delombok

## Constructors

```java
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
class Person {
  String firstName;
  String lastName;
  Integer age;

  // public Person() {}

  // public Person(String firstName, String lastName, Integer age) {
  //   this.firstName = firstName
  //   this.lastName = lastName
  //   this.age = age
  // }
}
```

### Code Example

```java
// src/main/java/com/devtiro/lombok/domain/Author.java
package com.devtiro.lombok.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

  private String title;

  private Integer yearPublished;

  private Author author;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(title, book.title) && Objects.equals(yearPublished, book.yearPublished) && Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, yearPublished, author);
  }

  @Override
  public String toString() {
    return "Book(" + "title=" + title + ", yearPublished=" + yearPublished + ", author=" + author + ')';
  }
}
```

## `.toString()` using `@ToString`

```java
import lombok.ToString;

@ToString
class Person {
  //...
}
```

### Code Example

**Before**

```java
// src/main/java/com/devtiro/lombok/domain/Author.java
package com.devtiro.lombok.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {
  private String givenName;
  private String familyName;
  private Integer age;

  //...

  @Override
  public String toString() {
    return "Author(" +
        "givenName=" + givenName +
        ", familyName=" + familyName +
        ", age=" + age +
        ')';
  }
}
```

**After**

```java
// src/main/java/com/devtiro/lombok/domain/Author.java
package com.devtiro.lombok.domain;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Author {
  private String givenName;
  private String familyName;
  private Integer age;

  //...
}
```

## `.equals()` + `.hashCode()` using `@EqualsAndHashCode`

```java
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class Person {
  //...
}
```

### Code Example

**Before**

```java
// src/main/java/com/devtiro/lombok/domain/Author.java
package com.devtiro.lombok.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {
  private String givenName;
  private String familyName;
  private Integer age;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Author author = (Author) o;
    return Objects.equals(givenName, author.givenName) && Objects.equals(familyName, author.familyName)
        && Objects.equals(age, author.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(givenName, familyName, age);
  }
}
```

**After**

```java
// src/main/java/com/devtiro/lombok/domain/Author.java
package com.devtiro.lombok.domain;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Author {
  private String givenName;
  private String familyName;
  private Integer age;
}
```

## Data Classes using `@Data`

- In the previous examples we are essentially creating Data Transfer Objects (DTOs) and have a lot of annotations
- The `@Data` CONTAINS the following annotations: `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`

```java
import lombok.Data;

@Data
class Person {
  //...
}
```

### Code Example

**Before**

```java
// src/main/java/com/devtiro/lombok/domain/Author.java
package com.devtiro.lombok.domain;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Author {
  private String givenName;
  private String familyName;
  private Integer age;
}
```

**After**

```java
// src/main/java/com/devtiro/lombok/domain/Author.java
package com.devtiro.lombok.domain;

import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
  private String givenName;
  private String familyName;
  private Integer age;
}
```

## Loggers using `@Log`

```
import lombok.Log;

@Log
```

### Code Example

**Before**

```java
// src/main/java/com/devtiro/lombok/App.java
package com.devtiro.lombok;

import com.devtiro.lombok.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Logger;

public class App {
  /**
   * This "App" prints out the books and authors found in a JSON file in resources.
   * @param args Main args.
   * @throws IOException when cannot read books-authors.json file.
   */

  final static Logger log = Logger.getLogger(App.class.getName());

  public static void main(String[] args) throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();
    final URL booksAuthorsFile = App.class.getClassLoader().getResource("books-authors.json");
    final Book[] books = objectMapper.readValue(booksAuthorsFile, Book[].class);
    Arrays.stream(books).forEach(book -> log.info(book.toString));
  }
}
```

**After**

```java
// src/main/java/com/devtiro/lombok/App.java
package com.devtiro.lombok;

import com.devtiro.lombok.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import lombok.Log;

@Log
public class App {
  /**
   * This "App" prints out the books and authors found in a JSON file in resources.
   * @param args Main args.
   * @throws IOException when cannot read books-authors.json file.
   */

  public static void main(String[] args) throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();
    final URL booksAuthorsFile = App.class.getClassLoader().getResource("books-authors.json");
    final Book[] books = objectMapper.readValue(booksAuthorsFile, Book[].class);
    Arrays.stream(books).forEach(book -> log.info(book.toString));
  }
}
```

## Builders (Builder Pattern)

- Imagine you have a class with 20 parameters and 10 of them are optional
  - You could somehow make tons of constructors taking care of this logic, or make a constructor with all those arguments and pass `null`'s in some places
  - Solution/Fix: Is to use `@Builder`

```java
import lombok.Builder;

@Builder
class Person {
  //...
}
```

```java
// Usage
ClassName.builder().property1(value1).property2(value2).build();
```

### Code Example

```java
// src/main/java/com/devtiro/lombok/domain/Author.java
package com.devtiro.lombok.domain;

import lombok.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // <-- HERE
public class Author {
  private String givenName;
  private String familyName;
  private Integer age;
}
```

**Before**

```java
// src/test/java/com/devtiro/lombok/TestDataUtil.java
package com.devtiro.lombok;

import com.devtiro.lombok.domain.Author;
import com.devtiro.lombok.domain.Book;

// Utility class for generating test data
public final class TestDataUtil {
  private TestDataUtil() {}

  public static Author createTestAuthor() {
    return new Author(
        "Aria",
        "Montgomery",
        36);
  }

  public static Book createTestBook() {
    return new Book(
        "The Enigma of Eternity",
        2005,
        createTestAuthor());
  }
}
```

**After**

```java
// src/test/java/com/devtiro/lombok/TestDataUtil.java
package com.devtiro.lombok;

import com.devtiro.lombok.domain.Author;
import com.devtiro.lombok.domain.Book;

// Utility class for generating test data
public final class TestDataUtil {
  private TestDataUtil() {}

  public static Author createTestAuthor() {
    return Author.builder()
        .givenName("Aria")
        .familyName("Montgomery")
        .age(36)
        .build();
  }

  public static Book createTestBook() {
    return Book.builder()
        .title("The Enigma of Eternity")
        .yearPublished(2005)
        .author(createTestAuthor())
        .build();
  }
}
```
