# Table of Contents

- [Table of Contents](#table-of-contents)
- [Enterprise Integration Patterns](#enterprise-integration-patterns)
  - [C2 - Integration Styles](#c2---integration-styles)
  - [Remote Procecure Call/Invocation (RPI/RPC)](#remote-procecure-callinvocation-rpirpc)
  - [Messaging](#messaging)

# Enterprise Integration Patterns

- [Enterprise Integration Patterns Book](https://learning.oreilly.com/library/view/enterprise-integration-patterns/0321200683/)

**Author = djoleB**

- https://www.youtube.com/playlist?list=PLWmY-5Dfr8QBX7c5403yIcx7r93frvrfV
- https://github.com/djoleB/enterprise_integration_patterns
- Patterns Covered
  - Message Filter
  - Content Based Router
  - Splitter
  - Recipient List
  - Resequencer
  - Dynamic Router
  - Aggregator

## C2 - Integration Styles

## Remote Procecure Call/Invocation (RPI/RPC)

> Develop each application as a large-scale object or component with encapsulated data. Provide an interface to allow other applications to interact with the running application
>
> Remote Procedure Invocation applies the principle of encapsulation to integrating applications
>
> - If an application needs some information that is owned by another application, it asks that application directly
> - If one application needs to modify the data of another, it does so by making a call to the other application
> - This allows each application to maintain the integrity of the data it owns
> - Furthermore, each application can alter the format of its internal data without affecting every other application

![](https://learning.oreilly.com/api/v2/epubs/urn:orm:book:0321200683/files/graphics/051fig01.jpg)

- Note: RPC is a **SYNCHRONOUS** process
  - The caller must block and wait until the called method completes execution, and thus offers no potential for developing loosely coupled enterprise applications without the use of multiple threads
  - _RPC systems require the client and server to be available at the same time_

## Messaging

> Use Messaging to transfer packets of data frequently, immediately, reliably, and asynchronously, using customizable formats

![](https://learning.oreilly.com/api/v2/epubs/urn:orm:book:0321200683/files/graphics/054fig01.jpg)

- Asynchronous messaging is solution to the problems of distributed systems
  - Sending a message does not require both systems to be up and ready at the same time
  - Thinking about the communication in an asynchronous manner forces developers to recognize that working with a remote application is slower
    - Encourages design of components with high cohesion (lots of work locally) and low adhesion (selective work remotely)
- Messages can be transformed in transit without either the sender or receiver knowing about the transformation
  - The decoupling allows integrators to choose between broadcasting messages to multiple receivers, routing a message to one of many receivers, or other topologies
  - This separates integration decisions from the development of the applications
- FAQ
  - _How do you transfer packets of data?_
    - A sender sends data to a receiver by sending a Message (66) via a Message Channel (60) that connects the sender and receiver
  - _How do you know where to send the data?_
    If the sender does not know where to address the data, it can send the data to a Message Router (78), which will direct the data to the proper receiver
  - _How do you know what data format to use?_
    - If the sender and receiver do not agree on the data format, the sender can direct the data to a Message Translator (85) that will convert the data to the receiver's format and then forward the data to the receiver
  - _If you're an application developer, how do you connect your application to the messaging system?_
    - An application that wishes to use messaging will implement Message Endpoints (95) to perform the actual sending and receiving
