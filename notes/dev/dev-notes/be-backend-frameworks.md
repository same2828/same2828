# Table of Contents

- [Table of Contents](#table-of-contents)
- [Frameworks](#frameworks)
  - [Apache Camel](#apache-camel)
  - [Red Hat Fuse](#red-hat-fuse)

# Frameworks

## Apache Camel

**Summary**

> Apache Camel = A versatile open source integration framework based on Enterprise Integration Patterns (EIP)

- Apache Camel = A complete production-ready framework for people who want to implement their solution to follow the Enterprise Integration Patterns
  - Apache Camel offers you the interfaces for the Enterprise Integration Patterns, the base objects, commonly needed implementations, debugging tools, a configuration system, and many other helpers which will save you a ton of time when you want to implement your solution to follow the Enterprise Integration Patterns
- Apache Camel = An open source Java framework based on Enterprise Integration Patterns (EIP) that provides:
  - Concrete implementations of all the widely used Enterprise Integration Patterns (EIPs)
  - Connectivity to a great variety of transports and APIs
  - Easy to use Domain Specific Languages (DSLs) to wire EIPs and transports together
- Apache Camel = Messaging technology glue with routing. It joins together messaging start and end points allowing the transference of messages from different sources to different destinations. For example: JMS -> JSON, HTTP -> JMS or funneling FTP -> JMS, HTTP -> JMS, JSON -> JMS
- Apache Camel > Red Hat Fuse

**What is Apache Camel (Video)**

- [Source](https://www.youtube.com/watch?v=Zwq8bxHnwqg&pp=ygUVd2hhdCBpcyBhcGFjaGUgY2FtbGVs)
- Problem: Companies have lots of data in different locations/services (servers, databases, cloud apps)
  - Case/Scenario: We need to move data between these locations/places (i.e. fetch a zip file from a server to be extracted or upload a folder to Dropbox)
    - This is known as "integration" = moving data between different systems
  - To integrate systems, a developer needs to know: protocols of systems (HTTPS/FTP), data formats, each service's APIs
- Apache Camel is an integration framework that provides integration libraries in Java
- The core part of Apache Camel is the engine (which runs the integrations)
  - The developer defines: where to pull data from, what Apache Camel should do with it, where the data needs to go
- Apache Camel comes with "components" that allow the user to connect to things such as web services, ftp servers, apps (e.g. Salesforce, Twitter)
- Apache Camel comes with a builtin set of patterns that user can use and configure in their integration flow
  - These patterns come from the book "Enterprise Integration Patterns"
    - Example:
      - Split message into multiple lines = Splitter Pattern
        - We can use Splitter Pattern which is implemented in Apache Camel, in integration workflow we tell Apache Camel to use the splitter pattern and how to split the message
      - Perform action based on content of message (i.e. routing/deleting) = Content Based Routing Pattern
- Steps to use Apache Camel
  - Add Apache Camel Libraries
  - Write integration flow using Apache Camel's language/domain specific language (DSL)
    - Note: In Apache Camel these "flows" are called "routes"
  - Use components and patterns
    - When writing routes decide which "components" you will need (which systems you will talk to) and which patterns to use
  - Start the Engine
    - Done either explicitly in code or by another framework such as Spring Boot

**Open Source Integration With Apache Camel and How Fuse IDE Can Help**

- [Source 1](http://dzone.com/articles/open-source-integration-apache)
- [Source 2](https://web.archive.org/web/20171029104103/https://dzone.com/articles/open-source-integration-apache)

- Take any integration project and you have multiple applications talking over multiple transports on multiple platforms. As you can imagine, in large enterprises, applications like this can get complex very fast. Much of the complexity stems from two issues:
  - _Dealing with the specifics of applications and transports_
  - _Coming up with good solutions to integration problems_
- Apache Camel = An open source Java framework that focuses on making integration easier and more accessible to developers (created with the intention of addressing these two issues above)
  - It does this by providing:
    - _Concrete implementations of all the widely used Enterprise Integration Patterns (EIPs)_
    - _Connectivity to a great variety of transports and APIs_
    - _Easy to use Domain Specific Languages (DSLs) to wire EIPs and transports together_
- - High level view of Camel's architecture
    ![](https://web.archive.org/web/20171029104103im_/http://java.dzone.com/sites/all/files/figure1_1.jpg)
- **"Components"** are the extension point in Camel to add connectivity to other systems
  - The core of Camel is very small to keep dependencies low, promote embeddability, etc. and as a result contains only 13 essential components
  - There are over 80 components outside the core
  - To expose these systems to the rest of Camel, Components provide an `Endpoint` interface
  - By using URIs, you can send or receive messages on `Endpoints` in a uniform way
  - E.g. To receive messages from a JMS queue aQueue and send them to a file system directory "/tmp", you could use URIs like `jms:aQueue` and `file:/tmp`
- **"Processors"** are used to manipulate and mediate messages in between **Endpoints**
  - All of the EIPs are defined as Processors or sets of Processor
- To wire `Processors` and `Endpoints` together, Camel defines multiple DSLs in regular programming languages such as Java, Scala and Groovy

  - It also allows routing rules to be specified in XML
  - DSL examples (functionally equivalent)
    - In all the below examples we define a routing rule that will load files in the "/tmp" directory into memory, create a new JMS message with the file contents, and send that message to a JMS queue named aQueue
    - Java DSL
      ```java
      from ("file:/tmp").to("jms:aQueue");
      ```
    - Spring DSL
      ```xml
      <route>
        <from uri="file:/tmp"/>
        <to uri="jms:aQueue"/>
      </route>
      ```

- Resources

  - https://camel.apache.org/manual/faq/what-is-camel.html
  - https://stackoverflow.com/questions/8845186/what-exactly-is-apache-camel
  - http://dzone.com/articles/open-source-integration-apache
  - https://web.archive.org/web/20171029104103/https://dzone.com/articles/open-source-integration-apache

## Red Hat Fuse

- Red Hat Fuse = Red Hat Fuse is an open source distributed integration platform that provides a standardized methodology, infrastructure, and tools to integrate services, microservices, and application components (Wikipedia)
- Red Hat Fuse = Distributed, cloud-native integration platform (Red Hat)
- Red Hat Fuse 7.x EOL on June 30, 2024, it is recommended users migrate to the Red Hat build of Apache Camel
- Overview
  - Red Hat Fuse comes with a series of "connectors" (called "components" in Apache Camel) so you can programmatically tie together various external SaaS services
  - Fuse enables you to build collaborative and agile Java applications using microservices and containers
  - Fuse packages together Apache Camel with ten other open source projects into a coherent whole that will save you time in implementation, while allowing you to use a variety of specific application development tools (such as ApiCurio, Swagger, and Undertow) to build apps with your own preferences and create powerful links with these interfaces
  - Because Fuse is based on containers, you can create a distributed environment that can isolate faults, deploy consistently, allow for continuous improvement, and be extensible
- [Read more](https://developers.redhat.com/products/fuse/overview)
