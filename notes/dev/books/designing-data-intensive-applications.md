# Table of Contents

- [Table of Contents](#table-of-contents)
- [C1](#c1)
  - [Reliability](#reliability)
    - [Hardware Faults](#hardware-faults)
    - [Software Errors](#software-errors)
    - [Human Errors](#human-errors)
  - [Scalability](#scalability)
    - [Describing Load](#describing-load)
    - [Describing Performance](#describing-performance)
    - [Coping with Load](#coping-with-load)
  - [Maintainability](#maintainability)
    - [Operability](#operability)
    - [Simplicity (Managing Complexity)](#simplicity-managing-complexity)
    - [Evolvability (Making Change Easy)](#evolvability-making-change-easy)

# C1

Data intensive applications need to:

- Store data so that they, or another application, can find it again later (databases)
- Remember the result of an expensive operation, to speed up reads (caches)
- Allow users to search data by keyword or filter it in various ways (search indexes)
- Send a message to another process, to be handled asynchronously (stream processing)
- Periodically crunch a large amount of accumulated data (batch processing)

Thinking About Data Systems

- Datastores that are also used as message queues (Redis)
- Message queues with database-like durability guarantees (Apache Kafka)
- Application-managed caching layer Memcached
- Full text search server (Elasticsearch, Solr)

An application has to meet various requirements in order to be useful

- **Functional requirements** (what it should do)
  - Allowing data to be stored, retrieved, searched, and processed in various ways
- **Non-functional requirements**
  - General properties like security, reliability, compliance, scalability, compatibility, and maintainability

## Reliability

- **Reliability = A system's ability to continue working correctly even when faults occur**
  - Faults from hardware, software, human error
- The things that can go wrong are called faults, and systems that anticipate faults and can cope with them are called **fault-toleran**t or **resilient**
- **Fault != Failure**
  - A fault is when a component of the system deviates from its spec
  - A failure is when the system as a whole stops providing the required service to the user
- Counterintuitively in fault-tolerant systems, we should increase the rate of faults by triggering them deliberately (e.g. by randomly killing individual processes without warning) to ensure that the fault-tolerance machinery is continually exercised and tested (increases confidence that faults will be handled correctly when they occur naturally)

### Hardware Faults

- **Hardware Redundancy**

  - First response is usually to **add redundancy to the individual hardware components** in order to reduce the failure rate of the system
    - Disks may be set up in a RAID configuration
    - Servers may have dual power supplies and hot-swappable CPUs
    - Datacenters may have batteries and diesel generators for backup power

- **Software Fault Tolerance**
  - AWS prioritize flexibility and elasticity over single-machine reliability (hence common for single VM instances can become unavailable unexpectedly)
  - **Move toward systems that can tolerate the loss of entire machines**, by using **software fault-tolerance techniques** in preference or in addition to hardware redundancy
  - Such systems also have operational advantages such as being able to tolerate machine failures by patching one node at a time, without downtime of the entire system (a rolling upgrade)

### Software Errors

- Examples
  - A software bug that causes every instance of an application server to crash when given a particular bad input (leap years)
  - A runaway process that uses up some shared resource-CPU time, memory, disk space, or network bandwidth
  - A service that the system depends on that slows down, becomes unresponsive, or starts returning corrupted responses
  - Cascading failures, where a small fault in one component triggers a fault in another component, which in turn triggers further faults
- The bugs that cause these kinds of software faults often **lie dormant** for a long time **until they are triggered by an unusual set of circumstances**

  - In those circumstances, it is revealed that the software is making some kind of assumption about its environment/constraints and suddenly the assumption becomes false

- **Ways to mitigate Software Errors**:
  - Carefully thinking about assumptions and interactions in the system
  - Thorough testing
  - Process isolation
  - Allowing processes to crash and restart
  - Measuring, monitoring, and analyzing system behavior in production
  - If a system is expected to provide some guarantee (e.g. in a message queue, that the number of incoming messages equals the number of outgoing messages), it can constantly check itself while it is running and raise an alert if a discrepancy is found

### Human Errors

- **Ways to mitigate Human Errors**:
  - Design systems in a way that minimizes opportunities for error
    - E.g. Abstractions, APIs, and admin interfaces make it easy to do "the right thing" and discourage "the wrong thing"
  - Fully featured non-production sandbox environments for testing
  - Test at all levels
    - Unit tests
    - Whole-system integration tests
    - Manual tests
    - Automated tests
  - Quick and easy roll back configuration changes
  - Set up detailed and clear monitoring of performance metrics and error rates

## Scalability

- **Scalability = A system's ability to cope with increased load and maintain performance**

### Describing Load

- **Load Parameters** (depends on on the architecture of your system)
  - Requests per second to a web server
  - Ratio of reads to writes in a database
  - Number number of simultaneously active users in a chat room
  - The hit rate on a cache

### Describing Performance

We can investigate what happens when the load increases in 2 ways

1. When you increase a load parameter and **keep the system resources unchanged** (CPU, memory, network bandwidth, etc.), how is the performance of your system affected?
2. When you increase a load parameter, how much do you need to increase the resources if you want to **keep performance unchanged**?

- Depends on the system:

  - In a batch processing system such as Hadoop, we usually care about throughput (the number of records processed per second), or the total time it takes to run a job
    on a dataset of a certain size
    - Ideally, the running time of a batch job is the size of the dataset divided by the throughput
    - In practice, the running time is often longer: due to skew (data not being spread evenly across worker processes) and needing to wait for the slowest task to complete
  - In online systems, what's usually more important is the service's response time (the time between a client sending a request and receiving a response)

- **Latency != Response Time**

  - Latency = The duration that a request is waiting to be handled (during which it is latent/awaiting service)
  - Response Time = Time that the client see/waits which includes: the time to process the request (service time), network delays and queueing delay

- Measuring Response Time: Use **distribution of values**
- Causes of latency/response time variation:
  - Context switch to a background process
  - Loss of a network packet and TCP retransmission
  - Garbage collection pause
  - Page fault forcing a read from disk
  - Mechanical vibrations in the server rack

### Coping with Load

- **Vertical Scaling** (Scaling Up) = Moving to a more powerful machine
- **Horizontal Scaling** (Scaling Out) = Distributing the load across multiple smaller machines
- **Elastic** = Automatically add computing resources when they detect a load increase (can also be done manually)

## Maintainability

- Examples
  — Fixing bugs
  - Keeping systems operational
  - Investigating failures
  - Adapting to new platforms
  - Modifying for new use cases
  - Repaying technical debt
  - Adding new features

### Operability

- **Operability = Easiness for operations teams to keep the system running smoothly**
  - Good operability means having good visibility into the system's health, and having effective ways of managing it
- Responsibilities:

  - Monitoring the health of the system and quickly restoring service if it goes into a bad state
  - Tracking down the cause of problems, such as system failures or degraded performance
  - Keeping software and platforms up to date, including security patches
  - Keeping tabs on how different systems affect each other, so that a problematic change can be avoided before it causes damage
  - Anticipating future problems and solving them before they occur (e.g., capacity planning)
  - Establishing good practices and tools for deployment, configuration management, and more
  - Performing complex maintenance tasks, such as moving an application from one platform to another
  - Maintaining the security of the system as configuration changes are made
  - Defining processes that make operations predictable and help keep the production environment stable
  - Preserving the organization's knowledge about the system, even as individual people come and go

- Data systems features to make routine tasks easy:

  - Providing visibility into the runtime behavior and internals of the system, with good monitoring
  - Providing good support for automation and integration with standard tools
  - Avoiding dependency on individual machines (allowing machines to be taken down for maintenance while the system as a whole continues running uninterrupted)
  - Providing good documentation and an easy-to-understand operational model ("If I do X, Y will happen")
  - Providing good default behavior, but also giving administrators the freedom to override defaults when needed
  - Self-healing where appropriate, but also giving administrators manual control over the system state when needed
  - Exhibiting predictable behavior, minimizing surprises

### Simplicity (Managing Complexity)

- Make it easy for new engineers to understand the system, by removing as much complexity as possible from the system
- Note: this does NOT mean simplicity of the user interface
- Causes of complexity
  - Explosion of the state space
  - Tight coupling of modules
  - Tangled dependencies
  - Inconsistent naming and terminology
  - Hacks aimed at solving performance problems
  - Special edge casing to work around issues
- Accidental complexity occurs due to method of implementation
- Use **abstraction** to **remove accidental complexity**
  - Hide a great deal of implementation detail behind a clean and simple-to-understand facade

### Evolvability (Making Change Easy)

- Make it easy for engineers to make changes to the system in the future, adapting it for unanticipated use cases as requirements change
- Also known as extensibility, modifiability, plasticity
- System's requirements remain in flux:
  - Learn new facts
  - Previously unanticipated use cases emerge
  - Business priorities change
  - Users request new features
  - New platforms replace old platforms
  - Legal or regulatory requirements change
  - Growth of the system forces architectural changes
