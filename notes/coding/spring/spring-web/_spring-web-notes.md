# Table of Contents

- [Table of Contents](#table-of-contents)
- [Miscellaneous](#miscellaneous)
  - [`ResponseEntity` - Dan Vega](#responseentity---dan-vega)
- [HTTP Interface in Spring - Baeldung](#http-interface-in-spring---baeldung)
  - [HTTP Interface](#http-interface)
    - [Exchange Methods](#exchange-methods)
    - [Method Parameters](#method-parameters)
    - [Return Values](#return-values)
  - [Client Proxy](#client-proxy)
    - [Proxy Factory](#proxy-factory)
    - [Exception Handling](#exception-handling)
  - [Testing](#testing)
    - [Using Mockito](#using-mockito)
    - [Using MockServer](#using-mockserver)
- [Spring HTTP Interface Clients: Consuming HTTP services in Spring Boot - Dan Vega](#spring-http-interface-clients-consuming-http-services-in-spring-boot---dan-vega)
  - [Project Setup](#project-setup)
    - [Article Service](#article-service)
    - [Content Service](#content-service)
  - [ArticleService](#articleservice)
    - [Defining the Article class](#defining-the-article-class)
    - [Defining the ArticleController](#defining-the-articlecontroller)
    - [Testing the Endpoints manually with Postman](#testing-the-endpoints-manually-with-postman)
  - [ContentService](#contentservice)
    - [Implementing the HTTP Interface Client](#implementing-the-http-interface-client)
    - [Creating the ContentController](#creating-the-contentcontroller)
    - [Testing the Endpoints manually with Postman](#testing-the-endpoints-manually-with-postman-1)
- [Spring Declarative HTTP Client using @HttpExchange - HowToDoInJava](#spring-declarative-http-client-using-httpexchange---howtodoinjava)
  - [What is a Declarative Http Interface?](#what-is-a-declarative-http-interface)
  - [Maven](#maven)
  - [Creating an HTTP Service Interface](#creating-an-http-service-interface)
    - [Exchange Methods](#exchange-methods-1)
    - [Method Arguments](#method-arguments)
    - [Return Values](#return-values-1)
  - [Building `HttpServiceProxyFactory`](#building-httpserviceproxyfactory)
  - [HTTP Request Headers](#http-request-headers)
    - [Headers Specific to a Request](#headers-specific-to-a-request)
    - [Set Static Global Header to WebClient Bean](#set-static-global-header-to-webclient-bean)
    - [Set Dynamic Global Header with ExchangeFilterFunction](#set-dynamic-global-header-with-exchangefilterfunction)
  - [HTTP Service Interface Example](#http-service-interface-example)

# Miscellaneous

## `ResponseEntity` - Dan Vega

- [Spring ResponseEntity - How to customize the response in Spring Boot](https://www.youtube.com/watch?v=B5Zrn1Tzyqw).

> If you are NOT manipulating the response and just returning the body -> use the type as the return type
> If you are manipulating the response (i.e. adding headers, changing status codes) -> use Response Entity as the return type

- [ResponseEntity<T> Docs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html)

```java
// src/main/java/org.codemash.runtracker/RunTrackerApplication.java
package org.codemash.runtracker;

import org.codemash.runtracker.model.Activity;
import org.codemash.runtracker.repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunTrackerApplication {
  public static void main(String[] args) {
    SpringApplication.run(RunTrackerApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(ActivityRepository activityRepository) {
    return args -> {
      activityRepository.save(new Activity("Tuesday Morning Run",
        LocalDateTime.of(2022, 12, 06, 10, 00),
        LocalDateTime.now().plus(45, ChronoUnit.MINUTES)));
      activityRepository.save(new Activity("Wednesday Evening Run",
        LocalDateTime.of(2022, 12, 07, 17, 00),
        LocalDateTime.now().plus(60, ChronoUnit.MINUTES)));
    };
  }
}
```

```java
// src/main/java/org.codemash.runtracker/repository/ActivityRepository.java
package org.codemash.runtracker.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.codemash.runtracker.model.Activity;

public interface ActivityRepository extends ListCrudRepository<Activity, Integer> {

}
```

```java
// src/main/java/org.codemash.runtracker/controller/ActivityController.java
package org.codemash.runtracker.controller;

import org.codemash.runtracker.model.Activity;
import org.codemash.runtracker.repository.ActivityRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@equestMapping("/api/activity")
public class ActivityController {
  private final ActivityRepository activityRepository;

  // Constructor-Injection
  public ActivityController(ActivityRepository activityRepository) {
    this.activityRepository = activity;
  }

  // @GetMapping("/")
  // public List<Activity> findAll() {
  //   return activityRepository.findAll();
  // }

  @GetMapping("/")
  public ResponseEntity<List<Activity>> findAll() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("my-custom-header", "my-custom-value");
    return new ResponseEntity<>(activityRepository.findAll(), headers, HttpStatus.OK);
    // return new ResponseEntity<>(activityRepository.findAll(), headers, 200);

    // Return 200 http_status with body of `activityRepository.findAll()`
    return ResponseEntity.ok(activityRepository.findAll());
  }

  @ResponseStatus(HttpStatus.CREATED)
  public Activity create(@RequestBody Activity activity) {
    return activityRepository.save(activity);
  }
}
```

# HTTP Interface in Spring - Baeldung

- [HTTP Interface in Spring - Baeldung](https://www.baeldung.com/spring-6-http-interface)
- [HTTP Interface Docs](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-http-interface)

> The Spring Framework 6 and Spring Boot 3, enables us to define declarative HTTP services using Java interfaces

## HTTP Interface

The declarative HTTP interface includes annotated methods for HTTP exchanges.

We can express the remote API details using an annotated Java interface and let Spring
generate a proxy that implements this interface and performs the exchanges (reducing the boilerplate code)

### Exchange Methods

`@HttpExchange` is the root annotation we can apply to an HTTP interface and its exchange methods.

When we apply it on the interface level, then it applies to ALL exchange methods.

This can be useful for specifying attributes common to all interface methods like content type or URL prefix.

Additional annotations for all the HTTP methods are available:

- `@GetExchange` for HTTP GET requests
- `@PostExchange` for HTTP POST requests
- `@PutExchange` for HTTP PUT requests
- `@PatchExchange` for HTTP PATCH requests
- `@DeleteExchange` for HTTP DELETE requests

Example of defining a sample declarative HTTP interface using the method-specific annotations for a simple REST service:

Note: All the HTTP method-specific annotations are meta-annotated with @HttpExchange

- Therefore, `@GetExchange("/books")` is equivalent to `@HttpExchange(url = "/books", method = "GET")`

```java
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import java.util.List;

interface BooksService {
  @GetExchange("/books")
  List<Book> getBooks();

  @GetExchange("/books/{id}")
  Book getBook(@PathVariable long id);

  @PostExchange("/books")
  Book saveBook(@RequestBody Book book);

  @DeleteExchange("/books/{id}")
  ResponseEntity<Void> deleteBook(@PathVariable long id);
}
```

### Method Parameters

In the example interface above, we used `@PathVariable` and `@RequestBody` annotations for method parameters

In addition, we may use the following set of method parameters for our exchange methods:

- `URI`: Dynamically sets the URL for the request, overriding the annotation attribute
- `HttpMethod`: Dynamically sets the HTTP method for the request, overriding the annotation attribute
- `@RequestHeader`: Adds the request header names and values, the argument may be a Map or MultiValueMap
- `@PathVariable`: Replaces a value that has a placeholder in the request URL
- `@RequestBody`: Provides the body of the request either as an object to be serialized, or a reactive streams publisher such as Mono or Flux
- `@RequestParam`: Adds request parameter names and values, the argument may be a Map or MultiValueMap
- `@CookieValue`: Adds cookie names and values, the argument may be a Map or MultiValueMap

Note: Request parameters are encoded in the request body only for content type "application/x-www-form-urlencoded". Otherwise, request parameters are added as URL query parameters.

### Return Values

In the example interface above, the exchange methods return blocking values.

However, declarative **HTTP interface exchange methods support both blocking and reactive return values**

In addition, we may choose to return only the specific response information, such as status codes or headers.
As well as returning void in case we are not interested in the service response at all.

To summarize, HTTP interface exchange methods support the following set of return values:

- `void, Mono<Void>`: Performs the request and releases the response content
- `HttpHeaders, Mono<HttpHeaders>`: Performs the request, releases the response content, and returns the response headers
- `<T>, Mono<T>`: Performs the request and decodes the response content to the declared type
- `<T>, Flux<T>`: Performs the request and decodes the response content to a stream of the declared type
- `ResponseEntity<Void>, Mono<ResponseEntity<Void>>`: Performs the request, releases the response content, and returns a ResponseEntity containing status and headers
- `ResponseEntity<T>, Mono<ResponseEntity<T>>`: Performs the request, releases the response content, and returns a ResponseEntity containing status, headers, and the decoded body
- `Mono<ResponseEntity<Flux<T>>`: Performs the request, releases the response content, and returns a ResponseEntity containing status, headers, and the decoded response body stream

We can also use any other async or reactive types registered in the `ReactiveAdapterRegistry`

## Client Proxy

Now that we have defined our sample HTTP service interface, we'll need to create a proxy that implements the interface and performs the exchanges.

### Proxy Factory

Spring framework provides us with a `HttpServiceProxyFactory` that we can use to generate a client proxy for our HTTP interface:

```java
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.service.invoker.WebClientAdapter;

//...

HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
  .builder(WebClientAdapter.forClient(webClient))
  .build();
booksService = httpServiceProxyFactory.createClient(BooksService.class);
```

To create a proxy using the provided factory, besides the HTTP interface, we'll also require an instance of a reactive web client:

```java
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.service.invoker.WebClientAdapter;

//...

WebClient webClient = WebClient.builder()
  .baseUrl(serviceUrl)
  .build();
```

Now, we can register the client proxy instance as a Spring bean or component and use it to exchange data with the REST service.

### Exception Handling

By default, `WebClient` throws `WebClientResponseException` for any client or server error HTTP status codes.

We can customize exception handling by registering a default response status handler that applies to all responses performed through the client:

```java
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

BooksClient booksClient = new BooksClient(WebClient.builder()
  .defaultStatusHandler(HttpStatusCode::isError, resp -> Mono.just(new MyServiceException("Custom exception")))
  .baseUrl(serviceUrl)
  .build());
```

As a result, when we we request a book that does NOT exist, we'll receive a custom exception:

```java
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatusCode;

public class BookServiceTest {

  @Test
  public void testGetBookThrowsException() {
    BooksService booksService = booksClient.getBooksService();
    assertThrows(MyServiceException.class, () -> booksService.getBook(9));
  }
}
```

## Testing

Test our sample declarative HTTP interface and its client proxy that performs the exchanges.

### Using Mockito

As we aim to test the client proxy created using our declarative HTTP interface,
we'll need to mock the underlying WebClient's fluent API using Mockito's deep stubbing feature:

- https://www.baeldung.com/mockito-fluent-apis

```java
@Mock(answer = Answers.RETURNS_DEEP_STUBS)
private WebClient webClient;
```

Now, we can use Mockito's Behaviour Driven Development (BDD) methods to call the chained WebClient methods and provide a mocked response:

- https://www.baeldung.com/bdd-mockito

```java
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyMap;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.ParameterizedTypeReference;
import reactor.core.publisher.Mono;

import java.util.List;

public class BookTests {

  @Test
  public void testGetBooks() {
    given(webClient.method(HttpMethod.GET)
      .uri(anyString(), anyMap())
      .retrieve()
      .bodyToMono(new ParameterizedTypeReference<List<Book>>(){}))
      .willReturn(Mono.just(List.of(
        new Book(1,"Book_1", "Author_1", 1998),
        new Book(2, "Book_2", "Author_2", 1999)
      )));
  }
}
```

Once we have our mocked response in place, we can call our service using the methods defined in the HTTP interface:

```java
BooksService booksService = booksClient.getBooksService();
Book book = booksService.getBook(1);
assertEquals("Book_1", book.title());
```

### Using MockServer

In case we want to avoid mocking the WebClient, we can use a library like **MockServer to generate and return fixed HTTP responses:**

```java
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.MediaType;
import org.mockserver.model.HttpStatusCode;
import org.mockserver.model.HttpRequest.request;
import org.mockserver.model.HttpResponse.response;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpMethod;

public class MockServerSetup {
  private static final String SERVER_ADDRESS = "localhost";
  private static final int serverPort = 1080;
  private static final String PATH = "/api";

  public void setupMockServer() {
    new MockServerClient(SERVER_ADDRESS, serverPort)
      .when(
        request()
          .withPath(PATH + "/1")
          .withMethod(HttpMethod.GET.name()),
        Times.exactly(1))
      .respond(
        response()
          .withStatusCode(HttpStatusCode.OK_200.code())
          .withContentType(MediaType.APPLICATION_JSON)
          .withBody("{\"id\":1,\"title\":\"Book_1\",\"author\":\"Author_1\",\"year\":1998}"));
  }
}
```

Now that we have the mocked responses in place and a running mock server, we can call our service:

```java
import org.springframework.web.reactive.function.client.WebClient;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BooksTest {
  private static final String serviceUrl = "http://example.com"; // Replace with actual service URL

  public void testGetBook() {
    BooksClient booksClient = new BooksClient(WebClient.builder()
      .baseUrl(serviceUrl)
      .build());
    BooksService booksService = booksClient.getBooksService();
    Book book = booksService.getBook(1);
    assertEquals("Book_1", book.title());
  }
}
```

We can also verify that our code under test called the correct mocked service:

```java
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpMethod;
import org.mockserver.verify.VerificationTimes;

public class MockServerVerification {
  private static final String PATH = "/api";

  public void verifyMockServer(MockServerClient mockServer) {
    mockServer.verify(
      HttpRequest.request()
        .withMethod(HttpMethod.GET.name())
        .withPath(PATH + "/1"),
      VerificationTimes.exactly(1));
  }
}
```

# Spring HTTP Interface Clients: Consuming HTTP services in Spring Boot - Dan Vega

- [YouTube Video](https://www.youtube.com/watch?v=4U0hUyktpvg)
- [Blog](https://www.danvega.dev/blog/spring-http-interfaces)
- [GitHub Source Code](https://github.com/danvega/http-interfaces)
- [HTTP Interface Docs](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-http-interface)

## Project Setup

We are creating 2 modules

### Article Service

Add the `Spring Web` Module

This service defines the articles in our system and provides a REST API

### Content Service

Add the `Spring Web` Module

Add the `Spring Reactive Web` Module

The content service will delegate all Article calls to the Articles Service using a new client.

## ArticleService

```java
// http-interfaces/articles-service/src/main/java/dev/danvega/articlesservice/ArticlesServiceApplication.java
package dev.danvega.articlesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArticlesServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(ArticlesServiceApplication.class, args);
  }
}
```

### Defining the Article class

```java
// http-interfaces/articles-service/src/main/java/dev/danvega/articlesservice/model/Article.java
package dev.danvega.articlesservice.model;

public record Article(Integer id, String title, String body) {} // <-- HERE
```

### Defining the ArticleController

```java
// http-interfaces/articles-service/src/main/java/dev/danvega/articlesservice/controller/ArticleController.java
package dev.danvega.articlesservice.controller;

import dev.danvega.articlesservice.model.Article;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

  private final List<Article> articles = new ArrayList<>();

  @GetMapping
  public List<Article> findAll() throws InterruptedException {
    // Thread.sleep(6000);
    return articles;
  }

  @GetMapping("/{id}")
  public Optional<Article> findById(@PathVariable Integer id) {
    return articles.stream().filter(article -> article.id().equals(id)).findFirst();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Article article) {
    this.articles.add(article);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@RequestBody Article updatedArticle, @PathVariable Integer id) {
    // var currArticle = articles.stream().filter(a -> a.id().equals(id)).findFirst();
    Optional<Article> currArticle = articles.stream().filter(a -> a.id().equals(id)).findFirst();
    currArticle.ifPresent(value -> this.articles.set(articles.indexOf(value), updatedArticle));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    this.articles.removeIf(a -> a.id().equals(id));
  }

  @PostConstruct
  private void init() {
    Article article = new Article(1, "Hello, World!", "This is my first post");
    this.articles.add(article);
  }
}
```

### Testing the Endpoints manually with Postman

- Change `server.port` in `application.properties` to avoid CONFLICTS
- Run/Start the ArticlesServiceApplication

```conf
# http-interfaces/articles-service/src/main/resources/application.properties
server.port=8081
```

```txt
# articles.http

### Find All Articles
GET http://localhost:8081/api/articles

### Get Article by ID
GET http://localhost:8081/api/articles/1

### Create new article
POST http://localhost:8081/api/articles
Content-Type: application/json

{
  "id": 2,
  "title": "My 2nd Post",
  "body": "My Second blog post"
}

### Update existing Content
PUT http://localhost:8081/api/articles/2
Content-Type: application/json

{
  "id": 2,
  "title": "My 2nd Post",
  "body": "I have updated my 2nd blog post!"
}

### delete by id
DELETE http://localhost:8081/api/articles/2
```

## ContentService

```java
// http-interfaces/content-service/src/main/java/dev/danvega/contentservice/ContentServiceApplication.java
package dev.danvega.contentservice;

import dev.danvega.contentservice.service.ArticleClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class ContentServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ContentServiceApplication.class, args);
  }
}
```

### Implementing the HTTP Interface Client

Client == Responsible for the "calling" of the ArticleService somewhere else

```java
// http-interfaces/content-service/src/main/java/dev/danvega/contentservice/config/ClientConfig.java
package dev.danvega.contentservice.config;

import dev.danvega.contentservice.service.ArticleClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
public class ClientConfig {

  @Bean
  ArticleClient articleClient() {
    WebClient client = WebClient.builder()
      .baseUrl("http://localhost:8081/api")
      .build();
    HttpServiceProxyFactory factory = HttpServiceProxyFactory
      .builder(WebClientAdapter.forClient(client))
      .blockTimeout(Duration.ofSeconds(7))
      .build();
    return factory.createClient(ArticleClient.class);
  }
}
```

```java
// http-interfaces/content-service/src/main/java/dev/danvega/contentservice/service/ArticleClient.java
package dev.danvega.contentservice.service;

import dev.danvega.contentservice.model.Article;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;
import java.util.Optional;

public interface ArticleClient {

  @GetExchange("/articles")
  ResponseEntity<List<Article>> findAll(); // Blocking
  // Flux<Article> findAll();        // Non-Blocking (Async)

  @GetExchange("/articles/{id}")
  Optional<Article> findOne(@PathVariable Integer id);

  @PostExchange("/articles")
  void create(@RequestBody Article article);

  @PutExchange("/articles/{id}")
  void update(@RequestBody Article article, @PathVariable Integer id);

  @DeleteExchange("/articles/{id}")
  void delete(@PathVariable Integer id);
}
```

### Creating the ContentController

```java
package dev.danvega.contentservice.controller;

import dev.danvega.contentservice.model.Article;
import dev.danvega.contentservice.service.ArticleClient;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

  public final ArticleClient articleClient;

  // Constructor Injection
  public ContentController(ArticleClient articleClient) {
    this.articleClient = articleClient;
  }

  @GetMapping("/articles")
  public ResponseEntity<List<Article>> findAllArticles() {
    return articleClient.findAll();
  }

  @GetMapping("/articles/{id}")
  public Optional<Article> findById(@PathVariable Integer id) {
    return articleClient.findOne(id);
  }

  @PostMapping("/articles")
  public void create(@RequestBody Article article) {
    articleClient.create(article);
  }

  @PutMapping("/articles/{id}")
  public void update(@RequestBody Article article, @PathVariable Integer id) {
    articleClient.update(article, id);
  }

  @DeleteMapping("/articles/{id}")
  public void delete(@PathVariable Integer id) {
    articleClient.delete(id);
  }
}
```

### Testing the Endpoints manually with Postman

```txt
# content.http

### Find All Articles
GET http://localhost:8080/api/content/articles

### Get Article by ID
GET http://localhost:8080/api/content/articles/1

### Create new article
POST http://localhost:8080/api/content/articles
Content-Type: application/json

{
  "id": 2,
  "title": "My 2nd Post",
  "body": "My Second blog post"
}

### Update existing Content
PUT http://localhost:8080/api/content/articles/2
Content-Type: application/json

{
  "id": 2,
  "title": "My 2nd Post",
  "body": "I have updated my 2nd blog post!"
}

### delete by id
DELETE http://localhost:8080/api/content/articles/2
```

# Spring Declarative HTTP Client using @HttpExchange - HowToDoInJava

- [Spring Declarative HTTP Client using @HttpExchange](https://howtodoinjava.com/spring-webflux/http-declarative-http-client-httpexchange/)
- [HTTP Interface Docs](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-http-interface)

> Starting Spring 6 and Spring Boot 3, Spring framework supports proxying a remote HTTP service as a Java interface with annotated methods for HTTP exchanges
> Similar libraries, like OpenFeign and Retrofit, can still be used, but HttpServiceProxyFactory adds native support to Spring framework.

## What is a Declarative Http Interface?

A declarative HTTP interface is a Java interface that helps reduce the boilerplate code,
generates a proxy implementing this interface, and performs the exchanges at the framework level.

For example, if we want to consume an API at URL https://server-address.com/api/resource/id
then we need to create and configure either a `RestTemplate` or `WebClient` bean
and use its exchange methods for invoking the API, parsing response and handling the errors.

Most often, the code to create and configure the beans and invoke remote APIs is
very similar and thus can be abstracted by the framework, so we do not need to
write this code again and again in every application. We can simply express the
remote API details using the annotations on an interface and let the framework
create an implementation under the hood.

For example, if we want to consume a HTTP GET /users API then we can simply write:

```java
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Flux;

public interface UserClient {
  @GetExchange("/users")
  Flux<User> getAll();
}
```

Spring will provide the interface and exchange implementations in runtime,
and we only need to invoke the `getAll()` method.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserService {

  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  @Autowired // <-- HERE
  UserClient userClient; // <-- HERE

  public void fetchAllUsers() {
    userClient.getAll().subscribe( // <-- HERE
      data -> log.info("User: {}", data)); // <-- HERE
  }
}
```

## Maven

The declarative HTTP interface functionality is part of the `spring-web` dependency
that is transitively pulled in when we include either `spring-boot-starter-web` or `spring-boot-starter-webflux`

- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-webflux

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<!-- For reactive support -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

## Creating an HTTP Service Interface

> In Spring, a HTTP service interface is a Java interface with @HttpExchange methods

The annotated method is treated as an HTTP endpoint, and the details are defined
statically through annotation attributes as well as through the input method argument types.

### Exchange Methods

We can use the following annotations to mark a method as HTTP service endpoint:

| Exchange Method   | Description                                                                                                        |
| ----------------- | ------------------------------------------------------------------------------------------------------------------ |
| `@HttpExchange`   | Is the generic annotation to specify an HTTP endpoint. When used at the interface level, it applies to all methods |
| `@GetExchange`    | Specifies @HttpExchange for HTTP GET requests                                                                      |
| `@PostExchange`   | Specifies @HttpExchange for HTTP POST requests                                                                     |
| `@PutExchange`    | Specifies @HttpExchange for HTTP PUT requests                                                                      |
| `@DeleteExchange` | Specifies @HttpExchange for HTTP DELETE requests                                                                   |
| `@PatchExchange`  | Specifies @HttpExchange for HTTP PATCH requests                                                                    |

### Method Arguments

The exchange methods support the following method parameters in the method signature:

| Method Parameters | Description                                                                                                                                                                                                                       |
| ----------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `URI`             | Sets the URL for the request                                                                                                                                                                                                      |
| `@PathVariable`   | Replaces a value with a placeholder in the request URL (e.g. `id` in `/users/{id}`)                                                                                                                                               |
| `@RequestBody`    | Provides the body of the request                                                                                                                                                                                                  |
| `@RequestParam`   | Add the request parameter(s) `?key1=value1&key2=value2`. When "content-type" is set to "application/x-www-form-urlencoded", request parameters are encoded in the request body. Otherwise, they are added as URL query parameters |
| `@RequestHeader`  | Adds the request header names and values                                                                                                                                                                                          |
| `@RequestPart`    | Can be used to add a request part (form field, resource or HttpEntity etc)                                                                                                                                                        |
| `@CookieValue`    | Adds cookies to the request                                                                                                                                                                                                       |

```java
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @PutMapping
  void update(@PathVariable Long id, @RequestBody User user) {
    // Method implementation
  }
}
```

### Return Values

An HTTP exchange method can return values that are:

- Either blocking or reactive (Mono/Flux).
- Only the specific response information, such as status code and/or response headers.
- `void` if the method is treated as execute only.

For a blocking exchange method, we should generally return `ResponseEntity`, and for reactive methods, we can return the `Mono/Flux` types.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

  // Blocking
  @GetMapping("/{id}")
  User getById(@PathVariable Long id) {
    // Example method implementation
    return new User(id, "John Doe");
  }

  // Reactive
  @GetMapping("/reactive/{id}")
  Mono<User> getByIdReactive(@PathVariable Long id) {
    // Example method implementation
    return Mono.just(new User(id, "John Doe"));
  }
}
```

## Building `HttpServiceProxyFactory`

The `HttpServiceProxyFactory` is a factory to create a client proxy from an HTTP service interface.

Use its `HttpServiceProxyFactory.builder(client).build()` method to get an instance of the proxy bean.

Note: Notice we have set the remote API's base URL in the WebClient bean, so we need to use only the relative paths in the exchange methods.

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.app.web.UserClient;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {
  @Bean
  WebClient webClient(ObjectMapper objectMapper) {
    return WebClient.builder()
      .baseUrl("https://jsonplaceholder.typicode.com/")
      .build();
  }

  @SneakyThrows
  @Bean
  UserClient postClient(WebClient webClient) {
    HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
    return httpServiceProxyFactory.createClient(UserClient.class);
  }
}
```

## HTTP Request Headers

We can set the request headers in all outgoing requests in two ways:

1. Headers specific to a request
2. Global headers send with every outgoing request automatically

### Headers Specific to a Request

To send a header, specific to a request, we must add it to the method signature using the `@RequestHeader` annotation as follows:

```java
import org.springframework.web.bind.annotation.GetExchange;
import org.springframework.web.bind.annotation.RequestHeader;
import reactor.core.publisher.Flux;

public class UserController {

  @GetExchange("/")
  Flux<User> getAll(@RequestHeader("MY-CUSTOM-HEADER") String headerName) { // <-- HERE
    User user1 = new User("1", "Alice");
    // Example implementation
    User user2 = new User("2", "Bob");
    return Flux.just(user1, user2);
  }
}
```

Next, we need to set the header value when we execute the request.

```java
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class UserClientExample {

  private static final Logger log = LoggerFactory.getLogger(UserClientExample.class);

  public void execute() {
    String headerValue = UUID.randomUUID().toString(); // <-- HERE
    UserClient userClient = new UserClient();
    userClient.getAll(headerValue).subscribe( // <-- HERE
      data -> log.info("User: {}", data));
  }
}
```

### Set Static Global Header to WebClient Bean

To set the request headers for every outgoing request, such as trace ID or authentication, we can set the headers in the `WebClient` bean itself.

In the example below, we are setting the basic authentication with each outgoing request.
Additionally, we have set the `enableLoggingRequestDetails(true)` to verify the headers in outgoing requests

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  @Bean
  public WebClient webClient(ObjectMapper objectMapper) {
    return WebClient.builder()
      .exchangeStrategies(
        ExchangeStrategies.builder().codecs(c -> c.defaultCodecs().enableLoggingRequestDetails(true)).build())
      .defaultHeaders(header -> header.setBasicAuth("username", "password")) // Globally Set Header - Once
      .baseUrl("https://jsonplaceholder.typicode.com/")
      .build();
  }
}
```

Now, when we execute the `getAll()` API written, we can see that both, local and global, headers are present in the request.

```txt
HTTP GET https://jsonplaceholder.typicode.com/users/
headers=[Authorization:"Basic dXNlcm5hbWU6cGFzc3dvcmQ=",
  Content-Type:"application/json",
  Accept:"application/json",
  MY-CUSTOM-HEADER:"0d4cb598-c53c-43dc-ac66-b13d78df8191"]
```

### Set Dynamic Global Header with ExchangeFilterFunction

If we want to set a global header whose value changes for each outgoing request,
we can use the `ExchangeFilterFunction`.

The `ExchangeFilterFunction` represents a filter that, once registered, is executed
for each request-response interaction with the server.

It should be noted `ClientRequest` object is IMMUTABLE and we CANNOT modify this once it has been fully initialized.
So in the `ExchangeFilterFunction.filter()`, we need to create a new `ClientRequest`
with the details from the existing request, add our new headers with dynamic values
and build a new request for further processing.

```java
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class DynamicHeaderFilter implements ExchangeFilterFunction {
  @Override
  public Mono<ClientResponse> filter(ClientRequest clientRequest, ExchangeFunction nextFilter) {
    // Create a new ClientRequest with the additional headers
    ClientRequest modifiedRequest = ClientRequest
      .from(clientRequest)
      .header("MY-REQUEST-TIMESTAMP", LocalDateTime.now().toString())
      .build();
    return nextFilter.exchange(modifiedRequest);
  }
}
```

Next, register the DynamicHeaderFilter with the WebClient so it is invoked for each outgoing request.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class WebClientConfig {

  @Autowired
  DynamicHeaderFilter dynamicHeaderFilter;

  @Bean
  public WebClient webClient(ObjectMapper objectMapper) {
    return WebClient.builder()
      //...
      .filter(dynamicHeaderFilter)
      //...
      .build();
  }
}
```

Test above filter with Postman request

```txt
HTTP GET https://jsonplaceholder.typicode.com/users/

headers=[
  Authorization:"Basic dXNlcm5hbWU6cGFzc3dvcmQ=",
  Content-Type:"application/json",
  Accept:"application/json",
  MY-CUSTOM-HEADER:"9d212fbc-4a2b-4646-a168-c60b8442ef89",
  MY-REQUEST-TIMESTAMP:"2023-09-03T12:54:56.583565800"]
```

## HTTP Service Interface Example

The following is an example of HTTP interface that interacts with https://jsonplaceholder.typicode.com/users/
endpoint and performs various operations.

```java
import com.howtodoinjava.app.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@HttpExchange(url = "/users", accept = "application/json", contentType = "application/json")
public interface UserClient {
  @GetExchange("/")
  Flux<User> getAll();

  @GetExchange("/{id}")
  Mono<User> getById(@PathVariable("id") Long id);

  @PostExchange("/")
  Mono<ResponseEntity<Void>> save(@RequestBody User user);

  @PutExchange("/{id}")
  Mono<ResponseEntity<Void>> update(@PathVariable Long id, @RequestBody User user);

  @DeleteExchange("/{id}")
  Mono<ResponseEntity<Void>> delete(@PathVariable Long id);
}
```

Note that we have created a record of User type to hold the user information.

```java
public record User(Long id, String name, String username, String email) {}
```

Now we can inject the `UserClient` bean into application classes and invoke methods to get the API responses.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {

  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  @Autowired
  UserClient userClient;

  public void performUserOperations() {
    // Get All Users
    userClient.getAll().subscribe(data -> log.info("User: {}", data));

    // Get User By Id
    userClient.getById(1L).subscribe(data -> log.info("User: {}", data));

    // Create a New User
    userClient.save(new User(null, "Seth", "Chen", "admin@email.com"))
      .subscribe(data -> log.info("User: {}", data));

    // Delete User By Id
    userClient.delete(1L).subscribe(data -> log.info("User: {}", data));
  }
}
```
