# Table of Contents

- [Table of Contents](#table-of-contents)
- [Official Docs](#official-docs)
  - [Maven](#maven)
  - [Spring Framework](#spring-framework)
  - [Spring Boot](#spring-boot)
  - [Spring HTTP Package (under Spring Framework)](#spring-http-package-under-spring-framework)
  - [Spring WebFlux](#spring-webflux)
  - [Spring Test](#spring-test)
  - [Spring Security](#spring-security)
  - [SpringDoc](#springdoc)
  - [Jackson](#jackson)
  - [Lombok](#lombok)
  - [JUnit5](#junit5)
  - [Mockito](#mockito)
  - [MockWebServer](#mockwebserver)
  - [Reactive Streams](#reactive-streams)
  - [Project Reactor](#project-reactor)
  - [Netty](#netty)
- [Reactive](#reactive)
  - [What is Reactive Processing](#what-is-reactive-processing)
  - [Why use Reactive Processing](#why-use-reactive-processing)
- [Reactive Programming](#reactive-programming)
  - [Reactive Programming - Baeldung](#reactive-programming---baeldung)
    - [Origins of Reactive Programming](#origins-of-reactive-programming)
    - [Reactive Programming Frameworks](#reactive-programming-frameworks)
    - [Observer Pattern](#observer-pattern)
    - [Reactive Streams Operators](#reactive-streams-operators)
  - [Reactive Programming - Simform Engineering](#reactive-programming---simform-engineering)
    - [What is Reactive Programming](#what-is-reactive-programming)
    - [Why Reactive Programming](#why-reactive-programming)
    - [Components of Reactive Programming](#components-of-reactive-programming)
    - [Spring Web Flux](#spring-web-flux)
    - [Example Project](#example-project)
      - [Dependencies in `pom.xml`](#dependencies-in-pomxml)
      - [Properties](#properties)
      - [Entity RestController, Service, Repository](#entity-restcontroller-service-repository)
      - [Mapper](#mapper)
      - [Curl/Postman](#curlpostman)
    - [Backpressure](#backpressure)
  - [Reactive Programming - Java Brains](#reactive-programming---java-brains)
    - [What is Reactive Programming](#what-is-reactive-programming-1)
    - [Why Reactive Programming](#why-reactive-programming-1)
    - [Async](#async)
  - [Reactive Programming - Java Techie](#reactive-programming---java-techie)
    - [Sending HTTP Requests/Calling REST API using Webclient in Spring Boot](#sending-http-requestscalling-rest-api-using-webclient-in-spring-boot)
- [Project Reactor](#project-reactor-1)
  - [Reactor Core - Baeldung](#reactor-core---baeldung)
    - [Reactive Streams](#reactive-streams-1)
    - [Maven Dependencies](#maven-dependencies)
    - [Producing a Stream of Data](#producing-a-stream-of-data)
      - [`Mono`](#mono)
      - [`Flux`](#flux)
    - [Subscribing to a Stream](#subscribing-to-a-stream)
      - [Collecting Elements](#collecting-elements)
    - [Comparison to Java 8 Streams](#comparison-to-java-8-streams)
    - [Backpressure](#backpressure-1)
    - [Operating on a Stream](#operating-on-a-stream)
      - [Mapping Data in a Stream](#mapping-data-in-a-stream)
      - [Combining Two Streams](#combining-two-streams)
    - [Hot Streams](#hot-streams)
      - [Connectable Flux](#connectable-flux)
      - [Throttling](#throttling)
    - [Concurrency](#concurrency)
  - [Reactive Spring Boot + Project Reactor - Bubu Tripathy](#reactive-spring-boot--project-reactor---bubu-tripathy)
    - [Project Setup](#project-setup)
    - [Define Reactive Endpoints](#define-reactive-endpoints)
    - [Operators](#operators)
      - [`.map()` Operator](#map-operator)
    - [`.filter()` Operator](#filter-operator)
      - [`.flatMap()` Operator](#flatmap-operator)
      - [`.zip()` Operator](#zip-operator)
      - [`.merge()` and `.concat()` Operators](#merge-and-concat-operators)
      - [Chaining Operators](#chaining-operators)
      - [Composing Operators](#composing-operators)
    - [Error Handling](#error-handling)
      - [Error Handling Strategies](#error-handling-strategies)
      - [Example](#example)
      - [Testing Error Scenarios](#testing-error-scenarios)
    - [Testing Reactive Endpoints](#testing-reactive-endpoints)
      - [Set Up Testing Environment](#set-up-testing-environment)
      - [Write Test Methods](#write-test-methods)
      - [Test Error Scenarios](#test-error-scenarios)
    - [Mono + Flux Deep Dive](#mono--flux-deep-dive)
      - [Mono: Handling One or Zero Elements](#mono-handling-one-or-zero-elements)
      - [Flux: Handling Multiple Elements](#flux-handling-multiple-elements)
      - [Subscribing to Mono and Flux](#subscribing-to-mono-and-flux)
      - [Transforming Elements](#transforming-elements)
      - [Combining Streams](#combining-streams)
      - [Handling Empty Streams](#handling-empty-streams)
    - [Combining Publishers](#combining-publishers)
      - [Concatenating Publishers](#concatenating-publishers)
      - [Merging Publishers](#merging-publishers)
      - [Zip Publishers](#zip-publishers)
      - [Combining Latest Values](#combining-latest-values)
      - [Using FlatMap for Dynamic Publishers](#using-flatmap-for-dynamic-publishers)
      - [Handling Errors with Combining Operators](#handling-errors-with-combining-operators)
    - [Backpressure](#backpressure-2)
      - [Backpressure Handling Strategies](#backpressure-handling-strategies)
      - [Implementing Backpressure](#implementing-backpressure)
      - [Mismatches in Producer and Consumer Speeds](#mismatches-in-producer-and-consumer-speeds)
    - [WebClient](#webclient)
      - [Error Handling](#error-handling-1)
- [Spring WebFlux](#spring-webflux-1)
  - [Spring WebFlux: Threading + EventLoops - Stefan Kreidel](#spring-webflux-threading--eventloops---stefan-kreidel)
    - [What it means to be Reactive](#what-it-means-to-be-reactive)
    - [How Threads are used to achieve Reactiveness](#how-threads-are-used-to-achieve-reactiveness)
    - [Netty EventLoop's](#netty-eventloops)
  - [Spring WebFlux Tutorial with CRUD Example - HowToDoInJava](#spring-webflux-tutorial-with-crud-example---howtodoinjava)
    - [Reactive Programming](#reactive-programming-1)
      - [Blocking/Synchronous Request Processing](#blockingsynchronous-request-processing)
      - [Non-Blocking/Asynchronous Request Processing](#non-blockingasynchronous-request-processing)
      - [What is Reactive Programming?](#what-is-reactive-programming-2)
    - [Reactive Streams API](#reactive-streams-api)
      - [`Publisher`](#publisher)
      - [`Subscriber`](#subscriber)
      - [`Subscription`](#subscription)
      - [`Processor`](#processor)
    - [What is Spring WebFlux?](#what-is-spring-webflux)
    - [Spring Boot WebFlux Example](#spring-boot-webflux-example)
      - [Maven](#maven-1)
      - [Configurations](#configurations)
        - [Webflux Configuration](#webflux-configuration)
        - [MongoDB Configuration](#mongodb-configuration)
        - [`application.properties`](#applicationproperties)
      - [REST Controller with CRUD APIs](#rest-controller-with-crud-apis)
      - [Service](#service)
      - [Repository/DAO](#repositorydao)
      - [Model](#model)
      - [Testing with Postman](#testing-with-postman)
- [Spring WebClient](#spring-webclient)
  - [Get Response Body from ClientResponse - via `.retrieve()`](#get-response-body-from-clientresponse---via-retrieve)
  - [Spring WebClient - StackOverflow](#spring-webclient---stackoverflow)
  - [Simultaneous Spring WebClient Calls - Baeldung](#simultaneous-spring-webclient-calls---baeldung)
  - [Spring WebClient Hands-On Examples - HowToDoInJava](#spring-webclient-hands-on-examples---howtodoinjava)
    - [Maven](#maven-2)
    - [Creating a Spring WebClient Instance](#creating-a-spring-webclient-instance)
      - [Using `WebClient.create()`](#using-webclientcreate)
      - [Using `WebClient.Builder` API](#using-webclientbuilder-api)
      - [Using WebClient for Sending Requests and Handling Responses](#using-webclient-for-sending-requests-and-handling-responses)
    - [WebClient `.retrieve()` vs `.exchange()` APIs](#webclient-retrieve-vs-exchange-apis)
      - [`.retrieve()`](#retrieve)
      - [`.exchange()`](#exchange)
    - [Spring WebClient Examples](#spring-webclient-examples)
      - [GET API Example](#get-api-example)
      - [POST API Example](#post-api-example)
      - [PUT API Example](#put-api-example)
      - [DELETE API Example](#delete-api-example)
    - [Advanced Configurations for Spring WebClient](#advanced-configurations-for-spring-webclient)
      - [Configuring Memory Limit](#configuring-memory-limit)
      - [Configuring Connection Timeouts](#configuring-connection-timeouts)
  - [Spring WebClient POST Example - HowToDoInJava](#spring-webclient-post-example---howtodoinjava)
    - [Setting Up WebClient in Spring Boot](#setting-up-webclient-in-spring-boot)
    - [Using WebClient to Call a POST Request and Handle Response](#using-webclient-to-call-a-post-request-and-handle-response)
      - [Remote API returns the Location Header and Empty Response Body](#remote-api-returns-the-location-header-and-empty-response-body)
      - [Remote API returns Success Response with Response Body](#remote-api-returns-success-response-with-response-body)
    - [Using WebClient to Call a POST Request and Pass Response to API Client](#using-webclient-to-call-a-post-request-and-pass-response-to-api-client)
      - [Response with Location Header and Empty Response Body](#response-with-location-header-and-empty-response-body)
      - [Success Response with Response Body](#success-response-with-response-body)
    - [Using WebClient to Submit Form Data](#using-webclient-to-submit-form-data)
    - [Using WebClient to Upload a Multipart File](#using-webclient-to-upload-a-multipart-file)
    - [Sending URL/Query Parameters using WebClient](#sending-urlquery-parameters-using-webclient)
    - [Sending Request Headers using WebClient](#sending-request-headers-using-webclient)
  - [Spring WebClient `Retry` and `RetryWhen` - HowToDoInJava](#spring-webclient-retry-and-retrywhen---howtodoinjava)
    - [What is a Retry? Why do we need it?](#what-is-a-retry-why-do-we-need-it)
    - [Initial Setup](#initial-setup)
      - [Maven](#maven-3)
      - [Application Setup](#application-setup)
      - [Simulating Service Failures using WireMock](#simulating-service-failures-using-wiremock)
    - [Retry Mechanisms with WebClient](#retry-mechanisms-with-webclient)
      - [Default Behavior](#default-behavior)
    - [Retry with Fixed Delay](#retry-with-fixed-delay)
    - [Retry with Exponential Backoff](#retry-with-exponential-backoff)
    - [Adding Randomness with Jitter](#adding-randomness-with-jitter)
    - [Handling Exhausted Retries](#handling-exhausted-retries)
    - [Retry Only for Specific Status Codes](#retry-only-for-specific-status-codes)
    - [Retry with Timeout](#retry-with-timeout)
  - [Spring WebClient Timeout: `Global` vs `Request-Level` - HowToDoInJava](#spring-webclient-timeout-global-vs-request-level---howtodoinjava)
    - [Setting Timeouts Globally](#setting-timeouts-globally)
    - [Setting Timeouts at Request Level](#setting-timeouts-at-request-level)
    - [`.responseTimeout(Duration)` vs `ReadTimeoutHandler(long timeout, TimeUnit unit)` vs `WriteTimeoutHandler(long timeout, TimeUnit unit)`](#responsetimeoutduration-vs-readtimeouthandlerlong-timeout-timeunit-unit-vs-writetimeouthandlerlong-timeout-timeunit-unit)
    - [Handling Timeout Exceptions](#handling-timeout-exceptions)
    - [Summary](#summary)
  - [Spring WebClient - Pushkar Kumar](#spring-webclient---pushkar-kumar)
    - [Implementation of Spring WebClient](#implementation-of-spring-webclient)
      - [Dependency pom.xml](#dependency-pomxml)
      - [Create a Bean for Spring WebClient](#create-a-bean-for-spring-webclient)
      - [Invoking Bean in Project](#invoking-bean-in-project)
  - [Spring WebClient - Java Techie](#spring-webclient---java-techie)

# Official Docs

## Maven

- [Maven - Guide Index](https://maven.apache.org/guides/index.html)
- [Maven - User Index](https://maven.apache.org/users/index.html)
- [Maven - `Pom` Reference](https://maven.apache.org/pom.html)
- [Maven - `Settings` Reference](https://maven.apache.org/settings.html)
- [Maven - `Plugins` Reference](https://maven.apache.org/plugins/index.html)
- [Maven - Glossary](https://maven.apache.org/glossary.html)
- [GitHub CLI - Maven](https://docs.github.com/en/actions/use-cases-and-examples/building-and-testing/building-and-testing-java-with-maven)
- [Maven Repository - Apache](https://mvnrepository.com/)
- [Maven Central Repository - Sonatype](https://central.sonatype.com/)

## Spring Framework

- [`Spring Framework`](https://spring.io/projects/spring-framework)
- [`Spring Framework` - Reference](https://docs.spring.io/spring-framework/reference/index.html)
- [`Spring Framework` - JavaDocs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/)
- [`Spring Framework` - javadoc.io](https://javadoc.io/doc/org.springframework)

## Spring Boot

- [`Spring Boot`](https://spring.io/projects/spring-boot)
- [`Spring Boot` - Reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [`Spring Boot` - JavaDocs](https://docs.spring.io/spring-boot/api/java/index.html)

## Spring HTTP Package (under Spring Framework)

- [`Spring HTTP` - JavaDocs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/package-summary.html)

## Spring WebFlux

- [`Spring WebFlux` - javadoc.io](https://javadoc.io/doc/org.springframework/spring-webflux/latest/index.html)

## Spring Test

- [`Spring Test` - javadoc.io](https://javadoc.io/doc/org.springframework/spring-test/latest/index.html)

## Spring Security

- [`Spring Security`](https://spring.io/projects/spring-security)
- [`Spring Security` - Reference](https://docs.spring.io/spring-security/reference/index.html)
- [`Spring Security` - JavaDocs](https://docs.spring.io/spring-security/site/docs/current/api/)

## SpringDoc

- [`SpringDoc` - javadoc.io](https://javadoc.io/doc/org.springdoc)

## Jackson

- [`jackson-core` - JavaDocs](http://fasterxml.github.io/jackson-core/javadoc/2.5/)
- [`jackson-core` - javadoc.io](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-core)
- [`jackson-annotations` - JavaDocs](http://fasterxml.github.io/jackson-databind/javadoc/2.5/)
- [`jackson-annotations` - javadoc.io](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-annotations)
- [`jackson-databind` - JavaDocs](http://fasterxml.github.io/jackson-annotations/javadoc/2.5/)
- [`jackson-databind` - javadoc.io](https://javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind)

## Lombok

- [`Lombok` - ProjectLombok](https://projectlombok.org/features/)
- [`Lombok` - javadoc.io](https://javadoc.io/doc/org.projectlombok/lombok)

## JUnit5

- [`JUnit5` - Reference](https://junit.org/junit5/docs/current/user-guide/)
- [`JUnit5` - JavaDocs](https://junit.org/junit5/docs/current/api/)
- [`JUnit5` - javadoc.io](https://javadoc.io/doc/org.junit.jupiter/junit-jupiter-api/latest/index.html)

## Mockito

- [`Mockito` - JavaDocs](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [`MockitoAnnotations` - JavaDocs](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/MockitoAnnotations.html)
- [Mockito User Guide - GoogleDocs](https://docs.google.com/document/d/15mJ2Qrldx-J14ubTEnBj7nYN2FB8ap7xOn8GRAi24_A/edit)

## MockWebServer

- [`MockWebServer` - JavaDocs](https://square.github.io/okhttp/3.x/mockwebserver/index.html?okhttp3/mockwebserver/MockWebServer.html)
- [`MockWebServer` - javadoc.io](https://www.javadoc.io/doc/com.squareup.okhttp3/mockwebserver/3.14.9/overview-summary.html)

## Reactive Streams

- [`Reactive Streams` - JavaDocs](https://www.reactive-streams.org/reactive-streams-1.0.4-javadoc/org/reactivestreams/package-summary.html)

## Project Reactor

- [Project Reactor](https://projectreactor.io/docs)
- [Project Reactor - `Core` - Reference](https://projectreactor.io/docs/core/release/reference/)
- [Project Reactor - `Core` - JavaDocs](https://projectreactor.io/docs/core/release/api/)
- [Project Reactor - `Core` - javadoc.io](https://javadoc.io/doc/io.projectreactor/reactor-core/latest/index.html)
- [Project Reactor - `Test` - Reference](https://projectreactor.io/docs/core/release/reference/index.html#testing)
- [Project Reactor - `Test` - JavaDocs](https://projectreactor.io/docs/test/release/api/)
- [Project Reactor - `Test` - javadoc.io](https://javadoc.io/doc/io.projectreactor/reactor-test/latest/index.html)
- [Project Reactor - `Extra` - JavaDocs](https://projectreactor.io/docs/extra/release/api/)
- [Project Reactor - `Netty` - Reference](https://projectreactor.io/docs/netty/release/reference/index.html)
- [Project Reactor - `Netty` - JavaDocs](https://projectreactor.io/docs/netty/release/api/)
- [Project Reactor - `Tools` - javadoc.io](https://javadoc.io/doc/io.projectreactor/reactor-tools/latest/index.html)
- [Project Reactor - `StepVerifier` - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.html)
- [Project Reactor - `StepVerifier` - javadoc.io](https://javadoc.io/doc/io.projectreactor/reactor-test/latest/index.html)
- [Project Reactor - `StepVerifier.Assertions` - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.Assertions.html)
- [Project Reactor - `StepVerifier.ContextExpectations` - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.ContextExpectations.html)
- [Project Reactor - `StepVerifier.FirstStep` - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.FirstStep.html)
- [Project Reactor - `StepVerifier.LastStep` - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.LastStep.html)
- [Project Reactor - `StepVerifier.Step` - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.Step.html)

## Netty

Note: Netty 5.X is abandoned

- [`Netty 4` - User Guide](https://netty.io/wiki/user-guide-for-4.x.html)
- [`Netty 4.1` - JavaDocs](https://netty.io/4.1/api/index.html)

# Reactive

## What is Reactive Processing

> Reactive Processing = A paradigm that enables developers build non-blocking, asynchronous applications that can handle back-pressure (flow control)

## Why use Reactive Processing

> Reactive systems better utilize modern processors. Also, the inclusion of back-pressure in reactive programming ensures better resilience between decoupled components

# Reactive Programming

## Reactive Programming - Baeldung

> Reactive programming is a declarative programming paradigm that is based on the idea of asynchronous event processing and data streams
>
> Asynchronous processing means that the processing of an event does NOT block the processing of other events

- [Reactive Programming - Baeldung](https://www.baeldung.com/cs/reactive-programming)

### Origins of Reactive Programming

- In the first GUI applications, the user interface was updated only after some user action, like clicking a button

  - The heart of the application was a so-called event loop
  - It was an endless loop and was responsible for handling user input and updating the user interface
  - But as the program was waiting synchronously (i.e., blocking) for the user input, nothing else could happen
  - And waiting synchronously for an event that doesn't come means that the whole application hangs and the
    GUI becomes unresponsive

- The solution is to decouple the event handling from the GUI update

  - **The decoupling is done by introducing an event queue and parallel event processing (known as the producer and consumer pattern)**
  - A thread handling user input puts events into the queue, and a consumer thread takes events from the queue's head and processes them
  - The consumer thread may also act as a producer by putting GUI update requests into a queue processed by a GUI update thread. Such producer/consumer chaining then leads to reactive streams

- Today, the reactive programming paradigm has also spread to cloud applications
  - Cloud-based services are often implemented as a set of microservices
  - **These are small components that are loosely coupled and communicate with each other via asynchronous message passing**
  - The reactive programming paradigm is a perfect fit for such microservices

### Reactive Programming Frameworks

[Reactive Streams](https://www.reactive-streams.org/) is an initiative to standardise the reactive streams API

- It defines a set of rules for asynchronous stream processing with non-blocking back pressure

### Observer Pattern

- Reactive systems make use of asynchronous communication

  - In contrast to a synchronous procedure call, where parameters are passed to the procedure, and the program flow doesn't continue until the procedure returns the result, the caller doesn't wait for the result in asynchronous communication. -
  - Instead, the caller registers a callback procedure that is called when the result is available
  - The caller can continue his work, and the callback procedure is called when the result is available
  - I.e. **The caller passes to the asynchronous procedure of "what should happen in the future when the result is available"**

- Moreover, the caller can register multiple callback procedures

  - This is useful when the caller wants to be notified about the result of the asynchronous procedure but also when the asynchronous procedure fails
  - **In this case, the caller can register two callback procedures, one for the success case and one for the failure case**
  - And lastly, the caller itself may be a callee, perform some processing on the result and pass it back to the caller

- **The callback pattern is usually implemented in object-oriented programming (OOP) using the "Observer Pattern"**
  - In the Observer Pattern:
    - **`Observable` = The return value of the asynchronous procedure call**
    - **`Observer` = The callback procedure**

![](https://www.baeldung.com/wp-content/uploads/sites/4/2023/02/rx_pattern.png)

### Reactive Streams Operators

- In reactive applications, handling simply one event doesn't do the job

  - Instead, the application has to handle a stream of reactive events
  - **The `Observable` is not just a single event but an event stream**
  - **The `Observer` then has to provide "callbacks" for success + failure + the end of the stream**

- Reactive streams may also differ in how the stream flow is controlled
  1. **PUSH approach**: The consumer doesn't know exactly when a new event is emitted
     - The consumer may easily be overwhelmed by the stream of events and is able to control the stream flow via **back pressure**
  2. **PULL approach**: The consumer explicitly decides when to get the next event from the stream

## Reactive Programming - Simform Engineering

> Reactive programming is an approach to handling asynchronous and event-based programming and is well-suited for real-time data-intensive applications

- [Reactive Programming - Simform Engineering](https://medium.com/simform-engineering/deep-dive-into-reactive-programming-with-spring-boot-d62cae63bb03)

### What is Reactive Programming

> Reactive programming is about non-blocking applications that are asynchronous and event-driven and require a small number of threads to scale

Reactive programming is a design approach that uses asynchronous programming logic to handle real-time adjustments

The core of reactive programming is a data stream that we can observe and react to, even apply back pressure as well

### Why Reactive Programming

> Reactive Programming allows applications/servers to handle multiple concurrent or simultaneous requests asynchronously, and be non-blocking hence improving performance, increasing scalability, and handling high-user traffic

Modern applications today require the ability to handle multiple concurrent or simultaneous requests

- Concurrent = Separate overlapping activities without a direct connection
- Simultaneous = Connected events happening at the precise same moment

### Components of Reactive Programming

![](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*h7CWDPpUG7XeVM70_uZWHQ.jpeg)

The `Publisher` creates an event or message for every result obtained
The `Publisher` can:

- Send the `Subscriber` (n) numbers of values by calling `.onNext()`
- Signal an error by calling `.onError()`, which can terminate the sequence
- Terminate the sequence by default if `.onComplete()` is called

In Reactor: `Flux` and `Mono`, there are two primary primitive publishers

Flux = A Flux Publisher publishes `0..N` data/event and can produce from `0..N` values asynchronously

Mono = A Mono Publisher publishes only `0..1` data/event

### Spring Web Flux

- Spring Web Flux is a reactive programming model introduced by Pivotal in Spring 5
- It provides an asynchronous, non-blocking, and event-driven architecture for building web applications that are resilient and responsive
- The framework is based on the Reactive Streams specification and provides support for both client-side and server-side development

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-webflux -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
    <version>3.3.1</version>
</dependency>
```

### Example Project

#### Dependencies in `pom.xml`

pom.xml

```xml
<dependencies>
  <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-webflux</artifactId>
  </dependency>
  <dependency>
     <groupId>org.projectlombok</groupId>
     <artifactId>lombok</artifactId>
     <optional>true</optional>
  </dependency>
  <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-data-mongodb-reactive</artifactId>
  </dependency>
  <dependency>
     <groupId>org.mapstruct</groupId>
     <artifactId>mapstruct</artifactId>
     <version>1.5.5.Final</version>
  </dependency>
  <dependency>
     <groupId>org.mapstruct</groupId>
     <artifactId>mapstruct-processor</artifactId>
     <version>1.5.5.Final</version>
  </dependency>
</dependencies>
```

#### Properties

```yml
spring:
  data:
    mongodb:
      authentication-database: admin
      database: demo_db
      host: localhost
      password: root
      port: 27017
      username: root
```

#### Entity RestController, Service, Repository

```java
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "user")
public class User {
  @Id
  private String id;
  private String name;
  private String email;
  private String phone;
  private String address;
  private String city;
  private String state;
  private String postalCode;
  private Boolean isPreferred;
  private LocalDate birthDate;
}
```

```java
@RestController
@RequestMapping("/api/user")
public class UserController {

  final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public Mono<UserResponse> saveUser(@RequestBody UserRequest request) {
    return userService.saveUser(request);
  }

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<UserResponse> retrieveUsers() {
    return userService.retrieveUsers();
  }
}
```

```java
@Service
public class UserService {
  final UserMapper userMapper;

  final UserRepository userRepository;

  public UserService(UserMapper userMapper, UserRepository userRepository) {
    this.userMapper = userMapper;
    this.userRepository = userRepository;
  }

  public Mono<UserResponse> saveUser(UserRequest request) {
    User user = userMapper.toUser(request);
    Mono<User> customerMono = userRepository.save(user).log();
    return customerMono.map(userMapper::toUserResponse);
  }

  public Flux<UserResponse> retrieveUsers() {
    return userRepository.findAll().log().map(userMapper::toUserResponse);
  }
}
```

```java
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {}
```

#### Mapper

Use Mapper to convert/for the conversion of request to entity and entity back to response

```java
@Mapper(componentModel = "spring")
public interface UserMapper {
  UserResponse toUserResponse(User destination);

  User toUser(UserRequest request);
}
```

#### Curl/Postman

```sh
curl --location -X POST 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "John Doe",
"email": "jd@gmail.com",
"phone": "555-555-5555",
"address": "456 Oak St",
"city": "Chicago",
"state": "IL",
"postalCode": "60601",
"isPreferred": false,
"birthDate": "09/01/1985"
}'
```

![](https://miro.medium.com/v2/resize:fit:4800/format:webp/1*Nkki2_wMHRFg3KkhivsjFA.png)

### Backpressure

> Backpressure = A mechanism that allows the consumer of data to control the rate at which the producer produces data
>
> Backpressure can be implemented using various techniques such as buffering, dropping data, or requesting the producer to slow down
>
> Backpressure ensures that both producers and consumers can operate at their optimal processing rates without causing any bottlenecks or overloading the system

Modify the GET method

```java
@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<UserResponse> retrieveUsers() {
  return userService.retrieveUsers()
    .onBackpressureBuffer(10, BufferOverflowStrategy.DROP_OLDEST)
    .delayElements(Duration.ofMillis(100))
    .log();
}
```

The `onBackpressureBuffer(10, BufferOverflowStrategy.DROP_OLDEST)` operator is then applied to the Flux, which limits the buffer size to 10 elements and uses a buffer overflow strategy of dropping the oldest elements when the buffer becomes full

- This means that if the downstream subscriber cannot keep up with the rate of emissions, the buffer will store up to 10 elements before it starts dropping older elements to make room for newer ones

The `delayElements(Duration.ofMillis(100))` operator is applied to the Flux, which adds a delay of 100 milliseconds before emitting each element

- This means that the `UserResponse` objects emitted by the Flux will be spaced out by at least 100 milliseconds, which can help control the rate of emissions and prevent backpressure issues

To mock this situation and test the backpressure and delay of elements, you can create a test and use a mocking framework like Mockito to create a mock implementation of `userService.retrieveUsers()`

- You can then use the `StepVerifier` class from Reactor to subscribe to the Flux returned by `retrieveUsers()` and verify that the backpressure and delay are working as expected

```java
package com.demo.user;

import com.demo.user.controller.UserController;
import com.demo.user.model.response.UserResponse;
import com.demo.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

  @Mock
  private UserService userService;

  @InjectMocks
  private UserController controller;

  @Test
  void testRetrieveUsersBackpressureAndDelay() {
    // Create a mock Flux of UserResponse objects with 1000 elements
    // Not considering other values like address, email etc for test case
    Flux<UserResponse> mockFlux = Flux.range(1, 1000).map(i -> UserResponse.builder().id(String.valueOf(i)).build());
    // When the retrieveUsers method is called on the userService mock, return the mockFlux we created above
    when(userService.retrieveUsers()).thenReturn(mockFlux);
    // Subscribe to the Flux returned by the controller's retrieveUsers method
    Flux<UserResponse> result = controller.retrieveUsers();
    // Verify that the backpressure and delay are working as expected
    StepVerifier.create(result)
      .expectSubscription()
      .thenRequest(5) // Request the first 5 elements
      .expectNextCount(5) // Expect to receive 5 elements
      .thenAwait(Duration.ofMillis(100)) // Wait for 100ms before requesting more elements
      .thenRequest(5) // Request the next 5 elements
      .expectNextCount(5) // Expect to receive 5 more elements
      .thenCancel()
      .verify();
  }

  @Test
  void testRetrieveUsers_BufferOverflow() {
    // Given
    int numUsers = 100;
    when(userService.retrieveUsers())
      .thenReturn(Flux.range(1, numUsers).map(i -> UserResponse.builder().id(String.valueOf(i)).name("User " + i).build()));
    // When
    Flux<UserResponse> userResponseFlux = controller.retrieveUsers();
    // Then
    StepVerifier.create(userResponseFlux)
      .expectSubscription()
      .expectNextCount(10) // With a backpressure buffer size of 10, we expect to receive the first 10 users
      .thenAwait(Duration.ofMillis(1000)) // Wait for the buffer to overflow
      .expectNextCount(0) // We should not receive any more users after the buffer overflows
      .thenCancel()
      .verify();
  }
}
```

Test 1: `testRetrieveUsersBackpressureAndDelay()`

- Mocks a Flux of UserResponse objects with 1000 elements
- Sets up the UserService mock to return the above-created Flux when retrieveUsers() method is called
- Calls the controller's retrieveUsers() method
- Uses StepVerifier to verify that backpressure and delay are working as expected by requesting the first 5 elements waiting for 100ms, then requesting the next 5 elements and canceling after that

Test 2: `testRetrieveUsers_BufferOverflow()`

- Given 100 users, sets up the UserService mock to return a Flux of UserResponse objects containing these users
- Calls the controller's retrieveUsers() method
- Uses StepVerifier to verify that as the buffer size is set to 10 only the first 10 users will be received. After waiting for the buffer to overflow for 1 second, no more users are expected

## Reactive Programming - Java Brains

- [Java Brains - Java Reactive Programming Playlist](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTYPR2oH7kgElMYZhJd4vOGI)
  - [Java Brains - GitHub](https://github.com/koushikkothagal/reactive-java-workshop)

### What is Reactive Programming

> Reactive programming = a declarative programming paradigm concerned with data streams and the propagation of change
>
> With this paradigm, it is possible to express static (e.g. arrays) or dynamic (e.g. event emitters) data streams with ease, and also communicate that an inferred dependency within the associated execution model exists, which facilitates the automatic propagation of the changed data flow

Traditional Use Cases:

- User Events
  - When the user clicks a button
  - When I/O response happens
  - React to Something: When user clicks this button, run this function

### Why Reactive Programming

- Code workflow
  - Single request
  - Multiple simulatenous user services abstracted out (e.g. `getUser`, `getUserPrefs`)
  - Multiple calls to user services and delays abstracted out
  - Cost: Sequential blocking operations
  - Cost: Idling threads

### Async

- `Future` interface, `CompletableFuture` Class
  - Works with `CompletionStage` to coordinate async operations

```java
CompletableFuture<User> userAsync = CompletableFuture.supplyAsync(() -> userService.getUser(userId));
```

Using `CompletableFuture`

- Call userService
- Call userProfileService in parallel
- When both return, merge the data structures
- Return merged object

```java
CompletableFuture<User> userAsync = CompletableFuture.supplyAsync(() -> userService.getUser(userId));
CompletableFuture<User> userPrefAsync = CompletableFuture.supplyAsync(() -> userPrefService.getUserPref(userId));
CompletableFuture<Void> bothFutures = CompletableFuture.allOf(userAsync, userPrefAsync);
bothFutures.join();
```

## Reactive Programming - Java Techie

- [Java Techie - Spring Reactive Playlist](https://www.youtube.com/playlist?list=PLVz2XdJiJQxyB4Sy29sAnU3Eqz0pvGCkD)
- [Java Techie - Spring Boot Playlist](https://www.youtube.com/playlist?list=PLVz2XdJiJQxw-jVLpBfVn2yqjvA1Ycceq)

### Sending HTTP Requests/Calling REST API using Webclient in Spring Boot

- Webclient
- Mono = Single Object or Empty Value
- Flux = List of Objects or Empty Value
- .block() == Converts returned `Mono<T>`/`Flux<T>` to `T`

https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html
https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
    <!-- <version>3.1.2</version> -->
</dependency>
```

https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/WebClient.html

- Resources
  - [Random Code - How to Call a REST API using WebClient in Spring Boot](https://www.youtube.com/watch?v=RHZgllzbjVQ)
    - [Random Code - Spring Boot Playlist](https://www.youtube.com/playlist?list=PLrzWQu7Ajpi3GrvRZWrua3XheTnObqJfS)
    - [Random Code - Project Lombok Playlist](https://www.youtube.com/playlist?list=PLrzWQu7Ajpi1WDRIWDS6f4HqHyBE7ISYO)
  - [Devtiro - Reactive REST API Calls in Spring Boot: How to Use the Reactive Web Client](https://www.youtube.com/watch?v=SN2ApMA-CGk)
    - [Devtiro - spring-boot-reactive-web-client-tutorial Repo](https://github.com/devtiro/spring-boot-reactive-web-client-tutorial)
    - [Devitiro - GitHub](https://github.com/orgs/devtiro/repositories)
  - [Java Techie - Consume Rest service using Spring 5 WebClient (Reactive programming)](https://www.youtube.com/watch?v=eyN9H_EA7tI&list=PLVz2XdJiJQxw-jVLpBfVn2yqjvA1Ycceq)

# Project Reactor

> Project Reactor is a fully non-blocking foundation with back-pressure support included
>
> It's the foundation of the reactive stack in the Spring ecosystem and is featured in projects such as Spring WebFlux, Spring Data, and Spring Cloud Gateway

Resources

- [Project Reactor](https://projectreactor.io/)
- [Project Reactor - Learn](https://projectreactor.io/learn)
- [Project Reactor - Docs](https://projectreactor.io/docs)
  - [reactor-core](https://projectreactor.io/docs/core/release/api/)
  - [reactor-test](https://projectreactor.io/docs/test/release/api/)
  - [`Flux`](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html)
  - [`Mono`](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html)
  - [`WebClient`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/WebClient.html)
  - [`ClientResponse`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/ClientResponse.html)
- [Project Reactor - Reference](https://projectreactor.io/docs/core/release/reference/)
- [Baeldung - Intro to Reactor Core](https://www.baeldung.com/reactor-core)

## Reactor Core - Baeldung

> Reactor Core is a Java 8 library that implements the [reactive programming model](https://www.baeldung.com/cs/reactive-programming)
>
> It's built on top of the [Reactive Streams specification](http://www.reactive-streams.org/), a standard for building reactive applications

- [Baeldung - Intro to Reactor Core](https://www.baeldung.com/reactor-core)

### Reactive Streams

> Reactor Core implements the [Reactive Streams specification](http://www.reactive-streams.org/)
>
> Reactive Streams = A specification for asynchronous stream processing

A key part of asynchronous stream processing is **"back pressure"**

- Back Pressure = Allows consumer to control producer's flow of event streams

### Maven Dependencies

```xml
<dependency>
    <groupId>io.projectreactor</groupId>
    <artifactId>reactor-core</artifactId>
    <version>3.6.7</version>
</dependency>

<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.5.6</version>
</dependency>
```

### Producing a Stream of Data

> In order for an application to be reactive, the first thing it must be able to do is to produce a stream of events/data

- This could be something like the stock update example that we gave earlier
  - Without this data, we wouldn't have anything to react to
- Reactive Core gives us two data types that enable us to do this
  1. `Flux`
  2. `Mono`
- Note: Both `Flux` and `Mono` are implementations of the [Reactive Streams Publisher interface](http://www.reactive-streams.org/reactive-streams-1.0.4-javadoc/org/reactivestreams/Publisher.html)

#### `Mono`

> `Mono` = A stream of `0..1` elements

```java
Mono<Integer> just = Mono.just(1);
```

#### `Flux`

> `Flux` = A stream of `0..N` elements

```java
Flux<Integer> nums = Flux.just(1, 2, 3, 4);
```

### Subscribing to a Stream

> We need to SUBSCRIBE to a stream in order for it to EMIT events/data

#### Collecting Elements

Use the `.subscribe()` method to collect all the elements in a stream:

```java
List<Integer> elements = new ArrayList<>();

Flux.just(1, 2, 3, 4)
  .log()
  .subscribe(elements::add);

assertThat(elements).containsExactly(1, 2, 3, 4);
```

We also added some logging to visualize how the data is flowing through the stream

```log
20:25:19.550 [main] INFO  reactor.Flux.Array.1 - | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | request(unbounded)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onNext(1)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onNext(2)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onNext(3)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onNext(4)
20:25:19.553 [main] INFO  reactor.Flux.Array.1 - | onComplete()
```

- First of all, everything is running on the main thread
- Now let's go through the sequence that we have logged one by one:
  - `onSubscribe()`: This is called when we subscribe to the stream
  - `request(unbounded)`: When we call `.subscribe()`, behind the scenes we are creating a `Subscription`
    - This `Subscription` requests elements from the stream
    - In this case, it defaults to `unbounded`, meaning it requests every single element available
  - `onNext()`: This is called on every single element
  - `onComplete()`: This is called LAST, after receiving the last element. There's actually an onError() as well, which would be called if there is an exception, but in this case, there isn't
- This is the flow laid out in the `Subscriber` interface as part of the Reactive Streams Specification, and in reality, that's what's been instantiated behind the scenes in the call to onSubscribe()

To better understand what's happening let's provide a Subscriber interface directly:

- We can see that each possible stage in the below code flow maps to a method in the `Subscriber` implementation
- It just happens that `Flux` has provided us with a helper method to reduce this verbosity

```java
Flux.just(1, 2, 3, 4)
  .log()
  .subscribe(new Subscriber<Integer>() {
    @Override
    public void onSubscribe(Subscription s) {
      s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Integer integer) {
      elements.add(integer);
    }

    @Override
    public void onError(Throwable t) {}

    @Override
    public void onComplete() {}
});
```

### Comparison to Java 8 Streams

It still might appear that we have something synonymous to a Java 8 Stream doing `.collect()`:

```java
List<Integer> collected = Stream.of(1, 2, 3, 4).collect(toList());
```

Except we do NOT

> The core difference is that Reactive is a PUSH model, whereas the Java 8 Streams are a PULL model

- In a reactive approach, events are pushed to the subscribers as they come in
- The next thing to notice is a `Streams` terminal operator is just that, terminal, pulling all the data and returning a result
- With `Reactive` we could have an infinite stream coming in from an external resource, with multiple subscribers attached and removed on an ad hoc basis
  - We can also do things like combine streams, throttle streams, and apply backpressure

### Backpressure

> Backpressure = When a downstream consumer can tell an upstream producer to send it less data in order to prevent it from being overwhelmed

- In the example, the subscriber is telling the producer to push every single element at once
  - This could end up becoming overwhelming for the subscriber, consuming all of its resources
- We can modify the `Subscriber` implementation to apply backpressure
  - Let's tell the upstream to only send two elements at a time by using `.request()`:

```java
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

Flux.just(1, 2, 3, 4)
  .log()
  .subscribe(new Subscriber<Integer>() {
    private Subscription s;
    int numProcessed;

    @Override
    public void onSubscribe(Subscription s) {
      this.s = s;
      s.request(2);
    }

    @Override
    public void onNext(Integer integer) {
      elements.add(integer);
      numProcessed++;
      // Process 2 elements at once and only request more once existing 2 have been processed
      if (numProcessed % 2 == 0) {
        s.request(2);
      }
    }

    @Override
    public void onError(Throwable t) {}

    @Override
    public void onComplete() {}
});
```

Now if we run the code again, we'll see the `request(2)` is called, followed by two `onNext()` calls, then `request(2)` again

```log
23:31:15.395 [main] INFO  reactor.Flux.Array.1 - | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
23:31:15.397 [main] INFO  reactor.Flux.Array.1 - | request(2)
23:31:15.397 [main] INFO  reactor.Flux.Array.1 - | onNext(1)
23:31:15.398 [main] INFO  reactor.Flux.Array.1 - | onNext(2)
23:31:15.398 [main] INFO  reactor.Flux.Array.1 - | request(2)
23:31:15.398 [main] INFO  reactor.Flux.Array.1 - | onNext(3)
23:31:15.398 [main] INFO  reactor.Flux.Array.1 - | onNext(4)
23:31:15.398 [main] INFO  reactor.Flux.Array.1 - | request(2)
23:31:15.398 [main] INFO  reactor.Flux.Array.1 - | onComplete()
```

### Operating on a Stream

#### Mapping Data in a Stream

Example: Double all the numbers in the stream via a transformation

Note: `map()` will be applied when `onNext()` is called

```java
Flux.just(1, 2, 3, 4)
  .log()
  .map(i -> {
    LOGGER.debug("{}:{}", i, Thread.currentThread());
    return i * 2;
  })
  .subscribe(elements::add);
```

#### Combining Two Streams

There are two Flux streams

1. Stream of doubled values
2. Stream of indicies

```java
Flux.just(1, 2, 3, 4)
  .log()
  .map(i -> i * 2)
  .zipWith(Flux.range(0, Integer.MAX_VALUE),
    (a, b) -> String.format("First Flux: %d, Second Flux: %d", a, b))
  .subscribe(elements::add);

assertThat(elements).containsExactly(
  "First Flux: 2, Second Flux: 0",
  "First Flux: 4, Second Flux: 1",
  "First Flux: 6, Second Flux: 2",
  "First Flux: 8, Second Flux: 3"
);
```

Note: We have one subscription per Flux

- The `.onNext()` calls are also alternated, so the index of each element in the stream will match when we apply the `zipWith()` function

```log
20:04:38.064 [main] INFO  reactor.Flux.Array.1 - | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
20:04:38.065 [main] INFO  reactor.Flux.Array.1 - | onNext(1)
20:04:38.066 [main] INFO  reactor.Flux.Range.2 - | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
20:04:38.066 [main] INFO  reactor.Flux.Range.2 - | onNext(0)
20:04:38.067 [main] INFO  reactor.Flux.Array.1 - | onNext(2)
20:04:38.067 [main] INFO  reactor.Flux.Range.2 - | onNext(1)
20:04:38.067 [main] INFO  reactor.Flux.Array.1 - | onNext(3)
20:04:38.067 [main] INFO  reactor.Flux.Range.2 - | onNext(2)
20:04:38.067 [main] INFO  reactor.Flux.Array.1 - | onNext(4)
20:04:38.067 [main] INFO  reactor.Flux.Range.2 - | onNext(3)
20:04:38.067 [main] INFO  reactor.Flux.Array.1 - | onComplete()
20:04:38.067 [main] INFO  reactor.Flux.Array.1 - | cancel()
20:04:38.067 [main] INFO  reactor.Flux.Range.2 - | cancel()
```

### Hot Streams

> Cold Streams = Static, fixed-length streams
>
> Hot Streams = Real-time infinitely running streams

#### Connectable Flux

One way to create a hot stream is by converting a cold stream into one

Let's create a Flux that lasts forever, outputting the results to the console,
which would simulate an infinite stream of data coming from an external resource:

```java
ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
    while(true) {
      fluxSink.next(System.currentTimeMillis());
    }
  })
  .publish();
```

By calling `.publish()` we are given a `ConnectableFlux`

This means that calling `.subscribe()` will NOT cause it to start emitting, allowing us to add multiple subscriptions:

```java
// .subscribe() does NOT invoke/start the Flux
publish.subscribe(System.out::println);
publish.subscribe(System.out::println);
```

**The Flux only starts emitting when we call `.connect()`**

```java
publish.connect();
```

#### Throttling

In the example above, the console will be overwhelmed with logging

- This is simulating a situation where too much data is being passed to the consumers

We use the `.sample()` method with an interval of two seconds

Now values will only be pushed to the subscriber every two seconds

```java
ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
    while (true) {
      fluxSink.next(System.currentTimeMillis());
    }
  })
  .sample(ofSeconds(2))
  .publish();
```

### Concurrency

All of the above examples have currently run on the `main` thread

However, we can control which thread the code runs on if we want

The `Scheduler` interface provides an abstraction around asynchronous code, for which many implementations are provided for us

Let's try subscribing to a different thread to `main`:

```java
Flux.just(1, 2, 3, 4)
  .log()
  .map(i -> i * 2)
  .subscribeOn(Schedulers.parallel())
  .subscribe(elements::add);
```

The Parallel scheduler will cause the subscription to be run on a different thread, which we can prove by looking at the logs

We see the first entry comes from the main thread and the Flux is running in another thread called `parallel-1`

```log
20:03:27.505 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
20:03:27.529 [parallel-1] INFO  reactor.Flux.Array.1 - | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
20:03:27.531 [parallel-1] INFO  reactor.Flux.Array.1 - | request(unbounded)
20:03:27.531 [parallel-1] INFO  reactor.Flux.Array.1 - | onNext(1)
20:03:27.531 [parallel-1] INFO  reactor.Flux.Array.1 - | onNext(2)
20:03:27.531 [parallel-1] INFO  reactor.Flux.Array.1 - | onNext(3)
20:03:27.531 [parallel-1] INFO  reactor.Flux.Array.1 - | onNext(4)
20:03:27.531 [parallel-1] INFO  reactor.Flux.Array.1 - | onComplete()
```

## Reactive Spring Boot + Project Reactor - Bubu Tripathy

- [Reactive Spring Boot Applications with Project Reactor - Bubu Tripathy](https://medium.com/@bubu.tripathy/reactive-spring-boot-applications-62ec2fcfc05a)

> Reactive programming is an asynchronous programming paradigm that deals with data streams and the propagation of changes
>
> It focuses on composing and transforming streams of data using declarative and functional constructs
>
> Project Reactor is a reactive programming library developed by Pivotal, designed to work with Spring Framework and Spring Boot

Creating Reactive APIs involves designing and implementing endpoints in your Spring Boot
application that use Project Reactor to handle asynchronous and non-blocking operations effectively

These APIs allow you to work with streams of data and handle requests in a reactive, efficient and scalable manner

### Project Setup

[Spring Initializr](https://start.spring.io/)

Add the "Spring Reactive Web" dependency

### Define Reactive Endpoints

> Mono = A stream of at most one element. Used when you expect to return zero or one result

> Flux = A stream of multiple elements. Used when you expect to return a collection or sequence of data

```java
@GetMapping("/users/{id}")
public Mono<ResponseEntity<User>> getUserById(@PathVariable String id) {
  return userService.getUserById(id)
    .map(user -> ResponseEntity.ok(user))
    .defaultIfEmpty(ResponseEntity.notFound().build());
}

@GetMapping("/users")
public Flux<User> getAllUsers() {
  return userService.getAllUsers();
}

@PostMapping("/users")
public Mono<ResponseEntity<User>> createUser(@RequestBody User user) {
  return userService.saveUser(user)
    .map(savedUser -> ResponseEntity.status(HttpStatus.CREATED).body(savedUser));
}
```

### Operators

Using operators like `map`, `filter`, and others allows us to perform various operations
on the data as it flows through the stream, enabling you to create complex transformations and calculations efficiently

#### `.map()` Operator

> The `.map()` operator transforms each element emitted by a reactive stream using a function
>
> It is useful for converting data from one type to another or applying some transformation to each element

```java
Flux<Integer> originalFlux = Flux.just(1, 2, 3);
Flux<String> mappedFlux = originalFlux.map(number -> "Number: " + number);
```

### `.filter()` Operator

> The `.filter()` operator allows you to selectively emit elements from a reactive stream based on a given condition
>
> Useful for implementing data filtering logic

```java
Flux<Integer> numbers = Flux.range(1, 10);
Flux<Integer> evenNumbers = numbers.filter(number -> number % 2 == 0);
```

#### `.flatMap()` Operator

> The `.flatMap()` operator is used to transform each element into a new reactive stream and then flatten the resulting streams into a single stream
>
> Useful for scenarios where each input element corresponds to multiple output elements

```java
Flux<Integer> numbers = Flux.just(1, 2, 3);
Flux<String> letterFlux = numbers.flatMap(number -> Flux.just("A", "B").map(letter -> number + letter));
// ["1A", "1B", "2A", "2B", "3A", "3B"]
```

#### `.zip()` Operator

> The `.zip()` operator combines elements from two or more reactive streams into pairs, tuples, or other custom objects
>
> Useful when we need to process elements from multiple streams together

```java
Flux<Integer> numbers = Flux.just(1, 2, 3);
Flux<String> letters = Flux.just("A", "B", "C");
Flux<String> combined = Flux.zip(numbers, letters, (number, letter) -> number + letter);
// ["1A", "2B", "3C"]
```

#### `.merge()` and `.concat()` Operators

> The `.merge()` operator combines elements from multiple streams into a single stream, interleaving elements as they arrive
>
> The `.concat()` operator, on the other hand, concatenates the streams one after another

```java
Flux<Integer> flux1 = Flux.just(1, 2, 3);
Flux<Integer> flux2 = Flux.just(4, 5, 6);
Flux<Integer> mergedFlux = Flux.merge(flux1, flux2); // interleaved (no consistent/exact order)
Flux<Integer> concatenatedFlux = Flux.concat(flux1, flux2); // in order (always)
```

#### Chaining Operators

Note: The order of chaining matters as it affects how the data flows through the stream

```java
Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
Flux<String> transformedFlux = numbers
  .filter(number -> number % 2 == 0)
  .map(number -> "Even: " + number);
```

#### Composing Operators

```java
// Chaining map, filter, and reduce
Flux<Integer> numbers = Flux.range(1, 5);
Mono<Integer> sumOfEvenSquaredNumbers = numbers
  .filter(number -> number % 2 == 0) // Filter even numbers
  .map(evenNumber -> evenNumber * evenNumber) // Square the even numbers
  .reduce(0, (acc, squaredNumber) -> acc + squaredNumber); // Calculate sum
sumOfEvenSquaredNumbers.subscribe(result -> System.out.println("Sum: " + result));

// Using zip and map together
Flux<Integer> numbers = Flux.range(1, 5);
Flux<String> words = Flux.just("one", "two", "three", "four", "five");
Flux<String> combined = Flux.zip(numbers, words, (number, word) -> number + ": " + word);
combined.subscribe(System.out::println);
// ["1: one", "2: two", "3: three", "4: four", "5: five"]

// Combining flatMap and filter
Flux<String> upperCaseLetters = Flux.just("A", "B", "C");
Flux<String> transformedLetters = upperCaseLetters
  .flatMap(letter -> Flux.just(letter, letter.toLowerCase())) // Transform each letter into upper and lower case
  .filter(transformedLetter -> !transformedLetter.equals("a")); // Filter out lowercase 'a'
transformedLetters.subscribe(System.out::println);
```

### Error Handling

Error Handling Challenges

- Non-Blocking Nature:
  - Reactive programming relies on non-blocking operations, which can lead to errors occurring at different times and potentially being handled on different threads
  - This makes traditional error handling mechanisms, like try-catch blocks, less effective
- Asynchronous Stack Traces:
  - Asynchronous operations can complicate stack traces, making it harder to track down the source of errors and their context
- Multiple Stages:
  - Reactive chains often consist of multiple stages with various transformations and operators
  - Errors could occur at any stage, making it important to handle them at the appropriate level

#### Error Handling Strategies

Project Reactor provides several operators to manage errors effectively within reactive streams:

1. `onErrorResume` and `onErrorReturn`:
   - These operators allow you to provide fallback values or alternative streams in case of an error
   - This can help prevent the entire stream from failing and provide a more graceful degradation
2. `doOnError`
   - This operator lets you execute specific actions when an error occurs, such as logging the error or cleaning up resources
   - It doesn't interfere with the error propagation itself
3. `retry` and `retryWhen`
   - These operators enable you to automatically retry an operation a specified number of times or based on a certain condition
   - This can be helpful for transient errors
4. Global Error Handling
   - Spring WebFlux offers global exception handling through `@ControllerAdvice` and `@ExceptionHandler` annotations, similar to traditional Spring MVC applications

#### Example

Suppose you have a reactive service that fetches user data, and you want to provide a default user if an error occurs:

```java
public Mono<User> getUserById(String id) {
  return userRepository.findById(id)
    .onErrorResume(throwable -> {
      log.error("Error occurred while fetching user by id: {}", id, throwable);
      return Mono.just(new User("default", "Default User"));
    });
}
```

In the example below, the `doOnError` operator is used to log an error message when an error occurs

We then use the `onErrorReturn` operator to provide a fallback value of -1 when an error occurs

```java
import reactor.core.publisher.Flux;

public class DoOnErrorExample {

  public static void main(String[] args) {
    Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5)
      .concatWith(Flux.error(new RuntimeException("Oops! An error occurred.")))
      .map(number -> 10 / (number - 3)) // This will cause an ArithmeticException
      .doOnError(throwable -> System.err.println("Error occurred: " + throwable.getMessage()))
      .onErrorReturn(-1); // Provide a fallback value in case of an error

    numbers.subscribe(
      value -> System.out.println("Received: " + value),
      error -> System.err.println("Subscriber error: " + error.getMessage()));
  }
}
```

#### Testing Error Scenarios

When testing reactive components, ensure you cover error scenarios using `StepVerifier` to verify the behavior of your reactive streams in response to different types of errors

In the example below

- We have three test methods, each demonstrating a different aspect of testing reactive streams
- In the `testFlux` method, we verify that a simple Flux emits the expected elements and completes successfully using expectNext and verifyComplete
- In the `testTransformations` method, we apply transformations using filter and map, and then verify the transformed elements using expectNext and verifyComplete
- In the `testWithError` method, we simulate an error scenario by concatenating an error-producing Flux to an existing Flux. We use expectError to verify that the error is emitted

```java
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class ReactiveStreamTest {

  @Test
  public void testFlux() {
    Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
    StepVerifier.create(numbers)
      .expectNext(1, 2, 3, 4, 5)
      .verifyComplete();
  }

  @Test
  public void testTransformations() {
    Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
    StepVerifier.create(numbers
      .filter(number -> number % 2 == 0)
      .map(evenNumber -> evenNumber * 2))
      .expectNext(4, 8)
      .verifyComplete();
  }

  @Test
  public void testWithError() {
    Flux<Integer> numbers = Flux.just(1, 2, 3)
      .concatWith(Flux.error(new RuntimeException("Oops! An error occurred.")));
    StepVerifier.create(numbers)
      .expectNext(1, 2, 3)
      .expectError(RuntimeException.class)
      .verify();
  }
}
```

### Testing Reactive Endpoints

By using testing frameworks like JUnit and the WebTestClient provided by Spring WebFlux,
we can simulate HTTP requests, verify responses, and cover various scenarios, including success and error cases

#### Set Up Testing Environment

In your test class, annotate it with `@SpringBootTest` to indicate that it's a Spring Boot test

You can also use `@AutoConfigureWebTestClient` to automatically configure the `WebTestClient` for testing

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class UserControllerTest {

  @Autowired
  private WebTestClient webTestClient;

  // Test methods...
}
```

#### Write Test Methods

Create test methods to cover various scenarios of your reactive endpoints

Use the `WebTestClient` to simulate HTTP requests and verify responses

```java
@Test
public void testGetAllUsers() {
  webTestClient.get().uri("/users")
    .exchange()
    .expectStatus().isOk()
    .expectBodyList(User.class);
}

@Test
public void testGetUserById() {
  webTestClient.get().uri("/users/{id}", "user-id")
    .exchange()
    .expectStatus().isOk()
    .expectBody(User.class);
}

@Test
public void testCreateUser() {
  User newUser = new User("new-user-id", "New User");

  webTestClient.post().uri("/users")
    .bodyValue(newUser)
    .exchange()
    .expectStatus().isCreated()
    .expectBody(User.class)
    .isEqualTo(newUser);
}
```

#### Test Error Scenarios

```java
@Test
public void testGetUserById_NotFound() {
  webTestClient.get().uri("/users/nonexistent-id")
    .exchange()
    .expectStatus().isNotFound();
}
```

### Mono + Flux Deep Dive

The Mono and Flux types allow you to represent asynchronous and potentially infinite data streams

#### Mono: Handling One or Zero Elements

A Mono represents a stream that emits at most one element or an error

It's used when you expect either a single result or no result at all

Common use cases include fetching a single resource or performing an operation that results in a single value

```java
Mono<User> userMono = userRepository.findById(userId);
```

#### Flux: Handling Multiple Elements

A Flux represents a stream that emits multiple elements (including zero)

It's used for scenarios where you expect a sequence of values, such as fetching a list of items, streaming data, or processing events

```java
Flux<User> allUsers = userRepository.findAll();
```

#### Subscribing to Mono and Flux

To initiate the processing of elements in a reactive stream, you need to subscribe to the stream

Subscription triggers the execution of asynchronous operations and consumption of emitted values

```java
userMono.subscribe(user -> System.out.println("User: " + user));
allUsers.subscribe(user -> System.out.println("User: " + user));
```

#### Transforming Elements

Project Reactor provides a wide range of operators to manipulate and transform elements within Mono and Flux

Operators like map, filter, flatMap, and zip allow you to modify, filter, and combine elements as they flow through the stream

```java
Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);
Flux<String> squaredStrings = numbers
  .map(number -> number * number)
  .map(squared -> "Squared: " + squared);
```

#### Combining Streams

You can also combine multiple streams using operators like concat, merge, and zip

These operators allow you to create more complex data processing pipelines

```java
Flux<User> users1 = userRepository.findByAgeGreaterThan(18);
Flux<User> users2 = userRepository.findByCountry("USA");
Flux<User> combinedUsers = Flux.concat(users1, users2);
```

#### Handling Empty Streams

Both Mono and Flux can emit an empty stream when there are no elements

You can use operators like `defaultIfEmpty` to provide a fallback value in case of an empty stream

```java
Mono<User> userMono = userRepository.findById(userId)
                                    .defaultIfEmpty(new User("default", "Default User"));
```

### Combining Publishers

> The ability to combine and orchestrate multiple publishers enables developers
> to create intricate and dynamic data flows, perform complex operations,
> and handle scenarios involving multiple sources of data

#### Concatenating Publishers

The concat operator is used to concatenate the emissions from multiple publishers in the order they are provided

This is useful when you want to ensure that the emissions from one publisher are fully processed before moving on to the emissions of the next publisher

```java
Flux<Integer> first = Flux.range(1, 3);
Flux<Integer> second = Flux.range(4, 6);
Flux<Integer> concatenated = Flux.concat(first, second);
concatenated.subscribe(System.out::println);
// Output: 1 2 3 4 5 6
```

#### Merging Publishers

The merge operator allows emissions from multiple publishers to interleave

This is useful when dealing with multiple sources of data that can arrive asynchronously

```java
// interval1 is a Flux that emits a sequence of long values starting from 0 with a period of 1 second and stops after emitting 3 values
Flux<Long> interval1 = Flux.interval(Duration.ofSeconds(1)).take(3);
// interval2 is a Flux that starts emitting a sequence of long values starting from 0 after an initial delay of 500 milliseconds and then continues to emit every 1000 milliseconds, stopping after 3 values
Flux<Long> interval2 = Flux.interval(Duration.ofMillis(500), Duration.ofMillis(1000)).take(3);
Flux<Long> merged = Flux.merge(interval1, interval2);
merged.subscribe(System.out::println);
// Output: 0 0 1 1 2 2
```

#### Zip Publishers

The zip operator pairs up corresponding elements from multiple publishers

This is beneficial when you want to combine data points that have a logical relationship, like fetching additional details based on an initial set of data

```java
Flux<String> colors = Flux.just("Red", "Green", "Blue");
Flux<String> codes = Flux.just("#DC3545", "#198754", "#0D6EFD");
Flux<String> combined = Flux.zip(colors, codes, (color, code) -> color + ": " + code);
combined.subscribe(System.out::println);
// Red: #DC3545
// Green: #198754
// Blue: #0D6EFD
```

#### Combining Latest Values

The `combineLatest` operator combines the latest emissions from multiple publishers

This is helpful when you want to react to changes in any of the combined publishers

```java
Flux<Long> interval1 = Flux.interval(Duration.ofSeconds(1));
Flux<Long> interval2 = Flux.interval(Duration.ofMillis(500));

Flux<String> combined = Flux.combineLatest(interval1, interval2,
  (value1, value2) -> "Interval1: " + value1 + " | Interval2: " + value2);

combined.take(5).subscribe(System.out::println);
// Output (as time progresses):

// Interval1: 0 | Interval2: 0
// Interval1: 0 | Interval2: 1
// Interval1: 1 | Interval2: 1
// Interval1: 2 | Interval2: 1
// Interval1: 2 | Interval2: 2
```

#### Using FlatMap for Dynamic Publishers

The flatMap operator is a versatile tool for managing dynamic asynchronous operations

It takes each emission from a source publisher and maps it to a new publisher, which can emit its own sequence of values

This is particularly useful when you have to perform additional asynchronous tasks for each emitted item

```java
Flux<String> source = Flux.just("apple", "banana", "cherry");

Flux<String> processed = source.flatMap(item ->
  Mono.just(item.toUpperCase())
      .delayElement(Duration.ofMillis(item.length() * 100))
);

processed.subscribe(System.out::println);
// Output (timing varies):

// APPLE
// BANANA
// CHERRY
```

#### Handling Errors with Combining Operators

When combining publishers, it's important to consider error handling

Errors in any of the publishers will trigger an error signal in the resulting combined publisher

```java
Flux<Integer> first = Flux.range(1, 3)
  .map(n -> {
    if (n == 2) {
      throw new RuntimeException("Oops!");
    }
    return n;
  });

Flux<Integer> second = Flux.range(4, 6);
Flux<Integer> combined = Flux.concat(first, second);

combined.subscribe(
  System.out::println,
  error -> System.err.println("Error: " + error.getMessage())
);
// 1
// Error: Oops!
```

### Backpressure

> Backpressure addresses the challenge of managing the flow of data between publishers and subscribers,
> especially when the rate of data production exceeds the rate of data consumption
>
> Backpressure addresses this by allowing the consumer to control the rate at which it receives data from the producer/publisher

- Imagine a scenario where a fast data producer is feeding a slow data consumer
  - Without backpressure, the consumer could become overwhelmed, leading to memory exhaustion, latency spikes, or even application crashes
- Backpressure addresses this issue by allowing the consumer to control the rate at which it receives data from the producer/publisher
  - When a subscriber encounters too much data, it signals the publisher to slow down or stop emitting data temporarily

Reactive Streams, which Reactor is built upon, provide a standardised way to handle backpressure
The key interfaces of Reactive Streams are:

- Publisher = Emits a stream of data to which a subscriber can subscribe
- Subscriber = Consumes data emitted by the publisher and signals backpressure when needed
- Subscription = Represents a connection between a publisher and a subscriber, allowing the subscriber to request a specific number of items

#### Backpressure Handling Strategies

Reactor offers various backpressure handling strategies, allowing developers to
choose the approach that best fits their application's needs:

- `BUFFER`
  - The most straightforward strategy
  - The publisher buffers emitted data until the subscriber can consume it
  - While this can prevent data loss, it might lead to increased memory usage
- `DROP`
  - When the subscriber signals that it can't keep up, the publisher simply drops the excess data
  - This can lead to data loss but helps prevent memory overflows
- `LATEST`
  - This strategy drops the previously buffered data and only keeps the most recent data
  - It's useful when older data becomes less relevant
- `ERROR`
  - The publisher throws an error when the subscriber can't keep up
  - This strategy ensures that backpressure issues are surfaced explicitly but can be disruptive

#### Implementing Backpressure

Reactors' built-in operators facilitate seamless backpressure handling

For instance, the `onBackpressureBuffer` operator buffers excess data and awaits the consumer's readiness

The onBackpressureDrop operator simply discards surplus data

**Example**

In the example below, the `fastProducer` emits integers from 1 to 1000 in quick succession

The `bufferedConsumer` is created as a buffered version of the `fastProducer`,
ensuring that when the consumer can't keep up, up to 10 values are buffered before
applying backpressure

```java
Flux<Integer> fastProducer = Flux.range(1, 1000);
Flux<Integer> bufferedConsumer = fastProducer.onBackpressureBuffer(10);

bufferedConsumer.subscribe(
  value -> {
    // Simulate slow processing
    Thread.sleep(100);
    System.out.println(value);
  }
);
```

#### Mismatches in Producer and Consumer Speeds

Backpressure is most critical when there's a substantial difference between the speed of data production and consumption

Reactive Streams help balance this discrepancy by allowing subscribers to request data at their own pace

When using Reactor, publishers only emit data when explicitly requested by subscribers,
ensuring that the rate of data production matches the rate of consumption

In the example below, the output will show the integers from 1 to 1000 incrementing sequentially,
but with a delay of approximately 100 milliseconds between each printed value

This example illustrates how the slow processing of each emitted value by the subscriber
can impact the rate at which data is consumed from a fast data source, effectively introducing a backpressure scenario

```java
Flux<Integer> fastProducer = Flux.range(1, 1000);
fastProducer.subscribe(
  value -> {
    // Simulate slow processing
    Thread.sleep(100);
    System.out.println(value);
  }
);
```

### WebClient

> `WebClient` is a reactive HTTP client provided by Spring WebFlux, the reactive counterpart of Spring MVC
>
> It enables you to make non-blocking, asynchronous HTTP requests to external services while leveraging the power of reactive programming
>
> `WebClient` is ideal for scenarios where you want to fetch data from remote APIs, call microservices, or interact with any external HTTP-based service

You can create a `WebClient` instance using the `WebClient.builder()` method

The builder provides various options to configure the behavior of the client, such as setting base URLs, default headers, and more

```java
WebClient webClient = WebClient.builder()
  .baseUrl("https://api.example.com")
  .defaultHeader("Authorization", "Bearer YOUR_ACCESS_TOKEN")
  .build();
```

WebClient offers a variety of methods for making HTTP requests

You can choose the appropriate method based on the type of request you need to perform (GET, POST, PUT, DELETE, etc.)

Each method returns a `Mono<ClientResponse>` representing the response of the HTTP request

```java
Mono<ClientResponse> responseMono = webClient.get()
  .uri("/endpoint")
  .retrieve()
  .toBodilessEntity();
```

n the above example, the `.get()` method is used to initiate a GET request to the specified URI

The `.retrieve()` method performs the request, and the `.toBodilessEntity()` method extracts the response without reading the body

You can use other methods like `.toEntity()`, `.bodyToMono()`, or `.bodyToFlux()` to extract different parts of the response

Since `WebClient` operates in a reactive environment, it returns reactive types such as `Mono` or `Flux` to represent asynchronous data

You can use these types to process the response data asynchronously

**Example**

In the example below, the `.bodyToMono()` method converts the response body to a `Mono<ApiResponse>`
where `ApiResponse` is a class representing the structure of the response

The `.subscribe()` method initiates the request and handles the response or error asynchronously

```java
Mono<ApiResponse> responseMono = webClient.get()
  .uri("/endpoint")
  .retrieve()
  .bodyToMono(ApiResponse.class);

responseMono.subscribe(
  response -> System.out.println("Response: " + response),
  error -> System.err.println("Error: " + error.getMessage())
);
```

#### Error Handling

`WebClient` also provides mechanisms for handling errors in a reactive way

You can use the `.onStatus()` method to define how to handle different HTTP response statuses

**Example**

In the example below, the `.onStatus()` method is used to handle 4xx client errors

If a 4xx error occurs, a custom exception is created and propagated through the reactive pipeline

```java
Mono<ApiResponse> responseMono = webClient.get()
  .uri("/endpoint")
  .retrieve()
  .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new CustomException("Client error")))
  .bodyToMono(ApiResponse.class);
```

# Spring WebFlux

## Spring WebFlux: Threading + EventLoops - Stefan Kreidel

- [Spring WebFlux - Threading + EventLoops](https://www.stefankreidel.io/blog/spring-webflux)
- [Spring WebFlux - Executing Code in Parallel](https://www.stefankreidel.io/blog/spring-webflux-async-compute)

### What it means to be Reactive

The `EventHandler` (this is not what they are called in Spring) reacts to two scenarios

1. One is the arrival of a new request, visualised as a RequestEvent
2. Two is the completion of some kind of processing step

Both of these event types can happen at any time

- If the EventHandler happens to by free, the event is picked up and handled immediately
- If it is busy however, the event is queued until the handler is free again

### How Threads are used to achieve Reactiveness

Spring supports multiple, non-blocking web servers, which fall into two categories:

1. Non-blocking servlet containers like Apache Tomcat, Eclipse Jetty and other Servlet 3.1+ containers
2. Non-servlet runtimes such as Netty and JBoss Undertow

Spring Boot has a WebFlux starter which automatically starts Netty by default (since Netty was implemented to be non-blocking from the ground-up)

Starter Steps

- Add `spring-boot-starter-webflux` dependency to pom.xml

The main difference compared to the other servers supported by Spring is that **Netty does NOT work on Servlets**,
which dispatch incoming requests ready to be picked up by a worker thread but instead **Netty works on EventLoops**

- [Read more about Servlets](https://www.stefankreidel.io/blog/spring-webmvc-servlet-threading)

### Netty EventLoop's

> EventLoop = A term for a non-blocking IO thread, based on Java NIO

So technically speaking, it is not all that much different from a worker thread
we already know from "classic" Spring Web. The important difference becomes more
obvious once we understand how EventLoops behave

Typically, a couple of `EventLoops` are running at all time, managed by an `EventLoopGroup`

Each `EventLoop` handles a number of `SocketChannels`, through which requests can be accepted (on the server side) or made (on the client side)

Whenever a new `SocketChannel` is created, it is PERMANENTLY BOUND TO EXACTLY ONE `EventLoop` and this binding cannot be changed anymore

- This is the first big difference compared to Spring Web: Sockets are continuously bound to the same EventLoop (and thereby thread)
- This means that a blocked EventLoop causes queuing of incoming requests, event if another EventLoop is free

## Spring WebFlux Tutorial with CRUD Example - HowToDoInJava

- [Spring WebFlux Tutorial with CRUD Example - HowToDoInJava](https://howtodoinjava.com/spring-webflux/spring-webflux-tutorial/)

> The reactive-stack web framework, Spring WebFlux, has been added to Spring 5
>
> It is fully non-blocking, supports reactive streams back pressure, and runs on such servers as Netty, Undertow, and Servlet 3.1+ containers

### Reactive Programming

> Reactive programming is a programming paradigm that promotes an asynchronous, non-blocking, event-driven approach to data processing
>
> Reactive programming involves modeling data and events as observable data streams and implementing data processing routines to react to the changes in those streams

#### Blocking/Synchronous Request Processing

In traditional MVC applications, a new servlet thread is created (or obtained from the thread pool) when a request comes to the server

It delegates the request to worker threads for I/O operations such as database access etc

During the time worker threads are busy, the servlet thread (request thread) remains in waiting status, and thus it is blocked

This is known as synchronous request processing

![](https://howtodoinjava.com/wp-content/uploads/2019/02/Blocking-request-processing.png)

As a server can have some finite number of request threads, it limits the server's capability
to process that number of requests at maximum server load. It may limit/hamper the performance
and limit the full utilization of server capability

#### Non-Blocking/Asynchronous Request Processing

In non-blocking or asynchronous request processing, NO thread is in waiting state

There is generally only one request thread receiving the request

All incoming requests come with an event handler and callback information

Request thread delegates the incoming requests to a thread pool (generally a small number of threads)
which delegates the request to its handler function and immediately starts processing
other incoming requests from the request thread

When the handler function is complete, one thread from the pool collects the response and passes it to the callback function

![](https://howtodoinjava.com/wp-content/uploads/2019/02/Non-blocking-request-processing.png)

Non-blocking/asynchronous nature of threads helps in scaling the performance of the application

A small number of threads means less memory utilization and less context switching

#### What is Reactive Programming?

The term, "reactive," refers to programming models that are built around **reacting to changes**

- It is built around the publisher-subscriber pattern [observer pattern](https://howtodoinjava.com/design-patterns/behavioral/observer-design-pattern/)
- In the reactive style of programming, we make a request for resources and start performing other things
- When the data is available, **we get the response/notification along with data in the callback function**
- **The callback function handles the response** as per application/user needs

**Note: In non-blocking code, backpressure controls the rate of events so that a fast producer does NOT overwhelm its consumer/destination**

By using non-blocking and event-driven mechanisms, we can design scalable well-suited solutions for applications that involve streaming data and real-time interactions

- Reactive programming can also benefit traditional CRUD applications

While reactive APIs offload tasks to non-blocking threads, they also require proper thread management

- Incorrect handling of threads or blocking operations within a reactive context can lead to thread contention and performance issues

Also, reactive programming adds more unnecessary complexity without substantial gains in low concurrent traditional applications

For such applications, a traditional synchronous approach may be more straightforward and suitable

### Reactive Streams API

> Reactive Streams is an initiative to provide a standard for asynchronous stream processing with non-blocking back pressure
>
> This encompasses efforts aimed at runtime environments (JVM and JavaScript) as well as network protocols

Two popular implementations of reactive streams are:

- RxJava (https://github.com/ReactiveX/RxJava)
- Project Reactor (https://projectreactor.io/)

The new Reactive Streams API defines four interfaces:

#### `Publisher`

The `Publisher` emits a sequence of events to subscribers according to the demand received from its subscribers/consumers

A `Publisher` can serve multiple subscribers/consumers

```java
// Publisher.java
import org.reactivestreams.Subscriber;

public interface Publisher<T> {
  public void subscribe(Subscriber<? super T> s);
}
```

#### `Subscriber`

Receives and processes events emitted by a `Publisher`

Note: NO notifications will be received until `Subscription.request()` is called to signal the demand

It has four methods to handle various kinds of responses received

```java
// Subscriber.java
import org.reactivestreams.Subscription;

public interface Subscriber<T> {
  public void onSubscribe(Subscription s);

  public void onNext(T t);

  public void onError(Throwable t);

  public void onComplete();
}
```

#### `Subscription`

Subscription = Defines a one-to-one relationship between a `Publisher` and a `Subscriber`

It can only be used ONCE by a SINGLE `Subscriber`.

It is used to both signal desire for data and cancels demand (and allow resource cleanup)

```java
// Subscription.java
import org.reactivestreams.Subscription;

public interface Subscription<T> {
  public void request(long n);
  public void cancel();
}
```

#### `Processor`

Processor = Represents a processing stage consisting of both a `Subscriber` and a `Publisher` and obeys both contracts

```java
// Processor.java
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {}
```

### What is Spring WebFlux?

> Spring WebFlux = A parallel version of Spring MVC and supports fully non-blocking reactive streams
>
> It supports the back pressure concept and uses Netty as the inbuilt server to run reactive applications

Spring WebFlux uses Project Reactor as the reactive library

Reactor is a Reactive Streams library; therefore, all of its operators support non-blocking back pressure

Spring WebFlux heavily uses two publishers:

1. `Mono` = Returns 0 or 1 element

   - [Mono Docs](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html)

   ```java
   import reactor.core.publisher.Mono;

   Mono<String> mono = Mono.just("Alex");
   Mono<String> mono = Mono.empty();
   ```

2. `Flux` = Returns 0...N elements

   - A Flux can be endless, meaning that it can keep emitting elements forever
   - A Flux can also return a sequence of elements and then send a completion notification when it has returned all of its elements
   - [Flux Docs](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html)

   ```java
   import reactor.core.publisher.Flux;
   import java.util.Arrays;

   Flux<String> flux = Flux.just("A", "B", "C");
   Flux<String> flux = Flux.fromArray(new String[]{"A", "B", "C"});
   Flux<String> flux = Flux.fromIterable(Arrays.asList("A", "B", "C"));
   // To subscribe call method
   flux.subscribe();
   ```

In Spring WebFlux, we call reactive APIs/functions that return Monos and Fluxes,
and your controllers will return Monos and Fluxes

When you invoke an API that returns a `Mono` or a `Flux`, it will return immediately

The function call results will be delivered to you through the `Mono` or `Flux` when they become available

Note: To build a truly non-blocking application, we must aim to create/use all of its components as non-blocking
i.e. client, controller, middle services and even the database. If one of them is blocking the requests, our code will NOT be non-blocking

### Spring Boot WebFlux Example

In the example Spring Boot application below, we are creating an employee management system

To make it fully non-blocking, we are using MongoDB as the backend database

#### Maven

```xml
<!-- pom.xml -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb-reactive</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>io.projectreactor</groupId>
  <artifactId>reactor-test</artifactId>
  <scope>test</scope>
</dependency>
```

#### Configurations

##### Webflux Configuration

The `@EnableWebFlux` annotation imports the Spring WebFlux configuration from `WebFluxConfigurationSupport`
that enables the use of annotated controllers and functional endpoints

It is similar to `@EnableWebMvc` annotation for Spring MVC applications

```java
// WebFluxConfig.java
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {}
```

##### MongoDB Configuration

We are using MongoDB as our backend database so let's configure the persistence layer

```java

// MongoConfig.java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.howtodoinjava.demo.dao")
public class MongoConfig extends AbstractReactiveMongoConfiguration {
  @Value("${port}")
  private String port;
  @Value("${dbname}")
  private String dbName;

  @Override
  public MongoClient reactiveMongoClient() {
    return MongoClients.create();
  }

  @Override
  protected String getDatabaseName() {
    return dbName;
  }

  @Bean
  public ReactiveMongoTemplate reactiveMongoTemplate() {
    return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
  }
}
```

##### `application.properties`

The properties used in the Mongo config can be defined in `application.properties` file

```conf
application.propertiesport=27017
dbname=testdb
```

#### REST Controller with CRUD APIs

```java
// EmployeeController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.howtodoinjava.demo.model.Employee;
import com.howtodoinjava.demo.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @RequestMapping(value = { "/create", "/" }, method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Employee e) {
    employeeService.create(e);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id) {
    Mono<Employee> e = employeeService.findById(id);
    return new ResponseEntity<Mono<Employee>>(e, HttpStatus.OK);
  }

  @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
  public Flux<Employee> findByName(@PathVariable("name") String name) {
    return employeeService.findByName(name);
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Employee> findAll() {
    Flux<Employee> emps = employeeService.findAll();
    return emps;
  }

  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public Mono<Employee> update(@RequestBody Employee e) {
    return employeeService.update(e);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") Integer id) {
    employeeService.delete(id).subscribe();
  }
}
```

#### Service

```java
// EmployeeService.java
import com.howtodoinjava.demo.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
  void create(Employee e);

  Mono<Employee> findById(Integer id);

  Flux<Employee> findByName(String name);

  Flux<Employee> findAll();

  Mono<Employee> update(Employee e);

  Mono<Void> delete(Integer id);
}
```

```java
// EmployeeServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.howtodoinjava.demo.dao.EmployeeRepository;
import com.howtodoinjava.demo.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  EmployeeRepository employeeRepo;

  public void create(Employee e) {
    employeeRepo.save(e).subscribe();
  }

  public Mono<Employee> findById(Integer id) {
    return employeeRepo.findById(id);
  }

  public Flux<Employee> findByName(String name) {
    return employeeRepo.findByName(name);
  }

  public Flux<Employee> findAll() {
    return employeeRepo.findAll();
  }

  public Mono<Employee> update(Employee e) {
    return employeeRepo.save(e);
  }

  public Mono<Void> delete(Integer id) {
    return employeeRepo.deleteById(id);
  }
}
```

#### Repository/DAO

```java
// EmployeeRepository.java
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.howtodoinjava.demo.model.Employee;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {
  @Query("{ 'name': ?0 }")
  Flux<Employee> findByName(final String name);
}
```

#### Model

The model is a Mongo Document

```java
// Employee.java
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Employee {
  @Id
  int id;
  String name;
  long salary;

  //Getters and setters
  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
  }
}
```

#### Testing with Postman

`HTTP POST http://localhost:8080/create`

`HTTP PUT http://localhost:8080/update`

`HTTP GET http://localhost:8080/`

```
data:{"id":1,"name":"user_1","salary":101}

data:{"id":2,"name":"user_2","salary":102}
```

Note: We are testing the API with Postman Chrome Browser Extension which is a BLOCKING client

- It will display the result only when it has collected both employees' responses

To verify the non-blocking response feature, hit the URL in the chrome browser directly

- The results will appear one by one, as and when they are available in form of events (text/event-stream).
- To better view the result, consider adding a delay to the controller API

![](https://howtodoinjava.com/wp-content/uploads/2019/02/Spring-WebFlux-Demo-Event-Stream.png)

# Spring WebClient

> Spring WebClient is part of the Spring WebFlux library
>
> Spring WebFlux includes a client to perform HTTP requests with namely WebClient
>
> > WebClient has a functional, fluent API based on Project Reactor which enables declarative composition of asynchronous logic without the need to deal with threads or concurrency
>
> > It is fully non-blocking, it supports streaming, and relies on the same codecs that are also used to encode and decode request and response content on the server side

- Resources
  - [New in Spring 6.1: RestClient - Spring Blog](https://spring.io/blog/2023/07/13/new-in-spring-6-1-restclient)

## Get Response Body from ClientResponse - via `.retrieve()`

To get both the response headers and body in Spring WebFlux, we typically use
the `.exchangeToMono()` or `.exchangeToFlux()` methods

However if we are to specifically use `.retrieve()`, we can achieve this by accessing
the response headers through `ResponseEntity`

Here's how we can modify the example to get both the response headers and body:

- Use `.retrieve()`
- Instead of directly calling `.bodyToMono()`, use `.toEntity()` or `.toEntityList()` (if expecting a collection) which returns a `Mono<ResponseEntity<T>>` or `Flux<ResponseEntity<List<T>>>`
  - This allows access to both the body and headers
- Extract the body and headers from the ResponseEntity

Note: `.toEntity(T)`: returns a `ResponseEntity` with the body decoded to an Object of the given type `T`

- For an error response (status code of 4xx or 5xx), the `Mono` emits a `WebClientException`
- Need to use `.onStatus(Predicate, Function)` to customie error response handling

```java
@Service
public class MyService {

  private final WebClient webClient;

  @Autowired
  public MyService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Mono<Employee> createEmployee(Employee employee) {
    return webClient.post()
      .uri("/employees")
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .body(Mono.just(employee), Employee.class)
      .retrieve()
      .toEntity(Employee.class) // Use toEntity to get ResponseEntity
      .map(responseEntity -> {
        HttpHeaders headers = responseEntity.getHeaders(); // Access the headers
        Employee responseBody = responseEntity.getBody(); // Access the body
        // Process headers and body as needed
        return responseBody; // Return the body or a combination of data as needed
      });
  }
}
```

**Get Response Body from ClientResponse - via `.exchange()` (DEPRECATED)**

To get the response body from a ClientResponse instance in a Spring WebFlux WebClient,
we typically use the bodyToMono or bodyToFlux method depending on whether we
expect a single object or a collection of objects

Call the `.exchange()` method instead of `.retrieve()` to get a `Mono<ClientResponse>`

Use the `.flatMap()` or `.flatMapMany()` method on the Mono<ClientResponse> to access the ClientResponse object

Inside the `.flatMap()` or `.flatMapMany()`, call the `.bodyToMono(T.class)`/`.bodyToMono(Class<T>)` or `bodyToFlux(T.class)`/`bodyToFlux(Class<T>)` on the `ClientResponse` object to extract the body

- Note: The `Class<T>` parameter is the class of the object or objects we are expecting in the response body
- Note: `Class<T> == T.class`

The result will be a `Mono<T>` or `Flux<T>` representing the body or bodies extracted from the response

```java
public Mono<Employee> createEmployee(Employee employee) {
  return webClient.post()
    .uri("/employees")
    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    .body(Mono.just(employee), Employee.class)
    .exchange() // Use .exchange() instead of .retrieve()
    .flatMap(response -> response.bodyToMono(Employee.class)); // Extract the body
}
```

The `.flatMap()` operation in reactive programming, specifically with Project Reactor (used in Spring WebFlux),
is used to transform the items emitted by a Publisher (e.g. `Mono` or `Flux`) into Publishers themselves,
then flatten the emissions from those resulting Publishers into a single Flux (for `Flux.flatMap()`) or Mono (for `Mono.flatMap()`)

In the context of Spring WebFlux `.flatMap()` would be used when we have a `Mono<ClientResponse>`
and we want to asynchronously extract and process the response body, potentially transforming
it into another type or performing further asynchronous operations on it
The `.flatMap()` operation allows we to keep the processing chain reactive and non-blocking

Why `.flatMap()` is needed: Since `.exchange()` returns a `Mono<ClientResponse>`,
and we want to call a method (`bodyToMono(Class<T>)`) that operates on the `ClientResponse` itself,
we need a way to transform the `Mono<ClientResponse>` into a `Mono<T>`
This is exactly what `.flatMap()` does. It takes a function that operates on the
contained `ClientResponse` and returns a new `Mono` based on the body of the response

Essentially, `.flatMap()` allows we to chain asynchronous operations: from completing
the request and receiving the ClientResponse, to processing the response body

## Spring WebClient - StackOverflow

- Resources
  - `webclient make asynchronous call`

> https://stackoverflow.com/questions/72629760/making-async-http-call-with-spring-webclient

```java
private CompletableFuture<Object> asyncHttpCall(HttpMethod httpMethod, String url, String body, Map<String, String> headers) {
  return WebClient.create(url).method(httpMethod).bodyValue(body).headers(httpHeaders -> headers.forEach(httpHeaders::add))
    .retrieve()
    .bodyToMono(Object.class)
    // specify timeout
    .timeout(Duration.ofSeconds(5L))
    // subscribe on a different thread from the given scheduler to avoid blocking as toFuture is a subscriber
    .subscribeOn(Schedulers.single())
    // subscribes to the mono and converts it to a completable future
    .toFuture();
}

// execute asyncHttpCall
asyncHttpCall(HttpMethod.POST, "https://httpbin.org/post", "", Collections.emptyMap())
  // consume the response from the CompletableFuture
  .thenAccept(response -> System.out.println("response = " + response));
```

> https://stackoverflow.com/questions/59123889/is-spring-boot-webclient-real-asynchronous

WebClient uses Reactor Netty to provide a fully asynchronous, NIO networking library for Java

Using `.block()`, we'll be blocking the calling thread, which is not desired

For I/O calls, we should use `.flatMap()`, which subscribes to the inner streams and dynamically merges the results as and when they arrive

```java
Mono.just(httpRequest)
  .flatMap(request -> request.exchange().bodyToMono(String.class))
  .map(response -> doWhateverToTheResponse(response))
  .subscribeOn(Schedulers.elastic())
  .subscribe();
```

```java
CompletableFuture<Optional<ReturnType>> response = new CompletableFuture<>();
  client.post()
    .uri("why isn't this an argument to post???")
    .bodyValue("register a ridiculous number of callbacks to make a web call")
    .exchangeToMono(this::handleResponse)
    .subscribeOn(Schedulers.boundedElastic())
    .subscribe(resp -> response.complete(Optional.of(resp)))
  // Do some CPU work
  // Make another request
  response.get(...bound the response with some time & wrap in exception handlers)
```

> https://stackoverflow.com/questions/58957969/how-to-make-an-asynchronous-call-using-spring5-webclient

we can use `.subscribe()` function to make a asynchronous call

Do NOT use `.block()` since it will block and wait for the http call

```java
Mono<ClientResponse> response = WebClient.builder().build().post()
  .uri("http://api.com")
  .body(BodyInserters.fromObject("data"))
  .accept(MediaType.APPLICATION_JSON)
  .header("Authorization", "Bearer blahblahblahblah")
  .bodyToMono(ClientResponse.class)
  .retrieve();
```

## Simultaneous Spring WebClient Calls - Baeldung

> Spring Webclient provides a reactive, asynchronous, non-blocking interface for sending HTTP requests
>
> Note: You can still make synchronous calls with WebClient

Note: The `.bodyToMono()` method, which will throw a `WebClientException` if the status code is 4xx (client error) or 5xx (server error)

- [Simultaneous Spring WebClient Calls - Baeldung](https://www.baeldung.com/spring-webclient-simultaneous-calls)

## Spring WebClient Hands-On Examples - HowToDoInJava

> The Spring WebClient is an asynchronous and non-blocking reactive HTTP library

Note: You can still make synchronous requests with WebClient

- [Spring WebClient (with Hands-On Examples) - HowToDoInJava](https://howtodoinjava.com/spring-webflux/webclient-get-post-example/)
- [Spring WebClient - HowToDoInJava](https://howtodoinjava.com/spring-webflux/)

### Maven

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

### Creating a Spring WebClient Instance

#### Using `WebClient.create()`

The create() method is an overloaded method and can optionally accept a base URL for requests

```java
WebClient webClient = WebClient.create(); // With empty URI
WebClient webClient = WebClient.create("https://client-domain.com"); // With specified root URI
```

#### Using `WebClient.Builder` API

We can also build the client using the DefaultWebClientBuilder class, which uses builder pattern style fluent-API

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {
  @Bean
  public WebClient webClient() {
    WebClient webClient = WebClient.builder()
      .baseUrl("http://localhost:3000")
      .defaultCookie("cookie-name", "cookie-value")
      .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .build();
  }
}
```

#### Using WebClient for Sending Requests and Handling Responses

> To send a request, we can use the `.builder()` method to customise as per the requirements

For example, sending an HTTP POST request involves the following steps

- Create `WebClient.UriSpec` reference using prebuilt methods such as `.get()`, `.put()`, `.post()` or `.delete()`
- Set the request URI if not set already
- Set the request headers and authentication details (if any)
- Set the request body (if any)
- Call the `.retrieve()` or `.exchange()` method
  - The `.retrieve()` method directly performs the HTTP request and retrieves the response body
  - The `.exchange()` method returns `ClientResponse` having the response status and headers
    - We can then get the response body from ClientResponse instance
    - **Note: As of Spring 5.3: `.exchange()` has been DEPRECATED due to potential memory/connection leaks; please, use `.exchangeToMono()`, `.exchangeToFlux()`; consider also using `.retrieve()` which provides access to the response status and headers via `ResponseEntity` along with error status handling via `.onStatus()`**
- Handle the response returned from the server

In the example below, we send an HTTP POST request to URI `http://localhost:3000/employees` that returns an Employee object after the successful call

```java
@Service
public class MyService {

  private final WebClient webClient;

  @Autowired
  public MyService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Mono<Employee> createEmployee(Employee employee) {
    Mono<Employee> employeeMono = webClient.post()
      .uri("/employees")
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .body(Mono.just(employee), Employee.class)
      .retrieve()
      .bodyToMono(Employee.class);

    return employeeMono;
  }
}
```

The example below demonstrates how we can use the service method and handle success and error scenarios:

```java
public void someMethod() {

  Employee employee = new Employee(...); // Create an Employee instance

  myService.createEmployee(employee)
    .subscribe(
      createdEmployee -> {
        // Handle the successful response
        System.out.println("Employee created: " + createdEmployee);
      },
      error -> {
        // Handle errors
        System.err.println("Error creating employee: " + error.getMessage());
      }
    );
}
```

### WebClient `.retrieve()` vs `.exchange()` APIs

> Note: As of Spring 5.3: `.exchange()` has been DEPRECATED due to potential memory/connection leaks;
>
> Prefer `.exchangeToMono()`, `.exchangeToFlux()`, or `.retrieve()`
>
> Note: Consider also using `.retrieve()` which provides access to the response status and headers via `ResponseEntity` along with error status handling via `.onStatus()`

#### `.retrieve()`

The `.retrieve()` is a simplified API for common use cases where we want to send an HTTP request,
receive the response, and handle it in a reactive way

When we call `.retrieve()` the request is sent, and the response is automatically processed
and deserialised into a reactive type (e.g. Mono or Flux). We do NOT need to explicitly
`.subscribe()` to the response. We do need to call `.subscribe()` when after using `.bodyToMono()` or `.bodyToFlux` though

The response type is inferred from the final call to `.bodyToMono()` or `.bodyToFlux()`

For example, if we use `bodyToMono(Employee.class)`, we'll get a `Mono<Employee>` as the result

```java
Mono<Employee> employeeMono = webClient.get()
  .uri("/employees/{id}", 123)
  .retrieve()
  .bodyToMono(Employee.class);
```

Note: `.bodyToMono()` and `.bodyToFlux()` methods always expect a response body of a given class type

- If the response status code is 4xx (client error) or 5xx (Server error) i.e. there is no response body then these methods throw `WebClientException`
- Use `.bodyToMono(Void.class)` if no response body is expected (useful for DELETE operations)

```java
webClient.delete()
  .uri("/employees/" + id)
  .retrieve()
  .bodyToMono(Void.class);
```

#### `.exchange()`

The `.exchange()` API allows us to handle the request and response explicitly

It returns the `ClientResponse` which has all the response elements such as status, headers and response body as well

With `.exchange()`, we are responsible for subscribing to the response explicitly using `.subscribe()`, `.block()` or similar methods

- This gives us more control over when and how the request is executed

When using `.exchange()`, we must always use any of the `.bodyToMono()`, `.bodyToFlux()` or `.toEntity()` methods of `ClientResponse` which provides more flexibility in choosing the reactive type for the response

```java
Mono<ClientResponse> responseMono = webClient.get()
  .uri("/employees/{id}", 123)
  .exchange();

responseMono.subscribe(clientResponse -> {
  HttpStatus statusCode = clientResponse.statusCode();  // HTTP Status
  HttpHeaders headers = clientResponse.headers();  // HTTP Headers
  Mono<Employee> employeeMono = clientResponse.bodyToMono(Employee.class);  // Response Body
  // Handle the response, including error handling based on status code
});
```

The example below demonstrates how to use `.exchangeToMono()` to make a GET request with Spring WebClient and handle the response:

```java
@Service
public class MyService {

  private final WebClient webClient;

  public MyService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Mono<Employee> fetchEmployeeById(int id) {
    return webClient.get()
      .uri("/employees/{id}", id)
      .exchangeToMono(this::handleResponse);
  }

  private Mono<Employee> handleResponse(ClientResponse response) {

    if (response.statusCode().is2xxSuccessful()) {
      return response.bodyToMono(Employee.class);
    } else if (response.statusCode().is4xxClientError()) {
      // Handle client errors (e.g., 404 Not Found)
      return Mono.error(new EmployeeNotFoundException("Employee not found"));
    } else if (response.statusCode().is5xxServerError()) {
      // Handle server errors (e.g., 500 Internal Server Error)
      return Mono.error(new RuntimeException("Server error"));
    } else {
      // Handle other status codes as needed
      return Mono.error(new RuntimeException("Unexpected error"));
    }
  }
}
```

### Spring WebClient Examples

#### GET API Example

Generally, we will use GET API to fetch either a collection of resources or a singular resource

- `HTTP GET /employees`: Collection of employees as Flux
- `HTTP GET /employees/{id}`: sSingle employee by id as Mono

```java
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

  private final WebClient webClient;

  public MyService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Flux<Employee> getAllEmployees() {

    return webClient.get()
      .uri("/employees")
      .retrieve()
      .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
        clientResponse -> handleErrorResponse(clientResponse.statusCode()))
      .bodyToFlux(Employee.class)
      .onErrorResume(Exception.class, e -> Flux.empty()); // Return an empty collection on error
  }

  public Mono<Employee> getEmployeeById(int id) {
    return webClient.get()
      .uri("/employees/{id}", id)
      .retrieve()
      .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
        clientResponse -> handleErrorResponse(clientResponse.statusCode()))
      .bodyToMono(Employee.class);
  }

  private Mono<? extends Throwable> handleErrorResponse(HttpStatus statusCode) {
    // Handle non-success status codes here (e.g. logging or custom error handling)
    return Mono.error(new EmployeeServiceException("Failed to fetch employee. Status code: " + statusCode));
  }
}
```

Now, in the application code, we can inject the `EmployeeService` and use it as follows:

```java
// Example of using getAllEmployees()
Flux<Employee> allEmployees = employeeService.getAllEmployees();

allEmployees.subscribe(employee -> {
  // Process each employee in the Flux
  System.out.println("Employee: " + employee);
});

// Example of using getEmployeeById(int id)
int employeeId = 123; // Replace with the desired employee ID
Mono<Employee> employeeById = employeeService.getEmployeeById(employeeId);

employeeById.subscribe(employee -> {
  // Process the employee retrieved by ID
  System.out.println("Employee by ID: " + employee);
});
```

#### POST API Example

POST API is commonly used for creating a resource

`HTTP POST /employees`: Creates a new employee from the request body and returns the created employee in response

```java
@Service
public class EmployeeService {

  private final WebClient webClient;

  @Autowired
  public EmployeeService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Mono<ResponseEntity<Employee>> createEmployee(Employee newEmployee) {
    return webClient.post()
      .uri("/employees")
      .body(Mono.just(newEmployee), Employee.class)
      .retrieve()
      .onStatus(HttpStatus::is4xxClientError, response -> {
        // log.error("Client error occurred");
        return Mono.error(new WebClientResponseException("Bad Request", response.statusCode().value(), null, null, null));
      })
      .onStatus(HttpStatus::is5xxServerError, response -> {
        // log.error("Server error occurred");
        return Mono.error(new WebClientResponseException("Server Error", response.statusCode().value(), null, null, null));
      })
      .toEntity(Employee.class);
  }
}
```

Now, in the application code, we can inject the EmployeeService and use it to create an employee:

```java
Employee newEmployee = new Employee(180, "Sam", "Active");

employeeService.createEmployee(newEmployee)
  .subscribe(responseEntity -> {
    System.out.println("Status: " + responseEntity.getStatusCodeValue());
    System.out.println("Location URI: " + responseEntity.getHeaders().getLocation());
    System.out.println("Created New Employee: " + responseEntity.getBody());
  });
```

#### PUT API Example

PUT API is commonly used for updating a resource

`HTTP PUT /employees/{id}`: Updates an existing employee data from the request body and returns the updated employee in response

```java
public Mono<Employee> updateEmployee(Employee updatedEmployee) {
  return webClient.put()
    .uri("/employees/{id}", updatedEmployee.getId())
    .body(Mono.just(updatedEmployee), Employee.class)
    .retrieve()
    .onStatus(HttpStatus::is4xxClientError, clientResponse -> handleClientError(clientResponse))
    .onStatus(HttpStatus::is5xxServerError, clientResponse -> handleServerError(clientResponse))
    .bodyToMono(Employee.class);
}

private Mono<? extends Throwable> handleClientError(ClientResponse clientResponse) {
  // Handle client errors (e.g., 404 Not Found) here
  return Mono.error(new EmployeeNotFoundException("Employee not found"));
}

private Mono<? extends Throwable> handleServerError(ClientResponse clientResponse) {
  // Handle server errors (e.g., 500 Internal Server Error) here
  return Mono.error(new RuntimeException("Server error"));
}
```

#### DELETE API Example

DELETE API is commonly used for deleting a resource

`HTTP DELETE /employees/{id}`: Deletes an existing employee by its ID. It does not accept any request body as well as does not return any response body as well

```java
public Mono<Void> deleteEmployee(Integer id) {
  return webClient.delete()
    .uri("/employees/" + id)
    .retrieve()
    .onStatus(HttpStatus::is4xxClientError, clientResponse -> handleClientError(clientResponse))
    .onStatus(HttpStatus::is5xxServerError, clientResponse -> handleServerError(clientResponse))
    .bodyToMono(Void.class);
}

private Mono<? extends Throwable> handleClientError(ClientResponse clientResponse) {
  // Handle client errors (e.g., 404 Not Found) here
  return Mono.error(new EmployeeNotFoundException("Employee not found"));
}

private Mono<? extends Throwable> handleServerError(ClientResponse clientResponse) {
  // Handle server errors (e.g., 500 Internal Server Error) here
  return Mono.error(new RuntimeException("Server error"));
}
```

### Advanced Configurations for Spring WebClient

#### Configuring Memory Limit

Spring WebFlux configures the default memory limit for buffering data in-memory to 256KB

If this limit is exceeded in any case then we will encounter `DataBufferLimitException` error

To reset the memory limit, configure the below property in application.properties file

`spring.codec.max-in-memory-size=1MB`

#### Configuring Connection Timeouts

We can use Apache `HttpClient` class to set timeout periods for connection timeout, read timeout and write timeouts

- https://howtodoinjava.com/spring-boot2/resttemplate/resttemplate-httpclient-java-config/

```java
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;
import org.springframework.web.reactive.function.client.ClientHttpConnector;
import reactor.netty.http.client.ReactorClientHttpConnector;

public class WebClientConfig {

  @Bean
  public WebClient getWebClient() {

    HttpClient httpClient = HttpClient.create()
      .tcpConfiguration(client -> client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
        .doOnConnected(conn -> conn
          .addHandlerLast(new ReadTimeoutHandler(10))
          .addHandlerLast(new WriteTimeoutHandler(10))));

    ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

    return WebClient.builder()
      .baseUrl("http://localhost:3000")
      .clientConnector(connector)
      .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .build();
  }
}
```

## Spring WebClient POST Example - HowToDoInJava

> Spring WebClient provides a fluent builder API for sending HTTP requests and handling the responses in a Spring and Spring Boot-based application
>
> WebClient follows the reactive (non-blocking) approach, and so it is preferred over its blocking counterpart RestTemplate

- [Spring Boot WebClient POST Example](https://howtodoinjava.com/spring-webflux/webclient-post-examples/)

### Setting Up WebClient in Spring Boot

Add to `pom.xml`

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

Also, in a `@Configuration` class, we must create a bean to initialize the WebClient with appropriate settings

```java
@Configuration
public class WebConfig {

  @Bean
  public WebClient webClient() {
    WebClient webClient = WebClient.builder()
      .baseUrl("http://localhost:3000")
      .defaultCookie("cookie-name", "cookie-value")
      .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .build();
  }
}
```

### Using WebClient to Call a POST Request and Handle Response

In the examples below, we are writing code for a service that prepares the data,
sends it to a remote API for creating a resource, and finally handles the response

Only two parties are involved here

```
Client App <-> Remote API
```

- Client App
  - Executes HTTP POST requests using WebClient and handles the response
- Remote API
  - Contains HTTP Post APIs that return responses with or without body

#### Remote API returns the Location Header and Empty Response Body

This is the most common usecase where we create a new resource and the server responds
with the Location header of the newly created resource

The object, for which the resource has to be created, is sent as the serialised JSON/XML
string in the request body and setting the appropriate content type

- Note: The serialization of JSON to String is handled by the Spring framework automatically

In the following code snippet, the `bodyValue()` function sets the request body and `contentType()` is set to `APPLICATION_JSON`

The `.retrieve()` method triggers the request and returns a `ResponseEntity` without a body

```java
// Create a new employee object
Employee newEmployee = ...;

webClient.post()
  .uri("/employees")
  .bodyValue(BodyInserters.fromValue(newEmployee))
  .retrieve()
  .toBodilessEntity()
  .subscribe(
    responseEntity -> {
      // Handle success response here
      HttpStatusCode status = responseEntity.getStatusCode();
      URI location = responseEntity.getHeaders().getLocation();
      // Handle response as necessary
    },
    error -> {
      // Handle the error here
      if (error instanceof WebClientResponseException) {
        WebClientResponseException ex = (WebClientResponseException) error;
        HttpStatusCode status = ex.getStatusCode();
        System.out.println("Error Status Code: " + status.value());
        // ...
      } else {
        // Handle other types of errors
        System.err.println("An unexpected error occurred: " + error.getMessage());
      }
    }
  );
```

#### Remote API returns Success Response with Response Body

If there is a response body and we want to fetch it from the API response,
we need to replace `.toBodilessEntity()` to `.toEntity(Employee.class)` method

```java
webClient.post()
  .uri("/employees")
  .bodyValue(BodyInserters.fromValue(newEmployee))
  .retrieve()
  .toEntity(Employee.class)   // Change here
  .subscribe(
    responseEntity -> {
      // Handle success response here
      HttpStatusCode status = responseEntity.getStatusCode();
      URI location = responseEntity.getHeaders().getLocation();
      Employee createdEmployee = responseEntity.getBody();    // Response body
      // handle response as necessary
    },
    error -> {
      // Handle the error here
      if (error instanceof WebClientResponseException) {
        WebClientResponseException ex = (WebClientResponseException) error;
        HttpStatusCode status = ex.getStatusCode();
        System.out.println("Error Status Code: " + status.value());
        // ...
      } else {
        // Handle other types of errors
        System.err.println("An unexpected error occurred: " + error.getMessage());
      }
    }
  );
```

### Using WebClient to Call a POST Request and Pass Response to API Client

Many times, we will write code for an intermediary service that accepts requests from API/UI clients,
sends them to remote APIs and returns the response to the API/UI clients

In such cases, after making the request, we must return a Mono or Flux to the API/UI client
to keep the whole flow truly reactive

```
API/UI Client <-> Intermediary App <-> Remote API
```

- API/UI Client
  - Sends POST requests using AJAX or Form Submission
- Intermediary App
  - Accepts requests from UI and sends them to Remote API and returns Mono/Flux to UI
- Remote API
  - Contains HTTP POST API that returns responses with or without body

Generally, these solutions will create a `REST` controller and a `Service` class

The controller will handle the requests from UI and invoke the methods in Service, which in turn will execute the remote APIs

#### Response with Location Header and Empty Response Body

The `Service` class can be written as:

```java
@Service
public class EmployeeService {
  private final WebClient webClient;

  @Autowired
  public EmployeeService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Mono<ResponseEntity<Void>> createEmployee(Employee newEmployee) {
    return webClient.post()
      .uri("/employees")
      .contentType(MediaType.APPLICATION_JSON)
      .bodyValue(newEmployee) // Note: We can either send it as a JsonNode or as a String (Spring will automatically handle the serialization for us) [there is NO need to use ObjectMapper to convert between the two]
      .retrieve()
      .toBodilessEntity();
  }
}
```

Next, we call this API in some other class such as `ApiController`

It returns a response with a status code of 201 (Created) and a Location header indicating the location of the newly created resource

```java
@PostMapping("/create")
public Mono<ResponseEntity<String>> createEmployee(@RequestBody Employee newEmployee) {

  return employeeService.createEmployee(newEmployee)
    .map(responseEntity -> {
      if (responseEntity.getStatusCode().is2xxSuccessful()) {
        String employeeId = createdEmployee.getId();
        String locationUri = ServletUriComponentsBuilder
          .fromCurrentRequest()
          .path("/{id}")
          .buildAndExpand(employeeId)
          .toUriString();

        return ResponseEntity
          .status(HttpStatus.CREATED)
          .header("Location", locationUri)
          .body("Employee created successfully. Location: " + locationUri);
      } else {
        return ResponseEntity.status(responseEntity.getStatusCode()).body("Failed to create employee");
      }
    });
}
```

#### Success Response with Response Body

The service class code will be:

```java
public Mono<ResponseEntity<Employee>> createEmployee(Employee newEmployee) {

  return webClient.post()
    .uri("/employees")
    .contentType(MediaType.APPLICATION_JSON)
    .bodyValue(newEmployee)
    .retrieve()
    .toEntity(Employee.class);
}
```

Next, we can use this API in the controller class as follows:

```java
@PostMapping("/create")
public Mono<ResponseEntity<?>> createEmployee(@RequestBody Employee newEmployee) {
  return employeeService.createEmployee(newEmployee)
    .map(responseEntity -> {
      if (responseEntity.getStatusCode().is2xxSuccessful()) {
        return ResponseEntity.ok(responseEntity.getBody());
      } else {
        return ResponseEntity.status(responseEntity.getStatusCode())
          .body("Failed to create employee");
      }
    })
    .onErrorResume(exception -> {
      return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Internal Server Error: " + exception.getMessage()));
    });
}
```

### Using WebClient to Submit Form Data

Another common usecase for WebClient is to post data in the MVC form style

In this case, we use `BodyInserters.fromFormData()` to create the form data by adding
key-value pairs where keys are form fields and values are input field values

The added fields are posted to the API URL as URL-encoded form data

```java
@Service
public class EmployeeService {

  private final WebClient webClient;

  @Autowired
  public EmployeeService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Mono<Employee> createEmployee(Map<String, String> formParams) {
    return webClient.post()
      .uri("/employees")
      .body(BodyInserters.fromFormData("id", formParams.get("id"))
        .with("name", formParams.get("name"))
        .with("status", formParams.get("status")))
      .retrieve()
      .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
        // Handle 4xx client errors here
      })
      .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
        // Handle 5xx server errors here
      })
      .toEntity(Employee.class)
      .flatMap(responseEntity -> Mono.justOrEmpty(responseEntity.getBody()));
  }
}
```

From the controller, we can call this method as follows:

```java
@PostMapping("/create-employee")
public Mono<ResponseEntity<Employee>> createEmployee(@RequestBody Map<String, String> formParams) {
  return employeeService.createEmployee(formParams)
    .map(employee -> ResponseEntity.ok(employee));
}
```

### Using WebClient to Upload a Multipart File

To submit a form with multipart form data and simple fields, we can use the `MultipartBodyBuilder` class to add different parts of the input form

```java
MultipartBodyBuilder builder = new MultipartBodyBuilder();

builder.part("file", new FileSystemResource("c:/temp/file-name.txt"));
builder.part("id", "190001", MediaType.TEXT_PLAIN);
builder.part("name", "Sam", MediaType.TEXT_PLAIN);
builder.part("status", "active", MediaType.TEXT_PLAIN);
```

Then we can submit the multipart form data by using the method `BodyInserters.fromMultipartData(builder.build())`
and send a normal request as in the previous examples

```java
webClient.post()
  .uri("/employees")
  .contentType(MediaType.MULTIPART_FORM_DATA)
  .body(BodyInserters.fromMultipartData(builder.build()))
  .retrieve()
  .toEntity(Employee.class)
  .doOnError(WriteTimeoutException.class, ex -> {
    System.err.println("WriteTimeout");
  })
  .subscribe(responseEntity -> {
    System.out.println("Status: " + responseEntity.getStatusCode().value());
    System.out.println("Location URI: " + responseEntity.getHeaders().getLocation().toString());
    System.out.println("Created New Employee : " + responseEntity.getBody());
  });
```

### Sending URL/Query Parameters using WebClient

Generally, there is NO need to send the query parameters in a POST request

We should add all the needed information in the request body itself

But if in any case, we need to send the URL parameters in any POST request,
we can use `UriComponentsBuilder` to build the request URI with the parameters in it

```java
String endpoint = "/employees";

UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromPath(endpoint)
  .queryParam("param1", "value1")
  .queryParam("param2", "value2");

webClient.post()
  .uri(uriBuilder.build().toUri())
  .bodyValue(new Employee(...))
  .retrieve()
  // ...
```

### Sending Request Headers using WebClient

The custom request headers are set using the `.header()` method while building the `WebClient` request

The headers can be needed for many reasons such as authorization information, user agent, API version information, preferred data center location etc

```java
webClient.get()
  .uri("/employees")
  .bodyValue(new Employee(...))
  .header("Authorization", "Bearer auth-token")
  .header("User-Agent", "Mobile App 1.0")
  .retrieve()
  // ...
```

## Spring WebClient `Retry` and `RetryWhen` - HowToDoInJava

- [Spring WebClient `Retry` and `RetryWhen` - HowToDoInJava](https://howtodoinjava.com/spring-webflux/retry-with-spring-webclient/)

When a service downstream doesn't respond within a specific time limit or replies with a server error
related to its momentary inability to process the request, you can configure your client to try again

Prefix = `webClient.get().retrieve().onStatus(...).bodyToMono(String.class)`

| Retry Configuration                                                                                      | What does it do?                                                                                                                                                                                                              |
| -------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class);`                                     | No retry                                                                                                                                                                                                                      |
| Note: The prefix of `webClient.get().retrieve().onStatus(...).bodyToMono(String.class)` is OMITTED BELOW |                                                                                                                                                                                                                               |
| `.retry();`                                                                                              | Retry indefinitely                                                                                                                                                                                                            |
| `.retry(3);`                                                                                             | Retry 3 times before failing                                                                                                                                                                                                  |
| `.retryWhen(Retry.max(3).doBeforeRetry(...)));`                                                          | Perform an action before each retry                                                                                                                                                                                           |
| `.retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(2)));`                                                | Retry 3 times, and add a delay of 2 seconds before 2nd and 3rd retries.                                                                                                                                                       |
| `.retryWhen(Retry.backoff (3, Duration.ofSeconds(2)))`                                                   | Retry 3 times with each retry attempt with an exponential delay. `Retry.backoff (numRetries, initialDelay)` gives a delay of `initialDelay * 2^(retryAttempt-1)` for each `retryAttempt` (where `retryAttempt` starts at `1`) |
| `.retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).jitter(0.75));`                                      | Add random delay with Jitter which prevents replicas from retrying simultaneously                                                                                                                                             |
| `.retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).onRetryExhaustedThrow(...));`                        | Throw an Exception once the retry limit is reached.                                                                                                                                                                           |
| `.retryWhen(...).filter(ex -> ex instanceof ServiceException));`                                         | Retry on a specific exception                                                                                                                                                                                                 |

| Retry Configuration                                                                                                                                | What does it do?                                                                                                                                                                                   |
| -------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class);`                                                                               | No retry                                                                                                                                                                                           |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class).retry();`                                                                       | Retry indefinitely                                                                                                                                                                                 |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class).retry(3);`                                                                      | Retry 3 times before failing                                                                                                                                                                       |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class).retryWhen(Retry.max(3).doBeforeRetry(...)));`                                   | Perform an action before each retry                                                                                                                                                                |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class).retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(2)));`                         | Retry 3 times, and add a delay of 2 seconds before 2nd and 3rd retries.                                                                                                                            |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class).retryWhen(Retry.backoff (3, Duration.ofSeconds(2)))`                            | Retry 3 times with each retry attempt with a growing delay                                                                                                                                         |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class).retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).jitter(0.75));`               | Add random delay with Jitter which prevents replicas from retrying simultaneously                                                                                                                  |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class).retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).onRetryExhaustedThrow(...));` | Throw an Exception once the retry limit is reached.                                                                                                                                                |
| `webClient.get().retrieve().onStatus(...).bodyToMono(String.class).retryWhen(...).filter(ex -> ex instanceof ServiceException));`                  | Retry on a specific exception `webClient.get().retrieve().onStatus(...).bodyToMono(String.class).retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).filter(ex -> ex instanceof ServiceException));` |

### What is a Retry? Why do we need it?

When we invoke remote APIs, failures may happen due to various reasons such as a network outage, server being down, network glitch, rate limit, etc

In such cases, we usually try to retry the operation a few times before sending an error response to the client

> Retries increase the chance of getting a response back from a remote service when it's momentarily overloaded or unresponsive

We need to carefully design the retry strategy in our application to make it efficient

Best practices for retries:

- Limit the number of retries
  - Do not retry indefinitely. Have a hard stop on the number of retries. If the API call is still failing after the set number of retries, it's better to communicate the failure
- Retry only for transient/server-side errors:
  - Transient errors are temporary and are most likely resolved by retrying a few times
  - The remote server being unavailable is one such example
  - Do NOT retry for failures caused by invalid data or authentication errors since retries would not help here
- Use exponential back-off for retry:
  - Exponential back-off is to increase the delay between each retry
  - E.g. If we have 3 retry attempts and the first retry is after 2 seconds, the second retry could be after 3 seconds, and the third after 5 seconds. We could also add a random jitter with exponential back-off
- Watch out for time spent:
  - We must remember to balance resilience and user experience
  - You don't want users to wait too long while retrying the request behind the scenes
  - If you can't avoid that, make sure you inform the users and give them feedback about the status of the request

Also, consider combining timeout with the retry mechanism for a time-bound response to users

### Initial Setup

We will be creating a simple Spring Boot web application which would call mocked external APIs using WebClient. For mocking the webserver, we will be using WireMock

#### Maven

To use WebClient, we must have the `spring-boot-starter-webflux` module imported into our Spring Boot project

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

#### Application Setup

Let's create our Controller which would expose `http://localhost:8000/helloWorldResource`
This would invoke the service which uses WebClient for external calls

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {
  @Autowired
  private HelloWorldService helloWorldService;

  @GetMapping(value = "/helloWorldResource")
  public Mono<String> getResource() {
    return helloWorldService.getResource();
  }
}
```

Let's add the WebClient configuration which will help us configure the 'baseURL' for the remote APIs

Here, we configure the baseUrl as 'http://localhost:8080/api/v1' which we setup in the next section

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  @Bean
  public WebClient webClient() {
    return WebClient.builder().baseUrl("http://localhost:8080/api/v1").build();
  }
}
```

#### Simulating Service Failures using WireMock

Let's simulate an API would can be invoked at http://localhost:8080/api/v1

The first 2 invocations of this API would fail, whereas the third invocation would return a successful response

To do the same we need to use [WireMock's stateful behavior](https://wiremock.org/docs/stateful-behaviour/)

```java
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.stubbing.Scenario;

public class MockServer {

  private static final String SECOND_FAILURE = "Second Failure";
  private static final String FIRST_FAILURE = "First Failure";
  private static final String SERVICE_UNAVAILABLE = "Service Unavailable";
  private static final String RETRY_SCENARIOS = "Retry Scenarios";
  private static final String API_URL = "/api/v1";
  private static final String SUCCESS_RESPONSE = "Hello World!";

  public static void main(String[] args) {
    WireMockServer wireMockServer = new WireMockServer();
    wireMockServer.start();

    stubFor(get(urlEqualTo(API_URL)).inScenario(RETRY_SCENARIOS).whenScenarioStateIs(Scenario.STARTED)
      .willReturn(aResponse().withStatus(503).withBody(SERVICE_UNAVAILABLE))
      .willSetStateTo(FIRST_FAILURE));

    stubFor(get(urlEqualTo(API_URL)).inScenario(RETRY_SCENARIOS).whenScenarioStateIs(FIRST_FAILURE)
      .willReturn(aResponse().withStatus(503).withBody(SERVICE_UNAVAILABLE))
      .willSetStateTo(SECOND_FAILURE));

    stubFor(get(urlEqualTo(API_URL)).inScenario(RETRY_SCENARIOS).whenScenarioStateIs(SECOND_FAILURE)
      .willReturn(aResponse().withStatus(200).withBody(SUCCESS_RESPONSE))
      .willSetStateTo(Scenario.STARTED));
  }
}
```

### Retry Mechanisms with WebClient

Spring WebClient provides several built-in mechanisms for handling retries for Mono and Flux APIs

- `.retry()`
  - Indefinite retries in case of errors
  - It reties the entire HTTP request, regardless of the response status code
- `.retry(count)`
  - Takes a long parameter to limit the number of retries
- `.retryWhen(Retry retrySpec)`
  - Retries based on the strategy defined in the Retry specification

#### Default Behavior

By default, `.retry()` would re-subscribe indefinitely

- This is NOT ideal and can bring down the remote APIs
- We must retry only a few times before failing

Since our Mock server would fail twice before giving a successful response, let's retry three times before failing

In this case `.retry()` would re-subscribe to the Mono three times before failing

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class HelloWorldService {
  @Autowired
  private WebClient webClient;

  public Mono<String> getResource() {
    return webClient.get()
      .retrieve()
      .bodyToMono(String.class)
      .retry(3);
  }
}
```

The same behavior can be achieved using `.retryWhen()` using the Retry spec

- We are also adding logging to see if it's actually retrying

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class HelloWorldService {
  @Autowired
  private WebClient webClient;

  public Mono<String> getResource() {
    return webClient.get()
      .retrieve()
      .bodyToMono(String.class)
      .retryWhen(Retry.max(3)
        .doBeforeRetry(x -> logger.info("Retrying " + x.totalRetries())));
  }
}
```

This produces the following output which indicates the third invocation gave a successful response

```log
2023-10-07T19:36:52.295+05:30  INFO 24892 --- [ctor-http-nio-3] c.h.caffeine.service.HelloWorldService   : Retrying 0
2023-10-07T19:36:52.303+05:30  INFO 24892 --- [ctor-http-nio-3] c.h.caffeine.service.HelloWorldService   : Retrying 1
```

Notice that the above retries are instant, which means the client does NOT wait before retrying

Starting a sequence of retry attempts, one after the other, risks making the system even more unstable

### Retry with Fixed Delay

Ideally we want to give the server some time to recover before retrying again

In such instances, it's a good practice to add some delay before trying again

Let's add a delay of 2 seconds before each retry using the `Retry.fixedDelay()` method

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import java.time.Duration;

@Component
public class HelloWorldService {
  @Autowired
  private WebClient webClient;

  public Mono<String> getResource() {
    return webClient.get()
      .retrieve()
      .bodyToMono(String.class)
      .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(2)));
  }
}
```

### Retry with Exponential Backoff

A better approach is using an exponential backoff strategy to perform each retry attempt with a growing delay

By waiting for more and more time between one attempt and the next, you're more likely
to give the backing service time to recover and become responsive again

Exponential backoff is used to increase the delay between each retry

This is achieved using the `Retry.backoff()` method and gives the server an even
better chance of recovery and hence greater chances of a successful response on retry

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import java.time.Duration;

@Component
public class HelloWorldService {
  @Autowired
  private WebClient webClient;

  public Mono<String> getResource() {
    return webClient.get()
      .retrieve()
      .bodyToMono(String.class)
      .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)));
  }
}
```

### Adding Randomness with Jitter

To add randomness between the already delayed retries, we may consider adding the jitter to the delay interval

**When you have multiple instances of API clients running, the jitter factor ensures that the replicas will NOT retry requests simultaneously**.

In the following example, the code will retry with a jitter of at most 75% of the computed delay

- By default, a jitter of at most 50% of the computed delay is used

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import java.time.Duration;

@Component
public class HelloWorldService {
  @Autowired
  private WebClient webClient;

  public Mono<String> getResource() {
    return webClient.get()
      .retrieve()
      .bodyToMono(String.class)
      .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).jitter(0.75));
  }
}
```

### Handling Exhausted Retries

There will be cases when retries may not help solve the problem

This would mean we exhaust all the retries available and the client would fail with a `RetryExhaustedException`.

We can override this behavior to handle exhausted retries using the `.onRetryExhaustedThrow()` method

Let's create a custom ServiceException which would be thrown once the retries are exhausted

```java
public class ServiceException extends RuntimeException {
  public ServiceException(String message) {
    super(message);
  }
}
```

We can now configure to throw the `ServiceException` once the retry limit is reached

This will ensure if the request fails after retries, a `ServiceException` is thrown

We can handle this exception using `@ControllerAdvice` and `@ExceptionHandler` annotation

```java
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import java.time.Duration;
// import your.package.ServiceException; // Replace 'your.package' with the actual package name where ServiceException is located

@Component
public class HelloWorldService {
  @Autowired
  private WebClient webClient;

  public Mono<String> getResource() {
    return webClient.get()
      .retrieve()
      .bodyToMono(String.class)
      .retryWhen(Retry.backoff(3, Duration.ofSeconds(2))
        .onRetryExhaustedThrow((spec, signal) -> {
          throw new ServiceException(
            "Error: Service call failed after retrying " + signal.totalRetries() + " times");
        }));
  }
}
```

### Retry Only for Specific Status Codes

WebClient also offers the possibility of retrying on specific HTTP response codes

For example, we can add retry logic only if the server returns a 5xx HTTP code in the response

To achieve status-code-based retries, we throw `ServiceException` in case of 5xx response codes

For any other response codes, no exception is thrown

We can take advantage of this to filter out only `ServiceException` for retrying

A typical flow would look like:

- Check the response status using `.onStatus()`
- If the status is 5xx, throw `ServiceException`
- Filter for `ServiceException` in `.retryWhen()`

```java
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import java.time.Duration;
import org.springframework.http.HttpStatus;

@Component
public class HelloWorldService {
  @Autowired
  private WebClient webClient;

  public Mono<String> getResource() {
    return webClient.get()
      .retrieve()
      .onStatus(HttpStatusCode::is5xxServerError, resp -> Mono.error(new ServiceException(resp.statusCode().toString())))
      .bodyToMono(String.class)
      .retryWhen(Retry.backoff(3, Duration.ofSeconds(2))
        .filter(ex -> ex instanceof ServiceException));
  }
}
```

### Retry with Timeout

Note: Be very careful when you combine the `.timeout()` method with retry logic

- Their order of appearance matters a lot and can change their meaning completely

> Note: Placing the `.retryWhen()` operator AFTER `.timeout()` means that the timeout is applied to EACH retry attempt

```java
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import java.time.Duration;

@Component
public class HelloWorldService {
  @Autowired
  private WebClient webClient;

  public Mono<String> getResource() {
    return webClient.get()
      .retrieve()
      .bodyToMono(String.class)
      .timeout(Duration.ofSeconds(2))
      .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)));
  }
}
```

> Note: Placing the `.retryWhen()` operator BEFORE `.timeout()` means that the timeout is applied to the OVERALL operation
> This means that the whole sequence of the initial request and retries MUST happen WITHIN the given time limit

```java
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import java.time.Duration;

@Component
public class HelloWorldService {

  @Autowired
  private WebClient webClient;

  public Mono<String> getResource() {
    return webClient.get()
      .retrieve()
      .bodyToMono(String.class)
      .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)))
      .timeout(Duration.ofSeconds(2));
  }
}
```

## Spring WebClient Timeout: `Global` vs `Request-Level` - HowToDoInJava

- [Spring WebClient Timeout: `Global` vs `Request-Level` - HowToDoInJava](https://howtodoinjava.com/spring-webflux/webclient-set-timeouts/)

Spring WebClient is a powerful tool for making HTTP requests in a reactive way,
and it provides flexible options for setting timeouts

### Setting Timeouts Globally

Global timeouts are applied to ALL requests made with a specific `WebClient` instance

- This is useful when we want to set a timeout for ALL requests to a particular service or API

To set a global timeout, we must configure the timeouts at the `WebClient` instance level,
and use this instance in all services

- One of the most natural ways to configure timeouts at the WebClient level is configuring the underlying HTTP client
- Spring provides built-in support for some HTTP client libraries, and Reactor Netty is used by default
  - https://docs.spring.io/spring-framework/reference/web/webflux-webclient/client-builder.html
  - https://github.com/reactor/reactor-netty

In the example code below, we are setting

- Connection Timeout: to 10,000 milliseconds (10 seconds) using `ChannelOption.CONNECT_TIMEOUT_MILLIS`
- Read Timeout: of 10 seconds using `ReadTimeoutHandler` class
  - This means if no data is received within 10 seconds of making a request, a `ReadTimeoutException` exception will be thrown
  - [ReadTimeoutHandler](https://netty.io/4.1/api/io/netty/handler/timeout/ReadTimeoutHandler.html)
  - [ReadTimeoutException](https://netty.io/4.1/api/io/netty/handler/timeout/ReadTimeoutException.html)
- Write Timeout: of 10 seconds using `WriteTimeoutHandler` class
  - When a write operation cannot finish in the specified period of time, a `WriteTimeoutException` exception will be thrown
  - [WriteTimeoutHandler](https://netty.io/4.1/api/io/netty/handler/timeout/WriteTimeoutHandler.html)
  - [WriteTimeoutException](https://netty.io/4.1/api/io/netty/handler/timeout/WriteTimeoutException.html)

```java
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {

  @Bean
  public WebClient getWebClient() {

    HttpClient httpClient = HttpClient.create()
      .tcpConfiguration(client -> client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
        .doOnConnected(conn -> conn
          .addHandler(new ReadTimeoutHandler(10, TimeUnit.SECONDS))
          .addHandlerLast(new WriteTimeoutHandler(10, TimeUnit.SECONDS))));

    ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient.wiretap(true));

    return WebClient.builder()
      .baseUrl("http://localhost:3000")
      .clientConnector(connector)
      .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .build();
  }
}
```

### Setting Timeouts at Request Level

There are situations where we may want different timeouts for different requests

We can set request-specific timeouts by chaining the `.timeout()` method to the Mono or Flux returned by the `WebClient` request

Request-level timeouts override the global timeout settings, if any

The `.timeout(Duration)` method in both classes is overloaded with many options

- [Mono](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html#timeout-java.time.Duration-)
- [Flux](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#timeout-java.time.Duration-)

In the example below, we set a timeout of 10 seconds specifically for the request made with uri(`/employees`)
In that situation, the `TimeoutException` is thrown in case no item is received within the given 10 seconds

> The `.timeout()` method applies the timeout to the whole operation, from initiating the connection to receiving the response
>
> Note: It does NOT allow configuring feature-specific timeout settings as we set at `HttpClient` level

```java
import java.time.Duration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmployeeService {

  private final WebClient webClient;

  public EmployeeService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Flux<Employee> findAll() {
    return webClient.get()
      .uri("/employees")
      .retrieve()
      .bodyToFlux(Employee.class)
      .timeout(Duration.ofMillis(10_000));
  }

  public Mono<Employee> create(Employee empl) {
    return webClient.post()
      .uri("/employees")
      .body(Mono.just(empl), Employee.class)
      .retrieve()
      .bodyToMono(Employee.class)
      .timeout(Duration.ofMillis(10_000));
  }
}
```

By using `.onError()` blocks, we can gracefully handle timeout exceptions and other specific exceptions that may occur
during the `WebClient` requests while providing appropriate error-handling strategies

> Note: Mono timeouts set via `Mono.timeout()` do NOT change the GLOBAL timeout, so it will work only
> when the overridden timeout is SHORTER/LESS THAN the GLOBAL timeout set with `HttpClient`
>
> Alternatively, you can create a new instance of `WebClient`, by copying all settings
> from globally configured `WebClient`, and then only resetting the `HttpClient` instance with new global timeouts

```java
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

public class CustomWebClient {

  public WebClient customiseWebClient(WebClient existingWebClient) {
    HttpClient customHttpClient = HttpClient.create() // <-- HERE
      .responseTimeout(Duration.ofSeconds(5));

    HttpClient customHttpClient2 = HttpClient.create() // <-- HERE
      .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(5, TimeUnit.SECONDS))
        .addHandlerLast(new WriteTimeoutHandler(5, TimeUnit.SECONDS)));

    WebClient customWebClient = existingWebClient.mutate()
      .clientConnector(new ReactorClientHttpConnector(customHttpClient))
      .build();

    return customWebClient;
  }
}
```

### `.responseTimeout(Duration)` vs `ReadTimeoutHandler(long timeout, TimeUnit unit)` vs `WriteTimeoutHandler(long timeout, TimeUnit unit)`

`.responseTimeout(Duration.ofSeconds(5))`
This sets a maximum duration for the entire response to be received after the request has been sent. If the response is not fully received within this duration, a timeout error occurs
It applies to the total response time, including the time to establish the connection, send the request, and receive the full response
It's a high-level timeout setting that is useful for setting an upper bound on how long you're willing to wait for a response from the server

`ReadTimeoutHandler(5, TimeUnit.SECONDS)`
This handler sets a timeout for read operations on the connection. If no data is read (i.e., received from the server) within the specified timeout period, a timeout error occurs
It's more granular and applies specifically to the intervals between data packets being received. If the data is being received but is slow, the read timeout might not trigger as long as packets keep coming in within the timeout interval

`WriteTimeoutHandler(5, TimeUnit.SECONDS)`
Similar to the ReadTimeoutHandler, but for write operations. If no data is written (sent to the server) within the specified timeout period, a timeout error occurs
This is useful for detecting issues with sending data where, for some reason, the client is unable to send data packets within the expected timeframe
In summary, responseTimeout is a broad measure of the total time a response takes, while ReadTimeoutHandler and WriteTimeoutHandler provide more fine-grained control over the read and write operations, respectively. These more granular timeouts are particularly useful in streaming scenarios or when dealing with large payloads that are transmitted over a prolonged period

### Handling Timeout Exceptions

When a timeout occurs, an exception is thrown

- `TimeoutException`
- `WebClientResponseException`
- `WebClientRequestException`

We can handle these timeout exceptions by providing an error handler in the `.subscribe()` method and/or `.onError()` blocks

```java
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.netty.exceptions.ConnectTimeoutException;
import reactor.netty.exceptions.ReadTimeoutException;

@SpringBootTest
public class WebClientTest {

  @Autowired
  private WebClient webClient; // Assuming WebClient is configured as a Spring bean

  @Test
  public void testWebClientResponse() {
    webClient.get()
      .uri("/employees")
      .retrieve()
      .bodyToFlux(Employee.class)
      .timeout(Duration.ofSeconds(10))
      .onErrorResume(ConnectTimeoutException.class, ex -> {
        // Handle ConnectTimeoutException here
        System.err.println("Connect timeout occurred: " + ex.getMessage());
        return Flux.empty();
      })
      .onErrorResume(ReadTimeoutException.class, ex -> {
        // Handle ReadTimeoutException here
        System.err.println("Read timeout occurred: " + ex.getMessage());
        return Flux.empty();
      })
      .subscribe(
        response -> {
          // Handle the successful response
          System.out.println("Response: " + response);
        },
        error -> {
          // Handle other errors, if any
          System.err.println("Unhandled error: " + error.getMessage());
        });
  }
}
```

### Summary

Spring WebClient provides both global and request-specific timeout options to give us flexibility in handling different scenarios. By understanding and using these timeout settings effectively, we can improve the reliability of the reactive applications when making HTTP requests

- GLOBAL timeouts can be set using the `HttpClient` configuration on the WebClient instance and apply to ALL requests made with that instance
- REQUEST-SPECIFIC timeouts are set on a per-request basis using the `.timeout()` method on the Mono or Flux returned by WebClient requests
- Handle timeouts in the error handler of the `.subscribe()` or `.onError()` blocks to implement appropriate error-handling strategies

## Spring WebClient - Pushkar Kumar

> The Spring WebClient is an asynchronous and non-blocking reactive HTTP library

Note: You can still make synchronous requests with WebClient

- [Spring WebClient vs RestTemplate](https://medium.com/@kmrpushkar09/spring-webclient-vs-resttemplate-whats-better-in-2023-99844f649b53)

### Implementation of Spring WebClient

#### Dependency pom.xml

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

#### Create a Bean for Spring WebClient

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

  @Bean
  public WebClient webClient() {

    WebClient webClient = WebClient.builder()
      .baseUrl("http://localhost:3000")
      .defaultCookie("cookie-name", "cookie-value")
      .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .build();
  }
}
```

#### Invoking Bean in Project

```java
@Service
public class MyService {

  private final WebClient webClient;

  @Autowired
  public MyService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Mono<Employee> createEmployee(Employee employee) {
    Mono<Employee> employeeMono = webClient.post()
      .uri("/employees")
      .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
      .body(Mono.just(employee), Employee.class)
      .retrieve()
      .bodyToMono(Employee.class);
    return employeeMono;
  }

  public Mono<Employee> getEmployee() {
    Mono<Employee> employeeMono = webClient.get()
      .uri("/employees/{id}", 123)
      .retrieve()
      .bodyToMono(Employee.class);
    return employeeMono;
  }
}
```

## Spring WebClient - Java Techie

https://www.youtube.com/watch?v=eyN9H_EA7tI&list=PLVz2XdJiJQxw-jVLpBfVn2yqjvA1Ycceq

https://github.com/Java-Techie-jt/spring5-webclient
