# Table of Contents

- [Table of Contents](#table-of-contents)
- [Durable Execution System](#durable-execution-system)
  - [What is a Durable Execution System?](#what-is-a-durable-execution-system)
- [How Errors Affect Workflow Execution](#how-errors-affect-workflow-execution)
  - [Activity Errors](#activity-errors)
- [Workflow Errors](#workflow-errors)
  - [`Workflow Task Failures`](#workflow-task-failures)
  - [`Workflow Execution Failures`](#workflow-execution-failures)
  - [How to Throw Exceptions from Application Code](#how-to-throw-exceptions-from-application-code)
- [Backwards-Compatible Evolution of Input Parameters and Return Values](#backwards-compatible-evolution-of-input-parameters-and-return-values)
  - [Example: Using a Class as Activity Input](#example-using-a-class-as-activity-input)
    - [Example: Using Classes for Data](#example-using-classes-for-data)
- [Task Queue Names](#task-queue-names)
- [Running Multiple Worker Processes](#running-multiple-worker-processes)
- [Choosing Workflow IDs](#choosing-workflow-ids)
  - [How Temporal Handles a Workflow ID Conflict](#how-temporal-handles-a-workflow-id-conflict)
- [Workflow ID Reuse Policy and Retention Period](#workflow-id-reuse-policy-and-retention-period)
  - [Retention Period](#retention-period)
  - [Retention Periods Do Not Affect Open Workflows](#retention-periods-do-not-affect-open-workflows)
- [Logging in Workflows and Activities](#logging-in-workflows-and-activities)
  - [Configuring the Logger](#configuring-the-logger)
  - [Using the Logger](#using-the-logger)
- [Accessing Results](#accessing-results)
  - [Synchronous Invocations](#synchronous-invocations)
    - [Requesting Workflow Execution](#requesting-workflow-execution)
    - [Requesting Activity Execution](#requesting-activity-execution)
  - [Asynchronous Workflow Invocations](#asynchronous-workflow-invocations)
  - [Asynchronous Activity Invocations](#asynchronous-activity-invocations)
  - [Waiting on Execution Results](#waiting-on-execution-results)
  - [Deferring Access to Execution Results](#deferring-access-to-execution-results)
- [Temporal Timers](#temporal-timers)
  - [What is a Timer?](#what-is-a-timer)
  - [Use Cases for Timers](#use-cases-for-timers)
  - [Timer APIs Provided by the Java SDK](#timer-apis-provided-by-the-java-sdk)
  - [Pausing Workflow Execution for a Specified Duration](#pausing-workflow-execution-for-a-specified-duration)
  - [Running Code at a Specific Point in the Future](#running-code-at-a-specific-point-in-the-future)
  - [What Happens to a Timer if the Worker Crashes?](#what-happens-to-a-timer-if-the-worker-crashes)
- [Workflow Execution Overview](#workflow-execution-overview)
  - [Workflow Execution States](#workflow-execution-states)
    - [Open State](#open-state)
    - [Closed State](#closed-state)
- [How Workflow Code Maps to Commands](#how-workflow-code-maps-to-commands)
- [Overview of Event History](#overview-of-event-history)
  - [Event History Content](#event-history-content)
  - [Protecting Confidential Data](#protecting-confidential-data)
- [Event History Limits](#event-history-limits)
  - [Event History Item Count](#event-history-item-count)
  - [Event History Size](#event-history-size)
- [Event Structure and Attributes](#event-structure-and-attributes)
  - [Attributes Vary by Event Type](#attributes-vary-by-event-type)
- [How Commands Map to Events](#how-commands-map-to-events)
- [Workflow and Activity Task States](#workflow-and-activity-task-states)
- [Sticky Execution](#sticky-execution)
  - [How Sticky Execution Works](#how-sticky-execution-works)
- [History Replay: How Temporal Provides Durable Execution](#history-replay-how-temporal-provides-durable-execution)

# Durable Execution System

## What is a Durable Execution System?

A durable execution system ensures that the code in your application runs reliably and correctly, even in the face of adversity.

- It maintains state, allowing your code to automatically recover from failure, regardless of whether that failure was caused by a small problem, such as a network timeout, or a big one, such as a kernel panic on a production application server.

# How Errors Affect Workflow Execution

## Activity Errors

Recall that Activities are useful to encapsulate parts of the Workflow that are prone to failure.

- For example, you might use an Activity to query a database.
- The database server might reject your credentials or be offline when you open a connection, or there might be a syntax error in your SQL when you issue the query.

If your Activity throws an exception, the Temporal Cluster will deem that execution attempt as failed.

- Every Activity is associated with a Retry Policy, either one you define or the default policy, which governs how any subsequent retries will be performed.
- It should be noted that while retrying an Activity is the default, there are ways to specify that a failed Activity should not be retried, such as by specifying one or more exception types in a call to the `setDoNotRetry` method when creating your `RetryPolicy`.
- If Activity execution fails with any of the exception you listed, it will not be retried.

When using the default Retry Policy, Temporal automatically retries the Activity using an exponential backoff.

- After the initial failure, it waits one second before the first retry, and if that attempt also fails, doubles this delay (up to a maximum of 100 seconds) during each subsequent attempt.
- It will continue retrying until execution of the Activity succeeds, is canceled, or times out.

This means that intermittent problems, such as temporary outages, are handled automatically upon retry. - Other problems, such as incorrect credentials or invalid SQL query syntax, can be repaired manually by changing the Activity code itself.

- Once the change is deployed, execution will succeed during a subsequent attempt.

You can change the retry behavior by specifying a custom Retry Policy (`RetryOptions`), and passing it to an `ActivityOptions` object.

- You will use this `ActivityOptions` object when registering your Activities to your Workflow.
- You can create multiple instances of your Activities using various `RetryOptions`, allowing you to execute activities with varying Retry Policies, giving you the flexibility needed to implement your business logic.

Given that an Activity may be retried, a single call to an Activity Method can result in your Activity code being executed more than once.

- We recommend that you ensure your Activity code is idempotent; that is, ensure that any change in state resulting from the execution of that Activity is identical to the state that would result from it being retried one or more times.

# Workflow Errors

In contrast, Workflows are NOT associated with a Retry Policy by default.

- Although it is possible to associate a Workflow Execution with a Retry Policy, it is unusual to do so. - If a Workflow throws an exception, it will either be retried, or marked as failed.
- This is dependent on whether the exception is a `Workflow Task Failure` or a `Workflow Execution Failure`

## `Workflow Task Failures`

A `Workflow Task Failure` is an exception that is thrown when the Workflow code throws an exception that does NOT extend `TemporalFailure`.

- This will cause the Workflow to be retried.
- If you were to throw a custom or typical Java-based exception (example: IOError) in your Workflow this is the type of exception you would get.

## `Workflow Execution Failures`

A `Workflow Execution Failure` is an exception that is thrown when the Workflow code throws an exception that extends `TemporalFailure` or one of its child classes.

- Workflow Execution Failures put the Workflow Execution into the "Failed" state and no more attempts will be made in progressing this execution.
- If you are creating custom exceptions or raising typical Java-based exceptions you would either need to extend the `TemporalFailure` class or explicitly state that this exception is a Workflow Execution Failure by throwing a new `ApplicationFailure`.

Example:

```java
if (isDelivery && (distance.getKilometers() > 25)) {
  throw ApplicationFailure.newFailure("Customer lives outside the service area",
    OutOfServiceAreaException.class.getName());
}
```

## How to Throw Exceptions from Application Code

Just as you would in other applications you develop, you can thrown an exception when encountering an adverse or unexpected condition in your Workflow or Activity Definition.

Example: an Activity that makes a request to a Web server would throw an exception if the request failed.

```java
BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))
String line;
while ((line = in.readLine()) != null) {
  builder.append(line);
}
```

In the above example, you'd have to either catch the potential `IOException` or specify in the method header that this type of exception could be thrown.

Exceptions thrown by application code, like the ones shown above, are automatically converted into an language-neutral format by the Temporal Worker, `ApplicationFailure`. When the above activity throws the `IOException`, the Workflow will receive an `ActivityFailure` with an `ApplicationFailure` whose type will be `java.io.IOException` with the message and stack trace copied to it. It is important to note that the caller of this code would receive the resulting `ApplicationFailure` and not the original exception object.

In order to prevent you from having to explicitly define checked exceptions on your Activity or Workflow Methods, the Temporal Java SDK provides a way to wrap exceptions and rethrow them as an `ActivityFailure`

```java
try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
  String line;
  while ((line = in.readLine()) != null) {
    builder.append(line);
  }
} catch (IOException e) {
  throw Activity.wrap(e);
}
```

The automatic wrapping of exceptions is one of the things that makes it possible to have different parts of the application implemented using different SDKs, any of which might use a different language than Temporal itself. For example, you might use a TypeScript client to execute a Workflow written in Go, which calls one Activity written in Python and another in Java. Each of the languages has both a different philosophy and different implementation for handling errors, so Temporal's approach enables interoperability between them and enables the Temporal Cluster to serialize the error details in a consistent manner.

# Backwards-Compatible Evolution of Input Parameters and Return Values

Using classes to represent both the input parameters you pass to them and the results they return.

Workflows and Activities can accept any number of input parameters. In either case, changing the number, position, or type of these parameters will break backwards compatibility with existing executions.

For this reason, it is considered a **best practice to encapsulate all input parameters into a single class, which is passed as input to the Workflow or Activity**, rather than passing a series of individual parameters to these methods.

- This allows you to change the composition of the class without changing the signature of those methods.
- This is also the recommended approach for values returned from Workflows and Activities.

## Example: Using a Class as Activity Input

Consider the "Hello World" scenario presented in Temporal 101, which had an Activity that called a microservice to retrieve a greeting in Spanish. This method took a string (containing a person's name) as input and returned a string (containing the customized greeting in Spanish) as output:

```java
// This Activity returns a customized greeting in English, using the provided name
@Override
public String greetInSpanish(String name) {
  //...
}
```

Although this certainly works, it is NOT the best approach for something you plan to deploy to production and maintain over time.

- Imagine that you are later presented with the requirement to support greetings in other languages, such as German or Zulu.
- If you add another input parameter to the Activity, you change the signature of that method, which affects its compatibility with ongoing executions of that Activity.
- However, this would not be a problem if you had specified a single class as the input parameter, because you could add the new language code field to the class without affecting the method signature.

```java
public class GreetingInput {
  private String name;
  private String languageCode;

  // Default constructor omitted for brevity
  public GreetingInput(String name, String languageCode) {
    this.name = name;
    this.languageCode = languageCode;
  }
  // Getters and Setters omitted for brevity
}
```

```java
public class GreetingOutput {
  private String greeting;

  // Default constructor omitted for brevity
  public GreetingOutput(String greeting) {
    this.greeting = greeting;

  }
  // Getters and Setters omitted for brevity
}
```

```java
public class GreetingActivitiesImpl implements GreetingActivities {

  // Specify these types for the input parameter and return value of the Activity
  public GreetingOutput greetSomeone( GreetingInput input) {

    // An example to show how to access input parameters and create the return value
    if (input.getLanguageCode().equals("fr")) {
      String bonjour = "Bonjour, " + input.getName();
      return new GreetingOutput(bonjour);
    }

    // support for additional languages would follow...
  }
}
```

- This code example illustrates a better design for this Activity.
- It begins by defining a class that represents input to this Activity, which includes the original name but also the new language code field.
- It then defines another class, which represents the output returned by the Activity method.
- It just contains the greeting for now, but you could update this as requirements change in the future.
- Finally, the Activity method itself has been updated to use these class instead of the strings it had previously used.

While the initial move from strings to a class is not a backward compatible change, making that change as early as possible will ensure that the code is better able to handle future evolution of the input or output data.

### Example: Using Classes for Data

See [samples/using-classes-for-data repository](https://github.com/temporalio/samples-java)

# Task Queue Names

The Temporal Cluster maintains a set of Task Queues, which Workers poll to see what work needs to be done.

- Each Task Queue is identified by a name, which is provided to the Temporal Cluster when launching a Workflow Execution.
- In this example, the value is included in the options supplied by the `setTaskQueue` method to the `WorkflowOptions` Builder.

Excerpt of code used to start the Workflow:

```java
WorkflowOptions options = WorkflowOptions.newBuilder()
  .setWorkflowId("my-workflow")
  .setTaskQueue("my-task-queue-name")
  .build();

MyWorkflow workflow = client.newWorkflowStub(MyWorkflow.class, options);
```

Excerpt of code used to configure the Worker:

```java
Worker worker = factory.newWorker("my-task-queue-name");
```

Since Task Queues are created dynamically when they are first used, a mismatch between these two values does not result in an error.

- Instead, it will result in the creation of two different Task Queues.
- Consequently, the Worker will not receive any tasks from the Temporal Cluster and the Workflow Execution will not progress.
- Therefore, we **recommend that you define the Task Queue name in a constant that is referenced by the Client and Worker to ensure that they always use the same value**.

Excerpt of code used to define a constant with the Task Queue name:

```java
package app;

public class Constants {

  public static final String taskQueueName = "my-task-queue-name";
}
```

Excerpt of code used to start the Workflow, referencing the constant defined with the Task Queue name:

```java
WorkflowOptions options = WorkflowOptions.newBuilder()
  .setWorkflowId("my-workflow")
  .setTaskQueue(Constants.taskQueueName)
  .build();

MyWorkflow workflow = client.newWorkflowStub(MyWorkflow.class, options);
```

Excerpt of code used to configure the Worker, referencing the constant defined with the Task Queue name:

```java
Worker worker = factory.newWorker(Constants.taskQueueName);
```

However, it's not always possible to do this, such as when the Client used to start the Workflow is running on another system or is implemented in a different programming language.

# Running Multiple Worker Processes

**We recommend running at least two Worker Processes for each Task Queue in a production application, each running on a separate host.**

This eliminates the Worker as a single point of failure, because if there are two Worker Processes and one of them crashes, the remaining Worker will recover any executions that were in progress and will continue to handle new ones, too.

- Running additional Worker Processes will further increase the scalability and availability of your application.

# Choosing Workflow IDs

When starting a Workflow, you specify a Workflow ID that is associated with that execution.

- A Workflow ID is intended to be meaningful for your business logic.
- For example, an order processing Workflow might use a Workflow ID that includes the order number (e.g., `process-order-number-90743812`), while a Workflow that manages the loan that a bank has made to one of their customers might include the account number (e.g., `manage-loan-account-28430614`).

```java
// Example: An order processing Workflow might include order number in the Workflow ID
WorkflowOptions options = WorkflowOptions.newBuilder()
  .setWorkflowId("process-order-number-" + orderInfo.OrderNumber)
  .setTaskQueue(Constants.taskQueueName)
  .build();

ProcessOrderWorkflow workflow = client.newWorkflowStub(ProcessOrderWorkflow.class, options);

// Workflow processOrder defined elsewhere
workflow.processOrder(orderInfo)
```

Temporal guarantees that there can only be a single Workflow Execution with a given Workflow ID running within a Namespace at any point in time (a Namespace is a logical unit of isolation, often used to separate Workflows running on the same cluster but owned by different teams).

This constraint applies to Workflow Executions of any type within that Namespace, not just those of the same type.

- For example, an execution of the order processing Workflow cannot use the same Workflow ID currently used by a running execution of the loan management Workflow.
- This is an important consideration when choosing a Workflow ID value.

## How Temporal Handles a Workflow ID Conflict

In the Java SDK, an attempt to start a Workflow Execution while one with the same Workflow ID is already running is effectively ignored.

- Rather than start a new Workflow Execution, it will return the information associated with the one that is already running, although you can configure `WorkflowOptions` to instead return an error in this case.

# Workflow ID Reuse Policy and Retention Period

As you've just learned, Temporal guarantees that there can only be a single Workflow Execution with a given Workflow ID running within a Namespace at any point in time. Temporal allows you to further constrain the uniqueness of the Workflow ID within the Namespace by specifying a Workflow ID Reuse Policy when you start a Workflow. This policy allows for one of four options that govern whether the Workflow ID can be reused:

| Workflow Reuse Policy                                  | Explanation                                                                                                                                                                                                                                                                                       |
| ------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `WORKFLOW_ID_REUSE_POLICY_ALLOW_DUPLICATE`             | This is the default, which allows the Workflow ID to be reused by another Workflow Execution in the same Namespace upon the conclusion of the current one, regardless of whether that resulted in success or failure.                                                                             |
| `WORKFLOW_ID_REUSE_POLICY_ALLOW_DUPLICATE_FAILED_ONLY` | This policy is similar to the default, but only allows the Workflow ID to be reused if the Workflow - Execution that used it did not complete successfully.                                                                                                                                       |
| `WORKFLOW_ID_REUSE_POLICY_REJECT_DUPLICATE`            | This policy does not allow the Workflow ID to be reused at all, regardless of how the previous one ended.                                                                                                                                                                                         |
| `WORKFLOW_ID_REUSE_POLICY_TERMINATE_IF_RUNNING`        | This policy is similar to the default, with one important difference: It terminates the Workflow Execution currently using the specified Workflow ID, if there is one. This ensures that the new Workflow Execution will be the only one running in the Namespace with the specified Workflow ID. |

- Specifying a Workflow ID Reuse Policy

You can specify the Workflow ID Reuse Policy through the SDK, or you can use a command-line option to specify one when using temporal to start the Workflow.

Le`t's look at an example of how you can specify the Workflow ID Reuse Policy when starting a Workflow using the APIs provided by the Java SDK.

There are two steps. The first is to add the following statement to your import section which allows you to reference the policy options by name:

```java
package app;

// The following import is needed to reference the Workflow ID Reuse Policy value
import io.temporal.api.enums.v1.WorkflowIdReusePolicy;
// other imports removed for brevity
```

The second step is to include the WorkflowIDReusePolicy attribute in the options used to start the Workflow Execution:

```java
// Example: An order processing Workflow might include order number in the Workflow ID
WorkflowOptions options = WorkflowOptions.newBuilder()
  .setWorkflowId("example-workflow-id")
  .setTaskQueue(Constants.taskQueueName)
  .setWorkflowIdReusePolicy(WorkflowIdReusePolicy.WORKFLOW_ID_REUSE_POLICY_ALLOW_DUPLICATE_FAILED_ONLY)
  .build();

MyWorkflow workflow = client.newWorkflowStub(MyWorkflow.class, options);
// additional code would follow
```

This example overrides the default policy and specifies that the Workflow ID can be reused for the new execution only if the previous one came to an unsuccessful conclusion.

## Retention Period

One thing to keep in mind if you specify a more restrictive Workflow ID Reuse Policy is that Temporal can only enforce uniqueness based on the Workflow Executions for which it still has data.

- In order to maintain good performance and conserve storage space used by the cluster's database, data associated with past Workflow Executions is eventually deleted.
- This duration between when a Workflow Execution has finished and when it is eligible for automatic deletion is known as the Retention Period.
- **It typically has a value between 1 and 30 days**.
- Although it may be possible to specify a longer retention period if you're running a recent version of the Temporal Cluster software, this is generally discouraged because it can increase storage requirements and may diminish performance.

Some users are subject to compliance regulations or other requirements that mandate the ability to determine what took place during a Workflow Execution several months or even years after it concluded.

- Increasing the retention period may seem like an attractive solution for these use cases, but Temporal provides an alternative solution.

Self-hosted Temporal clusters provide the Archival feature.

- When Archival is enabled, data associated with a Workflow Execution is automatically copied to an appropriate long-term storage system (such as a local filesystem or Amazon S3) before being deleted after the Retention Period is reached.

Temporal Cloud provides a similar feature, known as Export.

- After Export is initially configured, it will export history data from your namespace to S3 on an hourly basis.

## Retention Periods Do Not Affect Open Workflows

Be sure to note that the countdown for the Retention Period only begins once the Workflow Execution finishes.

- The Retention Period does NOT affect Workflow Executions that are currently running, so a five-day retention period won't cause any problems for a Workflow Execution that runs for 10 years.
- Data associated with a running Workflow Execution is always available, regardless of how long that execution runs.

# Logging in Workflows and Activities

The Temporal Java SDK provides an slf4j compatible logging implementation that is safe to use in your code.

Why not use a third-party logging package directly in your code?

- Temporal provides durable execution of your Workflow, which it achieves through a process known as History Replay. You'll learn how this works later in the course, but the synopsis is that a Temporal Worker recovers the state of the Workflow by safely re-executing the Workflow Definition. By using Temporal's logging API, the Worker is able to suppress these log messages during replay so that log statements from the original execution aren't duplicated by the re-execution.

The SDK's Logger implementation defines a method corresponding to each of four log levels, which are similar to those you may have used in other logging packages. From least to most important, those levels are: debug, info, warn, and error.

## Configuring the Logger

For this course we will use slf4j and logback for our logger. To do so include the following dependency in your pom.xml.

```xml
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.4.8</version>
</dependency>
```

This logback dependency will bring in all necessary slf4j dependencies as well.

You will also need to provide a logback.xml configuration to format the output and log level of your logs. For the sake of this course we'll use a configuration with a more limited scope. For more information about available tags visit the [logger documentation](https://www.javadoc.io/doc/io.temporal/temporal-sdk/latest/io/temporal/internal/logging/LoggerTag.html)

```xml
<configuration>
  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <!-- encoders are assigned the type
            ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
    <encoder>
      <!-- WorkflowId and ActivityId are keys populated by JavaSDK into MDC context -->
      <!-- See io.temporal.internal.logging.LoggerTag for a full list of keys -->
      <pattern>%d{HH:mm:ss.SSS} %-5level - %msg %n</pattern>
    </encoder>
  </appender>
  <logger name="io.grpc.netty" level="INFO" />
  <root level="INFO">
    <appender-ref ref="STDOUT" />
  </root>
</configuration>
```

## Using the Logger

You can access a logger by calling the `Workflow.getLogger` method in your Workflow Definition.

- This method takes a single parameter, which can either be a string or a class object, that will help you identify messages produced by this logger.
- This is typically done within your Workflow class implementation as an instance variable, making the logger available to all methods.
- To log information, call a method on the logger that corresponds to one of the four log levels, passing in the string that you want to log.

```java
public static final Logger logger = Workflow.getLogger(TranslationWorkflowImpl.class);

logger.debug("Preparing to execute an Activity")
logger.info("Calculated cost of order. Tax {}, Total {}", tax, total)
```

# Accessing Results

Because Temporal guarantees the durable execution of your Workflow code, you can reliably run Workflows that last for many months or years. The individual Activities that are part of those Workflow Executions may also run for very long periods of time.

Temporal's design supports this by making these executions asynchronous to the code that initiated them. For example, a program invoking a Workflow or Activity Method does not actually execute those things; instead, these calls submit a request to the cluster to execute them.

The benefits of these types of calls are that they are non-blocking calls, so the flow of control continues with the next statement without having to wait on the Workflow or Activity Execution.

## Synchronous Invocations

So far in this course and Temporal 101 we have demonstrated Workflows and Activities using blocking calls.

The following calls submit execution requests to the cluster:

### Requesting Workflow Execution

```java
// Use a client to request Workflow Execution
GreetingWorkflow workflow = client.newWorkflowStub(GreetingWorkflow.class, options);
String greeting = workflow.greetSomeone(name);
```

### Requesting Activity Execution

```java
// Request Activity Execution from within a Workflow
String spanishGreeting = activities.greetInSpanish(name);
```

These are blocking calls, which means the program will halt and await their completion before proceeding.

## Asynchronous Workflow Invocations

In the Temporal Java SDK you would use a `CompleteableFuture` to invoke a Workflow asynchronously.

```java
import java.util.concurrent.CompletableFuture;
import io.temporal.client.WorkflowClient;

...
// Options defining code omitted for brevity
GreetingWorkflow workflow = client.newWorkflowStub(GreetingWorkflow.class, options);

// Workflow will be started at this point but the call doesn't block.
CompletableFuture<String> greeting = WorkflowClient.execute(workflow::greetSomeone, "World");

// This line will block, waiting on the result from the Workflow.
String result = greeting.get();
```

## Asynchronous Activity Invocations

In the Temporal Java SDK you would use a Temporal-defined class called a [`Promise`](https://www.javadoc.io/doc/io.temporal/temporal-sdk/latest/io/temporal/workflow/Promise.html), for invoking Activities asynchronously.

- A `Promise` can only be used inside Temporal Workflow code and was designed for handling the execution of asynchronous activities.

```java
import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;

...

private final GreetingActivities activities = Workflow.newActivityStub(GreetingActivities.class, options);
...

Promise<String> hello = Async.function(activities::greetInSpanish, name);
Promise<String> bye = Async.function(activities::farewellInSpanish, name);
```

## Waiting on Execution Results

In most cases, the code that initiated the execution will eventually want to retrieve the result returned by that execution.

- Since those calls must return something immediately, yet the result won't be available until the execution is finished, the Java SDK returns a Promise that provides access to the result of an asynchronous execution.
- You will call `get()` to retrieve the value, which will block until the result becomes available at the end of execution.

```java
Promise<String> hello = Async.function(activities::greetInSpanish, name);
String result = hello.get();
```

The call to get on the Promise returned by the first line will block until execution is complete.

## Deferring Access to Execution Results

If you need to execute several Activities independently from one another, then you may be able to significantly reduce the overall execution time of the Workflow by separating the execution requests from the retrieval of the results.

- Assuming that your Workers and the downstream systems used in your Activities have sufficient capacity, this will execute the Activities in parallel.

```java
Promise<String> hello = Async.function(activities::greetInSpanish, name);
Promise<String> goodbye = Async.function(activities::farewellInSpanish, name);
Promise<String> thanks = Async.function(activities::thankInSpanish, name);

// The following lines block until their respective executions have finished

String helloResult = hello.get();
String goodbyeResult = goodbye.get();
String thanksResult = thanks.get();
```

If each of the three Activities shown here runs for a similar length of time, then this approach would make the Workflow roughly three times faster than waiting to retrieve the results of one Activity before requesting execution of the next one.

This is a good strategy when a Workflow needs to call unrelated Activities.

# Temporal Timers

## What is a Timer?

Durable Timers are one of the features provided by Temporal and are used to introduce delays in a Workflow Execution.

- When a Timer is set, the execution of code awaiting that timer will block until the Timer fires.
- Timers are maintained by the Temporal Cluster and the Worker does not consume resources while awaiting them.

The duration of a Timer is fixed and can range from one second to several years.

- Although it is possible to specify a duration of less than one second, you should avoid doing so because the networking latency involved with roundtrips between the Worker and Temporal Cluster will affect the precision of Timers with sub-second durations.

## Use Cases for Timers

There are several reasons that you might want to introduce delays in a Workflow Execution.

One is that your business logic dictates that you execute an Activity at fixed intervals.

- For example, a Workflow used for customer onboarding might send e-mail reminders one day, one week, and/or one month after they sign up.

Another is that you need to execute an Activity multiple times at intervals that are dynamically calculated.

- In this case, you might delay calling one Activity based on the value returned by a previous Activity.

Yet another reason is that you need to allow time for offline steps to complete before proceeding.

- For example, a business process may require a fixed period of time to elapse before the next task can begin.

## Timer APIs Provided by the Java SDK

The Java SDK offers two ways of starting a Timer, both synchronous and asynchronous.

- Both of these are Workflow-safe, replay-aware, and provide similar functionality you may be familiar with if you've used `Thread.sleep` or `java.util.Timer`.
- Note: You should NOT/NEVER use these, which will very likely result in a `WorkflowTaskTimedOut` error.

## Pausing Workflow Execution for a Specified Duration

Use the `Workflow.sleep` function if you need to pause further execution of the Workflow for a specific duration:

```java
import java.time.Duration;
import io.temporal.workflow.Workflow;

// This will pause Workflow Execution for 10 seconds
Workflow.sleep(Duration.ofSeconds(10));
```

This is a Workflow-safe replacement for Java's `Thread.sleep` method and takes one input parameters, the duration for which to sleep.

- Calling this method blocks until the Timer fires (or is canceled).

## Running Code at a Specific Point in the Future

Use the `Workflow.newTimer` method if you need to run code at a specific point in the future.

```java
import java.time.Duration;
import io.temporal.workflow.Workflow;

// Workflow.newTimer is a Workflow-safe counterpart to java.util.Timer
Promise timerPromise = Workflow.newTimer(Duration.ofSeconds(30));
logger.info("The timer was set");

// Unlike Workflow.sleep, waiting for the timer is a separate operation
timerPromise.get();
logger.Info("The timer has fired");
```

This is a Workflow-safe replacement for Java's `java.util.Timer` class.

- It takes the duration to wait as a parameter, the same two input parameters as Workflow.sleep, but unlike that method, calling it does not block after setting the Timer.
- Instead, it returns a Promise, which becomes ready when the Timer fires (or is canceled).
- Waiting on that Promise will block until it becomes ready.

## What Happens to a Timer if the Worker Crashes?

Timers are durable and are maintained by the Temporal Cluster.

- When the Worker encounters either a `Workflow.sleep` or `Workflow.newTimer` call in the Workflow code, it submits a request to the cluster, asking it to start a Timer for the specified duration.
- When the Timer fires, the cluster adds a new Workflow Task to the Task Queue, after which the Worker resumes execution of the Workflow.

Note: The Temporal cluster fires the Timer after the specified duration, regardless of whether or not any Workers happen to be running at the time.

To better understand the behavior of a Timer in the event of a Worker crash, consider the following scenario: Your Workflow code uses `Workflow.sleep` to set a Timer for 10 seconds and you have a single Worker process, which happens to crash 3 seconds later.

- If you restart the Worker process 2 seconds later, then Workflow Execution will pause for the remaining 5 seconds of the Timer, and it will be as if it had never crashed at all
- However, if you started it 20 minutes later, then the Timer will have already fired, and the Worker will resume execution of the remaining Workflow code without additional delay

**Since Timers are maintained by the Temporal Cluster, they fire regardless of whether any Workers are running**.

- However, Workers can experience potentially long outages (due to a crash or system maintenance)
- Therefore, Workflow code should be robust to account for the possibility that a Timer takes longer than the specified duration.

# Workflow Execution Overview

TODO: Get image from https://youtu.be/mmH5OEv1l7w?si=wqI3tn1KzsSY6d32&t=31

## Workflow Execution States

1. **Open** (currently running)
2. **Closed** (stopped running, completed successfully, failed, terminated)

```sh
# One way transition
Open -> Closed
```

Every Workflow Execution has an unique `Run ID` automatically generated when it is launched

### Open State

While in `Open` state, Workflow is doing one of 2 things

1. Actively making progress
2. Awaiting something for progress to continue (i.e. awaiting activity execution return value, awaiting for timer to be fired or cancelled)

### Closed State

```
Open -> Completed
```

`Completed`: The Workflow function returned a result

```
Open -> Continued-As-New
```

`Continued-As-New`: The code is still running but any future progress will take place in a new workflow execution and event history

- Note: The reason for this is because the `event history` is limited to `50,000` events and 15mb
  - So if the event history exceeds 50,000 then a new workflow execution will take place

```
Open -> Failed
```

`Failed`: The Workflow function returned an error (workflow method throws exception instead of returning a result)

```
Open -> Timed Out
```

`Timed Out`: Time limit associated with Workflow execution elapsed before the workflow method returned a result or threw an exception

```
Open -> Terminated
```

`Terminated`: Terminated from code, CLI or Web UI

```
Open -> Cancelled
```

`Canceled`: Graceful version of termination because workflows and activities can be notified of cancellation and perform cleanup before exiting

TODO: Get image from https://youtu.be/mmH5OEv1l7w?si=n1dOAP-4Zy0tHUgN&t=237

# How Workflow Code Maps to Commands

A Workflow = A sequence of steps

Steps that are internal to the Workflow and do NOT involve interaction with the Temporal Cluster

- Setting configuration parameters
- Performing calculations
- Evaluating variables or expressions
- Populating data structures

Steps that do involve interaction with the Temporal cluster

- Executing an Activity
- Setting a Timer
- Throwing an exception from the Workflow
- Returning a value from the Workflow

# Overview of Event History

Every Workflow Execution has an `Event History` associated with it, which represents the single source of truth for what transpired during that execution.

- Since the Temporal Cluster maintains this history, appending new Events based on requests from Clients and Workers, this history represents the Temporal Cluster's perspective about what happened during Workflow Execution.

Event Histories are persisted to the database used by the Temporal Cluster, so they're durable, and will even survive a crash of the Temporal Cluster itself.

Event Histories serve two key purposes in Temporal.

1. They are essential for Temporal to provide its guarantee of durable execution, because Events in the history are used to reconstruct the state of a Workflow Execution following a Worker crash.
2. History information enables developers to investigate Workflow Executions.

- This is one of the benefits of using Temporal.
- Not only can you trace the steps followed during the execution of the code that's currently running, you can also review the steps for code that ran in the past, so you'll have insight well beyond what's available in a traditional application.

Although The Event History is stored in the cluster's database, you can access the history of a Workflow Execution from code that uses a Temporal SDK, from Temporal's command-line tool, or from the Web UI.

## Event History Content

The Event History acts as an `ordered append-only` log of Events.

In other words, all of the Events in the history are written in sequential order, with each new Event following the last one written. Once an Event is written to history, it is immutable, so neither its details nor its position within the history will change.

The first Event for any Workflow Execution that was successfully launched is always `WorkflowExecutionStarted`.

- Subsequent Events will be appended as Workflow Execution progresses, although which Events those are vary based on what's in the Workflow Definition and what happens during its execution.
- The Event History will end, meaning that the final Event is written, when the Workflow Execution closes.
- E.g., if execution is successful, the final Event will be `WorkflowExecutionCompleted`.

## Protecting Confidential Data

As you've learned, neither Temporal Cluster nor Temporal Cloud have access to your code or the data processed inside your Workflows and Activities.

However, **in order to recreate the state of a Workflow following a crash, they store the Event History associated with the execution, which includes values passed as input and returned as output from both Workflows and Activities.**

- In some cases, these may contain confidential information, such as medical or financial data.
- Temporal supports the use of TLS (Transport Layer Security) to provide end-to-end encryption to protect this data as it is transmitted between a Client and Frontend, as well as between different services within the Temporal Cluster.
- However, a common question asked by people new to Temporal is how to protect confidential data stored by the Temporal Cluster.

Although storing this data is critical to how Temporal operates, it's actually the Workers that interpret it.

- Applications can protect the confidentiality of this information by creating a custom Codec that encrypts data as it's sent to the Temporal Cluster or Temporal Cloud, so that it's stored in encrypted form.
- The Data Encoder will then decrypt the information it receives from Temporal Cluster or Cloud, thereby ensuring that it's only readable within the application itself.

[The Security section of our documentation provides more information on these topics.](https://docs.temporal.io/self-hosted-guide/data-encryption#codec-server-setup)

# Event History Limits

In order to conserve space and maintain good performance, Temporal limits both the number of Events and overall size of the Event History.

## Event History Item Count

The Temporal Cluster begins logging warnings after 10K (10,240) events and will log additional warnings as new Events are appended to the history.

- If the Event History exceeds 50K (51,200) Events, the Workflow Execution may be terminated or be `Continued-As-New`

We recommend NOT exceeding a few thousand Events in a single Workflow Execution since this should provide plenty of time to address it before the Workflow is terminated.

- There are several techniques for dealing with this, but one is to use the Continue-As-New mechanism to continue under a new Workflow Execution with a new Event History, potentially repeating this as you approach the limits again.

## Event History Size

Recall that input parameters and output values of both Workflows and Activities are stored in the Event History.

- Storing large amounts of data can lead to performance problems, so the Temporal Cluster limits both the size of the Event History and values stored within it.

**A Workflow Execution may be terminated if the size of any payload (i.e., the input passed into, or the result returned by, an Activity or Workflow) exceeds 2 MB or if the entire Event History exceeds 50 MB.**

To avoid hitting these limits, it's recommended and considered a best practice to avoid passing large amounts of data into and out of Workflows and Activities.

- A popular way of dealing with this is by using the `Claim Check pattern`, which is widely used with messaging systems such as Apache Kafka.
- Instead of passing a large amount of data into your function, you store that data external to Temporal, perhaps in a database or object storage.
- You would then pass the identifier for the data, such as the primary key or file path, into the function, and use an `Activity` to retrieve it as needed.
- If your Activity produces a large amount of data, you could use a similar approach, writing that data to an external system and returning as output an identifier that could subsequently be used to retrieve it.

# Event Structure and Attributes

Event history can contain many different types of Events, such as `WorkflowExecutionStarted` or `ActivityTaskScheduled`.

- The Temporal API currently defines more than three dozen different types of Events.

Each of these defines one or more attributes used to store information specific to that Event, such as the error associated with a failed Activity or the duration of a Timer.

- Every Event has at least three attributes in common.

1. `Event ID`, which uniquely identifies this Event within the History and also its position within the history.
2. `Event time`, which is a timestamp representing when the Event occurred.
3. `Event Type`, which specifies what kind of Event it is.

## Attributes Vary by Event Type

Events may also contain additional attributes that vary based on the Event Type.

- E.g., the `WorkflowExecutionStarted` Event contains the Workflow Type and the data provided as input at the start of execution.
- `WorkflowExecutionCompleted` Event contains the result of that execution,
- Failed Workflows will end with a `WorkflowExecutionFailed` Event that contains the error returned by that execution.

Events related to Activity execution follow a similar pattern.

- `ActivityTaskScheduled` Event contains the Activity Type and input parameters
- `ActivityTaskCompleted` Event contains the result of that execution.

Events related to Task scheduling will contain information about execution Timeouts and Retry Policies.

# How Commands Map to Events

https://youtu.be/rcVXdg0J1XA?si=piCaN60aoHketwOk&t=53

# Workflow and Activity Task States

https://www.youtube.com/watch?v=jH3GOoFqkXQ

Suffix of `"Scheduled"` indicate that a Task was added to the Task Queue (an action performed by the Temporal Cluster)

This was always the first Event in that sequence and Events that represent subsequent actions performed by the Worker follow that.

Tasks that end with the suffix `"Started"` represent the Worker dequeueing a Task, while those ending with `"Completed"` represents a Worker successfully finishing a Task

However, just as with Workflow Executions, `Activity Tasks` have closed states that represent failure, as well as success.

TODO: Get image https://youtu.be/jH3GOoFqkXQ?si=-Ch8B2mdRQUebZOa&t=39

- E.g. `Start-to-Close Timeout` is the maximum amount of time allowed for between when the Worker starts working on a task and when that Task enters the closed state (i.e. it specifies the maximum duration between step 2, when the Worker begins execution, and step 3, when execution ends.)

Let's now look at the Events corresponding to each of these states and the various ways that a Task can reach one of these closed states.

TODO: Get image https://youtu.be/jH3GOoFqkXQ?si=EOX_dQO4n9JW27rd&t=76

Here are the Events corresponding to each of those states.

- The Worker determines whether an Activity Task is completed or failed.
- If executing the code for that Task results in an error, then the Task is `failed`.
- If it runs to completion without an error, then the Task is `completed`.

**However, it is the Temporal Cluster that determines whether the Task times out, based on whether or not the Worker notified the Cluster of the result before the time period allowed for execution elapsed**.

- This is intuitive when you think about it, since a Worker crash is one reason that a Task might time out, and the Worker that had crashed wouldn't be able to report a time out.

The pattern above applies to Workflow Tasks as well.

TODO: Get image https://youtu.be/jH3GOoFqkXQ?si=ThPZ7MQ71d_cII9m&t=117

Here are the Events related to Workflow Tasks. As you can see, their names follow the same pattern you saw with Activity Tasks.

# Sticky Execution

Workers cache the state of the Workflow methods they execute.

- To make this caching more effective, Temporal employs a performance optimization known as `"Sticky Execution"` which directs Workflow Tasks to the same Worker that accepted them earlier in the same Workflow Execution.

## How Sticky Execution Works

- Once Workflow Execution begins, the Temporal Service schedules a Workflow Task and puts it into a Task Queue with the name you specify.
  - Any Worker that polls that Task Queue is eligible to accept the Task and begin executing the Workflow.
- The Worker that picks up this Workflow Task will continue polling the original Task Queue, but will also begin polling an additional Task Queue, which the Temporal Service shares exclusively with that specific Worker (this queue, which has an automatically-generated name, is known as a `Sticky Queue`)
- As the Workflow Execution progresses, the Temporal Service schedules additional Workflow Tasks into this Worker-specific Sticky Queue.
- If this Worker fails to start a Workflow Task in the sticky queue shortly after it is scheduled, within five seconds by default, the Temporal Service disables stickiness for that Workflow Execution and reschedules the Workflow Task in the original queue, allowing any Worker to pick it up and continue the Workflow Execution.

Note: Sticky Execution only applies to Workflow Tasks. Since Event History is associated with a Workflow, the concept of Sticky Execution is not relevant to Activity Tasks.

# History Replay: How Temporal Provides Durable Execution
