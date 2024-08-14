# Table of Contents

- [Table of Contents](#table-of-contents)
- [Apache Camel](#apache-camel)
  - [Introduction To Apache Camel - Baeldung](#introduction-to-apache-camel---baeldung)
    - [About Apache Camel](#about-apache-camel)
    - [Maven Dependencies](#maven-dependencies)
    - [Domain Specific Language (DSL)](#domain-specific-language-dsl)
    - [Camel Terminology](#camel-terminology)
    - [Camel Architecture](#camel-architecture)
    - [Defining a Route](#defining-a-route)
      - [Routing With Java DSL](#routing-with-java-dsl)
      - [Routing With Spring DSL](#routing-with-spring-dsl)
  - [Apache Camel with Spring Boot - Baeldung](#apache-camel-with-spring-boot---baeldung)
    - [Maven Dependencies](#maven-dependencies-1)
    - [The Main Class](#the-main-class)
    - [Camel Configurations for Spring Boot](#camel-configurations-for-spring-boot)
    - [Setting up the Camel Servlet](#setting-up-the-camel-servlet)
    - [Building a Route](#building-a-route)
      - [The `restConfiguration()` Route](#the-restconfiguration-route)
      - [The `rest()` Route](#the-rest-route)
      - [The `from()` Route With `.transform()`](#the-from-route-with-transform)
      - [The SIMPLE Scripting Language](#the-simple-scripting-language)
      - [The `from()` Route With `process()`](#the-from-route-with-process)
  - [How to Send a Post Request in Apache Camel - Baeldung](#how-to-send-a-post-request-in-apache-camel---baeldung)
    - [Apache Camel HTTP Component](#apache-camel-http-component)
    - [Project Setup](#project-setup)
    - [Sending Post Request](#sending-post-request)
      - [Sending Post Request With JSON String](#sending-post-request-with-json-string)
      - [Sending Post Request With POJO Class](#sending-post-request-with-pojo-class)
    - [Testing the Route](#testing-the-route)
  - [Integration Patterns With Apache Camel - Baeldung](#integration-patterns-with-apache-camel---baeldung)
    - [Content Based Router EIP](#content-based-router-eip)
    - [Message Translator EIP](#message-translator-eip)
    - [Multicast EIP](#multicast-eip)
    - [Splitter EIP](#splitter-eip)
    - [Dead Letter Channel](#dead-letter-channel)
  - [Apache Camel Conditional Routing - Baeldung](#apache-camel-conditional-routing---baeldung)
- [Enterprise Integration Patterns](#enterprise-integration-patterns)
  - [Resources](#resources)
  - [`Aggregator` EIP with Apache Camel - Amin Shahimian](#aggregator-eip-with-apache-camel---amin-shahimian)
    - [What is Aggregator EIP](#what-is-aggregator-eip)
    - [Example in Apache Camel](#example-in-apache-camel)
  - [`Splitter` EIP in Apache Camel - Amin Shahimian](#splitter-eip-in-apache-camel---amin-shahimian)
    - [What is Splitter EIP](#what-is-splitter-eip)
    - [How Splitter EIP Works](#how-splitter-eip-works)
    - [Example in Apache Camel](#example-in-apache-camel-1)
  - [`Routing Slip` EIP in Apache Camel - Amin Shahimian](#routing-slip-eip-in-apache-camel---amin-shahimian)
    - [Using a Bean to Compute the Routing Slip Header:](#using-a-bean-to-compute-the-routing-slip-header)
    - [Using an Expression as the Routing Slip](#using-an-expression-as-the-routing-slip)
    - [Using `@RoutingSlip` Annotation as the Routing Slip](#using-routingslip-annotation-as-the-routing-slip)
  - [`Dynamic Router` EIP - Amin Shahimian](#dynamic-router-eip---amin-shahimian)
    - [Dynamic Router vs Routing Slip](#dynamic-router-vs-routing-slip)
    - [Understanding the Dynamic Router EIP](#understanding-the-dynamic-router-eip)
    - [Usage of Dynamic Router EIP](#usage-of-dynamic-router-eip)
    - [Example in Apache Camel](#example-in-apache-camel-2)
    - [XML Configuration (Camel Context)](#xml-configuration-camel-context)

# Apache Camel

## Introduction To Apache Camel - Baeldung

- [Introduction To Apache Camel - Baeldung](https://www.baeldung.com/apache-camel-intro)
- [Apache Camel](http://camel.apache.org/)
- [Apache Camel Integration Patterns](http://camel.apache.org/enterprise-integration-patterns.html)
- [Apache Camel User Guide](http://camel.apache.org/user-guide.html)
- [Apache Camel SIMPLE Language](http://camel.apache.org/simple.html)
- [Apache Camel Spring Boot Examples](https://github.com/apache/camel-spring-boot-examples)
- https://www.udemy.com/course/apache-camel-framework-with-spring-boot/

### About Apache Camel

> Apache Camel is an open-source integration framework designed to make integrating systems simple and easy.
>
> It allows end users to integrate various systems using the same API, providing support for multiple protocols and data types while being extensible and allowing the introduction of custom protocols

### Maven Dependencies

- Project Dependencies
  - [camel-spring-boot-starter](https://mvnrepository.com/artifact/org.apache.camel.springboot/camel-spring-boot-starter)
  - [spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- Test Dependencies
  - [camel-test-spring-junit5](https://mvnrepository.com/artifact/org.apache.camel/camel-test-spring-junit5)
  - [awaitility](https://mvnrepository.com/artifact/org.awaitility/awaitility)

### Domain Specific Language (DSL)

Routes and the routing engine are a central part of Camel.

- Routes contain the flow and logic of integration between different systems.

In order to define routes more easily and cleanly, Camel offers several different domain-specific languages (DSL) for programming languages like Java or Groovy.

- On the other hand, it also provides defining routes in XML with Spring DSL.

Using either Java DSL or Spring DSL is mostly user preference, as most of the features are available in both.

- Java DSL offers a few more features that are not supported in Spring DSL.
- However, Spring DSL is sometimes more beneficial as configuration XML can be changed without the need to recompile the code.

### Camel Terminology

Core Camel Terminology/Concepts

- `Message` = Contains data that is being transferred to a route.
  - Each message has an unique identifier, and is constructed out of a body, headers, and attachments.
- `Exchange` = The container of a message, and is created when a message is received by a consumer during the routing process.
  - The Exchange allows different types of interaction between systems – it can define a one-way message or a request-response message.
- `Endpoint` = A channel through which the system can receive or send a message.
  - It can refer to a web service URI, queue URI, file, email address, etc.
- `Component` = Acts as an endpoint factory.
  - To put it simply, components offer an interface to different technologies using the same approach and syntax.
  - Camel already supports a lot of components in its DSLs for almost every possible technology, but it also gives the ability to write custom components.
- `Processor` = A simple Java interface that is used to add custom integration logic to a route.
  - It contains a single process method used to perform custom business logic on a message received by a consumer.
- `Route` = A set of processing steps that are applied to a message as it travels from a source to a destination.
  - A route typically consists of a series of processing steps that are connected in a linear sequence.
  - A Camel route is where the integration flow is defined.
    - For example, you can write a Camel route to specify how two systems can be integrated.
      - You can also specify how the data can be manipulated, routed, or mediated between the systems.
  - The routes are typically defined using a simple, declarative syntax that is easy to read and understand.
    - For instance, you could write a route to consume files from an FTP server and send them to an ActiveMQ messaging system. A route to do so, using Java DSL, would look like this:
      ```java
      from("ftp:myserver/folder")
        .to("activemq:queue:cheese");
      ```
    - Camel routes can be defined using a variety of domain-specific languages (DSLs), such as Java, Spring XML, or YAML. For example, you could write the route described above using XML:
      ```xml
      <route>
        <from uri="ftp:myserver/folder"/>
        <to uri="activemq:queue:cheese"/>
      </route>
      ```

### Camel Architecture

```
CamelContext
|
v
Processors
|
v
Endpoints
```

`CamelContext` = Represents the Camel runtime system, and it wires different concepts such as routes, components, or endpoints.

`Processors` = Processors handle routing and transformations between endpoints

`Endpoints` = Integrate different systems together

### Defining a Route

> Routes can be defined with Java DSL or Spring DSL.

We'll illustrate both styles by defining a route that consumes files from one folder
and moves them into another folder while prepending a date to each file name.

#### Routing With Java DSL

To define a route with Java DSL, we will first need to create a `DefaultCamelContext` instance.

After that, we need to extend the `RouteBuilder` class and implement the `configure()` method, which will contain route flow:

The `configure` method can be read like this:

- Read files from the source folder,
- Process them with `FileProcessor`,
- Send the result to a destination folder.

Setting `delete=true` means the file will be deleted from the source folder after it is processed successfully.

In order to start Camel, we need to call the `start` method on `CamelContext`.

- After that, we use the `.await()` method (one of the static methods of the `Awaitility` class) in order to allow Camel the time necessary to move the files from one folder to another.
- The `.atMost()` method sets an upper limit on how long `Awaitility` should wait for the conditions to be met.
  - In this case, it will wait up to `DURATION_MILLIS` milliseconds.

In addition, we can use the `.untilAsserted()` method which allows us to provide a lambda or method reference that contains one or more assertions.

- `Awaitility` will repeatedly run these assertions until they all pass or the specified `.atMost()` duration is reached.
- Here, there are two assertions being made using the `assertThat()` method.
  - In these assertions, we check the file's existence in the destination folder.

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;

public class FileMoveTest {

  private static final long DURATION_MILLIS = 10000;
  private static final String SOURCE_FOLDER = "src/test/source-folder";
  private static final String DESTINATION_FOLDER = "src/test/destination-folder";

  @Test
  public void givenJavaDSLRoute_whenCamelStart_thenMoveFolderContent() throws Exception {
    CamelContext camelContext = new DefaultCamelContext();
    camelContext.addRoutes(new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        from("file://" + SOURCE_FOLDER + "?delete=true")
          .process(new FileProcessor())
          .to("file://" + DESTINATION_FOLDER);
      }
    });
    camelContext.start();
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    File destinationFile1 = new File(DESTINATION_FOLDER + "/" + dateFormat.format(date) + "File1.txt");
    File destinationFile2 = new File(DESTINATION_FOLDER + "/" + dateFormat.format(date) + "File2.txt");

    Awaitility.await().atMost(DURATION_MILLIS, TimeUnit.MILLISECONDS).untilAsserted(() -> {
      assertThat(destinationFile1.exists()).isTrue();
      assertThat(destinationFile2.exists()).isTrue();
    });
    camelContext.stop();
  }
}
```

`FileProcessor` implements the `Processor` interface and contains a single process method that contains logic for modifying file names:

In order to retrieve the file name, we have to retrieve an incoming message from
an exchange and access its header.

To modify the file name, we have to update the message header.

```java
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FileProcessor implements Processor {
  @Override
  public void process(Exchange exchange) throws Exception {
    String originalFileName = (String) exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String changedFileName = dateFormat.format(date) + originalFileName;
    exchange.getIn().setHeader(Exchange.FILE_NAME, changedFileName);
  }
}
```

#### Routing With Spring DSL

When defining a route with Spring DSL, we use an XML file to set up our routes and processors.

This allows us to configure routes using no code by using Spring and, gives us the benefit of total inversion of control.

We will focus on using both Spring DSL along with Java DSL, which is commonly a preferred way of defining routes.

In this arrangement, `CamelContext` is defined in Spring XML file using custom XML syntax for Camel,
but without the route definition like in the case of "pure" Spring DSL using XML:

```xml
<camelContext xmlns="http://camel.apache.org/schema/spring">
  <routeBuilder ref="fileRouter" />
</camelContext>
```

This way, we tell Camel to use the `FileRouter` class, which holds the definition of our route in Java DSL:

```java
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {

  private static final String SOURCE_FOLDER = "src/test/source-folder";
  private static final String DESTINATION_FOLDER = "src/test/destination-folder";

  @Override
  public void configure() throws Exception {
    from("file://" + SOURCE_FOLDER + "?delete=true")
      .process(new FileProcessor())
      .to("file://" + DESTINATION_FOLDER);
  }
}
```

In order to test this, we have to create an instance of `ClassPathXmlApplicationContext`,
which will load up our `CamelContext` in Spring:

```java
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import org.awaitility.Awaitility;

@CamelSpringBootTest
public class TestClass {

  private static final String DESTINATION_FOLDER = "your/destination/folder";
  private static final long DURATION_MILLIS = 5000;

  @Test
  public void givenSpringDSLRoute_whenCamelStart_thenMoveFolderContent() throws Exception {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("camel-context-test.xml");

    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    File destinationFile1 = new File(DESTINATION_FOLDER + "/" + dateFormat.format(date) + "File1.txt");
    File destinationFile2 = new File(DESTINATION_FOLDER + "/" + dateFormat.format(date) + "File2.txt");

    Awaitility.await().atMost(DURATION_MILLIS, TimeUnit.MILLISECONDS).untilAsserted(() -> {
      assertThat(destinationFile1.exists()).isTrue();
      assertThat(destinationFile2.exists()).isTrue();
    });
    applicationContext.close();
  }
}
```

## Apache Camel with Spring Boot - Baeldung

- [Apache Camel with Spring Boot - Baeldung](https://www.baeldung.com/apache-camel-spring-boot)

> At its core, Apache Camel is an integration engine that is used to facilitate interactions between technologies/microservices
>
> These bridges between services and technologies are called routes.
>
> Routes are implemented on an engine (the `CamelContext`), and they communicate with so-called `exchange messages`

### Maven Dependencies

https://mvnrepository.com/artifact/org.apache.camel.springboot

```xml
<dependencies>
  <dependency>
    <groupId>org.apache.camel.springboot</groupId>
    <artifactId>camel-servlet-starter</artifactId>
    <version>4.3.0</version>
  </dependency>
  <dependency>
    <groupId>org.apache.camel.springboot</groupId>
    <artifactId>camel-jackson-starter</artifactId>
    <version>4.3.0</version>
  </dependency>
  <dependency>
    <groupId>org.apache.camel.springboot</groupId>
    <artifactId>camel-swagger-java-starter</artifactId>
    <version>3.22.0</version>
  </dependency>
  <dependency>
    <groupId>org.apache.camel.springboot</groupId>
    <artifactId>camel-spring-boot-starter</artifactId>
    <version>4.3.0</version>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
</dependencies>
```

### The Main Class

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.baeldung.camel")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
```

### Camel Configurations for Spring Boot

Let's now configure our application with Spring, starting with the configuration files (properties).

The example below shows an `src/main/resources/application.properties` file that also sets the path to a Logback configuration.

- By setting the IP to "0.0.0.0", we fully restrict admin and management access on the web server provided by Spring Boot.
- Also, we enable the needed network access to our application endpoints as well as the health-check endpoints.

```conf
logging.config=classpath:logback.xml
camel.springboot.name=MyCamel
server.address=0.0.0.0
server.port=8080
management.address=0.0.0.0
management.port=9090
endpoints.enabled = true
endpoints.health.enabled = true
```

The example below shows an `src/main/resources/application.yml`

```yml
logging:
  config: classpath:logback.xml

camel:
  springboot:
    name: MyCamel

server:
  address: 0.0.0.0
  port: 8080

management:
  address: 0.0.0.0
  port: 9090

endpoints:
  enabled: true
  health:
    enabled: true

quickstart:
  generateOrderPeriod: 10s
  processOrderPeriod: 30s
```

### Setting up the Camel Servlet

One way to start using Camel is to register it as a servlet, so it can intercept
the HTTP requests and redirect them to our application.

Starting with Camel's version 2.18 and below we can take advantage of our `application.yml`
by creating a parameter for our final URL. Later it will be injected into our Java code:

```yml
baeldung:
  api:
    path: '/camel'
```

Back to our Application class, we need to register the Camel servlet at the root
of our context path, which is going to be injected from the reference `baeldung.api.path`
in the `application.yml` when the application starts:

Note: As of Camel's version 2.19, this configuration has been dropped as the `CamelServlet` is by default set to `/camel`

```java
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.baeldung.camel")
public class Application {

  @Value("${baeldung.api.path}") // "/camel"
  String contextPath;

  @Bean
  ServletRegistrationBean<CamelHttpTransportServlet> servletRegistrationBean() {
    ServletRegistrationBean<CamelHttpTransportServlet> servlet = new ServletRegistrationBean<>(
      new CamelHttpTransportServlet(), contextPath + "/*");
    servlet.setName("CamelServlet");
    return servlet;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
```

### Building a Route

Let's start making a route by extending the `RouteBuilder` class from Camel,
and setting it as a `@Component` so the component scan routine can locate it during
web server initialization:

In this example below:

- We override the `configure()` method from Camel's `RouteBuilder` class.
- Camel always needs a `CamelContext` instance – the core component where the incoming and outgoing messages are kept.
  - Here `DefaultCamelContext` suffices as it just binds messages and routes into it, like the REST service that we are going to create.

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
class RestApi extends RouteBuilder {
  @Override
  public void configure() {
    CamelContext context = new DefaultCamelContext();
    // Configure the REST DSL
    restConfiguration()...
    // Define a REST endpoint
    rest("/api/")...
    // Define a route from a direct endpoint to a mock service
    from("direct:remoteService")...
  }
}
```

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
class RestApi extends RouteBuilder {
  @Override
  public void configure() {
    CamelContext context = new DefaultCamelContext();
    // Configure the REST DSL
    restConfiguration() // <-- HERE
      .component("servlet")
      .contextPath("/camel")
      .port(8080);
    // Define a REST endpoint
    rest("/api/") // <-- HERE
      .get("hello")
      .route()
      .transform().constant("Hello, World!");
    // Define a route from a direct endpoint to a mock service
    from("direct:remoteService") // <-- HERE
      .log("Received request: ${body}")
      .transform().simple("Response from remote service: ${body}");
  }
}
```

#### The `restConfiguration()` Route

Next, we create a REST declaration for the endpoints we plan to create in the `restConfiguration()` method:

- Here, we register the context path with our injected attribute from the YAML file.
  - The same logic was applied to the port of our application.
  - CORS is enabled, allowing for cross-site use of this web service.
  - The binding mode allows and converts arguments to our API.

Next, we add Swagger documentation to the URI, title, and version we previously set.
As we create methods/endpoints for our REST web service, the Swagger documentation will be automatically updated.

This Swagger context is itself a Camel route, and we can see some technical information
about it in the server log during the startup process. Our example documentation
is by default served at `http://localhost:8080/camel/api-doc`

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
class RestApi extends RouteBuilder {
  @Override
  public void configure() {
    CamelContext context = new DefaultCamelContext();
    // Configure the REST DSL
    restConfiguration()
      .contextPath(contextPath)
      .port(serverPort)
      .enableCORS(true)
      .apiContextPath("/api-doc")
      .apiProperty("api.title", "Test REST API")
      .apiProperty("api.version", "v1")
      .apiContextRouteId("doc-api")
      .component("servlet")
      .bindingMode(RestBindingMode.json);
    // Define a REST endpoint
    rest("/api/")...
    // Define a route from a direct endpoint to a mock service
    from("direct:remoteService")...
  }
}
```

#### The `rest()` Route

- `.id()` is the identification of the route inside the `CamelContext`.
- `.consume()` defines the MIME type
- `.bindingMode()` defines here to show that we can set a mode on the `restConfiguration()`
- `.post()` method adds an operation to the API, generating a `POST /bean` endpoint,
- `.type()` defines the expected parameters i.e. `MyBean` (a regular Java bean with an Integer id and String name)
- `.to()` method creates a bridge to another route.
  - Here it tells Camel to search inside its context/engine to another route that we're going to create which is named and detected by the value/id `direct: ...`, matching the route defined in the `from()` method

Other HTTP actions

- `.get()`
- `.post()`
- `.put()`
- `.delete()`

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
class RestApi extends RouteBuilder {
  @Override
  public void configure() {
    CamelContext context = new DefaultCamelContext();
    // Configure the REST DSL
    restConfiguration()
      .contextPath(contextPath)
      .port(serverPort)
      .enableCORS(true)
      .apiContextPath("/api-doc")
      .apiProperty("api.title", "Test REST API")
      .apiProperty("api.version", "v1")
      .apiContextRouteId("doc-api")
      .component("servlet")
      .bindingMode(RestBindingMode.json);
    // Define a REST endpoint
    rest("/api/")
      .id("api-route")
      .consumes("application/json")
      .post("/bean")
      .bindingMode(RestBindingMode.json_xml)
      .type(MyBean.class)
      .to("direct:remoteService");
    // Define a route from a direct endpoint to a mock service
    from("direct:remoteService")...
  }
}
```

#### The `from()` Route With `.transform()`

When working with Camel, a route receives parameters and then converts, transforms and process these parameters.

After that, it sends these parameters to another route that forwards the result
to the desired output (a file, a database, an SMTP server or a REST API response).

In this article, we only create another route inside the `configure()` method that we are overriding.

It will be the destination route for our last `to()` route:

The `from()` method follows the same principles and has many of the same methods
as the `rest()` method, except that it consumes messages from the CamelContext.

This is the reason for the parameter `direct-route`, that creates a link to the aforementioned method `rest().to()`

Many other conversions are available, including extraction as Java primitives (or objects)
and sending it down to a persistence layer. Notice that the routes always read from
incoming messages, so that chained routes will IGNORE outgoing messages.

Testing the example using Postman

- Run the command: `mvn spring-boot:run`
- Do a `POST` request to `http://localhost:8080/camel/api/bean` with header parameters: `Content-Type: application/json`, and a payload `{"id": 1,"name": "World"}`
- We should receive a response code of `200` and the log output of `Hello, World!`

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
class RestApi extends RouteBuilder {
  @Override
  public void configure() {
    CamelContext context = new DefaultCamelContext();
    // Configure the REST DSL
    restConfiguration()
      .contextPath(contextPath)
      .port(serverPort)
      .enableCORS(true)
      .apiContextPath("/api-doc")
      .apiProperty("api.title", "Test REST API")
      .apiProperty("api.version", "v1")
      .apiContextRouteId("doc-api")
      .component("servlet")
      .bindingMode(RestBindingMode.json);
    // Define a REST endpoint
    rest("/api/")
      .id("api-route")
      .consumes("application/json")
      .post("/bean")
      .bindingMode(RestBindingMode.json_xml)
      .type(MyBean.class)
      .to("direct:remoteService");
    // Define a route from a direct endpoint to a mock service
    from("direct:remoteService")
      .routeId("direct-route")
      .tracing()
      .log(">>> ${body.id}")
      .log(">>> ${body.name}")
      .transform().simple("Hello ${in.body.name}!")
      .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
  }
}
```

#### The SIMPLE Scripting Language

The example above outputs logging using the `.tracing()` method.

Note: We have used the `${}` placeholders; these are part of a scripting language that belongs to Camel called SIMPLE.

- It is applied to messages that are exchanged over the route, like the body of the in-message.

In our example, we are using SIMPLE to output to the log the bean attributes that are inside the Camel message body.

We can also use it to do simple transformations as well, as was shown with the `transform()` method.

#### The `from()` Route With `process()`

Let's do something more meaningful, such as calling a service layer to return processed data.

SIMPLE is NOT meant for heavy data processing, so let's replace the `transform()` with a `process()` method:

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
class RestApi extends RouteBuilder {
  @Override
  public void configure() {
    CamelContext context = new DefaultCamelContext();
    // Configure the REST DSL
    restConfiguration()
      .contextPath(contextPath)
      .port(serverPort)
      .enableCORS(true)
      .apiContextPath("/api-doc")
      .apiProperty("api.title", "Test REST API")
      .apiProperty("api.version", "v1")
      .apiContextRouteId("doc-api")
      .component("servlet")
      .bindingMode(RestBindingMode.json);
    // Define a REST endpoint
    rest("/api/")
      .id("api-route")
      .consumes("application/json")
      .post("/bean")
      .bindingMode(RestBindingMode.json_xml)
      .type(MyBean.class)
      .to("direct:remoteService");
    // Define a route from a direct endpoint to a mock service
    from("direct:remoteService")
      .routeId("direct-route")
      .tracing()
      .log(">>> ${body.id}")
      .log(">>> ${body.name}")
      .process(new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {
          MyBean bodyIn = (MyBean) exchange.getIn().getBody();
          ExampleServices.example(bodyIn);
          exchange.getIn().setBody(bodyIn);
        }
      })
      .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
  }
}
```

This allows us to extract the data into a bean, the same one previously defined on the `type()` method, and process it in our `ExampleServices` layer.

Since we set the `bindingMode()` to JSON previously, the response already is in a proper JSON format, generated based on our POJO. This implies that for an ExampleServices class:

```java
import com.example.MyBean;

public class ExampleServices {
  public static void example(MyBean bodyIn) {
    bodyIn.setName("Hello, " + bodyIn.getName() + '!');
    bodyIn.setId(bodyIn.getId() * 10);
  }
}
```

Testing the example with Postman

- Run the command: `mvn spring-boot:run`
- Do a `POST` request to `http://localhost:8080/camel/api/bean` with header parameters: `Content-Type: application/json`, and a payload `{"id": 1,"name": "World"}`
- We should receive a response code of 200 and body of `{"id": 10,"name": "Hello, World!"}`

## How to Send a Post Request in Apache Camel - Baeldung

- [How to Send a Post Request in Apache Camel - Baeldung](https://www.baeldung.com/java-apache-camel-send-post-request)

Apache Camel is a robust open-source integration framework.

- It provides a mature set of components to interact with various protocols and systems, including HTTP.

In this tutorial, we'll explore the Apache Camel HTTP component and demonstrate
how to initiate a POST request to [JSONPlaceholder](https://jsonplaceholder.typicode.com/),
a free fake API for testing and prototyping.

### Apache Camel HTTP Component

The Apache Camel HTTP component provides functionality to communicate with an external web server.
It supports various HTTP methods including GET, POST, PUT, DELETE, etc.

By default, the HTTP component uses port `80` for HTTP and port `443` for HTTPS.
Here's the general syntax for the HTTP component URI:

```
http://hostname[:port][/resourceUri][?options]
```

The component must start with the 'http' or 'https' scheme, followed by the hostname,
optional port, resource path, and query parameters.

We can set the HTTP method using the httpMethod option in the [URI](https://www.baeldung.com/java-url-vs-uri)

```
https://jsonplaceholder.typicode.com/posts?httpMethod=POST
```

We can set the HTTP method in the message header:

```java
setHeader(Exchange.HTTP_METHOD, constant("POST"))
```

Complete code example in Spring Boot and Apache Camel

```java
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.camel")
public class Application {

  @Value("${camel.api.path}")
  String contextPath;

  @Bean
  ServletRegistrationBean<CamelHttpTransportServlet> servletRegistrationBean() {
    ServletRegistrationBean<CamelHttpTransportServlet> servlet = new ServletRegistrationBean<>(new CamelHttpTransportServlet(), contextPath + "/*");
    servlet.setName("CamelServlet");
    return servlet;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public RouteBuilder routeBuilder() {
    return new RouteBuilder() {
      @Override
      public void configure() {
        from("direct:start")
          .setHeader(Exchange.HTTP_METHOD, constant("POST"))
          .to("http://example.com/api");
      }
    };
  }
}
```

### Project Setup

- The `camel-core` dependency provides the core classes for system integration.
  - One of the important classes is the `RouteBuilder` to create routes.
- The `camel-test-junit5` provides support for testing Camel routes with JUnit 5
- https://mvnrepository.com/artifact/org.apache.camel/camel-core
- https://mvnrepository.com/artifact/org.apache.camel/camel-test-junit5
- https://mvnrepository.com/artifact/org.apache.camel/camel-jackson
- https://mvnrepository.com/artifact/org.apache.camel/camel-http

```xml
<dependency>
  <groupId>org.apache.camel</groupId>
  <artifactId>camel-core</artifactId>
  <version>4.6.0</version>
</dependency>
<dependency>
  <groupId>org.apache.camel</groupId>
  <artifactId>camel-test-junit5</artifactId>
  <version>4.6.0</version>
</dependency>
<dependency>
  <groupId>org.apache.camel</groupId>
  <artifactId>camel-jackson</artifactId>
  <version>4.6.0</version>
</dependency>
<dependency>
  <groupId>org.apache.camel</groupId>
  <artifactId>camel-http</artifactId>
  <version>4.6.0</version>
</dependency>
```

The `camel-http` dependency provides support for HTTP components to communicate with external servers.
Also, we added `camel-jackson` dependency for JSON serialization and deserialization using Jackson.

Then, let's create a sample JSON payload for the POST request to `https://jsonplaceholder.typicode.com/post`

```json
{
  "userId": 1,
  "title": "Java 21",
  "body": "Virtual Thread"
}
```

Here, the payload contains the userId, title, and body.

We expect the endpoint to return HTTP status code 201 on the successful creation of a new post.

### Sending Post Request

To begin, let's create a class named `PostRequestRoute` which extends the `RouteBuilder` class:

```java
public class PostRequestRoute extends RouteBuilder {}
```

The `RouteBuilder` class allows us to override the `configure()` method to create a route

#### Sending Post Request With JSON String

Let's define a route that sends a POST request to our dummy server:

- In the example below, we define a route and set the payload as JSON String.
- The `setBody()` body method accepts the JSON string as an argument.
- Also, we set the HTTP method to POST by using the `httpMethod` option.
- Then, we send the request to the `JSONPlacehoder API`.
- Finally, we forward the response to a mock endpoint.

**V1**

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.Exchange;

public class Application {
  public static void main(String[] args) throws Exception {
    // Create Camel context
    CamelContext camelContext = new DefaultCamelContext();
    // Add the route
    camelContext.addRoutes(new RouteBuilder() {
      @Override
      public void configure() {
        from("direct:post")
          .process(exchange -> exchange.getIn()
          .setBody("{\"title\":\"Java 21\",\"body\":\"Virtual Thread\",\"userId\":\"1\"}"))
          .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
          .to("https://jsonplaceholder.typicode.com/posts?httpMethod=POST")
          .to("mock:post");
      }
    });
    // Start the context
    camelContext.start();
    // Send a message to the direct:post endpoint
    camelContext.createProducerTemplate().sendBody("direct:post", null);
    // Keep the application running for a short period to allow the route to process
    Thread.sleep(5000);
    // Stop the context
    camelContext.stop();
  }
}
```

**V2**

```java
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class PostRequestRoute extends RouteBuilder {

  @Override
  public void configure() {
    from("direct:post")
      .process(exchange -> exchange.getIn()
      .setBody("{\"title\":\"Java 21\",\"body\":\"Virtual Thread\",\"userId\":\"1\"}"))
      .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
      .to("https://jsonplaceholder.typicode.com/posts?httpMethod=POST")
      .to("mock:post");
  }
}
```

```java
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
// import your.package.name.PostRequestRoute; // Add the correct package name for PostRequestRoute

public class Application {
  public static void main(String[] args) throws Exception {
    // Create Camel context
    CamelContext camelContext = new DefaultCamelContext();
    // Add the route
    camelContext.addRoutes(new PostRequestRoute());
    // Start the context
    camelContext.start();
    // Keep the application running for a while to process the route
    Thread.sleep(5000);
    // Stop the context
    camelContext.stop();
  }
}
```

#### Sending Post Request With POJO Class

However, defining a JSON string could be error-prone.

For a more type-safe approach, let's define a POJO class named PostDto:

```java
public class PostDto {
  private int userId;
  private String title;
  private String body;

  // Constructor
  public PostDto(int userId, String title, String body) {
    this.userId = userId;
    this.title = title;
    this.body = body;
  }
  // Getters
  public int getUserId() {
    return userId;
  }
  public String getTitle() {
    return title;
  }
  public String getBody() {
    return body;
  }
  // Setters
  public void setUserId(int userId) {
    this.userId = userId;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public void setBody(String body) {
    this.body = body;
  }
}
```

In the example below,

- We start from a direct endpoint named `start`.
- We create a `PostDto` instance and set it as the request body.
- We marshal (transform) the POJO to JSON using [Jackson](https://www.baeldung.com/jackson-json-view-annotation)

Next, we send the request to the fake API and log the response code and body.
Finally, we forward the response to a mock endpoint for testing purposes.

```java
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.camel.PostDto; // Import the PostDto class

public class PostRequestRoute extends RouteBuilder {

  private static final Logger log = LoggerFactory.getLogger(PostRequestRoute.class);

  @Override
  public void configure() {
    from("direct:start")
      .process(exchange -> exchange.getIn()
      .setBody(new PostDto(1, "Java 21", "Virtual Thread"))).marshal().json(JsonLibrary.Jackson)
      .setHeader(Exchange.HTTP_METHOD, constant("POST"))
      .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
      .to("https://jsonplaceholder.typicode.com/posts")
      .process(exchange -> log.info("The HTTP response code is: {}", exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE)))
      .process(exchange -> log.info("The response body is: {}", exchange.getIn().getBody(String.class)))
      .to("mock:result");
  }
}
```

```java
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
// import your.package.name.PostRequestRoute; // Add the correct package name for PostRequestRoute

public class Application {
  public static void main(String[] args) throws Exception {
    // Create Camel context
    CamelContext camelContext = new DefaultCamelContext();
    // Add the route
    camelContext.addRoutes(new PostRequestRoute());
    // Start the context
    camelContext.start();
    // Keep the application running for a while to process the route
    Thread.sleep(5000);
    // Stop the context
    camelContext.stop();
  }
}
```

### Testing the Route

```java
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;

// Assuming PostRequestRoute and Post classes are in the same package or imported correctly
import your.package.name.PostRequestRoute;
import your.package.name.Post;

class PostRequestRouteUnitTest extends CamelTestSupport {
  // Create mock endpoint
  @EndpointInject("mock:result")
  protected MockEndpoint resultEndpoint;
  // Create producer template
  @Produce("direct:start")
  protected ProducerTemplate template;

  @Override
  protected RouteBuilder createRouteBuilder() {
    return new PostRequestRoute();
  }

  @Test
  void whenMakingAPostRequestToDummyServer_thenAscertainTheMockEndpointReceiveOneMessage() throws Exception {
    resultEndpoint.expectedMessageCount(1);
    resultEndpoint.message(0).header(Exchange.HTTP_RESPONSE_CODE)
      .isEqualTo(201);
    resultEndpoint.message(0).body()
      .isNotNull();
    // Send request
    template.sendBody(new Post(1, "Java 21", "Virtual Thread"));

    resultEndpoint.assertIsSatisfied();
  }
}
```

## Integration Patterns With Apache Camel - Baeldung

- [Integration Patterns With Apache Camel - Baeldung](https://www.baeldung.com/camel-integration-patterns)

### Content Based Router EIP

`Content Based Router` is a message router which routes a message to its destination based on a message header, part of payload or basically anything from message exchange which we consider as content.

It starts with `choice()` DSL statement followed by one or more `when()` DSL statements.

- Each `when()` contains a predicate expression which, if satisfied, will result in the execution of contained processing steps.

Let's illustrate this EIP by defining a route which consumes files from one folder
and moves them into two different folders depending on file extension.

```xml
<bean id="contentBasedFileRouter"
  class="com.baeldung.camel.file.ContentBasedFileRouter" />

<camelContext xmlns="http://camel.apache.org/schema/spring">
  <routeBuilder ref="contentBasedFileRouter" />
</camelContext>
```

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Application {
  public static void main(String[] args) throws Exception {
    // Create Camel context
    CamelContext camelContext = new DefaultCamelContext();
    // Add the route
    camelContext.addRoutes(new ContentBasedFileRouter());
    // Start the context
    camelContext.start();
    // Keep the application running
    Thread.sleep(5000);
    // Stop the context
    camelContext.stop();
  }
}
```

```java
class ContentBasedFileRouter extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("file:input")
      .choice()
      .when(header("CamelFileName").endsWith(".xml"))
      .to("file:output/xml")
      .when(header("CamelFileName").endsWith(".txt"))
      .to("file:output/txt")
      .otherwise()
      .to("file:output/others");
  }
}
```

**V2**

```java
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ContentBasedFileRouterConfig {

  @Bean
  ContentBasedFileRouter getContentBasedFileRouter() {
    return new ContentBasedFileRouter();
  }

  public List<RouteBuilder> routes() {
    return Arrays.asList(getContentBasedFileRouter());
  }
}
```

```java
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import your.package.name.ContentBasedFileRouterConfig;

import java.util.List;

@SpringBootApplication
public class Application {

  @Autowired
  private ContentBasedFileRouterConfig routerConfig;

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(Application.class, args);
    // Get the ContentBasedFileRouterConfig bean
    ContentBasedFileRouterConfig routerConfig = context.getBean(ContentBasedFileRouterConfig.class);
    // Create a new DefaultCamelContext
    CamelContext camelContext = new DefaultCamelContext();
    // Access the routes
    List<RouteBuilder> routes = routerConfig.routes();
    // Add routes to Camel context
    routes.forEach(route -> {
      try {
        camelContext.addRoutes(route);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    // Start the Camel context
    try {
      camelContext.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
```

The extension is evaluated using [Simple Expression Language](http://camel.apache.org/simple.html)
via simple() DSL statement which was intended to be used for evaluating Expressions and Predicates:

Note: We are additionally using `otherwise()` DSL statement in order to route all messages
which do NOT satisfy predicates given with `when()` statements.

```java
import org.apache.camel.builder.RouteBuilder;

public class ContentBasedFileRouter extends RouteBuilder {

  private static final String SOURCE_FOLDER = "src/test/source-folder";
  private static final String DESTINATION_FOLDER_TXT = "src/test/destination-folder-txt";
  private static final String DESTINATION_FOLDER_OTHER = "src/test/destination-folder-other";

  @Override
  public void configure() throws Exception {
    from("file://" + SOURCE_FOLDER + "?delete=true").choice()
      .when(simple("${file:ext} == 'txt'"))
      .to("file://" + DESTINATION_FOLDER_TXT).otherwise()
      .to("file://" + DESTINATION_FOLDER_OTHER);
  }
}
```

### Message Translator EIP

Since every system uses it's own data format, it is frequently required to translate
the message coming from another system into the data format supported by the destination system.

Camel supports `MessageTranslator` router which allows us to transform messages
using either custom processor in the routing logic, using a specific bean to perform
the transformation or by using `transform()` DSL statement.

Example with using a custom processor where we defined a processor which prepends a timestamp to each incoming file's filename.

```java
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FileProcessor implements Processor {
  @Override
  public void process(Exchange exchange) throws Exception {
    String originalFileName = (String) exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String changedFileName = dateFormat.format(date) + originalFileName;
    exchange.getIn().setHeader(Exchange.FILE_NAME, changedFileName);
  }
}
```

Example of how to use Message Translator using `transform()` statement

In the example below, we are appending the filename to file content via `transform()` statement
for each file from the source folder and moving transformed files to a destination folder.

```java
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MessageTranslatorFileRouter extends RouteBuilder {
  private static final String SOURCE_FOLDER = "src/test/source-folder";
  private static final String DESTINATION_FOLDER = "src/test/destination-folder";

  @Override
  public void configure() throws Exception {
    from("file://" + SOURCE_FOLDER + "?delete=true")
      .transform(body().append(header(Exchange.FILE_NAME)))
      .to("file://" + DESTINATION_FOLDER);
  }
}
```

### Multicast EIP

Multicast allows us to route the same message to a set of different endpoints
and process them in a different way.

This is possible by using `multicast()` DSL statement and then by listing the endpoints
and processing steps within them.

By default, processing on different endpoints is NOT done in parallel,
but this can be changed by using `parallelProcessing()` DSL statement.

Camel will use the LAST reply as the outgoing message after the multicasts by default.
However, it is possible to define a different aggregation strategy to be used for
assembling the replies from the multicasts.

In the example below, We'll multicast files from source folder onto two different
routes where we'll transform their content and send them to different destination folders.
Here we use `direct:component` which allows us to link two routes together:

```java
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Exchange;

public class MulticastFileRouter extends RouteBuilder {
  private static final String SOURCE_FOLDER = "src/test/source-folder";
  private static final String DESTINATION_FOLDER_WORLD = "src/test/destination-folder-world";
  private static final String DESTINATION_FOLDER_HELLO = "src/test/destination-folder-hello";

  @Override
  public void configure() throws Exception {
    from("file://" + SOURCE_FOLDER + "?delete=true")
      .multicast()
      .to("direct:append", "direct:prepend").end();

    from("direct:append")
      .transform(body().append("World"))
      .to("file://" + DESTINATION_FOLDER_WORLD);

    from("direct:prepend")
      .transform(body().prepend("Hello"))
      .to("file://" + DESTINATION_FOLDER_HELLO);
  }
}
```

### Splitter EIP

The Splitter EIP allows us to split the incoming message into a number of pieces
and processing each of them individually. This is possible by using `split()` DSL statement.

As opposed to Multicast, Splitter will change the incoming message, while Multicast will leave it as it is.

In the example below we'll define a route where each line from a file is split and
transformed into an individual file which is then moved to a different destination folder.
Each new file will be created with file name equal to file content:

```java
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Exchange;

public class SplitterFileRouter extends RouteBuilder {
  private static final String SOURCE_FOLDER = "src/test/source-folder";
  private static final String DESTINATION_FOLDER = "src/test/destination-folder";

  @Override
  public void configure() throws Exception {
    from("file://" + SOURCE_FOLDER + "?delete=true")
      .split(body().convertToString().tokenize("\n"))
      .setHeader(Exchange.FILE_NAME, body())
      .to("file://" + DESTINATION_FOLDER);
  }
}
```

### Dead Letter Channel

It is common and it should be expected that sometimes problems can happen, for example, database deadlocks,
which can cause a message not to be delivered as expected. However, in certain cases,
trying again with a certain delay will help and a message will get processed.

Dead Letter Channel allows us to control what happens with a message once it fails to be delivered.

- Using Dead Letter Channel we can specify whether to propagate the thrown Exception to the caller and where to route the failed Exchange.

When a message fails to be delivered, Dead Letter Channel (if used) will move the message to the dead letter endpoint.

In the example below we throw an exception on the route:

- We defined an `errorHandler` which logs failed deliveries and defines redelivery strategy.
- By setting `retryAttemptedLogLevel()`, each redelivery attempt will be logged with specified log level.
- In order for this to be fully functional, we additionally need to configure a logger.

```java
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.LoggingLevel;

public class DeadLetterChannelFileRouter extends RouteBuilder {
  private static final String SOURCE_FOLDER = "src/test/source-folder";

  @Override
  public void configure() throws Exception {
    errorHandler(deadLetterChannel("log:dead?level=ERROR")
      .maximumRedeliveries(3).redeliveryDelay(1000)
      .retryAttemptedLogLevel(LoggingLevel.ERROR));

    from("file://" + SOURCE_FOLDER + "?delete=true")
      .process(exchange -> {
        throw new IllegalArgumentException("Exception thrown!");
      });
  }
}
```

After running this test, following log statements are visible in a console:

```log
ERROR DeadLetterChannel:156 - Failed delivery for
(MessageId: ID-ZAG0025-50922-1481340325657-0-1 on
ExchangeId: ID-ZAG0025-50922-1481340325657-0-2).
On delivery attempt: 0 caught: java.lang.IllegalArgumentException:
Exception thrown!
ERROR DeadLetterChannel:156 - Failed delivery for
(MessageId: ID-ZAG0025-50922-1481340325657-0-1 on
ExchangeId: ID-ZAG0025-50922-1481340325657-0-2).
On delivery attempt: 1 caught: java.lang.IllegalArgumentException:
Exception thrown!
ERROR DeadLetterChannel:156 - Failed delivery for
(MessageId: ID-ZAG0025-50922-1481340325657-0-1 on
ExchangeId: ID-ZAG0025-50922-1481340325657-0-2).
On delivery attempt: 2 caught: java.lang.IllegalArgumentException:
Exception thrown!
ERROR DeadLetterChannel:156 - Failed delivery for
(MessageId: ID-ZAG0025-50922-1481340325657-0-1 on
ExchangeId: ID-ZAG0025-50922-1481340325657-0-2).
On delivery attempt: 3 caught: java.lang.IllegalArgumentException:
Exception thrown!
ERROR dead:156 - Exchange[ExchangePattern: InOnly,
BodyType: org.apache.camel.component.file.GenericFile,
Body: [Body is file based: GenericFile[File.txt]]]
```

## Apache Camel Conditional Routing - Baeldung

- [Apache Camel Conditional Routing - Baeldung](https://www.baeldung.com/spring-apache-camel-conditional-routing)

# Enterprise Integration Patterns

> Enterprise Integration Patterns (EIP) provide a valuable set of solutions for integrating various systems and applications within an enterprise environment

## Resources

- https://www.enterpriseintegrationpatterns.com/patterns/messaging/
- https://camel.apache.org/components/4.4.x/eips/enterprise-integration-patterns.html
- [List of Patterns - EIP](https://learning.oreilly.com/library/view/enterprise-integration-patterns/0321200683/pref01.html)
- [Table of Contents - EIP](https://learning.oreilly.com/library/view/enterprise-integration-patterns/0321200683/toc.html)
- https://www.javainuse.com/camel/camel-routing-slip-example
- https://www.baeldung.com/tag/apache-camel

## `Aggregator` EIP with Apache Camel - Amin Shahimian

- [`Aggregator` EIP with Apache Camel - Amin Shahimian](https://medium.com/@a11shahimian/aggregator-eip-in-apache-camel-9d57f3aa7ddd)

> The Aggregator Pattern is used in situations where messages from multiple sources need to be combined or correlated into a single message
>
> Apache Camel (an integration framework), offers robust support for implementing the Aggregator EIP

### What is Aggregator EIP

> The Aggregator EIP addresses the challenge of combining related messages from
> different sources into a single, cohesive message
>
> This pattern is particularly useful in scenarios such as collecting data from distributed systems,
> processing and correlating responses from multiple services, or assembling fragments of a large message.
>
> Aggregation allows developers to aggregate messages based on specific criteria,
> such as correlation IDs, time windows, or message content, providing flexibility
> and control over the integration flow

### Example in Apache Camel

[Apache Camel](https://camel.apache.org/) simplifies the implementation of the Aggregator EIP
through its rich set of components and DSL (Domain Specific Language).

The framework provides the Aggregator and Resequencer EIPs, which are specifically
designed to facilitate message aggregation. Let's delve into a basic example of
implementing the Aggregator EIP using Apache Camel within a Java Spring Boot application.

In the example below, we define a Camel route that starts from the `direct:start` endpoint.

- We use the `.aggregate()` DSL to aggregate messages based on the header `aggregationId` using a custom `MyAggregationStrategy`
- We set the completion size to 5, indicating that aggregation should be completed after receiving 5 messages.
- Once aggregation is completed, the aggregated message is routed to the `direct:aggregated` endpoint for further processing.

```java
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AggregationRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("direct:start")
      .aggregate(header("aggregationId"), new MyAggregationStrategy())
      .completionSize(5) // Complete aggregation after 5 messages
      .to("direct:aggregated");

    from("direct:aggregated")
      .log("Aggregated Message: ${body}");
  }
}
```

In the example below, the `MyAggregationStrategy` class defines the custom aggregation logic:

- In this case it simply concatenates the bodies of incoming messages into a single aggregated message.

```java
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class MyAggregationStrategy implements AggregationStrategy {

  @Override
  public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    if (oldExchange == null) {
      return newExchange;
    }
    String oldBody = oldExchange.getIn().getBody(String.class);
    String newBody = newExchange.getIn().getBody(String.class);
    String aggregatedBody = oldBody + ", " + newBody;
    oldExchange.getIn().setBody(aggregatedBody);
    return oldExchange;
  }
}
```

## `Splitter` EIP in Apache Camel - Amin Shahimian

- [`Splitter` EIP in Apache Camel - Amin Shahimian](https://medium.com/@a11shahimian/splitter-eip-in-apache-camel-simplifying-message-processing-0011c2bed25e)

> The Splitter EIP allows you to split a message into multiple parts and process them individually

### What is Splitter EIP

> The Splitter EIP is designed to split a message into smaller parts, often based on a delimiter or specific criteria
>
> This pattern is particularly useful in scenarios where you receive a single message
> containing multiple records or chunks of data that need to be processed independently.
>
> This pattern is useful when you are dealing with CSV files, XML documents, or any other structured data,
> whereby the Splitter EIP allows you to efficiently handle message decomposition and streamline your integration workflows.

### How Splitter EIP Works

> The Splitter EIP processes the input message and generates one or more output messages,
> each containing a single part of the original message.
>
> It iterates over the input message and applies the splitting logic to extract individual parts,
> which are then processed separately downstream.

### Example in Apache Camel

Let's consider a scenario where we receive a CSV file containing employee data,
with each line representing information about a single employee (e.g. ID, name, department).

Our goal is to split this CSV file into individual records and process each employee's data independently.

In the example below:

1. We define a Camel route that consumes a CSV file from the `data/input` directory.
2. We use the Splitter EIP by invoking the `.split().tokenize("\n")` method, which splits the input message by newline characters.
3. We enable streaming mode using `.streaming()` to process large files efficiently.
4. Each split part is then routed to the `direct:processEmployee` endpoint for further processing.
5. In the `direct:processEmployee` route, we access each individual employee data and perform processing tasks as required.

```java
import org.apache.camel.builder.RouteBuilder;

public class SplitterExampleRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("file:data/input")
      .split().tokenize("\n") // Split the input by newline
      .streaming() // Enable streaming to process large files efficiently
      .to("direct:processEmployee");

    from("direct:processEmployee")
      .process(exchange -> {
        String employeeData = exchange.getIn().getBody(String.class);
        // Process individual employee data here
        System.out.println("Processing employee data: " + employeeData);
      });
  }
}
```

## `Routing Slip` EIP in Apache Camel - Amin Shahimian

- [`Routing Slip` EIP in Apache Camel - Amin Shahimian](https://medium.com/@a11shahimian/splitter-eip-in-apache-camel-simplifying-message-processing-0011c2bed25e)

> The Routing Slip EIP enables dynamic message routing based based on certain criteria

### Using a Bean to Compute the Routing Slip Header:

One approach to implementing the Routing Slip EIP involves using a bean to compute
the routing slip header dynamically.

In the example below, the `RoutingSlipBean` computes the routing slip based on the message content.
The `CamelRoute` then uses this bean to determine the routing slip header dynamically.

```java
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.CamelContext;
import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.direct;
import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.log;

public class RoutingSlipBean {
  public String computeRoutingSlip(String body) {
    // Compute routing slip based on message content
    // For demonstration, a simple logic is used
    if (body.contains("categoryA")) {
      return "direct:processCategoryA";
    } else {
      return "direct:processCategoryB";
    }
  }
}

public class CamelRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("direct:start")
      .bean(RoutingSlipBean.class, "computeRoutingSlip") // <-- HERE
      .routingSlip(header("routingSlipHeader"));

    from("direct:processCategoryA")
      .to("log:categoryA");

    from("direct:processCategoryB")
      .to("log:categoryB");
  }
}

public class MainApp {
  public static void main(String[] args) throws Exception {
    CamelContext context = new DefaultCamelContext();
    context.addRoutes(new CamelRoute());
    context.start();
    Thread.sleep(5000);
    context.stop();
  }
}
```

### Using an Expression as the Routing Slip

Another approach is to use an expression to calculate the routing slip dynamically

In the example below, the `computeRoutingSlipExpression` method computes the routing slip dynamically.
This method can contain any logic required to determine the routing slip based on message attributes.

```java
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.CamelContext;

public class ExpressionHelper {
  public static String computeRoutingSlipExpression(String body) {
    // Compute routing slip based on message content
    if (body.contains("categoryA")) {
      return "direct:processCategoryA";
    } else {
      return "direct:processCategoryB";
    }
  }
}

public class CamelRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("direct:start")
      .setHeader("routingSlipHeader", method(ExpressionHelper.class, "computeRoutingSlipExpression")) // <-- HERE
      .routingSlip(header("routingSlipHeader"));

    from("direct:processCategoryA")
      .to("log:categoryA");

    from("direct:processCategoryB")
      .to("log:categoryB");
  }
}

public class MainApp {
  public static void main(String[] args) throws Exception {
    CamelContext context = new DefaultCamelContext();
    context.addRoutes(new CamelRoute());
    context.start();
    Thread.sleep(5000);
    context.stop();
  }
}
```

### Using `@RoutingSlip` Annotation as the Routing Slip

Apache Camel also provides the `@RoutingSlip` annotation to simplify the implementation of the Routing Slip EIP

In the example below, the `computeRoutingSlipWithAnnotation` method is annotated with `@RoutingSlip`, indicating that it computes the routing slip.

- The method returns the routing slip dynamically, simplifying the configuration.

```java
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.RoutingSlip;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.CamelContext;

public class CamelRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("direct:start")
      .routingSlip().method(RoutingSlipBean.class, "computeRoutingSlipWithAnnotation");

    from("direct:processCategoryA")
      .to("log:categoryA");

    from("direct:processCategoryB")
      .to("log:categoryB");
  }
}

public class RoutingSlipBean {
  @RoutingSlip // <-- HERE
  public String computeRoutingSlipWithAnnotation(String body) {
    // Compute routing slip based on message content
    // Logic here...
    return "direct:processCategoryA,direct:processCategoryB";
  }
}

public class MainApp {
  public static void main(String[] args) throws Exception {
    CamelContext context = new DefaultCamelContext();
    context.addRoutes(new CamelRoute());
    context.start();
    Thread.sleep(5000);
    context.stop();
  }
}
```

## `Dynamic Router` EIP - Amin Shahimian

- [`Dynamic Router` EIP - Amin Shahimian](https://medium.com/@a11shahimian/dynamic-router-eip-6d370b523d47)

> Dynamic Router enables the dynamic routing of messages within an application based on a set of pre-defined rules or conditions

### Dynamic Router vs Routing Slip

> The Routing Slip will compute the slip (series of endpoints) beforehand, which means the slip is only computed once (static)
> If you need to dynamically compute the slip on-the-fly (evaluating after each step), then use the Dynamic Router EIP instead (dynamic)

### Understanding the Dynamic Router EIP

> At its core, the Dynamic Router EIP is all about routing messages dynamically within an application.

Instead of having static routing paths defined within the application code,
the Dynamic Router allows for the routing decision to be made at runtime based
on certain conditions. This provides flexibility and adaptability to the application,
especially in scenarios where the routing logic might change frequently or needs
to be configured externally.

### Usage of Dynamic Router EIP

The Dynamic Router EIP is particularly useful in scenarios such as:

1. Conditional Routing: When messages need to be routed based on specific conditions or criteria.
2. Load Balancing: Distributing messages across multiple endpoints based on load or availability.
3. Content-Based Routing: Routing messages based on their content or type.
4. Error Handling: Redirecting messages to error handling endpoints dynamically based on error types.

### Example in Apache Camel

Let's illustrate the usage of Dynamic Router EIP with a simple example using Java 17 and XML configuration.

In the example below, we define a `DynamicRouterExample` class with a route method
that contains our routing logic. Depending on whether the message contains the word
"important" or not, it dynamically routes the message to different endpoints.

```java
public class DynamicRouterExample {

  public String route(String message) {
    // Implement your routing logic here
    if (message.contains("important")) {
      return "direct:importantQueue";
    } else {
      return "direct:defaultQueue";
    }
  }

  public static void main(String[] args) {
    CamelContext context = new DefaultCamelContext();

    try {
      context.addRoutes(new RouteBuilder() {
        public void configure() {
          from("direct:start")
            .dynamicRouter(method(DynamicRouterExample.class, "route"));

          from("direct:importantQueue")
            .to("log:important");

          from("direct:defaultQueue")
            .to("log:default");
        }
      });

      context.start();

      ProducerTemplate producer = context.createProducerTemplate();
      producer.sendBody("direct:start", "Message containing important information");
      producer.sendBody("direct:start", "Regular message");
    } finally {
      context.stop();
    }
  }
}
```

### XML Configuration (Camel Context)

In the XML configuration, we define the routes similar to the Java DSL,
specifying the dynamic router method and the endpoints.

```xml
<camelContext xmlns="http://camel.apache.org/schema/spring">
    <route>
        <from uri="direct:start" />
        <dynamicRouter>
            <method bean="dynamicRouterExample" method="route" />
        </dynamicRouter>
    </route>
    <route>
        <from uri="direct:importantQueue" />
        <to uri="log:important" />
    </route>
    <route>
        <from uri="direct:defaultQueue" />
        <to uri="log:default" />
    </route>
</camelContext>
```
