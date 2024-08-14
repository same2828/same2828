# Table of Contents

- [Table of Contents](#table-of-contents)
- [Java](#java)
  - [Java Key Store (JKS)](#java-key-store-jks)
  - [Java Message Service (JMS)](#java-message-service-jms)
    - [Message Delivery Models](#message-delivery-models)
      - [Point-to-Point (Queue Destination)](#point-to-point-queue-destination)
      - [Publish/Subscribe (Topic Destination)](#publishsubscribe-topic-destination)
    - [JMS Programming Model](#jms-programming-model)
      - [Header](#header)
      - [Properties](#properties)
      - [Body](#body)
  - [Java Virtual Machine (JVM)](#java-virtual-machine-jvm)
    - [JDK](#jdk)
    - [JRE](#jre)
    - [JVM](#jvm)
      - [Class Loader](#class-loader)
      - [Runtime Data Area](#runtime-data-area)
        - [Method Area](#method-area)
        - [Heap Area](#heap-area)
      - [Execution Engine](#execution-engine)
        - [Native Method Interface/Library](#native-method-interfacelibrary)

# Java

## Java Key Store (JKS)

> A Java KeyStore (JKS) is a repository of "security certificates" (authorization/public key certificates) + corresponding "private keys" used for instance in TLS encryption

- KeyStore is also a class which is part of the standard API
  - Essentially it is a way to load, save and generally interact with one of the "physical" keystores as described above
  - A KeyStore can also be purely in memory, if you just need the API abstraction for your application
- A KeyStore is a repository where private keys, certificates and symmetric keys can be stored (typically a file)
- [Java JKS Docs](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/security/KeyStore.html)

## Java Message Service (JMS)

> The Java Message Service (JMS) API is an ASYNCHRONOUS Java message-oriented middleware (MOM) API (messaging standard) for sending messages between two or more clients/application components (producers & consumers) to create, send, receive, and read messages
>
> JMS provides a standard way for clients to asynchronously create, send, receive, and read messages, regardless of the messaging style used. It also provides features such as transaction support, message persistence, and message filtering
>
> It enables distributed communication that is loosely coupled, reliable, and asynchronous

- The Java Message Service (JMS) allows for asynchronous sending and receiving of data and events in business appplications
  - It provides a common way for Java applications to access such enterprise messaging systems (through a common enterprise messaging API)
  - JMS supports both messaging models: point-to-point (queuing) and publish-subscribe (topic)
- Message Delivery Models
  - JMS supports two different message delivery models:
    - Point-to-Point (Queue Destination)
    - Publish/Subscribe (Topic Destination)

### Message Delivery Models

![](https://miro.medium.com/v2/resize:fit:720/format:webp/1*6xoSrUbGrRpl_tmM_Bhd3Q.png)

#### Point-to-Point (Queue Destination)

- In this model, a message is delivered from a producer to one consumer
  - **One/Many Producers -> ONE Consumer**
- The messages are delivered to the destination, which is a queue, and then delivered to one of the consumers registered for the queue
- While any number of producers can send messages to the queue, each message is guaranteed to be delivered, and consumed by ONE consumer
- _If no consumers are registered to consume the messages, the queue holds them until a consumer registers to consume them_

![](https://www.javatpoint.com/ejbpages/images/jms-point-to-point-model.png)

#### Publish/Subscribe (Topic Destination)

- In this model, a message is delivered from a producer to any number of consumers
  - **One/Many Producers -> ZERO/MANY Consumers**
- Messages are delivered to the topic destination, and then to all active consumers who have subscribed to the topic
- In addition, any number of producers can send messages to a topic destination, and each message can be delivered to any number of subscribers
- _There is a "Timing Dependency" between publishers and subscribers_
  - The publisher MUST create a message topic for clients to subscribe
  - The subscriber MUST remain continuously active to receive messages, unless it has established a durable subscription
    - In that case, messages published while the subscriber is not connected will be redistributed whenever it reconnects
- _If there are no consumers registered, the topic destination does NOT hold messages unless it has durable subscription for inactive consumers_
  - A durable subscription represents a consumer registered with the topic destination that can be inactive at the time the messages are sent to the topic
- Note: A common analogy is an anonymous bulletin board
  - In this model, neither the publisher nor the subscriber knows about each other

![](https://www.javatpoint.com/ejbpages/images/jms-publisher-subscriber-model.png)

### JMS Programming Model

> A JMS application consists of a set of application-defined messages and a set of clients that exchange them
>
> JMS clients interact by sending and receiving messages using the JMS API.
>
> A message is composed of three parts:
>
> - Header
> - Properties
> - Body

![](https://www.javatpoint.com/ejbpages/images/jms-programming-model.png)

#### Header

- **The header (REQUIRED for every message), contains information that is used for routing and identifying messages**
  - Some of these fields are set automatically, by the JMS provider, during producing and delivering a message, and others are set by the client on a message by message basis.

#### Properties

- **The properties (optional), provide values that clients can use to filter messages through property name/value pairs**
- They provide additional information about the data, such as which process created it, the time it was created.
- Properties can be considered as an extension to the header, and consist of property name/value pairs.
- Using properties, clients can fine-tune their selection of messages by specifying certain values that act as selection criteria.

#### Body

- **The body (optional), contains the actual data to be exchanged**
- The JMS specification defined six type or classes of messages that a JMS provider must support:
  - `Message`: This represents a message without a message body
  - `StreamMessage`: A message whose body contains a stream of Java primitive types. It is written and read sequentially.
  - `MapMessage`: A message whose body contains a set of name/value pairs. The order of entries is NOT defined.
  - `TextMessage`: A message whose body contains a Java string (i.e. such as an XML message)
  - `ObjectMessage`: A message whose body contains a serialized Java object
  - `BytesMessage`: A message whose body contains a stream of uninterpreted bytes

## Java Virtual Machine (JVM)

> The Java Virtual Machine (JVM) serves as an abstraction layer between the Java code and the underlying hardware.
>
> When a Java program is compiled, it generates bytecode, which is then interpreted by the JVM at runtime.
>
> It follows the concept of  **WORA (_Write Once Run Anywhere_)**, where code can be written once and be used on any hardware that has a compatible JVM.

First it might be useful to differentiate the difference between the JDK, JRE and JVM.

- Resources
  - [JRE - IBM](https://www.ibm.com/topics/jre)
  - [Java Virtual Machine - Medium](https://medium.com/@sanju.skm/java-virtual-machine-a1fc9e45d9d3)
  - [Is the Java Virtual Machine the same as a VM](https://stackoverflow.com/questions/861422/is-the-java-virtual-machine-really-a-virtual-machine-in-the-same-sense-as-my-vmw)
  - [Memory footprint of the JVM](https://spring.io/blog/2019/03/11/memory-footprint-of-the-jvm)
  - [JIT Compiler - IBM](https://www.ibm.com/docs/en/sdk-java-technology/8?topic=reference-jit-compiler)

### JDK

The Java Development Kit (JDK) provides the tools necessary to write and develop Java programs. This usually contains tools like the compiler which converts Java code(.java) to Java byte code (.class), debugger and the runtime environment which is what you use to run the code (JRE in this case).

### JRE

The Java Runtime Environment (JRE) contains sets of libraries and files that the JVM uses at runtime. It has a physical location on disk. The JRE is platform dependant as it needs to have the appropriate libraries to access the correct native OS methods.

The JRE can be used to run Java byte code, the JDK is not required.

![](https://miro.medium.com/v2/resize:fit:640/format:webp/1*8oNn6HxcWFmrCsgUt27k0w.jpeg)

### JVM

The JVM can be thought of as 3 seperate systems: Class Loader, JVM Memory and Execution Engine.
The Java is both a [compiled and interpreted language](https://www.freecodecamp.org/news/compiled-versus-interpreted-languages/). The Java code is **compiled** into byte code and that byte code is **interpreted** by the JVM.

![](https://miro.medium.com/v2/resize:fit:720/format:webp/1*d3iiqc2AFfphG-fN4Xictg.png)

#### Class Loader

The class loader is responsible for loading the compiled byte code classes into the JVM. This includes the compiled classes from the application and also the standard library which includes things like Strings, Collections etc.

Linking involves verifying the bytecode is valid, then preparing by allocating and initialising memory for class variables to default values. Finally, symbolic references are transformed into direct references to memory in the Method Area.

The last step is Initialisation, static variables will be initialised to their assigned starting values now that the memory has been allocated.

#### Runtime Data Area

##### Method Area

Class data, constants and static variables are stored in the method area. There is only one method area per JVM, and it is a shared resource. This method area is logically part of the Heap but implementations may treat this memory area differently and might not [[notes/Garbage Collection|Garbage Collect]] it.

##### Heap Area

The heap memory is where all the Objects created by the application are stored. There is only one area per JVM and it is a shared resource.

#### Execution Engine

The Interpreter converts bytecode into machine code and executes it. The issue is that the interpreter will interpret all bytecode even if the same method is being called again.

The Just In Time (JIT) compiler has a Profiler which monitors the code to identify which methods are frequently executed (hotspots). The JVM identifies hotspots through keeping track of the number of times a method has been invoked. Once a threshold is exceeded, JIT compilation is triggered. The threshold for triggering JIT compilation can be configured and better performance can be achieved at the expense of higher compilation costs in terms of CPU and memory.

Methods such as loops are common hotspot areas where optimisation is possible. When a hotspot is identified the JIT compiler will compile it to native machine code. Subsequent requests of the same method will then use the machine code which does not need to be interpreted which result in significant performance improvements.

##### Native Method Interface/Library

The Native Interface and Native method library are the libraries called to interact with the host machines OS.
