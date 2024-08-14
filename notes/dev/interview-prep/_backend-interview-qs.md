# Table of Contents

- [Table of Contents](#table-of-contents)
- [Design Patterns](#design-patterns)
  - [Avoiding Global + Static Objects](#avoiding-global--static-objects)

# Design Patterns

## Avoiding Global + Static Objects

> Why are global and static objects evil/to be avoided? Can you show it with a code example in Java?

The terms "global" and "static" objects often carry a negative connotation in software development because they can introduce several issues that make the codebase difficult to maintain, test, and understand

Here are some of the main reasons why they are considered "evil":

- Global State and Side Effects
  - Global objects can be modified from anywhere in the code, making it difficult to track changes and debug issues
- Tight Coupling
  - Global and static objects create tight coupling between classes, making the code harder to refactor and maintain
- Hidden Dependencies
  - Global and static objects introduce hidden dependencies, as it's not clear from a class's interface what dependencies it relies on
- Concurrency Issues
  - Global and static objects can lead to concurrency problems in multi-threaded applications since global and static state can be accessed by multiple threads simultaneously
- Testing Difficulties:
  - Global and static objects make unit testing more difficult because it becomes hard to isolate classes for testing purposes
  - Mocking or stubbing static methods and global state requires special frameworks or techniques
- Unintended Side Effects
  - Since global and static objects maintain state across different parts of the application, changes in one part of the code can have unintended side effects in other parts

**Example: Using Globals + Static**

```java
// Example: Using Globals + Static
class GlobalConfig {
  public static String configValue = "Default Config";
}

class Service {
  public static void performAction() {
    System.out.println("Performing action with config: " + GlobalConfig.configValue);
  }
}

public class Main {
  public static void main(String[] args) {
    Service.performAction(); // Outputs: Performing action with config: Default Config
    // Change the global state
    GlobalConfig.configValue = "New Config";
    Service.performAction(); // Outputs: Performing action with config: New Config
  }
}
```

- Problems with above code example
  - _Global State and Side Effects_: The `GlobalConfig.configValue` is accessible and modifiable from anywhere, leading to potential unexpected changes
  - _Tight Coupling_: The `Service` class is tightly coupled to `GlobalConfig`, making it less flexible
  - _Concurrency Issues_: If multiple threads modify `GlobalConfig.configValue`, it can lead to unpredictable behavior
  - _Testing Difficulties_: Unit tests for `Service` would have to reset `GlobalConfig.configValue` to a known state before each test, making tests harder to write and maintain

**Example: Using Dependency Injection**

```java
class Config {
  private String configValue;

  public Config(String configValue) {
    this.configValue = configValue;
  }

  public String getConfigValue() {
    return configValue;
  }

  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }
}

class Service {
  private Config config;

  public Service(Config config) {
    this.config = config;
  }

  public void performAction() {
    System.out.println("Performing action with config: " + config.getConfigValue());
  }
}

public class Main {
  public static void main(String[] args) {
    Config config = new Config("Default Config");
    Service service = new Service(config);
    service.performAction(); // Outputs: Performing action with config: Default Config

    // Change the configuration through dependency injection
    config.setConfigValue("updated");
    service.performAction();

    // Change the configuration through creating a new instance
    Config newConfig = new Config("New Config");
    Service newService = new Service(newConfig);
    newService.performAction(); // Outputs: Performing action with config: New Config
  }
}
```

- Advantages/Benefits improved version using "dependency injection"
  - _Loose Coupling_: `Service` is loosely coupled with `Config`. You can easily change the configuration without affecting the service's implementation
  - _Explicit Dependencies_: The dependency on `Config` is explicit in the constructor of `Service`
  - _Controlled Side Effects_: Changes to `Config` affect only the instances of `Service` that use that particular configuration, reducing the risk of unintended side effects
  - _Encapsulation and Independence_: The `Config` object is encapsulated and passed to the `Service`, which is no longer tightly coupled to a global state
  - _Enhanced/Easier Testability_:
    - You can easily create different `Config` objects for testing different scenarios without relying on global state
    - You can easily test `Service` with different configurations by passing mock or stub `Config` objects
  - _Thread Safety_: Each thread can have its own instance of the `Config` object, avoiding concurrency issues with shared state
  - _Maintainability_: Changes to the configuration logic are localized to the `Config` class, making the codebase easier to manage and extend

By using dependency injection and instance-based configuration, the code becomes more modular, testable, and maintainable
