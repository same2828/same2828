# Table of Contents

- [Table of Contents](#table-of-contents)
- [What is Temporal?](#what-is-temporal)
- [What is a Workflow](#what-is-a-workflow)
  - [Workflow Examples](#workflow-examples)
    - [Expense Report Example](#expense-report-example)
    - [Money Transfer Example](#money-transfer-example)
- [Architectural Overview](#architectural-overview)
  - [Temporal Platform](#temporal-platform)
    - [Part 1: The Server](#part-1-the-server)
    - [Part 2: Clients that communicate with the Temporal Server](#part-2-clients-that-communicate-with-the-temporal-server)
  - [Communication Between Temporal Application and Temporal Cluster/Cloud](#communication-between-temporal-application-and-temporal-clustercloud)
  - [Temporal Cluster](#temporal-cluster)
  - [Workers](#workers)
    - [Worker Connectivity](#worker-connectivity)
- [Options for Running a Temporal Cluster](#options-for-running-a-temporal-cluster)
  - [Self-Hosted](#self-hosted)
  - [Temporal Cloud](#temporal-cloud)
  - [Where Your Code Runs](#where-your-code-runs)
- [Integrating Temporal into Other Applications](#integrating-temporal-into-other-applications)
  - [Direct Integration in Application Frontend](#direct-integration-in-application-frontend)
  - [Integration through a Backend Application](#integration-through-a-backend-application)
- [Temporal SDKs](#temporal-sdks)
- [Temporal Command-Line Interface: `temporal`](#temporal-command-line-interface-temporal)
  - [Installing `temporal` CLI](#installing-temporal-cli)
- [Writing a Workflow Definition](#writing-a-workflow-definition)
  - [Input Parameters and Return Values](#input-parameters-and-return-values)
    - [Values Must Be Serializable](#values-must-be-serializable)
    - [Data Confidentiality](#data-confidentiality)
    - [Avoid Passing Large Amounts of Data](#avoid-passing-large-amounts-of-data)
- [The Role of a Worker](#the-role-of-a-worker)
  - [Initializing a Worker](#initializing-a-worker)
  - [The Lifetime of a Worker](#the-lifetime-of-a-worker)
  - [Choosing Names for Task Queues](#choosing-names-for-task-queues)
- [Executing a Workflow from the Command Line](#executing-a-workflow-from-the-command-line)
  - [Using the CLI to Start a Workflow with Windows](#using-the-cli-to-start-a-workflow-with-windows)
  - [Explanation of Command Arguments](#explanation-of-command-arguments)
  - [What Happens When You Run the Command](#what-happens-when-you-run-the-command)
  - [Hands-On Exercise #1: Hello Workflow](#hands-on-exercise-1-hello-workflow)
- [Executing a Workflow from Application Code](#executing-a-workflow-from-application-code)
  - [Explanation](#explanation)
- [Viewing Workflow History with `temporal` CLI](#viewing-workflow-history-with-temporal-cli)
  - [Running `temporal workflow show`](#running-temporal-workflow-show)
  - [Interpreting Command Output](#interpreting-command-output)
- [Making Changes to a Workflow](#making-changes-to-a-workflow)
  - [Input Parameters and Return Values](#input-parameters-and-return-values-1)
  - [Determinism](#determinism)
  - [Versioning](#versioning)
- [Restarting the Worker Process](#restarting-the-worker-process)
- [Temporal Activities](#temporal-activities)
  - [What are Temporal Activities?](#what-are-temporal-activities)
  - [Activity Definition](#activity-definition)
    - [Activity Definition Example](#activity-definition-example)
  - [Registering Activities](#registering-activities)
    - [Activity Registration Example](#activity-registration-example)
  - [Executing Activities](#executing-activities)
    - [Specifying Activity Options](#specifying-activity-options)
    - [Executing the Activity](#executing-the-activity)
    - [Executing the Activity Synchronously](#executing-the-activity-synchronously)
    - [Executing the Activity Asynchronously](#executing-the-activity-asynchronously)
      - [Using `io.temporal.workflow.Async` and `io.temporal.workflow.Promise`](#using-iotemporalworkflowasync-and-iotemporalworkflowpromise)
      - [Using `java.util.concurrent.CompletableFuture`](#using-javautilconcurrentcompletablefuture)
    - [Retrieving the Result](#retrieving-the-result)
- [Using Appropriate Timeouts](#using-appropriate-timeouts)
- [How Temporal Handles Activity Failure](#how-temporal-handles-activity-failure)
  - [Default Behavior](#default-behavior)
    - [Changing the Timing and Number of Retry Attempts](#changing-the-timing-and-number-of-retry-attempts)
- [Activity Retry Policy Example](#activity-retry-policy-example)

https://learn.temporal.io/courses/temporal_101/java/

https://learn.temporal.io/getting_started/java/dev_environment/

# What is Temporal?

In short, Temporal is a platform that guarantees the durable execution of your application code.
It allows you to develop as if failures don't even exist.
Your application will run reliably even if it encounters problems, such as network outages or server crashes, which would be catastrophic for a typical application.
The Temporal platform handles these types of problems, allowing you to focus on the business logic, instead of writing application code to detect and recover from failures.

# What is a Workflow

Temporal applications are built using an abstraction called `Workflows`.

- You'll develop those `Workflows` by writing code in a general-purpose programming language such as Go, Java, TypeScript, or Python.
- The code you write is the same code that will be executed at runtime, so you can use your favorite tools and libraries to develop `Temporal Workflows`.

`Temporal Workflows` are resilient.

- They can run—and keeping running—for years, even if the underlying infrastructure fails.
- If the application itself crashes, Temporal will automatically recreate its pre-failure state so it can continue right where it left off.

**Conceptually, a `workflow` defines a sequence of steps**

- With Temporal, those steps are defined by writing code, known as a `Workflow Definition`, and are carried out by running that code, which results in a `Workflow Execution`.

## Workflow Examples

### Expense Report Example

![](https://learn.temporal.io/courses/temporal-101/java/chapter_02/expense-report-workflow-diagram.png)

First, you create the report, describe the items you purchased, attach receipts if necessary, and then you submit it. The manager then reviews it, either rejecting it (in which case you'll be notified so you can fix the problem and resubmit if necessary) or approving it. If approved, the accounting department will process it, reimburse you by sending a check or direct deposit, and then let you know they've done so. They will also archive this report so it's available in case of an audit.

- Long-running process
  - Depending on the organization and the number of approvals required, it may take days, weeks, or longer from start to finish.
- Conditional logic
  - Just like a computer program, there are decision points and execution paths that diverge based on the outcome: if your expense report is accepted, reimbursement is the next step, but if it's rejected, the next step is sending a notification requesting that you modify and resubmit the report.
- Can contain cycles
  - For example, because a rejected report may lead to correction, re-submission, and another review. It's also worth noting that the workflow involves multiple points of human interaction, from the employee, the manager, and the accounting department. It also involves external systems, notably the company's bank, which is the source of the reimbursement, and the employee's bank, which is the target of those funds.

### Money Transfer Example

In the case of the expense report scenario, you might think of the reimbursement as a single step, but it's actually two distinct operations.

![](https://learn.temporal.io/courses/temporal-101/java/chapter_02/money-transfer.png)

- The first step is to withdraw money from the employer’s bank account and the second is to deposit the same amount into the employee’s bank account.
- There are two important constraints for doing this correctly.
  - First, you must execute both the withdrawal and the deposit.
  - Second, you must execute each of them exactly once.
- This workflow would typically involve multiple accounts accessed through some type of remote procedure calls, making it a distributed system.
  - As with any distributed system, it could fail for many reasons, including server failure or a network outage

# Architectural Overview

## Temporal Platform

Temporal Platform has two parts: Server & Client

![](https://learn.temporal.io/courses/temporal-101/java/chapter_02/temporal-server-diagram.png)

### Part 1: The Server

- The `Temporal Server` consists of a frontend service, plus several backend services that work together to manage the execution of your application code.
- All of those services are horizontally scalable and a production environment will typically run multiple instances of each, deployed across multiple machines, to increase performance and availability.

Note: The frontend service that is part of the `Temporal Server` acts as an API gateway

Note: The frontend service is for clients ONLY and NOT end users/developers (end users will interact with the CLI or Web UI)

### Part 2: Clients that communicate with the Temporal Server

- There are three types of clients
  1. Temporal's command-line interface (CLI)
  2. Temporal's web-based user interface (Web UI)
  3. A Temporal Client embedded into the applications you run

## Communication Between Temporal Application and Temporal Cluster/Cloud

Clients communicate with the `Temporal Server` by issuing requests to this Frontend Service.

- The Frontend Service then communicates with backend services, as necessary to fulfill the request, and then returns a response to the client.
- Communication to and within the Cluster is done using gRPC, a popular high-performance open source RPC framework originally developed at Google and now part of the Cloud Native Computing Foundation ecosystem.
- The messages themselves are encoded using Protocol Buffers, an open source serialization mechanism also originally developed at Google.

All of this communication can be secured with TLS, which encrypts the data as it is transmitted across the network and can also verify the identity of the client and server by validating their certificates.

![](https://learn.temporal.io/courses/temporal-101/java/chapter_02/communication-v2.png)

## Temporal Cluster

The complete Temporal is known as the `Temporal Cluster`, which is a deployment of the `Temporal Server` software on some number of machines, plus the additional components used with it.

![](https://learn.temporal.io/courses/temporal-101/java/chapter_02/temporal-cluster-diagram.png)

- **The only required component is a database**

- The `Temporal Cluster` tracks the current state of every execution of your Workflows.
  - It also maintains a history of all Events that occur during their executions, which it uses to reconstruct the current state in case of failure.
  - It persists this and other information, such as details related to durable timers and queues, to the database.

- Elasticsearch is an optional component.
  - It provides advanced searching, sorting, and filtering capabilities for information about current and recent Workflow Executions.
  - This is helpful when you run Workflows millions of times and need to locate a specific one; for example, based on when it started, how long it took to run, or its final status.

- Prometheus is used to collect metrics from Temporal
- Grafana is used to create dashboards based on those metrics.
- Together, these tools help operations teams monitor cluster and application health.

## Workers

![](https://learn.temporal.io/courses/temporal-101/java/chapter_02/temporal-platform-diagram.png)

Note: **The `Temporal Cluster` does NOT execute your code**.

- While the `Temporal Platform` guarantees the durable execution of your code, it achieves this through orchestration.
- The execution of your application code is EXTERNAL to the `Temporal Cluster`, and in typical deployments, takes place on a separate set of servers, potentially running in a different data center than the `Temporal Cluster`.

**The entity responsible for executing your code is known as a `Worker`**

- It's common to run Workers on multiple servers, since this increases both the scalability and availability of your application.
- **The `Worker` (which is part of your application), communicates with the Temporal Cluster to manage the execution of your Workflows**

The `application` will contain the code used to initialize the `Worker`, the `Workflow` and other functions that comprise your business logic, and possibly also code used to start or check the status of the Workflow.

- At runtime, you'll need everything needed to execute the application, which will include any libraries or other dependencies referenced in your code, on each machine where at least one `Worker` process will run.

#### Worker Connectivity

Since the `Worker` uses a `Temporal Client` to communicate with the `Temporal Cluster`, each machine running a `Worker` will require connectivity to the Temporal Cluster’s Frontend Service, which listens on TCP port `7233` by default.

# Options for Running a Temporal Cluster

There are several ways to run a Temporal Cluster, but they fall into two categories: host it yourself or let Temporal do it for you.

## Self-Hosted

One option for deploying a self-hosted Temporal Cluster is to use Docker Compose. It's extremely convenient for development clusters because it avoids the need to manually install and configure individual components. [Temporal maintains a GitHub repository that offers several configurations for you to use](https://github.com/temporalio/docker-compose).

Another option, which was described in the "Setting up a Local Development Environment" section of the previous chapter, is the temporal command's built-in support for running a development server. This runs in a single process and doesn't have any external runtime dependencies, so it is less complex and less resource-intensive than using Docker Compose.

Production grade self-hosted Temporal Clusters are often run on Kubernetes, although this is not required. [The documentation provides more information about cluster deployment](https://docs.temporal.io/cluster-deployment-guide).

## Temporal Cloud

The alternative to hosting your own Temporal Cluster is to use Temporal Cloud, a fully-managed cloud service operated and staffed by Temporal. It's a simple, secure, scalable way to power your Temporal applications, providing 99.9% uptime and SOC2 compliance. It also comes with developer and production support from the experts at Temporal.

Using Temporal Cloud frees your organization from the operational workload of running and supporting your own cluster, which involves not only the initial planning and deployment, but ongoing work to monitor, update, and scale it.

Temporal Cloud uses consumption-based pricing, so you only pay for what you use, and you can see your current and past usage at any time right from the web interface.

![](https://learn.temporal.io/courses/temporal-101/java/chapter_02/cloud-usage.png)

## Where Your Code Runs

Regardless of whether you host your own Temporal Cluster or use Temporal Cloud, your application runs on servers that you control. These might be servers in your own datacenter or virtual machines hosted by your favorite cloud provider, **but it's important to understand that Temporal neither runs your code nor even has access to your code**.

# Integrating Temporal into Other Applications

During this course, you will primarily interact with the Workflow Executions using a command-line interface or through code executed in the terminal. While this approach allows you to quickly iterate as you learn, it does not necessarily reflect most real-world interactions with Temporal Workflows.

Temporal serves a diverse range of use cases;

- E.g. ensuring that e-commerce orders and financial transactions execute reliably.
- The end users of these applications aren't developers and are probably unaware of Temporal, yet their actions trigger Workflow Executions and other interactions with the Temporal Cluster.

## Direct Integration in Application Frontend

It is possible to use a Temporal Client from within those applications.

It is also possible to issue gRPC requests directly from the applications without using a Temporal Client at all.

However, both would be atypical approaches. **NOT RECOMMENDED**

![](https://learn.temporal.io/courses/temporal-101/java/chapter_02/integration-direct.png)

## Integration through a Backend Application

A more typical approach is to have the Web or mobile app make calls to a service (e.g. a Web application that provides a REST endpoint) which acts as an application gateway.

This way when a request is made to the endpoint associated with order processing, the code within that service can extract data from the HTTP request and use it as input to the `Workflow` when it calls the Temporal client's `execute workflow` method.

- That in turn issues a gRPC request to the `Temporal Cluster`, which starts the `Workflow` Execution. Similarly, there may be endpoints for canceling the Workflow or retrieving its result.

![](https://learn.temporal.io/courses/temporal-101/java/chapter_02/integration-indirect.png)

This approach is easier to support from a network security perspective, since the Temporal Cluster's Frontend Service only needs to accept inbound connections from the Web server instead of having to accept them from every end user.

# Temporal SDKs

```xml
<dependency>
  <groupId>io.temporal</groupId>
  <artifactId>temporal-sdk</artifactId>
  <version>1.19.1</version>
</dependency>
```

[See the documentation for details on how to install SDKs for other languages](https://docs.temporal.io/concepts/what-is-a-temporal-sdk)

# Temporal Command-Line Interface: `temporal`

Temporal provides a command-line interface (CLI), temporal, which allows you to interact with a cluster, start a development server, and more.

- During this course, you'll use temporal to start workflows and view the status and history of their execution, although it has many more advanced capabilities as well.

```sh
$ temporal
The Temporal CLI manages, monitors, and debugs Temporal apps. It lets you run
a local Temporal Service, start Workflow Executions, pass messages to running
Workflows, inspect state, and more.

* Start a local development service:
      temporal server start-dev
* View help: pass --help to any command:
      temporal activity complete --help

Usage:
  temporal [command]

Available Commands:
  activity    Complete or fail an Activity
  batch       Manage running batch jobs
  completion  Generate the autocompletion script for the specified shell
  env         Manage environments
  help        Help about any command
  operator    Manage Temporal deployments
  schedule    Perform operations on Schedules
  server      Run Temporal Server
  task-queue  Manage Task Queues
  workflow    Start, list, and operate on Workflows

Flags:
      --color string
        Output coloring. Accepted values: always, never, auto.
        (default "auto")

      --env ENV
        Active environment name (ENV). (default "default")

      --env-file $HOME/.config/temporalio/temporal.yaml
        Path to environment settings file.
        (defaults to $HOME/.config/temporalio/temporal.yaml).

  -h, --help
        help for temporal

      --log-format string
        Log format. Options are: text, json. Defaults to: text.

      --log-level server start-dev
        Log level. Default is "info" for most commands and "warn" for
        server start-dev. Accepted values: debug, info, warn, error,
        never. (default "info")

      --no-json-shorthand-payloads
        Raw payload output, even if they are JSON.

  -o, --output string
        Non-logging data output format. Accepted values: text, json,
        jsonl, none. (default "text")

      --time-format string
        Time format. Accepted values: relative, iso, raw.
        (default "relative")

  -v, --version
        version for temporal

Use "temporal [command] --help" for more information about a command.
```

As you see, the program has 10 commands, each of which has several subcommands. Fortunately, you don't have to remember all of these. If you add --help after a command or partial command, it will display more specific help, as shown in the excerpt below:

```sh
$ temporal workflow --help
Workflow commands perform operations on Workflow Exec
For example:

temporal workflow list

Usage:
  temporal workflow [command]

Available Commands:
  cancel           Send cancellation to Workflow Execution
  count            Number of Workflow Executions
  delete           Remove Workflow Execution
  describe         Show Workflow Execution info
  execute          Start new Workflow Execution
...
Use "temporal workflow [command] --help" for more information about a command.
```

## Installing `temporal` CLI

```sh
brew install temporal
```

[The Temporal documentation describes alternative methods for installing the Temporal CLI, including instructions for installing it on Linux and Windows.](https://docs.temporal.io/cli#install)

# Writing a Workflow Definition

1. Import the `io.temporal.workflow.WorkflowInterface` and `io.temporal.workflow.WorkflowMethod` annotation types provided by the SDK
2. Annotate the interface with `@WorkflowInterface`
3. Annotate the method signature with `@WorkflowMethod`

In the Java SDK, the `Workflow Type` defaults to the name of the interface used to define the `Workflow`

```java
package greeting;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface Greeting {
  @WorkflowMethod
  String greetSomeone(String name);
}
```

```java
package greeting;

public class GreetingImpl implements Greeting {
  @Override
  public String greetSomeone(String name) {
    return "Hello, " + name + "!";
  }
}
```

```java
package greeting;

public class Starter {
  public static void main(String[] args) {
    Greeting greeting = new GreetingImpl();
    String greetingMsg = argsp.length > 0 ? greeting.greetSomeone(args[0]) : greeting.greetSomeone("World");
    System.out.println(greetingMsg);
  }
}
```

## Input Parameters and Return Values

### Values Must Be Serializable

Temporal maintains information about current and past Workflow Executions.

- One benefit of this is that you can use the Web UI to explore these details when investigating a problem, even one that may have occurred several days earlier.
- However, this also affects how you design Workflow Definitions.

In order for Temporal to store the Workflow's input and output, data used in input parameters and return values must be serializable.

- By default, Temporal can handle `null` or binary values, as well as any data that can be serialized by the default `Jackson JSON Payload Converter`.
- This means that most of the types you'd typically use in a function, such as integers and floating point numbers, boolean values, and Strings, are all handled automatically.

It is best practice and recommended to pass objects as parameters so that the object's individual fields can be altered without breaking the signature of the Workflow.

### Data Confidentiality

Although the input parameters and return values are stored as part of the Event History of your Workflow Executions, you can create a custom Data Converter to encrypt the data as it enters the Temporal Cluster and decrypt it upon exit, thereby maintaining the confidentiality of any sensitive data used as input or output of your applications. [Custom data converters are beyond the scope of the Temporal 101 course, but the documentation provides more information.](https://docs.temporal.io/concepts/what-is-a-data-converter/)

### Avoid Passing Large Amounts of Data

Because the Event History, which is sent across the network from Workers to the Temporal Cluster and vice-versa, contains the input and output, you'll have better performance if you limit the amount of data sent.

- For example, imagine you've created a Workflow that will convert audio files from one format to another.
- It would be much better to pass the path or URL for the files as input than to pass the content of the files.

To protect against unexpected failures caused by sending or storing too much data, the Temporal Server imposes various limits beyond which it will emit warnings or errors, depending on the severity. [The documentation includes a page that details these limits](https://docs.temporal.io/kb/temporal-platform-limits-sheet).

# The Role of a Worker

Workers execute your Workflow code.

- The Worker itself is provided by the Temporal SDK, but your application will include code to configure and run it.
- When that code executes, the Worker establishes a persistent connection to the Temporal Cluster and begins polling a Task Queue on the Cluster, seeking work to perform.

Since Workers execute your code, any Workflows you execute will make no progress unless one Worker is running.

## Initializing a Worker

There are typically three things you need in order to configure a `Worker`:

1. **A `Temporal Client`**, which is used to communicate with the `Temporal Cluster`
2. **The name of a `Task Queue`**, which is maintained by the `Temporal Server` and polled by the `Worker`
3. **The name of the `Workflow Definition` interface**, used to register the Workflow implementation with the `Worker`

Worker Initialization Code

```java
package io.temporal.learn;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class GreetingWorker {

  public static void main(String[] args) {

    WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
    WorkflowClient client = WorkflowClient.newInstance(service);
    WorkerFactory factory = WorkerFactory.newInstance(client);

    // Specify the name of the Task Queue that this Worker should poll
    Worker worker = factory.newWorker("greeting-tasks");

    // Specify which Workflow implementations this Worker will support
    worker.registerWorkflowImplementationTypes(GreetingImpl.class);

    // Begin running the Worker
    factory.start();
  }
}
```

The `main` method begins by creating a `WorkflowServiceStubs` instance, which represents a gRPC connection to a Temporal Cluster.

- The `newLocalServiceStubs()` method used to create this instance here is appropriate when the Temporal Cluster and Worker are running on the same machine, as is often the case during development.
- If the Temporal Cluster is running on a different machine or if you are using Temporal Cloud, you would instead call the `newServiceStubs(WorkflowServiceStubsOptions options)` method using options that include the hostname and port number used to reach its frontend service.

- The code uses the `WorkflowServiceStubs` instance to create a Temporal Client, which the `Worker` will use to communicate with the Temporal Cluster. The line that follows uses that client to create a `WorkerFactory`, which is used to create one or more `Worker` instances.

- When creating the Worker, call the factory's `newWorker` method, specifying the name of the Task Queue on the Temporal Cluster that this Worker will poll.
  - After creating the Worker, you must register the Workflow implementation class that you want this Worker to support.
  - A single Worker can support multiple Workflows, so you can call this method multiple times, passing in a different Workflow implementation class each time.

Finally, it calls the factory's `start` method, which starts all the Worker instance(s) created by that factory, although only one Worker instance is created in this example.

- When the Worker starts, it will begin a "long poll" of the Task Queue and will execute code in the Workflow Definition in response to tasks created by the Cluster.

If you start the Worker from a terminal, using a program like the one shown above, don't be surprised if you see nothing more than a few lines of output. This is the expected behavior and the program isn't stuck, it's just busy polling the task queue and working on the tasks that it has accepted from the Temporal Cluster.

## The Lifetime of a Worker

**The lifetime of the Worker and the duration of a Workflow Execution are unrelated**.

- The `start` method used to start this Worker is a blocking method that doesn't stop unless it is terminated or encounters a fatal error.
- The Worker's process may last for days, weeks, or longer.
- If the Workflows it handles are relatively short, then a single Worker might execute thousands or even millions of them during its lifetime.
- On the other hand, a Workflow can run for years, while the server where a Worker process is running might be rebooted after a few months by an administrator doing maintenance.
- If the `Workflow Type` was registered with other workers, one or more of them will automatically continue where the original Worker left off.
- If there are no other Workers available, then the Workflow Execution will continue where it left off as soon as the original Worker is restarted.
- In either case, the downtime will not cause the Workflow Execution to fail.

## Choosing Names for Task Queues

Task queue names are case sensitive

# Executing a Workflow from the Command Line

We have created a Workflow Definition and initialized a Worker capable of executing it.

The next step is to run your application.

One way to start the Workflow is by using the temporal command-line tool to run a command similar to the one shown here:

```sh
temporal workflow start \
  --type HelloWorkflowWorkflow \
  --task-queue greeting-tasks \
  --workflow-id my-first-workflow \
  --input '"Mason"'
```

**Note: The quoting for the input value, which has double quotes inside of single quotes.**

- The input passed to the temporal command MUST be in JSON format and the quoting used here is necessary to pass the value through the shell and into the Workflow in the correct format.

## Using the CLI to Start a Workflow with Windows

The mix of single and double quotes we currently have pertains to UNIX-style shells. However, If you are running the Temporal CLI in Windows (such as Powershell), you will need to use Windows-style quote escaping like this:

```sh
temporal workflow start --type HelloWorkflowWorkflow --task-queue greeting-tasks --workflow-id my-first-workflow --input '\"Mason\"'
```

## Explanation of Command Arguments

This command specifies several arguments. The first is the Workflow Type. In the Java SDK, this defaults to the unqualified name of the interface for your Workflow Definition.

The next is the Task Queue that the Temporal Cluster will use, which must exactly match the value supplied when initializing the Worker. Since task queues are dynamically created, typing the task queue name incorrectly would not cause an error, but it would result in two different task queues, and since the Cluster and Worker wouldn't share the same queue in this case, the Workflow Execution would never progress.

The command also specifies a Workflow ID, which is optional, but recommended. This is a user-defined identifier, which typically has some business meaning, so an expense reporting workflow might have a Workflow ID that identifies the expense report or the employee who submitted it. If omitted, a UUID will be automatically assigned as the Workflow ID.

Since this Workflow requires input (a string containing a name used to customize the greeting), this command supplies that value. When submitting a Workflow for execution through the command line, the input is always in JSON format, which is why the input in this command shows double quotes inside of single quotes. Typing JSON directly on the command line is fine for a simple case like this, where there's just one parameter and a single value, but it would be a clumsy way of passing more complex data. Luckily, you can save the input to a file, in JSON format, and specify its path to the `--input-file` option, rather than using the `--input` option to specify the data inline, as shown here.

## What Happens When You Run the Command

When you run the command, it submits your execution request to the cluster, which responds with the Workflow ID, which will be the same as the one you provided, or assigned UUID if you omitted it.

It also displays a Run ID, which uniquely identifies this specific execution of the Workflow. However, it does not display the result returned by the Workflow, since Workflows might run for months or years. You can use the `temporal workflow` show command to retrieve the result.

```sh
temporal workflow show --workflow-id my-first-workflow
```

## Hands-On Exercise #1: Hello Workflow

[See repo](https://github.com/temporalio/edu-101-java-code/tree/main/exercises/hello-workflow/solution/src/main/java/helloworkflow)

# Executing a Workflow from Application Code

During the previous exercise, you used temporal to start a Workflow from the command line. An alternative to this is to start the Workflow from code in your application, which is the approach you'll use during later hands-on exercises to save you from having to type out long temporal commands each time.

Although both approaches accomplish the same result, doing it from code provides a way of integrating Temporal into your own applications. For example, you might execute or terminate a Workflow in response to some user activity, such as clicking a button in a Web or mobile app.

## Explanation

This application follows three main steps to start the Workflow:

1. Import the necessary packages from the Temporal SDK
2. Create and configure a client
3. Use the API to request execution

Regarding the second point, the code used to create and configure the `client` here is identical to the code used during Worker initialization. You can structure your application such that the same client is shared between those two parts of the code. In fact, this is common for real-world Temporal applications, but in this course, I've kept the Worker initialization and starter code separate so that it's easier to distinguish the role of each.

The Workflow Execution options specify the Workflow ID and Task Queue name, the same two values supplied as arguments to the `temporal` command.

The application requests execution of the Workflow by calling the Workflow Method from an instance of a client stub of the Workflow and passing in the input for Workflow. In this case, the input is supplied through the command line when running this application.

By the way, when starting a Workflow from code, we don't have to specify the input in JSON format you did on the command line. The Temporal SDK will automatically encode all input properly.

```java
package helloworkflow;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class Starter {
  public static void main(String[] args) throws Exception {
    WorkflowServiceStubs workflowService = WorkflowServiceStubs.newLocalServiceStubs();
    WorkflowClient workflowClient = WorkflowClient.newInstance(workflowService);
    WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
      .setWorkflowId("my-first-workflow")
      .setTaskQueue("greeting-tasks")
      .build();
    HelloWorkflowWorkflow helloWorkflow = workflowClient.newWorkflowStub(HelloWorkflowWorkflow.class, workflowOptions);

    String greeting = helloWorkflow.greetSomeone(args[0]);
    String workflowId = WorkflowStub.fromTyped(helloWorkflow).getExecution().getWorkflowId();
    System.out.println(workflowId + " " + greeting);
  }
}
```

In the example above, the call to greetSomeone will block until the Workflow completes execution, and the value returned by the Workflow will be assigned to the greeting variable.

Temporal does offer the option of asynchronous execution, which allows you to start a Workflow with a non-blocking call and later await its results using a separate call that will block until the execution is complete.

# Viewing Workflow History with `temporal` CLI

## Running `temporal workflow show`

The `Temporal Cluster` maintains detailed information about the history of each Workflow Execution.

- This is another advantage of developing on the `Temporal Platform`, because it gives you insight into what's happening in your applications, both those that are currently running and those that have recently run.

One way to see the simple history of your Workflow Execution is by running a temporal command similar to the one shown below:

```sh
temporal workflow show --workflow-id my-first-workflow
```

## Interpreting Command Output

Running the command above will produce output similar to this, which details events that occurred during the execution of this Workflow:

```sh
Progress:
  ID           Time                     Type
    1  2024-08-20T19:22:22Z  WorkflowExecutionStarted
    2  2024-08-20T19:22:22Z  WorkflowTaskScheduled
    3  2024-08-20T19:22:22Z  WorkflowTaskStarted
    4  2024-08-20T19:22:22Z  WorkflowTaskCompleted
    5  2024-08-20T19:22:22Z  WorkflowExecutionCompleted
Results:
  Status          COMPLETED
  Result          "Hello Mason!"
  ResultEncoding  json/plain
```

This Workflow Execution has five items in its Event History as well as the status and output of the Workflow Execution

To see a more detailed history of your Workflow Execution, run the following command similar to the one shown below:

```sh
temporal workflow show --workflow-id my-first-workflow --detailed
```

```sh
Progress:

identity: temporal-cli:masonegger@Masons-Laptop
input[0]: Mason
originalExecutionRunId: 86afe3ea-8563-4056-9de1-e8ed6ca5b1e3
taskId: 1048587
taskQueue.kind: TASK_QUEUE_KIND_NORMAL
taskQueue.name: greeting-tasks
workflowExecutionTimeout: 0s
workflowId: my-first-workflow
workflowRunTimeout: 0s
workflowTaskTimeout: 10s
workflowType.name: GreetSomeone

--------------- [2] WorkflowTaskScheduled ------
eventTime: 2024-08-20T19:22:22.081601Z
historySizeBytes: 304
identity: 35461@Masons-Laptop
requestId: a0e88f09-ebc0-4b4d-bf1a-4c8fc616859c
scheduledEventId: 2
taskId: 1048593
workerVersion.buildId: a29a35df004d1a3519db4896d1335c96

--------------- [4] WorkflowTaskCompleted ---------------
eventTime: 2024-08-20T19:22:22.089363Z
identity: 35461@Masons-Laptop
scheduledEventId: 2
sdkMetadata.coreUsedFlags[0]: 1
sdkMetadata.coreUsedFlags[1]: 2
startedEventId: 3
taskId: 1048597
workerVersion.buildId: a29a35df004d1a3519db4896d1335c96

--------------- [5] WorkflowExecutionCompleted ---------------
eventTime: 2024-08-20T19:22:22.089482Z
result[0]: Hello Mason!
taskId: 1048598
workflowTaskCompletedEventId: 4

Results:
  Status          COMPLETED
  Result          "Hello Mason!"
  ResultEncoding  json/plain
```

The same Events from the previous output are present with more context and options. You can probably extract some helpful information from this output.

The details shown to the right of the first Event identifies the Workflow Type (`HelloWorldWorkflow`), Task Queue (`greeting-tasks`), input value (`Mason`), and various timeout settings used for this Workflow Execution. The next three events indicate that the Temporal Cluster scheduled a Workflow Task, which was then started and completed by a Worker. The final Event confirms that the Workflow Execution completed, returning a result (`Hello Mason!`).

# Making Changes to a Workflow

Backwards compatibility is an important consideration in Temporal. You might execute a given Workflow Definition hundreds, thousands, or millions of times. If the execution fails, then Temporal will reconstruct the Workflow's state before the failure, and then continue on with the execution

## Input Parameters and Return Values

> In general, you should avoid changing the number or types of input parameters and return values for your Workflow.

Temporal recommends that your Workflow Definition takes a single input parameter, a custom object, rather than multiple input parameters. Changing which fields are part of the object doesn't change the type of the object itself, so this provides a backwards-compatible way to evolve your code.

## Determinism

Your Workflow must be [deterministic](https://docs.temporal.io/concepts/what-is-a-workflow-definition/#deterministic-constraints)

You can view determinism as a requirement that each execution of a given Workflow must produce the same output, given the same input.

- This means that you shouldn't do things like work with random numbers in your Workflow code.
- If you need to do things such as working with random numbers, the SDK provides safe alternatives.
- `Temporal Activities`, provide a safe way to perform operations that interact with the outside world.
- Such operations, which might access files, databases, or network services, are inherently non-deterministic.

## Versioning

Since Workflow Executions in Temporal can run for long periods — sometimes months or even years — it's common to need major changes to a `Workflow Definition`, even while a particular `Workflow Execution` is in progress.

For example, imagine that your Workflow currently notifies a customer when an order is shipped with an e-mail notification.

- Later, you decide to change the Workflow so that it sends both an email and a text message instead.

Versioning is a feature in Temporal that helps manage these code changes safely.

- With Versioning, you can modify your Workflow Definition so that new executions use the updated code, while existing ones continue running the original version.
- This is particularly useful when you make a non-deterministic change — one that leads to a change in the order of execution within a running Workflow Execution.
- Temporal's SDK allows you to track and manage these versions, letting older executions use the original code while new executions use the modified version.
- You can use the SDK’s "Versioning" feature to identify when a non-deterministic change is introduced.

[Learn more about Versioning in our free Versioning Workflows course.](https://learn.temporal.io/courses/versioning/)

# Restarting the Worker Process

Restart the terminal process that runs the code below

```sh
mvn compile exec:java -Dexec.mainClass="helloworkflow.HelloWorkflowWorker"
```

```java
package helloworkflow;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class HelloWorkflowWorker {

  public static void main(String[] args) {
    WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
    WorkflowClient client = WorkflowClient.newInstance(service);
    WorkerFactory factory = WorkerFactory.newInstance(client);
    Worker worker = factory.newWorker("greeting-tasks");
    worker.registerWorkflowImplementationTypes(HelloWorkflowWorkflowImpl.class);
    factory.start();
  }
}
```

# Temporal Activities

## What are Temporal Activities?

We learned earlier that Workflow code must be deterministic, and must produce the same output each time, given the same input.

- This also implies that it can't interact with the outside world; for example, accessing files or network resources, because those might not be available at a given point in time.
- However, your business logic may require you to do such things.
- How do you reconcile this?

In Temporal, you can use `Activities` to encapsulate business logic that is prone to failure.

- Unlike the Workflow Definition, there is no requirement for an Activity Definition to be deterministic.

**In general, any operation that introduces the possibility of failure should be done as part of an `Activity`, rather than as part of the Workflow directly**.

- While `Activities` are executed as part of `Workflow Execution`, they have an important characteristic: **they are retried if they fail**.
- If you have an extensive Workflow that needs to access a service, and that service happens to become unavailable, you don't want to re-run the entire Workflow.
- Instead, you just want to retry the part that failed, so you can define that code in an `Activity` and reference it in your Workflow Definition.
- The code within that Activity Definition will be executed, retried if necessary, and the Workflow will continue its progress once the Activity completes successfully.

## Activity Definition

Just as a Workflow Definition is a Java interface and implementation, an Activity Definition is also a Java interface and implementation, and has the same rules regarding types allowed as input parameters and return values as the Workflow Definition.

The interface must be annotated with `@ActivityInterface` instead of `@WorkflowInterface`.

Optionally, you can annotate your methods with `@ActivityMethod`, although this is not required unless you are attempting to specify optional arguments to the Activity.

- Temporal doesn't impose rules about how this interface is named.

- You can include the Activity Definition in the same source file as your Workflow Definition, or put it in a different source file if you prefer.

### Activity Definition Example

- Like the Workflow Definition you've already run, it takes a name (String) as input and returns a customized greeting (String) as output.
- However, this Activity makes a call to a microservice, accessed through HTTP, to request this greeting in Spanish.
- It supplies the name in the URL and retrieves the greeting from the body of the response.

```java
// GreetingActivities.java
package farewellworkflow;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@ActivityInterface
public interface GreetingActivities {

  public String greetInSpanish(String name);
}
```

```java
// GreetingActivitiesImpl.java
package farewellworkflow;

public class GreetingActivitiesImpl implements GreetingActivities {

  @Override
  public String greetInSpanish(String name) {
    StringBuilder builder = new StringBuilder();

    String baseUrl = "http://localhost:9999/get-spanish-greeting?name=";
    URL url = new URL(baseUrl + URLEncoder.encode(name, "UTF-8"));

    try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
      String line;
      while ((line = in.readLine()) != null) {
        builder.append(line).append("\n");
      }
    }

    return builder.toString();
  }
}
```

## Registering Activities

You may recall that you must register your Workflows when initializing the Worker.

You must also perform a similar step for Activities.

The process for registering the Activity is slightly different to that for registering a Workflow, with the differences being

- The name of the function you call to register it -> `worker.registerActivitiesImplementations()`
- Passing in an instantiated instance (instead of `.class`) of the Activity implementation to the registration method

### Activity Registration Example

The following Worker initialization code shows an example of registering an Activity (`new GreetingActivititiesImpl()` is an instantiation of the class that implements the Activity Definition interface `GreetingActivities`).

```java
package farewellworkflow;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class GreetingWorker {
  public static void main(String[] args) {
    WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
    WorkflowClient client = WorkflowClient.newInstance(service);
    WorkerFactory factory = WorkerFactory.newInstance(client);
    Worker worker = factory.newWorker("greeting-tasks");
    worker.registerWorkflowImplementationTypes(GreetingWorkflowImpl.class); // <-- DIFFERENCE
    worker.registerActivitiesImplementations(new GreetingActivitiesImpl()); // <-- DIFFERENCE
    factory.start();
  }
}
```

## Executing Activities

Temporal Activities are executed from within a Workflow.

The following code would be written in the implementation of the Workflow Definition.

### Specifying Activity Options

The first step to executing an Activity as part of your Workflow is to specify the options that govern its execution:

```java
ActivityOptions options = ActivityOptions.newBuilder()
  .setStartToCloseTimeout(Duration.ofSeconds(5))
  .build();
```

Crucially, this includes a `Start-to-Close` timeout, which we recommend that you always set.

- Its value should be longer than the maximum amount of time you think the execution of the Activity should take.
- This allows the Temporal Cluster to detect a Worker that crashed, in which case it will consider that attempt failed and will create another task that a different Worker could pick up.

**Note: It is REQUIRED that either `Start-to-Close` timeout or `Schedule-to-Close` timeout is set.**

### Executing the Activity

Temporal Activities can be executed either synchronously or asynchronously, depending on your use case.

To request execution of an Activity within your Workflow Definition, first call the `workflow.newActivityStub()` method, passing in the class object for your Activity Definition interface and the options (such as the Timeout described above) used to control its execution.

This returns a client stub corresponding to your Activity Definition:

```java
private final GreetingActivities activities = Workflow.newActivityStub(GreetingActivities.class, options);
```

From here, the implementation will differ depending on whether you are executing the Activity synchronously or asynchronously.

### Executing the Activity Synchronously

- To execute the Activity synchronously you will call the method from the Workflow Definition and store the result in a variable.
- Each of these calls are blocking, meaning that the Workflow Execution will wait for the first method, `greetInSpanish`, to complete before attempting to execute `farewellInSpanish`.

```java
String spanishGreeting = activities.greetInSpanish(name);
String spanishFarewell = activities.farewellInSpanish(name);
```

The only argument either of these methods take is a single string, name.

- For simplicity in this course, we pass the input as a String, although a real-world example should follow the best practice of using a custom object (with individual fields representing input values) rather than a long list of parameters.

```java
package farewellworkflow;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class GreetingWorkflowImpl implements GreetingWorkflow {

  ActivityOptions options = ActivityOptions.newBuilder()
    .setStartToCloseTimeout(Duration.ofSeconds(5))
    .build();

  private final GreetingActivities activities = Workflow.newActivityStub(GreetingActivities.class, options);

  @Override
  public String greetSomeone(String name) {
    String spanishGreeting = activities.greetInSpanish(name);
    String spanishFarewell = activities.farewellInSpanish(name);

    return "\n" + spanishGreeting + "\n" + spanishFarewell;
  }
}
```

### Executing the Activity Asynchronously

To execute the Activity asynchronously you will use Temporal's `Async` and `Promise` implementations.

- We pass in the Activity Method from the stubbed instance of our implementation and the variable `name` to `Async.function`.
- This will begin execution of the Activity and not wait for the Activity to complete before continuing execution.
- Because of this you will need to retrieve the result of the execution at a later point

Below are the import statements, followed by the code for executing Activites asynchronously (other code has been omitted for brevity):

```java
import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;

...

private final GreetingActivities activities = Workflow.newActivityStub(GreetingActivities.class, options);

...
Promise<String> hello = Async.function(activities::greetInSpanish, name);
Promise<String> bye = Async.function(activities::farewellInSpanish, name);
```

#### Using `io.temporal.workflow.Async` and `io.temporal.workflow.Promise`

```java
package io.temporal.samples.hello;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityOptions;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;
import io.temporal.workflow.Workflow;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import java.time.Duration;

/** Sample Temporal Workflow Definition that demonstrates an asynchronous Activity Execution. */
public class HelloAsync {

  // Define the task queue name
  static final String TASK_QUEUE = "HelloAsyncActivityTaskQueue";

  // Define our workflow unique id
  static final String WORKFLOW_ID = "HelloAsyncActivityWorkflow";

  /**
   * The Workflow Definition's Interface must contain one method annotated with @WorkflowMethod.
   *
   * <p>Workflow Definitions should not contain any heavyweight computations, non-deterministic
   * code, network calls, database operations, etc. Those things should be handled by the
   * Activities.
   *
   * @see io.temporal.workflow.WorkflowInterface
   * @see io.temporal.workflow.WorkflowMethod
   */
  @WorkflowInterface
  public interface GreetingWorkflow {

    /**
     * This is the method that is executed when the Workflow Execution is started. The Workflow
     * Execution completes when this method finishes execution.
     */
    @WorkflowMethod
    String getGreeting(String name);
  }

  /**
   * This is the Activity Definition's Interface. Activities are building blocks of any Temporal
   * Workflow and contain any business logic that could perform long running computation, network
   * calls, etc.
   *
   * <p>Annotating Activity Definition methods with @ActivityMethod is optional.
   *
   * @see io.temporal.activity.ActivityInterface
   * @see io.temporal.activity.ActivityMethod
   */
  @ActivityInterface
  public interface GreetingActivities {

    // Define your activity method which can be called during workflow execution
    String composeGreeting(String greeting, String name);
  }

  // Define the workflow implementation which implements our getGreeting workflow method.
  public static class GreetingWorkflowImpl implements GreetingWorkflow {

    /*
     * Define the GreetingActivities stub. Activity stubs are proxies for activity invocations that
     * are executed outside of the workflow thread on the activity worker, that can be on a
     * different host. Temporal is going to dispatch the activity results back to the workflow and
     * unblock the stub as soon as activity is completed on the activity worker.
     *
     * <p>In the {@link ActivityOptions} definition the "setStartToCloseTimeout" option sets the
     * maximum time of a single Activity execution attempt. For this example it is set to 10
     * seconds.
     */
    private final GreetingActivities activities = Workflow.newActivityStub(
      GreetingActivities.class,
      ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(10)).build());

    @Override
    public String getGreeting(String name) {

      /*
       * This is our workflow method. We invoke the composeGreeting method two times using
       * {@link io.temporal.workflow.Async#function(Func)}.
       * The results of each async activity method invocation returns us a
       * {@link io.temporal.workflow.Promise} which is similar to a Java {@link java.util.concurrent.Future}
       */
      Promise<String> hello = Async.function(activities::composeGreeting, "Hello", name);
      Promise<String> bye = Async.function(activities::composeGreeting, "Bye", name);

      // After calling the two activity methods async, we block until we receive their results
      return hello.get() + "\n" + bye.get();
    }
  }

  /** Simple activity implementation, that concatenates two strings. */
  static class GreetingActivitiesImpl implements GreetingActivities {
    @Override
    public String composeGreeting(String greeting, String name) {
      return greeting + " " + name + "!";
    }
  }

  /**
   * With our Workflow and Activities defined, we can now start execution. The main method starts
   * the worker and then the workflow.
   */
  public static void main(String[] args) {

    // Get a Workflow service stub.
    WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

    /*
     * Get a Workflow service client which can be used to start, Signal, and Query Workflow Executions.
     */
    WorkflowClient client = WorkflowClient.newInstance(service);

    /*
     * Define the workflow factory. It is used to create workflow workers for a specific task queue.
     */
    WorkerFactory factory = WorkerFactory.newInstance(client);

    /*
     * Define the workflow worker. Workflow workers listen to a defined task queue and process
     * workflows and activities.
     */
    Worker worker = factory.newWorker(TASK_QUEUE);

    /*
     * Register our workflow implementation with the worker.
     * Workflow implementations must be known to the worker at runtime in
     * order to dispatch workflow tasks.
     */
    worker.registerWorkflowImplementationTypes(GreetingWorkflowImpl.class);

    /*
     * Register our Activity Types with the Worker. Since Activities are stateless and thread-safe,
     * the Activity Type is a shared instance.
     */
    worker.registerActivitiesImplementations(new GreetingActivitiesImpl());

    /*
     * Start all the workers registered for a specific task queue.
     * The started workers then start polling for workflows and activities.
     */
    factory.start();

    // Create the workflow client stub. It is used to start our workflow execution.
    GreetingWorkflow workflow = client.newWorkflowStub(
      GreetingWorkflow.class,
      WorkflowOptions.newBuilder()
        .setWorkflowId(WORKFLOW_ID)
        .setTaskQueue(TASK_QUEUE)
        .build());

    // Execute our workflow and wait for it to complete.
    String greeting = workflow.getGreeting("World");

    // Display workflow execution results
    System.out.println(greeting);
    System.exit(0);
  }
}
```

#### Using `java.util.concurrent.CompletableFuture`

```java
package io.temporal.samples.hello;

import io.temporal.activity.*;
import io.temporal.client.ActivityCompletionClient;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.workflow.Workflow;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/** Sample Temporal Workflow Definition that demonstrates asynchronous Activity Execution */
public class HelloAsyncActivityCompletion {

  // Define the task queue name
  static final String TASK_QUEUE = "HelloAsyncActivityCompletionTaskQueue";

  // Define the workflow unique id
  static final String WORKFLOW_ID = "HelloAsyncActivityCompletionWorkflow";

  /**
   * The Workflow Definition's Interface must contain one method annotated with @WorkflowMethod.
   *
   * <p>Workflow Definitions should not contain any heavyweight computations, non-deterministic
   * code, network calls, database operations, etc. Those things should be handled by the
   * Activities.
   *
   * @see io.temporal.workflow.WorkflowInterface
   * @see io.temporal.workflow.WorkflowMethod
   */
  @WorkflowInterface
  public interface GreetingWorkflow {

    /**
     * This is the method that is executed when the Workflow Execution is started. The Workflow
     * Execution completes when this method finishes execution.
     */
    @WorkflowMethod
    String getGreeting(String name);
  }

  /**
   * This is the Activity Definition's Interface. Activities are building blocks of any Temporal
   * Workflow and contain any business logic that could perform long running computation, network
   * calls, etc.
   *
   * <p>Annotating Activity Definition methods with @ActivityMethod is optional.
   *
   * @see io.temporal.activity.ActivityInterface
   * @see io.temporal.activity.ActivityMethod
   */
  @ActivityInterface
  public interface GreetingActivities {

    /** Define the activity method which can be called during workflow execution */
    String composeGreeting(String greeting, String name);
  }

  // Define the workflow implementation which implements the getGreeting workflow method.
  public static class GreetingWorkflowImpl implements GreetingWorkflow {

    /*
     * Define the GreetingActivities stub. Activity stubs are proxies for activity invocations that
     * are executed outside of the workflow thread on the activity worker, that can be on a
     * different host. Temporal is going to dispatch the activity results back to the workflow and
     * unblock the stub as soon as activity is completed on the activity worker.
     *
     * <p>In the {@link ActivityOptions} definition the "setStartToCloseTimeout" option sets the
     * maximum time of a single Activity execution attempt. For this example it is set to 10
     * seconds.
     */
    private final GreetingActivities activities = Workflow.newActivityStub(
      GreetingActivities.class,
      ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(10)).build());

    @Override
    public String getGreeting(String name) {
      // This is a blocking call that returns only after the activity has completed.
      return activities.composeGreeting("Hello", name);
    }
  }

  /**
   * Implementation of our workflow activity interface. It overwrites the defined composeGreeting
   * activity method.
   */
  static class GreetingActivitiesImpl implements GreetingActivities {

    /*
     * ActivityCompletionClient is used to asynchronously complete activities. In this example we
     * will use this client alongside with {@link
     * io.temporal.activity.ActivityExecutionContext#doNotCompleteOnReturn()} which means our
     * activity method will not complete when it returns, however is expected to be completed
     * asynchronously using the client.
     */
    private final ActivityCompletionClient completionClient;

    GreetingActivitiesImpl(ActivityCompletionClient completionClient) {
      this.completionClient = completionClient;
    }

    @Override
    public String composeGreeting(String greeting, String name) {

      // Get the activity execution context
      ActivityExecutionContext context = Activity.getExecutionContext();

      // Set a correlation token that can be used to complete the activity asynchronously
      byte[] taskToken = context.getTaskToken();

      /*
       * For the example we will use a {@link java.util.concurrent.ForkJoinPool} to execute our
       * activity. In real-life applications this could be any service. The composeGreetingAsync
       * method is the one that will actually complete workflow action execution.
       */
      ForkJoinPool.commonPool().execute(() -> composeGreetingAsync(taskToken, greeting, name));
      context.doNotCompleteOnReturn();

      // Since we have set doNotCompleteOnReturn(), the workflow action method return value is
      // ignored.
      return "ignored";
    }

    // Method that will complete action execution using the defined ActivityCompletionClient
    private void composeGreetingAsync(byte[] taskToken, String greeting, String name) {
      String result = greeting + " " + name + "!";

      // Complete our workflow activity using ActivityCompletionClient
      completionClient.complete(taskToken, result);
    }
  }

  /**
   * With our Workflow and Activities defined, we can now start execution. The main method starts
   * the worker and then the workflow.
   */
  public static void main(String[] args) throws ExecutionException, InterruptedException {

    // Get a Workflow service stub.
    WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

    /*
     * Get a Workflow service client which can be used to start, Signal, and Query Workflow
     * Executions.
     */
    WorkflowClient client = WorkflowClient.newInstance(service);

    /*
     * Define the workflow factory. It is used to create workflow workers for a specific task queue.
     */
    WorkerFactory factory = WorkerFactory.newInstance(client);

    /*
     * Define the workflow worker. Workflow workers listen to a defined task queue and process
     * workflows and activities.
     */
    Worker worker = factory.newWorker(TASK_QUEUE);

    /*
     * Register our Workflow Types with the Worker. Workflow Types must be known to the Worker at
     * runtime in order for it to poll for Workflow Tasks.
     */
    worker.registerWorkflowImplementationTypes(GreetingWorkflowImpl.class);

    /*
     * Register our Activity Types with the Worker. Since Activities are stateless and thread-safe,
     * the Activity Type is a shared instance.
     */
    ActivityCompletionClient completionClient = client.newActivityCompletionClient();
    worker.registerActivitiesImplementations(new GreetingActivitiesImpl(completionClient));

    /*
     * Start all the Workers registered for a specific Task Queue. The Workers then start polling
     * for Workflow Tasks and Activity Tasks.
     */
    factory.start();

    // Create the workflow client stub. It is used to start our workflow execution.
    GreetingWorkflow workflow = client.newWorkflowStub(
      GreetingWorkflow.class,
      WorkflowOptions.newBuilder()
        .setWorkflowId(WORKFLOW_ID)
        .setTaskQueue(TASK_QUEUE)
        .build());

    /*
     * Here we use {@link io.temporal.client.WorkflowClient} to execute our workflow asynchronously.
     * It gives us back a {@link java.util.concurrent.CompletableFuture}. We can then call its get
     * method to block and wait until a result is available.
     */
    CompletableFuture<String> greeting = WorkflowClient.execute(workflow::getGreeting, "World");

    // Wait for workflow execution to complete and display its results.
    System.out.println(greeting.get());
    System.exit(0);
  }
}
```

### Retrieving the Result

The Workflow does not execute the Activity. That is, it does not invoke the Activity Function. Instead, it makes a request to the Temporal Cluster, asking it to **schedule** execution of the Activity.

With the synchronous approach, requesting Activity Execution and accessing the result it produces are done in the same statement.

With asynchronous Activity Execution, you write separate statements to perform each operation. The call to `Async.function` returns a `Promise`, since the result returned by the Activity won't be available until the Activity has completed.

- To access the value from this `Promise`, you must first define a variable of the type corresponding to the value.
- Next, you will call the `get` function on the variable used to store the `Promise`.
- Be sure to check for an error before attempting to use the result, as this variable will not be assigned the value if the Activity Execution failed.

```java
String greeting;

try {
  greeting = hello.get();
} catch(RuntimeExeption e) {
  // handle the failure as dictated by your business logic
}
```

# Using Appropriate Timeouts

Common pitfall: Copying Workflow or Activity code and forgetting to change the Timeout values to match their actual use cases

```java
// Start-to-Close Timeout should be set a little longer than the maximum
// length of time you expect for the Activity to complete successfully
ActivityOptions options = ActivityOptions.newBuilder()
  .setStartToCloseTimeout(Duration.ofSeconds(5))
  .setRetryOptions(retryOptions)
  .build();

private final MyActivities activities = Workflow.newActivityStub(MyActivities.class, options);

// Somewhere in a Workflow
String spanishGreeting = activities.myActivity(input);
```

However, if you change the Activity code so that it calls a remote service, processes a file, or queries a database, your executions will take considerably longer. If you don't update the value to something greater than the expected execution time, then there's a good chance that the Activities will time out.

While specifying a Start-to-Close Timeout that is too short for the execution of your Activity is a problem, you should also avoid one that is too long. The Start-to-Close Timeout is one way Temporal detects a Worker crash, so an excessively long value wastes time by delaying the detection and recovery, ultimately reducing throughput. The Start-to-Close Timeout should be set to slightly longer than the slowest successful execution you expect for the Activity.

# How Temporal Handles Activity Failure

Activity method signatures should NOT include checked exceptions.

If your Activity implementation calls code that throws a checked exception, we recommend using the `Activity.wrap` method to re-throw it.

- This converts it to a Temporal-specific unchecked exception and the original exception can be retrieved (if needed) by calling its `getCause()` method.

There is NO need to use the `Activity.wrap` method to re-throw unchecked exceptions, although it is safe to do so if you wish.

Here is an example of catching a checked exception and wrapping it:

```java
try {
  data = readData(dataFilePath);
} catch (IOException e) {
  throw Activity.wrap(e);
}
```

## Default Behavior

Temporal's default behavior is to automatically retry an Activity, with a short delay between each attempt, until it either succeeds or is canceled.

- That means that intermittent failures require NO action on developers part.
- When a subsequent request succeeds, your code will resume as if the failure never occurred.
- However, that behavior may not always be desirable, so Temporal allows you to customize it through a custom Retry Policy.

### Changing the Timing and Number of Retry Attempts

Four properties that determine the timing and number of retries:

| Property           | Description                                       | Default Value           |
| ------------------ | ------------------------------------------------- | ----------------------- |
| InitialInterval    | Duration before the first retry                   | `1` second              |
| BackoffCoefficient | Multiplier used for subsequent retries            | `2.0`                   |
| MaximumInterval    | Maximum duration between retries                  | `100 * InitialInterval` |
| MaximumAttempts    | Maximum number of retry attempts before giving up | `0` (unlimited)         |

- The `InitialInterval` property defines how long after the initial failure the first retry will occur. By default, that's one second.
- The `BackoffCoefficient` is a multiplier, applied to the InitialInterval value, that's used to calculate the delay between each subsequent attempt. Assuming that you use the defaults for both properties, that means there will be a retry after 1 second, another after 2 seconds, then 4 seconds, 8 seconds and so on.
- The `MaximumInterval` puts a limit on that delay, and by default it's 100 times the initial interval, which means that the delays would keep doubling as described, but would never exceed 100 seconds.
- The `MaximumAttempts` specified the maximum count of retries allowed before marking the Activity as failed, in which case the Workflow can handle the failure according to its business logic.

# Activity Retry Policy Example

The image below shows an annotated example of a custom `RetryPolicy.`

There are three steps to using a custom RetryPolicy to control how Activity failure is handled in your Workflow:

1. Import the `io.temporal.common.RetryOptions;` package
2. Specify values for one or more properties, such as `InitialInterval` or `BackoffCoefficient`
3. Associate your policy with the ActivityOptions used with your Activity

![](https://learn.temporal.io/courses/temporal-101/java/chapter_08/retry-policy-example.png)
