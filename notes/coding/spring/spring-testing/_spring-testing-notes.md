# Table of Contents

- [Table of Contents](#table-of-contents)
- [Official Docs](#official-docs)
  - [Spring Framework](#spring-framework)
  - [Spring Boot](#spring-boot)
  - [Spring HTTP Package (under Spring Framework)](#spring-http-package-under-spring-framework)
  - [Spring WebFlux](#spring-webflux)
  - [Spring Test](#spring-test)
  - [Spring Security](#spring-security)
  - [SpringDoc](#springdoc)
  - [JUnit5](#junit5)
  - [Mockito](#mockito)
  - [MockWebServer](#mockwebserver)
  - [Reactive Streams](#reactive-streams)
  - [Project Reactor](#project-reactor)
  - [Netty](#netty)
- [JUnit5](#junit5-1)
  - [JUnit5 Tutorial - HowToDoInJava](#junit5-tutorial---howtodoinjava)
    - [JUnit5 Maven Dependencies](#junit5-maven-dependencies)
    - [JUnit5 Annotations](#junit5-annotations)
      - [Custom Composed Annotations](#custom-composed-annotations)
    - [JUnit5 Test Example](#junit5-test-example)
    - [Writing JUnit 5 Test Suites](#writing-junit-5-test-suites)
    - [JUnit5 Assertions](#junit5-assertions)
    - [JUnit5 Assumptions](#junit5-assumptions)
    - [JUnit 4 to JUnit 5 Migration](#junit-4-to-junit-5-migration)
  - [JUnit + MockWebServer - HowToDoInJava](#junit--mockwebserver---howtodoinjava)
    - [Maven Dependencies](#maven-dependencies)
    - [Starting and Stopping the MockWebServer](#starting-and-stopping-the-mockwebserver)
    - [Setting Up Mocks](#setting-up-mocks)
      - [Using `mockServer.enqueue()`](#using-mockserverenqueue)
      - [Using Dispatcher](#using-dispatcher)
    - [Writing Tests](#writing-tests)
      - [Normal JUnit Tests](#normal-junit-tests)
    - [Error Conditions](#error-conditions)
    - [Verifying Server Stats](#verifying-server-stats)
- [Mockito](#mockito-1)
  - [Getting Started With Mockito and JUnit - HowToDoInJava](#getting-started-with-mockito-and-junit---howtodoinjava)
    - [Introduction to Mockito](#introduction-to-mockito)
    - [Mockito Setup with JUnit](#mockito-setup-with-junit)
    - [Programmatic Initialization](#programmatic-initialization)
    - [Mockito Annotations](#mockito-annotations)
    - [Mockito Example/Demo](#mockito-exampledemo)
      - [System Under Test](#system-under-test)
      - [Test Example](#test-example)
  - [Mockito Annotations: `@Mock`, `@Spy`, `@InjectMocks`, `@Captor` - HowToDoInJava](#mockito-annotations-mock-spy-injectmocks-captor---howtodoinjava)
    - [Initializing Mockito Annotations](#initializing-mockito-annotations)
      - [With JUnit 5 / Spring Boot](#with-junit-5--spring-boot)
      - [Using `MockitoAnnotations.openMocks()`](#using-mockitoannotationsopenmocks)
    - [`@Mock`](#mock)
    - [`@Spy`](#spy)
    - [`@Captor`](#captor)
    - [`@InjectMocks`](#injectmocks)
    - [`@Mock` vs `@Spy`](#mock-vs-spy)
  - [`@Mock` vs `@InjectMocks` - HowToDoInJava](#mock-vs-injectmocks---howtodoinjava)
    - [What is a Mock?](#what-is-a-mock)
    - [`@Mock` vs `@InjectMocks`](#mock-vs-injectmocks)
    - [Example/Demo](#exampledemo)
      - [System Under Test](#system-under-test-1)
      - [Unit Test](#unit-test)
  - [Mock Static Methods with Mockito - HowToDoInJava](#mock-static-methods-with-mockito---howtodoinjava)
    - [Maven Dependency](#maven-dependency)
    - [System Under Test](#system-under-test-2)
    - [`MockedStatic` class](#mockedstatic-class)
    - [Mocking No-Args Static Methods](#mocking-no-args-static-methods)
    - [Mocking a Static Method with Arguments](#mocking-a-static-method-with-arguments)
  - [Verify Multiple Invocations with Different Arguments - HowToDoInJava](#verify-multiple-invocations-with-different-arguments---howtodoinjava)
    - [Verify Multiple Invocations with `ArgumentCaptor`](#verify-multiple-invocations-with-argumentcaptor)
  - [`Mockito.mock()` vs `@Mock` vs `@MockBean` - Baeldung](#mockitomock-vs-mock-vs-mockbean---baeldung)
    - [`Mockito.mock()`](#mockitomock)
    - [`@Mock` Annotation](#mock-annotation)
      - [Example using `MockitoJUnitRunner`](#example-using-mockitojunitrunner)
      - [Example using `MockitoAnnotations.openMocks()`](#example-using-mockitoannotationsopenmocks)
    - [`@MockBean` Annotation](#mockbean-annotation)
  - [`@Mock` vs `@MockBean` - StackOverflow](#mock-vs-mockbean---stackoverflow)
    - [Difference between `@Mock`, `@MockBean` and `Mockito.mock()`](#difference-between-mock-mockbean-and-mockitomock)
      - [Plain Mockito Library](#plain-mockito-library)
      - [Spring Boot Library Wrapping Mockito Library](#spring-boot-library-wrapping-mockito-library)
      - [When to use `@Mock` from Mockito and `@MockBean` From Spring Boot ?](#when-to-use-mock-from-mockito-and-mockbean-from-spring-boot-)
      - [Typical Usage of `@MockBean`](#typical-usage-of-mockbean)
- [Reactive Testing](#reactive-testing)
  - [Testing Reactive Streams Using `StepVerifier` and `TestPublisher` - Baeldung](#testing-reactive-streams-using-stepverifier-and-testpublisher---baeldung)
    - [Maven Dependencies](#maven-dependencies-1)
    - [`StepVerifier`](#stepverifier)
      - [Step-By-Step Scenario](#step-by-step-scenario)
      - [Exceptions in StepVerifier](#exceptions-in-stepverifier)
      - [Testing Time-Based Publishers](#testing-time-based-publishers)
      - [Post-Execution Assertions with `StepVerifier`](#post-execution-assertions-with-stepverifier)
    - [Producing Data with `TestPublisher`](#producing-data-with-testpublisher)
      - [Creating a TestPublisher](#creating-a-testpublisher)
      - [TestPublisher in Action](#testpublisher-in-action)
      - [Misbehaving `TestPublisher`](#misbehaving-testpublisher)
- [Spring Boot Testing](#spring-boot-testing)
  - [`@SpringBootTest` Annotation - HowToDoInJava](#springboottest-annotation---howtodoinjava)
    - [Using `@SpringBootTest` for Integration Testing](#using-springboottest-for-integration-testing)
    - [Using `@SpringBootTest` for Unit Testing](#using-springboottest-for-unit-testing)
      - [`classes` attribute](#classes-attribute)
      - [Test Annotations](#test-annotations)
  - [`@TestConfiguration` Annotation - HowToDoInJava](#testconfiguration-annotation---howtodoinjava)
    - [Creating `@TestConfiguration`](#creating-testconfiguration)
    - [Importing Test Configurations](#importing-test-configurations)
      - [Using `@Import`](#using-import)
    - [Using Static Nested `@TestConfiguration` Class](#using-static-nested-testconfiguration-class)
  - [Spring Boot 3 + JUnit 5 - HowToDoInJava](#spring-boot-3--junit-5---howtodoinjava)
    - [Maven](#maven)
    - [Writing JUnit 5 Tests](#writing-junit-5-tests)
    - [Running The Tests](#running-the-tests)
    - [JUnit5 Example Tests](#junit5-example-tests)
  - [Spring Boot 3 + JUnit5 + Mockito Example - HowToDoInJava](#spring-boot-3--junit5--mockito-example---howtodoinjava)
    - [Maven](#maven-1)
    - [Initializing Mocks](#initializing-mocks)
      - [`@Mock` vs `@InjectMocks`](#mock-vs-injectmocks-1)
      - [Initialization with `MockitoExtension`](#initialization-with-mockitoextension)
      - [Initialization with `MockitoAnnotations.openMocks()`](#initialization-with-mockitoannotationsopenmocks)
    - [Unit Tests Example](#unit-tests-example)
  - [MockMVC + `WebMvcTest` Annotation - HowToDoInJava](#mockmvc--webmvctest-annotation---howtodoinjava)
    - [Maven](#maven-2)
    - [Unit Test Structure](#unit-test-structure)
    - [MockMvc Example](#mockmvc-example)
      - [HTTP GET API](#http-get-api)
      - [HTTP POST API](#http-post-api)
      - [HTTP PUT API](#http-put-api)
      - [HTTP DELETE API](#http-delete-api)
  - [Testing POST APIs using `TestRestTemplate` - HowToDoInJava](#testing-post-apis-using-testresttemplate---howtodoinjava)
    - [Maven dependencies](#maven-dependencies-2)
    - [HTTP POST API](#http-post-api-1)
    - [Spring `TestRestTemplate`](#spring-testresttemplate)
  - [Testing Controller, Service and Dao Layers - HowToDoInJava](#testing-controller-service-and-dao-layers---howtodoinjava)
    - [Maven](#maven-3)
    - [Testing if Application Bootstraps Correctly](#testing-if-application-bootstraps-correctly)
    - [Unit Testing the REST `@Controller` Layer](#unit-testing-the-rest-controller-layer)
    - [Unit Testing the `@Service` Layer](#unit-testing-the-service-layer)
    - [Unit testing DAO/`@Repository` Layer](#unit-testing-daorepository-layer)
    - [Integration Testing](#integration-testing)
    - [Integration Testing using `TestRestTemplate`](#integration-testing-using-testresttemplate)
  - [Testing REST Controllers `@RestClientTest` - HowToDoInJava](#testing-rest-controllers-restclienttest---howtodoinjava)
    - [`@RestClientTest` Annotation](#restclienttest-annotation)
    - [Testing service which uses RestTemplateBuilder](#testing-service-which-uses-resttemplatebuilder)
    - [Testing Service which does NOT use RestTemplateBuilder](#testing-service-which-does-not-use-resttemplatebuilder)
  - [Testing REST Controllers with JUnit 5 - HowToDoInJava](#testing-rest-controllers-with-junit-5---howtodoinjava)
    - [Setup](#setup)
    - [Unit Testing Spring Controller using `@WebMvcTest`](#unit-testing-spring-controller-using-webmvctest)
    - [Unit Testing Spring Controller using Mockito](#unit-testing-spring-controller-using-mockito)
    - [Best Practices](#best-practices)
  - [Testing JPA Repositories using `@DataJpaTest` - HowToDoInJava](#testing-jpa-repositories-using-datajpatest---howtodoinjava)
    - [`@Repository` Annotation/Decorator](#repository-annotationdecorator)
    - [`@DataJpaTest` Annotation](#datajpatest-annotation)
      - [Embedded Database](#embedded-database)
      - [SQL Logs](#sql-logs)
      - [Transactions](#transactions)
      - [TestEntityManager](#testentitymanager)
      - [JUnit Runner](#junit-runner)
    - [Demo/Example](#demoexample)
  - [How to Write Unit Tests - HowToDoInJava](#how-to-write-unit-tests---howtodoinjava)
    - [Unit Test vs Integration Test](#unit-test-vs-integration-test)
    - [Maven](#maven-4)
    - [Initializing the Tests](#initializing-the-tests)
    - [JUnit4 - `@RunWith(SpringRunner.class)`](#junit4---runwithspringrunnerclass)
    - [JUnit4 with Mockito - `@RunWith(MockitoJUnitRunner.class)`](#junit4-with-mockito---runwithmockitojunitrunnerclass)
    - [JUnit5 - `@ExtendWith(SpringExtension.class)`](#junit5---extendwithspringextensionclass)
    - [JUnit5 with Mockito - `@ExtendWith(MockitoExtension.class)`](#junit5-with-mockito---extendwithmockitoextensionclass)
    - [Spring Boot Test Annotations](#spring-boot-test-annotations)
      - [`@SpringBootTest`](#springboottest)
      - [`@WebMvcTest`](#webmvctest)
      - [`@WebFluxTest`](#webfluxtest)
    - [`@TestConfiguration`](#testconfiguration)
      - [`@Import` Annotation](#import-annotation)
      - [Static Nested Classes](#static-nested-classes)
    - [Mocking](#mocking)
      - [Using `@Mock` Annotation](#using-mock-annotation)
      - [Without `@MockBean` Annotation](#without-mockbean-annotation)
  - [Adding Mocks to SpringApplicationContext using `@MockBean` - HowToDoInJava](#adding-mocks-to-springapplicationcontext-using-mockbean---howtodoinjava)
    - [`@MockBean` Annotation](#mockbean-annotation-1)
    - [Difference between Mockito `@Mock` and Spring Boot `@MockBean`](#difference-between-mockito-mock-and-spring-boot-mockbean)
    - [`@MockBean` in Unit Testing](#mockbean-in-unit-testing)
    - [`@MockBean` Example](#mockbean-example)
  - [How to Write Integration Tests - HowToDoInJava](#how-to-write-integration-tests---howtodoinjava)
    - [What to Test in Integration Testing?](#what-to-test-in-integration-testing)
    - [Writing the Integration Tests](#writing-the-integration-tests)
      - [Maven](#maven-5)
      - [REST Controller to Test](#rest-controller-to-test)
      - [Integration Tests Example](#integration-tests-example)
  - [Mocking APIs with `WireMock` - HowToDoInJava](#mocking-apis-with-wiremock---howtodoinjava)
    - [Maven Dependency](#maven-dependency-1)
    - [How to Use Wiremock](#how-to-use-wiremock)
      - [Via `WireMockServer`](#via-wiremockserver)
      - [Via `WireMockRule`](#via-wiremockrule)
      - [Via `@WireMockTest`](#via-wiremocktest)
      - [Enabling HTTPS](#enabling-https)
    - [WireMock Example](#wiremock-example)
    - [Advanced Usages](#advanced-usages)
      - [Configuring API Request](#configuring-api-request)
      - [Configuring API Response](#configuring-api-response)
      - [Testing API Delay and Timeouts](#testing-api-delay-and-timeouts)
      - [Testing Bad Responses](#testing-bad-responses)
      - [Verifying API Hits](#verifying-api-hits)
  - [`@WebFluxTest` + `WebTestClient` + JUnit 5](#webfluxtest--webtestclient--junit-5)
    - [Maven](#maven-6)
    - [`@WebFluxTest`](#webfluxtest-1)
    - [WebTestClient](#webtestclient)
    - [Testing Async Controller](#testing-async-controller)
      - [System Under Test](#system-under-test-3)
      - [JUnit Tests](#junit-tests)

# Official Docs

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

## JUnit5

- [`JUnit5` - Reference](https://junit.org/junit5/docs/current/user-guide/)
- [`JUnit5` - JavaDocs](https://junit.org/junit5/docs/current/api/)

## Mockito

- [`Mockito` - JavaDocs](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [`MockitoAnnotations` - JavaDocs](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/MockitoAnnotations.html)

## MockWebServer

- [MockWebServer - JavaDocs](https://square.github.io/okhttp/3.x/mockwebserver/index.html?okhttp3/mockwebserver/MockWebServer.html)
- [MockWebServer - javadoc.io](https://www.javadoc.io/doc/com.squareup.okhttp3/mockwebserver/3.14.9/overview-summary.html)

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

Netty 5.X is abandoned

- [Netty 4 - User Guide](https://netty.io/wiki/user-guide-for-4.x.html)
- [Netty 4.1 - JavaDocs](https://netty.io/4.1/api/index.html)

# JUnit5

## JUnit5 Tutorial - HowToDoInJava

- [JUnit 5 Tutorial - HowToDoInJava](https://howtodoinjava.com/junit-5-tutorial/)
- Resources
  - https://howtodoinjava.com/junit5/

JUnit 5 introduced the modular approach into the framework and it was capable of allowing JUnit to interact with different
programmatic clients that used different tools and IDEs

It introduced the following logical separation of concerns in form of APIs:

- An API to write tests, mainly for use by developers
- A mechanism for discovering and running tests
- An API to allow easy interaction with IDEs and tools and to run tests from them

> JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage

- JUnit Platform:
  - To be able to launch junit tests, IDEs, build tools or plugins need to include and extend platform APIs
    It defines the TestEngine API for developing new testing frameworks that run on the platform
    It also provides a Console Launcher to launch the platform from the command line and build plugins for Gradle and Maven
- JUnit Jupiter:
  - It includes new programming and extension models for writing tests
  - It has all new junit annotations and TestEngine implementation to run tests written with these annotations
- JUnit Vintage:
  - Its primary purpose is to support running JUnit 3 and JUnit 4 written tests on the JUnit 5 platform
  - It's there is backward compatibility
  - It requires JUnit 4.12 or later to be present on the class path or module path

![](https://howtodoinjava.com/wp-content/uploads/2021/11/JUnit-5-Architecture.png)

### JUnit5 Maven Dependencies

- `junit-jupiter-api`: It is the main module where all core annotations are located, such as @Test, Lifecycle method annotations and assertions
- `junit-jupiter-engine`: It has test engine implementation which is required at runtime to execute the tests
- `junit-jupiter-params`: It provides support for parameterized tests
- `junit-platform-suite`: It provides the @Suite support that makes the legacy JUnit 4's JUnitPlatform runner obsolete
- `junit-vintage-engine`: it contains the engine implementation to execute tests written in JUnit 3 or 4. For this purpose, of course, you also need the JUnit 3 or 4 jar

```xml
<properties>
  <junit.jupiter.version>5.8.1</junit.jupiter.version>
  <junit.platform.version>1.8.1</junit.platform.version>
</properties>
<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>${junit.jupiter.version}</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>${junit.jupiter.version}</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>${junit.jupiter.version}</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-suite</artifactId>
    <version>${junit.platform.version}</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

![](https://howtodoinjava.com/wp-content/uploads/2021/11/JUnit-Modules.jpg)

To be able to run tests from the command prompt, make sure your `pom.xml` configuration file includes a JUnit provider dependency for the Maven Surefire plugin

```xml
<build>
  <plugins>
    <plugin>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>2.22.2</version>
    </plugin>
  </plugins>
</build>
```

Now we open a command prompt into the project folder (the one containing the pom.xml file), and run this command

```sh
mvn clean
mvn test
mvn install

# All in one command to: compile, test and convert it into a runnable Java program (a jar file)
mvn clean install
```

### JUnit5 Annotations

| Annotation           | Description                                                                                                          |
| -------------------- | -------------------------------------------------------------------------------------------------------------------- |
| `@BeforeEach`        | The annotated method will be run before each test method in the test class                                           |
| `@AfterEach`         | The annotated method will be run after each test method in the test class                                            |
| `@BeforeAll`         | The annotated method will be run before all test methods in the test class. This method must be static               |
| `@AfterAll`          | The annotated method will be run after all test methods in the test class. This method must be static                |
| `@Test`              | It is used to mark a method as a junit test                                                                          |
| `@DisplayName`       | Used to provide any custom display name for a test class or test method                                              |
| `@Disable`           | It is used to disable or ignore a test class or test method from the test suite                                      |
| `@Nested`            | Used to create nested test classes                                                                                   |
| `@Tag`               | Mark test methods or test classes with tags for test discovery and filtering                                         |
| `@TestFactory`       | Mark a method as a test factory for dynamic tests                                                                    |
| `@ParameterizedTest` | Denotes that a method is a parameterized test                                                                        |
| `@RepeatedTest`      | Denotes that a method is a test template for a repeated test                                                         |
| `@TestClassOrder`    | Used to configure the test class execution order for @Nested test classes in the annotated test class                |
| `@TestMethodOrder`   | Used to configure the test method execution order for the annotated test class; similar to JUnit 4's @FixMethodOrder |
| `@Timeout`           | Used to fail a test, test factory, test template, or lifecycle method if its execution exceeds a given duration      |
| `@TempDir`           | Used to supply a temporary directory via field injection or parameter injection in a lifecycle method or test method |

A typical test class with JUnit 5 annotations is as follows:

```java
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JUnit5TestClass {

  @BeforeAll
  static void setUpClass() {
    // setup the common resource(s) for all tests
  }

  @AfterAll
  static void tearDownClass() {
    // close the common resource(s) for all tests
  }

  @Test
  void testMethod_For_Some_Action() {
    boolean result = systemUnderTest.someMethod();
    assertTrue(result);
  }

  @Test
  @Disabled
  void testMethod_For_Another_Action() {
    assertEquals(2, 1, "2 is not equal to 1"); //Not executed because it is disabled
  }
}
```

#### Custom Composed Annotations

We can also create composed annotations that will automatically inherit the semantics of its meta-annotations

For example, instead of copying and pasting `@Tag("development")`, we can create a composed annotation `@Dev` as follows:

```java
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("development")
public @interface Dev {
  //...
}
```

And then we can use `@Dev` annotation in tests that have to be executed on the development environment

This makes it easy to change the environment name later, if needed, without modifying all the test classes

```java
@Dev
@Test
void someTest() {
  // ...
}
```

### JUnit5 Test Example

There is not much change between JUnit 4 and JUnit 5 in test writing styles

- A test class is any top-level class, static member class, or `@Nested` class that contains AT LEAST ONE test method
  - Test classes must NOT be abstract and must have a single constructor
- A test method is written using `@Test`, `@RepeatedTest`, `@ParameterizedTest`, `@TestFactory`, or `@TestTemplate` annotations
- Test classes, test methods, and lifecycle methods are NOT required to be `public`, but they must NOT be `private`.
  - Using the `public` modifier is recommended

Here are sample tests with their life cycle methods

Notice all the annotations are coming from `org.junit.jupiter.api` package

```java
// JUnit 5 Tests
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.howtodoinjava.junit5.examples.Calculator;

public class AppTest {
  @BeforeAll
  static void setUp(){
    System.out.println("@BeforeAll executed");
  }

  @BeforeEach
  void setupThis(){
    System.out.println("@BeforeEach executed");
  }

  @Tag("DEV")
  @Test
  void testCalcOne() {
    System.out.println("Test 1 executed");
    Assertions.assertEquals( 4 , Calculator.add(2, 2));
  }

  @Tag("PROD")
  @Disabled
  @Test
  void testCalcTwo(){
    System.out.println("TEST 2 executed");
    Assertions.assertEquals( 6 , Calculator.add(2, 4));
  }

  @AfterEach
  void tearThis(){
    System.out.println("@AfterEach executed");
  }

  @AfterAll
  static void tear(){
    System.out.println("@AfterAll executed");
  }
}
```

### Writing JUnit 5 Test Suites

Using JUnit 5 test suites, you can run tests spread into multiple test classes and different packages

JUnit 5 provides these annotations to create test suites

- `@Suite`
- `@SelectClasses`
- `@SelectPackages`
- `@IncludePackages`
- `@ExcludePackages`
- `@IncludeClassNamePatterns`
- `@ExcludeClassNamePatterns`
- `@IncludeTags`
- `@ExcludeTags`

To execute the suite, you need to use `@Suite` annotation and include `junit-platform-suite` module in the project dependencies

```java
@Suite
@SelectPackages("com.howtodoinjava.junit5.examples")
public class JUnit5TestSuiteExample {
  //...
}
```

### JUnit5 Assertions

Assertions help in validating the expected output with the actual output of a test

To keep things simple, all JUnit Jupiter assertions are `static` methods in the `org.junit.jupiter.Assertions` class e.g. `assertEquals()`, `assertNotEquals()`

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.function.Supplier;

public class CalculatorTest {

  @Test
  void testCase() {
    // Test will pass
    assertNotEquals(3, Calculator.add(2, 2));
    // Test will fail
    assertNotEquals(4, Calculator.add(2, 2), "Calculator.add(2, 2) test failed");
    // Test will fail
    Supplier<String> messageSupplier = () -> "Calculator.add(2, 2) test failed";
    assertNotEquals(4, Calculator.add(2, 2), messageSupplier);
  }
}
```

- [More examples](https://howtodoinjava.com/junit5/junit-5-assertions-examples/)

### JUnit5 Assumptions

The `Assumptions` class provides static methods to support conditional test execution based on assumptions

A failed assumption results in a test being aborted

Assumptions are typically used whenever it does NOT make sense to continue the execution of a given test method

In the test report, these tests will be marked as passed

The Assumptions class has three such methods: `assumeFalse()`, `assumeTrue()` and `assumingThat()`

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

public class AppTest {
  @Test
  void testOnDev() {
    System.setProperty("ENV", "DEV");
    Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), AppTest::message);
  }

  @Test
  void testOnProd() {
    System.setProperty("ENV", "PROD");
    Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
  }

  private static String message() {
    return "TEST Execution Failed :: ";
  }
}
```

- [More examples](https://howtodoinjava.com/junit5/junit-5-assumptions-examples/)

### JUnit 4 to JUnit 5 Migration

While JUnit 5 provides support for JUnit 4's annotations, it's recommended to migrate to the new annotations to take full advantage of JUnit 5 features

The official JUnit 5 reference has a [list of changes](https://junit.org/junit5/docs/current/user-guide/#migrating-from-junit4-tips)
that we need to make for a robust migration. It provides a migration path with the help of the JUnit Vintage test engine

The main changes are listed below:

| Step                                   | Discussion                                                                                                                                         |
| -------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------- |
| Replace / update the dependencies      | JUnit 4 needed a single dependency whereas JUnit 5 needs several dependencies based on the usage of modules                                        |
| Replace the annotations                | JUnit 5 has a separate package structure than JUnit 4, so even if the annotation names are the same, we still need to change the import statements |
| Replace the assertions and assumptions | JUnit 5 has separate classes and packages for assertion and assumption statements. We need to use the new classes                                  |
| Replace JUnit 4 rules and runners      | This needs more careful changes. We need to understand the JUnit 5 upgrades and make those changes one by one in each class                        |

## JUnit + MockWebServer - HowToDoInJava

- [Getting Started with MockWebServer and JUnit - HowToDoInJava](https://howtodoinjava.com/java/library/mockwebserver-junit-webclient/)

The MockWebServer is a helpful library to mock dependent APIs on which the current component under test depends

Such mock APIs are extremely helpful in microservices architecture where we are developing
multiple dependent services at the same time

We will be using Spring WebClient as HTTP client to invoke the mocked APIs

### Maven Dependencies

The `MockWebServer` is part of `okhttp3` library so we need to import the following two dependencies

```xml
<dependency>
  <groupId>com.squareup.okhttp3</groupId>
  <artifactId>okhttp</artifactId>
  <version>4.12.0</version>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>com.squareup.okhttp3</groupId>
  <artifactId>mockwebserver</artifactId>
  <version>4.12.0</version>
  <scope>test</scope>
</dependency>
```

### Starting and Stopping the MockWebServer

We can use the `MockWebServer` similar to other such libraries, such as `WireMock`

Typically, we:

1. Configure the mocks
2. Start the server before tests begin
3. Run the tests and verify the responses
4. Stop the server after the end of the tests

The following example uses the `@BeforeAll` and `@AfterAll` hooks to start and stop the server

By default, the server starts in port 8080. We can use a different port by specifying in `.start()` method

```java
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import okhttp3.mockwebserver.MockWebServer;
import java.io.IOException;

public class MockWebServerTests {
  public static MockWebServer mockServer;

  @BeforeAll
  static void setUp() throws IOException {
    mockServer = new MockWebServer();
    mockServer.start(8080);
  }

  @AfterAll
  static void tearDown() throws IOException {
    mockServer.shutdown();
  }
}
```

If we want then we can create a NEW server instance for EVERY/EACH unit test

```java
// Method 1
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import okhttp3.mockwebserver.MockWebServer;
import java.io.IOException;

public class MockWebServerTests {
  public static MockWebServer mockServer;

  @BeforeEach
  static void setUp() throws IOException {
    mockServer = new MockWebServer();
    mockServer.start(8080);
  }

  @AfterEach
  static void tearDown() throws IOException {
    mockServer.shutdown();
  }
}
```

```java
// Method 2
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import okhttp3.mockwebserver.MockWebServer;
import java.io.IOException;

public class MockWebServerTests {
  public static MockWebServer mockServer;

  public void testA() throws Exception {
    MockWebServer mockServer = new MockWebServer();
    mockServer.start(8080);
    //...
    mockServer.shutdown();
  }
}
```

### Setting Up Mocks

#### Using `mockServer.enqueue()`

To setup mocks, we can use the `mockServer.enqueue()` method

We can enqueue as many responses as we want

Then we can hit the mocked API URL to fetch mocked responses in sequence

Note: `StepVerifier.create()` takes in a Mono/Flux as args and will automatically subscribe to the Mono/Flux when you chain methods onto it

```java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import java.io.IOException;

public class MockWebServerTests {
  public static MockWebServer mockServer;

  @InjectMocks
  private MyProvider myProvider;

  @BeforeEach
  static void setUp() throws IOException {
    mockServer = new MockWebServer();
    mockServer.start(8080);
  }

  @AfterEach
  static void tearDown() throws IOException {
    mockServer.shutdown();
  }

  public void test() throws Exception {
    MockWebServer server = new MockWebServer();
    mockServer.enqueue(new MockResponse().setBody("message 1"));
    mockServer.enqueue(new MockResponse().setBody("message 2"));
    mockServer.enqueue(new MockResponse().setBody("message 3"));

    StepVerifier.create(myProvider.sendRequest()) // Note: This assumes the .sendRequest() method returns an Object wrapped with Mono (e.g. Mono<JsonNode>)
    .expectNextMatches(response -> response.toString().contains("message 1"))
    .verifyComplete();
  }
}
```

#### Using Dispatcher

Returning the enqueued responses may NOT be suitable in all conditions

We can use `Dispatcher` class to devise our own logic to return API responses

In the example below, we are using a dispatcher to match the API URI of the incoming request and then return the response for a matching URI

```java
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.BeforeAll;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MockWebServerTests {
  public static MockWebServer server;
  final static Dispatcher dispatcher = new Dispatcher() {
    @Override
    public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
      switch (request.getPath()) {
      case "/api/v1/url-valid-one":
        return new MockResponse()
          .setResponseCode(201);
      case "/api/v1/url-valid-two":
        return new MockResponse()
          .setHeader("x-header-name", "header-value")
          .setResponseCode(200)
          .setBody("<response />");
      case "/api/v1/url-invalid-three":
        return new MockResponse()
          .setResponseCode(500)
          .setBodyDelay(5000, TimeUnit.SECONDS)
          .setChunkedBody("<error-response />", 5);
      case "/api/v1/urlinvalid-four":
        return new MockResponse()
          .setResponseCode(200)
          .setBody("{\"data\":\"\"}")
          .throttleBody(1024, 5, TimeUnit.SECONDS);
      }
      return new MockResponse().setResponseCode(404);
    }
  };

  @BeforeAll
  static void setUp() throws IOException {
    server = new MockWebServer();
    server.setDispatcher(dispatcher);
    server.start(8080);
  }

  @AfterAll
  static void tearDown() throws IOException {
    server.shutdown();
  }
}
```

### Writing Tests

#### Normal JUnit Tests

After setting up the mocks, we can hit the mock APIs using Spring WebClient

To get the API host URL, use the `server.getHostName()` method

```JAVA
WebClient webClient = WebClient.create(String.format("http://%s:8080", server.getHostName()));
```

Then, hit the mock API and pass on the request parameters and body, as necessary

```java
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class MockWebServerTests {
  public static MockWebServer server;
  final static Dispatcher dispatcher = new Dispatcher() {
    @Override
    public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
      switch (request.getPath()) {
      case "/api/v1/url-valid-one":
        return new MockResponse()
          .setResponseCode(201);
      case "/api/v1/url-valid-two":
        return new MockResponse()
          .setHeader("x-header-name", "header-value")
          .setResponseCode(200)
          .setBody("<response />");
      case "/api/v1/url-invalid-three":
        return new MockResponse()
          .setResponseCode(500)
          .setBodyDelay(5000, TimeUnit.SECONDS)
          .setChunkedBody("<error-response />", 5);
      case "/api/v1/urlinvalid-four":
        return new MockResponse()
          .setResponseCode(200)
          .setBody("{\"data\":\"\"}")
          .throttleBody(1024, 5, TimeUnit.SECONDS);
      }
      return new MockResponse().setResponseCode(404);
    }
  };

  @BeforeAll
  static void setUp() throws IOException {
    server = new MockWebServer();
    server.setDispatcher(dispatcher);
    server.start(8080);
  }

  @AfterAll
  static void tearDown() throws IOException {
    server.shutdown();
  }

  @Test
  public void testA() {
    WebClient webClient = WebClient.create(String.format("http://%s:8080", server.getHostName()));
    // <-- HERE
    Mono<String> apiResponse = webClient.post()
      .uri("/api/v1/url-valid-two")
      .body(Mono.just("<data />"), String.class)
      .header("Authorization", "Basic " + Base64Utils.encodeToString(("username:password").getBytes(StandardCharsets.UTF_8)))
      .retrieve()
      .bodyToMono(String.class);
  }
}
```

Once the API response is available, we can project Reactor's `StepVerifier` to test these async responses

```java
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class MockWebServerTests {
  public static MockWebServer server;
  final static Dispatcher dispatcher = new Dispatcher() {
    @Override
    public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
      switch (request.getPath()) {
      case "/api/v1/url-valid-one":
        return new MockResponse()
          .setResponseCode(201);
      case "/api/v1/url-valid-two":
        return new MockResponse()
          .setHeader("x-header-name", "header-value")
          .setResponseCode(200)
          .setBody("<response />");
      case "/api/v1/url-invalid-three":
        return new MockResponse()
          .setResponseCode(500)
          .setBodyDelay(5000, TimeUnit.SECONDS)
          .setChunkedBody("<error-response />", 5);
      case "/api/v1/urlinvalid-four":
        return new MockResponse()
          .setResponseCode(200)
          .setBody("{\"data\":\"\"}")
          .throttleBody(1024, 5, TimeUnit.SECONDS);
      }
      return new MockResponse().setResponseCode(404);
    }
  };

  @BeforeAll
  static void setUp() throws IOException {
    server = new MockWebServer();
    server.setDispatcher(dispatcher);
    server.start(8080);
  }

  @AfterAll
  static void tearDown() throws IOException {
    server.shutdown();
  }

  @Test
  public void testA() {
    WebClient webClient = WebClient.create(String.format("http://%s:8080", server.getHostName()));
    Mono<String> apiResponse = webClient.post()
      .uri("/api/v1/url-valid-two")
      .body(Mono.just("<data />"), String.class)
      .header("Authorization", "Basic " + Base64Utils.encodeToString(("username:password").getBytes(StandardCharsets.UTF_8)))
      .retrieve()
      .bodyToMono(String.class);
    StepVerifier.create(apiResponse)
      .expectNext("<response />")
      .verifyComplete();
  }
}
```

### Error Conditions

API responses will NOT be successful all the time

- We may get different error codes and other fails such as network issues and latencies
- `MockWebServer` supports these kinds of erroneous mock responses

For example, we can test the timeout logic and delayed responses using `.setBodyDelay()` method

```java
return new MockResponse()
  .setResponseCode(200)
  .setBodyDelay(5000, TimeUnit.MILLISECONDS)
  .setBody("<data-response />");
```

To test a slow network, we can use `.setChunkedBody()` method to send the response in chunks

- The given mock will send the response in 5 chunks

```java
return new MockResponse()
  .setResponseCode(200)
  .setChunkedBody("<data-response />", 5);
```

### Verifying Server Stats

Sometimes it is important to verify how many times a request was hit on the mock server

- This is especially useful when we are implementing and testing the retry logic
- We can use `RecordedRequest` instance to fetch the details of HTTP requests `MockWebServer` to make sure our WebClient sent it correctly

```java
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ServerTest {
  private static MockWebServer server;

  @BeforeAll
  static void setUp() throws IOException {
    server = new MockWebServer();
    server.start();
  }

  @AfterAll
  static void tearDown() throws IOException {
    server.shutdown();
  }

  @Test
  void testRequest() throws InterruptedException {
    RecordedRequest request = server.takeRequest();
    Assertions.assertEquals("/api/v1/url-valid-two", request.getPath());
    Assertions.assertEquals("POST", request.getMethod());
    Assertions.assertNotNull(request.getHeader("Authorization"));
    Assertions.assertEquals("<data />", request.getBody().readUtf8());
  }
}
```

# Mockito

[Mockito Docs](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
[MockitoAnnotations Docs](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/MockitoAnnotations.html)

## Getting Started With Mockito and JUnit - HowToDoInJava

- [Getting Started With Mockito and JUnit - HowToDoInJava](https://howtodoinjava.com/mockito/junit-mockito-example/)

Quick Reference for Mockito with JUnit 5

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
  @Mock
  private ItemRepository itemRepository;

  @InjectMocks
  private ItemService itemService; // Assuming ItemService uses ItemRepository

  @Test
  public void testCreateItem() {
    // ...
  }
}
```

### Introduction to Mockito

Mockito is an open-source framework that allows us to create test doubles (mocks) easily

- A 'test double' is a generic term for any case where we replace a production object for testing purposes

In Mockito, we generally work with the following kinds of test doubles

- `Stubs` are objects that have predefined return values to the method executions made during the test
- `Spies` are objects that are similar to stubs, but they additionally record the stats of how they were executed
- `Mocks` are objects that have return values to method executions made during the test and has recorded expectations of these executions
  - Mocks can throw an exception if they receive a call they don't expect and are checked during verification to ensure they got all the calls they were expecting

We can mock both interfaces and classes in the test class

Mockito also helps to produce minimum boilerplate code if we use the using Mockito annotations

Note: Once created, a `mock` will remember all interactions. Then we can selectively verify whatever interactions we are interested in

### Mockito Setup with JUnit

To add Mockito to the project, we can add the latest Mockito version by any means i.e. Maven, Gradle or Jar file

```xml
<!-- pom.xml -->
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-core</artifactId>
  <version>5.12.0</version>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter-api</artifactId>
  <version>5.10.3</version>
  <scope>test</scope>
</dependency>
```

To process Mockito annotations with JUnit 5, we need to use `MockitoExtension` as follows:

```java
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {
  // code
}
```

### Programmatic Initialization

Alternatively, we can programmatically bootstrap Mockito using `.openMocks()` method somewhere in the base class or a test runner

This method initializes fields annotated with Mockito annotations `@Mock`, `@Spy`, `@Captor`, `@InjectMocks`

The previously used `.initMocks()` method is now deprecated

```java
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class TestClass {
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  public void tearDown() {
    MockitoAnnotations.openMocks(this);
  }
}
```

### Mockito Annotations

- `@Mock`
  - Used for mock creation
  - **Note: Any object annotated/labelled with `@Mock` causes it be replaced with a proxy/dummy object that does NOT contain any values**
    - This is why we need to utilise `Mockito.when().thenReturn()` statements in our `setUp()` method annotated/labelled with `@BeforeEach` or `@BeforeAll`
  - **Mock pretends the real object exists by replacing it with a proxy/dummy object**
- `@Spy`
  - Used to create a spy instance
  - We can use the `Mockito.spy(Object)` method
- `@InjectMocks`
  - Used to instantiate the tested object automatically and inject all the `@Mock` or `@Spy` annotated field dependencies into it (if applicable).
  - `@InjectMocks` can only be used with classes, not with interfaces
- `@Captor`
  - Used to create an argument captor

```java
import org.mockito.Mock;
import org.mockito.InjectMocks;
public class ApplicationTest {
  @Mock
  Dependency mock;

  @InjectMocks
  Service codeUnderTest;
}
```

### Mockito Example/Demo

#### System Under Test

To demo the Mockito syntax, we have created a typical use case where a `RecordService` invokes `RecordDao` to save a `Record`

The `RecordService` uses a `SequenceGenerator` class to get the next record id

#### Test Example

- To test `RecordService.saveRecord()` method, we need to inject `RecordDao` and `SequenceGenerator` as dependencies in it
  - For this, we are using `@Mock` and `@InjectMocks` annotations
- The `@ExtendWith(MockitoExtension.class)` starts the bootstrapping process and injects the mocks into the service instance
- We use the `when(...).then(...)` methods to record the expectations from mock objects, and we verify these expectations, after the application code execution finishes, using the `.verify()` method calls
- Finally, we can use additional JUnit assertions for additional validations, if any

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MockitoHelloTest {
  @Mock
  RecordDao mockDao;

  @Mock
  NotificationService mockNotification;

  @Mock
  SequenceGenerator mockGenerator;

  @InjectMocks
  RecordService service;

  @Test
  public void testSaveRecord() {
    Record record = new Record();
    record.setName("Test Record");
    when(mockGenerator.getNext()).thenReturn(100L);
    when(mockDao.saveRecord(record)).thenReturn(record);
    Record savedRecord = service.saveRecord(record);
    verify(mockGenerator, times(1)).getNext();
    verify(mockDao, times(1)).saveRecord(any(Record.class));
    assertEquals("Test Record", savedRecord.getName());
    assertEquals(100L, savedRecord.getId());
  }
}
```

## Mockito Annotations: `@Mock`, `@Spy`, `@InjectMocks`, `@Captor` - HowToDoInJava

- [Mockito Annotations: `@Mock`, `@Spy`, `@InjectMocks`, `@Captor` - HowToDoInJava](https://howtodoinjava.com/mockito/mockito-annotations/)

Quick Reference for Mockito with JUnit 5

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
  @Mock
  private ItemRepository itemRepository;

  @InjectMocks
  private ItemService itemService; // Assuming ItemService uses ItemRepository

  @Test
  public void testCreateItem() {
    // ...
  }
}
```

### Initializing Mockito Annotations

#### With JUnit 5 / Spring Boot

To process Mockito annotations with JUnit 5, we need to use MockitoExtension as follows:

```java
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {
  // Annotated mocks and spies will be automatically initialized
}
```

#### Using `MockitoAnnotations.openMocks()`

Alternatively, we can programmatically bootstrap Mockito using `openMocks()` method for initializing annotated mocks and spies in a test class

Note: The previously used `MockitoAnnotations.initMocks()` method is now DEPRECATED

```java
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class MyTestClass {
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }
}
```

### `@Mock`

> Any object annotated/labelled with `@Mock` causes it be replaced with a proxy/dummy object that does NOT contain any values
> This is why we need to utilise `Mockito.when().thenReturn()` statements in our `setUp()` method annotated/labelled with `@BeforeEach` or `@BeforeAll`
>
> Mock pretends the real object exists by replacing it with a proxy/dummy object

> The @Mock annotation is used to create and inject mocked instances
>
> We do NOT create real objects, rather ask Mockito to create a mock for the class
>
> `Mocks` are objects that have return values to method executions made during the test and has recorded expectations of these executions
>
> Mocks can throw an exception if they receive a call they don't expect and are checked during verification to ensure they got all the calls they were expecting
>
> We can mock both interfaces and classes in the test class
>
> Note: Once created, a `mock` will remember all interactions. Then we can selectively verify whatever interactions we are interested in

The `@Mock` annotation is an alternative to `Mockito.mock(classToMock)` (both achieve the same result)

Using `@Mock` is usually considered "cleaner", as we don't fill up the tests with boilerplate assignments that all look the same

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Map;

public class MapMockTest {
  @Mock
  Map<String, Integer> mockedMap;
  // or
  Map mockedMapManual = Mockito.mock(Map.class);
}
```

Using the `@Mock` annotation

- Allows shorthand creation of objects required for testing
- Minimizes repetitive mock creation code
- Makes the test class more readable
- Makes the verification error easier to read because field name is used to identify the mock

In the example below, we have mocked the Map class

In real tests, we shall be mocking actual application classes

We put a key-value pair in Map, and then verified that method invocation was performed on mocked map instance

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class HashMapTest {

  @Mock
  Map<String, Integer> mockHashMap;

  @Test
  public void saveTest() {
    mockHashMap.put("A", 1);
    Mockito.verify(mockHashMap, times(1)).put("A", 1);
    Mockito.verify(mockHashMap, times(0)).get("A");
    assertEquals(0, mockHashMap.size());
  }
}
```

### `@Spy`

> The @Spy annotation is used to create a real object and spy on that real object
>
> A spy helps to call all the normal methods of the object while still tracking every interaction, just as we would with a `mock`.

Note: Notice how in the example below the size of the Map is maintained to 1 because we added one key-value pair to it

- We are also able to get back the value added to Map using its key
- This is NOTpossible in mocked instances

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class MapSpyTest {

  @Spy
  Map<String, Integer> map = new HashMap<>();

  @Test
  public void saveTest() {
    map.put("A", 10);
    Mockito.verify(map, times(1)).put("A", 10);
    Mockito.verify(map, times(0)).get("A");
    assertEquals(1, map.size());
    assertEquals(10, (int) map.get("A"));
  }
}
```

### `@Captor`

> The `@Captor` annotation is used to create an ArgumentCaptor instance which is used to capture method argument values for further assertions

Note: Mockito verifies argument values using the `equals()` method of argument class

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class MapTest {

  @Mock
  HashMap<String, Integer> map;
  @Captor
  ArgumentCaptor<String> keyCaptor;
  @Captor
  ArgumentCaptor<Integer> valueCaptor;

  @Test
  public void saveTest() {
    map.put("A", 10);
    Mockito.verify(map).put(keyCaptor.capture(), valueCaptor.capture());
    assertEquals("A", keyCaptor.getValue());
    assertEquals(10, (int) valueCaptor.getValue());
  }
}
```

### `@InjectMocks`

In Mockito, we need to create the object of a test class to be tested and then insert the mocked dependencies to test the behavior completely

To do this, we use `@InjectMocks` annotation

The `@InjectMocks` marks a field on which injection should be performed

Mockito will try to inject mocks only either by constructor injection, setter injection, or property injection (in this order)

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
  @Mock
  private ItemRepository itemRepository;

  @InjectMocks
  private ItemService itemService; // Assuming ItemService uses ItemRepository

  @Test
  public void testCreateItem() {
    // ...
  }
}
```

### `@Mock` vs `@Spy`

When using `@Mock`, Mockito creates a bare-bones shell instance of the field type, entirely instrumented to track interactions with it

- This is NOT a real object and does NOT maintain the state changes to it

When using `@Spy`, Mockito proxies a real instance of the class and tracks every interaction with it

- It DOES maintain the state changes to it

## `@Mock` vs `@InjectMocks` - HowToDoInJava

- [`@Mock` vs `@InjectMocks` - HowToDoInJava](https://howtodoinjava.com/mockito/mockito-mock-injectmocks/)

During unit testing with junit and Mockito, generally, we use `@Mock` and `@InjectMocks` annotations to create mocks and SUT (System Under Test) to be tested

Quick Reference

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
  @Mock
  private ItemRepository itemRepository;
  @InjectMocks
  private ItemService itemService; // ItemService uses ItemRepository

  @Test
  public void testCreateItem() {
    // ...
  }
}
```

### What is a Mock?

It is important to understand the difference between a mock and an object

An object is an actual instance of a class and any method invoked using object reference will execute the method body defined in the class file

A mock object is a proxy interface to hide an underlying dependency that cannot be tested in a test environment e.g. database, network locations etc

- A method invoked using mocked reference does NOT execute the actual method body defined in the class file, rather the method behavior is configured using `when(...).thenReturn(...)` methods

In a junit test, we create objects for the class that need to be tested and its methods to be invoked

- We create mocks for the dependencies which will NOT be present in the test environment and objects are dependent on it to complete the method call

### `@Mock` vs `@InjectMocks`

In Mockito-based junit tests, `@Mock` annotation creates mocks and `@InjectMocks` creates actual objects and injects mocked dependencies into it

- Use `@InjectMocks` to create class instances that need to be tested in the test class. We call it 'code under test' or 'system under test'.
- Use `@InjectMocks` when the actual method body needs to be executed for a given class
- Use `@InjectMocks` when we need all or a few internal dependencies initialized with mock objects to work the method correctly
- Use `@Mock` to create mocks that are needed to support the testing of the System Under Test (SUT)
- We must define the `when(...).thenReturn(...)` methods for mock objects whose class methods will be invoked during actual test execution

- Steps
  - Add `@Mock` annotation/decorator to service's DEPENDENCIES
  - Add `@InjectMocks` annotation/decorator to service ITSELF
  - Add `MockitoAnnotations.openMocks(this);` to start mocks for current test class

### Example/Demo

In the example below , we have a class `MainClass` that has a method `save()`

`MainClass` has a dependency on `DatabaseDao` and `NetworkDao`.

When we call `MainClass.save()` method, it internally calls `save` methods of both dependent objects

#### System Under Test

```java
public class MainClass {
  DatabaseDao database;
  NetworkDao network;

  //Setters and getters
  public boolean save(String fileName) {
    database.save(fileName);
    System.out.println("Saved in database in Main class");
    network.save(fileName);
    System.out.println("Saved in network in Main class");
    return true;
  }
}
```

```java
public class DatabaseDao {
  public boolean save(String fileName) {
    System.out.println("Saved in database");
    return true;
  }
}
```

```java
public class NetworkDao {
  public void save(String fileName) {
    System.out.println("Saved in network location");
    return true;
  }
}
```

#### Unit Test

JUnit Test for `MainClass`

```java
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ApplicationTest {
  @InjectMocks
  MainClass mainClass;
  @Mock
  DatabaseDAO dependentClassOne;
  @Mock
  NetworkDAO dependentClassTwo;

  @Before
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void validateTest() {
    // Record expectations with mock methods
    when(dependentClassOne.save()).thenReturn(true);
    when(dependentClassTwo.save()).thenReturn(true);
    boolean saved = mainClass.save("temp.txt");
    assertEquals(true, saved);
    // Verify recorded expectations
  }
}
```

## Mock Static Methods with Mockito - HowToDoInJava

- [Mock Static Methods with Mockito - HowToDoInJava](https://howtodoinjava.com/mockito/mock-static-methods/)

Previously, we had to use PowerMock to mock private and static methods, but starting version 3.4.0, Mockito supports mocking static methods directly

### Maven Dependency

To mock static methods, we need to use the inline mock-making facility provided by `mockito-inline module`.

Note: This module is separate from `mockito-core` module for some time, and in a future release it will be merged with `mockito-core` itself

```xml
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-inline</artifactId>
  <version>5.2.0</version>
  <scope>test</scope>
</dependency>
```

### System Under Test

For demo purposes, we are creating a simple class with two methods

- The first method does NOT take any argument and returns the string value "foo".
- The second method takes a variable number of int arguments and returns their sum

```java
class ClassWithStaticMethod {

  public static String getVal() {
    return "foo";
  }

  public static int add(int... args) {
    return IntStream.of(args).sum();
  }
}
```

### `MockedStatic` class

The `MockedStatic` represents an active and scoped mock of a type's static methods

Due to the defined scope of the static mock, it returns to its original behavior once the scope is released

To define mock behavior and to verify static method invocations, use the `MockedStatic` reference returned from the `Mockito.mockStatic()` method

It is necessary to call `ScopedMock.close()` method to release the static mock once it has been used and is no longer needed

It is therefore recommended to create this object within a try catch block/statement unless when managed explicitly

The following is the syntax to use the `MockedStatic` class in a unit test

Note: If we do NOT use a try-catch block, as suggested, the mocking/stubbing/verifying will work as expected but leaves the class in a mocked state

```java
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.mockStatic;

public class AppStaticTest {

  @Test
  public void testStaticMethod() {
    try (MockedStatic<AppStatic> mock = mockStatic(AppStatic.class)) {
      // Record mock expectations
      // Test code
      // Verify mock
    }
  }
}
```

### Mocking No-Args Static Methods

Let us mock the first method `getVal()` that takes no arguments and returns a String value "foo".

We are mocking the `getVal()` method and returning the value "bar" from the mock

When we invoke the `getVal()` method, outside the mock scope, we should the value as "bar" and inside the scope, we should get the value "foo".

```java
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

public class StaticMethodTest {

  @Test
  public void testGetVal() {
    assertEquals("foo", ClassWithStaticMethod.getVal());
    // try (MockedStatic mockStatic = mockStatic(ClassWithStaticMethod.class)) {
    try (MockedStatic<ClassWithStaticMethod> mockStatic = mockStatic(ClassWithStaticMethod.class)) {
      mockStatic.when(ClassWithStaticMethod::getVal).thenReturn("bar");
      assertEquals("bar", ClassWithStaticMethod.getVal());
      mockStatic.verify(ClassWithStaticMethod::getVal);
    }
    assertEquals("foo", ClassWithStaticMethod.getVal());
  }
}
```

### Mocking a Static Method with Arguments

Mocking the static methods that accept arguments and return values is pretty much same as the previous section

Additionally, we can use flexible argument-matchers in expectations

Note: We are using the lambda expression syntax for invoking the static method

- https://howtodoinjava.com/java8/lambda-expressions/

```java
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticMethodMockTest {

  @Test
  public void testAdd() {
    assertEquals(3, ClassWithStaticMethod.add(1, 2));
    // try (MockedStatic mockStatic = mockStatic(ClassWithStaticMethod.class)) {
    try (MockedStatic<ClassWithStaticMethod> mockStatic = mockStatic(ClassWithStaticMethod.class)) {
      mockStatic.when(() -> ClassWithStaticMethod.add(anyInt(), anyInt())).thenReturn(10);
      assertEquals(10, ClassWithStaticMethod.add(1, 2));
      mockStatic.verify(() -> ClassWithStaticMethod.add(1, 2));
    }
    assertEquals(3, ClassWithStaticMethod.add(1, 2));
  }
}

```

## Verify Multiple Invocations with Different Arguments - HowToDoInJava

- [Verify Multiple Invocations with Different Arguments - HowToDoInJava](https://howtodoinjava.com/mockito/verify-multiple-method-arguments/)

### Verify Multiple Invocations with `ArgumentCaptor`

The given unit test has mocked the Map class and invokes in `.put(key, value)` code twice

It then verifies that the method had been invoked twice

The test further verifies all the different method arguments separately

To capture and verify all the method arguments passed to a method when it is invoked multiple times, we shall follow the below steps:

- Use `Mockito.verify(mock, times(n))` to verify if the method was executed 'n' times
- Create as many `ArgumentCaptor` instances as the number of arguments in the method
  - In the example below, we tested the Map which works on key-value pairs, so we created two `ArgumentCaptor` instances – one for key and second for value
- Use `ArgumentCaptor.getAllValues()` to retrieve all the values passed to one method parameter during all executions
  - It returns a List of passed argument values
- We can use `assertEquals(expected, result)` to verify that expected multiple arguments match with the retrieved values from `ArgumentCaptor`

```java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.times;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class MockitoExample {
  @Mock
  Map<String, Integer> map;
  @Captor
  ArgumentCaptor<String> keyCaptor;
  @Captor
  ArgumentCaptor<Integer> valueCaptor;

  @Test
  public void saveTest() {
    map.put("A", 10);
    map.put("B", 20);
    // 1. Verify method was invoked N times
    Mockito.verify(map, times(2)).put(keyCaptor.capture(), valueCaptor.capture());
    List<String> keys = keyCaptor.getAllValues();
    List<Integer> values = valueCaptor.getAllValues();
    // 2. Verify method argument values as list
    assertEquals(Arrays.asList("A", "B"), keys);
    assertEquals(Arrays.asList(10, 20), values);
    // 3. Verify method arguments separately
    assertEquals("A", keys.get(0));
    assertEquals("B", keys.get(1));
    assertEquals(Integer.valueOf(10), values.get(0));
    assertEquals(Integer.valueOf(20), values.get(1));
  }
}
```

## `Mockito.mock()` vs `@Mock` vs `@MockBean` - Baeldung

- [`Mockito.mock()` vs `@Mock` vs `@MockBean` - Baeldung](https://www.baeldung.com/java-spring-mockito-mock-mockbean)

### `Mockito.mock()`

> The `Mockito.mock()` method allows us to create a Mock object of a class or an interface
>
> We can then use the Mock to stub return values for its methods and verify if they were called

Example

```java
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.data.repository.Repository;

public class UserRepositoryTest {

  @Test
  public void givenCountMethodMocked_WhenCountInvoked_ThenMockedValueReturned() {
    UserRepository localMockRepository = Mockito.mock(UserRepository.class);
    Mockito.when(localMockRepository.count()).thenReturn(111L);

    long userCount = localMockRepository.count();

    Assert.assertEquals(111L, userCount);
    Mockito.verify(localMockRepository).count();
  }
}
```

### `@Mock` Annotation

> The `@Mock` Annotation is a shorthand for the `Mockito.mock()` method
>
> Unlike the `.mock()` method, we need to enable Mockito annotations to use this annotation
>
> > We can do this either by using the `MockitoJUnitRunner` to run the test, or by calling the `MockitoAnnotations.openMocks()` method explicitly
> > Note: `MockitoAnnotations.initMocks()` method is deprecated

Note: We should only use `@Mock` in a test class

#### Example using `MockitoJUnitRunner`

```java
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockAnnotationUnitTest {

  @Mock
  UserRepository mockRepository;

  @Test
  public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
    Mockito.when(mockRepository.count()).thenReturn(123L);
    long userCount = mockRepository.count();
    Assert.assertEquals(123L, userCount);
    Mockito.verify(mockRepository).count();
  }
}
```

#### Example using `MockitoAnnotations.openMocks()`

```java
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MockAnnotationUnitTest {
  @Mock
  UserRepository mockRepository;

  @Before
  public void initMocks() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
    Mockito.when(mockRepository.count()).thenReturn(123L);
    long userCount = mockRepository.count();
    Assert.assertEquals(123L, userCount);
    Mockito.verify(mockRepository).count();
  }
}
```

Apart from making the code more readable, `@Mock` makes it easier to find the problem mock in case of a failure,
as the name of the field appears in the failure message:

```
Wanted but not invoked:
mockRepository.count();
-> at org.baeldung.MockAnnotationTest.testMockAnnotation(MockAnnotationTest.java:22)
Actually, there were zero interactions with this mock

  at org.baeldung.MockAnnotationTest.testMockAnnotation(MockAnnotationTest.java:22)
```

### `@MockBean` Annotation

We can use the `@MockBean` to add mock objects to the Spring application context

The mock will replace any existing bean of the same type in the application context

If NO bean of the same type is defined, a new one will be added

This annotation is useful in integration tests where a particular bean, like an external service, needs to be mocked

When we use the annotation on a field, the mock will be injected into the field,
as well as being registered in the application context

- This is evident in the code below where we used the injected `UserRepository` mock to stub the `.count()` method

- Then we used the bean from the application context to verify that it is indeed the mocked bean

To use this annotation, we have to use `SpringRunner` to run the test:

**JUnit 4**

```java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

@RunWith(SpringRunner.class)
public class MockBeanAnnotationIntegrationTest {

  @MockBean
  UserRepository mockRepository;

  @Autowired
  ApplicationContext context;

  @Test
  public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
    Mockito.when(mockRepository.count()).thenReturn(123L);

    UserRepository userRepoFromContext = context.getBean(UserRepository.class);
    long userCount = userRepoFromContext.count();

    Assert.assertEquals(123L, userCount);
    Mockito.verify(mockRepository).count();
  }
}
```

**JUnit 5**

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;

@ExtendWith(SpringExtension.class)
public class MockBeanAnnotationIntegrationTest {

  @MockBean
  UserRepository mockRepository;

  @Autowired
  ApplicationContext context;

  @Test
  public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
    Mockito.when(mockRepository.count()).thenReturn(123L);

    UserRepository userRepoFromContext = context.getBean(UserRepository.class);
    long userCount = userRepoFromContext.count();

    Assertions.assertEquals(123L, userCount);
    Mockito.verify(mockRepository).count();
  }
}
```

## `@Mock` vs `@MockBean` - StackOverflow

### Difference between `@Mock`, `@MockBean` and `Mockito.mock()`

- [Difference between `@Mock`, `@MockBean` and `Mockito.mock()`](https://stackoverflow.com/questions/44200720/difference-between-mock-mockbean-and-mockito-mock)

`Mockito.mock()`

- Will create a mock object of either class or interface. We can use this mock to stub the return values and verify if they are called
- We must use the when(..) and thenReturn(..) methods for mock objects whose class methods will be invoked during test case execution

`@Mock`

- `@Mock` is shorthand/shortcut for `Mockito.mock()`
- Both `Mockito.mock()` and `@Mock` are functionally equivalent
- Easier to identify the problem in mock failure as name of the field appears in the error message

To enable the Mockito annotation during test execution we need to call the `MockitoAnnotations.openMocks(this)`

- Note: `MockitoAnnotations.initMocks(this)` is DEPRECATED

In order to avoid the side effects it is advised to call this method before test case executions

- Place the `MockitoAnnotations.openMocks(this)` call INSIDE the `@BeforeEach` function
- Another way to enable the Mockito annotations is by annotating the test class with `@RunWith(MockitoJUnitRunner)`

`@MockBean`

- `@MockBean` is used to add the Mock objects into Spring Application Context
- This mock will replace the existing bean of same type in the Application Context
- If NO bean is available, then new bean will be added/created
- This is useful in integration test case

When to use `@Mock` and `@MockBean`

- When we write a test case that does NOT need any dependencies from the Spring Boot container, use `@Mock` since it is fast and favors the isolation of the tested component
- If our test case needs to rely on the Spring Boot container AND we want to add or mock one of the container beans then use `@MockBean`

#### Plain Mockito Library

**Method 1**

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Mock
  MyService myService;

  @Test
  public void testMyService() {
    //...
  }
}
```

**Method 2**

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  MyService myService = Mockito.mock(MyService.class);

  @Test
  public void testMyService() {
    //...
  }
}
```

Note:

- To enable Mockito annotations during test executions, the `MockitoAnnotations.openMocks(this)` static method MUST be called
- To avoid side effect between tests, it is advised to do it BEFORE EACH test execution
- `MockitoAnnotations.initMocks(this)` is DEPRECATED

Another way to enable Mockito annotations is annotating the test class with `@RunWith` by specifying the `MockitoJUnitRunner`

```java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class MyClassTest {
  @Test
  public void myTest() {
    //...
  }
}
```

#### Spring Boot Library Wrapping Mockito Library

- `@MockBean` is indeed a Spring Boot Class
  - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/mock/mockito/MockBean.html

> `@MockBean` allows to add Mockito mocks in a Spring `ApplicationContext`
>
> If a bean (compatible with the declared class exists in the context) `@MockBean` REPLACES it by the mock
>
> If a bean does NOT exist already, `@MockBean` ADDS the mock in the context as a bean

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MyServiceTest {

  @MockBean
  MyService myService;

  @Test
  public void testMyService() {
    //...
  }
}
```

#### When to use `@Mock` from Mockito and `@MockBean` From Spring Boot ?

Unit tests are designed to test a component in isolation from other components and unit tests have also a requirement:
being as fast as possible in terms of execution time as these tests may be executed each day dozen times on the developer machines

Consequently, here is a simple guideline :

- If you write a test that does NOT need any dependencies from the Spring Boot container, use `@Mock` from Mockito (since it is fast and favors the isolation of the tested component)
- If your test needs to rely on the Spring Boot container AND you want also to add or mock one of the container beans, use `@MockBean` from Spring Boot

#### Typical Usage of `@MockBean`

- If we write a test class annotated with `@WebMvcTest` (web test slice)
- [The Spring Boot documentation summarizes that very well](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html#boot-features-testing-spring-boot-applications-testing-autoconfigured-mvc-tests)
  - "Often `@WebMvcTest` will be limited to a single controller and used in combination with `@MockBean` to provide mock implementations for required collaborators"

Example

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FooController.class)
public class FooControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private FooService fooServiceMock;

  @Test
  public void testExample() throws Exception {
    Foo mockedFoo = new Foo("one", "two");
    Mockito.when(fooServiceMock.get(1))
      .thenReturn(mockedFoo);
    mvc.perform(get("/foos/1")
      .accept(MediaType.TEXT_PLAIN))
      .andExpect(status().isOk())
      .andExpect(content().string("one two"));
  }
}
```

# Reactive Testing

- [StepVerifier - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.html)
  - [StepVerifier.Assertions - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.Assertions.html)
  - [StepVerifier.ContextExpectations - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.ContextExpectations.html)
  - [StepVerifier.FirstStep - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.FirstStep.html)
  - [StepVerifier.LastStep - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.LastStep.html)
  - [StepVerifier.Step - JavaDocs](https://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.Step.html)

## Testing Reactive Streams Using `StepVerifier` and `TestPublisher` - Baeldung

- [Testing Reactive Streams Using StepVerifier and TestPublisher - Baeldung](https://www.baeldung.com/reactive-streams-step-verifier-test-publisher)

### Maven Dependencies

Spring Reactor comes with several classes for testing reactive streams

We can get these by adding the reactor-test dependency:

```xml
<dependency>
  <groupId>io.projectreactor</groupId>
  <artifactId>reactor-test</artifactId>
  <scope>test</scope>
  <version>3.6.8</version>
</dependency>
```

### `StepVerifier`

In general, `reactor-test` has two main uses:

1. Creating a step-by-step test with `StepVerifier`
2. Producing predefined data with `TestPublisher` to test downstream operators

The most common case in testing reactive streams is when we have a publisher (a `Flux` or `Mono`) defined in our code

- **We want to know how it behaves when someone subscribes**

With the `StepVerifier` API, we can DEFINE our expectations of published elements in terms of **what elements we expect and what happens when our stream completes**.

First of all, let's create a publisher with some operators

We'll use a `Flux.just(T elements)`

- This method will create a Flux that emits given elements and then completes

We'll just create a simple publisher that outputs only four-letter names mapped to uppercase:

```java
Flux<String> source = Flux.just("John", "Monica", "Mark", "Chloe", "Bill", "Frank", "Casper", "Olivia", "Emily", "Kate")
  .filter(name -> name.length() == 4)
  .map(String::toUpperCase);
```

#### Step-By-Step Scenario

Let's test our source with `StepVerifier` **in order to test what will happen when someone subscribes**:

- First, we create a StepVerifier builder with the `.create()` method
- Next, we wrap our Flux source, which is under test
  - The first signal is verified with `expectNext(T element)`, but really, we can pass any number of elements to `.expectNext()`
- We can also use `.expectNextMatches()` and provide a `Predicate<T>` (lambda function) for a more custom match
- For our last expectation, we expect that our stream completes with `.expectComplete()`
- Finally, we use `.verify()` to trigger our test

```java
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifierTest {

  @Test
  public void testNamesFlux() {
    Flux<String> source = Flux.just("JOHN", "MARK", "CHLOE", "KATE");

    StepVerifier
      .create(source)
      .expectNext("JOHN")
      .expectNextMatches(name -> name.startsWith("MA"))
      .expectNext("BILL", "KATE")
      .expectComplete()
      .verify();
  }
}
```

#### Exceptions in StepVerifier

Now, let's concatenate our Flux publisher with Mono

We'll have this Mono terminate immediately with an error when subscribed to

```java
Flux<String> error = source.concatWith(Mono.error(new IllegalArgumentException("Error Message")));
```

Now, after four all elements, we expect our stream to terminate with an exception:

```java
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class StepVerifierTest {

  @Test
  public void testNamesFlux() {
    Flux<String> source = Flux.just("JOHN", "MARK", "CLOE", "CATE");
    Flux<String> error = source.concatWith(Mono.error(new IllegalArgumentException("Error Message")));

    StepVerifier
      .create(error)
      .expectNextCount(4)
      .expectErrorMatches(throwable -> throwable instanceof IllegalArgumentException && throwable.getMessage().equals("Our message"))
      .verify();
  }
}
```

**We can use only ONE method to verify exceptions**

- The `OnError` signal notifies the subscriber that the publisher is closed with an error state
- Therefore, we CANNOT add more expectations afterward

If it is NOT necessary to check the type and message of the exception at once, then we can use one of the dedicated methods:

- `.expectError()` = Expect any kind of error
- `.expectError(Class<? extends Throwable> clazz)` = Expect an error of a specific type
- `.expectErrorMessage(String errorMessage)` = Expect an error having a specific message
- `.expectErrorMatches(Predicate<Throwable> predicate)` = Expect an error that matches a given predicate/lambda function
- `.expectErrorSatisfies(Consumer<Throwable> assertionConsumer)` = Consume a Throwable in order to do a custom assertion

#### Testing Time-Based Publishers

Sometimes our publishers are time-based

For example, suppose that in our real-life application, we have a one-day delay between events

Now, obviously, we don't want our tests to run for an entire day to verify expected behavior with such a delay

`StepVerifier.withVirtualTime` builder is designed to avoid long-running tests

We create a builder by calling `withVirtualTime()` method

- Note: This method does NOT take `Flux` as an input
  - Instead, it takes a `Supplier`, which lazily creates an instance of the tested Flux after having the scheduler set up

To demonstrate how we can test for an expected delay between events, let's create a Flux with an interval of one second that runs for two seconds

- If the timer runs correctly, we should only get two elements

Note: We MUST ALWAYS **instantiate Flux INSIDE the lambda** (avoid instantiating the Flux earlier in the code and then having the Supplier return this variable)

There are two major expectation methods that deal with time:

1. `thenAwait(Duration duration)` = Pauses the evaluation of the steps; new events may occur during this time
2. `expectNoEvent(Duration duration)` = Fails when any event appears during the duration; the sequence will pass with a given duration

Note: **The FIRST signal is a SUBSCRIPTION event, so every `expectNoEvent(Duration duration)` should be preceded with `expectSubscription()`**

- Breakdown of `.withVirtualTime(() -> Flux.interval(Duration.ofSeconds(1)).take(2))`
  - `Flux.interval(Duration.ofSeconds(1))`
    - This creates a Flux that emits a long value starting from 0 and then increments by 1 (0, 1, 2, ...) at fixed intervals of 1 second
    - So, after 1 second, it emits 0; after another second, it emits 1, and so on
  - `.take(2)`:
    - This operator limits the number of emitted items to 2
    - So, even though `Flux.interval` can emit values indefinitely at 1-second intervals, `.take(2)` ensures that only the first two values (0 and 1) are emitted
    - After emitting the value 1, the Flux completes
  - `.withVirtualTime(() -> ...)`
    - This is typically used in testing to simulate the passage of time
    - When you wrap a Flux with `.withVirtualTime`, it allows you to test time-dependent operations without actually waiting for real time to pass
    - This means the Flux that normally would take 2 seconds to emit all its values and complete (because of the 1-second intervals) can be tested almost instantly

```java
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class VirtualTimeTest {

  @Test
  public void testWithVirtualTime() {
    StepVerifier
      .withVirtualTime(() -> Flux.interval(Duration.ofSeconds(1)).take(2))
      .expectSubscription()
      .expectNoEvent(Duration.ofSeconds(1))
      .expectNext(0L)
      .thenAwait(Duration.ofSeconds(1))
      .expectNext(1L)
      .verifyComplete();
  }
}
```

#### Post-Execution Assertions with `StepVerifier`

Sometimes we need to verify additional state after our whole scenario played out successfully

Let's create a custom publisher. It will emit a few elements, then complete, pause, and emit one more element, which we'll drop:

```java
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxTest {

  @Test
  public void testFluxFilter() {
    Flux<Integer> source = Flux.<Integer>create(emitter -> {
      emitter.next(1);
      emitter.next(2);
      emitter.next(3);
      emitter.complete();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      emitter.next(4);
    }).filter(number -> number % 2 == 0);

    StepVerifier.create(source)
      .expectNext(2)
      .verifyComplete();
  }
}
```

We expect that it will emit a 2, but drop a 4, since we called `emitter.complete()` first

So, let's verify this behavior by using `verifyThenAssertThat()`

- This method returns `StepVerifier.Assertions` on which we can add our assertions

```java
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import java.time.Duration;

public class FluxTest {

  @Test
  public void testDroppedElements() {
    Flux<Integer> source = Flux.<Integer>create(emitter -> {
      emitter.next(1);
      emitter.next(2);
      emitter.next(3);
      emitter.complete();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      emitter.next(4);
    }).filter(number -> number % 2 == 0);

    StepVerifier.create(source)
      .expectNext(2)
      .expectComplete()
      .verifyThenAssertThat()
      .hasDropped(4)
      .tookLessThan(Duration.ofMillis(1050));
  }
}
```

### Producing Data with `TestPublisher`

Sometimes, we might need some special data in order to trigger the chosen signals

For instance, we may have a very particular situation that we want to test

Alternatively, we may choose to implement our own operator and want to test how it behaves

For both cases, we can use `TestPublisher<T>`, which allows us to programmatically trigger miscellaneous signals:
`.next(T value)` or `next(T value, T rest)` = Send one or more signals to subscribers
`.emit(T value)` = Same as `.next(T)` but invokes `.complete()` afterwards
`.complete()` = Terminates a source with the complete signal
`.error(Throwable tr)` = Terminates a source with an error
`.flux()` = Method to wrap a TestPublisher into Flux
`.mono()` = Method to wrap a TestPublisher into a Mono

#### Creating a TestPublisher

Let's create a simple `TestPublisher` that emits a few signals and then terminates with an exception:

```java
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class TestPublisherExample {

  @Test
  public void testPublisherExample() {
    TestPublisher<String> testPublisher = TestPublisher
      .<String>create()
      .next("First", "Second", "Third")
      .error(new RuntimeException("Message"));

    Flux<String> source = testPublisher.flux();

    StepVerifier.create(source)
      .expectNext("First", "Second", "Third")
      .expectError(RuntimeException.class)
      .verify();
  }
}
```

#### TestPublisher in Action

We may sometimes want to trigger a finely chosen signal that closely matches to a particular situation

Now, it's especially important in this case that we have complete mastery over the source of the data

- To achieve this, we can again rely on `TestPublisher`

First, let's create a class that uses `Flux<String>` as the constructor parameter to perform the operation `.getUpperCase()`:

- In the example below, we create a test Flux publisher in the `UpperCaseConverter` constructor parameter
- Then, our TestPublisher emits three elements and completes

```java
import reactor.core.publisher.Flux;

class UpperCaseConverter {
  private final Flux<String> source;

  UpperCaseConverter(Flux<String> source) {
    this.source = source;
  }

  Flux<String> getUpperCase() {
    return source
      .map(String::toUpperCase);
  }
}
```

Suppose that `UpperCaseConverter` is our class with complex logic and operators, and we need to supply very particular data from the source publisher

We can easily achieve this with `TestPublisher`:

```java
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class UpperCaseConverterTest {

  @Test
  public void testUpperCaseConversion() {
    final TestPublisher<String> testPublisher = TestPublisher.create();

    UpperCaseConverter uppercaseConverter = new UpperCaseConverter(testPublisher.flux());

    StepVerifier.create(uppercaseConverter.getUpperCase())
      .then(() -> testPublisher.emit("aA", "bb", "ccc"))
      .expectNext("AA", "BB", "CCC")
      .verifyComplete();
  }

  static class UpperCaseConverter {
    private final Flux<String> source;

    UpperCaseConverter(Flux<String> source) {
      this.source = source;
    }

    Flux<String> getUpperCase() {
      return source
        .map(String::toUpperCase);
    }
  }
}
```

#### Misbehaving `TestPublisher`

We can create a misbehaving `TestPublisher` with the `.createNonCompliant()` factory method

- We need to pass in the constructor one enum value from `TestPublisher.Violation`
- These values specify which parts of specifications our publisher may overlook

In addition to `ALLOW_NULL`, we can also use TestPublisher.Violation to:

- `ALLOW_NULL` = Allow `.next()` calls to be made with a `null` value without throwing/triggering a `NullPointerException`
- `REQUEST_OVERFLOW` = Allows calling `.next()` without throwing an `IllegalStateException` when there is an insufficient number of requests
- `CLEANUP_ON_TERMINATE` = Allows sending any termination signal several times in a row
- `DEFER_CANCELLATION` = Allows us to ignore cancellation signals and continue with emitting elements

Let's see an example of a `TestPublisher` that will NOT throw a `NullPointerException` for the `null` element:

```java
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class TestPublisherViolationTest {

  @Test
  public void testPublisherAllowNull() {
    Flux<String> source = TestPublisher
      .<String>createNoncompliant(TestPublisher.Violation.ALLOW_NULL)
      .emit("1", "2", null, "3");

    StepVerifier.create(source)
      .expectNext("1", "2")
      .expectNext((String) null)
      .expectNext("3")
      .verifyComplete();
  }
}
```

# Spring Boot Testing

## `@SpringBootTest` Annotation - HowToDoInJava

- [`@SpringBootTest` Annotation - HowToDoInJava](https://howtodoinjava.com/spring-boot2/testing/springboottest-annotation/)

We can specify `@SpringBootTest` annotation on a test class that runs Spring Boot based tests

It's class declaration is as below:

```java
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = TYPE)
@Retention(value = RUNTIME)
@Documented
@Inherited
@BootstrapWith(value = SpringBootTestContextBootstrapper.class)
@ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class)
public @interface SpringBootTest {
  //...
}
```

It provides the following features over and above the regular Spring `TestContext` provided by `@ContextConfiguration(classes=...​)` annotation in spring-test

- Automatically searches for a `@SpringBootConfiguration` when nested `@Configuration` class is NOT used, and no explicit classes are specified
- Allows custom environment properties to be defined using the `properties` attribute
- Provides support for different webEnvironment modes, including the ability to start a fully running web server listening on a defined or random port
- Registers a `TestRestTemplate` and/or `WebTestClient` bean for use in web tests that are using a fully running web server

### Using `@SpringBootTest` for Integration Testing

Under the hood, `@SpringBootTest` tries to mimic the processes added by Spring Boot framework
for creating the context e.g. it decides what to scan based on package structures,
loads external configurations from predefined locations, optionally runs auto-configuration starters and so on

As we see that this annotation starts and configures almost the whole application before the tests begin,
we should use `@SpringBootTest` to write an integration tests that use the application processes and dependencies

```java
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootDemoApplicationTests {
  @LocalServerPort
  int randomServerPort;

  // Tests
}
```

### Using `@SpringBootTest` for Unit Testing

`@SpringBootTest` annotation loads whole application, but it is better to limit
ApplicationContext only to a set of spring components that participate in test scenario

#### `classes` attribute

The `classes` attribute specifies the annotated classes to use for loading an `ApplicationContext`

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import your.package.EmployeeRepository; // Replace "your.package" with the actual package name where EmployeeRepository is located
// import your.package.EmployeeService; // Replace "your.package" with the actual package name where EmployeeService is located

@SpringBootTest(classes = { EmployeeRepository.class, EmployeeService.class })
public class SpringBootDemoApplicationTests {
  @Autowired
  private EmployeeService employeeService;
  // Tests
}
```

#### Test Annotations

If we are writing unit tests then it's always better now to use `@SpringBootTest` annotation

Rather use the specialized spring boot test annotations which test a very specific slice of the application

These annotations disable full auto-configuration and instead apply only configuration relevant to specific layers of the codebase

Some of these annotations are given below:

- `@WebFluxTest`
  - Used in combination with `@RunWith(SpringRunner.class)` for a typical Spring WebFlux test which focuses only on Spring WebFlux components
  - It will also auto-configure a WebTestClient
- `@JdbcTest`
  - Used when a test focuses only on jdbc-based components
  - The annotation configures an in-memory embedded database and JdbcTemplate
  - By default, tests are transactional and roll back at the end of each test
- `@DataMongoTest`
  - Used when a test focuses only on MongoDB components
  - By default, tests annotated with `@DataMongoTest` will use an embedded in-memory MongoDB process if the driver is available through dependencies
  - It also configures a MongoTemplate, scans for `@Document` classes, and configures Spring Data MongoDB repositories
- `@DataRedisTest`
  - Used to test Redis applications. It scans for `@RedisHash` classes and configures Spring Data Redis repositories
- `@DataLdapTest`
  - Used to test LDAP applications. It configures an in-memory embedded LDAP (if available), configures a LdapTemplate, scans for `@Entry` classes, and configures Spring Data LDAP repositories
- `@RestClientTest`
  - Used to test REST clients. It auto-configures dependencies like Jackson, GSON, and Jsonb support, configures a RestTemplateBuilder, and adds support for MockRestServiceServer by default
- `@JooqTest`
  - Used when a test focuses only on jOOQ-based components

## `@TestConfiguration` Annotation - HowToDoInJava

- [`@TestConfiguration` Annotation - HowToDoInJava](https://howtodoinjava.com/spring-boot2/testing/springboot-test-configuration/)

### Creating `@TestConfiguration`

The `@TestConfiguration` is a specialized form of `@Configuration` annotation that can be used to define additional beans or customizations specific to tests

```java
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

@TestConfiguration
public class AppTestConfiguration {

  @Bean
  DataSource inMemoryDataSource() {
    //...
  }
}
```

### Importing Test Configurations

In spring boot, any beans configured in a top-level class annotated with `@TestConfiguration` will NOT be picked up via component scanning

We must explicitly register the `@TestConfiguration` class with the class that contains the test cases

There are two ways to include the additional test configuration for tests:

#### Using `@Import`

The `@Import` annotation indicates one or more configuration classes to import into
the application context or spring test context. This annotation should be declared
at the class level or as a meta-annotation

```java
import org.springframework.context.annotation.Import;
// import your.package.AppTestConfiguration; // Replace "your.package" with the actual package name where AppTestConfiguration is located

@Import(AppTestConfiguration.class)
//other annotations
public class AppTests {
  //...
}
```

The `@Bean` definitions declared in imported `@TestConfiguration` classes should be accessed by using `@Autowired` injection

Either the bean itself can be autowired, or the configuration class instance declaring the bean can be autowired

Note: If XML or other non-configuration bean definition resources need to be imported, use the `@ImportResource` annotation instead

- https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/ImportResource.html

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import javax.sql.DataSource;
// import your.package.AppTestConfiguration; // Replace "your.package" with the actual package name where AppTestConfiguration is located

@Import(AppTestConfiguration.class)
public class AppTests {
  @Autowired
  DataSource datasource;

  // Tests
}
```

### Using Static Nested `@TestConfiguration` Class

We can define the test configurations in nested classes inside the test class

The nested class can be annotated with `@Configuration` or `@TestConfiguration` annotations

If the class annotated with `@TestConfiguration` or `@Configuration` is a static nested class within the test class, it would be registered automatically

In the case of nested `@Configuration` class, the given configuration would be used "instead of" the application's primary configuration

A nested `@TestConfiguration` class is used "in addition to" the application's primary configuration

```java
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

public class AppTests {
  @Autowired
  DataSource datasource;

  // Tests
  @TestConfiguration
  static class AppTestConfiguration {
    @Bean
    DataSource inMemoryDataSource() {
      //...
    }
  }
}
```

## Spring Boot 3 + JUnit 5 - HowToDoInJava

- [Spring Boot 3 with JUnit 5 - HowToDoInJava](https://howtodoinjava.com/spring-boot/junit-with-spring-boot/)

In Spring Boot 3, JUnit5 comes as part of `spring-boot-starter-test` module

### Maven

```xml
<!-- pom.xml -->
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>3.1.2</version>
</parent>
<dependencies>
  <!-- ... -->
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
</dependencies>
```

### Writing JUnit 5 Tests

We can use the `@SpringBootTest` annotation to load the Spring Boot application context for integration testing

The tests are written in the `/src/test/java/` directory in a suitable package hierarchy

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import your.package.MyService; // Replace "your.package" with the actual package name where MyService is located

@SpringBootTest
public class MyServiceTest {

  @Autowired
  private MyService myService;

  @Test
  public void testSomeMethod() {
    // Your JUnit 5 test logic here
    // You can use assertions and other JUnit 5 features
  }
}
```

### Running The Tests

```sh
mvn test
```

### JUnit5 Example Tests

Here is the Spring boot REST controller for which we will be writing unit tests

- https://howtodoinjava.com/spring-boot/spring-boot-rest-api-example/

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
// import your.package.Employee;
// import your.package.EmployeeDao;
// import your.package.Employees; // Replace "your.package" with the actual package names where Employee, EmployeeDao, and Employees are located

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
  @Autowired
  private EmployeeDao employeeDao;

  @GetMapping(path = "/", produces = "application/json")
  public Employees getEmployees() {
    return employeeDao.getAllEmployees();
  }

  @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
    employeeDao.addEmployee(employee);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(employee.getId())
      .toUri();
    return ResponseEntity.created(location).build();
  }
}
```

We will use the `@WebMvcTest` annotation, which is used for a Spring MVC test that focuses only on Spring MVC components
It disables full auto-configuration and instead applies only configuration relevant to MVC tests
It also configures the Spring Security and [MockMvc](https://docs.spring.io/spring-framework/docs/6.0.2/javadoc-api/org/springframework/test/web/servlet/MockMvc.html)

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
// import your.package.EmployeeController; // Replace "your.package" with the actual package name where EmployeeController is located

@WebMvcTest(EmployeeController.class)
public class TestEmployeeRestController {

  @Autowired
  private MockMvc mvc;

}
```

Finally, use MockMvc bean instance to invoke the APIs and verify the results

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import your.package.EmployeeController; // Replace "your.package" with the actual package name where EmployeeController is located

@WebMvcTest(EmployeeController.class)
public class TestEmployeeRestController {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getAllEmployeesAPI() throws Exception {
    mvc.perform(MockMvcRequestBuilders
      .get("/employees")
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
  }
}
```

## Spring Boot 3 + JUnit5 + Mockito Example - HowToDoInJava

- [Spring Boot 3 + Mockito + JUnit 5 Example](https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockito-junit-example/)

Quick Reference

- [Mockito Docs](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [Mockito - HowToDoInJava](https://howtodoinjava.com/mockito/mockito-annotations/)
- Mockito = Java Testing Framework that helps you create Mock objects and stub behaviours when writing unit tests
- Especially useful to isolate specific components for testing and in isolation from its dependencies
- Steps
  - Add `@Mock` annotation/decorator to service's DEPENDENCIES
  - Add `@InjectMocks` annotation/decorator to service ITSELF
  - Add `MockitoAnnotations.openMocks(this);` to start mocks for current test class

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
  @Mock
  private ItemRepository itemRepository;

  @InjectMocks
  private ItemService itemService; // Assuming ItemService uses ItemRepository

  @Test
  public void testCreateItem() {
    // ...
  }
}
```

### Maven

The `spring-boot-starter-test` dependency transitively imports JUnit 5 and Mockito

So we only need to include this dependency

```xml
<!-- pom.xml -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

### Initializing Mocks

In the example below, we are unit testing primarily two classes `EmployeeManager` and `EmployeeDao`

As the name implies, the `EmployeeManager` class represents the service layer, and the `EmployeeDao` class interacts with the database

The `EmployeeManager` class has a dependency on `EmployeeDao` to get the data from the database that is finally returned to controller classes

To test the methods in `EmployeeManager`, we can create a JUnit test class `TestEmployeeManager` in below given 2 ways:

#### `@Mock` vs `@InjectMocks`

- The `@Mock` annotation creates a mock implementation for the class it is annotated with
  - Add `@Mock` annotation/decorator to service's DEPENDENCIES
- The `@InjectMocks` also creates the mock implementation of annotated type and injects the dependent mocks into it
  - Add `@InjectMocks` annotation/decorator to service ITSELF

In the above example, we have annotated `EmployeeManager` class with `@InjectMocks`,
so Mockito will create the mock object for `EmployeeManager` class and inject the mock dependency of `EmployeeDao` into it

#### Initialization with `MockitoExtension`

To process Mockito annotations with JUnit, we need to use `MockitoExtension` which automatically
initializes all the objects annotated with `@Mock` and `@InjectMocks` annotations

```java
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
// import your.package.EmployeeManager; // Replace 'your.package' with the actual package name where EmployeeManager is located
// import your.package.EmployeeDao; // Replace 'your.package' with the actual package name where EmployeeDao is located

@ExtendWith(MockitoExtension.class)
public class TestEmployeeManager {

  @InjectMocks
  EmployeeManager manager;

  @Mock
  EmployeeDao dao;

  // Tests
}
```

#### Initialization with `MockitoAnnotations.openMocks()`

If we are NOT using the `MockitoJUnitRunner `class approach, then we can use the static method `MockitoAnnotations.openMocks()`

Upon initialization of JUnit tests, this method also initializes the mock objects

Note: The `MockitoAnnotations.initMocks()` method has been deprecated and should NOT be used

```java
// TestEmployeeManager.java
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
// import your.package.EmployeeService; // Replace 'your.package' with the actual package name where EmployeeService is located
// import your.package.EmployeeRepository; // Replace 'your.package' with the actual package name where EmployeeRepository is located

public class ServiceTests {
  @InjectMocks
  EmployeeService service;
  @Mock
  EmployeeRepository dao;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }
  // Tests
}
```

### Unit Tests Example

For reference, the service class is as follows:

```java
// EmployeeManager.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
// import your.package.Employee; // Replace 'your.package' with the actual package name where Employee is located
// import your.package.EmployeeRepository; // Replace 'your.package' with the actual package name where EmployeeRepository is located

@Service
public class EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;

  public Employee save(Employee employee) {
    //...
  }

  public List<Employee> findAll() {
    //...
  }

  public void deleteById(Integer id) {
    //...
  }

  void deleteAll() {
    //...
  }
}
```

For reference, the DAO class is as follows:

```java
// EmployeeDao.java
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
// import your.package.Employee; // Replace 'your.package' with the actual package name where Employee is located

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {}
```

Let's see a few examples of writing the junit tests to unit test the service layer and DAO layer methods using mock objects created with Mockito

A few example methods could be for `getAllEmployees()` returning a list of `Employee` objects,
`getEmployeeById(int id)` for returning an employee by given id and `createEmployee()` for adding an `Employee` object

The following class contains the tests for service class methods. It uses `Mockito.when()` methods to create test stubs

```java
// TestEmployeeManager.java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.howtodoinjava.employees.dao.EmployeeRepository;
import com.howtodoinjava.employees.model.Employee;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {
  @InjectMocks
  EmployeeService service;
  @Mock
  EmployeeRepository dao;

  @Test
  void testFindAllEmployees() {
    List<Employee> list = new ArrayList<>();
    Employee empOne = new Employee("John", "Wick");
    Employee empTwo = new Employee("Seth", "Chen");
    Employee empThree = new Employee("Steve", "Woz");
    list.add(empOne);
    list.add(empTwo);
    list.add(empThree);
    when(dao.findAll()).thenReturn(list);
    List<Employee> empList = service.findAll();
    assertEquals(3, empList.size());
    verify(dao, times(1)).findAll();
  }

  @Test
  void testCreateOrSaveEmployee() {
    Employee employee = new Employee("Eric", "Cartman");
    service.save(employee);
    verify(dao, times(1)).save(employee);
  }
}
```

Note: Mockito throws an `UnsupportedStubbingException` when an initialized mock is NOT called during test execution

- If there are such optional mocked behavior then use `Mockito.lenient()` as follows:

```java
Mockito.lenient().when(dao.isEmployeeDeleted()).thenReturn(Boolean.False);
```

**Tests**

```java
// src/test/java/com/howtodoinjava/SystemTests.java
package com.howtodoinjava.employees;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.howtodoinjava.employees.controllers.EmployeeController;
import com.howtodoinjava.employees.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SystemTests {

  @Autowired
  private EmployeeController controller;

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void testCreateReadDelete() {
    String url = "http://localhost:" + port + "/employee";
    Employee employee = new Employee("Seth", "Chen");
    ResponseEntity<Employee> entity = restTemplate.postForEntity(url, employee, Employee.class);

    Employee[] employees = restTemplate.getForObject(url, Employee[].class);
    Assertions.assertThat(employees).extracting(Employee::getFirstName).containsOnly("Seth");

    restTemplate.delete(url + "/" + entity.getBody().getId());
    Assertions.assertThat(restTemplate.getForObject(url, Employee[].class)).isEmpty();
  }

  @Test
  public void testErrorHandlingReturnsBadRequest() {
    String url = "http://localhost:" + port + "/wrong";
    try {
      restTemplate.getForEntity(url, String.class);
    } catch (HttpClientErrorException e) {
      Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
  }
}
```

Controller tests

```java
// src/test/java/com/howtodoinjava/controllers/IntegrationTests.java
package com.howtodoinjava.employees.controllers;

import com.howtodoinjava.employees.model.Employee;
import jakarta.validation.ValidationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IntegrationTests {

  @Autowired
  EmployeeController employeeController;

  @Test
  public void testCreateReadDelete() {
    Employee employee = new Employee("Seth", "Chen");
    Employee employeeResult = employeeController.create(employee);
    Iterable<Employee> employees = employeeController.read();
    Assertions.assertThat(employees).first().hasFieldOrPropertyWithValue("firstName", "Seth");
    employeeController.delete(employeeResult.getId());
    Assertions.assertThat(employeeController.read()).isEmpty();
  }

  @Test
  public void errorHandlingValidationExceptionThrown() {
    Assertions.assertThatExceptionOfType(ValidationException.class)
      .isThrownBy(() -> employeeController.somethingIsWrong());
  }
}
```

```java
// src/test/java/com/howtodoinjava/controllers/StandaloneControllerTests.java
package com.howtodoinjava.employees.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.howtodoinjava.employees.model.Employee;
import com.howtodoinjava.employees.services.EmployeeService;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EmployeeController.class)
public class StandaloneControllerTests {

  @MockBean
  EmployeeService employeeService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void testFindAll() throws Exception {
    Employee employee = new Employee("Seth", "Chen");
    List<Employee> employees = Arrays.asList(employee);
    Mockito.when(employeeService.findAll()).thenReturn(employees);
    mockMvc.perform(get("/employee"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$", Matchers.hasSize(1)))
      .andExpect(jsonPath("$[0].firstName", Matchers.is("Seth")));
  }
}
```

DAO Tests

```java
// src/test/java/com/howtodoinjava/dao/DaoTests.java
package com.howtodoinjava.employees.dao;

import com.howtodoinjava.employees.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {

  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  public void testCreateReadDelete() {
    Employee employee = new Employee("Seth", "Chen");
    employeeRepository.save(employee);
    Iterable<Employee> employees = employeeRepository.findAll();
    Assertions.assertThat(employees).extracting(Employee::getFirstName).containsOnly("Seth");
    employeeRepository.deleteAll();
    Assertions.assertThat(employeeRepository.findAll()).isEmpty();
  }
}
```

Service Tests

```java
// src/test/java/com/howtodoinjava/services/ServiceTests.java
package com.howtodoinjava.employees.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.howtodoinjava.employees.dao.EmployeeRepository;
import com.howtodoinjava.employees.model.Employee;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

  @InjectMocks
  EmployeeService service;

  @Mock
  EmployeeRepository dao;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindAllEmployees() {
    List<Employee> list = new ArrayList<>();
    Employee empOne = new Employee("John", "Doe");
    Employee empTwo = new Employee("Eric", "Cartman");
    Employee empThree = new Employee("Steve", "Wright");
    list.add(empOne);
    list.add(empTwo);
    list.add(empThree);
    when(dao.findAll()).thenReturn(list);
    List<Employee> empList = service.findAll();
    assertEquals(3, empList.size());
    verify(dao, times(1)).findAll();
  }

  @Test
  void testCreateOrSaveEmployee() {
    Employee employee = new Employee("Seth", "Chen");
    service.save(employee);
    verify(dao, times(1)).save(employee);
  }
}
```

## MockMVC + `WebMvcTest` Annotation - HowToDoInJava

- [Spring Boot MockMvc Example with @WebMvcTest](https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/)

### Maven

The spring-boot-starter-test dependency includes all required dependencies to create and execute tests

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
</dependency>
```

If not using spring boot then include the following dependencies. we can also use JUnit 5 dependencies

```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>{version}</version>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-test</artifactId>
  <version>{version}</version>
  <scope>test</scope>
</dependency>
```

### Unit Test Structure

A JUnit test class to test the Spring MVC controller request and responses can use the below-given configuration

The `@WebMvcTest` annotation is used for Spring MVC tests

- It disables full auto-configuration and instead applies only configuration relevant to MVC tests

The `@WebMvcTest` annotation auto-configures MockMvc instance as well

Using `EmployeeRestController.class` as the parameter, we are asking to initialize only one web controller,
and we need to provide the remaining dependencies required using Mock objects

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
// import your.package.EmployeeRestController; // Replace 'your.package' with the actual package name where EmployeeRestController is located

@WebMvcTest(EmployeeRestController.class)
public class TestEmployeeRestController {

  @Autowired
  private MockMvc mvc;

  // Your test methods would go here
  // ...
}
```

### MockMvc Example

#### HTTP GET API

The HTTP APIs defined in the controller are given below

In the given tests, we are testing two GET APIs – one without a path parameter
and another with a path parameter

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
// import your.package.EmployeeList; // Replace 'your.package' with the actual package name where EmployeeList is located
// import your.package.Employee; // Replace 'your.package' with the actual package name where Employee is located

@RestController
public class EmployeeController {
  @GetMapping(value = "/employees")
  public EmployeeList getAllEmployees() {
    //...
  }

  @GetMapping(value = "/employees/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
    //...
  }
}
```

And corresponding tests for the methods are given below

These tests hit the APIs, pass the path parameters using `MockMvcRequestBuilders`
and verify the status response codes and response content using `MockMvcResultMatchers` and `MockMvcResultHandlers`

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class EmployeeTest {
  @Autowired
  private MockMvc mvc;

  @Test
  public void getAllEmployeesAPI() throws Exception {
    mvc.perform(MockMvcRequestBuilders
      .get("/employees")
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
  }

  @Test
  public void getEmployeeByIdAPI() throws Exception {
    mvc.perform(MockMvcRequestBuilders
      .get("/employees/{id}", 1)
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(1));
  }
}
```

#### HTTP POST API

The HTTP POST API is defined in the controller as:

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
// import your.package.Employee; // Replace 'your.package' with the actual package name where Employee is located

@RestController
public class EmployeeController {

  @PostMapping(value = "/employees")
  public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
    //...
    return new ResponseEntity<>(employee, HttpStatus.CREATED);
  }
}
```

Corresponding mockmvc test for post JSON request is as follows

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeeControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void createEmployeeAPI() throws Exception {
    mvc.perform(MockMvcRequestBuilders
      .post("/employees")
      .content(asJsonString(new Employee(null, "firstName4", "lastName4", "email4@mail.com")))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isCreated())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
```

#### HTTP PUT API

The HTTP API is defined in the controller as:

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
// import your.package.Employee; // Replace 'your.package' with the actual package name where Employee is located

@RestController
public class EmployeeController {

  @PutMapping(value = "/employees/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @Valid @RequestBody Employee employee) {
    //...
    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
  }
}
```

Corresponding tests for the methods are:

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeeControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void updateEmployeeAPI() throws Exception {
    mvc.perform(MockMvcRequestBuilders
      .put("/employees/{id}", 2)
      .content(asJsonString(new EmployeeVO(2, "firstName2", "lastName2", "email2@mail.com")))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("firstName2"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("lastName2"))
      .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email2@mail.com"));
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
```

#### HTTP DELETE API

The HTTP API is defined in the controller as:

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @DeleteMapping(value = "/employees/{id}")
  public ResponseEntity<HttpStatus> removeEmployee(@PathVariable("id") int id) {
    // Example implementation code
    // Remove the employee by id from the database
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
}
```

Corresponding tests for the methods are:

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeeControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void deleteEmployeeAPI() throws Exception {
    mvc.perform(MockMvcRequestBuilders.delete("/employees/{id}", 1))
      .andExpect(status().isAccepted());
  }
}
```

## Testing POST APIs using `TestRestTemplate` - HowToDoInJava

-[Testing POST APIs using `TestRestTemplate` - HowToDoInJava](https://howtodoinjava.com/spring-boot2/testing/testresttemplate-post-example/)

### Maven dependencies

Make sure, you have `spring-boot-starter-test` dependency in your project to get access to `TestRestTemplate` class in runtime

If you are using the `@SpringBootTest` annotation, a `TestRestTemplate` is automatically available and can be `@Autowired` into your test

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```

### HTTP POST API

We are using the code base of [Spring Boot Rest API Example](https://howtodoinjava.com/spring-boot/spring-boot-rest-api-example/)

The POST API is given as below:

- It adds an employee in the employees collection
- It accept employee data in Employee object
- It accepts and creates JSON meta type
- It accepts two HTTP headers i.e. X-COM-PERSIST and X-COM-LOCATION
  - First header is required and second header is optional
- It returns the location of resource created

```java
package com.howtodoinjava.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.howtodoinjava.rest.dao.EmployeeDAO;
import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
  @Autowired
  private EmployeeDAO employeeDao;

  @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addEmployee(
    @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
    @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
    @RequestBody Employee employee)
    throws Exception {
    // Generate resource id
    Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
    employee.setId(id);
    // Add resource
    employeeDao.addEmployee(employee);
    // Create resource location
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(employee.getId())
      .toUri();
    // Send location in response
    return ResponseEntity.created(location).build();
  }
}
```

### Spring `TestRestTemplate`

To test POST API, we need to create spring boot test class annotated with `@SpringBootTest`

```java
package com.howtodoinjava.rest;

import com.howtodoinjava.rest.model.Employee;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootDemoApplicationTests {
  @Autowired
  private TestRestTemplate restTemplate;

  @LocalServerPort
  int randomServerPort;

  @Test
  public void testAddEmployeeSuccess() throws URISyntaxException {
    final String baseUrl = "http://localhost:" + randomServerPort + "/employees/";
    URI uri = new URI(baseUrl);
    Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-COM-PERSIST", "true");
    HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
    ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
    // Verify request succeed
    Assert.assertEquals(201, result.getStatusCodeValue());
  }

  @Test
  public void testAddEmployeeMissingHeader() throws URISyntaxException {
    final String baseUrl = "http://localhost:" + randomServerPort + "/employees/";
    URI uri = new URI(baseUrl);
    Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Employee> request = new HttpEntity<>(employee, headers);
    ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
    // Verify bad request and missing header
    Assert.assertEquals(400, result.getStatusCodeValue());
    Assert.assertEquals(true, result.getBody().contains("Missing request header"));
  }
}
```

## Testing Controller, Service and Dao Layers - HowToDoInJava

- [Spring Boot Tests for Controller, Service and Dao Layers - HowToDoInJava](https://howtodoinjava.com/spring-boot/spring-boot-test-controller-service-dao/)

For demo purposes, we have created a very simple Employee management application

It has a few CRUD API calls for creating, fetching and deleting the employees from the database

Do not forget to use `@ExtendWith(SpringExtension.class)` to initialize and inject the mocks using `Mockito` in the test classes

### Maven

This demo application uses Spring Boot 3 and Java 17

It includes the auto-configuration from the following modules:

- `spring-boot-starter-web`
- `spring-boot-starter-validation`
- `spring-boot-starter-test with Junit 5`
- `spring-boot-starter-data-jpa`

```xml
<dependencies>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>

  <dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
  </dependency>

  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>

</dependencies>
```

### Testing if Application Bootstraps Correctly

This is the simplest of all

Write a Test class annotated with `@SpringBootTest` and check for any important initialized bean
if it has been successfully injected into an `@Autowired` annotation/decorator or not

```sh
mvn test
```

```java
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.howtodoinjava.employees.controllers.EmployeeController;

@SpringBootTest
public class EmployeesApplicationTests {

  @Autowired
  EmployeeController employeeController;

  @Test
  public void contextLoads() {
    Assertions.assertThat(employeeController).isNot(null);
  }
}
```

### Unit Testing the REST `@Controller` Layer

Write a Test class annotated with `@WebMvcTest`

We can specify which `Controller` we want to test in the annotation/decorator value itself

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;

@WebMvcTest(EmployeeController.class)
public class StandaloneControllerTests {

  @MockBean
  EmployeeService employeeService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void testfindAll() throws Exception {
    Employee employee = new Employee("Seth", "Chen");
    List<Employee> employees = Arrays.asList(employee);

    Mockito.when(employeeService.findAll()).thenReturn(employees);

    mockMvc.perform(get("/employee"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$", Matchers.hasSize(1)))
      .andExpect(jsonPath("$[0].firstName", Matchers.is("Seth")));
  }
}
```

### Unit Testing the `@Service` Layer

To unit test the service layer, we must use mock the DAO layer

Spring Spring Boot Architecture Layers (Recap)
![](https://static.javatpoint.com/springboot/images/spring-boot-architecture.png)
![](https://static.javatpoint.com/springboot/images/spring-boot-architecture2.png)

- **Presentation Layer**
  - The presentation layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business layer. In short, it consists of views i.e., frontend part
- **Business Layer**
  - The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers. It also performs authorization and validation
- **Persistence Layer**
  - The persistence layer contains all the storage logic and translates business objects from and to database rows
- **Database Layer**
  - In the database layer, CRUD (create, retrieve, update, delete) operations are performed

Then we can run the tests using `MockitoExtension`

```java
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Assuming Employee and EmployeeRepository are in the same package as ServiceTests
// If not, their import statements need to be added here as well
@ExtendWith(MockitoExtension.class)
public class ServiceTests {
  @InjectMocks
  EmployeeService service;

  @Mock
  EmployeeRepository dao;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindAllEmployees() {
    List<Employee> list = new ArrayList<>();
    Employee empOne = new Employee("John", "Doe");
    Employee empTwo = new Employee("Eric", "Chen");
    Employee empThree = new Employee("Steve", "Wright");
    list.add(empOne);
    list.add(empTwo);
    list.add(empThree);
    when(dao.findAll()).thenReturn(list);
    // Test
    List<Employee> empList = service.findAll();
    assertEquals(3, empList.size());
    verify(dao, times(1)).findAll();
  }
  @Test
  void testCreateOrSaveEmployee() {
    Employee employee = new Employee("Seth", "Chen");
    service.save(employee);
    verify(dao, times(1)).save(employee);
  }
}
```

### Unit testing DAO/`@Repository` Layer

To unit test the DAO layer, we first need an in-memory test database

This we can achieve using `@AutoConfigureTestDatabase`

Then we need to use `@DataJpaTest` which disables full auto-configuration and instead apply only configuration relevant to JPA tests

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.assertj.core.api.Assertions;
// import your.package.name.Employee; // Replace "your.package.name" with the actual package name where Employee class is located
// import your.package.name.EmployeeRepository; // Replace "your.package.name" with the actual package name where EmployeeRepository interface is located

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {
  @Autowired
  EmployeeRepository employeeRepository;
  @Test
  public void testCreateReadDelete() {
    Employee employee = new Employee("Seth", "Chen");
    employeeRepository.save(employee);
    Iterable<Employee> employees = employeeRepository.findAll();
    Assertions.assertThat(employees).extracting(Employee::getFirstName).containsOnly("Seth");
    employeeRepository.deleteAll();
    Assertions.assertThat(employeeRepository.findAll()).isEmpty();
  }
}
```

### Integration Testing

Integration tests cover the whole path through the application

In these tests, we send a request to the application and check that it responds correctly and has changed the database state according to our expectations

The database can be an actual physical database or in-memory database for testing purposes

```java
import javax.validation.ValidationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.howtodoinjava.employees.model.Employee;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntegrationTests {
  @Autowired
  EmployeeController employeeController;

  @Test
  public void testCreateReadDelete() {
    Employee employee = new Employee("Seth", "Chen");
    Employee employeeResult = employeeController.create(employee);
    Iterable<Employee> employees = employeeController.read();
    Assertions.assertThat(employees).first().hasFieldOrPropertyWithValue("firstName", "Seth");
    employeeController.delete(employeeResult.getId());
    Assertions.assertThat(employeeController.read()).isEmpty();
  }

  @Test
  public void errorHandlingValidationExceptionThrown() {
    Assertions.assertThatExceptionOfType(ValidationException.class)
      .isThrownBy(() -> employeeController.somethingIsWrong());
  }
}
```

### Integration Testing using `TestRestTemplate`

We can use `TestRestTemplate` class to perform system testing

It helps in verifying the application as it looks to the client outside the application

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.assertj.core.api.Assertions;
// import your.package.name.Employee; // Replace "your.package.name" with the actual package name where Employee class is located
// import your.package.name.EmployeeController; // Replace "your.package.name" with the actual package name where EmployeeController class is located

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SystemTests {

  @Autowired
  private EmployeeController controller;

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void testCreateReadDelete() {
    String url = "http://localhost:" + port + "/employee";
    Employee employee = new Employee("Seth", "Chen");
    ResponseEntity<Employee> entity = restTemplate.postForEntity(url, employee, Employee.class);
    Employee[] employees = restTemplate.getForObject(url, Employee[].class);
    Assertions.assertThat(employees).extracting(Employee::getFirstName).containsOnly("Seth");
    restTemplate.delete(url + "/" + entity.getBody().getId());
    Assertions.assertThat(restTemplate.getForObject(url, Employee[].class)).isEmpty();
  }

  @Test
  public void testErrorHandlingReturnsBadRequest() {
    String url = "http://localhost:" + port + "/wrong";
    try {
      restTemplate.getForEntity(url, String.class);
    } catch (HttpClientErrorException e) {
      Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
  }
}
```

## Testing REST Controllers `@RestClientTest` - HowToDoInJava

-[Testing REST Controllers with Spring Boot @RestClientTest - HowToDoInJava](https://howtodoinjava.com/spring-boot2/testing/restclienttest-test-services/)

### `@RestClientTest` Annotation

In spring framework, `@RestClientTest` is one of the test specific annotations that disables full auto-configuration and instead apply only configuration relevant to specific tests

`@RestClientTest` annotation/decorator is used to test service layer which uses `RestTemplate `to interact with external services

This annotation/decorator disables full auto-configuration and instead apply only configuration relevant to rest client tests

To import the annotation/decorator in application, include `spring-boot-starter-test` starter module into `pom.xml` file

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

### Testing service which uses RestTemplateBuilder

If the service under test uses `RestTemplateBuilder` to obtain the `RestTemplate`
for invoking external services, we can use `@RestClientTest` annotation/decorator directly over test class

```java
// Service
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.springexamples.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  RestTemplate restTemplate;

  @Autowired
  public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {
    restTemplate = restTemplateBuilder.build();
  }

  @Override
  public String testUserService() {
    final String uri = "http://localhost:8080/users";
    String result = restTemplate.getForObject(uri, String.class);
    System.out.println(result);
    return result;
  }
}
```

```java
// Test Class
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import com.springexamples.demo.service.UserService;
import com.springexamples.demo.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@RestClientTest(UserServiceImpl.class)
public class UserServiceTest {
  @Autowired
  private MockRestServiceServer server;

  @Autowired
  private UserService client;

  @Test
  public void testServiceCall() {
    this.server.expect(requestTo("http://localhost:8080/users"))
      .andRespond(withSuccess("<users></users>", MediaType.TEXT_PLAIN));
    String userServiceResponse = client.testUserService();
    assertThat(userServiceResponse).isEqualTo("<users></users>");
  }
}
```

### Testing Service which does NOT use RestTemplateBuilder

If the service under test injects a `RestTemplate` directly, we can can add `@AutoConfigureWebClient(registerRestTemplate=true)` over test class

Also, if you are creating `RestTemplate` bean in main application configuration then you will need to enable bean overriding to true

```properties
spring.main.allow-bean-definition-overriding=true
```

```java
// Service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.springexamples.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
    RestTemplate restTemplate;

  @Override
  public String testUserService() {
    final String uri = "http://localhost:8080/users";
    String result = restTemplate.getForObject(uri, String.class);
    System.out.println(result);
    return result;
  }
}
```

```java
// Test Class
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.MockRestServiceServer;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@RestClientTest(UserServiceImpl.class)
@AutoConfigureWebClient(registerRestTemplate = true)
public class UserServiceTest {
  @Autowired
  private MockRestServiceServer server;

  @Autowired
  private UserService client;

  @Test
  public void testServiceCall() {
    this.server.expect(requestTo("http://localhost:8080/users"))
      .andRespond(withSuccess("<users></users>", MediaType.TEXT_PLAIN));
    String userServiceResponse = client.testUserService();
    assertThat(userServiceResponse).isEqualTo("<users></users>");
  }
}
```

## Testing REST Controllers with JUnit 5 - HowToDoInJava

- [Testing REST Controllers with JUnit 5 - HowToDoInJava](https://howtodoinjava.com/spring-boot2/testing/rest-controller-unit-test-example/)

### Setup

```xml
<!-- pom.xml -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

Here is the Spring boot rest controller for which we will be writing unit tests

- The controller has a dependency on `EmployeeDao` class for persistence
- addEmployee() method needs access to the request context using `ServletUriComponentsBuilder`
- addEmployee() method returns HTTP status and header using `ResponseEntity` class

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
// import your.package.Employee;
// import your.package.EmployeeDao;
// import your.package.Employees; // Replace "your.package" with the actual package names where Employee, EmployeeDao, and Employees are located

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
  @Autowired
  private EmployeeDao employeeDao;

  @GetMapping(path = "/", produces = "application/json")
  public Employees getEmployees() {
    return employeeDao.getAllEmployees();
  }

  @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
    employeeDao.addEmployee(employee);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(employee.getId())
      .toUri();
    return ResponseEntity.created(location).build();
  }
}
```

### Unit Testing Spring Controller using `@WebMvcTest`

The `@WebMvcTest `annotation is used to unit test the Spring MVC components (`@Controller`, `@ControllerAdvice`)

It disables the full autoconfiguration and only configures the Spring Security and MockMvc

https://docs.spring.io/spring-boot/api/java/org/springframework/boot/test/autoconfigure/web/servlet/WebMvcTest.html

https://docs.spring.io/spring-framework/docs/6.0.2/javadoc-api/org/springframework/test/web/servlet/MockMvc.html

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
// import your.package.EmployeeRestController; // Replace "your.package" with the actual package name where EmployeeRestController is located

@WebMvcTest(EmployeeRestController.class)
public class TestEmployeeRestController {

  @Autowired
  private MockMvc mvc;
}
```

Finally, use `MockMvc` bean instance to invoke the APIs and verify the results

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import your.package.Employee; // Replace "your.package" with the actual package name where Employee is located

@WebMvcTest(EmployeeRestController.class)
public class TestEmployeeRestController {
  @Autowired
  private MockMvc mvc;

  @Test
  public void getAllEmployeesAPI() throws Exception {
    mvc.perform(MockMvcRequestBuilders
      .get("/employees")
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
  }

  @Test
  public void createEmployeeAPI() throws Exception {
    mvc.perform(MockMvcRequestBuilders
      .post("/employees")
      .content(asJsonString(new Employee(null, "firstName", "lastName", "admin@mail.com")))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isCreated())
      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
```

### Unit Testing Spring Controller using Mockito

```xml
<!-- Mockito Extension -->
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-junit-jupiter</artifactId>
  <scope>test</scope>
</dependency>
```

The test class contains unit tests for the spring boot rest controller using the Mockito APIs

The class:

- Uses `@Mock` annotation to created mock object for `EmployeeDao` dependency
- Uses `@InjectMocks` to create `EmployeeController` class and also inject the mocked `employeeDao` instance
- `MockitoExtension` initializes mocks and handles strict stubbings
  - This extension is the JUnit Jupiter equivalent of our JUnit4 `MockitoJUnitRunner`
- `MockHttpServletRequest` and `RequestContextHolder` supply the request context where code under test needs it
- Use `org.mockito.Mockito.when()` and `org.mockito.Mockito.thenReturn()` apis to mock the desired behavior
- Finally use JUnit5 assertions to assert the test results with expected results

```java
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import com.howtodoinjava.rest.controller.EmployeeController;
import com.howtodoinjava.rest.Dao.EmployeeRepository;
import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
  @InjectMocks
  EmployeeController employeeController;
  @Mock
  EmployeeDao employeeDao;

  @Test
  public void testAddEmployee() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    when(employeeDao.addEmployee(any(Employee.class))).thenReturn(true);
    Employee employee = new Employee(1, "Seth", "Chen", "howtodoinjava@gmail.com");
    ResponseEntity<Object> responseEntity = employeeController.addEmployee(employeeToAdd);
    assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
  }

  @Test
  public void testFindAll() {
    Employee employee1 = new Employee(1, "Seth", "Chen", "howtodoinjava@gmail.com");
    Employee employee2 = new Employee(2, "Eric", "Cartman", "example@gmail.com");
    Employees employees = new Employees();
    employees.setEmployeeList(Arrays.asList(employee1, employee2));
    when(employeeDao.getAllEmployees()).thenReturn(employees);
    Employees result = employeeController.getEmployees();
    assertThat(result.getEmployeeList().size()).isEqualTo(2);
    assertThat(result.getEmployeeList().get(0).getFirstName()).isEqualTo(employee1.getFirstName());
    assertThat(result.getEmployeeList().get(1).getFirstName()).isEqualTo(employee2.getFirstName());
  }
}
```

### Best Practices

While writing a JUnit test for a REST controller method, we shall keep in mind that:

- A unit test is supposed to test only a certain part of code (i.e. code written in the controller class), so we shall mock all the dependencies injected and used in the controller class
- If the test utilizes outer dependencies (e.g., database/network), then it is integration testing, not unit testing
- We should NOT use any web server; otherwise, it will slow down unit testing
- Each unit test should be independent of other tests
- By definition, unit tests should be fast

## Testing JPA Repositories using `@DataJpaTest` - HowToDoInJava

- [Spring Boot `@DataJpaTest` - HowToDoInJava](https://howtodoinjava.com/spring-boot2/testing/datajpatest-annotation/)

### `@Repository` Annotation/Decorator

In the spring framework, `@Repository` is one of the stereotype annotations which
enable annotated classes (DAO) to be discovered and registered with the application context

We are creating one such `EmployeeRepository` and we will be writing a few JUnit tests to test it

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
  //...
}
```

### `@DataJpaTest` Annotation

In Spring boot applications, we can use `@DataJpaTest` annotation that focuses only
on testing the Java Persistence API (JPA) components. `@DataJpaTest` will disable full auto-configuration
of the application context and instead apply only configuration relevant to JPA components and tests

By default, it scans for `@Entity` classes and configures Spring Data JPA repositories
annotated with `@Repository` annotation

#### Embedded Database

If an embedded database is available on the classpath, it configures one as well

Use `@AutoConfigureTestDatabase` to override this behavior

For example, to run the tests against an application configured real database, use `Replace.NONE`

```java
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestAppData {
  // ...
}
```

#### SQL Logs

To log SQL queries, set the `spring.jpa.show-sql` property to `true`

```conf
spring.jpa.show-sql = true
```

#### Transactions

By default, data JPA tests are transactional and roll back at the end of each test

To disable this feature, use `Propagation.NOT_SUPPORTED`

```java
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TestAppData {
  // ..
}
```

#### TestEntityManager

A nice feature is that these tests may also inject a [TestEntityManager bean](https://docs.spring.io/spring-boot/api/java/org/springframework/boot/test/autoconfigure/orm/jpa/TestEntityManager.html)
which provides an alternative to the standard JPA EntityManager that is specifically designed for tests

Note: When using `TestEntityManager`, tests should be running in a transaction
The `@DataJpaTest` includes `@Transactional` annotation in it, so we do not need to do anything extra for it

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class TestAppData {
  @Autowired
  private TestEntityManager em;
  //..
}
```

#### JUnit Runner

When using JUnit 4, the `@RunWith(SpringRunner.class)` should be used in combination `@DataJpaTest`

```java
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
// import your.package.JpaConfig; // Replace "your.package" with the actual package name where JpaConfig is located

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(JpaConfig.class)
public class TestAppData {
  //...
}
```

When using JUnit 5, this annotation already contains the statement `@ExtendWith(SpringExtension.class)`,
so NO additional runner definition is required

```java
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
// import your.package.JpaConfig; // Replace "your.package" with the actual package name where JpaConfig is located

@DataJpaTest
@Import(JpaConfig.class)
public class TestAppData {
  //...
}
```

### Demo/Example

Given `TestBootstrappingEntityManager` class tests the `EmployeeRepository` which is of type `JpaRepository`
and is used to store and retrieve `EmployeeEntity` instances from underlying databases

Watch the program output in the console. We will find that only JPA-related configuration .
has been loaded into context and then tests execution start from there

```java
import com.howtodoinjava.demo.data.EmployeeRepository;
import com.howtodoinjava.demo.data.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(JpaConfig.class)
public class TestBootstrappingEntityManager {

  @Autowired
  private TestEntityManager em;

  @Autowired
  private EmployeeRepository repository;

  @Test
  public void contextLoads() {
    Assertions.assertNotNull(em);
  }

  @Test
  void verifyBootstrappingByPersistingAnEmployee() {
    Employee emp = new Employee();
    emp.setEmail("demo-user@email.com");
    emp.setFirstName("demo");
    emp.setLastName("user");

    Assertions.assertNull(emp.getEmployeeId());
    em.persist(emp);
    Assertions.assertNotNull(emp.getEmployeeId());
  }

  @Test
  void verifyRepositoryByPersistingAnEmployee() {
    Employee emp = new Employee();
    emp.setEmail("demo-user@email.com");
    emp.setFirstName("demo");
    emp.setLastName("user");

    Assertions.assertNull(emp.getEmployeeId());
    repository.save(emp);
    Assertions.assertNotNull(emp.getEmployeeId());
  }
}
```

## How to Write Unit Tests - HowToDoInJava

- [How to Unit Test a Spring Boot Application](https://howtodoinjava.com/spring-boot/spring-boot-testing/)

### Unit Test vs Integration Test

Typically any software application is divided into different modules and components

Unit Test = When a single module/component is tested IN ISOLATION

- It is written to verify that a relatively small piece of code is doing what it is intended to do
- Unit tests do NOT verify whether the application code works with external dependencies correctly
- It focuses on a single component and mocks all dependencies this component interacts with

Integration Test = When multiple modules/components are INTEGRATED TOGETHER AND TESTED

- Once different modules are developed and integrated then Integration testing is carried out
- Its main purpose is to discover the issues when different modules interact with each other to process user requests end to end
- Integration tests can put the whole application in scope or only certain components (based on what is being tested)
- They may need to require resources like database instances and hardware to be allocated for them
- However, these interactions can be mocked out as well to improve the test performance

In terms of typical Spring boot crud application, unit tests can be written to test REST controllers, DAO layer etc separately
It will not require even the embedded server as well

In integration testing, we shall focus on testing complete request processing from
the controller to the persistence layer. The application shall run inside the embedded server
to create an application context and all beans. Some of these beans may be overridden to mock certain behaviors

### Maven

In Spring Boot 2.3.0+, Junit Jupiter is included instead

To write tests in spring boot applications, the best way is to include `spring-boot-starter-test` in `pom.xml` file
It brings Junit, AssertJ, Hamcrest, Mockito, JSONassert and JsonPath dependencies into the application with the test scope

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

### Initializing the Tests

### JUnit4 - `@RunWith(SpringRunner.class)`

By default, tests written are on Junit 4

To run such tests, we can use SpringRunner class (`extends SpringJUnit4ClassRunner`) with `@RunWith` annotation at the class level

```java
@RunWith(SpringRunner.class)
@WebFluxTest(controllers = EmployeeController.class)
public class EmployeeRestControllerTest {
  // Tests
}
```

### JUnit4 with Mockito - `@RunWith(MockitoJUnitRunner.class)`

If tests use `@Mock` objects then prefer using `MockitoJUnitRunner`

It initializes mocks annotated with `@Mock`, so that explicit usage of `MockitoAnnotations.initMocks(Object)`/`MockitoAnnotations.initMocks(this)` is NOT necessary

Mocks are initialized before each test method

```java
@RunWith(MockitoJUnitRunner.class)
public class EmployeeRestControllerTest {

  @Mock
  private Repository repository;
}
```

### JUnit5 - `@ExtendWith(SpringExtension.class)`

The `SpringExtension` integrates the Spring TestContext Framework into JUnit 5's Jupiter programming model

https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/junit/jupiter/SpringExtension.html

```java
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
// import your.package.EmployeeController;
// import your.package.EmployeeService; // Replace "your.package" with the actual package names where these classes are located

@ExtendWith(SpringExtension.class) // included in @WebFluxTest
@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeService.class)
public class EmployeeControllerTest {
  // Tests
}
```

### JUnit5 with Mockito - `@ExtendWith(MockitoExtension.class)`

`MockitoExtension `initializes mocks and handles strict stubbings

https://www.javadoc.io/doc/org.mockito/mockito-junit-jupiter/3.0.0/org/mockito/junit/jupiter/MockitoExtension.html

It is equivalent of the `MockitoJUnitRunner`

Most test annotations include this annotation with them so no need to include it explicitly

```java
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
  // tests
}
```

### Spring Boot Test Annotations

Spring boot provides various annotations to enable test infrastructure related to only certain parts of the application

It also provides annotations that help in integration testing as well

#### `@SpringBootTest`

The `@SpringBootTest` annotation helps in writing integration tests

It starts the embedded server and fully initializes the application context

We can inject the dependencies in test class using `@Autowired` annotation

We can also provide test specific beans configuration using nested `@Configuration` class or explicit `@TestConfiguration` classes

It also provides support for different web environment modes and running web server listening on a defined or random port
It also registers a `TestRestTemplate` and/or `WebTestClient` bean for use in web tests

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import your.package.SpringBootDemoApplication; // Replace "your.package" with the actual package name where SpringBootDemoApplication is located

@SpringBootTest(classes = SpringBootDemoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate testRestTemplate;

  // Tests
}
```

#### `@WebMvcTest`

The `@WebMvcTest` annotation is used for Spring MVC tests

It disables full auto-configuration and instead applies only configuration relevant to MVC tests

It also auto-configures MockMvc instance as well

We can initialize only one web controller by passing `.class` as the annotation attribute

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
// import your.package.EmployeeRestController; // Replace "your.package" with the actual package name where EmployeeRestController is located

@WebMvcTest(EmployeeRestController.class)
public class TestEmployeeRestController {

  @Autowired
  private MockMvc mvc;

  // tests
}
```

#### `@WebFluxTest`

The `@WebFluxTest` annotation disables full auto-configuration and instead applies
only configuration relevant to WebFlux tests

By default, tests annotated with `@WebFluxTest` will also auto-configure a `WebTestClient`

Typically `@WebFluxTest` is used in combination with `@MockBean` or `@Import` to create any collaborators required by the controller bean

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
// import your.package.EmployeeController;
// import your.package.EmployeeRepository;
// import your.package.EmployeeService; // Replace "your.package" with the actual package names where these classes are located

@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeService.class)
public class EmployeeControllerTest {

  @MockBean
  EmployeeRepository repository;

  @Autowired
  private WebTestClient webClient;

  // Tests
}
```

- `@JdbcTest`
  - Can be used for a typical JDBC test when a test focuses only on jdbc-based components
  - It disables full auto-configuration and instead applies only configuration relevant to JDBC tests
  - By default, tests annotated with `@JdbcTest` are transactional and roll back at the end of each test
  - The annotation configures an in-memory embedded database and JdbcTemplate
- `@JooqTest`
  - It can be used when a test focuses only on jOOQ-based components
  - Beware that by default, tests annotated with `@JooqTest` use the application-configured database
  - To use an embedded in-memory database, `@AutoConfigureTestDatabase` annotation can be used to override these settings
- `@JsonTest`
  - It is used when a test focuses only on JSON serialization. It initializes the `@JsonComponent`, JacksonTester, JsonbTester and GsonTester fields
- `@DataJpaTest`
  - It can be used to test JPA applications
  - By default, it scans for `@Entity` classes and configures Spring Data JPA repositories
  - If an embedded database is available on the classpath, it configures one as well
  - By default, data JPA tests are transactional and roll back at the end of each test
  - Data JPA tests may also inject a `TestEntityManager` bean, which provides an alternative to the standard JPA EntityManager that is specifically designed for tests
- `@DataMongoTest`
  - Is used to test MongoDB applications
  - By default, it configures an in-memory embedded MongoDB (if available), configures a MongoTemplate, scans for `@Document` classes, and configures Spring Data MongoDB repositories
- `@DataRedisTest`
  - Is used to test Redis applications
  - By default, it scans for `@RedisHash` classes and configures Spring Data Redis repositories
- `@DataLdapTest`
  - Is used to test LDAP applications
  - By default, it configures an in-memory embedded LDAP (if available), configures a LdapTemplate, scans for `@Entry` classes, and configures Spring Data LDAP repositories
- `@RestClientTest`
  - Is used to test REST clients
  - By default, it auto-configures Jackson, GSON, and Jsonb support, configures a RestTemplateBuilder, and adds support for MockRestServiceServer

### `@TestConfiguration`

The `@TestConfiguration` is specialized form of `@Configuration` that can be used to define additional beans or customizations for a test

In spring boot, any beans configured in a top-level class annotated with `@TestConfiguration` will NOT be picked up via component scanning

We must explicitly register the `@TestConfiguration` class with the class that contains the test cases

The best thing is that these test configurations are not automatically part of the application's primary configuration

They are available only on-demand using one of below two ways to include this additional test configuration

#### `@Import` Annotation

It can be used to import one or more configuration classes into the application context or spring test context

```java
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

@TestConfiguration
public class AppTestConfiguration {

  @Bean
  DataSource inMemoryDataSource() {
    //...
  }
}
```

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import javax.sql.DataSource;
// import your.package.AppTestConfiguration; // Replace "your.package" with the actual package name where AppTestConfiguration is located

@Import(AppTestConfiguration.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootDemoApplicationTests {
  @LocalServerPort
  int randomServerPort;

  @Autowired
  DataSource datasource;

  // Tests
}
```

#### Static Nested Classes

We can define the test configurations in nested classes inside the test class

The nested class can be annotated with `@Configuration` or `@TestConfiguration` annotations

In case of nested `@Configuration` class, the given configuration would be used "instead of" the application's primary configuration

A nested `@TestConfiguration` class is used "in addition to" the application's primary configuration

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

public class AppTests {
  @Autowired
  DataSource datasource;

  // Tests

  @TestConfiguration
  static class AppTestConfiguration {

    @Bean
    DataSource inMemoryDataSource() {
      //
    }
  }
}
```

### Mocking

#### Using `@Mock` Annotation

To process Mockito annotations with JUnit, we need to use `MockitoExtension` which automatically
initializes all the objects annotated with `@Mock` and `@InjectMocks` annotations

- [Mockito Docs](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [Mockito - HowToDoInJava](https://howtodoinjava.com/mockito/mockito-annotations/)
- Mockito = Java Testing Framework that helps you create Mock objects and stub behaviours when writing unit tests
- Especially useful to isolate specific components for testing and in isolation from its dependencies
- Steps
  - Add `@Mock` annotation/decorator to service's DEPENDENCIES
  - Add `@InjectMocks` annotation/decorator to service ITSELF
  - Add `MockitoAnnotations.openMocks(this);` to start mocks for current test class

```java
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
// import your.package.EmployeeManager;
// import your.package.EmployeeDao; // Replace "your.package" with the actual package names where EmployeeManager and EmployeeDao are located

@ExtendWith(MockitoExtension.class)
public class TestEmployeeManager {

  @InjectMocks
  EmployeeManager manager;

  @Mock
  EmployeeDao dao;

  // Tests
}
```

#### Without `@MockBean` Annotation

The `@MockBean` annotation used to add mocks to a Spring ApplicationContext

It allows one to mock a class or an interface and to record and verify behaviors on it

Interestingly, any existing bean of the same type defined in the context will be replaced by the mock

If no existing bean is defined a new one will be added

`@MockBean` is similar to Mockito's `@Mock` but with Spring support

We will generally use `@MockBean` along with either `@WebMvcTest` or `@WebFluxTest` annotations

These annotations are for web test slices and are limited to a single controller

In the example below, we are mocking the `EmployeeRepository` bean

In this way, all the application code will be invoked but all repository interactions will be mocked

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
// import your.package.EmployeeController;
// import your.package.EmployeeRepository;
// import your.package.EmployeeService; // Replace "your.package" with the actual package names where these classes are located

@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeService.class)
public class EmployeeControllerTest {
  @MockBean
  EmployeeRepository repository;

  @Autowired
  private WebTestClient webClient;

  // Tests
}
```

## Adding Mocks to SpringApplicationContext using `@MockBean` - HowToDoInJava

- [Spring Boot `@MockBean` Example - HowToDoInJava](https://howtodoinjava.com/spring-boot2/testing/spring-mockbean-annotation/)

Spring boot `@MockBean` annotation is used to add mocks to a Spring `ApplicationContext`

### `@MockBean` Annotation

- `@MockBean` Annotation allows us to mock a class/interface and record + verify its behaviours
- `@MockBean` Annotation can be used on the class-level or on fields in either `@Configuration` classes, or test classes that are `@RunWith` the SpringRunner

```java
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ApiControllerTest {
  @MockBean
  private ApiService service;
}
```

```java
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
// import your.package.ApiService; // Replace "your.package" with the actual package name where ApiService is located

@RunWith(SpringRunner.class)
@MockBean(ApiService.class)
public class ApiControllerTest {
  @Autowired
  private ApiService service;
}
```

```java
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
// import your.package.AppConfiguration; // Replace "your.package" with the actual package name where AppConfiguration is located

@RunWith(SpringRunner.class)
public class ApiControllerTest {

  @Autowired
  private ApiService service;

  @Configuration
  @Import(AppConfiguration.class)
  static class Config {
    @MockBean
    private ApiService service;
  }
}
```

- The mock will replace any existing single bean of the same type defined in the context. If no existing bean is defined a new one will be added
- Mocks can be registered by type or by bean name
- If there is more than one bean of the requested type, `@Qualifier` metadata must be specified at the field level

```java
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
// import your.package.ApiService; // Replace "your.package" with the actual package name where ApiService is located

@RunWith(SpringRunner.class)
public class ApiControllerTest {
  @MockBean
  @Qualifier("apiV1")
  private ApiService service;
}
```

- The mock will also be injected into the field when `@MockBean` is used on a field and registered in the application context
- This annotation is `@Repeatable` and may be specified multiple times when working with Java 8 or contained within an `@MockBeans` annotation
- `@MockBean` is similar to Mockito's `@Mock` but with Spring support

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
// import your.package.EmployeeService; // Replace "your.package" with the actual package name where EmployeeService is located
// import your.package.EmployeeRepository; // Replace "your.package" with the actual package name where EmployeeRepository is located

@RunWith(SpringRunner.class)
public class ApiControllerTest {
  @MockBeans({ @MockBean(EmployeeService.class), @MockBean(EmployeeRepository.class) })
  public class EmployeeControllerTest {
    @Autowired
    EmployeeService service;

    @Autowired
    EmployeeRepository repository;
  }
}
```

### Difference between Mockito `@Mock` and Spring Boot `@MockBean`

Both annotations are used to add mock objects, which allow to mock a class or an interface
and to record and verify behaviors on it. However, we can prefer to use one over another in a certain way

As we write a test that doesn't need any dependencies from the Spring Boot container,
the Mockito's `@Mock` shall be used. It is fast and favors the isolation of the tested component

If the test needs to rely on the Spring Boot container and we want also to add or
mock one of the container beans then `@MockBean` from Spring Boot is preferred way to add mocks

### `@MockBean` in Unit Testing

We will generally use `@MockBean` along with either `@WebMvcTest` or `@WebFluxTest` annotations

These annotations are for web test slices and are limited to a single controller

We can use `@MockBean` to provide mock implementations for required collaborators in the controller class

### `@MockBean` Example

We have already seen the usage of `@MockBean` in `@WebFluxTest` example

In the given test class below, we are testing the REST endpoints of the flux controller
class `EmployeeController`. It tests the api methods and service interaction
whilst mocking the persistence layer code (i.e. `EmployeeRepository`)

```java

// EmployeeControllerTest.java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.times;
// import your.package.Employee;
// import your.package.EmployeeController;
// import your.package.EmployeeRepository;
// import your.package.EmployeeService; // Replace "your.package" with the actual package names where these classes are located

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeService.class)
public class EmployeeControllerTest {
  @MockBean
  EmployeeRepository repository;

  @Autowired
  private WebTestClient webClient;

  @Test
  void testCreateEmployee() {
    Employee employee = new Employee();
    employee.setId(1);
    employee.setName("Test");
    employee.setSalary(1000);

    Mockito.when(repository.save(employee)).thenReturn(Mono.just(employee));

    webClient.post()
      .uri("/create")
      .contentType(MediaType.APPLICATION_JSON)
      .body(BodyInserters.fromObject(employee))
      .exchange()
      .expectStatus().isCreated();

    Mockito.verify(repository, times(1)).save(employee);
  }
}
```

## How to Write Integration Tests - HowToDoInJava

- [How to Write Integration Test in Spring Boot](https://howtodoinjava.com/spring-boot2/testing/spring-integration-testing/)

### What to Test in Integration Testing?

While doing integration testing in spring boot applications, we should keep in mind that:

- An integration test is supposed to test whether different modules are bounded correctly and if they work as expected
- The integration tests should NOT utilize the actual production dependencies (e.g., database/network), and they can mimic certain behaviors
- The application should run in `ApplicationContext` and run tests in it
- Spring boot provides `@SpringBootTest` annotation, which starts the embedded server, creates a web environment and then enables `@Test` methods to do integration testing
  - Use its `webEnvironment` attribute for it
  - It also creates the `ApplicationContext` used in the tests
- Using an in-memory database is recommended for mimicking the database
  - Though it is not mandatory, we can use Mockito to mock the database interactions
- It is recommended to use test-specific configurations using `@TestConfiguration` annotation

Note: Use `@SpringBootTest` annotation for tests that cover the whole Spring Boot application from incoming request to database

### Writing the Integration Tests

#### Maven

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

#### REST Controller to Test

Here is the Spring boot rest controller we will be writing tests for

- The controller has dependency on `EmployeeRepository` class for persistence
- `getEmployees()` method returns list of all employees. Typically, in real applications, it will accept pagination parameters
- `addEmployee()` method need access to the request context using `ServletUriComponentsBuilder`
- `addEmployee()` method returns HTTP status and header using `ResponseEntity` class

```java
import java.net.URI;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.howtodoinjava.rest.dao.EmployeeRepository;
import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@RestController
public class EmployeeController {
  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping(path = "/employees", produces = "application/json")
  public Employees getEmployees() {
    Employees response = new Employees();
    List<Employee> list = new ArrayList<>();
    employeeRepository.findAll().forEach(e -> list.add(e));
    response.setEmployeeList(list);
    return response;
  }

  @PostMapping(path = "/employees", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
    // Add resource
    employee = employeeRepository.save(employee);
    // Create resource location
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(employee.getId())
      .toUri();
    // Send location in response
    return ResponseEntity.created(location).build();
  }
}
```

#### Integration Tests Example

The test class given below contains integration tests for the spring boot rest controller mentioned above

This test class:

- Uses `@SpringBootTest` annotation, which loads the actual application context
- Uses `WebEnvironment.RANDOM_PORT` to create run the application at some random server port
- `@LocalServerPort` gets the reference of port where the server has started
  - It helps in building the actual request URIs to mimic real client interactions
- Use `TestRestTemplate` class helps in invoking the HTTP requests, which are handled by the controller class
- `@Sql` annotation helps in populating the database with some prerequisite data if the test is dependent on it to test the behavior correctly
- `org.junit.jupiter.api.Test` annotations are from Junit 5 and mark the method as a test method to run

The test class starts the whole application in an embedded server and executes each test one by one

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import com.howtodoinjava.rest.model.Employee;
import com.howtodoinjava.rest.model.Employees;

@SpringBootTest(classes = SpringBootDemoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests {
  @LocalServerPort
  private int port;
  @Autowired
  private TestRestTemplate restTemplate;

  @Sql({ "schema.sql", "data.sql" })
  @Test
  public void testAllEmployees() {
    assertTrue(
      this.restTemplate
        .getForObject("http://localhost:" + port + "/employees", Employees.class)
        .getEmployeeList().size() == 3);
  }

  @Test
  public void testAddEmployee() {
    Employee employee = new Employee("Seth", "Chen", "howtodoinjava@gmail.com");
    ResponseEntity<String> responseEntity = this.restTemplate
      .postForEntity("http://localhost:" + port + "/employees", employee, String.class);
    assertEquals(201, responseEntity.getStatusCodeValue());
  }
}
```

## Mocking APIs with `WireMock` - HowToDoInJava

- [Mocking APIs with `WireMock` - HowToDoInJava](https://howtodoinjava.com/java/library/mock-rest-api-with-wiremock/)

The microservices architecture allows us to develop, test and deploy different components of an application independently

Though such a component can be developed independently, testing this in isolation can be challenging

For a true integration testing of a microservice, we must test its interaction with other APIs

[WireMock](https://wiremock.org/) helps in integration testing when we need to mock external APIs
for testing a particular API dependent on those external APIs to complete a transaction

WireMock is a popular HTTP mock server that helps in mocking APIs and stubbing responses

Note: Wiremock can be run as part of an application or a standalone process

### Maven Dependency

https://mvnrepository.com/artifact/com.github.tomakehurst/wiremock-jre8

```
<dependency>
   <groupId>com.github.tomakehurst</groupId>
   <artifactId>wiremock-jre8</artifactId>
   <version>2.35.2</version>
   <scope>test</scope>
</dependency>
```

### How to Use Wiremock

There are a few ways for getting started with Wiremock

#### Via `WireMockServer`

The simplest way to create `WireMockServer` instance is to call its constructor

By default, wiremock uses the hostname `localhost` and port number `8080`

We can initialize a `WireMockServer` with a random/fixed port number and a custom hostname using `.configureFor()` method

Note: It is very important to START the server BEFORE the tests execute, and STOP the server AFTER the tests finish

We can reset the mock stubs in between the tests

The following is an example of setting up wiremock with [JUnit 5 tests](https://howtodoinjava.com/junit-5-tutorial/)

Note: This technique can be used in standalone Java applications as well. It is not limited to only tests

```java
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class WireMockServerTest {
  static WireMockServer wireMockServer = new WireMockServer();

  @BeforeAll
  public static void beforeAll() {
    //WireMock.configureFor("custom-host", 9000, "/api-root-url");
    wireMockServer.start();
  }

  @AfterAll
  public static void afterAll() {
    wireMockServer.stop();
  }

  @AfterEach
  public void afterEach() {
    wireMockServer.resetAll();
  }
}
```

#### Via `WireMockRule`

The `WireMockRule` was the preferred way to configure, start and stop the server in JUnit 4 tests, though we can use it in JUnit 5 tests as well

It is very similar to `WireMockServer` class in features and control

The following is an example of setting up wiremock with JUnit 4 tests

```java
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.AfterEach;
import org.junit.Before;
import org.junit.Rule;

public class WireMockServerTest {
  @Rule
  WireMockRule wireMockRule = new WireMockRule();

  @Before
  public void beforeAll() {
    wireMockRule.start();
  }

  @After
  public void afterAll() {
    wireMockRule.stop();
  }

  @AfterEach
  public void afterEach() {
    wireMockRule.resetAll();
  }
}
```

#### Via `@WireMockTest`

The `@WireMockTest` annotation is another convenient way to power JUnit tests with wiremock

This is class-level annotation

`@WireMockTest` starts the wiremock server before the tests start, stops the server after the end of the tests
and cleans the context between tests

So basically, it does all three steps implicitly that we did in previous sections using before and after annotations

```java
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest
public class WireMockTestAnnotationTest {
  //...
}
```

#### Enabling HTTPS

We can enable HTTPS via the `httpsEnabled` annotation parameter

By default, a random port will be assigned

To fix/set the HTTPS port number, use `httpsPort` parameter

```java
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

@WireMockTest(httpsEnabled = true, httpsPort = 8443)
```

With `WireMockRule`, we can pass the `WireMockConfiguration.options()` as constructor argument

The same configuration steps work with `WireMockServer` as well

```java
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;

public class WireMockExample {
  WireMockServer wm = new WireMockServer(options().port(8080).httpsPort(8443));
  // or
  @Rule
  public WireMockRule wireMockRule = new WireMockRule(options().port(8080).httpsPort(8443));
}
```

### WireMock Example

Let's start with creating a very simple API stub, invoke it using any HTTP client and verify that the mock server was hit

- To stub the mock API response, use the `WireMock.stubFor()` method
  - It accepts a `MappingBuilder` instance that we can use to build API mapping information such as URL, request parameters and body, headers, authorization etc
- To test the API, we can use any HTTP client such as `HttpClient`, `RestTemplate` or `TestRestTemplate`.
- We will be using TestRestTemplate for this example
- To verify if the request has hit the mock API, we can use `WireMock.verify()` method

The following is an example of all three steps with a very simple mock API

Note: If we prefer to use Behaviour Driven Development (BDD) language in our tests then we can replace `.stubFor()` with `.givenThat()`

```java
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.web.client.RestTemplate;

@WireMockTest
public class WireMockTestAnnotationTest {
  @Test
  void simpleStubTesting(WireMockRuntimeInfo wmRuntimeInfo) {
    String responseBody = "Hello World !!";
    String apiUrl = "/api-url";
    // Define stub
    stubFor(get(apiUrl).willReturn(ok(responseBody)));
    // Hit API and check response
    String apiResponse = getContent(wmRuntimeInfo.getHttpBaseUrl() + apiUrl);
    assertEquals(apiResponse, responseBody);
    // Verify API is hit
    verify(getRequestedFor(urlEqualTo(apiUrl)));
  }

  private String getContent(String url) {
    TestRestTemplate testRestTemplate = new TestRestTemplate();
    return testRestTemplate.getForObject(url, String.class);
  }
}
```

### Advanced Usages

#### Configuring API Request

Wiremock gives lots of useful static methods to stub the API request and response parts

Use `.get()`, `.put()`, `.post()`, `.delete()` and other methods to match corresponding HTTP methods

Use `.any()` to match any HTTP method matching the URL

```java
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

public class WireMockSetup {
  public void setupStubs() {
    stubFor(delete("/url").willReturn(ok()));
    stubFor(post("/url").willReturn(ok()));
    stubFor(any("/url").willReturn(ok()));
  }
}
```

Use other methods such as `.withHeader()`, `.withCookie()`, `.withQueryParam()`, `.withRequestBody()` etc. to set other parts of request

We can pass authorization information as well using the `.withBasicAuth()`

#### Configuring API Response

Generally, we are interested in only the response status, response headers and response body

WireMock supports stubbing all these components in the response with easy methods

```java
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class WireMockExample {

  public void setupStub() {
    stubFor(get(urlEqualTo("/api-url"))
      .willReturn(aResponse()
        .withStatus(200)
        .withStatusMessage("Everything was just fine!")
        .withHeader("Content-Type", "application/json")
        .withBody("{ \"message\": \"Hello world!\" }")));
  }
}
```

#### Testing API Delay and Timeouts

To test a delayed API response and how the current API handles timeouts, we can use the following methods:

The `.withFixedDelay()` can be used to configure a fixed delay where the response will NOT be returned until after the specified number of milliseconds

```java
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class WireMockDelaySetup {

  public void setupStubWithDelay() {
    stubFor(get(urlEqualTo("/api-url"))
      .willReturn(ok().withFixedDelay(2000)));
  }
}
```

The `.withRandomDelay()` can be used to get the delay from a random distribution

WireMock supports to types of random distributions: uniform distribution and lognormal distribution

```java
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class WireMockResponseDelay {

  public void setupStubWithResponseDelay() {
    stubFor(get(urlEqualTo("/api-url"))
      .willReturn(
        aResponse()
          .withStatus(200)
          .withFixedDelay(2000)
          // Uncomment the desired delay mechanism
          //.withLogNormalRandomDelay(90, 0.1)
          //.withRandomDelay(new UniformDistribution(15, 25))
      ));
  }
}
```

We can also use `.withChunkedDribbleDelay()` to simulate a slow network using where
the response is received in chunks with time delays in between

It takes two parameters: `numberOfChunks` and `totalDuration`

```java
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

public class WireMockChunkedResponse {

  public void setupStubWithChunkedResponse() {
    stubFor(get("/api-url").willReturn(
      aResponse()
        .withStatus(200)
        .withBody("api-response")
        .withChunkedDribbleDelay(5, 1000)));
  }
}
```

#### Testing Bad Responses

In a microservices architecture, an API can behave abnormally at any time so the
API consumers must be ready to handle those cases

Wiremock helps in this kind of response handling by stubbing faulty responses using `.withFault()` method

```java
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.http.Fault;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class WireMockFaultResponse {

  public void setupStubWithFaultResponse() {
    stubFor(get(urlEqualTo("/api-url"))
      .willReturn(aResponse()
        .withFault(Fault.MALFORMED_RESPONSE_CHUNK)));
  }
}
```

It supports following enum constants:

- `EMPTY_RESPONSE`: Return a completely empty response
- `RANDOM_DATA_THEN_CLOSE`: Send garbage then close the connection
- `MALFORMED_RESPONSE_CHUNK`: Send an OK status header, then garbage, then close the connection
- `CONNECTION_RESET_BY_PEER`: Close the connection causing a "Connection reset by peer" error

#### Verifying API Hits

If we wish to verify that mocked APIs were hit and how many times, we can do so `WireMock.verify()` method in the following manner

```java
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

public class WireMockVerification {

  public void verifyPostRequest(String api_url) {
    verify(WireMock.exactly(1), postRequestedFor(urlEqualTo(api_url))
      .withHeader("Content-Type", "application/JSON"));
  }
}
```

There are quite a few methods to verify the hit counts, such as `.lessThan()`, `.lessThanOrExactly()`, `.exactly()`, `.moreThanOrExactly()`, `.moreThan()`

```java
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.anyRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.anyUrl;
import static com.github.tomakehurst.wiremock.client.WireMock.exactly;
import static com.github.tomakehurst.wiremock.client.WireMock.lessThan;
import static com.github.tomakehurst.wiremock.client.WireMock.lessThanOrExactly;
import static com.github.tomakehurst.wiremock.client.WireMock.moreThan;
import static com.github.tomakehurst.wiremock.client.WireMock.moreThanOrExactly;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

public class WireMockRequestVerification {

  public void verifyRequests() {
    verify(lessThan(5), anyRequestedFor(anyUrl()));
    verify(lessThanOrExactly(5), anyRequestedFor(anyUrl()));
    verify(exactly(5), anyRequestedFor(anyUrl()));
    verify(moreThanOrExactly(5), anyRequestedFor(anyUrl()));
    verify(moreThan(5), anyRequestedFor(anyUrl()));
  }
}
```

## `@WebFluxTest` + `WebTestClient` + JUnit 5

- [Spring Boot @WebFluxTest and WebTestClient with JUnit 5](https://howtodoinjava.com/spring-boot2/testing/webfluxtest-with-webtestclient/)

### Maven

```xml
<dependency>
  <groupId>io.projectreactor</groupId>
  <artifactId>reactor-test</artifactId>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

### `@WebFluxTest`

It disables full auto-configuration and only applies configuration relevant to WebFlux tests
(i.e. `@Controller`, `@ControllerAdvice`, `@JsonComponent`, Converter and WebFluxConfigurer beans but NOT `@Component`, `@Service` or `@Repository` beans).

By default, tests annotated with `@WebFluxTest` will also auto-configure a WebTestClient

Typically `@WebFluxTest` is used in combination with `@MockBean` or `@Import` to create any collaborators required by the `@Controller` beans

Note: To write integration tests which require full application context – consider using `@SpringBootTest` combined with `@AutoConfigureWebTestClient`

### WebTestClient

It is a non-blocking, reactive client for testing web servers that uses the reactive WebClient internally to perform requests and provides a fluent API to verify responses

It can connect to any server over an HTTP, or bind directly to WebFlux applications using mock request and response objects, without needing an HTTP server

`WebTestClient` is similar to `MockMvc`. The only difference between those test web clients is that `WebTestClient` is aimed at testing `WebFlux` endpoints

### Testing Async Controller

#### System Under Test

In the example below, we are testing the EmployeeController class, which contains reactive methods for CRUD operations

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping(value = { "/create", "/" })
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody Employee e) {
    employeeService.create(e);
  }

  @GetMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id) {
    Mono<Employee> e = employeeService.findById(id);
    HttpStatus status = (e != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    return new ResponseEntity<>(e, status);
  }

  @GetMapping(value = "/name/{name}")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Employee> findByName(@PathVariable("name") String name) {
    return employeeService.findByName(name);
  }

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public Flux<Employee> findAll() {
    return employeeService.findAll();
  }

  @PutMapping(value = "/update")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Employee> update(@RequestBody Employee e) {
    return employeeService.update(e);
  }

  @DeleteMapping(value = "/delete/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") Integer id) {
    employeeService.delete(id).subscribe();
  }
}
```

#### JUnit Tests

The following class contains the JUnit tests that verify the async API handler methods, status and responses

- We are using `@ExtendWith( SpringExtension.class)` to support testing in Junit 5
  - In Junit 4, we need to use `@RunWith(SpringRunner.class)`
- We used `@Import(EmployeeService.class)` to provide service dependency to application context which is NOT automatically scanned while using `@WebFluxTest`.
- We have mocked the `EmployeeRepository` which is of type `ReactiveMongoRepository`.
  - This will prevent the actual DB insertions and updates
- `WebTestClient` is used to hit particular endpoints of the controller and verify whether it returns the correct status codes and body

```java
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import com.howtodoinjava.demo.controller.EmployeeController;
import com.howtodoinjava.demo.dao.EmployeeRepository;
import com.howtodoinjava.demo.model.Employee;
import com.howtodoinjava.demo.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = EmployeeController.class)
@Import(EmployeeService.class)
public class EmployeeControllerTest {
  @MockBean
  EmployeeRepository repository;

  @Autowired
  private WebTestClient webClient;

  @Test
  void testCreateEmployee() {
    Employee employee = new Employee();
    employee.setId(1);
    employee.setName("Test");
    employee.setSalary(1000);

    Mockito.when(repository.save(employee)).thenReturn(Mono.just(employee));

    webClient.post()
      .uri("/create")
      .contentType(MediaType.APPLICATION_JSON)
      .body(BodyInserters.fromObject(employee))
      .exchange()
      .expectStatus().isCreated();

    Mockito.verify(repository, times(1)).save(employee);
  }

  @Test
  void testGetEmployeesByName() {
    Employee employee = new Employee();
    employee.setId(1);
    employee.setName("Test");
    employee.setSalary(1000);

    List<Employee> list = new ArrayList<>();
    list.add(employee);

    Flux<Employee> employeeFlux = Flux.fromIterable(list);

    Mockito.when(repository.findByName("Test")).thenReturn(employeeFlux);

    webClient.get().uri("/name/{name}", "Test")
      .header(HttpHeaders.ACCEPT, "application/json")
      .exchange()
      .expectStatus().isOk()
      .expectBodyList(Employee.class);

    Mockito.verify(repository, times(1)).findByName("Test");
  }

  @Test
  void testGetEmployeeById() {
    Employee employee = new Employee();
    employee.setId(100);
    employee.setName("Test");
    employee.setSalary(1000);

    Mockito.when(repository.findById(100)).thenReturn(Mono.just(employee));

    webClient.get()
      .uri("/{id}", 100)
      .exchange()
      .expectStatus().isOk()
      .expectBody()
      .jsonPath("$.name").isNotEmpty()
      .jsonPath("$.id").isEqualTo(100)
      .jsonPath("$.name").isEqualTo("Test")
      .jsonPath("$.salary").isEqualTo(1000);

    Mockito.verify(repository, times(1)).findById(100);
  }

  @Test
  void testDeleteEmployee() {
    Mono<Void> voidReturn = Mono.empty();
    Mockito.when(repository.deleteById(1)).thenReturn(voidReturn);

    webClient.get()
      .uri("/delete/{id}", 1)
      .exchange()
      .expectStatus().isOk();
  }
}
```
